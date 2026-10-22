package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.zj.adlib.ax6;
import com.zj.adlib.cl3;
import com.zj.adlib.hx4;
import com.zj.adlib.oj7;
import com.zj.adlib.pj7;
import com.zj.adlib.te5;
import com.zj.adlib.tj7;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Drawable f29976a = new ColorDrawable(0);

    public static Drawable a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            oj7 oj7Var = new oj7(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            b(oj7Var, roundingParams);
            return oj7Var;
        }
        if (drawable instanceof hx4) {
            hx4 hx4Var = (hx4) drawable;
            tj7 tj7Var = new tj7(resources, hx4Var.i(), hx4Var.j());
            b(tj7Var, roundingParams);
            return tj7Var;
        }
        if (!(drawable instanceof ColorDrawable)) {
            return drawable;
        }
        pj7 pj7VarA = pj7.a((ColorDrawable) drawable);
        b(pj7VarA, roundingParams);
        return pj7VarA;
    }

    public static void b(Rounded rounded, RoundingParams roundingParams) {
        rounded.k(roundingParams.k());
        rounded.d(roundingParams.g());
        rounded.g(roundingParams.e(), roundingParams.f());
        rounded.n(roundingParams.j());
    }

    public static DrawableParent c(DrawableParent drawableParent) {
        while (true) {
            Object objI = drawableParent.i();
            if (objI == drawableParent || !(objI instanceof DrawableParent)) {
                break;
            }
            drawableParent = (DrawableParent) objI;
        }
        return drawableParent;
    }

    public static Drawable d(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        if (drawable == null || roundingParams == null || roundingParams.l() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
            return drawable;
        }
        if (!(drawable instanceof cl3)) {
            return a(drawable, roundingParams, resources);
        }
        DrawableParent drawableParentC = c((cl3) drawable);
        drawableParentC.h(a(drawableParentC.h(f29976a), roundingParams, resources));
        return drawable;
    }

    @Nullable
    public static Drawable e(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new te5(drawable, matrix);
    }

    public static Drawable f(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        if (drawable == null || roundingParams == null || roundingParams.l() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            return drawable;
        }
        RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
        b(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.s(roundingParams.i());
        return roundedCornersDrawable;
    }

    @Nullable
    public static Drawable g(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return h(drawable, scaleType, null);
    }

    @Nullable
    public static Drawable h(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        if (drawable == null || scaleType == null) {
            return drawable;
        }
        com.facebook.drawee.drawable.a aVar = new com.facebook.drawee.drawable.a(drawable, scaleType);
        if (pointF != null) {
            aVar.v(pointF);
        }
        return aVar;
    }

    public static void i(Rounded rounded) {
        rounded.k(false);
        rounded.setRadius(0.0f);
        rounded.g(0, 0.0f);
        rounded.n(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(DrawableParent drawableParent, @Nullable RoundingParams roundingParams, Resources resources) {
        DrawableParent drawableParentC = c(drawableParent);
        Drawable drawableI = drawableParentC.i();
        if (roundingParams == null || roundingParams.l() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawableI instanceof Rounded) {
                i((Rounded) drawableI);
            }
        } else if (drawableI instanceof Rounded) {
            b((Rounded) drawableI, roundingParams);
        } else if (drawableI != 0) {
            drawableParentC.h(f29976a);
            drawableParentC.h(a(drawableI, roundingParams, resources));
        }
    }

    public static void k(DrawableParent drawableParent, @Nullable RoundingParams roundingParams) {
        Drawable drawableI = drawableParent.i();
        if (roundingParams == null || roundingParams.l() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawableI instanceof RoundedCornersDrawable) {
                Drawable drawable = f29976a;
                drawableParent.h(((RoundedCornersDrawable) drawableI).q(drawable));
                drawable.setCallback(null);
                return;
            }
            return;
        }
        if (!(drawableI instanceof RoundedCornersDrawable)) {
            drawableParent.h(f(drawableParent.h(f29976a), roundingParams));
            return;
        }
        RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawableI;
        b(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.s(roundingParams.i());
    }

    public static com.facebook.drawee.drawable.a l(DrawableParent drawableParent, ScalingUtils.ScaleType scaleType) {
        Drawable drawableG = g(drawableParent.h(f29976a), scaleType);
        drawableParent.h(drawableG);
        ax6.j(drawableG, "Parent has no child drawable!");
        return (com.facebook.drawee.drawable.a) drawableG;
    }
}
