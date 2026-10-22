package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ah {
    private static AtomicInteger bpq = new AtomicInteger(0);
    private static volatile boolean bpr = false;
    private static volatile boolean bps;

    private static int US() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int iFT = hVar.FT();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + iFT);
        return iFT;
    }

    private static void UT() {
        if (bpr) {
            return;
        }
        bpq.set(UW());
        bps = bq.m("kssdk_kv_mode", "downgrade", false);
        bpr = true;
    }

    public static void UU() {
        if (UX() || US() == 0) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ah.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.utils.b.a aVarUV = ah.UV();
                if (aVarUV == null) {
                    return;
                }
                ah.c(aVarUV);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(aVarUV);
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a UV() {
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences sharedPreferencesM1068if = bq.m1068if("ksadsdk_kv_perf");
        if (sharedPreferencesM1068if == null) {
            return null;
        }
        try {
            Map<String, ?> all = sharedPreferencesM1068if.getAll();
            if (all == null) {
                return null;
            }
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
            aVar.bsH = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
            Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
            while (it2.hasNext()) {
                editorEdit.putInt(it2.next().getKey(), 0);
            }
            editorEdit.apply();
            d(aVar);
            e(aVar);
        } catch (Throwable unused) {
        }
        return aVar;
    }

    private static int UW() {
        int iB = bq.b("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + iB);
        return iB;
    }

    private static boolean UX() {
        UT();
        return bpq.get() == 0;
    }

    private static boolean UY() {
        return true;
    }

    private static int UZ() {
        UT();
        int iUS = (bps || !UY()) ? 0 : US();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + iUS);
        return iUS;
    }

    public static void Va() {
        UT();
        int i = bpq.get();
        int iUZ = UZ();
        boolean z = i != iUZ;
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(iUZ);
        }
    }

    private static void Vb() {
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ah.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    Context context = ai.getContext();
                    if (context == null) {
                        return;
                    }
                    Iterator<String> it = com.kwad.sdk.j.a.aGc.iterator();
                    while (it.hasNext()) {
                        ah.Y(context, it.next());
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                ah.fV(0);
                ah.bpq.set(0);
            }
        });
    }

    private static void Vc() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ah.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    Context context = ai.getContext();
                    if (context != null) {
                        Iterator<String> it = com.kwad.sdk.j.a.aGc.iterator();
                        while (it.hasNext()) {
                            ah.X(context, it.next());
                        }
                        ah.fV(1);
                        ah.bpq.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void X(Context context, String str) {
        SharedPreferences sharedPreferencesM1068if;
        com.kwad.sdk.utils.a.c cVarAF = com.kwad.sdk.utils.a.e.aF(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (sharedPreferencesM1068if = bq.m1068if(str)) == null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (cVarAF.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences sharedPreferencesM1068if2 = bq.m1068if(str);
        if (sharedPreferencesM1068if2 == null) {
            cVarAF.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        cVarAF.putAll(sharedPreferencesM1068if2.getAll());
        cVarAF.putBoolean("sp_to_kv_transfer_flag", true);
        bq.az(str, "kv_to_sp_transfer_flag");
        a(str, cVarAF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Y(Context context, String str) {
        SharedPreferences sharedPreferencesM1068if = bq.m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (sharedPreferencesM1068if.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c cVarAF = com.kwad.sdk.utils.a.e.aF(context, str);
        Map<String, Object> all = cVarAF.getAll();
        if (all.isEmpty()) {
            bq.l(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bq.a(str, all);
        bq.l(str, "kv_to_sp_transfer_flag", true);
        cVarAF.remove("sp_to_kv_transfer_flag");
        cVarAF.release();
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (com.kwad.sdk.j.a.aGd.contains(str)) {
            return;
        }
        cVar.release();
    }

    @WorkerThread
    public static void aw(final String str, final String str2) {
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ah.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    int iB = bq.b("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bq.az("ksadsdk_kv_perf", str);
                    } else {
                        bq.a("ksadsdk_kv_perf", str, iB + 1);
                    }
                } catch (Exception e) {
                    bq.az("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        });
    }

    public static void ax(final String str, final String str2) {
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ah.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                SharedPreferences sharedPreferencesM1068if = bq.m1068if("ksadsdk_kv_perf");
                if (sharedPreferencesM1068if != null && sharedPreferencesM1068if.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bq.a("ksadsdk_kv_perf_failed", str, bq.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bq.a("ksadsdk_kv_perf_success", str, bq.b("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        int i = aVar.bsI;
        if (((double) i) / ((double) (i + aVar.bsJ)) > 0.10000000149011612d) {
            bps = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bq.l("kssdk_kv_mode", "downgrade", true);
        }
        if (bps) {
            Va();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesM1068if = bq.m1068if("ksadsdk_kv_perf_failed");
        int iIntValue = 0;
        if (sharedPreferencesM1068if == null) {
            aVar.bsI = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesM1068if.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bsI = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesM1068if = bq.m1068if("ksadsdk_kv_perf_success");
        int iIntValue = 0;
        if (sharedPreferencesM1068if == null) {
            aVar.bsJ = 0;
            return;
        }
        Map<String, ?> all = sharedPreferencesM1068if.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.bsJ = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public static void fV(int i) {
        bq.a("kssdk_kv_mode", "mode", i);
    }

    private static boolean hM(String str) {
        return com.kwad.sdk.j.a.aGc.contains(str);
    }

    public static boolean hN(String str) {
        boolean z = UX() || !hM(str);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "shouldUseModeSp:" + z);
        return z;
    }

    private static void transfer(int i) {
        if (i == 0) {
            Vb();
        } else if (i == 1) {
            Vc();
        }
    }
}
