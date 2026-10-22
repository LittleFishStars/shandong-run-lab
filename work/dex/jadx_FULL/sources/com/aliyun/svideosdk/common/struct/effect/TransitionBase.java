package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.common.b.b;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TransitionBase extends Effect {
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 2;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int TRANSITION_TYPE_CIRCLE = 2;
    public static final int TRANSITION_TYPE_CUSTOM = 5;
    public static final int TRANSITION_TYPE_FADE = 4;
    public static final int TRANSITION_TYPE_FIVEPOINTSTAR = 3;
    public static final int TRANSITION_TYPE_SHUTTER = 0;
    public static final int TRANSITION_TYPE_TRANSLATE = 1;

    @SerializedName("CustomSource")
    protected Source mCustomSource;
    private transient EffectConfig mEffectConfig;

    @SerializedName("OverlapDuration")
    private float mOverlapDurationSec;

    @SerializedName("ParamString")
    protected String mParamsString;

    @SerializedName("TransitionType")
    public int mType;

    public TransitionBase() {
        super(Effect.Type.transition);
        this.mType = 5;
    }

    public TransitionBase(Source source) {
        super(Effect.Type.transition);
        this.mType = 5;
        if (source == null || q.b(source.getPath())) {
            return;
        }
        this.mType = 5;
        this.mCustomSource = source;
        initCustom();
    }

    @Deprecated
    public TransitionBase(String str) {
        this(new Source(str));
    }

    private void initCustom() {
        try {
            this.mEffectConfig = (EffectConfig) new b().readValue(new File(this.mCustomSource.getPath(), "config.json"), EffectConfig.class);
            if (q.b(this.mParamsString)) {
                this.mParamsString = toJsonString();
            } else {
                this.mEffectConfig.readParamsJson(this.mParamsString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Source getCustomSource() {
        return this.mCustomSource;
    }

    public EffectConfig getEffectConfig() {
        Source source = this.mCustomSource;
        if (source != null && !q.b(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        return this.mEffectConfig;
    }

    public List<EffectConfig.NodeBean> getNodeTree() {
        Source source = this.mCustomSource;
        if (source != null && !q.b(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getNodeTree();
    }

    public long getOverlapDuration() {
        return (long) (this.mOverlapDurationSec * 1000000.0f);
    }

    public long getOverlapDuration(TimeUnit timeUnit) {
        return timeUnit.convert(getOverlapDuration(), TimeUnit.MICROSECONDS);
    }

    public void setCustomSource(Source source) {
        if (source == null || q.b(source.getPath())) {
            return;
        }
        this.mType = 5;
        this.mCustomSource = source;
        initCustom();
    }

    public void setEffectConfig(EffectConfig effectConfig) {
        if (effectConfig != null) {
            this.mParamsString = effectConfig.getParamsJsonString();
        }
        this.mEffectConfig = effectConfig;
    }

    public void setOverlapDuration(long j) {
        setOverlapDuration(j, TimeUnit.MICROSECONDS);
    }

    public void setOverlapDuration(long j, TimeUnit timeUnit) {
        this.mOverlapDurationSec = timeUnit.toMillis(j) / 1000.0f;
    }

    public void setParamsString(String str) {
        this.mParamsString = str;
    }

    public String toJsonString() {
        Source source = this.mCustomSource;
        if (source != null && !q.b(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getParamsJsonString();
    }
}
