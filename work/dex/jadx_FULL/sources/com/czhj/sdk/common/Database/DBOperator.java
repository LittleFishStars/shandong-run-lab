package com.czhj.sdk.common.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory;
import com.czhj.sdk.logger.SigmobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DBOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DBOperator f29380a = new DBOperator();
    private final Object c = new Object();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new BackgroundThreadFactory());

    public interface DataSQLiteLisenter {
        void onFailed(Error error);

        void onSuccess(List<Map> list);
    }

    public class SQLiteDeleteThread implements Runnable {
        private final String b;
        private final String c;
        private final String[] d;
        private final SQLiteLisenter e;
        private final SQLiteDatabase f;

        public SQLiteDeleteThread(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr, SQLiteLisenter sQLiteLisenter) {
            this.b = str;
            this.f = sQLiteDatabase;
            this.c = str2;
            this.d = strArr;
            this.e = sQLiteLisenter;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f.delete(this.b, this.c, this.d);
                SQLiteLisenter sQLiteLisenter = this.e;
                if (sQLiteLisenter != null) {
                    sQLiteLisenter.onSuccess(null);
                }
            } catch (Throwable th) {
                SQLiteLisenter sQLiteLisenter2 = this.e;
                if (sQLiteLisenter2 != null) {
                    sQLiteLisenter2.onFailed(new Error(th.getMessage()));
                }
            }
        }
    }

    public class SQLiteThread implements Runnable {
        private final String b;
        private final String[] c;
        private final String d;
        private final String[] e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final SQLiteDatabase j;
        private final DataSQLiteLisenter k;

        public SQLiteThread(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
            this.b = str;
            this.j = sQLiteDatabase;
            this.c = strArr;
            this.d = str2;
            this.e = strArr2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.k = dataSQLiteLisenter;
        }

        private List<Map> a(Cursor cursor) {
            Object objValueOf;
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                String[] columnNames = cursor.getColumnNames();
                HashMap map = new HashMap();
                for (String str : columnNames) {
                    int columnIndex = cursor.getColumnIndex(str);
                    if (columnIndex >= 0) {
                        int type = cursor.getType(columnIndex);
                        if (type == 1) {
                            objValueOf = Long.valueOf(cursor.getLong(columnIndex));
                        } else if (type == 2) {
                            objValueOf = Double.valueOf(cursor.getDouble(columnIndex));
                        } else if (type == 3) {
                            objValueOf = cursor.getString(columnIndex);
                        } else if (type == 4) {
                            map.put(str, cursor.getBlob(columnIndex));
                        }
                        map.put(str, objValueOf);
                    }
                }
                arrayList.add(map);
            }
            return arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Cursor cursorQuery = this.j.query(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                try {
                    List<Map> listA = a(cursorQuery);
                    DataSQLiteLisenter dataSQLiteLisenter = this.k;
                    if (dataSQLiteLisenter != null) {
                        dataSQLiteLisenter.onSuccess(listA);
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                DataSQLiteLisenter dataSQLiteLisenter2 = this.k;
                if (dataSQLiteLisenter2 != null) {
                    dataSQLiteLisenter2.onFailed(new Error(th3.getMessage()));
                }
            }
        }
    }

    private DBOperator() {
    }

    public static synchronized DBOperator getInstance() {
        return f29380a;
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str) {
        return count(sQLiteDatabase, str, null);
    }

    public int count(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query(str, null, str2, null, null, null, null, null);
            try {
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e(th.getMessage());
                    return 0;
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    public void delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr, SQLiteLisenter sQLiteLisenter) {
        try {
            this.b.submit(new SQLiteDeleteThread(sQLiteDatabase, str, str2, strArr, sQLiteLisenter));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            sQLiteLisenter.onFailed(new Error(th.getMessage()));
        }
    }

    public void find(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, DataSQLiteLisenter dataSQLiteLisenter) {
        this.b.submit(new SQLiteThread(sQLiteDatabase, str, strArr, str2, strArr2, str3, str4, str5, str6, dataSQLiteLisenter));
    }
}
