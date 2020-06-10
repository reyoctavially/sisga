package org.diskominfo.sisga.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import org.diskominfo.sisga.R;
import org.diskominfo.sisga.facerecognition.FaceInActivity;
import org.diskominfo.sisga.facerecognition.FaceOutActivity;

public class AbsenKeluarActivity extends AppCompatActivity {
    Button btnSimpan;
    ImageView arrow;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_keluar);

        arrow = findViewById(R.id.iv_camera_keluar);
        btnSimpan = findViewById(R.id.btn_simpan_keluar);
        btnSimpan.setVisibility(View.GONE);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AbsenKeluarActivity.this, FaceOutActivity.class);
                startActivity(intent);
            }
        });
    }
}
