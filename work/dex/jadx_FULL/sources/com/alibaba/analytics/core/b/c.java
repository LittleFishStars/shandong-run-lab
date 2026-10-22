package com.alibaba.analytics.core.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.analytics.a.j;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f23767a;

    public c(Context context, String str) {
        super(context, str, null, 2, null);
    }

    private void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean deleteDatabase(File file) {
        if (file == null) {
            return false;
        }
        boolean zDelete = file.delete() | false | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] fileArrListFiles = parentFile.listFiles(new FileFilter() { // from class: com.alibaba.analytics.core.b.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().startsWith(str);
                }
            });
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    zDelete |= file2.delete();
                }
            }
        }
        return zDelete;
    }

    private synchronized void z() {
        SQLiteDatabase sQLiteDatabase = this.f23767a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused) {
        }
        this.f23767a = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            if (this.f23767a == null) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f23767a = writableDatabase;
                boolean zIsDatabaseIntegrityOk = writableDatabase.isDatabaseIntegrityOk();
                j.d("SQLiteCheckHelper", "isDatabaseIntegrityOk", Boolean.valueOf(zIsDatabaseIntegrityOk));
                if (!zIsDatabaseIntegrityOk) {
                    j.e("SQLiteCheckHelper", "delete Database", Boolean.valueOf(deleteDatabase(new File(this.f23767a.getPath()))));
                }
                j.d("SQLiteCheckHelper", "WritableDatabase", this.f23767a);
            }
        } catch (Throwable th) {
            j.w("TAG", "e", th);
        }
        return this.f23767a;
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

    public void y() {
        getWritableDatabase();
        z();
    }
}
