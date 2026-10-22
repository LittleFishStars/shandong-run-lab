package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.util.DialogUtil;
import com.kuaishou.weapon.p0.bo;
import com.qiyukf.nimlib.sdk.RequestCallback;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.api.YSFUserInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002R\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001d¨\u0006!"}, d2 = {"Lcom/zj/adlib/r57;", "", "Landroid/content/Context;", "context", "", "b", "f", y6b.f, "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "c", "i", "", "e", "Lcom/qiyukf/unicorn/api/UnreadCountChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "a", y6b.g, "Lcom/qiyukf/unicorn/api/YSFOptions;", "d", "", "avatar", "j", "Lcom/qiyukf/nimlib/sdk/RequestCallback;", "Ljava/lang/Void;", RenderCallContext.TYPE_CALLBACK, "k", "Ljava/lang/String;", "APP_KEY", "Lcom/qiyukf/unicorn/api/YSFOptions;", "ysfOptions", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class r57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public static YSFOptions ysfOptions = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final r57 f19240a = new r57();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String APP_KEY = "9ab347345f51cc7f63449945cef0324f";

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/r57$a", "Lcom/qiyukf/nimlib/sdk/RequestCallback;", "Ljava/lang/Void;", bo.g, "", "a", "", "onFailed", "", "onException", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements RequestCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f44378a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Dialog f19242a;

        public a(Dialog dialog, Activity activity) {
            this.f19242a = dialog;
            this.f44378a = activity;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable Void p0) {
            this.f19242a.dismiss();
            ConsultSource consultSource = new ConsultSource((String) null, (String) null, (String) null);
            consultSource.robotFirst = true;
            Unicorn.openServiceActivity(this.f44378a, "客服中心", consultSource);
        }

        public void onException(@Nullable Throwable p0) {
            this.f19242a.dismiss();
            fv5.b("客服加载失败了");
        }

        public void onFailed(int p0) {
            this.f19242a.dismiss();
            fv5.b("客服加载失败了");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/r57$b", "Lcom/qiyukf/nimlib/sdk/RequestCallback;", "Ljava/lang/Void;", bo.g, "", "a", "", "onFailed", "", "onException", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements RequestCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f44379a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Dialog f19243a;

        public b(Dialog dialog, Activity activity) {
            this.f19243a = dialog;
            this.f44379a = activity;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable Void p0) {
            this.f19243a.dismiss();
            ConsultSource consultSource = new ConsultSource((String) null, "平台商城客服", (String) null);
            consultSource.robotFirst = false;
            consultSource.groupId = 485269844L;
            Unicorn.openServiceActivity(this.f44379a, "官方客服", consultSource);
        }

        public void onException(@Nullable Throwable p0) {
            this.f19243a.dismiss();
            fv5.b("客服加载失败了");
        }

        public void onFailed(int p0) {
            this.f19243a.dismiss();
            fv5.b("客服加载失败了");
        }
    }

    @JvmStatic
    public static final void a(@NotNull UnreadCountChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Unicorn.addUnreadCountChangeListener(listener, true);
    }

    @JvmStatic
    public static final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Unicorn.config(context.getApplicationContext(), APP_KEY, f19240a.d(), new iu3(context));
    }

    @JvmStatic
    public static final void c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        if (!ai9.l()) {
            fv5.b("请先登录");
            return;
        }
        Dialog dialogM = DialogUtil.m(activity);
        dialogM.show();
        CommonUserInfo commonUserInfoE = ai9.e();
        if (!TextUtils.isEmpty(commonUserInfoE.getAvatar())) {
            f19240a.j(commonUserInfoE.getAvatar());
        }
        YSFUserInfo ySFUserInfo = new YSFUserInfo();
        ySFUserInfo.userId = commonUserInfoE.getUserId();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CachedContentIndex.a.e, "real_name");
        jsonObject.addProperty("value", commonUserInfoE.getUserName());
        jsonArray.add(jsonObject);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(CachedContentIndex.a.e, "mobile_phone");
        jsonObject2.addProperty("value", commonUserInfoE.getPhone());
        jsonArray.add(jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty(CachedContentIndex.a.e, "email");
        jsonObject3.addProperty("hidden", Boolean.TRUE);
        jsonArray.add(jsonObject3);
        JsonObject jsonObject4 = new JsonObject();
        jsonObject4.addProperty(CachedContentIndex.a.e, "avatar");
        jsonObject4.addProperty("value", commonUserInfoE.getAvatar());
        jsonArray.add(jsonObject4);
        JsonObject jsonObject5 = new JsonObject();
        jsonObject5.addProperty("index", (Number) 0);
        jsonObject5.addProperty(CachedContentIndex.a.e, "userId");
        jsonObject5.addProperty("label", "用户ID");
        jsonObject5.addProperty("value", commonUserInfoE.getUserId());
        jsonArray.add(jsonObject5);
        JsonObject jsonObject6 = new JsonObject();
        jsonObject6.addProperty("index", (Number) 1);
        jsonObject6.addProperty(CachedContentIndex.a.e, "schoolName");
        jsonObject6.addProperty("label", "学校");
        jsonObject6.addProperty("value", commonUserInfoE.getSchoolName());
        jsonArray.add(jsonObject6);
        JsonObject jsonObject7 = new JsonObject();
        jsonObject7.addProperty("index", (Number) 2);
        jsonObject7.addProperty(CachedContentIndex.a.e, "studentNumber");
        jsonObject7.addProperty("label", "学号");
        jsonObject7.addProperty("value", commonUserInfoE.getStudentNumber());
        jsonArray.add(jsonObject7);
        JsonObject jsonObject8 = new JsonObject();
        jsonObject8.addProperty("index", (Number) 3);
        jsonObject8.addProperty(CachedContentIndex.a.e, "deviceType");
        jsonObject8.addProperty("label", "设备类型");
        jsonObject8.addProperty("value", "Android|" + Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.VERSION.RELEASE);
        jsonArray.add(jsonObject8);
        JsonObject jsonObject9 = new JsonObject();
        jsonObject9.addProperty("index", (Number) 4);
        jsonObject9.addProperty(CachedContentIndex.a.e, "appVersion");
        jsonObject9.addProperty("label", "APP版本号");
        jsonObject9.addProperty("value", com.blankj.utilcode.util.b.C());
        jsonArray.add(jsonObject9);
        ySFUserInfo.data = jsonArray.toString();
        Unicorn.setUserInfo(ySFUserInfo, new a(dialogM, activity));
    }

    @JvmStatic
    public static final int e() {
        return Unicorn.getUnreadCount();
    }

    @JvmStatic
    public static final void f() {
        Unicorn.initSdk();
    }

    @JvmStatic
    public static final void g() {
        Unicorn.logout();
    }

    @JvmStatic
    public static final void h(@NotNull UnreadCountChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Unicorn.addUnreadCountChangeListener(listener, false);
    }

    @JvmStatic
    public static final void i(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        if (!ai9.l()) {
            fv5.b("请先登录");
            return;
        }
        Dialog dialogM = DialogUtil.m(activity);
        dialogM.show();
        f19240a.k(new b(dialogM, activity));
    }

    public final YSFOptions d() {
        if (ysfOptions == null) {
            YSFOptions ySFOptions = YSFOptions.DEFAULT;
            ySFOptions.isUseSAF = true;
            ysfOptions = ySFOptions;
        }
        YSFOptions ySFOptions2 = ysfOptions;
        Intrinsics.checkNotNull(ySFOptions2);
        return ySFOptions2;
    }

    public final void j(String avatar) {
        YSFOptions ySFOptionsD = d();
        UICustomization uICustomization = ySFOptionsD.uiCustomization;
        if (uICustomization == null) {
            uICustomization = new UICustomization();
        }
        uICustomization.rightAvatar = avatar;
        ySFOptionsD.uiCustomization = uICustomization;
        Unicorn.updateOptions(ySFOptionsD);
    }

    public final void k(RequestCallback<Void> callback) {
        CommonUserInfo commonUserInfoE = ai9.e();
        if (!TextUtils.isEmpty(commonUserInfoE.getAvatar())) {
            j(commonUserInfoE.getAvatar());
        }
        YSFUserInfo ySFUserInfo = new YSFUserInfo();
        ySFUserInfo.userId = commonUserInfoE.getUserId();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CachedContentIndex.a.e, "real_name");
        jsonObject.addProperty("value", commonUserInfoE.getUserName());
        jsonArray.add(jsonObject);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(CachedContentIndex.a.e, "mobile_phone");
        jsonObject2.addProperty("value", commonUserInfoE.getPhone());
        jsonArray.add(jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty(CachedContentIndex.a.e, "email");
        jsonObject3.addProperty("hidden", Boolean.TRUE);
        jsonArray.add(jsonObject3);
        JsonObject jsonObject4 = new JsonObject();
        jsonObject4.addProperty(CachedContentIndex.a.e, "avatar");
        jsonObject4.addProperty("value", commonUserInfoE.getAvatar());
        jsonArray.add(jsonObject4);
        JsonObject jsonObject5 = new JsonObject();
        jsonObject5.addProperty("index", (Number) 0);
        jsonObject5.addProperty(CachedContentIndex.a.e, "userId");
        jsonObject5.addProperty("label", "用户ID");
        jsonObject5.addProperty("value", commonUserInfoE.getUserId());
        jsonArray.add(jsonObject5);
        JsonObject jsonObject6 = new JsonObject();
        jsonObject6.addProperty("index", (Number) 1);
        jsonObject6.addProperty(CachedContentIndex.a.e, "schoolName");
        jsonObject6.addProperty("label", "学校");
        jsonObject6.addProperty("value", commonUserInfoE.getSchoolName());
        jsonArray.add(jsonObject6);
        JsonObject jsonObject7 = new JsonObject();
        jsonObject7.addProperty("index", (Number) 2);
        jsonObject7.addProperty(CachedContentIndex.a.e, "studentNumber");
        jsonObject7.addProperty("label", "学号");
        jsonObject7.addProperty("value", commonUserInfoE.getStudentNumber());
        jsonArray.add(jsonObject7);
        JsonObject jsonObject8 = new JsonObject();
        jsonObject8.addProperty("index", (Number) 3);
        jsonObject8.addProperty(CachedContentIndex.a.e, "deviceType");
        jsonObject8.addProperty("label", "设备类型");
        jsonObject8.addProperty("value", "Android|" + Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.VERSION.RELEASE);
        jsonArray.add(jsonObject8);
        JsonObject jsonObject9 = new JsonObject();
        jsonObject9.addProperty("index", (Number) 4);
        jsonObject9.addProperty(CachedContentIndex.a.e, "appVersion");
        jsonObject9.addProperty("label", "APP版本号");
        jsonObject9.addProperty("value", com.blankj.utilcode.util.b.C());
        jsonArray.add(jsonObject9);
        ySFUserInfo.data = jsonArray.toString();
        Unicorn.setUserInfo(ySFUserInfo, callback);
    }
}
