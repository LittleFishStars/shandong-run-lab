package com.huachenjie.run.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.huachenjie.run.database.dao.LatLngDao;
import com.huachenjie.run.database.dao.PaceDao;
import com.huachenjie.run.database.dao.StepDao;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.zj.adlib.aw4;
import com.zj.adlib.kr8;
import com.zj.adlib.xk6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class SunshineRunDataBase_Impl extends SunshineRunDataBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile LatLngDao f35439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile PaceDao f11402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile StepDao f11403a;

    public class a extends RoomOpenHelper.Delegate {
        public a(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("CREATE TABLE IF NOT EXISTS `run_lat_lng` (`lat` REAL NOT NULL, `lng` REAL NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `runCode` TEXT, `accuracy` REAL NOT NULL, `speed` REAL NOT NULL, `timestamp` INTEGER NOT NULL, `runTimestamp` INTEGER NOT NULL, `satellites` INTEGER NOT NULL, `isValid` INTEGER NOT NULL, `is_uploaded` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `state` INTEGER NOT NULL, `offFenceDisM` INTEGER NOT NULL)");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `run_step` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `runCode` TEXT, `startTime` INTEGER NOT NULL, `startStep` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `endStep` INTEGER NOT NULL, `time` INTEGER NOT NULL, `step` INTEGER NOT NULL, `isValid` INTEGER NOT NULL, `is_uploaded` INTEGER NOT NULL)");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `run_pace` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `runCode` TEXT, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `startDistance` INTEGER NOT NULL, `endDistance` INTEGER NOT NULL, `startStepCount` INTEGER NOT NULL, `endStepCount` INTEGER NOT NULL, `time` INTEGER NOT NULL, `distance` INTEGER NOT NULL, `stepCount` INTEGER NOT NULL, `isValid` INTEGER NOT NULL, `is_uploaded` INTEGER NOT NULL)");
            _db.execSQL(RoomMasterTable.CREATE_QUERY);
            _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7f293ab8884ab1345ccee9ce891aa828')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("DROP TABLE IF EXISTS `run_lat_lng`");
            _db.execSQL("DROP TABLE IF EXISTS `run_step`");
            _db.execSQL("DROP TABLE IF EXISTS `run_pace`");
            if (((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase _db) {
            if (((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.get(i)).onCreate(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase _db) {
            ((RoomDatabase) SunshineRunDataBase_Impl.this).mDatabase = _db;
            SunshineRunDataBase_Impl.this.internalInitInvalidationTracker(_db);
            if (((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) SunshineRunDataBase_Impl.this).mCallbacks.get(i)).onOpen(_db);
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
            HashMap map = new HashMap(14);
            map.put("lat", new TableInfo.Column("lat", "REAL", true, 0, null, 1));
            map.put("lng", new TableInfo.Column("lng", "REAL", true, 0, null, 1));
            map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map.put("runCode", new TableInfo.Column("runCode", "TEXT", false, 0, null, 1));
            map.put("accuracy", new TableInfo.Column("accuracy", "REAL", true, 0, null, 1));
            map.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, 1));
            map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            map.put("runTimestamp", new TableInfo.Column("runTimestamp", "INTEGER", true, 0, null, 1));
            map.put("satellites", new TableInfo.Column("satellites", "INTEGER", true, 0, null, 1));
            map.put("isValid", new TableInfo.Column("isValid", "INTEGER", true, 0, null, 1));
            map.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, 1));
            map.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, 1));
            map.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
            map.put("offFenceDisM", new TableInfo.Column("offFenceDisM", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("run_lat_lng", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(_db, "run_lat_lng");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "run_lat_lng(com.huachenjie.common.bean.RunLatLng).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(10);
            map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map2.put("runCode", new TableInfo.Column("runCode", "TEXT", false, 0, null, 1));
            map2.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, 1));
            map2.put("startStep", new TableInfo.Column("startStep", "INTEGER", true, 0, null, 1));
            map2.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, null, 1));
            map2.put("endStep", new TableInfo.Column("endStep", "INTEGER", true, 0, null, 1));
            map2.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
            map2.put("step", new TableInfo.Column("step", "INTEGER", true, 0, null, 1));
            map2.put("isValid", new TableInfo.Column("isValid", "INTEGER", true, 0, null, 1));
            map2.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("run_step", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(_db, "run_step");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "run_step(com.huachenjie.run.bean.IntervalStep).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(13);
            map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map3.put("runCode", new TableInfo.Column("runCode", "TEXT", false, 0, null, 1));
            map3.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, 1));
            map3.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, null, 1));
            map3.put("startDistance", new TableInfo.Column("startDistance", "INTEGER", true, 0, null, 1));
            map3.put("endDistance", new TableInfo.Column("endDistance", "INTEGER", true, 0, null, 1));
            map3.put("startStepCount", new TableInfo.Column("startStepCount", "INTEGER", true, 0, null, 1));
            map3.put("endStepCount", new TableInfo.Column("endStepCount", "INTEGER", true, 0, null, 1));
            map3.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
            map3.put(SchoolActivitySuccessActivity.x, new TableInfo.Column(SchoolActivitySuccessActivity.x, "INTEGER", true, 0, null, 1));
            map3.put("stepCount", new TableInfo.Column("stepCount", "INTEGER", true, 0, null, 1));
            map3.put("isValid", new TableInfo.Column("isValid", "INTEGER", true, 0, null, 1));
            map3.put("is_uploaded", new TableInfo.Column("is_uploaded", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo("run_pace", map3, new HashSet(0), new HashSet(0));
            TableInfo tableInfo6 = TableInfo.read(_db, "run_pace");
            if (tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "run_pace(com.huachenjie.run.bean.IntervalPace).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
        }
    }

    @Override // com.huachenjie.run.database.SunshineRunDataBase
    public LatLngDao c() {
        LatLngDao latLngDao;
        if (this.f35439a != null) {
            return this.f35439a;
        }
        synchronized (this) {
            if (this.f35439a == null) {
                this.f35439a = new aw4(this);
            }
            latLngDao = this.f35439a;
        }
        return latLngDao;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `run_lat_lng`");
            writableDatabase.execSQL("DELETE FROM `run_step`");
            writableDatabase.execSQL("DELETE FROM `run_pace`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "run_lat_lng", "run_step", "run_pace");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new a(7), "7f293ab8884ab1345ccee9ce891aa828", "c515323f6c9f6acad8b4ec1fa9cec950")).build());
    }

    @Override // com.huachenjie.run.database.SunshineRunDataBase
    public PaceDao d() {
        PaceDao paceDao;
        if (this.f11402a != null) {
            return this.f11402a;
        }
        synchronized (this) {
            if (this.f11402a == null) {
                this.f11402a = new xk6(this);
            }
            paceDao = this.f11402a;
        }
        return paceDao;
    }

    @Override // com.huachenjie.run.database.SunshineRunDataBase
    public StepDao e() {
        StepDao stepDao;
        if (this.f11403a != null) {
            return this.f11403a;
        }
        synchronized (this) {
            if (this.f11403a == null) {
                this.f11403a = new kr8(this);
            }
            stepDao = this.f11403a;
        }
        return stepDao;
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(LatLngDao.class, aw4.g());
        map.put(StepDao.class, kr8.f());
        map.put(PaceDao.class, xk6.f());
        return map;
    }
}
