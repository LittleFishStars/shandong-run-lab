package com.igexin.push.core.b;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.core.ServiceManager;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.u15;
import com.zj.adlib.ze1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f37951a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f = "open";
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public long n;
    public String o;

    public a() {
        if (com.igexin.push.core.e.g != null) {
            this.f += u15.f19942b + com.igexin.push.core.e.g;
        }
        this.e = "3.3.7.0";
        this.b = com.igexin.push.core.e.E;
        this.c = com.igexin.push.core.e.D;
        this.d = com.igexin.push.g.n.c();
        this.f37951a = com.igexin.push.core.e.F;
        this.h = "ANDROID";
        this.j = "android" + Build.VERSION.RELEASE;
        this.k = "MDP";
        this.g = com.igexin.push.core.e.H;
        this.n = System.currentTimeMillis();
        this.l = com.igexin.push.core.e.I;
        this.m = com.igexin.push.core.e.G;
        this.o = com.igexin.push.core.e.C;
        if (!com.igexin.assist.sdk.a.a().c() || AssistPushManager.checkSupportDevice(com.igexin.push.core.e.l)) {
            return;
        }
        StringBuilder sb = new StringBuilder("FCM-");
        String str = this.m;
        sb.append(str == null ? "" : str);
        this.m = sb.toString();
    }

    private static String a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = aVar.f37951a;
        if (str == null) {
            str = "";
        }
        jSONObject.put(ze1.k, str);
        String str2 = aVar.b;
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("sim", str2);
        String str3 = aVar.c;
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put(DeviceIdType.IMEI, str3);
        jSONObject.put("mac", aVar.d == null ? "" : com.igexin.push.g.n.c());
        String str4 = aVar.e;
        if (str4 == null) {
            str4 = "";
        }
        jSONObject.put("version", str4);
        String str5 = aVar.f;
        if (str5 == null) {
            str5 = "";
        }
        jSONObject.put("channelid", str5);
        jSONObject.put("type", "ANDROID");
        String str6 = aVar.k;
        if (str6 == null) {
            str6 = "";
        }
        jSONObject.put(NativeCallContext.DOMAIN_APP, str6);
        StringBuilder sb = new StringBuilder("ANDROID-");
        String str7 = aVar.g;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        jSONObject.put("deviceid", sb.toString());
        String str8 = aVar.l;
        if (str8 == null) {
            str8 = "";
        }
        jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, str8);
        String str9 = aVar.m;
        if (str9 == null) {
            str9 = "";
        }
        jSONObject.put("brand", str9);
        String str10 = aVar.j;
        if (str10 == null) {
            str10 = "";
        }
        jSONObject.put("system_version", str10);
        String str11 = aVar.i;
        if (str11 == null) {
            str11 = "";
        }
        jSONObject.put("cell", str11);
        jSONObject.put("aid", com.igexin.push.g.n.h());
        jSONObject.put("adid", com.igexin.push.g.n.i());
        jSONObject.put("gtcid", TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
        String str12 = com.igexin.push.core.e.h;
        if (str12 == null) {
            str12 = "";
        }
        jSONObject.put(DeviceIdType.OAID, str12);
        ServiceManager.getInstance();
        String strE = ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.ap.equals(strE)) {
            jSONObject.put(com.igexin.push.g.o.f38157a, strE);
        }
        ServiceManager.getInstance();
        jSONObject.put("ua", ServiceManager.d(com.igexin.push.core.e.l));
        jSONObject.put("notification_enabled", com.igexin.push.g.c.b(com.igexin.push.core.e.l) ? 1 : 0);
        jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "addphoneinfo");
        jSONObject2.put("id", String.valueOf(aVar.n));
        jSONObject2.put(AliyunLogCommon.LogLevel.INFO, jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("guardMe", String.valueOf(com.igexin.push.config.e.b()));
        jSONObject3.put("guardOthers", String.valueOf(com.igexin.push.config.e.c()));
        jSONObject2.put("extra", jSONObject3);
        return jSONObject2.toString();
    }
}
