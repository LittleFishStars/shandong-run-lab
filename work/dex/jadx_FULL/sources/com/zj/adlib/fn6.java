package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.internal.PaintDrawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class fn6 extends PaintDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Region f41713a = new Region();
    public static final Region b = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    public int K = 1;
    public int L = 1;
    public int M = 0;
    public int N = 0;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f16580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Path> f16581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16582a;
    public List<Integer> c;
    public List<Path> d;
    public List<String> e;

    public final void b(int i, int i2) {
        Bitmap bitmap = this.f16580a;
        if (bitmap != null && i == bitmap.getWidth() && i2 == this.f16580a.getHeight()) {
            return;
        }
        this.f16580a = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f16582a = true;
    }

    public void c(int i, int i2, int i3, int i4) {
        this.M = i;
        this.N = i2;
        this.K = i3;
        this.O = i3;
        this.L = i4;
        this.P = i4;
        Rect bounds = getBounds();
        int i5 = bounds.left;
        int i6 = bounds.top;
        super.setBounds(i5, i6, i3 + i5, i4 + i6);
    }

    public final void d(Canvas canvas) {
        canvas.translate(-this.M, -this.N);
        if (this.f16581a != null) {
            for (int i = 0; i < this.f16581a.size(); i++) {
                List<Integer> list = this.c;
                if (list != null && i < list.size()) {
                    ((PaintDrawable) this).f40422a.setColor(this.c.get(i).intValue());
                }
                canvas.drawPath(this.f16581a.get(i), ((PaintDrawable) this).f40422a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (((PaintDrawable) this).f40422a.getAlpha() != 255) {
            b(iWidth, iHeight);
            if (this.f16582a) {
                this.f16580a.eraseColor(0);
                d(new Canvas(this.f16580a));
                this.f16582a = false;
            }
            canvas.drawBitmap(this.f16580a, bounds.left, bounds.top, ((PaintDrawable) this).f40422a);
            return;
        }
        canvas.save();
        canvas.translate(bounds.left - this.M, bounds.top - this.N);
        if (this.f16581a != null) {
            for (int i = 0; i < this.f16581a.size(); i++) {
                List<Integer> list = this.c;
                if (list != null && i < list.size()) {
                    ((PaintDrawable) this).f40422a.setColor(this.c.get(i).intValue());
                }
                canvas.drawPath(this.f16581a.get(i), ((PaintDrawable) this).f40422a);
            }
            ((PaintDrawable) this).f40422a.setAlpha(255);
        }
        canvas.restore();
    }

    public void e(int... iArr) {
        this.c = new ArrayList();
        for (int i : iArr) {
            this.c.add(Integer.valueOf(i));
        }
    }

    public boolean f(String... strArr) {
        this.P = 0;
        this.O = 0;
        this.e = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.f16581a = arrayList;
        for (String str : strArr) {
            this.e.add(str);
            this.d.add(bn6.d(str));
        }
        return onMeasure();
    }

    public void g(int i) {
        Rect bounds = getBounds();
        float fHeight = (i * 1.0f) / bounds.height();
        setBounds((int) (bounds.left * fHeight), (int) (bounds.top * fHeight), (int) (bounds.right * fHeight), (int) (bounds.bottom * fHeight));
    }

    public void h(int i) {
        Rect bounds = getBounds();
        float fWidth = (i * 1.0f) / bounds.width();
        setBounds((int) (bounds.left * fWidth), (int) (bounds.top * fWidth), (int) (bounds.right * fWidth), (int) (bounds.bottom * fWidth));
    }

    public boolean onMeasure() {
        Integer num;
        Integer numValueOf;
        Integer numValueOf2;
        int i;
        List<Path> list = this.f16581a;
        Integer numValueOf3 = null;
        if (list != null) {
            Integer numValueOf4 = null;
            numValueOf = null;
            numValueOf2 = null;
            for (Path path : list) {
                Region region = f41713a;
                region.setPath(path, b);
                Rect bounds = region.getBounds();
                numValueOf3 = Integer.valueOf(Math.min(numValueOf3 == null ? bounds.top : numValueOf3.intValue(), bounds.top));
                numValueOf4 = Integer.valueOf(Math.min(numValueOf4 == null ? bounds.left : numValueOf4.intValue(), bounds.left));
                numValueOf = Integer.valueOf(Math.max(numValueOf == null ? bounds.right : numValueOf.intValue(), bounds.right));
                numValueOf2 = Integer.valueOf(Math.max(numValueOf2 == null ? bounds.bottom : numValueOf2.intValue(), bounds.bottom));
            }
            num = numValueOf3;
            numValueOf3 = numValueOf4;
        } else {
            num = null;
            numValueOf = null;
            numValueOf2 = null;
        }
        this.M = numValueOf3 == null ? 0 : numValueOf3.intValue();
        this.N = num == null ? 0 : num.intValue();
        this.K = numValueOf == null ? 0 : numValueOf.intValue() - this.M;
        int iIntValue = numValueOf2 == null ? 0 : numValueOf2.intValue() - this.N;
        this.L = iIntValue;
        if (this.O == 0) {
            this.O = this.K;
        }
        if (this.P == 0) {
            this.P = iIntValue;
        }
        Rect bounds2 = getBounds();
        int i2 = this.K;
        if (i2 != 0 && (i = this.L) != 0) {
            int i3 = bounds2.left;
            int i4 = bounds2.top;
            super.setBounds(i3, i4, i2 + i3, i + i4);
            return true;
        }
        if (this.O == 0) {
            this.O = 1;
        }
        if (this.P == 0) {
            this.P = 1;
        }
        this.L = 1;
        this.K = 1;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.d;
        if (list == null || list.size() <= 0 || (i5 == this.K && i6 == this.L)) {
            super.setBounds(i, i2, i3, i4);
            return;
        }
        int i7 = this.M;
        int i8 = this.N;
        float f = i5;
        float f2 = i6;
        this.f16581a = bn6.h((f * 1.0f) / this.O, (f2 * 1.0f) / this.P, this.d, this.e);
        if (onMeasure()) {
            return;
        }
        this.K = i5;
        this.L = i6;
        this.M = (int) (((i7 * 1.0f) * f) / this.O);
        this.N = (int) (((i8 * 1.0f) * f2) / this.P);
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
