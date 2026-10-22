package com.byazt.nn;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.byazt.gq.t;
import com.byazt.nr.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 42})
public class i {

    @com.byazt.zqa.c(c = {0, 1, 1020, 64})
    public static class c {
        public static i c = new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences ve() {
        return com.byazt.ut.a.getKVStore(t.getContext(), "sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.byazt.dd.tt> tt() {
        ConcurrentHashMap<Long, com.byazt.dd.tt> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = ve().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.byazt.dd.tt ttVarTt = com.byazt.dd.tt.tt(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && ttVarTt != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), ttVarTt);
                    }
                } catch (Exception e) {
                    m.c(e);
                }
            }
        }
        return concurrentHashMap;
    }

    private i() {
    }

    public static i c() {
        return c.c;
    }

    public void c(com.byazt.dd.tt ttVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ttVar);
        c((Collection<com.byazt.dd.tt>) arrayList);
    }

    public synchronized void c(final Collection<com.byazt.dd.tt> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.nn.i.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = i.this.ve().edit();
                        for (com.byazt.dd.tt ttVar : collection) {
                            if (ttVar != null && ttVar.tt() != 0) {
                                editorEdit.putString(String.valueOf(ttVar.tt()), ttVar.s().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void c(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.nn.i.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = i.this.ve().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
