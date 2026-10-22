package com.kwad.sdk.i;

import androidx.annotation.WorkerThread;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class m {
    private static final Map<String, k> biR = new ConcurrentHashMap();
    private static long biS;

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void H(List<k> list) {
        if (list != null) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                biR.remove(it.next().actionId);
            }
        }
    }

    public static void Sd() {
        long jCurrentTimeMillis = System.currentTimeMillis() - biS;
        if (biR.size() <= 0 || jCurrentTimeMillis <= h.RQ().RW()) {
            return;
        }
        biS = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        actionList.size();
        j.Sb();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.Sb();
                m.H(actionList);
            }
        });
    }

    @WorkerThread
    public static synchronized void a(i iVar, boolean z) {
        Map<String, k> map = biR;
        if (map.size() > 200) {
            j.an("LogRequestManger", "enqueueAction fail size limit");
        } else {
            k kVarB = b(iVar, z);
            map.put(kVarB.actionId, kVarB);
        }
        Sd();
    }

    private static k b(i iVar, boolean z) {
        com.kwai.adclient.kscommerciallogger.model.c cVarYq = (z ? com.kwai.adclient.kscommerciallogger.model.c.a.Yo() : com.kwai.adclient.kscommerciallogger.model.c.a.Yp()).c(BusinessType.OTHER).b(SubBusinessType.OTHER).iL("ad_sdk_local_log").iK(iVar.biK).B(iVar.toJson()).Yq();
        return new k(cVarYq.Yi(), cVarYq.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        Map<String, k> map = biR;
        arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }
}
