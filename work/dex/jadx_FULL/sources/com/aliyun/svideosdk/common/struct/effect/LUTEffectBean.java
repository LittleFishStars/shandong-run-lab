package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class LUTEffectBean {
    private float mIntensity = 1.0f;
    private Source mSource;

    public float getIntensity() {
        return this.mIntensity;
    }

    public Source getSource() {
        return this.mSource;
    }

    public void setIntensity(float f) {
        this.mIntensity = f;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }
}
