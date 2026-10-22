package com.byazt.twu;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.fl.saas.base.cache.DatabaseHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 13})
public abstract class tt extends com.byazt.uf.c implements ve {
    public final Context tt;
    public com.byazt.rz.c uj;
    public com.byazt.vb.n ve;
    public final List<com.byazt.vb.tt> c = new ArrayList();
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f29079a = new Runnable() { // from class: com.byazt.twu.tt.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (tt.this) {
                if (tt.this.c.isEmpty()) {
                    tt.this.n = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(tt.this.c);
                tt.this.c.clear();
                tt.this.n = false;
                tt.this.tt(arrayList);
            }
        }
    };

    public tt(Context context, com.byazt.vb.n nVar, com.byazt.rz.c cVar) {
        this.tt = context;
        this.ve = nVar;
        this.uj = cVar;
    }

    private void tt() {
        if (this.n) {
            return;
        }
        com.byazt.ho.c cVarC = com.byazt.ho.c.c(uj());
        cVarC.c().postDelayed(this.f29079a, cVarC.tt());
        this.n = true;
    }

    public abstract String c();

    public Context getContext() {
        return this.tt;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0026 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
      0x0026: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x0026: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int n() {
        Cursor cursorQuery = null;
        int i = 0;
        try {
            cursorQuery = com.byazt.ym.tt.query(getContext(), c(), new String[]{"count(1)"}, null, null, null, null, null, this.ve);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                i = cursorQuery.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i;
    }

    public abstract com.byazt.vb.n uj();

    public List<com.byazt.vb.tt> c(int i, int i2, com.byazt.vb.tt ttVar, boolean z) {
        int iTt;
        if (this.uj == null || ttVar == null || !com.byazt.ml.c.c(i) || !c(ttVar) || (iTt = this.uj.tt()) <= i2) {
            return null;
        }
        return c(iTt - i2, DatabaseHelper.COLUMN_ID, i, z);
    }

    public synchronized void tt(com.byazt.vb.tt ttVar) {
        if (c(ttVar) && ttVar.sp() != null && !TextUtils.isEmpty(ttVar.ve())) {
            this.c.add(ttVar);
            tt();
        }
    }

    public com.byazt.uf.tt c(int i, List<com.byazt.vb.tt> list) {
        com.byazt.uf.tt ttVar = new com.byazt.uf.tt();
        if (list != null && list.size() != 0 && list.get(0) != null && c(list.get(0))) {
            if (i != 200 && i != -1 && i != -3) {
                ttVar.c("code:".concat(String.valueOf(i)));
            } else {
                ttVar.c(delete(list));
            }
            ttVar.c(true);
            return ttVar;
        }
        ttVar.c(false);
        return ttVar;
    }

    public void tt(List<com.byazt.vb.tt> list) {
        com.byazt.ym.tt.insert(getContext(), c(), list, this.ve);
        Iterator<com.byazt.vb.tt> it = list.iterator();
        while (it.hasNext()) {
            com.byazt.ml.c.c(it.next(), this.ve, "_db");
        }
    }

    @Override // com.byazt.uf.c
    public List<com.byazt.vb.tt> tt(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list, String str) {
        List<com.byazt.vb.tt> listC = c(DatabaseHelper.COLUMN_ID, i, z);
        if (!c(listC, list)) {
            return null;
        }
        c();
        listC.size();
        return listC;
    }

    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.byazt.vb.tt> it = this.c.iterator();
            while (it.hasNext()) {
                com.byazt.vb.tt next = it.next();
                if (next != null) {
                    String strVe = next.ve();
                    if (!TextUtils.isEmpty(strVe) && list.contains(strVe)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.byazt.ml.ve.c("DBInsertMemRepo", c() + "deleteMemList: " + th.getMessage(), this.ve.n());
        }
    }

    @Override // com.byazt.uf.c
    public boolean tt(int i, String str, com.byazt.vb.tt ttVar) {
        if (this.uj == null) {
            return false;
        }
        int iN = n();
        int iC = this.uj.c();
        com.byazt.ml.ve.c("check db " + c() + " count:" + iN + " MaxCacheCount:" + iC + " message:" + com.byazt.ml.c.tt(i), this.ve);
        return iN >= iC;
    }

    @Override // com.byazt.uf.c
    public boolean c(String str) {
        if (this.uj == null) {
            return false;
        }
        int iN = n();
        com.byazt.ml.ve.c("check flush db " + c() + " count:" + iN, this.ve);
        return iN > 0;
    }

    private boolean c(List<com.byazt.vb.tt> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.byazt.vb.tt> it = list.iterator();
                while (it.hasNext()) {
                    com.byazt.vb.tt next = it.next();
                    if (next != null) {
                        String strVe = next.ve();
                        if (!TextUtils.isEmpty(strVe) && list2.contains(strVe)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.byazt.ml.ve.c("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.ve);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
