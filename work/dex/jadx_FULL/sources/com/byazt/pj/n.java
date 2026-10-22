package com.byazt.pj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.kt.RecyclerView;
import com.byazt.sz.da;
import com.byazt.sz.gt;
import com.byazt.sz.i;
import com.byazt.sz.rh;
import com.byazt.sz.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1693, 46})
public class n extends RecyclerView.c<RecyclerView.gu> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f28945a;
    public List<com.byazt.pj.ve> c;
    public rh da;
    public da i;
    public ve n;
    public gt sl;
    public uj sp;
    public Map<Integer, i.c> tt;
    public com.byazt.pj.uj uj;
    public Context ve;
    public boolean x = true;

    public interface c {
        void P_();

        void Q_();

        View ve();
    }

    /* JADX INFO: renamed from: com.byazt.pj.n$n, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1693, 1143})
    public class C0502n extends RecyclerView.gu implements c {
        public com.byazt.xj.ve nu;
        public z rh;

        public C0502n(View view) {
            super(view);
        }

        @Override // com.byazt.pj.n.c
        public void P_() {
            if (n.this.uj != null) {
                n.this.uj.tt(this.nu);
            }
        }

        @Override // com.byazt.pj.n.c
        public void Q_() {
            if (n.this.uj != null) {
                n.this.uj.c(this.nu);
            }
        }

        public void c(com.byazt.xj.ve veVar) {
            this.nu = veVar;
        }

        public com.byazt.xj.ve p() {
            return this.nu;
        }

        @Override // com.byazt.pj.n.c
        public View ve() {
            return this.nu.i();
        }

        public void c(z zVar) {
            this.rh = zVar;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1693, 934})
    public class tt extends RecyclerView.gu {
        public tt(View view) {
            super(view);
        }
    }

    public interface uj {
        void c(RecyclerView.gu guVar, int i);
    }

    public interface ve {
    }

    public n(Context context) {
        this.ve = context;
    }

    public void c(Map<Integer, i.c> map) {
        this.tt = map;
    }

    public void c(List<com.byazt.pj.ve> list) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.addAll(list);
    }

    public void c(com.byazt.pj.uj ujVar) {
        this.uj = ujVar;
    }

    public void c(da daVar) {
        this.i = daVar;
    }

    public void c(rh rhVar) {
        this.da = rhVar;
    }

    public void c(gt gtVar) {
        this.sl = gtVar;
    }

    public void c(ve veVar) {
        this.n = veVar;
    }

    @Override // com.byazt.kt.RecyclerView.c
    public RecyclerView.gu c(ViewGroup viewGroup, int i) {
        i.c cVar = this.tt.get(Integer.valueOf(i));
        z zVar = new z(this.ve);
        com.byazt.xj.ve<View> veVarC = zVar.c(cVar);
        zVar.c(veVarC);
        if (veVarC != null) {
            veVarC.c(new ViewGroup.LayoutParams(veVarC.or(), veVarC.cu()));
            C0502n c0502n = new C0502n(veVarC.i());
            c0502n.c((com.byazt.xj.ve) veVarC);
            c0502n.c(zVar);
            return c0502n;
        }
        return new tt(new View(this.ve));
    }

    public void c(uj ujVar) {
        this.sp = ujVar;
    }

    @Override // com.byazt.kt.RecyclerView.c
    public int c(int i) {
        return this.c.get(i).tt();
    }

    @Override // com.byazt.kt.RecyclerView.c
    public void c(RecyclerView.gu guVar, int i, List<Object> list) {
        uj ujVar;
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null && this.f28945a != null && TextUtils.equals(obj.toString(), this.f28945a.toString()) && (ujVar = this.sp) != null) {
                    ujVar.c(guVar, i);
                }
            }
            return;
        }
        c(guVar, i);
    }

    @Override // com.byazt.kt.RecyclerView.c
    public void c(RecyclerView.gu guVar, int i) {
        com.byazt.pj.ve veVar;
        com.byazt.pj.uj ujVar;
        if (guVar == null || (veVar = this.c.get(i)) == null || !(guVar instanceof C0502n)) {
            return;
        }
        JSONObject jSONObjectC = veVar.c();
        C0502n c0502n = (C0502n) guVar;
        c0502n.nu.c(new ViewGroup.LayoutParams(c0502n.nu.or(), c0502n.nu.cu()));
        c(jSONObjectC, c0502n.p());
        c(this.ve, jSONObjectC, c0502n.p());
        if (i == 0 && (ujVar = this.uj) != null && this.x) {
            this.x = false;
            ujVar.c(c0502n.nu);
        }
    }

    @Override // com.byazt.kt.RecyclerView.c
    public int c() {
        return this.c.size();
    }

    public void c(Object obj) {
        this.f28945a = obj;
    }

    public void c(JSONObject jSONObject, com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        if (veVar instanceof com.byazt.xj.c) {
            veVar.c(jSONObject);
            List<com.byazt.xj.ve<View>> listSp = ((com.byazt.xj.c) veVar).sp();
            if (listSp == null || listSp.size() <= 0) {
                return;
            }
            Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
            while (it.hasNext()) {
                c(jSONObject, it.next());
            }
            return;
        }
        veVar.c(jSONObject);
    }

    public void c(Context context, JSONObject jSONObject, com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        if (veVar instanceof com.byazt.xj.c) {
            veVar.c(this.i);
            veVar.c(this.da);
            veVar.tt(true);
            veVar.tt();
            List<com.byazt.xj.ve<View>> listSp = ((com.byazt.xj.c) veVar).sp();
            if (listSp == null || listSp.size() <= 0) {
                return;
            }
            Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
            while (it.hasNext()) {
                c(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectGr = veVar.gr();
        Iterator<String> itKeys = jSONObjectGr.keys();
        com.byazt.xj.c cVarD = veVar.d();
        com.byazt.xj.c.C0576c c0576cX = cVarD != null ? cVarD.x() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strC = com.byazt.wj.tt.c(jSONObjectGr.optString(next), jSONObject);
            veVar.c(next, strC);
            veVar.c(this.i);
            veVar.c(this.da);
            if (c0576cX != null) {
                c0576cX.c(context, next, strC);
            }
        }
        veVar.tt(true);
        veVar.tt();
    }
}
