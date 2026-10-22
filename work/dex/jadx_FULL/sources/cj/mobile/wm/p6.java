package cj.mobile.wm;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p6 extends j6 implements t6.dexc {
    public final Paint dexa;
    public final Rect dexb;
    public final dexa dexc;
    public final j2 dexd;
    public final t6 dexe;
    public boolean dexf;
    public boolean dexg;
    public boolean dexh;
    public boolean dexi;
    public int dexj;
    public int dexk;
    public boolean dexl;

    public static class dexa extends Drawable.ConstantState {
        public l2 dexa;
        public byte[] dexb;
        public Context dexc;
        public v2<Bitmap> dexd;
        public int dexe;
        public int dexf;
        public j2.dexa dexg;
        public r3 dexh;
        public Bitmap dexi;

        public dexa(l2 l2Var, byte[] bArr, Context context, v2<Bitmap> v2Var, int i, int i2, j2.dexa dexaVar, r3 r3Var, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.dexa = l2Var;
            this.dexb = bArr;
            this.dexh = r3Var;
            this.dexi = bitmap;
            this.dexc = context.getApplicationContext();
            this.dexd = v2Var;
            this.dexe = i;
            this.dexf = i2;
            this.dexg = dexaVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new p6(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public p6(Context context, j2.dexa dexaVar, r3 r3Var, v2<Bitmap> v2Var, int i, int i2, l2 l2Var, byte[] bArr, Bitmap bitmap) {
        this(new dexa(l2Var, bArr, context, v2Var, i, i2, dexaVar, r3Var, bitmap));
    }

    public p6(dexa dexaVar) {
        this.dexb = new Rect();
        this.dexi = true;
        this.dexk = -1;
        if (dexaVar == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.dexc = dexaVar;
        j2 j2Var = new j2(dexaVar.dexg);
        this.dexd = j2Var;
        this.dexa = new Paint();
        j2Var.dexa(dexaVar.dexa, dexaVar.dexb);
        t6 t6Var = new t6(dexaVar.dexc, this, j2Var, dexaVar.dexe, dexaVar.dexf);
        this.dexe = t6Var;
        t6Var.dexa(dexaVar.dexd);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p6(p6 p6Var, Bitmap bitmap, v2<Bitmap> v2Var) {
        dexa dexaVar = p6Var.dexc;
        this(new dexa(dexaVar.dexa, dexaVar.dexb, dexaVar.dexc, v2Var, dexaVar.dexe, dexaVar.dexf, dexaVar.dexg, dexaVar.dexh, bitmap));
    }

    private void dexf() {
        this.dexe.dexa();
        invalidateSelf();
    }

    private void dexg() {
        this.dexj = 0;
    }

    private void dexh() {
        if (this.dexd.dexd() != 1) {
            if (this.dexf) {
                return;
            }
            this.dexf = true;
            this.dexe.dexc();
        }
        invalidateSelf();
    }

    private void dexi() {
        this.dexf = false;
        this.dexe.dexd();
    }

    @Override // cj.mobile.wm.t6.dexc
    @TargetApi(11)
    public void a(int i) {
        if (getCallback() == null) {
            stop();
            dexf();
            return;
        }
        invalidateSelf();
        if (i == this.dexd.dexd() - 1) {
            this.dexj++;
        }
        int i2 = this.dexk;
        if (i2 == -1 || this.dexj < i2) {
            return;
        }
        stop();
    }

    public byte[] dexa() {
        return this.dexc.dexb;
    }

    public Bitmap dexb() {
        return this.dexc.dexi;
    }

    public int dexc() {
        return this.dexd.dexd();
    }

    public v2<Bitmap> dexd() {
        return this.dexc.dexd;
    }

    public void dexe() {
        this.dexh = true;
        dexa dexaVar = this.dexc;
        dexaVar.dexh.a(dexaVar.dexi);
        this.dexe.dexa();
        this.dexe.dexd();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.dexh) {
            return;
        }
        if (this.dexl) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.dexb);
            this.dexl = false;
        }
        Bitmap bitmapDexb = this.dexe.dexb();
        if (bitmapDexb == null) {
            bitmapDexb = this.dexc.dexi;
        }
        canvas.drawBitmap(bitmapDexb, (Rect) null, this.dexb, this.dexa);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.dexc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.dexc.dexi.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.dexc.dexi.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.dexf;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.dexl = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.dexa.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.dexa.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.dexi = z;
        if (!z) {
            dexi();
        } else if (this.dexg) {
            dexh();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.dexg = true;
        dexg();
        if (this.dexi) {
            dexh();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.dexg = false;
        dexi();
    }
}
