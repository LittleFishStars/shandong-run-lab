package com.byazt.nwh;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aq.sp;
import com.byazt.or.x;
import com.byazt.tm.DynamicImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 668, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28854a;
    public Paint c;
    public int n;
    public int uj;
    public Path tt = new Path();
    public Path ve = new Path();

    public c() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    public void c(Canvas canvas, tt ttVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrTt;
        if (ttVar.getRippleValue() != 0.0f) {
            if (com.byazt.mf.c.c().ve() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrTt = sp.tt(str);
                    } catch (Exception unused) {
                        fArrTt = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.c.setColor(Color.parseColor(str));
                    this.c.setAlpha(90);
                } else if (fArrTt != null) {
                    this.c.setColor(x.c(fArrTt[3] * (1.0f - ttVar.getRippleValue()), fArrTt[0] / 256.0f, fArrTt[1] / 256.0f, fArrTt[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.uj;
            int i2 = this.n;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * ttVar.getRippleValue(), this.c);
        }
        if (ttVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.tt.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.uj * 4) + (iIntValue2 * 2)) + (this.n * 2)) * ttVar.getShineValue())) - ((this.n * 2) + iIntValue2);
                float f = shineValue;
                int i3 = this.n;
                this.c.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.c.setStrokeWidth(this.uj * 2);
                Path path = this.ve;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue2;
                int i5 = this.n;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.c);
            }
        }
        if (ttVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.tt.reset();
                this.tt.moveTo(0.0f, 0.0f);
                this.tt.lineTo(this.uj * 2, 0.0f);
                this.tt.lineTo(this.uj * 2, this.n * 2);
                this.tt.lineTo(0.0f, this.n * 2);
                this.tt.lineTo(0.0f, 0.0f);
                this.c.setShader(new LinearGradient(0.0f, 0.0f, this.uj * 2, this.n * 2, new int[]{(int) (ttVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - ttVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.c.setColor(-65536);
                this.c.setStyle(Paint.Style.STROKE);
                this.c.setStrokeWidth(iIntValue);
                canvas.drawPath(this.tt, this.c);
            }
        }
    }

    public void c(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = this.f28854a;
        int i2 = (int) (i * f);
        layoutParams.width = i2;
        view.setTranslationX((i - i2) / 2);
        if (view instanceof DynamicImageView) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i3).setTranslationX((-(this.f28854a - layoutParams.width)) / 2);
                i3++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void c(View view, int i, int i2) {
        String str;
        this.uj = i / 2;
        this.n = i2 / 2;
        if (this.f28854a == 0 && view.getLayoutParams().width > 0) {
            this.f28854a = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.ve.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.uj * 2);
            view.setPivotY(this.n);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.n);
        } else {
            view.setPivotX(this.uj);
            view.setPivotY(this.n);
        }
    }
}
