package org.diskominfo.sisga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSuratDetail {
    @SerializedName("surat")
    private List<Surat> surat;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public List<Surat> getSurat(){
        return surat;
    }

    public void setSurat(List<Surat> surat) {
        this.surat = surat;
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
        return "ResponseSuratDetail{" +
                "surat/{kode_pegawai} = '" + surat + '\'' +
                ", error = '" + error + '\'' +
                ", message = '" + message + '\'' +
                "}";
    }
}
