package com.ali.auth.third.core.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RpcRequest {
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;
    public ArrayList<String> paramNames = new ArrayList<>();
    public ArrayList<Object> paramValues = new ArrayList<>();
    public String target;
    public String version;

    public void addParam(String str, Object obj) {
        this.paramNames.add(str);
        this.paramValues.add(obj);
    }

    public String toString() {
        return "RpcRequest [target=" + this.target + ", version=" + this.version + ", params=]";
    }
}
