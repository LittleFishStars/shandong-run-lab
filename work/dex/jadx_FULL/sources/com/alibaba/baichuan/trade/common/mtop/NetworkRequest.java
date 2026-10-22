package com.alibaba.baichuan.trade.common.mtop;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkRequest implements Serializable {
    public String accessToken;
    public String apiName;
    public String apiVersion;
    public Map<String, String> extHeaders;
    public Map<String, String> extQueries;
    public boolean isVip;
    public String openAppKey;
    public Map<String, Object> paramMap;
    public int requestType;
    public String ttid;
    public boolean needLogin = false;
    public boolean needCache = false;
    public boolean needAuth = false;
    public boolean needWua = false;
    public boolean showAuthUI = false;
    public boolean isPost = true;
    public String authParams = "";
    public int timeOut = -1;

    public boolean checkApiExist() {
        return (TextUtils.isEmpty(this.apiName) || TextUtils.isEmpty(this.apiVersion)) ? false : true;
    }

    public String toString() {
        return "NetworkRequest [apiName=" + this.apiName + ", apiVersion=" + this.apiVersion + ", params=" + this.paramMap + ", openAppKey=" + this.openAppKey + ", accessToken=" + this.accessToken + ", ttid=" + this.ttid + ", needAuth=" + this.needAuth + ", needWua=" + this.needWua + "]";
    }
}
