package com.huachenjie.works.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.zj.adlib.xh9;
import com.zj.adlib.yj7;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class PublicWorkDatabase_Impl extends PublicWorkDatabase {
    private volatile PublicWorkDao _publicWorkDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `public_work_draft`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "public_work_draft");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) { // from class: com.huachenjie.works.database.PublicWorkDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `public_work_draft` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `updateTime` INTEGER NOT NULL, `attachmentType` INTEGER NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `mediaPath` TEXT NOT NULL, `permissionType` INTEGER NOT NULL, `categoryNo` TEXT, `tagNo` TEXT, `pic_list` TEXT NOT NULL, `video_media` TEXT, `channel` TEXT, `location` TEXT)");
                _db.execSQL(RoomMasterTable.CREATE_QUERY);
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '42e1e016e36316083fd96fc309a6bfeb')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `public_work_draft`");
                if (((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase _db) {
                if (((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.get(i)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                ((RoomDatabase) PublicWorkDatabase_Impl.this).mDatabase = _db;
                PublicWorkDatabase_Impl.this.internalInitInvalidationTracker(_db);
                if (((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) PublicWorkDatabase_Impl.this).mCallbacks.get(i)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap map = new HashMap(13);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, null, 1));
                map.put("attachmentType", new TableInfo.Column("attachmentType", "INTEGER", true, 0, null, 1));
                map.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                map.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                map.put("mediaPath", new TableInfo.Column("mediaPath", "TEXT", true, 0, null, 1));
                map.put("permissionType", new TableInfo.Column("permissionType", "INTEGER", true, 0, null, 1));
                map.put(yj7.g.WORKS_PUBLISH_CATEGORY_NO, new TableInfo.Column(yj7.g.WORKS_PUBLISH_CATEGORY_NO, "TEXT", false, 0, null, 1));
                map.put("tagNo", new TableInfo.Column("tagNo", "TEXT", false, 0, null, 1));
                map.put("pic_list", new TableInfo.Column("pic_list", "TEXT", true, 0, null, 1));
                map.put("video_media", new TableInfo.Column("video_media", "TEXT", false, 0, null, 1));
                map.put(xh9.WEBSITE_PARAMS_CHANNEL, new TableInfo.Column(xh9.WEBSITE_PARAMS_CHANNEL, "TEXT", false, 0, null, 1));
                map.put(RequestParameters.SUBRESOURCE_LOCATION, new TableInfo.Column(RequestParameters.SUBRESOURCE_LOCATION, "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("public_work_draft", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(_db, "public_work_draft");
                if (tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "public_work_draft(com.huachenjie.works.database.PublicWorkDraft).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
        }, "42e1e016e36316083fd96fc309a6bfeb", "a2a063c7392dad7eed4c8fffe9d3adaf")).build());
    }

    @Override // com.huachenjie.works.database.PublicWorkDatabase
    public PublicWorkDao getPublicWorkDao() {
        PublicWorkDao publicWorkDao;
        if (this._publicWorkDao != null) {
            return this._publicWorkDao;
        }
        synchronized (this) {
            if (this._publicWorkDao == null) {
                this._publicWorkDao = new PublicWorkDao_Impl(this);
            }
            publicWorkDao = this._publicWorkDao;
        }
        return publicWorkDao;
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(PublicWorkDao.class, PublicWorkDao_Impl.getRequiredConverters());
        return map;
    }
}
