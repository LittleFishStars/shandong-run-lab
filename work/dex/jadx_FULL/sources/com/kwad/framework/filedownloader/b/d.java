package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kwad.framework.filedownloader.f.f;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean aAF = false;
    private final e aAG = new e(com.kwad.framework.filedownloader.f.c.Dx());
    private SQLiteDatabase aAH;

    public class a implements com.kwad.framework.filedownloader.b.a.InterfaceC1253a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> aAI = new SparseArray<>();
        private b aAJ;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> aAv;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> aAw;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.aAv = sparseArray;
            this.aAw = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void BS() {
            b bVar = this.aAJ;
            if (bVar != null) {
                bVar.BS();
            }
            try {
                SQLiteDatabase sQLiteDatabaseBT = d.this.BT();
                if (sQLiteDatabaseBT == null) {
                    return;
                }
                int size = this.aAI.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        sQLiteDatabaseBT.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int iKeyAt = this.aAI.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.aAI.get(iKeyAt);
                            sQLiteDatabaseBT.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            sQLiteDatabaseBT.insert("ksad_file_download", null, cVar.CV());
                            if (cVar.Da() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> listCD = d.this.cD(iKeyAt);
                                if (listCD.size() > 0) {
                                    sQLiteDatabaseBT.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : listCD) {
                                        aVar.setId(cVar.getId());
                                        sQLiteDatabaseBT.insert("ksad_file_download_connection", null, aVar.CV());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aAv;
                        if (sparseArray != null && this.aAw != null) {
                            synchronized (sparseArray) {
                                int size2 = this.aAv.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.aAv.valueAt(i2).getId();
                                    List<com.kwad.framework.filedownloader.d.a> listCD2 = d.this.cD(id);
                                    if (listCD2 != null && listCD2.size() > 0) {
                                        synchronized (this.aAw) {
                                            this.aAw.put(id, listCD2);
                                        }
                                    }
                                }
                            }
                        }
                        sQLiteDatabaseBT.setTransactionSuccessful();
                        try {
                            sQLiteDatabaseBT.endTransaction();
                        } catch (Exception e) {
                            d.printStackTrace(e);
                        }
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        try {
                            sQLiteDatabaseBT.endTransaction();
                        } catch (Exception e3) {
                            d.printStackTrace(e3);
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        try {
                            sQLiteDatabaseBT.endTransaction();
                        } catch (Exception e5) {
                            d.printStackTrace(e5);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        sQLiteDatabaseBT.endTransaction();
                    } catch (Exception e6) {
                        d.printStackTrace(e6);
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.aAI.put(i, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC1253a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.aAv;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aAv.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.aAJ = bVar;
            return bVar;
        }
    }

    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor aAL;
        private final List<Integer> aAM = new ArrayList();
        private int aAN;

        public b() {
            try {
                this.aAL = d.this.BT().query("ksad_file_download", null, null, null, null, null, null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: BU, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c cVarD = d.d(this.aAL);
            this.aAN = cVarD.getId();
            return cVarD;
        }

        public final void BS() {
            Cursor cursor = this.aAL;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.aAM.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.aAM);
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", strJoin);
            }
            try {
                SQLiteDatabase sQLiteDatabaseBT = d.this.BT();
                sQLiteDatabaseBT.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", DatabaseHelper.COLUMN_ID, strJoin));
                sQLiteDatabaseBT.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", strJoin));
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.aAL;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.aAM.add(Integer.valueOf(this.aAN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase BT() {
        if (this.aAH == null) {
            this.aAH = this.aAG.getWritableDatabase();
        }
        return this.aAH;
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            BT().insert("ksad_file_download", null, cVar.CV());
        } catch (SQLiteException e) {
            cVar.ch(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private static void o(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        o(th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.b.a.InterfaceC1253a BR() {
        return new a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cC(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            BT().update("ksad_file_download", cVar.CV(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e) {
            cVar.ch(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        cF(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cB(int i) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c cC(int i) throws Throwable {
        Cursor cursorRawQuery;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursorRawQuery = BT().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", DatabaseHelper.COLUMN_ID), new String[]{Integer.toString(i)});
                try {
                    if (cursorRawQuery.moveToNext()) {
                        com.kwad.framework.filedownloader.d.c cVarD = d(cursorRawQuery);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                        return cVarD;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    a(i, e);
                } catch (Exception e2) {
                    e = e2;
                    printStackTrace(e);
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Exception e4) {
            e = e4;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({"Range"})
    public final List<com.kwad.framework.filedownloader.d.a> cD(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = BT().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i);
                    aVar.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("startOffset")));
                    aVar.ad(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                    aVar.ae(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return arrayList;
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cE(int i) {
        try {
            BT().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean cF(int i) {
        try {
            return BT().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cG(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            BT().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            BT().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void w(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            BT().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                BT().insert("ksad_file_download_connection", null, aVar.CV());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            BT().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Range"})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.af(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.ah(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.ch(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.cg(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.ci(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.cV(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    public final com.kwad.framework.filedownloader.b.a.InterfaceC1253a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i, ContentValues contentValues) {
        try {
            BT().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                cF(i);
                cE(i);
            }
            o(sQLiteException);
            aAF = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
