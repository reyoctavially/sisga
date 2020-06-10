package org.diskominfo.sisga.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.adapter.AdapterListDashboardCuti;
import org.diskominfo.sisga.interfaces.OnClickListener;
import org.diskominfo.sisga.model.PengajuanCutiModel;
import org.diskominfo.sisga.util.SharedPrefManager;

import java.util.ArrayList;

public class DashboardCutiActivity extends AppCompatActivity {
    RecyclerView listCuti;
    SharedPrefManager sharedPrefManager;
    private String kode_pegawai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_cuti);
        listCuti = findViewById(R.id.list_cuti);

        sharedPrefManager = new SharedPrefManager(this);
        kode_pegawai = sharedPrefManager.getSPKode();

        LinearLayoutManager in= new LinearLayoutManager(DashboardCutiActivity.this);

        final ArrayList<PengajuanCutiModel> pengajuanCutiModels = new ArrayList<>();
        pengajuanCutiModels.add(new PengajuanCutiModel("Pengajuan Cuti Pegawai", "Ajukan cuti dan riwayat pengajuan cuti"));
        pengajuanCutiModels.add(new PengajuanCutiModel("Jadwal Cuti Pegawai", "Lihat jadwal cuti saya"));

        AdapterListDashboardCuti adapter = new AdapterListDashboardCuti(pengajuanCutiModels);

        adapter.setListener(new OnClickListener() {
            @Override
            public void onclick(int position) {
                pengajuanCutiModels.get(position);
                switch (position){
                    case 0:
                        Intent intent = new Intent(DashboardCutiActivity.this, DataPengajuanCutiActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(DashboardCutiActivity.this, DataCutiActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

        listCuti.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        listCuti.setLayoutManager(in);
        listCuti.setAdapter(adapter);
    }
}
