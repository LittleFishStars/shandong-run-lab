package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.base.download.DownloadTipDialog;
import com.fl.saas.adx.base.widget.FLCommonDialog;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fl.saas.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1439v {
    private static C1439v b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadTipDialog f30198a;

    /* JADX INFO: renamed from: com.fl.saas.v$a */
    public class a implements T {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f30199a;
        final /* synthetic */ C1415j b;

        public a(Context context, C1415j c1415j) {
            this.f30199a = context;
            this.b = c1415j;
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            C1439v.this.a(this.f30199a, this.b, str);
        }

        @Override // com.fl.saas.T
        public void b(String str) {
            C1439v.this.a(this.f30199a, this.b, str);
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            exc.printStackTrace();
        }
    }

    private C1439v() {
    }

    public static C1439v b() {
        if (b == null) {
            synchronized (C1439v.class) {
                b = new C1439v();
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void i(Context context, C1415j c1415j) {
        String str = !TextUtils.isEmpty(c1415j.z0) ? c1415j.z0 : c1415j.x0;
        C1435t.a().a(c1415j, 4);
        C1435t.a().a(context, c1415j, str);
    }

    private void k(Context context, C1415j c1415j) {
        List list;
        if (c1415j == null || (list = c1415j.R0) == null || list.isEmpty()) {
            return;
        }
        if (c1415j.r()) {
            AbstractC1447z.a("click", c1415j);
        }
        Iterator it = c1415j.R0.iterator();
        while (it.hasNext()) {
            C1401c.c().a(true, C1443x.a().a((String) it.next(), c1415j), (T) new a(context, c1415j));
        }
    }

    public void c(final Context context, final C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(c1415j.y0)) {
                a(context, C1443x.a().a(c1415j.x0, c1415j), c1415j);
            } else if (QuickAppHelper.getInstance().enableQuickApp(c1415j.i) || !QuickAppHelper.getInstance().urlIntercept(c1415j.y0)) {
                h(context, c1415j);
            } else if (QuickAppHelper.getInstance().getQuickAppInterceptionType() == 1) {
                new FLCommonDialog(context).setTitle("跳转提示").setContent("想要打开“快应用”\n是否允许").setCanDismiss(false).setCancelName("拒绝").setSubmitName("允许").setOnSubmitListener(new FLCommonDialog.OnSubmitListener() { // from class: com.zj.adlib.kvb
                    @Override // com.fl.saas.adx.base.widget.FLCommonDialog.OnSubmitListener
                    public final void onClick() {
                        this.f17797a.h(context, c1415j);
                    }
                }).show();
            }
        } catch (Exception e) {
            c1415j.h2 = 1;
            if (c1415j.i2 != 2) {
                c1415j.i2 = 3;
            }
            C1443x.a().f(c1415j);
            a(context, C1443x.a().a(c1415j.x0, c1415j), c1415j);
            e.printStackTrace();
        }
    }

    public void d(final Context context, final C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        LogcatUtil.d(context + "--" + c1415j.g2);
        if (c1415j.g2) {
            try {
                a();
                if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                    final Activity topActivity = DeviceUtil.getTopActivity();
                    LogcatUtil.d(topActivity + "----");
                    if (topActivity == null || topActivity.isFinishing()) {
                        i(context, c1415j);
                        return;
                    } else if (this.f30198a == null) {
                        this.f30198a = new DownloadTipDialog(topActivity, c1415j, new DownloadTipDialog.OnAgreeClickListener() { // from class: com.zj.adlib.jvb
                            @Override // com.fl.saas.adx.base.download.DownloadTipDialog.OnAgreeClickListener
                            public final void onClick() {
                                this.f17508a.a(topActivity, c1415j);
                            }
                        });
                    }
                } else if (this.f30198a == null) {
                    this.f30198a = new DownloadTipDialog(context, c1415j, new DownloadTipDialog.OnAgreeClickListener() { // from class: com.zj.adlib.hvb
                        @Override // com.fl.saas.adx.base.download.DownloadTipDialog.OnAgreeClickListener
                        public final void onClick() {
                            this.f17085a.i(context, c1415j);
                        }
                    });
                }
                this.f30198a.show();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        i(context, c1415j);
    }

    public void e(Context context, C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        c(context, c1415j);
    }

    public void f(Context context, C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, c1415j.A1);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = c1415j.B1;
            if (!TextUtils.isEmpty(c1415j.C1) && c1415j.C1.trim().length() > 0) {
                req.path = c1415j.C1;
            }
            req.miniprogramType = 0;
            iwxapiCreateWXAPI.sendReq(req);
        } catch (Throwable th) {
            e(context, c1415j);
            th.printStackTrace();
        }
    }

    public void g(Context context, C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(c1415j.y0)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (c1415j.y0.contains("m.taobao.com")) {
                    intent.setFlags(805339136);
                } else {
                    intent.setFlags(268435456);
                }
                intent.setData(Uri.parse(c1415j.y0));
                if (DeviceUtil.deviceCanHandleIntent(intent)) {
                    C1443x.a().g(c1415j);
                    C1443x.a().e(c1415j);
                    if (!AbstractC1447z.a(context, intent, c1415j.y0, c1415j.n0, c1415j.m0)) {
                        context.startActivity(intent);
                    }
                    C1443x.a().d(c1415j);
                    c1415j.p2 = "1";
                    return;
                }
                c1415j.i2 = 2;
                C1443x.a().f(c1415j);
            }
            d(context, c1415j);
        } catch (Exception e) {
            c1415j.h2 = 1;
            if (c1415j.i2 != 2) {
                c1415j.i2 = 3;
            }
            C1443x.a().f(c1415j);
            d(context, c1415j);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void h(Context context, C1415j c1415j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (c1415j.y0.contains("m.taobao.com")) {
                intent.setFlags(805339136);
            } else {
                intent.setFlags(268435456);
            }
            intent.setData(Uri.parse(c1415j.y0));
            if (DeviceUtil.deviceCanHandleIntent(intent)) {
                if (c1415j.l0 == 1) {
                    J.b().a(C1443x.a().a(c1415j.x0, c1415j), c1415j.i, c1415j.h0);
                }
                c1415j.p2 = "1";
                J.b().a(c1415j);
                C1443x.a().g(c1415j);
                C1443x.a().e(c1415j);
                if (!AbstractC1447z.a(context, intent, c1415j.y0, c1415j.n0, c1415j.m0)) {
                    context.startActivity(intent);
                }
            } else {
                if (c1415j.l0 == 1) {
                    J.b().a(C1443x.a().a(c1415j.x0, c1415j), c1415j.i, c1415j.h0);
                }
                if (!AbstractC1447z.a(context, intent, c1415j.y0, c1415j.n0, c1415j.m0)) {
                    context.startActivity(intent);
                }
                c1415j.p2 = "1";
                J.b().a(c1415j);
                C1443x.a().g(c1415j);
                C1443x.a().e(c1415j);
            }
            C1443x.a().d(c1415j);
        } catch (Exception e) {
            c1415j.h2 = 1;
            if (c1415j.i2 != 2) {
                c1415j.i2 = 3;
            }
            C1443x.a().f(c1415j);
            a(context, C1443x.a().a(c1415j.x0, c1415j), c1415j);
            e.printStackTrace();
        }
    }

    public void b(Context context, C1415j c1415j) {
        if (context == null || c1415j == null) {
            return;
        }
        String str = c1415j.w0;
        if (str.equals("1")) {
            g(context, c1415j);
            return;
        }
        if (str.equals("5") || str.equals("6")) {
            k(context, c1415j);
            return;
        }
        if (str.equals("3")) {
            c(context, c1415j);
        } else if (str.equals("7")) {
            f(context, c1415j);
        } else {
            e(context, c1415j);
        }
    }

    public void a() {
        try {
            DownloadTipDialog downloadTipDialog = this.f30198a;
            if (downloadTipDialog != null && downloadTipDialog.isShowing()) {
                this.f30198a.dismiss();
            }
            this.f30198a = null;
        } catch (Exception e) {
            e.printStackTrace();
            this.f30198a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, C1415j c1415j, String str) {
        if (context == null || c1415j == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (c1415j.w0.equals("5")) {
                if (str.contains("qz_gdt=")) {
                    c1415j.z1 = str.substring(str.indexOf("qz_gdt=") + 7);
                }
                c(context, c1415j);
            } else if (c1415j.w0.equals("6")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ret", -1) == 0) {
                        c1415j.z1 = jSONObject.optJSONObject("data").optString("clickid");
                        g(context, c1415j);
                    } else {
                        e(context, c1415j);
                    }
                } catch (Throwable unused) {
                    e(context, c1415j);
                }
            }
        } catch (Throwable unused2) {
            e(context, c1415j);
        }
    }

    private void a(Context context, String str, C1415j c1415j) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && c1415j != null) {
                    if (c1415j.h0 == 0) {
                        FLH5Activity.launchWithEnableQuickApp(context, str, QuickAppHelper.getInstance().enableQuickApp(c1415j.i));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
