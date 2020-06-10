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
import org.diskominfo.sisga.adapter.AdapterAbsen;
import org.diskominfo.sisga.adapter.AdapterPengajuanCuti;
import org.diskominfo.sisga.model.Absensi;
import org.diskominfo.sisga.model.Pengajuancuti;
import org.diskominfo.sisga.model.ResponseAbsenDetail;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataAbsenActivity extends AppCompatActivity {

    RecyclerView rvAbsen;
    ProgressDialog loading;

    Context mContext;
    List<Absensi> absensis = new ArrayList<>();
    AdapterAbsen adapterAbsen;
    BaseApiServices mApiService;
    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_absen);
        rvAbsen = findViewById(R.id.list_detail_absen);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();
        adapterAbsen = new AdapterAbsen(absensis, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this,
                manager.getOrientation());
        rvAbsen.addItemDecoration(divider);
        rvAbsen.setLayoutManager(mLayoutManager);
        rvAbsen.setItemAnimator(new DefaultItemAnimator());

        getResultAbsen(kode_pegawai);
    }

    private void getResultAbsen(String kode_pegawai){
        loading = ProgressDialog.show(this, null, "Harap Tunggu...", true, false);
        mApiService.getAbsenDetail(kode_pegawai).enqueue(new Callback<ResponseAbsenDetail>() {
            @Override
            public void onResponse(Call<ResponseAbsenDetail> call, Response<ResponseAbsenDetail> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<Absensi> absensis = response.body().getAbsensi();

                    rvAbsen.setAdapter(new AdapterAbsen(absensis, mContext));
                    adapterAbsen.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data cuti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAbsenDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Anda belum mengajukan cuti", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
