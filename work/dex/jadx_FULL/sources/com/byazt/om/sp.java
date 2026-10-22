package com.byazt.om;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.vx.p;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 91})
public class sp implements c.InterfaceC0486c {
    public List<c> c;
    public com.byazt.iz.tt tt;
    public int uj;
    public int ve;

    public sp(List<c> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.c = copyOnWriteArrayList;
        this.ve = 0;
        this.uj = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    public static /* synthetic */ int a(sp spVar) {
        int i = spVar.uj;
        spVar.uj = i + 1;
        return i;
    }

    public static /* synthetic */ int uj(sp spVar) {
        int i = spVar.ve;
        spVar.ve = i + 1;
        return i;
    }

    @Override // com.byazt.om.c.InterfaceC0486c
    public void c(com.byazt.iz.tt ttVar) {
        if (this.tt != ttVar && ttVar != null) {
            this.tt = ttVar;
        }
        if (p.c(this.c)) {
            return;
        }
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.om.sp.1
            @Override // java.lang.Runnable
            public void run() {
                if (sp.this.ve == 0 && sp.this.tt != null) {
                    sp.this.tt.tt(SystemClock.elapsedRealtime());
                }
                if (sp.this.c.size() > sp.this.ve) {
                    ((c) sp.this.c.get(sp.uj(sp.this))).c(sp.this);
                }
            }
        });
    }

    @Override // com.byazt.om.c.InterfaceC0486c
    public com.byazt.iz.tt c() {
        return this.tt;
    }

    @Override // com.byazt.om.c.InterfaceC0486c
    public void c(String str) {
        com.byazt.iz.tt ttVar;
        if (!TextUtils.isEmpty(str) && (ttVar = this.tt) != null) {
            ttVar.tt(str);
        }
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.om.sp.2
            @Override // java.lang.Runnable
            public void run() {
                if (sp.this.c.size() > sp.this.uj) {
                    ((c) sp.this.c.get(sp.a(sp.this))).tt(sp.this);
                }
            }
        });
    }
}
