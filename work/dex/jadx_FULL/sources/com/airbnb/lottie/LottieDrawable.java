package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.a45;
import com.zj.adlib.b45;
import com.zj.adlib.b85;
import com.zj.adlib.ds4;
import com.zj.adlib.dw4;
import com.zj.adlib.g25;
import com.zj.adlib.i45;
import com.zj.adlib.j45;
import com.zj.adlib.k35;
import com.zj.adlib.lk3;
import com.zj.adlib.mk3;
import com.zj.adlib.n39;
import com.zj.adlib.o64;
import com.zj.adlib.up5;
import com.zj.adlib.vs4;
import com.zj.adlib.zt4;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = -1;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f23322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Canvas f318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RectF f322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ImageAssetDelegate f323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnVisibleAction f324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RenderMode f325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.airbnb.lottie.model.layer.a f326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i45 f327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k35 f328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public lk3 f329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public mk3 f330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public n39 f331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public o64 f332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<LazyCompositionTask> f333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f334a;
    public Matrix b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Rect f335b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RectF f336b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f337b;
    public Matrix c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Rect f338c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public RectF f339c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f340c;
    public boolean d;
    public boolean e;

    @Nullable
    public String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f341f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    public interface LazyCompositionTask {
        void a(k35 k35Var);
    }

    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.f326a != null) {
                LottieDrawable.this.f326a.L(LottieDrawable.this.f327a.m());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends j45<T> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SimpleLottieValueCallback f342a;

        public b(SimpleLottieValueCallback simpleLottieValueCallback) {
            this.f342a = simpleLottieValueCallback;
        }

        @Override // com.zj.adlib.j45
        public T a(a45<T> a45Var) {
            return (T) this.f342a.a(a45Var);
        }
    }

    public LottieDrawable() {
        i45 i45Var = new i45();
        this.f327a = i45Var;
        this.f334a = true;
        this.f337b = false;
        this.f340c = false;
        this.f324a = OnVisibleAction.NONE;
        this.f333a = new ArrayList<>();
        a aVar = new a();
        this.f23322a = aVar;
        this.e = false;
        this.f341f = true;
        this.K = 255;
        this.f325a = RenderMode.AUTOMATIC;
        this.j = false;
        this.f319a = new Matrix();
        this.k = false;
        i45Var.addUpdateListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(float f, k35 k35Var) {
        h1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(float f, k35 k35Var) {
        k1(f);
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ds4 ds4Var, Object obj, j45 j45Var, k35 k35Var) {
        v(ds4Var, obj, j45Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(k35 k35Var) {
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(k35 k35Var) {
        M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(int i, k35 k35Var) {
        T0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(int i, k35 k35Var) {
        Y0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, k35 k35Var) {
        Z0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(float f, k35 k35Var) {
        a1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int i, int i2, k35 k35Var) {
        b1(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(String str, k35 k35Var) {
        c1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(String str, String str2, boolean z, k35 k35Var) {
        d1(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(float f, float f2, k35 k35Var) {
        e1(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(int i, k35 k35Var) {
        f1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str, k35 k35Var) {
        g1(str);
    }

    public final void A() {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            return;
        }
        this.j = this.f325a.useSoftwareRendering(Build.VERSION.SDK_INT, k35Var.t(), k35Var.n());
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void C(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    @Deprecated
    public void C0(boolean z) {
        this.f327a.setRepeatCount(z ? -1 : 0);
    }

    @Deprecated
    public void D() {
    }

    public void D0() {
        this.f333a.clear();
        this.f327a.v();
        if (isVisible()) {
            return;
        }
        this.f324a = OnVisibleAction.NONE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void E(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        k35 k35Var = this.f328a;
        if (aVar == null || k35Var == null) {
            return;
        }
        if (this.j) {
            canvas.save();
            canvas.concat(matrix);
            K0(canvas, aVar);
            canvas.restore();
        } else {
            aVar.b(canvas, matrix, this.K);
        }
        this.k = false;
    }

    @MainThread
    public void E0() {
        if (this.f326a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.c
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f23356a.o0(k35Var);
                }
            });
            return;
        }
        A();
        if (w() || a0() == 0) {
            if (isVisible()) {
                this.f327a.x();
                this.f324a = OnVisibleAction.NONE;
            } else {
                this.f324a = OnVisibleAction.PLAY;
            }
        }
        if (w()) {
            return;
        }
        T0((int) (c0() < 0.0f ? W() : V()));
        this.f327a.l();
        if (isVisible()) {
            return;
        }
        this.f324a = OnVisibleAction.NONE;
    }

    public final void F(Canvas canvas) {
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        k35 k35Var = this.f328a;
        if (aVar == null || k35Var == null) {
            return;
        }
        this.f319a.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.f319a.preScale(bounds.width() / k35Var.b().width(), bounds.height() / k35Var.b().height());
        }
        aVar.b(canvas, this.f319a, this.K);
    }

    public void F0() {
        this.f327a.removeAllListeners();
    }

    public void G(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        if (this.f328a != null) {
            x();
        }
    }

    public void G0() {
        this.f327a.removeAllUpdateListeners();
        this.f327a.addUpdateListener(this.f23322a);
    }

    public boolean H() {
        return this.d;
    }

    public void H0(Animator.AnimatorListener animatorListener) {
        this.f327a.removeListener(animatorListener);
    }

    @MainThread
    public void I() {
        this.f333a.clear();
        this.f327a.l();
        if (isVisible()) {
            return;
        }
        this.f324a = OnVisibleAction.NONE;
    }

    @RequiresApi(api = 19)
    public void I0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f327a.removePauseListener(animatorPauseListener);
    }

    public final void J(int i, int i2) {
        Bitmap bitmap = this.f317a;
        if (bitmap == null || bitmap.getWidth() < i || this.f317a.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f317a = bitmapCreateBitmap;
            this.f318a.setBitmap(bitmapCreateBitmap);
            this.k = true;
            return;
        }
        if (this.f317a.getWidth() > i || this.f317a.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f317a, 0, 0, i, i2);
            this.f317a = bitmapCreateBitmap2;
            this.f318a.setBitmap(bitmapCreateBitmap2);
            this.k = true;
        }
    }

    public void J0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f327a.removeUpdateListener(animatorUpdateListener);
    }

    public final void K() {
        if (this.f318a != null) {
            return;
        }
        this.f318a = new Canvas();
        this.f339c = new RectF();
        this.b = new Matrix();
        this.c = new Matrix();
        this.f321a = new Rect();
        this.f322a = new RectF();
        this.f320a = new zt4();
        this.f335b = new Rect();
        this.f338c = new Rect();
        this.f336b = new RectF();
    }

    public final void K0(Canvas canvas, com.airbnb.lottie.model.layer.a aVar) {
        if (this.f328a == null || aVar == null) {
            return;
        }
        K();
        canvas.getMatrix(this.b);
        canvas.getClipBounds(this.f321a);
        B(this.f321a, this.f322a);
        this.b.mapRect(this.f322a);
        C(this.f322a, this.f321a);
        if (this.f341f) {
            this.f339c.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            aVar.a(this.f339c, null, false);
        }
        this.b.mapRect(this.f339c);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        O0(this.f339c, fWidth, fHeight);
        if (!h0()) {
            RectF rectF = this.f339c;
            Rect rect = this.f321a;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.f339c.width());
        int iCeil2 = (int) Math.ceil(this.f339c.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        J(iCeil, iCeil2);
        if (this.k) {
            this.f319a.set(this.b);
            this.f319a.preScale(fWidth, fHeight);
            Matrix matrix = this.f319a;
            RectF rectF2 = this.f339c;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.f317a.eraseColor(0);
            aVar.b(this.f318a, this.f319a, this.K);
            this.b.invert(this.c);
            this.c.mapRect(this.f336b, this.f339c);
            C(this.f336b, this.f338c);
        }
        this.f335b.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.f317a, this.f335b, this.f338c, this.f320a);
    }

    @Nullable
    public Bitmap L(String str) {
        o64 o64VarR = R();
        if (o64VarR != null) {
            return o64VarR.a(str);
        }
        return null;
    }

    public List<ds4> L0(ds4 ds4Var) {
        if (this.f326a == null) {
            g25.e("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f326a.g(ds4Var, 0, arrayList, new ds4(new String[0]));
        return arrayList;
    }

    public boolean M() {
        return this.f341f;
    }

    @MainThread
    public void M0() {
        if (this.f326a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.k
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f23364a.p0(k35Var);
                }
            });
            return;
        }
        A();
        if (w() || a0() == 0) {
            if (isVisible()) {
                this.f327a.y();
                this.f324a = OnVisibleAction.NONE;
            } else {
                this.f324a = OnVisibleAction.RESUME;
            }
        }
        if (w()) {
            return;
        }
        T0((int) (c0() < 0.0f ? W() : V()));
        this.f327a.l();
        if (isVisible()) {
            return;
        }
        this.f324a = OnVisibleAction.NONE;
    }

    public k35 N() {
        return this.f328a;
    }

    public void N0() {
        this.f327a.z();
    }

    public final mk3 O() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f330a == null) {
            this.f330a = new mk3(getCallback(), this.f329a);
        }
        return this.f330a;
    }

    public final void O0(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    public int P() {
        return (int) this.f327a.o();
    }

    public void P0(boolean z) {
        this.i = z;
    }

    @Nullable
    @Deprecated
    public Bitmap Q(String str) {
        o64 o64VarR = R();
        if (o64VarR != null) {
            return o64VarR.a(str);
        }
        k35 k35Var = this.f328a;
        b45 b45Var = k35Var == null ? null : k35Var.j().get(str);
        if (b45Var != null) {
            return b45Var.a();
        }
        return null;
    }

    public void Q0(boolean z) {
        if (z != this.f341f) {
            this.f341f = z;
            com.airbnb.lottie.model.layer.a aVar = this.f326a;
            if (aVar != null) {
                aVar.Q(z);
            }
            invalidateSelf();
        }
    }

    public final o64 R() {
        if (getCallback() == null) {
            return null;
        }
        o64 o64Var = this.f332a;
        if (o64Var != null && !o64Var.c(getContext())) {
            this.f332a = null;
        }
        if (this.f332a == null) {
            this.f332a = new o64(getCallback(), this.f, this.f323a, this.f328a.j());
        }
        return this.f332a;
    }

    public boolean R0(k35 k35Var) {
        if (this.f328a == k35Var) {
            return false;
        }
        this.k = true;
        z();
        this.f328a = k35Var;
        x();
        this.f327a.A(k35Var);
        k1(this.f327a.getAnimatedFraction());
        Iterator it = new ArrayList(this.f333a).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.a(k35Var);
            }
            it.remove();
        }
        this.f333a.clear();
        k35Var.z(this.g);
        A();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    @Nullable
    public String S() {
        return this.f;
    }

    public void S0(lk3 lk3Var) {
        this.f329a = lk3Var;
        mk3 mk3Var = this.f330a;
        if (mk3Var != null) {
            mk3Var.d(lk3Var);
        }
    }

    @Nullable
    public b45 T(String str) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            return null;
        }
        return k35Var.j().get(str);
    }

    public void T0(final int i) {
        if (this.f328a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.d
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f479a.q0(i, k35Var);
                }
            });
        } else {
            this.f327a.B(i);
        }
    }

    public boolean U() {
        return this.e;
    }

    public void U0(boolean z) {
        this.f337b = z;
    }

    public float V() {
        return this.f327a.r();
    }

    public void V0(ImageAssetDelegate imageAssetDelegate) {
        this.f323a = imageAssetDelegate;
        o64 o64Var = this.f332a;
        if (o64Var != null) {
            o64Var.e(imageAssetDelegate);
        }
    }

    public float W() {
        return this.f327a.s();
    }

    public void W0(@Nullable String str) {
        this.f = str;
    }

    @Nullable
    public PerformanceTracker X() {
        k35 k35Var = this.f328a;
        if (k35Var != null) {
            return k35Var.o();
        }
        return null;
    }

    public void X0(boolean z) {
        this.e = z;
    }

    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public float Y() {
        return this.f327a.m();
    }

    public void Y0(final int i) {
        if (this.f328a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.j
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f485a.r0(i, k35Var);
                }
            });
        } else {
            this.f327a.C(i + 0.99f);
        }
    }

    public RenderMode Z() {
        return this.j ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void Z0(final String str) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.l
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f23365a.s0(str, k35Var2);
                }
            });
            return;
        }
        b85 b85VarL = k35Var.l(str);
        if (b85VarL != null) {
            Y0((int) (b85VarL.f40696a + b85VarL.f15462b));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + Consts.DOT);
    }

    public int a0() {
        return this.f327a.getRepeatCount();
    }

    public void a1(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) final float f) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.b
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f478a.t0(f, k35Var2);
                }
            });
        } else {
            this.f327a.C(up5.k(k35Var.r(), this.f328a.f(), f));
        }
    }

    @SuppressLint({"WrongConstant"})
    public int b0() {
        return this.f327a.getRepeatMode();
    }

    public void b1(final int i, final int i2) {
        if (this.f328a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.e
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f480a.u0(i, i2, k35Var);
                }
            });
        } else {
            this.f327a.D(i, i2 + 0.99f);
        }
    }

    public float c0() {
        return this.f327a.t();
    }

    public void c1(final String str) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.f
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f23359a.v0(str, k35Var2);
                }
            });
            return;
        }
        b85 b85VarL = k35Var.l(str);
        if (b85VarL != null) {
            int i = (int) b85VarL.f40696a;
            b1(i, ((int) b85VarL.f15462b) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + Consts.DOT);
        }
    }

    @Nullable
    public n39 d0() {
        return this.f331a;
    }

    public void d1(final String str, final String str2, final boolean z) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f23366a.w0(str, str2, z, k35Var2);
                }
            });
            return;
        }
        b85 b85VarL = k35Var.l(str);
        if (b85VarL == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + Consts.DOT);
        }
        int i = (int) b85VarL.f40696a;
        b85 b85VarL2 = this.f328a.l(str2);
        if (b85VarL2 != null) {
            b1(i, (int) (b85VarL2.f40696a + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + Consts.DOT);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        vs4.a("Drawable#draw");
        if (this.f340c) {
            try {
                if (this.j) {
                    K0(canvas, this.f326a);
                } else {
                    F(canvas);
                }
            } catch (Throwable th) {
                g25.c("Lottie crashed in draw!", th);
            }
        } else if (this.j) {
            K0(canvas, this.f326a);
        } else {
            F(canvas);
        }
        this.k = false;
        vs4.b("Drawable#draw");
    }

    @Nullable
    public Typeface e0(String str, String str2) {
        mk3 mk3VarO = O();
        if (mk3VarO != null) {
            return mk3VarO.b(str, str2);
        }
        return null;
    }

    public void e1(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) final float f, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) final float f2) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.g
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f482a.x0(f, f2, k35Var2);
                }
            });
        } else {
            b1((int) up5.k(k35Var.r(), this.f328a.f(), f), (int) up5.k(this.f328a.r(), this.f328a.f(), f2));
        }
    }

    public boolean f0() {
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        return aVar != null && aVar.O();
    }

    public void f1(final int i) {
        if (this.f328a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.h
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f483a.y0(i, k35Var);
                }
            });
        } else {
            this.f327a.E(i);
        }
    }

    public boolean g0() {
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        return aVar != null && aVar.P();
    }

    public void g1(final String str) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f23381a.z0(str, k35Var2);
                }
            });
            return;
        }
        b85 b85VarL = k35Var.l(str);
        if (b85VarL != null) {
            f1((int) b85VarL.f40696a);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + Consts.DOT);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.K;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            return -1;
        }
        return k35Var.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            return -1;
        }
        return k35Var.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final boolean h0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (parent instanceof ViewGroup) {
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    public void h1(final float f) {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var2) {
                    this.f484a.A0(f, k35Var2);
                }
            });
        } else {
            f1((int) up5.k(k35Var.r(), this.f328a.f(), f));
        }
    }

    public boolean i0() {
        i45 i45Var = this.f327a;
        if (i45Var == null) {
            return false;
        }
        return i45Var.isRunning();
    }

    public void i1(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        if (aVar != null) {
            aVar.J(z);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.k) {
            return;
        }
        this.k = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return i0();
    }

    public boolean j0() {
        if (isVisible()) {
            return this.f327a.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f324a;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public void j1(boolean z) {
        this.g = z;
        k35 k35Var = this.f328a;
        if (k35Var != null) {
            k35Var.z(z);
        }
    }

    public boolean k0() {
        return this.i;
    }

    public void k1(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) final float f) {
        if (this.f328a == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.a
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f362a.B0(f, k35Var);
                }
            });
            return;
        }
        vs4.a("Drawable#setProgress");
        this.f327a.B(this.f328a.h(f));
        vs4.b("Drawable#setProgress");
    }

    public boolean l0() {
        return this.f327a.getRepeatCount() == -1;
    }

    public void l1(RenderMode renderMode) {
        this.f325a = renderMode;
        A();
    }

    public boolean m0() {
        return this.d;
    }

    public void m1(int i) {
        this.f327a.setRepeatCount(i);
    }

    public void n1(int i) {
        this.f327a.setRepeatMode(i);
    }

    public void o1(boolean z) {
        this.f340c = z;
    }

    public void p1(float f) {
        this.f327a.F(f);
    }

    public void q1(Boolean bool) {
        this.f334a = bool.booleanValue();
    }

    public void r(Animator.AnimatorListener animatorListener) {
        this.f327a.addListener(animatorListener);
    }

    public void r1(n39 n39Var) {
        this.f331a = n39Var;
    }

    @RequiresApi(api = 19)
    public void s(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f327a.addPauseListener(animatorPauseListener);
    }

    @Nullable
    public Bitmap s1(String str, @Nullable Bitmap bitmap) {
        o64 o64VarR = R();
        if (o64VarR == null) {
            g25.e("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapF = o64VarR.f(str, bitmap);
        invalidateSelf();
        return bitmapF;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.K = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        g25.e("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            OnVisibleAction onVisibleAction = this.f324a;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                E0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                M0();
            }
        } else if (this.f327a.isRunning()) {
            D0();
            this.f324a = OnVisibleAction.RESUME;
        } else if (!z3) {
            this.f324a = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        E0();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        I();
    }

    public void t(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f327a.addUpdateListener(animatorUpdateListener);
    }

    public boolean t1() {
        return this.f331a == null && this.f328a.c().size() > 0;
    }

    public <T> void u(ds4 ds4Var, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        v(ds4Var, t, new b(simpleLottieValueCallback));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public <T> void v(final ds4 ds4Var, final T t, @Nullable final j45<T> j45Var) {
        com.airbnb.lottie.model.layer.a aVar = this.f326a;
        if (aVar == null) {
            this.f333a.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(k35 k35Var) {
                    this.f23382a.n0(ds4Var, t, j45Var, k35Var);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (ds4Var == ds4.f41268a) {
            aVar.i(t, j45Var);
        } else if (ds4Var.d() != null) {
            ds4Var.d().i(t, j45Var);
        } else {
            List<ds4> listL0 = L0(ds4Var);
            for (int i = 0; i < listL0.size(); i++) {
                listL0.get(i).d().i(t, j45Var);
            }
            zIsEmpty = true ^ listL0.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == LottieProperty.t) {
                k1(Y());
            }
        }
    }

    public final boolean w() {
        return this.f334a || this.f337b;
    }

    public final void x() {
        k35 k35Var = this.f328a;
        if (k35Var == null) {
            return;
        }
        com.airbnb.lottie.model.layer.a aVar = new com.airbnb.lottie.model.layer.a(this, dw4.b(k35Var), k35Var.k(), k35Var);
        this.f326a = aVar;
        if (this.h) {
            aVar.J(true);
        }
        this.f326a.Q(this.f341f);
    }

    public void y() {
        this.f333a.clear();
        this.f327a.cancel();
        if (isVisible()) {
            return;
        }
        this.f324a = OnVisibleAction.NONE;
    }

    public void z() {
        if (this.f327a.isRunning()) {
            this.f327a.cancel();
            if (!isVisible()) {
                this.f324a = OnVisibleAction.NONE;
            }
        }
        this.f328a = null;
        this.f326a = null;
        this.f332a = null;
        this.f327a.k();
        invalidateSelf();
    }
}
