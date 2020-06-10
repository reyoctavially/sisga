package org.diskominfo.sisga.model;

public class PengajuanSppdModel {
    String judul, desc;

    public PengajuanSppdModel(String judul, String desc) {
        this.judul = judul;
        this.desc = desc;
    }

    public String getJudul() {
        return judul;
    }

    public String getDesc() {
        return desc;
    }
}
