package com.huachenjie.base.view.slide;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.huachenjie.base.R;
import com.kuaishou.weapon.p0.t;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 V2\u00020\u0001:\u0001\u0015B\u0013\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bO\u0010PB\u001d\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bO\u0010QB%\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010R\u001a\u00020\u0002¢\u0006\u0004\bO\u0010SB-\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010R\u001a\u00020\u0002\u0012\u0006\u0010T\u001a\u00020\u0002¢\u0006\u0004\bO\u0010UJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR6\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190 8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010)R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010+R\u001b\u00106\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\b4\u00105R\u001b\u00108\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\b7\u00105R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010:R\u0016\u0010<\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010>\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010=R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010=R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010=R\u001b\u0010D\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\bB\u0010CR\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\bE\u0010CR\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010+R\u001b\u0010L\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00103\u001a\u0004\bJ\u0010K¨\u0006W"}, d2 = {"Lcom/huachenjie/base/view/slide/LetterSideBarView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", b.f25229a, "onDraw", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "Landroid/util/AttributeSet;", "attrs", "c", "", "eventY", "b", t.q, "a", RVParams.SHOW_PROGRESS, "d", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "getSelectIndexCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectIndexCallback", "(Lkotlin/jvm/functions/Function1;)V", "selectIndexCallback", "", "value", "[Ljava/lang/String;", "getIndexItems", "()[Ljava/lang/String;", "setIndexItems", "([Ljava/lang/String;)V", "indexItems", "K", "I", "mCurrentIndex", "F", "mCurrentY", "L", "mTextColor", "mTextSize", "M", "mTipTextColor", "mTipsSize", "Lkotlin/Lazy;", "getMIndexItemHeight", "()F", "mIndexItemHeight", "getMBarHeight", "mBarHeight", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mTouchingArea", "mBarWidth", "Z", "mStartTouching", "mIsMoved", "mIsShowCenterTips", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "getMHintPaint", "mHintPaint", "e", "mFirstItemBaseLineY", "Landroid/util/DisplayMetrics;", "getMDisplayMetrics", "()Landroid/util/DisplayMetrics;", "mDisplayMetrics", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "base_release"}, k = 1, mv = {1, 8, 0})
public final class LetterSideBarView extends View {
    public static final int N = 14;
    public static final int O = 28;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int mCurrentIndex;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int mTextColor;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public int mTipTextColor;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float mCurrentY;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RectF mTouchingArea;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mIndexItemHeight;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function1<? super String, Unit> selectIndexCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean mStartTouching;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String[] indexItems;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public float mTextSize;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mBarHeight;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean mIsMoved;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float mTipsSize;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mPaint;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean mIsShowCenterTips;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public float mBarWidth;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mHintPaint;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public float mFirstItemBaseLineY;

    /* JADX INFO: renamed from: e, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mDisplayMetrics;

    @NotNull
    public static final String[] b = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public LetterSideBarView(@Nullable Context context) {
        this(context, null);
    }

    private final float getMBarHeight() {
        return ((Number) this.mBarHeight.getValue()).floatValue();
    }

    private final DisplayMetrics getMDisplayMetrics() {
        Object value = this.mDisplayMetrics.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDisplayMetrics>(...)");
        return (DisplayMetrics) value;
    }

    private final Paint getMHintPaint() {
        return (Paint) this.mHintPaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMIndexItemHeight() {
        return ((Number) this.mIndexItemHeight.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint getMPaint() {
        return (Paint) this.mPaint.getValue();
    }

    public final float a(int dp) {
        return TypedValue.applyDimension(1, dp, getMDisplayMetrics());
    }

    public final int b(float eventY) {
        float paddingTop = eventY - getPaddingTop();
        this.mCurrentY = paddingTop;
        if (paddingTop <= 0.0f) {
            return 0;
        }
        int mIndexItemHeight = (int) (paddingTop / getMIndexItemHeight());
        String[] strArr = this.indexItems;
        if (mIndexItemHeight >= strArr.length) {
            mIndexItemHeight = strArr.length - 1;
        }
        if (mIndexItemHeight < 0) {
            return 0;
        }
        return mIndexItemHeight;
    }

    public final void c(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.LetterSideBarView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…leable.LetterSideBarView)");
        int i = R.styleable.LetterSideBarView_show_center_tips;
        this.mIsShowCenterTips = typedArrayObtainStyledAttributes.getBoolean(i, true);
        this.mTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.LetterSideBarView_sidebar_text_color, -7829368);
        this.mTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.LetterSideBarView_sidebar_text_size, d(14));
        this.mIsShowCenterTips = typedArrayObtainStyledAttributes.getBoolean(i, false);
        this.mTipTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.LetterSideBarView_tips_text_color, -7829368);
        this.mTipsSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.LetterSideBarView_tips_text_size, d(28));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final float d(int sp) {
        return TypedValue.applyDimension(2, sp, getMDisplayMetrics());
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float y = event.getY();
        float x = event.getX();
        this.mCurrentIndex = b(y);
        int action = event.getAction();
        if (action == 0) {
            if (!this.mTouchingArea.contains(x, y)) {
                this.mIsMoved = false;
                return false;
            }
            this.mStartTouching = true;
            Function1<? super String, Unit> function1 = this.selectIndexCallback;
            if (function1 != null) {
                function1.invoke(this.indexItems[this.mCurrentIndex]);
            }
            this.mIsMoved = true;
            invalidate();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                Function1<? super String, Unit> function2 = this.selectIndexCallback;
                if (function2 != null) {
                    function2.invoke(this.indexItems[this.mCurrentIndex]);
                }
                this.mIsMoved = true;
                invalidate();
                return true;
            }
            if (action != 3) {
                return super.onTouchEvent(event);
            }
        }
        Function1<? super String, Unit> function3 = this.selectIndexCallback;
        if (function3 != null) {
            function3.invoke(this.indexItems[this.mCurrentIndex]);
        }
        this.mStartTouching = false;
        this.mIsMoved = false;
        invalidate();
        return true;
    }

    @NotNull
    public final String[] getIndexItems() {
        return this.indexItems;
    }

    @Nullable
    public final Function1<String, Unit> getSelectIndexCallback() {
        return this.selectIndexCallback;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        super.onDraw(canvas);
        int length = this.indexItems.length;
        for (int i = 0; i < length; i++) {
            canvas.drawText(this.indexItems[i], (getWidth() - getPaddingRight()) - (this.mBarWidth / 2), this.mFirstItemBaseLineY + (getMIndexItemHeight() * i), getMPaint());
        }
        if (this.mIsMoved && this.mIsShowCenterTips) {
            canvas.drawText(this.indexItems[this.mCurrentIndex], getWidth() / 2, getHeight() / 2, getMHintPaint());
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View.MeasureSpec.getSize(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Paint.FontMetrics fontMetrics = getMPaint().getFontMetrics();
        for (String str : this.indexItems) {
            this.mBarWidth = Math.max(this.mBarWidth, (getMPaint().measureText(str) * 2) + a(4));
        }
        float f = size;
        float paddingRight = (f - this.mBarWidth) - getPaddingRight();
        float paddingTop = getPaddingTop();
        this.mTouchingArea.set(paddingRight, paddingTop, f, getMBarHeight() + paddingTop);
        float paddingTop2 = getPaddingTop();
        float f2 = 2;
        float mIndexItemHeight = getMIndexItemHeight() / f2;
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        this.mFirstItemBaseLineY = (paddingTop2 + (mIndexItemHeight - ((f3 - f4) / f2))) - f4;
    }

    public final void setIndexItems(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "value");
        this.indexItems = strArr;
        requestLayout();
    }

    public final void setSelectIndexCallback(@Nullable Function1<? super String, Unit> function1) {
        this.selectIndexCallback = function1;
    }

    public LetterSideBarView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public LetterSideBarView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public LetterSideBarView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.indexItems = b;
        this.mCurrentY = -1.0f;
        this.mTextColor = -16777216;
        this.mTipTextColor = -16777216;
        this.mIndexItemHeight = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.base.view.slide.LetterSideBarView$mIndexItemHeight$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m232invoke() {
                Paint.FontMetrics fontMetrics = this.this$0.getMPaint().getFontMetrics();
                return Float.valueOf((fontMetrics.bottom - fontMetrics.top) + this.this$0.a(4));
            }
        });
        this.mBarHeight = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.base.view.slide.LetterSideBarView$mBarHeight$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m229invoke() {
                return Float.valueOf(this.this$0.getIndexItems().length * this.this$0.getMIndexItemHeight());
            }
        });
        this.mTouchingArea = new RectF();
        this.mPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.base.view.slide.LetterSideBarView$mPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m233invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFakeBoldText(true);
                paint.setColor(this.this$0.mTextColor);
                paint.setTextSize(this.this$0.mTextSize);
                paint.setTextAlign(Paint.Align.CENTER);
                return paint;
            }
        });
        this.mHintPaint = LazyKt.lazy(new Function0<Paint>() { // from class: com.huachenjie.base.view.slide.LetterSideBarView$mHintPaint$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Paint m231invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFakeBoldText(true);
                paint.setColor(this.this$0.mTipTextColor);
                paint.setTextSize(this.this$0.mTipsSize);
                paint.setTextAlign(Paint.Align.CENTER);
                return paint;
            }
        });
        this.mDisplayMetrics = LazyKt.lazy(new Function0<DisplayMetrics>() { // from class: com.huachenjie.base.view.slide.LetterSideBarView$mDisplayMetrics$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final DisplayMetrics m230invoke() {
                return this.this$0.getContext().getResources().getDisplayMetrics();
            }
        });
        c(attributeSet);
    }
}
