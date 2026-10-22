package com.blankj.utilcode.util;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28224a = -16;

    public static class a {
        public static final int c = 1140850688;
        public static final int d = i.v(8.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28225a = -1.0f;
        public float b = -1.0f;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public float f1440c = -1.0f;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public float f1441d = -1.0f;
        public float e = -1.0f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f1437a = c;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f1439b = c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1438a = false;

        public Drawable a(Drawable drawable) {
            if (drawable == null) {
                drawable = new ColorDrawable(0);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = drawable;
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, new c(drawable2, d(), e(), b(), this.f1439b, this.f1438a));
            stateListDrawable.addState(StateSet.WILD_CARD, new c(drawable2, d(), f(), c(), this.f1437a, this.f1438a));
            return stateListDrawable;
        }

        public final float b() {
            if (this.f1441d == -1.0f) {
                this.f1441d = e();
            }
            return this.f1441d;
        }

        public final float c() {
            if (this.e == -1.0f) {
                this.e = f();
            }
            return this.e;
        }

        public final float d() {
            if (this.f28225a < 0.0f) {
                this.f28225a = 0.0f;
            }
            return this.f28225a;
        }

        public final float e() {
            if (this.b == -1.0f) {
                this.b = d;
            }
            return this.b;
        }

        public final float f() {
            if (this.f1440c == -1.0f) {
                this.f1440c = e();
            }
            return this.f1440c;
        }

        public a g() {
            this.f1438a = true;
            if (this.f28225a == -1.0f) {
                return this;
            }
            throw new IllegalArgumentException("Set circle needn't set radius.");
        }

        public a h(int i) {
            return i(i, i);
        }

        public a i(int i, int i2) {
            this.f1437a = i;
            this.f1439b = i2;
            return this;
        }

        public a j(int i) {
            return k(i, i);
        }

        public a k(int i, int i2) {
            this.f1441d = i;
            this.e = i2;
            return this;
        }

        public a l(float f) {
            this.f28225a = f;
            if (this.f1438a) {
                throw new IllegalArgumentException("Set circle needn't set radius.");
            }
            return this;
        }

        public a m(int i) {
            return n(i, i);
        }

        public a n(int i, int i2) {
            this.b = i;
            this.f1440c = i2;
            return this;
        }
    }

    public static class b extends Drawable implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f28226a;

        public b(Drawable drawable) {
            b(drawable);
        }

        public Drawable a() {
            return this.f28226a;
        }

        public void b(Drawable drawable) {
            Drawable drawable2 = this.f28226a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f28226a = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.f28226a.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getChangingConfigurations() {
            return this.f28226a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable getCurrent() {
            return this.f28226a.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f28226a.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f28226a.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.f28226a.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.f28226a.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.f28226a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return this.f28226a.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public int[] getState() {
            return this.f28226a.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public Region getTransparentRegion() {
            return this.f28226a.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isAutoMirrored() {
            return DrawableCompat.isAutoMirrored(this.f28226a);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return this.f28226a.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public void jumpToCurrentState() {
            DrawableCompat.jumpToCurrentState(this.f28226a);
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            this.f28226a.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean onLevelChange(int i) {
            return this.f28226a.setLevel(i);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.f28226a.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAutoMirrored(boolean z) {
            DrawableCompat.setAutoMirrored(this.f28226a, z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setChangingConfigurations(int i) {
            this.f28226a.setChangingConfigurations(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f28226a.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            this.f28226a.setDither(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            this.f28226a.setFilterBitmap(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            DrawableCompat.setHotspot(this.f28226a, f, f2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            DrawableCompat.setHotspotBounds(this.f28226a, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            return this.f28226a.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTint(int i) {
            DrawableCompat.setTint(this.f28226a, i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(ColorStateList colorStateList) {
            DrawableCompat.setTintList(this.f28226a, colorStateList);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintMode(PorterDuff.Mode mode) {
            DrawableCompat.setTintMode(this.f28226a, mode);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            return super.setVisible(z, z2) || this.f28226a.setVisible(z, z2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final double f28227a = Math.cos(Math.toRadians(45.0d));
        public final int K;
        public final int L;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public float f1442a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Paint f1443a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Path f1444a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RectF f1445a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1446a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Paint f1447b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f1448b;
        public float c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f1449c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;

        public c(Drawable drawable, float f, float f2, float f3, int i, boolean z) {
            super(drawable);
            this.f1442a = 1.0f;
            this.b = 1.0f;
            this.c = 1.0f;
            this.d = 1.0f;
            this.f1446a = true;
            this.f1448b = false;
            this.K = i;
            this.L = i & 16777215;
            this.f1449c = z;
            if (z) {
                this.f1442a = 1.0f;
                this.b = 1.0f;
                this.c = 1.0f;
                this.d = 1.0f;
            }
            Paint paint = new Paint(5);
            this.f1443a = paint;
            paint.setStyle(Paint.Style.FILL);
            this.e = Math.round(f);
            this.f1445a = new RectF();
            Paint paint2 = new Paint(this.f1443a);
            this.f1447b = paint2;
            paint2.setAntiAlias(false);
            r(f2, f3);
        }

        public static float e(float f, float f2, boolean z) {
            return z ? (float) (((double) f) + ((1.0d - f28227a) * ((double) f2))) : f;
        }

        public static int s(float f) {
            int iRound = Math.round(f);
            return iRound % 2 == 1 ? iRound - 1 : iRound;
        }

        @Override // com.blankj.utilcode.util.f.b
        public /* bridge */ /* synthetic */ Drawable a() {
            return super.a();
        }

        @Override // com.blankj.utilcode.util.f.b
        public /* bridge */ /* synthetic */ void b(Drawable drawable) {
            super.b(drawable);
        }

        public final void c(Rect rect) {
            if (this.f1449c) {
                this.e = rect.width() / 2;
            }
            float f = this.g;
            float f2 = this.f1442a * f;
            this.f1445a.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
            Drawable drawableA = a();
            RectF rectF = this.f1445a;
            drawableA.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            d();
        }

        public final void d() {
            if (!this.f1449c) {
                float f = this.e;
                RectF rectF = new RectF(-f, -f, f, f);
                RectF rectF2 = new RectF(rectF);
                float f2 = this.h;
                rectF2.inset(-f2, -f2);
                Path path = this.f1444a;
                if (path == null) {
                    this.f1444a = new Path();
                } else {
                    path.reset();
                }
                this.f1444a.setFillType(Path.FillType.EVEN_ODD);
                this.f1444a.moveTo(-this.e, 0.0f);
                this.f1444a.rLineTo(-this.h, 0.0f);
                this.f1444a.arcTo(rectF2, 180.0f, 90.0f, false);
                this.f1444a.arcTo(rectF, 270.0f, -90.0f, false);
                this.f1444a.close();
                float f3 = -rectF2.top;
                if (f3 > 0.0f) {
                    this.f1443a.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.K, this.L}, new float[]{0.0f, this.e / f3, 1.0f}, Shader.TileMode.CLAMP));
                }
                this.f1447b.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, this.K, this.L, Shader.TileMode.CLAMP));
                this.f1447b.setAntiAlias(false);
                return;
            }
            float fWidth = (this.f1445a.width() / 2.0f) - 1.0f;
            float f4 = -fWidth;
            RectF rectF3 = new RectF(f4, f4, fWidth, fWidth);
            RectF rectF4 = new RectF(rectF3);
            float f5 = this.h;
            rectF4.inset(-f5, -f5);
            Path path2 = this.f1444a;
            if (path2 == null) {
                this.f1444a = new Path();
            } else {
                path2.reset();
            }
            this.f1444a.setFillType(Path.FillType.EVEN_ODD);
            this.f1444a.moveTo(f4, 0.0f);
            this.f1444a.rLineTo(-this.h, 0.0f);
            this.f1444a.arcTo(rectF4, 180.0f, 180.0f, false);
            this.f1444a.arcTo(rectF4, 0.0f, 180.0f, false);
            this.f1444a.arcTo(rectF3, 180.0f, 180.0f, false);
            this.f1444a.arcTo(rectF3, 0.0f, 180.0f, false);
            this.f1444a.close();
            float f6 = -rectF4.top;
            if (f6 > 0.0f) {
                this.f1443a.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.K, this.L}, new float[]{0.0f, fWidth / f6, 1.0f}, Shader.TileMode.CLAMP));
            }
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1446a) {
                c(getBounds());
                this.f1446a = false;
            }
            g(canvas);
            super.draw(canvas);
        }

        public final float f(float f, float f2, boolean z) {
            return z ? (float) (((double) (f * this.f1442a)) + ((1.0d - f28227a) * ((double) f2))) : f * this.f1442a;
        }

        public final void g(Canvas canvas) {
            if (this.f1449c) {
                int iSave = canvas.save();
                canvas.translate(this.f1445a.centerX(), this.f1445a.centerY());
                canvas.drawPath(this.f1444a, this.f1443a);
                canvas.restoreToCount(iSave);
                return;
            }
            int iSave2 = canvas.save();
            canvas.rotate(this.j, this.f1445a.centerX(), this.f1445a.centerY());
            float f = this.e;
            float f2 = (-f) - this.h;
            float f3 = f * 2.0f;
            boolean z = this.f1445a.width() - f3 > 0.0f;
            boolean z2 = this.f1445a.height() - f3 > 0.0f;
            float f4 = this.i;
            float f5 = f4 - (this.b * f4);
            float f6 = f4 - (this.c * f4);
            float f7 = f4 - (this.d * f4);
            float f8 = f == 0.0f ? 1.0f : f / (f6 + f);
            float f9 = f == 0.0f ? 1.0f : f / (f5 + f);
            float f10 = f == 0.0f ? 1.0f : f / (f7 + f);
            int iSave3 = canvas.save();
            RectF rectF = this.f1445a;
            canvas.translate(rectF.left + f, rectF.top + f);
            canvas.scale(f8, f9);
            canvas.drawPath(this.f1444a, this.f1443a);
            if (z) {
                canvas.scale(1.0f / f8, 1.0f);
                canvas.drawRect(0.0f, f2, this.f1445a.width() - f3, -this.e, this.f1447b);
            }
            canvas.restoreToCount(iSave3);
            int iSave4 = canvas.save();
            RectF rectF2 = this.f1445a;
            canvas.translate(rectF2.right - f, rectF2.bottom - f);
            float f11 = f10;
            canvas.scale(f8, f11);
            canvas.rotate(180.0f);
            canvas.drawPath(this.f1444a, this.f1443a);
            if (z) {
                canvas.scale(1.0f / f8, 1.0f);
                canvas.drawRect(0.0f, f2, this.f1445a.width() - f3, -this.e, this.f1447b);
            }
            canvas.restoreToCount(iSave4);
            int iSave5 = canvas.save();
            RectF rectF3 = this.f1445a;
            canvas.translate(rectF3.left + f, rectF3.bottom - f);
            canvas.scale(f8, f11);
            canvas.rotate(270.0f);
            canvas.drawPath(this.f1444a, this.f1443a);
            if (z2) {
                canvas.scale(1.0f / f11, 1.0f);
                canvas.drawRect(0.0f, f2, this.f1445a.height() - f3, -this.e, this.f1447b);
            }
            canvas.restoreToCount(iSave5);
            int iSave6 = canvas.save();
            RectF rectF4 = this.f1445a;
            canvas.translate(rectF4.right - f, rectF4.top + f);
            float f12 = f9;
            canvas.scale(f8, f12);
            canvas.rotate(90.0f);
            canvas.drawPath(this.f1444a, this.f1443a);
            if (z2) {
                canvas.scale(1.0f / f12, 1.0f);
                canvas.drawRect(0.0f, f2, this.f1445a.height() - f3, -this.e, this.f1447b);
            }
            canvas.restoreToCount(iSave6);
            canvas.restoreToCount(iSave2);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getChangingConfigurations() {
            return super.getChangingConfigurations();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Drawable getCurrent() {
            return super.getCurrent();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
            return super.getIntrinsicHeight();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
            return super.getIntrinsicWidth();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumHeight() {
            return super.getMinimumHeight();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumWidth() {
            return super.getMinimumWidth();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            int iCeil = (int) Math.ceil(f(this.g, this.e, this.f1448b));
            int iCeil2 = (int) Math.ceil(e(this.g, this.e, this.f1448b));
            rect.set(iCeil2, iCeil, iCeil2, iCeil);
            return true;
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int[] getState() {
            return super.getState();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Region getTransparentRegion() {
            return super.getTransparentRegion();
        }

        public float h() {
            return this.e;
        }

        public float i() {
            return this.g;
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
            return super.isAutoMirrored();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isStateful() {
            return super.isStateful();
        }

        public float j() {
            float f = this.g;
            return (Math.max(f, this.e + ((this.f1442a * f) / 2.0f)) * 2.0f) + (this.g * this.f1442a * 2.0f);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void jumpToCurrentState() {
            super.jumpToCurrentState();
        }

        public float k() {
            float f = this.g;
            return (Math.max(f, this.e + (f / 2.0f)) * 2.0f) + (this.g * 2.0f);
        }

        public float l() {
            return this.i;
        }

        public void m(boolean z) {
            this.f1448b = z;
            invalidateSelf();
        }

        public void n(float f) {
            float fRound = Math.round(f);
            if (this.e == fRound) {
                return;
            }
            this.e = fRound;
            this.f1446a = true;
            invalidateSelf();
        }

        public void o(float f) {
            r(this.i, f);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            this.f1446a = true;
        }

        public final void p(float f) {
            if (this.j != f) {
                this.j = f;
                invalidateSelf();
            }
        }

        public void q(float f) {
            r(f, this.g);
        }

        public void r(float f, float f2) {
            if (f < 0.0f || f2 < 0.0f) {
                throw new IllegalArgumentException("invalid shadow size");
            }
            float fS = s(f);
            float fS2 = s(f2);
            if (fS > fS2) {
                fS = fS2;
            }
            if (this.i == fS && this.g == fS2) {
                return;
            }
            this.i = fS;
            this.g = fS2;
            this.h = Math.round(fS * this.f1442a);
            this.f = fS2;
            this.f1446a = true;
            invalidateSelf();
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            super.scheduleDrawable(drawable, runnable, j);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            super.setAlpha(i);
            this.f1443a.setAlpha(i);
            this.f1447b.setAlpha(i);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
            super.setAutoMirrored(z);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
            super.setChangingConfigurations(i);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setDither(boolean z) {
            super.setDither(z);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
            super.setFilterBitmap(z);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
            super.setHotspot(f, f2);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
            super.setHotspotBounds(i, i2, i3, i4);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
            return super.setState(iArr);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTint(int i) {
            super.setTint(i);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
            super.setTintList(colorStateList);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
            super.setTintMode(mode);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
            return super.setVisible(z, z2);
        }

        @Override // com.blankj.utilcode.util.f.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            super.unscheduleDrawable(drawable, runnable);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        Drawable background = view.getBackground();
        Object tag = view.getTag(-16);
        if (tag instanceof Drawable) {
            ViewCompat.setBackground(view, (Drawable) tag);
            return;
        }
        Drawable drawableA = aVar.a(background);
        ViewCompat.setBackground(view, drawableA);
        view.setTag(-16, drawableA);
    }

    public static void b(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            a(view, new a());
        }
    }
}
