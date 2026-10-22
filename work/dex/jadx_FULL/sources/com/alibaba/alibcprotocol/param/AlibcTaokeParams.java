package com.alibaba.alibcprotocol.param;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTaokeParams implements Serializable {
    private static final String TAG = "AlibcTaokeParams";
    private static final long serialVersionUID = -991490994204513259L;
    public Map<String, String> extParams = new HashMap(16);
    public String materialSourceUrl;
    public String pid;
    public String relationId;
    public String subPid;
    public String unionId;

    public AlibcTaokeParams(String str, String str2, String str3) {
        this.pid = str;
        this.subPid = str2;
        this.unionId = str3;
    }

    public String toString() {
        return "AlibcTaokeParams{pid=" + this.pid + ", subPid=" + this.subPid + "}";
    }

    public AlibcTaokeParams(String str) {
        this.pid = str;
    }
}
