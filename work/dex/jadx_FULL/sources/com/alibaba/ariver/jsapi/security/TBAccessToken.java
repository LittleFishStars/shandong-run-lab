package com.alibaba.ariver.jsapi.security;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBAccessToken implements Serializable {
    public String accessToken;
    public long expirationTime;

    public TBAccessToken() {
    }

    public boolean isFailure() {
        return TextUtils.isEmpty(this.accessToken) || this.expirationTime <= System.currentTimeMillis();
    }

    public TBAccessToken(String str) {
        JSONObject object = JSON.parseObject(str);
        this.accessToken = object.getString("accessToken");
        this.expirationTime = object.getLong("expirationTime").longValue();
    }
}
