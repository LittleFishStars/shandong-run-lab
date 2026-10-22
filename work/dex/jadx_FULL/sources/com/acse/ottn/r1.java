package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.zj.adlib.t24;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static r1 f23147a = null;
    public static String b = "HttpUtil";

    public class a implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f23148a;

        public a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f23148a = onIndividuationCallBack;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f23148a.onIndividuationState(true);
            h2.b("ShopHelperService", "报错了=" + th.getMessage());
        }
    }

    public class a0 implements Consumer<Throwable> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class b implements Consumer<String> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("r") != 1) {
                    return;
                }
                n3.a().b("tag_homepage_info", jSONObject.getString("data"));
            } catch (Throwable unused) {
            }
        }
    }

    public class b0 implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f23150a;

        public b0(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f23150a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") != 1) {
                AcseHelpManager.OnOpenPermission onOpenPermission = this.f23150a;
                if (onOpenPermission != null) {
                    onOpenPermission.openPermission(false);
                    return;
                }
                return;
            }
            n3.a().b("oppo_state", jSONObject.getString("oppo_state"));
            if (jSONObject.getInt("open_plugin_permission") == 1) {
                AcseHelpManager.OnOpenPermission onOpenPermission2 = this.f23150a;
                if (onOpenPermission2 != null) {
                    onOpenPermission2.openPermission(true);
                    return;
                }
                return;
            }
            AcseHelpManager.OnOpenPermission onOpenPermission3 = this.f23150a;
            if (onOpenPermission3 != null) {
                onOpenPermission3.openPermission(false);
            }
        }
    }

    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(t24.f44832a, "报错了=" + th.getMessage());
        }
    }

    public class c0 implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f23152a;

        public c0(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f23152a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f23152a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(false);
            }
        }
    }

    public class d implements Consumer<String> {
        public d() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 1) {
                n3.a().b("tag_homepage_info", jSONObject.getString("data"));
            } else {
                n3.a().b("tag_homepage_info", "");
            }
        }
    }

    public class d0 implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f23154a;

        public d0(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f23154a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f23154a != null) {
                if (jSONObject.getInt("r") == 1) {
                    this.f23154a.openPermission(AcseHelpManager.isOpenAccessiblityPermission());
                } else {
                    this.f23154a.openPermission(true);
                }
            }
        }
    }

    public class e implements Consumer<Throwable> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(t24.f44832a, "报错了=" + th.getMessage());
        }
    }

    public class e0 implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f23156a;

        public e0(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f23156a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f23156a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(AcseHelpManager.isOpenAccessiblityPermission());
            }
        }
    }

    public class f implements Consumer<AccessiblityModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23157a;
        public final /* synthetic */ i0 b;

        public f(String str, i0 i0Var) {
            this.f23157a = str;
            this.b = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            h2.a(r1.b, "请求成功 string =" + accessiblityModel.toString());
            r4.a().b(2, this.f23157a, " r =" + accessiblityModel.getR());
            i0 i0Var = this.b;
            if (i0Var != null) {
                i0Var.a(accessiblityModel);
            }
            n3.a().a("coupon_request_time", 0L);
        }
    }

    public class f0 implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23158a;

        public f0(String str) {
            this.f23158a = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            o1.c().a(this.f23158a);
        }
    }

    public class g implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23159a;

        public g(i0 i0Var) {
            this.f23159a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(r1.b, "报错了=" + th.getMessage());
            i0 i0Var = this.f23159a;
            if (i0Var != null) {
                i0Var.a(th.getMessage());
            }
        }
    }

    public class g0 implements Consumer<Throwable> {
        public g0() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class h implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23161a;

        public h(i0 i0Var) {
            this.f23161a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            int i = new JSONObject(str).getInt("r");
            i0 i0Var = this.f23161a;
            if (i0Var != null) {
                if (i == 1) {
                    i0Var.a((AccessiblityModel) null);
                } else {
                    i0Var.a((String) null);
                }
            }
        }
    }

    public class h0 implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f23162a;

        public h0(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f23162a = onIndividuationCallBack;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (new JSONObject(str).getInt("state") == 1) {
                this.f23162a.onIndividuationState(true);
            } else {
                this.f23162a.onIndividuationState(false);
            }
        }
    }

    public class i implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23163a;

        public i(i0 i0Var) {
            this.f23163a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            i0 i0Var = this.f23163a;
            if (i0Var != null) {
                i0Var.a((String) null);
            }
        }
    }

    public interface i0 {
        void a(AccessiblityModel accessiblityModel);

        void a(String str);
    }

    public class j implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23164a;

        public j(i0 i0Var) {
            this.f23164a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("r");
            i0 i0Var = this.f23164a;
            if (i0Var != null) {
                if (i != 1) {
                    i0Var.a((String) null);
                    return;
                }
                int i2 = jSONObject.getInt("state");
                AccessiblityModel accessiblityModel = new AccessiblityModel();
                accessiblityModel.setRed_package(i2);
                this.f23164a.a(accessiblityModel);
            }
        }
    }

    public interface j0 {
        void a(int i, int i2);
    }

    public class k implements Consumer<String> {
        public k() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    public interface k0 {
        void onSuccess(String str);
    }

    public class l implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23166a;

        public l(i0 i0Var) {
            this.f23166a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            i0 i0Var = this.f23166a;
            if (i0Var != null) {
                i0Var.a((String) null);
            }
        }
    }

    public class m implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23167a;

        public m(i0 i0Var) {
            this.f23167a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (new JSONObject(str).getInt("r") == 1) {
                this.f23167a.a((AccessiblityModel) null);
            } else {
                this.f23167a.a((String) null);
            }
        }
    }

    public class n implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f23168a;

        public n(i0 i0Var) {
            this.f23168a = i0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            i0 i0Var = this.f23168a;
            if (i0Var != null) {
                i0Var.a((String) null);
            }
        }
    }

    public class o implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f23169a;

        public o(k0 k0Var) {
            this.f23169a = k0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            k0 k0Var = this.f23169a;
            if (k0Var != null) {
                k0Var.onSuccess(str);
            }
        }
    }

    public class p implements Consumer<Throwable> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class q implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f23170a;

        public q(j0 j0Var) {
            this.f23170a = j0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("r");
            int i2 = jSONObject.getInt("code");
            j0 j0Var = this.f23170a;
            if (j0Var != null) {
                j0Var.a(i, i2);
            }
        }
    }

    public class r implements Consumer<Throwable> {
        public r() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class s implements Consumer<String> {
        public s() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            t0.b().k(str);
        }
    }

    public class t implements Consumer<Throwable> {
        public t() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            Log.d("updateProject", "throwable =" + th.getMessage());
        }
    }

    public class u implements Consumer<String> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            Log.d("vivoPermissionPiction", "string =" + str);
        }
    }

    public class v implements Consumer<Throwable> {
        public v() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class w implements Consumer<Throwable> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class x implements Consumer<String> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            n3.a().b("auto_start", jSONObject.getString("auto_start"));
            n3.a().b("relevancy_start", jSONObject.getString("relevancy_start"));
            n3.a().b("service_show_view", jSONObject.getString("service_show_view"));
        }
    }

    public class y implements Consumer<Throwable> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class z implements Consumer<String> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    public static r1 c() {
        if (f23147a == null) {
            synchronized (r1.class) {
                if (f23147a == null) {
                    f23147a = new r1();
                }
            }
        }
        return f23147a;
    }

    public static void f() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", n3.a().e("getSystemVersion"));
        new com.acse.ottn.g0().q(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new x(), new y());
    }

    public void b() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", n3.a().e("getSystemVersion"));
        treeMap.put("plunin_version", "0");
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("is_snt", "0");
        new com.acse.ottn.g0().e(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new k(), new v());
    }

    public final Object d() throws ObjectStreamException {
        return f23147a;
    }

    public void e() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put(RequestParameters.MARKER, HelpShopAppUtil.sessionExID());
        treeMap.put("new_version", l0.m);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new l1().a(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new d(), new e());
    }

    public void g() {
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("version", com.acse.ottn.f0.f);
        treeMap.put("mobile_id", p4.o());
        treeMap.put("mobile", p4.b());
        treeMap.put("mobile_version_release", l0.A);
        treeMap.put("app_versione", l0.z);
        treeMap.put("app_system_model", p4.d());
        treeMap.put("device_product", p4.j());
        treeMap.put("time", System.currentTimeMillis() + "");
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_model", p4.p());
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new v0().a(t0.b().a(treeMap)).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new s(), new t());
    }

    public void a(Activity activity, AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", p4.q());
        treeMap.put("harmonyDisplayVersion", p4.e());
        treeMap.put("accessiblity_state", com.acse.ottn.b.c().e() ? "1" : "0");
        treeMap.put("flow_window_state", Settings.canDrawOverlays(activity) ? "1" : "0");
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        if (activity != null) {
            treeMap.put("plunin_version", w1.a().a((Context) activity).getVersion());
        }
        treeMap.put("is_snt", "0");
        new com.acse.ottn.g0().l(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new b0(onOpenPermission), new c0(onOpenPermission));
    }

    public static void c(String str) {
        n3.a().b("sys_dialog_text", "");
        TreeMap treeMap = new TreeMap();
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", n3.a().e("getSystemVersion"));
        treeMap.put("state", str);
        new com.acse.ottn.g0().m(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new z(), new a0());
    }

    public void b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put(RequestParameters.MARKER, HelpShopAppUtil.sessionExID());
        treeMap.put("new_version", l0.m);
        treeMap.put(NativeCallContext.DOMAIN_APP, str);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new l1().b(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new b(), new c());
    }

    public void a(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", n3.a().e("getSystemVersion"));
        treeMap.put("plunin_version", w1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new com.acse.ottn.g0().h(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new d0(onOpenPermission), new e0(onOpenPermission));
    }

    public static void b(String str, String str2, i0 i0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("username", str);
        treeMap.put("password", str2);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new l1().l(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new h(i0Var), new i(i0Var));
    }

    public void a(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("version", w1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        treeMap.put("state", str);
        new com.acse.ottn.g0().d(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new f0(str), new g0());
    }

    public void a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        new com.acse.ottn.g0().o(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new h0(onIndividuationCallBack), new a(onIndividuationCallBack));
    }

    public void a(List<String> list, String str, String str2, String str3, i0 i0Var) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("ak", HelpShopAppUtil.getHmKey());
            treeMap.put(NativeCallContext.DOMAIN_APP, str);
            HelpShopAppUtil.getInstance();
            treeMap.put(RequestParameters.MARKER, HelpShopAppUtil.sessionExID());
            if (list != null) {
                String jSONString = JSON.toJSONString(list);
                if (l0.d) {
                    n3.a().b("title_data", jSONString);
                }
                treeMap.put("data", jSONString);
            } else {
                n3.a().b("title_data", "");
                treeMap.put("data", "");
            }
            treeMap.put("title", str3);
            treeMap.put("tb_title_pic", com.acse.ottn.d.d().m);
            treeMap.put("tb_title_pic_by", com.acse.ottn.d.d().n);
            treeMap.put("new_version", l0.m);
            treeMap.put("coupon_type", t0.b().j(str));
            treeMap.put("genuine_packagename", str2);
            treeMap.put("device_brand", p4.b());
            treeMap.put("current_system_time", System.currentTimeMillis() + "");
            treeMap.put("is_snt", l0.m);
            treeMap.put("version", p4.r());
            treeMap.put("maven_version", com.acse.ottn.f0.f);
            treeMap.put("flow_permission", com.acse.ottn.b.c().a() ? "1" : "0");
            treeMap.put("mobile", p4.b());
            treeMap.put("mobile_version_release", l0.A);
            treeMap.put("lon", n3.a().e("longitude"));
            treeMap.put("lat", n3.a().e("latitude"));
            treeMap.put("loca_type", n3.a().e("location_state"));
            treeMap.put("is_open_adb", p4.d(HelpShopAppUtil.getContext()) ? "1" : "0");
            treeMap.put("accession_size", n3.a().c("accession_size") + "");
            treeMap.put("is_ist_xp", n3.a().a("xposed_state") ? "1" : "0");
            treeMap.put("is_debug", "0");
            treeMap.put("is_developermode_enabled", p4.e(HelpShopAppUtil.getContext()) ? "1" : "0");
            if (list != null) {
                h2.a(b, "getCouponInfo string =" + JSON.toJSONString(list));
            }
            new l1().c(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new f(str, i0Var), new g(i0Var));
            return;
        }
        h2.a(b, "isShowConpunInfor is " + l0.e);
    }

    public static void a(i0 i0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("secret", "abwvAq57vugUhUcTvDAVXWWV1gaqoNQA");
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new l1().e(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new j(i0Var), new l(i0Var));
    }

    public static void a(String str, String str2, i0 i0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("secret", "abwvAq57vugUhUcTvDAVXWWV1gaqoNQA");
        treeMap.put("password", str);
        treeMap.put("state", str2);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        new l1().k(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new m(i0Var), new n(i0Var));
    }

    public static void a(String str, k0 k0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(NativeCallContext.DOMAIN_APP, str);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        new l1().g(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new o(k0Var), new p());
    }

    public void a(String str, j0 j0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", "coupon");
        treeMap.put("is_snt", "0");
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("package_name", str);
        new com.acse.ottn.g0().i(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new q(j0Var), new r());
    }

    public static void a(String str, String str2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("pic", str);
        treeMap.put("maven_version", com.acse.ottn.f0.f);
        treeMap.put("pic_effect", str2);
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("device_manufacturer", p4.i());
        treeMap.put("device_product", p4.j());
        treeMap.put("device_brand", p4.b());
        treeMap.put("system_model", p4.p());
        treeMap.put("device_board", p4.a());
        treeMap.put("device_device", p4.d());
        treeMap.put("device_fubgerprint", p4.f());
        treeMap.put("device_SDK", p4.k() + "");
        treeMap.put("system_version", n3.a().e("getSystemVersion"));
        new com.acse.ottn.g0().p(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new u(), new w());
    }
}
