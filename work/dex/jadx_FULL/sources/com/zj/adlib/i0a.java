package com.zj.adlib;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huachenjie.base.interact.database.WorksInteractDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class i0a implements WorksInteractDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<WorksInteractEventBean> f42245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EntityInsertionAdapter<WorksInteractEventBean> f17104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RoomDatabase f17105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedSQLiteStatement f17106a;
    public final SharedSQLiteStatement b;

    public class a extends EntityInsertionAdapter<WorksInteractEventBean> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement stmt, WorksInteractEventBean value) {
            stmt.bindLong(1, value.getId());
            if (value.getWorksNo() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.getWorksNo());
            }
            if (value.getBizNo() == null) {
                stmt.bindNull(3);
            } else {
                stmt.bindString(3, value.getBizNo());
            }
            if (value.getWorksAuthorNo() == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, value.getWorksAuthorNo());
            }
            if (value.getCommentUserNo() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindString(5, value.getCommentUserNo());
            }
            stmt.bindLong(6, value.getEventType());
            stmt.bindLong(7, value.getEventTime());
            stmt.bindLong(8, value.getBizType());
            stmt.bindLong(9, value.getSource());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `works_interact_event` (`id`,`works_no`,`biz_no`,`author_no`,`comment_user_no`,`event_type`,`event_time`,`biz_type`,`source`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<WorksInteractEventBean> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement stmt, WorksInteractEventBean value) {
            stmt.bindLong(1, value.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `works_interact_event` WHERE `id` = ?";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM works_interact_event where biz_type > 0";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM works_interact_event where biz_type < 0";
        }
    }

    public i0a(RoomDatabase __db) {
        this.f17105a = __db;
        this.f17104a = new a(__db);
        this.f42245a = new b(__db);
        this.f17106a = new c(__db);
        this.b = new d(__db);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public int a() {
        this.f17105a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.b.acquire();
        this.f17105a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.f17105a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.f17105a.endTransaction();
            this.b.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public List<WorksInteractEventBean> b() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM works_interact_event where biz_type < 0", 0);
        this.f17105a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f17105a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "works_no");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "biz_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author_no");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_user_no");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event_type");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "biz_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
                int i = columnIndexOrThrow2;
                worksInteractEventBean.setId(cursorQuery.getLong(columnIndexOrThrow));
                worksInteractEventBean.setWorksNo(cursorQuery.isNull(i) ? null : cursorQuery.getString(i));
                worksInteractEventBean.setBizNo(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                worksInteractEventBean.setWorksAuthorNo(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                worksInteractEventBean.setCommentUserNo(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                worksInteractEventBean.setEventType(cursorQuery.getInt(columnIndexOrThrow6));
                int i2 = columnIndexOrThrow;
                worksInteractEventBean.setEventTime(cursorQuery.getLong(columnIndexOrThrow7));
                worksInteractEventBean.setBizType(cursorQuery.getInt(columnIndexOrThrow8));
                worksInteractEventBean.setSource(cursorQuery.getInt(columnIndexOrThrow9));
                arrayList.add(worksInteractEventBean);
                columnIndexOrThrow = i2;
                columnIndexOrThrow2 = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public void c(final WorksInteractEventBean event) {
        this.f17105a.assertNotSuspendingTransaction();
        this.f17105a.beginTransaction();
        try {
            this.f42245a.handle(event);
            this.f17105a.setTransactionSuccessful();
        } finally {
            this.f17105a.endTransaction();
        }
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public long d(final WorksInteractEventBean event) {
        this.f17105a.assertNotSuspendingTransaction();
        this.f17105a.beginTransaction();
        try {
            long jInsertAndReturnId = this.f17104a.insertAndReturnId(event);
            this.f17105a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.f17105a.endTransaction();
        }
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public int e() {
        this.f17105a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f17106a.acquire();
        this.f17105a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.f17105a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.f17105a.endTransaction();
            this.f17106a.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.huachenjie.base.interact.database.WorksInteractDao
    public List<WorksInteractEventBean> f() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM works_interact_event where biz_type > 0", 0);
        this.f17105a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f17105a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "works_no");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "biz_no");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author_no");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_user_no");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event_type");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event_time");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "biz_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                WorksInteractEventBean worksInteractEventBean = new WorksInteractEventBean();
                int i = columnIndexOrThrow2;
                worksInteractEventBean.setId(cursorQuery.getLong(columnIndexOrThrow));
                worksInteractEventBean.setWorksNo(cursorQuery.isNull(i) ? null : cursorQuery.getString(i));
                worksInteractEventBean.setBizNo(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                worksInteractEventBean.setWorksAuthorNo(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                worksInteractEventBean.setCommentUserNo(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                worksInteractEventBean.setEventType(cursorQuery.getInt(columnIndexOrThrow6));
                int i2 = columnIndexOrThrow;
                worksInteractEventBean.setEventTime(cursorQuery.getLong(columnIndexOrThrow7));
                worksInteractEventBean.setBizType(cursorQuery.getInt(columnIndexOrThrow8));
                worksInteractEventBean.setSource(cursorQuery.getInt(columnIndexOrThrow9));
                arrayList.add(worksInteractEventBean);
                columnIndexOrThrow = i2;
                columnIndexOrThrow2 = i;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
