package com.aliyun.svideosdk.common.struct.project;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Frame implements Serializable {
    public float alpha;
    public int pic;
    public float time;

    public float getAlpha() {
        return this.alpha;
    }

    public int getPic() {
        return this.pic;
    }

    public float getTime() {
        return this.time;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setPic(int i) {
        this.pic = i;
    }

    public void setTime(float f) {
        this.time = f;
    }
}
