package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.activity.SeedingLoadingActivity;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.ExcessService;
import com.acse.ottn.service.WebViewService;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n4 {
    public static n4 b = null;
    public static String c = "StartAppUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TimerTask f23103a;

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f23104a;
        public final /* synthetic */ AccessibilityService b;
        public final /* synthetic */ b c;

        /* JADX INFO: renamed from: com.acse.ottn.n4$a$a, reason: collision with other inner class name */
        public class RunnableC0111a implements Runnable {
            public RunnableC0111a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AccessiblityModel accessiblityModel = a.this.f23104a;
                if (accessiblityModel == null || accessiblityModel.getData() == null) {
                    return;
                }
                h2.a(n4.c, "currenttime 2=" + System.currentTimeMillis());
                if (!"click_type".equals(a.this.f23104a.getGenuine_packagename()) && !l0.e) {
                    h2.a(n4.c, "isShowConpunInfor is false1");
                    return;
                }
                h2.a(n4.c, "couponCountDown CommonUtil.isShowConpunInfor()111 =" + l0.e);
                h2.a(n4.c, "couponCountDown couponModel.getRed_package() =" + a.this.f23104a.getRed_package());
                if (a.this.f23104a.getRed_package() != 1) {
                    a aVar = a.this;
                    b bVar = aVar.c;
                    if (bVar != null) {
                        bVar.a(aVar.f23104a);
                        return;
                    }
                    return;
                }
                if (TextUtils.isEmpty(a.this.f23104a.getData().getPresent_price())) {
                    h2.a(n4.c, "packageName is null");
                } else {
                    if ("0".equals(w1.a().a(a.this.f23104a.getData().getPresent_price()).getVersion())) {
                        h2.a(n4.c, "current phone have not app");
                        return;
                    }
                    h2.a(n4.c, "current phone have app");
                }
                if ("1".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    n4 n4VarC = n4.c();
                    a aVar2 = a.this;
                    n4VarC.b(aVar2.b, aVar2.f23104a);
                    return;
                }
                if ("5".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    o oVarC = o.c();
                    a aVar3 = a.this;
                    oVarC.a(aVar3.b, aVar3.f23104a.getData().getTkl_turn_url());
                    n4 n4VarC2 = n4.c();
                    a aVar4 = a.this;
                    n4VarC2.b(aVar4.b, aVar4.f23104a);
                    return;
                }
                if ("3".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    n4.c().b();
                    Intent intent = new Intent(a.this.b, (Class<?>) ExcessService.class);
                    intent.putExtra("password", a.this.f23104a.getData().getTkl_turn_url());
                    intent.putExtra("deeplink", a.this.f23104a.getData().getSpop_deeplink());
                    intent.putExtra("link", a.this.f23104a.getData().getSpop_link());
                    intent.putExtra("name", a.this.f23104a.getData().getPackage_name());
                    intent.putExtra("time", a.this.f23104a.getData().getCoupon_load_time());
                    intent.putExtra("origin_url", a.this.f23104a.getData().getOrigin_url());
                    intent.putExtra("jump_type", a.this.f23104a.getData().getJump_type());
                    intent.putExtra("dissmiss_time", a.this.f23104a.getData().getActivity_dismiss_time());
                    intent.addFlags(268435456);
                    a.this.b.startService(intent);
                    return;
                }
                if ("4".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    Intent intent2 = new Intent(a.this.b, (Class<?>) WebViewService.class);
                    intent2.putExtra("url", a.this.f23104a.getData().getOrigin_url());
                    intent2.putExtra("shortLink", a.this.f23104a.getData().getTkl_turn_url());
                    a.this.b.startService(intent2);
                    return;
                }
                if ("6".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    a aVar5 = a.this;
                    b bVar2 = aVar5.c;
                    if (bVar2 != null) {
                        bVar2.a(aVar5.f23104a);
                        return;
                    }
                    return;
                }
                if ("8888".equals(a.this.f23104a.getData().getAuto_open_coupon())) {
                    h2.a(n4.c, "couponCountDown showFloatWindow 8888");
                    a.this.f23104a.getData().setPackage_name(o.c().U);
                    a aVar6 = a.this;
                    b bVar3 = aVar6.c;
                    if (bVar3 != null) {
                        bVar3.a(aVar6.f23104a);
                    }
                }
            }
        }

        public a(AccessiblityModel accessiblityModel, AccessibilityService accessibilityService, b bVar) {
            this.f23104a = accessiblityModel;
            this.b = accessibilityService;
            this.c = bVar;
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0111a(), 0L);
            } catch (Throwable th) {
                h2.a(n4.c, "couponCountDown e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
        }
    }

    public interface b {
        void a(AccessiblityModel accessiblityModel);
    }

    public static n4 c() {
        if (b == null) {
            synchronized (n4.class) {
                if (b == null) {
                    b = new n4();
                }
            }
        }
        return b;
    }

    public void b(Context context, AccessiblityModel accessiblityModel) {
        if (accessiblityModel == null || TextUtils.isEmpty(accessiblityModel.getData().getSpop_deeplink()) || TextUtils.isEmpty(accessiblityModel.getData().getSpop_link()) || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        q2.b().a("clickcoupon_" + accessiblityModel.getData().getPackage_name());
        n3.a().a("click_state", Boolean.TRUE);
        if ("1".equals(accessiblityModel.getData().getTo_loading())) {
            try {
                b();
                Intent intent = new Intent(context, (Class<?>) SeedingLoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("link", accessiblityModel.getData().getSpop_link());
                intent.putExtra("packagename", accessiblityModel.getData().getPackage_name());
                intent.putExtra("tkl_turn_url", accessiblityModel.getData().getTkl_turn_url());
                intent.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
                intent.putExtra("pic_type", accessiblityModel.getData().getPic_type());
                intent.putExtra("dissmiss_time", accessiblityModel.getData().getActivity_dismiss_time());
                intent.putExtra("jump_type", accessiblityModel.getData().getJump_type());
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                a(context, accessiblityModel);
                return;
            }
        }
        if (!"2".equals(accessiblityModel.getData().getTo_loading())) {
            a(context, accessiblityModel);
            return;
        }
        b();
        Intent intent2 = new Intent(context, (Class<?>) ExcessActivity.class);
        intent2.putExtra("password", accessiblityModel.getData().getTkl_turn_url());
        intent2.putExtra("deeplink", accessiblityModel.getData().getSpop_deeplink());
        intent2.putExtra("link", accessiblityModel.getData().getSpop_link());
        intent2.putExtra("time", accessiblityModel.getData().getCoupon_load_time());
        intent2.putExtra("name", accessiblityModel.getData().getPackage_name());
        intent2.putExtra("origin_url", accessiblityModel.getData().getOrigin_url());
        intent2.putExtra("dissmiss_time", accessiblityModel.getData().getActivity_dismiss_time());
        intent2.putExtra("jump_type", accessiblityModel.getData().getJump_type());
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }

    public void a(Context context, AccessiblityModel accessiblityModel) {
        try {
            String strL = t0.b().l(accessiblityModel.getData().getPackage_name());
            if (!TextUtils.isEmpty(strL)) {
                accessiblityModel.getData().setSpop_deeplink(strL);
            }
            a(context, accessiblityModel.getData().getSpop_deeplink(), accessiblityModel.getData().getSpop_link(), accessiblityModel.getData().getJump_type());
        } catch (Exception unused) {
            a(context, accessiblityModel.getData().getSpop_deeplink(), accessiblityModel.getData().getSpop_link(), accessiblityModel.getData().getJump_type());
        }
    }

    public void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        if (str3.equals("1")) {
            if (str == null || str2 == null) {
                return;
            }
            try {
                a(context, str, str2);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused2) {
                q2.b().a("open_browser_fail");
            }
        } catch (Exception unused3) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public final void a(Context context, String str, String str2) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, h0.a().a(context));
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = str2;
        req.path = str;
        req.miniprogramType = 0;
        iwxapiCreateWXAPI.sendReq(req);
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel, String str, b bVar) {
        h2.a(c, "couponCountDown ");
        TimerTask timerTask = this.f23103a;
        if (timerTask != null) {
            timerTask.cancel();
            this.f23103a = null;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
            d.d().a(accessibilityService, accessiblityModel.getData().getSpop_describe());
        }
        h2.a(c, "currenttime 1=" + System.currentTimeMillis());
        this.f23103a = n0.a().b(accessiblityModel.getData().getShow_coupon_time(), 200, new a(accessiblityModel, accessibilityService, bVar));
    }

    public void b() {
        List<WeakReference<Activity>> list = p.m;
        for (int size = list.size() - 1; size >= 0; size--) {
            Activity activity = list.get(size).get();
            if (activity != null) {
                activity.finish();
                list.remove(size);
            }
        }
    }
}
