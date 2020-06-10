package org.diskominfo.sisga.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.model.Cuti;
import org.diskominfo.sisga.model.Surat;

public class DetailSuratActivity extends AppCompatActivity {

    public static final String DATA_SURAT = "data_surat";
    private TextView nomor, jenis, saku, mulai, selesai, status;
    private Surat surat;
    private String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat);
        nomor = findViewById(R.id.detailnomorsurat);
        jenis = findViewById(R.id.tvdetailjenissurat);
        saku = findViewById(R.id.tvdetailuangsaku);
        mulai = findViewById(R.id.tvdetailmulaisppd);
        selesai = findViewById(R.id.tvdetailselesaisppd);
        status = findViewById(R.id.tvstatsppd);

        surat = getIntent().getParcelableExtra(DATA_SURAT);
        setTitle(surat.getNo_surat());
        nomor.setText("Nomor surat : " + surat.getNo_surat());
        jenis.setText(surat.getJenis_surat());
        saku.setText("Rp. " + surat.getUang_saku());
        mulai.setText(surat.getTglmulaisppd());
        selesai.setText(surat.getTglselesaisppd());
        status.setText("Status surat : " + surat.getStatussurat());

        stat = status.getText().toString();
        if (stat.equals("Status surat : Berlaku")){
            status.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (stat.equals("Status surat : Selesai")) {
            status.setBackgroundResource(R.drawable.bg_radius_red);
        }
    }
}
