package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z) {
        setFlag(16, z);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags = i | this.mFlags;
        } else {
            this.mFlags = (~i) & this.mFlags;
        }
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if (((this.mFlags & 128) == 0) && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long startOffset = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mDuration = startOffset;
            this.mLastEnd = this.mStartOffset + startOffset;
        } else {
            long jMax = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mLastEnd = jMax;
            this.mDuration = jMax - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j = 0;
        for (int i = size - 1; i >= 0; i--) {
            long jComputeDurationHint = arrayList.get(i).computeDurationHint();
            if (jComputeDurationHint > j) {
                j = jComputeDurationHint;
            }
        }
        return j;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, arrayList.get(i).getDuration());
        }
        return jMax;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            jMin = Math.min(jMin, arrayList.get(i).getStartTime());
        }
        return jMin;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062 A[Catch: all -> 0x006c, TryCatch #0 {all -> 0x006c, blocks: (B:26:0x0051, B:28:0x0055, B:30:0x0059, B:31:0x005c, B:32:0x005e, B:34:0x0062, B:36:0x0066, B:37:0x0069), top: B:42:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0066 A[Catch: all -> 0x006c, TryCatch #0 {all -> 0x006c, blocks: (B:26:0x0051, B:28:0x0055, B:30:0x0059, B:31:0x005c, B:32:0x005e, B:34:0x0062, B:36:0x0066, B:37:0x0069), top: B:42:0x0051 }] */
    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j, GLTransformation gLTransformation) {
        Animation.AnimationListener animationListener;
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = size - 1; i >= 0; i--) {
            GLAnimation gLAnimation = arrayList.get(i);
            gLTransformation2.clear();
            z3 = gLAnimation.getTransformation(j, gLTransformation, getScaleFactor()) || z3;
            z2 = z2 || gLAnimation.hasStarted();
            z = gLAnimation.hasEnded() && z;
        }
        if (z2) {
            try {
                if (!this.mStarted) {
                    Animation.AnimationListener animationListener2 = this.mListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationStart();
                    }
                    this.mStarted = true;
                }
                if (z != this.mEnded) {
                    animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                    this.mEnded = z;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (z != this.mEnded) {
            animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd();
            }
            this.mEnded = z;
        }
        return z3;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        super.initialize();
        int i = this.mFlags;
        boolean z = (i & 32) == 32;
        boolean z2 = (i & 1) == 1;
        boolean z3 = (i & 2) == 2;
        boolean z4 = (i & 4) == 4;
        boolean z5 = (i & 16) == 16;
        boolean z6 = (i & 8) == 8;
        if (z5) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j = this.mDuration;
        boolean z7 = this.mFillAfter;
        boolean z8 = this.mFillBefore;
        int i2 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z9 = z6;
        long j2 = this.mStartOffset;
        int i3 = 0;
        while (i3 < size) {
            ArrayList<GLAnimation> arrayList2 = arrayList;
            GLAnimation gLAnimation = arrayList.get(i3);
            if (z) {
                gLAnimation.setDuration(j);
            }
            if (z2) {
                gLAnimation.setFillAfter(z7);
            }
            if (z3) {
                gLAnimation.setFillBefore(z8);
            }
            if (z4) {
                gLAnimation.setRepeatMode(i2);
            }
            if (z5) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z9) {
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j2);
            }
            gLAnimation.initialize();
            i3++;
            z2 = z2;
            arrayList = arrayList2;
            z3 = z3;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j) {
        super.restrictDuration(j);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).restrictDuration(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).scaleCurrentDuration(f);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j) {
        this.mFlags |= 32;
        super.setDuration(j);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z) {
        this.mFlags |= 1;
        super.setFillAfter(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z) {
        this.mFlags |= 2;
        super.setFillBefore(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i) {
        this.mFlags |= 4;
        super.setRepeatMode(i);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j) {
        this.mFlags |= 8;
        super.setStartOffset(j);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j) {
        super.setStartTime(j);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            arrayList.get(i).setStartTime(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* JADX INFO: renamed from: clone */
    public GLAnimationSet mo163clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.mo163clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i).mo163clone());
        }
        return gLAnimationSet;
    }
}
