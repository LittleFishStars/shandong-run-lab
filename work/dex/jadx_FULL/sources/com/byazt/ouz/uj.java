package com.byazt.ouz;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 15})
public class uj {
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    public static void c(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObject3;
        JSONObject jSONObjectOptJSONObject;
        if ((jSONObject2 == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject("xAppInfo")) == null || jSONObjectOptJSONObject.optInt("themeStatus") != 1) ? false : true) {
            if (jSONObject2.optJSONObject("xSetting") != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("xSetting");
                Objects.requireNonNull(jSONObjectOptJSONObject2);
                if (jSONObjectOptJSONObject2.optJSONObject("dark_mode_config") != null) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("xSetting");
                    Objects.requireNonNull(jSONObjectOptJSONObject3);
                    jSONObject3 = jSONObjectOptJSONObject3.optJSONObject("dark_mode_config");
                } else {
                    jSONObject3 = null;
                }
            } else {
                jSONObject3 = null;
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            int iC = c(jSONObject.optString("backgroundColor"), jSONObject3);
            if (iC == 1) {
                jSONObject.put("backgroundColor", uj(jSONObject.optString("backgroundColor"), jSONObject3));
            } else if (iC == 2) {
                jSONObject.put("backgroundColor", tt(jSONObject.optString("backgroundColor"), jSONObject3));
            }
            if (c(jSONObject.optString("textColor"), jSONObject3) == 1) {
                jSONObject.put("textColor", ve(jSONObject.optString("textColor"), jSONObject3));
            }
        }
    }

    private static String tt(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("dark_gray_threshold", 30);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            return Math.max(iRed, Math.max(iGreen, iBlue)) - Math.min(iRed, Math.min(iGreen, iBlue)) < iOptInt ? c(iAlpha, 255 - iRed, 255 - iGreen, 255 - iBlue) : c(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static String uj(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("black_bright_offset", 20);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            int iMax = Math.max(0, Math.min(100, iOptInt));
            return c(iAlpha, Math.min(255, iRed + ((255 - iRed) * (iMax / 100))), Math.min(255, iGreen + ((255 - iGreen) * (iMax / 100))), Math.min(255, iBlue + ((255 - iBlue) * (iMax / 100))));
        } catch (Exception unused) {
            return str;
        }
    }

    private static String ve(String str, JSONObject jSONObject) {
        int iC = com.byazt.cd.c.c(str);
        try {
            int iOptInt = jSONObject.optInt("gray_threshold", 20);
            int iOptInt2 = jSONObject.optInt("light_gray_threshold", 225);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iAlpha = Color.alpha(iC);
            if (iAlpha < 0) {
                iAlpha = 1;
            }
            return Math.max(iRed, Math.max(iGreen, iBlue)) - Math.min(iRed, Math.min(iGreen, iBlue)) < iOptInt ? c(iAlpha, 255 - iRed, 255 - iGreen, 255 - iBlue) : c(iAlpha, iOptInt2, iOptInt2, iOptInt2);
        } catch (Exception unused) {
            return str;
        }
    }

    private static int c(String str, JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("luminance_upper", 90);
            int iOptInt2 = jSONObject.optInt("luminance_lower", 40);
            int iOptInt3 = jSONObject.optInt("gray_threshold", 20);
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int iC = com.byazt.cd.c.c(str);
            int iRed = Color.red(iC);
            int iGreen = Color.green(iC);
            int iBlue = Color.blue(iC);
            int iMax = Math.max(iRed, Math.max(iGreen, iBlue));
            int iMin = Math.min(iRed, Math.min(iGreen, iBlue));
            int i = (iMax + iMin) / 2;
            int i2 = iMax - iMin;
            if (i > iOptInt && i2 < iOptInt3) {
                return 2;
            }
            if (i < iOptInt2 && i2 < iOptInt3) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static String c(int i, int i2, int i3, int i4) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
