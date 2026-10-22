package com.hzchengdun.securityguard.open.unifiedsecurity;

import android.content.Context;
import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class UnifiedSecurityComponent {
    private static final String KEY_API = "api";
    private static final String KEY_APPKEY = "appkey";
    private static final String KEY_AUTH_CODE = "authCode";
    private static final String KEY_BIZ_ID = "bizId";
    private static final String KEY_DATA = "data";
    private static final String KEY_ENV = "env";
    private static final String KEY_EXTEND_PARAS = "extendParas";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_MINI_WUA = "miniWua";
    private static final String KEY_REQUESET_ID = "requestId";
    private static final String KEY_SIGN_KEY = "signKey";
    private static final String KEY_USE_WUA = "useWua";
    private static Context gContext;

    private String assembleExtendParam(HashMap<String, String> map) {
        String strUrlEncodeString;
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String strUrlEncodeString2 = urlEncodeString(it.next());
                if (strUrlEncodeString2 != null && strUrlEncodeString2.length() > 0 && (strUrlEncodeString = urlEncodeString(map.get(strUrlEncodeString2))) != null) {
                    if (sb.length() != 0) {
                        sb.append("&");
                    }
                    sb.append(strUrlEncodeString2);
                    sb.append("=");
                    sb.append(strUrlEncodeString);
                }
            }
        }
        return sb.toString();
    }

    private String urlEncodeString(String str) {
        if (str != null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public HashMap<String, String> getSecurityFactors(HashMap<String, Object> map) throws SecException {
        if (map == null || map.isEmpty()) {
            throw new SecException(2401);
        }
        if (!map.containsKey("appkey") || !map.containsKey("data") || !map.containsKey(KEY_USE_WUA) || map.get("appkey") == null || map.get("data") == null || map.get(KEY_USE_WUA) == null) {
            throw new SecException(2401);
        }
        String str = (String) map.get("appkey");
        String str2 = (String) map.get("data");
        Boolean bool = (Boolean) map.get(KEY_USE_WUA);
        bool.booleanValue();
        String str3 = null;
        String str4 = (!map.containsKey(KEY_AUTH_CODE) || map.get(KEY_AUTH_CODE) == null) ? null : (String) map.get(KEY_AUTH_CODE);
        String str5 = (!map.containsKey(KEY_SIGN_KEY) || map.get(KEY_SIGN_KEY) == null) ? null : (String) map.get(KEY_SIGN_KEY);
        int iIntValue = (!map.containsKey(KEY_ENV) || map.get(KEY_ENV) == null) ? 0 : ((Integer) map.get(KEY_ENV)).intValue();
        String str6 = map.get("api") != null ? (String) map.get("api") : null;
        String strAssembleExtendParam = (!map.containsKey(KEY_EXTEND_PARAS) || map.get(KEY_EXTEND_PARAS) == null) ? null : assembleExtendParam((HashMap) map.get(KEY_EXTEND_PARAS));
        String str7 = (!map.containsKey(KEY_MINI_WUA) || map.get(KEY_MINI_WUA) == null) ? null : (String) map.get(KEY_MINI_WUA);
        if (map.containsKey(KEY_REQUESET_ID) && map.get(KEY_REQUESET_ID) != null) {
            str3 = (String) map.get(KEY_REQUESET_ID);
        }
        return (HashMap) JNICLibrary.doCommand(70102, str, str2, bool, Integer.valueOf(iIntValue), str6, strAssembleExtendParam, str4, str5, str7, str3, Integer.valueOf((!map.containsKey(KEY_BIZ_ID) || map.get(KEY_BIZ_ID) == null) ? 0 : ((Integer) map.get(KEY_BIZ_ID)).intValue()), Integer.valueOf((!map.containsKey(KEY_FLAG) || map.get(KEY_FLAG) == null) ? 0 : ((Integer) map.get(KEY_FLAG)).intValue()));
    }

    public void init(HashMap<String, Object> map) throws SecException {
        JNICLibrary.doCommand(70101, (map == null || map.isEmpty() || !map.containsKey(KEY_AUTH_CODE)) ? "" : (String) map.get(KEY_AUTH_CODE), Integer.valueOf((map == null || map.isEmpty() || !map.containsKey(KEY_FLAG)) ? 0 : ((Integer) map.get(KEY_FLAG)).intValue()));
    }
}
