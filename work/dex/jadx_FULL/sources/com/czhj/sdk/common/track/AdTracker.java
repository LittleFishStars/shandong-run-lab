package com.czhj.sdk.common.track;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.czhj.sdk.common.Database.DBOperator;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteLisenter;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.logger.SigmobLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdTracker implements Serializable {
    private static final long serialVersionUID = 1;
    private String extInfo;
    private boolean mCalled;
    private final String mEvent;
    private Long mId;
    private final MessageType mMessageType;
    private final String mRequest_id;
    private String mSource = "native";
    private String mUrl;
    private Integer retryCount;
    private Integer retryNum;
    private Long timestamp;

    /* JADX INFO: renamed from: com.czhj.sdk.common.track.AdTracker$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType = iArr;
            try {
                iArr[MessageType.QUARTILE_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TOBID_TRACKING_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TRACKING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum MessageType {
        TRACKING_URL,
        QUARTILE_EVENT,
        TOBID_TRACKING_URL
    }

    public AdTracker(MessageType messageType, String str, String str2, String str3) {
        this.mRequest_id = str3;
        this.mMessageType = messageType;
        this.mUrl = str;
        this.mEvent = str2;
    }

    public static void cleanExpiredAdTracker(long j) {
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), SQLiteTrackHelper.TABLE_TRACK, "timestamp < ?", new String[]{String.valueOf(System.currentTimeMillis() - j)}, new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.1
                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                }
            });
        } catch (Throwable th) {
            SigmobLog.e("cleanExpiredAdTracker error", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0089 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    public static void cleanLimitAdTracker(long j) {
        long count;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        l = null;
        Long l = null;
        try {
            SQLiteDatabase readableDatabase = SQLiteTrackHelper.getInstance().getReadableDatabase();
            Cursor cursorRawQuery2 = readableDatabase.rawQuery("select * from tracks", null);
            if (cursorRawQuery2 != null) {
                try {
                    count = cursorRawQuery2.getCount();
                    cursorRawQuery2.close();
                    cursorRawQuery2 = null;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery2;
                    try {
                        SigmobLog.e("cleanLimitAdTracker ", th);
                        if (cursor != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            } else {
                count = 0;
            }
            if (count > j) {
                cursorRawQuery = readableDatabase.rawQuery("select * from tracks order by id desc limit ?", new String[]{String.valueOf(j)});
                try {
                    int columnIndex = cursorRawQuery.getColumnIndex("id");
                    if (cursorRawQuery.moveToLast()) {
                        Long lValueOf = Long.valueOf(cursorRawQuery.getLong(columnIndex));
                        cursorRawQuery.close();
                        cursorRawQuery = null;
                        l = lValueOf;
                    }
                } catch (Throwable th2) {
                    cursor = cursorRawQuery;
                    th = th2;
                    SigmobLog.e("cleanLimitAdTracker ", th);
                    if (cursor != null) {
                        return;
                    } else {
                        return;
                    }
                }
            } else {
                cursorRawQuery = cursorRawQuery2;
            }
            if (l == null) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } else {
                DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), SQLiteTrackHelper.TABLE_TRACK, "id < ?", new String[]{String.valueOf(l)}, new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.2
                    @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                    public void onFailed(Error error) {
                        SigmobLog.e(error.getMessage());
                    }

                    @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                    public void onSuccess(List list) {
                    }
                });
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static SQLiteBuider.CreateTable createTable() {
        SQLiteBuider.CreateTable.Builder builder = new SQLiteBuider.CreateTable.Builder();
        builder.setTableName(SQLiteTrackHelper.TABLE_TRACK);
        builder.setPrimaryKey("id", "long");
        builder.autoincrement(true);
        HashMap map = new HashMap();
        map.put("url", "text");
        map.put("event", "text");
        map.put("request_id", "text");
        map.put("timestamp", "long");
        map.put("source", "text");
        map.put("retryNum", "int");
        map.put(a.A, "text");
        map.put("messageType", "int");
        builder.setColumns(map);
        return builder.build();
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0113  */
    /* JADX WARN: Code duplicated, block: B:72:0x0130 A[DONT_GENERATE, PHI: r2
      0x0130: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v3 android.database.Cursor) binds: [B:71:0x012e, B:67:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:97:0x0125 A[EDGE_INSN: B:97:0x0125->B:67:0x0125 BREAK  A[LOOP:0: B:9:0x006b->B:66:0x0115], SYNTHETIC] */
    public static List<AdTracker> getAdTrackerFromDB(int i, long j) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        MessageType messageType;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            int i8 = 0;
            cursorRawQuery = SQLiteTrackHelper.getInstance().getReadableDatabase().rawQuery("select * from tracks where timestamp > ? order by id desc limit ?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                int columnIndex = cursorRawQuery.getColumnIndex("url");
                int columnIndex2 = cursorRawQuery.getColumnIndex("id");
                int columnIndex3 = cursorRawQuery.getColumnIndex("event");
                int columnIndex4 = cursorRawQuery.getColumnIndex("request_id");
                int columnIndex5 = cursorRawQuery.getColumnIndex("timestamp");
                int columnIndex6 = cursorRawQuery.getColumnIndex("source");
                int columnIndex7 = cursorRawQuery.getColumnIndex("retryNum");
                int columnIndex8 = cursorRawQuery.getColumnIndex(a.A);
                int columnIndex9 = cursorRawQuery.getColumnIndex("messageType");
                while (i8 < i) {
                    try {
                        String string = cursorRawQuery.getString(columnIndex);
                        long j2 = cursorRawQuery.getLong(columnIndex2);
                        String string2 = cursorRawQuery.getString(columnIndex3);
                        String string3 = cursorRawQuery.getString(columnIndex4);
                        i2 = columnIndex;
                        try {
                            Long lValueOf = Long.valueOf(cursorRawQuery.getLong(columnIndex5));
                            i3 = columnIndex2;
                            try {
                                String string4 = cursorRawQuery.getString(columnIndex6);
                                i4 = columnIndex3;
                                try {
                                    int i9 = cursorRawQuery.getInt(columnIndex7);
                                    i5 = columnIndex4;
                                    try {
                                        String string5 = cursorRawQuery.getString(columnIndex8);
                                        i6 = columnIndex5;
                                        try {
                                            int i10 = cursorRawQuery.getInt(columnIndex9);
                                            if (TextUtils.isEmpty(string) || j2 < 0 || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                                i7 = columnIndex6;
                                            } else {
                                                i7 = columnIndex6;
                                                if (i10 == 1) {
                                                    messageType = MessageType.QUARTILE_EVENT;
                                                } else if (i10 != 2) {
                                                    try {
                                                        messageType = MessageType.TRACKING_URL;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        SigmobLog.e("getAdTrackList error", th);
                                                    }
                                                } else {
                                                    messageType = MessageType.TOBID_TRACKING_URL;
                                                }
                                                AdTracker adTracker = new AdTracker(messageType, string, string2, string3);
                                                adTracker.setId(Long.valueOf(j2));
                                                adTracker.setRetryCount(i9);
                                                adTracker.setTimestamp(lValueOf);
                                                if (!TextUtils.isEmpty(string4)) {
                                                    adTracker.setSource(string4);
                                                }
                                                adTracker.setExtInfo(string5);
                                                arrayList.add(adTracker);
                                                if (!cursorRawQuery.moveToNext()) {
                                                    break;
                                                }
                                                i8++;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            i7 = columnIndex6;
                                            SigmobLog.e("getAdTrackList error", th);
                                            if (!cursorRawQuery.moveToNext()) {
                                                break;
                                                if (cursorRawQuery != null) {
                                                }
                                                return arrayList;
                                            }
                                            i8++;
                                            columnIndex2 = i3;
                                            columnIndex3 = i4;
                                            columnIndex = i2;
                                            columnIndex4 = i5;
                                            columnIndex5 = i6;
                                            columnIndex6 = i7;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i6 = columnIndex5;
                                        i7 = columnIndex6;
                                        SigmobLog.e("getAdTrackList error", th);
                                        if (!cursorRawQuery.moveToNext()) {
                                            break;
                                            if (cursorRawQuery != null) {
                                            }
                                            return arrayList;
                                        }
                                        i8++;
                                        columnIndex2 = i3;
                                        columnIndex3 = i4;
                                        columnIndex = i2;
                                        columnIndex4 = i5;
                                        columnIndex5 = i6;
                                        columnIndex6 = i7;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    i5 = columnIndex4;
                                    i6 = columnIndex5;
                                    i7 = columnIndex6;
                                    SigmobLog.e("getAdTrackList error", th);
                                    if (!cursorRawQuery.moveToNext()) {
                                        break;
                                        if (cursorRawQuery != null) {
                                        }
                                        return arrayList;
                                    }
                                    i8++;
                                    columnIndex2 = i3;
                                    columnIndex3 = i4;
                                    columnIndex = i2;
                                    columnIndex4 = i5;
                                    columnIndex5 = i6;
                                    columnIndex6 = i7;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                i4 = columnIndex3;
                                i5 = columnIndex4;
                                i6 = columnIndex5;
                                i7 = columnIndex6;
                                SigmobLog.e("getAdTrackList error", th);
                                if (!cursorRawQuery.moveToNext()) {
                                    break;
                                    if (cursorRawQuery != null) {
                                    }
                                    return arrayList;
                                }
                                i8++;
                                columnIndex2 = i3;
                                columnIndex3 = i4;
                                columnIndex = i2;
                                columnIndex4 = i5;
                                columnIndex5 = i6;
                                columnIndex6 = i7;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            i3 = columnIndex2;
                            i4 = columnIndex3;
                            i5 = columnIndex4;
                            i6 = columnIndex5;
                            i7 = columnIndex6;
                            SigmobLog.e("getAdTrackList error", th);
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                                if (cursorRawQuery != null) {
                                }
                                return arrayList;
                            }
                            i8++;
                            columnIndex2 = i3;
                            columnIndex3 = i4;
                            columnIndex = i2;
                            columnIndex4 = i5;
                            columnIndex5 = i6;
                            columnIndex6 = i7;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        i2 = columnIndex;
                    }
                    columnIndex2 = i3;
                    columnIndex3 = i4;
                    columnIndex = i2;
                    columnIndex4 = i5;
                    columnIndex5 = i6;
                    columnIndex6 = i7;
                }
            }
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th8) {
            try {
                SigmobLog.e("getlogs fail", th8);
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        return arrayList;
    }

    private void setId(Long l) {
        this.mId = l;
    }

    private void setRetryCount(int i) {
        this.retryCount = Integer.valueOf(i);
    }

    public void deleteDB() {
        if (this.mId == null) {
            return;
        }
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), SQLiteTrackHelper.TABLE_TRACK, "id = ?", new String[]{String.valueOf(this.mId)}, new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.4
                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                    SigmobLog.d("delete id " + AdTracker.this.mId);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public Long getId() {
        return this.mId;
    }

    public MessageType getMessageType() {
        return this.mMessageType;
    }

    public String getRequest_id() {
        return this.mRequest_id;
    }

    public int getRetryCount() {
        return this.retryCount.intValue();
    }

    public Integer getRetryNum() {
        Integer num = this.retryNum;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getSource() {
        return this.mSource;
    }

    public long getTimestamp() {
        Long l = this.timestamp;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void insertToDB(final SQLiteTrackHelper.ExecCallBack execCallBack) {
        try {
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(SQLiteTrackHelper.TABLE_TRACK);
            HashMap map = new HashMap();
            int i = AnonymousClass5.$SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[this.mMessageType.ordinal()];
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 0;
                }
            }
            map.put("url", this.mUrl);
            map.put("request_id", this.mRequest_id);
            map.put("event", this.mEvent);
            map.put("source", this.mSource);
            map.put("retryNum", this.retryCount);
            map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            map.put(a.A, this.extInfo);
            map.put("messageType", Integer.valueOf(i2));
            builder.setColumnValues(map);
            SQLiteTrackHelper.insert(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build(), new SQLiteTrackHelper.ExecCallBack() { // from class: com.czhj.sdk.common.track.AdTracker.3
                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onFailed(Throwable th) {
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onFailed(th);
                    }
                    SigmobLog.e(th.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onSuccess() {
                    SigmobLog.d("event: " + AdTracker.this.mEvent + " url " + AdTracker.this.mUrl + " mRequest_id: " + AdTracker.this.mRequest_id + " insert success! ");
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onSuccess();
                    }
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public boolean isTracked() {
        return this.mCalled;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setRetryCountInc() {
        this.retryCount = Integer.valueOf(this.retryCount.intValue() + 1);
    }

    public void setRetryNum(Integer num) {
        this.retryNum = num;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public void setTracked() {
        this.mCalled = true;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void updateToDB() {
        try {
            SQLiteBuider.Update.Builder builder = new SQLiteBuider.Update.Builder();
            builder.setTableName(SQLiteTrackHelper.TABLE_TRACK);
            builder.setWhere(" where id=" + this.mId.toString());
            HashMap map = new HashMap();
            map.put("retryNum", this.retryCount);
            builder.setColumnValues(map);
            SQLiteTrackHelper.getInstance().transactionWriteExecSQL(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build().getSql(), null);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
