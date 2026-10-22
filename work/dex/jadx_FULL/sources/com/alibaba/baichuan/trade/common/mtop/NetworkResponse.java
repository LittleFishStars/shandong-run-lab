package com.alibaba.baichuan.trade.common.mtop;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkResponse implements Serializable {
    public byte[] byteData;
    public Map<String, Object> data;
    public String errorCode;
    public String errorMsg;
    public String httpCode;
    public boolean isSuccess;
    public String jsonData;
    public Object object;
    public String[] ret;

    public boolean isSuccess() {
        return this.isSuccess;
    }
}
