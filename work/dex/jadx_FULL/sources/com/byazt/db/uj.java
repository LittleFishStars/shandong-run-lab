package com.byazt.db;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 734, 15})
public abstract class uj extends com.byazt.yl.ve {
    public com.byazt.dv.c i;
    public Function<SparseArray<Object>, Object> x;

    public uj(com.byazt.dv.c cVar) {
        this.i = cVar;
    }

    public static Integer isReadyStatus(Function<SparseArray<Object>, Object> function) {
        Integer numC;
        if (function == null || (numC = com.byazt.sq.c.c(function.apply(com.byazt.yxi.uj.c().c(8121).c(20068, 1).c(Object.class).tt()))) == null) {
            return 1;
        }
        return numC;
    }

    @Override // com.byazt.yl.ve, com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8128) {
            this.x = (Function) pluginValueSet.objectValue(8035, Function.class);
        } else if (i == 8208) {
            String strStringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(strStringValue)) {
                setLevelTag(strStringValue);
            }
        } else if (i == 8209) {
            setImageMode(pluginValueSet.intValue(8060));
        } else if (i == 8140) {
            setInteractionType(pluginValueSet.intValue(8059));
        }
        return (T) callMethod(i, pluginValueSet, cls);
    }

    @Override // com.byazt.yl.ve
    public void bidLoseNotify(Map<String, Object> map) {
        if (isClientBiddingAd() && this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8144).c(Void.class).c(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void bidWinNotify(Map<String, Object> map) {
        if (isClientBiddingAd() && this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8142).c(Void.class).c(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).tt());
        }
    }

    public abstract <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // com.byazt.yl.ve
    public long getAdId() {
        if (this.x == null) {
            return super.getAdId();
        }
        Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8246).c(Long.class).tt());
        if (objApply instanceof Long) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.yl.ve
    public long getCreativeId() {
        if (this.x == null) {
            return super.getCreativeId();
        }
        Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8245).c(Long.class).tt());
        if (objApply instanceof Long) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.yl.ve
    public Map<String, Object> getMediaExtraInfo() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8239).c(Map.class).tt());
            setMediaExtraInfo(objApply instanceof Map ? (Map) objApply : null);
        }
        return super.getMediaExtraInfo();
    }

    @Override // com.byazt.yl.ve
    public boolean hasDestroyed() {
        if (this.x == null) {
            return false;
        }
        this.x.apply(com.byazt.yxi.uj.c().c(8120).c(Boolean.class).tt());
        return false;
    }

    public boolean isClientBidding() {
        com.byazt.dv.c cVar = this.i;
        if (cVar != null) {
            return cVar.c();
        }
        return false;
    }

    @Override // com.byazt.yl.ve
    public void onDestroy() {
        super.onDestroy();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8109).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void onPause() {
        super.onPause();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8149).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void onResume() {
        super.onResume();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8148).c(Void.class).tt());
        }
    }
}
