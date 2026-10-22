package com.huachenjie.common.binding_adapter;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.coroutines.BindingAdapter;
import com.zj.adlib.e27;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DrawablesBindingAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33648a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f8512a = "Drawables";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f8513a = new int[4];

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DP {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientType {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
        public static final int SWEEP = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
        public static final int BL_TR = 5;
        public static final int BOTTOM_TOP = 4;
        public static final int BR_TL = 3;
        public static final int LEFT_RIGHT = 6;
        public static final int RIGHT_LEFT = 2;
        public static final int TL_BR = 7;
        public static final int TOP_BOTTOM = 0;
        public static final int TR_BL = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShapeMode {
        public static final int LINE = 2;
        public static final int OVAL = 1;
        public static final int RECTANGLE = 0;
        public static final int RING = 3;
    }

    public static Drawable a(int shapeMode, @ColorInt Integer solidColor, @ColorInt int strokeColor, float strokeWidth, float strokeDash, float strokeDashGap, float radius, float radiusLT, float radiusLB, float radiusRT, float radiusRB, @ColorInt Integer startColor, @ColorInt Integer centerColor, @ColorInt Integer endColor, int orientation, int gradientType, Float radialCenterX, Float radialCenterY, float radialRadius, float width, float height, float marginLeft, float marginTop, float marginRight, float marginBottom, float ringThickness, float ringThicknessRatio, float ringInnerRadius, float ringInnerRadiusRatio) {
        if (shapeMode == 0 && solidColor == null && strokeColor == 0 && strokeWidth == 0.0f && strokeDash == 0.0f && strokeDashGap == 0.0f && radius == 0.0f && radiusLT == 0.0f && radiusLB == 0.0f && radiusRT == 0.0f && radiusRB == 0.0f && startColor == null && centerColor == null && endColor == null && orientation == 0 && gradientType == 0 && radialCenterX == null && radialCenterY == null && radialRadius == 0.0f && width == 0.0f && height == 0.0f && marginLeft == 0.0f && marginTop == 0.0f && marginRight == 0.0f && marginBottom == 0.0f) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (startColor != null && endColor != null) {
            gradientDrawable.setColors(centerColor != null ? new int[]{startColor.intValue(), centerColor.intValue(), endColor.intValue()} : new int[]{startColor.intValue(), endColor.intValue()});
            gradientDrawable.setOrientation(c(orientation));
            gradientDrawable.setGradientType(gradientType);
            if (gradientType == 1) {
                gradientDrawable.setGradientCenter(radialCenterX == null ? 0.5f : radialCenterX.floatValue(), radialCenterY != null ? radialCenterY.floatValue() : 0.5f);
                gradientDrawable.setGradientRadius(b(radialRadius));
            }
        } else if (solidColor != null) {
            gradientDrawable.setColor(solidColor.intValue());
        }
        gradientDrawable.setShape(i(shapeMode));
        if (shapeMode == 3) {
            f(gradientDrawable, Float.valueOf(ringThickness), Float.valueOf(ringThicknessRatio), Float.valueOf(ringInnerRadius), Float.valueOf(ringInnerRadiusRatio));
        }
        if (strokeWidth > 0.0f) {
            gradientDrawable.setStroke(b(strokeWidth), strokeColor, b(strokeDash), b(strokeDashGap));
        }
        if (radius <= 0.0f) {
            gradientDrawable.setCornerRadii(new float[]{b(radiusLT), b(radiusLT), b(radiusRT), b(radiusRT), b(radiusRB), b(radiusRB), b(radiusLB), b(radiusLB)});
        } else {
            gradientDrawable.setCornerRadius(b(radius));
        }
        if (width > 0.0f && height > 0.0f) {
            gradientDrawable.setSize(b(width), b(height));
        }
        return (marginLeft == 0.0f && marginTop == 0.0f && marginRight == 0.0f && marginBottom == 0.0f) ? gradientDrawable : new InsetDrawable((Drawable) gradientDrawable, b(marginLeft), b(marginTop), b(marginRight), b(marginBottom));
    }

    public static int b(float dipValue) {
        return (int) ((dipValue * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static GradientDrawable.Orientation c(int orientation) {
        switch (orientation) {
            case 0:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return GradientDrawable.Orientation.BL_TR;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;
            default:
                return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    @BindingAdapter(requireAll = false, value = {"normalSrc", "normalTint", "checkedSrc", "checkedTint", "checkableSrc", "checkableTint", "disabledSrc", "disabledTint", "focusedSrc", "focusedTint", "pressedSrc", "pressedTint", "selectedSrc", "selectedTint"})
    public static void d(View imageView, Drawable normalSrc, @ColorInt Integer normalTint, Drawable checkedSrc, @ColorInt Integer checkedTint, Drawable checkableSrc, @ColorInt Integer checkableTint, Drawable disabledSrc, @ColorInt Integer disabledTint, Drawable focusedSrc, @ColorInt Integer focusedTint, Drawable pressedSrc, @ColorInt Integer pressedTint, Drawable selectedSrc, @ColorInt Integer selectedTint) {
        if (imageView instanceof ImageView) {
            e27 e27Var = new e27();
            if (checkedSrc != null) {
                if (checkedTint != null) {
                    checkableSrc.setTint(checkedTint.intValue());
                }
                e27Var.addState(new int[]{R.attr.state_checked}, checkedSrc);
            }
            if (checkableSrc != null) {
                if (checkableTint != null) {
                    checkableSrc.setTint(checkableTint.intValue());
                }
                e27Var.addState(new int[]{R.attr.state_checkable}, checkableSrc);
            }
            if (disabledSrc != null) {
                if (disabledTint != null) {
                    disabledSrc.setTint(disabledTint.intValue());
                }
                e27Var.addState(new int[]{-16842910}, disabledSrc);
            }
            if (focusedSrc != null) {
                if (focusedTint != null) {
                    focusedSrc.setTint(focusedTint.intValue());
                }
                e27Var.addState(new int[]{R.attr.state_focused}, focusedSrc);
            }
            if (pressedSrc != null) {
                if (pressedTint != null) {
                    pressedSrc.setTint(pressedTint.intValue());
                }
                e27Var.addState(new int[]{R.attr.state_pressed}, pressedSrc);
            }
            if (selectedSrc != null) {
                if (selectedTint != null) {
                    selectedSrc.setTint(selectedTint.intValue());
                }
                e27Var.addState(new int[]{R.attr.state_selected}, selectedSrc);
            }
            if (normalSrc != null) {
                if (normalTint != null) {
                    normalSrc.setTint(normalTint.intValue());
                }
                e27Var.addState(new int[0], normalSrc);
            }
            ((ImageView) imageView).setImageDrawable(e27Var);
        }
    }

    @BindingAdapter({"srcRes"})
    public static void e(View imageView, @DrawableRes int srcRes) {
        if (imageView instanceof ImageView) {
            ((ImageView) imageView).setImageResource(srcRes);
        }
    }

    public static void f(GradientDrawable drawable, Float thickness, Float thicknessRatio, Float innerRadius, Float innerRadiusRatio) {
        try {
            Field declaredField = drawable.getClass().getDeclaredField("mGradientState");
            declaredField.setAccessible(true);
            Class<?> cls = declaredField.get(drawable).getClass();
            Field declaredField2 = cls.getDeclaredField("mUseLevelForShape");
            declaredField2.setAccessible(true);
            declaredField2.setBoolean(declaredField.get(drawable), false);
            if (thickness != null) {
                Field declaredField3 = cls.getDeclaredField("mThickness");
                declaredField3.setAccessible(true);
                declaredField3.setInt(declaredField.get(drawable), b(thickness.floatValue()));
            }
            if (thicknessRatio != null) {
                Field declaredField4 = cls.getDeclaredField("mThicknessRatio");
                declaredField4.setAccessible(true);
                declaredField4.setFloat(declaredField.get(drawable), b(thicknessRatio.floatValue()));
            }
            if (innerRadius != null) {
                Field declaredField5 = cls.getDeclaredField("mInnerRadius");
                declaredField5.setAccessible(true);
                declaredField5.setInt(declaredField.get(drawable), b(innerRadius.floatValue()));
            }
            if (innerRadiusRatio != null) {
                Field declaredField6 = cls.getDeclaredField("mInnerRadiusRatio");
                declaredField6.setAccessible(true);
                declaredField6.setFloat(declaredField.get(drawable), b(innerRadiusRatio.floatValue()));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    @BindingAdapter(requireAll = false, value = {"textColor", "textCheckedColor", "textCheckableColor", "textDisabledColor", "textFocusedColor", "textPressedColor", "textSelectedColor"})
    public static void g(View textView, @ColorInt Integer textColor, @ColorInt Integer textCheckedColor, @ColorInt Integer textCheckableColor, @ColorInt Integer textDisabledColor, @ColorInt Integer textFocusedColor, @ColorInt Integer textPressedColor, @ColorInt Integer textSelectedColor) {
        int i;
        if (textView instanceof TextView) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 7, 1);
            int[] iArr2 = new int[7];
            if (textDisabledColor != null) {
                iArr[0] = new int[]{-16842910};
                iArr2[0] = textDisabledColor.intValue();
                i = 1;
            } else {
                i = 0;
            }
            if (textPressedColor != null) {
                iArr[i] = new int[]{R.attr.state_pressed};
                iArr2[i] = textPressedColor.intValue();
                i++;
            }
            if (textCheckedColor != null) {
                iArr[i] = new int[]{R.attr.state_checked};
                iArr2[i] = textCheckedColor.intValue();
                i++;
            }
            if (textSelectedColor != null) {
                iArr[i] = new int[]{R.attr.state_selected};
                iArr2[i] = textSelectedColor.intValue();
                i++;
            }
            if (textFocusedColor != null) {
                iArr[i] = new int[]{R.attr.state_focused};
                iArr2[i] = textFocusedColor.intValue();
                i++;
            }
            if (textCheckableColor != null) {
                iArr[i] = new int[]{R.attr.state_checkable};
                iArr2[i] = textCheckableColor.intValue();
                i++;
            }
            if (textColor != null) {
                iArr[i] = new int[]{0};
                iArr2[i] = textColor.intValue();
                i++;
            }
            if (i > 0) {
                ((TextView) textView).setTextColor(new ColorStateList(iArr, iArr2));
            }
        }
    }

    @BindingAdapter(requireAll = false, value = {"drawable_shapeMode", "drawable_solidColor", "drawable_strokeColor", "drawable_strokeWidth", "drawable_strokeDash", "drawable_strokeDashGap", "drawable_radius", "drawable_radiusLT", "drawable_radiusLB", "drawable_radiusRT", "drawable_radiusRB", "drawable_startColor", "drawable_centerColor", "drawable_endColor", "drawable_orientation", "drawable_gradientType", "drawable_radialCenterX", "drawable_radialCenterY", "drawable_radialRadius", "drawable_width", "drawable_height", "drawable_marginLeft", "drawable_marginTop", "drawable_marginRight", "drawable_marginBottom", "drawable_ringThickness", "drawable_ringThicknessRatio", "drawable_ringInnerRadius", "drawable_ringInnerRadiusRatio", "drawable_checked_shapeMode", "drawable_checked_solidColor", "drawable_checked_strokeColor", "drawable_checked_strokeWidth", "drawable_checked_strokeDash", "drawable_checked_strokeDashGap", "drawable_checked_radius", "drawable_checked_radiusLT", "drawable_checked_radiusLB", "drawable_checked_radiusRT", "drawable_checked_radiusRB", "drawable_checked_startColor", "drawable_checked_centerColor", "drawable_checked_endColor", "drawable_checked_orientation", "drawable_checked_gradientType", "drawable_checked_radialCenterX", "drawable_checked_radialCenterY", "drawable_checked_radialRadius", "drawable_checked_width", "drawable_checked_height", "drawable_checked_marginLeft", "drawable_checked_marginTop", "drawable_checked_marginRight", "drawable_checked_marginBottom", "drawable_checked_ringThickness", "drawable_checked_ringThicknessRatio", "drawable_checked_ringInnerRadius", "drawable_checked_ringInnerRadiusRatio", "drawable_checkable_shapeMode", "drawable_checkable_solidColor", "drawable_checkable_strokeColor", "drawable_checkable_strokeWidth", "drawable_checkable_strokeDash", "drawable_checkable_strokeDashGap", "drawable_checkable_radius", "drawable_checkable_radiusLT", "drawable_checkable_radiusLB", "drawable_checkable_radiusRT", "drawable_checkable_radiusRB", "drawable_checkable_startColor", "drawable_checkable_centerColor", "drawable_checkable_endColor", "drawable_checkable_orientation", "drawable_checkable_gradientType", "drawable_checkable_radialCenterX", "drawable_checkable_radialCenterY", "drawable_checkable_radialRadius", "drawable_checkable_width", "drawable_checkable_height", "drawable_checkable_marginLeft", "drawable_checkable_marginTop", "drawable_checkable_marginRight", "drawable_checkable_marginBottom", "drawable_checkable_ringThickness", "drawable_checkable_ringThicknessRatio", "drawable_checkable_ringInnerRadius", "drawable_checkable_ringInnerRadiusRatio", "drawable_enabled_shapeMode", "drawable_enabled_solidColor", "drawable_enabled_strokeColor", "drawable_enabled_strokeWidth", "drawable_enabled_strokeDash", "drawable_enabled_strokeDashGap", "drawable_enabled_radius", "drawable_enabled_radiusLT", "drawable_enabled_radiusLB", "drawable_enabled_radiusRT", "drawable_enabled_radiusRB", "drawable_enabled_startColor", "drawable_enabled_centerColor", "drawable_enabled_endColor", "drawable_enabled_orientation", "drawable_enabled_gradientType", "drawable_enabled_radialCenterX", "drawable_enabled_radialCenterY", "drawable_enabled_radialRadius", "drawable_enabled_width", "drawable_enabled_height", "drawable_enabled_marginLeft", "drawable_enabled_marginTop", "drawable_enabled_marginRight", "drawable_enabled_marginBottom", "drawable_enabled_ringThickness", "drawable_enabled_ringThicknessRatio", "drawable_enabled_ringInnerRadius", "drawable_enabled_ringInnerRadiusRatio", "drawable_disabled_shapeMode", "drawable_disabled_solidColor", "drawable_disabled_strokeColor", "drawable_disabled_strokeWidth", "drawable_disabled_strokeDash", "drawable_disabled_strokeDashGap", "drawable_disabled_radius", "drawable_disabled_radiusLT", "drawable_disabled_radiusLB", "drawable_disabled_radiusRT", "drawable_disabled_radiusRB", "drawable_disabled_startColor", "drawable_disabled_centerColor", "drawable_disabled_endColor", "drawable_disabled_orientation", "drawable_disabled_gradientType", "drawable_disabled_radialCenterX", "drawable_disabled_radialCenterY", "drawable_disabled_radialRadius", "drawable_disabled_width", "drawable_disabled_height", "drawable_disabled_marginLeft", "drawable_disabled_marginTop", "drawable_disabled_marginRight", "drawable_disabled_marginBottom", "drawable_disabled_ringThickness", "drawable_disabled_ringThicknessRatio", "drawable_disabled_ringInnerRadius", "drawable_disabled_ringInnerRadiusRatio", "drawable_focused_shapeMode", "drawable_focused_solidColor", "drawable_focused_strokeColor", "drawable_focused_strokeWidth", "drawable_focused_strokeDash", "drawable_focused_strokeDashGap", "drawable_focused_radius", "drawable_focused_radiusLT", "drawable_focused_radiusLB", "drawable_focused_radiusRT", "drawable_focused_radiusRB", "drawable_focused_startColor", "drawable_focused_centerColor", "drawable_focused_endColor", "drawable_focused_orientation", "drawable_focused_gradientType", "drawable_focused_radialCenterX", "drawable_focused_radialCenterY", "drawable_focused_radialRadius", "drawable_focused_width", "drawable_focused_height", "drawable_focused_marginLeft", "drawable_focused_marginTop", "drawable_focused_marginRight", "drawable_focused_marginBottom", "drawable_focused_ringThickness", "drawable_focused_ringThicknessRatio", "drawable_focused_ringInnerRadius", "drawable_focused_ringInnerRadiusRatio", "drawable_pressed_shapeMode", "drawable_pressed_solidColor", "drawable_pressed_strokeColor", "drawable_pressed_strokeWidth", "drawable_pressed_strokeDash", "drawable_pressed_strokeDashGap", "drawable_pressed_radius", "drawable_pressed_radiusLT", "drawable_pressed_radiusLB", "drawable_pressed_radiusRT", "drawable_pressed_radiusRB", "drawable_pressed_startColor", "drawable_pressed_centerColor", "drawable_pressed_endColor", "drawable_pressed_orientation", "drawable_pressed_gradientType", "drawable_pressed_radialCenterX", "drawable_pressed_radialCenterY", "drawable_pressed_radialRadius", "drawable_pressed_width", "drawable_pressed_height", "drawable_pressed_marginLeft", "drawable_pressed_marginTop", "drawable_pressed_marginRight", "drawable_pressed_marginBottom", "drawable_pressed_ringThickness", "drawable_pressed_ringThicknessRatio", "drawable_pressed_ringInnerRadius", "drawable_pressed_ringInnerRadiusRatio", "drawable_selected_shapeMode", "drawable_selected_solidColor", "drawable_selected_strokeColor", "drawable_selected_strokeWidth", "drawable_selected_strokeDash", "drawable_selected_strokeDashGap", "drawable_selected_radius", "drawable_selected_radiusLT", "drawable_selected_radiusLB", "drawable_selected_radiusRT", "drawable_selected_radiusRB", "drawable_selected_startColor", "drawable_selected_centerColor", "drawable_selected_endColor", "drawable_selected_orientation", "drawable_selected_gradientType", "drawable_selected_radialCenterX", "drawable_selected_radialCenterY", "drawable_selected_radialRadius", "drawable_selected_width", "drawable_selected_height", "drawable_selected_marginLeft", "drawable_selected_marginTop", "drawable_selected_marginRight", "drawable_selected_marginBottom", "drawable_selected_ringThickness", "drawable_selected_ringThicknessRatio", "drawable_selected_ringInnerRadius", "drawable_selected_ringInnerRadiusRatio", "drawable", "drawable_checked", "drawable_checkable", "drawable_enabled", "drawable_disabled", "drawable_focused", "drawable_pressed", "drawable_selected"})
    public static void h(View view, int shapeMode, @ColorInt Integer solidColor, @ColorInt int strokeColor, float strokeWidth, float strokeDash, float strokeDashGap, float radius, float radiusLT, float radiusLB, float radiusRT, float radiusRB, @ColorInt Integer startColor, @ColorInt Integer centerColor, @ColorInt Integer endColor, int orientation, int gradientType, Float radialCenterX, Float radialCenterY, float radialRadius, float width, float height, float marginLeft, float marginTop, float marginRight, float marginBottom, float ringThickness, float ringThicknessRatio, float ringInnerRadius, float ringInnerRadiusRatio, int checked_shapeMode, @ColorInt Integer checked_solidColor, @ColorInt int checked_strokeColor, float checked_strokeWidth, float checked_strokeDash, float checked_strokeDashGap, float checked_radius, float checked_radiusLT, float checked_radiusLB, float checked_radiusRT, float checked_radiusRB, @ColorInt Integer checked_startColor, @ColorInt Integer checked_centerColor, @ColorInt Integer checked_endColor, int checked_orientation, int checked_gradientType, Float checked_radialCenterX, Float checked_radialCenterY, float checked_radialRadius, float checked_width, float checked_height, float checked_marginLeft, float checked_marginTop, float checked_marginRight, float checked_marginBottom, float checked_ringThickness, float checked_ringThicknessRatio, float checked_ringInnerRadius, float checked_ringInnerRadiusRatio, int checkable_shapeMode, @ColorInt Integer checkable_solidColor, @ColorInt int checkable_strokeColor, float checkable_strokeWidth, float checkable_strokeDash, float checkable_strokeDashGap, float checkable_radius, float checkable_radiusLT, float checkable_radiusLB, float checkable_radiusRT, float checkable_radiusRB, @ColorInt Integer checkable_startColor, @ColorInt Integer checkable_centerColor, @ColorInt Integer checkable_endColor, int checkable_orientation, int checkable_gradientType, Float checkable_radialCenterX, Float checkable_radialCenterY, float checkable_radialRadius, float checkable_width, float checkable_height, float checkable_marginLeft, float checkable_marginTop, float checkable_marginRight, float checkable_marginBottom, float checkable_ringThickness, float checkable_ringThicknessRatio, float checkable_ringInnerRadius, float checkable_ringInnerRadiusRatio, int enabled_shapeMode, @ColorInt Integer enabled_solidColor, @ColorInt int enabled_strokeColor, float enabled_strokeWidth, float enabled_strokeDash, float enabled_strokeDashGap, float enabled_radius, float enabled_radiusLT, float enabled_radiusLB, float enabled_radiusRT, float enabled_radiusRB, @ColorInt Integer enabled_startColor, @ColorInt Integer enabled_centerColor, @ColorInt Integer enabled_endColor, int enabled_orientation, int enabled_gradientType, Float enabled_radialCenterX, Float enabled_radialCenterY, float enabled_radialRadius, float enabled_width, float enabled_height, float enabled_marginLeft, float enabled_marginTop, float enabled_marginRight, float enabled_marginBottom, float enabled_ringThickness, float enabled_ringThicknessRatio, float enabled_ringInnerRadius, float enabled_ringInnerRadiusRatio, int disabled_shapeMode, @ColorInt Integer disabled_solidColor, @ColorInt int disabled_strokeColor, float disabled_strokeWidth, float disabled_strokeDash, float disabled_strokeDashGap, float disabled_radius, float disabled_radiusLT, float disabled_radiusLB, float disabled_radiusRT, float disabled_radiusRB, @ColorInt Integer disabled_startColor, @ColorInt Integer disabled_centerColor, @ColorInt Integer disabled_endColor, int disabled_orientation, int disabled_gradientType, Float disabled_radialCenterX, Float disabled_radialCenterY, float disabled_radialRadius, float disabled_width, float disabled_height, float disabled_marginLeft, float disabled_marginTop, float disabled_marginRight, float disabled_marginBottom, float disabled_ringThickness, float disabled_ringThicknessRatio, float disabled_ringInnerRadius, float disabled_ringInnerRadiusRatio, int focused_shapeMode, @ColorInt Integer focused_solidColor, @ColorInt int focused_strokeColor, float focused_strokeWidth, float focused_strokeDash, float focused_strokeDashGap, float focused_radius, float focused_radiusLT, float focused_radiusLB, float focused_radiusRT, float focused_radiusRB, @ColorInt Integer focused_startColor, @ColorInt Integer focused_centerColor, @ColorInt Integer focused_endColor, int focused_orientation, int focused_gradientType, Float focused_radialCenterX, Float focused_radialCenterY, float focused_radialRadius, float focused_width, float focused_height, float focused_marginLeft, float focused_marginTop, float focused_marginRight, float focused_marginBottom, float focused_ringThickness, float focused_ringThicknessRatio, float focused_ringInnerRadius, float focused_ringInnerRadiusRatio, int pressed_shapeMode, @ColorInt Integer pressed_solidColor, @ColorInt int pressed_strokeColor, float pressed_strokeWidth, float pressed_strokeDash, float pressed_strokeDashGap, float pressed_radius, float pressed_radiusLT, float pressed_radiusLB, float pressed_radiusRT, float pressed_radiusRB, @ColorInt Integer pressed_startColor, @ColorInt Integer pressed_centerColor, @ColorInt Integer pressed_endColor, int pressed_orientation, int pressed_gradientType, Float pressed_radialCenterX, Float pressed_radialCenterY, float pressed_radialRadius, float pressed_width, float pressed_height, float pressed_marginLeft, float pressed_marginTop, float pressed_marginRight, float pressed_marginBottom, float pressed_ringThickness, float pressed_ringThicknessRatio, float pressed_ringInnerRadius, float pressed_ringInnerRadiusRatio, int selected_shapeMode, @ColorInt Integer selected_solidColor, @ColorInt int selected_strokeColor, float selected_strokeWidth, float selected_strokeDash, float selected_strokeDashGap, float selected_radius, float selected_radiusLT, float selected_radiusLB, float selected_radiusRT, float selected_radiusRB, @ColorInt Integer selected_startColor, @ColorInt Integer selected_centerColor, @ColorInt Integer selected_endColor, int selected_orientation, int selected_gradientType, Float selected_radialCenterX, Float selected_radialCenterY, float selected_radialRadius, float selected_width, float selected_height, float selected_marginLeft, float selected_marginTop, float selected_marginRight, float selected_marginBottom, float selected_ringThickness, float selected_ringThicknessRatio, float selected_ringInnerRadius, float selected_ringInnerRadiusRatio, Drawable drawable, Drawable drawable_checked, Drawable drawable_checkable, Drawable drawable_enabled, Drawable drawable_disabled, Drawable drawable_focused, Drawable drawable_pressed, Drawable drawable_selected) {
        boolean z;
        int i;
        boolean z2;
        Drawable drawableA = drawable;
        if (drawableA == null) {
            drawableA = a(shapeMode, solidColor, strokeColor, strokeWidth, strokeDash, strokeDashGap, radius, radiusLT, radiusLB, radiusRT, radiusRB, startColor, centerColor, endColor, orientation, gradientType, radialCenterX, radialCenterY, radialRadius, width, height, marginLeft, marginTop, marginRight, marginBottom, ringThickness, ringThicknessRatio, ringInnerRadius, ringInnerRadiusRatio);
        }
        if (drawableA != null) {
            i = 1;
            z = false;
        } else {
            z = true;
            i = 0;
        }
        if (drawable_checked == 0) {
            drawable_checked = a(checked_shapeMode, checked_solidColor, checked_strokeColor, checked_strokeWidth, checked_strokeDash, checked_strokeDashGap, checked_radius, checked_radiusLT, checked_radiusLB, checked_radiusRT, checked_radiusRB, checked_startColor, checked_centerColor, checked_endColor, checked_orientation, checked_gradientType, checked_radialCenterX, checked_radialCenterY, checked_radialRadius, checked_width, checked_height, checked_marginLeft, checked_marginTop, checked_marginRight, checked_marginBottom, checked_ringThickness, checked_ringThicknessRatio, checked_ringInnerRadius, checked_ringInnerRadiusRatio);
        }
        if (drawable_checked != null) {
            i++;
        }
        Drawable drawableA2 = drawable_checkable;
        if (drawableA2 == null) {
            drawableA2 = a(checkable_shapeMode, checkable_solidColor, checkable_strokeColor, checkable_strokeWidth, checkable_strokeDash, checkable_strokeDashGap, checkable_radius, checkable_radiusLT, checkable_radiusLB, checkable_radiusRT, checkable_radiusRB, checkable_startColor, checkable_centerColor, checkable_endColor, checkable_orientation, checkable_gradientType, checkable_radialCenterX, checkable_radialCenterY, checkable_radialRadius, checkable_width, checkable_height, checkable_marginLeft, checkable_marginTop, checkable_marginRight, checkable_marginBottom, checkable_ringThickness, checkable_ringThicknessRatio, checkable_ringInnerRadius, checkable_ringInnerRadiusRatio);
        }
        if (drawableA2 != null) {
            i++;
        }
        Drawable drawableA3 = drawable_enabled;
        if (drawableA3 == null) {
            drawableA3 = a(enabled_shapeMode, enabled_solidColor, enabled_strokeColor, enabled_strokeWidth, enabled_strokeDash, enabled_strokeDashGap, enabled_radius, enabled_radiusLT, enabled_radiusLB, enabled_radiusRT, enabled_radiusRB, enabled_startColor, enabled_centerColor, enabled_endColor, enabled_orientation, enabled_gradientType, enabled_radialCenterX, enabled_radialCenterY, enabled_radialRadius, enabled_width, enabled_height, enabled_marginLeft, enabled_marginTop, enabled_marginRight, enabled_marginBottom, enabled_ringThickness, enabled_ringThicknessRatio, enabled_ringInnerRadius, enabled_ringInnerRadiusRatio);
        }
        if (drawableA3 != null) {
            i++;
        }
        Drawable drawableA4 = drawable_disabled;
        if (drawableA4 == null) {
            drawableA4 = a(disabled_shapeMode, disabled_solidColor, disabled_strokeColor, disabled_strokeWidth, disabled_strokeDash, disabled_strokeDashGap, disabled_radius, disabled_radiusLT, disabled_radiusLB, disabled_radiusRT, disabled_radiusRB, disabled_startColor, disabled_centerColor, disabled_endColor, disabled_orientation, disabled_gradientType, disabled_radialCenterX, disabled_radialCenterY, disabled_radialRadius, disabled_width, disabled_height, disabled_marginLeft, disabled_marginTop, disabled_marginRight, disabled_marginBottom, disabled_ringThickness, disabled_ringThicknessRatio, disabled_ringInnerRadius, disabled_ringInnerRadiusRatio);
        }
        if (drawableA4 != null) {
            i++;
        }
        Drawable drawableA5 = drawable_focused;
        if (drawableA5 == null) {
            drawableA5 = a(focused_shapeMode, focused_solidColor, focused_strokeColor, focused_strokeWidth, focused_strokeDash, focused_strokeDashGap, focused_radius, focused_radiusLT, focused_radiusLB, focused_radiusRT, focused_radiusRB, focused_startColor, focused_centerColor, focused_endColor, focused_orientation, focused_gradientType, focused_radialCenterX, focused_radialCenterY, focused_radialRadius, focused_width, focused_height, focused_marginLeft, focused_marginTop, focused_marginRight, focused_marginBottom, focused_ringThickness, focused_ringThicknessRatio, focused_ringInnerRadius, focused_ringInnerRadiusRatio);
        }
        if (drawableA5 != null) {
            i++;
        }
        Drawable drawableA6 = drawable_pressed;
        if (drawableA6 == null) {
            drawableA6 = a(pressed_shapeMode, pressed_solidColor, pressed_strokeColor, pressed_strokeWidth, pressed_strokeDash, pressed_strokeDashGap, pressed_radius, pressed_radiusLT, pressed_radiusLB, pressed_radiusRT, pressed_radiusRB, pressed_startColor, pressed_centerColor, pressed_endColor, pressed_orientation, pressed_gradientType, pressed_radialCenterX, pressed_radialCenterY, pressed_radialRadius, pressed_width, pressed_height, pressed_marginLeft, pressed_marginTop, pressed_marginRight, pressed_marginBottom, pressed_ringThickness, pressed_ringThicknessRatio, pressed_ringInnerRadius, pressed_ringInnerRadiusRatio);
        }
        if (drawableA6 != null) {
            i++;
        }
        Drawable drawableA7 = drawable_selected;
        if (drawableA7 == null) {
            drawableA7 = a(selected_shapeMode, selected_solidColor, selected_strokeColor, selected_strokeWidth, selected_strokeDash, selected_strokeDashGap, selected_radius, selected_radiusLT, selected_radiusLB, selected_radiusRT, selected_radiusRB, selected_startColor, selected_centerColor, selected_endColor, selected_orientation, selected_gradientType, selected_radialCenterX, selected_radialCenterY, selected_radialRadius, selected_width, selected_height, selected_marginLeft, selected_marginTop, selected_marginRight, selected_marginBottom, selected_ringThickness, selected_ringThicknessRatio, selected_ringInnerRadius, selected_ringInnerRadiusRatio);
        }
        if (drawableA7 != null) {
            i++;
        }
        if (i < 1) {
            return;
        }
        if (z || i == 1) {
            int[] iArr = f8513a;
            iArr[0] = view.getPaddingLeft();
            iArr[1] = view.getPaddingTop();
            iArr[2] = view.getPaddingRight();
            iArr[3] = view.getPaddingBottom();
            z2 = true;
        } else {
            z2 = false;
        }
        if (i != 1 || z) {
            e27 e27Var = new e27();
            if (drawable_checked != null) {
                e27Var.addState(new int[]{R.attr.state_checked}, drawable_checked);
            }
            if (drawableA2 != null) {
                e27Var.addState(new int[]{R.attr.state_checkable}, drawableA2);
            }
            if (drawableA5 != null) {
                e27Var.addState(new int[]{R.attr.state_focused}, drawableA5);
            }
            if (drawableA6 != null) {
                e27Var.addState(new int[]{R.attr.state_pressed}, drawableA6);
            }
            if (drawableA7 != null) {
                e27Var.addState(new int[]{R.attr.state_selected}, drawableA7);
            }
            if (drawableA4 != null) {
                e27Var.addState(new int[]{-16842910}, drawableA4);
            }
            if (drawableA3 != null) {
                e27Var.addState(new int[]{R.attr.state_enabled}, drawableA3);
            }
            if (drawableA != null) {
                e27Var.addState(new int[]{0}, drawableA);
            } else {
                Drawable background = view.getBackground();
                if (background != null) {
                    if (background instanceof e27) {
                        background = ((e27) background).a();
                    }
                    e27Var.addState(new int[]{0}, background);
                }
            }
            view.setBackground(e27Var);
        } else {
            view.setBackground(drawableA);
        }
        if (z2) {
            int[] iArr2 = f8513a;
            view.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        }
    }

    public static int i(int shapeMode) {
        if (shapeMode > 3 || shapeMode < 0) {
            return 0;
        }
        return shapeMode;
    }
}
