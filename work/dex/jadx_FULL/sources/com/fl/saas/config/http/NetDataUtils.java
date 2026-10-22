package com.fl.saas.config.http;

import android.text.TextUtils;
import com.fl.saas.config.utils.AesUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetDataUtils {
    public static JSONObject parseResponseNew(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strDecrypt = AesUtils.decrypt(str);
                if (!TextUtils.isEmpty(strDecrypt) && !"null".equals(strDecrypt)) {
                    return new JSONObject(strDecrypt);
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
