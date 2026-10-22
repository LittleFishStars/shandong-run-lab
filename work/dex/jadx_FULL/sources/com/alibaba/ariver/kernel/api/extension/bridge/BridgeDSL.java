package com.alibaba.ariver.kernel.api.extension.bridge;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeDSL {
    public static final String CMD = "cmd";
    public static final String EVENT = "event";
    public static final String INVOKE = "invoke";
    public static final String NAME = "name";
    public static final String NAME_SPACE = "namespace";
    public static final String TYPE = "type";
    String cmd;
    String name;
    String namespace;
    String type;

    public BridgeDSL(String str, String str2, String str3, String str4) {
        this.cmd = str;
        this.name = str2;
        this.namespace = str3;
        this.type = str4;
    }

    public String toJSONString() {
        if (TextUtils.equals(INVOKE, this.type)) {
            return "{'namespace':'" + this.namespace + "','name':'" + this.name + "','cmd':'" + this.cmd + "','type':'" + this.type + "'}";
        }
        if (!TextUtils.equals("event", this.type)) {
            RVLogger.e("Register DSL error: Invalid type [" + this.type + "]");
            return "";
        }
        return "{'namespace':'" + this.namespace + "','name':'" + this.name + "','type':'" + this.type + "'}";
    }

    public BridgeDSL(String str, String str2, String str3) {
        this.name = str;
        this.namespace = str2;
        this.type = str3;
        this.cmd = "";
    }
}
