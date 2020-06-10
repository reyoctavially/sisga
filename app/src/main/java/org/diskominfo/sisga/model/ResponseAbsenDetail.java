package org.diskominfo.sisga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAbsenDetail {
    @SerializedName("absen")
    private List<Absensi> absensi;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public List<Absensi> getAbsensi(){
        return absensi;
    }

    public void setAbsensi(List<Absensi> absensi){
        this.absensi = absensi;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseAbsenCutiDetail{" +
                "absen/{kode_pegawai} = '" + absensi + '\'' +
                ", error = '" + error + '\'' +
                ", message = '" + message + '\'' +
                "}";
    }
}
