package com.fl.saas.base.base;

import android.os.Handler;
import android.os.Looper;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.base.interfaces.AdReRequestListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.util.ReflectHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.ConfigUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.ydsdk.api.MediaExtraInfo;
import com.fl.saas.ydsdk.manager.YdConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseAPI<T extends BaseBuilder<?>, S extends BuilderLoadManager<T, ?, ?>> implements MediaExtraInfo {
    protected final T builder;
    protected S manager;

    public BaseAPI(T t) {
        this.builder = t;
    }

    private S createManager() {
        API api = (API) ReflectHelper.getSupperAnnotations(API.class, getClass());
        if (api == null) {
            return null;
        }
        return (S) api.value().createManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reRequest$1() {
        S s = this.manager;
        if (s == null || s.isDestroy()) {
            return;
        }
        this.manager.selectBottomAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$0() {
        S s = this.manager;
        if (s == null || s.isDestroy()) {
            return;
        }
        this.manager.selectBottomAd();
    }

    private void loadFailed(YdError ydError) {
        T t = this.builder;
        if (t instanceof AdLoadEvent) {
            ((AdLoadEvent) t).onLoadFailed(ydError);
        } else {
            t.onAdFailed(ydError);
        }
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
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

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public AdInfo getAdInfo() {
        S s = this.manager;
        if (s == null) {
            return null;
        }
        return s.getAdInfo();
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
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

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        S s = this.manager;
        return s == null ? "" : s.getMaterialJson();
    }

    public String getReqId() {
        AdPlace adPlace;
        S s = this.manager;
        return (s == null || (adPlace = s.getAdPlace()) == null) ? "" : adPlace.req_id;
    }

    public void reRequest() {
        String str;
        try {
            if (!YdConfig.isInit()) {
                loadFailed(YdError.create(20402, "Please initialize the SDK first"));
                return;
            }
            T t = this.builder;
            if (t != null && ConfigUtils.checkImpressFreq(t.getKey())) {
                loadFailed(YdError.create(20406, "Request too frequently"));
                return;
            }
            ReportHelper.getInstance().reportSDKInit();
            T t2 = this.builder;
            if (t2 != null && t2.isValid() && this.builder.getTimeout() >= 1000) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.vm0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f45383a.lambda$reRequest$1();
                    }
                }, this.builder.getTimeout() - 20);
            }
            if ("0".equals(DeviceUtil.getNetworkType())) {
                loadFailed(YdError.create(20403, "无网络连接"));
                return;
            }
            if (this.manager == null) {
                this.manager = (S) createManager();
            }
            if (this.manager == null) {
                str = "manager create error: " + getClass().getSimpleName();
            } else {
                if (this.builder.isValid()) {
                    this.manager.request(this.builder);
                    return;
                }
                str = "builder is invalid";
            }
            loadFailed(YdError.create(20410, str));
        } catch (Exception e) {
            e.printStackTrace();
            loadFailed(YdError.create(20410, "request has error" + e.getMessage()));
        }
    }

    public void request() {
        String str;
        try {
            if (!YdConfig.isInit()) {
                loadFailed(YdError.create(20402, "Please initialize the SDK first"));
                return;
            }
            T t = this.builder;
            if (t != null && ConfigUtils.checkImpressFreq(t.getKey())) {
                loadFailed(YdError.create(20406, "Request too frequently,Please check if the advertising space has frequency control set up."));
                return;
            }
            ReportHelper.getInstance().reportSDKInit();
            T t2 = this.builder;
            if (t2 != null && t2.isValid() && this.builder.getTimeout() >= 1000) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.xm0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f45848a.lambda$request$0();
                    }
                }, this.builder.getTimeout() - 20);
            }
            if ("0".equals(DeviceUtil.getNetworkType())) {
                loadFailed(YdError.create(20403, "无网络连接"));
                return;
            }
            S s = (S) createManager();
            this.manager = s;
            if (s != null) {
                s.setAdReRequestListener(new AdReRequestListener() { // from class: com.zj.adlib.zm0
                    @Override // com.fl.saas.base.interfaces.AdReRequestListener
                    public final void onReRequest() {
                        this.f46291a.reRequest();
                    }
                });
                if (this.builder.isValid()) {
                    this.manager.request(this.builder);
                    return;
                }
                str = "builder is invalid";
            } else {
                str = "manager create error: " + getClass().getSimpleName();
            }
            loadFailed(YdError.create(20410, str));
        } catch (Exception e) {
            e.printStackTrace();
            loadFailed(YdError.create(20410, "request has error" + e.getMessage()));
        }
    }
}
