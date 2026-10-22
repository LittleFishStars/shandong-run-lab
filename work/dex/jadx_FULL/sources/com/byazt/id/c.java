package com.byazt.id;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.byazt.fb.uj;
import com.byazt.ih.tt;
import com.byazt.px.n;
import com.byazt.px.ve;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1583, 20})
public class c extends uj {
    public static final String ve = "TTMediationSDK_" + c.class.getSimpleName();
    public Function<SparseArray<Object>, Object> sp;
    public tt uj;
    public final AtomicBoolean n = new AtomicBoolean(false);
    public long c = 0;
    public int tt = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<SparseArray<Object>, Object> f28643a = ve.c(com.byazt.bp.c.t().cu()).c();

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8216) {
            this.sp = (Function) pluginValueSet.objectValue(8402, Function.class);
        } else if (i == 8219) {
            callInitSuccess();
        } else {
            if (i == 8220) {
                return (T) Boolean.valueOf(isInit());
            }
            if (i == 8270) {
                long jLongValue = pluginValueSet.longValue(8073);
                this.tt = pluginValueSet.intValue(8557);
                this.c = jLongValue;
            }
        }
        return (T) com.byazt.hf.c.c(cls);
    }

    public final void callInitSuccess() {
        this.n.set(true);
    }

    public void clearInitStatus() {
        this.tt = 0;
        this.c = 0L;
    }

    public String getAdapterSdkVersion() {
        return "0.0";
    }

    @Nullable
    public String getBiddingToken(Context context, Map<String, Object> map) {
        if (this.sp == null) {
            return null;
        }
        Object objApply = this.sp.apply(com.byazt.yxi.uj.c().c(8139).c(String.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(8075, map).tt());
        return objApply instanceof String ? (String) objApply : "";
    }

    public String getNetworkSdkVersion() {
        if (this.sp == null) {
            return null;
        }
        Object objApply = this.sp.apply(com.byazt.yxi.uj.c().c(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel).c(String.class).tt());
        return objApply instanceof String ? (String) objApply : "";
    }

    @Nullable
    public String getSdkInfo(Context context, Map<String, Object> map) {
        if (this.sp == null) {
            return null;
        }
        Object objApply = this.sp.apply(com.byazt.yxi.uj.c().c(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue).c(String.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(8075, map).tt());
        return objApply instanceof String ? (String) objApply : "";
    }

    public long initDuration() {
        return this.c;
    }

    public int initStatus() {
        return this.tt;
    }

    public void initializeADN(Context context, tt ttVar, Map<String, Object> map) {
        if (ttVar != null) {
            com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c().c(8100).c(Void.class).c(8089, com.byazt.bp.c.t().cu().sparseArray()).c(8545, com.byazt.lq.uj.c(ttVar.c())).c(8400, map).c(8401, this).c(8098, Boolean.TRUE);
            n.c(ujVarC);
            this.f28643a.apply(ujVarC.tt());
        }
    }

    public final void initializeInnerADN(Context context, tt ttVar, Map<String, Object> map) {
        this.n.set(false);
        this.uj = ttVar;
        initializeADN(context, ttVar, map);
    }

    public final boolean isInit() {
        return this.n.get();
    }
}
