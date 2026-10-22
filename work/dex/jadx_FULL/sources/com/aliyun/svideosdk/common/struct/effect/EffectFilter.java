package com.aliyun.svideosdk.common.struct.effect;

import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.b.b;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectFilter extends EffectBase {
    private long mDuration;
    private EffectConfig mEffectConfig;
    private long mStartTime;
    private String name;

    @Visible
    public static final class Builder {
        private long mDuration;
        private EffectConfig mEffectConfig;
        private long mStartTime;
        private Source source;

        public EffectFilter build() {
            return new EffectFilter(this);
        }

        @Deprecated
        public Builder duration(long j) {
            this.mDuration = j;
            return this;
        }

        public Builder effectConfig(EffectConfig effectConfig) {
            this.mEffectConfig = effectConfig;
            return this;
        }

        @Deprecated
        public Builder path(String str) {
            this.source = new Source(str);
            return this;
        }

        public Builder source(Source source) {
            this.source = source;
            return this;
        }

        @Deprecated
        public Builder startTime(long j) {
            this.mStartTime = j;
            return this;
        }
    }

    private EffectFilter(Builder builder) {
        setSource(builder.source);
        setStartTime(builder.mStartTime);
        setDuration(builder.mDuration);
        try {
            this.mEffectConfig = (EffectConfig) new b().readValue(new File(builder.source.getPath(), "config.json"), EffectConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (builder.mEffectConfig != null) {
            setEffectConfig(builder.mEffectConfig);
        }
    }

    public EffectFilter(Source source) {
        if (source == null || q.b(source.getPath())) {
            Log.e("AliYunLog", "Invalid path");
            return;
        }
        setSource(source);
        String string = readString(source.getPath() + "/config.json");
        try {
            this.name = new JSONObject(string).optString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.mEffectConfig = (EffectConfig) new b().readValue(string, EffectConfig.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public EffectFilter(String str) {
        this(new Source(str));
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(EffectBase effectBase) {
        if (effectBase instanceof EffectFilter) {
            EffectFilter effectFilter = (EffectFilter) effectBase;
            try {
                b bVar = new b();
                this.mEffectConfig.getParamsJsonString();
                effectFilter.setEffectConfig((EffectConfig) bVar.readValue(bVar.writeValue(this.mEffectConfig), EffectConfig.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EffectFilter effectFilter = (EffectFilter) obj;
        if (this.mStartTime != effectFilter.mStartTime || this.mDuration != effectFilter.mDuration) {
            return false;
        }
        String str = this.name;
        String str2 = effectFilter.name;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    @Deprecated
    public long getDuration() {
        return this.mDuration;
    }

    public EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    @Deprecated
    public String getName() {
        return this.name;
    }

    public List<EffectConfig.NodeBean> getNodeTree() {
        EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getNodeTree();
    }

    @Deprecated
    public long getStartTime() {
        return this.mStartTime;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.mStartTime;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.mDuration;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Deprecated
    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEffectConfig(EffectConfig effectConfig) {
        this.mEffectConfig = effectConfig;
    }

    @Deprecated
    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public String toJsonString() {
        EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getParamsJsonString();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public String toString() {
        return "EffectFilter{name='" + this.name + "', mStartTime=" + this.mStartTime + ", mDuration=" + this.mDuration + '}';
    }

    public TrackEffectFilter toTrackEffectFilter() {
        TrackEffectFilter.Builder builderSource = new TrackEffectFilter.Builder().source(this.mSource);
        long startTime = getStartTime();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TrackEffectFilter trackEffectFilterBuild = builderSource.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).resId(getResId()).build();
        trackEffectFilterBuild.setViewId(getViewId());
        return trackEffectFilterBuild;
    }
}
