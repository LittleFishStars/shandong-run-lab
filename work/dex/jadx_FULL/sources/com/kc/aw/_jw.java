package com.kc.aw;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jw {
    public static final ConcurrentHashMap<String, SharedPreferences> _a = new ConcurrentHashMap<>(4);
    public static final ConcurrentHashMap _b = new ConcurrentHashMap();
    public static final Object _c = new Object();

    public static long _a(Context context, String str) {
        if (context != null && str != null) {
            Long l = (Long) _a((Object) 0L, str);
            if (l != null && l.longValue() != 0) {
                return l.longValue();
            }
            SharedPreferences sharedPreferences_b = _b(context, "aw_sdk_config");
            if (sharedPreferences_b == null) {
                return 0L;
            }
            try {
                long j = sharedPreferences_b.getLong(str, 0L);
                _b(Long.valueOf(j), str);
                return j;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return 0L;
    }

    public static long _a(String str, String str2) {
        Context context = PtgAdSdk.getContext();
        String str3 = "{}";
        if (context != null) {
            String str4 = (String) _a((Object) "{}", str);
            if (TextUtils.isEmpty(str4) || str4.equals("{}")) {
                SharedPreferences sharedPreferences_b = _b(context, "aw_sdk_config");
                if (sharedPreferences_b != null) {
                    try {
                        String string = sharedPreferences_b.getString(str, "{}");
                        _b(string, str);
                        str3 = string;
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            } else {
                str3 = str4;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String strOptString = jSONObject.optString("dataTime");
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            if ((i + LoginConstants.UNDER_LINE + (i2 + 1) + LoginConstants.UNDER_LINE + calendar.get(5)).equals(strOptString)) {
                return jSONObject.optLong(str2);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static Object _a(Object obj, String str) {
        Map map;
        if (str == null || (map = (Map) _b.get("aw_sdk_config")) == null) {
            return obj;
        }
        try {
            if (!map.containsKey(str)) {
                return null;
            }
            Object obj2 = map.get(str);
            if (obj2 != null && obj != null && obj.getClass().isInstance(obj2)) {
                return obj2;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return obj;
    }

    public static void _a(long j, String str, String str2) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            jSONObject.put("dataTime", i + LoginConstants.UNDER_LINE + (i2 + 1) + LoginConstants.UNDER_LINE + calendar.get(5));
            jSONObject.put(str2, j);
            string = jSONObject.toString();
        } catch (Exception unused) {
            string = "";
        }
        _a(PtgAdSdk.getContext(), str, string);
    }

    public static void _a(Context context, String str, long j) {
        if (context == null || str == null) {
            return;
        }
        _b(Long.valueOf(j), str);
        com.kc.aw.lib.utils._d._b(new _jv(context, str, j));
    }

    public static void _a(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            _b(str2, str);
            com.kc.aw.lib.utils._d._b(new _jt(context, str, str2));
        }
    }

    public static void _a(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (Exception e) {
            e.getMessage();
            try {
                editor.commit();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    public static void _a(boolean z, boolean z2) {
        if (z) {
            _a(_a("sdk_local_enhance_limit", "enhanceLimit") + 1, "sdk_local_enhance_limit", "enhanceLimit");
            _a(System.currentTimeMillis(), "sdk_local_enhance_last_time", "enhanceLastTime");
            if (z2) {
                _a(_a("sdk_local_enhance_f_click_limit", "fClickLimit") + 1, "sdk_local_enhance_f_click_limit", "fClickLimit");
            }
        }
    }

    public static boolean _a(Context context) {
        if (context != null) {
            Boolean bool = (Boolean) _a(Boolean.TRUE, "ptg_sensor_status");
            if (bool != null) {
                return bool.booleanValue();
            }
            SharedPreferences sharedPreferences_b = _b(context, "aw_sdk_config");
            if (sharedPreferences_b == null) {
                return true;
            }
            try {
                boolean z = sharedPreferences_b.getBoolean("ptg_sensor_status", true);
                _b(Boolean.valueOf(z), "ptg_sensor_status");
                return z;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return true;
    }

    public static SharedPreferences _b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _a;
        SharedPreferences sharedPreferences = concurrentHashMap.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        try {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                concurrentHashMap.put(str, sharedPreferences);
            }
        } catch (SecurityException | Exception e) {
            e.getMessage();
        }
        return sharedPreferences;
    }

    public static void _b(Object obj, String str) {
        ConcurrentHashMap concurrentHashMap = _b;
        if (!concurrentHashMap.containsKey("aw_sdk_config")) {
            synchronized (_c) {
                if (!concurrentHashMap.containsKey("aw_sdk_config")) {
                    concurrentHashMap.put("aw_sdk_config", new ConcurrentHashMap());
                }
            }
        }
        Map concurrentHashMap2 = (Map) concurrentHashMap.get("aw_sdk_config");
        if (concurrentHashMap2 == null) {
            synchronized (_c) {
                concurrentHashMap2 = (Map) concurrentHashMap.get("aw_sdk_config");
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap.put("aw_sdk_config", concurrentHashMap2);
                }
            }
        }
        concurrentHashMap2.put(str, obj);
    }

    public static String _c(Context context, String str) {
        if (context == null) {
            return "";
        }
        String str2 = (String) _a((Object) "", str);
        if (!TextUtils.isEmpty(str2) && !str2.equals("")) {
            return str2;
        }
        SharedPreferences sharedPreferences_b = _b(context, "aw_sdk_config");
        if (sharedPreferences_b == null) {
            return "";
        }
        try {
            String string = sharedPreferences_b.getString(str, "");
            _b(string, str);
            return string;
        } catch (Exception e) {
            e.getMessage();
            return "";
        }
    }
}
