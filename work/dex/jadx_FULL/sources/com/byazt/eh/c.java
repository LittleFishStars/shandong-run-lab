package com.byazt.eh;

import com.byazt.nr.m;
import com.byazt.vb.tt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 888, 20})
public abstract class c<T extends com.byazt.vb.tt> extends com.byazt.uf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28468a;
    public com.byazt.rz.c c;
    public Queue<String> n;
    public String tt;
    public Queue<T> uj = new ConcurrentLinkedQueue();
    public com.byazt.vb.n ve;

    public c(com.byazt.rz.c cVar, Queue<String> queue, String str, com.byazt.vb.n nVar) {
        this.f28468a = -1;
        this.c = cVar;
        this.n = queue;
        this.ve = nVar;
        this.tt = str;
        if (nVar != null) {
            this.f28468a = nVar.t();
        }
    }

    public com.byazt.uf.tt c(int i, List<T> list, int i2) {
        com.byazt.uf.tt ttVar = new com.byazt.uf.tt();
        if (list == null || list.size() == 0 || list.get(0) == null || !c(list.get(0))) {
            ttVar.c(false);
            return ttVar;
        }
        tt(i, list, i2);
        ttVar.c(true);
        return ttVar;
    }

    public void tt(T t) {
        if (this.uj == null || t == null || !c(t)) {
            return;
        }
        if (this.f28468a > 0 && this.uj.size() > this.f28468a) {
            this.uj.poll();
        }
        this.uj.offer(t);
    }

    @Override // com.byazt.uf.c
    public List<com.byazt.vb.tt> tt(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.uj.size();
        do {
            T tPoll = this.uj.poll();
            if (tPoll == null) {
                break;
            }
            tPoll.tt(tPoll.da() + 1);
            arrayList.add(tPoll);
        } while (arrayList.size() != this.c.tt());
        return arrayList;
    }

    @Override // com.byazt.uf.c
    public boolean c(String str) {
        return this.uj.size() > 0;
    }

    public int c() {
        return this.uj.size();
    }

    private void tt(int i, List<T> list, int i2) {
        com.byazt.vb.tt ttVar;
        int size = this.uj.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.uj) {
                if (t != null) {
                    map.put(t.ve(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (ttVar = (com.byazt.vb.tt) map.get(t2.ve())) != null) {
                    try {
                        this.uj.remove(ttVar);
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            }
        }
        this.uj.size();
    }

    @Override // com.byazt.uf.c
    public boolean tt(int i, String str, com.byazt.vb.tt ttVar) {
        int size = this.uj.size();
        int iC = this.c.c();
        com.byazt.ml.c.tt(i);
        return size >= iC;
    }
}
