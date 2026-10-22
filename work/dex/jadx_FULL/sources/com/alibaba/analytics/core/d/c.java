package com.alibaba.analytics.core.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.AnalyticsImp;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.l;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.a.y;
import com.alibaba.analytics.core.a.n;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.UTMCLogFields;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    private static volatile String av;
    private static volatile String aw;

    private static void I(String str) {
        if (!n.a().m105a(19999, "TRUNC_LOG")) {
            j.d("sendTruncLogEvent", "TRUNC_LOG is discarded!");
            return;
        }
        Map<String, String> mapA = a(str);
        if (mapA == null) {
            return;
        }
        String str2 = mapA.get(LogField.PAGE.toString());
        String str3 = mapA.get(LogField.EVENTID.toString());
        String str4 = mapA.get(LogField.ARG1.toString());
        String str5 = mapA.get(LogField.ARG2.toString());
        String str6 = mapA.get(LogField.ARG3.toString());
        String str7 = mapA.get(LogField.ARGS.toString());
        String str8 = mapA.get(LogField.RESERVE3.toString());
        HashMap map = new HashMap();
        map.put("PN", str2);
        map.put("EID", str3);
        map.put("A1", d(str4));
        map.put("A2", d(str5));
        map.put("A3", d(str6));
        map.put("AS", d(str7));
        map.put("R3", str8);
        com.alibaba.analytics.core.f.d.a().a(new com.alibaba.analytics.core.model.a("UT_ANALYTICS", UserTrackConstant.CUSTOM_EVENT, "TRUNC_LOG", "", "", l.c(map)));
    }

    private static void a(String str, Map<String, String> map, Map<String, String> map2) {
        if (map.containsKey(str) || map2.get(str) == null) {
            return;
        }
        map.put(str, map2.get(str));
    }

    public static String b(Map<String, String> map) {
        boolean z;
        String string;
        LogField logField;
        Map<String, String> mapA = a.a(map);
        boolean z2 = true;
        boolean z3 = a(mapA, LogField.ARG3.toString()) || (a(mapA, LogField.ARG2.toString()) || a(mapA, LogField.ARG1.toString()));
        StringBuffer stringBuffer = new StringBuffer();
        LogField[] logFieldArrValues = LogField.values();
        int length = logFieldArrValues.length;
        int i = 0;
        while (true) {
            String strA = null;
            if (i >= length || (logField = logFieldArrValues[i]) == LogField.ARGS) {
                break;
            }
            if (mapA.containsKey(logField.toString())) {
                strA = u.a(mapA.get(logField.toString()));
                mapA.remove(logField.toString());
            }
            stringBuffer.append(c(strA));
            stringBuffer.append("||");
            i++;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        LogField logField2 = LogField.ARGS;
        if (mapA.containsKey(logField2.toString())) {
            stringBuffer2.append(c(u.a(mapA.get(logField2.toString()))));
            mapA.remove(logField2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str : mapA.keySet()) {
            String strA2 = mapA.containsKey(str) ? u.a(mapA.get(str)) : null;
            if (z) {
                if ("StackTrace".equals(str)) {
                    stringBuffer2.append("StackTrace=====>");
                    stringBuffer2.append(strA2);
                } else {
                    stringBuffer2.append(c(str));
                    stringBuffer2.append("=");
                    stringBuffer2.append(strA2);
                }
                z = false;
            } else if ("StackTrace".equals(str)) {
                stringBuffer2.append(",");
                stringBuffer2.append("StackTrace=====>");
                stringBuffer2.append(strA2);
            } else {
                stringBuffer2.append(",");
                stringBuffer2.append(c(str));
                stringBuffer2.append("=");
                stringBuffer2.append(strA2);
            }
        }
        int length2 = stringBuffer2.length();
        if (length2 < 1) {
            string = c49.f40900a;
        } else if (length2 > 40960) {
            if (!e(map.get(LogField.EVENTID.toString()))) {
                j.e("LogAssemble", "truncLog field", LogField.ARGS.toString(), "length", Integer.valueOf(length2));
                string = stringBuffer2.substring(0, 40960);
            } else if (length2 > 409600) {
                j.e("LogAssemble", "truncLog field", LogField.ARGS.toString(), "length", Integer.valueOf(length2));
                string = stringBuffer2.substring(0, 409600);
            } else {
                string = stringBuffer2.toString();
                z2 = z3;
            }
            z3 = z2;
        } else {
            string = stringBuffer2.toString();
        }
        stringBuffer.append(string);
        String string2 = stringBuffer.toString();
        if (z3) {
            I(string2);
        }
        return string2;
    }

    private static String c(String str) {
        return u.isEmpty(str) ? c49.f40900a : str;
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 1024) ? str : str.substring(0, 1024);
    }

    private static boolean e(String str) {
        return "65501".equalsIgnoreCase(str) || "65502".equalsIgnoreCase(str) || "65503".equalsIgnoreCase(str);
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        LogField logField = LogField.BRAND;
        map.put(logField.toString(), map2.get(logField.toString()));
        LogField logField2 = LogField.DEVICE_MODEL;
        map.put(logField2.toString(), map2.get(logField2.toString()));
        LogField logField3 = LogField.RESOLUTION;
        map.put(logField3.toString(), map2.get(logField3.toString()));
        LogField logField4 = LogField.OS;
        map.put(logField4.toString(), map2.get(logField4.toString()));
        LogField logField5 = LogField.OSVERSION;
        map.put(logField5.toString(), map2.get(logField5.toString()));
        LogField logField6 = LogField.UTDID;
        map.put(logField6.toString(), map2.get(logField6.toString()));
        a(LogField.IMEI.toString(), map, map2);
        a(LogField.IMSI.toString(), map, map2);
        a(LogField.APPVERSION.toString(), map, map2);
        a(UTMCLogFields.DEVICE_ID.toString(), map, map2);
        a(LogField.LANGUAGE.toString(), map, map2);
        a(LogField.ACCESS.toString(), map, map2);
        a(LogField.ACCESS_SUBTYPE.toString(), map, map2);
        a(LogField.CARRIER.toString(), map, map2);
    }

    public static String a(Map<String, String> map) {
        String imsi;
        String imei;
        StringBuilder sb;
        if (map != null && map.size() > 0) {
            Context context = com.alibaba.analytics.core.d.a().getContext();
            if (context == null && AnalyticsImp.getApplication() != null) {
                context = AnalyticsImp.getApplication().getApplicationContext();
            }
            com.alibaba.analytics.core.c.c cVarC = com.alibaba.analytics.core.c.b.c(context);
            if (cVarC != null) {
                imei = cVarC.getImei();
                imsi = cVarC.getImsi();
            } else {
                imsi = null;
                imei = null;
            }
            if (imei != null && imsi != null) {
                LogField logField = LogField.IMEI;
                if (map.get(logField.toString()) == null) {
                    LogField logField2 = LogField.IMSI;
                    if (map.get(logField2.toString()) == null) {
                        map.put(logField.toString(), imei);
                        map.put(logField2.toString(), imsi);
                    }
                }
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().k())) {
                map.put(LogField.USERNICK.toString(), com.alibaba.analytics.core.d.a().k());
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().h())) {
                map.put(LogField.LL_USERNICK.toString(), com.alibaba.analytics.core.d.a().h());
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().m123l())) {
                map.put(LogField.USERID.toString(), com.alibaba.analytics.core.d.a().m123l());
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().i())) {
                map.put(LogField.LL_USERID.toString(), com.alibaba.analytics.core.d.a().i());
            }
            LogField logField3 = LogField.SDKVERSION;
            if (!map.containsKey(logField3.toString())) {
                map.put(logField3.toString(), com.alibaba.analytics.b.a.a().E());
            }
            LogField logField4 = LogField.APPKEY;
            if (!map.containsKey(logField4.toString())) {
                map.put(logField4.toString(), com.alibaba.analytics.core.d.a().getAppkey());
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().j())) {
                map.put(LogField.CHANNEL.toString(), com.alibaba.analytics.core.d.a().j());
            }
            if (!u.isEmpty(com.alibaba.analytics.core.d.a().g())) {
                map.put(LogField.APPVERSION.toString(), com.alibaba.analytics.core.d.a().g());
            }
            LogField logField5 = LogField.RECORD_TIMESTAMP;
            if (map.containsKey(logField5.toString())) {
                String str = map.get(logField5.toString());
                map.put(logField5.toString(), "" + h.a().a(str));
            } else {
                map.put(logField5.toString(), "" + h.a().e());
            }
            LogField logField6 = LogField.START_SESSION_TIMESTAMP;
            if (!map.containsKey(logField6.toString())) {
                map.put(logField6.toString(), "" + g.a().b());
            }
            LogField logField7 = LogField.SDKTYPE;
            if (!map.containsKey(logField7.toString())) {
                map.put(logField7.toString(), com.alibaba.analytics.core.b.c());
            }
            map.put(LogField.RESERVE5.toString(), f.b(context));
            Map<String, String> mapB = y.b(context);
            if (mapB != null) {
                a(map, mapB);
                if (map.containsKey(UTMCLogFields.ALIYUN_PLATFORM_FLAG.toString())) {
                    map.put(LogField.OS.toString(), "y");
                }
                LogField logField8 = LogField.RESERVES;
                String str2 = map.get(logField8.toString());
                if (!u.isEmpty(str2)) {
                    sb = new StringBuilder(str2);
                } else {
                    sb = new StringBuilder(100);
                }
                UTMCLogFields uTMCLogFields = UTMCLogFields.DEVICE_ID;
                String str3 = map.get(uTMCLogFields.toString());
                if (str3 != null) {
                    if (sb.length() > 0) {
                        sb.append(",_did=");
                        sb.append(str3);
                    } else {
                        sb.append("_did=");
                        sb.append(str3);
                    }
                    map.remove(uTMCLogFields.toString());
                }
                String strA = d.a(context);
                if (strA != null) {
                    LogField logField9 = LogField.UTDID;
                    if (map.containsKey(logField9.toString()) && strA.equals(map.get(logField9.toString()))) {
                        strA = "utdid";
                    }
                    if (sb.length() > 0) {
                        sb.append(",_umid=");
                        sb.append(strA);
                    } else {
                        sb.append("_umid=");
                        sb.append(strA);
                    }
                }
                if (com.alibaba.analytics.core.d.a().m129o()) {
                    String strO = com.alibaba.analytics.core.d.a().o();
                    if (!TextUtils.isEmpty(strO)) {
                        if (sb.length() > 0) {
                            sb.append(",_buildid=");
                            sb.append(strO);
                        } else {
                            sb.append("_buildid=");
                            sb.append(strO);
                        }
                    }
                }
                if (sb.length() > 0) {
                    sb.append(",_timeAdjust=");
                    sb.append(h.a().s() ? "1" : "0");
                } else {
                    sb.append("_timeAdjust=");
                    sb.append(h.a().s() ? "1" : "0");
                }
                String str4 = map.get(logField4.toString());
                String appkey = com.alibaba.analytics.core.d.a().getAppkey();
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(appkey) && !appkey.equalsIgnoreCase(str4)) {
                    if (sb.length() > 0) {
                        sb.append(",_mak=");
                        sb.append(appkey);
                    } else {
                        sb.append("_mak=");
                        sb.append(appkey);
                    }
                }
                String str5 = y.d(com.alibaba.analytics.core.d.a().getContext()) ? "1" : "0";
                if (sb.length() > 0) {
                    sb.append(",_pad=");
                    sb.append(str5);
                } else {
                    sb.append("_pad=");
                    sb.append(str5);
                }
                String strC = com.alibaba.analytics.a.a.c(context);
                if (!TextUtils.isEmpty(strC)) {
                    if (sb.length() > 0) {
                        sb.append(",_channel2=");
                        sb.append(strC);
                    } else {
                        sb.append("_channel2=");
                        sb.append(strC);
                    }
                }
                String strM125m = com.alibaba.analytics.core.d.a().m125m();
                if (!u.isEmpty(strM125m)) {
                    if (sb.length() > 0) {
                        sb.append(",_openid=");
                        sb.append(strM125m);
                    } else {
                        sb.append("_openid=");
                        sb.append(strM125m);
                    }
                }
                String str6 = map.get("UTPVID_T");
                if (!TextUtils.isEmpty(str6)) {
                    if (sb.length() > 0) {
                        sb.append(",_t=");
                        sb.append(str6);
                    } else {
                        sb.append("_t=");
                        sb.append(str6);
                    }
                    map.remove("UTPVID_T");
                }
                Map<String, String> mapM114a = com.alibaba.analytics.core.d.a().m114a();
                if (mapM114a != null && mapM114a.size() > 0) {
                    String strD = u.d(mapM114a);
                    if (!u.isEmpty(strD)) {
                        if (sb.length() > 0) {
                            sb.append(",");
                            sb.append(strD);
                        } else {
                            sb.append(strD);
                        }
                    }
                }
                map.put(logField8.toString(), sb.toString());
                return b(map);
            }
        }
        return null;
    }

    public static Map<String, String> a(String str) {
        if (u.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        String[] strArrA = a(str, 34);
        if (strArrA != null && strArrA.length > 0) {
            int i = 0;
            for (LogField logField : LogField.values()) {
                if (i < strArrA.length && strArrA[i] != null) {
                    map.put(logField.toString(), strArrA[i]);
                }
                i++;
            }
        }
        return map;
    }

    private static String[] a(String str, int i) {
        int i2;
        String[] strArr = new String[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = i - 1;
            if (i3 >= i2) {
                break;
            }
            int iIndexOf = str.indexOf("||", i4);
            if (iIndexOf == -1) {
                strArr[i3] = str.substring(i4);
                break;
            }
            strArr[i3] = str.substring(i4, iIndexOf);
            i4 = iIndexOf + 2;
            i3++;
        }
        strArr[i2] = str.substring(i4);
        return strArr;
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            map2.put(LogField.PAGE.toString(), str);
        }
        map2.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            map2.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            map2.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            map2.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            map2.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            map2.put(LogField.RESERVE3.toString(), str6);
        }
        return a(map2);
    }

    private static boolean a(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2) || str2.length() <= 40960) {
            return false;
        }
        j.e("LogAssemble truncLog", "field", str, "length", Integer.valueOf(str2.length()));
        map.put(str, str2.substring(0, 40960));
        return true;
    }
}
