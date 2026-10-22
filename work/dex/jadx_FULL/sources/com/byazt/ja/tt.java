package com.byazt.ja;

import com.byazt.omf.d;
import com.byazt.pct.nu;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1425, 13})
public final class tt extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public static WeakReference<c> c;
    public WeakReference<d> tt;

    public interface c {
        void c();

        void c(int i);
    }

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    private tt(d dVar) {
        this.tt = new WeakReference<>(dVar);
    }

    public static void c(nu nuVar, final d dVar) {
        nuVar.c("onClickBrowseCloseCallback", new com.byazt.pct.uj.tt() { // from class: com.byazt.ja.tt.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new tt(dVar);
            }
        });
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        WeakReference<c> weakReference = c;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (this.tt == null || jSONObject == null) {
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (cVar != null) {
                cVar.c();
            }
        } else if (cVar != null) {
            cVar.c(iOptInt);
        }
    }

    public static void c(c cVar) {
        c = new WeakReference<>(cVar);
    }
}
