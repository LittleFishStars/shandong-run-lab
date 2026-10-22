package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.provider.MediaStore;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40065a = "7";
    public static final String b = "6";
    public static final String c = "5";
    public static final String d = "4";
    public static final String e = "3";
    public static final String f = "2";
    public static final String g = "1";

    /* JADX WARN: Code duplicated, block: B:63:0x0286  */
    public static JSONArray a(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        String str;
        Object obj;
        JSONArray jSONArray;
        JSONArray jSONArray2 = new JSONArray();
        try {
            try {
                CRC32 crc32 = new CRC32();
                ContentResolver contentResolver = context.getContentResolver();
                Cursor cursorQuery = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 1), null, null, null, null);
                try {
                    try {
                        if (cursorQuery.moveToNext()) {
                            JSONObject jSONObject = new JSONObject();
                            crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                            jSONObject.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                            jSONObject.put("2", "1");
                            jSONObject.put("1", "0");
                            jSONArray2.put(jSONObject);
                        }
                        cursorQuery.close();
                        Cursor cursorQuery2 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 2), null, null, null, null);
                        if (cursorQuery2.moveToNext()) {
                            JSONObject jSONObject2 = new JSONObject();
                            crc32.update(cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject2.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject2.put("4", cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow("date_added")));
                            jSONObject2.put("3", cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow("date_modified")));
                            str = "2";
                            jSONObject2.put(str, "1");
                            jSONObject2.put("1", "1");
                            jSONArray2.put(jSONObject2);
                        } else {
                            str = "2";
                        }
                        cursorQuery2.close();
                        String str2 = str;
                        Cursor cursorQuery3 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 4), null, null, null, null);
                        if (cursorQuery3.moveToNext()) {
                            JSONObject jSONObject3 = new JSONObject();
                            crc32.update(cursorQuery3.getString(cursorQuery3.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject3.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject3.put("4", cursorQuery3.getInt(cursorQuery3.getColumnIndexOrThrow("date_added")));
                            jSONObject3.put("3", cursorQuery3.getInt(cursorQuery3.getColumnIndexOrThrow("date_modified")));
                            jSONObject3.put(str2, "1");
                            jSONObject3.put("1", str2);
                            jSONArray2.put(jSONObject3);
                        }
                        cursorQuery3.close();
                        Cursor cursorQuery4 = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_ringtone= ? ", new String[]{"1"}, "date_added");
                        if (cursorQuery4.moveToNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            crc32.update(cursorQuery4.getString(cursorQuery4.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject4.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject4.put("4", cursorQuery4.getInt(cursorQuery4.getColumnIndexOrThrow("date_added")));
                            jSONObject4.put("3", cursorQuery4.getInt(cursorQuery4.getColumnIndexOrThrow("date_modified")));
                            obj = "0";
                            jSONObject4.put(str2, obj);
                            jSONObject4.put("1", obj);
                            jSONArray2.put(jSONObject4);
                        } else {
                            obj = "0";
                        }
                        cursorQuery4.close();
                        Object obj2 = obj;
                        try {
                            cursorQuery = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_notification= ? ", new String[]{"1"}, "date_added");
                            try {
                                if (cursorQuery.moveToNext()) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")).getBytes());
                                    jSONObject5.put("5", Long.toHexString(crc32.getValue()));
                                    jSONObject5.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                                    jSONObject5.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                                    jSONObject5.put(str2, obj2);
                                    jSONObject5.put("1", "1");
                                    jSONArray = jSONArray2;
                                    try {
                                        jSONArray.put(jSONObject5);
                                    } catch (Exception unused) {
                                        jSONArray2 = jSONArray;
                                        cursor2 = cursorQuery;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        return jSONArray2;
                                    }
                                } else {
                                    jSONArray = jSONArray2;
                                }
                                cursorQuery.close();
                                try {
                                    JSONArray jSONArray3 = jSONArray;
                                    try {
                                        cursorQuery = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_alarm= ? ", new String[]{"1"}, "date_added");
                                        try {
                                            if (cursorQuery.moveToNext()) {
                                                JSONObject jSONObject6 = new JSONObject();
                                                crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")).getBytes());
                                                jSONObject6.put("5", Long.toHexString(crc32.getValue()));
                                                jSONObject6.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                                                jSONObject6.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                                                jSONObject6.put(str2, obj2);
                                                jSONObject6.put("1", str2);
                                                jSONArray2 = jSONArray3;
                                                jSONArray2.put(jSONObject6);
                                            } else {
                                                jSONArray2 = jSONArray3;
                                            }
                                            cursorQuery.close();
                                        } catch (Exception unused2) {
                                            jSONArray2 = jSONArray3;
                                            cursor2 = cursorQuery;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        }
                                    } catch (Exception unused3) {
                                        jSONArray2 = jSONArray3;
                                        cursor2 = null;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (Exception unused4) {
                                    jSONArray2 = jSONArray;
                                }
                            } catch (Exception unused5) {
                                jSONArray2 = jSONArray2;
                            }
                        } catch (Exception unused6) {
                            jSONArray2 = jSONArray2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception unused7) {
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Exception unused8) {
        }
        return jSONArray2;
    }
}
