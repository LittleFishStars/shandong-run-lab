package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class PasterTrack extends Track {

    @SerializedName("Type")
    private Type mType;

    public enum Type {
        photo,
        gif,
        subtitle,
        bubble_caption,
        caption,
        roll_captions
    }

    public Type getType() {
        return this.mType;
    }

    public void setType(Type type) {
        this.mType = type;
    }
}
