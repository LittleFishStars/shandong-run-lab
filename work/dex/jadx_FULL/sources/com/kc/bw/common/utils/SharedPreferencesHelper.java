package com.kc.bw.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.utils.AesUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SharedPreferencesHelper {
    public static SharedPreferencesHelper instance;
    public final SharedPreferences baseConfigPreference;
    public final SharedPreferences extConfigPreference;

    @Keep
    public enum ConfigType {
        BASE,
        EXT
    }

    public SharedPreferencesHelper(Context context) {
        this.baseConfigPreference = context.getSharedPreferences(dexg.dexa("ldcx/qsfgfsfodft"), 0);
        this.extConfigPreference = context.getSharedPreferences(dexg.dexa("ldcx`fyu`dpogjh/qsfgfsfodft"), 0);
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
            DebugLog.common_w(dexg.dexa("dmfbsBmmQsfgfsfodft!gbjm!") + Log.getStackTraceString(th));
        }
    }

    public boolean getPreferencesBoolean(ConfigType configType, String str, boolean z) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getBoolean(str, z);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getBoolean(str, z);
        }
        DebugLog.common_w(dexg.dexa("hfuQsfgfsfodftCppmfbo!gbjm-dpogjhUzqf!volopxo"));
        return false;
    }

    public float getPreferencesFloat(ConfigType configType, String str, float f) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getFloat(str, f);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getFloat(str, f);
        }
        DebugLog.common_w(dexg.dexa("hfuQsfgfsfodftGmpbu!gbjm-dpogjhUzqf!volopxo"));
        return 0.0f;
    }

    public int getPreferencesInteger(ConfigType configType, String str, int i) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getInt(str, i);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getInt(str, i);
        }
        DebugLog.common_w(dexg.dexa("hfuQsfgfsfodftJoufhfs!gbjm-dpogjhUzqf!volopxo"));
        return 0;
    }

    public long getPreferencesLong(ConfigType configType, String str, long j) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getLong(str, j);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getLong(str, j);
        }
        DebugLog.common_w(dexg.dexa("hfuQsfgfsfodftMpoh!gbjm-dpogjhUzqf!volopxo"));
        return 0L;
    }

    public String getPreferencesString(ConfigType configType, String str) {
        return getPreferencesString(configType, str, (String) null);
    }

    public String getPreferencesString(ConfigType configType, String str, String str2) {
        if (configType == ConfigType.BASE) {
            return this.baseConfigPreference.getString(str, str2);
        }
        if (configType == ConfigType.EXT) {
            return this.extConfigPreference.getString(str, str2);
        }
        DebugLog.common_w(dexg.dexa("hfuQsfgfsfodftTusjoh!gbjm-dpogjhUzqf!volopxo"));
        return "";
    }

    public String getPreferencesString(ConfigType configType, String str, String str2, boolean z) {
        String preferencesString;
        try {
            preferencesString = getPreferencesString(configType, str, str2);
            try {
                return (TextUtils.isEmpty(preferencesString) || !z || TextUtils.isEmpty(ConstantInfo.getAppToken())) ? preferencesString : AesUtil.decrypt(preferencesString, ConstantInfo.getAppToken(), str);
            } catch (Throwable th) {
                th = th;
                DebugLog.common_w(str + dexg.dexa("!hfuQsfgfsfodftTusjoh!gbjm!") + th);
                return preferencesString;
            }
        } catch (Throwable th2) {
            th = th2;
            preferencesString = "";
        }
    }

    public String getPreferencesString(ConfigType configType, String str, boolean z) {
        String preferencesString;
        try {
            preferencesString = getPreferencesString(configType, str);
            try {
                return (TextUtils.isEmpty(preferencesString) || !z || TextUtils.isEmpty(ConstantInfo.getAppToken())) ? preferencesString : AesUtil.decrypt(preferencesString, ConstantInfo.getAppToken(), str);
            } catch (Throwable th) {
                th = th;
                DebugLog.common_w(str + dexg.dexa("!hfuQsfgfsfodftTusjoh!gbjm!") + th);
                return preferencesString;
            }
        } catch (Throwable th2) {
            th = th2;
            preferencesString = "";
        }
    }

    public String getPreferencesString(String str) {
        return getPreferencesString(ConfigType.BASE, str);
    }

    public String getPreferencesString(String str, String str2) {
        return getPreferencesString(ConfigType.BASE, str, str2);
    }

    public String getPreferencesString(String str, String str2, boolean z) {
        return getPreferencesString(ConfigType.BASE, str, str2, z);
    }

    public String getPreferencesString(String str, boolean z) {
        return getPreferencesString(ConfigType.BASE, str, z);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    public void removeValueByKey(ConfigType configType, String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        DebugLog.common_w(dexg.dexa("sfnpwfWbmvfCzLfz!lfz;") + str);
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("sfnpwfWbmvfCzLfz!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.remove(str);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("sfnpwfWbmvfCzLfz!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.remove(str);
            editorEdit.apply();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public void savePreferencesBoolean(ConfigType configType, String str, boolean z) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftCppmfbo!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.putBoolean(str, z);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftCppmfbo!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public void savePreferencesFloat(ConfigType configType, String str, float f) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftGmpbu!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.putFloat(str, f);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftGmpbu!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putFloat(str, f);
            editorEdit.apply();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public void savePreferencesInteger(ConfigType configType, String str, int i) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftJoufhfs!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.putInt(str, i);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftJoufhfs!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putInt(str, i);
            editorEdit.apply();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public void savePreferencesLong(ConfigType configType, String str, long j) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftMpoh!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.putLong(str, j);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftMpoh!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putLong(str, j);
            editorEdit.apply();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:37:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x003c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x006c A[SYNTHETIC] */
    public void savePreferencesMap(ConfigType configType, Map<String, Object> map) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        Object obj;
        String string;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftNbq!gbjm-fejups!jt!ovmm"));
                return;
            }
            for (String str : map.keySet()) {
                obj = map.get(str);
                if (obj instanceof Integer) {
                    editorEdit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else {
                    if (obj instanceof String) {
                        string = (String) obj;
                    } else if (obj instanceof Float) {
                        editorEdit.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Long) {
                        editorEdit.putLong(str, ((Long) obj).longValue());
                    } else if (obj != null) {
                        string = obj.toString();
                    } else {
                        string = "";
                    }
                    editorEdit.putString(str, string);
                }
            }
            editorEdit.apply();
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftNbq!gbjm-fejups!jt!ovmm"));
            return;
        }
        while (r0.hasNext()) {
            obj = map.get(str);
            if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else {
                if (obj instanceof String) {
                    string = (String) obj;
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(str, ((Long) obj).longValue());
                } else if (obj != null) {
                    string = obj.toString();
                } else {
                    string = "";
                }
                editorEdit.putString(str, string);
            }
        }
        editorEdit.apply();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public void savePreferencesString(ConfigType configType, String str, String str2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences;
        if (configType != ConfigType.BASE) {
            if (configType == ConfigType.EXT) {
                sharedPreferences = this.extConfigPreference;
            } else {
                editorEdit = null;
            }
            if (editorEdit == null) {
                DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftTusjoh!gbjm-fejups!jt!ovmm"));
            } else {
                editorEdit.putString(str, str2);
                editorEdit.apply();
            }
        }
        sharedPreferences = this.baseConfigPreference;
        editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            DebugLog.common_w(dexg.dexa("tbwfQsfgfsfodftTusjoh!gbjm-fejups!jt!ovmm"));
        } else {
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }

    public void savePreferencesString(ConfigType configType, String str, String str2, boolean z) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(ConstantInfo.getAppToken())) {
                    str2 = AesUtil.encrypt(str2, ConstantInfo.getAppToken(), str);
                }
            } catch (Throwable th) {
                DebugLog.common_w(str + dexg.dexa("!tbwfQsfgfsfodftTusjoh!gbjm!") + th);
            }
        }
        savePreferencesString(configType, str, str2);
    }

    public void savePreferencesString(String str, String str2) {
        savePreferencesString(ConfigType.BASE, str, str2);
    }

    public void savePreferencesString(String str, String str2, boolean z) {
        savePreferencesString(ConfigType.BASE, str, str2, z);
    }
}
