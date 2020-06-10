package org.diskominfo.sisga.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Surat implements Parcelable {
    @SerializedName("no_surat")
    private String no_surat;

    @SerializedName("jenis_surat")
    private String jenis_surat;

    @SerializedName("uang_saku")
    private String uang_saku;

    @SerializedName("tglmulaisppd")
    private String tglmulaisppd;

    @SerializedName("tglselesaisppd")
    private String tglselesaisppd;

    @SerializedName("statussurat")
    private String statussurat;

    protected Surat(Parcel in) {
        no_surat = in.readString();
        jenis_surat = in.readString();
        uang_saku = in.readString();
        tglmulaisppd = in.readString();
        tglselesaisppd = in.readString();
        statussurat = in.readString();
    }

    public static final Creator<Surat> CREATOR = new Creator<Surat>() {
        @Override
        public Surat createFromParcel(Parcel in) {
            return new Surat(in);
        }

        @Override
        public Surat[] newArray(int size) {
            return new Surat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(no_surat);
        parcel.writeString(jenis_surat);
        parcel.writeString(uang_saku);
        parcel.writeString(tglmulaisppd);
        parcel.writeString(tglselesaisppd);
        parcel.writeString(statussurat);
    }

    public String getNo_surat() {
        return no_surat;
    }

    public String getJenis_surat() {
        return jenis_surat;
    }

    public String getUang_saku() {
        return uang_saku;
    }

    public String getTglmulaisppd() {
        return tglmulaisppd;
    }

    public String getTglselesaisppd() {
        return tglselesaisppd;
    }

    public String getStatussurat() {
        return statussurat;
    }

    @Override
    public String toString() {
        return "Surat{" +
                "no_surat='" + no_surat + '\'' +
                ", jenis_surat='" + jenis_surat + '\'' +
                ", uang_saku='" + uang_saku + '\'' +
                ", tglmulaisppd='" + tglmulaisppd + '\'' +
                ", tglselesaisppd='" + tglselesaisppd + '\'' +
                ", statussurat='" + statussurat + '\'' +
                '}';
    }
}
