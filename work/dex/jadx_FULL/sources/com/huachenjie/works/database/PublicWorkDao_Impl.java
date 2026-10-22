package com.huachenjie.works.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.zj.adlib.xh9;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class PublicWorkDao_Impl implements PublicWorkDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PublicWorkDraft> __deletionAdapterOfPublicWorkDraft;
    private final EntityInsertionAdapter<PublicWorkDraft> __insertionAdapterOfPublicWorkDraft;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllWorks;
    private final EntityDeletionOrUpdateAdapter<PublicWorkDraft> __updateAdapterOfPublicWorkDraft;
    private final PubWorkMediaListTypeConverter __pubWorkMediaListTypeConverter = new PubWorkMediaListTypeConverter();
    private final PubWorkMediaTypeConverter __pubWorkMediaTypeConverter = new PubWorkMediaTypeConverter();
    private final PubWorkChannelTypeConverter __pubWorkChannelTypeConverter = new PubWorkChannelTypeConverter();
    private final PubWorkLocationTypeConverter __pubWorkLocationTypeConverter = new PubWorkLocationTypeConverter();

    public PublicWorkDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPublicWorkDraft = new EntityInsertionAdapter<PublicWorkDraft>(__db) { // from class: com.huachenjie.works.database.PublicWorkDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `public_work_draft` (`id`,`updateTime`,`attachmentType`,`title`,`content`,`mediaPath`,`permissionType`,`categoryNo`,`tagNo`,`pic_list`,`video_media`,`channel`,`location`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, PublicWorkDraft value) {
                stmt.bindLong(1, value.getId());
                stmt.bindLong(2, value.getUpdateTime());
                stmt.bindLong(3, value.getAttachmentType());
                if (value.getTitle() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getTitle());
                }
                if (value.getContent() == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindString(5, value.getContent());
                }
                if (value.getMediaPath() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getMediaPath());
                }
                stmt.bindLong(7, value.getPermissionType());
                if (value.getCategoryNo() == null) {
                    stmt.bindNull(8);
                } else {
                    stmt.bindString(8, value.getCategoryNo());
                }
                if (value.getTagNo() == null) {
                    stmt.bindNull(9);
                } else {
                    stmt.bindString(9, value.getTagNo());
                }
                String strMediaListToString = PublicWorkDao_Impl.this.__pubWorkMediaListTypeConverter.mediaListToString(value.getPicList());
                if (strMediaListToString == null) {
                    stmt.bindNull(10);
                } else {
                    stmt.bindString(10, strMediaListToString);
                }
                String strMediaToString = PublicWorkDao_Impl.this.__pubWorkMediaTypeConverter.mediaToString(value.getVideoMedia());
                if (strMediaToString == null) {
                    stmt.bindNull(11);
                } else {
                    stmt.bindString(11, strMediaToString);
                }
                String strChannelToString = PublicWorkDao_Impl.this.__pubWorkChannelTypeConverter.channelToString(value.getChannel());
                if (strChannelToString == null) {
                    stmt.bindNull(12);
                } else {
                    stmt.bindString(12, strChannelToString);
                }
                String strLocationToString = PublicWorkDao_Impl.this.__pubWorkLocationTypeConverter.locationToString(value.getLocation());
                if (strLocationToString == null) {
                    stmt.bindNull(13);
                } else {
                    stmt.bindString(13, strLocationToString);
                }
            }
        };
        this.__deletionAdapterOfPublicWorkDraft = new EntityDeletionOrUpdateAdapter<PublicWorkDraft>(__db) { // from class: com.huachenjie.works.database.PublicWorkDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `public_work_draft` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, PublicWorkDraft value) {
                stmt.bindLong(1, value.getId());
            }
        };
        this.__updateAdapterOfPublicWorkDraft = new EntityDeletionOrUpdateAdapter<PublicWorkDraft>(__db) { // from class: com.huachenjie.works.database.PublicWorkDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `public_work_draft` SET `id` = ?,`updateTime` = ?,`attachmentType` = ?,`title` = ?,`content` = ?,`mediaPath` = ?,`permissionType` = ?,`categoryNo` = ?,`tagNo` = ?,`pic_list` = ?,`video_media` = ?,`channel` = ?,`location` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, PublicWorkDraft value) {
                stmt.bindLong(1, value.getId());
                stmt.bindLong(2, value.getUpdateTime());
                stmt.bindLong(3, value.getAttachmentType());
                if (value.getTitle() == null) {
                    stmt.bindNull(4);
                } else {
                    stmt.bindString(4, value.getTitle());
                }
                if (value.getContent() == null) {
                    stmt.bindNull(5);
                } else {
                    stmt.bindString(5, value.getContent());
                }
                if (value.getMediaPath() == null) {
                    stmt.bindNull(6);
                } else {
                    stmt.bindString(6, value.getMediaPath());
                }
                stmt.bindLong(7, value.getPermissionType());
                if (value.getCategoryNo() == null) {
                    stmt.bindNull(8);
                } else {
                    stmt.bindString(8, value.getCategoryNo());
                }
                if (value.getTagNo() == null) {
                    stmt.bindNull(9);
                } else {
                    stmt.bindString(9, value.getTagNo());
                }
                String strMediaListToString = PublicWorkDao_Impl.this.__pubWorkMediaListTypeConverter.mediaListToString(value.getPicList());
                if (strMediaListToString == null) {
                    stmt.bindNull(10);
                } else {
                    stmt.bindString(10, strMediaListToString);
                }
                String strMediaToString = PublicWorkDao_Impl.this.__pubWorkMediaTypeConverter.mediaToString(value.getVideoMedia());
                if (strMediaToString == null) {
                    stmt.bindNull(11);
                } else {
                    stmt.bindString(11, strMediaToString);
                }
                String strChannelToString = PublicWorkDao_Impl.this.__pubWorkChannelTypeConverter.channelToString(value.getChannel());
                if (strChannelToString == null) {
                    stmt.bindNull(12);
                } else {
                    stmt.bindString(12, strChannelToString);
                }
                String strLocationToString = PublicWorkDao_Impl.this.__pubWorkLocationTypeConverter.locationToString(value.getLocation());
                if (strLocationToString == null) {
                    stmt.bindNull(13);
                } else {
                    stmt.bindString(13, strLocationToString);
                }
                stmt.bindLong(14, value.getId());
            }
        };
        this.__preparedStmtOfDeleteAllWorks = new SharedSQLiteStatement(__db) { // from class: com.huachenjie.works.database.PublicWorkDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM public_work_draft";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public void delWork(final PublicWorkDraft work) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPublicWorkDraft.handle(work);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public void deleteAllWorks() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllWorks.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllWorks.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public List<PublicWorkDraft> getAllWorks() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM public_work_draft ORDER BY updateTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attachmentType");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mediaPath");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionType");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagNo");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pic_list");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_media");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, xh9.WEBSITE_PARAMS_CHANNEL);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, RequestParameters.SUBRESOURCE_LOCATION);
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    PublicWorkDraft publicWorkDraft = new PublicWorkDraft();
                    int i = columnIndexOrThrow11;
                    int i2 = columnIndexOrThrow12;
                    publicWorkDraft.setId(cursorQuery.getLong(columnIndexOrThrow));
                    publicWorkDraft.setUpdateTime(cursorQuery.getLong(columnIndexOrThrow2));
                    publicWorkDraft.setAttachmentType(cursorQuery.getInt(columnIndexOrThrow3));
                    publicWorkDraft.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    publicWorkDraft.setContent(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    publicWorkDraft.setMediaPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    publicWorkDraft.setPermissionType(cursorQuery.getInt(columnIndexOrThrow7));
                    publicWorkDraft.setCategoryNo(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    publicWorkDraft.setTagNo(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    publicWorkDraft.setPicList(this.__pubWorkMediaListTypeConverter.stringToMediaList(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10)));
                    columnIndexOrThrow11 = i;
                    publicWorkDraft.setVideoMedia(this.__pubWorkMediaTypeConverter.stringToMedia(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11)));
                    publicWorkDraft.setChannel(this.__pubWorkChannelTypeConverter.stringToChannel(cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    publicWorkDraft.setLocation(this.__pubWorkLocationTypeConverter.stringToLocation(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    arrayList.add(publicWorkDraft);
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow12 = i2;
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

    @Override // com.huachenjie.works.database.PublicWorkDao
    public PublicWorkDraft getLatestWorks() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PublicWorkDraft publicWorkDraft;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM public_work_draft ORDER BY updateTime DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attachmentType");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mediaPath");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionType");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tagNo");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pic_list");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_media");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, xh9.WEBSITE_PARAMS_CHANNEL);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, RequestParameters.SUBRESOURCE_LOCATION);
            if (cursorQuery.moveToFirst()) {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                try {
                    PublicWorkDraft publicWorkDraft2 = new PublicWorkDraft();
                    publicWorkDraft2.setId(cursorQuery.getLong(columnIndexOrThrow));
                    publicWorkDraft2.setUpdateTime(cursorQuery.getLong(columnIndexOrThrow2));
                    publicWorkDraft2.setAttachmentType(cursorQuery.getInt(columnIndexOrThrow3));
                    publicWorkDraft2.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    publicWorkDraft2.setContent(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    publicWorkDraft2.setMediaPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    publicWorkDraft2.setPermissionType(cursorQuery.getInt(columnIndexOrThrow7));
                    publicWorkDraft2.setCategoryNo(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    publicWorkDraft2.setTagNo(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    publicWorkDraft2.setPicList(this.__pubWorkMediaListTypeConverter.stringToMediaList(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10)));
                    publicWorkDraft2.setVideoMedia(this.__pubWorkMediaTypeConverter.stringToMedia(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11)));
                    publicWorkDraft2.setChannel(this.__pubWorkChannelTypeConverter.stringToChannel(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12)));
                    publicWorkDraft2.setLocation(this.__pubWorkLocationTypeConverter.stringToLocation(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    publicWorkDraft = publicWorkDraft2;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } else {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                publicWorkDraft = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return publicWorkDraft;
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public int getWorksSize() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM public_work_draft", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public long insertWork(final PublicWorkDraft work) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPublicWorkDraft.insertAndReturnId(work);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.huachenjie.works.database.PublicWorkDao
    public void updateWork(final PublicWorkDraft work) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPublicWorkDraft.handle(work);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
