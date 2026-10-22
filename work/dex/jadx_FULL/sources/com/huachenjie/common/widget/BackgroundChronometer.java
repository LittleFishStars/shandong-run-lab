package com.huachenjie.common.widget;

import android.content.Context;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RemoteViews;
import com.zj.adlib.c49;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@RemoteViews.RemoteView
public class BackgroundChronometer extends CustomerTextView {
    private static final String TAG = "Chronometer";
    private long mBase;
    private boolean mCountDown;
    private String mFormat;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private Object[] mFormatterArgs;
    private Locale mFormatterLocale;
    private boolean mLogged;
    private long mNow;
    private OnChronometerTickListener mOnChronometerTickListener;
    private StringBuilder mRecycle;
    private boolean mStarted;
    private final Runnable mTickRunnable;
    private boolean mTicking;
    private boolean mVisible;

    public interface OnChronometerTickListener {
        void onChronometerTick(BackgroundChronometer chronometer);
    }

    public BackgroundChronometer(Context context) {
        super(context, null);
        this.mFormatterArgs = new Object[1];
        this.mRecycle = new StringBuilder(8);
        this.mTickRunnable = new Runnable() { // from class: com.huachenjie.common.widget.BackgroundChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (BackgroundChronometer.this.mTicking) {
                    BackgroundChronometer.this.updateText(SystemClock.elapsedRealtime());
                    BackgroundChronometer.this.dispatchChronometerTick();
                    BackgroundChronometer backgroundChronometer = BackgroundChronometer.this;
                    backgroundChronometer.postDelayed(backgroundChronometer.mTickRunnable, 1000L);
                }
            }
        };
    }

    private void init() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mBase = jElapsedRealtime;
        updateText(jElapsedRealtime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateText(long now) {
        boolean z;
        this.mNow = now;
        long j = (this.mCountDown ? this.mBase - now : now - this.mBase) / 1000;
        if (j < 0) {
            j = -j;
            z = true;
        } else {
            z = false;
        }
        String elapsedTime = DateUtils.formatElapsedTime(this.mRecycle, j);
        if (z) {
            elapsedTime = c49.f40900a;
        }
        if (this.mFormat != null) {
            Locale locale = Locale.getDefault();
            if (this.mFormatter == null || !locale.equals(this.mFormatterLocale)) {
                this.mFormatterLocale = locale;
                this.mFormatter = new Formatter(this.mFormatBuilder, locale);
            }
            this.mFormatBuilder.setLength(0);
            Object[] objArr = this.mFormatterArgs;
            objArr[0] = elapsedTime;
            try {
                this.mFormatter.format(this.mFormat, objArr);
                elapsedTime = this.mFormatBuilder.toString();
            } catch (IllegalFormatException unused) {
                if (!this.mLogged) {
                    this.mLogged = true;
                }
            }
        }
        setText(elapsedTime);
    }

    private void updateTicking() {
        boolean z = this.mStarted;
        if (z != this.mTicking) {
            if (z) {
                updateText(SystemClock.elapsedRealtime());
                dispatchChronometerTick();
                postDelayed(this.mTickRunnable, 1000L);
            } else {
                removeCallbacks(this.mTickRunnable);
            }
            this.mTicking = z;
        }
    }

    public void dispatchChronometerTick() {
        OnChronometerTickListener onChronometerTickListener = this.mOnChronometerTickListener;
        if (onChronometerTickListener != null) {
            onChronometerTickListener.onChronometerTick(this);
        }
    }

    public long getBase() {
        return this.mBase;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public OnChronometerTickListener getOnChronometerTickListener() {
        return this.mOnChronometerTickListener;
    }

    public boolean isCountDown() {
        return this.mCountDown;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mVisible = false;
        updateTicking();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        updateTicking();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.mVisible = visibility == 0;
        updateTicking();
    }

    public void setBase(long base) {
        this.mBase = base;
        dispatchChronometerTick();
        updateText(SystemClock.elapsedRealtime());
    }

    public void setCountDown(boolean countDown) {
        this.mCountDown = countDown;
        updateText(SystemClock.elapsedRealtime());
    }

    public void setFormat(String format) {
        this.mFormat = format;
        if (format == null || this.mFormatBuilder != null) {
            return;
        }
        this.mFormatBuilder = new StringBuilder(format.length() * 2);
    }

    public void setOnChronometerTickListener(OnChronometerTickListener listener) {
        this.mOnChronometerTickListener = listener;
    }

    public void setStarted(boolean started) {
        this.mStarted = started;
        updateTicking();
    }

    public void start() {
        this.mStarted = true;
        updateTicking();
    }

    public void stop() {
        this.mStarted = false;
        updateTicking();
    }

    public BackgroundChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFormatterArgs = new Object[1];
        this.mRecycle = new StringBuilder(8);
        this.mTickRunnable = new Runnable() { // from class: com.huachenjie.common.widget.BackgroundChronometer.1
            @Override // java.lang.Runnable
            public void run() {
                if (BackgroundChronometer.this.mTicking) {
                    BackgroundChronometer.this.updateText(SystemClock.elapsedRealtime());
                    BackgroundChronometer.this.dispatchChronometerTick();
                    BackgroundChronometer backgroundChronometer = BackgroundChronometer.this;
                    backgroundChronometer.postDelayed(backgroundChronometer.mTickRunnable, 1000L);
                }
            }
        };
        init();
    }
}
