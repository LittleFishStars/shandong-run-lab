package com.kc.bw.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class BaseDao<T> {
    public static String TAG;
    public SQLiteDatabase database;
    public SQLiteOpenHelper helper;
    public Lock lock;

    @Keep
    public interface Action {
        void call(SQLiteDatabase sQLiteDatabase);
    }

    public BaseDao(SQLiteOpenHelper sQLiteOpenHelper) {
        TAG = getClass().getSimpleName();
        this.lock = DBHelper.lock;
        this.helper = sQLiteOpenHelper;
        this.database = openWriter();
    }

    public final void closeDatabase(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public long delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete(getTableName(), str, strArr);
    }

    public boolean delete(String str, String[] strArr) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.delete(getTableName(), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public long deleteAll(SQLiteDatabase sQLiteDatabase) {
        return delete(sQLiteDatabase, null, null);
    }

    public boolean deleteAll() {
        return delete(null, null);
    }

    public boolean deleteList(List<Pair<String, String[]>> list) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (Pair<String, String[]> pair : list) {
                this.database.delete(getTableName(), (String) pair.first, (String[]) pair.second);
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public abstract ContentValues getContentValues(T t);

    public abstract String getTableName();

    public long insert(SQLiteDatabase sQLiteDatabase, T t) {
        return sQLiteDatabase.insert(getTableName(), null, getContentValues(t));
    }

    public boolean insert(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.insert(getTableName(), null, getContentValues(it.next()));
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean insert(T t) {
        if (t == null) {
            return false;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.insert(getTableName(), null, getContentValues(t));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean insert(List<T> list) {
        if (list == null) {
            return false;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.database.insert(getTableName(), null, getContentValues(it.next()));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public SQLiteDatabase openReader() {
        return this.helper.getReadableDatabase();
    }

    public SQLiteDatabase openWriter() {
        return this.helper.getWritableDatabase();
    }

    public abstract T parseCursorToBean(Cursor cursor);

    public List<T> query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return query(sQLiteDatabase, null, str, strArr, null, null, null, null);
    }

    public List<T> query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = sQLiteDatabase.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                try {
                    arrayList.add(parseCursorToBean(cursorQuery));
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        closeDatabase(null, cursorQuery);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        return arrayList;
    }

    public List<T> query(String str, String[] strArr) {
        return query(null, str, strArr, null, null, null, null);
    }

    public List<T> query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursorQuery;
        this.lock.lock();
        ArrayList arrayList = new ArrayList();
        try {
            this.database.beginTransaction();
            cursorQuery = this.database.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                try {
                    arrayList.add(parseCursorToBean(cursorQuery));
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        closeDatabase(null, cursorQuery);
                        this.database.endTransaction();
                        this.lock.unlock();
                    }
                }
            }
            this.database.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        return arrayList;
    }

    public List<T> queryAll() {
        return query(null, null);
    }

    public List<T> queryAll(SQLiteDatabase sQLiteDatabase) {
        return query(sQLiteDatabase, null, null);
    }

    public T queryOne(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        List<T> listQuery = query(sQLiteDatabase, null, str, strArr, null, null, null, dexg.dexa("2"));
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    public T queryOne(String str, String[] strArr) {
        List<T> listQuery = query(null, str, strArr, null, null, null, dexg.dexa("2"));
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    public long replace(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.replace(getTableName(), null, contentValues);
    }

    public long replace(SQLiteDatabase sQLiteDatabase, T t) {
        return sQLiteDatabase.replace(getTableName(), null, getContentValues(t));
    }

    public boolean replace(ContentValues contentValues) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, contentValues);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean replace(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.replace(getTableName(), null, getContentValues(it.next()));
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean replace(T t) {
        if (t == null) {
            return false;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, getContentValues(t));
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean replace(List<T> list) {
        if (list == null) {
            return false;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.database.replace(getTableName(), null, getContentValues(it.next()));
            }
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public void startTransaction(Action action) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            action.call(this.database);
            this.database.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public abstract void unInit();

    public long update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), contentValues, str, strArr);
    }

    public long update(SQLiteDatabase sQLiteDatabase, T t, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), getContentValues(t), str, strArr);
    }

    public boolean update(ContentValues contentValues, String str, String[] strArr) {
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), contentValues, str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }

    public boolean update(T t, String str, String[] strArr) {
        if (t == null) {
            return false;
        }
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), getContentValues(t), str, strArr);
            this.database.setTransactionSuccessful();
            this.database.endTransaction();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return false;
            } finally {
                this.database.endTransaction();
                this.lock.unlock();
            }
        }
    }
}
