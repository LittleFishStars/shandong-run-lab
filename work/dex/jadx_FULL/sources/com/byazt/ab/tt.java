package com.byazt.ab;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 757, 13})
public class tt {
    public static volatile tt c;
    public LruCache<String, com.byazt.ehu.c> tt;
    public int uj;
    public final long ve;
    public CopyOnWriteArrayList<String> n = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<String> f28282a = new CopyOnWriteArrayList<>();
    public ConcurrentHashMap<String, WeakReference<com.byazt.at.uj>> sp = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Long> x = new ConcurrentHashMap<>();
    public final Object i = new Object();

    private tt() {
        int iPb = gt.tt().pb();
        this.uj = iPb;
        if (iPb > 30) {
            this.uj = 30;
        } else if (iPb < 0) {
            this.uj = 5;
        }
        this.ve = gt.tt().sy() * 1000;
        this.tt = new LruCache<String, com.byazt.ehu.c>(this.uj) { // from class: com.byazt.ab.tt.1
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.byazt.ehu.c cVar) {
                return 1;
            }
        };
    }

    public static /* synthetic */ void c(tt ttVar, String str) {
    }

    private void uj(final ic icVar) {
        if (TextUtils.isEmpty(icVar.wo())) {
            return;
        }
        final String strWo = icVar.wo();
        if (this.n.contains(strWo) || this.f28282a.contains(strWo) || this.tt.get(strWo) != null) {
            return;
        }
        this.n.add(strWo);
        this.x.put(strWo, Long.valueOf(System.currentTimeMillis()));
        n.tt(new sp("playable_prefetch") { // from class: com.byazt.ab.tt.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    tt.this.c(icVar, strWo);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void tt(ic icVar) {
        if (icVar != null) {
            try {
                if (TextUtils.isEmpty(icVar.wo())) {
                    return;
                }
                String strWo = icVar.wo();
                this.f28282a.add(strWo);
                this.tt.remove(strWo);
                this.n.remove(strWo);
                this.sp.remove(strWo);
                this.x.remove(strWo);
                this.tt.size();
                this.n.size();
                this.f28282a.size();
            } catch (Exception unused) {
            }
        }
    }

    public long ve(ic icVar) {
        try {
            if (this.x == null || icVar == null || TextUtils.isEmpty(icVar.wo())) {
                return 0L;
            }
            return this.x.get(icVar.wo()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public void c(ic icVar) {
        if (icVar != null) {
            try {
                if (icVar.cj() == 3) {
                    uj(icVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ic icVar, final String str) {
        com.byazt.hy.tt.c(icVar, icVar == null ? null : icVar.jm(), new com.byazt.at.uj() { // from class: com.byazt.ab.tt.3
            @Override // com.byazt.at.uj
            public void c(boolean z, List<ic> list, boolean z2) {
                try {
                    if (tt.this.f28282a != null && tt.this.f28282a.contains(str)) {
                        tt.c(tt.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    tt.c(tt.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (tt.this.i) {
                        if (!z || list == null) {
                            tt.this.n.remove(str);
                        } else {
                            if (list.size() > 0) {
                                com.byazt.ehu.c cVar = new com.byazt.ehu.c();
                                cVar.c = list;
                                cVar.tt = z;
                                cVar.ve = SystemClock.elapsedRealtime();
                                tt.this.tt.put(str, cVar);
                                tt.c(tt.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            tt.this.n.remove(str);
                        }
                        throw th;
                    }
                    WeakReference weakReference = (WeakReference) tt.this.sp.get(str);
                    com.byazt.at.uj ujVar = weakReference == null ? null : (com.byazt.at.uj) weakReference.get();
                    if (ujVar != null) {
                        ujVar.c(z, list, true);
                        tt.this.sp.remove(str);
                        tt.c(tt.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.byazt.dj.tt) null);
    }

    public boolean c(ic icVar, com.byazt.at.uj ujVar) {
        if (icVar != null && !TextUtils.isEmpty(icVar.wo())) {
            String strWo = icVar.wo();
            try {
                synchronized (this.i) {
                    if (this.n.contains(strWo)) {
                        this.sp.put(strWo, new WeakReference<>(ujVar));
                        return true;
                    }
                    com.byazt.ehu.c cVar = this.tt.get(strWo);
                    if (cVar == null) {
                        return false;
                    }
                    if (c(cVar)) {
                        tt(icVar);
                        return false;
                    }
                    if (ujVar != null) {
                        ujVar.c(cVar.tt, cVar.c, true);
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean c(com.byazt.ehu.c cVar) {
        return this.ve > 0 && cVar != null && SystemClock.elapsedRealtime() - cVar.ve > this.ve;
    }
}
