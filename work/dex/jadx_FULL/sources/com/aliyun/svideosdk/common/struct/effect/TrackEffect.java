package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackEffect<BEAN extends EffectBase> {
    protected BEAN bean;
    protected long duration;
    protected long startTime;

    public TrackEffect(long j, long j2, BEAN bean) {
        this.bean = bean;
        this.startTime = j;
        this.duration = j2;
    }

    public BEAN getBean() {
        return this.bean;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, TimeUnit.MILLISECONDS);
    }

    public long getEndTime() {
        return this.startTime + this.duration;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime + this.duration, TimeUnit.MILLISECONDS);
    }

    public int getResId() {
        return this.bean.getResId();
    }

    public Source getSource() {
        return this.bean.getSource();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
    }

    public int getViewId() {
        return this.bean.getViewId();
    }

    public void setDuration(long j, TimeUnit timeUnit) {
        this.duration = Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setSource(Source source) {
        this.bean.setSource(source);
    }

    public void setStartTime(long j, TimeUnit timeUnit) {
        this.startTime = Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setViewId(int i) {
        this.bean.setViewId(i);
    }
}
