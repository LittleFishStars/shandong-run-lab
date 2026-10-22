package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.base.dsbridge_webview.HalfTransparentDWebActivity;
import com.huachenjie.base.dsbridge_webview.PayWebViewActivity;
import com.huachenjie.common.callback.VoidCallback;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class su9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f44781a = "com.huachenjie.shandong_school.time_film_share";
    public static String b = "com.huachenjie.shandong_school.time_film_del";

    public static /* synthetic */ void c(String str) {
        try {
            nl0.f43546a.b(str);
        } catch (Exception unused) {
            fv5.b("您暂未安装微信APP");
        }
    }

    public static /* synthetic */ void d(String str) {
        try {
            nl0.f43546a.b(str);
        } catch (Exception unused) {
            fv5.b("您暂未安装微信APP");
        }
    }

    public static void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/metaverse-shop/passport");
        context.startActivity(intent);
    }

    public static void f(Context context) {
        v(context, Environment.c + "/#/affiliate");
    }

    public static void g(Context context) {
        v(context, Environment.c + "/#/mall/activity-20250214");
    }

    public static void h(Context context, String examCode, String examStudentResultCode) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        if (TextUtils.isEmpty(examCode)) {
            examCode = "";
        }
        if (TextUtils.isEmpty(examStudentResultCode)) {
            examStudentResultCode = "";
        }
        intent.putExtra("url", Environment.c + "/#/exam/paper-detail?examCode=" + examCode + "&examStudentResultCode=" + examStudentResultCode);
        context.startActivity(intent);
    }

    public static void i(Context context, String activityNo) {
        v(context, Environment.c + "/#/mall/mall-flash-sale?activityNo=" + activityNo);
    }

    public static void j(Context context, String code) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/metaverse/guide?code=" + code);
        context.startActivity(intent);
    }

    public static void k(Context context, String url) {
        Intent intent = new Intent(context, (Class<?>) HalfTransparentDWebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void l(Context context, final String url) {
        if (nl0.f43546a.a(url)) {
            pq8.i(context, "跳转提示", "闪动校园想要打开学脉小程序", false, "不同意", "同意", null, new VoidCallback() { // from class: com.zj.adlib.qu9
                @Override // com.huachenjie.common.callback.VoidCallback
                public final void a() {
                    su9.c(url);
                }
            });
            return;
        }
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void m(Context context) {
        v(context, Environment.b + "/shandong-local-life/#/");
    }

    public static void n(Context context, String orderItemNo) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/mall/trade-snapshot?orderItemNo=" + orderItemNo);
        context.startActivity(intent);
    }

    public static void o(Context context) {
        v(context, Environment.c + "/#/corner/privacy-settings");
    }

    public static void p(Context context, String code) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/notice?code=" + code);
        context.startActivity(intent);
    }

    public static void q(Context context, final String url) {
        if (nl0.f43546a.a(url)) {
            pq8.i(context, "跳转提示", "闪动校园想要打开学脉小程序", false, "不同意", "同意", null, new VoidCallback() { // from class: com.zj.adlib.ru9
                @Override // com.huachenjie.common.callback.VoidCallback
                public final void a() {
                    su9.d(url);
                }
            });
        } else {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", url).navigation();
        }
    }

    public static void r(Context context) {
        v(context, Environment.c + "/#/mall/point-mall2");
    }

    public static void s(Activity context, int requestCode) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/questionnaire");
        intent.putExtra("closeInterceptorName", "default");
        intent.putExtra("forbidBack", true);
        context.startActivityForResult(intent, requestCode);
    }

    public static void t(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/metaverse-shop/lobby");
        activity.startActivity(intent);
    }

    public static void u(Context context, String bizNo) {
        v(context, Environment.c + "/#/stadium-reserve/detail/" + bizNo);
    }

    public static void v(Context context, String url) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void w(Context context, String url, boolean showToolBar) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra(RVParams.LONG_SHOW_TOOLBAR, showToolBar);
        context.startActivity(intent);
    }

    public static void x(Context context) {
        Intent intent = new Intent(context, (Class<?>) PayWebViewActivity.class);
        intent.putExtra("url", Environment.c + "/#/wallet");
        context.startActivity(intent);
    }
}
