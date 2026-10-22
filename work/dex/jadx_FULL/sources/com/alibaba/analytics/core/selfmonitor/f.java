package com.alibaba.analytics.core.selfmonitor;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {
    public static int INTERFACE;
    private static HashMap<Integer, String> e;
    public static int j;
    public static int k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static int s;
    public static int t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EventType f23786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DimensionValueSet f657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MeasureValueSet f658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Double f659a;
    public String aT;
    public String monitorPoint;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        e = map;
        INTERFACE = 1;
        j = 2;
        k = 3;
        l = 4;
        m = 5;
        n = 6;
        o = 7;
        p = 8;
        q = 9;
        r = 10;
        s = 11;
        t = 12;
        map.put(1, "sampling_monitor");
        e.put(Integer.valueOf(j), "db_clean");
        e.put(Integer.valueOf(m), "db_monitor");
        e.put(Integer.valueOf(k), "upload_failed");
        e.put(Integer.valueOf(l), "upload_traffic");
        e.put(Integer.valueOf(n), "config_arrive");
        e.put(Integer.valueOf(o), "tnet_request_send");
        e.put(Integer.valueOf(p), "tnet_create_session");
        e.put(Integer.valueOf(q), "tnet_request_timeout");
        e.put(Integer.valueOf(r), "tent_request_error");
        e.put(Integer.valueOf(s), "datalen_overflow");
        e.put(Integer.valueOf(t), "logs_timeout");
    }

    private f(String str, String str2, Double d) {
        this.f23786a = null;
        this.monitorPoint = str;
        this.aT = str2;
        this.f659a = d;
        this.f23786a = EventType.COUNTER;
    }

    public static f a(int i, String str, Double d) {
        return new f(b(i), str, d);
    }

    private static String b(int i) {
        return e.get(Integer.valueOf(i));
    }

    public String toString() {
        return "SelfMonitorEvent{arg='" + this.aT + "', monitorPoint='" + this.monitorPoint + "', type=" + this.f23786a + ", value=" + this.f659a + ", dvs=" + this.f657a + ", mvs=" + this.f658a + '}';
    }
}
