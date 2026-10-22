package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.mshield.utility.g;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f26719a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    public SharedPreferences d;
    public SharedPreferences.Editor e;
    public SharedPreferences f;
    public SharedPreferences.Editor g;
    public Context h;
    public int i;
    public String j = null;
    public Map<String, SharedPreferences> k = new HashMap();

    public a(Context context) {
        this.h = context;
        this.i = com.baidu.mshield.utility.a.h(context);
        com.baidu.mshield.b.c.a.b("checking platformName:mshield_SOFIRE");
        i();
        c cVar = new c(this.h, this.i == 1 ? context.getSharedPreferences("leroadmshieldcfg", 0) : null, "leroadmshieldcfg", false, this.i);
        this.b = cVar;
        this.c = cVar.edit();
        c cVar2 = new c(this.h, (this.i == 1 && TextUtils.isEmpty(this.j)) ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", true, this.i, this.j);
        this.d = cVar2;
        this.e = cVar2.edit();
        c cVar3 = new c(this.h, this.i == 1 ? context.getSharedPreferences("msre_po_rt", 0) : null, "msre_po_rt", false, this.i);
        this.f = cVar3;
        this.g = cVar3.edit();
    }

    public int A() {
        return this.b.getInt("wi_fa_pu_cl", 0);
    }

    public long B() {
        return this.f.getLong("re_net_pu_de", 0L);
    }

    public String C() {
        return this.f.getString("re_net_ali2_version", "");
    }

    public int D() {
        return this.f.getInt("re_net_dy_lt", 50);
    }

    public int E() {
        return this.f.getInt("g_r_d_d_n", 0);
    }

    public int F() {
        return this.f.getInt("re_net_wt", 3);
    }

    public long G() {
        return this.f.getLong("re_last_ofline_time", 0L);
    }

    public int H() {
        return this.f.getInt("re_net_one_lt", 5);
    }

    public int I() {
        return this.f.getInt("re_net_over", 7);
    }

    public int J() {
        if ("com.baidu.BaiduMap.meizu".equals(this.h.getPackageName())) {
            return this.f.getInt("re_net_hr", 24);
        }
        int i = this.f.getInt("re_net_hr", 3);
        try {
            String[] strArrI = com.baidu.mshield.utility.a.i(this.h);
            if (strArrI.length == 2 && !TextUtils.isEmpty(strArrI[0]) && !TextUtils.isEmpty(strArrI[1]) && "200080".equals(strArrI[0]) && "com.baidu.BaiduMap".equals(this.h.getPackageName()) && i < 24) {
                return 24;
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public String K() {
        return this.b.getString("svi_n_wm", "");
    }

    public String a() {
        return this.b.getString("svi_wm", "");
    }

    public long b() {
        long j = this.b.getLong("se_ae_fd", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        k();
        return jCurrentTimeMillis;
    }

    public long c() {
        return this.f.getLong("re_day_b_t", 0L);
    }

    public long d() {
        return this.f.getLong("re_day_len", 0L);
    }

    public String e() {
        return this.d.getString("xytk", "");
    }

    public String f() {
        return this.d.getString("sgud", "");
    }

    public int g() {
        return this.f.getInt("up_nu_co", 50);
    }

    public int h() {
        return this.f.getInt("up_nu_li", 100);
    }

    public void i() {
        Bundle bundle = new Bundle();
        bundle.putString("operation", "querySharedHandler");
        Bundle bundleA = g.a(this.h, "CallPreferences", bundle, false, "3.5.8.0", true);
        if (bundleA != null) {
            this.j = bundleA.getString("handle_platform");
            com.baidu.mshield.b.c.a.b("get can handle shared platform:" + this.j);
        }
    }

    public void j() {
        this.c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public void k() {
        this.c.putLong("se_ae_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public void l(String str) {
        this.e.putString("rpmacadd", str);
        this.e.commit();
    }

    public void m(String str) {
        this.e.putString("xytk_m", str);
        this.e.apply();
    }

    public void n(int i) {
        this.g.putInt("up_nu_co", i);
        this.g.commit();
    }

    public void o(String str) {
        this.e.putString("sgud", str);
        this.e.commit();
    }

    public List<com.baidu.mshield.rp.b.a> p() {
        com.baidu.mshield.rp.b.a aVarA;
        String string = this.f.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (aVarA = com.baidu.mshield.rp.b.a.a(str)) != null) {
                arrayList.add(aVarA);
            }
        }
        return arrayList;
    }

    public String q() {
        return this.d.getString("xyusec", "");
    }

    public String r() {
        return this.d.getString("xygls", "");
    }

    public String s() {
        return this.d.getString("rpiiem", "");
    }

    public String t() {
        return this.f.getString("re_a_lc", "");
    }

    public String u() {
        return this.d.getString("rpmacadd", "");
    }

    public String v() {
        return this.d.getString("xytk_m", "");
    }

    public SharedPreferences w() {
        return this.b;
    }

    public SharedPreferences x() {
        return this.d;
    }

    public long y() {
        long j = this.b.getLong("pu_cl_fd", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        j();
        return jCurrentTimeMillis;
    }

    public int z() {
        return this.b.getInt("mo_fa_pu_cl", 0);
    }

    public static synchronized a a(Context context) {
        try {
            if (context == null) {
                return f26719a;
            }
            if (f26719a == null) {
                f26719a = new a(context);
            }
            return f26719a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public SharedPreferences c(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.k) {
                sharedPreferences = this.k.get(str);
                if (sharedPreferences == null) {
                    c cVar = new c(this.h, this.i == 1 ? this.h.getSharedPreferences(str, 0) : null, str, false, this.i);
                    this.k.put(str, cVar);
                    sharedPreferences = cVar;
                }
            }
            return sharedPreferences;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    public void d(String str, String str2) {
        this.c.putString("svi_n_wm", str + c49.f40900a + str2);
        this.c.commit();
    }

    public void e(int i) {
        this.c.putInt("wi_fa_pu_cl", i);
        this.c.commit();
    }

    public void f(int i) {
        this.g.putInt("re_net_dy_lt", i);
        this.g.commit();
    }

    public void g(String str) {
        this.e.putString("rpandid", str);
        this.e.commit();
    }

    public void h(String str) {
        this.e.putString("xyus", str);
        this.e.commit();
    }

    public void j(String str) {
        this.e.putString("xygls", str);
        this.e.commit();
    }

    public void k(String str) {
        this.e.putString("rpiiem", str);
        this.e.commit();
    }

    public void l(int i) {
        this.g.putInt("re_net_hr_bc", i);
        this.g.commit();
    }

    public String m() {
        return this.d.getString("rpandid", "");
    }

    public void n(String str) {
        this.g.putString("re_net_ali2_version", str);
        this.g.commit();
    }

    public void o(int i) {
        this.g.putInt("up_nu_li", i);
        this.g.commit();
    }

    public void b(int i) {
        this.c.putInt("mo_fa_pu_ap", i);
        this.c.commit();
    }

    public void d(int i) {
        this.c.putInt("mo_fa_pu_cl", i);
        this.c.commit();
    }

    public boolean e(String str) {
        return this.f.getBoolean("re_net_ins_" + str, false);
    }

    public void f(String str) {
        this.g.putString("li_pk_s", str);
        this.g.commit();
    }

    public void g(int i) {
        this.g.putInt("g_r_d_d_n", i);
        this.g.commit();
    }

    public void h(int i) {
        this.g.putInt("re_net_wt", i);
        this.g.commit();
    }

    public void m(int i) {
        this.g.putInt("re_net_hr", i);
        this.g.commit();
    }

    public void j(int i) {
        this.g.putInt("re_net_one_lt", i);
        this.g.commit();
    }

    public void k(int i) {
        this.g.putInt("re_net_over", i);
        this.g.commit();
    }

    public int l() {
        return this.b.getInt("mo_ae_fa_ct", 0);
    }

    public String n() {
        return this.d.getString("xyus", "");
    }

    public String o() {
        return this.f.getString("re_a_cv", "");
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x0180  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public Bundle a(Bundle bundle) {
        try {
            String string = bundle.getString("operation");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if ("querySharedHandler".equals(string)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("handle_platform", "mshield");
                return bundle2;
            }
            String string2 = bundle.getString("pref_name");
            if (TextUtils.isEmpty(string2)) {
                return null;
            }
            String string3 = bundle.getString(CachedContentIndex.a.e);
            if (TextUtils.isEmpty(string3)) {
                return null;
            }
            com.baidu.mshield.b.c.a.b("handleRemoteCall:" + string + LoginConstants.UNDER_LINE + string2 + LoginConstants.UNDER_LINE + string3);
            SharedPreferences sharedPreferencesA = a(string2);
            byte b = 0;
            if (string.startsWith(p3.f)) {
                String string4 = bundle.getString("defult_value");
                if (!"getString".equals(string) && TextUtils.isEmpty(string4)) {
                    return null;
                }
                com.baidu.mshield.b.c.a.b("handleRemoteCall get:" + string + "_defValue=" + string4);
                if (sharedPreferencesA == null) {
                    return null;
                }
                Bundle bundle3 = new Bundle();
                switch (string.hashCode()) {
                    case -1249359687:
                        if (!string.equals("getInt")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -75354382:
                        if (!string.equals("getLong")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 804029191:
                        if (!string.equals("getString")) {
                            b = -1;
                        }
                        break;
                    case 1101572082:
                        if (!string.equals("getBoolean")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 1953351846:
                        if (!string.equals("getFloat")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    bundle3.putString("result", sharedPreferencesA.getString(string3, string4));
                } else if (b == 1) {
                    bundle3.putInt("result", sharedPreferencesA.getInt(string3, Integer.parseInt(string4)));
                } else if (b == 2) {
                    bundle3.putLong("result", sharedPreferencesA.getLong(string3, Long.parseLong(string4)));
                } else if (b == 3) {
                    bundle3.putFloat("result", sharedPreferencesA.getFloat(string3, Float.parseFloat(string4)));
                } else if (b == 4) {
                    bundle3.putBoolean("result", sharedPreferencesA.getBoolean(string3, Boolean.parseBoolean(string4)));
                }
                return bundle3;
            }
            if (string.startsWith("put")) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                com.baidu.mshield.b.c.a.b("handleRemoteCall put:" + string);
                switch (string.hashCode()) {
                    case -976920992:
                        if (!string.equals("putInt")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -462997504:
                        if (!string.equals("putString")) {
                            b = -1;
                        }
                        break;
                    case -219689429:
                        if (!string.equals("putLong")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 478450201:
                        if (!string.equals("putBoolean")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 1773932685:
                        if (!string.equals("putFloat")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    editorEdit.putString(string3, bundle.getString("value"));
                } else if (b == 1) {
                    editorEdit.putInt(string3, bundle.getInt("value"));
                } else if (b == 2) {
                    editorEdit.putLong(string3, bundle.getLong("value"));
                } else if (b == 3) {
                    editorEdit.putFloat(string3, bundle.getFloat("value"));
                } else if (b == 4) {
                    editorEdit.putBoolean(string3, bundle.getBoolean("value"));
                }
                editorEdit.apply();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void b(long j) {
        this.g.putLong("re_last_ofline_time", j);
        this.g.commit();
    }

    public String d(String str) {
        return this.f.getString("re_net_ali2_" + str, "");
    }

    public void i(int i) {
        this.g.putInt("re_net_ty", i);
        this.g.commit();
    }

    public void d(long j) {
        this.g.putLong("re_day_len", j);
        this.g.commit();
    }

    public String b(String str) {
        return this.f.getString("al_da" + str, "");
    }

    public void i(String str) {
        this.e.putString("xyusec", str);
        this.e.commit();
    }

    public void b(String str, String str2) {
        this.g.putString("in_da" + str, str2);
        this.g.commit();
    }

    public void c(int i) {
        this.c.putInt("wi_fa_pu_ap", i);
        this.c.commit();
    }

    public void c(String str, String str2) {
        this.g.putString("re_net_ali2_" + str, str2);
        this.g.commit();
    }

    public void c(long j) {
        this.g.putLong("re_day_b_t", j);
        this.g.commit();
    }

    public final SharedPreferences a(String str) {
        if (str.equals("leroadmshieldcfg")) {
            return this.b;
        }
        if (str.equals("leroadcfg")) {
            return this.d;
        }
        if (str.equals("msre_po_rt")) {
            return this.f;
        }
        return c(str);
    }

    public void a(int i) {
        this.c.putInt("mo_ae_fa_ct", i);
        this.c.commit();
    }

    public void a(com.baidu.mshield.rp.b.a aVar) {
        if (aVar == null) {
            return;
        }
        String string = this.f.getString("re_con", "");
        this.g.putString("re_con", string + "||" + com.baidu.mshield.rp.b.a.a(aVar));
        this.g.commit();
    }

    public void a(List<com.baidu.mshield.rp.b.a> list, com.baidu.mshield.rp.b.a aVar) {
        int iIndexOf;
        com.baidu.mshield.rp.b.a aVar2;
        if (aVar == null || list == null || (iIndexOf = list.indexOf(aVar)) == -1 || (aVar2 = list.get(iIndexOf)) == null) {
            return;
        }
        this.g.putString("re_con", this.f.getString("re_con", "").replace(com.baidu.mshield.rp.b.a.a(aVar2), com.baidu.mshield.rp.b.a.a(aVar)));
        this.g.commit();
    }

    public void a(String str, boolean z) {
        this.g.putBoolean("re_net_ins_" + str, z);
        this.g.commit();
    }

    public void a(long j) {
        this.g.putLong("re_net_pu_de", j);
        this.g.commit();
    }

    public void a(String str, String str2) {
        this.g.putString("al_da" + str, str2);
        this.g.commit();
    }
}
