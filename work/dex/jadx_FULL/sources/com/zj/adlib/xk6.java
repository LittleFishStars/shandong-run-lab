package com.zj.adlib;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.database.dao.PaceDao;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class xk6 implements PaceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<IntervalPace> f45838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntityInsertionAdapter<IntervalPace> f20672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RoomDatabase f20673a;

    public class a extends EntityInsertionAdapter<IntervalPace> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, IntervalPace intervalPace) {
            supportSQLiteStatement.bindLong(1, intervalPace.getId());
            if (intervalPace.getRunCode() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, intervalPace.getRunCode());
            }
            supportSQLiteStatement.bindLong(3, intervalPace.getStartTime());
            supportSQLiteStatement.bindLong(4, intervalPace.getEndTime());
            supportSQLiteStatement.bindLong(5, intervalPace.getStartDistance());
            supportSQLiteStatement.bindLong(6, intervalPace.getEndDistance());
            supportSQLiteStatement.bindLong(7, intervalPace.getStartStepCount());
            supportSQLiteStatement.bindLong(8, intervalPace.getEndStepCount());
            supportSQLiteStatement.bindLong(9, intervalPace.getTime());
            supportSQLiteStatement.bindLong(10, intervalPace.getDistance());
            supportSQLiteStatement.bindLong(11, intervalPace.getStepCount());
            supportSQLiteStatement.bindLong(12, intervalPace.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, intervalPace.isUploaded() ? 1L : 0L);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `run_pace` (`id`,`runCode`,`startTime`,`endTime`,`startDistance`,`endDistance`,`startStepCount`,`endStepCount`,`time`,`distance`,`stepCount`,`isValid`,`is_uploaded`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<IntervalPace> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, IntervalPace intervalPace) {
            supportSQLiteStatement.bindLong(1, intervalPace.getId());
            if (intervalPace.getRunCode() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, intervalPace.getRunCode());
            }
            supportSQLiteStatement.bindLong(3, intervalPace.getStartTime());
            supportSQLiteStatement.bindLong(4, intervalPace.getEndTime());
            supportSQLiteStatement.bindLong(5, intervalPace.getStartDistance());
            supportSQLiteStatement.bindLong(6, intervalPace.getEndDistance());
            supportSQLiteStatement.bindLong(7, intervalPace.getStartStepCount());
            supportSQLiteStatement.bindLong(8, intervalPace.getEndStepCount());
            supportSQLiteStatement.bindLong(9, intervalPace.getTime());
            supportSQLiteStatement.bindLong(10, intervalPace.getDistance());
            supportSQLiteStatement.bindLong(11, intervalPace.getStepCount());
            supportSQLiteStatement.bindLong(12, intervalPace.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, intervalPace.isUploaded() ? 1L : 0L);
            supportSQLiteStatement.bindLong(14, intervalPace.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `run_pace` SET `id` = ?,`runCode` = ?,`startTime` = ?,`endTime` = ?,`startDistance` = ?,`endDistance` = ?,`startStepCount` = ?,`endStepCount` = ?,`time` = ?,`distance` = ?,`stepCount` = ?,`isValid` = ?,`is_uploaded` = ? WHERE `id` = ?";
        }
    }

    public xk6(RoomDatabase __db) {
        this.f20673a = __db;
        this.f20672a = new a(__db);
        this.f45838a = new b(__db);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // com.huachenjie.run.database.dao.PaceDao
    public void a(final List<Integer> ids) {
        this.f20673a.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("update run_pace set is_uploaded=1 where id in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.f20673a.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (Integer num : ids) {
            if (num == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i, num.intValue());
            }
            i++;
        }
        this.f20673a.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.f20673a.setTransactionSuccessful();
        } finally {
            this.f20673a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.PaceDao
    public List<IntervalPace> b(boolean z, String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from run_pace where is_uploaded=? and isValid=1 and runCode=?", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.f20673a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f20673a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startDistance");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endDistance");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startStepCount");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endStepCount");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SchoolActivitySuccessActivity.x);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stepCount");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new IntervalPace(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10), cursorQuery.getInt(columnIndexOrThrow11), cursorQuery.getInt(columnIndexOrThrow12) != 0, cursorQuery.getInt(columnIndexOrThrow13) != 0));
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

    @Override // com.huachenjie.run.database.dao.PaceDao
    public IntervalPace c(final String runCode) {
        IntervalPace intervalPace;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from run_pace where runCode=? order by startTime desc limit 1", 1);
        if (runCode == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, runCode);
        }
        this.f20673a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f20673a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startDistance");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endDistance");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startStepCount");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endStepCount");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SchoolActivitySuccessActivity.x);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stepCount");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            if (cursorQuery.moveToFirst()) {
                intervalPace = new IntervalPace(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getInt(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10), cursorQuery.getInt(columnIndexOrThrow11), cursorQuery.getInt(columnIndexOrThrow12) != 0, cursorQuery.getInt(columnIndexOrThrow13) != 0);
            } else {
                intervalPace = null;
            }
            return intervalPace;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.huachenjie.run.database.dao.PaceDao
    public void d(final IntervalPace... paceList) {
        this.f20673a.assertNotSuspendingTransaction();
        this.f20673a.beginTransaction();
        try {
            this.f45838a.handleMultiple(paceList);
            this.f20673a.setTransactionSuccessful();
        } finally {
            this.f20673a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.PaceDao
    public void e(final IntervalPace... paceList) {
        this.f20673a.assertNotSuspendingTransaction();
        this.f20673a.beginTransaction();
        try {
            this.f20672a.insert(paceList);
            this.f20673a.setTransactionSuccessful();
        } finally {
            this.f20673a.endTransaction();
        }
    }
}
