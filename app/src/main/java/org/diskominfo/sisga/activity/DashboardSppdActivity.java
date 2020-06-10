package org.diskominfo.sisga.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.adapter.AdapterListDashboardSppd;
import org.diskominfo.sisga.interfaces.OnClickListener;
import org.diskominfo.sisga.model.PengajuanSppdModel;
import org.diskominfo.sisga.util.SharedPrefManager;

import java.util.ArrayList;

public class DashboardSppdActivity extends AppCompatActivity {
    RecyclerView listSppd;
    SharedPrefManager sharedPrefManager;
    private String kode_pegawai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_sppd);
        listSppd = findViewById(R.id.list_sppd);

        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();

        LinearLayoutManager in= new LinearLayoutManager(DashboardSppdActivity.this);

        final ArrayList<PengajuanSppdModel> pengajuanSppdModels = new ArrayList<>();
        pengajuanSppdModels.add(new PengajuanSppdModel("Pengajuan SPPD", "Ajukan sppd dan riwayat pengajuan sppd"));
        pengajuanSppdModels.add(new PengajuanSppdModel("Jadwal Perjalanan Dinas", "Lihat jadwal perjalanan dinas saya"));

        AdapterListDashboardSppd adapter = new AdapterListDashboardSppd(pengajuanSppdModels);

        adapter.setListener(new OnClickListener() {
            @Override
            public void onclick(int position) {
                pengajuanSppdModels.get(position);
                switch (position){
                    case 0:
                        Intent intent = new Intent(DashboardSppdActivity.this, DataPengajuanSppdActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(DashboardSppdActivity.this, DataSuratActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

        listSppd.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        listSppd.setLayoutManager(in);
        listSppd.setAdapter(adapter);
    }
}
