package com.github.chrisbanes.photoview.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.annotation.RestrictTo;
import com.zj.adlib.fj9;
import com.zj.adlib.qq1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static final int N = 200;
    public static final int O = -2;
    public static final int P = -1;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = -2;
    public static final int U = -1;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 1;
    public static float e = 3.0f;
    public static float f = 1.75f;
    public static float g = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GestureDetector f1860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f1861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnLongClickListener f1862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageView f1865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnGestureListener f1866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnMatrixChangedListener f1867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnOutsidePhotoTapListener f1868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnPhotoTapListener f1869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnScaleChangedListener f1870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnSingleFlingListener f1871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnViewDragListener f1872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnViewTapListener f1873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.github.chrisbanes.photoview.custom.a f1874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f1875a;
    public float d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Interpolator f1863a = new AccelerateDecelerateInterpolator();
    public int K = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30395a = g;
    public float b = f;
    public float c = e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1876a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1879b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f1858a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Matrix f1878b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Matrix f1880c = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f1859a = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f1877a = new float[9];
    public int L = 2;
    public int M = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1881c = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView.ScaleType f1864a = ImageView.ScaleType.FIT_CENTER;

    public class a implements OnGestureListener {
        public a() {
        }

        @Override // com.github.chrisbanes.photoview.custom.OnGestureListener
        public void a(float f, float f2) {
            b.this.f1880c.postTranslate(f, f2);
            b.this.y();
            if (b.this.f1872a == null || !b.this.f1872a.c(f, f2)) {
                ViewParent parent = b.this.f1865a.getParent();
                if (!b.this.f1876a || b.this.f1874a.g() || b.this.f1879b) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((b.this.L == 2 || b.this.L == -2 || ((b.this.L == 0 && f >= 1.0f) || (b.this.L == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        @Override // com.github.chrisbanes.photoview.custom.OnGestureListener
        public void b(float f, float f2, float f3, float f4) {
            b bVar = b.this;
            bVar.f1875a = bVar.new f(bVar.f1865a.getContext());
            f fVar = b.this.f1875a;
            b bVar2 = b.this;
            int iH = bVar2.H(bVar2.f1865a);
            b bVar3 = b.this;
            fVar.c(iH, bVar3.G(bVar3.f1865a), (int) f3, (int) f4);
            b.this.f1865a.post(b.this.f1875a);
        }

        @Override // com.github.chrisbanes.photoview.custom.OnGestureListener
        public void c(float f, float f2, float f3) {
            if (b.this.L() < b.this.c || f < 1.0f) {
                if (b.this.f1870a != null) {
                    b.this.f1870a.a(f, f2, f3);
                }
                b.this.f1880c.postScale(f, f, f2, f3);
                b.this.y();
            }
        }
    }

    /* JADX INFO: renamed from: com.github.chrisbanes.photoview.custom.b$b, reason: collision with other inner class name */
    public class C0663b extends GestureDetector.SimpleOnGestureListener {
        public C0663b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (b.this.f1871a == null || b.this.L() > b.g || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            return b.this.f1871a.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.f1862a != null) {
                b.this.f1862a.onLongClick(b.this.f1865a);
            }
        }
    }

    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fL = b.this.L();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (fL < b.this.J()) {
                    b bVar = b.this;
                    bVar.d0(bVar.J(), x, y, true);
                } else if (fL < b.this.J() || fL >= b.this.I()) {
                    b bVar2 = b.this;
                    bVar2.d0(bVar2.K(), x, y, true);
                } else {
                    b bVar3 = b.this;
                    bVar3.d0(bVar3.I(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.f1861a != null) {
                b.this.f1861a.onClick(b.this.f1865a);
            }
            RectF rectFB = b.this.B();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (b.this.f1873a != null) {
                b.this.f1873a.a(b.this.f1865a, x, y);
            }
            if (rectFB == null) {
                return false;
            }
            if (!rectFB.contains(x, y)) {
                if (b.this.f1868a == null) {
                    return false;
                }
                b.this.f1868a.a(b.this.f1865a);
                return false;
            }
            float fWidth = (x - rectFB.left) / rectFB.width();
            float fHeight = (y - rectFB.top) / rectFB.height();
            if (b.this.f1869a == null) {
                return true;
            }
            b.this.f1869a.a(b.this.f1865a, fWidth, fHeight);
            return true;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30399a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f30399a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30399a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30399a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30399a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f30400a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f1882a = System.currentTimeMillis();
        public final float b;
        public final float c;
        public final float d;

        public e(float f, float f2, float f3, float f4) {
            this.f30400a = f3;
            this.b = f4;
            this.c = f;
            this.d = f2;
        }

        public final float b() {
            return b.this.f1863a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f1882a) * 1.0f) / b.this.K));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fB = b();
            float f = this.c;
            b.this.f1866a.c((f + ((this.d - f) * fB)) / b.this.L(), this.f30400a, this.b);
            if (fB < 1.0f) {
                qq1.a(b.this.f1865a, this);
            }
        }
    }

    public class f implements Runnable {
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OverScroller f30401a;

        public f(Context context) {
            this.f30401a = new OverScroller(context);
        }

        public void b() {
            this.f30401a.forceFinished(true);
        }

        public void c(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFB = b.this.B();
            if (rectFB == null) {
                return;
            }
            int iRound3 = Math.round(-rectFB.left);
            float f = i;
            if (f < rectFB.width()) {
                iRound = Math.round(rectFB.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFB.top);
            float f2 = i2;
            if (f2 < rectFB.height()) {
                iRound2 = Math.round(rectFB.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.K = iRound3;
            this.L = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f30401a.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f30401a.isFinished() && this.f30401a.computeScrollOffset()) {
                int currX = this.f30401a.getCurrX();
                int currY = this.f30401a.getCurrY();
                b.this.f1880c.postTranslate(this.K - currX, this.L - currY);
                b.this.y();
                this.K = currX;
                this.L = currY;
                qq1.a(b.this.f1865a, this);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public b(ImageView imageView) {
        a aVar = new a();
        this.f1866a = aVar;
        this.f1865a = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.d = 0.0f;
        this.f1874a = new com.github.chrisbanes.photoview.custom.a(imageView.getContext(), aVar);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new C0663b());
        this.f1860a = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public void A(Matrix matrix) {
        matrix.set(D());
    }

    public RectF B() {
        z();
        return C(D());
    }

    public final RectF C(Matrix matrix) {
        Drawable drawable = this.f1865a.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f1859a.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.f1859a);
        return this.f1859a;
    }

    public final Matrix D() {
        this.f1878b.set(this.f1858a);
        this.f1878b.postConcat(this.f1880c);
        return this.f1878b;
    }

    public int E() {
        return this.L;
    }

    public Matrix F() {
        return this.f1878b;
    }

    public final int G(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int H(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float I() {
        return this.c;
    }

    public float J() {
        return this.b;
    }

    public float K() {
        return this.f30395a;
    }

    public float L() {
        return (float) Math.sqrt(((float) Math.pow(O(this.f1880c, 0), 2.0d)) + ((float) Math.pow(O(this.f1880c, 3), 2.0d)));
    }

    public ImageView.ScaleType M() {
        return this.f1864a;
    }

    public void N(Matrix matrix) {
        matrix.set(this.f1880c);
    }

    public final float O(Matrix matrix, int i) {
        matrix.getValues(this.f1877a);
        return this.f1877a[i];
    }

    public int P() {
        return this.M;
    }

    @Deprecated
    public boolean Q() {
        return this.f1881c;
    }

    public boolean R() {
        return this.f1881c;
    }

    public final void S() {
        this.f1880c.reset();
        a0(this.d);
        W(D());
        z();
    }

    public void T(boolean z) {
        this.f1876a = z;
    }

    public void U(float f2) {
        this.d = f2 % 360.0f;
        update();
        a0(this.d);
        y();
    }

    public boolean V(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f1865a.getDrawable() == null) {
            return false;
        }
        this.f1880c.set(matrix);
        y();
        return true;
    }

    public final void W(Matrix matrix) {
        RectF rectFC;
        this.f1865a.setImageMatrix(matrix);
        if (this.f1867a == null || (rectFC = C(matrix)) == null) {
            return;
        }
        this.f1867a.a(rectFC);
    }

    public void X(float f2) {
        fj9.a(this.f30395a, this.b, f2);
        this.c = f2;
    }

    public void Y(float f2) {
        fj9.a(this.f30395a, f2, this.c);
        this.b = f2;
    }

    public void Z(float f2) {
        fj9.a(f2, this.b, this.c);
        this.f30395a = f2;
    }

    public void a0(float f2) {
        this.f1880c.postRotate(f2 % 360.0f);
        y();
    }

    public void b0(float f2) {
        this.f1880c.setRotate(f2 % 360.0f);
        y();
    }

    public void c0(float f2) {
        e0(f2, false);
    }

    public void d0(float f2, float f3, float f4, boolean z) {
        if (z) {
            this.f1865a.post(new e(L(), f2, f3, f4));
        } else {
            this.f1880c.setScale(f2, f2, f3, f4);
            y();
        }
    }

    public void e0(float f2, boolean z) {
        d0(f2, this.f1865a.getRight() / 2, this.f1865a.getBottom() / 2, z);
    }

    public void f0(float f2, float f3, float f4) {
        fj9.a(f2, f3, f4);
        this.f30395a = f2;
        this.b = f3;
        this.c = f4;
    }

    public void g0(ImageView.ScaleType scaleType) {
        if (!fj9.d(scaleType) || scaleType == this.f1864a) {
            return;
        }
        this.f1864a = scaleType;
        update();
    }

    public void h0(Interpolator interpolator) {
        this.f1863a = interpolator;
    }

    public void i0(int i) {
        this.K = i;
    }

    public void j0(boolean z) {
        this.f1881c = z;
        update();
    }

    public final void k0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fH = H(this.f1865a);
        float fG = G(this.f1865a);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f1858a.reset();
        float f2 = intrinsicWidth;
        float f3 = fH / f2;
        float f4 = intrinsicHeight;
        float f5 = fG / f4;
        ImageView.ScaleType scaleType = this.f1864a;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f1858a.postTranslate((fH - f2) / 2.0f, (fG - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.f1858a.postScale(fMax, fMax);
            this.f1858a.postTranslate((fH - (f2 * fMax)) / 2.0f, (fG - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.f1858a.postScale(fMin, fMin);
            this.f1858a.postTranslate((fH - (f2 * fMin)) / 2.0f, (fG - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fH, fG);
            if (((int) this.d) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = d.f30399a[this.f1864a.ordinal()];
            if (i == 1) {
                this.f1858a.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.f1858a.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.f1858a.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.f1858a.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        S();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        k0(this.f1865a.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        com.github.chrisbanes.photoview.custom.a aVar;
        GestureDetector gestureDetector;
        boolean zG;
        boolean zF;
        boolean z2;
        boolean z3;
        RectF rectFB;
        boolean z4 = false;
        if (!this.f1881c || !fj9.c((ImageView) view)) {
            if (motionEvent.getAction() == 0) {
                if (this.f1861a != null) {
                    return true;
                }
            } else if (motionEvent.getAction() == 1 && (onClickListener = this.f1861a) != null) {
                onClickListener.onClick(view);
                return true;
            }
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (L() < this.f30395a) {
                    RectF rectFB2 = B();
                    if (rectFB2 != null) {
                        view.post(new e(L(), this.f30395a, rectFB2.centerX(), rectFB2.centerY()));
                        z = true;
                    }
                } else if (L() > this.c && (rectFB = B()) != null) {
                    view.post(new e(L(), this.c, rectFB.centerX(), rectFB.centerY()));
                    z = true;
                }
            }
            aVar = this.f1874a;
            if (aVar != null) {
                zG = aVar.g();
                zF = this.f1874a.f();
                boolean zH = this.f1874a.h(motionEvent);
                if (!zG || this.f1874a.g()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!zF || this.f1874a.f()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z2 && z3) {
                    z4 = true;
                }
                this.f1879b = z4;
                z = zH;
            }
            gestureDetector = this.f1860a;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            return z;
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        x();
        z = false;
        aVar = this.f1874a;
        if (aVar != null) {
            zG = aVar.g();
            zF = this.f1874a.f();
            boolean zH2 = this.f1874a.h(motionEvent);
            if (zG) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (zF) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (z2) {
                z4 = true;
            }
            this.f1879b = z4;
            z = zH2;
        }
        gestureDetector = this.f1860a;
        if (gestureDetector == null) {
        }
        return z;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1861a = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1860a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1862a = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f1867a = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f1868a = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f1869a = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f1870a = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f1871a = onSingleFlingListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f1872a = onViewDragListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f1873a = onViewTapListener;
    }

    public void update() {
        if (this.f1881c) {
            k0(this.f1865a.getDrawable());
        } else {
            S();
        }
    }

    public final void x() {
        f fVar = this.f1875a;
        if (fVar != null) {
            fVar.b();
            this.f1875a = null;
        }
    }

    public final void y() {
        if (z()) {
            W(D());
        }
    }

    public final boolean z() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF rectFC = C(D());
        if (rectFC == null) {
            return false;
        }
        float fHeight = rectFC.height();
        float fWidth = rectFC.width();
        float fG = G(this.f1865a);
        float f7 = 0.0f;
        if (fHeight <= fG) {
            int i = d.f30399a[this.f1864a.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (fG - fHeight) / 2.0f;
                    f6 = rectFC.top;
                } else {
                    f5 = fG - fHeight;
                    f6 = rectFC.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -rectFC.top;
            }
            if (fHeight == fG) {
                this.M = 2;
            } else {
                this.M = -2;
            }
        } else {
            float f8 = rectFC.top;
            if (f8 > 0.0f) {
                this.M = 0;
                f2 = -f8;
            } else {
                float f9 = rectFC.bottom;
                if (f9 < fG) {
                    this.M = 1;
                    f2 = fG - f9;
                } else {
                    this.M = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fH = H(this.f1865a);
        if (fWidth <= fH) {
            int i2 = d.f30399a[this.f1864a.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (fH - fWidth) / 2.0f;
                    f4 = rectFC.left;
                } else {
                    f3 = fH - fWidth;
                    f4 = rectFC.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -rectFC.left;
            }
            if (fWidth == fH) {
                this.L = 2;
            } else {
                this.L = -2;
            }
        } else {
            float f10 = rectFC.left;
            if (f10 > 0.0f) {
                this.L = 0;
                f7 = -f10;
            } else {
                float f11 = rectFC.right;
                if (f11 < fH) {
                    f7 = fH - f11;
                    this.L = 1;
                } else {
                    this.L = -1;
                }
            }
        }
        this.f1880c.postTranslate(f7, f2);
        return true;
    }
}
