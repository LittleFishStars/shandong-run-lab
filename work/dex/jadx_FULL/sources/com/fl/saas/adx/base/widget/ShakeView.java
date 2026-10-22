package com.fl.saas.adx.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.fl.saas.C1432r0;
import com.fl.saas.R;
import com.fl.saas.U0;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ShakeView extends FrameLayout implements SensorEventListener {
    private static final int SHAKE_DEFAULT_THRESHOLD = 400;
    private final float[] accelerometerReading;
    private Sensor accelerometerSensor;
    private Runnable checkValidAreaRunnable;
    private boolean isCallback;
    private boolean isVisibility;
    private long lastUpdate;
    private float last_x;
    private float last_y;
    private float last_z;
    private Animator mAnimator;
    private ImageView mImageView;
    private ShakeListener mShakeListener;
    private Sensor magneticSensor;
    private final float[] magnetometerReading;
    private boolean needVibrator;
    private final float[] orientationAngles;
    private final Runnable playAnimatorRunnable;
    private final float[] rotationMatrix;
    private SensorManager sensorManager;
    private int shakeThreshold;
    private long startTime;
    private double startXAngle;
    private double startYAngle;
    private double startZAngle;

    public interface ShakeListener {
        void onShake(int i, int i2, int i3);
    }

    public ShakeView(@NonNull Context context) {
        super(context);
        this.shakeThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.needVibrator = true;
        this.lastUpdate = 0L;
        this.accelerometerReading = new float[3];
        this.magnetometerReading = new float[3];
        this.rotationMatrix = new float[9];
        this.orientationAngles = new float[3];
        this.playAnimatorRunnable = new Runnable() { // from class: com.zj.adlib.a88
            @Override // java.lang.Runnable
            public final void run() {
                this.f40476a.playAnimator();
            }
        };
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidArea() {
        if (isShow()) {
            registerAccelerometer(true);
            return;
        }
        if (this.checkValidAreaRunnable == null) {
            this.checkValidAreaRunnable = new Runnable() { // from class: com.zj.adlib.c88
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40923a.checkValidArea();
                }
            };
        }
        DeviceUtil.removePostUI(this.checkValidAreaRunnable);
        DeviceUtil.postUIDelayed(200L, this.checkValidAreaRunnable);
    }

    private Animator createAnimatorSet(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        float measuredHeight = view.getMeasuredHeight();
        float measuredWidth = view.getMeasuredWidth();
        if (measuredHeight == 0.0f && measuredWidth == 0.0f) {
            float fDip2px = DeviceUtil.dip2px(24.0f);
            measuredWidth = DeviceUtil.dip2px(24.0f);
            measuredHeight = fDip2px;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        view.setPivotX(measuredHeight / 2.0f);
        view.setPivotY(measuredWidth / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, f);
        objectAnimatorOfFloat.setDuration(j);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, f, -f);
        objectAnimatorOfFloat2.setDuration(2 * j);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat2.setRepeatCount(3);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, f, 0.0f);
        objectAnimatorOfFloat3.setDuration(j);
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setStartDelay(400L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.adx.base.widget.ShakeView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ShakeView.this.mImageView != null) {
                    ShakeView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ShakeView.this.isVisibility) {
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

    private boolean isShow() {
        return getGlobalVisibleRect(new Rect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 100L, 16.0f);
        }
        if (this.mAnimator.isRunning()) {
            return;
        }
        this.mAnimator.start();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
        unRegisterAccelerometer(true);
        this.sensorManager = null;
        this.accelerometerSensor = null;
        Runnable runnable = this.checkValidAreaRunnable;
        if (runnable != null) {
            DeviceUtil.removePostUI(runnable);
            this.checkValidAreaRunnable = null;
        }
        removeCallbacks(null);
        this.mImageView.removeCallbacks(this.playAnimatorRunnable);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        if (this.isCallback) {
            return;
        }
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() != 1) {
            if (sensor.getType() == 2) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = this.magnetometerReading;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                return;
            }
            return;
        }
        try {
            if (this.shakeThreshold >= 0) {
                float[] fArr3 = sensorEvent.values;
                float f2 = fArr3[0];
                float f3 = fArr3[1];
                f = fArr3[2];
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - this.lastUpdate;
                if (j > 100) {
                    this.lastUpdate = jCurrentTimeMillis;
                    float f4 = this.last_x;
                    if (f4 == 0.0f && this.last_y == 0.0f && this.last_z == 0.0f) {
                        this.last_x = f2;
                        this.last_y = f3;
                        this.last_z = f;
                        return;
                    }
                    float f5 = f2 - f4;
                    float f6 = f3 - this.last_y;
                    float f7 = f - this.last_z;
                    boolean z = (Math.sqrt((double) (((f5 * f5) + (f6 * f6)) + (f7 * f7))) / ((double) j)) * 10000.0d >= ((double) this.shakeThreshold);
                    this.last_x = f2;
                    this.last_y = f3;
                    this.last_z = f;
                    if (z && isShow()) {
                        this.isCallback = true;
                        ShakeListener shakeListener = this.mShakeListener;
                        if (shakeListener != null) {
                            shakeListener.onShake(Math.round(f2 * 100.0f), Math.round(f3 * 100.0f), Math.round(f * 100.0f));
                        }
                        if (this.needVibrator) {
                            ((Vibrator) getContext().getApplicationContext().getSystemService("vibrator")).vibrate(500L);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            float[] fArr4 = sensorEvent.values;
            float[] fArr5 = this.accelerometerReading;
            System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
            SensorManager.getRotationMatrix(this.rotationMatrix, null, this.accelerometerReading, this.magnetometerReading);
            SensorManager.getOrientation(this.rotationMatrix, this.orientationAngles);
            float[] fArr6 = this.orientationAngles;
            double d = ((double) (fArr6[0] * 180.0f)) / 3.141592653589793d;
            double d2 = ((double) (fArr6[1] * 180.0f)) / 3.141592653589793d;
            double d3 = ((double) (fArr6[2] * 180.0f)) / 3.141592653589793d;
            if (this.startXAngle == AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.startXAngle = d2;
                this.startYAngle = d3;
                this.startZAngle = d;
                return;
            }
            float[] fArr7 = sensorEvent.values;
            float f8 = fArr7[0];
            float f9 = fArr7[1];
            f = fArr7[2];
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis2 - this.lastUpdate;
            if (j2 > 100) {
                boolean z2 = Math.abs(d2 - this.startXAngle) > 35.0d || Math.abs(d3 - this.startYAngle) > 35.0d || Math.abs(d - this.startZAngle) > 35.0d;
                if (z2 && this.startTime == 0) {
                    this.startTime = jCurrentTimeMillis2;
                }
                this.lastUpdate = jCurrentTimeMillis2;
                float f10 = this.last_x;
                if (f10 == 0.0f && this.last_y == 0.0f && this.last_z == 0.0f) {
                    this.last_x = f8;
                    this.last_y = f9;
                    this.last_z = f;
                    return;
                }
                float f11 = f8 - f10;
                float f12 = f9 - this.last_y;
                float f13 = f - this.last_z;
                boolean z3 = (Math.sqrt((double) (((f11 * f11) + (f12 * f12)) + (f13 * f13))) / ((double) j2)) * 10000.0d >= 1500.0d;
                if (z3 && this.startTime == 0) {
                    this.startTime = jCurrentTimeMillis2;
                }
                this.last_x = f8;
                this.last_y = f9;
                this.last_z = f;
                if (z3 && z2 && jCurrentTimeMillis2 - this.startTime > 3000 && isShow()) {
                    this.isCallback = true;
                    ShakeListener shakeListener2 = this.mShakeListener;
                    if (shakeListener2 != null) {
                        shakeListener2.onShake(Math.round(f8 * 100.0f), Math.round(f9 * 100.0f), Math.round(f * 100.0f));
                    }
                    if (this.needVibrator) {
                        ((Vibrator) getContext().getApplicationContext().getSystemService("vibrator")).vibrate(500L);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i != 0) {
            cancelAnimator();
            unRegisterAccelerometer(true);
            return;
        }
        this.mImageView.post(this.playAnimatorRunnable);
        if (isShow()) {
            registerAccelerometer(true);
        } else {
            checkValidArea();
        }
    }

    public void registerAccelerometer(boolean z) {
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
            if (z) {
                U0.a().a(this);
            }
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) getContext().getApplicationContext().getSystemService("sensor");
            }
            if (this.accelerometerSensor == null) {
                this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
            }
            this.sensorManager.registerListener(this, this.accelerometerSensor, 3);
            if (this.magneticSensor == null) {
                this.magneticSensor = this.sensorManager.getDefaultSensor(2);
            }
            this.sensorManager.registerListener(this, this.magneticSensor, 3, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCallback(boolean z) {
        this.isCallback = z;
    }

    public void setNeedVibrator(boolean z) {
        this.needVibrator = z;
    }

    public void setShakeListener(int i, ShakeListener shakeListener) {
        int i2;
        if (i < 0 || i >= 100) {
            i2 = -1;
        } else if (i < 50) {
            i2 = i * 5;
        } else {
            i2 = i <= 70 ? i * 8 : i * 20;
        }
        this.shakeThreshold = i2;
        this.mShakeListener = shakeListener;
    }

    public void unRegisterAccelerometer(boolean z) {
        if (z) {
            try {
                U0.a().b(this);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.startTime = 0L;
        this.startXAngle = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.startYAngle = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.startZAngle = AudioStats.AUDIO_AMPLITUDE_NONE;
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            Sensor sensor = this.accelerometerSensor;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.magneticSensor;
            if (sensor2 != null) {
                this.sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    public ShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shakeThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.needVibrator = true;
        this.lastUpdate = 0L;
        this.accelerometerReading = new float[3];
        this.magnetometerReading = new float[3];
        this.rotationMatrix = new float[9];
        this.orientationAngles = new float[3];
        this.playAnimatorRunnable = new Runnable() { // from class: com.zj.adlib.a88
            @Override // java.lang.Runnable
            public final void run() {
                this.f40476a.playAnimator();
            }
        };
        createImageView();
    }
}
