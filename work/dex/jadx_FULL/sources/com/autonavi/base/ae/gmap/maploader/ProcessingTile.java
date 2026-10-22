package com.autonavi.base.ae.gmap.maploader;

import com.autonavi.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool<>(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public ProcessingTile(String str) {
        setParams(str);
    }

    public static ProcessingTile obtain(String str) {
        ProcessingTile processingTileAcquire = M_POOL.acquire();
        if (processingTileAcquire == null) {
            return new ProcessingTile(str);
        }
        processingTileAcquire.setParams(str);
        return processingTileAcquire;
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0L;
        M_POOL.release(this);
    }
}
