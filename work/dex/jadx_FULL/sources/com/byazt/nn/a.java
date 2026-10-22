package com.byazt.nn;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.ar.AdDownloadModel;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 34})
public class a {
    public volatile boolean c;
    public final ConcurrentHashMap<Long, com.byazt.dd.tt> n;
    public final ConcurrentHashMap<Long, DownloadModel> tt;
    public final ConcurrentHashMap<Long, DownloadController> uj;
    public final ConcurrentHashMap<Long, DownloadEventConfig> ve;

    @com.byazt.zqa.c(c = {0, 1, 1020, 464})
    public static class c {
        public static a c = new a();
    }

    public void a(long j) {
        this.tt.remove(Long.valueOf(j));
        this.ve.remove(Long.valueOf(j));
        this.uj.remove(Long.valueOf(j));
    }

    @NonNull
    public n n(long j) {
        n nVar = new n();
        nVar.c = j;
        nVar.tt = c(j);
        DownloadEventConfig downloadEventConfigTt = tt(j);
        nVar.ve = downloadEventConfigTt;
        if (downloadEventConfigTt == null) {
            nVar.ve = new com.byazt.su.uj();
        }
        DownloadController downloadControllerVe = ve(j);
        nVar.uj = downloadControllerVe;
        if (downloadControllerVe == null) {
            nVar.uj = new com.byazt.su.ve();
        }
        return nVar;
    }

    public com.byazt.dd.tt uj(long j) {
        return this.n.get(Long.valueOf(j));
    }

    public DownloadController ve(long j) {
        return this.uj.get(Long.valueOf(j));
    }

    private a() {
        this.c = false;
        this.tt = new ConcurrentHashMap<>();
        this.ve = new ConcurrentHashMap<>();
        this.uj = new ConcurrentHashMap<>();
        this.n = new ConcurrentHashMap<>();
    }

    public void tt() {
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.nn.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c) {
                    return;
                }
                synchronized (a.class) {
                    if (!a.this.c) {
                        a.this.n.putAll(i.c().tt());
                        a.this.c = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.byazt.dd.tt> ve() {
        return this.n;
    }

    public static a c() {
        return c.c;
    }

    public DownloadEventConfig tt(long j) {
        return this.ve.get(Long.valueOf(j));
    }

    public void c(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.tt.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.byazt.dd.tt tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.dd.tt ttVar : this.n.values()) {
            if (ttVar != null && str.equals(ttVar.c())) {
                return ttVar;
            }
        }
        return null;
    }

    public void tt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.tt.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void c(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.ve.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void c(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.uj.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void c(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        this.n.put(Long.valueOf(ttVar.tt()), ttVar);
        i.c().c(ttVar);
    }

    public DownloadModel c(long j) {
        return this.tt.get(Long.valueOf(j));
    }

    public com.byazt.dd.tt c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.byazt.dd.tt ttVar : this.n.values()) {
            if (ttVar != null && str.equals(ttVar.n())) {
                return ttVar;
            }
        }
        return null;
    }

    public com.byazt.dd.tt c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.byazt.dd.tt ttVar : this.n.values()) {
            if (ttVar != null && ttVar.my() == downloadInfo.getId()) {
                return ttVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jC = u.c(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jC != 0) {
                    for (com.byazt.dd.tt ttVar2 : this.n.values()) {
                        if (ttVar2 != null && ttVar2.tt() == jC) {
                            return ttVar2;
                        }
                    }
                    com.byazt.dm.ve.c().c("getNativeModelByInfo");
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        for (com.byazt.dd.tt ttVar3 : this.n.values()) {
            if (ttVar3 != null && TextUtils.equals(ttVar3.c(), downloadInfo.getUrl())) {
                return ttVar3;
            }
        }
        return null;
    }

    public com.byazt.dd.tt c(int i) {
        for (com.byazt.dd.tt ttVar : this.n.values()) {
            if (ttVar != null && ttVar.my() == i) {
                return ttVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.byazt.dd.tt> c(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.byazt.dd.tt ttVar : this.n.values()) {
                if (ttVar != null && TextUtils.equals(ttVar.c(), str)) {
                    ttVar.tt(str2);
                    map.put(Long.valueOf(ttVar.tt()), ttVar);
                }
            }
        }
        return map;
    }

    public synchronized void c(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.n.remove(Long.valueOf(jLongValue));
        }
        i.c().c((List<String>) arrayList);
    }
}
