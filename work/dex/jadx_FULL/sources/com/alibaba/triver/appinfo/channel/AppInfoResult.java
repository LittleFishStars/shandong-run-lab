package com.alibaba.triver.appinfo.channel;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppInfoResult implements Serializable {
    public String channel;
    public List<TriverAppModel> data;

    public AppInfoResult(String str, List<TriverAppModel> list) {
        this.data = list;
        this.channel = str;
    }
}
