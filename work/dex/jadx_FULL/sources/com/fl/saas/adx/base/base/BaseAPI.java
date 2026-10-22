package com.fl.saas.adx.base.base;

import com.fl.saas.A;
import com.fl.saas.C0;
import com.fl.saas.E0;
import com.fl.saas.adx.api.FLConfig;
import com.fl.saas.adx.api.MediaExtraInfo;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bean.MaterialBean;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdLoadEvent;
import com.fl.saas.adx.base.interfaces.AdReRequestListener;
import com.fl.saas.adx.base.manager.manager.BuilderLoadManager;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseAPI<T extends BaseBuilder<?>, S extends BuilderLoadManager<T, ?, ?>> implements MediaExtraInfo {
    protected final T builder;
    protected S manager;

    public BaseAPI(T t) {
        this.builder = t;
    }

    private S createManager() {
        API api = (API) C0.a(API.class, getClass());
        if (api == null) {
            return null;
        }
        return (S) api.value().createManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFailed$2(FLError fLError) {
        T t = this.builder;
        if (t instanceof AdLoadEvent) {
            ((AdLoadEvent) t).onLoadFailed(fLError);
        } else {
            t.onAdFailed(fLError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$0() {
        requestAd(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAd$1() {
        requestAd(false);
    }

    private void loadFailed(final FLError fLError) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.ym0
            @Override // java.lang.Runnable
            public final void run() {
                this.f46064a.lambda$loadFailed$2(fLError);
            }
        });
    }

    private void requestAd(boolean z) {
        String str;
        try {
            if (!FLConfig.isInit()) {
                loadFailed(FLError.create(20402, "Please initialize the SDK first"));
                return;
            }
            T t = this.builder;
            if (t != null && A.a(t.getKey())) {
                loadFailed(FLError.create(20406, "Request too frequently,Please check if the advertising space has frequency control set up."));
                return;
            }
            if ("0".equals(DeviceUtil.getNetworkType())) {
                loadFailed(FLError.create(20403, "无网络连接"));
                return;
            }
            E0.a().e();
            S s = (S) createManager();
            this.manager = s;
            if (s != null) {
                if (z) {
                    s.setAdReRequestListener(new AdReRequestListener() { // from class: com.zj.adlib.wm0
                        @Override // com.fl.saas.adx.base.interfaces.AdReRequestListener
                        public final void onReRequest() {
                            this.f45624a.lambda$requestAd$1();
                        }
                    });
                }
                if (this.builder.isValid()) {
                    this.manager.request(this.builder);
                    return;
                }
                str = "builder is invalid";
            } else {
                str = "manager create error: " + getClass().getSimpleName();
            }
            loadFailed(FLError.create(20410, str));
        } catch (Exception e) {
            e.printStackTrace();
            loadFailed(FLError.create(20410, "request has error" + e.getMessage()));
        }
    }

    @Override // com.fl.saas.adx.api.MediaExtraInfo
    public void biddingResultUpload(boolean z, int i, int i2) {
        S s = this.manager;
        if (s != null) {
            s.biddingResultUpload(z, i, i2);
        }
    }

    public void destroy() {
        S s = this.manager;
        if (s != null) {
            s.destroy();
        }
    }

    @Override // com.fl.saas.adx.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        S s = this.manager;
        if (s == null) {
            return null;
        }
        return s.getAdInfo();
    }

    @Override // com.fl.saas.adx.api.MediaExtraInfo
    public int getECPM() {
        S s = this.manager;
        if (s != null) {
            return s.getEcpm();
        }
        return 0;
    }

    public int getEcpm() {
        S s = this.manager;
        if (s != null) {
            return s.getEcpm();
        }
        return 0;
    }

    public MaterialBean getMaterial() {
        S s = this.manager;
        return s == null ? new MaterialBean() : s.getMaterial();
    }

    public String getReqId() {
        S s = this.manager;
        if (s == null) {
            return "";
        }
        s.getReqId();
        return "";
    }

    public void request() {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.an0
            @Override // java.lang.Runnable
            public final void run() {
                this.f40558a.lambda$request$0();
            }
        });
    }
}
