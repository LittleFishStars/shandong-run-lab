package com.fl.saas.adx.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.C1432r0;
import com.fl.saas.R;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InclineView extends FrameLayout implements SensorEventListener {
    private static final int INCLINE_DEFAULT_THRESHOLD = 400;
    private Sensor accelerometerSensor;
    private int inclineThreshold;
    private boolean isCallback;
    private boolean isVisibility;
    private long lastUpdate;
    private float last_x;
    private float last_y;
    private float last_z;
    private Animator mAnimator;
    private ImageView mImageView;
    private InclineListener mInclineListener;
    private SensorManager sensorManager;

    public interface InclineListener {
        void onIncline(int i, int i2, int i3);
    }

    public InclineView(@NonNull Context context) {
        super(context);
        this.inclineThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.lastUpdate = 0L;
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    private Animator createAnimatorSet(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getMeasuredHeight() / 2.0f);
        view.setPivotY(view.getMeasuredWidth() / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, f);
        objectAnimatorOfFloat.setDuration(j);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "rotationX", f, (-f) / 2.0f);
        objectAnimatorOfFloat2.setDuration(2 * j);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "rotationX", f, 0.0f);
        objectAnimatorOfFloat3.setDuration(j);
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setStartDelay(400L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.adx.base.widget.InclineView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (InclineView.this.mImageView != null) {
                    InclineView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (InclineView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    private void createImageView() {
        ImageView imageView = new ImageView(getContext());
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(this.mImageView, layoutParams);
        this.mImageView.setImageResource(R.drawable.fl_adx_icon_shake_hand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 200L, 40.0f);
        }
        if (this.mAnimator.isRunning()) {
            return;
        }
        this.mAnimator.start();
    }

    private void registerAccelerometer() {
        try {
            if (this.isCallback) {
                return;
            }
            C1432r0 c1432r0 = DeviceUtil.controlBean;
            if (c1432r0 != null) {
                if (!c1432r0.f()) {
                    return;
                }
            } else if (!DeviceUtil.isCanUseSensor) {
                return;
            }
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) getContext().getSystemService("sensor");
            }
            if (this.accelerometerSensor == null) {
                this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
            }
            this.sensorManager.registerListener(this, this.accelerometerSensor, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unRegisterAccelerometer() {
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
        unRegisterAccelerometer();
        this.sensorManager = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.isCallback && sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastUpdate;
            if (j > 100) {
                this.lastUpdate = jCurrentTimeMillis;
                float f4 = this.last_x;
                if (f4 == 0.0f && this.last_y == 0.0f && this.last_z == 0.0f) {
                    this.last_x = f;
                    this.last_y = f2;
                    this.last_z = f3;
                    return;
                }
                float f5 = f - f4;
                float f6 = f2 - this.last_y;
                float f7 = f3 - this.last_z;
                boolean z = (Math.sqrt((double) (((f5 * f5) + (f6 * f6)) + (f7 * f7))) / ((double) j)) * 10000.0d >= ((double) this.inclineThreshold);
                this.last_x = f;
                this.last_y = f2;
                this.last_z = f3;
                if (z) {
                    this.isCallback = true;
                    InclineListener inclineListener = this.mInclineListener;
                    if (inclineListener != null) {
                        inclineListener.onIncline(Math.round(f * 100.0f), Math.round(f2 * 100.0f), Math.round(f3 * 100.0f));
                    }
                    try {
                        ((Vibrator) getContext().getSystemService("vibrator")).vibrate(500L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new Runnable() { // from class: com.zj.adlib.y84
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45975a.playAnimator();
                }
            });
            registerAccelerometer();
        } else {
            cancelAnimator();
            unRegisterAccelerometer();
        }
    }

    public void setCallback(boolean z) {
        this.isCallback = z;
    }

    public void setInclineListener(int i, InclineListener inclineListener) {
        int i2;
        if (i < 0 || i > 100) {
            i2 = 400;
        } else if (i < 50) {
            i2 = i * 5;
        } else {
            i2 = i <= 70 ? i * 8 : i * 15;
        }
        this.inclineThreshold = i2;
        this.mInclineListener = inclineListener;
    }

    public InclineView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InclineView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inclineThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.lastUpdate = 0L;
        createImageView();
    }
}
