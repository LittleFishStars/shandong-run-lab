package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.interfaces.IPickerViewData;
import com.contrarywind.listener.OnItemSelectedListener;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.f94;
import com.zj.adlib.hm5;
import com.zj.adlib.v25;
import com.zj.adlib.wk8;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class WheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f29318a = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09"};
    public static final int e0 = 5;
    public static final float i = 0.8f;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f1487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f1490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f1491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f1492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GestureDetector f1493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WheelAdapter f1494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemSelectedListener f1495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DividerType f1496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScheduledExecutorService f1497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScheduledFuture<?> f1498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1499a;
    public int a0;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f1500b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1501b;
    public int b0;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Paint f1502c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1503c;
    public int c0;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1504d;
    public int d0;
    public float e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f1505f;
    public float g;
    public float h;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f1495a.a(WheelView.this.getCurrentItem());
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public final String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).a();
        }
        return obj instanceof Integer ? b(((Integer) obj).intValue()) : obj.toString();
    }

    public final String b(int i2) {
        return (i2 < 0 || i2 >= 10) ? String.valueOf(i2) : f29318a[i2];
    }

    public final int c(int i2) {
        if (i2 < 0) {
            return c(i2 + this.f1494a.a());
        }
        return i2 > this.f1494a.a() + (-1) ? c(i2 - this.f1494a.a()) : i2;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f1498a;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f1498a.cancel(true);
        this.f1498a = null;
    }

    public final void d(Context context) {
        this.f1489a = context;
        this.f1492a = new hm5(this);
        GestureDetector gestureDetector = new GestureDetector(context, new v25(this));
        this.f1493a = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f1503c = true;
        this.f = 0.0f;
        this.S = -1;
        e();
    }

    public final void e() {
        Paint paint = new Paint();
        this.f1490a = paint;
        paint.setColor(this.O);
        this.f1490a.setAntiAlias(true);
        this.f1490a.setTypeface(this.f1491a);
        this.f1490a.setTextSize(this.K);
        Paint paint2 = new Paint();
        this.f1500b = paint2;
        paint2.setColor(this.P);
        this.f1500b.setAntiAlias(true);
        this.f1500b.setTextScaleX(1.1f);
        this.f1500b.setTypeface(this.f1491a);
        this.f1500b.setTextSize(this.K);
        Paint paint3 = new Paint();
        this.f1502c = paint3;
        paint3.setColor(this.Q);
        this.f1502c.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void f() {
        float f = this.b;
        if (f < 1.0f) {
            this.b = 1.0f;
        } else if (f > 4.0f) {
            this.b = 4.0f;
        }
    }

    public final void g() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.f1494a.a(); i2++) {
            String strA = a(this.f1494a.getItem(i2));
            this.f1500b.getTextBounds(strA, 0, strA.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.L) {
                this.L = iWidth;
            }
        }
        this.f1500b.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.M = iHeight;
        this.f1487a = this.b * iHeight;
    }

    public final WheelAdapter getAdapter() {
        return this.f1494a;
    }

    public final int getCurrentItem() {
        int i2;
        WheelAdapter wheelAdapter = this.f1494a;
        if (wheelAdapter == null) {
            return 0;
        }
        return (!this.f1503c || ((i2 = this.T) >= 0 && i2 < wheelAdapter.a())) ? Math.max(0, Math.min(this.T, this.f1494a.a() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.T) - this.f1494a.a()), this.f1494a.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f1492a;
    }

    public int getInitPosition() {
        return this.S;
    }

    public float getItemHeight() {
        return this.f1487a;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.f1494a;
        if (wheelAdapter != null) {
            return wheelAdapter.a();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int iCeil = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCeil += (int) Math.ceil(fArr[i2]);
        }
        return iCeil;
    }

    public float getTotalScrollY() {
        return this.f;
    }

    public final void h(String str) {
        String str2;
        Rect rect = new Rect();
        this.f1500b.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.b0;
        if (i2 == 3) {
            this.c0 = 0;
            return;
        }
        if (i2 == 5) {
            this.c0 = (this.X - rect.width()) - ((int) this.h);
            return;
        }
        if (i2 != 17) {
            return;
        }
        if (this.f1499a || (str2 = this.f1505f) == null || str2.equals("") || !this.f1501b) {
            this.c0 = (int) (((double) (this.X - rect.width())) * 0.5d);
        } else {
            this.c0 = (int) (((double) (this.X - rect.width())) * 0.25d);
        }
    }

    public final void i(String str) {
        String str2;
        Rect rect = new Rect();
        this.f1490a.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.b0;
        if (i2 == 3) {
            this.d0 = 0;
            return;
        }
        if (i2 == 5) {
            this.d0 = (this.X - rect.width()) - ((int) this.h);
            return;
        }
        if (i2 != 17) {
            return;
        }
        if (this.f1499a || (str2 = this.f1505f) == null || str2.equals("") || !this.f1501b) {
            this.d0 = (int) (((double) (this.X - rect.width())) * 0.5d);
        } else {
            this.d0 = (int) (((double) (this.X - rect.width())) * 0.25d);
        }
    }

    public void isCenterLabel(boolean z) {
        this.f1501b = z;
    }

    public boolean isLoop() {
        return this.f1503c;
    }

    public final void j() {
        if (this.f1494a == null) {
            return;
        }
        g();
        int i2 = (int) (this.f1487a * (this.V - 1));
        this.W = (int) (((double) (i2 * 2)) / 3.141592653589793d);
        this.Y = (int) (((double) i2) / 3.141592653589793d);
        this.X = View.MeasureSpec.getSize(this.a0);
        int i3 = this.W;
        float f = this.f1487a;
        this.c = (i3 - f) / 2.0f;
        float f2 = (i3 + f) / 2.0f;
        this.d = f2;
        this.e = (f2 - ((f - this.M) / 2.0f)) - this.h;
        if (this.S == -1) {
            if (this.f1503c) {
                this.S = (this.f1494a.a() + 1) / 2;
            } else {
                this.S = 0;
            }
        }
        this.U = this.S;
    }

    public final void k(String str) {
        Rect rect = new Rect();
        this.f1500b.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.K;
        for (int iWidth = rect.width(); iWidth > this.X; iWidth = rect.width()) {
            i2--;
            this.f1500b.setTextSize(i2);
            this.f1500b.getTextBounds(str, 0, str.length(), rect);
        }
        this.f1490a.setTextSize(i2);
    }

    public final void l(float f, float f2) {
        int i2;
        int i3 = this.N;
        if (i3 > 0) {
            i2 = 1;
        } else {
            i2 = i3 < 0 ? -1 : 0;
        }
        this.f1490a.setTextSkewX(i2 * (f2 <= 0.0f ? 1 : -1) * 0.5f * f);
        this.f1490a.setAlpha(this.f1504d ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        int i2;
        Object item;
        boolean z;
        String strA;
        if (this.f1494a == null) {
            return;
        }
        boolean z2 = false;
        int iMin = Math.min(Math.max(0, this.S), this.f1494a.a() - 1);
        this.S = iMin;
        try {
            this.U = iMin + (((int) (this.f / this.f1487a)) % this.f1494a.a());
            while (true) {
                int i3 = this.V;
                if (i2 >= i3) {
                    return;
                }
                int i4 = this.U - ((i3 / 2) - i2);
                if (this.f1503c) {
                    item = this.f1494a.getItem(c(i4));
                } else {
                    item = "";
                    if (i4 >= 0 && i4 <= this.f1494a.a() - 1) {
                        item = this.f1494a.getItem(i4);
                    }
                }
                canvas.save();
                double d = ((this.f1487a * i2) - f) / this.Y;
                float f2 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f2 > 90.0f || f2 < -90.0f) {
                    z = z2;
                    canvas.restore();
                } else {
                    if (this.f1501b || TextUtils.isEmpty(this.f1505f) || TextUtils.isEmpty(a(item))) {
                        strA = a(item);
                    } else {
                        strA = a(item) + this.f1505f;
                    }
                    float fPow = (float) Math.pow(Math.abs(f2) / 90.0f, 2.2d);
                    k(strA);
                    h(strA);
                    i(strA);
                    float fCos = (float) ((((double) this.Y) - (Math.cos(d) * ((double) this.Y))) - ((Math.sin(d) * ((double) this.M)) / 2.0d));
                    canvas.translate(0.0f, fCos);
                    float f3 = this.c;
                    if (fCos > f3 || this.M + fCos < f3) {
                        float f4 = this.d;
                        if (fCos > f4 || this.M + fCos < f4) {
                            if (fCos >= f3) {
                                int i5 = this.M;
                                if (i5 + fCos <= f4) {
                                    canvas.drawText(strA, this.c0, i5 - this.h, this.f1500b);
                                    this.T = this.U - ((this.V / 2) - i2);
                                }
                                canvas.restore();
                                this.f1500b.setTextSize(this.K);
                            }
                            canvas.save();
                            z = false;
                            canvas.clipRect(0, 0, this.X, (int) this.f1487a);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            l(fPow, f2);
                            canvas.drawText(strA, this.d0 + (this.N * fPow), this.M, this.f1490a);
                            canvas.restore();
                            canvas.restore();
                            this.f1500b.setTextSize(this.K);
                        } else {
                            canvas.save();
                            canvas.clipRect(0.0f, 0.0f, this.X, this.d - fCos);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas.drawText(strA, this.c0, this.M - this.h, this.f1500b);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0.0f, this.d - fCos, this.X, (int) this.f1487a);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            l(fPow, f2);
                            canvas.drawText(strA, this.d0, this.M, this.f1490a);
                            canvas.restore();
                        }
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.X, this.c - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        l(fPow, f2);
                        canvas.drawText(strA, this.d0, this.M, this.f1490a);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.c - fCos, this.X, (int) this.f1487a);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(strA, this.c0, this.M - this.h, this.f1500b);
                        canvas.restore();
                    }
                    z = false;
                    canvas.restore();
                    this.f1500b.setTextSize(this.K);
                }
                i2++;
                z2 = z;
                f = f;
            }
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.f1503c) {
            if (this.U < 0) {
                this.U = this.f1494a.a() + this.U;
            }
            if (this.U > this.f1494a.a() - 1) {
                this.U -= this.f1494a.a();
            }
        } else {
            if (this.U < 0) {
                this.U = 0;
            }
            if (this.U > this.f1494a.a() - 1) {
                this.U = this.f1494a.a() - 1;
            }
        }
        f = this.f % this.f1487a;
        DividerType dividerType = this.f1496a;
        if (dividerType == DividerType.WRAP) {
            float f5 = (TextUtils.isEmpty(this.f1505f) ? (this.X - this.L) / 2 : (this.X - this.L) / 4) - 12;
            float f6 = f5 <= 0.0f ? 10.0f : f5;
            float f7 = this.X - f6;
            float f8 = this.c;
            float f9 = f6;
            canvas.drawLine(f9, f8, f7, f8, this.f1502c);
            float f10 = this.d;
            canvas.drawLine(f9, f10, f7, f10, this.f1502c);
        } else if (dividerType == DividerType.CIRCLE) {
            this.f1502c.setStyle(Paint.Style.STROKE);
            this.f1502c.setStrokeWidth(this.R);
            float f11 = (TextUtils.isEmpty(this.f1505f) ? (this.X - this.L) / 2.0f : (this.X - this.L) / 4.0f) - 12.0f;
            float f12 = f11 > 0.0f ? f11 : 10.0f;
            canvas.drawCircle(this.X / 2.0f, this.W / 2.0f, Math.max((this.X - f12) - f12, this.f1487a) / 1.8f, this.f1502c);
        } else {
            float f13 = this.c;
            canvas.drawLine(0.0f, f13, this.X, f13, this.f1502c);
            float f14 = this.d;
            canvas.drawLine(0.0f, f14, this.X, f14, this.f1502c);
        }
        if (!TextUtils.isEmpty(this.f1505f) && this.f1501b) {
            canvas.drawText(this.f1505f, (this.X - getTextWidth(this.f1500b, this.f1505f)) - this.h, this.e, this.f1500b);
        }
        i2 = 0;
    }

    public final void onItemSelected() {
        if (this.f1495a != null) {
            postDelayed(new a(), 200L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.a0 = i2;
        j();
        setMeasuredDimension(this.X, this.W);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f1493a.onTouchEvent(motionEvent);
        float f = (-this.S) * this.f1487a;
        float fA = ((this.f1494a.a() - 1) - this.S) * this.f1487a;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f1488a = System.currentTimeMillis();
            cancelFuture();
            this.g = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.g - motionEvent.getRawY();
            this.g = motionEvent.getRawY();
            float f2 = this.f + rawY;
            this.f = f2;
            if (!this.f1503c) {
                float f3 = this.f1487a;
                if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > fA && rawY > 0.0f)) {
                    this.f = f2 - rawY;
                    z = true;
                }
            }
        } else if (!zOnTouchEvent) {
            float y = motionEvent.getY();
            int i2 = this.Y;
            double dAcos = Math.acos((i2 - y) / i2) * ((double) this.Y);
            float f4 = this.f1487a;
            this.Z = (int) (((((int) ((dAcos + ((double) (f4 / 2.0f))) / ((double) f4))) - (this.V / 2)) * f4) - (((this.f % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.f1488a > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.f1498a = this.f1497a.scheduleWithFixedDelay(new f94(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.f1494a = wheelAdapter;
        j();
        invalidate();
    }

    public void setAlphaGradient(boolean z) {
        this.f1504d = z;
    }

    public final void setCurrentItem(int i2) {
        this.T = i2;
        this.S = i2;
        this.f = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.f1503c = z;
    }

    public void setDividerColor(int i2) {
        this.Q = i2;
        this.f1502c.setColor(i2);
    }

    public void setDividerType(DividerType dividerType) {
        this.f1496a = dividerType;
    }

    public void setDividerWidth(int i2) {
        this.R = i2;
        this.f1502c.setStrokeWidth(i2);
    }

    public void setGravity(int i2) {
        this.b0 = i2;
    }

    public void setIsOptions(boolean z) {
        this.f1499a = z;
    }

    public void setItemsVisibleCount(int i2) {
        if (i2 % 2 == 0) {
            i2++;
        }
        this.V = i2 + 2;
    }

    public void setLabel(String str) {
        this.f1505f = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.b = f;
            f();
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f1495a = onItemSelectedListener;
    }

    public void setTextColorCenter(int i2) {
        this.P = i2;
        this.f1500b.setColor(i2);
    }

    public void setTextColorOut(int i2) {
        this.O = i2;
        this.f1490a.setColor(i2);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i2 = (int) (this.f1489a.getResources().getDisplayMetrics().density * f);
            this.K = i2;
            this.f1490a.setTextSize(i2);
            this.f1500b.setTextSize(this.K);
        }
    }

    public void setTextXOffset(int i2) {
        this.N = i2;
        if (i2 != 0) {
            this.f1500b.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.f = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.f1491a = typeface;
        this.f1490a.setTypeface(typeface);
        this.f1500b.setTypeface(this.f1491a);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f;
            float f2 = this.f1487a;
            int i2 = (int) (((f % f2) + f2) % f2);
            this.Z = i2;
            if (i2 > f2 / 2.0f) {
                this.Z = (int) (f2 - i2);
            } else {
                this.Z = -i2;
            }
        }
        this.f1498a = this.f1497a.scheduleWithFixedDelay(new wk8(this, this.Z), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1499a = false;
        this.f1501b = true;
        this.f1497a = Executors.newSingleThreadScheduledExecutor();
        this.f1491a = Typeface.MONOSPACE;
        this.b = 1.6f;
        this.V = 11;
        this.Z = 0;
        this.g = 0.0f;
        this.f1488a = 0L;
        this.b0 = 17;
        this.c0 = 0;
        this.d0 = 0;
        this.f1504d = false;
        this.K = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.h = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.h = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.h = 6.0f;
        } else if (f >= 3.0f) {
            this.h = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.b0 = typedArrayObtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.O = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.P = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.Q = typedArrayObtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pickerview_wheelview_dividerWidth, 2);
            this.K = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.K);
            this.b = typedArrayObtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.b);
            typedArrayObtainStyledAttributes.recycle();
        }
        f();
        d(context);
    }
}
