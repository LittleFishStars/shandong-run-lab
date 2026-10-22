package com.getui.gtc.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.getui.gtc.base.db.AbstractTable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends AbstractTable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<Long> f30349a = new SparseArray<>();
    private SparseArray<Long> b = new SparseArray<>();
    private SparseIntArray c = new SparseIntArray();

    public final long a(int i) {
        Long l = this.f30349a.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final void a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ei", Integer.valueOf(i));
        contentValues.put("elt", String.valueOf(j));
        if (replace(null, contentValues) != -1) {
            this.f30349a.put(i, Long.valueOf(j));
        }
    }

    public final void a(int i, long j, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ei", Integer.valueOf(i));
        contentValues.put("est", String.valueOf(j));
        contentValues.put("esn", Integer.valueOf(i2));
        if (replace(null, contentValues) != -1) {
            this.b.put(i, Long.valueOf(j));
            this.c.put(i, i2);
        }
    }

    public final long b(int i) {
        Long l = this.b.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final int c(int i) {
        return this.c.get(i);
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS e (ei INTEGER PRIMARY KEY, elt TEXT, est TEXT, esn INTEGER)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "e";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = query(new String[]{"ei", "elt", "est", "esn"}, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                while (cursorQuery.moveToNext()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("ei"));
                    try {
                        this.f30349a.put(i, Long.valueOf(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("elt")))));
                    } catch (Exception unused) {
                    }
                    try {
                        this.b.put(i, Long.valueOf(Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("est")))));
                    } catch (Exception unused2) {
                    }
                    this.c.put(i, cursorQuery.getInt(cursorQuery.getColumnIndex("esn")));
                }
                cursorQuery.close();
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b(e);
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
