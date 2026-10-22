package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.zj.adlib.gj9;
import com.zj.adlib.mm9;
import com.zj.adlib.qq2;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements WritableDownloadIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final int f30800a = 3;
    public static final int b = 0;
    public static final int c = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f3584c = "ExoPlayerDownloads";
    public static final int d = 2;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f3585d = "id";
    public static final int e = 3;
    public static final int f = 4;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f3587f = "uri";
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f3590i = "data";
    public static final int j = 8;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f3591j = "state";
    public static final int k = 9;
    public static final int l = 10;
    public static final int m = 11;
    public static final int n = 12;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final String f3595n = "stop_reason";
    public static final int o = 13;
    public static final int p = 14;
    public static final String s = "id = ?";
    public static final String t = "state = 2";
    public static final String v = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
    public static final String w = "1";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DatabaseProvider f3598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("initializationLock")
    public boolean f3601a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f3602b;
    public static final String u = k(3, 4);

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f3586e = "mime_type";

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f3588g = "stream_keys";

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f3589h = "custom_cache_key";

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final String f3592k = "start_time_ms";

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final String f3593l = "update_time_ms";

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final String f3594m = "content_length";

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final String f3596o = "failure_reason";

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public static final String f3597p = "percent_downloaded";
    public static final String q = "bytes_downloaded";
    public static final String r = "key_set_id";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f3583a = {"id", f3586e, "uri", f3588g, f3589h, "data", "state", f3592k, f3593l, f3594m, "stop_reason", f3596o, f3597p, q, r};

    public static final class b implements DownloadCursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f30801a;

        @Override // com.google.android.exoplayer2.offline.DownloadCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f30801a.close();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getCount() {
            return this.f30801a.getCount();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getPosition() {
            return this.f30801a.getPosition();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean isClosed() {
            return this.f30801a.isClosed();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean moveToPosition(int i) {
            return this.f30801a.moveToPosition(i);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public Download w0() {
            return a.i(this.f30801a);
        }

        public b(Cursor cursor) {
            this.f30801a = cursor;
        }
    }

    public a(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    public static List<StreamKey> e(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : gj9.u1(str, ",")) {
            String[] strArrU1 = gj9.u1(str2, "\\.");
            sb0.i(strArrU1.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(strArrU1[0]), Integer.parseInt(strArrU1[1]), Integer.parseInt(strArrU1[2])));
        }
        return arrayList;
    }

    @VisibleForTesting
    public static String f(List<StreamKey> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            StreamKey streamKey = list.get(i2);
            sb.append(streamKey.periodIndex);
            sb.append('.');
            sb.append(streamKey.groupIndex);
            sb.append('.');
            sb.append(streamKey.streamIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static Download i(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.b bVarF = new DownloadRequest.b((String) sb0.g(cursor.getString(0)), Uri.parse((String) sb0.g(cursor.getString(2)))).e(cursor.getString(1)).f(e(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest downloadRequestA = bVarF.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        qq2 qq2Var = new qq2();
        qq2Var.f19160a = cursor.getLong(13);
        qq2Var.f44275a = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        return new Download(downloadRequestA, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2 == 4 ? cursor.getInt(11) : 0, qq2Var);
    }

    public static Download j(Cursor cursor) {
        DownloadRequest downloadRequestA = new DownloadRequest.b((String) sb0.g(cursor.getString(0)), Uri.parse((String) sb0.g(cursor.getString(2)))).e(l(cursor.getString(1))).f(e(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        qq2 qq2Var = new qq2();
        qq2Var.f19160a = cursor.getLong(13);
        qq2Var.f44275a = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        return new Download(downloadRequestA, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2 == 4 ? cursor.getInt(11) : 0, qq2Var);
    }

    public static String k(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state");
        sb.append(" IN (");
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(iArr[i2]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static String l(@Nullable String str) {
        if ("dash".equals(str)) {
            return "application/dash+xml";
        }
        if (LiveConfigKey.HLS.equals(str)) {
            return "application/x-mpegURL";
        }
        return "ss".equals(str) ? "application/vnd.ms-sstr+xml" : "video/x-unknown";
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void a(Download download) throws DatabaseIOException {
        g();
        try {
            n(download, this.f3598a.getWritableDatabase());
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    public DownloadCursor b(int... iArr) throws DatabaseIOException {
        g();
        return new b(h(k(iArr), null));
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    @Nullable
    public Download c(String str) throws DatabaseIOException {
        g();
        try {
            Cursor cursorH = h("id = ?", new String[]{str});
            try {
                if (cursorH.getCount() == 0) {
                    cursorH.close();
                    return null;
                }
                cursorH.moveToNext();
                Download downloadI = i(cursorH);
                cursorH.close();
                return downloadI;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
        throw new DatabaseIOException(e2);
    }

    public final void g() throws DatabaseIOException {
        synchronized (this.f3599a) {
            if (this.f3601a) {
                return;
            }
            try {
                int iB = mm9.b(this.f3598a.getReadableDatabase(), 0, this.f3600a);
                if (iB != 3) {
                    SQLiteDatabase writableDatabase = this.f3598a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        mm9.d(writableDatabase, 0, this.f3600a, 3);
                        List<Download> listM = iB == 2 ? m(writableDatabase) : new ArrayList<>();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f3602b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f3602b + " " + v);
                        Iterator<Download> it = listM.iterator();
                        while (it.hasNext()) {
                            n(it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.f3601a = true;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }
    }

    public final Cursor h(String str, @Nullable String[] strArr) throws DatabaseIOException {
        try {
            return this.f3598a.getReadableDatabase().query(this.f3602b, f3583a, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final List<Download> m(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!gj9.A1(sQLiteDatabase, this.f3602b)) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.f3602b, new String[]{"id", "title", "uri", f3588g, f3589h, "data", "state", f3592k, f3593l, f3594m, "stop_reason", f3596o, f3597p, q}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(j(cursorQuery));
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final void n(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.f3490a.keySetId;
        if (bArr == null) {
            bArr = gj9.f16790a;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.f3490a.id);
        contentValues.put(f3586e, download.f3490a.mimeType);
        contentValues.put("uri", download.f3490a.uri.toString());
        contentValues.put(f3588g, f(download.f3490a.streamKeys));
        contentValues.put(f3589h, download.f3490a.customCacheKey);
        contentValues.put("data", download.f3490a.data);
        contentValues.put("state", Integer.valueOf(download.f30784a));
        contentValues.put(f3592k, Long.valueOf(download.f3489a));
        contentValues.put(f3593l, Long.valueOf(download.f3492b));
        contentValues.put(f3594m, Long.valueOf(download.f3493c));
        contentValues.put("stop_reason", Integer.valueOf(download.b));
        contentValues.put(f3596o, Integer.valueOf(download.c));
        contentValues.put(f3597p, Float.valueOf(download.b()));
        contentValues.put(q, Long.valueOf(download.a()));
        contentValues.put(r, bArr);
        sQLiteDatabase.replaceOrThrow(this.f3602b, null, contentValues);
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void removeDownload(String str) throws DatabaseIOException {
        g();
        try {
            this.f3598a.getWritableDatabase().delete(this.f3602b, "id = ?", new String[]{str});
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setDownloadingStatesToQueued() throws DatabaseIOException {
        g();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.f3598a.getWritableDatabase().update(this.f3602b, contentValues, t, null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStatesToRemoving() throws DatabaseIOException {
        g();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put(f3596o, (Integer) 0);
            this.f3598a.getWritableDatabase().update(this.f3602b, contentValues, null, null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(int i2) throws DatabaseIOException {
        g();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i2));
            this.f3598a.getWritableDatabase().update(this.f3602b, contentValues, u, null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public a(DatabaseProvider databaseProvider, String str) {
        this.f3600a = str;
        this.f3598a = databaseProvider;
        this.f3602b = f3584c + str;
        this.f3599a = new Object();
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(String str, int i2) throws DatabaseIOException {
        g();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i2));
            this.f3598a.getWritableDatabase().update(this.f3602b, contentValues, u + " AND id = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
