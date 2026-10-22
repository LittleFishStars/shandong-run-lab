package com.byazt.pj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.cd.x;
import com.byazt.kt.RecyclerView;
import com.byazt.sz.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1693, 34})
public class a extends com.byazt.xj.c<RecyclerView> {
    public uj cf;
    public n.ve ij;
    public List<ve> kz;
    public n mq;
    public tt vi;
    public Map<Integer, i.c> vp;
    public RecyclerView.i yo;

    @com.byazt.zqa.c(c = {0, 1, 1693, 464})
    public static class c extends RecyclerView.x implements n.c {
        public int c;

        public c(int i) {
            this.c = i;
        }

        @Override // com.byazt.pj.n.c
        public void P_() {
        }

        @Override // com.byazt.pj.n.c
        public void Q_() {
        }

        @Override // com.byazt.kt.RecyclerView.x
        public void c(Rect rect, View view, RecyclerView recyclerView, RecyclerView.gt gtVar) {
            super.c(rect, view, recyclerView, gtVar);
            int i = this.c;
            rect.left = i;
            rect.right = i;
            rect.bottom = i;
            if (recyclerView.a(view) == 0) {
                rect.top = this.c;
            }
        }

        @Override // com.byazt.pj.n.c
        public View ve() {
            return null;
        }
    }

    public interface tt {
        void c();

        void c(int i, int i2);

        void c(int i, View view, ve veVar);

        void c(RecyclerView recyclerView, int i);
    }

    public a(Context context) {
        super(context);
        this.vp = new HashMap();
    }

    @Override // com.byazt.xj.ve
    public void c(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.byazt.xj.c
    public com.byazt.xj.c.C0576c x() {
        return null;
    }

    public void c(uj ujVar) {
        this.cf = ujVar;
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
        n nVar = new n(this.tt);
        this.mq = nVar;
        nVar.c(this.xd);
        this.mq.c(this.hq);
        this.mq.c(this.ny);
        this.mq.c(this.cf);
        this.mq.c(this.ij);
        this.mq.c(this.vp);
        this.mq.c(this.kz);
        ((RecyclerView) this.n).setLayoutManager(this.yo);
        ((RecyclerView) this.n).setAdapter(this.mq);
        ((RecyclerView) this.n).c((RecyclerView.x) new c((int) x.c(this.tt, 10.0f)));
        ((RecyclerView) this.n).c((RecyclerView.yp) new com.byazt.pj.tt(new com.byazt.pj.c()) { // from class: com.byazt.pj.a.1
            @Override // com.byazt.pj.tt
            public void c(int i, int i2) {
                if (a.this.vi != null) {
                    a.this.vi.c(i, i2);
                }
            }

            @Override // com.byazt.pj.tt
            public void tt(RecyclerView recyclerView, int i) {
                if (a.this.vi != null) {
                    a.this.vi.c(recyclerView, i);
                }
            }

            @Override // com.byazt.pj.tt
            public void c(int i, View view) {
                if (a.this.vi == null || i < 0 || a.this.kz == null || i >= a.this.kz.size()) {
                    return;
                }
                a.this.vi.c(i, view, (ve) a.this.kz.get(i));
            }

            @Override // com.byazt.pj.tt
            public void c() {
                if (a.this.vi != null) {
                    a.this.vi.c();
                }
            }
        });
    }

    @Override // com.byazt.xj.ve
    public View c() {
        return new RecyclerView(this.tt);
    }

    public void c(tt ttVar) {
        this.vi = ttVar;
    }

    @Override // com.byazt.xj.ve
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
    }

    public void c(List<ve> list) {
        this.kz = list;
    }

    public void c(int i, Object obj) {
        n nVar = this.mq;
        if (nVar != null) {
            nVar.c(obj);
            this.mq.c(i, obj);
        }
    }

    public void c(n.uj ujVar) {
        this.mq.c(ujVar);
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        ((com.byazt.xj.c) this).c.add(veVar);
        if (veVar.eo() != null) {
            this.vp.put(Integer.valueOf(veVar.eo().hashCode()), veVar.md());
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.yo = new com.byazt.kt.n(this.tt);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void tt(List<ve> list) {
        if (this.mq == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.kz == null) {
            this.kz = new ArrayList();
        }
        int size = this.kz.size();
        this.kz.addAll(list);
        this.mq.c(list);
        this.mq.c(size, this.kz.size());
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar, ViewGroup.LayoutParams layoutParams) {
        ((com.byazt.xj.c) this).c.add(veVar);
        this.vp.put(Integer.valueOf(veVar.eo().hashCode()), veVar.md());
    }
}
