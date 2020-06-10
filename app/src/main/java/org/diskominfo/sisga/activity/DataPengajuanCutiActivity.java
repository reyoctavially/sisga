package org.diskominfo.sisga.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.adapter.AdapterPengajuanCuti;
import org.diskominfo.sisga.model.Pengajuancuti;
import org.diskominfo.sisga.model.ResponsePengajuanCutiDetail;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPengajuanCutiActivity extends AppCompatActivity {
    RecyclerView rvCuti;
    ProgressDialog loading;

    Context mContext;
    List<Pengajuancuti> pengajuancutis = new ArrayList<>();
    AdapterPengajuanCuti adapterPengajuanCuti;
    BaseApiServices mApiService;
    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pengajuan_cuti);
        rvCuti = findViewById(R.id.list_detail_cuti);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();
        adapterPengajuanCuti = new AdapterPengajuanCuti(pengajuancutis, this);
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
        mApiService.getCutiDetail(kode_pegawai).enqueue(new Callback<ResponsePengajuanCutiDetail>() {
            @Override
            public void onResponse(Call<ResponsePengajuanCutiDetail> call, Response<ResponsePengajuanCutiDetail> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<Pengajuancuti> pengajuancutis = response.body().getPengajuancuti();

                    rvCuti.setAdapter(new AdapterPengajuanCuti(pengajuancutis, mContext));
                    adapterPengajuanCuti.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data cuti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePengajuanCutiDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Anda belum mengajukan cuti", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pengajuan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.action_add:
                Intent intent = new Intent(DataPengajuanCutiActivity.this, PengajuanCutiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
