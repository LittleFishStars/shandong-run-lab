package com.byazt.ux;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.byazt.ete.ic;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.m;
import com.byazt.omf.d;
import com.byazt.ouz.sl;
import com.byazt.sz.da;
import com.byazt.sz.rh;
import com.byazt.sz.yp;
import com.byazt.sz.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 419, 34})
public class a implements rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ic f29119a;
    public Context c;
    public sl da;
    public x i;
    public ve n;
    public d sl;
    public com.byazt.xj.ve sp;
    public String t;
    public com.byazt.ddx.sp tt;
    public int u;
    public uj uj;
    public com.byazt.xj.ve<View> ve;
    public tt x;

    public a(Context context, com.byazt.ddx.sp spVar, ic icVar, String str, int i) {
        this.c = context;
        this.tt = spVar;
        this.f29119a = icVar;
        this.t = str;
        this.u = i;
    }

    @Override // com.byazt.sz.rh
    public void c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(JSONObject jSONObject, List<com.byazt.pj.ve> list, sp spVar) {
        z zVar = new z(this.c);
        yp ypVar = new yp();
        ypVar.c(this.c);
        HashMap map = new HashMap();
        map.put("key_material", this.f29119a);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).c());
        }
        d dVar = new d(this.c);
        this.sl = dVar;
        dVar.c(this.da);
        this.sl.c(this.x);
        this.sl.c(this.t);
        this.sl.ve(this.u);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.sl);
        ypVar.c(map);
        zVar.c("aggPage", ypVar);
        com.byazt.xj.ve<View> veVarC = zVar.c(jSONObject);
        this.ve = veVarC;
        if (veVarC == null || list.size() <= 0) {
            com.byazt.ddx.sp spVar2 = this.tt;
            if (spVar2 != null) {
                spVar2.c(-1, "ugeno render fail");
            }
            if (spVar != null) {
                spVar.c(-1, "");
                return;
            }
            return;
        }
        com.byazt.xj.ve<T> veVarUj = this.ve.uj("recycler_layout");
        this.sp = veVarUj;
        if (veVarUj instanceof com.byazt.pj.a) {
            ((com.byazt.pj.a) veVarUj).c(list);
            ((com.byazt.pj.a) this.sp).c(new com.byazt.pj.a.tt() { // from class: com.byazt.ux.a.2
                @Override // com.byazt.pj.a.tt
                public void c() {
                    if (a.this.uj != null) {
                        a.this.uj.uj(a.this.sp);
                    }
                }

                @Override // com.byazt.pj.a.tt
                public void c(int i2, int i3) {
                    if (a.this.uj != null) {
                        a.this.uj.c(i2, i3);
                    }
                }

                @Override // com.byazt.pj.a.tt
                public void c(RecyclerView recyclerView, int i2) {
                    if (a.this.uj != null) {
                        a.this.uj.c(recyclerView, i2);
                    }
                }

                @Override // com.byazt.pj.a.tt
                public void c(int i2, View view, com.byazt.pj.ve veVar) {
                    if (a.this.uj != null) {
                        a.this.uj.c(a.this.sp, i2, view, veVar);
                    }
                }
            });
            ((com.byazt.pj.a) this.sp).c(new com.byazt.pj.uj() { // from class: com.byazt.ux.a.3
                @Override // com.byazt.pj.uj
                public void c(com.byazt.xj.ve<View> veVar) {
                    if (a.this.uj != null) {
                        a.this.uj.n(veVar);
                    }
                }

                @Override // com.byazt.pj.uj
                public void tt(com.byazt.xj.ve<View> veVar) {
                    if (a.this.uj != null) {
                        a.this.uj.a(veVar);
                    }
                }
            });
        }
        zVar.c(new da() { // from class: com.byazt.ux.a.4
            @Override // com.byazt.sz.da
            public void c(com.byazt.xj.ve veVar) {
                if (a.this.n != null) {
                    a.this.n.ve(veVar);
                }
            }
        });
        zVar.c(this);
        JSONObject jSONObjectYg = this.f29119a.yg();
        if (list.size() > 0) {
            try {
                jSONObjectYg.put("ugen_sub_meta", list.get(0).c());
            } catch (JSONException e) {
                m.c(e);
            }
        }
        zVar.tt(jSONObjectYg);
        this.tt.c(0L);
        if (spVar != null) {
            spVar.c(this.ve);
        }
    }

    public void c(uj ujVar) {
        this.uj = ujVar;
    }

    public void c(x xVar) {
        this.i = xVar;
    }

    public void c(ve veVar) {
        this.n = veVar;
    }

    public void c(final JSONObject jSONObject, final List<com.byazt.pj.ve> list, final sp spVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(jSONObject, list, spVar);
        } else {
            com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.ux.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.tt(jSONObject, (List<com.byazt.pj.ve>) list, spVar);
                }
            });
        }
    }

    public void c(sl slVar) {
        this.da = slVar;
    }

    public void c(tt ttVar) {
        this.x = ttVar;
    }

    public com.byazt.xj.ve c() {
        return this.sp;
    }

    @Override // com.byazt.sz.rh
    public void c(com.byazt.sz.m mVar, rh.tt ttVar, rh.c cVar) {
        x xVar;
        if (mVar == null) {
            return;
        }
        if (mVar.tt() == 1) {
            tt(mVar, (rh.tt) null, (rh.c) null);
            return;
        }
        if (mVar.tt() != 10 || (xVar = this.i) == null) {
            return;
        }
        xVar.tt(mVar.c());
        d dVar = this.sl;
        if (dVar != null) {
            dVar.tt("webviewVisible", (JSONObject) null);
        }
    }

    private void tt(com.byazt.sz.m mVar, rh.tt ttVar, rh.c cVar) {
        if (mVar == null || mVar.c() == null) {
            return;
        }
        JSONObject jSONObjectVe = mVar.ve();
        String strOptString = jSONObjectVe.optString("type");
        String strOptString2 = jSONObjectVe.optString(IpcMessageConstants.EXTRA_NODE_ID);
        strOptString.hashCode();
        if (strOptString.equals("onDismiss")) {
            com.byazt.xj.ve<T> veVarUj = this.ve.uj(strOptString2);
            if (veVarUj != 0) {
                veVarUj.tt(8);
            }
        } else if (!strOptString.equals("onShow")) {
            ve veVar = this.n;
            if (veVar != null) {
                veVar.ve(mVar.c());
            }
        } else {
            com.byazt.xj.ve<T> veVarUj2 = this.ve.uj(strOptString2);
            if (veVarUj2 != 0) {
                veVarUj2.tt(0);
            }
        }
        final String strOptString3 = jSONObjectVe.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ux.a.5
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", strOptString3);
                    return com.byazt.qal.tt.tt().c("agg_click").tt(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (ttVar == null || mVar.uj() == null) {
            return;
        }
        ttVar.c(mVar.uj());
    }
}
