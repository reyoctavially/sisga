package org.diskominfo.sisga.util.api;

import org.diskominfo.sisga.model.ResponseAbsenDetail;
import org.diskominfo.sisga.model.ResponseCutiDetail;
import org.diskominfo.sisga.model.ResponsePengajuanCutiDetail;
import org.diskominfo.sisga.model.ResponsePengajuanSuratDetail;
import org.diskominfo.sisga.model.ResponseSuratDetail;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiServices {
    // Fungsi ini untuk memanggil API http://10.0.2.2/sisga/login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("username_pegawai") String username_pegawai,
                                    @Field("pass_pegawai") String pass_pegawai);

    // Fungsi ini untuk memanggil API http://10.0.2.2/sisga/pengajuancuti.php
    @FormUrlEncoded
    @POST("pengajuancuti.php")
    Call<ResponseBody> cutiRequest(@Field("tgl_pengajuan_cuti") String tgl_pengajuan_cuti,
                                   @Field("alasan_pengajuan_cuti") String alasan_pengajuan_cuti,
                                   @Field("tgl_mulai_cuti") String tgl_mulai_cuti,
                                   @Field("tgl_selesai_cuti") String tgl_selesai_cuti,
                                   @Field("kode_pegawai") String kode_pegawai);

    // Fungsi ini untuk memanggil API http://10.0.2.2/sisga/pengajuansurat.php
    @FormUrlEncoded
    @POST("pengajuansppd.php")
    Call<ResponseBody> suratRequest(@Field("tgl_pengajuan_surat") String tgl_pengajuan_surat,
                                    @Field("tujuan_pengajuan_surat") String tujuan_pengajuan_surat,
                                    @Field("tgl_mulai_sppd") String tgl_mulai_sppd,
                                    @Field("tgl_selesai_sppd") String tgl_selesai_sppd,
                                    @Field("kode_pegawai") String kode_pegawai);

    @GET("cuti/{kode_pegawai}")
    Call<ResponseCutiDetail> getCuti(@Path("kode_pegawai") String kode_pegawai);

    @GET("surat/{kode_pegawai}")
    Call<ResponseSuratDetail> getSurat(@Path("kode_pegawai") String kode_pegawai);

    @GET("pengajuancuti/{kode_pegawai}")
    Call<ResponsePengajuanCutiDetail> getCutiDetail(@Path("kode_pegawai") String kode_pegawai);

    @GET("pengajuansurat/{kode_pegawai}")
    Call<ResponsePengajuanSuratDetail> getSuratDetail(@Path("kode_pegawai") String kode_pegawai);

    @GET("absen/{kode_pegawai}")
    Call<ResponseAbsenDetail> getAbsenDetail(@Path("kode_pegawai") String kode_pegawai);

    @FormUrlEncoded
    @POST("updateAbsen.php")
    Call<ResponseBody> updateAbsenRequest(@Field("tanggal_absen") String tanggal_absen,
                                          @Field("kode_pegawai") String kode_pegawai,
                                          @Field("jam_keluar") String jam_keluar);

    @FormUrlEncoded
    @POST("absen.php")
    Call<ResponseBody> simpanAbsenRequest(@Field("tanggal_absen") String tanggal_absen,
                                          @Field("jam_masuk") String jam_masuk,
                                          @Field("jam_keluar") String jam_keluar,
                                          @Field("kode_pegawai") String kode_pegawai);

    @FormUrlEncoded
    @POST("cekabsenmasuk.php")
    Call<ResponseBody> cekAbsenMasukRequest(@Field("tanggal_absen") String tanggal_absen,
                                          @Field("kode_pegawai") String kode_pegawai);

    @FormUrlEncoded
    @POST("cekabsenkeluar.php")
    Call<ResponseBody> cekAbsenKeluarRequest(@Field("tanggal_absen") String tanggal_absen,
                                             @Field("kode_pegawai") String kode_pegawai,
                                             @Field("jam_keluar") String jam_keluar);

}
