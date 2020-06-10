package org.diskominfo.sisga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCutiDetail {
    @SerializedName("cuti")
    private List<Cuti> cuti;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public List<Cuti> getCuti(){
        return cuti;
    }

    public void setCuti(List<Cuti> cuti){
        this.cuti = cuti;
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
        return "ResponseCutiDetail{" +
                "cuti/{kode_pegawai} = '" + cuti + '\'' +
                ", error = '" + error + '\'' +
                ", message = '" + message + '\'' +
                "}";
    }
}
