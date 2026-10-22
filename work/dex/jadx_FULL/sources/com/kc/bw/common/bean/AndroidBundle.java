package com.kc.bw.common.bean;

import com.google.gson.annotations.SerializedName;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AndroidBundle {

    @SerializedName("k")
    public int key;

    @SerializedName("v")
    public String value;

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
