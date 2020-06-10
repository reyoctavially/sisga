package org.diskominfo.sisga.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_SISGA_APP = "spSisgaApp";

    public static final String SP_KODE = "spKode";
    public static final String SP_NAMA = "spNama";
    public static final String SP_JABATAN = "spJabatan";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_TELP = "spTelp";
    public static final String SP_REKENING = "spRekening";
    public static final String SP_JALAN = "spJalan";
    public static final String SP_RUMAH = "spRumah";
    public static final String SP_RTRW = "spRtRw";
    public static final String SP_KEC = "spKec";
    public static final String SP_KOTA = "spKota";
    public static final String SP_POS = "spPos";
    public static final String SP_USERNAME = "spUsername";
    public static final String SP_PASSWORD = "spPassword";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context) {
        sp = context.getSharedPreferences(SP_SISGA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPKode() {
        return sp.getString(SP_KODE, "");
    }

    public String getSPNama() {
        return sp.getString(SP_NAMA, "");
    }

    public String getSPJabatan() {
        return sp.getString(SP_JABATAN, "");
    }

    public String getSPEmail() {
        return sp.getString(SP_EMAIL, "");
    }

    public String getSPTelp() {
        return sp.getString(SP_TELP, "");
    }

    public String getSPRekening() {
        return sp.getString(SP_REKENING, "");
    }

    public String getSPJalan() {
        return sp.getString(SP_JALAN, "");
    }

    public String getSPRumah() {
        return sp.getString(SP_RUMAH, "");
    }

    public String getSPRtRw() {
        return sp.getString(SP_RTRW, "");
    }

    public String getSPKec() {
        return sp.getString(SP_KEC, "");
    }

    public String getSPKota() {
        return sp.getString(SP_KOTA, "");
    }

    public String getSPPos() {
        return sp.getString(SP_POS, "");
    }

    public String getSPUsername() {
        return sp.getString(SP_USERNAME, "");
    }

    public String getSPPassword() {
        return sp.getString(SP_PASSWORD, "");
    }

    public Boolean getSPSudahLogin() {
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
