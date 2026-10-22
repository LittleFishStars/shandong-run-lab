package com.byazt.qp;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.byazt.aas.gr;
import com.byazt.aas.n;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.byazt.hkv.tt;
import com.byazt.kf.PageWebView;
import com.byazt.pm.a;
import com.byazt.sz.gt;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.sz.yp;
import com.byazt.sz.z;
import com.byazt.xj.ve;
import com.byazt.xs.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY, 20})
public class c implements gt, rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.qj.c f28980a;
    public Context c;
    public Map<String, Object> da;
    public JSONObject i;
    public ve n;
    public tt sp;
    public ViewGroup tt;
    public ic uj;
    public com.byazt.seg.c ve;
    public da x;

    public c(Context context, ViewGroup viewGroup, com.byazt.seg.c cVar, ic icVar) {
        this.c = context;
        this.tt = viewGroup;
        this.ve = cVar;
        this.uj = icVar;
    }

    @Override // com.byazt.sz.rh
    public void c(ve veVar, String str, a.c cVar) {
    }

    public void tt() {
        PageWebView.c(this.i);
    }

    public void c(com.byazt.qj.c cVar) {
        this.f28980a = cVar;
    }

    public void c(DownloadListener downloadListener) {
        PageWebView.c(this.i, downloadListener);
    }

    public void c() {
        com.byazt.seg.c cVar = this.ve;
        if (cVar == null) {
            com.byazt.qj.c cVar2 = this.f28980a;
            if (cVar2 != null) {
                cVar2.c(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectC = sp.c().c(cVar.c(), this.ve.tt());
        if (jSONObjectC == null) {
            com.byazt.hy.tt.c(this.ve, new com.byazt.hy.tt.InterfaceC0432tt() { // from class: com.byazt.qp.c.1
                @Override // com.byazt.hy.tt.InterfaceC0432tt
                public void c(JSONObject jSONObject) {
                    c.this.c(jSONObject);
                }

                @Override // com.byazt.hy.tt.InterfaceC0432tt
                public void c() {
                    if (c.this.f28980a != null) {
                        c.this.f28980a.c(-1);
                    }
                }
            });
        } else {
            c(jSONObjectC);
        }
    }

    public void c(final JSONObject jSONObject) {
        final z zVar = new z(this.c);
        final JSONObject jSONObjectYg = this.uj.yg();
        this.i = jSONObjectYg;
        yp ypVar = new yp();
        ypVar.c(this.c);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.da);
        ypVar.c(map);
        zVar.c("reward_page", ypVar);
        zVar.c((rh) this);
        com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.qp.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.n = zVar.c(jSONObject);
                if (c.this.n == null) {
                    if (c.this.f28980a != null) {
                        c.this.f28980a.c(-1);
                    }
                } else {
                    zVar.tt(jSONObjectYg);
                    c.this.tt.addView(c.this.n.i(), new FrameLayout.LayoutParams(c.this.n.or(), c.this.n.cu()));
                    if (c.this.f28980a != null) {
                        c.this.f28980a.c(c.this.n.i());
                    }
                }
            }
        });
    }

    @Override // com.byazt.sz.rh
    public void c(m mVar, rh.tt ttVar, rh.c cVar) {
        if (mVar != null && mVar.tt() == 1) {
            c(mVar, mVar.ve());
        }
    }

    private void c(m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (!strOptString.equals("clickEvent")) {
            if (strOptString.equals("openPolicy")) {
                n.c(this.c, this.uj);
            }
        } else {
            tt ttVar = this.sp;
            if (ttVar != null) {
                ttVar.c(mVar.c().i(), this.x);
            }
        }
    }

    public void c(tt ttVar) {
        this.sp = ttVar;
    }

    @Override // com.byazt.sz.gt
    public void c(ve veVar, MotionEvent motionEvent) {
        this.x.ve(motionEvent.getDeviceId());
        this.x.tt(motionEvent.getToolType(0));
        this.x.uj(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.x.ve(motionEvent.getRawX());
                this.x.uj(motionEvent.getRawY());
                this.x.tt(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.x.ve(motionEvent.getRawX());
                this.x.uj(motionEvent.getRawY());
                return;
            }
        }
        this.x.n((int) motionEvent.getRawX());
        this.x.a((int) motionEvent.getRawY());
        this.x.c(motionEvent.getRawX());
        this.x.tt(motionEvent.getRawY());
        this.x.c(System.currentTimeMillis());
        this.x.tt(motionEvent.getToolType(0));
        this.x.ve(motionEvent.getDeviceId());
        this.x.uj(motionEvent.getSource());
        this.x.tt(true);
        gr.c(motionEvent);
    }

    public void c(Map<String, Object> map) {
        this.da = map;
    }
}
