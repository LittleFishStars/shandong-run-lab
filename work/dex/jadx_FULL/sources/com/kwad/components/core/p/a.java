package com.kwad.components.core.p;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.o;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static boolean ajy = false;

    /* JADX INFO: renamed from: com.kwad.components.core.p.a$a, reason: collision with other inner class name */
    public static final class C1219a {
        private static final a ajA = new a();
    }

    public static n S(long j) {
        return new n(j);
    }

    private static n a(long j, AdTemplate adTemplate, String str) {
        return new n(j, adTemplate, str);
    }

    private static n b(long j, AdTemplate adTemplate) {
        return new n(j, adTemplate);
    }

    public static a vL() {
        return C1219a.ajA;
    }

    public final void aL(Context context) {
        n nVarS = S(11L);
        p pVar = (p) d.f(p.class);
        if (pVar != null) {
            JSONArray[] jSONArrayArrB = pVar.b(context, e.FL());
            nVarS.aVE = jSONArrayArrB[0];
            nVarS.aVF = jSONArrayArrB[1];
            g.a(nVarS);
        }
    }

    public final void bQ(int i) {
        n nVarS = S(10104L);
        nVarS.aVM = i;
        g.a(nVarS);
    }

    public final void bR(int i) {
        n nVarS = S(10107L);
        nVarS.aVN = i;
        g.a(nVarS);
    }

    public final void bd(@NonNull AdTemplate adTemplate) {
        g.a(b(10007L, adTemplate));
    }

    public final void be(@NonNull AdTemplate adTemplate) {
        g.a(b(10208L, adTemplate));
    }

    public final void bf(@NonNull AdTemplate adTemplate) {
        g.a(b(10209L, adTemplate));
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n nVarS = S(10200L);
        nVarS.aVQ = jSONArray;
        g.a(nVarS);
    }

    public final void e(@NonNull JSONObject jSONObject, int i) {
        n nVarS = S(10201L);
        ac.putValue(jSONObject, "appChangeType", i);
        nVarS.aVP = jSONObject;
        g.a(nVarS);
    }

    public final void g(AdTemplate adTemplate, int i, String str) {
        n nVarB = b(10109L, adTemplate);
        nVarB.aVN = 1;
        nVarB.aVO = str;
        g.a(nVarB);
    }

    public final void h(@NonNull AdTemplate adTemplate, long j) {
        n nVarB = b(10202L, adTemplate);
        nVarB.aVU = j;
        g.a(nVarB);
    }

    public final void i(AdTemplate adTemplate, int i) {
        n nVarB = b(10108L, adTemplate);
        nVarB.aVN = i;
        g.a(nVarB);
    }

    public final void j(AdTemplate adTemplate, long j) {
        n nVarB = b(10207L, adTemplate);
        nVarB.aWl = j;
        g.a(nVarB);
    }

    public final void l(@NonNull AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(12006L, adTemplate);
        nVarB.aqR = i;
        nVarB.aMA = i2;
        g.a(nVarB);
    }

    public final void m(@NonNull AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(10002L, adTemplate);
        nVarB.Nd();
        if (com.kwad.sdk.core.response.helper.e.eG(adTemplate)) {
            nVarB.aVL = com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        } else {
            nVarB.aVL = com.kwad.sdk.core.response.helper.e.eQ(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            nVarB.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        g.a(nVarB);
    }

    public final n o(String str, String str2) {
        n nVarS = S(12200L);
        nVarS.aWt = str;
        nVarS.aWu = str2;
        return nVarS;
    }

    public final void vM() {
        if (ajy) {
            return;
        }
        ajy = true;
        i.execute(new bi() { // from class: com.kwad.components.core.p.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                n nVarS = a.S(8L);
                nVarS.aWm = f.Ia();
                g.a(nVarS);
            }
        });
    }

    public final void vN() {
        g.a(S(10101L));
    }

    public final void vO() {
        g.a(S(10106L));
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10003L, adTemplate);
        nVarB.aVL = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10005L, adTemplate);
        if (com.kwad.sdk.core.response.helper.e.eG(adTemplate)) {
            nVarB.aVL = com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        } else {
            nVarB.aVL = com.kwad.sdk.core.response.helper.e.eQ(adTemplate);
        }
        nVarB.aVL = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void c(long j, int i) {
        if (e.Kq()) {
            n nVarS = S(20000L);
            nVarS.timestamp = System.currentTimeMillis();
            nVarS.aWv = i;
            nVarS.posId = j;
            nVarS.aWw = BuildConfig.VERSION_CODE;
            g.a(nVarS);
        }
    }

    public final void h(@NonNull AdTemplate adTemplate, int i, String str) {
        n nVarB = b(107L, adTemplate);
        nVarB.errorCode = i;
        nVarB.errorMsg = str;
        g.a(nVarB);
    }

    public final void i(AdTemplate adTemplate, long j) {
        n nVarB = b(10206L, adTemplate);
        nVarB.aWk = j;
        g.a(nVarB);
    }

    public final void j(@NonNull AdTemplate adTemplate, int i) {
        if (e.Kq()) {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            n nVarS = S(20000L);
            nVarS.timestamp = System.currentTimeMillis();
            nVarS.aWv = i;
            nVarS.trace = adInfoEO.trace;
            nVarS.aWw = BuildConfig.VERSION_CODE;
            nVarS.posId = com.kwad.sdk.core.response.helper.e.eH(adTemplate);
            g.a(nVarS);
        }
    }

    public final void e(String str, String str2, boolean z) {
        g.a(o(str, str2), z);
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        g.a(a(i, adTemplate, str));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        n nVarB = b(10203L, adTemplate);
        nVarB.apv = j;
        nVarB.blockDuration = j2;
        nVarB.aVB = i;
        g.a(nVarB);
    }

    public final void a(boolean z, List<Integer> list) {
        n nVarS = S(10204L);
        nVarS.aVW = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            nVarS.aVV = jSONArray;
        }
        g.a(nVarS);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        n nVarS = S(10216L);
        nVarS.aVW = z;
        nVarS.aVX = str;
        nVarS.adScene = sceneImpl;
        g.a(nVarS);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, int i) {
        n nVarB = b(104L, adTemplate);
        nVarB.clickTime = o.fs(adTemplate);
        nVarB.aWa = j;
        nVarB.aWb = i;
        g.a(nVarB);
    }

    public final void a(b bVar) {
        n nVarS = S(10215L);
        nVarS.ajo = bVar.ajo;
        nVarS.ajv = bVar.ajv;
        nVarS.ajw = bVar.ajw;
        nVarS.ajx = bVar.ajx;
        g.a(nVarS);
    }
}
