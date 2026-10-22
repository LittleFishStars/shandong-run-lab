package com.huachenjie.compat.api;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.bean.SendMsgEntity;
import com.huachenjie.compat.bean.ConfirmPhoneEntity;
import com.huachenjie.compat.bean.DepartmentClassBean;
import com.huachenjie.compat.bean.MyCourseInfo;
import com.huachenjie.compat.bean.PersonalInfo;
import com.huachenjie.compat.bean.StudentCard;
import com.huachenjie.compat.bean.SubSchoolBean;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public interface CompatApi {
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/changePhone")
    Observable<BaseEntity<ConfirmPhoneEntity>> a(@Field(AliyunLogCommon.TERMINAL_TYPE) String str, @Field("authCode") String str2, @Field("ticket") String str3, @Field("type") int i);

    @FormUrlEncoded
    @POST("run-front/account/queryStudentCard")
    Observable<BaseEntity<StudentCard>> b(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/login/getPasswordCodeIn")
    Observable<BaseEntity<JSONObject>> c(@Field("captchaPoint") String str);

    @FormUrlEncoded
    @POST("run-front/school/querySchoolDepartmentClassList")
    Observable<BaseEntity<List<DepartmentClassBean>>> d(@Field("schoolCode") String str);

    @FormUrlEncoded
    @POST("run-front/account/personal")
    Observable<BaseEntity<PersonalInfo>> e(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/login/resetPasswordIn")
    Observable<BaseEntity<Object>> f(@Field("ticket") String str, @Field("password") String str2, @Field("authCode") String str3, @Field(AliyunLogCommon.TERMINAL_TYPE) String str4);

    @POST("run-front/account/updateStudent")
    Observable<BaseEntity<Object>> g(@Body RequestBody requestBody);

    @POST("run-front/common/nation")
    Observable<BaseEntity<PageEntity<String>>> h();

    @POST("run-front/face/getUserFaceImg")
    Observable<BaseEntity<UserFaceBean>> i();

    @FormUrlEncoded
    @POST("run-front/unsubscribe/appeal")
    Observable<BaseEntity<JSONObject>> j(@Field("ticket") String str, @Field(AliyunLogCommon.TERMINAL_TYPE) String str2, @Field("remark") String str3);

    @FormUrlEncoded
    @POST("run-front/unsubscribe/smsCode")
    Observable<BaseEntity<JSONObject>> k(@Field(AliyunLogCommon.TERMINAL_TYPE) String str);

    @POST("run-front/course/findMyCourse")
    Observable<BaseEntity<MyCourseInfo>> l();

    @FormUrlEncoded
    @POST("run-front/unsubscribe/verifySmsCode")
    Observable<BaseEntity<JSONObject>> m(@Field(AliyunLogCommon.TERMINAL_TYPE) String str, @Field("smsCode") String str2);

    @POST("run-front/subSchool/list")
    Observable<BaseEntity<PageEntity<SubSchoolBean>>> n();

    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/sendAuthCode")
    Observable<BaseEntity<SendMsgEntity>> o(@Field(AliyunLogCommon.TERMINAL_TYPE) String str, @Field("type") int i, @Field("captchaPoint") String str2);
}
