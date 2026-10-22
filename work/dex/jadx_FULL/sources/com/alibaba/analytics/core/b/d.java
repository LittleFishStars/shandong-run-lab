package com.alibaba.analytics.core.b;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends SQLiteOpenHelper {
    private static boolean G = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DatabaseErrorHandler f23768a = new DatabaseErrorHandler() { // from class: com.alibaba.analytics.core.b.d.1
        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            j.w("SqliteHelper", "DatabaseErrorHandler onCorruption");
            boolean unused = d.G = true;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SQLiteDatabase f631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Future<?> f633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AtomicInteger f634a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                if (d.this.f634a.get() == 0 && d.this.f631a != null) {
                    d.this.f631a.close();
                    d.this.f631a = null;
                }
            }
        }
    }

    public d(Context context, String str) {
        super(context, str, null, 2, f23768a);
        this.f634a = new AtomicInteger();
        this.f632a = new a();
    }

    public void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void closeWritableDatabase(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            if (this.f634a.decrementAndGet() == 0) {
                Future<?> future = this.f633a;
                if (future != null) {
                    future.cancel(false);
                }
                this.f633a = x.a().schedule(null, this.f632a, 30000L);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.f631a == null) {
                if (G) {
                    return null;
                }
                this.f631a = super.getWritableDatabase();
            }
            this.f634a.incrementAndGet();
        } catch (Throwable th) {
            j.w("TAG", "e", th);
        }
        return this.f631a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        } catch (Throwable unused) {
        }
        closeCursor(cursorRawQuery);
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
