package com.byazt.yj;

import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Collection;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class nb implements yv, Function {
    public com.byazt.oz.a loadFactory = new com.byazt.oz.a(null, com.byazt.oz.n.da());

    private void c(Collection<? extends c> collection, double d) {
        if (collection == null) {
            return;
        }
        for (c cVar : collection) {
            if (cVar != null) {
                cVar.c(d);
            }
        }
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object hVar = sparseArray.get(1);
            if (hVar != null) {
                hVar = new h((Function) hVar);
            }
            yp ypVarFrom = from((md) hVar);
            return ypVarFrom != null ? new z(ypVarFrom) : ypVarFrom;
        }
        if (iIntValue == 2) {
            Object hVar2 = sparseArray.get(1);
            if (hVar2 != null) {
                hVar2 = new h((Function) hVar2);
            }
            clearMemoryBitmapCache((md) hVar2);
            return null;
        }
        if (iIntValue != 3) {
            if (iIntValue != 4) {
                return null;
            }
            clearAllMemoryCache();
            return null;
        }
        Object hVar3 = sparseArray.get(1);
        if (hVar3 != null) {
            hVar3 = new h((Function) hVar3);
        }
        clearMemoryRawCache((md) hVar3);
        return null;
    }

    @Override // com.byazt.yj.yv
    public void clearAllMemoryCache() {
        c(this.loadFactory.c(), AudioStats.AUDIO_AMPLITUDE_NONE);
        c(this.loadFactory.tt(), AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.byazt.yj.yv
    public void clearMemoryBitmapCache(md mdVar) {
        eo eoVarC;
        com.byazt.oz.a aVar = this.loadFactory;
        if (aVar == null || (eoVarC = aVar.c(c(mdVar))) == null) {
            return;
        }
        eoVarC.c();
    }

    @Override // com.byazt.yj.yv
    public void clearMemoryRawCache(md mdVar) {
        zb zbVarTt;
        com.byazt.oz.a aVar = this.loadFactory;
        if (aVar == null || (zbVarTt = aVar.tt(c(mdVar))) == null) {
            return;
        }
        zbVarTt.c();
    }

    @Override // com.byazt.yj.yv
    public yp from(md mdVar) {
        String cacheDir = mdVar.getCacheDir();
        String name = mdVar.getName();
        yp ypVarFrom = new com.byazt.oz.ve.tt(this.loadFactory).from(name);
        ypVarFrom.key(com.byazt.in.c.c(cacheDir, name));
        ypVarFrom.cacheDir(cacheDir);
        ypVarFrom.cache(c(mdVar));
        return ypVarFrom;
    }

    private tt c(final md mdVar) {
        return new tt() { // from class: com.byazt.yj.nb.1
            @Override // com.byazt.yj.tt
            public File getCacheDir() {
                return new File(mdVar.getCacheDir());
            }

            @Override // com.byazt.yj.tt
            public long getFileCacheSize() {
                return 0L;
            }

            @Override // com.byazt.yj.tt
            public int getMemoryCacheSize() {
                return mdVar.getMemoryCacheSize();
            }

            @Override // com.byazt.yj.tt
            public int getRawMemoryCacheSize() {
                return mdVar.getRawCacheSize();
            }

            @Override // com.byazt.yj.tt
            public boolean isDiskCache() {
                return false;
            }

            @Override // com.byazt.yj.tt
            public boolean isMemoryCache() {
                return mdVar.getMemoryCacheSize() > 0;
            }

            @Override // com.byazt.yj.tt
            public boolean isQueryAll() {
                return false;
            }

            @Override // com.byazt.yj.tt
            public boolean isRawMemoryCache() {
                return mdVar.getRawCacheSize() > 0;
            }
        };
    }
}
