package com.kc.dw.core.loader.serverbidding;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class S2SBManager {
    public static String MsPidConst = "MS_PID_";
    private static final String TAG = "S2SBManager";
    public static Gson gson = new Gson();

    public static S2sbCacheEntity getAdByPid(Context context, String str) {
        try {
            String string = context.getSharedPreferences("ms_platform", 0).getString(MsPidConst + str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return (S2sbCacheEntity) gson.fromJson(string, S2sbCacheEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void putAdByPid(Context context, String str, S2sbCacheEntity s2sbCacheEntity) {
        try {
            String json = gson.toJson(s2sbCacheEntity);
            context.getSharedPreferences("ms_platform", 0).edit().putString(MsPidConst + str, json).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
