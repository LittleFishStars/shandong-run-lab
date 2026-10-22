package com.alibaba.alibclinkpartner.smartlink.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MAtrixAppData implements Serializable {
    public Map<String, MatrixAppInfoDetail> appinfo = new HashMap();
    public String sign;
    public String validtime;
    public String version;
}
