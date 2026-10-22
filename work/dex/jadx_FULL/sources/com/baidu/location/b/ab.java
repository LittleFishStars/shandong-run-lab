package com.baidu.location.b;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ab {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ab f26335a = new ab();
    }

    private ab() {
    }

    public static ab a() {
        return a.f26335a;
    }

    private void a(String str, String str2, String str3) {
        Log.d("UrlConfigManger", "setConfig");
        Log.d("baidu_location_dev", "type:" + str + ", owner: " + str2 + " ,url: " + str3);
        if (str2.contains("default_owner") || com.alibaba.ariver.jsapi.logging.a.f24154a.equals(str3) || !str3.contains("https")) {
            Log.d("baidu_location_dev", "url 不合法");
            return;
        }
        str.hashCode();
        switch (str) {
            case "indoor_roadnet":
                com.baidu.location.e.d.h = str3;
                break;
            case "vdr_log_update":
                com.baidu.location.e.d.k = str3;
                break;
            case "hdyawupdate":
                com.baidu.location.e.d.p = str3;
                break;
            case "basement_inout":
                com.baidu.location.e.d.q = str3;
                break;
            case "indoor_poi_data":
                com.baidu.location.e.d.j = str3;
                break;
            case "loc":
                com.baidu.location.e.d.e = str3;
                break;
            case "cfgs":
                com.baidu.location.e.d.f = str3;
                break;
            case "indoor_rects":
                com.baidu.location.e.d.i = str3;
                break;
        }
    }

    private boolean a(String str) {
        JSONArray jSONArrayOptJSONArray;
        Log.d("UrlConfigManger", "parseConfig");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("url_config") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("url_config")) == null) {
                return true;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                a(jSONObjectOptJSONObject.optString("type"), jSONObjectOptJSONObject.optString("owner"), jSONObjectOptJSONObject.optString("url"));
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(Context context) {
        Log.d("UrlConfigManger", TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL);
        if (context == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getExternalFilesDir(Environment.DIRECTORY_MOVIES));
            String str = File.separator;
            sb.append(str);
            sb.append("baiduLocDev");
            sb.append(str);
            sb.append("loc_local_config");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            try {
                if (!new File(string).exists()) {
                    Log.d("baidu_location_dev", "loc_local_config not exit...");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(string);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        fileInputStream.close();
                        a(sb2.toString());
                        return;
                    }
                    sb2.append(new String(bArr, 0, i));
                }
            } catch (FileNotFoundException | IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
