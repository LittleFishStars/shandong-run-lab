package com.huawei.hms.framework.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class NetworkKitSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME_DYNAMIC = "networkkit_dynamic.db";
    private static final String DB_NAME_LOCAL = "networkkit.db";
    private static final String DB_NAME_SUFFIX = "-journal";
    public static final int DB_VERSION = 1;
    private static final String TAG = "PLSQLiteOpenHelper";
    private static String dbName = "networkkit.db";
    private static volatile NetworkKitSQLiteOpenHelper instance;

    static {
        if (ContextHolder.getKitContext() != null) {
            dbName = DB_NAME_DYNAMIC;
        }
    }

    private NetworkKitSQLiteOpenHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    public static NetworkKitSQLiteOpenHelper getInstance() {
        if (instance == null) {
            synchronized (NetworkKitSQLiteOpenHelper.class) {
                if (instance == null) {
                    instance = new NetworkKitSQLiteOpenHelper(ContextHolder.getAppContext().createDeviceProtectedStorageContext(), dbName, 1);
                }
            }
        }
        return instance;
    }

    public boolean deleteDbFile() {
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath());
    }

    public boolean deleteDbFileByPath(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        Logger.i(TAG, "db is not exists");
        return false;
    }

    public boolean deleteUnusedDbFile() {
        String str = dbName;
        String str2 = DB_NAME_DYNAMIC;
        if (str.equals(DB_NAME_DYNAMIC)) {
            str2 = DB_NAME_LOCAL;
        }
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath().replace(dbName, str2));
    }

    public SQLiteDatabase getDbByName(String str) {
        SQLiteDatabase networkKitReadableDatabase = getNetworkKitReadableDatabase();
        if (networkKitReadableDatabase == null) {
            return networkKitReadableDatabase;
        }
        String strReplace = networkKitReadableDatabase.getPath().replace(dbName, str);
        if (new File(strReplace).exists()) {
            return SQLiteDatabase.openDatabase(strReplace, null, 0);
        }
        Logger.i(TAG, "old db is not exists");
        return networkKitReadableDatabase;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbNameSuffix() {
        return DB_NAME_SUFFIX;
    }

    public SQLiteDatabase getNetworkKitReadableDatabase() {
        SQLiteDatabase readableDatabase;
        try {
            readableDatabase = getReadableDatabase();
        } catch (Throwable th) {
            Logger.e(TAG, "getReadableDatabase db error:" + th.getMessage());
            readableDatabase = null;
        }
        if (readableDatabase == null) {
            Logger.e(TAG, "getReadableDatabase db is null");
        }
        return readableDatabase;
    }

    public SQLiteDatabase getNetworkKitWritableDatabase() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            Logger.e(TAG, "getWritableDatabase db error:" + th.getMessage());
            writableDatabase = null;
        }
        if (writableDatabase == null) {
            Logger.e(TAG, "getWritableDatabase db is null");
        }
        return writableDatabase;
    }

    public SQLiteDatabase getNetworkkitUnusedDbDB() {
        String str = dbName;
        String str2 = DB_NAME_DYNAMIC;
        if (str.equals(DB_NAME_DYNAMIC)) {
            str2 = DB_NAME_LOCAL;
        }
        return getDbByName(str2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public boolean tabbleIsExistInDB(String str, String str2) {
        SQLiteDatabase networkKitReadableDatabase;
        if (str2 == null || (networkKitReadableDatabase = getNetworkKitReadableDatabase()) == null) {
            return false;
        }
        try {
            networkKitReadableDatabase = SQLiteDatabase.openDatabase(networkKitReadableDatabase.getPath().replace(dbName, str), null, 0);
            networkKitReadableDatabase.rawQuery("select count(1) from " + str2, null);
            IoUtils.closeSecure(networkKitReadableDatabase);
            return true;
        } catch (Throwable unused) {
            IoUtils.closeSecure(networkKitReadableDatabase);
            return false;
        }
    }
}
