package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40087a;
    private int b;

    public cl(Context context, int i) {
        this.f40087a = context;
        this.b = i;
    }

    public JSONObject a() throws JSONException {
        h hVar;
        String str;
        cl clVar;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f40087a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (hVarA.b(dd.aO, 1) == 1 && (zE || zE2)) {
                String strA = bf.a(this.f40087a);
                if (!TextUtils.isEmpty(strA) && !strA.startsWith("RISK")) {
                    jSONObject.put("01001", strA);
                }
                String strC = bf.c(this.f40087a);
                if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                    jSONObject.put("01003", strC);
                }
                String strB = bf.b(this.f40087a, 0);
                if (!TextUtils.isEmpty(strB) && !strB.startsWith("RISK")) {
                    jSONObject.put("01019", strB);
                }
                String strB2 = bf.b(this.f40087a, 1);
                if (!TextUtils.isEmpty(strB2) && !strB2.startsWith("RISK")) {
                    jSONObject.put("01004", strB2);
                }
                String strD = bf.d(this.f40087a);
                if (!TextUtils.isEmpty(strD) && !strD.startsWith("RISK")) {
                    jSONObject.put("01007", strD);
                }
            }
            if (hVarA.b(dd.aP, 0) == 1 && (zE || zE2)) {
                be beVar = new be();
                if (hVarA.b(dd.bc, 1) == 1) {
                    jSONObject.put("10020", beVar.f(this.f40087a));
                }
            }
            if (hVarA.b(dd.aQ, 1) == 1 && (zE || zE2)) {
                jSONObject.put("01011", bf.e(this.f40087a));
            }
            if (hVarA.b(dd.aR, 1) == 1 && (zE || zE2)) {
                String strP = bf.p(this.f40087a);
                if (!TextUtils.isEmpty(strP) && !strP.startsWith("RISK")) {
                    jSONObject.put("01016", strP);
                }
            }
            if (hVarA.b(dd.aF, 1) == 1) {
                if (zE || zE2) {
                    String strF = bf.f(this.f40087a);
                    if (!TextUtils.isEmpty(strF) && !strF.startsWith("RISK")) {
                        jSONObject.put("01013", strF);
                    }
                    jSONObject.put("02042", bf.u(this.f40087a));
                }
                try {
                    if (Engine.loadSuccess) {
                        try {
                            jSONObject.put("02019", bj.b(this.f40087a));
                            jSONObject.put("02021", bj.d(this.f40087a));
                            jSONObject.put("02022", bj.c(this.f40087a));
                            jSONObject.put("02030", bj.f(this.f40087a));
                            cc ccVar = new cc(this.f40087a);
                            jSONObject.put("01014", ccVar.a("01014") != null ? ccVar.a("01014") : "");
                            jSONObject.put("02001", ccVar.a("02001") != null ? ccVar.a("02001") : bj.a());
                            jSONObject.put("02002", ccVar.a("02002") != null ? ccVar.a("02002") : bj.b());
                            jSONObject.put("02003", ccVar.a("02003") != null ? ccVar.a("02003") : bj.c());
                            jSONObject.put("02004", ccVar.a("02004") != null ? ccVar.a("02004") : bj.d());
                            jSONObject.put("02005", ccVar.a("02005") != null ? ccVar.a("02005") : bj.e());
                            jSONObject.put("02006", ccVar.a("02006") != null ? ccVar.a("02006") : bj.f());
                            jSONObject.put("02007", ccVar.a("02007") != null ? ccVar.a("02007") : bj.g());
                            jSONObject.put("02008", ccVar.a("02008") != null ? ccVar.a("02008") : bj.h());
                            jSONObject.put("02009", ccVar.a("02009") != null ? ccVar.a("02009") : bj.i());
                            jSONObject.put("02010", ccVar.a("02010") != null ? ccVar.a("02010") : bj.j());
                            jSONObject.put("02011", ccVar.a("02011") != null ? ccVar.a("02011") : bj.k());
                            jSONObject.put("02012", ccVar.a("02012") != null ? ccVar.a("02012") : bj.l());
                            jSONObject.put("02013", ccVar.a("02013") != null ? ccVar.a("02013") : bj.m());
                            jSONObject.put("02014", ccVar.a("02014") != null ? ccVar.a("02014") : bj.n());
                            jSONObject.put("02015", ccVar.a("02015") != null ? ccVar.a("02015") : bj.p());
                            jSONObject.put("02016", ccVar.a("02016") != null ? ccVar.a("02016") : bj.q());
                            jSONObject.put("02017", ccVar.a("02017") != null ? ccVar.a("02017") : Integer.valueOf(bj.r()));
                            jSONObject.put("02018", ccVar.a("02018") != null ? ccVar.a("02018") : bj.s());
                            jSONObject.put("02020", ccVar.a("02020") != null ? ccVar.a("02020") : bj.u());
                            jSONObject.put("02023", ccVar.a("02023") != null ? ccVar.a("02023") : "");
                            jSONObject.put("02031", ccVar.a("02031") != null ? ccVar.a("02031") : bj.y());
                            jSONObject.put("02032", ccVar.a("02032") != null ? ccVar.a("02032") : bj.o());
                            jSONObject.put("02033", ccVar.a("02033") != null ? ccVar.a("02033") : bj.x());
                            jSONObject.put("02034", ccVar.a("02034") != null ? ccVar.a("02034") : bj.z());
                            jSONObject.put("02035", ccVar.a("02035") != null ? ccVar.a("02035") : bj.A());
                            jSONObject.put("02036", ccVar.a("02036") != null ? ccVar.a("02036") : "");
                            jSONObject.put("02037", ccVar.a("02037") != null ? ccVar.a("02037") : bj.w());
                            jSONObject.put("02038", ccVar.a("02038") != null ? ccVar.a("02038") : bj.v());
                            jSONObject.put("02045", ccVar.a("02045") != null ? ccVar.a("02045") : bj.B());
                        } catch (Exception unused) {
                        }
                        clVar = this;
                    } else {
                        jSONObject.put("02001", bj.a());
                        jSONObject.put("02002", bj.b());
                        jSONObject.put("02003", bj.c());
                        jSONObject.put("02004", bj.d());
                        jSONObject.put("02005", bj.e());
                        jSONObject.put("02006", bj.f());
                        jSONObject.put("02007", bj.g());
                        jSONObject.put("02008", bj.h());
                        jSONObject.put("02009", bj.i());
                        jSONObject.put("02010", bj.j());
                        jSONObject.put("02011", bj.k());
                        jSONObject.put("02012", bj.l());
                        jSONObject.put("02013", bj.m());
                        jSONObject.put("02014", bj.n());
                        jSONObject.put("02015", bj.p());
                        jSONObject.put("02016", bj.q());
                        jSONObject.put("02017", bj.r());
                        jSONObject.put("02018", bj.s());
                        clVar = this;
                        try {
                            jSONObject.put("02019", bj.b(clVar.f40087a));
                            jSONObject.put("02020", bj.u());
                            jSONObject.put("02021", bj.d(clVar.f40087a));
                            jSONObject.put("02022", bj.c(clVar.f40087a));
                            jSONObject.put("02030", bj.f(clVar.f40087a));
                            jSONObject.put("02031", bj.y());
                            jSONObject.put("02032", bj.o());
                            jSONObject.put("02033", bj.x());
                            jSONObject.put("02034", bj.z());
                            jSONObject.put("02035", bj.A());
                            jSONObject.put("02037", bj.w());
                            jSONObject.put("02038", bj.v());
                            jSONObject.put("02045", bj.B());
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    str = "";
                    jSONObject.put("02067", clVar.f40087a.getApplicationContext().getPackageResourcePath().replace("/data/app/", str).replace("/base.apk", str));
                    jSONObject.put("02039", bf.i());
                    jSONObject.put("02040", bf.j());
                    jSONObject.put("02041", bf.t(clVar.f40087a));
                    jSONObject.put("02044", bj.t());
                    jSONObject.put("02046", bj.C());
                    String strA2 = bf.a("persist.service.adb.enable");
                    if (!TextUtils.isEmpty(strA2)) {
                        jSONObject.put("03058", strA2);
                    }
                    String strA3 = bf.a("sys.resettype");
                    if (!TextUtils.isEmpty(strA3)) {
                        jSONObject.put("03057", strA3);
                    }
                    String strA4 = bf.a("ro.boot.bootreason");
                    if (!TextUtils.isEmpty(strA4)) {
                        jSONObject.put("03056", strA4);
                    }
                    String strA5 = bf.a("ro.runtime.firstboot");
                    if (!TextUtils.isEmpty(strA5)) {
                        jSONObject.put("03055", strA5);
                    }
                    String strA6 = bf.a("init.svc.atcmdserver");
                    if (!TextUtils.isEmpty(strA6)) {
                        jSONObject.put("03054", strA6);
                    }
                    String strA7 = bf.a("ro.build.date.utc");
                    if (!TextUtils.isEmpty(strA7)) {
                        jSONObject.put("03061", strA7);
                    }
                    String strA8 = bf.a("ro.bootimage.build.date.utc");
                    if (!TextUtils.isEmpty(strA8)) {
                        jSONObject.put("03062", strA8);
                    }
                    String strA9 = bf.a("ro.build.date.YmdHM");
                    if (!TextUtils.isEmpty(strA9)) {
                        jSONObject.put("03063", strA9);
                    }
                    String strA10 = bf.a("dhcp.ipv6.wlan0.dns1");
                    if (!TextUtils.isEmpty(strA10)) {
                        jSONObject.put("03067", strA10);
                    }
                    String strA11 = bf.a("dhcp.ipv6.wlan0.dns2");
                    if (!TextUtils.isEmpty(strA11)) {
                        jSONObject.put("03068", strA11);
                    }
                    String strA12 = bf.a("dhcp.wlan0.dns1");
                    if (!TextUtils.isEmpty(strA12)) {
                        jSONObject.put("03069", strA12);
                    }
                    String strA13 = bf.a("dhcp.wlan0.dns2");
                    if (!TextUtils.isEmpty(strA13)) {
                        jSONObject.put("03070", strA13);
                    }
                    String strA14 = bf.a("net.change");
                    if (!TextUtils.isEmpty(strA14)) {
                        jSONObject.put("03071", strA14);
                    }
                    String strA15 = bf.a("net.dns1");
                    if (!TextUtils.isEmpty(strA15)) {
                        jSONObject.put("03072", strA15);
                    }
                    String strA16 = bf.a("net.dns2");
                    if (!TextUtils.isEmpty(strA16)) {
                        jSONObject.put("03073", strA16);
                    }
                    hVar = hVarA;
                    long jA = hVar.a(dd.d, -1L);
                    if (jA != -1) {
                        jSONObject.put("03074", jA + System.currentTimeMillis());
                    }
                    try {
                        jSONObject.put("03064", Settings.System.getInt(clVar.f40087a.getContentResolver(), "screen_brightness_mode"));
                        jSONObject.put("03065", Settings.System.getInt(clVar.f40087a.getContentResolver(), "accelerometer_rotation"));
                    } catch (Throwable unused3) {
                    }
                    jSONObject.put("03081", bj.L());
                    jSONObject.put("03052", bj.i(clVar.f40087a));
                    jSONObject.put("03050", bj.h(clVar.f40087a));
                    jSONObject.put("03049", bj.g(clVar.f40087a));
                    jSONObject.put("02027", bj.H());
                    jSONObject.put("02028", bj.D());
                    jSONObject.put("02029", bj.E());
                    jSONObject.put("02057", bj.F());
                    jSONObject.put("02058", bj.G());
                } catch (Throwable unused4) {
                    return null;
                }
            } else {
                hVar = hVarA;
                str = "";
                clVar = this;
            }
            if (hVar.b(dd.aG, 1) == 1) {
                jSONObject.put("03001", bm.a());
                jSONObject.put("03002", bm.b());
                jSONObject.put("03001", bm.a());
                jSONObject.put("03043", SystemClock.elapsedRealtime());
                jSONObject.put("03044", SystemClock.uptimeMillis());
                jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                bw bwVar = new bw(clVar.f40087a);
                if (Engine.loadSuccess) {
                    jSONObject.put("03004", bwVar.a("03004") != null ? bwVar.a("03004") : str);
                    jSONObject.put("03036", bwVar.b("03036") != null ? bwVar.b("03036") : str);
                    jSONObject.put("03039", bwVar.a("03039") != null ? bwVar.a("03039") : str);
                    jSONObject.put("03040", bwVar.a("03040") != null ? bwVar.a("03040") : str);
                    jSONObject.put("03041", bwVar.a("03041") != null ? bwVar.a("03041") : str);
                    jSONObject.put("03042", bwVar.a("03042") != null ? bwVar.a("03042") : str);
                    jSONObject.put("03079", bwVar.a("03079") != null ? bwVar.a("03079") : null);
                    jSONObject.put("03080", bwVar.a("03080") != null ? bwVar.a("03080") : null);
                }
                jSONObject.put("03007", bt.a(clVar.f40087a));
                jSONObject.put("03008", bt.c(clVar.f40087a));
                jSONObject.put("03011", am.b(clVar.f40087a));
                jSONObject.put("03012", am.b());
                jSONObject.put("03014", bf.g(clVar.f40087a));
                jSONObject.put("03034", bf.h(clVar.f40087a));
                jSONObject.put("03020", bt.b(clVar.f40087a));
                jSONObject.put("03037", bj.I());
                jSONObject.put("03038", bj.J());
                jSONObject.put("03077", bj.K());
                try {
                    be beVar2 = new be();
                    jSONObject.put("03006", beVar2.a(clVar.f40087a));
                    jSONObject.put("03010", beVar2.b(clVar.f40087a));
                    jSONObject.put("03033", beVar2.c(clVar.f40087a));
                    jSONObject.put("03021", beVar2.e(clVar.f40087a));
                    jSONObject.put("03030", be.d(clVar.f40087a));
                    jSONObject.put("10031", beVar2.a());
                } catch (Exception unused5) {
                }
            }
            if (hVar.b(dd.aU, 0) == 1) {
                jSONObject.put("03019", bf.k(clVar.f40087a));
                String strM = bf.m(clVar.f40087a);
                if (!TextUtils.isEmpty(strM)) {
                    jSONObject.put("03047", strM);
                }
            }
            if (hVar.b(dd.aV, 1) == 1) {
                jSONObject.put("02059", bk.a(clVar.f40087a));
                jSONObject.put("02060", bk.a());
                jSONObject.put("02062", bk.c());
                if (Engine.loadSuccess) {
                    by byVar = new by(clVar.f40087a);
                    jSONObject.put("08001", byVar.a("08001") != null ? byVar.a("08001") : str);
                }
                JSONObject jSONObjectD = bk.d();
                if (jSONObjectD != null && jSONObjectD.length() > 0) {
                    jSONObject.put("10050", jSONObjectD);
                }
            }
            hVar.b(dd.aT, 1);
            if (hVar.b(dd.aH, 1) == 1) {
                if (Engine.loadSuccess) {
                    bx bxVar = new bx(clVar.f40087a);
                    jSONObject.put("04001", bxVar.a("04001") != null ? bxVar.a("04001") : str);
                    jSONObject.put("04002", bxVar.a("04002") != null ? bxVar.a("04002") : str);
                    jSONObject.put("04003", bxVar.a("04003") != null ? bxVar.a("04003") : str);
                    jSONObject.put("04004", bxVar.a("04004") != null ? bxVar.a("04004") : str);
                } else {
                    try {
                        bh bhVarB = bi.b();
                        jSONObject.put("04001", bi.a());
                        jSONObject.put("04002", bhVarB.b());
                        jSONObject.put("04003", bhVarB.c());
                        jSONObject.put("04004", bhVarB.a());
                    } catch (Exception unused6) {
                    }
                }
            }
            if (hVar.b(dd.aK, 0) == 1 && (zE || zE2)) {
                JSONArray jSONArrayF = bf.f();
                if (jSONArrayF != null) {
                    jSONObject.put("06014", jSONArrayF);
                }
                if (Engine.loadSuccess) {
                    cd cdVar = new cd(clVar.f40087a);
                    jSONObject.put("06015", cdVar.b("06015") != null ? cdVar.b("06015") : str);
                }
            }
            if (zE != 0 || zE2 != 0) {
                String strH = bf.h();
                if ((TextUtils.isEmpty(strH) || strH.startsWith("RISK")) && strH == null) {
                    jSONObject.put("07005", str);
                } else {
                    jSONObject.put("07005", strH);
                }
            }
            if (hVar.b(dd.aI, 0) == 1 && (zE != 0 || zE2 != 0)) {
                if (Engine.loadSuccess) {
                    jSONObject.put("07007", new ca(clVar.f40087a).a("07007"));
                }
                JSONArray jSONArrayA = bp.a(clVar.f40087a);
                if (jSONArrayA != null && jSONArrayA.length() > 0) {
                    jSONObject.put("03035", jSONArrayA);
                }
            }
            if (zE != 0 || zE2 != 0) {
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
                    jSONObject.put("09001", bf.d());
                } catch (Exception unused7) {
                }
            }
            hVar.b(dd.aM, 0);
            if (hVar.b(dd.aJ, 1) == 1 && Engine.loadSuccess) {
                String strA17 = new cb(clVar.f40087a).a("05001");
                try {
                    if (!TextUtils.isEmpty(strA17) && strA17.length() > 10) {
                        jSONObject.put("05001", new JSONArray(strA17));
                    }
                } catch (Exception unused8) {
                }
            }
            if (Engine.loadSuccess) {
                bz bzVar = new bz(clVar.f40087a);
                jSONObject.put("13001", bzVar.a("13001") != null ? bzVar.a("13001") : str);
            }
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11003", bg.v);
            jSONObject.put("11004", Engine.loadSoCount);
            jSONObject.put("11006", zE != 0 ? 1 : 0);
            jSONObject.put("11029", zE2 != 0 ? 1 : 0);
            jSONObject.put("11008", hVar.b(dd.g, bo.e));
            jSONObject.put("11009", bq.a(clVar.f40087a.getApplicationContext()));
            try {
                String strW = bf.w(clVar.f40087a);
                if (!TextUtils.isEmpty(strW)) {
                    jSONObject.put("01026", strW);
                }
                if (hVar.b(dd.aL, 1) == 1) {
                    String strQO = com.kwad.sdk.e.b.QY().QO();
                    if (!TextUtils.isEmpty(strQO)) {
                        jSONObject.put("11102", strQO);
                    }
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
                }
            } catch (Throwable unused9) {
            }
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
                jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                String string = Settings.Global.getString(clVar.f40087a.getContentResolver(), "Phenotype_boot_count");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("03085", string);
                }
                String string2 = Settings.Global.getString(clVar.f40087a.getContentResolver(), "boot_count");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("03086", string2);
                }
                String string3 = Settings.System.getString(clVar.f40087a.getContentResolver(), "power_on_times");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("03091", string3);
                }
                String string4 = Settings.System.getString(clVar.f40087a.getContentResolver(), "first_boot_flag");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("03104", string4);
                }
            } catch (Throwable unused10) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused11) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new ck(str, ci.j).a(this.f40087a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
