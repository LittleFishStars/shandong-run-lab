package com.huachenjie.login.api;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.login.bean.AuthCodeData;
import com.huachenjie.login.bean.BindVisitorBean;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.bean.LoginCheckData;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.bean.PasswordVerifyCodeData;
import com.huachenjie.login.bean.RegisterConfigBean;
import com.huachenjie.login.bean.RemainTimesData;
import com.huachenjie.login.bean.SchoolAuthBean;
import com.huachenjie.login.bean.SchoolCertificationBean;
import com.huachenjie.login.bean.SearchSchoolInfoBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ9\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0005J%\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\nJ%\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\nJ1\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00022\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH§@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ9\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010 \u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J?\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0004\b'\u0010$J3\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u00022\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0004\b)\u0010*JK\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0004\b+\u0010,JK\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0004\b-\u0010,J'\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\n\b\u0001\u0010/\u001a\u0004\u0018\u00010.H§@ø\u0001\u0000¢\u0006\u0004\b0\u00101J%\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00022\b\b\u0001\u0010/\u001a\u00020.H§@ø\u0001\u0000¢\u0006\u0004\b3\u00101J/\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\b\b\u0001\u00104\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b6\u0010*J3\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000208070\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J7\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00022\b\b\u0001\u0010;\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u00062\b\b\u0001\u0010<\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b>\u0010$JC\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\b\b\u0001\u0010;\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010@\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\bA\u0010,JE\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010B\u001a\u00020\f2\b\b\u0001\u0010<\u001a\u00020\f2\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJW\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00022\b\b\u0001\u0010;\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010E\u001a\u00020\u00062\b\b\u0001\u0010@\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/huachenjie/login/api/LoginApi;", "", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/login/bean/RegisterConfigBean;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "word", "Lcom/alibaba/fastjson/JSONObject;", "q", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schoolName", "", "pageNum", "pageSize", "Lcom/huachenjie/login/bean/SearchSchoolInfoBean;", "f", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/login/bean/GradeBean;", "k", "loginName", "Lcom/huachenjie/login/bean/LoginCheckData;", "n", AliyunLogCommon.TERMINAL_TYPE, "Lcom/huachenjie/login/bean/RemainTimesData;", t.d, "", "map", "Lcom/huachenjie/login/bean/AuthCodeData;", "i", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authCode", "ticket", "Lcom/huachenjie/login/bean/LoginResultData;", "p", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "password", "captchaPoint", "e", "Lcom/huachenjie/login/bean/PasswordVerifyCodeData;", "t", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "Lokhttp3/RequestBody;", "body", "s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/login/bean/BindVisitorBean;", "m", "geTuiToken", "gyuid", y6b.g, "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/login/bean/SchoolCertificationBean;", y6b.f, "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schoolCode", "type", "Lcom/huachenjie/login/bean/SchoolAuthBean;", "b", "number", "bindKey", "a", "sendType", "d", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "code", j.b, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login_release"}, k = 1, mv = {1, 8, 0})
public interface LoginApi {
    @FormUrlEncoded
    @POST("run-front/account/sso/phone/bind")
    @Nullable
    Object a(@Field("schoolCode") @NotNull String str, @Field("number") @NotNull String str2, @Field(AliyunLogCommon.TERMINAL_TYPE) @NotNull String str3, @Field("bindKey") @NotNull String str4, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @FormUrlEncoded
    @POST("run-front/auth/sso/casCallback")
    @Nullable
    Object b(@Field("schoolCode") @NotNull String str, @Field("ticket") @NotNull String str2, @Field("type") @NotNull String str3, @NotNull Continuation<? super BaseEntity<SchoolAuthBean>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/login/setPassword_v2")
    Object c(@Field("ticket") @Nullable String str, @Field("password") @Nullable String str2, @Field("authCode") @Nullable String str3, @Field(AliyunLogCommon.TERMINAL_TYPE) @Nullable String str4, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/getAuthCode")
    @Nullable
    Object d(@Field(AliyunLogCommon.TERMINAL_TYPE) @NotNull String str, @Field("sendType") int i, @Field("type") int i2, @Field("captchaPoint") @Nullable String str2, @NotNull Continuation<? super BaseEntity<AuthCodeData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/auth/loginPassword")
    Object e(@Field("loginName") @Nullable String str, @Field("password") @Nullable String str2, @Field("captchaPoint") @Nullable String str3, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/school/firstPageSchoolList")
    Object f(@Field("schoolName") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<SearchSchoolInfoBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/sso/school/getConfigList")
    @Nullable
    Object g(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<SchoolCertificationBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/oneClick/login")
    @Nullable
    Object h(@Field("geTuiToken") @NotNull String str, @Field("gyuid") @NotNull String str2, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/getAuthCode")
    Object i(@FieldMap @NotNull Map<String, String> map, @NotNull Continuation<? super BaseEntity<AuthCodeData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/login/resetPasswordOut")
    Object j(@Field("ticket") @Nullable String str, @Field("password") @Nullable String str2, @Field("authCode") @Nullable String str3, @Field(AliyunLogCommon.TERMINAL_TYPE) @Nullable String str4, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @POST("run-front/account/gradeList")
    @Nullable
    Object k(@NotNull Continuation<? super BaseEntity<List<GradeBean>>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/sendRemainTimes")
    Object l(@Field(AliyunLogCommon.TERMINAL_TYPE) @NotNull String str, @NotNull Continuation<? super BaseEntity<RemainTimesData>> continuation);

    @Headers({"e:1"})
    @POST("run-front/auth/bindVisitor")
    @Nullable
    Object m(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<BindVisitorBean>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/auth/loginCheck")
    Object n(@Field("loginName") @NotNull String str, @NotNull Continuation<? super BaseEntity<LoginCheckData>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/sso/phone/bind/verify")
    @Nullable
    Object o(@Field("schoolCode") @NotNull String str, @Field("number") @NotNull String str2, @Field(AliyunLogCommon.TERMINAL_TYPE) @NotNull String str3, @Field("code") @NotNull String str4, @Field("bindKey") @NotNull String str5, @Field("ticket") @NotNull String str6, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/account/login_v3")
    Object p(@Field(AliyunLogCommon.TERMINAL_TYPE) @NotNull String str, @Field("authCode") @NotNull String str2, @Field("ticket") @NotNull String str3, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/sensitiveFilter")
    @Nullable
    Object q(@Field("word") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/auth/registerConfig")
    @Nullable
    Object r(@NotNull Continuation<? super BaseEntity<RegisterConfigBean>> continuation);

    @POST("run-front/account/thirdLogin_v2")
    @Nullable
    Object s(@Body @Nullable RequestBody requestBody, @NotNull Continuation<? super BaseEntity<LoginResultData>> continuation);

    @Nullable
    @FormUrlEncoded
    @Headers({"e:1"})
    @POST("run-front/login/getPasswordSetCode")
    Object t(@Field(AliyunLogCommon.TERMINAL_TYPE) @Nullable String str, @Field("captchaPoint") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PasswordVerifyCodeData>> continuation);
}
