package com.alibaba.triver.kit.api.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SPUtils {
    private static final String KEY_CONFIG_VERSION = "_config_version";
    private static final String NAME_SPACE = "triver";
    public static final String ORANGE_KEY_WINDMILL_DELETE_LIST = "_delete_list";

    private static Context getContext() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            return rVEnvironmentService.getApplicationContext();
        }
        throw new RuntimeException("RVEnvironmentService is necessary");
    }

    public static void initIfNeed() {
        Map<String, String> configsByGroup;
        IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
        if (iConfigProxy == null || (configsByGroup = iConfigProxy.getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_SP_CONFIG)) == null || configsByGroup.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(NAME_SPACE, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String str = configsByGroup.get(KEY_CONFIG_VERSION);
        String string = sharedPreferences.getString(KEY_CONFIG_VERSION, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(string) || !TextUtils.equals(str, string)) {
            String strRemove = configsByGroup.containsKey(ORANGE_KEY_WINDMILL_DELETE_LIST) ? configsByGroup.remove(ORANGE_KEY_WINDMILL_DELETE_LIST) : null;
            for (String str2 : configsByGroup.keySet()) {
                editorEdit.putString(str2, configsByGroup.get(str2));
            }
            if (!TextUtils.isEmpty(strRemove)) {
                for (String str3 : JSON.parseArray(strRemove)) {
                    if (sharedPreferences.contains(str3)) {
                        editorEdit.remove(str3);
                    }
                }
            }
            editorEdit.apply();
        }
    }

    public static boolean readBoolean(String str, boolean z) {
        try {
            return Boolean.parseBoolean(getContext().getSharedPreferences(NAME_SPACE, 0).getString(str, z + ""));
        } catch (Exception unused) {
            return z;
        }
    }

    public static int readInt(String str, int i) {
        try {
            return Integer.parseInt(getContext().getSharedPreferences(NAME_SPACE, 0).getString(str, i + ""));
        } catch (Exception unused) {
            return i;
        }
    }

    public static long readLong(String str, long j) {
        try {
            return Long.parseLong(getContext().getSharedPreferences(NAME_SPACE, 0).getString(str, j + ""));
        } catch (Exception unused) {
            return j;
        }
    }

    public static String readString(String str, String str2) {
        return getContext().getSharedPreferences(NAME_SPACE, 0).getString(str, str2);
    }

    public static void remove(String str) {
        getContext().getSharedPreferences(NAME_SPACE, 0).edit().remove(str).apply();
    }

    public static void writeBoolean(String str, boolean z) {
        getContext().getSharedPreferences(NAME_SPACE, 0).edit().putString(str, z + "").apply();
    }

    public static void writeInt(String str, int i) {
        getContext().getSharedPreferences(NAME_SPACE, 0).edit().putString(str, i + "").apply();
    }

    public static void writeLong(String str, long j) {
        getContext().getSharedPreferences(NAME_SPACE, 0).edit().putString(str, j + "").apply();
    }

    public static void writeString(String str, String str2) {
        getContext().getSharedPreferences(NAME_SPACE, 0).edit().putString(str, str2).apply();
    }

    public static String readString(String str, String str2, String str3) {
        return getContext().getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void writeString(String str, String str2, String str3) {
        getContext().getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
