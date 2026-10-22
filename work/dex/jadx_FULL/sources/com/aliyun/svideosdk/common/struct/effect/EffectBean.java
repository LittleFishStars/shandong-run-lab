package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class EffectBean {
    private int mId;
    private int mMvAudioId;
    private int mOldId;
    private Source mSource;
    private long mStartTime;
    private long mStreamDuration;
    private long mStreamStartTime;
    private long mDuration = 2147483647L;
    private int mWeight = 50;

    public boolean equals(Object obj) {
        return (obj instanceof EffectBean) && this.mId == ((EffectBean) obj).mId;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), TimeUnit.MICROSECONDS);
    }

    public int getId() {
        return this.mId;
    }

    public int getMvAudioId() {
        return this.mMvAudioId;
    }

    public int getOldId() {
        return this.mOldId;
    }

    @Deprecated
    public String getPath() {
        Source source = this.mSource;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public Source getSource() {
        return this.mSource;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), TimeUnit.MICROSECONDS);
    }

    public long getStreamDuration() {
        return this.mStreamDuration;
    }

    public long getStreamDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStreamDuration, TimeUnit.MICROSECONDS);
    }

    public long getStreamStartTime() {
        return this.mStreamStartTime;
    }

    public long getStreamStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStreamStartTime, TimeUnit.MICROSECONDS);
    }

    public int getWeight() {
        return this.mWeight;
    }

    public void setDuration(long j) {
        setDuration(j, TimeUnit.MICROSECONDS);
    }

    public void setDuration(long j, TimeUnit timeUnit) {
        this.mDuration = timeUnit.toMicros(j);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMvAudioId(int i) {
        this.mMvAudioId = i;
    }

    public void setOldId(int i) {
        this.mOldId = i;
    }

    @Deprecated
    public void setPath(String str) {
        this.mSource = new Source(str);
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setStartTime(long j) {
        setStartTime(j, TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, TimeUnit timeUnit) {
        this.mStartTime = timeUnit.toMicros(j);
    }

    public void setStreamDuration(long j) {
        setStreamDuration(j, TimeUnit.MICROSECONDS);
    }

    public void setStreamDuration(long j, TimeUnit timeUnit) {
        this.mStreamDuration = timeUnit.toMicros(j);
    }

    public void setStreamStartTime(long j) {
        setStreamStartTime(j, TimeUnit.MICROSECONDS);
    }

    public void setStreamStartTime(long j, TimeUnit timeUnit) {
        this.mStreamStartTime = timeUnit.toMicros(j);
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }

    public TrackAudioStream toTrackAudioStream() {
        TrackAudioStream.Builder builderSource = new TrackAudioStream.Builder().streamId(getId()).source(getSource());
        long startTime = getStartTime();
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return builderSource.startTime(startTime, timeUnit).streamStartTime(getStreamStartTime(), timeUnit).streamDuration(getStreamDuration(), timeUnit).audioWeight(getWeight()).build();
    }

    public TrackEffectFilter toTrackEffectFilter() {
        TrackEffectFilter.Builder builderSource = new TrackEffectFilter.Builder().source(getSource());
        long startTime = getStartTime();
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return builderSource.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).resId(getId()).build();
    }

    public TrackEffectMV toTrackMV() {
        TrackEffectMV.Builder builderSource = new TrackEffectMV.Builder().source(getSource());
        long startTime = getStartTime();
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        TrackEffectMV trackEffectMVBuild = builderSource.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).build();
        trackEffectMVBuild.setAudioStreamId(getMvAudioId());
        trackEffectMVBuild.setViewId(getId());
        return trackEffectMVBuild;
    }
}
