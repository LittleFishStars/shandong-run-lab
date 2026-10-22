package com.fl.saas.config.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SPUtil {
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final int DEFAULT_INT = 0;
    private static final String DEFAULT_STRING = "";
    private static final String TAG = "SPUtil";
    private static Context mContext;
    private static SharedPreferences.Editor sEditor;
    private static SPUtil sSPUtil;
    private static SharedPreferences sSharedPreferences;
    private static final Set<String> DEFAULT_STRING_SET = new HashSet(0);
    private static final String DEFAULT_SP_NAME = "YD_SP";
    private static String mCurSPName = DEFAULT_SP_NAME;
    public static String UPLOAD_DATE = "APP_DATE";

    private SPUtil() {
        this(DEFAULT_SP_NAME);
    }

    private SPUtil(String str) {
        mCurSPName = str;
        Log.i(TAG, "SPUtil: " + mCurSPName);
    }

    public static SPUtil getInstance() {
        if (sSPUtil == null || !mCurSPName.equals(DEFAULT_SP_NAME)) {
            synchronized (SPUtil.class) {
                sSPUtil = new SPUtil();
            }
        }
        return sSPUtil;
    }

    public boolean clear() {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return false;
        }
        editor.clear();
        return sEditor.commit();
    }

    public boolean contains(int i) {
        return contains(mContext.getString(i));
    }

    public boolean contains(String str) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    public Object get(int i, Object obj) {
        return get(mContext.getString(i), obj);
    }

    public Object get(String str, Object obj) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        if (sharedPreferences == null) {
            return obj;
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = sSharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public boolean getBoolean(int i) {
        return getBoolean(mContext.getString(i));
    }

    public boolean getBoolean(int i, boolean z) {
        return getBoolean(mContext.getString(i), z);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(int i) {
        return getFloat(mContext.getString(i));
    }

    public float getFloat(int i, float f) {
        return getFloat(mContext.getString(i), f);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public float getFloat(String str, float f) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences == null ? f : sharedPreferences.getFloat(str, f);
    }

    public int getInt(int i) {
        return getInt(mContext.getString(i));
    }

    public int getInt(int i, int i2) {
        return getInt(mContext.getString(i), i2);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public long getLong(int i) {
        return getLong(mContext.getString(i));
    }

    public long getLong(int i, long j) {
        return getLong(mContext.getString(i), j);
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

    public String getString(int i) {
        return getString(mContext.getString(i), "");
    }

    public String getString(int i, String str) {
        return getString(mContext.getString(i), str);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    public Set<String> getStringSet(int i) {
        return getStringSet(mContext.getString(i));
    }

    public Set<String> getStringSet(int i, Set<String> set) {
        return getStringSet(mContext.getString(i), set);
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, DEFAULT_STRING_SET);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = sSharedPreferences;
        return sharedPreferences == null ? set : sharedPreferences.getStringSet(str, set);
    }

    public void init(Context context) {
        init(context, DEFAULT_SP_NAME);
    }

    public void init(Context context, String str) {
        mContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(mCurSPName, 0);
        sSharedPreferences = sharedPreferences;
        sEditor = sharedPreferences.edit();
        if (sSPUtil != null && str.equals(mCurSPName)) {
            return;
        }
        SPUtil sPUtil = new SPUtil(str);
        sSPUtil = sPUtil;
    }

    public SPUtil put(int i, Object obj) {
        return put(mContext.getString(i), obj);
    }

    public SPUtil put(String str, Object obj) {
        String string;
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return sSPUtil;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else {
                string = obj.toString();
            }
            sEditor.apply();
            return sSPUtil;
        }
        string = (String) obj;
        editor.putString(str, string);
        sEditor.apply();
        return sSPUtil;
    }

    public SPUtil putBoolean(int i, boolean z) {
        return putBoolean(mContext.getString(i), z);
    }

    public SPUtil putBoolean(String str, boolean z) {
        SharedPreferences.Editor editor = sEditor;
        if (editor != null) {
            editor.putBoolean(str, z).apply();
        }
        return sSPUtil;
    }

    public SPUtil putFloat(int i, float f) {
        return putFloat(mContext.getString(i), f);
    }

    public SPUtil putFloat(String str, float f) {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return sSPUtil;
        }
        editor.putFloat(str, f).apply();
        return sSPUtil;
    }

    public SPUtil putInt(int i, int i2) {
        return putInt(mContext.getString(i), i2);
    }

    public SPUtil putInt(String str, int i) {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return this;
        }
        editor.putInt(str, i).apply();
        return this;
    }

    public SPUtil putLong(int i, long j) {
        return putLong(mContext.getString(i), j);
    }

    public SPUtil putLong(String str, long j) {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return sSPUtil;
        }
        editor.putLong(str, j).apply();
        return sSPUtil;
    }

    public SPUtil putString(int i, String str) {
        return putString(mContext.getString(i), str);
    }

    public SPUtil putString(String str, String str2) {
        SharedPreferences.Editor editor = sEditor;
        if (editor != null) {
            editor.putString(str, str2).apply();
        }
        return sSPUtil;
    }

    public SPUtil putStringSet(int i, Set<String> set) {
        return putStringSet(mContext.getString(i), set);
    }

    public SPUtil putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return sSPUtil;
        }
        editor.putStringSet(str, set).apply();
        return sSPUtil;
    }

    public SPUtil remove(int i) {
        return remove(mContext.getString(i));
    }

    public SPUtil remove(String str) {
        SharedPreferences.Editor editor = sEditor;
        if (editor == null) {
            return sSPUtil;
        }
        editor.remove(str).apply();
        return sSPUtil;
    }
}
