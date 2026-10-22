package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bu {
    private static final byte[] d = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40068a;
    private boolean b;
    private int c;

    public bu(Context context, int i, boolean z) {
        this.f40068a = context;
        this.b = z;
        this.c = i;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f40068a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", zE ? 1 : 0);
            jSONObject.put("11029", zE2 ? 1 : 0);
            if (hVarA.b(dd.au, 1) == 1 && (zE || zE2)) {
                String strA = bf.a(this.f40068a);
                if (!TextUtils.isEmpty(strA) && !strA.startsWith("RISK")) {
                    jSONObject.put("01001", f.a(strA));
                }
                String strC = bf.c(this.f40068a);
                if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                    jSONObject.put("01003", strC);
                }
                String strB = bf.b(this.f40068a, 0);
                if (!TextUtils.isEmpty(strB) && !strB.startsWith("RISK")) {
                    jSONObject.put("01019", strB);
                }
                String strB2 = bf.b(this.f40068a, 1);
                if (!TextUtils.isEmpty(strB2) && !strB2.startsWith("RISK")) {
                    jSONObject.put("01004", f.a(strB2));
                }
            }
            int iB = hVarA.b(dd.at, 1);
            if (iB == 1 && (zE || zE2)) {
                String strF = bf.f(this.f40068a);
                if (!TextUtils.isEmpty(strF) && !strF.startsWith("RISK")) {
                    jSONObject.put("01013", strF);
                }
            }
            if (hVarA.b(dd.av, 1) == 1 && (zE || zE2)) {
                String strD = bf.d(this.f40068a);
                if (!TextUtils.isEmpty(strD) && !strD.startsWith("RISK")) {
                    jSONObject.put("01007", strD);
                }
            }
            if (hVarA.b(dd.aw, 1) == 1 && (zE || zE2)) {
                jSONObject.put("01011", bf.e(this.f40068a));
            }
            if (zE || zE2) {
                String strH = bf.h();
                if ((TextUtils.isEmpty(strH) || strH.startsWith("RISK")) && strH == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", strH);
                }
                jSONObject.put("07006", bf.g());
            }
            if (hVarA.b(dd.ay, 1) == 1 && (zE || zE2)) {
                String strP = bf.p(this.f40068a);
                if (!TextUtils.isEmpty(strP) && !strP.startsWith("RISK")) {
                    jSONObject.put("01016", strP);
                }
            }
            if (zE || zE2) {
                try {
                    double dB = bf.b();
                    if (dB > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(dB);
                        jSONObject.put("09002", sb.toString());
                    }
                    double dC = bf.c();
                    if (dC > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(dC);
                        jSONObject.put("09003", sb2.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(bv.a(this.f40068a.getApplicationContext()), 2));
            jSONObject.put("11012", bv.b(this.f40068a));
            try {
                jSONObject.put("11202", bf.b(com.kwad.sdk.e.b.QY().QO()));
                jSONObject.put("11204", bf.b(com.kwad.sdk.e.b.QY().QU()));
                jSONObject.put("11205", bf.b(com.kwad.sdk.e.b.QY().getDeviceId()));
                jSONObject.put("11206", bf.b(com.kwad.sdk.e.b.QY().getIccId()));
                jSONObject.put("11207", bf.b(com.kwad.sdk.e.b.QY().getIMEI()));
                jSONObject.put("11208", bf.b(com.kwad.sdk.e.b.QY().QP()));
                jSONObject.put("11209", bf.b(com.kwad.sdk.e.b.QY().QQ()));
                jSONObject.put("11210", bf.b(com.kwad.sdk.e.b.QY().QR()));
                jSONObject.put("11211", bf.b(com.kwad.sdk.e.b.QY().getIp()));
                jSONObject.put("11212", bf.b(com.kwad.sdk.e.b.QY().getLocation()));
                jSONObject.put("11213", bf.b(com.kwad.sdk.e.b.QY().getOaid()));
                jSONObject.put("11214", bf.b(com.kwad.sdk.e.b.QY().getMac()));
                jSONObject.put("11215", bf.b(com.kwad.sdk.e.b.QY().QT()));
                jSONObject.put("11216", bf.b(com.kwad.sdk.e.b.QY().QS()));
                jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
                jSONObject.put("11104", com.kwad.sdk.e.b.QY().QU());
                jSONObject.put("11105", com.kwad.sdk.e.b.QY().getDeviceId());
                jSONObject.put("11106", com.kwad.sdk.e.b.QY().getIccId());
                jSONObject.put("11107", com.kwad.sdk.e.b.QY().getIMEI());
                jSONObject.put("11108", com.kwad.sdk.e.b.QY().QP());
                jSONObject.put("11109", com.kwad.sdk.e.b.QY().QQ());
                jSONObject.put("11110", com.kwad.sdk.e.b.QY().QR());
                jSONObject.put("11111", com.kwad.sdk.e.b.QY().getIp());
                jSONObject.put("11112", com.kwad.sdk.e.b.QY().getLocation());
                jSONObject.put("11113", com.kwad.sdk.e.b.QY().getOaid());
                jSONObject.put("11114", com.kwad.sdk.e.b.QY().getMac());
                jSONObject.put("11115", com.kwad.sdk.e.b.QY().QT());
                jSONObject.put("11116", com.kwad.sdk.e.b.QY().QS());
            } catch (Throwable unused2) {
            }
            String strW = bf.w(this.f40068a);
            if (!TextUtils.isEmpty(strW)) {
                jSONObject.put("01026", strW);
            }
            if (iB == 1) {
                try {
                    JSONObject jSONObjectA = ai.a(this.f40068a);
                    if (jSONObjectA != null) {
                        jSONObject.put("11015", jSONObjectA);
                    }
                    if (Engine.loadSuccess) {
                        cc ccVar = new cc(this.f40068a);
                        jSONObject.put("02001", ccVar.a("02001") != null ? ccVar.a("02001") : bj.a());
                        jSONObject.put("02002", ccVar.a("02002") != null ? ccVar.a("02002") : bj.b());
                        jSONObject.put("02003", ccVar.a("02003") != null ? ccVar.a("02003") : bj.c());
                        jSONObject.put("02007", ccVar.a("02007") != null ? ccVar.a("02007") : bj.g());
                        jSONObject.put("02006", ccVar.a("02006") != null ? ccVar.a("02006") : bj.f());
                        jSONObject.put("02004", ccVar.a("02004") != null ? ccVar.a("02004") : bj.d());
                        jSONObject.put("02005", ccVar.a("02005") != null ? ccVar.a("02005") : bj.e());
                        jSONObject.put("02018", ccVar.a("02018") != null ? ccVar.a("02018") : bj.s());
                        jSONObject.put("02013", ccVar.a("02013") != null ? ccVar.a("02013") : bj.m());
                        jSONObject.put("02016", ccVar.a("02016") != null ? ccVar.a("02016") : bj.q());
                    } else {
                        jSONObject.put("02001", bj.a());
                        jSONObject.put("02002", bj.b());
                        jSONObject.put("02003", bj.c());
                        jSONObject.put("02004", bj.d());
                        jSONObject.put("02005", bj.e());
                        jSONObject.put("02006", bj.f());
                        jSONObject.put("02007", bj.g());
                        jSONObject.put("02018", bj.s());
                        jSONObject.put("02013", bj.m());
                        jSONObject.put("02016", bj.q());
                    }
                    jSONObject.put("02021", bj.d(this.f40068a));
                    jSONObject.put("02022", bj.c(this.f40068a));
                    jSONObject.put("02044", bj.t());
                    jSONObject.put("11009", bq.a(this.f40068a.getApplicationContext()));
                    if (Engine.loadSuccess) {
                        bx bxVar = new bx(this.f40068a);
                        jSONObject.put("04001", bxVar.a("04001") != null ? bxVar.a("04001") : "");
                        jSONObject.put("04002", bxVar.a("04002") != null ? bxVar.a("04002") : "");
                        jSONObject.put("04003", bxVar.a("04003") != null ? bxVar.a("04003") : "");
                        jSONObject.put("04004", bxVar.a("04004") != null ? bxVar.a("04004") : "");
                    } else {
                        try {
                            bh bhVarB = bi.b();
                            jSONObject.put("04001", bi.a());
                            jSONObject.put("04002", bhVarB.b());
                            jSONObject.put("04003", bhVarB.c());
                            jSONObject.put("04004", bhVarB.a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put(PushConsts.SEND_MESSAGE_ERROR, this.c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (d) {
                JSONObject jSONObjectA = new ck(str, ci.j).a(this.f40068a);
                if (jSONObjectA == null) {
                    return null;
                }
                JSONObject jSONObjectA2 = a();
                if (jSONObjectA2 == null) {
                    return null;
                }
                jSONObjectA.put("module_section", jSONObjectA2);
                return jSONObjectA.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
