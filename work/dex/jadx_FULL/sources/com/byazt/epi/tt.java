package com.byazt.epi;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.nr.gt;
import com.byazt.nr.m;
import com.byazt.vb.a;
import com.byazt.vb.i;
import com.byazt.vb.n;
import com.byazt.vb.sp;
import com.byazt.vb.uj;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1653, 13})
public class tt implements sp {
    public static volatile com.byazt.gs.c uj;
    public n c;
    public Context tt;
    public i ve;

    public tt(com.byazt.vb.c cVar) {
        c(cVar);
    }

    private boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static com.byazt.gs.c n() {
        if (uj == null) {
            synchronized (tt.class) {
                if (uj == null) {
                    uj = new com.byazt.ke.c();
                }
            }
        }
        return uj;
    }

    public void tt(n nVar) {
        this.c = nVar;
        this.tt = nVar.getContext();
        this.ve = new com.byazt.mv.tt(this.c);
    }

    @Override // com.byazt.vb.sp
    public uj uj() {
        n nVar = this.c;
        if (nVar == null) {
            return null;
        }
        return nVar.uj();
    }

    @Override // com.byazt.vb.sp
    public i ve() {
        return this.ve;
    }

    public tt() {
    }

    @Override // com.byazt.vb.sp
    public n tt() {
        n nVar = this.c;
        if (nVar == null) {
            return null;
        }
        return nVar;
    }

    @Override // com.byazt.vb.sp
    public void tt(boolean z) {
        n nVar = this.c;
        if (nVar != null) {
            nVar.c(z);
        }
    }

    public void c(n nVar) {
        tt(nVar);
    }

    private void tt(final com.byazt.vb.tt ttVar) {
        n nVar = this.c;
        if (nVar != null && this.ve != null) {
            final uj ujVarUj = nVar.uj();
            if (ttVar == null || ujVarUj == null || this.c.getContext() == null || ujVarUj.x() == null) {
                return;
            }
            if (this.c.sl()) {
                if (c(this.c.getContext(), ujVarUj)) {
                    this.ve.c(ttVar);
                    return;
                }
                a();
                if (a()) {
                    ujVarUj.x().execute(new com.byazt.ke.tt("dispatchEvent") { // from class: com.byazt.epi.tt.2
                        @Override // java.lang.Runnable
                        public void run() {
                            tt.this.c(ttVar, ujVarUj.da());
                        }
                    });
                    return;
                } else {
                    c(ttVar, ujVarUj.da());
                    return;
                }
            }
            this.ve.c(ttVar);
            return;
        }
        m.uj("log_error", "dispatch event configManager is null");
    }

    @Override // com.byazt.vb.sp
    public void c(a aVar) {
        n nVar = this.c;
        if (nVar != null) {
            if (aVar == null) {
                aVar = com.byazt.shi.tt.c;
            }
            nVar.c(aVar);
        }
    }

    private boolean c(Context context, uj ujVar) {
        if (context == null || ujVar == null) {
            return false;
        }
        if (ujVar.da() == 1) {
            return ujVar.u();
        }
        try {
            return gt.c(context);
        } catch (Throwable th) {
            m.c(th);
            return true;
        }
    }

    @Override // com.byazt.vb.sp
    public void c(final boolean z) {
        final uj ujVarUj;
        n nVar = this.c;
        if (nVar == null || (ujVarUj = nVar.uj()) == null || this.c.getContext() == null || ujVarUj.x() == null) {
            return;
        }
        if (this.c.sl()) {
            if (c(this.c.getContext(), ujVarUj)) {
                i iVar = this.ve;
                if (iVar != null) {
                    iVar.c(z);
                    return;
                }
                return;
            }
            if (a()) {
                ujVarUj.x().execute(new com.byazt.ke.tt("start") { // from class: com.byazt.epi.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n unused = tt.this.c;
                        tt.this.c(ujVarUj.da(), z);
                    }
                });
                return;
            } else {
                c(ujVarUj.da(), z);
                return;
            }
        }
        i iVar2 = this.ve;
        if (iVar2 != null) {
            iVar2.c(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z) {
        if (i == 0 || i == 2) {
            com.byazt.xm.c.c(this.c, z);
        } else if (i == 1) {
            com.byazt.xm.tt.c(this.c, z);
        }
    }

    @Override // com.byazt.vb.sp
    public void c(com.byazt.vb.tt ttVar) {
        tt(ttVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.vb.tt ttVar, int i) {
        if (i == 0 || i == 2) {
            com.byazt.xm.c.c(ttVar, this.c);
        } else if (i == 1) {
            com.byazt.xm.tt.c(ttVar, this.c);
        }
    }

    @Override // com.byazt.vb.sp
    public void c(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        n nVar = this.c;
        if (nVar == null) {
            m.uj("log_error", "track configManager is null");
            return;
        }
        final uj ujVarUj = nVar.uj();
        if (ujVarUj == null || this.c.getContext() == null || ujVarUj.x() == null || !ujVarUj.a()) {
            return;
        }
        if (ujVarUj.da() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (ujVarUj.da() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (this.c.sl() && !c(this.c.getContext(), ujVarUj)) {
            if (a()) {
                ujVarUj.x().execute(new com.byazt.ke.tt("trackFailed") { // from class: com.byazt.epi.tt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c(str, (List<String>) list, z, ujVarUj.da(), jSONObject);
                    }
                });
                return;
            } else {
                c(str, list, z, ujVarUj.da(), jSONObject);
                return;
            }
        }
        com.byazt.pvs.c.c(this.c).c(str, list, z, map, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.byazt.xm.c.c(str, list, z, this.c, jSONObject);
        } else if (i == 1) {
            com.byazt.xm.tt.c(str, list, z, this.c);
        }
    }

    @Override // com.byazt.vb.sp
    public void c(final String str) {
        n nVar = this.c;
        if (nVar == null) {
            com.byazt.ml.ve.ve("log_error", "trackFailedUrls configManager is null", nVar);
            return;
        }
        final uj ujVarUj = nVar.uj();
        if (ujVarUj == null || this.c.getContext() == null || ujVarUj.x() == null || !ujVarUj.a()) {
            return;
        }
        if (ujVarUj.da() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c.sl() && !c(this.c.getContext(), ujVarUj)) {
            if (a()) {
                ujVarUj.x().execute(new com.byazt.ke.tt("trackFailed") { // from class: com.byazt.epi.tt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c(str, ujVarUj.da());
                    }
                });
                return;
            } else {
                c(str, ujVarUj.da());
                return;
            }
        }
        com.byazt.pvs.c.c(this.c).c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i) {
        if (i == 0) {
            com.byazt.xm.c.c(str, this.c);
        } else if (i == 1) {
            com.byazt.xm.tt.c(str, this.c);
        }
    }

    @Override // com.byazt.vb.sp
    public void c() {
        i iVar = this.ve;
        if (iVar != null) {
            iVar.c();
        }
    }
}
