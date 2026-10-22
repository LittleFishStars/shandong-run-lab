package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.igexin.sdk.PushConsts;
import com.kc.aw.lib.constants.BiddingConst;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40085a;
    private int b;
    private int c;

    public cj(Context context, int i, int i2) {
        this.f40085a = context;
        this.b = i;
        this.c = i2;
    }

    public JSONObject a() {
        int i;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f40085a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f40085a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put("24", ajVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f40085a) ? 1 : 0);
            JSONObject jSONObjectA = ai.a(this.f40085a);
            if (jSONObjectA != null) {
                jSONObject.put("4", jSONObjectA);
            }
            z zVar = new z();
            JSONArray jSONArrayA = zVar.a(this.f40085a);
            jSONObject.put("49", jSONArrayA);
            jSONObject.put("146", zVar.e());
            jSONObject.put("154", zVar.a());
            jSONObject.put("168", dh.b(jSONArrayA));
            jSONObject.put("169", dh.a(jSONArrayA));
            jSONObject.put("185", zVar.d());
            jSONObject.put("191", zVar.c());
            if (zVar.b() != null) {
                jSONObject.put("161", zVar.b());
            }
            jSONObject.put("22", ab.a());
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean zA = acVar.a(this.f40085a);
            jSONObject.put(PrepareException.ERROR_AUTH_FAIL, zA ? 1 : 0);
            if (zA) {
                jSONObject.put("61", acVar.b(this.f40085a));
            }
            jSONObject.put("181", acVar.f(this.f40085a) ? 1 : 0);
            jSONObject.put("9", acVar.d(this.f40085a));
            jSONObject.put("10", acVar.e(this.f40085a));
            jSONObject.put("11", acVar.c(this.f40085a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            jSONObject.put("28", aeVar.b("/proc/cpuinfo") ? 1 : 0);
            jSONObject.put("29", aeVar.b("/proc/meminfo") ? 1 : 0);
            jSONObject.put("96", aeVar.a());
            jSONObject.put("134", aeVar.b());
            an anVar = new an();
            Set<String> setB = anVar.b();
            Set<String> setC = anVar.c();
            if (setC != null) {
                jSONObject.put("30", 1);
                jSONObject.put("32", new JSONArray((Collection) setC));
            } else {
                jSONObject.put("30", 0);
            }
            if (setB != null) {
                jSONObject.put("31", 1);
                jSONObject.put("33", new JSONArray((Collection) setB));
            } else {
                jSONObject.put("31", 0);
            }
            Set<String> setA = anVar.a();
            if (setA != null) {
                jSONObject.put("34", setA);
                if (setB != null || setC != null) {
                    HashSet hashSet = new HashSet();
                    if (setB != null) {
                        hashSet.add(setB);
                    }
                    if (setC != null) {
                        hashSet.add(setC);
                    }
                    jSONObject.put("13", anVar.a(this.f40085a, 13, hashSet));
                    jSONObject.put("14", anVar.a(this.f40085a, 14, hashSet));
                    jSONObject.put("15", anVar.a(this.f40085a, 15, hashSet));
                    jSONObject.put(TinyApp.SUB_TYPE_BRAND_ZONE, anVar.a(this.f40085a, 16, hashSet));
                    jSONObject.put("17", anVar.a(this.f40085a, 17, hashSet));
                    jSONObject.put("18", anVar.a(this.f40085a, 18, hashSet));
                    jSONObject.put("19", anVar.a(this.f40085a, 19, hashSet));
                    jSONObject.put("20", anVar.a(this.f40085a, 20, hashSet));
                    jSONObject.put("21", anVar.a(this.f40085a, 21, hashSet));
                    jSONObject.put("130", anVar.b(hashSet));
                }
            }
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean zB = aoVar.b();
            jSONObject.put("66", zB ? 1 : 0);
            if (zB) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            jSONObject.put("103", new ad().a() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bt.a(this.f40085a));
            jSONObject2.put("03014", bf.g(this.f40085a));
            jSONObject2.put("03020", bt.b(this.f40085a));
            jSONObject2.put("03030", be.d(this.f40085a));
            jSONObject.put("51", jSONObject2);
            an anVar2 = new an();
            jSONObject.put(BiddingConst.ADN_ID.VIVO, anVar2.d());
            jSONObject.put("155", anVar2.e());
            jSONObject.put("170", anVar2.g());
            jSONObject.put("190", anVar2.f());
            ah ahVar = new ah();
            jSONObject.put("131", ahVar.a());
            jSONObject.put("145", ahVar.a(this.f40085a));
            jSONObject.put("132", di.a());
            jSONObject.put("133", new aj(this.f40085a).g());
            if (hVarA.b(dd.an, 1) == 1) {
                jSONObject.put("139", dj.c(this.f40085a));
                jSONObject.put("140", dj.d(this.f40085a));
                jSONObject.put("147", dj.a());
                jSONObject.put("148", dg.b());
                jSONObject.put("149", dg.c());
                jSONObject.put("151", di.b());
            }
            if (hVarA.b(dd.ac, 0) == 1) {
                jSONObject.put("128", ad.b() ? 1 : 0);
            }
            if (Engine.loadSuccess) {
                as asVar = new as(this.f40085a, 100);
                jSONObject.put("6", asVar.a("6"));
                JSONArray jSONArrayA2 = asVar.a(asVar.a(), "41");
                if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                    JSONArray jSONArrayC = asVar.c(asVar.a(), "41");
                    JSONArray jSONArrayB = asVar.b(asVar.a(), "41");
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, jSONArrayC);
                    jSONObject.put("43", jSONArrayB);
                    jSONObject.put("41", asVar.a(asVar.a(jSONArrayA2, jSONArrayC), jSONArrayB));
                }
                jSONObject.put("47", asVar.a("47"));
                jSONObject.put("48", asVar.a("48"));
                jSONObject.put("23", asVar.a("23"));
                jSONObject.put("37", asVar.a("37"));
                jSONObject.put("38", asVar.a("38"));
                jSONObject.put("40", asVar.b("40"));
                jSONObject.put("45", asVar.b("45"));
                jSONObject.put("46", asVar.e("46"));
                jSONObject.put("91", asVar.a("91"));
                jSONObject.put("62", asVar.c("62"));
                jSONObject.put("63", asVar.c("63"));
                jSONObject.put("64", asVar.c("64"));
                jSONObject.put("85", asVar.d("85"));
                jSONObject.put("50", asVar.a("50"));
                jSONObject.put("70", asVar.c("70"));
                jSONObject.put("39", asVar.a("39"));
                jSONObject.put("52", asVar.a("52"));
                jSONObject.put("53", asVar.a("53"));
                jSONObject.put("54", asVar.a("54"));
                jSONObject.put("55", asVar.a("55"));
                jSONObject.put("73", asVar.a("73"));
                jSONObject.put("74", asVar.a("74"));
                jSONObject.put("104", asVar.a("104"));
                hVarA.b(dd.X, 1);
                jSONObject.put("77", asVar.a("77"));
                jSONObject.put("78", asVar.a("78"));
                jSONObject.put("79", asVar.a("79"));
                jSONObject.put("84", asVar.a("84"));
                jSONObject.put("80", asVar.a("80"));
                jSONObject.put("81", asVar.a("81"));
                jSONObject.put("82", asVar.a("82"));
                jSONObject.put("83", asVar.a("83"));
                jSONObject.put("87", asVar.a("87"));
                jSONObject.put("89", asVar.a("89"));
                jSONObject.put("90", asVar.d("90"));
                jSONObject.put("75", asVar.a("75"));
                jSONObject.put("88", asVar.a("88"));
                jSONObject.put("92", asVar.a("92"));
                jSONObject.put("93", asVar.a("93"));
                jSONObject.put("94", asVar.a("94"));
                jSONObject.put("95", asVar.a("95"));
                jSONObject.put("98", asVar.a("98"));
                jSONObject.put("100", asVar.a("100"));
                jSONObject.put(BiddingConst.ADN_ID.HW, asVar.a(BiddingConst.ADN_ID.HW));
                if (hVarA.b(dd.Z, 1) == 1) {
                    aq aqVar = new aq(this.f40085a, 0);
                    jSONObject.put(BiddingConst.ADN_ID.ADMOB, aqVar.a(BiddingConst.ADN_ID.ADMOB));
                    jSONObject.put(BiddingConst.ADN_ID.MINTEGRAL, aqVar.a(BiddingConst.ADN_ID.MINTEGRAL));
                    jSONObject.put(BiddingConst.ADN_ID.MM, aqVar.a(BiddingConst.ADN_ID.MM));
                }
                if (hVarA.b(dd.ab, 1) == 1) {
                    aq aqVar2 = new aq(this.f40085a, 1);
                    jSONObject.put(BiddingConst.ADN_ID.QM, aqVar2.b(BiddingConst.ADN_ID.QM));
                    jSONObject.put("113", aqVar2.a("113"));
                    jSONObject.put("114", aqVar2.a("114"));
                    jSONObject.put("115", aqVar2.a("115"));
                    jSONObject.put("116", aqVar2.a("116"));
                    jSONObject.put("117", aqVar2.a("117"));
                    jSONObject.put("120", aqVar2.a("120"));
                    aq aqVar3 = new aq(this.f40085a, 4);
                    jSONObject.put("124", aqVar3.a("124"));
                    jSONObject.put("125", aqVar3.a("125"));
                    jSONObject.put("126", aqVar3.a("126"));
                    jSONObject.put("127", aqVar3.a("127"));
                }
                if (hVarA.b(dd.aj, 0) == 1) {
                    av avVar = new av(this.f40085a, 100);
                    jSONObject.put("97", avVar.a("97"));
                    jSONObject.put("118", avVar.a("118"));
                    jSONObject.put("119", avVar.a("119"));
                    jSONObject.put("135", avVar.a("135"));
                    jSONObject.put("174", avVar.a("174"));
                    av avVar2 = new av(this.f40085a, 200);
                    jSONObject.put("173", avVar2.a("173"));
                    jSONObject.put("182", avVar2.a("182"));
                }
                if (hVarA.b(dd.Y, 1) == 1) {
                    jSONObject.put("129", new bc(this.f40085a, 4).a("129"));
                    bc bcVar = new bc(this.f40085a, 1);
                    jSONObject.put("121", bcVar.a(bcVar.a(), "121"));
                    bc bcVar2 = new bc(this.f40085a, 2);
                    jSONObject.put("137", bcVar2.a("137"));
                    jSONObject.put("138", bcVar2.a("138"));
                    jSONObject.put("141", bcVar2.a("141"));
                    jSONObject.put("142", bcVar2.a("142"));
                    bd bdVar = new bd(this.f40085a, 3);
                    JSONArray jSONArrayB2 = bdVar.b("150");
                    jSONObject.put("150", jSONArrayB2);
                    if (jSONArrayB2 != null) {
                        jSONObject.put("188", bdVar.a(jSONArrayB2));
                    }
                }
                if (hVarA.b(dd.U, 1) == 1) {
                    az azVar = new az(this.f40085a, 100);
                    jSONObject.put("152", azVar.a("152"));
                    jSONObject.put("153", azVar.a("153"));
                    jSONObject.put("156", azVar.a("156"));
                    jSONObject.put("157", azVar.a("157"));
                    jSONObject.put("163", azVar.a("163"));
                    jSONObject.put("171", azVar.a("171", true));
                    jSONObject.put("172", azVar.b("172"));
                    jSONObject.put("177", new az(this.f40085a, 500).d("177"));
                }
                if ((zE || zE2) && hVarA.b(dd.W, 0) == 1) {
                    jSONObject.put("158", new az(this.f40085a, 300).b("158"));
                }
                i = 0;
                if (hVarA.b(dd.am, 0) == 1) {
                    bb bbVar = new bb(this.f40085a);
                    jSONObject.put("162", bbVar.a("162"));
                    jSONObject.put("160", bbVar.a(bbVar.a(), "160"));
                    az azVar2 = new az(this.f40085a, 400);
                    jSONObject.put("164", azVar2.a("164"));
                    jSONObject.put("165", azVar2.a("165"));
                    jSONObject.put("166", azVar2.c("166"));
                    jSONObject.put("167", azVar2.a("167"));
                }
                if (hVarA.b(dd.ak, 1) == 1) {
                    ax axVar = new ax(this.f40085a, 600);
                    jSONObject.put("179", axVar.a("179"));
                    jSONObject.put("186", axVar.a("186"));
                    jSONObject.put("189", axVar.a("189"));
                }
            } else {
                i = 0;
            }
            jSONObject.put("60", ab.b(this.f40085a) ? 1 : i);
            jSONObject.put("11000", Engine.loadSuccess ? 1 : i);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11008", hVarA.b(dd.g, bo.e));
            jSONObject.put("11009", bq.a(this.f40085a.getApplicationContext()));
            try {
                jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
            } catch (Throwable unused) {
            }
            String strB = hVarA.b(dd.m, "", true);
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("183", strB);
                hVarA.c(dd.m, "");
            }
            jSONObject.put("11006", zE ? 1 : i);
            jSONObject.put("11029", zE2 ? 1 : i);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            jSONObject.put(PushConsts.SEND_MESSAGE_ERROR, this.b);
            jSONObject.put(PushConsts.SEND_MESSAGE_ERROR_GENERAL, this.c);
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new ck(str, ci.j).a(this.f40085a);
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
