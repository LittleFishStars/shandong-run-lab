package com.zj.adlib;

import android.os.Build;
import android.os.SystemClock;
import cn.hzjizhun.admin.base.b;
import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class kha extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17684a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f17685b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f17686b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f17687c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f17688c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f17689d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f17690d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f17691e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f17692e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f17693f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f17694f;
    public float g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f17695g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f17696g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f17697h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f17698i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f17699j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f17700k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;

    public final JSONObject b() {
        try {
            ((b) this).f22696a.put("version", 38);
            ((b) this).f22696a.put("sdkv", "2.1.0");
            ((b) this).f22696a.put("osversion", Build.VERSION.RELEASE);
            ((b) this).f22696a.put("apiLevel", Build.VERSION.SDK_INT);
            ((b) this).f22696a.put(com.igexin.push.core.b.aC, b.a(this.f17684a));
            ((b) this).f22696a.put("deviceId", b.a(this.f17686b));
            ((b) this).f22696a.put("os", 1);
            ((b) this).f22696a.put("appversion", b.a(this.f17688c));
            ((b) this).f22696a.put("lat", this.f42822a);
            ((b) this).f22696a.put("lng", this.b);
            ((b) this).f22696a.put("screenwidth", this.f17683a);
            ((b) this).f22696a.put("screenheight", this.f17685b);
            ((b) this).f22696a.put("webviewW", this.i);
            ((b) this).f22696a.put("webviewH", this.j);
            ((b) this).f22696a.put("ua", b.a(this.f17696g));
            ((b) this).f22696a.put("mac", b.a(this.f17694f));
            ((b) this).f22696a.put("wifiname", b.a(this.m));
            ((b) this).f22696a.put("imsi", b.a(this.f17690d));
            ((b) this).f22696a.put("network", b.a(this.f17697h));
            ((b) this).f22696a.put(ze1.k, b.a(this.f17698i));
            ((b) this).f22696a.put("vendor", b.a(this.f17699j));
            ((b) this).f22696a.put(DeviceIdType.IMEI, b.a(this.f17692e));
            ((b) this).f22696a.put("vaid", b.a(this.n));
            ((b) this).f22696a.put(DeviceIdType.OAID, b.a(this.p));
            ((b) this).f22696a.put("aaid", b.a(this.o));
            ((b) this).f22696a.put(DeviceIdType.ANDROID_ID, b.a(this.q));
            ((b) this).f22696a.put("sysUpdateMark", b.a(this.f17700k));
            ((b) this).f22696a.put("sysBootMark", b.a(this.l));
            ((b) this).f22696a.put("comptime", SystemClock.elapsedRealtime());
            ((b) this).f22696a.put("elapseTime", SystemClock.uptimeMillis());
            ((b) this).f22696a.put("density", this.c);
            ((b) this).f22696a.put("densitydpi", this.f17687c);
            ((b) this).f22696a.put("screenSize", this.d);
            ((b) this).f22696a.put("orientation", this.f17689d);
            ((b) this).f22696a.put("memSize", this.e);
            ((b) this).f22696a.put("cpuNum", this.f17691e);
            ((b) this).f22696a.put("operator", this.k);
            ((b) this).f22696a.put("cpuFrequency", this.g);
            ((b) this).f22696a.put("diskSize", this.f);
            ((b) this).f22696a.put("romversion", b.a(this.r));
            ((b) this).f22696a.put("vivoStoreVersion", b.a(this.s));
            ((b) this).f22696a.put("oppoStoreVersion", b.a(this.t));
            ((b) this).f22696a.put("hwStoreVersion", b.a(this.u));
            ((b) this).f22696a.put("hmsCoreVersion", b.a(this.v));
            ((b) this).f22696a.put("vivoStoreVersionCode", this.f17693f);
            ((b) this).f22696a.put("oppoStoreVersionCode", this.f17695g);
            ((b) this).f22696a.put("hwStoreVersionCode", this.h);
            ((b) this).f22696a.put("hmsCoreVersionCode", b.a(this.w));
            ((b) this).f22696a.put("sysCompilingTime", b.a(String.valueOf(Build.TIME)));
        } catch (Throwable unused) {
        }
        return ((b) this).f22696a;
    }
}
