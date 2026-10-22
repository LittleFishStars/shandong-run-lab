package com.byazt.ey;

import android.content.Context;
import android.net.Uri;
import com.byakv.z.TTEncryptUtils;
import com.byazt.yv.u;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 217, 20})
public class c {
    public static JSONObject c(Context context, JSONObject jSONObject, boolean z) {
        byte[] bytes;
        JSONObject jSONObjectC;
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = jSONObject.toString().getBytes("UTF-8");
            String strClientPackedBase64 = TTEncryptUtils.clientPackedBase64(bytes2, bytes2.length);
            if (com.byazt.tf.c.tt()) {
                com.byazt.tf.c.c("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                com.byazt.tf.c.ve("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(strClientPackedBase64)));
            }
            bytes = strClientPackedBase64.getBytes("UTF-8");
        } catch (Exception e) {
            com.byazt.tf.c.uj("__kite", "error: " + e.getMessage());
            bytes = bytes2;
        }
        if (bytes == null) {
            com.byazt.tf.c.ve("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObjectC = c(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter("req_id", UUID.randomUUID().toString()).build().toString(), bytes, z);
        } catch (Exception e2) {
            com.byazt.tf.c.tt("__kiteerror " + e2.getMessage());
            jSONObjectC = null;
        }
        return jSONObjectC == null ? new JSONObject() : jSONObjectC;
    }

    public static JSONObject c(Context context, String str, byte[] bArr, boolean z) {
        String strC;
        try {
            if (u.uj()) {
                try {
                    strC = com.byazt.mp.c.c(context, str, bArr, null, false, false);
                } catch (RuntimeException e) {
                    com.byazt.tf.c.uj("__kite", "error " + e.getMessage());
                    strC = com.byazt.mp.c.c(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
            } else {
                try {
                    strC = com.byazt.mp.c.c(context, str, bArr, "application/json; charset=utf-8", false, true);
                } catch (Exception e2) {
                    com.byazt.tf.c.uj("__kite", "error " + e2.getMessage());
                    strC = "";
                }
            }
        } catch (Exception e3) {
            com.byazt.tf.c.uj("__kite", "network error " + e3.getMessage());
            strC = "";
        }
        try {
            return new JSONObject(strC);
        } catch (Exception e4) {
            com.byazt.tf.c.uj("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
    }
}
