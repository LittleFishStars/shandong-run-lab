package com.byazt.six;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.nr.m;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 502, 34})
public class a {
    public static int c = 2000;
    public static volatile a tt;
    public volatile ConcurrentHashMap<String, com.byazt.ku.ve> n;
    public final Object uj = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f29022a = new AtomicBoolean(false);
    public LruCache<String, com.byazt.ku.tt> sp = new LruCache<String, com.byazt.ku.tt>(c) { // from class: com.byazt.six.a.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.byazt.ku.tt ttVar) {
            return 1;
        }
    };
    public Set<String> ve = Collections.synchronizedSet(new HashSet());

    private a() {
    }

    public static a c() {
        if (tt == null) {
            synchronized (a.class) {
                if (tt == null) {
                    tt = new a();
                }
            }
        }
        return tt;
    }

    private void uj(String str) {
        LruCache<String, com.byazt.ku.tt> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.sp) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.uj) {
            this.sp.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    public Set<com.byazt.ku.tt> tt(String str) {
        com.byazt.ku.tt ttVar;
        if (TextUtils.isEmpty(str) || com.byazt.mf.c.c().tt() == null) {
            return Collections.emptySet();
        }
        Cursor cursorQuery = com.byazt.mf.c.c().tt().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    HashSet hashSet = new HashSet();
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.uj) {
                                    ttVar = this.sp.get(string);
                                }
                                if (ttVar != null) {
                                    hashSet.add(ttVar);
                                } else {
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                    com.byazt.ku.tt ttVarC = new com.byazt.ku.tt().c(str).tt(string).ve(string2).uj(string3).n(string4).a(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).c(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                    hashSet.add(ttVarC);
                                    synchronized (this.uj) {
                                        this.sp.put(string, ttVarC);
                                    }
                                    this.ve.add(string);
                                }
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    cursorQuery.close();
                    return hashSet;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } else if (cursorQuery != null) {
            cursorQuery.close();
        }
        return Collections.emptySet();
    }

    public void ve(String str) {
        com.byazt.ku.ve veVar;
        try {
            if (this.n == null || this.n.isEmpty() || (veVar = this.n.get(str)) == null) {
                return;
            }
            String strC = veVar.c();
            if (!TextUtils.isEmpty(strC) && com.byazt.mf.c.c().a() != null) {
                com.byazt.mf.c.c().a().delete(strC, str);
            }
            this.n.remove(str);
        } catch (Throwable unused) {
        }
    }

    public static String ve() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }

    public com.byazt.ku.tt c(String str) {
        com.byazt.ku.tt ttVar;
        com.byazt.ku.tt ttVarC;
        if (TextUtils.isEmpty(str) || com.byazt.mf.c.c().tt() == null) {
            return null;
        }
        synchronized (this.uj) {
            ttVar = this.sp.get(String.valueOf(str));
        }
        if (ttVar != null) {
            return ttVar;
        }
        Cursor cursorQuery = com.byazt.mf.c.c().tt().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        ttVarC = new com.byazt.ku.tt().c(string).tt(string2).ve(string3).uj(string4).n(string5).a(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).c(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.uj) {
                            this.sp.put(string2, ttVarC);
                        }
                        this.ve.add(string2);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return ttVarC;
                }
            } catch (Throwable th) {
                try {
                    m.ve("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    public List<com.byazt.ku.tt> tt() {
        if (com.byazt.mf.c.c().tt() == null) {
            return null;
        }
        boolean z = this.f29022a.get();
        this.f29022a.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.mf.c.c().tt().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    arrayList.add(new com.byazt.ku.tt().c(string).tt(string2).ve(string3).uj(string4).n(string5).a(string6).c(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")))));
                    synchronized (this.uj) {
                        this.sp.put(string2, (com.byazt.ku.tt) arrayList.get(arrayList.size() - 1));
                    }
                    this.ve.add(string2);
                    if (!z && com.byazt.mf.c.c().a() != null) {
                        if (this.n == null) {
                            this.n = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.n.contains(string2)) {
                            this.n.put(string2, new com.byazt.ku.ve(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        m.ve("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        cursorQuery.close();
                    }
                }
            }
        }
        return arrayList;
    }

    public void c(com.byazt.ku.tt ttVar, boolean z) {
        if (ttVar == null || com.byazt.mf.c.c().tt() == null || TextUtils.isEmpty(ttVar.tt())) {
            return;
        }
        Cursor cursorQuery = com.byazt.mf.c.c().tt().query("template_diff_new", null, "id=?", new String[]{ttVar.tt()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", ttVar.c());
        contentValues.put("id", ttVar.tt());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, ttVar.ve());
        contentValues.put("url", ttVar.uj());
        contentValues.put("data", ttVar.n());
        contentValues.put("version", ttVar.a());
        contentValues.put("update_time", ttVar.sp());
        if (z2) {
            com.byazt.mf.c.c().tt().update("template_diff_new", contentValues, "id=?", new String[]{ttVar.tt()});
        } else {
            com.byazt.mf.c.c().tt().insert("template_diff_new", contentValues);
        }
        synchronized (this.uj) {
            this.sp.put(ttVar.tt(), ttVar);
        }
        this.ve.add(ttVar.tt());
        if (z) {
            return;
        }
        try {
            if (com.byazt.mf.c.c().a() == null) {
                return;
            }
            if (this.n == null) {
                this.n = new ConcurrentHashMap<>();
            }
            com.byazt.ku.ve veVar = new com.byazt.ku.ve(ttVar.c(), ttVar.tt(), ttVar.ve());
            this.n.put(ttVar.tt(), veVar);
            if (string != null) {
                com.byazt.mf.c.c().a().delete(string, veVar.tt());
            }
            com.byazt.mf.c.c().a().update(ttVar.c(), veVar);
        } catch (Throwable unused2) {
        }
    }

    public void c(Set<String> set) {
        if (set == null || set.isEmpty() || com.byazt.mf.c.c().tt() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                uj(strArr[i]);
                com.byazt.mf.c.c().tt().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                ve(strArr[i]);
            }
        }
    }
}
