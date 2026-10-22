package com.alipay.mobile.jsengine;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25357a;
    private Map<String, String> b;
    private Map<String, String> c;
    private Map<String, String> d;
    private Map<String, String> e;
    private Map<String, String> f;

    private LogData(String str) {
        this.f25357a = str;
    }

    public static LogData seedId(String str) {
        return new LogData(str);
    }

    public LogData add(String str, Object obj) {
        Map<String, String> map = this.f;
        if (map == null) {
            return this;
        }
        map.put(str, obj == null ? "" : obj.toString());
        return this;
    }

    public Map<String, String> getParam1Map() {
        return this.b;
    }

    public Map<String, String> getParam2Map() {
        return this.c;
    }

    public Map<String, String> getParam3Map() {
        return this.d;
    }

    public Map<String, String> getParam4Map() {
        return this.e;
    }

    public String getSeedId() {
        return this.f25357a;
    }

    public LogData param1() {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.f = this.b;
        return this;
    }

    public LogData param2() {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.f = this.c;
        return this;
    }

    public LogData param3() {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.f = this.d;
        return this;
    }

    public LogData param4() {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.f = this.e;
        return this;
    }
}
