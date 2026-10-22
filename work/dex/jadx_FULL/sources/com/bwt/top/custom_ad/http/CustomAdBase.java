package com.bwt.top.custom_ad.http;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CustomAdBase implements Serializable {

    @JSONField(name = "result")
    private CustomAdPosResult adPosResult;
    private String msg;

    public CustomAdPosResult getAdPosResult() {
        return this.adPosResult;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAdPosResult(CustomAdPosResult customAdPosResult) {
        this.adPosResult = customAdPosResult;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ChannelAdBase{msg='" + this.msg + "', adPosResult=" + this.adPosResult + '}';
    }
}
