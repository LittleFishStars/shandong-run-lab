package com.beizi.fusion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.EventItem;
import com.zj.adlib.xh9;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i6 {
    private static volatile i6 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y1 f27401a;

    private i6(Context context) {
        this.f27401a = y1.a(context);
    }

    public static i6 a(Context context) {
        if (b == null) {
            synchronized (i6.class) {
                if (b == null) {
                    b = new i6(context);
                }
            }
        }
        return b;
    }

    private synchronized void b(String str) {
        SQLiteDatabase writableDatabase = this.f27401a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            String str2 = "create table " + str + "(id integer primary key autoincrement,event_code nvarchar," + xh9.WEBSITE_PARAMS_CHANNEL + " nvarchar,space_id nvarchar,timestamp nvarchar)";
            jh.a("DaoManager", "sql createTable tableName = " + str2);
            writableDatabase.execSQL(str2);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception unused) {
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    private synchronized int d(String str) {
        Cursor cursorQuery = this.f27401a.getWritableDatabase().query(str, null, null, null, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count;
    }

    private synchronized boolean e(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f27401a.getWritableDatabase().query("Sqlite_master", new String[]{"count('*') as c"}, "type=? and name =?", new String[]{"table", str.trim()}, null, null, null);
                if (cursorQuery.moveToNext()) {
                    int i = cursorQuery.getInt(0);
                    Log.e("DaoManager", "DaoManager count:" + i);
                    if (i > 0) {
                        z = true;
                    }
                }
                cursorQuery.close();
                return z;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        }
    }

    public synchronized List c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "T_" + str;
        a(str2);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f27401a.getWritableDatabase().query(str2, null, null, null, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            return arrayList;
        }
        cursorQuery.moveToFirst();
        do {
            try {
                arrayList.add(a(cursorQuery));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } while (cursorQuery.moveToNext());
        cursorQuery.close();
        return arrayList;
    }

    private EventItem a(Cursor cursor) {
        EventItem eventItem = new EventItem();
        eventItem.setCode(cursor.getString(cursor.getColumnIndex("event_code")));
        eventItem.setChannel(cursor.getString(cursor.getColumnIndex(xh9.WEBSITE_PARAMS_CHANNEL)));
        eventItem.setSpaceId(cursor.getString(cursor.getColumnIndex("space_id")));
        eventItem.setTimeStamp(cursor.getString(cursor.getColumnIndex("timestamp")));
        return eventItem;
    }

    private ContentValues a(EventItem eventItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_code", eventItem.getCode());
        contentValues.put(xh9.WEBSITE_PARAMS_CHANNEL, eventItem.getChannel());
        contentValues.put("space_id", eventItem.getSpaceId());
        contentValues.put("timestamp", eventItem.getTimeStamp());
        return contentValues;
    }

    private synchronized void a(String str) {
        boolean zE = e(str);
        jh.a("DaoManager", "sql table is exist == " + zE);
        if (zE) {
            return;
        }
        b(str);
    }

    public synchronized void a(String str, EventItem eventItem) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "T_" + str;
        a(str2);
        int iD = d(str2);
        long jInsert = this.f27401a.getWritableDatabase().insert(str2, null, a(eventItem));
        StringBuilder sb = new StringBuilder();
        sb.append("insert before size == ");
        sb.append(iD);
        sb.append(", insert data success = ");
        sb.append(jInsert != -1);
        jh.a("DaoManager", sb.toString());
        a(str2, Math.max(86400000L, j8.a(str) * 2));
    }

    public synchronized void a(String str, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        int iD = d(str);
        if (iD > 0 && j > 0 && jCurrentTimeMillis > 0) {
            boolean z = true;
            int iDelete = this.f27401a.getWritableDatabase().delete(str, "timestamp<=?", new String[]{String.valueOf(jCurrentTimeMillis)});
            StringBuilder sb = new StringBuilder();
            sb.append("start first delete data success = ");
            if (iDelete <= 0) {
                z = false;
            }
            sb.append(z);
            sb.append(", intervalTime = ");
            sb.append(j);
            jh.a("DaoManager", sb.toString());
        }
        if (iD >= 1000) {
            this.f27401a.getWritableDatabase().execSQL("delete from " + str + " where rowid in(select rowid from " + str + " order by id limit 200)");
            jh.a("DaoManager", "start second delete data");
        }
    }
}
