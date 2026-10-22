package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    long mStartOffset;
    private int mZAdjustment;
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    long mDuration = 500;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    public void applyTransformation(float f, GLTransformation gLTransformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * ((long) (getRepeatCount() + 1));
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        fireAnimationEnd();
    }

    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j, GLTransformation gLTransformation) {
        float fMax;
        if (this.mStartTime == -1) {
            this.mStartTime = j;
        }
        long startOffset = getStartOffset();
        long j2 = this.mDuration;
        if (j2 != 0) {
            fMax = (j - (this.mStartTime + startOffset)) / j2;
        } else {
            fMax = j < this.mStartTime ? 0.0f : 1.0f;
        }
        boolean z = fMax >= 1.0f;
        this.mMore = !z;
        if (!this.mFillEnabled) {
            fMax = Math.max(Math.min(fMax, 1.0f), 0.0f);
        }
        if ((fMax >= 0.0f || this.mFillBefore) && (fMax <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                fMax = Math.max(Math.min(fMax, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                fMax = 1.0f - fMax;
            }
            applyTransformation(this.mInterpolator.getInterpolation(fMax), gLTransformation);
        }
        if (z) {
            int i = this.mRepeatCount;
            int i2 = this.mRepeated;
            if (i != i2) {
                if (i > 0) {
                    this.mRepeated = i2 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                fireAnimationEnd();
            }
        }
        boolean z2 = this.mMore;
        if (z2 || !this.mOneMoreTime) {
            return z2;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j) {
        long j2 = this.mStartOffset;
        if (j2 > j) {
            this.mStartOffset = j;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j3 = this.mDuration + j2;
        if (j3 > j) {
            this.mDuration = j - j2;
            j3 = j;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        int i = this.mRepeatCount;
        if (i < 0 || i > j || ((long) i) * j3 > j) {
            int i2 = ((int) (j / j3)) - 1;
            this.mRepeatCount = i2;
            if (i2 < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f) {
        this.mDuration = (long) (this.mDuration * f);
        this.mStartOffset = (long) (this.mStartOffset * f);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setDetachWallpaper(boolean z) {
        this.mDetachWallpaper = z;
    }

    public void setDuration(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mDuration = j;
    }

    public void setFillAfter(boolean z) {
        this.mFillAfter = z;
    }

    public void setFillBefore(boolean z) {
        this.mFillBefore = z;
    }

    public void setFillEnabled(boolean z) {
        this.mFillEnabled = z;
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setRepeatCount(int i) {
        if (i < 0) {
            i = -1;
        }
        this.mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public void setStartOffset(long j) {
        this.mStartOffset = j;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i) {
        this.mZAdjustment = i;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLAnimation mo163clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean getTransformation(long j, GLTransformation gLTransformation, float f) {
        this.mScaleFactor = f;
        return getTransformation(j, gLTransformation);
    }
}
