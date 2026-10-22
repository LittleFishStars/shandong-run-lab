package com.byazt.utw;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 54})
public final class ve {
    public static volatile ve n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.byazt.emg.ve f29114a;
    public volatile int c = 163840;
    public final com.byazt.utw.tt.InterfaceC0551tt da;
    public final HashSet<c> i;
    public volatile String sl;
    public volatile com.byazt.byh.ve sp;
    public volatile boolean t;
    public final SparseArray<Map<String, com.byazt.utw.tt>> tt;
    public final ExecutorService uj;
    public final tt<Runnable> ve;
    public volatile com.byazt.byh.tt x;

    @com.byazt.zqa.c(c = {0, 1, 450, 24})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f29115a;
        public final boolean c;
        public final Map<String, String> n;
        public final boolean tt;
        public final String uj;
        public final int ve;

        public c(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.c = z;
            this.tt = z2;
            this.ve = i;
            this.uj = str;
            this.n = map;
            this.f29115a = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.c == cVar.c && this.tt == cVar.tt && this.ve == cVar.ve) {
                return this.uj.equals(cVar.uj);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.c ? 1 : 0) * 31) + (this.tt ? 1 : 0)) * 31) + this.ve) * 31) + this.uj.hashCode();
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 450, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static final class tt<T> extends LinkedBlockingDeque<T> {
        public ThreadPoolExecutor c;

        private tt() {
        }

        public void c(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.c != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.c = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.c.getPoolSize();
                int activeCount = this.c.getActiveCount();
                int maximumPoolSize = this.c.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t);
                }
                if (uj.n) {
                    m.c("TAG_PROXY_TT", "create new preloader thread");
                }
                return false;
            }
        }
    }

    private ve() {
        SparseArray<Map<String, com.byazt.utw.tt>> sparseArray = new SparseArray<>(2);
        this.tt = sparseArray;
        this.i = new HashSet<>();
        this.da = new com.byazt.utw.tt.InterfaceC0551tt() { // from class: com.byazt.utw.ve.1
            @Override // com.byazt.utw.tt.InterfaceC0551tt
            public void c(com.byazt.utw.tt ttVar) {
                int iN = ttVar.n();
                synchronized (ve.this.tt) {
                    Map map = (Map) ve.this.tt.get(iN);
                    if (map != null) {
                        map.remove(ttVar.x);
                    }
                }
                boolean z = uj.n;
            }
        };
        tt<Runnable> ttVar = new tt<>();
        this.ve = ttVar;
        ExecutorService executorServiceC = c(ttVar);
        this.uj = executorServiceC;
        ttVar.c((ThreadPoolExecutor) executorServiceC);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public void c(com.byazt.byh.ve veVar) {
        this.sp = veVar;
    }

    public void tt() {
        com.byazt.nxx.c.c(new Runnable() { // from class: com.byazt.utw.ve.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.byazt.utw.tt> arrayList = new ArrayList();
                synchronized (ve.this.tt) {
                    int size = ve.this.tt.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) ve.this.tt.get(ve.this.tt.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    ve.this.ve.clear();
                }
                for (com.byazt.utw.tt ttVar : arrayList) {
                    ttVar.c();
                    if (uj.n) {
                        m.tt("TAG_PROXY_Preloader", "PreloadTask: " + ttVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    public void c(com.byazt.emg.ve veVar) {
        this.f29114a = veVar;
    }

    public void c(int i) {
        if (i > 0) {
            this.c = i;
        }
        if (uj.n) {
            m.c("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    public static ve c() {
        if (n == null) {
            synchronized (ve.class) {
                if (n == null) {
                    n = new ve();
                }
            }
        }
        return n;
    }

    public void c(boolean z, boolean z2, int i, String str, String... strArr) throws Throwable {
        c(z, z2, i, str, null, strArr);
    }

    public void c(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) throws Throwable {
        SparseArray<Map<String, com.byazt.utw.tt>> sparseArray;
        ArrayList arrayList;
        boolean z3 = uj.n;
        com.byazt.byh.c cVar = z ? this.x : this.sp;
        com.byazt.emg.ve veVar = this.f29114a;
        if (cVar == null || veVar == null) {
            if (z3) {
                m.uj("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.c : i;
        String strC = z2 ? str : com.byazt.lt.c.c(str);
        File fileUj = cVar.uj(strC);
        if (fileUj != null && fileUj.length() >= i2) {
            if (z3) {
                m.c("TAG_PROXY_Preloader", "no need preload, file size: " + fileUj.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        SparseArray<Map<String, com.byazt.utw.tt>> sparseArray2 = this.tt;
        synchronized (sparseArray2) {
            try {
                try {
                    Map<String, com.byazt.utw.tt> map2 = this.tt.get(z ? 1 : 0);
                    if (!map2.containsKey(strC)) {
                        int i3 = i2;
                        sparseArray = sparseArray2;
                        c cVar2 = new c(z, z2, i2, str, map, strArr);
                        String str2 = this.sl;
                        if (str2 != null) {
                            int i4 = uj.ve;
                            if (i4 == 3) {
                                synchronized (this.i) {
                                    this.i.add(cVar2);
                                }
                                if (z3) {
                                    m.tt("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                }
                                return;
                            }
                            if (i4 == 2) {
                                if (z3) {
                                    m.tt("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                                }
                                return;
                            } else if (i4 == 1 && this.t == z && str2.equals(strC)) {
                                if (z3) {
                                    m.tt("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                }
                                return;
                            }
                        }
                        List<a.tt> listC = com.byazt.nxx.c.c(com.byazt.nxx.c.c(map));
                        if (listC != null) {
                            arrayList = new ArrayList(listC.size());
                            int size = listC.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                a.tt ttVar = listC.get(i5);
                                if (ttVar != null) {
                                    arrayList.add(new a.tt(ttVar.c, ttVar.tt));
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        com.byazt.utw.tt ttVarC = new com.byazt.utw.tt.c().c(cVar).c(veVar).c(str).tt(strC).c(new x(com.byazt.nxx.c.c(strArr))).c((List<a.tt>) arrayList).c(i3).c(this.da).c(cVar2).c();
                        map2.put(strC, ttVarC);
                        this.uj.execute(ttVarC);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    sparseArray = sparseArray2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            throw th;
        }
    }

    public void c(String str) {
        c(false, false, str);
    }

    public void c(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.nxx.c.c(new Runnable() { // from class: com.byazt.utw.ve.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.utw.tt ttVar;
                synchronized (ve.this.tt) {
                    Map map = (Map) ve.this.tt.get(com.byazt.emg.tt.c(z));
                    if (map != null) {
                        ttVar = (com.byazt.utw.tt) map.remove(z2 ? str : com.byazt.lt.c.c(str));
                    } else {
                        ttVar = null;
                    }
                }
                if (ttVar != null) {
                    ttVar.c();
                }
            }
        });
    }

    private static ExecutorService c(final tt<Runnable> ttVar) {
        int i;
        int iC = com.byazt.nxx.c.c();
        if (iC > 0) {
            if (iC > 4) {
                i = 4;
            }
            return new com.byazt.jtc.uj(0, i, 60L, TimeUnit.SECONDS, ttVar, new ThreadFactory() { // from class: com.byazt.utw.ve.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(runnable) { // from class: com.byazt.utw.ve.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable th) {
                                m.c(th);
                            }
                            super.run();
                        }
                    };
                    veVar.setName("csj_video_preload_" + veVar.getId());
                    veVar.setDaemon(true);
                    if (uj.n) {
                        m.c("TAG_PROXY_Preloader", "new preload thead: " + veVar.getName());
                    }
                    return veVar;
                }
            }, new RejectedExecutionHandler() { // from class: com.byazt.utw.ve.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        ttVar.offerFirst(runnable);
                        if (uj.n) {
                            m.c("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                        }
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            });
        }
        iC = 1;
        i = iC;
        return new com.byazt.jtc.uj(0, i, 60L, TimeUnit.SECONDS, ttVar, new ThreadFactory() { // from class: com.byazt.utw.ve.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(runnable) { // from class: com.byazt.utw.ve.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            m.c(th);
                        }
                        super.run();
                    }
                };
                veVar.setName("csj_video_preload_" + veVar.getId());
                veVar.setDaemon(true);
                if (uj.n) {
                    m.c("TAG_PROXY_Preloader", "new preload thead: " + veVar.getName());
                }
                return veVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.byazt.utw.ve.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    ttVar.offerFirst(runnable);
                    if (uj.n) {
                        m.c("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        });
    }
}
