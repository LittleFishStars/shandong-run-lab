package com.fl.saas.s2s.videocache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PreCatcher {
    private Map<String, PreCacheCallable> mCacheCallableMap;
    private ExecutorService preCacheExecutor;

    public static class InstanceHolder {
        private static PreCatcher mInstance = new PreCatcher();
    }

    public class PreCacheCallable implements Callable<Boolean> {
        int mCacheSize;
        HttpUrlSource mSource;
        String mUrl;
        boolean mStoped = false;
        private final Object mStopLock = new Object();

        public PreCacheCallable(String str, int i) {
            this.mCacheSize = Integer.MAX_VALUE;
            this.mUrl = str;
            if (i > 0) {
                this.mCacheSize = i;
            }
        }

        private boolean connectToPoxyServer(String str) {
            synchronized (this.mStopLock) {
                if (isStoped()) {
                    return false;
                }
                HttpUrlSource httpUrlSource = new HttpUrlSource(str);
                this.mSource = httpUrlSource;
                try {
                    try {
                        httpUrlSource.open(0L);
                        byte[] bArr = new byte[8192];
                        int i = 0;
                        do {
                            int i2 = this.mSource.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            synchronized (this.mStopLock) {
                                try {
                                    if (isStoped()) {
                                        break;
                                    }
                                    i += i2;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } while (i < this.mCacheSize);
                        try {
                            return true;
                        } catch (ProxyCacheException e) {
                            return true;
                        }
                    } catch (ProxyCacheException e2) {
                        e2.printStackTrace();
                        try {
                            this.mSource.close();
                        } catch (ProxyCacheException e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    }
                } finally {
                    try {
                        this.mSource.close();
                        PreCatcher.this.removePreCacheCallable(str);
                    } catch (ProxyCacheException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        private boolean isStoped() {
            return this.mStoped;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(connectToPoxyServer(this.mUrl));
        }

        public void stop() {
            synchronized (this.mStopLock) {
                this.mStoped = true;
            }
        }
    }

    private PreCatcher() {
        this.preCacheExecutor = Executors.newFixedThreadPool(5);
        this.mCacheCallableMap = new HashMap();
    }

    public static PreCatcher getInstance() {
        return InstanceHolder.mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removePreCacheCallable(String str) {
        if (this.mCacheCallableMap.get(str) == null) {
            return false;
        }
        this.mCacheCallableMap.remove(str);
        return true;
    }

    public synchronized boolean startCache(String str, int i) {
        if (this.mCacheCallableMap.containsKey(str)) {
            return false;
        }
        PreCacheCallable preCacheCallable = new PreCacheCallable(str, i);
        this.mCacheCallableMap.put(str, preCacheCallable);
        this.preCacheExecutor.submit(preCacheCallable);
        return true;
    }

    public void stopAll() {
        Iterator<PreCacheCallable> it = this.mCacheCallableMap.values().iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.mCacheCallableMap.clear();
    }

    public synchronized void stopCache(String str) {
        PreCacheCallable preCacheCallable = this.mCacheCallableMap.get(str);
        if (preCacheCallable != null) {
            preCacheCallable.stop();
            this.mCacheCallableMap.remove(str);
        }
    }
}
