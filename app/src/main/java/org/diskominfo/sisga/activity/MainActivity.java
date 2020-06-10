package org.diskominfo.sisga.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.facerecognition.FaceInActivity;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView namaPegawai;
    ImageView absenMasuk, absenKeluar, cuti, sppd, rekapAbsensi;

    SharedPrefManager sharedPrefManager;
    String kode_pegawai;

    Context mContext;
    ProgressDialog loading;
    BaseApiServices mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.ic_business_center);
        menu.setDisplayUseLogoEnabled(true);
        sharedPrefManager = new SharedPrefManager(MainActivity.this);
        mApiService = UtilsApi.getAPIService();
        mContext = this;

        namaPegawai = findViewById(R.id.tv_nama_pegawai);
        namaPegawai.setText(sharedPrefManager.getSPNama());
        absenMasuk = findViewById(R.id.iv_absen_masuk);
        absenKeluar = findViewById(R.id.iv_absen_keluar);
        cuti = findViewById(R.id.iv_cuti);
        sppd = findViewById(R.id.iv_sppd);
        rekapAbsensi = findViewById(R.id.iv_rekap_absensi);
        kode_pegawai = sharedPrefManager.getSPKode();

        absenMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                cekAbsenMasuk();
            }
        });

        absenKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                cekAbsenKeluar();
            }
        });

        cuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DashboardCutiActivity.class);
                startActivity(intent);
            }
        });

        sppd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DashboardSppdActivity.class);
                startActivity(intent);
            }
        });

        rekapAbsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataAbsenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void cekAbsenKeluar(){
        String kode_pegawai = sharedPrefManager.getSPKode();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggal = new Date();
        String jam_keluar = "-";
        String tanggal_absen = dateFormat.format(tanggal);
        mApiService.cekAbsenKeluarRequest(tanggal_absen,
                kode_pegawai, jam_keluar)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "Silahkan untuk melakukan absen", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, AbsenKeluarActivity.class);
                                    startActivity(intent);
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void cekAbsenMasuk(){
        String kode_pegawai = sharedPrefManager.getSPKode();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggal = new Date();
        String tanggal_absen = dateFormat.format(tanggal);
        mApiService.cekAbsenMasukRequest(tanggal_absen,
                kode_pegawai)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "Silahkan untuk melakukan absen", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, AbsenMasukActivity.class);
                                    startActivity(intent);
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sisga, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.action_account:
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                Intent intent3 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
