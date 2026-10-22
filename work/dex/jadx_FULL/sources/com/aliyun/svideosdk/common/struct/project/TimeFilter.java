package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TimeFilter extends EffectTrack {
    private transient Long mDuration;

    @SerializedName("NeedOriginDuration")
    private boolean mIsNeedOriginDuration;

    @SerializedName("TimeParam")
    private float mParam;

    @SerializedName("EffectType")
    private int mTimeFilterType;

    public TimeFilter() {
        setType(EffectTrack.Type.time_effect);
    }

    public TimeFilter(int i, long j, long j2, int i2, float f, boolean z) {
        this();
        setId(i);
        Long lValueOf = Long.valueOf(j2);
        this.mDuration = lValueOf;
        this.mTimeFilterType = i2;
        this.mParam = f;
        this.mIsNeedOriginDuration = z;
        float f2 = j / 1000.0f;
        this.mTimelineIn = f2;
        this.mTimelineOut = f2 + (lValueOf.longValue() / 1000.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeFilter timeFilter = (TimeFilter) obj;
        return this.mTimelineIn == timeFilter.mTimelineIn && this.mDuration.equals(timeFilter.mDuration) && this.mTimeFilterType == timeFilter.mTimeFilterType && this.mParam == timeFilter.mParam;
    }

    public long getDuration() {
        return (long) ((this.mTimelineOut - this.mTimelineIn) * 1000.0f);
    }

    public float getParam() {
        return this.mParam;
    }

    public long getStartTime() {
        return (long) (this.mTimelineIn * 1000.0f);
    }

    public int getTimeFilterType() {
        return this.mTimeFilterType;
    }

    public boolean isNeedOriginDuration() {
        return this.mIsNeedOriginDuration;
    }

    public void setDuration(long j) {
        Long lValueOf = Long.valueOf(j);
        this.mDuration = lValueOf;
        this.mTimelineOut = this.mTimelineIn + (lValueOf.longValue() / 1000.0f);
    }

    public void setNeedOriginDuration(boolean z) {
        this.mIsNeedOriginDuration = z;
    }

    public void setParam(float f) {
        this.mParam = f;
    }

    public void setStartTime(long j) {
        if (this.mDuration == null) {
            this.mDuration = Long.valueOf(((long) (this.mTimelineIn - this.mTimelineOut)) * 1000);
        }
        float f = j / 1000.0f;
        this.mTimelineIn = f;
        this.mTimelineOut = f + (this.mDuration.longValue() / 1000.0f);
    }

    public void setTimeFilterType(int i) {
        this.mTimeFilterType = i;
    }
}
