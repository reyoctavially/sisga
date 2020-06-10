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
import org.diskominfo.sisga.adapter.AdapterPengajuanSurat;
import org.diskominfo.sisga.model.Pengajuansurat;
import org.diskominfo.sisga.model.ResponsePengajuanSuratDetail;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPengajuanSppdActivity extends AppCompatActivity {

    RecyclerView rvSurat;
    ProgressDialog loading;

    Context mContext;
    List<Pengajuansurat> pengajuansurats = new ArrayList<>();
    AdapterPengajuanSurat adapterPengajuanSurat;
    BaseApiServices mApiService;
    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pengajuan_sppd);
        rvSurat = findViewById(R.id.list_detail_sppd);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();
        adapterPengajuanSurat = new AdapterPengajuanSurat(pengajuansurats, this);
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
        mApiService.getSuratDetail(kode_pegawai).enqueue(new Callback<ResponsePengajuanSuratDetail>() {
            @Override
            public void onResponse(Call<ResponsePengajuanSuratDetail> call, Response<ResponsePengajuanSuratDetail> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<Pengajuansurat> pengajuansurats = response.body().getPengajuansurat();

                    rvSurat.setAdapter(new AdapterPengajuanSurat(pengajuansurats, mContext));
                    adapterPengajuanSurat.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data sppd", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePengajuanSuratDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Anda belum mengajukan surat", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(DataPengajuanSppdActivity.this, PengajuanSppdActivity.class);
                startActivity(intent);
                break;
        }
    }
}
