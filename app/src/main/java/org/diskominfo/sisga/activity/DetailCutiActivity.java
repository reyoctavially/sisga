package org.diskominfo.sisga.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.model.Cuti;

public class DetailCutiActivity extends AppCompatActivity {
    
    public static final String DATA_CUTI = "data_cuti";
    private TextView kode, jenis, honor, mulai, selesai, status;
    private Cuti cuti;
    private String stat;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cuti);
        kode = findViewById(R.id.detailkodecuti);
        jenis = findViewById(R.id.tvdetailjeniscuti);
        honor = findViewById(R.id.tvdetailhonor);
        mulai = findViewById(R.id.tvdetailmulaicuti);
        selesai = findViewById(R.id.tvdetailselesaicuti);
        status = findViewById(R.id.tvstatcuti);

        cuti = getIntent().getParcelableExtra(DATA_CUTI);
        setTitle(cuti.getKode_cuti());
        kode.setText("Kode pengajuan cuti : " + cuti.getKode_cuti());
        jenis.setText(cuti.getJenis_cuti());
        honor.setText("Rp. " + cuti.getPemotongan_honor());
        mulai.setText(cuti.getTglmulaicuti());
        selesai.setText(cuti.getTglselesaicuti());
        status.setText("Status cuti : " + cuti.getStatuscuti());

        stat = status.getText().toString();
        if (stat.equals("Status cuti : Berlaku")){
            status.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (stat.equals("Status cuti : Selesai")) {
            status.setBackgroundResource(R.drawable.bg_radius_red);
        }
    }
}
