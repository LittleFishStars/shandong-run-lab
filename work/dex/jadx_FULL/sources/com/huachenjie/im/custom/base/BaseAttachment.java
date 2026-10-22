package com.huachenjie.im.custom.base;

import com.google.gson.Gson;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseAttachment implements MsgAttachment {
    public int customType;

    public abstract int getCustomType();

    public String packData() {
        this.customType = getCustomType();
        try {
            return new Gson().toJson(this);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String toJson(boolean z) {
        return packData();
    }
}
