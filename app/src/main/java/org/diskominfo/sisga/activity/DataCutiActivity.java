package org.diskominfo.sisga.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.adapter.AdapterCuti;
import org.diskominfo.sisga.adapter.AdapterPengajuanCuti;
import org.diskominfo.sisga.model.Cuti;
import org.diskominfo.sisga.model.Pengajuancuti;
import org.diskominfo.sisga.model.ResponseCutiDetail;
import org.diskominfo.sisga.model.ResponsePengajuanCutiDetail;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataCutiActivity extends AppCompatActivity {

    RecyclerView rvCuti;
    ProgressDialog loading;

    Context mContext;
    List<Cuti> cutis = new ArrayList<>();
    AdapterCuti adapterCuti;
    BaseApiServices mApiService;
    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cuti);
        rvCuti = findViewById(R.id.listdetailcuti);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();
        adapterCuti = new AdapterCuti(cutis, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this,
                manager.getOrientation());
        rvCuti.addItemDecoration(divider);
        rvCuti.setLayoutManager(mLayoutManager);
        rvCuti.setItemAnimator(new DefaultItemAnimator());

        getResultCuti(kode_pegawai);
    }

    private void getResultCuti(String kode_pegawai){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);
        mApiService.getCuti(kode_pegawai).enqueue(new Callback<ResponseCutiDetail>() {
            @Override
            public void onResponse(Call<ResponseCutiDetail> call, Response<ResponseCutiDetail> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<Cuti> cutis = response.body().getCuti();

                    rvCuti.setAdapter(new AdapterCuti(cutis, mContext));
                    adapterCuti.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data cuti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCutiDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Anda belum mengajukan cuti", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
