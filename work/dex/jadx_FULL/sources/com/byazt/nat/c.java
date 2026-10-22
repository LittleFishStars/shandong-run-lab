package com.byazt.nat;

import android.content.Context;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1196, 20})
public class c extends com.byazt.zo.c {
    public tt n = new tt();

    /* JADX INFO: renamed from: com.byazt.nat.c$c, reason: collision with other inner class name */
    public interface InterfaceC0470c {
        void c(View view, int i);
    }

    @Override // com.byazt.zo.c
    public int c(Map<String, Object> map, com.byazt.zo.ve veVar) {
        return 0;
    }

    public void c(int i) {
        this.n.tt(i);
    }

    public void tt(boolean z) {
        this.n.uj(z);
    }

    public void uj(boolean z) {
        this.n.tt(z);
    }

    public void ve(boolean z) {
        this.n.ve(z);
    }

    public void c(Map<String, Object> map) {
        this.n.c(map);
    }

    public void tt(int i) {
        if (this.n.uj()) {
            this.n.c(i);
        }
    }

    public void uj() {
        if (this.n.uj()) {
            com.byazt.uz.c cVarN = this.n.n();
            if (!nb.ve(this.c) || cVarN == null) {
                return;
            }
            cVarN.tt();
        }
    }

    public void ve() {
        if (this.n.tt() && this.n.uj()) {
            com.byazt.pop.ve veVarA = this.n.a();
            if (veVarA instanceof com.byazt.wz.c) {
                ((com.byazt.wz.c) veVarA).a(true);
            }
        }
    }

    public void c(String str) {
        this.n.c(str);
    }

    public void c(boolean z) {
        this.n.c(z);
    }

    public tt tt() {
        return this.n;
    }

    public void c(ic icVar) {
        this.c = icVar;
        this.n.c(icVar);
    }

    public void c(Context context) {
        this.tt = context;
        this.n.c(context);
    }

    public void c(com.byazt.pop.ve veVar) {
        this.n.c(veVar);
    }

    public com.byazt.pop.ve c() {
        return this.n.a();
    }

    public void c(Object obj) {
        this.n.c(obj);
    }

    public void c(com.byazt.uz.c cVar) {
        this.n.c(cVar);
    }

    public void c(InterfaceC0470c interfaceC0470c) {
        this.n.c(interfaceC0470c);
    }

    public void c(long j) {
        this.n.c(j);
    }

    public void c(com.byazt.zd.tt ttVar) {
        this.n.c(ttVar);
    }
}
