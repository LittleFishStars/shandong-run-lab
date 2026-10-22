package com.byazt.ma;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.p;
import com.byazt.ete.pu;
import com.byazt.ete.u;
import com.byazt.omf.gt;
import com.byazt.sy.EasyPlayableContainer;
import com.byazt.sy.sp;
import com.byazt.sz.qy;
import com.byazt.xl.x;
import com.byazt.xl.yp;
import com.byazt.xs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 20})
public class c extends com.byazt.sy.tt implements com.byazt.qdk.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28784a;
    public final sp da;
    public Context i;
    public View n;
    public com.byazt.atv.n sp;
    public ir uj;
    public com.byazt.dj.tt x;

    public c(ic icVar, com.byazt.sy.c cVar, ir irVar) {
        super(icVar, cVar);
        this.f28784a = false;
        this.da = new sp() { // from class: com.byazt.ma.c.1
            @Override // com.byazt.sy.sp
            public void c() {
            }

            @Override // com.byazt.sy.sp
            public void c(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("second_page_type", i);
                } catch (JSONException unused) {
                }
                com.byazt.sy.ve.tt(c.this.c, c.this.uj, false, jSONObject);
                c.this.c(i);
            }

            @Override // com.byazt.sy.sp
            public void c(boolean z) {
            }

            @Override // com.byazt.sy.sp
            public void n() {
                c.this.a();
            }

            @Override // com.byazt.sy.sp
            public void tt() {
                c.this.f28784a = true;
                c.this.sp();
            }

            @Override // com.byazt.sy.sp
            public void uj() {
                if (p.c() && c.this.ve != null) {
                    c.this.ve.c(c.this.c);
                }
            }

            @Override // com.byazt.sy.sp
            public void ve() {
                c.this.f28784a = false;
                View view = c.this.n;
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        };
        this.uj = irVar;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.a.uj(com.byazt.ip.sp.c(this.c), 2);
    }

    public int ve() {
        return 2;
    }

    private boolean i() {
        return pu.c(this.c) == 1;
    }

    private void ve(final ViewGroup viewGroup, final View view) {
        ir irVar = this.uj;
        if (irVar == null) {
            return;
        }
        da.c(this.uj.da(), irVar.i(), new com.byazt.xs.ve() { // from class: com.byazt.ma.c.2
            @Override // com.byazt.xs.ve
            public void c(String str) {
                try {
                    com.byazt.rgb.a.c(com.byazt.ip.sp.c(c.this.c), 1);
                    com.byazt.sy.ve.c(c.this.c, (u) c.this.uj, true);
                    c.this.c(new JSONObject(str), viewGroup, view);
                } catch (JSONException unused) {
                    com.byazt.rgb.a.c(com.byazt.ip.sp.c(c.this.c), 2);
                    com.byazt.sy.ve.c(c.this.c, (u) c.this.uj, false, 3);
                }
            }

            @Override // com.byazt.xs.ve
            public void c() {
                com.byazt.rgb.a.c(com.byazt.ip.sp.c(c.this.c), 2);
                com.byazt.sy.ve.c(c.this.c, (u) c.this.uj, false, 4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.sp.c(this.da);
        this.sp.c(this.tt);
        this.sp.c(this);
        this.sp.c(new x() { // from class: com.byazt.ma.c.4
            @Override // com.byazt.xl.x
            public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
                com.byazt.rgb.a.uj(com.byazt.ip.sp.c(c.this.c));
                if (c.this.tt != null) {
                    c.this.tt.c(view, i, veVar, c.this.uj);
                }
            }

            @Override // com.byazt.xl.x
            public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
                com.byazt.rgb.a.uj(com.byazt.ip.sp.c(c.this.c));
                if (c.this.tt != null) {
                    c.this.tt.c(view, i, veVar, c.this.uj);
                }
            }
        });
        this.sp.c(new com.byazt.sy.x() { // from class: com.byazt.ma.c.5
            @Override // com.byazt.sy.x
            public void c() {
                com.byazt.rgb.a.uj(com.byazt.ip.sp.c(c.this.c), 1);
                c.this.a();
            }
        });
    }

    public void a() {
        uj();
        com.byazt.rgb.a.uj(com.byazt.ip.sp.c(this.c), 1);
        com.byazt.kyz.c cVar = this.ve;
        if (cVar != null) {
            cVar.ve();
        }
    }

    public void n() {
        a();
        this.n = null;
        com.byazt.atv.n nVar = this.sp;
        if (nVar != null) {
            nVar.c((sp) null);
            this.sp.c((x) null);
            this.sp.c((com.byazt.sy.x) null);
            this.sp.t();
            this.sp = null;
        }
    }

    public void sp() {
        View view = this.n;
        if (view == null || !this.f28784a) {
            return;
        }
        view.setVisibility(0);
    }

    public void tt(ViewGroup viewGroup, View view) {
        if (c(viewGroup, view)) {
            ve(viewGroup, view);
        } else {
            com.byazt.rgb.a.c(com.byazt.ip.sp.c(this.c), 2);
        }
    }

    public void uj() {
        final View view = this.n;
        if (view == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(view);
        } else {
            view.post(new Runnable() { // from class: com.byazt.ma.c.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.tt(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void tt(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        ViewParent parent = view.getParent();
        if (parent instanceof EasyPlayableContainer) {
            ViewParent parent2 = parent.getParent();
            ((ViewGroup) parent).removeView(view);
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView((View) parent);
                return;
            }
            return;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public boolean c(ViewGroup viewGroup, View view) {
        ir irVar = this.uj;
        if (irVar != null && view != null && viewGroup != null) {
            if (!irVar.t()) {
                com.byazt.sy.ve.c(this.c, (u) this.uj, false, 6);
                return false;
            }
            if (com.byazt.sy.uj.c(viewGroup)) {
                String name = viewGroup.getClass().getName();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("container_name", name);
                    jSONObject.put("enable_layout_restrict", gt.tt().bj());
                } catch (JSONException unused) {
                }
                com.byazt.sy.ve.c(this.c, (u) this.uj, false, 1, jSONObject);
                return false;
            }
            if (!com.byazt.sy.uj.c(this.c, true)) {
                com.byazt.sy.ve.c(this.c, (u) this.uj, false, 2);
                return false;
            }
            gt.tt().sl();
            if (this.uj.x() == 1) {
                com.byazt.sy.ve.c(this.c, (u) this.uj, false, 11);
                return false;
            }
            if (this.uj.c(view.getWidth(), view.getHeight())) {
                return true;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("view_width", view.getWidth());
                jSONObject2.put("view_height", view.getHeight());
            } catch (JSONException unused2) {
            }
            com.byazt.sy.ve.c(this.c, (u) this.uj, false, 10, jSONObject2);
            return false;
        }
        com.byazt.sy.ve.c(this.c, (u) irVar, false, 5);
        return false;
    }

    @Override // com.byazt.sy.tt
    public u tt() {
        return this.uj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final JSONObject jSONObject, final ViewGroup viewGroup, final View view) {
        viewGroup.post(new Runnable() { // from class: com.byazt.ma.c.3
            @Override // java.lang.Runnable
            public void run() {
                ir irVar;
                if (c.this.c == null || (irVar = c.this.uj) == null) {
                    com.byazt.sy.ve.c(c.this.c, (u) c.this.uj, false, 100, "materialMeta or ugenComponent is null");
                    return;
                }
                int iVe = irVar.ve();
                com.byazt.atv.tt ttVarC = c.this.c(view, c.this.c(iVe, jSONObject, view));
                c cVar = c.this;
                cVar.sp = cVar.c(iVe, ttVarC, viewGroup);
                c.this.x();
                final int i = iVe != 3 ? 2 : 3;
                com.byazt.rgb.a.c().c(com.byazt.ip.sp.c(c.this.c), new com.byazt.ip.uj.c() { // from class: com.byazt.ma.c.3.1
                    @Override // com.byazt.ip.uj.c
                    public void c(com.byazt.ip.tt ttVar) {
                        if (ttVar instanceof com.byazt.ha.x) {
                            ((com.byazt.ha.x) ttVar).uj = i;
                        }
                    }
                });
                com.byazt.rgb.a.ve(com.byazt.ip.sp.c(c.this.c));
                com.byazt.sy.ve.tt(c.this.c, c.this.uj);
                c.this.sp.c(new com.byazt.xl.sp() { // from class: com.byazt.ma.c.3.2
                    @Override // com.byazt.xl.sp
                    public void c(View view2, yp ypVar) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c.this.c(view2, viewGroup, view);
                    }

                    @Override // com.byazt.xl.sp
                    public void c(int i2, String str) {
                        if (c.this.tt != null) {
                            c.this.tt.c(viewGroup);
                        }
                        com.byazt.rgb.a.tt(com.byazt.ip.sp.c(c.this.c), 2);
                        com.byazt.sy.ve.c(c.this.c, (u) c.this.uj, false, i2, str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(int i, JSONObject jSONObject, View view) {
        if (i != 3) {
            return jSONObject;
        }
        return com.byazt.jlk.tt.c(this.c, com.byazt.jlk.tt.c(view), jSONObject, i(), null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.atv.tt c(View view, JSONObject jSONObject) {
        com.byazt.atv.tt.c cVar = new com.byazt.atv.tt.c();
        cVar.n(da.c(this.c, view, i()));
        cVar.c(jSONObject);
        cVar.c((qy) new com.byazt.ouz.gt());
        cVar.tt(view.getHeight());
        cVar.c(view.getWidth());
        cVar.c(com.byazt.omf.x.m().uj());
        cVar.da(this.c.eo());
        cVar.sl(ve());
        return cVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.atv.n c(int i, com.byazt.atv.tt ttVar, ViewGroup viewGroup) {
        if (i == 3) {
            return new com.byazt.atv.sp(gt.getContext(), this.c, ttVar, viewGroup);
        }
        return new com.byazt.atv.n(gt.getContext(), this.c, ttVar, viewGroup);
    }

    @Override // com.byazt.qdk.tt
    public boolean c(String str, com.byazt.xj.ve veVar, com.byazt.qdk.ve veVar2) {
        str.hashCode();
        if (!str.equals("closeWidget")) {
            return false;
        }
        a();
        return true;
    }

    @Override // com.byazt.qdk.tt
    public void c(String str) {
        str.hashCode();
        if (str.equals("clickEvent") || str.equals("convert")) {
            com.byazt.sy.ve.c(this.c, (u) this.uj, false, (JSONObject) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, ViewGroup viewGroup, View view2) {
        if (view == null) {
            com.byazt.rgb.a.tt(com.byazt.ip.sp.c(this.c), 2);
            com.byazt.sy.ve.c(this.c, (u) this.uj, false, 101, "renderView is null");
            return;
        }
        com.byazt.rgb.a.tt(com.byazt.ip.sp.c(this.c), 1);
        com.byazt.sy.ve.tt(this.c, this.uj, true);
        this.n = view;
        view.setVisibility(8);
        if (!c(view)) {
            com.byazt.rgb.a.ve(com.byazt.ip.sp.c(this.c), 2);
            com.byazt.sy.ve.tt(this.c, this.uj, false, 103, new JSONObject());
        } else {
            View view3 = this.n;
            com.byazt.atv.n nVar = this.sp;
            c(viewGroup, view2, view3, nVar != null ? nVar.n() : null);
            sp();
        }
    }

    private boolean c(View view) {
        View childAt;
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return false;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if ((this.sp instanceof com.byazt.atv.sp) && childAt2 != null) {
            ViewGroup viewGroup2 = (ViewGroup) childAt2;
            if (viewGroup2.getChildCount() <= 0 || (childAt = viewGroup2.getChildAt(0)) == null || childAt.getVisibility() != 0) {
                return false;
            }
        } else if (childAt2 == null || childAt2.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.byazt.sy.tt
    public sp c() {
        return this.da;
    }

    public void c(com.byazt.dj.tt ttVar) {
        this.x = ttVar;
    }

    public void c(Context context) {
        this.i = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        new com.byazt.rob.c(this.c, this.i).c(i, this.x);
    }
}
