package com.alibaba.triver.open.prefetch.context;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopPrefetchContext extends PrefetchContext implements Serializable {
    public MtopTaskParams params;

    public static class MtopTaskParams implements Serializable {
        public String api;
        public JSONObject apiParams;
        public String ext_headers;
        public String mpHost;
        public List<String> mtopIgnore;
        public boolean needLogin;
        public List<String> queryBlackList;
        public String ua;
        public String version;
        public String requestType = "GET";
        public String dataType = "originaljson";
        public int secType = 0;
        public long timeout = 5000;
        public long expire = 5000;
        public String sessionOption = "AutoLoginAndManualLogin";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", params=");
        MtopTaskParams mtopTaskParams = this.params;
        sb.append(mtopTaskParams == null ? "{}" : mtopTaskParams.toString());
        return sb.toString();
    }
}
