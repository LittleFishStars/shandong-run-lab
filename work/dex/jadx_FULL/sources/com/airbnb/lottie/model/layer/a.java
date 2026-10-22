package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.b;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.k35;
import com.zj.adlib.m88;
import com.zj.adlib.ul9;
import com.zj.adlib.vj9;
import com.zj.adlib.vs4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f23379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Boolean f574a;

    @Nullable
    public Boolean b;
    public final List<BaseLayer> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f575c;
    public final RectF f;
    public final Paint g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final RectF f576g;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0116a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23380a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f23380a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23380a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, k35 k35Var) {
        int i;
        BaseLayer baseLayer;
        super(lottieDrawable, layer);
        this.c = new ArrayList();
        this.f = new RectF();
        this.f576g = new RectF();
        this.g = new Paint();
        this.f575c = true;
        b bVarU = layer.u();
        if (bVarU != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = bVarU.a();
            this.f23379a = baseKeyframeAnimationA;
            j(baseKeyframeAnimationA);
            this.f23379a.a(this);
        } else {
            this.f23379a = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(k35Var.k().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer baseLayerV = BaseLayer.v(this, layer2, lottieDrawable, k35Var);
            if (baseLayerV != null) {
                longSparseArray.put(baseLayerV.z().d(), baseLayerV);
                if (baseLayer2 != null) {
                    baseLayer2.I(baseLayerV);
                    baseLayer2 = null;
                } else {
                    this.c.add(0, baseLayerV);
                    int i2 = C0116a.f23380a[layer2.h().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        baseLayer2 = baseLayerV;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.z().j())) != null) {
                baseLayer3.K(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void J(boolean z) {
        super.J(z);
        Iterator<BaseLayer> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().J(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void L(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        super.L(f);
        if (this.f23379a != null) {
            f = ((this.f23379a.f().floatValue() * ((BaseLayer) this).f538a.b().i()) - ((BaseLayer) this).f538a.b().r()) / (((BaseLayer) this).f534a.N().e() + 0.01f);
        }
        if (this.f23379a == null) {
            f -= ((BaseLayer) this).f538a.r();
        }
        if (((BaseLayer) this).f538a.v() != 0.0f && !"__container".equals(((BaseLayer) this).f538a.i())) {
            f /= ((BaseLayer) this).f538a.v();
        }
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.c.get(size).L(f);
        }
    }

    public boolean O() {
        if (this.b == null) {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.c.get(size);
                if (baseLayer instanceof m88) {
                    if (baseLayer.A()) {
                        this.b = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof a) && ((a) baseLayer).O()) {
                    this.b = Boolean.TRUE;
                    return true;
                }
            }
            this.b = Boolean.FALSE;
        }
        return this.b.booleanValue();
    }

    public boolean P() {
        if (this.f574a == null) {
            if (B()) {
                this.f574a = Boolean.TRUE;
                return true;
            }
            for (int size = this.c.size() - 1; size >= 0; size--) {
                if (this.c.get(size).B()) {
                    this.f574a = Boolean.TRUE;
                    return true;
                }
            }
            this.f574a = Boolean.FALSE;
        }
        return this.f574a.booleanValue();
    }

    public void Q(boolean z) {
        this.f575c = z;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.c.get(size).a(this.f, ((BaseLayer) this).f549c, true);
            rectF.union(this.f);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.t) {
            if (j45Var == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f23379a;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.k(null);
                    return;
                }
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.f23379a = ul9Var;
            ul9Var.a(this);
            j(this.f23379a);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).g(ds4Var, i, list, ds4Var2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(Canvas canvas, Matrix matrix, int i) {
        vs4.a("CompositionLayer#draw");
        this.f576g.set(0.0f, 0.0f, ((BaseLayer) this).f538a.l(), ((BaseLayer) this).f538a.k());
        matrix.mapRect(this.f576g);
        boolean z = ((BaseLayer) this).f534a.k0() && this.c.size() > 1 && i != 255;
        if (z) {
            this.g.setAlpha(i);
            vj9.n(canvas, this.f576g, this.g);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (((!this.f575c && "__container".equals(((BaseLayer) this).f538a.i())) || this.f576g.isEmpty()) ? true : canvas.clipRect(this.f576g)) {
                this.c.get(size).b(canvas, matrix, i);
            }
        }
        canvas.restore();
        vs4.b("CompositionLayer#draw");
    }
}
