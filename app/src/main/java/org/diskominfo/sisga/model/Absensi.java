package org.diskominfo.sisga.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Absensi implements Parcelable {
    @SerializedName("kode_absensi")
    private String kode_absensi;

    @SerializedName("tanggal_absen")
    private String tanggal_absen;

    @SerializedName("jam_masuk")
    private String jam_masuk;

    @SerializedName("jam_keluar")
    private String jam_keluar;

    protected Absensi(Parcel in) {
        kode_absensi = in.readString();
        tanggal_absen = in.readString();
        jam_masuk = in.readString();
        jam_keluar = in.readString();
    }

    public static final Creator<Absensi> CREATOR = new Creator<Absensi>() {
        @Override
        public Absensi createFromParcel(Parcel in) {
            return new Absensi(in);
        }

        @Override
        public Absensi[] newArray(int size) {
            return new Absensi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kode_absensi);
        parcel.writeString(tanggal_absen);
        parcel.writeString(jam_masuk);
        parcel.writeString(jam_keluar);
    }

    public String getKode_absensi() {
        return kode_absensi;
    }

    public String getTanggal_absen() {
        return tanggal_absen;
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    @Override
    public String toString() {
        return "Absensi{" +
                "kode_absensi='" + kode_absensi + '\'' +
                ", tanggal_absen='" + tanggal_absen + '\'' +
                ", jam_masuk='" + jam_masuk + '\'' +
                ", jam_keluar='" + jam_keluar + '\'' +
                '}';
    }
}
