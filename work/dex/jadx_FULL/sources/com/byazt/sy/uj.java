package com.byazt.sy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.camera.video.AudioStats;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.m;
import com.byazt.kt.RecyclerView;
import com.byazt.omf.gt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 15})
public final class uj {
    public static boolean c(int i) {
        return i == 3;
    }

    public static boolean c(ic icVar, boolean z) {
        int iSl = nb.sl(icVar);
        if (iSl == 5 || iSl == 9) {
            return true;
        }
        if (iSl == 3 || iSl == 4) {
            return z;
        }
        return iSl == 7 || iSl == 8;
    }

    private static Activity n(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static boolean tt(View view) {
        return "androidx.viewpager.widget.ViewPager".equals(view.getClass().getName()) || "androidx.viewpager.widget.ViewPager".equals(view.getClass().getName());
    }

    public static void uj(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception unused) {
            }
        }
    }

    public static ViewGroup ve(View view) {
        Window window;
        Activity activityN = n(view);
        if (activityN != null && (window = activityN.getWindow()) != null) {
            View decorView = window.getDecorView();
            if (decorView instanceof ViewGroup) {
                return (ViewGroup) decorView;
            }
        }
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if (rootView instanceof ViewGroup) {
            return (ViewGroup) rootView;
        }
        return null;
    }

    public static boolean c(View view) {
        if (view == null) {
            return true;
        }
        if (gt.tt().bj()) {
            return ((view instanceof FrameLayout) || (view instanceof RelativeLayout)) ? false : true;
        }
        return (view instanceof RecyclerView) || (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || tt(view);
    }

    public static void c(final ViewGroup viewGroup, final View view, final int i, final int i2, final int i3, final int i4) {
        if (viewGroup == null || view == null || i <= 0 || i2 <= 0) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(0, 0));
        final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.byazt.sy.uj.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                if (view.getParent() != viewGroup) {
                    return;
                }
                uj.c(view, i3, i4, i, i2);
            }
        };
        viewGroup.addOnLayoutChangeListener(onLayoutChangeListener);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.sy.uj.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
        });
        viewGroup.post(new Runnable() { // from class: com.byazt.sy.uj.3
            @Override // java.lang.Runnable
            public void run() {
                if (view.getParent() != viewGroup) {
                    return;
                }
                uj.c(view, i3, i4, i, i2);
            }
        });
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            return;
        }
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            view.layout(i, i2, i3 + i, i4 + i2);
            view.invalidate();
        } catch (Throwable unused) {
        }
    }

    public static m c(boolean[] zArr, float[] fArr, com.byazt.kyz.c cVar, float f, float f2, double d) {
        m mVarC = cVar != null ? m.c(cVar.tt()) : null;
        if (fArr == null) {
            if (mVarC == null) {
                return new m(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, pf.uj(gt.getContext(), f), pf.uj(gt.getContext(), f2));
            }
            return mVarC;
        }
        final m mVarC2 = c(fArr, f, f2);
        if (mVarC == null) {
            return mVarC2;
        }
        double dC = m.c(mVarC, mVarC2);
        final double d2 = mVarC2.ve * mVarC2.uj;
        final double d3 = mVarC.ve * mVarC.uj;
        final m mVarTt = m.tt(mVarC, mVarC2);
        final double d4 = mVarTt != null ? mVarTt.ve * mVarTt.uj : 0.0d;
        if (cVar != null) {
            cVar.c(new com.byazt.kyz.tt() { // from class: com.byazt.sy.uj.4
                @Override // com.byazt.kyz.tt
                public JSONObject getActualRectJson() {
                    return m.c(mVarC2);
                }

                @Override // com.byazt.kyz.tt
                public double getExceedAreaRate() {
                    double d5 = d3;
                    if (d5 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        return 1.0d;
                    }
                    if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        return -1.0d;
                    }
                    return (d4 - d5) / d5;
                }

                @Override // com.byazt.kyz.tt
                public JSONObject getMaxRectJson() {
                    return m.c(mVarTt);
                }
            });
        }
        if (d3 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            zArr[0] = false;
            return null;
        }
        if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            zArr[0] = false;
            return null;
        }
        double d5 = dC / d2;
        boolean z = d5 >= d;
        com.byazt.nr.m.c("xeasy", "A:" + d3 + " B:" + d2 + " o:" + dC + " R:" + d5);
        if (z) {
            return mVarTt;
        }
        zArr[0] = false;
        return null;
    }

    private static m c(float[] fArr, float f, float f2) {
        int iUj = pf.uj(gt.getContext(), f);
        int iUj2 = pf.uj(gt.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iUj - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        float f6 = (iUj2 - f4) - fArr[2];
        return new m(f3, f4, f5, f6 >= 0.0f ? f6 : 0.0f);
    }

    public static ir c(String str, String str2, String str3, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ugen_md5", str2);
            jSONObject.put("ugen_id", str);
            jSONObject.put("ugen_url", str3);
            jSONObject.put("displayAreaAndroid", i);
            jSONObject.put("render_sequence", i2);
        } catch (JSONException unused) {
        }
        return new ir(jSONObject, i3);
    }

    public static void c(View view, String str) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (str.equals(viewGroup.getTag())) {
                uj(viewGroup);
            }
        }
    }
}
