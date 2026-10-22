package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cr f40093a = new cr();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            cr crVar = new cr();
            int iA = crVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (iA > 0) {
                jSONObject.put("0", iA);
            }
            int iA2 = crVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (iA2 > 0) {
                jSONObject.put("1", iA2);
            }
            int iA3 = crVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (iA3 > 0) {
                jSONObject.put("2", iA3);
            }
            int iA4 = crVar.a(Location.class, "getLatitude", new Object[0]);
            if (iA4 > 0) {
                jSONObject.put("3", iA4);
            }
            int iA5 = crVar.a(Location.class, "getLongitude", new Object[0]);
            if (iA5 > 0) {
                jSONObject.put("4", iA5);
            }
            int iA6 = crVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (iA6 > 0) {
                jSONObject.put("6", iA6);
            }
            int iA7 = crVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (iA7 > 0) {
                jSONObject.put("7", iA7);
            }
            int iA8 = crVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (iA8 > 0) {
                jSONObject.put(PrepareException.ERROR_AUTH_FAIL, iA8);
            }
            int iA9 = crVar.a(JSONObject.class, "toString", new Object[0]);
            if (iA9 > 0) {
                jSONObject.put("9", iA9);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int iA = this.f40093a.a();
            if (iA <= 0) {
                return null;
            }
            int iA2 = this.f40093a.a(iA, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (iA2 > 0) {
                jSONObject.put("0", iA2);
            }
            int iA3 = this.f40093a.a(iA, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (iA3 > 0) {
                jSONObject.put("1", iA3);
            }
            int iA4 = this.f40093a.a(iA, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (iA4 > 0) {
                jSONObject.put("2", iA4);
            }
            int iA5 = this.f40093a.a(iA, Location.class, "getLatitude", new Object[0]);
            if (iA5 > 0) {
                jSONObject.put("3", iA5);
            }
            int iA6 = this.f40093a.a(iA, Location.class, "getLongitude", new Object[0]);
            if (iA6 > 0) {
                jSONObject.put("4", iA6);
            }
            int iA7 = this.f40093a.a(iA, WifiInfo.class, "getMacAddress", new Object[0]);
            if (iA7 > 0) {
                jSONObject.put("6", iA7);
            }
            int iA8 = this.f40093a.a(iA, WifiInfo.class, "getBSSID", new Object[0]);
            if (iA8 > 0) {
                jSONObject.put("7", iA8);
            }
            int iA9 = this.f40093a.a(iA, WifiInfo.class, "getRssi", new Object[0]);
            if (iA9 > 0) {
                jSONObject.put(PrepareException.ERROR_AUTH_FAIL, iA9);
            }
            int iA10 = this.f40093a.a(iA, JSONObject.class, "toString", new Object[0]);
            if (iA10 > 0) {
                jSONObject.put("9", iA10);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
