package com.huachenjie.run.api;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.run.bean.FinishFreeRunResult;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.UploadData;
import huachenjie.sdk.http.BaseEntity;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface IRunApi {
    @POST("run-front/run/finishFreeRun")
    Observable<BaseEntity<FinishFreeRunResult>> a(@Body RequestBody body);

    @FormUrlEncoded
    @POST("run-front/run/queryUnFinishRun")
    Observable<BaseEntity<UnfinishedRun>> b(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/run/startFreeRun")
    Observable<BaseEntity<JSONObject>> c(@FieldMap Map<String, String> map);

    @POST("run-front/run/uploadPaceRecord")
    Observable<BaseEntity<UploadData>> d(@Body RequestBody body);

    @POST("run-front/run/uploadPassPoint")
    Observable<BaseEntity<JSONObject>> e(@Body RequestBody body);

    @FormUrlEncoded
    @POST("run-front/run/nfc/verification-status")
    Observable<BaseEntity<JSONObject>> f(@Field("runRecordCode") String runRecordCode);

    @FormUrlEncoded
    @POST("run-front/run/queryRunRecordCount")
    Observable<BaseEntity<SportStatics>> g(@Field("timeType") int timeType, @Field("sportType") int sportType);

    @POST("run-front/run/uploadStrideRecord")
    Observable<BaseEntity<UploadData>> h(@Body RequestBody body);

    @POST("run-front/run/uploadRunRecord")
    Observable<BaseEntity<UploadData>> i(@Header(UserTrackConstant.SIGN) String sign, @Body RequestBody body);

    @POST("run-front/run/finishSunRun_v2")
    Observable<BaseEntity<FinishRunResult>> j(@Body RequestBody body);

    @POST("run-front/run/uploadStepsRecord")
    Observable<BaseEntity<UploadData>> k(@Body RequestBody body);
}
