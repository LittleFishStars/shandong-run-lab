package cj.mobile.wm.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.utils.AesUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SharedPreferencesHelper {
    public static SharedPreferencesHelper instance;
    public final SharedPreferences baseConfigPreference;
    public final SharedPreferences extConfigPreference;

    public enum ConfigType {
        BASE,
        EXT
    }

    public SharedPreferencesHelper(Context context) {
        this.baseConfigPreference = context.getSharedPreferences(dexc.dexa("mzxn/qsfgfsfodft"), 0);
        this.extConfigPreference = context.getSharedPreferences(dexc.dexa("mzxn`fyu`dpogjh/qsfgfsfodft"), 0);
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesHelper(context);
        }
        return instance;
    }

    public void clearAllPreferences() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        try {
            SharedPreferences sharedPreferences = this.baseConfigPreference;
            if (sharedPreferences != null && (editorEdit2 = sharedPreferences.edit()) != null) {
                editorEdit2.clear();
                editorEdit2.apply();
            }
            SharedPreferences sharedPreferences2 = this.extConfigPreference;
            if (sharedPreferences2 == null || (editorEdit = sharedPreferences2.edit()) == null) {
                return;
            }
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("dmfbsBmmQsfgfsfodft!gbjm!") + Log.getStackTraceString(th));
        }
    }

    public boolean getPreferencesBoolean(ConfigType configType, String str, boolean z) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getBoolean(str, z);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getBoolean(str, z);
        }
        DebugLog.common_w(dexc.dexa("hfuQsfgfsfodftCppmfbo!gbjm-dpogjhUzqf!volopxo"));
        return false;
    }

    public float getPreferencesFloat(ConfigType configType, String str, float f) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getFloat(str, f);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getFloat(str, f);
        }
        DebugLog.common_w(dexc.dexa("hfuQsfgfsfodftGmpbu!gbjm-dpogjhUzqf!volopxo"));
        return 0.0f;
    }

    public int getPreferencesInteger(ConfigType configType, String str, int i) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getInt(str, i);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getInt(str, i);
        }
        DebugLog.common_w(dexc.dexa("hfuQsfgfsfodftJoufhfs!gbjm-dpogjhUzqf!volopxo"));
        return 0;
    }

    public long getPreferencesLong(ConfigType configType, String str, long j) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getLong(str, j);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getLong(str, j);
        }
        DebugLog.common_w(dexc.dexa("hfuQsfgfsfodftMpoh!gbjm-dpogjhUzqf!volopxo"));
        return 0L;
    }

    public String getPreferencesString(String str, boolean z) {
        return getPreferencesString(ConfigType.BASE, str, z);
    }

    public void removeValueByKey(ConfigType configType, String str) {
        SharedPreferences.Editor editorEdit;
        DebugLog.common_w(dexc.dexa("sfnpwfWbmvfCzLfz!lfz;") + str);
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("sfnpwfWbmvfCzLfz!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.remove(str);
            editorEdit.apply();
        }
    }

    public void savePreferencesBoolean(ConfigType configType, String str, boolean z) {
        SharedPreferences.Editor editorEdit;
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftCppmfbo!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    public void savePreferencesFloat(ConfigType configType, String str, float f) {
        SharedPreferences.Editor editorEdit;
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftGmpbu!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putFloat(str, f);
            editorEdit.apply();
        }
    }

    public void savePreferencesInteger(ConfigType configType, String str, int i) {
        SharedPreferences.Editor editorEdit;
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftJoufhfs!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putInt(str, i);
            editorEdit.apply();
        }
    }

    public void savePreferencesLong(ConfigType configType, String str, long j) {
        SharedPreferences.Editor editorEdit;
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftMpoh!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putLong(str, j);
            editorEdit.apply();
        }
    }

    public void savePreferencesMap(ConfigType configType, Map<String, Object> map) {
        SharedPreferences.Editor editorEdit = configType == ConfigType.BASE ? this.baseConfigPreference.edit() : configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftNbq!gbjm-fejups!jt!ovmm"));
            return;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Float) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (obj != null) {
                editorEdit.putString(str, obj.toString());
            } else {
                editorEdit.putString(str, "");
            }
        }
        editorEdit.apply();
    }

    public void savePreferencesString(String str, String str2, boolean z) {
        savePreferencesString(ConfigType.BASE, str, str2, z);
    }

    public String getPreferencesString(ConfigType configType, String str, boolean z) {
        String preferencesString;
        try {
            preferencesString = getPreferencesString(configType, str);
            try {
                return (TextUtils.isEmpty(preferencesString) || !z || TextUtils.isEmpty(ConstantInfo.getAppToken())) ? preferencesString : AesUtil.decrypt(preferencesString, ConstantInfo.getAppToken(), str);
            } catch (Throwable th) {
                th = th;
                DebugLog.common_w(str + dexc.dexa("!hfuQsfgfsfodftTusjoh!gbjm!") + th);
                return preferencesString;
            }
        } catch (Throwable th2) {
            th = th2;
            preferencesString = "";
        }
    }

    public void savePreferencesString(ConfigType configType, String str, String str2, boolean z) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(ConstantInfo.getAppToken())) {
                    str2 = AesUtil.encrypt(str2, ConstantInfo.getAppToken(), str);
                }
            } catch (Throwable th) {
                DebugLog.common_w(str + dexc.dexa("!tbwfQsfgfsfodftTusjoh!gbjm!") + th);
            }
        }
        savePreferencesString(configType, str, str2);
    }

    public String getPreferencesString(String str) {
        return getPreferencesString(ConfigType.BASE, str);
    }

    public void savePreferencesString(String str, String str2) {
        savePreferencesString(ConfigType.BASE, str, str2);
    }

    public String getPreferencesString(ConfigType configType, String str) {
        return getPreferencesString(configType, str, (String) null);
    }

    public void savePreferencesString(ConfigType configType, String str, String str2) {
        SharedPreferences.Editor editorEdit;
        if (configType == ConfigType.BASE) {
            editorEdit = this.baseConfigPreference.edit();
        } else {
            editorEdit = configType == ConfigType.EXT ? this.extConfigPreference.edit() : null;
        }
        if (editorEdit == null) {
            DebugLog.common_w(dexc.dexa("tbwfQsfgfsfodftTusjoh!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }

    public String getPreferencesString(String str, String str2, boolean z) {
        return getPreferencesString(ConfigType.BASE, str, str2, z);
    }

    public String getPreferencesString(ConfigType configType, String str, String str2, boolean z) {
        String preferencesString;
        try {
            preferencesString = getPreferencesString(configType, str, str2);
            try {
                return (TextUtils.isEmpty(preferencesString) || !z || TextUtils.isEmpty(ConstantInfo.getAppToken())) ? preferencesString : AesUtil.decrypt(preferencesString, ConstantInfo.getAppToken(), str);
            } catch (Throwable th) {
                th = th;
                DebugLog.common_w(str + dexc.dexa("!hfuQsfgfsfodftTusjoh!gbjm!") + th);
                return preferencesString;
            }
        } catch (Throwable th2) {
            th = th2;
            preferencesString = "";
        }
    }

    public String getPreferencesString(String str, String str2) {
        return getPreferencesString(ConfigType.BASE, str, str2);
    }

    public String getPreferencesString(ConfigType configType, String str, String str2) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getString(str, str2);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getString(str, str2);
        }
        DebugLog.common_w(dexc.dexa("hfuQsfgfsfodftTusjoh!gbjm-dpogjhUzqf!volopxo"));
        return "";
    }
}
