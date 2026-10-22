package com.fl.saas.adx.base.manager.loader;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.C1407f;
import com.fl.saas.C1415j;
import com.fl.saas.C1428p0;
import com.fl.saas.H0;
import com.fl.saas.I0;
import com.fl.saas.J0;
import com.fl.saas.O0;
import com.fl.saas.P0;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bean.MaterialBean;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.manager.api.FailedLoader;
import com.fl.saas.adx.base.manager.api.ManagerInfoAPI;
import com.fl.saas.adx.base.manager.api.ManagerLoader;
import com.fl.saas.adx.base.manager.loader.BaseLoader;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.b1;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseLoader<T extends AdapterAPI> implements ManagerInfoAPI, FailedLoader {
    private boolean isHot = false;
    private String key;
    private int mAdType;
    private AdapterAPI mAdapter;

    @NonNull
    protected ManagerLoader<T> mLoader;
    private long trafficStartTime;

    public BaseLoader(@NonNull ManagerLoader<T> managerLoader, int i) {
        this.mLoader = managerLoader;
        this.mAdType = i;
    }

    private C1428p0 getValidAdSource() {
        return getValidAdapter().a(new Function() { // from class: com.zj.adlib.po0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((AdapterAPI) obj).getAdSource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AdInfo lambda$getAdInfo$1(C1415j c1415j) {
        return AdInfo.create(c1415j.p, c1415j.q, c1415j.j, c1415j.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$getValidAdapter$0(AdapterAPI adapterAPI) {
        try {
            return this.mAdapter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        AdapterAPI adapterAPI = this.mAdapter;
        if (adapterAPI instanceof BiddingResult) {
            ((BiddingResult) adapterAPI).biddingResult(z, i, i2, 0);
        }
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerInfoAPI
    public void destroy() {
        AdapterAPI adapterAPI = this.mAdapter;
        if (adapterAPI != null) {
            adapterAPI.destroy();
        }
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerInfoAPI
    public AdInfo getAdInfo() {
        return (AdInfo) getValidAdSource().a(new Function() { // from class: com.zj.adlib.ho0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return BaseLoader.lambda$getAdInfo$1((C1415j) obj);
            }
        }).b(new b1() { // from class: com.zj.adlib.jo0
            @Override // com.fl.saas.b1
            public final Object a() {
                return AdInfo.createEmpty();
            }
        });
    }

    @Override // com.fl.saas.adx.base.manager.api.ManagerInfoAPI
    public int getEcpm() {
        return ((Integer) getValidAdSource().a(new Function() { // from class: com.zj.adlib.no0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((C1415j) obj).c());
            }
        }).c(0)).intValue();
    }

    public MaterialBean getMaterial() {
        MaterialBean materialBean = new MaterialBean();
        AdapterAPI adapterAPI = this.mAdapter;
        if (adapterAPI != null) {
            adapterAPI.setMaterial(materialBean);
        }
        return materialBean;
    }

    public String getReqId() {
        return (String) getValidAdSource().a(new Function() { // from class: com.zj.adlib.fo0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((C1415j) obj).g;
            }
        }).c("");
    }

    public AdapterAPI getShowAdapter() {
        return this.mAdapter;
    }

    public C1428p0 getValidAdapter() {
        return C1428p0.b(this.mAdapter).a(new Function() { // from class: com.zj.adlib.lo0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f43111a.lambda$getValidAdapter$0((AdapterAPI) obj);
            }
        });
    }

    @Override // com.fl.saas.adx.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.mLoader.isFailedCallBack();
    }

    public void loadAdapter(AdapterAPI adapterAPI) {
        LogcatUtil.d("FLSDK-API", "loadAdapter");
        if (adapterAPI != null) {
            try {
                if (this.mLoader.getContext() != null) {
                    adapterAPI.setHot(this.isHot);
                    adapterAPI.setPlaceId(this.key);
                    adapterAPI.setContext(this.mLoader.getContext());
                    adapterAPI.setLinkId(this.mLoader.getLinkId());
                    this.mLoader.bindAdapter(adapterAPI);
                    adapterAPI.load();
                    LogcatUtil.d("FLSDK-API", TrackLoadSettingsAtom.TYPE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loadConfig() {
        AdapterAPI o0;
        this.trafficStartTime = System.currentTimeMillis();
        int i = this.mAdType;
        if (i == 1) {
            o0 = new P0();
        } else if (i == 2) {
            o0 = new H0();
        } else if (i == 3) {
            o0 = new I0();
        } else {
            if (i != 5) {
                if (i == 10) {
                    J0 j0 = new J0();
                    j0.a(DeviceUtil.appId, this.key);
                    j0.setLinkId(this.mLoader.getLinkId());
                    j0.a(this.isHot);
                    C1407f c1407f = new C1407f(j0);
                    this.mAdapter = c1407f;
                    loadAdapter(c1407f);
                    return;
                }
                return;
            }
            o0 = new O0();
        }
        this.mAdapter = o0;
        loadAdapter(o0);
    }

    @Override // com.fl.saas.adx.base.manager.api.FailedLoader
    public void onAdFailed(FLError fLError) {
        this.mLoader.onAdFailed(fLError);
    }

    @Override // com.fl.saas.adx.base.interfaces.AdLoadEvent
    public void onLoadFailed(FLError fLError) {
        this.mLoader.onLoadFailed(fLError);
    }

    public void request(String str) {
        this.key = str;
        LogcatUtil.d("FLSDK-API", "请求的: appId:" + DeviceUtil.appId + "   posId:" + str);
        loadConfig();
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }
}
