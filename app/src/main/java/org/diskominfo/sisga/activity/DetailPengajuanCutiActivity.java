package org.diskominfo.sisga.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.model.Pengajuancuti;

public class DetailPengajuanCutiActivity extends AppCompatActivity {

    public static final String DATA_CUTI = "data_cuti";
    private TextView kode, alasan, pengajuan, mulai, selesai, ket, status;
    private Pengajuancuti pengajuancuti;
    private String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengajuan_cuti);
        kode = findViewById(R.id.detail_kode_cuti);
        alasan = findViewById(R.id.tv_detail_alasan_cuti);
        pengajuan = findViewById(R.id.tv_detail_pengajuan_cuti);
        mulai = findViewById(R.id.tv_detail_mulai_cuti);
        selesai = findViewById(R.id.tv_detail_selesai_cuti);
        ket = findViewById(R.id.tv_detail_ket_cuti);
        status = findViewById(R.id.tv_stat_cuti);

        pengajuancuti = getIntent().getParcelableExtra(DATA_CUTI);
        setTitle(pengajuancuti.getKode_pengajuan_cuti());
        kode.setText("Kode pengajuan cuti : " + pengajuancuti.getKode_pengajuan_cuti());
        alasan.setText(pengajuancuti.getAlasan_pengajuan_cuti());
        pengajuan.setText(pengajuancuti.getTgl_pengajuan_cuti());
        mulai.setText(pengajuancuti.getTgl_mulai_cuti());
        selesai.setText(pengajuancuti.getTgl_selesai_cuti());
        ket.setText(pengajuancuti.getKet_pengajuan_cuti());
        status.setText("Status pengajuan : " + pengajuancuti.getStatus_pengajuan_cuti());

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
