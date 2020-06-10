package org.diskominfo.sisga.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pengajuansurat implements Parcelable {
    @SerializedName("kode_pengajuan_surat")
    private String kode_pengajuan_surat;

    @SerializedName("tujuan_pengajuan_surat")
    private String tujuan_pengajuan_surat;

    @SerializedName("tgl_pengajuan_surat")
    private String tgl_pengajuan_surat;

    @SerializedName("tgl_mulai_sppd")
    private String tgl_mulai_sppd;

    @SerializedName("tgl_selesai_sppd")
    private String tgl_selesai_sppd;

    @SerializedName("status_pengajuan_surat")
    private String status_pengajuan_surat;

    @SerializedName("ket_pengajuan_sppd")
    private String ket_pengajuan_sppd;

    protected Pengajuansurat(Parcel in) {
        kode_pengajuan_surat = in.readString();
        tujuan_pengajuan_surat = in.readString();
        tgl_pengajuan_surat = in.readString();
        tgl_mulai_sppd = in.readString();
        tgl_selesai_sppd = in.readString();
        status_pengajuan_surat = in.readString();
        ket_pengajuan_sppd = in.readString();
    }

    public static final Creator<Pengajuansurat> CREATOR = new Creator<Pengajuansurat>() {
        @Override
        public Pengajuansurat createFromParcel(Parcel in) {
            return new Pengajuansurat(in);
        }

        @Override
        public Pengajuansurat[] newArray(int size) {
            return new Pengajuansurat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kode_pengajuan_surat);
        parcel.writeString(tujuan_pengajuan_surat);
        parcel.writeString(tgl_pengajuan_surat);
        parcel.writeString(tgl_mulai_sppd);
        parcel.writeString(tgl_selesai_sppd);
        parcel.writeString(status_pengajuan_surat);
        parcel.writeString(ket_pengajuan_sppd);
    }

    public String getKode_pengajuan_surat() {
        return kode_pengajuan_surat;
    }

    public String getTujuan_pengajuan_surat() {
        return tujuan_pengajuan_surat;
    }

    public String getTgl_pengajuan_surat() {
        return tgl_pengajuan_surat;
    }

    public String getTgl_mulai_sppd() {
        return tgl_mulai_sppd;
    }

    public String getTgl_selesai_sppd() {
        return tgl_selesai_sppd;
    }

    public String getstatus_pengajuan_surat() {
        return status_pengajuan_surat;
    }

    public String getKet_pengajuan_sppd() {
        return ket_pengajuan_sppd;
    }

    @Override
    public String toString() {
        return "Pengajuansurat{" +
                "kode_pengajuan_surat='" + kode_pengajuan_surat + '\'' +
                ", tujuan_pengajuan_surat='" + tujuan_pengajuan_surat + '\'' +
                ", tgl_pengajuan_surat='" + tgl_pengajuan_surat + '\'' +
                ", tgl_mulai_sppd='" + tgl_mulai_sppd + '\'' +
                ", tgl_selesai_sppd='" + tgl_selesai_sppd + '\'' +
                ", status_pengajuan_surat='" + status_pengajuan_surat + '\'' +
                ", ket_pengajuan_sppd='" + ket_pengajuan_sppd + '\'' +
                '}';
    }
}
