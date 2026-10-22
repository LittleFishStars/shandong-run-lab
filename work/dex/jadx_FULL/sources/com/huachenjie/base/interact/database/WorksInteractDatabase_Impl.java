package com.huachenjie.base.interact.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.zj.adlib.i0a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class WorksInteractDatabase_Impl extends WorksInteractDatabase {
    public volatile WorksInteractDao b;

    public class a extends RoomOpenHelper.Delegate {
        public a(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("CREATE TABLE IF NOT EXISTS `works_interact_event` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `works_no` TEXT, `biz_no` TEXT, `author_no` TEXT, `comment_user_no` TEXT, `event_type` INTEGER NOT NULL, `event_time` INTEGER NOT NULL, `biz_type` INTEGER NOT NULL, `source` INTEGER NOT NULL)");
            _db.execSQL(RoomMasterTable.CREATE_QUERY);
            _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '504f88ed6cb1992bff41e5b9b77cba28')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("DROP TABLE IF EXISTS `works_interact_event`");
            if (((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase _db) {
            if (((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.get(i)).onCreate(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase _db) {
            ((RoomDatabase) WorksInteractDatabase_Impl.this).mDatabase = _db;
            WorksInteractDatabase_Impl.this.internalInitInvalidationTracker(_db);
            if (((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WorksInteractDatabase_Impl.this).mCallbacks.get(i)).onOpen(_db);
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
            HashMap map = new HashMap(9);
            map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map.put("works_no", new TableInfo.Column("works_no", "TEXT", false, 0, null, 1));
            map.put("biz_no", new TableInfo.Column("biz_no", "TEXT", false, 0, null, 1));
            map.put("author_no", new TableInfo.Column("author_no", "TEXT", false, 0, null, 1));
            map.put("comment_user_no", new TableInfo.Column("comment_user_no", "TEXT", false, 0, null, 1));
            map.put("event_type", new TableInfo.Column("event_type", "INTEGER", true, 0, null, 1));
            map.put("event_time", new TableInfo.Column("event_time", "INTEGER", true, 0, null, 1));
            map.put("biz_type", new TableInfo.Column("biz_type", "INTEGER", true, 0, null, 1));
            map.put("source", new TableInfo.Column("source", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("works_interact_event", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(_db, "works_interact_event");
            if (tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "works_interact_event(com.huachenjie.base.interact.bean.WorksInteractEventBean).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `works_interact_event`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "works_interact_event");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new a(1), "504f88ed6cb1992bff41e5b9b77cba28", "cb3cfb8fc89f3e9077e5115014f5e079")).build());
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDatabase
    public WorksInteractDao d() {
        WorksInteractDao worksInteractDao;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new i0a(this);
            }
            worksInteractDao = this.b;
        }
        return worksInteractDao;
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(WorksInteractDao.class, i0a.g());
        return map;
    }
}
