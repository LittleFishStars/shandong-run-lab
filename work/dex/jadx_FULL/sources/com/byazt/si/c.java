package com.byazt.si;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.ga.i;
import com.byazt.ga.rl;
import com.byazt.ga.uj;
import com.byazt.sa.n;
import com.byazt.sz.a;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.sz.z;
import com.byazt.xj.ve;
import com.byazt.xs.da;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 608, 20})
public class c extends tt {
    public boolean cf;
    public View ij;

    /* JADX INFO: renamed from: com.byazt.si.c$5, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 608, 100})
    public class AnonymousClass5 implements uj {
        public AnonymousClass5() {
        }

        @Override // com.byazt.ga.uj
        public Bitmap c(final i iVar) {
            final String strC;
            if (iVar == null) {
                return null;
            }
            String strYp = iVar.yp();
            String strU = iVar.u();
            String strUj = iVar.uj();
            if (!TextUtils.isEmpty(strUj) && strUj.startsWith("${") && "image:".equals(strYp)) {
                strC = com.byazt.wj.tt.c(strUj, c.this.uj);
            } else if (!TextUtils.isEmpty(strYp) && TextUtils.isEmpty(strU)) {
                strC = com.byazt.wj.tt.c(strYp, c.this.uj);
            } else if (!TextUtils.isEmpty(strU) && TextUtils.isEmpty(strYp)) {
                strC = com.byazt.wj.tt.c(strU, c.this.uj);
            } else if (TextUtils.isEmpty(strU) || TextUtils.isEmpty(strYp)) {
                strC = null;
            } else {
                strC = com.byazt.wj.tt.c(strYp, c.this.uj) + com.byazt.wj.tt.c(strU, c.this.uj);
            }
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            Bitmap bitmap = ((tt) c.this).vp.get(strC);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = ((tt) c.this).kz.get(strC);
            if (num == null || num.intValue() == 2) {
                ((tt) c.this).kz.put(strC, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) c.this.n).c(strC, new com.byazt.rs.i() { // from class: com.byazt.si.c.5.1
                @Override // com.byazt.rs.i
                public void c(Bitmap bitmap2) {
                    c.this.c(iVar, strC, bitmap2);
                }

                @Override // com.byazt.rs.i
                public void c() {
                    n.c().tt().c(c.this.i, strC, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.si.c.5.1.1
                        @Override // com.byazt.sa.c.InterfaceC0516c
                        public void c(Bitmap bitmap2) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.c(iVar, strC, bitmap2);
                        }
                    });
                }
            });
            return ((tt) c.this).vp.get(strC);
        }
    }

    /* JADX INFO: renamed from: com.byazt.si.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 608, 44})
    public static class C0520c implements com.byazt.qm.tt {
        public final WeakReference<ve> c;
        public int n;
        public final LottieAnimationView.tt tt;
        public int uj;
        public final Map<String, com.byazt.pm.i> ve = new ConcurrentHashMap();

        public C0520c(ve veVar, LottieAnimationView.tt ttVar) {
            this.c = new WeakReference<>(veVar);
            this.tt = ttVar;
        }

        @Override // com.byazt.qm.tt
        public void c(MotionEvent motionEvent, String str, i iVar, String str2, JSONArray jSONArray, int i, String str3, final com.byazt.qm.c cVar, boolean z) {
            if (motionEvent == null || iVar == null) {
                return;
            }
            String strSp = iVar.sp();
            JSONArray jSONArrayI = iVar.i();
            if (str == null) {
                jSONArray = jSONArrayI;
            } else {
                if (!TextUtils.isEmpty(strSp) || str.contains("CSJNO")) {
                    str2 = strSp;
                }
                if ((jSONArrayI == null || jSONArrayI.length() <= 0) && !str.contains("CSJLELNO")) {
                    strSp = str2;
                } else {
                    strSp = str2;
                    jSONArray = jSONArrayI;
                }
            }
            if (!TextUtils.isEmpty(iVar.m())) {
                str3 = iVar.m();
            }
            if (!TextUtils.isEmpty(str3)) {
                com.byazt.pm.i iVarC = this.ve.get(str);
                if (iVarC == null) {
                    iVarC = com.byazt.pm.i.c(this.c.get(), str3);
                    ve veVar = this.c.get();
                    if (veVar != null) {
                        iVarC.c(veVar.to());
                        iVarC.c(veVar.tk());
                    }
                    iVarC.c(new a() { // from class: com.byazt.si.c.c.1
                        @Override // com.byazt.sz.a
                        public void c(ve veVar2, String str4, List<com.byazt.pm.a.c> list) {
                            com.byazt.qm.c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.c();
                            }
                        }
                    });
                    this.ve.put(str, iVarC);
                }
                if (iVarC.c() != null) {
                    iVarC.c().c("lastEventInView", Boolean.valueOf(z));
                }
                iVarC.c(motionEvent);
                return;
            }
            if (motionEvent.getAction() == 0) {
                this.uj = (int) motionEvent.getX();
                this.n = (int) motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int iAbs = Math.abs(this.uj - x);
                int iAbs2 = Math.abs(this.n - y);
                float f = (int) (i * Resources.getSystem().getDisplayMetrics().density);
                if ((iAbs * iAbs) + (iAbs2 * iAbs2) <= f * f) {
                    if (!TextUtils.isEmpty(strSp) || (jSONArray != null && jSONArray.length() > 0)) {
                        this.tt.c(strSp, jSONArray);
                    }
                    if (cVar != null) {
                        cVar.c();
                    }
                }
            }
        }
    }

    public c(Context context) {
        super(context);
        this.cf = false;
    }

    private void kk() {
        m mVar = new m();
        mVar.c(21);
        mVar.c(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", ((tt) this).c);
            mVar.c(jSONObject);
            this.hq.c(mVar, this, this);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.si.tt, com.byazt.xj.ve
    /* JADX INFO: renamed from: sp */
    public UgenLottieView c() {
        LottieAnimationView.tt ttVar = new LottieAnimationView.tt() { // from class: com.byazt.si.c.1
            @Override // com.byazt.ga.LottieAnimationView.tt
            public void c(String str, JSONArray jSONArray) {
                m mVar = new m();
                mVar.c(1);
                mVar.c(c.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    c.this.c(mVar, jSONArray);
                }
                if (c.this.hq == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lottieEvent", true);
                    jSONObject.put("uttieUrl", ((tt) c.this).c);
                    if (TextUtils.equals("CSJCLOSE", str)) {
                        jSONObject.put("type", "close");
                    } else if (TextUtils.equals("clickEvent", str)) {
                        jSONObject.put("type", "clickEvent");
                    }
                    mVar.c(jSONObject);
                    rh rhVar = c.this.hq;
                    c cVar = c.this;
                    rhVar.c(mVar, cVar, cVar);
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        };
        UgenLottieView ugenLottieViewC = super.c();
        ugenLottieViewC.setTextDelegate(new gt(ugenLottieViewC) { // from class: com.byazt.si.c.2
            @Override // com.byazt.ga.gt
            public String c(String str) {
                return com.byazt.wj.tt.c(str, c.this.uj);
            }
        });
        ugenLottieViewC.setViewDelegate(new rl() { // from class: com.byazt.si.c.3
            @Override // com.byazt.ga.rl
            public View c(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!c.this.cf) {
                    c.this.cf = true;
                    c.this.c(map);
                }
                return c.this.ij;
            }
        });
        ugenLottieViewC.setLottieClicklistener(ttVar);
        ugenLottieViewC.setLottieAnimListener(new LottieAnimationView.c() { // from class: com.byazt.si.c.4
            @Override // com.byazt.ga.LottieAnimationView.c
            public void c(Map<String, Object> map) {
                c.this.c(map, 19);
            }

            @Override // com.byazt.ga.LottieAnimationView.c
            public void tt(Map<String, Object> map) {
                c.this.c(map, 20);
            }
        });
        ugenLottieViewC.setEventMonitorProxy(new C0520c(this, ttVar));
        return ugenLottieViewC;
    }

    @Override // com.byazt.si.tt
    public void x() {
        T t = this.n;
        if (t == 0 || ((UgenLottieView) t).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.n).setImageAssetDelegate(new AnonymousClass5());
        b();
        ((UgenLottieView) this.n).c();
        kk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map, int i) {
        m mVar = new m();
        mVar.c(i);
        mVar.c(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                c(mVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", ((tt) this).c);
                }
                Object obj3 = map.get(t.n);
                if (obj3 instanceof String) {
                    jSONObject.put("type", obj3);
                }
            }
            mVar.c(jSONObject);
            this.hq.c(mVar, this, this);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eo());
        arrayList.add(i == 19 ? "start" : "complete");
        c(tt((ve) this), "Lottie://state", arrayList.toArray());
    }

    private void c(ve veVar, String str, Object... objArr) {
        List<ve<View>> listSp;
        if (veVar == null) {
            return;
        }
        veVar.c(str, objArr);
        if (!(veVar instanceof com.byazt.xj.c) || (listSp = ((com.byazt.xj.c) veVar).sp()) == null || listSp.isEmpty()) {
            return;
        }
        Iterator<ve<View>> it = listSp.iterator();
        while (it.hasNext()) {
            c(it.next(), str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        ve veVarC = c(mVar.c(), strOptString);
                        if (veVarC != null) {
                            veVarC.tt(iOptInt == 0 ? 0 : 8);
                            View viewI = veVarC.i();
                            if (viewI instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewI;
                                if (iOptInt == 0) {
                                    ugenLottieView.c();
                                    kk();
                                } else {
                                    ugenLottieView.a();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ve c(ve veVar, String str) {
        if (veVar == null) {
            return null;
        }
        while (veVar.d() != null) {
            veVar = veVar.d();
        }
        return veVar.uj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        da.c(str, str2, new com.byazt.xs.ve() { // from class: com.byazt.si.c.6
            @Override // com.byazt.xs.ve
            public void c() {
            }

            @Override // com.byazt.xs.ve
            public void c(String str4) {
                try {
                    c.this.c(new JSONObject(str4), iIntValue, iIntValue2, str3);
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, int i, int i2, String str) {
        ve<View> veVarC;
        z zVar = new z(this.tt);
        if (str.startsWith("2")) {
            veVarC = zVar.c(jSONObject);
            zVar.tt(this.uj);
        } else {
            veVarC = str.startsWith("3") ? zVar.c(jSONObject, this.uj, (JSONObject) null) : null;
        }
        if (veVarC != null) {
            this.ij = veVarC.i();
        }
    }
}
