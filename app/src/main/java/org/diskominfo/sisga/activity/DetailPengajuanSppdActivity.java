package org.diskominfo.sisga.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.model.Pengajuansurat;

public class DetailPengajuanSppdActivity extends AppCompatActivity {

    public static final String DATA_SPPD = "data_surat";
    private TextView kode, tujuan, pengajuan, mulai, selesai, ket, status;
    private Pengajuansurat pengajuansurat;
    private String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengajuan_sppd);
        kode = findViewById(R.id.detail_kode_sppd);
        tujuan = findViewById(R.id.tv_detail_tujuan_sppd);
        pengajuan = findViewById(R.id.tv_detail_pengajuan_sppd);
        mulai = findViewById(R.id.tv_detail_mulai_sppd);
        selesai = findViewById(R.id.tv_detail_selesai_sppd);
        ket = findViewById(R.id.tv_detail_ket_sppd);
        status = findViewById(R.id.tv_stat_sppd);

        pengajuansurat = getIntent().getParcelableExtra(DATA_SPPD);
        setTitle(pengajuansurat.getKode_pengajuan_surat());
        kode.setText("Kode pengajuan sppd : " + pengajuansurat.getKode_pengajuan_surat());
        tujuan.setText(pengajuansurat.getTujuan_pengajuan_surat());
        pengajuan.setText(pengajuansurat.getTgl_pengajuan_surat());
        mulai.setText(pengajuansurat.getTgl_mulai_sppd());
        selesai.setText(pengajuansurat.getTgl_selesai_sppd());
        ket.setText(pengajuansurat.getKet_pengajuan_sppd());
        status.setText("Status pengajuan : " + pengajuansurat.getstatus_pengajuan_surat());

        stat = status.getText().toString();
        if (stat.equals("Status pengajuan : Menunggu")){
            status.setBackgroundResource(R.drawable.bg_radius_coral);
        } else if (stat.equals("Status pengajuan : Disetujui")) {
            status.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (stat.equals("Status pengajuan : Ditolak")){
            status.setBackgroundResource(R.drawable.bg_radius_red);
        }
    }
}
