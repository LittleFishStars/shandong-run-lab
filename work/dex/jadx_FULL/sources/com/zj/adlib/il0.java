package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import com.alibaba.alibclogin.AlibcLogin;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.callback.AlibcTradeCallback;
import com.alibaba.alibcprotocol.param.AlibcDegradeType;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.param.AlibcTaokeParams;
import com.alibaba.alibcprotocol.param.OpenType;
import com.alibaba.alibctriver.AlibcImageCenter;
import com.alibaba.alibctriver.AlibcNavigateCenter;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.baichuan.nb_trade.AlibcTrade;
import com.baichuan.nb_trade.callback.AlibcTradeInitCallback;
import com.baichuan.nb_trade.core.AlibcTradeSDK;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.baichuan.extend.ImageImpl;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.callback.VoidCallback;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JB\u0010\r\u001a\u00020\u00042:\u0010\f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007R\u0014\u0010\u0014\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/il0;", "", "Landroid/app/Application;", "application", "", "c", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "userNick", "successCallback", y6b.f, "Landroid/content/Context;", "context", "url", "d", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class il0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final il0 f42382a = new il0();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TAG = "BaiChuanUtil";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/zj/adlib/il0$a", "Lcom/baichuan/nb_trade/callback/AlibcTradeInitCallback;", "", "onSuccess", "", "code", "", "msg", "onFailure", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements AlibcTradeInitCallback {
        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public void onFailure(int code, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AlibcLogger.e(il0.TAG, "init sdk fail: code = " + code + ", msg = " + msg);
        }

        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public void onSuccess() {
            AlibcLogger.i(il0.TAG, "init sdk success");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"com/zj/adlib/il0$b", "Lcom/alibaba/alibcprotocol/callback/AlibcTradeCallback;", "", "i", "", j.b, "", "onSuccess", "code", "", "msg", "onFailure", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements AlibcTradeCallback {
        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public void onFailure(int code, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AlibcLogger.e(il0.TAG, "open fail: code = " + code + ", msg = " + msg);
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public void onSuccess(int i, @NotNull Object o) {
            Intrinsics.checkNotNullParameter(o, j.b);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/il0$c", "Lcom/alibaba/alibcprotocol/callback/AlibcLoginCallback;", "", "userId", "userNick", "", "onSuccess", "", "code", "msg", "onFailure", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements AlibcLoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<String, String, Unit> f42383a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super String, ? super String, Unit> function2) {
            this.f42383a = function2;
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public void onFailure(int code, @Nullable String msg) {
            AlibcLogger.e(il0.TAG, "login fail: code = " + code + ", msg = " + msg);
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public void onSuccess(@Nullable String userId, @Nullable String userNick) {
            this.f42383a.invoke(userId, userNick);
        }
    }

    public static final void e() {
    }

    public static final void f(Context context, String str) {
        String userId;
        String str2 = "";
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$url");
        try {
            AlibcShowParams alibcShowParams = new AlibcShowParams();
            alibcShowParams.setBackUrl("alisdk://");
            alibcShowParams.setOpenType(OpenType.Native);
            alibcShowParams.setDegradeType(AlibcDegradeType.Download);
            AlibcTaokeParams alibcTaokeParams = new AlibcTaokeParams("", "", "");
            CommonUserInfo commonUserInfoE = ai9.e();
            if (commonUserInfoE != null && (userId = commonUserInfoE.getUserId()) != null) {
                str2 = userId;
            }
            AlibcTrade.openByUrl(context, str, alibcShowParams, alibcTaokeParams, MapsKt.mapOf(TuplesKt.to("userId", str2)), new b());
        } catch (Exception unused) {
            fv5.b("您暂未安装相关APP");
        }
    }

    public final void c(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        AlibcNavigateCenter.registerNavigateUrl(new x88());
        AlibcImageCenter.registerImage(new ImageImpl(application));
        AlibcTradeSDK.init(application, MapsKt.mapOf(TuplesKt.to(com.alipay.sdk.m.o.b.r0, 5000)), new a(), AlibcTradeSDK.InitStrategy.BEFORE_CALL_API);
    }

    public final void d(@NotNull final Context context, @NotNull final String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        pq8.i(context, "跳转提示", "闪动校园想要打开淘宝", false, "不同意", "同意", new VoidCallback() { // from class: com.zj.adlib.gl0
            @Override // com.huachenjie.common.callback.VoidCallback
            public final void a() {
                il0.e();
            }
        }, new VoidCallback() { // from class: com.zj.adlib.hl0
            @Override // com.huachenjie.common.callback.VoidCallback
            public final void a() {
                il0.f(context, url);
            }
        });
    }

    public final void g(@NotNull Function2<? super String, ? super String, Unit> successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        AlibcLogin.getInstance().showLogin(new c(successCallback));
    }
}
