package com.alibaba.triver.basic.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.fl.saas.base.cache.DatabaseHelper;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class a {
    public static boolean a(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        if (context == null || calendar == null || calendar2 == null) {
            return false;
        }
        return c(context, str, str2, calendar, calendar2, i);
    }

    private static boolean b(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        try {
            long timeInMillis = calendar.getTimeInMillis();
            long timeInMillis2 = calendar2.getTimeInMillis();
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar_id", (Long) 1L);
            contentValues.put("title", str);
            contentValues.put("description", str2);
            contentValues.put("dtstart", Long.valueOf(timeInMillis));
            contentValues.put("dtend", Long.valueOf(timeInMillis2));
            contentValues.put("eventStatus", (Integer) 1);
            contentValues.put("hasAlarm", (Integer) 1);
            contentValues.put("eventTimezone", "GMT+8");
            Uri uri = Uri.parse("content://com.android.calendar/events");
            Long lValueOf = Long.valueOf(Long.parseLong(contentResolver.insert(uri, contentValues).getLastPathSegment()));
            if (!contentResolver.query(uri, new String[]{DatabaseHelper.COLUMN_ID, "title", "description", "dtstart", "dtend"}, "_id=" + lValueOf, null, null).moveToNext()) {
                return false;
            }
            ContentResolver contentResolver2 = context.getContentResolver();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("minutes", Integer.valueOf(i));
            contentValues2.put("event_id", lValueOf);
            contentValues2.put("method", (Integer) 1);
            contentResolver2.insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
            return true;
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "Calendar", e);
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(14)
    private static boolean c(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        try {
            if (a(context, str, str2, calendar, calendar2)) {
                return true;
            }
            long timeInMillis = calendar.getTimeInMillis();
            long timeInMillis2 = calendar2.getTimeInMillis();
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("dtstart", Long.valueOf(timeInMillis));
            contentValues.put("dtend", Long.valueOf(timeInMillis2));
            contentValues.put("title", str);
            contentValues.put("description", str2);
            contentValues.put("calendar_id", (Long) 1L);
            contentValues.put("eventTimezone", "GMT+8");
            Long lValueOf = Long.valueOf(Long.parseLong(contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues).getLastPathSegment()));
            if (!contentResolver.query(CalendarContract.Events.CONTENT_URI, new String[]{DatabaseHelper.COLUMN_ID, "title", "description", "dtstart", "dtend"}, "_id=" + lValueOf, null, null).moveToNext()) {
                return false;
            }
            ContentResolver contentResolver2 = context.getContentResolver();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("minutes", Integer.valueOf(i));
            contentValues2.put("event_id", lValueOf);
            contentValues2.put("method", (Integer) 1);
            contentResolver2.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            return true;
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "Calendar", e);
            return false;
        }
    }

    public static int a(Context context, String str, Calendar calendar, Calendar calendar2) {
        long jLongValue;
        if (context != null && calendar != null && calendar2 != null) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = Uri.parse("content://com.android.calendar/events");
            Cursor cursorQuery = contentResolver.query(uri, new String[]{DatabaseHelper.COLUMN_ID, "title", "description", "dtstart", "dtend"}, null, null, null);
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    jLongValue = 0;
                    break;
                }
                Long lValueOf = Long.valueOf(cursorQuery.getLong(0));
                String string = cursorQuery.getString(1);
                long j = cursorQuery.getLong(3);
                long j2 = cursorQuery.getLong(4);
                if (!TextUtils.isEmpty(string) && string.equals(str) && calendar.getTimeInMillis() == j && calendar2.getTimeInMillis() == j2) {
                    jLongValue = lValueOf.longValue();
                    break;
                }
            }
            if (jLongValue == 0) {
                return 0;
            }
            try {
                contentResolver.delete(uri, "_id= ?", new String[]{jLongValue + ""});
                return 1;
            } catch (Exception e) {
                RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "Calendar", e);
            }
        }
        return -1;
    }

    public static boolean a(Context context, String str, String str2, Calendar calendar, Calendar calendar2) {
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), new String[]{DatabaseHelper.COLUMN_ID}, "title= ? AND dtstart= ? AND dtend= ?", new String[]{str, timeInMillis + "", timeInMillis2 + ""}, null);
        return cursorQuery != null && cursorQuery.moveToNext();
    }
}
