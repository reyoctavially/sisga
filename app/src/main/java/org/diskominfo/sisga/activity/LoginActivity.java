package org.diskominfo.sisga.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.util.SharedPrefManager;
import org.diskominfo.sisga.util.api.BaseApiServices;
import org.diskominfo.sisga.util.api.UtilsApi;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUsername, etPassword;
    ProgressDialog loading;
    BaseApiServices mApiService;

    SharedPrefManager sharedPrefManager;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.ic_business_center);
        menu.setDisplayUseLogoEnabled(true);

        btnLogin = findViewById(R.id.btn_login);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);

        // Code berikut berfungsi untuk mengecek session, Jika session true ( sudah login )
        // maka langsung memulai MainActivity.
        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });

    }

    private void requestLogin(){
        mApiService.loginRequest(etUsername.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                    String kode = jsonRESULTS.getJSONObject("user").getString("kode_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_KODE, kode);
                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
                                    String jabatan = jsonRESULTS.getJSONObject("user").getString("jabatan_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_JABATAN, jabatan);
                                    String email = jsonRESULTS.getJSONObject("user").getString("email_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_EMAIL, email);
                                    String telp = jsonRESULTS.getJSONObject("user").getString("telp_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_TELP, telp);
                                    String rekening = jsonRESULTS.getJSONObject("user").getString("no_rekening_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_REKENING, rekening);
                                    String jalan = jsonRESULTS.getJSONObject("user").getString("jalan_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_JALAN, jalan);
                                    String rumah = jsonRESULTS.getJSONObject("user").getString("no_rumah_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_RUMAH, rumah);
                                    String rtrw = jsonRESULTS.getJSONObject("user").getString("rt_rw_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_RTRW, rtrw);
                                    String kec = jsonRESULTS.getJSONObject("user").getString("kec_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_KEC, kec);
                                    String kota = jsonRESULTS.getJSONObject("user").getString("kota_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_KOTA, kota);
                                    String pos = jsonRESULTS.getJSONObject("user").getString("kode_pos_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_POS, pos);
                                    String username = jsonRESULTS.getJSONObject("user").getString("username_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, username);
                                    String password = jsonRESULTS.getJSONObject("user").getString("pass_pegawai");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PASSWORD, password);
                                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                                    startActivity(new Intent(mContext, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                } else {
                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }

}
