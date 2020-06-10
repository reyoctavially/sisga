package org.diskominfo.sisga.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.facerecognition.FaceInActivity;
import org.diskominfo.sisga.facerecognition.FaceRecordActivity;
import org.diskominfo.sisga.util.SharedPrefManager;

public class AccountActivity extends AppCompatActivity {
    private SharedPrefManager sharedPrefManager;
    private TextView kode, nama, jabatan, email, telp, rekening, alamat, username, password;
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        kode = findViewById(R.id.tv_kode_pegawai);
        nama = findViewById(R.id.tv_nama_pegawai);
        jabatan = findViewById(R.id.tv_jabatan_pegawai);
        email = findViewById(R.id.tv_email_pegawai);
        telp = findViewById(R.id.tv_telp_pegawai);
        rekening = findViewById(R.id.tv_norek_pegawai);
        alamat = findViewById(R.id.tv_alamat_pegawai);
        username = findViewById(R.id.tv_username_pegawai);
        password = findViewById(R.id.tv_pass_pegawai);
        logout = findViewById(R.id.btnLogout);
        sharedPrefManager = new SharedPrefManager(this);

        kode.setText(sharedPrefManager.getSPKode());
        nama.setText(sharedPrefManager.getSPNama());
        jabatan.setText(sharedPrefManager.getSPJabatan());
        email.setText(sharedPrefManager.getSPEmail());
        telp.setText(sharedPrefManager.getSPTelp());
        rekening.setText(sharedPrefManager.getSPRekening());
        alamat.setText(sharedPrefManager.getSPJalan() + ", No." + sharedPrefManager.getSPRumah() + ", " + sharedPrefManager.getSPRtRw() + "\n" +
                sharedPrefManager.getSPKec() + ", " + sharedPrefManager.getSPKota() + ", " + sharedPrefManager.getSPPos());
        username.setText(sharedPrefManager.getSPUsername());
        password.setText(sharedPrefManager.getSPPassword());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(AccountActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                AccountActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_face_record, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.action_record:
                Intent intent = new Intent(AccountActivity.this, FaceRecordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
