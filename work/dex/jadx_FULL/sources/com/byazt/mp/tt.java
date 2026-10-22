package com.byazt.mp;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.lu.uj;
import com.byazt.vm.sp;
import com.byazt.yv.da;
import com.byazt.yv.n;
import com.byazt.yv.u;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.dv9;
import com.zj.adlib.xh9;
import com.zj.adlib.ze1;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2108, 13})
public class tt {
    public static final String[] c = {"ab_version", "device_brand", MediaFormat.KEY_LANGUAGE, "os_api", CommonCode.MapKey.HAS_RESOLUTION, "google_aid", "build_serial", "carrier", "install_id", "package", AlibcCommonConstant.APP_VERSION, "device_model", "udid", "density_dpi", "aliyun_uuid", ze1.t, "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    public static final String[] tt = {"ab_version", "device_brand", MediaFormat.KEY_LANGUAGE, "os_api", CommonCode.MapKey.HAS_RESOLUTION, "google_aid", "build_serial", "carrier", "iid", "app_name", "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", ze1.t, "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String c(Context context, JSONObject jSONObject, String str, boolean z, com.byazt.gj.tt ttVar) {
        HashMap<String, String> mapC;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(c.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = c;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(tt[i], strOptString);
            }
            i++;
        }
        if (ttVar != null) {
            try {
                mapC = ttVar.c(context);
            } catch (Exception e) {
                da.tt(e);
            }
        } else {
            mapC = null;
        }
        if (u.ve(context) && mapC != null) {
            map.putAll(mapC);
        }
        try {
            HashMap<String, String> mapC2 = com.byazt.gj.c.ve() == null ? null : com.byazt.gj.c.ve().c();
            if (mapC2 != null) {
                map.putAll(mapC2);
            }
        } catch (Exception e2) {
            da.tt(e2);
        }
        if (com.byazt.gj.c.ve.size() > 0) {
            map.putAll(com.byazt.gj.c.ve);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strC = n.c(context);
        if (!TextUtils.isEmpty(strC)) {
            map.put("ac", strC);
        }
        String str2 = (String) com.byazt.gj.c.c("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) com.byazt.gj.c.c(xh9.WEBSITE_PARAMS_CHANNEL, "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(xh9.WEBSITE_PARAMS_CHANNEL, str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) com.byazt.gj.c.c("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) com.byazt.gj.c.c("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) com.byazt.gj.c.c("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strC2 = sp.c(jSONObject.optJSONObject(DeviceIdType.OAID));
        if (!TextUtils.isEmpty(strC2)) {
            map.put(DeviceIdType.OAID, strC2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            str = str + WVNativeCallbackUtil.SEPERATER;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) >= 0 ? dv9.d : '?');
        return u.c(sb.toString(), map, "UTF-8");
    }

    public static String[] c(uj ujVar, Context context, JSONObject jSONObject) {
        String[] strArrTt = ujVar.sp().tt();
        String[] strArr = new String[strArrTt.length];
        String str = com.byazt.gj.c.x() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrTt.length; i++) {
            String strC = c(context, jSONObject, strArrTt[i] + str, true, com.byazt.gj.c.uj());
            strArr[i] = strC;
            strArr[i] = c.c(strC, c.tt);
        }
        return strArr;
    }
}
