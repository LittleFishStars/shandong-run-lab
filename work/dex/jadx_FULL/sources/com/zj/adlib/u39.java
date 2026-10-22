package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.j;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u39 extends BaseLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<String> f45056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f19949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j f19950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k35 f19951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f19952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<nk3, List<com.airbnb.lottie.animation.content.a>> f19953a;
    public final LottieDrawable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f19954b;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> c;
    public final Matrix d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f19955d;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> e;
    public final RectF f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f19956f;
    public final Paint g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f19957g;
    public final Paint h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f19958h;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> i;

    @Nullable
    public BaseKeyframeAnimation<Typeface, Typeface> j;

    public class a extends Paint {
        public a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    public class b extends Paint {
        public b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45059a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f45059a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45059a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45059a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public u39(LottieDrawable lottieDrawable, Layer layer) {
        com.airbnb.lottie.model.animatable.b bVar;
        com.airbnb.lottie.model.animatable.b bVar2;
        com.airbnb.lottie.model.animatable.a aVar;
        com.airbnb.lottie.model.animatable.a aVar2;
        super(lottieDrawable, layer);
        this.f19952a = new StringBuilder(2);
        this.f = new RectF();
        this.d = new Matrix();
        this.g = new a(1);
        this.h = new b(1);
        this.f19953a = new HashMap();
        this.f45056a = new LongSparseArray<>();
        this.b = lottieDrawable;
        this.f19951a = layer.b();
        j jVarA = layer.s().a();
        this.f19950a = jVarA;
        jVarA.a(this);
        j(jVarA);
        k60 k60VarT = layer.t();
        if (k60VarT != null && (aVar2 = k60VarT.f42747a) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = aVar2.a();
            this.f19949a = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            j(this.f19949a);
        }
        if (k60VarT != null && (aVar = k60VarT.b) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = aVar.a();
            this.c = baseKeyframeAnimationA2;
            baseKeyframeAnimationA2.a(this);
            j(this.c);
        }
        if (k60VarT != null && (bVar2 = k60VarT.f17590a) != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = bVar2.a();
            this.e = baseKeyframeAnimationA3;
            baseKeyframeAnimationA3.a(this);
            j(this.e);
        }
        if (k60VarT == null || (bVar = k60VarT.f17591b) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA4 = bVar.a();
        this.f19957g = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        j(this.f19957g);
    }

    public final void O(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = c.f45059a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else {
            if (i != 3) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final String P(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!c0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.f45056a.containsKey(j)) {
            return this.f45056a.get(j);
        }
        this.f19952a.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.f19952a.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.f19952a.toString();
        this.f45056a.put(j, string);
        return string;
    }

    public final void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void R(nk3 nk3Var, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<com.airbnb.lottie.animation.content.a> listY = Y(nk3Var);
        for (int i = 0; i < listY.size(); i++) {
            Path pathF = listY.get(i).f();
            pathF.computeBounds(this.f, false);
            this.d.set(matrix);
            this.d.preTranslate(0.0f, (-documentData.c) * vj9.e());
            this.d.preScale(f, f);
            pathF.transform(this.d);
            if (documentData.f492a) {
                U(pathF, this.g, canvas);
                U(pathF, this.h, canvas);
            } else {
                U(pathF, this.h, canvas);
                U(pathF, this.g, canvas);
            }
        }
    }

    public final void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f492a) {
            Q(str, this.g, canvas);
            Q(str, this.h, canvas);
        } else {
            Q(str, this.h, canvas);
            Q(str, this.g, canvas);
        }
    }

    public final void T(String str, DocumentData documentData, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strP = P(str, length);
            length += strP.length();
            S(strP, documentData, canvas);
            canvas.translate(this.g.measureText(strP) + f, 0.0f);
        }
    }

    public final void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void V(String str, DocumentData documentData, Matrix matrix, kk3 kk3Var, Canvas canvas, float f, float f2) {
        float fFloatValue;
        for (int i = 0; i < str.length(); i++) {
            nk3 nk3Var = this.f19951a.c().get(nk3.c(str.charAt(i), kk3Var.b(), kk3Var.d()));
            if (nk3Var != null) {
                R(nk3Var, matrix, f2, documentData, canvas);
                float fB = ((float) nk3Var.b()) * f2 * vj9.e() * f;
                float f3 = documentData.f489a / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f19958h;
                if (baseKeyframeAnimation != null) {
                    fFloatValue = baseKeyframeAnimation.f().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f19957g;
                    if (baseKeyframeAnimation2 != null) {
                        fFloatValue = baseKeyframeAnimation2.f().floatValue();
                    }
                    canvas.translate(fB + (f3 * f), 0.0f);
                }
                f3 += fFloatValue;
                canvas.translate(fB + (f3 * f), 0.0f);
            }
        }
    }

    public final void W(DocumentData documentData, Matrix matrix, kk3 kk3Var, Canvas canvas) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.i;
        float fFloatValue = (baseKeyframeAnimation != null ? baseKeyframeAnimation.f().floatValue() : documentData.f23367a) / 100.0f;
        float fG = vj9.g(matrix);
        String str = documentData.f491a;
        float fE = documentData.b * vj9.e();
        List<String> listA0 = a0(str);
        int size = listA0.size();
        for (int i = 0; i < size; i++) {
            String str2 = listA0.get(i);
            float fZ = Z(str2, kk3Var, fFloatValue, fG);
            canvas.save();
            O(documentData.f490a, canvas, fZ);
            canvas.translate(0.0f, (i * fE) - (((size - 1) * fE) / 2.0f));
            V(str2, documentData, matrix, kk3Var, canvas, fG, fFloatValue);
            canvas.restore();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008f A[LOOP:0: B:20:0x008d->B:21:0x008f, LOOP_END] */
    public final void X(DocumentData documentData, kk3 kk3Var, Canvas canvas) {
        float fFloatValue;
        float fE;
        List<String> listA0;
        int size;
        int i;
        Typeface typefaceB0 = b0(kk3Var);
        if (typefaceB0 == null) {
            return;
        }
        String strC = documentData.f491a;
        n39 n39VarD0 = this.b.d0();
        if (n39VarD0 != null) {
            strC = n39VarD0.c(getName(), strC);
        }
        this.g.setTypeface(typefaceB0);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.i;
        float fFloatValue2 = baseKeyframeAnimation != null ? baseKeyframeAnimation.f().floatValue() : documentData.f23367a;
        this.g.setTextSize(vj9.e() * fFloatValue2);
        this.h.setTypeface(this.g.getTypeface());
        this.h.setTextSize(this.g.getTextSize());
        float fE2 = documentData.b * vj9.e();
        float f = documentData.f489a / 10.0f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f19958h;
        if (baseKeyframeAnimation2 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f19957g;
            if (baseKeyframeAnimation3 != null) {
                fFloatValue = baseKeyframeAnimation3.f().floatValue();
            }
            fE = ((f * vj9.e()) * fFloatValue2) / 100.0f;
            listA0 = a0(strC);
            size = listA0.size();
            for (i = 0; i < size; i++) {
                String str = listA0.get(i);
                float fMeasureText = this.h.measureText(str) + ((str.length() - 1) * fE);
                canvas.save();
                O(documentData.f490a, canvas, fMeasureText);
                canvas.translate(0.0f, (i * fE2) - (((size - 1) * fE2) / 2.0f));
                T(str, documentData, canvas, fE);
                canvas.restore();
            }
        }
        fFloatValue = baseKeyframeAnimation2.f().floatValue();
        f += fFloatValue;
        fE = ((f * vj9.e()) * fFloatValue2) / 100.0f;
        listA0 = a0(strC);
        size = listA0.size();
        while (i < size) {
            String str2 = listA0.get(i);
            float fMeasureText2 = this.h.measureText(str2) + ((str2.length() - 1) * fE);
            canvas.save();
            O(documentData.f490a, canvas, fMeasureText2);
            canvas.translate(0.0f, (i * fE2) - (((size - 1) * fE2) / 2.0f));
            T(str2, documentData, canvas, fE);
            canvas.restore();
        }
    }

    public final List<com.airbnb.lottie.animation.content.a> Y(nk3 nk3Var) {
        if (this.f19953a.containsKey(nk3Var)) {
            return this.f19953a.get(nk3Var);
        }
        List<j88> listA = nk3Var.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.animation.content.a(this.b, this, listA.get(i)));
        }
        this.f19953a.put(nk3Var, arrayList);
        return arrayList;
    }

    public final float Z(String str, kk3 kk3Var, float f, float f2) {
        float fB = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            nk3 nk3Var = this.f19951a.c().get(nk3.c(str.charAt(i), kk3Var.b(), kk3Var.d()));
            if (nk3Var != null) {
                fB = (float) (((double) fB) + (nk3Var.b() * ((double) f) * ((double) vj9.e()) * ((double) f2)));
            }
        }
        return fB;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.f19951a.b().width(), this.f19951a.b().height());
    }

    public final List<String> a0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", b85.b).replaceAll("\n", b85.b).split(b85.b));
    }

    @Nullable
    public final Typeface b0(kk3 kk3Var) {
        Typeface typefaceF;
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null && (typefaceF = baseKeyframeAnimation.f()) != null) {
            return typefaceF;
        }
        Typeface typefaceE0 = this.b.e0(kk3Var.b(), kk3Var.d());
        return typefaceE0 != null ? typefaceE0 : kk3Var.e();
    }

    public final boolean c0(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        super.i(t, j45Var);
        if (t == LottieProperty.f349a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f19954b;
            if (baseKeyframeAnimation != null) {
                H(baseKeyframeAnimation);
            }
            if (j45Var == null) {
                this.f19954b = null;
                return;
            }
            ul9 ul9Var = new ul9(j45Var);
            this.f19954b = ul9Var;
            ul9Var.a(this);
            j(this.f19954b);
            return;
        }
        if (t == LottieProperty.f352b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f19955d;
            if (baseKeyframeAnimation2 != null) {
                H(baseKeyframeAnimation2);
            }
            if (j45Var == null) {
                this.f19955d = null;
                return;
            }
            ul9 ul9Var2 = new ul9(j45Var);
            this.f19955d = ul9Var2;
            ul9Var2.a(this);
            j(this.f19955d);
            return;
        }
        if (t == LottieProperty.h) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f19956f;
            if (baseKeyframeAnimation3 != null) {
                H(baseKeyframeAnimation3);
            }
            if (j45Var == null) {
                this.f19956f = null;
                return;
            }
            ul9 ul9Var3 = new ul9(j45Var);
            this.f19956f = ul9Var3;
            ul9Var3.a(this);
            j(this.f19956f);
            return;
        }
        if (t == LottieProperty.i) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.f19958h;
            if (baseKeyframeAnimation4 != null) {
                H(baseKeyframeAnimation4);
            }
            if (j45Var == null) {
                this.f19958h = null;
                return;
            }
            ul9 ul9Var4 = new ul9(j45Var);
            this.f19958h = ul9Var4;
            ul9Var4.a(this);
            j(this.f19958h);
            return;
        }
        if (t == LottieProperty.u) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.i;
            if (baseKeyframeAnimation5 != null) {
                H(baseKeyframeAnimation5);
            }
            if (j45Var == null) {
                this.i = null;
                return;
            }
            ul9 ul9Var5 = new ul9(j45Var);
            this.i = ul9Var5;
            ul9Var5.a(this);
            j(this.i);
            return;
        }
        if (t != LottieProperty.f345a) {
            if (t == LottieProperty.f347a) {
                this.f19950a.n(j45Var);
                return;
            }
            return;
        }
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation6 = this.j;
        if (baseKeyframeAnimation6 != null) {
            H(baseKeyframeAnimation6);
        }
        if (j45Var == null) {
            this.j = null;
            return;
        }
        ul9 ul9Var6 = new ul9(j45Var);
        this.j = ul9Var6;
        ul9Var6.a(this);
        j(this.j);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.b.t1()) {
            canvas.concat(matrix);
        }
        DocumentData documentDataF = this.f19950a.f();
        kk3 kk3Var = this.f19951a.g().get(documentDataF.f494b);
        if (kk3Var == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f19954b;
        if (baseKeyframeAnimation != null) {
            this.g.setColor(baseKeyframeAnimation.f().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f19949a;
            if (baseKeyframeAnimation2 != null) {
                this.g.setColor(baseKeyframeAnimation2.f().intValue());
            } else {
                this.g.setColor(documentDataF.f493b);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.f19955d;
        if (baseKeyframeAnimation3 != null) {
            this.h.setColor(baseKeyframeAnimation3.f().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.c;
            if (baseKeyframeAnimation4 != null) {
                this.h.setColor(baseKeyframeAnimation4.f().intValue());
            } else {
                this.h.setColor(documentDataF.f495c);
            }
        }
        int iIntValue = ((((BaseLayer) this).f536a.h() == null ? 100 : ((BaseLayer) this).f536a.h().f().intValue()) * 255) / 100;
        this.g.setAlpha(iIntValue);
        this.h.setAlpha(iIntValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.f19956f;
        if (baseKeyframeAnimation5 != null) {
            this.h.setStrokeWidth(baseKeyframeAnimation5.f().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.e;
            if (baseKeyframeAnimation6 != null) {
                this.h.setStrokeWidth(baseKeyframeAnimation6.f().floatValue());
            } else {
                this.h.setStrokeWidth(documentDataF.d * vj9.e() * vj9.g(matrix));
            }
        }
        if (this.b.t1()) {
            W(documentDataF, matrix, kk3Var, canvas);
        } else {
            X(documentDataF, kk3Var, canvas);
        }
        canvas.restore();
    }
}
