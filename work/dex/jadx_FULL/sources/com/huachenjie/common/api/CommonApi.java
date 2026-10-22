package com.huachenjie.common.api;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.bean.AdConfig;
import com.huachenjie.common.bean.AdPositionConfig;
import com.huachenjie.common.bean.CheatConfig;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.CurrentActivityData;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.bean.OrderBean;
import com.huachenjie.common.bean.OssTokenInfo;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.huachenjie.common.bean.PayResult;
import com.huachenjie.common.bean.StudentSchoolAuthBean;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.bean.VodTokenInfo;
import huachenjie.sdk.http.BaseEntity;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface CommonApi {
    @GET("run-front/common/getConfig")
    Observable<BaseEntity<CommonConfig>> a();

    @FormUrlEncoded
    @POST("run-front/account/updateUser")
    Observable<BaseEntity<Object>> b(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/outside/outsideRule")
    Observable<BaseEntity<OutsideAttendanceRule>> c(@Field("outsideConfigCode") String outsideConfigCode);

    @FormUrlEncoded
    @POST("run-front/outside/checkClock")
    Observable<BaseEntity<Object>> d(@Field("outsideConfigCode") String outsideConfigCode, @Field("lng") String lng, @Field("lat") String lat);

    @POST("run-front/ad/getAdConfig")
    Observable<BaseEntity<AdConfig>> e();

    @FormUrlEncoded
    @POST("run-front/attend/submitQrcode")
    Observable<BaseEntity<Object>> f(@Field("qrCode") String qrCode, @Field("lng") String lng, @Field("lat") String lat);

    @POST("run-front/multiverse/recordReviews")
    Observable<BaseEntity<JSONObject>> g();

    @POST("run-front/attend/submitFillDigitCode")
    Observable<BaseEntity<JSONObject>> h(@Body RequestBody body);

    @FormUrlEncoded
    @POST("run-front/aliyun/oss/getToken")
    Observable<BaseEntity<OssTokenInfo>> i(@Field("tokenType") String tokenType);

    @POST("run-front/vod/getVodToken")
    Observable<BaseEntity<VodTokenInfo>> j();

    @FormUrlEncoded
    @POST("run-front/sso/school/getSchoolConfig")
    Observable<BaseEntity<StudentSchoolAuthBean>> k(@Field("schoolCode") String schoolCode);

    @FormUrlEncoded
    @POST("run-front/pay/checkOrder")
    Observable<BaseEntity<PayResult>> l(@Field("payType") int payType, @Field("orderNo") String orderNo);

    @FormUrlEncoded
    @POST("run-front/metaverse/friend/edit")
    Observable<BaseEntity<Object>> m(@Field("friendCode") String friendCode, @Field("remarkNickname") String remarkNickname);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("run-front/customer/getCustomerStatus")
    Observable<BaseEntity<CustomerServerStatusData>> n();

    @POST("run-front/attend/scan/qrcode/submit")
    Observable<BaseEntity<JSONObject>> o(@Body RequestBody body);

    @FormUrlEncoded
    @POST("run-front/pay/payV2")
    Observable<BaseEntity<OrderBean>> p(@Field("payType") int payType, @Field("type") int type, @Field("goodsSubType") int goodsSubType, @Field("goodsCode") String goodsCode);

    @FormUrlEncoded
    @POST("run-front/emoji/checkEmojiBagDetail")
    Observable<BaseEntity<Object>> q(@Field("emojiBagCode") String emojiBagCode);

    @POST("run-front/multiverse/getGoodReviews")
    Observable<BaseEntity<JSONObject>> r();

    @POST("run-front/outside/clock")
    Observable<BaseEntity<Object>> s(@Body RequestBody body);

    @POST("run-front/detect/configV2")
    Observable<BaseEntity<CheatConfig>> t();

    @GET("run-front/common/syncTime")
    Observable<BaseEntity<JSONObject>> u();

    @FormUrlEncoded
    @POST("run-front/common/update")
    Observable<BaseEntity<VersionUpgrade>> v(@FieldMap Map<String, String> map);

    @POST("run-front/activity/getCurrent")
    Observable<BaseEntity<CurrentActivityData>> w();

    @POST("run-front/ad/getAadPositionAgencyConfig")
    Observable<BaseEntity<AdPositionConfig>> x();

    @FormUrlEncoded
    @POST("run-front/outside/clockTime")
    Observable<BaseEntity<ClockTimeData>> y(@Field("outsideConfigCode") String outsideConfigCode);

    @FormUrlEncoded
    @POST("run-front/account/logout")
    Observable<BaseEntity<Object>> z(@FieldMap Map<String, String> map);
}
