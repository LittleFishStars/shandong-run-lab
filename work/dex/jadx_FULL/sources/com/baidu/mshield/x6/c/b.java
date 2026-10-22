package com.baidu.mshield.x6.c;

import android.view.InputDevice;
import com.baidu.mshield.x6.f.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {
    public static String a() {
        try {
            int[] deviceIds = InputDevice.getDeviceIds();
            JSONArray jSONArray = new JSONArray();
            for (int i : deviceIds) {
                InputDevice device = InputDevice.getDevice(i);
                if (device != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", device.getName());
                    jSONObject.put("1", device.isVirtual() ? 1 : 0);
                    jSONObject.put("2", device.getVendorId());
                    jSONObject.put("3", device.getSources());
                    String string = device.toString();
                    jSONObject.put("4", string.indexOf("Location: built-in") > 0 ? 1 : string.indexOf("Location: external") > 0 ? 2 : 0);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString().replace("   ", "");
        } catch (Exception e) {
            f.b(e);
            return "";
        }
    }

    public static boolean b() {
        return true;
    }
}
