package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DefaultTimeBar extends View implements TimeBar {
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    public static final int W = -50;
    public static final int X = 3;
    public static final int Y = 20;
    public static final float c = 1.0f;
    public static final float d = 0.0f;
    public static final long f = 1000;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f4729f = "android.widget.SeekBar";
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public int T;
    public int U;
    public int V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f31057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f4731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Point f4733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Drawable f4735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f4737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Formatter f4738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArraySet<TimeBar.OnScrubListener> f4739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public long[] f4741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public boolean[] f4742a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f4743b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f4744b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4745b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4746b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f4747c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f4748c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Rect f4749c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f4750d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Paint f4751d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Rect f4752d;
    public long e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final Paint f4753e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public Rect f4754e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final Paint f4755f;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public static int c(float f2, int i) {
        return (int) ((i * f2) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        q(false);
    }

    private long getPositionIncrement() {
        long j = this.f4730a;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.f4747c;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / ((long) this.T);
    }

    private String getProgressText() {
        return gj9.s0(this.f4737a, this.f4738a, this.f4750d);
    }

    private long getScrubberPosition() {
        if (this.f4745b.width() <= 0 || this.f4747c == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.f4752d.width()) * this.f4747c) / ((long) this.f4745b.width());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f4734a);
    }

    public static int j(float f2, int i) {
        return (int) (i / f2);
    }

    public static boolean n(Drawable drawable, int i) {
        return gj9.f41922a >= 23 && drawable.setLayoutDirection(i);
    }

    private void update() {
        this.f4749c.set(this.f4745b);
        this.f4752d.set(this.f4745b);
        long j = this.f4746b ? this.f4743b : this.f4750d;
        if (this.f4747c > 0) {
            int iWidth = (int) ((((long) this.f4745b.width()) * this.e) / this.f4747c);
            Rect rect = this.f4749c;
            Rect rect2 = this.f4745b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f4745b.width()) * j) / this.f4747c);
            Rect rect3 = this.f4752d;
            Rect rect4 = this.f4745b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f4749c;
            int i = this.f4745b.left;
            rect5.right = i;
            this.f4752d.right = i;
        }
        invalidate(this.f4734a);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        sb0.g(onScrubListener);
        this.f4739a.add(onScrubListener);
    }

    public final void d(Canvas canvas) {
        int i;
        if (this.f4747c <= 0) {
            return;
        }
        Rect rect = this.f4752d;
        int iS = gj9.s(rect.right, rect.left, this.f4745b.right);
        int iCenterY = this.f4752d.centerY();
        Drawable drawable = this.f4735a;
        if (drawable == null) {
            if (this.f4746b || isFocused()) {
                i = this.Q;
            } else {
                i = isEnabled() ? this.O : this.P;
            }
            canvas.drawCircle(iS, iCenterY, (int) ((i * this.b) / 2.0f), this.f4755f);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.b)) / 2;
        int intrinsicHeight = ((int) (this.f4735a.getIntrinsicHeight() * this.b)) / 2;
        this.f4735a.setBounds(iS - intrinsicWidth, iCenterY - intrinsicHeight, iS + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f4735a.draw(canvas);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r();
    }

    public final void e(Canvas canvas) {
        int iHeight = this.f4745b.height();
        int iCenterY = this.f4745b.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.f4747c <= 0) {
            Rect rect = this.f4745b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.f4748c);
            return;
        }
        Rect rect2 = this.f4749c;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int iMax = Math.max(Math.max(this.f4745b.left, i3), this.f4752d.right);
        int i4 = this.f4745b.right;
        if (iMax < i4) {
            canvas.drawRect(iMax, iCenterY, i4, i, this.f4748c);
        }
        int iMax2 = Math.max(i2, this.f4752d.right);
        if (i3 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i3, i, this.f4744b);
        }
        if (this.f4752d.width() > 0) {
            Rect rect3 = this.f4752d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.f4732a);
        }
        if (this.V == 0) {
            return;
        }
        long[] jArr = (long[]) sb0.g(this.f4741a);
        boolean[] zArr = (boolean[]) sb0.g(this.f4742a);
        int i5 = this.N / 2;
        for (int i6 = 0; i6 < this.V; i6++) {
            int iWidth = ((int) ((((long) this.f4745b.width()) * gj9.t(jArr[i6], 0L, this.f4747c)) / this.f4747c)) - i5;
            Rect rect4 = this.f4745b;
            int iMin = rect4.left + Math.min(rect4.width() - this.N, Math.max(0, iWidth));
            canvas.drawRect(iMin, iCenterY, iMin + this.N, i, zArr[i6] ? this.f4753e : this.f4751d);
        }
    }

    public final boolean f(float f2, float f3) {
        return this.f4734a.contains((int) f2, (int) f3);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int iJ = j(this.f31057a, this.f4745b.width());
        if (iJ != 0) {
            long j = this.f4747c;
            if (j != 0 && j != -9223372036854775807L) {
                return j / ((long) iJ);
            }
        }
        return Long.MAX_VALUE;
    }

    public void hideScrubber(boolean z) {
        if (this.f4731a.isStarted()) {
            this.f4731a.cancel();
        }
        this.f4740a = z;
        this.b = 0.0f;
        invalidate(this.f4734a);
    }

    public final void i(float f2) {
        Rect rect = this.f4752d;
        Rect rect2 = this.f4745b;
        rect.right = gj9.s((int) f2, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4735a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final Point k(MotionEvent motionEvent) {
        this.f4733a.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f4733a;
    }

    public final boolean l(long j) {
        long j2 = this.f4747c;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.f4746b ? this.f4743b : this.f4750d;
        long jT = gj9.t(j3 + j, 0L, j2);
        if (jT == j3) {
            return false;
        }
        if (this.f4746b) {
            s(jT);
        } else {
            p(jT);
        }
        update();
        return true;
    }

    public final boolean m(Drawable drawable) {
        return gj9.f41922a >= 23 && n(drawable, getLayoutDirection());
    }

    @RequiresApi(29)
    public final void o(int i, int i2) {
        Rect rect = this.f4754e;
        if (rect != null && rect.width() == i && this.f4754e.height() == i2) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i2);
        this.f4754e = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.f4746b || z) {
            return;
        }
        q(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(f4729f);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f4729f);
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f4747c <= 0) {
            return;
        }
        if (gj9.f41922a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (l(positionIncrement)) {
                            removeCallbacks(this.f4736a);
                            postDelayed(this.f4736a, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (l(positionIncrement)) {
                            removeCallbacks(this.f4736a);
                            postDelayed(this.f4736a, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.f4746b) {
                            q(false);
                            return true;
                        }
                        break;
                }
            } else if (this.f4746b) {
                q(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingBottom;
        int iMax;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i7 = this.f4740a ? 0 : this.R;
        if (this.M == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.L;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.K;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.L) / 2;
            iMax = (i6 - this.K) / 2;
        }
        this.f4734a.set(paddingLeft, paddingBottom, paddingRight, this.L + paddingBottom);
        Rect rect = this.f4745b;
        Rect rect2 = this.f4734a;
        rect.set(rect2.left + i7, iMax, rect2.right - i7, this.K + iMax);
        if (gj9.f41922a >= 29) {
            o(i5, i6);
        }
        update();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.L;
        } else if (mode != 1073741824) {
            size = Math.min(this.L, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        r();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.f4735a;
        if (drawable == null || !n(drawable, i)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f4747c > 0) {
            Point pointK = k(motionEvent);
            int i = pointK.x;
            int i2 = pointK.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f2 = i;
                if (f(f2, i2)) {
                    i(f2);
                    p(getScrubberPosition());
                    update();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.f4746b) {
                    q(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.f4746b) {
                        q(motionEvent.getAction() == 3);
                        return true;
                    }
                }
            } else if (this.f4746b) {
                if (i2 < this.S) {
                    int i3 = this.U;
                    i(i3 + ((i - i3) / 3));
                } else {
                    this.U = i;
                    i(i);
                }
                s(getScrubberPosition());
                update();
                invalidate();
                return true;
            }
        }
        return false;
    }

    public final void p(long j) {
        this.f4743b = j;
        this.f4746b = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it = this.f4739a.iterator();
        while (it.hasNext()) {
            it.next().e(this, j);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f4747c <= 0) {
            return false;
        }
        if (i == 8192) {
            if (l(-getPositionIncrement())) {
                q(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (l(getPositionIncrement())) {
                q(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public final void q(boolean z) {
        removeCallbacks(this.f4736a);
        this.f4746b = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it = this.f4739a.iterator();
        while (it.hasNext()) {
            it.next().k(this, this.f4743b, z);
        }
    }

    public final void r() {
        Drawable drawable = this.f4735a;
        if (drawable != null && drawable.isStateful() && this.f4735a.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        this.f4739a.remove(onScrubListener);
    }

    public final void s(long j) {
        if (this.f4743b == j) {
            return;
        }
        this.f4743b = j;
        Iterator<TimeBar.OnScrubListener> it = this.f4739a.iterator();
        while (it.hasNext()) {
            it.next().l(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        sb0.a(i == 0 || !(jArr == null || zArr == null));
        this.V = i;
        this.f4741a = jArr;
        this.f4742a = zArr;
        update();
    }

    public void setAdMarkerColor(@ColorInt int i) {
        this.f4751d.setColor(i);
        invalidate(this.f4734a);
    }

    public void setBufferedColor(@ColorInt int i) {
        this.f4744b.setColor(i);
        invalidate(this.f4734a);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long j) {
        if (this.e == j) {
            return;
        }
        this.e = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long j) {
        if (this.f4747c == j) {
            return;
        }
        this.f4747c = j;
        if (this.f4746b && j == -9223372036854775807L) {
            q(true);
        }
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.f4746b || z) {
            return;
        }
        q(true);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyCountIncrement(int i) {
        sb0.a(i > 0);
        this.T = i;
        this.f4730a = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyTimeIncrement(long j) {
        sb0.a(j > 0);
        this.T = -1;
        this.f4730a = j;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i) {
        this.f4753e.setColor(i);
        invalidate(this.f4734a);
    }

    public void setPlayedColor(@ColorInt int i) {
        this.f4732a.setColor(i);
        invalidate(this.f4734a);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long j) {
        if (this.f4750d == j) {
            return;
        }
        this.f4750d = j;
        setContentDescription(getProgressText());
        update();
    }

    public void setScrubberColor(@ColorInt int i) {
        this.f4755f.setColor(i);
        invalidate(this.f4734a);
    }

    public void setUnplayedColor(@ColorInt int i) {
        this.f4748c.setColor(i);
        invalidate(this.f4734a);
    }

    public void showScrubber() {
        if (this.f4731a.isStarted()) {
            this.f4731a.cancel();
        }
        this.f4740a = false;
        this.b = 1.0f;
        invalidate(this.f4734a);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.f4734a = new Rect();
        this.f4745b = new Rect();
        this.f4749c = new Rect();
        this.f4752d = new Rect();
        Paint paint = new Paint();
        this.f4732a = paint;
        Paint paint2 = new Paint();
        this.f4744b = paint2;
        Paint paint3 = new Paint();
        this.f4748c = paint3;
        Paint paint4 = new Paint();
        this.f4751d = paint4;
        Paint paint5 = new Paint();
        this.f4753e = paint5;
        Paint paint6 = new Paint();
        this.f4755f = paint6;
        paint6.setAntiAlias(true);
        this.f4739a = new CopyOnWriteArraySet<>();
        this.f4733a = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f31057a = f2;
        this.S = c(f2, -50);
        int iC = c(f2, 4);
        int iC2 = c(f2, 26);
        int iC3 = c(f2, 4);
        int iC4 = c(f2, 12);
        int iC5 = c(f2, 0);
        int iC6 = c(f2, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, i, i2);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.f4735a = drawable;
                if (drawable != null) {
                    m(drawable);
                    iC2 = Math.max(drawable.getMinimumHeight(), iC2);
                }
                this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, iC);
                this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, iC2);
                this.M = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_bar_gravity, 0);
                this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, iC3);
                this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, iC4);
                this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, iC5);
                this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, iC6);
                int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, DEFAULT_BUFFERED_COLOR);
                int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, DEFAULT_UNPLAYED_COLOR);
                int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, DEFAULT_AD_MARKER_COLOR);
                int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.K = iC;
            this.L = iC2;
            this.M = 0;
            this.N = iC3;
            this.O = iC4;
            this.P = iC5;
            this.Q = iC6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.f4735a = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f4737a = sb;
        this.f4738a = new Formatter(sb, Locale.getDefault());
        this.f4736a = new Runnable() { // from class: com.zj.adlib.bj2
            @Override // java.lang.Runnable
            public final void run() {
                this.f40759a.g();
            }
        };
        Drawable drawable2 = this.f4735a;
        if (drawable2 != null) {
            this.R = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.R = (Math.max(this.P, Math.max(this.O, this.Q)) + 1) / 2;
        }
        this.b = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f4731a = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.cj2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f40976a.h(valueAnimator2);
            }
        });
        this.f4747c = -9223372036854775807L;
        this.f4730a = -9223372036854775807L;
        this.T = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void hideScrubber(long j) {
        if (this.f4731a.isStarted()) {
            this.f4731a.cancel();
        }
        this.f4731a.setFloatValues(this.b, 0.0f);
        this.f4731a.setDuration(j);
        this.f4731a.start();
    }

    public void showScrubber(long j) {
        if (this.f4731a.isStarted()) {
            this.f4731a.cancel();
        }
        this.f4740a = false;
        this.f4731a.setFloatValues(this.b, 1.0f);
        this.f4731a.setDuration(j);
        this.f4731a.start();
    }
}
