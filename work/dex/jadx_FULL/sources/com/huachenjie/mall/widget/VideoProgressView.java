package com.huachenjie.mall.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coroutines.BindingAdapter;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.huachenjie.mall.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u0001\u000fB\u0013\b\u0016\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,B\u001d\b\u0016\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b+\u0010-B%\b\u0016\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b+\u0010/J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR#\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010%R#\u0010(\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b'\u0010%¨\u00061"}, d2 = {"Lcom/huachenjie/mall/widget/VideoProgressView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", b.f25229a, "onDraw", "", "progress", "setProgress", "Landroid/util/AttributeSet;", "attrs", "a", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mOval", "F", "mRadius", "b", "mProgress", "c", "mMaxProgress", "K", "I", "bgColor", "L", "progressColor", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getStartBitmap", "()Landroid/graphics/Bitmap;", "startBitmap", "getFinishBitmap", "finishBitmap", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class VideoProgressView extends View {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int bgColor;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int progressColor;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float mRadius;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public Paint mPaint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public RectF mOval;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy startBitmap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float mProgress;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy finishBitmap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float mMaxProgress;

    /* JADX INFO: renamed from: com.huachenjie.mall.widget.VideoProgressView$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/widget/VideoProgressView$a;", "", "Lcom/huachenjie/mall/widget/VideoProgressView;", "view", "", "progressRate", "", "a", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @BindingAdapter({"videoProgress"})
        @JvmStatic
        public final void a(@NotNull VideoProgressView view, int progressRate) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.setProgress(progressRate);
        }
    }

    public VideoProgressView(@Nullable Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mOval = new RectF();
        this.mMaxProgress = 100.0f;
        this.bgColor = -16777216;
        this.progressColor = -16776961;
        this.startBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$startBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m587invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_start);
            }
        });
        this.finishBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$finishBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m586invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_finish);
            }
        });
    }

    private final Bitmap getFinishBitmap() {
        return (Bitmap) this.finishBitmap.getValue();
    }

    private final Bitmap getStartBitmap() {
        return (Bitmap) this.startBitmap.getValue();
    }

    @BindingAdapter({"videoProgress"})
    @JvmStatic
    public static final void setVideoProgress(@NotNull VideoProgressView videoProgressView, int i) {
        INSTANCE.a(videoProgressView, i);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MallVideoProgressView);
        this.bgColor = typedArrayObtainStyledAttributes.getColor(R.styleable.MallVideoProgressView_mall_bg_color, -16777216);
        this.progressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.MallVideoProgressView_mall_progress_color, -16776961);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.bgColor);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        super.onDraw(canvas);
        float f = this.mProgress;
        if (f == 0.0f) {
            canvas.drawBitmap(getStartBitmap(), 0.0f, 0.0f, this.mPaint);
            return;
        }
        if (f == this.mMaxProgress) {
            canvas.drawBitmap(getFinishBitmap(), 0.0f, 0.0f, this.mPaint);
            return;
        }
        this.mPaint.setColor(this.bgColor);
        float f2 = this.mRadius;
        canvas.drawCircle(f2, f2, f2, this.mPaint);
        this.mPaint.setColor(this.progressColor);
        canvas.drawArc(this.mOval, -90.0f, 360 * (this.mProgress / this.mMaxProgress), true, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.mRadius = Math.min(measuredWidth, measuredHeight) / 2.0f;
        this.mOval.set(0.0f, 0.0f, measuredWidth, measuredHeight);
    }

    public final void setProgress(float progress) {
        boolean z = false;
        if (0.0f <= progress && progress <= this.mMaxProgress) {
            z = true;
        }
        if (z) {
            this.mProgress = progress;
            invalidate();
        }
    }

    public VideoProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mOval = new RectF();
        this.mMaxProgress = 100.0f;
        this.bgColor = -16777216;
        this.progressColor = -16776961;
        this.startBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$startBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m587invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_start);
            }
        });
        this.finishBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$finishBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m586invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_finish);
            }
        });
        a(attributeSet);
    }

    public VideoProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mOval = new RectF();
        this.mMaxProgress = 100.0f;
        this.bgColor = -16777216;
        this.progressColor = -16776961;
        this.startBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$startBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m587invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_start);
            }
        });
        this.finishBitmap = LazyKt.lazy(new Function0<Bitmap>() { // from class: com.huachenjie.mall.widget.VideoProgressView$finishBitmap$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Bitmap m586invoke() {
                return BitmapFactory.decodeResource(this.this$0.getResources(), R.drawable.mall_ic_video_progress_finish);
            }
        });
        a(attributeSet);
    }
}
