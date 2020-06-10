package org.diskominfo.sisga.util.api;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
//    public static final String BASE_URL_API = "http://192.168.43.56/sisga/";
    public static final String BASE_URL_API = "http://sisga.majalengkakab.go.id/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiServices getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiServices.class);
    }
}
