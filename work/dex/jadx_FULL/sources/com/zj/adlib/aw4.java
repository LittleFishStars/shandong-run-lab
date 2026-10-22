package com.zj.adlib;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.run.database.dao.LatLngDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class aw4 implements LatLngDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<RunLatLng> f40625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntityInsertionAdapter<RunLatLng> f15407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RoomDatabase f15408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedSQLiteStatement f15409a;

    public class a extends EntityInsertionAdapter<RunLatLng> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, RunLatLng runLatLng) {
            supportSQLiteStatement.bindDouble(1, runLatLng.lat);
            supportSQLiteStatement.bindDouble(2, runLatLng.lng);
            supportSQLiteStatement.bindLong(3, runLatLng.getId());
            if (runLatLng.getRunCode() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, runLatLng.getRunCode());
            }
            supportSQLiteStatement.bindDouble(5, runLatLng.getAccuracy());
            supportSQLiteStatement.bindDouble(6, runLatLng.getSpeed());
            supportSQLiteStatement.bindLong(7, runLatLng.getTimestamp());
            supportSQLiteStatement.bindLong(8, runLatLng.getRunTimestamp());
            supportSQLiteStatement.bindLong(9, runLatLng.getSatellites());
            supportSQLiteStatement.bindLong(10, runLatLng.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, runLatLng.isUploaded() ? 1L : 0L);
            supportSQLiteStatement.bindLong(12, runLatLng.getCreateTime());
            supportSQLiteStatement.bindLong(13, runLatLng.state);
            supportSQLiteStatement.bindLong(14, runLatLng.offFenceDisM);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `run_lat_lng` (`lat`,`lng`,`id`,`runCode`,`accuracy`,`speed`,`timestamp`,`runTimestamp`,`satellites`,`isValid`,`is_uploaded`,`createTime`,`state`,`offFenceDisM`) VALUES (?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<RunLatLng> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, RunLatLng runLatLng) {
            supportSQLiteStatement.bindDouble(1, runLatLng.lat);
            supportSQLiteStatement.bindDouble(2, runLatLng.lng);
            supportSQLiteStatement.bindLong(3, runLatLng.getId());
            if (runLatLng.getRunCode() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, runLatLng.getRunCode());
            }
            supportSQLiteStatement.bindDouble(5, runLatLng.getAccuracy());
            supportSQLiteStatement.bindDouble(6, runLatLng.getSpeed());
            supportSQLiteStatement.bindLong(7, runLatLng.getTimestamp());
            supportSQLiteStatement.bindLong(8, runLatLng.getRunTimestamp());
            supportSQLiteStatement.bindLong(9, runLatLng.getSatellites());
            supportSQLiteStatement.bindLong(10, runLatLng.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, runLatLng.isUploaded() ? 1L : 0L);
            supportSQLiteStatement.bindLong(12, runLatLng.getCreateTime());
            supportSQLiteStatement.bindLong(13, runLatLng.state);
            supportSQLiteStatement.bindLong(14, runLatLng.offFenceDisM);
            supportSQLiteStatement.bindLong(15, runLatLng.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `run_lat_lng` SET `lat` = ?,`lng` = ?,`id` = ?,`runCode` = ?,`accuracy` = ?,`speed` = ?,`timestamp` = ?,`runTimestamp` = ?,`satellites` = ?,`isValid` = ?,`is_uploaded` = ?,`createTime` = ?,`state` = ?,`offFenceDisM` = ? WHERE `id` = ?";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update run_lat_lng set state=? where state=?";
        }
    }

    public aw4(RoomDatabase __db) {
        this.f15408a = __db;
        this.f15407a = new a(__db);
        this.f40625a = new b(__db);
        this.f15409a = new c(__db);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public void a(final int uploadingState, final int newState) {
        this.f15408a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f15409a.acquire();
        supportSQLiteStatementAcquire.bindLong(1, newState);
        supportSQLiteStatementAcquire.bindLong(2, uploadingState);
        this.f15408a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.f15408a.setTransactionSuccessful();
        } finally {
            this.f15408a.endTransaction();
            this.f15409a.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public List<RunLatLng> b(List<Integer> list, boolean z, String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("select * from run_lat_lng where state in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") and isValid=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" and runCode=");
        sbNewStringBuilder.append("?");
        int i = size + 2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), i);
        int i2 = 1;
        for (Integer num : list) {
            if (num == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindLong(i2, num.intValue());
            }
            i2++;
        }
        roomSQLiteQueryAcquire.bindLong(size + 1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(i);
        } else {
            roomSQLiteQueryAcquire.bindString(i, str);
        }
        this.f15408a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f15408a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lat");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lng");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accuracy");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "speed");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runTimestamp");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "satellites");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "offFenceDisM");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RunLatLng runLatLng = new RunLatLng(cursorQuery.getDouble(columnIndexOrThrow), cursorQuery.getDouble(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getFloat(columnIndexOrThrow5), cursorQuery.getFloat(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.getInt(columnIndexOrThrow11) != 0);
                    int i3 = columnIndexOrThrow2;
                    int i4 = columnIndexOrThrow3;
                    runLatLng.setCreateTime(cursorQuery.getLong(columnIndexOrThrow12));
                    runLatLng.state = cursorQuery.getInt(columnIndexOrThrow13);
                    int i5 = columnIndexOrThrow14;
                    int i6 = columnIndexOrThrow11;
                    int i7 = columnIndexOrThrow12;
                    runLatLng.offFenceDisM = cursorQuery.getLong(i5);
                    arrayList.add(runLatLng);
                    columnIndexOrThrow11 = i6;
                    columnIndexOrThrow14 = i5;
                    columnIndexOrThrow12 = i7;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow3 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public void c(final RunLatLng... runLatLngList) {
        this.f15408a.assertNotSuspendingTransaction();
        this.f15408a.beginTransaction();
        try {
            this.f15407a.insert(runLatLngList);
            this.f15408a.setTransactionSuccessful();
        } finally {
            this.f15408a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public void d(final List<Integer> ids, final int retState) {
        this.f15408a.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("update run_lat_lng set state=(");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(") where id in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.f15408a.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, retState);
        int i = 2;
        for (Integer num : ids) {
            if (num == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i, num.intValue());
            }
            i++;
        }
        this.f15408a.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.f15408a.setTransactionSuccessful();
        } finally {
            this.f15408a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public List<RunLatLng> e(boolean z, String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from run_lat_lng where isValid=? and runCode=?", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.f15408a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f15408a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lat");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lng");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accuracy");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "speed");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runTimestamp");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "satellites");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createTime");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "offFenceDisM");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RunLatLng runLatLng = new RunLatLng(cursorQuery.getDouble(columnIndexOrThrow), cursorQuery.getDouble(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getFloat(columnIndexOrThrow5), cursorQuery.getFloat(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9), cursorQuery.getInt(columnIndexOrThrow10) != 0, cursorQuery.getInt(columnIndexOrThrow11) != 0);
                    int i = columnIndexOrThrow2;
                    int i2 = columnIndexOrThrow3;
                    runLatLng.setCreateTime(cursorQuery.getLong(columnIndexOrThrow12));
                    runLatLng.state = cursorQuery.getInt(columnIndexOrThrow13);
                    int i3 = columnIndexOrThrow11;
                    int i4 = columnIndexOrThrow14;
                    int i5 = columnIndexOrThrow12;
                    runLatLng.offFenceDisM = cursorQuery.getLong(i4);
                    arrayList.add(runLatLng);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow12 = i5;
                    columnIndexOrThrow3 = i2;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow2 = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.huachenjie.run.database.dao.LatLngDao
    public void f(final RunLatLng... runLatLngList) {
        this.f15408a.assertNotSuspendingTransaction();
        this.f15408a.beginTransaction();
        try {
            this.f40625a.handleMultiple(runLatLngList);
            this.f15408a.setTransactionSuccessful();
        } finally {
            this.f15408a.endTransaction();
        }
    }
}
