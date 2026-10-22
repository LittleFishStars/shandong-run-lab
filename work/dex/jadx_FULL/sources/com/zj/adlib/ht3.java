package com.zj.adlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ht3 {
    @Nullable
    public static Drawable a(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    public static RoundingParams b(gt3 gt3Var) {
        if (gt3Var.s() == null) {
            gt3Var.T(new RoundingParams());
        }
        return gt3Var.s();
    }

    @Nullable
    public static ScalingUtils.ScaleType c(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.f29972a;
            case 1:
                return ScalingUtils.ScaleType.b;
            case 2:
                return ScalingUtils.ScaleType.c;
            case 3:
                return ScalingUtils.ScaleType.d;
            case 4:
                return ScalingUtils.ScaleType.e;
            case 5:
                return ScalingUtils.ScaleType.f;
            case 6:
                return ScalingUtils.ScaleType.g;
            case 7:
                return ScalingUtils.ScaleType.h;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static gt3 d(Context context, @Nullable AttributeSet attributeSet) {
        return f(new gt3(context.getResources()), context, attributeSet);
    }

    public static ft3 e(Context context, @Nullable AttributeSet attributeSet) {
        return d(context, attributeSet).a();
    }

    public static gt3 f(gt3 gt3Var, Context context, @Nullable AttributeSet attributeSet) {
        int dimensionPixelSize;
        boolean z;
        boolean z2;
        boolean z3;
        int i = 0;
        boolean z4 = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                int integer = 0;
                dimensionPixelSize = 0;
                z = true;
                z2 = true;
                z3 = true;
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.GenericDraweeHierarchy_actualImageScaleType) {
                        gt3Var.z(c(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImage) {
                        gt3Var.J(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage) {
                        gt3Var.M(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImage) {
                        gt3Var.N(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_fadeDuration) {
                        gt3Var.D(typedArrayObtainStyledAttributes.getInt(index, 0));
                    } else if (index == R.styleable.GenericDraweeHierarchy_viewAspectRatio) {
                        gt3Var.C(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType) {
                        gt3Var.L(c(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_retryImage) {
                        gt3Var.Q(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_retryImageScaleType) {
                        gt3Var.S(c(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_failureImage) {
                        gt3Var.E(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_failureImageScaleType) {
                        gt3Var.G(c(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType) {
                        gt3Var.P(c(typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                        integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                    } else if (index == R.styleable.GenericDraweeHierarchy_backgroundImage) {
                        gt3Var.A(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_overlayImage) {
                        gt3Var.H(a(context, typedArrayObtainStyledAttributes, index));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundAsCircle) {
                        b(gt3Var).u(typedArrayObtainStyledAttributes.getBoolean(index, false));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundedCornerRadius) {
                        dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundTopLeft) {
                        z4 = typedArrayObtainStyledAttributes.getBoolean(index, z4);
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundTopRight) {
                        z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomLeft) {
                        z3 = typedArrayObtainStyledAttributes.getBoolean(index, z3);
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomRight) {
                        z2 = typedArrayObtainStyledAttributes.getBoolean(index, z2);
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor) {
                        b(gt3Var).s(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderWidth) {
                        b(gt3Var).o(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderColor) {
                        b(gt3Var).n(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderPadding) {
                        b(gt3Var).t(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
                i = integer;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            dimensionPixelSize = 0;
            z = true;
            z2 = true;
            z3 = true;
        }
        if (gt3Var.o() != null && i > 0) {
            gt3Var.N(new ji0(gt3Var.o(), i));
        }
        if (dimensionPixelSize > 0) {
            b(gt3Var).p(z4 ? dimensionPixelSize : 0.0f, z ? dimensionPixelSize : 0.0f, z2 ? dimensionPixelSize : 0.0f, z3 ? dimensionPixelSize : 0.0f);
        }
        return gt3Var;
    }
}
