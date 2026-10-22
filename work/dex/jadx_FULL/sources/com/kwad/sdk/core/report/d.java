package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d implements l<e> {
    private static final String[] aVg = {"count(*)"};
    private static boolean aVh = false;
    protected c aVi;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aVi = cVar;
    }

    private synchronized void c(e eVar) {
        if (aVh) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.aVi.getReadableDatabase().delete(MW(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void H(List<e> list) {
        if (aVh) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase readableDatabase = null;
        try {
            try {
                readableDatabase = this.aVi.getReadableDatabase();
                readableDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                readableDatabase.setTransactionSuccessful();
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTrace(e3);
                    }
                }
            }
        } catch (Throwable th) {
            if (readableDatabase != null) {
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e4) {
                    com.kwad.sdk.core.d.c.printStackTrace(e4);
                }
            }
            throw th;
        }
    }

    public abstract String MW();

    public abstract String[] MX();

    public final synchronized List<e> MY() {
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArrMX = MX();
                cursorQuery = this.aVi.getReadableDatabase().query(MW(), strArrMX.length == 0 ? null : strArrMX, null, null, null, null, null);
                if (cursorQuery != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        try {
                            arrayList.add(f(cursorQuery));
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                    if (aVh) {
                        Log.d(getTag(), "read size= " + arrayList.size());
                        for (e eVar : arrayList) {
                            Log.d(getTag(), "read action=" + eVar);
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                    return arrayList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return new ArrayList();
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void o(e eVar) {
        if (aVh) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.aVi.getReadableDatabase().insert(MW(), null, contentValues);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> eE(int i) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.aVi.getReadableDatabase().query(MW(), MX(), null, null, null, null, null, "0,200");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(f(cursorQuery));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public abstract e f(@NonNull Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.aVi.getReadableDatabase().query(MW(), aVg, null, null, null, null, null);
                cursorQuery.moveToFirst();
                j = cursorQuery.getLong(0);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                j = 0;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            throw th;
        }
        return j;
    }
}
