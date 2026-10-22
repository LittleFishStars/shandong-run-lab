package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ScalingUtils {

    public static abstract class AbstractScaleType implements ScaleType {
        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            b(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
            return matrix;
        }

        public abstract void b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);
    }

    public interface ScaleType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScaleType f29972a = h.i;
        public static final ScaleType b = g.i;
        public static final ScaleType c = e.i;
        public static final ScaleType d = f.i;
        public static final ScaleType e = b.i;
        public static final ScaleType f = d.i;
        public static final ScaleType g = c.i;
        public static final ScaleType h = i.i;

        Matrix a(Matrix matrix, Rect rect, int i, int i2, float f2, float f3);
    }

    public interface StatefulScaleType {
        Object getState();
    }

    public static class a implements ScaleType, StatefulScaleType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f29973a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float[] f1618a = new float[9];
        public final float[] b = new float[9];
        public final float[] c = new float[9];
        public final ScaleType i;
        public final ScaleType j;

        public a(ScaleType scaleType, ScaleType scaleType2) {
            this.i = scaleType;
            this.j = scaleType2;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            this.i.a(matrix, rect, i, i2, f, f2);
            matrix.getValues(this.f1618a);
            this.j.a(matrix, rect, i, i2, f, f2);
            matrix.getValues(this.b);
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.c;
                float f3 = this.f1618a[i3];
                float f4 = this.f29973a;
                fArr[i3] = (f3 * (1.0f - f4)) + (this.b[i3] * f4);
            }
            matrix.setValues(this.c);
            return matrix;
        }

        public ScaleType b() {
            return this.i;
        }

        public ScaleType c() {
            return this.j;
        }

        public float d() {
            return this.f29973a;
        }

        public void e(float f) {
            this.f29973a = f;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            return Float.valueOf(this.f29973a);
        }
    }

    public static class b extends AbstractScaleType {
        public static final ScaleType i = new b();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i2) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i3) * 0.5f) + 0.5f));
        }
    }

    public static class c extends AbstractScaleType {
        public static final ScaleType i = new c();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fHeight;
            float fWidth;
            if (f4 > f3) {
                fWidth = rect.left + ((rect.width() - (i2 * f4)) * 0.5f);
                fHeight = rect.top;
                f3 = f4;
            } else {
                float f5 = rect.left;
                fHeight = ((rect.height() - (i3 * f3)) * 0.5f) + rect.top;
                fWidth = f5;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }
    }

    public static class d extends AbstractScaleType {
        public static final ScaleType i = new d();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fMin = Math.min(Math.min(f3, f4), 1.0f);
            float fWidth = rect.left + ((rect.width() - (i2 * fMin)) * 0.5f);
            float fHeight = rect.top + ((rect.height() - (i3 * fMin)) * 0.5f);
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }
    }

    public static class e extends AbstractScaleType {
        public static final ScaleType i = new e();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fMin = Math.min(f3, f4);
            float fWidth = rect.left + ((rect.width() - (i2 * fMin)) * 0.5f);
            float fHeight = rect.top + ((rect.height() - (i3 * fMin)) * 0.5f);
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }
    }

    public static class f extends AbstractScaleType {
        public static final ScaleType i = new f();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fMin = Math.min(f3, f4);
            float fWidth = rect.left + (rect.width() - (i2 * fMin));
            float fHeight = rect.top + (rect.height() - (i3 * fMin));
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }
    }

    public static class g extends AbstractScaleType {
        public static final ScaleType i = new g();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fMin = Math.min(f3, f4);
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }
    }

    public static class h extends AbstractScaleType {
        public static final ScaleType i = new h();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(f3, f4);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }
    }

    public static class i extends AbstractScaleType {
        public static final ScaleType i = new i();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f, float f2, float f3, float f4) {
            float fMax;
            float fMax2;
            if (f4 > f3) {
                float f5 = i2 * f4;
                fMax = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f * f5), 0.0f), rect.width() - f5);
                fMax2 = rect.top;
                f3 = f4;
            } else {
                fMax = rect.left;
                float f6 = i3 * f3;
                fMax2 = Math.max(Math.min((rect.height() * 0.5f) - (f2 * f6), 0.0f), rect.height() - f6) + rect.top;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (fMax + 0.5f), (int) (fMax2 + 0.5f));
        }
    }

    @Deprecated
    public static Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, ScaleType scaleType) {
        return scaleType.a(matrix, rect, i2, i3, f2, f3);
    }
}
