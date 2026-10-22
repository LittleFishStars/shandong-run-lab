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
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.database.dao.StepDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class kr8 implements StepDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<IntervalStep> f42892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntityInsertionAdapter<IntervalStep> f17776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RoomDatabase f17777a;

    public class a extends EntityInsertionAdapter<IntervalStep> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, IntervalStep intervalStep) {
            supportSQLiteStatement.bindLong(1, intervalStep.getId());
            if (intervalStep.getRunCode() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, intervalStep.getRunCode());
            }
            supportSQLiteStatement.bindLong(3, intervalStep.getStartTime());
            supportSQLiteStatement.bindLong(4, intervalStep.getStartStep());
            supportSQLiteStatement.bindLong(5, intervalStep.getEndTime());
            supportSQLiteStatement.bindLong(6, intervalStep.getEndStep());
            supportSQLiteStatement.bindLong(7, intervalStep.getTime());
            supportSQLiteStatement.bindLong(8, intervalStep.getStep());
            supportSQLiteStatement.bindLong(9, intervalStep.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(10, intervalStep.isUploaded() ? 1L : 0L);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `run_step` (`id`,`runCode`,`startTime`,`startStep`,`endTime`,`endStep`,`time`,`step`,`isValid`,`is_uploaded`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<IntervalStep> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, IntervalStep intervalStep) {
            supportSQLiteStatement.bindLong(1, intervalStep.getId());
            if (intervalStep.getRunCode() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, intervalStep.getRunCode());
            }
            supportSQLiteStatement.bindLong(3, intervalStep.getStartTime());
            supportSQLiteStatement.bindLong(4, intervalStep.getStartStep());
            supportSQLiteStatement.bindLong(5, intervalStep.getEndTime());
            supportSQLiteStatement.bindLong(6, intervalStep.getEndStep());
            supportSQLiteStatement.bindLong(7, intervalStep.getTime());
            supportSQLiteStatement.bindLong(8, intervalStep.getStep());
            supportSQLiteStatement.bindLong(9, intervalStep.isValid() ? 1L : 0L);
            supportSQLiteStatement.bindLong(10, intervalStep.isUploaded() ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, intervalStep.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `run_step` SET `id` = ?,`runCode` = ?,`startTime` = ?,`startStep` = ?,`endTime` = ?,`endStep` = ?,`time` = ?,`step` = ?,`isValid` = ?,`is_uploaded` = ? WHERE `id` = ?";
        }
    }

    public kr8(RoomDatabase __db) {
        this.f17777a = __db;
        this.f17776a = new a(__db);
        this.f42892a = new b(__db);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // com.huachenjie.run.database.dao.StepDao
    public void a(final List<Integer> ids) {
        this.f17777a.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("update run_step set is_uploaded=1 where id in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.f17777a.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (Integer num : ids) {
            if (num == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i, num.intValue());
            }
            i++;
        }
        this.f17777a.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.f17777a.setTransactionSuccessful();
        } finally {
            this.f17777a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.StepDao
    public List<IntervalStep> b(boolean z, String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from run_step where is_uploaded=? and runCode=?", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.f17777a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f17777a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startStep");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new IntervalStep(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.huachenjie.run.database.dao.StepDao
    public void c(final IntervalStep... stepList) {
        this.f17777a.assertNotSuspendingTransaction();
        this.f17777a.beginTransaction();
        try {
            this.f42892a.handleMultiple(stepList);
            this.f17777a.setTransactionSuccessful();
        } finally {
            this.f17777a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.StepDao
    public void d(final IntervalStep... stepList) {
        this.f17777a.assertNotSuspendingTransaction();
        this.f17777a.beginTransaction();
        try {
            this.f17776a.insert(stepList);
            this.f17777a.setTransactionSuccessful();
        } finally {
            this.f17777a.endTransaction();
        }
    }

    @Override // com.huachenjie.run.database.dao.StepDao
    public IntervalStep e(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from run_step where runCode=? order by startTime desc limit 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.f17777a.assertNotSuspendingTransaction();
        IntervalStep intervalStep = null;
        Cursor cursorQuery = DBUtil.query(this.f17777a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "runCode");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "startStep");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endTime");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endStep");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "step");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isValid");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_uploaded");
            if (cursorQuery.moveToFirst()) {
                intervalStep = new IntervalStep(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), cursorQuery.getInt(columnIndexOrThrow8), cursorQuery.getInt(columnIndexOrThrow9) != 0, cursorQuery.getInt(columnIndexOrThrow10) != 0);
            }
            return intervalStep;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
