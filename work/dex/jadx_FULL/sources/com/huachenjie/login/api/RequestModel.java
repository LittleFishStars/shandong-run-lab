package com.huachenjie.login.api;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
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
import com.huachenjie.login.bean.VisitorRequestBean;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\bI\u0010JJ\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0005J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\nJ/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010!J-\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J/\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010&J)\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J=\u0010,\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J=\u0010.\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010-JI\u00100\u001a\u0004\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001d\u00105\u001a\u0004\u0018\u0001042\u0006\u00103\u001a\u000202H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u00106J%\u00109\u001a\u0004\u0018\u00010$2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b9\u0010+J#\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J-\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\bA\u0010&J5\u0010D\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\bD\u0010-J/\u0010E\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u001eJE\u0010G\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lcom/huachenjie/login/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/login/api/LoginApi;", "Lcom/huachenjie/login/bean/RegisterConfigBean;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "word", "Lcom/alibaba/fastjson/JSONObject;", y6b.f, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schoolName", "", "pageNum", "Lcom/huachenjie/login/bean/SearchSchoolInfoBean;", "p", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/login/bean/GradeBean;", "i", "loginName", "Lcom/huachenjie/login/bean/LoginCheckData;", "m", AliyunLogCommon.TERMINAL_TYPE, "Lcom/huachenjie/login/bean/RemainTimesData;", "e", "sendType", "captchaPoint", "Lcom/huachenjie/login/bean/AuthCodeData;", "s", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "thirdType", "u", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authCode", "ticket", "Lcom/huachenjie/login/bean/LoginResultData;", t.d, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "password", "n", "Lcom/huachenjie/login/bean/PasswordVerifyCodeData;", "q", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", VerifyCodeActivity.y, "w", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/login/bean/VisitorRequestBean;", "requestBean", "Lcom/huachenjie/login/bean/BindVisitorBean;", "d", "(Lcom/huachenjie/login/bean/VisitorRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "geTuiToken", "gyuid", j.b, "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/login/bean/SchoolCertificationBean;", y6b.g, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schoolCode", "type", "Lcom/huachenjie/login/bean/SchoolAuthBean;", "f", "number", "bindKey", "c", "t", "code", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<LoginApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f34611a = new RequestModel();

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$bindPhoneBySchoolAuth$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull VisitorRequestBean visitorRequestBean, @NotNull Continuation<? super BindVisitorBean> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String jSONString = JSON.toJSONString(visitorRequestBean);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(requestBean)");
        return BaseRepositoryExtKt.a(this, new RequestModel$bindVisitor$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull Continuation<? super RemainTimesData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkRemainTimes$2(str, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super SchoolAuthBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkSchoolAuth$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkSensitiveWords$2(str, null), continuation);
    }

    @Nullable
    public final Object h(int i, @NotNull Continuation<? super PageEntity<SchoolCertificationBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getCertificationSchoolList$2(i, null), continuation);
    }

    @Nullable
    public final Object i(@NotNull Continuation<? super List<GradeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getGradeList$2(null), continuation);
    }

    @Nullable
    public final Object j(@NotNull Continuation<? super RegisterConfigBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getRegisterConfig$2(null), continuation);
    }

    @Nullable
    public final Object k(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$loginBySchoolAuthCode$2(str, str2, str3, str4, str5, str6, null), continuation);
    }

    @Nullable
    public final Object l(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$loginByVerifyCode$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object m(@NotNull String str, @NotNull Continuation<? super LoginCheckData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$loginCheck$2(str, null), continuation);
    }

    @Nullable
    public final Object n(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$loginPassword$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object o(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$oneKeyLogin$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object p(@NotNull String str, int i, @NotNull Continuation<? super SearchSchoolInfoBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySchoolPage$2(str, i, null), continuation);
    }

    @Nullable
    public final Object q(@Nullable String str, @Nullable String str2, @NotNull Continuation<? super PasswordVerifyCodeData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestPasswordVerifyCode$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object r(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$resetPassword$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object s(@NotNull String str, int i, @Nullable String str2, @NotNull Continuation<? super AuthCodeData> continuation) {
        HashMap map = new HashMap();
        map.put(AliyunLogCommon.TERMINAL_TYPE, str);
        map.put("sendType", String.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str2);
            map.put("captchaPoint", str2);
        }
        return BaseRepositoryExtKt.a(this, new RequestModel$sendAuthCode$2(map, null), continuation);
    }

    @Nullable
    public final Object t(@NotNull String str, int i, @Nullable String str2, @NotNull Continuation<? super AuthCodeData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$sendBindPhoneAuthCode$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object u(@NotNull String str, int i, int i2, @Nullable String str2, @NotNull Continuation<? super AuthCodeData> continuation) {
        HashMap map = new HashMap();
        map.put(AliyunLogCommon.TERMINAL_TYPE, str);
        map.put("sendType", String.valueOf(i));
        map.put("type", "3");
        map.put("thirdType", String.valueOf(i2));
        if (!TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str2);
            map.put("captchaPoint", str2);
        }
        return BaseRepositoryExtKt.a(this, new RequestModel$sendThirdAuthCode$2(map, null), continuation);
    }

    @Nullable
    public final Object v(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super LoginResultData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$setPassword$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object w(int i, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super LoginResultData> continuation) {
        HashMap map = new HashMap();
        map.put("thirdType", String.valueOf(i));
        map.put(VerifyCodeActivity.y, str);
        if (str2 != null) {
            map.put(AliyunLogCommon.TERMINAL_TYPE, str2);
            if (str3 == null) {
                str3 = "";
            }
            map.put("authCode", str3);
            if (str4 == null) {
                str4 = "";
            }
            map.put("ticket", str4);
        }
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$thirdLogin$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }
}
