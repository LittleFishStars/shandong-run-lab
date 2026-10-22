package com.byazt.qq;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.sz.rh;
import com.byazt.sz.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 13})
public abstract class tt {
    public z da;
    public g i;
    public Map<String, Object> m;
    public String sl;
    public ic sp;
    public String t;
    public c u;
    public Activity x;
    public AtomicBoolean yp;
    public String z;

    public tt(Activity activity, ic icVar) {
        this.u = new c(false, 0, "");
        this.yp = new AtomicBoolean(false);
        this.x = activity;
        this.sp = icVar;
    }

    public boolean a() {
        return true;
    }

    public c c(da daVar) {
        return new c(false, 0, "");
    }

    public abstract String c();

    public void n() {
    }

    public int sp() {
        return 0;
    }

    public c tt(da daVar) {
        return new c(false, 0, "");
    }

    public boolean tt() {
        return false;
    }

    public void uj() {
    }

    public void uj(String str) {
        this.sl = str;
    }

    public void ve() {
    }

    public void ve(String str) {
        this.t = str;
    }

    public String x() {
        return !TextUtils.isEmpty(this.z) ? this.z : c();
    }

    public void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.m;
        if (map2 == null) {
            this.m = map;
        } else {
            map2.putAll(map);
        }
    }

    public void tt(String str) {
        this.z = str;
    }

    public void uj(da daVar) {
        if (daVar != null) {
            daVar.c();
        }
    }

    public c ve(final da daVar) {
        if (!a()) {
            return new c(false, 0, "");
        }
        final com.byazt.sgn.a aVar = new com.byazt.sgn.a(this.x);
        c(aVar);
        final FrameLayout frameLayout = new FrameLayout(this.x);
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.byazt.qq.tt.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                z zVar = tt.this.da;
                if (zVar != null) {
                    zVar.c((rh) null);
                }
            }
        });
        com.byazt.seg.c cVar = new com.byazt.seg.c();
        cVar.c(this.i.uj());
        cVar.tt(this.i.n());
        cVar.ve(this.i.uj());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.byazt.ux.n.c(cVar, new com.byazt.ux.n.c() { // from class: com.byazt.qq.tt.2
            @Override // com.byazt.ux.n.c
            public void c(JSONObject jSONObject) {
                if (tt.this.yp.get()) {
                    return;
                }
                if (jSONObject == null) {
                    tt.this.u = new c(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    tt.this.c(aVar, frameLayout, daVar, jSONObject);
                    tt ttVar = tt.this;
                    ttVar.u = new c(true, ttVar.sp(), tt.this.i.uj(), aVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            m.c(e);
        }
        this.yp.set(true);
        return this.u;
    }

    @com.byazt.zqa.c(c = {0, 1, 88, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public boolean c;
        public int tt;
        public Dialog uj;
        public String ve;

        public c(boolean z, int i, String str, Dialog dialog) {
            this.c = z;
            this.tt = i;
            this.ve = str;
            this.uj = dialog;
        }

        public int c() {
            return this.tt;
        }

        public void n() {
            Dialog dialog = this.uj;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        public String tt() {
            return this.ve;
        }

        public boolean uj() {
            Dialog dialog = this.uj;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public boolean ve() {
            return this.c;
        }

        public c(boolean z, int i, String str) {
            this(z, i, str, null);
        }
    }

    public void c(final com.byazt.sgn.a aVar, final ViewGroup viewGroup, final da daVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(x());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View viewC = c(jSONObject, jSONObject2, new rh() { // from class: com.byazt.qq.tt.3
            @Override // com.byazt.sz.rh
            public void c(com.byazt.sz.m mVar, rh.tt ttVar, rh.c cVar) {
                JSONObject jSONObjectVe = mVar.ve();
                if (jSONObjectVe == null) {
                    return;
                }
                String strOptString = jSONObjectVe.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                boolean zOptBoolean = jSONObjectVe.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && tt.this.sp != null) {
                    aVar.dismiss();
                    nb.md();
                    com.byazt.bh.tt.INSTANCE.c(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", daVar);
                    com.byazt.ppf.ve.c(strOptString, tt.this.sp.yg(), map);
                    return;
                }
                strOptString.hashCode();
                if (!strOptString.equals("exit_watch")) {
                    if (strOptString.equals("continue_watch")) {
                        aVar.dismiss();
                        tt.this.uj(daVar);
                        return;
                    }
                    return;
                }
                aVar.dismiss();
                da daVar2 = daVar;
                if (daVar2 != null) {
                    daVar2.tt();
                }
            }

            @Override // com.byazt.sz.rh
            public void c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
            }
        });
        if (viewC == null) {
            return;
        }
        this.x.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.qq.tt.4
            @Override // java.lang.Runnable
            public void run() {
                tt.this.c(aVar, viewC, viewGroup);
                viewGroup.addView(viewC);
                aVar.c(viewGroup);
                aVar.show();
            }
        });
    }

    public tt(Activity activity, ic icVar, g gVar) {
        this(activity, icVar);
        this.i = gVar;
    }

    public void c(com.byazt.sgn.a aVar) {
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public View c(JSONObject jSONObject, JSONObject jSONObject2, rh rhVar) {
        z zVar = new z(this.x);
        this.da = zVar;
        com.byazt.xj.ve<View> veVarC = zVar.c(jSONObject);
        this.da.c(rhVar);
        this.da.tt(jSONObject2);
        if (veVarC == null) {
            return null;
        }
        return veVarC.i();
    }

    public void c(Dialog dialog, final View view, final View view2) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.sp.by() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = pf.ve(this.x, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.sp.by() == 2) {
            view.measure(0, 0);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, view.getMeasuredHeight()));
            view.setVisibility(4);
            view.post(new com.byazt.bwm.sp("scaleView") { // from class: com.byazt.qq.tt.5
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    View view3 = view2;
                    if (view3 != null) {
                        float height = view3.getHeight();
                        if (view.getHeight() > height) {
                            float height2 = height / view.getHeight();
                            view.setScaleY(height2);
                            view.setScaleX(height2);
                            view.setPivotY(0.0f);
                        }
                    }
                }
            });
        }
    }
}
