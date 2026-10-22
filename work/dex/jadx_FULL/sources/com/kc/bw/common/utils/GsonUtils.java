package com.kc.bw.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GsonUtils {
    public static final String TAG = dexg.dexa("HtpoVujmt");
    public static volatile GsonUtils gsonUtils = null;
    public Gson gson;

    public GsonUtils() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    public static GsonUtils getInstance() {
        if (gsonUtils == null) {
            synchronized (GsonUtils.class) {
                try {
                    if (gsonUtils == null) {
                        gsonUtils = new GsonUtils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return gsonUtils;
    }

    private void reportErrorInfo(String str, Throwable th) {
        ReportUtils.exReport(ContextContainer.getApplicationContext(), 900001, dexg.dexa("疱环楅葇楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public <T> T fromJson(String str, TypeToken typeToken) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, typeToken.getType());
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexg.dexa("gspnKtpo)UzqfUplfo*!fssps�") + th);
            reportErrorInfo(dexg.dexa("疱环騤矑ꕚ鰰)gspnKtpo.UzqfUplfo*;"), th);
            return null;
        }
    }

    public <T> T fromJson(String str, Class<T> cls) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return (T) this.gson.fromJson(str, (Class) cls);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexg.dexa("gspnKtpo)Dmbtt*!fssps�") + th);
            reportErrorInfo(dexg.dexa("疱环騤矑ꕚ鰰)gspnKtpo.Dmbtt*;"), th);
            return null;
        }
    }

    public String toJson(Object obj) {
        try {
            if (this.gson == null) {
                this.gson = new Gson();
            }
            return this.gson.toJson(obj);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexg.dexa("upKtpo!fssps�") + th);
            reportErrorInfo(dexg.dexa("疱环騤矑ꕚ鰰)upKtpo*;"), th);
            return "";
        }
    }
}
