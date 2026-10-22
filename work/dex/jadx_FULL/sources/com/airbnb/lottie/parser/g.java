package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import com.zj.adlib.ap4;
import com.zj.adlib.k35;
import com.zj.adlib.ps4;
import com.zj.adlib.up5;
import com.zj.adlib.vj9;
import com.zj.adlib.y6b;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f23388a = 100.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Interpolator f582a = new LinearInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static JsonReader.a f584a = JsonReader.a.a("t", "s", "e", com.google.android.exoplayer2.source.rtsp.j.b, "i", y6b.g, "to", RVParams.TITLE_IMAGE);
    public static JsonReader.a b = JsonReader.a.a("x", "y");

    @Nullable
    public static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (g.class) {
            weakReference = g().get(i);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = up5.c(pointF.x, -1.0f, 1.0f);
        pointF.y = up5.c(pointF.y, -100.0f, 100.0f);
        pointF2.x = up5.c(pointF2.x, -1.0f, 1.0f);
        float fC = up5.c(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fC;
        int i = vj9.i(pointF.x, pointF.y, pointF2.x, fC);
        WeakReference<Interpolator> weakReferenceA = a(i);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                interpolatorCreate = "The Path cannot loop back on itself.".equals(e.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorCreate;
            try {
                h(i, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> ps4<T> c(JsonReader jsonReader, k35 k35Var, float f, ValueParser<T> valueParser, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return e(k35Var, jsonReader, f, valueParser);
        }
        return z ? d(k35Var, jsonReader, f, valueParser) : f(jsonReader, f, valueParser);
    }

    public static <T> ps4<T> d(k35 k35Var, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolatorB;
        T t;
        jsonReader.h();
        PointF pointFE = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        float fQ = 0.0f;
        boolean z = false;
        PointF pointFE4 = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f584a)) {
                case 0:
                    fQ = (float) jsonReader.q();
                    break;
                case 1:
                    tA2 = valueParser.a(jsonReader, f);
                    break;
                case 2:
                    tA = valueParser.a(jsonReader, f);
                    break;
                case 3:
                    pointFE = ap4.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFE4 = ap4.e(jsonReader, 1.0f);
                    break;
                case 5:
                    z = jsonReader.r() == 1;
                    break;
                case 6:
                    pointFE2 = ap4.e(jsonReader, f);
                    break;
                case 7:
                    pointFE3 = ap4.e(jsonReader, f);
                    break;
                default:
                    jsonReader.J();
                    break;
            }
        }
        jsonReader.k();
        if (z) {
            interpolatorB = f582a;
            t = tA2;
        } else {
            interpolatorB = (pointFE == null || pointFE4 == null) ? f582a : b(pointFE, pointFE4);
            t = tA;
        }
        ps4<T> ps4Var = new ps4<>(k35Var, tA2, t, interpolatorB, fQ, null);
        ps4Var.f18924a = pointFE2;
        ps4Var.f18930b = pointFE3;
        return ps4Var;
    }

    /* JADX WARN: Code duplicated, block: B:93:0x01ed  */
    public static <T> ps4<T> e(k35 k35Var, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolatorB;
        Interpolator interpolatorB2;
        Interpolator interpolatorB3;
        T t;
        ps4<T> ps4Var;
        PointF pointF;
        float f2;
        PointF pointF2;
        jsonReader.h();
        PointF pointFE = null;
        boolean z = false;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        PointF pointF3 = null;
        T tA = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fQ = 0.0f;
        PointF pointFE4 = null;
        T tA2 = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f584a)) {
                case 0:
                    pointF = pointFE;
                    fQ = (float) jsonReader.q();
                    pointFE = pointF;
                    break;
                case 1:
                    pointF = pointFE;
                    tA = valueParser.a(jsonReader, f);
                    pointFE = pointF;
                    break;
                case 2:
                    pointF = pointFE;
                    tA2 = valueParser.a(jsonReader, f);
                    pointFE = pointF;
                    break;
                case 3:
                    pointF = pointFE;
                    f2 = fQ;
                    PointF pointF7 = pointFE4;
                    if (jsonReader.y() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.h();
                        float fQ2 = 0.0f;
                        float fQ3 = 0.0f;
                        float fQ4 = 0.0f;
                        float fQ5 = 0.0f;
                        while (jsonReader.l()) {
                            int iF = jsonReader.F(b);
                            if (iF == 0) {
                                JsonReader.Token tokenY = jsonReader.y();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (tokenY == token) {
                                    fQ4 = (float) jsonReader.q();
                                    fQ2 = fQ4;
                                } else {
                                    jsonReader.g();
                                    fQ2 = (float) jsonReader.q();
                                    fQ4 = jsonReader.y() == token ? (float) jsonReader.q() : fQ2;
                                    jsonReader.j();
                                }
                            } else if (iF != 1) {
                                jsonReader.J();
                            } else {
                                JsonReader.Token tokenY2 = jsonReader.y();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (tokenY2 == token2) {
                                    fQ5 = (float) jsonReader.q();
                                    fQ3 = fQ5;
                                } else {
                                    jsonReader.g();
                                    fQ3 = (float) jsonReader.q();
                                    fQ5 = jsonReader.y() == token2 ? (float) jsonReader.q() : fQ3;
                                    jsonReader.j();
                                }
                            }
                        }
                        PointF pointF8 = new PointF(fQ2, fQ3);
                        PointF pointF9 = new PointF(fQ4, fQ5);
                        jsonReader.k();
                        pointF4 = pointF9;
                        pointF3 = pointF8;
                        pointFE4 = pointF7;
                        fQ = f2;
                    } else {
                        pointFE2 = ap4.e(jsonReader, f);
                        fQ = f2;
                        pointFE4 = pointF7;
                    }
                    pointFE = pointF;
                    break;
                case 4:
                    if (jsonReader.y() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.h();
                        float fQ6 = 0.0f;
                        float f3 = 0.0f;
                        float fQ7 = 0.0f;
                        float fQ8 = 0.0f;
                        while (jsonReader.l()) {
                            pointFE4 = pointFE4;
                            int iF2 = jsonReader.F(b);
                            if (iF2 != 0) {
                                pointF2 = pointFE;
                                if (iF2 != 1) {
                                    jsonReader.J();
                                } else {
                                    JsonReader.Token tokenY3 = jsonReader.y();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (tokenY3 == token3) {
                                        fQ8 = (float) jsonReader.q();
                                        fQ = fQ;
                                        f3 = fQ8;
                                    } else {
                                        float f4 = fQ;
                                        jsonReader.g();
                                        float fQ9 = (float) jsonReader.q();
                                        float fQ10 = jsonReader.y() == token3 ? (float) jsonReader.q() : fQ9;
                                        jsonReader.j();
                                        fQ = f4;
                                        pointFE = pointF2;
                                        fQ8 = fQ10;
                                        f3 = fQ9;
                                    }
                                }
                            } else {
                                pointF2 = pointFE;
                                float f5 = fQ;
                                JsonReader.Token tokenY4 = jsonReader.y();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (tokenY4 == token4) {
                                    fQ7 = (float) jsonReader.q();
                                    fQ = f5;
                                    fQ6 = fQ7;
                                } else {
                                    jsonReader.g();
                                    fQ6 = (float) jsonReader.q();
                                    fQ7 = jsonReader.y() == token4 ? (float) jsonReader.q() : fQ6;
                                    jsonReader.j();
                                    fQ = f5;
                                }
                            }
                            pointFE = pointF2;
                        }
                        pointF = pointFE;
                        f2 = fQ;
                        PointF pointF10 = new PointF(fQ6, f3);
                        PointF pointF11 = new PointF(fQ7, fQ8);
                        jsonReader.k();
                        pointF6 = pointF11;
                        pointF5 = pointF10;
                        fQ = f2;
                    } else {
                        pointF = pointFE;
                        pointFE3 = ap4.e(jsonReader, f);
                    }
                    pointFE = pointF;
                    break;
                case 5:
                    z = jsonReader.r() == 1;
                    break;
                case 6:
                    pointFE4 = ap4.e(jsonReader, f);
                    break;
                case 7:
                    pointFE = ap4.e(jsonReader, f);
                    break;
                default:
                    pointF = pointFE;
                    jsonReader.J();
                    pointFE = pointF;
                    break;
            }
        }
        PointF pointF12 = pointFE;
        float f6 = fQ;
        PointF pointF13 = pointFE4;
        jsonReader.k();
        if (z) {
            interpolatorB = f582a;
            t = tA;
        } else {
            if (pointFE2 == null || pointFE3 == null) {
                if (pointF3 == null || pointF4 == null || pointF5 == null || pointF6 == null) {
                    interpolatorB = f582a;
                } else {
                    interpolatorB2 = b(pointF3, pointF5);
                    interpolatorB3 = b(pointF4, pointF6);
                    t = tA2;
                    interpolatorB = null;
                }
                if (interpolatorB2 != null || interpolatorB3 == null) {
                    ps4Var = new ps4<>(k35Var, tA, t, interpolatorB, f6, null);
                } else {
                    ps4Var = new ps4<>(k35Var, tA, t, interpolatorB2, interpolatorB3, f6, null);
                }
                ps4Var.f18924a = pointF13;
                ps4Var.f18930b = pointF12;
                return ps4Var;
            }
            interpolatorB = b(pointFE2, pointFE3);
            t = tA2;
        }
        interpolatorB2 = null;
        interpolatorB3 = null;
        if (interpolatorB2 != null) {
            ps4Var = new ps4<>(k35Var, tA, t, interpolatorB, f6, null);
        } else {
            ps4Var = new ps4<>(k35Var, tA, t, interpolatorB, f6, null);
        }
        ps4Var.f18924a = pointF13;
        ps4Var.f18930b = pointF12;
        return ps4Var;
    }

    public static <T> ps4<T> f(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new ps4<>(valueParser.a(jsonReader, f));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (f583a == null) {
            f583a = new SparseArrayCompat<>();
        }
        return f583a;
    }

    public static void h(int i, WeakReference<Interpolator> weakReference) {
        synchronized (g.class) {
            f583a.put(i, weakReference);
        }
    }
}
