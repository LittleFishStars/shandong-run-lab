package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.byazt.aq.sp;
import com.byazt.aq.x;
import com.byazt.du.i;
import com.byazt.nk.InteractViewContainer;
import com.byazt.nr.p;
import com.byazt.oq.GifView;
import com.byazt.or.a;
import com.byazt.xl.u;
import com.byazt.yj.da;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.byazt.yj.yp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 950})
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public static String gt = "";
    public Runnable c;
    public InteractViewContainer my;
    public ImageView qy;
    public volatile boolean rl;
    public Runnable tt;

    @com.byazt.zqa.c(c = {0, 1, 48, 1707})
    public static class c implements gr<Bitmap> {
        public final WeakReference<View> c;
        public final WeakReference<DynamicRootView> tt;
        public final x ve;

        public c(View view, DynamicRootView dynamicRootView, x xVar) {
            this.c = new WeakReference<>(view);
            this.tt = new WeakReference<>(dynamicRootView);
            this.ve = xVar;
        }

        @Override // com.byazt.yj.gr
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(m<Bitmap> mVar) {
            View view = this.c.get();
            if (!com.byazt.sr.uj.c()) {
                DynamicRootView dynamicRootView = this.tt.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().a()) || "splash_ad".equals(dynamicRootView.getRenderRequest().a())) {
                    view.setBackground(new BitmapDrawable(mVar.getResult()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(mVar.getResult()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(mVar.getResult()));
            x xVar = this.ve;
            if (xVar == null || xVar.da() == null || 6 != this.ve.da().c() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 48, 2429})
    public static class tt implements gr<Bitmap> {
        public final WeakReference<View> c;
        public final WeakReference<DynamicBaseWidget> tt;

        public tt(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.c = new WeakReference<>(view);
            this.tt = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.byazt.yj.gr
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(m<Bitmap> mVar) {
            Bitmap result;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.c.get();
            if (view == null || (result = mVar.getResult()) == null || mVar.getOriginResult() == null || (dynamicBaseWidget = this.tt.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.c(result));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 48, 2425})
    public static class ve implements da {
        public final WeakReference<Context> c;
        public final int tt;

        public ve(Context context, int i) {
            this.c = new WeakReference<>(context);
            this.tt = i;
        }

        @Override // com.byazt.yj.da
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.c.get();
            if (context != null) {
                return com.byazt.or.tt.c(context, bitmap, this.tt);
            }
            return null;
        }
    }

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.rl = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = xVar.da().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.x - ((int) com.byazt.or.x.c(context, this.t.tt() + this.t.c())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.x - ((int) com.byazt.or.x.c(context, this.t.tt() + this.t.c())));
        }
    }

    private static String getBuildModel() {
        try {
            gt = p.c();
        } catch (Throwable unused) {
            gt = Build.MODEL;
        }
        if (TextUtils.isEmpty(gt)) {
            gt = Build.MODEL;
        }
        return gt;
    }

    private void i() {
        if (this.rl) {
            int iL = this.t.l();
            int iLo = this.t.lo();
            Runnable runnable = new Runnable() { // from class: com.byazt.tm.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.yp;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.my = new InteractViewContainer(dynamicBaseWidgetImp2.sl, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.t);
                    } else {
                        u renderRequest = DynamicBaseWidgetImp.this.yp.getRenderRequest();
                        com.byazt.aq.da daVar = new com.byazt.aq.da();
                        daVar.c(renderRequest.nu());
                        daVar.tt(renderRequest.rh());
                        daVar.ve(renderRequest.my());
                        daVar.c(renderRequest.gt());
                        daVar.tt(renderRequest.rl());
                        daVar.ve(renderRequest.qy());
                        daVar.uj(renderRequest.gu());
                        daVar.n(renderRequest.gr());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.my = new InteractViewContainer(dynamicBaseWidgetImp4.sl, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.t, daVar, renderRequest);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.tt(dynamicBaseWidgetImp5.my);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.my.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.c((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.my, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.my.ve();
                }
            };
            this.c = runnable;
            postDelayed(runnable, ((long) iL) * 1000);
            if (this.t.pu() || iLo >= Integer.MAX_VALUE || iL >= iLo) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.byazt.tm.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    if (dynamicBaseWidgetImp.my != null) {
                        dynamicBaseWidgetImp.rl = false;
                        DynamicBaseWidgetImp.this.my.uj();
                        DynamicBaseWidgetImp.this.my.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp2.removeView(dynamicBaseWidgetImp2.my);
                    }
                }
            };
            this.tt = runnable2;
            postDelayed(runnable2, ((long) iLo) * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable tt(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = sp.c(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableC = c(c(string), iArr);
            gradientDrawableC.setShape(0);
            gradientDrawableC.setCornerRadius(com.byazt.or.x.c(this.sl, this.t.z()));
            return gradientDrawableC;
        } catch (Throwable unused) {
            return null;
        }
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.sp, this.x);
    }

    @Override // com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.z;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        double dGt = this.u.da().n().gt();
        if (dGt < 90.0d && dGt > AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.byazt.nr.da.tt().postDelayed(new Runnable() { // from class: com.byazt.tm.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dGt * 1000.0d));
        }
        c(this.u.da().n().my(), view2);
        if (!TextUtils.isEmpty(this.t.aw())) {
            i();
        }
        super.onAttachedToWindow();
    }

    @Override // com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.c);
            removeCallbacks(this.tt);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.tm.uj
    public boolean x() {
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject jSONObjectOptJSONObject;
        View view = this.z;
        final View view2 = view;
        if (view == null) {
            view2 = this;
        }
        setContentDescription(this.u.c(this.t.p()));
        String strYf = this.t.yf();
        String strYv = null;
        String strC = (TextUtils.isEmpty(strYf) || (dynamicRootView = this.yp) == null || dynamicRootView.getRenderRequest() == null || this.yp.getRenderRequest().n() == null || (jSONObjectOptJSONObject = this.yp.getRenderRequest().n().optJSONObject("creative")) == null) ? null : c(jSONObjectOptJSONObject.opt(strYf));
        if (TextUtils.isEmpty(strC)) {
            strC = this.t.rl();
        }
        if (this.t.gt()) {
            com.byazt.mf.c.c().n().from(this.t.tt).type(2).converter(new ve(this.sl, this.t.my())).to(new tt(view2, this));
        } else if (!TextUtils.isEmpty(strC)) {
            if (!strC.startsWith("http:") && !strC.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.yp;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    strYv = this.yp.getRenderRequest().yv();
                }
                strC = i.tt(strC, strYv);
            }
            yp ypVarType = com.byazt.mf.c.c().n().from(strC).type(2);
            c(ypVarType);
            if (com.byazt.sr.uj.c()) {
                ypVarType.to(new c(view2, this.yp, this.u));
            } else if ((view2 instanceof FrameLayout) && TextUtils.equals(this.u.da().getType(), "vessel")) {
                if (com.byazt.or.da.tt(strC)) {
                    this.qy = new GifView(this.sl);
                } else {
                    this.qy = new ImageView(this.sl);
                }
                ((FrameLayout) view2).addView(this.qy, new FrameLayout.LayoutParams(-1, -1));
                ypVarType.type(3).to(new gr() { // from class: com.byazt.tm.DynamicBaseWidgetImp.1
                    @Override // com.byazt.yj.gr
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.yj.gr
                    public void onSuccess(m mVar) {
                        Object result = mVar.getResult();
                        if (result instanceof byte[]) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            a.tt(DynamicBaseWidgetImp.this.qy, (byte[]) result, dynamicBaseWidgetImp.sp, dynamicBaseWidgetImp.x);
                        }
                    }
                }, 4);
            } else {
                c(ypVarType, view2);
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view2.setBackground(backgroundDrawable);
        }
        if (this.t.h() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            postDelayed(new Runnable() { // from class: com.byazt.tm.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.t.cu() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableTt = dynamicBaseWidgetImp.tt(dynamicBaseWidgetImp.yp.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.t.cu())));
                            if (drawableTt == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableTt = dynamicBaseWidgetImp2.c(true, dynamicBaseWidgetImp2.yp.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.t.cu())));
                            }
                            if (drawableTt != null) {
                                view2.setBackground(drawableTt);
                                return;
                            }
                            View view3 = view2;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view3.setBackground(dynamicBaseWidgetImp3.c(true, dynamicBaseWidgetImp3.yp.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.t.h() * 1000.0d));
        }
        View view3 = this.z;
        if (view3 != null) {
            view3.setPadding((int) com.byazt.or.x.c(this.sl, this.t.ve()), (int) com.byazt.or.x.c(this.sl, this.t.tt()), (int) com.byazt.or.x.c(this.sl, this.t.uj()), (int) com.byazt.or.x.c(this.sl, this.t.c()));
        }
        if (this.m || this.t.yp() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            setShouldInvisible(true);
            view2.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return c(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return c((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void c(yp ypVar, final View view) {
        ypVar.to(new gr<Bitmap>() { // from class: com.byazt.tm.DynamicBaseWidgetImp.3
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(m<Bitmap> mVar) {
                DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.yp;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().a()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.yp.getRenderRequest().a())) {
                    view.setBackground(new BitmapDrawable(mVar.getResult()));
                } else {
                    if (!com.byazt.sr.uj.c()) {
                        view.setBackground(new BitmapDrawable(mVar.getResult()));
                        return;
                    }
                    view.setBackground(new com.byazt.tm.c(mVar.getResult(), ((DynamicRoot) DynamicBaseWidgetImp.this.yp.getChildAt(0)).c));
                }
            }
        });
    }

    private static void c(yp ypVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            ypVar.config(Bitmap.Config.ARGB_8888);
        }
    }

    private void c(double d, final View view) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.byazt.nr.da.tt().postDelayed(new Runnable() { // from class: com.byazt.tm.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.u.da().n().vi() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }
}
