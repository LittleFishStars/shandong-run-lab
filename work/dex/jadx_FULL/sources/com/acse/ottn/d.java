package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.model.WxClickDataModel;
import com.acse.ottn.service.CircleFlowService;
import com.acse.ottn.service.CountdownService;
import com.acse.ottn.service.ExcessiveService;
import com.acse.ottn.service.LjFirstService;
import com.acse.ottn.service.MainService;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.ariver.kernel.RVParams;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.byazt.hv.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.dv9;
import com.zj.adlib.ze1;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements com.acse.ottn.service.a.u0 {
    public static d v = null;
    public static TimerTask w = null;
    public static TimerTask x = null;
    public static l2 y = null;
    public static String z = "acse_ShopHelperService";
    public String e;
    public String f;
    public List<String> g;
    public List<String> h;
    public AccessibilityService j;
    public Intent l;
    public String q;
    public AccessibilityNodeInfo t;
    public List u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22913a = 100;
    public int b = 10069;
    public int c = 10067;
    public int d = 10065;
    public int i = 0;
    public boolean k = true;
    public String m = "";
    public String n = "";
    public boolean o = false;
    public String p = "";
    public Handler r = new m(Looper.getMainLooper());
    public boolean s = false;

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22917a;

        public b(AccessibilityService accessibilityService) {
            this.f22917a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f22917a, "已下载的应用");
            AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(this.f22917a, "已安装的服务");
            AccessibilityNodeInfo accessibilityNodeInfoJ3 = com.acse.ottn.b.c().j(this.f22917a, "已下载的服务");
            AccessibilityNodeInfo accessibilityNodeInfoJ4 = com.acse.ottn.b.c().j(this.f22917a, "已安装的应用程序");
            if (accessibilityNodeInfoJ == null && accessibilityNodeInfoJ2 == null && accessibilityNodeInfoJ3 == null && accessibilityNodeInfoJ4 == null) {
                h2.a(d.z, "都没有找到");
            } else {
                com.acse.ottn.b.c().e(this.f22917a);
                h2.a(d.z, "找到");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.d().e(d.this.j);
        }
    }

    public class e implements r1.k0 {
        public e() {
        }

        @Override // com.acse.ottn.r1.k0
        public void onSuccess(String str) {
            if (l0.f) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if ("1".equals(jSONObject.getString("r"))) {
                        n3.a().b("applet_data", jSONObject.getString("local_toast_info"));
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class f implements n0.d {
        public f() {
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a("samon-->", "设置时间2=" + (System.currentTimeMillis() / 1000));
            d.this.o = false;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
        }
    }

    public class g implements r1.j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22922a;

        public g(String str) {
            this.f22922a = str;
        }

        @Override // com.acse.ottn.r1.j0
        public void a(int i, int i2) {
            if (i != 1) {
                m2.a().b(d.this.j);
            } else {
                if (i2 != 1) {
                    m2.a().b(d.this.j);
                    return;
                }
                m2 m2VarA = m2.a();
                d dVar = d.this;
                m2VarA.a(dVar.j, this.f22922a, dVar);
            }
        }
    }

    public class j implements n4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22926a;

        public j(AccessibilityService accessibilityService) {
            this.f22926a = accessibilityService;
        }

        @Override // com.acse.ottn.n4.b
        public void a(AccessiblityModel accessiblityModel) {
            d.this.b(this.f22926a, accessiblityModel);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22927a;
        public final /* synthetic */ AccessiblityModel b;

        public k(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
            this.f22927a = accessibilityService;
            this.b = accessiblityModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            e2.a().b(this.f22927a);
            i0.d().a(this.f22927a);
            i0.d().b(this.f22927a, this.b);
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22928a;
        public final /* synthetic */ AccessiblityModel b;

        public l(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
            this.f22928a = accessibilityService;
            this.b = accessiblityModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.h) {
                if (d.this.l != null) {
                    h2.a(d.z, "showFloatWindow stop floatIntent");
                    this.f22928a.stopService(d.this.l);
                    d.this.l = null;
                }
                d.this.l = new Intent(this.f22928a, (Class<?>) CircleFlowService.class);
                d.this.l.putExtra(ze1.k, this.b);
                this.f22928a.startService(d.this.l);
            }
        }
    }

    public class m extends Handler {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PageSettingTypeModel f22930a;
            public final /* synthetic */ String b;

            public a(PageSettingTypeModel pageSettingTypeModel, String str) {
                this.f22930a = pageSettingTypeModel;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.b(dVar.j);
                Message message = new Message();
                message.what = 10073;
                Bundle bundle = new Bundle();
                bundle.putString("coupon_packagename", this.f22930a.getPackage_name());
                bundle.putString("genuine_packagename", this.b);
                message.setData(bundle);
                d.this.r.sendMessageDelayed(message, 500L);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PageSettingTypeModel f22931a;
            public final /* synthetic */ String b;

            public class a implements Runnable {

                /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a, reason: collision with other inner class name */
                public class C0103a implements t0.b {

                    /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$a, reason: collision with other inner class name */
                    public class RunnableC0104a implements Runnable {
                        public RunnableC0104a() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                            bundle.putString("genuine_packagename", b.this.b);
                            message.setData(bundle);
                            d.this.r.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$b, reason: collision with other inner class name */
                    public class RunnableC0105b implements Runnable {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ AccessibilityNodeInfo f22935a;
                        public final /* synthetic */ int b;

                        /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$b$a, reason: collision with other inner class name */
                        public class RunnableC0106a implements Runnable {
                            public RunnableC0106a() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Message message = new Message();
                                message.what = 10072;
                                Bundle bundle = new Bundle();
                                bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                                bundle.putString("genuine_packagename", b.this.b);
                                message.setData(bundle);
                                d.this.r.sendMessageDelayed(message, 0L);
                            }
                        }

                        public RunnableC0105b(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
                            this.f22935a = accessibilityNodeInfo;
                            this.b = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            a3.d().b(this.f22935a, this.b);
                            new Handler().postDelayed(new RunnableC0106a(), 200L);
                        }
                    }

                    /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$c */
                    public class c implements Runnable {
                        public c() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                            bundle.putString("genuine_packagename", b.this.b);
                            message.setData(bundle);
                            d.this.r.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$d, reason: collision with other inner class name */
                    public class RunnableC0107d implements Runnable {
                        public RunnableC0107d() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                            bundle.putString("genuine_packagename", b.this.b);
                            message.setData(bundle);
                            d.this.r.sendMessageDelayed(message, 0L);
                        }
                    }

                    /* JADX INFO: renamed from: com.acse.ottn.d$m$b$a$a$e */
                    public class e implements Runnable {
                        public e() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Message message = new Message();
                            message.what = 10072;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                            bundle.putString("genuine_packagename", b.this.b);
                            message.setData(bundle);
                            d.this.r.sendMessageDelayed(message, 0L);
                        }
                    }

                    public C0103a() {
                    }

                    @Override // com.acse.ottn.t0.b
                    public void a(String str, int i, String str2, String str3) {
                        if (str.equals("0")) {
                            a3.d().a(d.this.j.getRootInActiveWindow(), i);
                            new Handler().postDelayed(new RunnableC0104a(), 200L);
                            return;
                        }
                        if (str.equals("1")) {
                            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(d.this.j, str2);
                            if (accessibilityNodeInfoJ == null) {
                                return;
                            }
                            a3.d().a(d.this.j);
                            new Handler().postDelayed(new RunnableC0105b(accessibilityNodeInfoJ, i), 100L);
                            return;
                        }
                        if (str.equals("2")) {
                            a3.d().a(d.this.j);
                            a3.d().a();
                            new Handler().postDelayed(new c(), 200L);
                            return;
                        }
                        if (str.equals("3")) {
                            AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(d.this.j, str2);
                            AccessibilityNodeInfo accessibilityNodeInfoJ3 = com.acse.ottn.b.c().j(d.this.j, str3);
                            if (accessibilityNodeInfoJ2 == null || accessibilityNodeInfoJ3 == null) {
                                return;
                            }
                            a3.d().a(d.this.j);
                            a3.d().a(d.this.j.getRootInActiveWindow(), i);
                            new Handler().postDelayed(new RunnableC0107d(), 200L);
                            return;
                        }
                        if (str.equals("4")) {
                            if (t0.b().a(d.this.h, str2, str3)) {
                                a3.d().a(d.this.j);
                                a3.d().a();
                                new Handler().postDelayed(new e(), 200L);
                                return;
                            }
                            return;
                        }
                        if (str.equals("5")) {
                            Message message = new Message();
                            message.what = 10073;
                            Bundle bundle = new Bundle();
                            bundle.putString("coupon_packagename", b.this.f22931a.getPackage_name());
                            bundle.putString("genuine_packagename", b.this.b);
                            message.setData(bundle);
                            d.this.r.sendMessageDelayed(message, 0L);
                        }
                    }
                }

                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    List<String> list = d.this.h;
                    if (list != null) {
                        h2.a("samon-->", list.toString());
                    }
                    t0 t0VarB = t0.b();
                    b bVar = b.this;
                    t0VarB.a(d.this.h, bVar.f22931a.getContainsTextList(), new C0103a());
                }
            }

            public b(PageSettingTypeModel pageSettingTypeModel, String str) {
                this.f22931a = pageSettingTypeModel;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.b(dVar.j);
                new Handler().postDelayed(new a(), 100L);
            }
        }

        public m(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0097 A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:20:0x00a1 A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:22:0x00cb A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:23:0x00d6 A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00f9 A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:31:0x010d A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:33:0x0119 A[Catch: all -> 0x0206, TryCatch #0 {all -> 0x0206, blocks: (B:3:0x000d, B:6:0x001e, B:7:0x0037, B:10:0x0043, B:16:0x006c, B:18:0x0097, B:20:0x00a1, B:22:0x00cb, B:23:0x00d6, B:25:0x00e0, B:28:0x00ed, B:30:0x00f9, B:31:0x010d, B:33:0x0119, B:34:0x0138, B:36:0x0140, B:38:0x0148, B:13:0x0065, B:39:0x015c, B:41:0x0166, B:42:0x018b, B:44:0x0191, B:46:0x019f, B:49:0x01bb, B:52:0x01d9, B:55:0x01f0, B:57:0x0200), top: B:62:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:20:0x00a1, please report this as an issue */
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            PageSettingTypeModel pageSettingTypeModelD;
            String str = "com.alipay.mobile.nebulax.xriver.activity.XRiverActivity";
            super.handleMessage(message);
            d.this.k = true;
            try {
                if (message.what == d.this.c) {
                    l0.e = true;
                    d.this.a((List<String>) null, message.getData().getString("coupon_packagename"), message.getData().getString("genuine_packagename"), "");
                    return;
                }
                if (message.what != d.this.d) {
                    if (message.what == d.this.b) {
                        h2.c(d.z, "开始获取页面信息");
                        String string = message.getData().getString("coupon_packagename");
                        String string2 = message.getData().getString("genuine_packagename");
                        l0.i = true;
                        l0.e = true;
                        d.this.b(string, string2);
                        return;
                    }
                    int i = message.what;
                    if (i == 10072) {
                        l0.e = true;
                        if (TextUtils.isEmpty(d.d().m)) {
                            return;
                        }
                        String string3 = message.getData().getString("coupon_packagename");
                        String string4 = message.getData().getString("genuine_packagename");
                        d dVar = d.this;
                        dVar.a(dVar.h, string3, string4, "");
                        return;
                    }
                    if (i == 10073) {
                        l0.e = true;
                        String string5 = message.getData().getString("coupon_packagename");
                        String string6 = message.getData().getString("genuine_packagename");
                        d dVar2 = d.this;
                        dVar2.a(dVar2.h, string5, string6, "");
                        return;
                    }
                    if (i == 10017) {
                        l0.e = true;
                        if (com.acse.ottn.o.c().t.equals(message.getData().getString("coupon_packagename")) && "1".equals(n3.a().e("ocr_screen_state"))) {
                            d.this.c();
                            return;
                        }
                        return;
                    }
                    return;
                }
                h2.a(d.z, "当前状态 =adRequestCode");
                String string7 = message.getData().getString("coupon_packagename");
                String string8 = message.getData().getString("genuine_packagename");
                if (!string7.contains("com.tencent.mm.plugin.appbrand.ui.AppBrandUI")) {
                    if (string7.contains("com.alipay.mobile.nebulax.xriver.activity.XRiverActivity")) {
                    }
                    h2.a(d.z, "当前状态samon =activityName=" + string7 + "  genuinePackagename=" + string8);
                    pageSettingTypeModelD = t0.b().d(string7);
                    if (pageSettingTypeModelD == null) {
                        h2.a(d.z, "model 当前状态 is null");
                        return;
                    }
                    l0.e = true;
                    h2.a(d.z, "model 当前状态 =" + pageSettingTypeModelD.toString());
                    if (pageSettingTypeModelD.getRead_type().equals("0")) {
                        d.this.a((List<String>) null, pageSettingTypeModelD.getPackage_name(), string8, "");
                        return;
                    }
                    if (!pageSettingTypeModelD.getRead_type().equals("1") && !pageSettingTypeModelD.getRead_type().equals("6")) {
                        if (pageSettingTypeModelD.getRead_type().equals("2")) {
                            new Handler().postDelayed(new a(pageSettingTypeModelD, string8), pageSettingTypeModelD.getRead_time());
                            return;
                        } else {
                            if (pageSettingTypeModelD.getRead_type().equals(BeiZiBiddingConstant.LossReason.OTHER)) {
                                a3.d().a(d.this.j);
                                new Handler().postDelayed(new b(pageSettingTypeModelD, string8), pageSettingTypeModelD.getRead_time());
                                return;
                            }
                            return;
                        }
                    }
                    if (d.this.b(string7) || !d.this.e(string8)) {
                    }
                    d.d().f(d.this.j);
                    l0.i = true;
                    d.this.a(pageSettingTypeModelD, string8);
                    return;
                }
                str = "com.tencent.mm.plugin.appbrand.ui.AppBrandUI";
                string7 = str;
                h2.a(d.z, "当前状态samon =activityName=" + string7 + "  genuinePackagename=" + string8);
                pageSettingTypeModelD = t0.b().d(string7);
                if (pageSettingTypeModelD == null) {
                    h2.a(d.z, "model 当前状态 is null");
                    return;
                }
                l0.e = true;
                h2.a(d.z, "model 当前状态 =" + pageSettingTypeModelD.toString());
                if (pageSettingTypeModelD.getRead_type().equals("0")) {
                    d.this.a((List<String>) null, pageSettingTypeModelD.getPackage_name(), string8, "");
                    return;
                }
                if (!pageSettingTypeModelD.getRead_type().equals("1")) {
                    if (pageSettingTypeModelD.getRead_type().equals("2")) {
                        new Handler().postDelayed(new a(pageSettingTypeModelD, string8), pageSettingTypeModelD.getRead_time());
                        return;
                    } else {
                        if (pageSettingTypeModelD.getRead_type().equals(BeiZiBiddingConstant.LossReason.OTHER)) {
                            a3.d().a(d.this.j);
                            new Handler().postDelayed(new b(pageSettingTypeModelD, string8), pageSettingTypeModelD.getRead_time());
                            return;
                        }
                        return;
                    }
                }
                if (d.this.b(string7)) {
                }
            } catch (Throwable th) {
                h2.a(d.z, "mHandler =" + th.getMessage());
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!n3.a().a("battery_white_accessiblity")) {
                h2.a(d.z, "没有打开");
                q2.b().a("system_open_accessiblity");
                return;
            }
            h2.a(d.z, "开始发送 user_open_accessiblity");
            q2.b().a("user_open_accessiblity");
            if (n3.a() != null) {
                n3.a().a("battery_white_accessiblity", Boolean.FALSE);
            }
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22941a;

        public o(AccessibilityService accessibilityService) {
            this.f22941a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().e(this.f22941a);
        }
    }

    public void f(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        h2.a(z, "initReadPageInfo=" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        if (l0.g) {
            accessibilityServiceInfo.flags = -1;
        } else {
            accessibilityServiceInfo.flags = 90;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new c(), 100L);
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = 97;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public final Object g() throws ObjectStreamException {
        return v;
    }

    public final void h() {
        if (x != null) {
            return;
        }
        if (s0.d().a().equals(n3.a() != null ? n3.a().e("appHeartbeat") : "")) {
            return;
        }
        x = n0.a().b(20000, 10000, new a());
    }

    public final AccessibilityWindowInfo i(AccessibilityService accessibilityService) {
        for (AccessibilityWindowInfo accessibilityWindowInfo : accessibilityService.getWindows()) {
            if (!TextUtils.isEmpty(accessibilityWindowInfo.getTitle()) && "点按相应功能即可开始使用：".equals(accessibilityWindowInfo.getTitle().toString())) {
                return accessibilityWindowInfo;
            }
        }
        return null;
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: com.acse.ottn.d$a$a, reason: collision with other inner class name */
        public class RunnableC0100a implements Runnable {

            /* JADX INFO: renamed from: com.acse.ottn.d$a$a$a, reason: collision with other inner class name */
            public class C0101a implements q2.c {
                public C0101a() {
                }

                @Override // com.acse.ottn.q2.c
                public void a() {
                    com.acse.ottn.e.c().b();
                }
            }

            public RunnableC0100a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (s0.d().c(s0.d().a()) + (HelpShopAppUtil.getInstance().createRandomNumber().longValue() * 1000) > System.currentTimeMillis()) {
                    TimerTask timerTask = d.x;
                    if (timerTask != null) {
                        timerTask.cancel();
                        d.x = null;
                        return;
                    }
                    return;
                }
                p4.r();
                q2.b().b("heart_beat", null, new C0101a());
                if (!n3.a().a("accessiblity_lists")) {
                    com.acse.ottn.b.c().b();
                    n3.a().a("accessiblity_lists", Boolean.TRUE);
                }
                h2.b(d.z, "心跳 倒计时设置位false");
                k0.a(HelpShopAppUtil.getContext());
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0100a(), 2000L);
            } catch (Throwable th) {
                h2.a(d.z, th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(d.z, "结束了");
            TimerTask timerTask = d.x;
            if (timerTask != null) {
                timerTask.cancel();
                d.x = null;
            }
        }
    }

    public static d d() {
        if (v == null) {
            synchronized (d.class) {
                if (v == null) {
                    v = new d();
                }
            }
        }
        return v;
    }

    public final boolean e(String str) {
        if (!s0.d().a().equals(n3.a().e("samon_" + str))) {
            return true;
        }
        h2.a(z, "the day not requst packageName =" + str);
        return false;
    }

    public void g(AccessibilityService accessibilityService) {
        h2.a(z, "onStopService");
        Intent intent = this.l;
        if (intent != null) {
            accessibilityService.stopService(intent);
            this.l = null;
        }
    }

    public final void c(String str, String str2, int i2, int i3) {
        try {
            Message message = new Message();
            message.what = i2;
            Bundle bundle = new Bundle();
            bundle.putString("coupon_packagename", str);
            bundle.putString("genuine_packagename", str2);
            message.setData(bundle);
            this.r.sendMessageDelayed(message, i3);
        } catch (Throwable th) {
            h2.a(z, "sendMessage =" + th.getMessage());
        }
    }

    public final boolean b(String str, int i2) {
        if (i2 == 0) {
            i2 = 500;
        }
        Long lValueOf = Long.valueOf(n3.a().d("coupon_" + str));
        h2.a(z, "controlCouponShow appPageName =" + str + "-----" + (System.currentTimeMillis() - lValueOf.longValue()));
        if (System.currentTimeMillis() - lValueOf.longValue() < i2) {
            h2.a(z, "controlCouponShow return false ");
            return false;
        }
        n3.a().a("coupon_" + str, System.currentTimeMillis());
        h2.a(z, "controlCouponShow return true");
        return true;
    }

    public class i implements r1.i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22925a;

        public i(String str) {
            this.f22925a = str;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v5 java.util.Collection<?>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // com.acse.ottn.r1.i0
        public void a(com.acse.ottn.model.AccessiblityModel r3) {
            /*
                r2 = this;
                com.acse.ottn.d r0 = com.acse.ottn.d.this
                java.lang.String r1 = r2.f22925a
                r0.a(r3, r1)
                com.acse.ottn.d r3 = com.acse.ottn.d.this
                java.util.List<java.lang.String> r3 = r3.g
                if (r3 == 0) goto L1e
                r3.removeAll(r3)
                com.acse.ottn.d r3 = com.acse.ottn.d.this
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r3.g = r0
                com.acse.ottn.d r3 = com.acse.ottn.d.this
                r0 = 0
                r3.i = r0
            L1e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.i.a(com.acse.ottn.model.AccessiblityModel):void");
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v5 java.util.Collection<?>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // com.acse.ottn.r1.i0
        public void a(java.lang.String r2) {
            /*
                r1 = this;
                com.acse.ottn.d r2 = com.acse.ottn.d.this
                java.util.List<java.lang.String> r2 = r2.g
                if (r2 == 0) goto L17
                r2.removeAll(r2)
                com.acse.ottn.d r2 = com.acse.ottn.d.this
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r2.g = r0
                com.acse.ottn.d r2 = com.acse.ottn.d.this
                r0 = 0
                r2.i = r0
            L17:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.i.a(java.lang.String):void");
        }
    }

    public void e(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        h2.a(z, "initOpenPermission=" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    /* JADX INFO: renamed from: com.acse.ottn.d$d, reason: collision with other inner class name */
    public class C0102d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22919a;
        public final /* synthetic */ String b;

        public C0102d(AccessibilityService accessibilityService, String str) {
            this.f22919a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a("samon-->", "开始循环 =" + d.this.s);
            d dVar = d.this;
            if (!dVar.s) {
                dVar.a(this.f22919a, this.b, j);
                return;
            }
            TimerTask timerTask = d.w;
            if (timerTask != null) {
                timerTask.cancel();
                d.w = null;
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a("samon-->", "循环结束 =" + d.this.s);
        }
    }

    public void h(AccessibilityService accessibilityService) {
        a3.d().a(accessibilityService);
        this.j = accessibilityService;
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        h2.a(z, "initDemoPermission =" + System.currentTimeMillis());
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 88;
        accessibilityServiceInfo.notificationTimeout = 300L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public final boolean b(String str) {
        return b(str, 0);
    }

    public void b(String str, String str2, int i2, int i3) {
        h2.a(z, "onSelectActivity");
        this.e = str2;
        this.f = str2;
        c(str, str2, i2, i3);
    }

    public final void c() {
        AccessibilityNodeInfo accessibilityNodeInfoH;
        String[] strArrF = n3.a().f("key_content");
        if (strArrF == null) {
            strArrF = new String[]{"送礼", "立即领取", "人已买", "回头客", "人感兴趣", "可再享:", "直降", "跨境进口", "跨境直邮", "淘金币已抵", "天价保", "官方立减", "活动价便宜", "大促价保", "全网低价"};
        }
        String[] strArrF2 = n3.a().f("find_type");
        if (strArrF2 == null) {
            strArrF2 = new String[]{"3", "3", "1", "1", "1", "3", "1", "1", "1", "1", "1", "1", "1", "3", "3"};
        }
        String[] strArrF3 = n3.a().f("location_type");
        if (strArrF3 == null) {
            strArrF3 = new String[]{"1", "3", "5", "5", "5", "2", "4", "5", "5", "4", "5", "4", "5", "5", "5"};
        }
        for (int i2 = 0; i2 < strArrF.length; i2++) {
            if (strArrF2[i2].equals("3")) {
                accessibilityNodeInfoH = com.acse.ottn.b.c().j(this.j, strArrF[i2].trim());
            } else {
                accessibilityNodeInfoH = strArrF2[i2].equals("1") ? com.acse.ottn.b.c().h(this.j, strArrF[i2].trim()) : null;
            }
            if (accessibilityNodeInfoH != null) {
                h2.a("samon,", "当前字段==》" + strArrF[i2]);
                a3.d().a(accessibilityNodeInfoH, strArrF3[i2]);
                return;
            }
        }
    }

    public final void f() {
        n0.a().b(3000, 1000, new f());
    }

    /* JADX WARN: Code duplicated, block: B:256:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:49:0x011f A[Catch: all -> 0x0bfe, TryCatch #0 {all -> 0x0bfe, blocks: (B:12:0x0040, B:15:0x0066, B:23:0x0089, B:26:0x0097, B:28:0x00a3, B:30:0x00b0, B:32:0x00bc, B:34:0x00c8, B:57:0x01e0, B:58:0x01e7, B:60:0x01ed, B:61:0x0200, B:62:0x0206, B:259:0x050c, B:464:0x0b71, B:479:0x0bf4, B:481:0x0bfa, B:467:0x0b79, B:470:0x0b84, B:472:0x0b92, B:475:0x0bba, B:477:0x0bd5, B:478:0x0bef, B:260:0x0512, B:262:0x051c, B:263:0x0533, B:265:0x053d, B:266:0x0554, B:267:0x0560, B:269:0x0569, B:270:0x056f, B:271:0x057a, B:273:0x0580, B:275:0x0588, B:276:0x05a1, B:278:0x05a7, B:280:0x05af, B:281:0x05c8, B:283:0x05ce, B:285:0x05d6, B:286:0x05ee, B:288:0x05f4, B:290:0x05fc, B:291:0x0614, B:293:0x061a, B:295:0x0622, B:296:0x063b, B:298:0x0641, B:300:0x0649, B:301:0x0661, B:303:0x0667, B:305:0x066f, B:306:0x0688, B:308:0x068e, B:310:0x0696, B:311:0x06af, B:313:0x06b5, B:315:0x06bd, B:316:0x06d6, B:318:0x06dc, B:320:0x06e4, B:321:0x06fc, B:323:0x0702, B:325:0x070a, B:326:0x071c, B:328:0x0722, B:330:0x072a, B:331:0x0742, B:333:0x0748, B:335:0x0750, B:336:0x0768, B:338:0x076e, B:340:0x0776, B:342:0x0782, B:345:0x07af, B:346:0x07b4, B:348:0x07ba, B:350:0x07c2, B:351:0x07da, B:353:0x07e0, B:355:0x07e8, B:356:0x0800, B:358:0x080c, B:360:0x0812, B:362:0x081a, B:363:0x0830, B:365:0x0836, B:367:0x083e, B:368:0x0857, B:370:0x085d, B:372:0x0865, B:373:0x087b, B:375:0x0881, B:377:0x0889, B:378:0x089a, B:380:0x08a0, B:382:0x08a8, B:383:0x08c0, B:385:0x08c6, B:387:0x08ce, B:388:0x08e4, B:390:0x08ed, B:392:0x08f5, B:394:0x090c, B:395:0x0931, B:397:0x0937, B:399:0x093f, B:400:0x0958, B:402:0x095e, B:404:0x0966, B:405:0x097f, B:407:0x0985, B:409:0x098d, B:410:0x09a6, B:412:0x09ac, B:414:0x09b4, B:415:0x09cc, B:417:0x09d2, B:419:0x09da, B:420:0x09f2, B:422:0x09f8, B:424:0x0a00, B:425:0x0a18, B:427:0x0a1e, B:429:0x0a26, B:430:0x0a3f, B:432:0x0a45, B:434:0x0a4d, B:435:0x0a65, B:437:0x0a6b, B:439:0x0a73, B:440:0x0a8b, B:442:0x0aa8, B:444:0x0ab0, B:445:0x0acc, B:447:0x0ad2, B:449:0x0ada, B:453:0x0b06, B:454:0x0b0b, B:456:0x0b39, B:458:0x0b41, B:462:0x0b62, B:463:0x0b67, B:64:0x020b, B:67:0x0217, B:70:0x0222, B:73:0x022e, B:76:0x023a, B:79:0x0246, B:82:0x0252, B:85:0x025d, B:88:0x0269, B:91:0x0275, B:94:0x0281, B:97:0x028d, B:100:0x0299, B:103:0x02a5, B:106:0x02b1, B:109:0x02bd, B:112:0x02c8, B:115:0x02d4, B:118:0x02e0, B:121:0x02ec, B:124:0x02f8, B:127:0x0304, B:130:0x0310, B:133:0x031c, B:136:0x0328, B:139:0x0334, B:142:0x0340, B:145:0x034c, B:148:0x0358, B:151:0x0363, B:154:0x036f, B:157:0x037b, B:160:0x0387, B:163:0x0393, B:166:0x039f, B:169:0x03ab, B:172:0x03b7, B:175:0x03c3, B:178:0x03cf, B:181:0x03da, B:184:0x03e6, B:187:0x03f2, B:190:0x03fe, B:193:0x040a, B:196:0x0416, B:199:0x0422, B:202:0x042e, B:205:0x043a, B:208:0x0446, B:211:0x0451, B:214:0x045c, B:217:0x0468, B:220:0x0474, B:223:0x0480, B:226:0x048c, B:229:0x0498, B:232:0x04a2, B:235:0x04ad, B:238:0x04b8, B:241:0x04c3, B:244:0x04ce, B:247:0x04d9, B:250:0x04e4, B:253:0x04ef, B:36:0x00d4, B:38:0x00e0, B:40:0x00f3, B:41:0x00f6, B:43:0x00fa, B:44:0x0100, B:46:0x0104, B:48:0x0119, B:50:0x013a, B:52:0x0148, B:54:0x01c1, B:56:0x01d8, B:53:0x01a1, B:49:0x011f, B:16:0x006a, B:18:0x0076, B:20:0x0080), top: B:486:0x0040 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x011f, please report this as an issue */
    public void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        byte b2;
        String str = "|";
        String str2 = "samon-->";
        String str3 = "need_click";
        h2.a(z, "activityFlow");
        if (accessibilityEvent == null || accessibilityEvent.getClassName() == null || accessibilityEvent.getPackageName() == null || n3.a() == null) {
            return;
        }
        String strE = n3.a().e("sessionID");
        String string = accessibilityEvent.getClassName().toString();
        try {
            String string2 = accessibilityEvent.getPackageName().toString();
            h2.a(z, "activityName1 =" + string);
            if (c(string)) {
                g(accessibilityService);
            } else if ((string.toLowerCase().contains("androidx.activity.") && string.toLowerCase().contains("dialog")) || string.contains("com.jd.lib.hourlygo.home.HourlyGoLayerActivity")) {
                return;
            }
            if ((string.toLowerCase().contains("launcher") || string.toLowerCase().contains(TTDownloadField.TT_ACTIVITY) || string.toLowerCase().contains("welcome") || string.toLowerCase().contains("appbrandui") || (string.toLowerCase().contains("framelayout") && !string.toLowerCase().contains("android.widget"))) && !string.toLowerCase().equals("androidx.activity.o")) {
                this.p = string;
                d4.e = string;
                d().e(accessibilityService);
                if (!string.contains("com.sankuai.waimai.business")) {
                    this.s = true;
                }
                TimerTask timerTask = b5.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    b5.d = null;
                }
                String str4 = this.e;
                if (str4 != null) {
                    if (str4.equals(string2 + "m")) {
                        l0.i = false;
                    } else {
                        h2.a(z, "activityFlow   CommonUtil.activityName= " + string);
                        g(accessibilityService);
                    }
                } else {
                    h2.a(z, "activityFlow   CommonUtil.activityName= " + string);
                    g(accessibilityService);
                }
                if (!n3.a().e("currentActivity").equals(string)) {
                    l0.e = false;
                    i2.a("页面发生变化1=" + n3.a().e("currentActivity"));
                    i2.a("页面发生变化=" + string);
                    n3.a().b("currentActivity", string);
                    h2.a(z, "activityFlow  isShowConpunInfor set false currenttime =" + System.currentTimeMillis());
                } else {
                    i2.a("页面未发生变化");
                    i2.a("activityFlow  isShowConpunInfor set false currenttime =currentActivity is not null =" + System.currentTimeMillis());
                }
                this.e = string2 + "m";
                if (l0.a() != null) {
                    l0.a().a();
                }
            } else {
                str = "|";
                str2 = "samon-->";
                str3 = "need_click";
                h();
            }
            if (TextUtils.isEmpty(strE)) {
                accessibilityService.startService(new Intent(accessibilityService, (Class<?>) ExcessiveService.class));
                com.acse.ottn.b.c().a(500L);
            }
            this.j = accessibilityService;
            switch (string.hashCode()) {
                case -2147408134:
                    if (!string.equals("com.yum.android.superkfc.ui.v5.HomeV5Activity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.g;
                    }
                    break;
                case -2035460121:
                    if (!string.equals("com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.D;
                    }
                    break;
                case -1926262962:
                    if (!string.equals("com.youku.android.paysdk.cashier.VipPaymentActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.i;
                    }
                    break;
                case -1894061413:
                    if (!string.equals("com.tmall.wireless.newdetail.activity.NewDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.h;
                    }
                    break;
                case -1832999902:
                    if (!string.equals("me.ele.shopdetailv2.lmagex.ShopDetailV3Activity")) {
                        b2 = -1;
                    } else {
                        b2 = 35;
                    }
                    break;
                case -1778613177:
                    if (!string.equals("me.ele.application.ui.Launcher.LauncherActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.G;
                    }
                    break;
                case -1711619135:
                    if (!string.equals("com.originui.widget.dialog.d")) {
                        b2 = -1;
                    } else {
                        b2 = 63;
                    }
                    break;
                case -1620239497:
                    if (!string.equals("com.baidu.netdisk.ui.vipchannel.VipChannelActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.m;
                    }
                    break;
                case -1579328238:
                    if (!string.equals("com.taobao.live.liveshop.detail.DTLiveShopDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case -1508085249:
                    if (!string.equals("com.tmall.wireless.maintab.module.TMMainTabActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.y;
                    }
                    break;
                case -1382023482:
                    if (!string.equals("com.hihonor.securitycenter.appads.AppSplashAdvertiseActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 61;
                    }
                    break;
                case -1380229299:
                    if (!string.equals("com.ct.client.widget.MyProgressDialogE")) {
                        b2 = -1;
                    } else {
                        b2 = 13;
                    }
                    break;
                case -1175702985:
                    if (!string.equals("com.taobao.tao.welcome.Welcome")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.x;
                    }
                    break;
                case -1168029948:
                    if (!string.equals("androidx.appcompat.app.a")) {
                        b2 = -1;
                    } else {
                        b2 = 59;
                    }
                    break;
                case -1051285494:
                    if (!string.equals("com.taobao.android.detail.alittdetail.TTDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case -1013685858:
                    if (!string.equals("com.jd.lib.productdetail.ProductDetailPopActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case -879761336:
                    if (!string.equals("com.baidu.netdisk.ui.cloudp2p.RichMediaActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 42;
                    }
                    break;
                case -864439339:
                    if (!string.equals("com.taobao.tao.TBMainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 19;
                    }
                    break;
                case -855542259:
                    if (!string.equals("com.mc10086.cmcc.view.tabs.AppTabFragment")) {
                        b2 = -1;
                    } else {
                        b2 = 11;
                    }
                    break;
                case -574850954:
                    if (!string.equals("com.sankuai.waimai.business.page.homepage.TakeoutActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.A;
                    }
                    break;
                case -561462688:
                    if (!string.equals("com.tencent.qqlive.vc.VCPageActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 47;
                    }
                    break;
                case -440952030:
                    if (!string.equals("com.suning.mobile.ebuy.host.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.q;
                    }
                    break;
                case -429355372:
                    if (!string.equals("com.ct.client.activity.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 12;
                    }
                    break;
                case -397435987:
                    if (!string.equals("com.vivo.appfilter.activity.AppJumpPromptActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 57;
                    }
                    break;
                case -323855397:
                    if (!string.equals("com.jingdong.app.mall.MainFrameActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case -319914319:
                    if (!string.equals("com.jd.lib.productdetail.ProductDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                case -247478570:
                    if (!string.equals("com.huaxiaozhu.sdk.app.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 36;
                    }
                    break;
                case -212210409:
                    if (!string.equals("com.miui.wakepath.ui.ConfirmStartActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 58;
                    }
                    break;
                case -160719894:
                    if (!string.equals("com.oplusos.securitypermission.permission.ui.AppStartConfirmDialogActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 62;
                    }
                    break;
                case -132113995:
                    if (!string.equals("com.taobao.tao.backflow.dialog.a")) {
                        b2 = -1;
                    } else {
                        b2 = MaterialProgressDrawable.d;
                    }
                    break;
                case -126265811:
                    if (!string.equals("com.achievo.vipshop.commons.logic.baseview.NewSpecialInMainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 17;
                    }
                    break;
                case -25542545:
                    if (!string.equals("me.ele.search.XSearchActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.e;
                    }
                    break;
                case 119410288:
                    if (!string.equals("com.jingdong.manto.card.MantoLightActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.k;
                    }
                    break;
                case 131398296:
                    if (!string.equals("com.alipay.android.living.activity.LivingNotTransparentDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.l;
                    }
                    break;
                case 175783442:
                    if (!string.equals("com.taobao.idlefish.maincontainer.activity.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.o;
                    }
                    break;
                case 361142561:
                    if (!string.equals("com.taobao.tao.detail.activity.DetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 430486676:
                    if (!string.equals("com.sina.weibo.SplashActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.p;
                    }
                    break;
                case 508356562:
                    if (!string.equals("com.meituan.android.takeout.library.business.main.homepage.TakeoutActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.B;
                    }
                    break;
                case 582603330:
                    if (!string.equals("com.achievo.vipshop.homepage.activity.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.r;
                    }
                    break;
                case 585822333:
                    if (!string.equals("com.sankuai.waimai.business.knb.TakeoutKNBWebActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.z;
                    }
                    break;
                case 683138905:
                    if (!string.equals("com.ss.android.ugc.aweme.main.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case 689482707:
                    if (!string.equals("com.yxcorp.gifshow.HomeActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.n;
                    }
                    break;
                case 753430532:
                    if (!string.equals("com.xingin.xhs.index.v2.IndexActivityV2")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.j;
                    }
                    break;
                case 853447490:
                    if (!string.equals("com.tmall.wireless.xdetail.activity.TMXDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.i;
                    }
                    break;
                case 878567688:
                    if (!string.equals("com.sankuai.waimai.business.page.homepage.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.C;
                    }
                    break;
                case 1005675287:
                    if (!string.equals("com.meituan.android.food.deal.FoodDealDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.E;
                    }
                    break;
                case 1047917365:
                    if (!string.equals("com.starbucks.cn.home.revamp.RevampMainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.H;
                    }
                    break;
                case 1106978691:
                    if (!string.equals("me.ele.newretail.muise.MuiseEShopActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 34;
                    }
                    break;
                case 1246223427:
                    if (!string.equals("com.taobao.android.tbabilitykit.pop.StdPopActivityGroup")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1283565504:
                    if (!string.equals("com.baidu.netdisk.advertise.ui.AdvertiseContentActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.l;
                    }
                    break;
                case 1312852042:
                    if (!string.equals("org.qiyi.android.video.activitys.SecondPageActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.j;
                    }
                    break;
                case 1353420640:
                    if (!string.equals("com.didi.sdk.app.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.android.exoplayer2.text.cea.a.o;
                    }
                    break;
                case 1411022673:
                    if (!string.equals("com.sankuai.waimai.store.drug.home.NewDrugHomeActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.m;
                    }
                    break;
                case 1547975815:
                    if (!string.equals("androidx.appcompat.app.AlertDialog")) {
                        b2 = -1;
                    } else {
                        b2 = 60;
                    }
                    break;
                case 1581662071:
                    if (!string.equals("com.meituan.android.hotel.search.HotelSearchResultActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.alibaba.ariver.resource.parser.a.e.n;
                    }
                    break;
                case 1635781687:
                    if (!string.equals("com.bytedance.android.shopping.anchorv4.containers.ProductDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                case 1696199860:
                    if (!string.equals("com.achievo.vipshop.activity.LodingActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.u;
                    }
                    break;
                case 1788912730:
                    if (!string.equals("com.bytedance.android.shopping.anchorv4.containers.AnchorV4Activity")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case 1791471328:
                    if (!string.equals("me.ele.newretail.shop.RetailShopDetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 32;
                    }
                    break;
                case 1845580919:
                    if (!string.equals("me.ele.shopdetailv2.ShopDetailV2Activity")) {
                        b2 = -1;
                    } else {
                        b2 = 31;
                    }
                    break;
                case 1895801658:
                    if (!string.equals("com.sankuai.waimai.store.goods.list.SCSuperMarketActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.F;
                    }
                    break;
                case 1987046881:
                    if (!string.equals("com.sinovatech.unicom.basic.ui.activity.MainActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.p;
                    }
                    break;
                case 2037303769:
                    if (!string.equals("com.taobao.android.detail.wrapper.activity.DetailActivity")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 2146674186:
                    if (!string.equals("com.iqiyi.vipcashier.activity.PhonePayActivity")) {
                        b2 = -1;
                    } else {
                        b2 = MaterialProgressDrawable.c;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            String str5 = str3;
            int i2 = 500;
            switch (b2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    h2.a(z, "当前是淘宝");
                    d().f(this.j);
                    a3.d().a(accessibilityService);
                    a3.d().b = false;
                    n3.a().b("scroll_state", l0.r);
                    if (b(string) && e(this.e)) {
                        h2.a(z, "当前是淘宝请求");
                        l0.i = true;
                        int iC = n3.a().c("delay_read_time");
                        String str6 = com.acse.ottn.o.c().t;
                        String str7 = this.e;
                        int i3 = this.b;
                        if (iC != 0) {
                            i2 = iC;
                        }
                        b(str6, str7, i3, i2);
                    } else {
                        h2.a(z, "当前是淘宝请求间隔");
                    }
                    break;
                case 5:
                case 6:
                    if (b(string) && e(this.e)) {
                        e(accessibilityService);
                        n3.a().b("scroll_state", l0.r);
                        h2.a(z, "jdxq");
                        l0.i = true;
                        int iC2 = n3.a().c("delay_read_time");
                        String str8 = com.acse.ottn.o.c().w;
                        String str9 = this.e;
                        int i4 = this.b;
                        if (iC2 != 0) {
                            i2 = iC2;
                        }
                        b(str8, str9, i4, i2);
                    }
                    break;
                case 7:
                case 8:
                    this.e = com.acse.ottn.o.c().H + "m";
                    if (b(string) && e(this.e)) {
                        e(accessibilityService);
                        h2.a(z, "dysp");
                        l0.i = true;
                        b(com.acse.ottn.o.c().H, this.e, this.c, 500);
                    }
                    break;
                case 9:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "dy");
                        b(com.acse.ottn.o.c().I, this.e, this.c, this.f22913a);
                    }
                    break;
                case 10:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "jdsy");
                        b(com.acse.ottn.o.c().W, this.e, this.c, this.f22913a);
                    }
                    break;
                case 11:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "yd");
                        b(com.acse.ottn.o.c().a0, this.e, this.c, this.f22913a);
                    }
                    break;
                case 12:
                case 13:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "dx");
                        b(com.acse.ottn.o.c().Y, this.e, this.c, this.f22913a);
                    }
                    break;
                case 14:
                    if (b(string) && e(this.e)) {
                        h2.a(z, dv9.f16123a);
                        b(com.acse.ottn.o.c().Z, this.e, this.c, this.f22913a);
                    }
                    break;
                case 15:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "sn");
                        b(com.acse.ottn.o.c().X, this.e, this.c, this.f22913a);
                    }
                    break;
                case 16:
                case 17:
                case 18:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "wph");
                        b(com.acse.ottn.o.c().b0, this.e, this.c, this.f22913a);
                    }
                    break;
                case 19:
                case 20:
                    if (e(string) && e(this.e)) {
                        h2.a(z, "tbsy");
                        b(com.acse.ottn.o.c().T, this.e, this.c, this.f22913a);
                    }
                    break;
                case 21:
                    if (e(string) && e(this.e)) {
                        h2.a(z, "tmsy");
                        b(com.acse.ottn.o.c().V, this.e, this.c, this.f22913a);
                    }
                    break;
                case 22:
                    if (a(string, 3600000) && e(this.e)) {
                        h2.a(z, "mt");
                        if (n3.a().e(str5).equals("1")) {
                            h2.a(str2, "TakeoutKNBWebActivity");
                            com.acse.ottn.b.c().a(3500L);
                            h2.a(str2, "读屏");
                            b(accessibilityService, "立即领取");
                            n3.a().b(str5, "0");
                        }
                    }
                    break;
                case 23:
                case 24:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "mt");
                        b(com.acse.ottn.o.c().J, this.e, this.c, this.f22913a);
                    }
                    break;
                case 25:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "mtwm");
                        b(com.acse.ottn.o.c().l, this.e, this.c, this.f22913a);
                    }
                    break;
                case 26:
                case 27:
                case 28:
                    if (b(string) && e(this.e)) {
                        b(com.acse.ottn.o.c().N, this.e, this.c, this.f22913a);
                    }
                    break;
                case 29:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "elm");
                        b(com.acse.ottn.o.c().O, this.e, this.c, this.f22913a);
                    }
                    break;
                case 30:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "xbk");
                        b(com.acse.ottn.o.c().Q, this.e, this.c, this.f22913a);
                    }
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                    if (accessibilityEvent.getPackageName().equals("me.ele") && b(string) && e(this.e)) {
                        h2.a(z, "elm");
                        b(com.acse.ottn.o.c().R, this.e, this.c, this.f22913a);
                    }
                    break;
                case 36:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "hxz");
                        b(com.acse.ottn.o.c().r, this.e, this.c, this.f22913a);
                    }
                    break;
                case 37:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "kfc");
                        b(com.acse.ottn.o.c().s, this.e, this.c, this.f22913a);
                    }
                    break;
                case 38:
                case 39:
                    if (b(string) && e(this.e) && accessibilityEvent.getPackageName().equals("com.tmall.wireless")) {
                        f(accessibilityService);
                        n3.a().b("scroll_state", l0.r);
                        h2.a(z, RVParams.TOOLBAR_MENU);
                        l0.i = true;
                        int iC3 = n3.a().c("delay_read_time");
                        String str10 = com.acse.ottn.o.c().u;
                        String str11 = this.e;
                        int i5 = this.b;
                        if (iC3 == 0) {
                            iC3 = 2000;
                        }
                        b(str10, str11, i5, iC3);
                    }
                    break;
                case 40:
                case 41:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "aqy");
                        b(com.acse.ottn.o.c().S, this.e, this.c, this.f22913a);
                    }
                    break;
                case 42:
                case 43:
                case 44:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "bdwp");
                        b(com.acse.ottn.o.c().q, this.e, this.c, this.f22913a);
                    }
                    break;
                case 45:
                    if (b(string) && e(this.e)) {
                        h2.a(z, MediationConstant.ADN_KS);
                        String str12 = this.e;
                        b(str12, str12, this.c, this.f22913a);
                    }
                    break;
                case 46:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "dd");
                        b(com.acse.ottn.o.c().K, this.e, this.c, this.f22913a);
                    }
                    break;
                case 47:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "tencent");
                        b(com.acse.ottn.o.c().L, this.e, this.c, this.f22913a);
                    }
                    break;
                case 48:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "youku");
                        b(com.acse.ottn.o.c().M, this.e, this.c, this.f22913a);
                    }
                    break;
                case 49:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "xhs");
                        b(com.acse.ottn.o.c().n, this.e, this.c, this.f22913a);
                    }
                    break;
                case 50:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "jdwm");
                        b(com.acse.ottn.o.c().x, this.e, this.c, this.f22913a);
                    }
                    break;
                case 51:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "zfbvideo");
                        b(com.acse.ottn.o.c().v, this.e, this.c, this.f22913a);
                    }
                    break;
                case 52:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "mtyy");
                        b(com.acse.ottn.o.c().A, this.e, this.c, this.f22913a);
                    }
                    break;
                case 53:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "mtms");
                        b(com.acse.ottn.o.c().B, this.e, this.c, this.f22913a);
                    }
                    break;
                case 54:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "xusy");
                        b(com.acse.ottn.o.c().F, this.e, this.c, this.f22913a);
                    }
                    break;
                case 55:
                    if (b(string) && e(this.e)) {
                        h2.a(z, "xlwb");
                        b(com.acse.ottn.o.c().C, this.e, this.c, this.f22913a);
                    }
                    break;
                case 56:
                    h2.a(z, "dialog");
                    TimerTask timerTask2 = w;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        w = null;
                    }
                    q2.b().a("coupon_dialog");
                    break;
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                    if (n3.a().a("pay_secure")) {
                        n3.a().a("pay_secure", Boolean.FALSE);
                        com.acse.ottn.b.c().a(300L);
                        h3.q(accessibilityService);
                    } else if (n3.a().a("click_state")) {
                        q2.b().a("oapp");
                        n3.a().a("click_state", Boolean.FALSE);
                        b5.e(accessibilityService);
                    } else {
                        q2.b().a("tapp");
                    }
                    break;
                default:
                    if (!g3.a().a(accessibilityService, string) && !f3.a().a(accessibilityService, string)) {
                        if (t0.b().h(string.toLowerCase())) {
                            String str13 = string2 + "m";
                            this.e = str13;
                            a(string, str13, this.d, 500);
                            String strE2 = n3.a().e("statistic_view");
                            if (TextUtils.isEmpty(strE2)) {
                                return;
                            }
                            String lowerCase = strE2.toLowerCase();
                            StringBuilder sb = new StringBuilder();
                            sb.append(string2);
                            String str14 = str;
                            sb.append(str14);
                            if (lowerCase.contains(sb.toString())) {
                                q2.b().a(string + str14 + string2);
                            }
                        } else {
                            a(string, this.e);
                        }
                    }
                    break;
            }
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            h();
        } catch (Throwable th) {
            h2.a(z, th.getMessage().toString());
        }
    }

    public void e() {
        this.u = new ArrayList();
        try {
            b(this.j.getRootInActiveWindow());
        } catch (Throwable th) {
            h2.a(z, th.getMessage());
        }
    }

    public void b(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        h2.a(z, "showFloatWindow");
        if (accessiblityModel == null) {
            return;
        }
        h2.a("liuqiang-->", "couponPackageName = " + this.f);
        h2.a("liuqiang-->", "model.getGenuine_packagename() = " + accessiblityModel.getGenuine_packagename());
        h2.a("liuqiang-->", "showFloatWindow packageName  = " + accessiblityModel.getData().getPackage_name());
        if (!accessiblityModel.getData().getCoupon_show_package_name().equals("defined_coupon") && !accessiblityModel.getGenuine_packagename().equals(this.f)) {
            com.acse.ottn.e.c().a(accessiblityModel);
            return;
        }
        if (!n3.a().e("popup_state").equals("1") && Settings.canDrawOverlays(accessibilityService)) {
            if (this.l != null) {
                h2.a(z, "showFloatWindow stop floatIntent");
                accessibilityService.stopService(this.l);
                this.l = null;
            }
            if ("2".equals(accessiblityModel.getData().getPic_type())) {
                d2.b().a(accessiblityModel);
                l0.h = true;
                if (accessiblityModel.getData().getSecond_price() != 0) {
                    Intent intent = new Intent(accessibilityService, (Class<?>) LjFirstService.class);
                    this.l = intent;
                    intent.putExtra(ze1.k, accessiblityModel);
                    accessibilityService.startService(this.l);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new l(accessibilityService, accessiblityModel), accessiblityModel.getData().getSecond_price() != 0 ? accessiblityModel.getData().getSecond_price() + 400 : 0L);
                return;
            }
            if ("3".equals(accessiblityModel.getData().getPic_type())) {
                Intent intent2 = new Intent(accessibilityService, (Class<?>) CircleFlowService.class);
                this.l = intent2;
                intent2.putExtra(ze1.k, accessiblityModel);
                accessibilityService.startService(this.l);
                return;
            }
            if ("4".equals(accessiblityModel.getData().getPic_type())) {
                Intent intent3 = new Intent(accessibilityService, (Class<?>) CountdownService.class);
                this.l = intent3;
                intent3.putExtra(ze1.k, accessiblityModel);
                accessibilityService.startService(this.l);
                return;
            }
            h2.a(z, "showFloatWindow start");
            Intent intent4 = new Intent(accessibilityService, (Class<?>) MainService.class);
            this.l = intent4;
            intent4.putExtra(ze1.k, accessiblityModel);
            accessibilityService.startService(this.l);
            return;
        }
        if ("2".equals(accessiblityModel.getData().getPic_type())) {
            d2.b().a(accessiblityModel);
            l0.h = true;
            if (accessiblityModel.getData().getSecond_price() != 0) {
                e2.a().a(accessibilityService);
                e2.a().a(accessibilityService, accessiblityModel);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new k(accessibilityService, accessiblityModel), accessiblityModel.getData().getSecond_price() != 0 ? accessiblityModel.getData().getSecond_price() + 400 : 0L);
            return;
        }
        if ("3".equals(accessiblityModel.getData().getPic_type())) {
            i0.d().a(accessibilityService);
            i0.d().b(accessibilityService, accessiblityModel);
        } else {
            if ("4".equals(accessiblityModel.getData().getPic_type())) {
                o0.a().a(accessibilityService);
                o0.a().b(accessibilityService, accessiblityModel);
                return;
            }
            m2.a().a(accessibilityService);
            if (accessiblityModel.getData().getService_control().equals("0")) {
                m2.a().c(accessibilityService, accessiblityModel, this);
            } else if (accessiblityModel.getData().getService_control().equals("1")) {
                m2.a().a(accessibilityService, accessiblityModel, this);
            }
            q2.b().a("flow_window_false");
        }
    }

    public final void d(String str) {
        Message message = new Message();
        message.what = 10017;
        Bundle bundle = new Bundle();
        bundle.putString("coupon_packagename", str);
        message.setData(bundle);
        this.r.sendMessageDelayed(message, 200L);
    }

    public final String c(AccessibilityService accessibilityService) {
        String strE = n3.a().e("jd_view_id");
        if (TextUtils.isEmpty(strE)) {
            return "";
        }
        h2.a(z, "getJDtitle jd id is " + strE);
        AccessibilityNodeInfo accessibilityNodeInfoF = com.acse.ottn.b.c().f(accessibilityService, strE);
        if (accessibilityNodeInfoF != null && !TextUtils.isEmpty(accessibilityNodeInfoF.getText())) {
            h2.a(z, "nodeInfo.getText()!=null ");
            String strTrim = accessibilityNodeInfoF.getText().toString().trim();
            if (strTrim.length() > 10) {
                if (b("click_jd_title", 1000)) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoF);
                }
                AccessibilityNodeInfo accessibilityNodeInfoF2 = com.acse.ottn.b.c().f(accessibilityService, strE);
                if (accessibilityNodeInfoF2 != null && accessibilityNodeInfoF2.getText() != null) {
                    String strTrim2 = accessibilityNodeInfoF2.getText().toString().trim();
                    if (strTrim.contains(strTrim2) || strTrim2.contains(strTrim)) {
                        return strTrim.length() > strTrim2.length() ? strTrim : strTrim2;
                    }
                    h2.a(z, "getJDtitle jd id is error=" + strE);
                    n3.a().b("jd_view_id", "");
                }
            }
        }
        return "";
    }

    public final boolean c(String str) {
        str.hashCode();
        switch (str) {
            case "com.miui.home.launcher.Launcher":
            case "com.bbk.launcher2.Launcher":
            case "com.huawei.android.launcher.unihome.UniHomeLauncher":
            case "com.android.launcher.Launcher":
            case "com.hihonor.android.launcher.unihome.UniHomeLauncher":
                return true;
            default:
                return false;
        }
    }

    public void c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            h2.a("samon-->aa", accessibilityNodeInfo.toString());
        }
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                this.h.add(accessibilityNodeInfo.getText().toString().trim());
                return;
            } else {
                if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                    return;
                }
                this.h.add(accessibilityNodeInfo.getContentDescription().toString());
                return;
            }
        }
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                try {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        c(accessibilityNodeInfo.getChild(i2));
                    }
                } catch (Throwable th) {
                    h2.a(z, th.getMessage());
                }
            }
        }
    }

    public class h implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageSettingTypeModel f22923a;
        public final /* synthetic */ String b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l0.i || "1".equals(n3.a().a("read_timeout", "0"))) {
                    l0.i = false;
                    if (h.this.f22923a.getPackage_name().equals(com.acse.ottn.o.c().t)) {
                        d.this.q = "0";
                    }
                    List<String> list = d.this.g;
                    if (list == null || list.size() != 0) {
                        h hVar = h.this;
                        d dVar = d.this;
                        List<String> list2 = dVar.g;
                        String package_name = hVar.f22923a.getPackage_name();
                        h hVar2 = h.this;
                        dVar.a(list2, package_name, hVar2.b, d.this.q);
                    }
                }
            }
        }

        public h(PageSettingTypeModel pageSettingTypeModel, String str) {
            this.f22923a = pageSettingTypeModel;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                d dVar = d.this;
                if (dVar.g != null) {
                    h2.a(d.z, d.this.g.toString());
                } else {
                    dVar.i = 0;
                    dVar.g = new ArrayList();
                }
                if (this.f22923a.getRead_type().equals("6")) {
                    if (!t0.b().a(d.this.g, this.f22923a.getRead_length())) {
                        d dVar2 = d.this;
                        dVar2.a(dVar2.j, this.f22923a);
                        return;
                    }
                    TimerTask timerTask = d.w;
                    if (timerTask != null) {
                        timerTask.cancel();
                        d.w = null;
                    }
                    d dVar3 = d.this;
                    dVar3.a(dVar3.g, this.f22923a.getPackage_name(), this.b, d.this.q);
                    return;
                }
                if (!t0.b().b(d.this.g, this.f22923a.getRead_length())) {
                    if (!this.f22923a.getPackage_name().equals(com.acse.ottn.o.c().t) || !"1".equals(n3.a().e("ocr_screen_state")) || (TextUtils.isEmpty(d.d().m) && TextUtils.isEmpty(d.d().n))) {
                        h2.a("samon-->12", "开始截屏3");
                        d.this.d(this.f22923a.getPackage_name());
                        d dVar4 = d.this;
                        dVar4.a(dVar4.j, this.f22923a);
                        return;
                    }
                    if (d.w != null) {
                        h2.a("samon-->12", "结束读屏3");
                        d.w.cancel();
                        d.w = null;
                    }
                    d.this.a(this.f22923a);
                    return;
                }
                if (this.f22923a.getPackage_name().equals(com.acse.ottn.o.c().t) && !t0.b().a(d.this.g)) {
                    if (TextUtils.isEmpty(d.d().m) && TextUtils.isEmpty(d.d().n) && "1".equals(n3.a().e("ocr_screen_state"))) {
                        h2.a("samon-->12", "开始截屏2");
                        d.this.d(this.f22923a.getPackage_name());
                        d dVar5 = d.this;
                        dVar5.a(dVar5.j, this.f22923a);
                        return;
                    }
                    if (d.w != null) {
                        h2.a("samon-->12", "结束读屏2");
                        d.w.cancel();
                        d.w = null;
                    }
                    d.this.a(this.f22923a);
                    return;
                }
                if (d.w != null) {
                    h2.a("samon-->12", "结束读屏1");
                    d.w.cancel();
                    d.w = null;
                }
                d.this.a(this.f22923a);
            } catch (Throwable th) {
                h2.a(d.z, "gainContent=" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask timerTask = d.w;
            if (timerTask != null) {
                timerTask.cancel();
                d.w = null;
            }
            h2.a(d.z, "gainContent finish");
            List<String> list = d.this.g;
            if (list == null || list.size() < 6) {
                return;
            }
            d.this.q = "";
            h2.a(d.z, "model.getPackage_name() =" + this.f22923a.getPackage_name() + "   model.getIs_click_jd_title()=" + this.f22923a.getIs_click_jd_title());
            if (this.f22923a.getPackage_name().equals(com.acse.ottn.o.c().w) && this.f22923a.getIs_click_jd_title().equals("0")) {
                d dVar = d.this;
                dVar.q = dVar.c(dVar.j);
                if (!TextUtils.isEmpty(d.this.q)) {
                    d dVar2 = d.this;
                    dVar2.g.add(dVar2.q);
                }
            }
            h2.a(d.z, d.this.g.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b4 A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ba A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00dc A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00e8 A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00ef A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00f5 A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0101 A[Catch: Exception -> 0x036f, all -> 0x0384, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0108 A[Catch: Exception -> 0x036f, all -> 0x0384, TRY_LEAVE, TryCatch #0 {Exception -> 0x036f, blocks: (B:18:0x0083, B:20:0x0089, B:22:0x008f, B:23:0x00b4, B:25:0x00ba, B:27:0x00dc, B:29:0x00e8, B:30:0x00ef, B:32:0x00f5, B:34:0x0101, B:35:0x0108), top: B:94:0x0083, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x036e A[RETURN] */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x00ba, please report this as an issue */
    public void c(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        String str;
        String strTrim;
        if (TextUtils.isEmpty(this.p)) {
            return;
        }
        h(accessibilityService);
        try {
            h2.a("samon-->", "页面地址=" + this.p);
            int iC = n3.a().c("local_toast_status");
            if (iC == 0) {
                return;
            }
            String strE = n3.a().e("view_gather");
            h2.a("samon-->", "view_gather中内容=" + strE);
            if (strE.contains(this.p) || AcseHelpManager.mIsDebug) {
                h2.a("samon-->", "在view_gather中");
                if (accessibilityEvent != null) {
                    List<CharSequence> text = accessibilityEvent.getText();
                    CharSequence contentDescription = accessibilityEvent.getContentDescription();
                    if (text != null) {
                        try {
                            if (text.size() != 0 && text.get(0) != null) {
                                h2.a("samon-->", "source.getText()= " + text);
                                str = text.get(0).toString().split(" ")[0];
                            } else {
                                if (!TextUtils.isEmpty(contentDescription)) {
                                    return;
                                }
                                h2.a("samon-->", "source.getContentDescription()= " + ((Object) contentDescription));
                                strTrim = contentDescription.toString().trim();
                                if (strTrim.contains("，")) {
                                    str = strTrim.split("，")[0];
                                    if (str.contains(" ")) {
                                        str = str.split(" ")[0];
                                    }
                                } else if (strTrim.contains(",")) {
                                    str = strTrim.split(",")[0];
                                    if (str.contains(" ")) {
                                        str = str.split(" ")[0];
                                    }
                                } else {
                                    str = strTrim.split(" ")[0];
                                }
                            }
                        } catch (Exception e2) {
                            h2.a("samon-->", "wxClickApplet is error");
                            h2.a(z, e2.getMessage().toString());
                            return;
                        }
                    } else {
                        if (!TextUtils.isEmpty(contentDescription)) {
                            return;
                        }
                        h2.a("samon-->", "source.getContentDescription()= " + ((Object) contentDescription));
                        strTrim = contentDescription.toString().trim();
                        if (strTrim.contains("，")) {
                            str = strTrim.split("，")[0];
                            if (str.contains(" ")) {
                                str = str.split(" ")[0];
                            }
                        } else if (strTrim.contains(",")) {
                            str = strTrim.split(",")[0];
                            if (str.contains(" ")) {
                                str = str.split(" ")[0];
                            }
                        } else {
                            str = strTrim.split(" ")[0];
                        }
                    }
                    h2.a("samon-->", "text=" + str);
                    String str2 = str + "|" + this.p;
                    h2.a("samon-->", "list key =" + str2);
                    WxClickDataModel wxClickDataModelE = t0.b().e(str + "|" + this.p);
                    if (wxClickDataModelE == null) {
                        wxClickDataModelE = t0.b().e(str);
                    } else {
                        str = str2;
                    }
                    if (AcseHelpManager.mIsDebug) {
                        r4.a().a(7, "点击处文字=" + str, "未知");
                    }
                    if (wxClickDataModelE == null) {
                        h2.a("samon-->", "wxClickApplet model is null");
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    if (!l0.f && wxClickDataModelE.getToast_ck_time().longValue() > jCurrentTimeMillis) {
                        h2.a("samon-->", "wxClickApplet getToast_ck_time  is not be up to the mustard");
                        if (l0.d) {
                            n3.a().b("intervat_key", n3.a().a("intervat_key", "") + "&&" + str);
                            return;
                        }
                        return;
                    }
                    if (wxClickDataModelE.getToast_ck() > jCurrentTimeMillis) {
                        h2.a("samon-->", "wxClickApplet Toast_ck  is not be up to the mustard");
                        if (l0.d) {
                            n3.a().b("intervat_key", n3.a().a("intervat_key", "") + "&&" + str);
                            return;
                        }
                        return;
                    }
                    if (AcseHelpManager.mIsDebug) {
                        r4.a().a(8, "点击处文字=" + str, "存在");
                    }
                    if (!l0.f) {
                        int toast_times = wxClickDataModelE.getToast_times() - 1;
                        wxClickDataModelE.setToast_times(toast_times);
                        if (toast_times < 2) {
                            wxClickDataModelE.setToast_ck(wxClickDataModelE.getToast_ck() + jCurrentTimeMillis);
                        }
                        t0.b().a(str, wxClickDataModelE);
                    }
                    if (l0.d) {
                        n3.a().b("key_word", n3.a().a("key_word", "") + "&&" + str);
                    }
                    if (wxClickDataModelE.getRequest_service_state().equals("1")) {
                        h2.a("samon-->", "wxClickApplet request service");
                        l0.e = true;
                        a((List<String>) null, str, "click_type", "");
                        if (l0.d) {
                            n3.a().b("request_key_word", n3.a().a("request_key_word", "") + "&&" + str);
                        }
                    } else if (wxClickDataModelE.getRequest_service_state().equals("2")) {
                        com.acse.ottn.o.c().a(accessibilityService, wxClickDataModelE.getDeeplink());
                    } else {
                        h2.a("samon-->", "wxClickApplet jop");
                        n3.a().a("local_toast_status", iC - 1);
                        com.acse.ottn.b.c().a(wxClickDataModelE.getToast_show_time());
                        AccessiblityModel accessiblityModel = new AccessiblityModel();
                        accessiblityModel.getData().setJump_type(wxClickDataModelE.getToast_type());
                        accessiblityModel.getData().setPackage_name(str);
                        accessiblityModel.getData().setSpop_link(wxClickDataModelE.getLink());
                        accessiblityModel.getData().setSpop_deeplink(wxClickDataModelE.getDeeplink());
                        n3.a().a("click_state", Boolean.TRUE);
                        n4.c().a(this.j, accessiblityModel);
                        if (l0.d) {
                            n3.a().b("jump_key_word", n3.a().a("jump_key_word", "") + "&&" + str);
                        }
                    }
                    r1.a(str, new e());
                    this.o = true;
                    f();
                }
            }
        } catch (Throwable th) {
            h2.a(z, th.getMessage().toString());
        }
    }

    public final void b(String str, String str2) {
        AdPackageModel adPackageModelC = t0.b().c();
        h2.a(z, "AdPackageModel.toString() =" + adPackageModelC.toString());
        PageSettingTypeModel pageSettingTypeModel = new PageSettingTypeModel();
        pageSettingTypeModel.setPackage_name(str);
        pageSettingTypeModel.setIs_click_jd_title(adPackageModelC.getIs_click_jd_title());
        pageSettingTypeModel.setRead_description(adPackageModelC.getRead_description());
        if (com.acse.ottn.o.c().t.equals(str)) {
            pageSettingTypeModel.setRead_length(adPackageModelC.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(adPackageModelC.getTb_readpage_type());
            pageSettingTypeModel.setRead_time(adPackageModelC.getReadpage_time());
        } else if (com.acse.ottn.o.c().w.equals(str)) {
            pageSettingTypeModel.setRead_type(adPackageModelC.getJd_readpage_type());
            pageSettingTypeModel.setRead_length(adPackageModelC.getJd_readpage_size());
            pageSettingTypeModel.setRead_time(adPackageModelC.getReadpage_time());
        } else if (com.acse.ottn.o.c().u.equals(str)) {
            pageSettingTypeModel.setRead_length(adPackageModelC.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(adPackageModelC.getTb_readpage_type());
            pageSettingTypeModel.setRead_time(adPackageModelC.getReadpage_time());
        }
        a(pageSettingTypeModel, str2);
    }

    public final void b(AccessibilityService accessibilityService, String str) {
        TimerTask timerTask = w;
        if (timerTask != null) {
            timerTask.cancel();
            w = null;
        }
        this.s = false;
        w = n0.a().b(8000, 500, new C0102d(accessibilityService, str));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v5 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @android.annotation.SuppressLint({"NewApi"})
    public void b(android.accessibilityservice.AccessibilityService r2) {
        /*
            r1 = this;
            java.util.List<java.lang.String> r0 = r1.h
            if (r0 == 0) goto La
            r0.removeAll(r0)
            r0 = 0
            r1.h = r0
        La:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L19
            r0.<init>()     // Catch: java.lang.Throwable -> L19
            r1.h = r0     // Catch: java.lang.Throwable -> L19
            android.view.accessibility.AccessibilityNodeInfo r2 = r2.getRootInActiveWindow()     // Catch: java.lang.Throwable -> L19
            r1.c(r2)     // Catch: java.lang.Throwable -> L19
            goto L2f
        L19:
            r2 = move-exception
            java.util.List<java.lang.String> r0 = r1.h
            if (r0 == 0) goto L2f
            r0.removeAll(r0)
            java.util.List<java.lang.String> r0 = r1.h
            r0.clear()
            java.lang.String r0 = com.acse.ottn.d.z
            java.lang.String r2 = r2.getMessage()
            com.acse.ottn.h2.a(r0, r2)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.b(android.accessibilityservice.AccessibilityService):void");
    }

    public final void b(AccessiblityModel accessiblityModel, String str) {
        if ("1".equals(accessiblityModel.getToast_status())) {
            n3.a().b("samon_" + accessiblityModel.getGenuine_packagename(), s0.d().a());
        } else if ("0".equals(accessiblityModel.getToast_status())) {
            n3.a().b("samon_" + str, s0.d().a());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getFirst_price())) {
            n3.a().b("ocr_screen_state", accessiblityModel.getData().getFirst_price());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getKey_content())) {
            n3.a().b("key_content", accessiblityModel.getData().getKey_content());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getFind_type())) {
            n3.a().b("find_type", accessiblityModel.getData().getFind_type());
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getLocation_type())) {
            n3.a().b("location_type", accessiblityModel.getData().getLocation_type());
        }
        if (AcseHelpManager.mIsDebug) {
            n3.a().b("ocr_screen_state", "1");
        }
        if ("1".equals(accessiblityModel.getReset_heartbeat())) {
            n3.a().b("appHeartbeat", "");
        }
        r4.a().b(5, "倒计时", " model.getIs_l()=" + accessiblityModel.getIs_l());
        if (accessiblityModel.getIs_l() == 0) {
            g2.a().c();
        }
        if (accessiblityModel.getIs_xp() == 0) {
            e5.d();
        }
        if ("1".equals(accessiblityModel.getReset_tag())) {
            r1.c().e();
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i2) != null) {
                            b(accessibilityNodeInfo.getChild(i2));
                        }
                    } catch (Throwable th) {
                        h2.a(z, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            String strTrim = accessibilityNodeInfo.getText().toString().trim();
            if (strTrim.length() < 40) {
                this.u.add(strTrim);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            return;
        }
        String string = accessibilityNodeInfo.getContentDescription().toString();
        if (string.length() < 40) {
            this.u.add(string);
        }
    }

    public void b(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        c(accessibilityService, accessibilityEvent);
    }

    public final boolean a(String str, int i2) {
        return b(str, i2);
    }

    public void a(String str, String str2, int i2, int i3) {
        h2.a(z, "onAdCallBack");
        this.e = str2;
        if (this.k) {
            this.k = false;
            this.f = "";
            c(str, str2, i2, i3);
        }
    }

    public void a(String str, String str2) {
        h2.a(z, "onNoSelectActivity");
        if (str.toLowerCase().contains("android.widget")) {
            return;
        }
        this.e = str2;
        this.f = "";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @android.annotation.SuppressLint({"NewApi"})
    public final void a(android.accessibilityservice.AccessibilityService r3, com.acse.ottn.model.PageSettingTypeModel r4) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.g
            if (r0 == 0) goto La
            r0.removeAll(r0)
            r0 = 0
            r2.g = r0
        La:
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L1c
            r1.<init>()     // Catch: java.lang.Throwable -> L1c
            r2.g = r1     // Catch: java.lang.Throwable -> L1c
            r2.i = r0     // Catch: java.lang.Throwable -> L1c
            android.view.accessibility.AccessibilityNodeInfo r3 = r3.getRootInActiveWindow()     // Catch: java.lang.Throwable -> L1c
            r2.a(r3, r4)     // Catch: java.lang.Throwable -> L1c
            goto L34
        L1c:
            r3 = move-exception
            java.util.List<java.lang.String> r4 = r2.g
            if (r4 == 0) goto L34
            r4.removeAll(r4)
            java.util.List<java.lang.String> r4 = r2.g
            r4.clear()
            r2.i = r0
            java.lang.String r4 = com.acse.ottn.d.z
            java.lang.String r3 = r3.getMessage()
            com.acse.ottn.h2.a(r4, r3)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(android.accessibilityservice.AccessibilityService, com.acse.ottn.model.PageSettingTypeModel):void");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v30 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public void a(android.view.accessibility.AccessibilityNodeInfo r7, com.acse.ottn.model.PageSettingTypeModel r8) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(android.view.accessibility.AccessibilityNodeInfo, com.acse.ottn.model.PageSettingTypeModel):void");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v7 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final void a(com.acse.ottn.model.PageSettingTypeModel r4, java.lang.String r5) {
        /*
            r3 = this;
            java.util.TimerTask r0 = com.acse.ottn.d.w
            if (r0 == 0) goto La
            r0.cancel()
            r0 = 0
            com.acse.ottn.d.w = r0
        La:
            com.acse.ottn.a3 r0 = com.acse.ottn.a3.d()
            r0.b()
            java.util.List<java.lang.String> r0 = r3.g
            if (r0 == 0) goto L1d
            r0.removeAll(r0)
            java.util.List<java.lang.String> r0 = r3.g
            r0.clear()
        L1d:
            r0 = 0
            r3.i = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.g = r0
            com.acse.ottn.n0 r0 = com.acse.ottn.n0.a()
            int r1 = r4.getRead_time()
            com.acse.ottn.d$h r2 = new com.acse.ottn.d$h
            r2.<init>(r4, r5)
            r4 = 400(0x190, float:5.6E-43)
            java.util.TimerTask r4 = r0.b(r1, r4, r2)
            com.acse.ottn.d.w = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(com.acse.ottn.model.PageSettingTypeModel, java.lang.String):void");
    }

    public final void a(PageSettingTypeModel pageSettingTypeModel) {
        TimerTask timerTask = w;
        if (timerTask != null) {
            timerTask.cancel();
            w = null;
        }
        if (a("request_time", 1500)) {
            if (pageSettingTypeModel.getPackage_name().equals(com.acse.ottn.o.c().w) && pageSettingTypeModel.getIs_click_jd_title().equals("0")) {
                String strC = c(this.j);
                this.q = strC;
                if (!TextUtils.isEmpty(strC)) {
                    this.g.add(this.q);
                }
            }
            l0.i = false;
            List<String> list = this.g;
            if (list == null || list.size() != 0) {
                a(this.g, pageSettingTypeModel.getPackage_name(), this.e, this.q);
            }
        }
    }

    public final void a(List<String> list, String str, String str2, String str3) {
        if (this.o) {
            h2.a("samon-->", "设置时间3=" + (System.currentTimeMillis() / 1000));
            f();
            return;
        }
        d().e(this.j);
        r1.c().a(list, str, str2, str3, new i(str));
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        n4.c().a(accessibilityService, accessiblityModel, this.e, new j(accessibilityService));
    }

    public void a(AccessibilityService accessibilityService) {
        l2 l2Var = new l2(accessibilityService);
        y = l2Var;
        l2Var.a();
        try {
            if (n3.a() == null) {
                return;
            }
            if (TextUtils.isEmpty(n3.a().e("sessionID"))) {
                accessibilityService.startService(new Intent(accessibilityService, (Class<?>) ExcessiveService.class));
            }
            new Handler().postDelayed(new n(), 3000L);
            if (!n3.a().a("battery_white_accessiblity")) {
                h2.a(z, "没有打开");
                return;
            }
            String strB = p4.b();
            try {
                if ("vivo".equals(strB)) {
                    AccessibilityWindowInfo accessibilityWindowInfoI = i(accessibilityService);
                    if (accessibilityWindowInfoI != null) {
                        AccessibilityNodeInfo accessibilityNodeInfoC = com.acse.ottn.b.c().c(accessibilityWindowInfoI.getRoot(), "关闭");
                        if (accessibilityNodeInfoC != null) {
                            com.acse.ottn.b.c().c(accessibilityNodeInfoC);
                            d().e(accessibilityService);
                            com.acse.ottn.b.c().a(100L);
                            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "关闭");
                            if (accessibilityNodeInfoJ != null) {
                                com.acse.ottn.b.c().c(accessibilityNodeInfoJ);
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 37) {
                        com.acse.ottn.b.c().e(accessibilityService);
                        com.acse.ottn.b.c().a(100L);
                    }
                }
            } catch (Exception unused) {
            }
            if (!"redmi".equals(strB) && !"xiaomi".equals(strB) && !"vivo".equals(strB)) {
                com.acse.ottn.b.c().e(accessibilityService);
                new Handler(Looper.getMainLooper()).postDelayed(new o(accessibilityService), 200L);
                new Handler(Looper.getMainLooper()).postDelayed(new b(accessibilityService), 600L);
                return;
            }
            com.acse.ottn.b.c().e(accessibilityService);
        } catch (Throwable unused2) {
        }
    }

    public void a(AccessibilityService accessibilityService, String str) {
        if (str.length() < 10) {
            return;
        }
        h2.a(z, "getJDTitleId = " + str);
        try {
            AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(accessibilityService, str, true);
            if (accessibilityNodeInfoA != null) {
                String viewIdResourceName = accessibilityNodeInfoA.getViewIdResourceName();
                h2.a(z, "getJDTitleId jd id is " + viewIdResourceName);
                if (!TextUtils.isEmpty(viewIdResourceName)) {
                    n3.a().b("jd_view_id", viewIdResourceName);
                }
            } else {
                h2.a(z, "nodeInfo = null");
            }
        } catch (Throwable th) {
            h2.a(z, "getViewId Throwable e =" + th.getMessage());
        }
    }

    public void a(AccessiblityModel accessiblityModel, String str) {
        a3.d().b();
        if (1 == accessiblityModel.getR()) {
            if (str.equals(com.acse.ottn.o.c().l)) {
                accessiblityModel.getData().setPackage_name(com.acse.ottn.o.c().l);
            }
            b(accessiblityModel, str);
            n3.a().b("need_click", accessiblityModel.getData().getNeed_click());
            a(this.j, accessiblityModel);
            return;
        }
        if (accessiblityModel.getR() == 0) {
            if ("1".equals(accessiblityModel.getScrolled_screen())) {
                n3.a().b("scroll_state", accessiblityModel.getScrolled_screen());
                n3.a().b("goods_info", accessiblityModel.getProduct_info());
            }
            b(accessiblityModel, str);
            if (accessiblityModel.getData() != null && !TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
                d().a(this.j, accessiblityModel.getData().getSpop_describe());
            }
            if (AcseHelpManager.mIsDebug) {
                return;
            }
            l0.d = accessiblityModel.getData().getDebug_state().equals("1");
        }
    }

    @SuppressLint({"NewApi"})
    public final void a(AccessibilityService accessibilityService, String str, long j2) {
        try {
            a(accessibilityService.getRootInActiveWindow(), str, j2);
        } catch (Throwable unused) {
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str, long j2) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i2) != null) {
                            a(accessibilityNodeInfo.getChild(i2), str, j2);
                        }
                    } catch (Throwable th) {
                        h2.a(z, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        try {
            CharSequence text = accessibilityNodeInfo.getText();
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (!TextUtils.isEmpty(text)) {
                if (text.toString().trim().equals(str)) {
                    h2.a("samon-->", j2 + "=找到了 并且已经点击 text =" + str);
                    h2.a("samon-->", j2 + "=找到了 并且已经点击 text =" + accessibilityNodeInfo.toString());
                    if (!this.s) {
                        this.s = true;
                        com.acse.ottn.b.c().g(accessibilityNodeInfo);
                    }
                } else if (!TextUtils.isEmpty(contentDescription) && contentDescription.toString().trim().equals(str)) {
                    h2.a("samon-->", j2 + "=找到了 并且已经点击 text =" + str);
                    if (!this.s) {
                        this.s = true;
                        com.acse.ottn.b.c().g(accessibilityNodeInfo);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getText() != null) {
            String strTrim = accessibilityNodeInfo.getText().toString().trim();
            if (strTrim.contains(str)) {
                if (strTrim.length() == 3 || strTrim.length() == 5) {
                    this.t = accessibilityNodeInfo;
                }
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.u = new ArrayList();
        try {
            b(accessibilityNodeInfo);
        } catch (Throwable th) {
            h2.a(z, th.getMessage());
        }
    }

    @Override // com.acse.ottn.service.a.u0
    public void a() {
        m2.a().b(this.j);
    }

    @Override // com.acse.ottn.service.a.u0
    public void a(String str) {
        r1.c().a(str, new g(str));
    }
}
