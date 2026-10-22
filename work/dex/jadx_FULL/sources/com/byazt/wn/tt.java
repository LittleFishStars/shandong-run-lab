package com.byazt.wn;

import android.content.Context;
import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 13})
public abstract class tt extends com.byazt.sp.tt {
    public static final int CLICK_TIMES = 60;
    public static final int SHOW_TIMES = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29164a;
    public String da;
    public String i;
    public Map<String, Object> n;
    public com.byazt.ll.tt sl;
    public int sp;
    public com.byazt.ih.ve tt;
    public com.byazt.dv.tt uj;
    public Function<SparseArray<Object>, Object> ve;
    public int x;

    public tt(String str, com.byazt.db.tt ttVar) {
        super(ttVar);
        this.n = new ConcurrentHashMap();
        this.f29164a = false;
        this.sp = 0;
        this.x = 0;
        this.da = str;
    }

    @Override // com.byazt.sp.tt, com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8221) {
            this.ve = (Function) pluginValueSet.objectValue(8405, Function.class);
        } else {
            if (i == 8137) {
                T t = (T) getAdm();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom loader : getAdm = ".concat(String.valueOf(t)));
                return t;
            }
            if (i == 8224) {
                T t2 = (T) getExtraDataNoParse();
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t2)));
                return t2;
            }
            if (i == 8226) {
                T t3 = (T) Integer.valueOf(getBiddingType());
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom loader : getBiddingType = ".concat(String.valueOf(t3)));
                return t3;
            }
            if (i == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                setExtraInfo(map);
            }
        }
        return (T) callManager(i, pluginValueSet, cls);
    }

    public void c(com.byazt.yl.ve veVar, double d, Map<String, Object> map) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE && getBiddingType() == 1) {
            veVar.setCpm(d);
        }
        if (map != null) {
            this.n.putAll(map);
        }
        veVar.putExtraMsg(this.n);
        notifyLoadSuccess(veVar);
    }

    public void callLoaderFail(int i, String str) {
        notifyLoadFail(new com.byazt.pp.c(i, str));
    }

    public abstract <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public final void checkClick(com.byazt.ylx.c.InterfaceC0587c interfaceC0587c) {
        int i = this.x;
        if (i >= 60) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.x = i + 1;
        if (interfaceC0587c != null) {
            interfaceC0587c.c();
        }
    }

    public final void checkLoadSuccess(com.byazt.ylx.c.InterfaceC0587c interfaceC0587c) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0587c != null) {
            interfaceC0587c.c();
        }
    }

    public final void checkShow(com.byazt.ylx.c.InterfaceC0587c interfaceC0587c) {
        if (!this.f29164a) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
            return;
        }
        int i = this.sp;
        if (i >= 2) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        this.sp = i + 1;
        if (interfaceC0587c != null) {
            interfaceC0587c.c();
        }
    }

    public String getAdm() {
        com.byazt.dv.tt ttVar = this.uj;
        return ttVar != null ? ttVar.zm() : "";
    }

    public int getBiddingType() {
        com.byazt.dv.tt ttVar = this.uj;
        if (ttVar != null) {
            return ttVar.my();
        }
        return 0;
    }

    public Object getExtraDataNoParse() {
        com.byazt.dv.tt ttVar = this.uj;
        return ttVar != null ? ttVar.qp() : "";
    }

    @Override // com.byazt.db.c
    public String getSdkVersion(String str) {
        return this.i;
    }

    public Integer isReadyStatus() {
        if (this.ve == null) {
            return 1;
        }
        Integer numC = com.byazt.sq.c.c(this.ve.apply(com.byazt.yxi.uj.c().c(8121).c(Object.class).c(20068, 1).tt()));
        if (numC == null) {
            return 1;
        }
        return numC;
    }

    public void mediationCallShow() {
        this.f29164a = true;
    }

    @Override // com.byazt.sp.tt
    public void notifyLoadSuccess(com.byazt.yl.ve veVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(veVar);
        notifyLoadSuccess(arrayList);
    }

    public void onDestroy() {
        if (this.ve != null) {
            this.ve.apply(com.byazt.yxi.uj.c().c(8109).c(Void.class).tt());
        }
    }

    public void onPause() {
        if (this.ve != null) {
            this.ve.apply(com.byazt.yxi.uj.c().c(8149).c(Void.class).tt());
        }
    }

    public void onResume() {
        if (this.ve != null) {
            this.ve.apply(com.byazt.yxi.uj.c().c(8148).c(Void.class).tt());
        }
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        if (this.ve != null) {
            this.ve.apply(com.byazt.yxi.uj.c().c(8225).c(Void.class).c(8406, Boolean.valueOf(z)).c(8407, Double.valueOf(d)).c(8408, Integer.valueOf(i)).c(8075, map).tt());
        }
    }

    public void setExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.n.clear();
            this.n.putAll(map);
        }
    }

    @Override // com.byazt.sp.tt
    public final void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        this.uj = ttVar;
        this.sl = ttVar2;
        this.tt = new com.byazt.ih.ve(ttVar.qy(), ttVar.t(), ttVar.yp(), ttVar.z(), ttVar.cu());
        com.byazt.id.c cVarC = com.byazt.px.c.c(ttVar.u());
        this.i = cVarC != null ? cVarC.getNetworkSdkVersion() : "";
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.byazt.tjo.tt.c() >= 5900) {
            ujVarC.c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.eu.c.c(context));
        } else {
            ujVarC.c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.da);
        ujVarC.c(8546, com.byazt.lq.uj.c(this.tt.c()));
        if (ttVar2.qp() != null) {
            ujVarC.c(8548, com.byazt.lq.uj.c(ttVar2.qp()));
        }
        Function<SparseArray<Object>, Object> functionA = com.byazt.vq.c.c().a();
        if (functionA == null) {
            notifyLoadFail(new com.byazt.pp.c("Adn custom class loader is null"));
            return;
        }
        ujVarC.c(Void.class);
        ujVarC.c(8106);
        functionA.apply(ujVarC.tt());
    }

    @Override // com.byazt.sp.tt, com.byazt.db.tt
    public void notifyLoadSuccess(List<com.byazt.yl.ve> list) {
        for (com.byazt.yl.ve veVar : list) {
            veVar.setMediaExtraInfo(this.n);
            veVar.setAdType(this.uj.yv());
        }
        super.notifyLoadSuccess(list);
    }
}
