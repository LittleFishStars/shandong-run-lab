package com.acse.ottn;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.igexin.assist.util.AssistUtils;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q2 f23139a;
    public static Activity b;

    public class a implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23140a;
        public final /* synthetic */ c b;

        public a(String str, c cVar) {
            this.f23140a = str;
            this.b = cVar;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            h2.a("MobclickAgentUtil", "统计发送成功 ==" + this.f23140a);
            if ("heart_beat".equals(this.f23140a)) {
                JSONObject jSONObject = new JSONObject(str);
                l0.e = true;
                n3.a().b("appHeartbeat", s0.d().a());
                n3.a().b(LiteEncryptUtils.KEY_AES, jSONObject.getString(LiteEncryptUtils.KEY_AES));
                n3.a().b("show_ad_activity", str);
                h2.a("MobclickAgentUtilsamon", "s= ==" + str);
                n3.a().b("ocr_screen_scroll", jSONObject.getString("ocr_screen_scroll"));
                n3.a().b("statistic_view", jSONObject.getString("statistic_view"));
                n3.a().b("applet_data", jSONObject.getString("local_toast_info"));
                n3.a().a("local_toast_status", jSONObject.getInt("local_toast_status"));
                n3.a().b("view_gather", jSONObject.getString("view_gather"));
                n3.a().b("popup_state", jSONObject.getString("popup_state"));
                l0.f = jSONObject.getString("custom_version").equals("1");
                l0.g = jSONObject.getString("set_special_tag").equals("1");
                q2.this.f();
                q2.this.c();
                d.d().o = false;
                try {
                    if (!"xiaomi".equals(p4.b()) && !AcseHelpManager.mIsDebug) {
                        r1.c().g();
                    }
                } catch (Exception unused) {
                }
                n3.a().b("notification_control", jSONObject.getString("notification_control"));
                if (jSONObject.getString("app_list").equals("1")) {
                    n3.a().a("click_state", Boolean.TRUE);
                    try {
                        if (!AssistUtils.BRAND_HON.equals(p4.b())) {
                            o.c().b();
                        }
                    } catch (Throwable unused2) {
                    }
                }
                c cVar = this.b;
                if (cVar != null) {
                    cVar.a();
                }
                h2.a("MobclickAgentUtil", "appStatistics s= " + str);
            }
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.a("MobclickAgentUtil", "统计发送失败 throwable =" + th.getMessage());
        }
    }

    public interface c {
        void a();
    }

    public static q2 b() {
        if (f23139a == null) {
            synchronized (q2.class) {
                if (f23139a == null) {
                    f23139a = new q2();
                }
            }
        }
        return f23139a;
    }

    public static boolean d() {
        if (g3.a().d()) {
            return com.acse.ottn.b.c().e() && com.acse.ottn.b.c().a() && d5.a().b(l0.y);
        }
        return true;
    }

    public void a(Activity activity) {
        b = activity;
    }

    public void c() {
        int i;
        String string;
        int i2 = 0;
        n3.a().a("accession_size", 0);
        try {
            i = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e) {
            h2.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e.getMessage());
            i = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(com.google.common.net.c.b);
        if (i != 1 || (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) == null) {
            return;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().contains(".service.ShopHelperService")) {
                i2++;
                n3.a().a("accession_size", i2);
            }
        }
    }

    public final Object e() throws ObjectStreamException {
        return f23139a;
    }

    public void f() {
        n3.a().b("request_key_word", "");
        n3.a().b("jump_key_word", "");
        n3.a().b("key_word", "");
        n3.a().b("intervat_key", "");
    }

    public void a(String str) {
        if (n3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, null, null);
    }

    public static Map<String, String> a(String str, String str2) {
        if (n3.a() == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("open_all_permission", d() ? "1" : "0");
        treeMap.put("flow_permission", com.acse.ottn.b.c().a() ? "1" : "0");
        treeMap.put("accessiblity_permission", com.acse.ottn.b.c().e() ? "1" : "0");
        treeMap.put("battery_permission", d5.a().b(l0.y) ? "1" : "0");
        treeMap.put("statistics_type", str);
        treeMap.put("mobile_id", p4.o());
        if ("heart_beat".equals(str)) {
            treeMap.put("is_snt", "3");
        } else {
            treeMap.put("is_snt", "0");
        }
        if (!TextUtils.isEmpty(str2)) {
            treeMap.put("accessiblity_list", str2);
        }
        treeMap.put("maven_version", f0.f);
        treeMap.put("mobile", p4.b());
        treeMap.put("mobile_version_release", l0.A);
        treeMap.put("app_versione", l0.z);
        treeMap.put("app_system_model", p4.d());
        treeMap.put("time", System.currentTimeMillis() + "");
        treeMap.put("system_model", p4.p());
        treeMap.put("new_version", l0.m);
        return treeMap;
    }

    public void b(String str, String str2) {
        if (n3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, str2, null);
    }

    public void b(String str, String str2, c cVar) {
        if (n3.a() == null || TextUtils.isEmpty(HelpShopAppUtil.getHmKey())) {
            return;
        }
        HelpShopAppUtil.getInstance();
        if (TextUtils.isEmpty(HelpShopAppUtil.sessionExID())) {
            return;
        }
        a(str, str2, cVar);
    }

    public final void a(String str, String str2, c cVar) {
        h2.a("MobclickAgentUtil", "埋点");
        if (n3.a() == null) {
            return;
        }
        new g0().a(t0.b().a(a(str, str2), str)).u5(Schedulers.newThread()).G3(i.a()).s5(new a(str, cVar), new b());
    }

    public void a() {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) HelpShopAppUtil.getContext().getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String str = accessibilityServiceInfo.getResolveInfo().serviceInfo.name;
            String str2 = accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName;
            arrayList.add("应用名称：" + accessibilityServiceInfo.getResolveInfo().loadLabel(HelpShopAppUtil.getContext().getPackageManager()).toString() + "--->app包名：" + str2 + "---->service路径：" + str);
        }
        b().b("accessiblity_list", JSON.toJSONString(arrayList));
    }
}
