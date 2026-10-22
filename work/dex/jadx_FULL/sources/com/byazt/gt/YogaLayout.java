package com.byazt.gt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.bj.a;
import com.byazt.bj.da;
import com.byazt.bj.i;
import com.byazt.bj.n;
import com.byazt.bj.sl;
import com.byazt.bj.u;
import com.byazt.bj.ve;
import com.byazt.bj.yp;
import com.byazt.rb.sp;
import com.byazt.rb.x;
import com.byazt.sa.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 225})
public class YogaLayout extends ViewGroup implements sp, com.byazt.xj.tt {
    public final Map<View, da> c;
    public final da tt;
    public x uj;
    public uj ve;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        da daVarC;
        this.tt.c((com.byazt.bj.sp) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.c(this);
            da yogaNode = virtualYogaLayout.getYogaNode();
            da daVar = this.tt;
            daVar.c(yogaNode, daVar.c());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.c.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            daVarC = ((YogaLayout) view).getYogaNode();
        } else {
            daVarC = this.c.containsKey(view) ? this.c.get(view) : sl.c();
            daVarC.c(view);
            daVarC.c((com.byazt.bj.sp) new tt());
        }
        c((c) view.getLayoutParams(), daVarC, view);
        this.c.put(view, daVarC);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.tt.c()));
        } else {
            da daVar2 = this.tt;
            daVar2.c(daVarC, daVar2.c());
        }
    }

    public da c(View view) {
        return this.c.get(view);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.tt(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public float getBorderRadius() {
        return this.uj.c();
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.uj.getRipple();
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.uj.getRubIn();
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.uj.getShine();
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.uj.getStretch();
    }

    public da getYogaNode() {
        return this.tt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.c(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.uj();
        }
        if (!(getParent() instanceof YogaLayout)) {
            c(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        c(this.tt, 0.0f, 0.0f);
        uj ujVar2 = this.ve;
        if (ujVar2 != null) {
            ujVar2.c(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            c(i, i2);
        }
        uj ujVar = this.ve;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            setMeasuredDimension(iArrC[0], iArrC[1]);
        } else {
            setMeasuredDimension(Math.round(this.tt.x()), Math.round(this.tt.i()));
        }
        uj ujVar2 = this.ve;
        if (ujVar2 != null) {
            ujVar2.ve();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.ve;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        c(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        c(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        c(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            c(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            c(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.uj.c(i);
    }

    public void setBorderRadius(float f) {
        this.uj.c(f);
    }

    public void setRipple(float f) {
        x xVar = this.uj;
        if (xVar != null) {
            xVar.tt(f);
        }
    }

    public void setRubIn(float f) {
        x xVar = this.uj;
        if (xVar != null) {
            xVar.n(f);
        }
    }

    public void setShine(float f) {
        x xVar = this.uj;
        if (xVar != null) {
            xVar.ve(f);
        }
    }

    public void setStretch(float f) {
        x xVar = this.uj;
        if (xVar != null) {
            xVar.uj(f);
        }
    }

    @Override // com.byazt.xj.tt
    public void tt(int i) {
        da daVar = this.tt;
        if (daVar != null) {
            tt(daVar, i);
            requestLayout();
        }
    }

    public void uj(View view, int i) {
        int iC;
        view.setVisibility(i);
        try {
            da daVar = this.c.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iC = this.tt.c(daVar)) == -1) {
                    return;
                }
                this.tt.tt(iC);
                view.setTag(151060224, Integer.valueOf(iC));
                c(this.tt);
                return;
            }
            if (tag == null || this.tt.c(daVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.tt.c()) {
                this.tt.c(this.c.get(view), iIntValue);
            } else {
                this.tt.c(this.c.get(view), this.tt.c());
            }
            c(this.tt);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.xj.tt
    public void ve(View view, int i) {
        uj(view, i);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uj = new x(this);
        da daVarC = sl.c();
        this.tt = daVarC;
        this.c = new HashMap();
        daVarC.c(this);
        daVarC.c((com.byazt.bj.sp) new tt());
        c((c) generateDefaultLayoutParams(), daVarC, this);
    }

    @Override // com.byazt.xj.tt
    public void c(int i) {
        da daVar = this.tt;
        if (daVar != null) {
            c(daVar, i);
            requestLayout();
        }
    }

    @Override // com.byazt.xj.tt
    public void tt(View view, int i) {
        da daVarC;
        if (view == null || (daVarC = c(view)) == null) {
            return;
        }
        tt(daVarC, i);
        view.requestLayout();
    }

    @Override // com.byazt.xj.tt
    public void c(View view, int i) {
        da daVarC;
        if (view == null || (daVarC = c(view)) == null) {
            return;
        }
        c(daVarC, i);
        view.requestLayout();
    }

    private void tt(da daVar, int i) {
        if (i == -1) {
            daVar.sp(100.0f);
        } else if (i == -2) {
            daVar.n();
        } else {
            daVar.a(i);
        }
    }

    private void c(da daVar, int i) {
        if (i == -1) {
            daVar.n(100.0f);
        } else if (i == -2) {
            daVar.uj();
        } else {
            daVar.uj(i);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, SecExceptionCode.SEC_ERROR_LBSRISK_GET_BINARY_FAILED})
    public static class tt implements com.byazt.bj.sp {
        @Override // com.byazt.bj.sp
        public long c(da daVar, float f, com.byazt.bj.x xVar, float f2, com.byazt.bj.x xVar2) {
            View view = (View) daVar.da();
            if (view == null || (view instanceof YogaLayout)) {
                return i.c(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, c(xVar)), View.MeasureSpec.makeMeasureSpec((int) f2, c(xVar2)));
            return i.c(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int c(com.byazt.bj.x xVar) {
            if (xVar == com.byazt.bj.x.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return xVar == com.byazt.bj.x.EXACTLY ? 1073741824 : 0;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 2525})
    public static class c extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28589a;
        public SparseArray<Float> c;
        public float da;
        public float i;
        public float m;
        public float my;
        public float n;
        public float nu;
        public float rh;
        public float sl;
        public float sp;
        public float t;
        public SparseArray<String> tt;
        public float u;
        public float uj;
        public float ve;
        public float x;
        public float yp;
        public float z;

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof c) {
                c cVar = (c) layoutParams;
                this.c = cVar.c.clone();
                this.tt = cVar.tt.clone();
                return;
            }
            this.c = new SparseArray<>();
            this.tt = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.c.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.c.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void a(float f) {
            this.t = f;
            this.c.put(14, Float.valueOf(f));
        }

        public void c(float f) {
            this.sp = f;
            this.c.put(5, Float.valueOf(f));
        }

        public void da(float f) {
            this.m = f;
            this.c.put(13, Float.valueOf(f));
        }

        public void i(float f) {
            this.z = f;
            this.c.put(12, Float.valueOf(f));
        }

        public void m(float f) {
            this.rh = f;
            this.c.put(27, Float.valueOf(f));
        }

        public void n(float f) {
            this.sl = f;
            this.c.put(9, Float.valueOf(f));
        }

        public void nu(float f) {
            this.my = f;
            this.c.put(28, Float.valueOf(f));
        }

        public void sl(float f) {
            this.ve = f;
            this.c.put(17, Float.valueOf(f));
        }

        public void sp(float f) {
            this.u = f;
            this.c.put(10, Float.valueOf(f));
        }

        public void t(float f) {
            this.uj = f;
            this.c.put(18, Float.valueOf(f));
        }

        public void tt(float f) {
            this.x = f;
            this.c.put(6, Float.valueOf(f));
        }

        public void u(float f) {
            this.n = f;
            this.c.put(19, Float.valueOf(f));
        }

        public void uj(float f) {
            this.da = f;
            this.c.put(8, Float.valueOf(f));
        }

        public void ve(float f) {
            this.i = f;
            this.c.put(7, Float.valueOf(f));
        }

        public void x(float f) {
            this.yp = f;
            this.c.put(11, Float.valueOf(f));
        }

        public void yp(float f) {
            this.f28589a = f;
            this.c.put(20, Float.valueOf(f));
        }

        public void z(float f) {
            this.nu = f;
            this.c.put(25, Float.valueOf(f));
        }

        public c(int i, int i2) {
            super(i, i2);
            this.c = new SparseArray<>();
            this.tt = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.c.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.c.put(16, Float.valueOf(i2));
            }
        }
    }

    private void c(da daVar) {
        if (daVar.tt() != null) {
            c(daVar.tt());
        } else {
            daVar.c(Float.NaN, Float.NaN);
        }
    }

    public void c(View view, da daVar) {
        this.c.put(view, daVar);
        addView(view);
    }

    private void c(View view, boolean z) {
        try {
            da daVar = this.c.get(view);
            if (daVar == null) {
                return;
            }
            da daVarTt = daVar.tt();
            for (int i = 0; i < daVarTt.c(); i++) {
                if (daVarTt.c(i).equals(daVar)) {
                    daVarTt.tt(i);
                    break;
                }
            }
            daVar.c((Object) null);
            this.c.remove(view);
            if (z) {
                this.tt.c(Float.NaN, Float.NaN);
            }
        } catch (Throwable unused) {
        }
    }

    private void c(da daVar, float f, float f2) {
        View view = (View) daVar.da();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(daVar.a() + f);
            int iRound2 = Math.round(daVar.sp() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(daVar.x()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(daVar.i()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iC = daVar.c();
        for (int i = 0; i < iC; i++) {
            if (equals(view)) {
                c(daVar.c(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                c(daVar.c(i), daVar.a() + f, daVar.sp() + f2);
            }
        }
    }

    private void c(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.tt.a(size2);
        }
        if (mode == 1073741824) {
            this.tt.uj(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.tt.sl(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.tt.da(size);
        }
        this.tt.c(Float.NaN, Float.NaN);
    }

    public static void c(c cVar, da daVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            daVar.c(ve.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                daVar.tt(com.byazt.bj.uj.LEFT, rect.left);
                daVar.tt(com.byazt.bj.uj.TOP, rect.top);
                daVar.tt(com.byazt.bj.uj.RIGHT, rect.right);
                daVar.tt(com.byazt.bj.uj.BOTTOM, rect.bottom);
            }
        }
        for (int i = 0; i < cVar.c.size(); i++) {
            int iKeyAt = cVar.c.keyAt(i);
            float fFloatValue = cVar.c.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                daVar.ve(com.byazt.bj.c.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                daVar.c(com.byazt.bj.c.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                daVar.tt(com.byazt.bj.c.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                daVar.t(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    daVar.ve();
                } else {
                    daVar.ve(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                daVar.c(n.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                daVar.c(fFloatValue);
            } else if (iKeyAt == 7) {
                daVar.tt(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    daVar.sp(100.0f);
                } else if (fFloatValue == -2.0f) {
                    daVar.n();
                } else {
                    daVar.a(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                daVar.c(com.byazt.bj.uj.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                daVar.c(a.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                daVar.c(com.byazt.bj.uj.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                daVar.c(com.byazt.bj.uj.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                daVar.c(com.byazt.bj.uj.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                daVar.i(fFloatValue);
            } else if (iKeyAt == 27) {
                daVar.x(fFloatValue);
            } else if (iKeyAt == 22) {
                daVar.tt(com.byazt.bj.uj.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                daVar.tt(com.byazt.bj.uj.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                daVar.tt(com.byazt.bj.uj.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                daVar.tt(com.byazt.bj.uj.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                daVar.ve(com.byazt.bj.uj.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                daVar.ve(com.byazt.bj.uj.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                daVar.ve(com.byazt.bj.uj.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                daVar.ve(com.byazt.bj.uj.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                daVar.c(u.c(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    daVar.n(100.0f);
                } else if (fFloatValue == -2.0f) {
                    daVar.uj();
                } else {
                    daVar.uj(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                daVar.c(yp.c(Math.round(fFloatValue)));
            }
        }
    }

    public void c(com.byazt.xj.ve veVar) {
        this.ve = veVar;
    }
}
