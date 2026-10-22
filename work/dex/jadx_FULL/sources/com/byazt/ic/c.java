package com.byazt.ic;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.bzd.x;
import com.byazt.ete.ic;
import com.byazt.ete.lr;
import com.byazt.ete.p;
import com.byazt.ete.rh;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.sz.i;
import com.byazt.ui.UpieImageView;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 20})
public class c {
    public static boolean a(ic icVar) {
        return icVar != null && icVar.il() == 18;
    }

    public static boolean c(ic icVar) {
        return tt(icVar) || ve(icVar);
    }

    public static com.byazt.ui.c da(final ic icVar) {
        if (icVar == null) {
            return null;
        }
        return new com.byazt.ui.c() { // from class: com.byazt.ic.c.2
            @Override // com.byazt.ui.c
            public void c(Map<String, Object> map) {
                yp.c().c(icVar, map.get("duration"));
            }

            @Override // com.byazt.ui.c
            public void c(int i, String str) {
                yp.c().tt(icVar, i, str);
            }
        };
    }

    public static com.byazt.cph.c i(ic icVar) {
        if (!uj(icVar) && !c(icVar)) {
            return new com.byazt.cph.c.C0378c().ve(t(icVar)).c();
        }
        com.byazt.cph.c.C0378c c0378cSl = sl(icVar);
        JSONObject jSONObjectYg = icVar.yg();
        if (jSONObjectYg != null) {
            try {
                jSONObjectYg.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0378cSl.c(jSONObjectYg);
        return c0378cSl.c();
    }

    public static boolean n(ic icVar) {
        return icVar != null && icVar.il() == 17;
    }

    private static com.byazt.cph.c.C0378c sl(ic icVar) {
        int[] iArrN = xd.n(icVar);
        rh rhVarIc = icVar.ic();
        String strVe = rhVarIc != null ? rhVarIc.ve() : null;
        com.byazt.cph.c.C0378c c0378c = new com.byazt.cph.c.C0378c();
        if (TextUtils.isEmpty(strVe)) {
            strVe = "";
        }
        com.byazt.cph.c.C0378c c0378cTt = c0378c.c(strVe).c((iArrN == null || iArrN.length < 2) ? 1280 : iArrN[0]).tt((iArrN == null || iArrN.length < 2) ? 720 : iArrN[1]);
        if (tt(icVar)) {
            com.byazt.jzl.c cVarNu = xd.nu(icVar);
            c0378cTt.ve(t(icVar)).tt(cVarNu != null ? cVarNu.n() : "").c(((long) xd.sp(icVar)) * 1000);
        }
        if (uj(icVar)) {
            c0378cTt.ve(t(icVar));
        }
        return c0378cTt;
    }

    public static boolean sp(ic icVar) {
        int[] iArrN;
        if (icVar == null || (iArrN = xd.n(icVar)) == null || iArrN.length < 2) {
            return true;
        }
        int i = iArrN[0];
        int i2 = iArrN[1];
        int iUj = xd.uj(icVar);
        int iVe = xd.ve(icVar);
        return (i >= i2 && iUj >= iVe) || (i <= i2 && iUj <= iVe);
    }

    private static String t(ic icVar) {
        List<zb> listPa;
        if (icVar == null || (listPa = icVar.pa()) == null || listPa.size() <= 0) {
            return null;
        }
        return listPa.get(0).c();
    }

    public static boolean uj(ic icVar) {
        return n(icVar) || a(icVar);
    }

    public static boolean ve(ic icVar) {
        return icVar != null && icVar.il() == 16;
    }

    public static boolean x(ic icVar) {
        if (icVar != null && !ic.ve(icVar)) {
            if (uj(icVar)) {
                return true;
            }
            if (!gt.tt().jm() && (p.tt(icVar) || p.ve(icVar) || lr.tt(icVar))) {
                return true;
            }
        }
        return false;
    }

    public static com.byazt.cph.c c(ic icVar, JSONObject jSONObject) {
        com.byazt.cph.c.C0378c c0378cSl = sl(icVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        c0378cSl.c(jSONObject);
        return c0378cSl.c();
    }

    public static boolean tt(ic icVar) {
        return icVar != null && icVar.il() == 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static void c(JSONObject jSONObject, ic icVar) {
        if (jSONObject != null) {
            if (c(icVar) || uj(icVar)) {
                try {
                    jSONObject.put("dynamic_join_type", icVar.il());
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
    }

    public static void c(boolean z, i.c cVar) {
        JSONObject jSONObjectN;
        if (cVar == null || (jSONObjectN = cVar.n()) == null || !TextUtils.equals("${image[0].url}", jSONObjectN.optString("src"))) {
            return;
        }
        try {
            if (z) {
                jSONObjectN.put("type", "UpieImage");
            } else {
                jSONObjectN.put("name", "UpieImage");
            }
        } catch (JSONException e) {
            m.c(e);
        }
        cVar.c("UpieImage");
    }

    public static void c(final ImageView imageView, final UpieImageView upieImageView) {
        x.c(new Runnable() { // from class: com.byazt.ic.c.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ic.c.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c.ve(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.ic.c.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        ImageView imageView2 = imageView;
                        if (imageView2 == view) {
                            imageView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        });
    }
}
