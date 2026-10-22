package com.huachenjie.run.api;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.common.bean.UnfinishedRun;
import huachenjie.sdk.http.BaseEntity;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface IFreeApi {
    @POST("run-front/run/finishFreeRun")
    Observable<BaseEntity<JSONObject>> a(@Body RequestBody body);

    @FormUrlEncoded
    @POST("run-front/run/queryUnFinishRun")
    Observable<BaseEntity<UnfinishedRun>> b(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/run/startFreeRun")
    Observable<BaseEntity<JSONObject>> c(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/run/pageFreeRunRecordList")
    Observable<BaseEntity<SunshineRecordListEntity>> d(@Field("pageSize") int pageSize, @Field("pageNum") int pageNum, @Field("timeType") int timeType);

    @FormUrlEncoded
    @POST("run-front/run/queryRunRecordCount")
    Observable<BaseEntity<SportStatics>> e(@Field("timeType") int timeType, @Field("sportType") int sportType);
}
