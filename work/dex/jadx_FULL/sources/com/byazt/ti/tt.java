package com.byazt.ti;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2161, 13})
public class tt {
    public static boolean c() {
        return com.byazt.yy.ve.getContext() != null;
    }

    public static Context getContext() {
        return com.byazt.yy.ve.getContext();
    }

    private static ContentResolver tt() {
        try {
            if (c()) {
                return com.byazt.yy.ve.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String ve() {
        return n.tt + "/t_sp/";
    }

    public static synchronized void c(String str, String str2, Boolean bool) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve(TypedValues.Custom.S_BOOLEAN, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String ve(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    public static String tt(String str, String str2, String str3) {
        String type;
        if (!c()) {
            return str3;
        }
        try {
            ContentResolver contentResolverTt = tt();
            return (contentResolverTt == null || (type = contentResolverTt.getType(Uri.parse(ve(TypedValues.Custom.S_STRING, str2, str)))) == null || type.equals("null") || TextUtils.isEmpty(type)) ? str3 : type;
        } catch (Throwable unused) {
        }
    }

    private static String ve(String str, String str2, String str3) {
        return ve() + str + WVNativeCallbackUtil.SEPERATER + str2 + ve(str3);
    }

    @TargetApi(11)
    public static Set<String> tt(String str, String str2, Set<String> set) {
        String type;
        if (!c()) {
            return set;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt == null || (type = contentResolverTt.getType(Uri.parse(ve("string_set", str2, str)))) == null || type.equals("null") || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String strSubstring = type.substring(1, type.length() - 1);
            String[] strArrSplit = strSubstring.split(", ");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(strSubstring)) {
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static synchronized void c(String str, String str2, String str3) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve(TypedValues.Custom.S_STRING, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void c(String str, String str2, Integer num) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void tt(String str, String str2) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    contentResolverTt.delete(Uri.parse(ve("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> tt(String str) {
        Cursor cursorQuery;
        Object string;
        String string2;
        if (!c()) {
            return null;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null) {
                cursorQuery = contentResolverTt.query(Uri.parse(ve() + "get_all" + ve(str)), null, null, null, null);
                try {
                    HashMap map = new HashMap();
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("cursor_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("cursor_type");
                        int columnIndex3 = cursorQuery.getColumnIndex("cursor_value");
                        do {
                            String string3 = cursorQuery.getString(columnIndex);
                            String string4 = cursorQuery.getString(columnIndex2);
                            if (string4.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                                string2 = cursorQuery.getString(columnIndex3);
                                if (string2.contains("__COMMA__") && string2.matches("\\[.*\\]")) {
                                    String strSubstring = string2.substring(1, string2.length() - 1);
                                    String[] strArrSplit = strSubstring.split(", ");
                                    HashSet hashSet = new HashSet();
                                    if (!TextUtils.isEmpty(strSubstring)) {
                                        for (String str2 : strArrSplit) {
                                            string = string2;
                                            string = string2;
                                            hashSet.add(str2.replace("__COMMA__", ", "));
                                        }
                                        string = string2;
                                        string = string2;
                                    }
                                    string = string2;
                                    string = string2;
                                    string = hashSet;
                                }
                            } else if (string4.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string4.equalsIgnoreCase("int")) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string4.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string4.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else {
                                string = string4.equalsIgnoreCase("string_set") ? cursorQuery.getString(columnIndex3) : null;
                            }
                            string = string2;
                            string = string2;
                            string = string2;
                            map.put(string3, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }

    public static synchronized void c(String str, String str2, Long l) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void c(String str, String str2, Float f) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve(TypedValues.Custom.S_FLOAT, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", f);
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void c(String str, String str2, Set<String> set) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    Uri uri = Uri.parse(ve("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put("value", hashSet.toString());
                    contentResolverTt.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int c(String str, String str2, int i) {
        String type;
        if (!c()) {
            return i;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null && (type = contentResolverTt.getType(Uri.parse(ve("int", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float c(String str, String str2, float f) {
        String type;
        if (!c()) {
            return f;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null && (type = contentResolverTt.getType(Uri.parse(ve(TypedValues.Custom.S_FLOAT, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean c(String str, String str2, boolean z) {
        String type;
        if (!c()) {
            return z;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null && (type = contentResolverTt.getType(Uri.parse(ve(TypedValues.Custom.S_BOOLEAN, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long c(String str, String str2, long j) {
        String type;
        if (!c()) {
            return j;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null && (type = contentResolverTt.getType(Uri.parse(ve("long", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static boolean c(String str, String str2) {
        String type;
        if (!c()) {
            return false;
        }
        try {
            ContentResolver contentResolverTt = tt();
            if (contentResolverTt != null && (type = contentResolverTt.getType(Uri.parse(ve("contain", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void c(String str) {
        if (c()) {
            try {
                ContentResolver contentResolverTt = tt();
                if (contentResolverTt != null) {
                    contentResolverTt.delete(Uri.parse(ve() + "clean" + ve(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
