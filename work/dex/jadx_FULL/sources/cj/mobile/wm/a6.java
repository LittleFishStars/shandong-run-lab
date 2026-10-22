package cj.mobile.wm;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a6 extends j6 {
    public final Rect dexa;
    public int dexb;
    public int dexc;
    public boolean dexd;
    public boolean dexe;
    public dexa dexf;

    public static class dexa extends Drawable.ConstantState {
        public static final Paint dexd = new Paint(6);
        public final Bitmap dexa;
        public int dexb;
        public Paint dexc;

        public dexa(Bitmap bitmap) {
            this.dexc = dexd;
            this.dexa = bitmap;
        }

        public dexa(dexa dexaVar) {
            this(dexaVar.dexa);
            this.dexb = dexaVar.dexb;
        }

        public void dexa() {
            if (dexd == this.dexc) {
                this.dexc = new Paint(6);
            }
        }

        public void dexa(int i) {
            dexa();
            this.dexc.setAlpha(i);
        }

        public void dexa(ColorFilter colorFilter) {
            dexa();
            this.dexc.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a6((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a6(resources, this);
        }
    }

    public a6(Resources resources, Bitmap bitmap) {
        this(resources, new dexa(bitmap));
    }

    public a6(Resources resources, dexa dexaVar) {
        int i;
        this.dexa = new Rect();
        if (dexaVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.dexf = dexaVar;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            i = i == 0 ? 160 : i;
            dexaVar.dexb = i;
        } else {
            i = dexaVar.dexb;
        }
        this.dexb = dexaVar.dexa.getScaledWidth(i);
        this.dexc = dexaVar.dexa.getScaledHeight(i);
    }

    public Bitmap dexa() {
        return this.dexf.dexa;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.dexd) {
            Gravity.apply(119, this.dexb, this.dexc, getBounds(), this.dexa);
            this.dexd = false;
        }
        dexa dexaVar = this.dexf;
        canvas.drawBitmap(dexaVar.dexa, (Rect) null, this.dexa, dexaVar.dexc);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.dexf;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.dexc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.dexb;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.dexf.dexa;
        return (bitmap == null || bitmap.hasAlpha() || this.dexf.dexc.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.dexe && super.mutate() == this) {
            this.dexf = new dexa(this.dexf);
            this.dexe = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.dexd = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.dexf.dexc.getAlpha() != i) {
            this.dexf.dexa(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.dexf.dexa(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
