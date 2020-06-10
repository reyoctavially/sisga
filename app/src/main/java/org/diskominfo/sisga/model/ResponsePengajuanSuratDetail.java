package org.diskominfo.sisga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePengajuanSuratDetail {
    @SerializedName("pengajuansurat")
    private List<Pengajuansurat> pengajuansurat;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public List<Pengajuansurat> getPengajuansurat(){
        return pengajuansurat;
    }

    public void setPengajuansurat(List<Pengajuansurat> pengajuansurat) {
        this.pengajuansurat = pengajuansurat;
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
        return "ResponsePengajuanSuratDetail{" +
                "pengajuansurat/{kode_pegawai} = '" + pengajuansurat + '\'' +
                ", error = '" + error + '\'' +
                ", message = '" + message + '\'' +
                "}";
    }
}
