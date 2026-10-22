package com.zj.adlib;

import android.R;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gt3 {
    public static final int b = 300;
    public static final ScalingUtils.ScaleType f = ScalingUtils.ScaleType.f;
    public static final ScalingUtils.ScaleType g = ScalingUtils.ScaleType.g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f16860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f16861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Matrix f16862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PointF f16863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f16864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ScalingUtils.ScaleType f16865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RoundingParams f16866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Drawable> f16867a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f16868b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ScalingUtils.ScaleType f16869b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<Drawable> f16870b;
    public Drawable c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ScalingUtils.ScaleType f16871c;
    public Drawable d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ScalingUtils.ScaleType f16872d;
    public Drawable e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public ScalingUtils.ScaleType f16873e;

    public gt3(Resources resources) {
        this.f16860a = resources;
        t();
    }

    public static gt3 u(Resources resources) {
        return new gt3(resources);
    }

    public gt3 A(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f16867a = null;
        } else {
            this.f16867a = Arrays.asList(drawable);
        }
        return this;
    }

    public gt3 B(@Nullable List<Drawable> list) {
        this.f16867a = list;
        return this;
    }

    public gt3 C(float f2) {
        this.f41982a = f2;
        return this;
    }

    public gt3 D(int i) {
        this.f16859a = i;
        return this;
    }

    public gt3 E(@Nullable Drawable drawable) {
        this.c = drawable;
        return this;
    }

    public gt3 F(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.c = drawable;
        this.f16871c = scaleType;
        return this;
    }

    public gt3 G(@Nullable ScalingUtils.ScaleType scaleType) {
        this.f16871c = scaleType;
        return this;
    }

    public gt3 H(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.f16870b = null;
        } else {
            this.f16870b = Arrays.asList(drawable);
        }
        return this;
    }

    public gt3 I(@Nullable List<Drawable> list) {
        this.f16870b = list;
        return this;
    }

    public gt3 J(@Nullable Drawable drawable) {
        this.f16864a = drawable;
        return this;
    }

    public gt3 K(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.f16864a = drawable;
        this.f16865a = scaleType;
        return this;
    }

    public gt3 L(@Nullable ScalingUtils.ScaleType scaleType) {
        this.f16865a = scaleType;
        return this;
    }

    public gt3 M(@Nullable Drawable drawable) {
        if (drawable == null) {
            this.e = null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
            this.e = stateListDrawable;
        }
        return this;
    }

    public gt3 N(@Nullable Drawable drawable) {
        this.d = drawable;
        return this;
    }

    public gt3 O(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.d = drawable;
        this.f16872d = scaleType;
        return this;
    }

    public gt3 P(@Nullable ScalingUtils.ScaleType scaleType) {
        this.f16872d = scaleType;
        return this;
    }

    public gt3 Q(@Nullable Drawable drawable) {
        this.f16868b = drawable;
        return this;
    }

    public gt3 R(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        this.f16868b = drawable;
        this.f16869b = scaleType;
        return this;
    }

    public gt3 S(@Nullable ScalingUtils.ScaleType scaleType) {
        this.f16869b = scaleType;
        return this;
    }

    public gt3 T(@Nullable RoundingParams roundingParams) {
        this.f16866a = roundingParams;
        return this;
    }

    public final void U() {
        List<Drawable> list = this.f16870b;
        if (list != null) {
            Iterator<Drawable> it = list.iterator();
            while (it.hasNext()) {
                ax6.i(it.next());
            }
        }
        List<Drawable> list2 = this.f16867a;
        if (list2 != null) {
            Iterator<Drawable> it2 = list2.iterator();
            while (it2.hasNext()) {
                ax6.i(it2.next());
            }
        }
    }

    public ft3 a() {
        U();
        return new ft3(this);
    }

    @Nullable
    public ColorFilter b() {
        return this.f16861a;
    }

    @Nullable
    public PointF c() {
        return this.f16863a;
    }

    @Nullable
    public Matrix d() {
        return this.f16862a;
    }

    @Nullable
    public ScalingUtils.ScaleType e() {
        return this.f16873e;
    }

    @Nullable
    public List<Drawable> f() {
        return this.f16867a;
    }

    public float g() {
        return this.f41982a;
    }

    public Resources getResources() {
        return this.f16860a;
    }

    public int h() {
        return this.f16859a;
    }

    @Nullable
    public Drawable i() {
        return this.c;
    }

    @Nullable
    public ScalingUtils.ScaleType j() {
        return this.f16871c;
    }

    @Nullable
    public List<Drawable> k() {
        return this.f16870b;
    }

    @Nullable
    public Drawable l() {
        return this.f16864a;
    }

    @Nullable
    public ScalingUtils.ScaleType m() {
        return this.f16865a;
    }

    @Nullable
    public Drawable n() {
        return this.e;
    }

    @Nullable
    public Drawable o() {
        return this.d;
    }

    @Nullable
    public ScalingUtils.ScaleType p() {
        return this.f16872d;
    }

    @Nullable
    public Drawable q() {
        return this.f16868b;
    }

    @Nullable
    public ScalingUtils.ScaleType r() {
        return this.f16869b;
    }

    @Nullable
    public RoundingParams s() {
        return this.f16866a;
    }

    public final void t() {
        this.f16859a = 300;
        this.f41982a = 0.0f;
        this.f16864a = null;
        ScalingUtils.ScaleType scaleType = f;
        this.f16865a = scaleType;
        this.f16868b = null;
        this.f16869b = scaleType;
        this.c = null;
        this.f16871c = scaleType;
        this.d = null;
        this.f16872d = scaleType;
        this.f16873e = g;
        this.f16862a = null;
        this.f16863a = null;
        this.f16861a = null;
        this.f16867a = null;
        this.f16870b = null;
        this.e = null;
        this.f16866a = null;
    }

    public gt3 v() {
        t();
        return this;
    }

    public gt3 w(@Nullable ColorFilter colorFilter) {
        this.f16861a = colorFilter;
        return this;
    }

    public gt3 x(@Nullable PointF pointF) {
        this.f16863a = pointF;
        return this;
    }

    @Deprecated
    public gt3 y(@Nullable Matrix matrix) {
        this.f16862a = matrix;
        this.f16873e = null;
        return this;
    }

    public gt3 z(@Nullable ScalingUtils.ScaleType scaleType) {
        this.f16873e = scaleType;
        this.f16862a = null;
        return this;
    }
}
