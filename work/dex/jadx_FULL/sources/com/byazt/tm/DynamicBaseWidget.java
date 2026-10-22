package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aq.a;
import com.byazt.aq.sp;
import com.byazt.aq.x;
import com.byazt.nr.m;
import com.byazt.nr.zm;
import com.byazt.xl.u;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.zj.adlib.un1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INVALID_AVMP_CONTEXT})
public abstract class DynamicBaseWidget extends FrameLayout implements com.byazt.nwh.tt, n, uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29065a;
    public float c;
    public int da;
    public float gt;
    public int i;
    public boolean m;
    public float my;
    public float n;
    public com.byazt.oj.tt nu;
    public boolean qy;
    public com.byazt.nwh.c rh;
    public zm rl;
    public Context sl;
    public int sp;
    public sp t;
    public float tt;
    public x u;
    public float uj;
    public float ve;
    public int x;
    public DynamicRootView yp;
    public View z;
    public static final View.OnTouchListener gu = new View.OnTouchListener() { // from class: com.byazt.tm.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    public static final View.OnClickListener gr = new View.OnClickListener() { // from class: com.byazt.tm.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context);
        this.qy = true;
        this.sl = context;
        this.yp = dynamicRootView;
        this.u = xVar;
        this.ve = xVar.a();
        this.uj = xVar.sp();
        this.n = xVar.x();
        this.f29065a = xVar.i();
        this.i = (int) com.byazt.or.x.c(this.sl, this.ve);
        this.da = (int) com.byazt.or.x.c(this.sl, this.uj);
        this.sp = (int) com.byazt.or.x.c(this.sl, this.n);
        this.x = (int) com.byazt.or.x.c(this.sl, this.f29065a);
        sp spVar = new sp(xVar.da());
        this.t = spVar;
        if (spVar.rh() > 0) {
            this.sp += this.t.rh() * 2;
            this.x += this.t.rh() * 2;
            this.i -= this.t.rh();
            this.da -= this.t.rh();
            List<x> listSl = xVar.sl();
            if (listSl != null) {
                for (x xVar2 : listSl) {
                    xVar2.ve(xVar2.a() + com.byazt.or.x.tt(this.sl, this.t.rh()));
                    xVar2.uj(xVar2.sp() + com.byazt.or.x.tt(this.sl, this.t.rh()));
                    xVar2.c(com.byazt.or.x.tt(this.sl, this.t.rh()));
                    xVar2.tt(com.byazt.or.x.tt(this.sl, this.t.rh()));
                }
            }
        }
        this.m = this.t.yp() > AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rh = new com.byazt.nwh.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        try {
            View view = this.z;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(gr);
        } catch (Exception unused) {
        }
    }

    private void i() {
        if (isShown()) {
            int iC = com.byazt.gd.c.c(this.t);
            if (iC == 2) {
                if (this.rl == null) {
                    this.rl = new zm(getContext().getApplicationContext(), 1, this.qy);
                }
                this.rl.c(new zm.c() { // from class: com.byazt.tm.DynamicBaseWidget.3
                    @Override // com.byazt.nr.zm.c
                    public void c(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.da();
                        }
                    }
                });
                u renderRequest = this.yp.getRenderRequest();
                if (renderRequest != null) {
                    this.rl.c(renderRequest.nu());
                    this.rl.n(renderRequest.gu());
                    this.rl.ve(renderRequest.rl());
                    this.rl.tt(renderRequest.my());
                    this.rl.a(renderRequest.gr());
                    this.rl.c(renderRequest.gt());
                    this.rl.tt(renderRequest.qy());
                }
            } else if (iC == 3) {
                if (this.rl == null) {
                    this.rl = new zm(getContext().getApplicationContext(), 2, this.qy);
                }
                this.rl.c(new zm.c() { // from class: com.byazt.tm.DynamicBaseWidget.4
                    @Override // com.byazt.nr.zm.c
                    public void c(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.da();
                        }
                    }
                });
                u renderRequest2 = this.yp.getRenderRequest();
                if (renderRequest2 != null) {
                    this.rl.tt(renderRequest2.my());
                    this.rl.a(renderRequest2.gr());
                    this.rl.c(renderRequest2.gt());
                    this.rl.tt(renderRequest2.qy());
                }
            }
            zm zmVar = this.rl;
            if (zmVar != null) {
                DynamicRootView dynamicRootView = this.yp;
                if (dynamicRootView == null) {
                    zmVar.c(0);
                    return;
                }
                u renderRequest3 = dynamicRootView.getRenderRequest();
                if (renderRequest3 != null) {
                    this.rl.c(renderRequest3.md());
                }
            }
        }
    }

    public void a() {
        if (sp()) {
            return;
        }
        View view = this.z;
        if (view == null) {
            view = this;
        }
        com.byazt.oj.tt ttVar = new com.byazt.oj.tt(view, this.u.da().n().vi());
        this.nu = ttVar;
        ttVar.c();
    }

    public Drawable getBackgroundDrawable() {
        return c(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.m;
    }

    public int getClickArea() {
        return this.t.p();
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.byazt.wl.c getDynamicClickListener() {
        return this.yp.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.x;
    }

    public a getDynamicLayoutBrickValue() {
        com.byazt.aq.n nVarDa;
        x xVar = this.u;
        if (xVar == null || (nVarDa = xVar.da()) == null) {
            return null;
        }
        return nVarDa.n();
    }

    public int getDynamicWidth() {
        return this.sp;
    }

    public String getImageObjectFit() {
        return this.t.to();
    }

    @Override // com.byazt.nwh.tt
    public float getMarqueeValue() {
        return this.my;
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(c(tt(this.t.qp().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.nwh.tt
    public float getRippleValue() {
        return this.c;
    }

    @Override // com.byazt.nwh.tt
    public float getShineValue() {
        return this.tt;
    }

    public float getStretchValue() {
        return this.gt;
    }

    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
        layoutParams.topMargin = this.da;
        int i = this.i;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        tt();
        super.onDetachedFromWindow();
        if (this.rl != null) {
            DynamicRootView dynamicRootView = this.yp;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                this.rl.tt(0);
            } else {
                this.rl.tt(this.yp.getRenderRequest().md());
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rh.c(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.nwh.c cVar = this.rh;
        View view = this.z;
        if (view == null) {
            view = this;
        }
        cVar.c(view, i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.rl != null) {
            DynamicRootView dynamicRootView = this.yp;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.rl.c(0);
                    return;
                } else {
                    this.rl.tt(0);
                    return;
                }
            }
            if (z) {
                this.rl.c(this.yp.getRenderRequest().md());
            } else {
                this.rl.tt(this.yp.getRenderRequest().md());
            }
        }
    }

    public void setCanUseSensor(boolean z) {
        this.qy = z;
    }

    public void setMarqueeValue(float f) {
        this.my = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.c = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.tt = f;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z) {
        this.m = z;
    }

    public void setStretchValue(float f) {
        this.gt = f;
        this.rh.c(this, f);
    }

    public boolean sp() {
        x xVar = this.u;
        return xVar == null || xVar.da() == null || this.u.da().n() == null || this.u.da().n().vi() == null;
    }

    public void tt(View view) {
        a aVarN;
        x xVar = this.u;
        if (xVar == null || (aVarN = xVar.da().n()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(aVarN.di()));
    }

    public boolean uj() {
        sp spVar = this.t;
        return (spVar == null || spVar.p() == 0) ? false : true;
    }

    public boolean ve() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.z;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (uj()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = gu;
            onClickListener = gr;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iC = com.byazt.gd.c.c(this.t);
            if (iC == 2 || iC == 3) {
                view2.setOnClickListener(gr);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        c(view2);
        tt(view2);
        return true;
    }

    public boolean c() {
        x();
        n();
        ve();
        return true;
    }

    private List<String> tt(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && (i = i - 1) == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    public void c(int i) {
        sp spVar = this.t;
        if (spVar != null && spVar.c(i)) {
            x();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).c(i);
                }
            }
        }
    }

    public void tt() {
        com.byazt.oj.tt ttVar = this.nu;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    public void c(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.u.x());
            jSONObject.put("height", this.u.i());
            if (com.byazt.sr.uj.c()) {
                view.setTag(com.byazt.kn.c.gt, this.t.nb());
                view.setTag(com.byazt.kn.c.rl, this.u.da().getType());
                view.setTag(com.byazt.kn.c.qy, this.u.ve());
                view.setTag(com.byazt.kn.c.gu, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.t.nb());
            view.setTag(2097610715, this.u.da().getType());
            view.setTag(2097610714, this.u.ve());
            view.setTag(2097610713, jSONObject.toString());
            int iC = com.byazt.gd.c.c(this.t);
            if (iC == 1) {
                view.setTag(2097610707, new Pair(this.t.zm(), Long.valueOf(this.t.yv())));
                view.setTag(2097610708, Integer.valueOf(iC));
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public Drawable c(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iMd;
        if (!TextUtils.isEmpty(this.t.qp())) {
            try {
                String strQp = this.t.qp();
                String strSubstring = strQp.substring(strQp.indexOf("(") + 1, strQp.length() - 1);
                if (strSubstring.contains(un1.b) && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{sp.c(strArrSplit[1]), sp.c(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{sp.c(strArrSplit[1].substring(0, 7)), sp.c(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableC = c(c(strArrSplit[0]), iArr);
                gradientDrawableC.setShape(0);
                gradientDrawableC.setCornerRadius(com.byazt.or.x.c(this.sl, this.t.z()));
                return gradientDrawableC;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fC = com.byazt.or.x.c(this.sl, this.t.z());
        drawable.setCornerRadius(fC);
        if (fC < 1.0f) {
            float fC2 = com.byazt.or.x.c(this.sl, this.t.d());
            float fC3 = com.byazt.or.x.c(this.sl, this.t.eo());
            float fC4 = com.byazt.or.x.c(this.sl, this.t.zb());
            float fC5 = com.byazt.or.x.c(this.sl, this.t.or());
            float[] fArr = new float[8];
            if (fC2 > 0.0f) {
                fArr[0] = fC2;
                fArr[1] = fC2;
            }
            if (fC3 > 0.0f) {
                fArr[2] = fC3;
                fArr[3] = fC3;
            }
            if (fC4 > 0.0f) {
                fArr[4] = fC4;
                fArr[5] = fC4;
            }
            if (fC5 > 0.0f) {
                fArr[6] = fC5;
                fArr[7] = fC5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iMd = Color.parseColor(str);
        } else {
            iMd = this.t.md();
        }
        drawable.setColor(iMd);
        if (this.t.nu() > 0.0f) {
            drawable.setStroke((int) com.byazt.or.x.c(this.sl, this.t.nu()), this.t.m());
            return drawable;
        }
        if (this.t.rh() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.t.rh(), this.t.m());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.u.da().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new ve((int) fC, this.t.rh());
    }

    public tt c(Bitmap bitmap) {
        return new c(bitmap, null);
    }

    private Drawable[] c(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = sp.c(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableC = c(c(strArrSplit[0]), iArr);
                gradientDrawableC.setShape(0);
                gradientDrawableC.setCornerRadius(com.byazt.or.x.c(this.sl, this.t.z()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableC;
            }
        }
        return drawableArr;
    }

    public GradientDrawable c(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    public GradientDrawable.Orientation c(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
