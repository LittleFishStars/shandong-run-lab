package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.util.DialogUtil;
import huachenjie.sdk.http.security.core.EncryptInterceptor;
import huachenjie.sdk.http.security.core.EncryptStatusListener;
import huachenjie.sdk.http.ui.HttpDialogManager;
import huachenjie.sdk.http.ui.HttpToastManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/r24;", "", "Landroid/content/Context;", "ctx", "", "versionName", "BUILD_VERSION", "PLATFORM", "APP_CODE", "", "hcj_debug", xh9.WEBSITE_PARAMS_CHANNEL, "", "c", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class r24 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r24 f44348a = new r24();

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/zj/adlib/r24$a", "Lhuachenjie/sdk/http/security/core/EncryptStatusListener;", "Lokhttp3/Request;", "request", "", "type", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "b", "Lokhttp3/Response;", ConnectionLog.CONN_LOG_STATE_RESPONSE, "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements EncryptStatusListener {
        public void a(@NotNull Response response, int type, @NotNull Exception e) {
            Intrinsics.checkNotNullParameter(response, ConnectionLog.CONN_LOG_STATE_RESPONSE);
            Intrinsics.checkNotNullParameter(e, "e");
        }

        public void b(@NotNull Request request, int type, @NotNull Exception e) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/r24$b", "Lhuachenjie/sdk/http/ui/HttpDialogManager;", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Dialog;", "b", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends HttpDialogManager {
        @Nullable
        public Dialog b(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            if (activity.isFinishing()) {
                return null;
            }
            Dialog dialogM = DialogUtil.m(activity);
            dialogM.setCanceledOnTouchOutside(false);
            dialogM.show();
            return dialogM;
        }
    }

    public static final void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.p24
            @Override // java.lang.Runnable
            public final void run() {
                r24.e(str);
            }
        });
    }

    public static final void e(String str) {
        fv5.b(str);
    }

    public final void c(@NotNull Context ctx, @Nullable String versionName, @Nullable String BUILD_VERSION, @Nullable String PLATFORM, @Nullable String APP_CODE, boolean hcj_debug, @NotNull String channel) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(channel, xh9.WEBSITE_PARAMS_CHANNEL);
        c25.m("NetInitUtils", "versionName=" + versionName + ";BUILD_VERSION=" + BUILD_VERSION + ";PLATFORM=" + PLATFORM + "\nAPP_CODE=" + APP_CODE + ";hcj_debug=" + hcj_debug);
        String str = Build.VERSION.RELEASE;
        String strC = ys8.c("ShanDong/%s (%s;Android %s)", versionName, Build.BRAND, str);
        hq1 hq1VarA = hq1.a();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("|");
        stringBuffer.append(Build.MODEL);
        hq1VarA.b(versionName, BUILD_VERSION, PLATFORM, stringBuffer.toString(), str, APP_CODE, strC, channel);
        if (r90.G()) {
            c25.l("您已同意隐私协议，开始二次初始化网络库");
            hq1VarA = hq1VarA.c(r90.D(), ai9.e().getToken(), ai9.e().getSatoken(), om2.b(ctx));
        }
        ix5 ix5Var = new ix5(hq1VarA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(AliyunLogCommon.TERMINAL_TYPE);
        arrayList.add("password");
        arrayList.add("userName");
        arrayList.add("schoolName");
        arrayList.add("studentNumber");
        h33.d((l43.b() == 9 || l43.b() == 11) ? q21.e : q21.f, "", false, false, arrayList);
        try {
            lo7.h(new lo7.a().q(Environment.f33657a).r(15000).D(15000).t(ctx).v(hcj_debug).A(new oq5()).A(new o89()).s(sw3.b()).A(new EncryptInterceptor(new EncryptInterceptor.HeaderInfo(), true, new a())).A(ix5Var).A(new lx7()).A(k24.a()).C(false).z(new HttpToastManager() { // from class: com.zj.adlib.q24
                public final void showToast(String str2) {
                    r24.d(str2);
                }
            }).y(new b()));
            sj8 sj8Var = sj8.a;
            String str2 = Environment.f33657a;
            Intrinsics.checkNotNullExpressionValue(str2, "BASE_URL");
            OkHttpClient okHttpClientF = lo7.e().f();
            Intrinsics.checkNotNullExpressionValue(okHttpClientF, "getInstance().okHttpClient");
            sj8Var.b(str2, okHttpClientF);
        } catch (Exception e) {
            Log.e("NetInitUtils", "网络库初始化失败", e);
            if (hcj_debug) {
                throw e;
            }
        }
    }
}
