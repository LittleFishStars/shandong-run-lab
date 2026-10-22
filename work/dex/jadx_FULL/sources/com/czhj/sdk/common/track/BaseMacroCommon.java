package com.czhj.sdk.common.track;

import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BaseMacroCommon implements Serializable {
    public static final String _BUNDLEID_ = "_BUNDLEID_";
    public static final String _COUNTRY_ = "_COUNTRY_";
    public static final String _LANGUAGE_ = "_LANGUAGE_";
    public static final String _MC_ = "_MC_";
    public static final String _OSVERSION_ = "_OSVERSION_";
    public static final String _TIMEMILLIS_ = "_TIMEMILLIS_";
    public static final String _TIMESTAMP_ = "_TIMESTAMP_";
    private static final long serialVersionUID = 1;
    private final Map<String, String> mMacroMap = new HashMap();
    private Map<String, String> mServerMacroMap = new HashMap();

    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static String getMacroValue(String str) {
        byte b;
        try {
            switch (str.hashCode()) {
                case -1478958456:
                    if (!str.equals(_LANGUAGE_)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -1012646968:
                    if (!str.equals(_TIMESTAMP_)) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case -181892765:
                    if (!str.equals(_BUNDLEID_)) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 501136648:
                    if (!str.equals(_COUNTRY_)) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1632828845:
                    if (!str.equals(_TIMEMILLIS_)) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1846323754:
                    if (!str.equals(_OSVERSION_)) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                return ClientMetadata.getInstance().getDeviceLocale().getCountry();
            }
            if (b == 1) {
                return ClientMetadata.getInstance().getAppPackageName();
            }
            if (b == 2) {
                return ClientMetadata.getInstance().getDeviceLocale().getLanguage();
            }
            if (b == 3) {
                return ClientMetadata.getDeviceOsVersion();
            }
            if (b != 4) {
                return b != 5 ? "unFind" : String.valueOf(System.currentTimeMillis());
            }
            return String.valueOf(System.currentTimeMillis() / 1000);
        } catch (Throwable unused) {
            return "unFind";
        }
    }

    private String replaceMacroWithMap(String str, Map<String, String> map) {
        String str2 = this.mServerMacroMap.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str2 + "]");
        if (!TextUtils.isEmpty(str2) && !str2.equals("unFind")) {
            return str2;
        }
        String str3 = this.mMacroMap.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str3 + "]");
        if (!TextUtils.isEmpty(str3) && !str3.equals("unFind")) {
            return str3;
        }
        if (map == null) {
            return null;
        }
        String str4 = map.get(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + str4 + "]");
        if (TextUtils.isEmpty(str4) || str4.equals("unFind")) {
            return null;
        }
        return str4;
    }

    public void addAllMarco(Map<String, String> map) {
        this.mMacroMap.putAll(map);
    }

    public void addMarcoKey(String str, String str2) {
        this.mMacroMap.put(str, str2);
    }

    public void clearMacro() {
        this.mMacroMap.clear();
    }

    public Map<String, String> getMacroMap() {
        return this.mMacroMap;
    }

    public String getMarcoKey(String str) {
        return this.mMacroMap.get(str);
    }

    public String macroProcess(String str) {
        return macroProcess(str, null);
    }

    public String macroProcess(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = Pattern.compile("_([A-Z,0-9])+_").matcher(str);
        try {
            SigmobLog.d("macroProcess() called with: origin url " + str);
            while (matcher.find()) {
                String strGroup = matcher.group();
                String strReplaceMacroWithMap = replaceMacroWithMap(strGroup, map);
                if (TextUtils.isEmpty(strReplaceMacroWithMap) || strReplaceMacroWithMap.equals("unFind")) {
                    strReplaceMacroWithMap = replaceWithDefault(strGroup);
                    if (TextUtils.isEmpty(strReplaceMacroWithMap) || strReplaceMacroWithMap.equals("unFind")) {
                    }
                }
                str = str.replaceAll(strGroup, strReplaceMacroWithMap);
            }
            SigmobLog.d("macroProcess() called with: final url " + str);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return str;
    }

    public void removeMarcoKey(String str) {
        this.mMacroMap.remove(str);
    }

    public String replaceWithDefault(String str) {
        String macroValue = getMacroValue(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + macroValue + "]");
        if (TextUtils.isEmpty(macroValue) || macroValue.equals("unFind")) {
            return null;
        }
        return macroValue;
    }

    public void setServerMacroMap(Map<String, String> map) {
        this.mServerMacroMap = map;
    }
}
