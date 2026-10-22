package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public abstract class ActionBase {

    @SerializedName("AnimationConfig")
    protected String mAnimationConfig;
    protected transient Long mDuration;
    protected transient int mId;
    protected transient boolean mIsStream;

    @SerializedName("PartParam")
    protected PartParam mPartParam;
    protected transient int mTargetId;

    @SerializedName("TimelineIn")
    protected float mTimelineIn;

    @SerializedName("TimelineOut")
    protected float mTimelineOut;

    @SerializedName("Type")
    protected Type mType;

    @SerializedName("SourceId")
    private String resId;

    @SerializedName("Scope")
    protected int mScope = Scope.Overall.ordinal();

    @SerializedName("TimelineInOffset")
    protected float mStartOffset = -1.0f;

    @SerializedName("FillBefore")
    protected int mFillBefore = -1;

    @SerializedName("FillAfter")
    protected int mFillAfter = -1;

    @SerializedName("RepeatCount")
    protected int mRepeatCount = -1;

    @SerializedName("RepeatMode")
    protected int mRepeatMode = -1;

    @SerializedName("InterpolatorType")
    protected int mInterpolatorType = -1;

    public enum Interpolator {
        Linear,
        Accelerate,
        Decelerate,
        Accelerate_Decelerate,
        Overshot,
        Anticipate,
        Anticipate_Overshot,
        Bound,
        Cycle
    }

    public static class PartParam {

        public enum Mode {
            Sequence,
            Reverse,
            Random,
            Middle
        }

        public void setMode(Mode mode) {
            mode.ordinal();
        }

        public void setOverlayRadio(float f) {
            Math.min(1.0f, Math.max(f, 0.0f));
        }
    }

    public enum RepeatMode {
        None,
        Restart,
        Reverse
    }

    public enum Scope {
        Overall,
        Part
    }

    public enum Type {
        alpha,
        scale,
        translate,
        rotate_repeat,
        rotate_by,
        rotate_to,
        swipe,
        custom,
        action_set
    }

    public boolean equals(Object obj) {
        return (obj instanceof ActionBase) && ((ActionBase) obj).mId == this.mId;
    }

    public String getAnimationConfig() {
        return this.mAnimationConfig;
    }

    public long getDuration() {
        return (long) ((this.mTimelineOut - this.mTimelineIn) * 1000000.0f);
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), TimeUnit.MICROSECONDS);
    }

    public int getId() {
        return this.mId;
    }

    public String getResId() {
        return this.resId;
    }

    public long getStartTime() {
        return (long) (this.mTimelineIn * 1000000.0f);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), TimeUnit.MICROSECONDS);
    }

    public int getTargetId() {
        return this.mTargetId;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isStream() {
        return this.mIsStream;
    }

    @Deprecated
    public void setAnimationConfig(String str) {
        this.mAnimationConfig = str;
    }

    public void setDuration(long j) {
        setDuration(j, TimeUnit.MICROSECONDS);
    }

    public void setDuration(long j, TimeUnit timeUnit) {
        Long lValueOf = Long.valueOf(timeUnit.toMicros(j));
        this.mDuration = lValueOf;
        this.mTimelineOut = this.mTimelineIn + (lValueOf.longValue() / 1000000.0f);
    }

    public void setFillAfter(boolean z) {
        this.mFillAfter = z ? 1 : 0;
    }

    public void setFillBefore(boolean z) {
        this.mFillBefore = z ? 1 : 0;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setInterpolatorType(Interpolator interpolator) {
        this.mInterpolatorType = interpolator.ordinal();
    }

    public void setIsStream(boolean z) {
        this.mIsStream = z;
    }

    public void setPartParam(PartParam partParam) {
        this.mPartParam = partParam;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(RepeatMode repeatMode) {
        this.mRepeatMode = repeatMode.ordinal();
    }

    public void setResId(String str) {
        this.resId = str;
    }

    public void setScope(Scope scope) {
        this.mScope = scope.ordinal();
    }

    public void setStartOffset(long j) {
        this.mStartOffset = j / 1000000.0f;
    }

    public void setStartTime(long j) {
        setStartTime(j, TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, TimeUnit timeUnit) {
        if (this.mDuration == null) {
            this.mDuration = Long.valueOf(((long) (this.mTimelineOut - this.mTimelineIn)) * 1000000);
        }
        float micros = timeUnit.toMicros(j) / 1000000.0f;
        this.mTimelineIn = micros;
        this.mTimelineOut = micros + (this.mDuration.longValue() / 1000000.0f);
    }

    public void setTargetId(int i) {
        this.mTargetId = i;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
