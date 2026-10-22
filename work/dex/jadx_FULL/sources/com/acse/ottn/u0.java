package com.acse.ottn;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface u0 {
    @POST("mobile/googleapis/v2/new_api")
    Observable<String> a(@Body RequestBody requestBody);
}
