package com.baidu.xclient.gdid;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26830a = "sec_gd_config_mshield";
    public static volatile e b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;

    public e() {
        SharedPreferences sharedPreferences = d.b.getSharedPreferences(f26830a, 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }

    public static e e() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public int A() {
        return b("k_b_app_l_idx", 0);
    }

    public int a() {
        return b("k_f_p_idx", 0);
    }

    public void a(int i) {
        a("k_mdl_sw", i);
    }

    public void a(long j) {
        a("k_last_pull_pl_t", j);
    }

    public void a(String str) {
        a("k_cu_p_ver_n", str);
    }

    public final void a(String str, int i) {
        this.d.putInt(str, i);
        this.d.commit();
    }

    public final void a(String str, long j) {
        this.d.putLong(str, j);
        this.d.commit();
    }

    public final void a(String str, String str2) {
        this.d.putString(str, str2);
        this.d.commit();
    }

    public final void a(String str, boolean z) {
        this.d.putBoolean(str, z);
        this.d.commit();
    }

    public void a(boolean z) {
        a("k_is_rep_m", z);
    }

    public int b() {
        return b("k_b_f_p_idx", 0);
    }

    public final int b(String str, int i) {
        return this.c.getInt(str, i);
    }

    public final long b(String str, long j) {
        return this.c.getLong(str, j);
    }

    public final String b(String str, String str2) {
        return this.c.getString(str, str2);
    }

    public void b(int i) {
        if (i <= 0) {
            return;
        }
        a("k_t_c_p", i);
    }

    public void b(long j) {
        if (j <= 0) {
            return;
        }
        a("k_pull_p_itl", j);
    }

    public void b(String str) {
        a("k_ply_s_n", str);
    }

    public void b(boolean z) {
        a("k_is_rep_im_m", z);
    }

    public final boolean b(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }

    public void c(int i) {
        if (i <= 0) {
            return;
        }
        a("k_t_a_p", i);
    }

    public void c(long j) {
        a("k_last_re_fing_t", j);
    }

    public void c(String str) {
        a("k_gu_all", str);
    }

    public void c(boolean z) {
        a("k_is_rep_im_e", z);
    }

    public boolean c() {
        return b("k_is_rp_mgc", false);
    }

    public void d() {
        a("k_is_rp_mgc", !c());
    }

    public void d(int i) {
        if (i < 0) {
            return;
        }
        a("k_t_ca_p", i);
    }

    public void d(long j) {
        if (j <= 0) {
            return;
        }
        a("k_re_fing_itl", j);
    }

    public void d(String str) {
        a("k_rep_al", str);
    }

    public void d(boolean z) {
        a("k_is_rp_rg_crc", z);
    }

    public void e(int i) {
        if (i < 0) {
            return;
        }
        a("l_td_t_s", i != 0);
    }

    public void e(long j) {
        a("k_last_alm_t", j);
    }

    public void e(String str) {
        a("k_rep_f_if", str);
    }

    public void e(boolean z) {
        a("k_is_rep_lc_4_p", z);
    }

    public long f() {
        return b("k_last_pull_pl_t", 0L);
    }

    public void f(int i) {
        if (i < 0) {
            return;
        }
        a("k_t_m_s_s", i != 0);
    }

    public void f(long j) {
        if (j <= 0) {
            return;
        }
        a("k_alm_itl", j);
    }

    public void f(String str) {
        a("k_last_ds_d", str);
    }

    public void f(boolean z) {
        a("k_is_rep_ad", z);
    }

    public long g() {
        return b("k_pull_p_itl", com.baidu.xclient.gdid.d.a.b * 8);
    }

    public void g(int i) {
        a("k_app_l_idx", i);
    }

    public void g(long j) {
        a("k_last_pi_t", j);
    }

    public void g(String str) {
        a("k_gd_p", str);
    }

    public void g(boolean z) {
        a("k_is_rep_im_c", z);
    }

    public long h() {
        return b("k_last_re_fing_t", 0L);
    }

    public void h(int i) {
        a("k_b_app_l_idx", i);
    }

    public void h(long j) {
        if (j <= 0) {
            return;
        }
        a("K_pi_itl", j);
    }

    public void h(boolean z) {
        a("k_is_rep_o_i", z);
    }

    public long i() {
        return b("k_re_fing_itl", com.baidu.xclient.gdid.d.a.c);
    }

    public void i(int i) {
        a("k_f_p_idx", i);
    }

    public void i(boolean z) {
        a("k_is_rep_wf", z);
    }

    public String j() {
        return b("k_cu_p_ver_n", "");
    }

    public void j(int i) {
        a("k_b_f_p_idx", i);
    }

    public void j(boolean z) {
        a("k_ig_u_a", z);
    }

    public String k() {
        String strB = b("k_ply_s_n", "");
        if (!TextUtils.isEmpty(strB)) {
            return new String(Base64.decode(strB, 1));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e", 1);
            jSONObject.put(t.d, 1);
            jSONObject.put("p", ".zqobbx.pa");
            jSONObject.put("i", 1);
            jSONObject.put("m", 0);
            jSONObject.put("w", 1);
            jSONObject.put("s", 1);
            jSONObject.put("c", 0);
            jSONObject.put("y", 20);
            jSONObject.put(j.o, 20);
            jSONObject.put("x", 0);
            jSONObject.put("u", 0);
            jSONObject.put(y6b.f, 20);
            jSONObject.put("n", 0);
            jSONObject.put("t", 0);
            jSONObject.put("q", 0);
            jSONObject.put("9", "");
            jSONObject.put("10", "");
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
        return jSONObject.toString();
    }

    public void k(boolean z) {
        a("k_is_rp_lp", z);
    }

    public long l() {
        return b("k_last_alm_t", 0L);
    }

    public void l(boolean z) {
        a("k_is_rp_dnp", z);
    }

    public long m() {
        return b("k_alm_itl", com.baidu.xclient.gdid.d.a.b);
    }

    public long n() {
        return b("k_last_pi_t", 0L);
    }

    public long o() {
        return b("K_pi_itl", com.baidu.xclient.gdid.d.a.b * 12);
    }

    public String p() {
        return b("k_ext_id4", "");
    }

    public String q() {
        return b("k_gu_all", "");
    }

    public String r() {
        return b("k_rep_al", "");
    }

    public String s() {
        return b("k_rep_f_if", "");
    }

    public String t() {
        return b("k_n_g_d", "");
    }

    public String u() {
        return b("k_ext_j", "");
    }

    public boolean v() {
        return y() == 3;
    }

    public boolean w() {
        int iY = y();
        return iY == 3 || iY == 1;
    }

    public boolean x() {
        int iY = y();
        return iY == 3 || iY == 2;
    }

    public int y() {
        return b("k_mdl_sw", 3);
    }

    public int z() {
        return b("k_app_l_idx", 0);
    }
}
