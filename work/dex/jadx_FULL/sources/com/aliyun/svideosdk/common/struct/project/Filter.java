package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.aliyun.common.b.b;
import com.aliyun.svideosdk.common.struct.effect.EffectConfig;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Filter extends EffectTrack {
    private transient EffectConfig mEffectConfig;

    @SerializedName("Intensity")
    private float mIntensity;

    @SerializedName("Source")
    private Source mSource;

    public Filter(Source source) {
        this.mSource = source;
        initEffectConfig(source.getPath());
    }

    @Deprecated
    public Filter(String str) {
        this(new Source(str));
    }

    private void initEffectConfig(String str) {
        try {
            this.mEffectConfig = (EffectConfig) new b().readValue(readString(str + "/config.json"), EffectConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readString(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            FileReader fileReader = new FileReader(new File(str));
            while (true) {
                int i = fileReader.read();
                if (i == -1) {
                    break;
                }
                stringBuffer.append((char) i);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public long getDuration() {
        return (long) ((getTimelineOut() - getTimelineIn()) * 1000.0f);
    }

    public EffectConfig getEffectConfig() {
        Source source;
        if (this.mEffectConfig == null && (source = this.mSource) != null) {
            initEffectConfig(source.getPath());
        }
        return this.mEffectConfig;
    }

    public float getIntensity() {
        return this.mIntensity;
    }

    public Source getSource() {
        return this.mSource;
    }

    public long getStartTime() {
        return (long) (getTimelineIn() * 1000.0f);
    }

    public void setEffectConfig(EffectConfig effectConfig) {
        this.mEffectConfig = effectConfig;
    }

    public void setIntensity(float f) {
        this.mIntensity = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }
}
