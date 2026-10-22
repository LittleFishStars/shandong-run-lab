package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.c;
import com.airbnb.lottie.animation.keyframe.k;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.zj.adlib.d74;
import com.zj.adlib.d85;
import com.zj.adlib.ds4;
import com.zj.adlib.g25;
import com.zj.adlib.g88;
import com.zj.adlib.gl8;
import com.zj.adlib.hs2;
import com.zj.adlib.j45;
import com.zj.adlib.k35;
import com.zj.adlib.m88;
import com.zj.adlib.sy0;
import com.zj.adlib.u39;
import com.zj.adlib.vj9;
import com.zj.adlib.vs4;
import com.zj.adlib.z36;
import com.zj.adlib.zt4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23376a = 2;
    public static final int b = 16;
    public static final int c = 1;
    public static final int d = 19;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BlurMaskFilter f529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k f536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BaseLayer f537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Layer f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d85 f539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<BaseLayer> f541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f542a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f545b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public BaseLayer f546b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<BaseKeyframeAnimation<?, ?>> f547b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f548b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Matrix f549c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final RectF f551c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Paint f552d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final RectF f553d;
    public final Paint e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final RectF f554e;

    @Nullable
    public Paint f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f532a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f530a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Matrix f543b = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f531a = new zt4(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f544b = new zt4(1, PorterDuff.Mode.DST_IN);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f550c = new zt4(1, PorterDuff.Mode.DST_OUT);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23377a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f23377a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23377a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23377a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23377a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23377a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23377a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23377a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        zt4 zt4Var = new zt4(1);
        this.f552d = zt4Var;
        this.e = new zt4(PorterDuff.Mode.CLEAR);
        this.f533a = new RectF();
        this.f545b = new RectF();
        this.f551c = new RectF();
        this.f553d = new RectF();
        this.f554e = new RectF();
        this.f549c = new Matrix();
        this.f547b = new ArrayList();
        this.f542a = true;
        this.f528a = 0.0f;
        this.f534a = lottieDrawable;
        this.f538a = layer;
        this.f540a = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            zt4Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            zt4Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        k kVarB = layer.w().b();
        this.f536a = kVarB;
        kVarB.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            d85 d85Var = new d85(layer.g());
            this.f539a = d85Var;
            Iterator<BaseKeyframeAnimation<g88, Path>> it = d85Var.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation : this.f539a.c()) {
                j(baseKeyframeAnimation);
                baseKeyframeAnimation.a(this);
            }
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        M(this.f535a.m() == 1.0f);
    }

    @Nullable
    public static BaseLayer v(com.airbnb.lottie.model.layer.a aVar, Layer layer, LottieDrawable lottieDrawable, k35 k35Var) {
        switch (a.f23377a[layer.f().ordinal()]) {
            case 1:
                return new m88(lottieDrawable, layer, aVar);
            case 2:
                return new com.airbnb.lottie.model.layer.a(lottieDrawable, layer, k35Var.p(layer.m()), k35Var);
            case 3:
                return new gl8(lottieDrawable, layer);
            case 4:
                return new d74(lottieDrawable, layer);
            case 5:
                return new z36(lottieDrawable, layer);
            case 6:
                return new u39(lottieDrawable, layer);
            default:
                g25.e("Unknown layer type " + layer.f());
                return null;
        }
    }

    public boolean A() {
        d85 d85Var = this.f539a;
        return (d85Var == null || d85Var.a().isEmpty()) ? false : true;
    }

    public boolean B() {
        return this.f537a != null;
    }

    public final void C(RectF rectF, Matrix matrix) {
        this.f551c.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (A()) {
            int size = this.f539a.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.f539a.b().get(i);
                Path pathF = this.f539a.a().get(i).f();
                if (pathF != null) {
                    this.f532a.set(pathF);
                    this.f532a.transform(matrix);
                    int i2 = a.b[mask.a().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && mask.d()) {
                        return;
                    }
                    this.f532a.computeBounds(this.f554e, false);
                    if (i == 0) {
                        this.f551c.set(this.f554e);
                    } else {
                        RectF rectF2 = this.f551c;
                        rectF2.set(Math.min(rectF2.left, this.f554e.left), Math.min(this.f551c.top, this.f554e.top), Math.max(this.f551c.right, this.f554e.right), Math.max(this.f551c.bottom, this.f554e.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f551c)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void D(RectF rectF, Matrix matrix) {
        if (B() && this.f538a.h() != Layer.MatteType.INVERT) {
            this.f553d.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f537a.a(this.f553d, matrix, true);
            if (rectF.intersect(this.f553d)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void E() {
        this.f534a.invalidateSelf();
    }

    public final void G(float f) {
        this.f534a.N().o().e(this.f538a.i(), f);
    }

    public void H(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f547b.remove(baseKeyframeAnimation);
    }

    public void I(@Nullable BaseLayer baseLayer) {
        this.f537a = baseLayer;
    }

    public void J(boolean z) {
        if (z && this.f == null) {
            this.f = new zt4();
        }
        this.f548b = z;
    }

    public void K(@Nullable BaseLayer baseLayer) {
        this.f546b = baseLayer;
    }

    public void L(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        this.f536a.j(f);
        if (this.f539a != null) {
            for (int i = 0; i < this.f539a.a().size(); i++) {
                this.f539a.a().get(i).j(f);
            }
        }
        c cVar = this.f535a;
        if (cVar != null) {
            cVar.j(f);
        }
        BaseLayer baseLayer = this.f537a;
        if (baseLayer != null) {
            baseLayer.L(f);
        }
        for (int i2 = 0; i2 < this.f547b.size(); i2++) {
            this.f547b.get(i2).j(f);
        }
    }

    public final void M(boolean z) {
        if (z != this.f542a) {
            this.f542a = z;
            E();
        }
    }

    public final void N() {
        if (this.f538a.e().isEmpty()) {
            M(true);
            return;
        }
        c cVar = new c(this.f538a.e());
        this.f535a = cVar;
        cVar.i();
        this.f535a.a(new BaseKeyframeAnimation.AnimationListener() { // from class: com.zj.adlib.zn0
            @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
            public final void h() {
                this.f46301a.F();
            }
        });
        M(this.f535a.f().floatValue() == 1.0f);
        j(this.f535a);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f533a.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f549c.set(matrix);
        if (z) {
            List<BaseLayer> list = this.f541a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f549c.preConcat(this.f541a.get(size).f536a.f());
                }
            } else {
                BaseLayer baseLayer = this.f546b;
                if (baseLayer != null) {
                    this.f549c.preConcat(baseLayer.f536a.f());
                }
            }
        }
        this.f549c.preConcat(this.f536a.f());
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        vs4.a(this.f540a);
        if (!this.f542a || this.f538a.x()) {
            vs4.b(this.f540a);
            return;
        }
        s();
        vs4.a("Layer#parentMatrix");
        this.f530a.reset();
        this.f530a.set(matrix);
        for (int size = this.f541a.size() - 1; size >= 0; size--) {
            this.f530a.preConcat(this.f541a.get(size).f536a.f());
        }
        vs4.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * (this.f536a.h() == null ? 100 : this.f536a.h().f().intValue())) / 100.0f) * 255.0f);
        if (!B() && !A()) {
            this.f530a.preConcat(this.f536a.f());
            vs4.a("Layer#drawLayer");
            u(canvas, this.f530a, iIntValue);
            vs4.b("Layer#drawLayer");
            G(vs4.b(this.f540a));
            return;
        }
        vs4.a("Layer#computeBounds");
        a(this.f533a, this.f530a, false);
        D(this.f533a, matrix);
        this.f530a.preConcat(this.f536a.f());
        C(this.f533a, this.f530a);
        this.f545b.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.f543b);
        if (!this.f543b.isIdentity()) {
            Matrix matrix2 = this.f543b;
            matrix2.invert(matrix2);
            this.f543b.mapRect(this.f545b);
        }
        if (!this.f533a.intersect(this.f545b)) {
            this.f533a.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        vs4.b("Layer#computeBounds");
        if (this.f533a.width() >= 1.0f && this.f533a.height() >= 1.0f) {
            vs4.a("Layer#saveLayer");
            this.f531a.setAlpha(255);
            vj9.n(canvas, this.f533a, this.f531a);
            vs4.b("Layer#saveLayer");
            t(canvas);
            vs4.a("Layer#drawLayer");
            u(canvas, this.f530a, iIntValue);
            vs4.b("Layer#drawLayer");
            if (A()) {
                p(canvas, this.f530a);
            }
            if (B()) {
                vs4.a("Layer#drawMatte");
                vs4.a("Layer#saveLayer");
                vj9.o(canvas, this.f533a, this.f552d, 19);
                vs4.b("Layer#saveLayer");
                t(canvas);
                this.f537a.b(canvas, matrix, iIntValue);
                vs4.a("Layer#restoreLayer");
                canvas.restore();
                vs4.b("Layer#restoreLayer");
                vs4.b("Layer#drawMatte");
            }
            vs4.a("Layer#restoreLayer");
            canvas.restore();
            vs4.b("Layer#restoreLayer");
        }
        if (this.f548b && (paint = this.f) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.f.setColor(-251901);
            this.f.setStrokeWidth(4.0f);
            canvas.drawRect(this.f533a, this.f);
            this.f.setStyle(Paint.Style.FILL);
            this.f.setColor(1357638635);
            canvas.drawRect(this.f533a, this.f);
        }
        G(vs4.b(this.f540a));
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        BaseLayer baseLayer = this.f537a;
        if (baseLayer != null) {
            ds4 ds4VarA = ds4Var2.a(baseLayer.getName());
            if (ds4Var.c(this.f537a.getName(), i)) {
                list.add(ds4VarA.j(this.f537a));
            }
            if (ds4Var.i(getName(), i)) {
                this.f537a.resolveChildKeyPath(ds4Var, ds4Var.e(this.f537a.getName(), i) + i, list, ds4VarA);
            }
        }
        if (ds4Var.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                ds4Var2 = ds4Var2.a(getName());
                if (ds4Var.c(getName(), i)) {
                    list.add(ds4Var2.j(this));
                }
            }
            if (ds4Var.i(getName(), i)) {
                resolveChildKeyPath(ds4Var, i + ds4Var.e(getName(), i), list, ds4Var2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f538a.i();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        E();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        this.f536a.c(t, j45Var);
    }

    public void j(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.f547b.add(baseKeyframeAnimation);
    }

    public final void k(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        this.f531a.setAlpha((int) (baseKeyframeAnimation2.f().intValue() * 2.55f));
        canvas.drawPath(this.f532a, this.f531a);
    }

    public final void l(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        vj9.n(canvas, this.f533a, this.f544b);
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        this.f531a.setAlpha((int) (baseKeyframeAnimation2.f().intValue() * 2.55f));
        canvas.drawPath(this.f532a, this.f531a);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        vj9.n(canvas, this.f533a, this.f531a);
        canvas.drawRect(this.f533a, this.f531a);
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        this.f531a.setAlpha((int) (baseKeyframeAnimation2.f().intValue() * 2.55f));
        canvas.drawPath(this.f532a, this.f550c);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        vj9.n(canvas, this.f533a, this.f544b);
        canvas.drawRect(this.f533a, this.f531a);
        this.f550c.setAlpha((int) (baseKeyframeAnimation2.f().intValue() * 2.55f));
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        canvas.drawPath(this.f532a, this.f550c);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        vj9.n(canvas, this.f533a, this.f550c);
        canvas.drawRect(this.f533a, this.f531a);
        this.f550c.setAlpha((int) (baseKeyframeAnimation2.f().intValue() * 2.55f));
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        canvas.drawPath(this.f532a, this.f550c);
        canvas.restore();
    }

    public final void p(Canvas canvas, Matrix matrix) {
        vs4.a("Layer#saveLayer");
        vj9.o(canvas, this.f533a, this.f544b, 19);
        if (Build.VERSION.SDK_INT < 28) {
            t(canvas);
        }
        vs4.b("Layer#saveLayer");
        for (int i = 0; i < this.f539a.b().size(); i++) {
            Mask mask = this.f539a.b().get(i);
            BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation = this.f539a.a().get(i);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f539a.c().get(i);
            int i2 = a.b[mask.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f531a.setColor(-16777216);
                        this.f531a.setAlpha(255);
                        canvas.drawRect(this.f533a, this.f531a);
                    }
                    if (mask.d()) {
                        o(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        q(canvas, matrix, baseKeyframeAnimation);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.d()) {
                            m(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            k(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.d()) {
                    n(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    l(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (r()) {
                this.f531a.setAlpha(255);
                canvas.drawRect(this.f533a, this.f531a);
            }
        }
        vs4.a("Layer#restoreLayer");
        canvas.restore();
        vs4.b("Layer#restoreLayer");
    }

    public final void q(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<g88, Path> baseKeyframeAnimation) {
        this.f532a.set(baseKeyframeAnimation.f());
        this.f532a.transform(matrix);
        canvas.drawPath(this.f532a, this.f550c);
    }

    public final boolean r() {
        if (this.f539a.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f539a.b().size(); i++) {
            if (this.f539a.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public void resolveChildKeyPath(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
    }

    public final void s() {
        if (this.f541a != null) {
            return;
        }
        if (this.f546b == null) {
            this.f541a = Collections.emptyList();
            return;
        }
        this.f541a = new ArrayList();
        for (BaseLayer baseLayer = this.f546b; baseLayer != null; baseLayer = baseLayer.f546b) {
            this.f541a.add(baseLayer);
        }
    }

    public final void t(Canvas canvas) {
        vs4.a("Layer#clearLayer");
        RectF rectF = this.f533a;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.e);
        vs4.b("Layer#clearLayer");
    }

    public abstract void u(Canvas canvas, Matrix matrix, int i);

    @Nullable
    public sy0 w() {
        return this.f538a.a();
    }

    public BlurMaskFilter x(float f) {
        if (this.f528a == f) {
            return this.f529a;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f529a = blurMaskFilter;
        this.f528a = f;
        return blurMaskFilter;
    }

    @Nullable
    public hs2 y() {
        return this.f538a.c();
    }

    public Layer z() {
        return this.f538a;
    }
}
