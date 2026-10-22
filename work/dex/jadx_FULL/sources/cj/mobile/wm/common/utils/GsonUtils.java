package cj.mobile.wm.common.utils;

import android.text.TextUtils;
import cj.mobile.wm.dexc;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GsonUtils {
    public Gson gson;
    public static final String TAG = dexc.dexa("HtpoVujmt");
    public static volatile GsonUtils gsonUtils = null;
    public static int ERROR_TO_JSON_COUNT = 0;
    public static int ERROR_FROM_JSON_CLAZZ_COUNT = 0;
    public static int ERROR_FROM_JSON_TYPE_TOKEN_COUNT = 0;

    public GsonUtils() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    public static GsonUtils getInstance() {
        if (gsonUtils == null) {
            synchronized (GsonUtils.class) {
                if (gsonUtils == null) {
                    gsonUtils = new GsonUtils();
                }
            }
        }
        return gsonUtils;
    }

    private void reportErrorInfo(String str, Throwable th) {
        if (th != null) {
            str = str + th;
        }
        ReportUtils.exReport(ContextContainer.getApplicationContext(), 900001, dexc.dexa("疱环楅葇楲鵦"), str);
    }

    public <T> T fromJson(String str, Class<T> cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                DebugLog.release_e(TAG, dexc.dexa("gspnKtpo.dmb{{!gbjm-ebub!dbo(u!cf!ovmm"));
                return null;
            }
            if (cls == null) {
                DebugLog.release_e(TAG, dexc.dexa("gspnKtpo.dmb{{!gbjm-dmb{{!dbo(u!cf!ovmm"));
                return null;
            }
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, (Class) cls);
        } catch (Throwable th) {
            int i = ERROR_FROM_JSON_CLAZZ_COUNT + 1;
            ERROR_FROM_JSON_CLAZZ_COUNT = i;
            if (i < 2) {
                String strDexa = dexc.dexa("gspnKtpo.dmb{{!gbjm!");
                DebugLog.release_e(TAG, strDexa + th);
                reportErrorInfo(strDexa, th);
            }
            return null;
        }
    }

    public String toJson(Object obj) {
        try {
            if (obj == null) {
                DebugLog.release_e(TAG, dexc.dexa("upKtpo!gbjm-pck!dbo(u!cf!ovmm"));
                return "";
            }
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return this.gson.toJson(obj);
        } catch (Throwable th) {
            int i = ERROR_TO_JSON_COUNT + 1;
            ERROR_TO_JSON_COUNT = i;
            if (i < 2) {
                String strDexa = dexc.dexa("upKtpo!gbjm!");
                DebugLog.release_e(TAG, strDexa + th);
                reportErrorInfo(strDexa, th);
            }
            return "";
        }
    }

    public <T> T fromJson(String str, TypeToken typeToken) {
        try {
            if (TextUtils.isEmpty(str)) {
                DebugLog.release_e(TAG, dexc.dexa("gspnKtpo.uzqfUplfo!gbjm-ebub!dbo(u!cf!ovmm"));
                return null;
            }
            if (typeToken == null) {
                DebugLog.release_e(TAG, dexc.dexa("gspnKtpo.uzqfUplfo!gbjm-uzqfUplfo!dbo(u!cf!ovmm"));
                return null;
            }
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, typeToken.getType());
        } catch (Throwable th) {
            int i = ERROR_FROM_JSON_TYPE_TOKEN_COUNT + 1;
            ERROR_FROM_JSON_TYPE_TOKEN_COUNT = i;
            if (i < 2) {
                String strDexa = dexc.dexa("gspnKtpo.uzqfUplfo!gbjm!");
                DebugLog.release_e(TAG, strDexa + th);
                reportErrorInfo(strDexa, th);
            }
            return null;
        }
    }
}
