package com.byazt.dbo;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 961, 15})
public class uj {
    public static JSONObject c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = com.byazt.nr.a.tt("id=" + str + "&timestamp=" + iCurrentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put("timestamp", iCurrentTimeMillis);
            jSONObject.put(UserTrackConstant.SIGN, upperCase);
            jSONObject.put(LoginConstants.EXT, str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
