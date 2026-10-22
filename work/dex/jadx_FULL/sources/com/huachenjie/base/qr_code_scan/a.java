package com.huachenjie.base.qr_code_scan;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.qr_code_scan.a;
import com.huachenjie.common.bean.LocationRangeBean;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.page.qrcode.QRCodeResultFragment;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.h46;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010!\u001a\u00020\u0012¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J+\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J(\u0010\u0011\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ*\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0015\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\u0016\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\"\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J&\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J=\u0010\u001d\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u001a\u0010(\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010)¨\u0006-"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/a;", "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", "", "s", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "", "outsideConfigCode", "", "clockType", "u", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Integer;)V", "result", "a", "", "lng", "lat", "j", "", t.d, "t", "q", "i", "n", "e", "qrcode", "p", "qrCode", j.b, y6b.f, "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "m", "Z", "needLocation", "Lcom/zj/adlib/gq1;", "Lcom/zj/adlib/gq1;", "commonModel", "I", "k", "()I", RequestParameters.SUBRESOURCE_LOCATION, "Ljava/lang/Integer;", "outsideClockType", "<init>", "(Z)V", "base_release"}, k = 1, mv = {1, 8, 0})
public class a implements QRCodeResultFragment.ScanResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer outsideClockType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean needLocation;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final gq1 commonModel = new gq1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final int location = 1;

    /* JADX INFO: renamed from: com.huachenjie.base.qr_code_scan.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¨\u0006\f"}, d2 = {"Lcom/huachenjie/base/qr_code_scan/a$a;", "", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/huachenjie/common/bean/LocationRangeBean;", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(ArrayList arrayList, boolean z) {
            Intrinsics.checkNotNullParameter(arrayList, "$list");
            if (z) {
                ARouter.getInstance().build(RoutePathConstants.Sport.w).withParcelableArrayList(UserConstants.MINE_PARAMS.o, arrayList).navigation();
            }
        }

        public final void b(@NotNull Context context, @NotNull final ArrayList<LocationRangeBean> list) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
            vo6.j(context, "android.permission.ACCESS_FINE_LOCATION", "为了能够在地图上显示您的位置和打卡范围，我们需要访问您的位置权限", new PermissionResultListener() { // from class: com.zj.adlib.lv7
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    a.Companion.c(list, z);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/base/qr_code_scan/a$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f32948a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ a f7230a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f7231a;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX INFO: renamed from: com.huachenjie.base.qr_code_scan.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/base/qr_code_scan/a$b$a", "Lcom/huachenjie/base/qr_code_scan/OutsideAttendanceFragment$SignInCallback;", "", "success", "", "code", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0786a implements OutsideAttendanceFragment.SignInCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppCompatActivity f32949a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ a f7232a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f7233a;

            public C0786a(a aVar, AppCompatActivity appCompatActivity, String str) {
                this.f7232a = aVar;
                this.f32949a = appCompatActivity;
                this.f7233a = str;
            }

            @Override // com.huachenjie.base.qr_code_scan.OutsideAttendanceFragment.SignInCallback
            public void a(boolean success, int code) {
                if (success) {
                    this.f7232a.s();
                } else {
                    this.f7232a.q(this.f32949a, this.f7233a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, Integer num, a aVar, AppCompatActivity appCompatActivity) {
            super(true);
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.f7231a = num;
            this.f7230a = aVar;
            this.f32948a = appCompatActivity;
        }

        public void onCCSuccess(@Nullable Object data) {
            Activity activityM = ActivityLifecycleManager.l().m();
            if (activityM instanceof AppCompatActivity) {
                OutsideAttendanceFragment.Companion bVar = OutsideAttendanceFragment.INSTANCE;
                FragmentManager supportFragmentManager = ((AppCompatActivity) activityM).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "topActivity.supportFragmentManager");
                OutsideAttendanceFragment outsideAttendanceFragmentA = bVar.a(supportFragmentManager);
                outsideAttendanceFragmentA.setCallback(new C0786a(this.f7230a, this.f32948a, this.f));
                outsideAttendanceFragmentA.startClock(this.f, this.g, this.h, this.f7231a);
            }
        }

        public void onFailed(int code, @Nullable String message) {
            if (code == 4044) {
                this.f7230a.q(this.f32948a, this.f);
            } else {
                super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/base/qr_code_scan/a$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/OutsideAttendanceRule;", "data", "", "onCCSuccess", "onFinish", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<OutsideAttendanceRule> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f32950a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppCompatActivity f7234a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AppCompatActivity appCompatActivity, Dialog dialog) {
            super(true);
            this.f7234a = appCompatActivity;
            this.f32950a = dialog;
        }

        public void onFinish() {
            this.f32950a.dismiss();
        }

        public void onCCSuccess(@Nullable OutsideAttendanceRule data) {
            if (data != null) {
                AppCompatActivity appCompatActivity = this.f7234a;
                Companion companion = a.INSTANCE;
                ArrayList<LocationRangeBean> locationList = data.getLocationList();
                if (locationList == null) {
                    locationList = new ArrayList<>();
                }
                companion.b(appCompatActivity, locationList);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/base/qr_code_scan/a$d", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends BizSubscriber<Object> {
        public d() {
            super(true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.b("签到成功");
            a.this.s();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/base/qr_code_scan/a$e", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class e extends BizSubscriber<JSONObject> {
        public e() {
            super(true);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null && data.containsKey("attendMessage")) {
                fv5.b(String.valueOf(data.get("attendMessage")));
            } else {
                fv5.b("成功");
                a.this.s();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/base/qr_code_scan/a$f", "Lcom/huachenjie/base/qr_code_scan/LocationHelper$Callback;", "", "lat", "lng", "", "a", "", "errorMsg", "b", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class f implements LocationHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f32953a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f7236a;

        public f(AppCompatActivity appCompatActivity, String str) {
            this.f32953a = appCompatActivity;
            this.f7236a = str;
        }

        @Override // com.huachenjie.base.qr_code_scan.LocationHelper.Callback
        public void a(double lat, double lng) {
            a.this.i(this.f32953a, this.f7236a, lng, lat);
        }

        @Override // com.huachenjie.base.qr_code_scan.LocationHelper.Callback
        public void b(@NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            fv5.b(errorMsg + "，签到失败");
        }
    }

    public a(boolean z) {
        this.needLocation = z;
    }

    public static final void f(a aVar, String str, AppCompatActivity appCompatActivity, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$result");
        if (z) {
            aVar.t(str, appCompatActivity);
        } else {
            fv5.b("无定位权限，签到失败");
        }
    }

    public static /* synthetic */ void h(a aVar, AppCompatActivity appCompatActivity, String str, String str2, String str3, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkOutsideSignIn");
        }
        if ((i & 16) != 0) {
            num = 1;
        }
        aVar.g(appCompatActivity, str, str2, str3, num);
    }

    public static final void r(a aVar, AppCompatActivity appCompatActivity, String str, View view) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$outsideConfigCode");
        aVar.m(appCompatActivity, str);
    }

    public static /* synthetic */ void v(a aVar, AppCompatActivity appCompatActivity, String str, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startOutsideClock");
        }
        if ((i & 4) != 0) {
            num = 1;
        }
        aVar.u(appCompatActivity, str, num);
    }

    @Override // com.huachenjie.common.page.qrcode.QRCodeResultFragment.ScanResultListener
    public void a(@Nullable AppCompatActivity activity, @NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (StringsKt.startsWith$default(result, "fitness-identity", false, 2, (Object) null)) {
            if (n(result)) {
                e(activity, result);
                return;
            } else {
                i(activity, result, -1.0d, -1.0d);
                return;
            }
        }
        if (this.needLocation) {
            e(activity, result);
        } else {
            i(activity, result, -1.0d, -1.0d);
        }
    }

    public final void e(final AppCompatActivity activity, final String result) {
        if (activity == null) {
            fv5.b("无定位权限，签到失败");
        } else if (vo6.a(activity)) {
            vo6.j(activity, "android.permission.ACCESS_FINE_LOCATION", "为了校验您是否在打卡范围内，我们需要访问您的位置权限", new PermissionResultListener() { // from class: com.zj.adlib.jv7
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    a.f(this.f17504a, result, activity, z);
                }
            });
        } else {
            new RequiredSettingComponent(activity).d(1);
        }
    }

    public final void g(AppCompatActivity activity, String outsideConfigCode, String lng, String lat, Integer clockType) {
        this.commonModel.a(outsideConfigCode, lng, lat).u5(Schedulers.io()).G3(d60.c()).p5(new b(outsideConfigCode, lng, lat, clockType, this, activity));
    }

    public final void i(AppCompatActivity activity, String result, double lng, double lat) {
        if (l(activity, result, lng, lat)) {
            return;
        }
        j(activity, result, lng, lat);
    }

    public final void j(@Nullable AppCompatActivity activity, @NotNull String result, double lng, double lat) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (StringsKt.startsWith$default(result, "fitness-identity", false, 2, (Object) null)) {
            p(result, lng, lat);
            return;
        }
        if (StringsKt.startsWith$default(result, "student-course-attend", false, 2, (Object) null)) {
            o(result, ys8.d("%.6f", Double.valueOf(lng)), ys8.d("%.6f", Double.valueOf(lat)));
            return;
        }
        if (result.length() >= 20 || !h46.f42049a.m(result)) {
            fv5.b("请扫描正确的二维码");
            return;
        }
        String strD = ys8.d("%.6f", Double.valueOf(lng));
        Intrinsics.checkNotNullExpressionValue(strD, "formatLocaleChina(\"%.6f\", lng)");
        String strD2 = ys8.d("%.6f", Double.valueOf(lat));
        Intrinsics.checkNotNullExpressionValue(strD2, "formatLocaleChina(\"%.6f\", lat)");
        Integer num = this.outsideClockType;
        g(activity, result, strD, strD2, Integer.valueOf(num != null ? num.intValue() : 1));
        this.outsideClockType = null;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getLocation() {
        return this.location;
    }

    public boolean l(@Nullable AppCompatActivity activity, @NotNull String result, double lng, double lat) {
        Intrinsics.checkNotNullParameter(result, "result");
        return false;
    }

    public final void m(AppCompatActivity activity, String outsideConfigCode) {
        this.commonModel.o(outsideConfigCode).u5(Schedulers.io()).G3(d60.c()).p5(new c(activity, DialogUtil.m(activity)));
    }

    public final boolean n(String result) {
        if (TextUtils.isEmpty(result) || !StringsKt.contains$default(result, Consts.DOT, false, 2, (Object) null)) {
            return false;
        }
        List listSplit$default = StringsKt.split$default(result, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
        Integer intOrNull = StringsKt.toIntOrNull((String) listSplit$default.get(CollectionsKt.getLastIndex(listSplit$default)));
        return ((intOrNull != null ? intOrNull.intValue() : 0) & this.location) > 0;
    }

    public final void o(String qrCode, String lng, String lat) {
        this.commonModel.v(qrCode, lng, lat).u5(Schedulers.io()).G3(d60.c()).p5(new d());
    }

    public final void p(String qrcode, double lng, double lat) {
        this.commonModel.w(qrcode, lng, lat).u5(Schedulers.io()).G3(d60.c()).p5(new e());
    }

    public final void q(@Nullable final AppCompatActivity activity, @NotNull final String outsideConfigCode) {
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        if (activity == null) {
            fv5.b("打卡失败，未在考勤范围内。");
        } else {
            ft1.g(activity).Q("打卡失败，未在考勤范围内，请同学确认打卡范围后重新定位再次打卡。").F("查看范围").N("退出打卡").C(new View.OnClickListener() { // from class: com.zj.adlib.kv7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.r(this.f17792a, activity, outsideConfigCode, view);
                }
            }).Y();
        }
    }

    public void s() {
    }

    public final void t(@NotNull String result, @Nullable AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(result, "result");
        LocationHelper.a(activity, new f(activity, result), true);
    }

    public final void u(@Nullable AppCompatActivity activity, @NotNull String outsideConfigCode, @Nullable Integer clockType) {
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        this.outsideClockType = clockType;
        e(activity, outsideConfigCode);
    }
}
