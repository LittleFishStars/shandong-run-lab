package com.byazt.iym;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.kt.RecyclerView;
import com.byazt.vfu.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 20})
public class c extends RecyclerView.c<n> {
    public final Context c;
    public final float uj;
    public final float ve;
    public final List<tt> tt = new ArrayList();
    public final List<n> n = new ArrayList();

    public c(Context context, float f, float f2) {
        this.c = context;
        this.ve = f;
        this.uj = f2;
    }

    @Override // com.byazt.kt.RecyclerView.c
    public long tt(int i) {
        return i;
    }

    public void uj() {
        Iterator<n> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().cu();
        }
        this.n.clear();
    }

    @Override // com.byazt.kt.RecyclerView.c
    /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
    public n c(ViewGroup viewGroup, int i) {
        n nVar = new n(a.t(this.c));
        this.n.add(nVar);
        return nVar;
    }

    public void c(List<tt> list) {
        this.tt.clear();
        this.tt.addAll(list);
        ve();
    }

    @Override // com.byazt.kt.RecyclerView.c
    public void c(n nVar) {
        super.c(nVar);
        nVar.cu();
    }

    @Override // com.byazt.kt.RecyclerView.c
    public void c(n nVar, int i) {
        List<tt> list = this.tt;
        nVar.c(list.get(i % list.size()), (int) this.ve, (int) this.uj);
    }

    @Override // com.byazt.kt.RecyclerView.c
    public int c() {
        return this.tt.size();
    }
}
