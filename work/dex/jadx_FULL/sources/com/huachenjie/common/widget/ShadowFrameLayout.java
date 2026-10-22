package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import com.huachenjie.common.R;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020+H\u0002J\b\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020\nH\u0002J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u0011J(\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020+H\u0014J\u0010\u0010<\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0014J0\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\u0018\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0014J(\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J\u0010\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020+H\u0002J\u0010\u0010O\u001a\u00020+2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010P\u001a\u00020+2\b\b\u0001\u0010Q\u001a\u00020\u0007J\u000e\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\nJ\u0010\u0010T\u001a\u00020+2\b\b\u0001\u0010U\u001a\u00020\u0007J.\u0010T\u001a\u00020+2\b\b\u0001\u0010?\u001a\u00020\u00072\b\b\u0001\u0010@\u001a\u00020\u00072\b\b\u0001\u0010A\u001a\u00020\u00072\b\b\u0001\u0010B\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020\u001dJ(\u0010X\u001a\u00020+2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0016J(\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0016J(\u0010\\\u001a\u00020+2\b\b\u0001\u0010Q\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\b\u0010_\u001a\u00020+H\u0002J(\u0010`\u001a\u00020+2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0002J\b\u0010a\u001a\u00020+H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/huachenjie/common/widget/ShadowFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignCenter", "", "alignEnd", "applyingPadding", "bgColor", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "cardBitmap", "Landroid/graphics/Bitmap;", "cardBitmapDirty", "clipPath", "Landroid/graphics/Path;", "clipToCorner", "contentPadB", "contentPadL", "contentPadR", "contentPadT", "cornerRadius", "", "insetB", "insetL", "insetR", "insetT", "shadowColor", "shadowDx", "shadowDy", "shadowRadius", "adjustMeasureSpec", "spec", "expand", "insetSum", "applyContentPadding", "", "dispatchDraw", com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a, "Landroid/graphics/Canvas;", "ensureCardBitmap", "expandHeight", "expandWidth", "getCardBounds", "out", "layoutChildren", "parentLeft", "parentTop", "parentRight", "parentBottom", "markCardBitmapDirty", "needsShadow", "onDetachedFromWindow", "onDraw", "onLayout", "changed", "left", com.ipd.dsp.internal.e1.f.l, "right", com.ipd.dsp.internal.e1.f.n, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", y6b.g, "oldw", "oldh", "parseStyle", "ta", "Landroid/content/res/TypedArray;", "recycleCardBitmap", "resolveContentPadding", "setBgColor", "color", "setClipToCorner", "clip", "setContentPadding", "padding", "setCornerRadius", "radius", "setPadding", "setPaddingRelative", "start", "end", "setShadow", "dx", "dy", "syncOutwardOffset", "updateContentPadding", "updateShadowInsets", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShadowFrameLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShadowFrameLayout.kt\ncom/huachenjie/common/widget/ShadowFrameLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,462:1\n1#2:463\n*E\n"})
public final class ShadowFrameLayout extends FrameLayout {
    private boolean alignCenter;
    private boolean alignEnd;
    private boolean applyingPadding;

    @ColorInt
    private int bgColor;

    @NotNull
    private final Paint bgPaint;

    @NotNull
    private final RectF bgRect;

    @Nullable
    private Bitmap cardBitmap;
    private boolean cardBitmapDirty;

    @NotNull
    private final Path clipPath;
    private boolean clipToCorner;
    private int contentPadB;
    private int contentPadL;
    private int contentPadR;
    private int contentPadT;
    private float cornerRadius;
    private int insetB;
    private int insetL;
    private int insetR;
    private int insetT;

    @ColorInt
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;
    private float shadowRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ShadowFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int adjustMeasureSpec(int spec, boolean expand, int insetSum) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (mode != Integer.MIN_VALUE) {
            return (mode == 1073741824 && !expand) ? View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(size - insetSum, 0), 1073741824) : spec;
        }
        return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(size - insetSum, 0), Integer.MIN_VALUE);
    }

    private final void applyContentPadding() {
        this.applyingPadding = true;
        super.setPadding(this.contentPadL, this.contentPadT, this.contentPadR, this.contentPadB);
        this.applyingPadding = false;
    }

    private final void ensureCardBitmap() {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = this.cardBitmap;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != width || bitmapCreateBitmap.getHeight() != height || bitmapCreateBitmap.isRecycled()) {
            if (bitmapCreateBitmap != null) {
                bitmapCreateBitmap.recycle();
            }
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.cardBitmap = bitmapCreateBitmap;
            this.cardBitmapDirty = true;
        }
        if (this.cardBitmapDirty) {
            bitmapCreateBitmap.eraseColor(0);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            int i = this.insetL;
            int i2 = this.insetR;
            if (width > i + i2) {
                int i3 = this.insetT;
                int i4 = this.insetB;
                if (height > i3 + i4) {
                    this.bgRect.set(i, i3, width - i2, height - i4);
                    this.bgPaint.setColor(this.bgColor);
                    if (!needsShadow() || isInEditMode()) {
                        this.bgPaint.clearShadowLayer();
                    } else {
                        this.bgPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
                    }
                    RectF rectF = this.bgRect;
                    float f = this.cornerRadius;
                    canvas.drawRoundRect(rectF, f, f, this.bgPaint);
                    this.bgPaint.clearShadowLayer();
                }
            }
            this.cardBitmapDirty = false;
        }
    }

    private final boolean expandHeight() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        return layoutParams == null || layoutParams.height != -1;
    }

    private final boolean expandWidth() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        return layoutParams == null || layoutParams.width != -1;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    private final void layoutChildren(int parentLeft, int parentTop, int parentRight, int parentBottom) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = parentRight - parentLeft;
        int i8 = parentBottom - parentTop;
        int layoutDirection = getLayoutDirection();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = layoutParams2.gravity;
                if (i10 == -1) {
                    i10 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i10, layoutDirection);
                int i11 = i10 & 112;
                int i12 = absoluteGravity & 7;
                if (i12 != 1) {
                    if (i12 != 5) {
                        i3 = layoutParams2.leftMargin + parentLeft;
                    } else {
                        i = parentRight - measuredWidth;
                        i2 = layoutParams2.rightMargin;
                    }
                    if (i11 != 16) {
                        if (i11 != 80) {
                            i6 = layoutParams2.topMargin + parentTop;
                        } else {
                            i4 = parentBottom - measuredHeight;
                            i5 = layoutParams2.bottomMargin;
                        }
                        childAt.layout(i3, i6, measuredWidth + i3, measuredHeight + i6);
                    } else {
                        i4 = ((i8 - measuredHeight) / 2) + parentTop + layoutParams2.topMargin;
                        i5 = layoutParams2.bottomMargin;
                    }
                    i6 = i4 - i5;
                    childAt.layout(i3, i6, measuredWidth + i3, measuredHeight + i6);
                } else {
                    i = ((i7 - measuredWidth) / 2) + parentLeft + layoutParams2.leftMargin;
                    i2 = layoutParams2.rightMargin;
                }
                i3 = i - i2;
                if (i11 != 16) {
                    if (i11 != 80) {
                        i6 = layoutParams2.topMargin + parentTop;
                    } else {
                        i4 = parentBottom - measuredHeight;
                        i5 = layoutParams2.bottomMargin;
                    }
                    childAt.layout(i3, i6, measuredWidth + i3, measuredHeight + i6);
                } else {
                    i4 = ((i8 - measuredHeight) / 2) + parentTop + layoutParams2.topMargin;
                    i5 = layoutParams2.bottomMargin;
                }
                i6 = i4 - i5;
                childAt.layout(i3, i6, measuredWidth + i3, measuredHeight + i6);
            }
        }
    }

    private final void markCardBitmapDirty() {
        this.cardBitmapDirty = true;
    }

    private final boolean needsShadow() {
        return this.shadowRadius > 0.0f && Color.alpha(this.shadowColor) > 0;
    }

    private final void parseStyle(TypedArray ta) {
        this.bgColor = ta.getColor(R.styleable.ShadowFrameLayout_sfl_bgColor, -1);
        this.cornerRadius = RangesKt.coerceAtLeast(ta.getDimension(R.styleable.ShadowFrameLayout_sfl_cornerRadius, 0.0f), 0.0f);
        this.shadowColor = ta.getColor(R.styleable.ShadowFrameLayout_sfl_shadowColor, 0);
        this.shadowRadius = RangesKt.coerceAtLeast(ta.getDimension(R.styleable.ShadowFrameLayout_sfl_shadowRadius, 0.0f), 0.0f);
        this.shadowDx = ta.getDimension(R.styleable.ShadowFrameLayout_sfl_shadowDx, 0.0f);
        this.shadowDy = ta.getDimension(R.styleable.ShadowFrameLayout_sfl_shadowDy, 0.0f);
        this.clipToCorner = ta.getBoolean(R.styleable.ShadowFrameLayout_sfl_clipToCorner, true);
        this.alignEnd = ta.getBoolean(R.styleable.ShadowFrameLayout_sfl_alignEnd, false);
        this.alignCenter = ta.getBoolean(R.styleable.ShadowFrameLayout_sfl_alignCenter, false);
        resolveContentPadding(ta);
    }

    private final void recycleCardBitmap() {
        Bitmap bitmap = this.cardBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.cardBitmap = null;
        this.cardBitmapDirty = true;
    }

    private final void resolveContentPadding(TypedArray ta) {
        this.contentPadL = getPaddingLeft();
        this.contentPadT = getPaddingTop();
        this.contentPadR = getPaddingRight();
        this.contentPadB = getPaddingBottom();
        int i = R.styleable.ShadowFrameLayout_sfl_contentPadding;
        if (ta.hasValue(i) || ta.hasValue(R.styleable.ShadowFrameLayout_sfl_contentPaddingLeft) || ta.hasValue(R.styleable.ShadowFrameLayout_sfl_contentPaddingTop) || ta.hasValue(R.styleable.ShadowFrameLayout_sfl_contentPaddingRight) || ta.hasValue(R.styleable.ShadowFrameLayout_sfl_contentPaddingBottom)) {
            int dimensionPixelSize = ta.getDimensionPixelSize(i, 0);
            this.contentPadL = ta.getDimensionPixelSize(R.styleable.ShadowFrameLayout_sfl_contentPaddingLeft, dimensionPixelSize);
            this.contentPadT = ta.getDimensionPixelSize(R.styleable.ShadowFrameLayout_sfl_contentPaddingTop, dimensionPixelSize);
            this.contentPadR = ta.getDimensionPixelSize(R.styleable.ShadowFrameLayout_sfl_contentPaddingRight, dimensionPixelSize);
            this.contentPadB = ta.getDimensionPixelSize(R.styleable.ShadowFrameLayout_sfl_contentPaddingBottom, dimensionPixelSize);
        }
    }

    private final void syncOutwardOffset() {
        float f;
        if (!expandWidth()) {
            f = 0.0f;
        } else if (this.alignCenter) {
            f = (this.insetR - this.insetL) / 2.0f;
        } else {
            f = this.alignEnd ? this.insetR : -this.insetL;
        }
        setTranslationX(f);
        setTranslationY(expandHeight() ? -this.insetT : 0.0f);
    }

    private final void updateContentPadding(int left, int top, int right, int bottom) {
        if (this.contentPadL == left && this.contentPadT == top && this.contentPadR == right && this.contentPadB == bottom) {
            return;
        }
        this.contentPadL = left;
        this.contentPadT = top;
        this.contentPadR = right;
        this.contentPadB = bottom;
        applyContentPadding();
        requestLayout();
    }

    private final void updateShadowInsets() {
        if (needsShadow()) {
            this.insetL = (int) Math.ceil(Math.max(0.0f, this.shadowRadius - this.shadowDx));
            this.insetT = (int) Math.ceil(Math.max(0.0f, this.shadowRadius - this.shadowDy));
            this.insetR = (int) Math.ceil(Math.max(0.0f, this.shadowRadius + this.shadowDx));
            this.insetB = (int) Math.ceil(Math.max(0.0f, this.shadowRadius + this.shadowDy));
            return;
        }
        this.insetL = 0;
        this.insetT = 0;
        this.insetR = 0;
        this.insetB = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a);
        if (!this.clipToCorner || this.cornerRadius <= 0.0f || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        this.bgRect.set(this.insetL, this.insetT, getWidth() - this.insetR, getHeight() - this.insetB);
        this.clipPath.reset();
        Path path = this.clipPath;
        RectF rectF = this.bgRect;
        float f = this.cornerRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        int iSave = canvas.save();
        canvas.clipPath(this.clipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public final void getCardBounds(@NotNull RectF out) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.set(this.insetL, this.insetT, getWidth() - this.insetR, getHeight() - this.insetB);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        recycleCardBitmap();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, com.alibaba.triver.triver_render.view.canvas.tinyapp.b.f25229a);
        ensureCardBitmap();
        Bitmap bitmap = this.cardBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        layoutChildren(this.insetL + this.contentPadL, this.insetT + this.contentPadT, (getWidth() - this.insetR) - this.contentPadR, (getHeight() - this.insetB) - this.contentPadB);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        int size2;
        boolean zExpandWidth = expandWidth();
        boolean zExpandHeight = expandHeight();
        super.onMeasure(adjustMeasureSpec(widthMeasureSpec, zExpandWidth, this.insetL + this.insetR), adjustMeasureSpec(heightMeasureSpec, zExpandHeight, this.insetT + this.insetB));
        if (!zExpandWidth && View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        } else {
            int measuredWidth = getMeasuredWidth() + this.insetL;
            int i = this.insetR;
            size = measuredWidth + i;
        }
        if (!zExpandHeight && View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        } else {
            int measuredHeight = getMeasuredHeight() + this.insetT;
            int i2 = this.insetB;
            size2 = measuredHeight + i2;
        }
        setMeasuredDimension(size, size2);
        syncOutwardOffset();
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        markCardBitmapDirty();
    }

    public final void setBgColor(@ColorInt int color) {
        if (this.bgColor == color) {
            return;
        }
        this.bgColor = color;
        markCardBitmapDirty();
        invalidate();
    }

    public final void setClipToCorner(boolean clip) {
        if (this.clipToCorner == clip) {
            return;
        }
        this.clipToCorner = clip;
        invalidate();
    }

    public final void setContentPadding(@Px int left, @Px int top, @Px int right, @Px int bottom) {
        updateContentPadding(left, top, right, bottom);
    }

    public final void setCornerRadius(float radius) {
        float fCoerceAtLeast = RangesKt.coerceAtLeast(radius, 0.0f);
        if (this.cornerRadius == fCoerceAtLeast) {
            return;
        }
        this.cornerRadius = fCoerceAtLeast;
        markCardBitmapDirty();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        if (this.applyingPadding) {
            super.setPadding(left, top, right, bottom);
        } else {
            updateContentPadding(left, top, right, bottom);
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        if (this.applyingPadding) {
            super.setPaddingRelative(start, top, end, bottom);
        } else if (getLayoutDirection() == 1) {
            updateContentPadding(end, top, start, bottom);
        } else {
            updateContentPadding(start, top, end, bottom);
        }
    }

    public final void setShadow(@ColorInt int color, float radius, float dx, float dy) {
        float fCoerceAtLeast = RangesKt.coerceAtLeast(radius, 0.0f);
        if (this.shadowColor == color) {
            if (this.shadowRadius == fCoerceAtLeast) {
                if (this.shadowDx == dx) {
                    if (this.shadowDy == dy) {
                        return;
                    }
                }
            }
        }
        this.shadowColor = color;
        this.shadowRadius = fCoerceAtLeast;
        this.shadowDx = dx;
        this.shadowDy = dy;
        updateShadowInsets();
        markCardBitmapDirty();
        syncOutwardOffset();
        requestLayout();
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.bgPaint = paint;
        this.bgRect = new RectF();
        this.clipPath = new Path();
        this.bgColor = -1;
        this.clipToCorner = true;
        this.cardBitmapDirty = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowFrameLayout, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eLayout, defStyleAttr, 0)");
        try {
            parseStyle(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            setWillNotDraw(false);
            setLayerType(0, null);
            updateShadowInsets();
            applyContentPadding();
            syncOutwardOffset();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setContentPadding(@Px int padding) {
        updateContentPadding(padding, padding, padding, padding);
    }
}
