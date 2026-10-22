package com.byazt.vx;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.pf;
import com.byazt.nys.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.hms.adapter.internal.CommonCode;
import com.ipd.dsp.internal.v0.q;
import com.kc.openset.constant.DeviceIdType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 117})
public class rl {
    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.dna.u uVar = (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            jSONObject.put("os", uVar.getOs());
            String strC = DeviceUtils.c((Boolean) null);
            jSONObject.put(DeviceIdType.IMEI, strC);
            jSONObject.put("imei_md5", gt.c(strC));
            jSONObject.put(DeviceIdType.OAID, veVar.getOAID(false));
            jSONObject.put("applog_did", veVar.getDid());
            jSONObject.put("device_model", uVar.getDeviceModel());
            jSONObject.put("vendor", uVar.getVendor());
            jSONObject.put("ua", uVar.getUserAgent());
            jSONObject.put(LoginConstants.IP, com.byazt.aas.my.c());
            jSONObject.put("package_name", eo.c());
            jSONObject.put("publisher_did", com.byazt.bp.c.t().rh());
            jSONObject.put("android_id", DeviceUtils.tt());
            jSONObject.put("os_version", uVar.getOsVersion());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        Context context = com.byazt.bp.tt.getContext();
        try {
            com.byazt.dna.u uVar = (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
            String did = ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid();
            jSONObject.put("device_id", did);
            if (TextUtils.isEmpty(did)) {
                did = UUID.randomUUID().toString();
            }
            jSONObject.put("user_unique_id", did);
            jSONObject.put("sdk_version", com.byazt.yl.tt.tt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", uVar.getOsVersion());
            jSONObject.put("device_model", uVar.getDeviceModel());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, com.byazt.eu.a.ve(com.byazt.bp.tt.getContext()) + "x" + com.byazt.eu.a.tt(com.byazt.bp.tt.getContext()));
            jSONObject.put(MediaFormat.KEY_LANGUAGE, uVar.getLanguage());
            jSONObject.put("timezone", uVar.getTimeZoneInt());
            jSONObject.put("access", qy.ve());
            jSONObject.put("openudid", DeviceUtils.tt());
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", sp.tt());
            jSONObject.put(AlibcCommonConstant.APP_VERSION, sp.c());
            jSONObject.put("package", eo.c());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", uVar.getRom());
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            c(context, jSONObject);
            jSONObject.put("display_density", pf.a());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.byazt.eu.a.n(context));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", uVar.getBuildSerial());
            jSONObject.put("version_code", eo.tt());
            jSONObject.put("udid", DeviceUtils.c((Boolean) null));
            jSONObject.put("custom", ve());
            String strC = com.byazt.aas.my.c();
            if (TextUtils.isEmpty(strC)) {
                strC = q.i;
            } else if (strC.contains(",")) {
                strC = c(strC);
            }
            jSONObject.put(LoginConstants.IP, strC);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    private static JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            String strC = DeviceUtils.c((Boolean) null);
            jSONObject.put(DeviceIdType.IMEI, strC);
            jSONObject.put("imei_md5", gt.c(strC));
            jSONObject.put("applog_did", veVar.getDid());
            jSONObject.put("publisher_did", com.byazt.bp.c.t().rh());
            jSONObject.put("android_id", DeviceUtils.tt());
            jSONObject.put(DeviceIdType.OAID, veVar.getOAID(false));
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.dna.u uVar = (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
            jSONObject.put(DeviceIdType.IMEI, DeviceUtils.c((Boolean) null));
            jSONObject.put("android_id", DeviceUtils.tt());
            jSONObject.put("uuid", com.byazt.by.c.ve());
            jSONObject.put("ssid", uVar.getSSID(null));
            jSONObject.put("wifi_mac", uVar.getWifiMac(null));
            jSONObject.put("imsi", uVar.getImsi(null));
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            jSONObject.put("power_on_time", sb.toString());
            jSONObject.put("rom_version", zm.c());
            jSONObject.put("sys_compiling_time", uVar.getCompilingTime());
            jSONObject.put("type", uVar.getDeviceType(false));
            jSONObject.put("os", uVar.getOs());
            jSONObject.put("os_version", uVar.getOsVersion());
            jSONObject.put("vendor", uVar.getVendor());
            jSONObject.put("device_model", uVar.getDeviceModel());
            jSONObject.put(MediaFormat.KEY_LANGUAGE, uVar.getLanguage());
            jSONObject.put("conn_type", com.byazt.aas.qy.c());
            jSONObject.put("mac", uVar.getMacAddress(null));
            jSONObject.put("screen_width", com.byazt.eu.a.tt(context));
            jSONObject.put("screen_height", com.byazt.eu.a.ve(context));
            jSONObject.put(DeviceIdType.OAID, ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static void c(Context context, JSONObject jSONObject) {
        ArrayList<String> arrayListC;
        if (context == null || jSONObject == null || (arrayListC = x.c(context, "MD5")) == null || arrayListC.isEmpty()) {
            return;
        }
        try {
            jSONObject.put("sig_hash", Build.MANUFACTURER);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String c(String str) {
        String[] strArrSplit = str.split(",");
        return (strArrSplit == null || strArrSplit.length <= 0 || TextUtils.isEmpty(strArrSplit[0])) ? q.i : strArrSplit[0].trim();
    }
}
