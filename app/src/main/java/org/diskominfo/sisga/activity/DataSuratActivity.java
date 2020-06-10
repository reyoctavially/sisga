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
import org.diskominfo.sisga.adapter.AdapterSurat;
import org.diskominfo.sisga.model.Cuti;
import org.diskominfo.sisga.model.ResponseCutiDetail;
import org.diskominfo.sisga.model.ResponseSuratDetail;
import org.diskominfo.sisga.model.Surat;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSuratActivity extends AppCompatActivity {

    RecyclerView rvSurat;
    ProgressDialog loading;

    Context mContext;
    List<Surat> surats = new ArrayList<>();
    AdapterSurat adapterSurat;
    BaseApiServices mApiService;
    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_surat);
        rvSurat = findViewById(R.id.listdetailsppd);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();
        adapterSurat = new AdapterSurat(surats, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this,
                manager.getOrientation());
        rvSurat.addItemDecoration(divider);
        rvSurat.setLayoutManager(mLayoutManager);
        rvSurat.setItemAnimator(new DefaultItemAnimator());

        getResultSurat(kode_pegawai);
    }

    private void getResultSurat(String kode_pegawai){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);
        mApiService.getSurat(kode_pegawai).enqueue(new Callback<ResponseSuratDetail>() {
            @Override
            public void onResponse(Call<ResponseSuratDetail> call, Response<ResponseSuratDetail> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<Surat> surats = response.body().getSurat();

                    rvSurat.setAdapter(new AdapterSurat(surats, mContext));
                    adapterSurat.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data cuti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSuratDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Anda belum mengajukan surat", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
