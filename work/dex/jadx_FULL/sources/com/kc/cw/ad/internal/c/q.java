package com.kc.cw.ad.internal.c;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38952a = "${SECOND_PRICE}";
    public static String b = "${WIN_PRICE}";
    public static String c = "${LOSS_REASON}";
    public static String d = "${WIN_BIDDER}";
    public static String e = "${SLOT_ID}";
    public static String f = "${REQ_ID}";
    public static String g = "${SDK_VERSION}";
    public static String h = "${DEVICE_ID}";

    private static String a(String str, int i) {
        if (i <= 1) {
            return str;
        }
        try {
            return String.valueOf((int) (Double.parseDouble(str) * ((double) i)));
        } catch (Exception e2) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
            return str;
        }
    }

    public static String a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strReplace = str.replace(f38952a, String.valueOf(i));
        return !TextUtils.isEmpty(str2) ? strReplace.replace(e, str2) : strReplace;
    }

    public static String a(String str, int i, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strReplace = str.replace(b, String.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            strReplace = strReplace.replace(c, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            strReplace = strReplace.replace(d, str3);
        }
        return !TextUtils.isEmpty(str4) ? strReplace.replace(e, str4) : strReplace;
    }

    public static String a(String str, com.kc.cw.ad.a.d dVar, com.kc.cw.ad.a.e eVar) {
        String strC;
        if (dVar == null || eVar == null) {
            return str;
        }
        if (eVar.t() != null) {
            if (dVar.a() == 2) {
                strC = eVar.t().b();
            } else {
                strC = dVar.a() == 3 ? eVar.t().c() : eVar.t().a();
            }
            str = str.replace("__oct_click_type__", strC);
        }
        String strReplace = str.replace("__oct_down_x__", !TextUtils.isEmpty(dVar.b()) ? dVar.b() : eVar.d()).replace("__oct_down_y__", !TextUtils.isEmpty(dVar.c()) ? dVar.c() : eVar.e()).replace("__oct_down_time__", !TextUtils.isEmpty(dVar.d()) ? dVar.d() : eVar.f()).replace("__oct_up_x__", !TextUtils.isEmpty(dVar.e()) ? dVar.e() : eVar.a()).replace("__oct_up_y__", !TextUtils.isEmpty(dVar.f()) ? dVar.f() : eVar.b()).replace("__oct_up_time__", !TextUtils.isEmpty(dVar.g()) ? dVar.g() : eVar.c()).replace("__oct_x_max_acc__", !TextUtils.isEmpty(dVar.l()) ? a(dVar.l(), eVar.s()) : eVar.g()).replace("__oct_y_max_acc__", !TextUtils.isEmpty(dVar.m()) ? a(dVar.m(), eVar.s()) : eVar.h()).replace("__oct_z_max_acc__", !TextUtils.isEmpty(dVar.n()) ? a(dVar.n(), eVar.s()) : eVar.i()).replace("__oct_shake_acc__", !TextUtils.isEmpty(dVar.o()) ? dVar.o() : eVar.k()).replace("__oct_shake_ang__", !TextUtils.isEmpty(dVar.p()) ? dVar.p() : eVar.l()).replace("__oct_shake_cnt__", !TextUtils.isEmpty(dVar.q()) ? dVar.q() : eVar.j()).replace("__oct_turn_x__", !TextUtils.isEmpty(dVar.r()) ? dVar.r() : eVar.m()).replace("__oct_turn_y__", !TextUtils.isEmpty(dVar.s()) ? dVar.s() : eVar.n()).replace("__oct_turn_z__", !TextUtils.isEmpty(dVar.t()) ? dVar.t() : eVar.o()).replace("__oct_turn_time__", !TextUtils.isEmpty(dVar.u()) ? dVar.u() : eVar.p()).replace("__oct_ms_time__", !TextUtils.isEmpty(dVar.i()) ? dVar.i() : eVar.r()).replace("__oct_s_time__", !TextUtils.isEmpty(dVar.h()) ? dVar.h() : eVar.q());
        if (!TextUtils.isEmpty(dVar.j())) {
            strReplace = strReplace.replace("__oct_container_w__", dVar.j());
        }
        if (!TextUtils.isEmpty(dVar.k())) {
            strReplace = strReplace.replace("__oct_container_h__", dVar.k());
        }
        return !TextUtils.isEmpty(a.p) ? strReplace.replace("__oct_screen_ppi__", a.p) : strReplace;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public static String a(String str, com.kc.cw.ad.a.h hVar, long j, long j2) {
        String strValueOf;
        String strValueOf2;
        if (hVar == null) {
            return str;
        }
        if (j == 0) {
            if (!TextUtils.isEmpty(hVar.a())) {
                strValueOf = hVar.a();
            }
            if (j2 == 0) {
                strValueOf2 = String.valueOf(j2);
            } else {
                if (!TextUtils.isEmpty(hVar.b())) {
                    return str;
                }
                strValueOf2 = hVar.b();
            }
            return str.replace("__oct_video_end_ts__", strValueOf2);
        }
        strValueOf = String.valueOf(j);
        str = str.replace("__oct_video_start_ts__", strValueOf);
        if (j2 == 0) {
            strValueOf2 = String.valueOf(j2);
        } else {
            if (!TextUtils.isEmpty(hVar.b())) {
                return str;
            }
            strValueOf2 = hVar.b();
        }
        return str.replace("__oct_video_end_ts__", strValueOf2);
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str.replace(e, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str = str.replace(h, str3);
        }
        return str.replace(g, "2.6.1.8");
    }
}
