package com.kc.openset.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f39940a;
    private Paint b;
    private RectF c;
    private int[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private onProgressListener j;
    private Handler k;

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CircularProgressView f39941a;

        static {
            OSETSDKProtected.interface11(4923);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CircularProgressView circularProgressView, Looper looper) {
            super(looper);
            this.f39941a = circularProgressView;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    @Keep
    public interface onProgressListener {
        void onClose();

        void onTimerOver();
    }

    public CircularProgressView(Context context) {
        this(context, null);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 1;
        this.g = 0;
        this.k = new a(this, Looper.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSETCircularProgressView);
        Paint paint = new Paint();
        this.f39940a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f39940a.setStrokeCap(Paint.Cap.ROUND);
        this.f39940a.setAntiAlias(true);
        this.f39940a.setDither(true);
        this.f39940a.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R.styleable.OSETCircularProgressView_OSETbackWidth, 5.0f));
        this.f39940a.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.OSETCircularProgressView_OSETbackColor, -3355444));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R.styleable.OSETCircularProgressView_OSETprogWidth, 10.0f));
        this.b.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.OSETCircularProgressView_OSETprogColor, -16776961));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.OSETCircularProgressView_OSETprogStartColor, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.OSETCircularProgressView_OSETprogFirstColor, -1);
        if (color == -1 || color2 == -1) {
            this.d = null;
        } else {
            this.d = new int[]{color, color2};
        }
        this.e = typedArrayObtainStyledAttributes.getInteger(R.styleable.OSETCircularProgressView_OSETprogress, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ int b(CircularProgressView circularProgressView) {
        int i = circularProgressView.f;
        circularProgressView.f = i + 1;
        return i;
    }

    public static /* synthetic */ int f(CircularProgressView circularProgressView) {
        int i = circularProgressView.g;
        circularProgressView.g = i + 1;
        return i;
    }

    public void a() {
        this.j = null;
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.k = null;
        }
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
        this.k.sendEmptyMessageDelayed(1, 1000L);
    }

    public int getCurrentProgress() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.c, 0.0f, 360.0f, false, this.f39940a);
        canvas.drawArc(this.c, 275.0f, (this.e * 360) / 10000, false, this.b);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int iMin = (int) (Math.min(measuredWidth, measuredHeight) - Math.max(this.f39940a.getStrokeWidth(), this.b.getStrokeWidth()));
        int paddingLeft = getPaddingLeft() + ((measuredWidth - iMin) / 2);
        int paddingTop = getPaddingTop() + ((measuredHeight - iMin) / 2);
        this.c = new RectF(paddingLeft, paddingTop, paddingLeft + iMin, paddingTop + iMin);
        int[] iArr = this.d;
        if (iArr == null || iArr.length <= 1) {
            return;
        }
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.d, (float[]) null, Shader.TileMode.MIRROR));
    }

    public void setBackColor(int i) {
        this.f39940a.setColor(ContextCompat.getColor(getContext(), i));
        invalidate();
    }

    public void setBackWidth(int i) {
        this.f39940a.setStrokeWidth(i);
        invalidate();
    }

    public void setCurrentProgress(int i) {
        this.e = i;
        invalidate();
    }

    public void setOnProgressListener(onProgressListener onprogresslistener) {
        this.j = onprogresslistener;
    }

    public void setProgColor(int i) {
        this.b.setColor(ContextCompat.getColor(getContext(), i));
        this.b.setShader(null);
        invalidate();
    }

    public void setProgColor(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        this.d = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.d[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.d, (float[]) null, Shader.TileMode.MIRROR));
        invalidate();
    }

    public void setProgWidth(int i) {
        this.b.setStrokeWidth(i);
        invalidate();
    }
}
