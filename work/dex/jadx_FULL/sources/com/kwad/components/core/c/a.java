package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a {
    private static volatile a Pg;
    private final SQLiteDatabase Pe;
    private ConcurrentHashMap<String, e> Pf = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    public static class C1191a extends SQLiteOpenHelper {
        private static int Pj = 1;
        private String Pk;
        private String Pl;

        public C1191a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, Pj);
            this.Pk = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.Pl = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.Pk);
            sQLiteDatabase.execSQL(this.Pl);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private a(Context context) {
        this.Pe = new C1191a(context).getWritableDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends j> void b(List<T> list, String str) {
        try {
            this.Pe.beginTransaction();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                try {
                    com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.Pe.insertWithOnConflict(str, null, it.next().oT(), 5));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            }
            this.Pe.setTransactionSuccessful();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        } finally {
            SQLiteDatabase sQLiteDatabase = this.Pe;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.c.printStackTrace(e3);
                }
            }
        }
    }

    @Nullable
    public static a oI() {
        if (Pg == null) {
            synchronized (a.class) {
                if (Pg == null) {
                    try {
                        Pg = new a(ServiceProvider.Ud());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        Pg = null;
                    }
                }
            }
        }
        return Pg;
    }

    @WorkerThread
    public final e ah(String str) throws Throwable {
        Cursor cursorRawQuery;
        e eVar;
        ConcurrentHashMap<String, e> concurrentHashMap = this.Pf;
        if (concurrentHashMap != null && (eVar = concurrentHashMap.get(str)) != null) {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "findCacheStrategyList from cache, posId: " + str);
            return eVar;
        }
        Cursor cursor = null;
        try {
            cursorRawQuery = this.Pe.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            try {
                try {
                    List<e> listA = e.a(cursorRawQuery);
                    if (listA != null && listA.size() > 0) {
                        e eVar2 = listA.get(0);
                        this.Pf.put(str, eVar2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                        return eVar2;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        return null;
    }

    @WorkerThread
    public final void j(List<i> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void oJ() {
        try {
            this.Pe.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @WorkerThread
    public final void oK() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.Pe.rawQuery("select  * from ksad_ad_cache_strategy", null);
                List<e> listA = e.a(cursorRawQuery);
                if (listA != null && !listA.isEmpty()) {
                    for (e eVar : listA) {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "readCacheStrategyList:" + eVar.oP());
                        this.Pf.put(eVar.oP(), eVar);
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    @WorkerThread
    public final void z(long j) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.Pe.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0096: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x0096 */
    @Nullable
    @WorkerThread
    public final List<i> a(String str, long j, int i) throws Throwable {
        Cursor cursorRawQuery;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursorRawQuery = this.Pe.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<i> listA = i.a(cursorRawQuery);
                    if (listA == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (i iVar : listA) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(iVar.pc());
                            if (i2 == listA.size()) {
                                sb.append(")");
                            } else {
                                sb.append(" OR");
                            }
                        } else if (iVar.pa() >= j) {
                            arrayList.add(iVar);
                        }
                    }
                    if (i2 > i) {
                        this.Pe.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    public final void a(final e eVar) {
        this.Pf.put(eVar.oP(), eVar);
        GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.components.core.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
            }
        });
    }
}
