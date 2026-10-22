package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40082a;
    private int b;

    public cg(Context context, int i) {
        this.f40082a = context;
        this.b = i;
    }

    public JSONObject a() {
        JSONArray jSONArrayA;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (!WeaponHI.as) {
                return null;
            }
            h hVarA = h.a(this.f40082a, "re_po_rt");
            int iB = hVarA.b(dd.o, 0);
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (iB == 1 && ((zE || zE2) && (jSONArrayA = new w(this.f40082a).a(0)) != null)) {
                jSONObject.put("10000", jSONArrayA);
                try {
                    jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                    jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                    jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
                } catch (Throwable unused) {
                }
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
            JSONObject jSONObjectA2 = new ck(str, ci.j).a(this.f40082a);
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
