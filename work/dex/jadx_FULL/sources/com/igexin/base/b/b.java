package com.igexin.base.b;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37803a;
    private SharedPreferences b;

    public b(Context context, String str) {
        this.f37803a = context;
        this.b = context.getSharedPreferences(str, 0);
    }

    @Override // com.igexin.base.b.a
    public final Object getParam(String str, Object obj) {
        SharedPreferences sharedPreferences = this.b;
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
        return obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }

    @Override // com.igexin.base.b.a
    public final boolean remove(String str) {
        SharedPreferences.Editor editorEdit = this.b.edit();
        editorEdit.remove(str);
        editorEdit.commit();
        return false;
    }

    @Override // com.igexin.base.b.a
    public final boolean saveParam(String str, Object obj) {
        if (obj == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.b.edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        }
        return editorEdit.commit();
    }
}
