package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.kc.aw.lib.constants.BiddingConst;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40083a;

    public ch(Context context) {
        this.f40083a = context;
    }

    public JSONObject a() {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f40083a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (hVarA.b(dd.G, 1) == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (hVarA.b(dd.K, 0) == 1 && Engine.loadSuccess) {
                    ap apVar = new ap(this.f40083a);
                    jSONObject.put("0", apVar.b("0"));
                    jSONObject.put("1", apVar.b("1"));
                    jSONObject.put("2", apVar.b("2"));
                    jSONObject.put("4", apVar.b("4"));
                    jSONObject.put("5", apVar.b("5"));
                    jSONObject.put("6", apVar.b("6"));
                    jSONObject.put("7", apVar.b("7"));
                    jSONObject.put(PrepareException.ERROR_AUTH_FAIL, apVar.b(PrepareException.ERROR_AUTH_FAIL));
                    jSONObject.put("9", apVar.b("9"));
                    jSONObject.put("10", apVar.b("10"));
                    jSONObject.put("11", apVar.b("11"));
                    jSONObject.put("12", apVar.b("12"));
                    jSONObject.put("13", apVar.b("13"));
                    jSONObject.put("14", apVar.b("14"));
                    jSONObject.put("15", apVar.b("15"));
                    jSONObject.put(TinyApp.SUB_TYPE_BRAND_ZONE, apVar.b(TinyApp.SUB_TYPE_BRAND_ZONE));
                    jSONObject.put("17", apVar.b("17"));
                    jSONObject.put("18", apVar.b("18"));
                    jSONObject.put("19", apVar.b("19"));
                    jSONObject.put("20", apVar.b("20"));
                    jSONObject.put("21", apVar.b("21"));
                    jSONObject.put("22", apVar.b("22"));
                    jSONObject.put("23", apVar.b("23"));
                    jSONObject.put("24", apVar.b("24"));
                    jSONObject.put("25", apVar.b("25"));
                    jSONObject.put("26", apVar.b("26"));
                    jSONObject.put("27", apVar.b("27"));
                    jSONObject.put("28", apVar.b("28"));
                    jSONObject.put("29", apVar.b("29"));
                    jSONObject.put("30", apVar.b("30"));
                    jSONObject.put("31", apVar.b("31"));
                    jSONObject.put("32", apVar.b("32"));
                    jSONObject.put("33", apVar.b("33"));
                    jSONObject.put("34", apVar.b("34"));
                    jSONObject.put("35", apVar.b("35"));
                    jSONObject.put("36", apVar.b("36"));
                    jSONObject.put("37", apVar.b("37"));
                    jSONObject.put("38", apVar.b("38"));
                    jSONObject.put("39", apVar.b("39"));
                    jSONObject.put("40", apVar.b("40"));
                    jSONObject.put("41", apVar.b("41"));
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, apVar.b(RoomMasterTable.DEFAULT_ID));
                    jSONObject.put("43", apVar.a("43"));
                    jSONObject.put("44", apVar.a("44"));
                    jSONObject.put("101", apVar.b("101"));
                    jSONObject.put("102", apVar.b("102"));
                    jSONObject.put(BiddingConst.ADN_ID.HW, apVar.b(BiddingConst.ADN_ID.HW));
                    jSONObject.put(BiddingConst.ADN_ID.OPPO, apVar.b(BiddingConst.ADN_ID.OPPO));
                }
                if (hVarA.b(dd.J, 1) == 1 && Engine.loadSuccess) {
                    at atVar = new at(this.f40083a);
                    jSONObject.put("45", atVar.d("45"));
                    if (atVar.a()) {
                        i2 = 1;
                        jSONObject.put("93", 1);
                    } else {
                        i2 = 1;
                    }
                    if (atVar.b()) {
                        jSONObject.put("94", i2);
                    }
                    jSONObject.put("46", atVar.d("46"));
                    jSONObject.put("48", atVar.a("48"));
                    jSONObject.put("51", atVar.b("51"));
                    i = 0;
                    jSONObject.put("52", atVar.a(this.f40083a, "52", 0));
                    jSONObject.put("55", atVar.c("55"));
                    jSONObject.put("66", atVar.a("66"));
                    jSONObject.put("67", dg.d());
                    jSONObject.put("78", atVar.a("78"));
                    jSONObject.put("79", atVar.a("79"));
                    ay ayVar = new ay(this.f40083a, 200);
                    jSONObject.put("70", ayVar.a("70"));
                    jSONObject.put("71", ayVar.a("71"));
                    jSONObject.put("72", ayVar.a("72"));
                    jSONObject.put("73", ayVar.a("73"));
                    jSONObject.put("74", ayVar.a("74"));
                } else {
                    i = 0;
                }
                if (hVarA.b(dd.M, 1) == 1) {
                    aw awVar = new aw(this.f40083a);
                    jSONObject.put("53", awVar.a(this.f40083a, "53", 1));
                    jSONObject.put("56", awVar.a("56"));
                    jSONObject.put("57", awVar.a("57"));
                    jSONObject.put("64", dg.a());
                }
                if (hVarA.b(dd.N, 1) == 1) {
                    cq cqVar = new cq();
                    jSONObject.put("98", cqVar.a());
                    jSONObject.put(BiddingConst.ADN_ID.VIVO, cqVar.b());
                    String strD = am.d();
                    if (!TextUtils.isEmpty(strD)) {
                        jSONObject.put("77", strD);
                    }
                    jSONObject.put("104", am.c());
                    jSONObject.put(BiddingConst.ADN_ID.MINTEGRAL, dj.e(this.f40083a));
                    aj ajVar = new aj(this.f40083a);
                    jSONObject.put("82", ajVar.h());
                    String strI = ajVar.i();
                    if (!TextUtils.isEmpty(strI)) {
                        jSONObject.put("83", strI);
                    }
                    String strJ = ajVar.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        jSONObject.put("84", strJ);
                    }
                    String strK = ajVar.k();
                    if (!TextUtils.isEmpty(strK)) {
                        jSONObject.put("86", strK);
                    }
                }
                if (hVarA.b(dd.L, 1) == 1) {
                    au auVar = new au(this.f40083a);
                    jSONObject.put("95", auVar.b("95"));
                    jSONObject.put("96", auVar.a() ? 1 : i);
                    jSONObject.put("97", dg.e());
                    try {
                        jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                        jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                        jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
                    } catch (Throwable unused) {
                    }
                }
                jSONObject.put("11006", zE ? 1 : i);
                if (zE2) {
                    i = 1;
                }
                jSONObject.put("11029", i);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new ck(str, ci.j).a(this.f40083a);
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
