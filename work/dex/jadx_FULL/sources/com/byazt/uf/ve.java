package com.byazt.uf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 54})
public class ve implements n {
    public final n c;
    public com.byazt.lph.ve n;
    public final uj tt;
    public com.byazt.vb.n uj;
    public final Queue<String> ve;

    public ve(com.byazt.vb.n nVar, com.byazt.lph.ve veVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.ve = concurrentLinkedQueue;
        this.uj = nVar;
        this.n = veVar;
        this.c = new a(concurrentLinkedQueue, nVar);
        this.tt = new uj(this.uj);
    }

    @Override // com.byazt.uf.n
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list) {
        return null;
    }

    @Override // com.byazt.uf.n
    public synchronized void c(com.byazt.vb.tt ttVar, int i, boolean z) {
        if (z) {
            try {
                if (!com.byazt.ml.c.i(ttVar, this.uj) || !this.n.uj()) {
                    this.c.c(ttVar, i, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ttVar != null) {
            this.tt.c(ttVar, i, z);
        }
    }

    @Override // com.byazt.uf.n
    public int tt() {
        return this.tt.tt();
    }

    @Override // com.byazt.uf.n
    public synchronized tt c(int i, List<com.byazt.vb.tt> list, int i2) {
        tt ttVarC;
        try {
            Iterator<com.byazt.vb.tt> it = list.iterator();
            while (it.hasNext()) {
                this.ve.remove(it.next().ve());
            }
        } catch (Throwable th) {
            tt ttVar = new tt();
            ttVar.c(false);
            ttVar.c("sending exception:" + th.getMessage());
            com.byazt.ml.ve.ve(th.getMessage(), this.uj);
        }
        try {
            this.c.c(i, list, i2);
        } catch (Throwable th2) {
            tt ttVar2 = new tt();
            ttVar2.c(false);
            ttVar2.c("mem exception:" + th2.getMessage());
            com.byazt.ml.ve.ve(th2.getMessage(), this.uj);
        }
        try {
            ttVarC = this.tt.c(i, list, i2);
        } catch (Exception e) {
            tt ttVar3 = new tt();
            ttVar3.c(false);
            ttVar3.c("db exception:" + e.getMessage());
            com.byazt.ml.ve.ve(e.getMessage(), this.uj);
            ttVarC = ttVar3;
        }
        return ttVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.uf.n
    public synchronized List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, String str) {
        List list;
        List<com.byazt.vb.tt> listC;
        boolean z2;
        List<com.byazt.vb.tt> listC2 = this.c.c(i, ttVar, z, (List<String>) null);
        if (listC2 != null && listC2.size() != 0) {
            int size = listC2.size();
            if (com.byazt.ml.c.c(i) && (listC = this.tt.c((com.byazt.vb.tt) listC2.get(0), size, i, z)) != null && listC.size() != 0) {
                list = listC2;
                list = listC2;
                list = listC2;
                listC.size();
                HashMap map = new HashMap();
                for (com.byazt.vb.tt ttVar2 : listC) {
                    map.put(ttVar2.ve(), ttVar2);
                }
                ArrayList arrayList = new ArrayList(this.ve);
                arrayList.size();
                for (com.byazt.vb.tt ttVar3 : listC) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (TextUtils.equals(ttVar3.ve(), (String) it.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        map.remove(ttVar3.ve());
                    }
                }
                for (com.byazt.vb.tt ttVar4 : listC2) {
                    map.put(ttVar4.ve(), ttVar4);
                }
                listC2.clear();
                Set setKeySet = map.keySet();
                map.size();
                Iterator it2 = setKeySet.iterator();
                while (it2.hasNext()) {
                    listC2.add(map.get((String) it2.next()));
                }
                listC.clear();
                list = listC2;
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.ve);
            int size2 = arrayList2.size();
            List<com.byazt.vb.tt> listC3 = this.tt.c(i, ttVar, z, arrayList2);
            if (listC3 != null && listC3.size() != 0) {
                listC3.size();
                HashMap map2 = new HashMap();
                for (com.byazt.vb.tt ttVar5 : listC3) {
                    map2.put(ttVar5.ve(), ttVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listC3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listC3.add(map2.get((String) it3.next()));
                }
            }
            list = listC3;
        }
        if (list != null && !list.isEmpty()) {
            list.size();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.ve.offer(((com.byazt.vb.tt) it4.next()).ve());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.byazt.uf.n
    public synchronized boolean c(int i, String str, com.byazt.vb.tt ttVar) {
        if (this.c.c(i, str, ttVar)) {
            com.byazt.ml.ve.tt("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.uj);
            return true;
        }
        if (!com.byazt.ml.c.c(i) || !this.tt.c(i, str, ttVar)) {
            return false;
        }
        com.byazt.ml.ve.tt("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.uj);
        return true;
    }

    @Override // com.byazt.uf.n
    public int c() {
        return this.c.c();
    }
}
