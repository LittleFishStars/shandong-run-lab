package com.acse.ottn;

import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdInfoModel;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface l4 {
    @POST("api/plugin_change")
    Observable<String> A(@Body RequestBody requestBody);

    @POST("api/an/gc/pn")
    Observable<AccessiblityModel> B(@Body RequestBody requestBody);

    @POST("api/an/gc/jlj")
    Observable<String> C(@Body RequestBody requestBody);

    @POST("api/close_remind")
    Observable<String> D(@Body RequestBody requestBody);

    @POST("api/an/gc/mt_ele")
    Observable<String> E(@Body RequestBody requestBody);

    @POST("api/check_session")
    Observable<String> a(@Body RequestBody requestBody);

    @POST("api/an/gc/set_close_status")
    Observable<String> b(@Body RequestBody requestBody);

    @POST("api/an/gc/get_app_list")
    Observable<String> c(@Body RequestBody requestBody);

    @POST("api/mobile_app")
    Observable<String> d(@Body RequestBody requestBody);

    @POST("api/an/gc/allocation_result")
    Observable<String> e(@Body RequestBody requestBody);

    @POST("api/an/gc/verify")
    Observable<String> f(@Body RequestBody requestBody);

    @POST("api/oppo_state")
    Observable<String> g(@Body RequestBody requestBody);

    @POST("api/cut_down")
    Observable<AdInfoModel> h(@Body RequestBody requestBody);

    @POST("api/report")
    Observable<String> i(@Body RequestBody requestBody);

    @POST("api/an/gc/get_close_status")
    Observable<String> j(@Body RequestBody requestBody);

    @POST("api/member")
    Observable<String> k(@Body RequestBody requestBody);

    @POST("api/an/gc/scroll")
    Observable<AccessiblityModel> l(@Body RequestBody requestBody);

    @POST("api/time_limit")
    Observable<String> m(@Body RequestBody requestBody);

    @POST("api/push_ad_ecpm")
    Observable<String> n(@Body RequestBody requestBody);

    @POST("api/sys_pic")
    Observable<String> o(@Body RequestBody requestBody);

    @POST("api/an/gc/save_settings")
    Observable<String> p(@Body RequestBody requestBody);

    @POST("api/an/gc/lon_lat")
    Observable<String> q(@Body RequestBody requestBody);

    @POST("api/data_check")
    Observable<String> r(@Body RequestBody requestBody);

    @POST("api/clear_ad_time")
    Observable<String> s(@Body RequestBody requestBody);

    @POST("api/limit_tips")
    Observable<String> t(@Body RequestBody requestBody);

    @POST("api/close_plugin")
    Observable<String> u(@Body RequestBody requestBody);

    @POST("api/mobile_check")
    Observable<String> v(@Body RequestBody requestBody);

    @POST("api/an/gc/local_ref")
    Observable<String> w(@Body RequestBody requestBody);

    @POST("api/sys_state")
    Observable<String> x(@Body RequestBody requestBody);

    @POST("api/an/gc/allocation_app")
    Observable<String> y(@Body RequestBody requestBody);

    @POST("api/plugin_check")
    Observable<String> z(@Body RequestBody requestBody);
}
