package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackEffectMV extends EffectBase {
    private int audioStreamId;
    private long duration;
    private long startTime;

    @Visible
    public static final class Builder {
        private TrackEffectMV effectMv = new TrackEffectMV();

        public TrackEffectMV build() {
            return this.effectMv;
        }

        public Builder duration(long j, TimeUnit timeUnit) {
            this.effectMv.duration = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public Builder source(Source source) {
            this.effectMv.setSource(source);
            return this;
        }

        public Builder startTime(long j, TimeUnit timeUnit) {
            this.effectMv.startTime = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    public int getAudioStreamId() {
        return this.audioStreamId;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, TimeUnit.MILLISECONDS);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
    }

    public void setAudioStreamId(int i) {
        this.audioStreamId = i;
    }
}
