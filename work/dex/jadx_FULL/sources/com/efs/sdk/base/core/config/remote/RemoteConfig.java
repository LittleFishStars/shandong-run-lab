package com.efs.sdk.base.core.config.remote;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RemoteConfig {
    public static final double FULL_RATE = 100.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f29589a;
    public int mConfigVersion = -1;
    String b = "https://";
    String c = "errnewlog.umeng.com";
    long d = 480;
    private Boolean e = null;
    public Map<String, Double> mUploadSampleRateMap = new HashMap();
    public Map<String, String> mSDKConfigMap = new HashMap();
    public Map<String, Object> mStrategyMap = new HashMap();

    private RemoteConfig() {
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f29589a = str;
            String str2 = new String(com.efs.sdk.base.core.util.secure.a.a(EncodeUtil.base64Decode(str.getBytes()), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
            String[] strArrSplit = str2.split("\\|");
            if (strArrSplit.length <= 1) {
                return;
            }
            String str3 = strArrSplit[1];
            try {
                JSONArray jSONArray = new JSONArray(str2.substring(strArrSplit[0].length() + strArrSplit[1].length() + 2));
                this.mStrategyMap.put("rate", Integer.valueOf(Integer.parseInt(str3)));
                this.mStrategyMap.put("stra", jSONArray);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static RemoteConfig a() {
        RemoteConfig remoteConfig = new RemoteConfig();
        if (ControllerCenter.getGlobalEnvStruct().isIntl()) {
            remoteConfig.c = "errnewlogos.umeng.com";
        } else {
            remoteConfig.c = "errnewlog.umeng.com";
        }
        return remoteConfig;
    }

    public final void a(@NonNull Map<String, String> map) {
        double d;
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String strReplace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                try {
                    d = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                    d = 100.0d;
                }
                map2.put(strReplace, Double.valueOf(d));
            }
        }
        this.mUploadSampleRateMap = map2;
        this.mSDKConfigMap = map;
    }
}
