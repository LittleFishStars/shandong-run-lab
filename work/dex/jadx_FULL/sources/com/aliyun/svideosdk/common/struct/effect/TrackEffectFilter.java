package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackEffectFilter extends TrackEffect<EffectFilter> {

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Source f25669a;
        private long b;
        private long c;
        private EffectConfig d;
        private int e = 0;

        public TrackEffectFilter build() {
            EffectFilter effectFilter = new EffectFilter(this.f25669a);
            effectFilter.setEffectConfig(this.d);
            int i = this.e;
            if (i != 0) {
                effectFilter.setResId(i);
            }
            return new TrackEffectFilter(this.b, this.c, effectFilter);
        }

        public Builder duration(long j, TimeUnit timeUnit) {
            this.c = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public Builder effectConfig(EffectConfig effectConfig) {
            this.d = effectConfig;
            return this;
        }

        public Builder resId(int i) {
            this.e = i;
            return this;
        }

        public Builder source(Source source) {
            this.f25669a = source;
            return this;
        }

        public Builder startTime(long j, TimeUnit timeUnit) {
            this.b = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    private TrackEffectFilter(long j, long j2, EffectFilter effectFilter) {
        super(j, j2, effectFilter);
        effectFilter.setStartTime(j);
        effectFilter.setDuration(j2);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.TrackEffect
    public void setDuration(long j, TimeUnit timeUnit) {
        super.setDuration(j, timeUnit);
        ((EffectFilter) this.bean).setDuration(this.duration);
    }

    public void setEffectConfig(EffectConfig effectConfig) {
        ((EffectFilter) this.bean).setEffectConfig(effectConfig);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.TrackEffect
    public void setStartTime(long j, TimeUnit timeUnit) {
        super.setStartTime(j, timeUnit);
        ((EffectFilter) this.bean).setStartTime(this.startTime);
    }
}
