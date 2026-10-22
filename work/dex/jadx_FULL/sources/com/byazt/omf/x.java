package com.byazt.omf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alipay.mobile.jsengine.BuildConfig;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.hv.TTDownloadField;
import com.byazt.nys.PluginConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 71})
public class x {
    public static final com.byazt.dj.uj c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f28890a;
    public com.byazt.ab.uj aw;
    public boolean bx;
    public volatile String cu;
    public int d;
    public volatile boolean da;
    public long eo;
    public HashMap<String, Object> gr;
    public Function<SparseArray<Object>, Object> gt;
    public volatile JSONObject gu;
    public int h;
    public volatile int i;
    public String ic;
    public String m;
    public int md;
    public volatile boolean my;
    public volatile String n;
    public volatile boolean nb;
    public String nu;
    public boolean or;
    public volatile Function<SparseArray<Object>, Object> p;
    public boolean pf;
    public ve qp;
    public volatile int qy;
    public volatile boolean rh;
    public volatile boolean rl;
    public final Set<Integer> sl;
    public volatile String sp;
    public volatile com.byazt.it.ve sv;
    public volatile boolean t;
    public volatile String tt;
    public Bitmap u;
    public volatile boolean uj;
    public volatile String ve;
    public volatile com.byazt.eli.c x;
    public volatile com.byazt.aas.c yp;
    public boolean yv;
    public volatile com.byazt.dj.uj z;
    public n zb;
    public boolean zm;

    @com.byazt.zqa.c(c = {0, 1, 31, 62})
    public static final class c extends com.byazt.dj.uj {
        public c() {
            super(null);
        }

        @Override // com.byazt.dj.uj
        public boolean alist() {
            return "1".equals(com.byazt.zlb.ve.c(17, "1"));
        }

        @Override // com.byazt.dj.uj
        public String getDevImei() {
            return com.byazt.zlb.ve.c(10, "");
        }

        @Override // com.byazt.dj.uj
        public String getDevOaid() {
            return com.byazt.zlb.ve.c(13, "");
        }

        @Override // com.byazt.dj.uj
        public String getMacAddress() {
            return com.byazt.zlb.ve.c(18, "");
        }

        @Override // com.byazt.dj.uj
        public com.byazt.dj.ve getTTLocation() {
            String[] strArrSplit;
            String strC = com.byazt.zlb.ve.c(8, "");
            if (TextUtils.isEmpty(strC) || (strArrSplit = strC.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.byazt.dj.ve.c().c(Double.valueOf(str).doubleValue()).tt(Double.valueOf(str2).doubleValue()).c();
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUseAndroidId() {
            return "1".equals(com.byazt.zlb.ve.c(22, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUseLocation() {
            return "1".equals(com.byazt.zlb.ve.c(7, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUseMessage() {
            return "1".equals(com.byazt.zlb.ve.c(24, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUsePermissionRecordAudio() {
            return false;
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUsePhoneState() {
            return "1".equals(com.byazt.zlb.ve.c(9, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUseWifiState() {
            return "1".equals(com.byazt.zlb.ve.c(11, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isCanUseWriteExternal() {
            return "1".equals(com.byazt.zlb.ve.c(12, "1"));
        }

        @Override // com.byazt.dj.uj
        public boolean isDefaultController() {
            return true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 31, 865})
    public static class tt {
        public static x c = new x();
    }

    @com.byazt.zqa.c(c = {0, 1, 31, 902})
    public static class ve {
        public Map<String, Object> c;
        public String tt;

        public ve(Map<String, Object> map, String str) {
            this.c = map;
            this.tt = str;
        }

        public void c(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.c) == null || map.size() == 0 || TextUtils.isEmpty(this.tt)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.tt));
        }
    }

    public static Object j() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                        declaredField3.setAccessible(true);
                        return declaredField3.get(obj);
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static x m() {
        return tt.c;
    }

    private com.byazt.it.ve ma() {
        if (this.sv == null) {
            synchronized (this) {
                if (this.sv == null) {
                    this.sv = com.byazt.vif.uj.c(this.tt, "sp_global_info");
                }
            }
        }
        return this.sv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        DeviceUtils.sl();
        DeviceUtils.t();
    }

    private static com.byazt.dj.uj yf() {
        return new com.byazt.dj.uj.c().tt(true).c(true).c((com.byazt.dj.ve) null).ve(true).c((String) null).uj(true).tt((String) null).n(true).ve((String) null).a(true).uj((String) null).sp(false).c();
    }

    public boolean a() {
        return this.nb;
    }

    public int aw() {
        int iUj;
        return (!com.byazt.by.ve.c().tt() || (iUj = com.byazt.by.uj.c().uj()) == Integer.MIN_VALUE) ? this.qy : iUj;
    }

    public long b() {
        return this.eo;
    }

    public boolean bm() {
        return "5001121".equals(this.tt);
    }

    public boolean bx() {
        return com.byazt.by.ve.c().tt() ? com.byazt.by.uj.c().c(false) : this.t;
    }

    public JSONObject cu() {
        return this.gu;
    }

    public boolean d() {
        return this.rh;
    }

    public boolean da() {
        return com.byazt.qh.ve.c().x();
    }

    public void eo() {
        com.byazt.by.uj.c().tt(this.qy);
        com.byazt.by.uj.c().ve(this.n);
        com.byazt.by.uj.c().n(this.f28890a);
        com.byazt.by.uj.c().sp(c(this.gr));
        ma().put("title_bar_theme", this.i);
        ma().put("allow_show_notify", this.da);
        com.byazt.by.uj.c().tt(this.t);
        Set<Integer> set = this.sl;
        if (set == null || set.isEmpty()) {
            ma().remove("network_state");
            return;
        }
        Iterator<Integer> it = this.sl.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        ma().put("network_state", sb.toString());
    }

    public String gr() {
        return !TextUtils.isEmpty(this.n) ? this.n : com.byazt.by.uj.c().uj("");
    }

    public boolean gt() {
        return ma().get("sdk_activate_init", true);
    }

    public boolean gu() {
        return this.uj;
    }

    public boolean h() {
        return com.byazt.ue.tt.c() ? ma().get("allow_show_notify", true) : this.da;
    }

    public boolean hd() {
        return "5001121".equals(this.tt) && "com.union_test.toutiao".equals(nb.x());
    }

    public boolean i() {
        return !da() && sp();
    }

    public String ic() {
        if (!com.byazt.by.ve.c().tt()) {
            return TextUtils.isEmpty(this.m) ? "" : this.m;
        }
        String str = ma().get("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public ve iu() {
        return this.qp;
    }

    public Object kk() {
        Object objApply;
        WeakReference<Activity> weakReferenceC = this.yp.c();
        if (weakReferenceC != null) {
            return weakReferenceC.get();
        }
        if (this.p != null) {
            objApply = this.p.apply(com.byazt.yxi.uj.c().c(14).c(Activity.class).tt());
        } else {
            objApply = null;
        }
        return objApply == null ? j() : objApply;
    }

    public int kp() {
        return this.d;
    }

    public String l() {
        if (!TextUtils.isEmpty(this.nu)) {
            return this.nu;
        }
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        String str = veVarC.get("any_door_id", (String) null);
        this.nu = str;
        if (!TextUtils.isEmpty(str)) {
            return this.nu;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        veVarC.put("any_door_id", strValueOf);
        this.nu = strValueOf;
        return strValueOf;
    }

    public boolean lo() {
        return this.my;
    }

    public boolean lr() {
        try {
            if ("com.union_test.toutiao".equals(gt.getContext().getPackageName()) && "5001121".equals(this.tt)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(gt.getContext().getPackageName()) && "5001121".equals(this.tt)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(gt.getContext().getPackageName()) && "5001121".equals(this.tt)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(gt.getContext().getPackageName()) && "5001121".equals(this.tt)) {
                return true;
            }
            return gt.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj") && "5001121".equals(this.tt);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Function<SparseArray<Object>, Object> lt() {
        return this.p;
    }

    public int md() {
        return com.byazt.ue.tt.c() ? ma().get("title_bar_theme", 0) : this.i;
    }

    public com.byazt.dj.uj my() {
        if (this.z == null || this.z.isDefaultController()) {
            this.z = hd() ? c : yf();
        }
        return this.z;
    }

    public String n() {
        return com.byazt.qh.ve.c().tt();
    }

    public Function<SparseArray<Object>, Object> nb() {
        Function<SparseArray<Object>, Object> function = this.gt;
        if (function != null) {
            return function;
        }
        com.byazt.dk.m mVarInstance = com.byazt.dk.m.instance(gt.getContext());
        this.gt = mVarInstance;
        return mVarInstance;
    }

    public com.byazt.dj.uj nu() {
        return new zm(my());
    }

    public boolean or() {
        return this.bx;
    }

    public String os() {
        return ma().get("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/ad_preview.html");
    }

    public String oz() {
        return ma().get("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/basic_info.html");
    }

    public Map<String, Object> p() {
        if (!this.gr.isEmpty()) {
            return this.gr;
        }
        String strX = com.byazt.by.uj.c().x("");
        this.gr.putAll(TextUtils.isEmpty(strX) ? yp(strX) : new HashMap<>());
        return this.gr;
    }

    public com.byazt.ab.uj pf() {
        if (this.aw == null) {
            this.aw = new com.byazt.ab.uj(10, 8);
        }
        return this.aw;
    }

    public int pu() {
        return com.byazt.by.uj.c().uj(0);
    }

    public String q() {
        try {
            if ((gt.tt().ca() & 1) == 1) {
                return com.byazt.by.n.c().n();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005f  */
    public void qp() {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            String strSp = com.byazt.xiv.n.sp();
            if (TextUtils.isEmpty(strSp)) {
                strSp = BuildConfig.VERSION_NAME;
            }
            jSONObject.put("gdt_version", strSp);
        } catch (JSONException unused) {
        }
        com.byazt.bzd.u.c();
        int i = com.byazt.xiv.n.i();
        if (i != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String string2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < string2.length(); i2++) {
                sb2.append(string2.charAt(i2));
                if (i2 != string2.length() - 1) {
                    sb2.append(Consts.DOT);
                }
            }
            if (TextUtils.isEmpty(sb2.toString())) {
                string = "0.0.0.0";
            } else {
                string = sb2.toString();
            }
        } else {
            string = "0.0.0.0";
        }
        if (jSONObject.has("gdt_version")) {
            try {
                com.byazt.xiv.n.c("dex_status", 1);
                jSONObject.put("app_id", this.tt);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, string);
                jSONObject.put("sdk_version", "2.0.0.0");
                jSONObject.put("plugin_update_network", "2");
                this.gu.put("com.byted.mixed", jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public String qy() {
        return this.ve;
    }

    public String r() {
        return ma().get("adnDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/adn_detail.html");
    }

    public String rh() {
        return this.ic;
    }

    public String rl() {
        return this.tt;
    }

    public String s() {
        return ma().get("ritDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/rit_detail.html");
    }

    public boolean sl() {
        return com.byazt.qh.ve.c().i();
    }

    public boolean sp() {
        return com.byazt.qh.ve.c().sp();
    }

    public Bitmap sv() {
        return com.byazt.ue.tt.c() ? com.byazt.nr.uj.c(ma().get("pause_icon", "")) : this.u;
    }

    public void t() {
        com.byazt.qh.ve.c().n();
    }

    public String tk() {
        return this.sp;
    }

    public boolean to() {
        return this.or;
    }

    public boolean tt() {
        if (!this.yv) {
            this.yv = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) gt.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.zm = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.zm;
    }

    public boolean tx() {
        if (ma().get("update_advance_preview_mode", false)) {
            long j = ma().get("update_advance_preview_mode_time", -1L);
            if (j != -1) {
                if (System.currentTimeMillis() - j <= 3600000) {
                    return true;
                }
                sl(false);
            }
        }
        return false;
    }

    public boolean u() {
        return com.byazt.qh.ve.c().ve();
    }

    public boolean uj() {
        return com.byazt.qh.ve.c().a();
    }

    public String v() {
        return ma().get("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public com.byazt.aas.c ve() {
        if (this.yp == null) {
            ve(gt.getContext());
        }
        return this.yp;
    }

    public boolean x() {
        return i() && com.byazt.xo.c.ve();
    }

    public String y() {
        return ma().get("codeidDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/codeid_detail.html");
    }

    public void yp() {
        z();
        Context context = gt.getContext();
        this.sl.add(4);
        ve(context);
    }

    public String yv() {
        return !TextUtils.isEmpty(this.f28890a) ? this.f28890a : com.byazt.by.uj.c().a("");
    }

    public void z() {
        this.nb = com.byazt.xo.c.tt();
    }

    public boolean zb() {
        return this.pf;
    }

    public com.byazt.eli.c zm() {
        return this.x;
    }

    private x() {
        this.x = new com.byazt.eli.c(2);
        this.i = 0;
        this.da = true;
        this.sl = Collections.synchronizedSet(new HashSet());
        this.t = false;
        this.u = null;
        this.rh = false;
        this.my = true;
        this.rl = true;
        this.qy = 0;
        this.gu = new JSONObject();
        this.gr = new HashMap<>();
        this.zm = false;
        this.yv = false;
        this.p = null;
        this.md = -1;
        this.h = -1;
        this.d = -1;
        this.eo = -1L;
        this.pf = false;
        this.bx = false;
        this.ic = null;
    }

    private static void m(String str) {
        com.byazt.nr.my.c(str, "name不能为空");
    }

    private static void nu(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.nr.my.c(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    private static void rh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.nr.my.c(str.length() <= 20000, "data超长, 最长为20000");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap map = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.isNull("__name__")) {
                    String strOptString = jSONObjectOptJSONObject.optString("__name__");
                    String strOptString2 = jSONObjectOptJSONObject.optString("value");
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString("name"))) {
                    i(jSONObjectOptJSONObject.optString("value"));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z) {
            this.f28890a = jSONArray.toString();
        } else {
            this.f28890a = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.f28890a = jSONArray2.toString();
        }
        if (map.isEmpty()) {
            return;
        }
        this.gr.putAll(map);
    }

    private static void z(String str) {
        com.byazt.nr.my.c(str, "appid不能为空");
    }

    public void a(final String str) {
        rh(str);
        ((qp) com.byazt.ut.uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.omf.x.1
            @Override // java.lang.Runnable
            public void run() {
                x.this.u(str);
            }
        });
    }

    public boolean c() {
        return this.yp != null && this.yp.tt();
    }

    public void da(boolean z) {
        this.or = z;
    }

    public void n(String str) {
        nu(str);
        this.n = str;
    }

    public void sl(boolean z) {
        ma().put("update_advance_preview_mode", z);
        ma().put("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public void sp(String str) {
        a(str);
        if (com.byazt.ue.tt.c()) {
            com.byazt.by.uj.c().n(str);
            com.byazt.by.uj.c().sp(c(this.gr));
        }
    }

    public void t(String str) {
        ma().put("toolsBasicInfUrl", str);
    }

    public void uj(String str) {
        m(str);
        this.ve = str;
    }

    public void x(String str) {
        n(str);
        com.byazt.by.uj.c().ve(str);
    }

    public boolean c(boolean z) {
        return this.yp != null && this.yp.c(z);
    }

    public void da(String str) {
        ma().put("toolsQueryHost", str);
    }

    public void i(boolean z) {
        this.my = z;
    }

    private void ve(Context context) {
        if (this.yp != null) {
            return;
        }
        this.yp = new com.byazt.aas.c();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.yp);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.yp);
        }
    }

    public void a(boolean z) {
        this.pf = z;
    }

    public void c(String str) {
        this.cu = str;
    }

    public void i(String str) {
        this.sp = str;
        com.byazt.ogz.x.c((com.byazt.ogz.n) null).c(true);
    }

    public void n(boolean z) {
        ve(z);
    }

    public void sl(String str) {
        ma().put("toolsAdPreviewUrl", str);
    }

    public void uj(boolean z) {
        this.da = z;
    }

    public void x(boolean z) {
        p.i = z;
        this.t = z;
    }

    private static final HashMap<String, Object> yp(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    map.put(next, jSONObject.opt(next));
                }
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public Function<SparseArray<Object>, Object> a(int i) {
        if (this.p == null) {
            return null;
        }
        return (Function) this.p.apply(com.byazt.yxi.uj.c().c(10).c(Object.class).c(0, Integer.valueOf(i)).tt());
    }

    public String c(ic icVar) {
        if (TextUtils.isEmpty(this.cu)) {
            this.cu = com.byazt.yih.i.c(icVar, false);
        }
        return this.cu;
    }

    public void n(int i) {
        com.byazt.by.uj.c().ve(i);
    }

    public void uj(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.qy = i;
        } catch (Throwable unused) {
        }
    }

    public void sp(boolean z) {
        this.bx = z;
    }

    public void tt(String str) {
        this.ic = str;
    }

    public void sp(int i) {
        this.d = i;
    }

    public void tt(boolean z) {
        ma().put("sdk_activate_init", z);
    }

    public boolean c(Activity activity) {
        return this.yp != null && this.yp.c(activity);
    }

    public void tt(int i) {
        this.i = i;
    }

    public void c(com.byazt.dj.uj ujVar) {
        this.z = ujVar;
    }

    public boolean tt(Context context) {
        if (com.byazt.pf.c.c().n()) {
            this.h = 2;
        } else {
            this.h = 1;
        }
        return this.h == 1;
    }

    public void c(int i) {
        this.x = new com.byazt.eli.c(i, true);
    }

    public void c(boolean z, SparseArray<Object> sparseArray) {
        com.byazt.nr.m.uj("bstsdk", "bst(true) stat-quit, run new pl");
        this.rh = z;
        com.byazt.xo.c.c(true);
        com.byazt.nr.m.c("bstsdk", "setQuitWork, resultValues: " + sparseArray);
        ((qp) com.byazt.ut.uj.getService("thread_service")).postIOTask(new Runnable() { // from class: com.byazt.omf.x.2
            @Override // java.lang.Runnable
            public void run() {
                x.unregisterReceiver();
                com.byazt.ol.n.c().tt();
            }
        });
    }

    public void ve(String str) {
        z(str);
        this.tt = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put("sdk_version", p.n);
            this.gu.put("com.byted.pangle", jSONObject);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public void c(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.gu.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.byazt.nr.m.uj("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void c(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.gu.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.tt;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put("app_id", str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.gu.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            com.byazt.nr.m.tt("GlobalInfo", "addPluginConfig for " + str + " failed: " + e.getMessage());
        }
    }

    public void ve(boolean z) {
        this.uj = z;
    }

    public boolean ve(int i) {
        if (com.byazt.ue.tt.c()) {
            String str = ma().get("network_state", "");
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(",");
                if (strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (!TextUtils.isEmpty(str2) && String.valueOf(i).equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.sl;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void c(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.tt);
                    c(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
    }

    public void c(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.sl.clear();
            for (int i : iArr) {
                this.sl.add(Integer.valueOf(i));
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private static final String c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public void c(Bitmap bitmap) {
        if (com.byazt.ue.tt.c()) {
            String strC = com.byazt.nr.uj.c(bitmap);
            if (!TextUtils.isEmpty(strC)) {
                ma().put("pause_icon", strC);
            }
        }
        this.u = bitmap;
    }

    public void c(Function<SparseArray<Object>, Object> function) {
        if (this.p != null) {
            return;
        }
        this.p = function;
    }

    public boolean c(Context context) {
        if (com.byazt.pf.c.c().n()) {
            this.md = 2;
        } else {
            this.md = 1;
        }
        return this.md == 1;
    }

    public void c(long j) {
        this.eo = j;
    }

    public void c(com.byazt.aas.c.tt ttVar) {
        if (this.p != null) {
            if (this.zb == null) {
                n nVar = new n();
                this.zb = nVar;
                nVar.c(this.p);
            }
            this.zb.c(ttVar);
        }
    }

    public void c(ve veVar) {
        this.qp = veVar;
    }
}
