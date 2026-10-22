package cj.mobile.wm.common.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
