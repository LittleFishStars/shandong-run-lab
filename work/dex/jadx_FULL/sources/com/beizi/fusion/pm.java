package com.beizi.fusion;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class pm {
    public static Object a(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("beizisdk_config", 0);
            if (sharedPreferences == null) {
                return null;
            }
            if (obj instanceof Boolean) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
            }
            if (obj instanceof Float) {
                return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
            }
            if (obj instanceof Integer) {
                return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
            }
            if (obj instanceof Long) {
                return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
            }
            if (obj instanceof String) {
                return sharedPreferences.getString(str, (String) obj);
            }
            if (obj instanceof Set) {
                return sharedPreferences.getStringSet(str, (Set) obj);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("fusion_config", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static void c(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("beizisdk_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editorEdit.remove(str);
                editorEdit.putStringSet(str, (Set) obj);
            }
            editorEdit.apply();
        }
    }

    public static void d(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("fusion_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editorEdit.remove(str);
                editorEdit.putStringSet(str, (Set) obj);
            }
            editorEdit.apply();
        }
    }

    public static Object b(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("fusion_config", 0);
            if (sharedPreferences == null) {
                return null;
            }
            if (obj instanceof Boolean) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
            }
            if (obj instanceof Float) {
                return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
            }
            if (obj instanceof Integer) {
                return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
            }
            if (obj instanceof Long) {
                return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
            }
            if (obj instanceof String) {
                return sharedPreferences.getString(str, (String) obj);
            }
            if (obj instanceof Set) {
                return sharedPreferences.getStringSet(str, (Set) obj);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(Context context, String str) {
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("beizisdk_config", 0);
                if (sharedPreferences == null) {
                    return null;
                }
                return sharedPreferences.getString(str, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("beizisdk_config", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.apply();
        }
    }
}
