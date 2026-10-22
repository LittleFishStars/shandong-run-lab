package com.kc.dw.platform;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.IAdEventListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.kc.dw.platform.custom.ca.listener.IAdapterChangeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class BasePlatformLoader<Loader extends a, LoaderListener extends IAdEventListener> implements b<Loader> {
    public Loader adLoader;
    private IAdapterChangeListener changeListener;
    public com.kc.dw.core.loader.concurrent.b conCurrentListener;
    public Context context;
    private int groupIndex;
    private boolean isChangeAdapter;
    public IAdEventListener loadListener;
    public b next;
    private SsdAdSlot qzxAdSlot;
    public SdkAdInfo sdkAdInfo;
    public Map<String, Object> localParams = new HashMap();
    private int index = -1;

    @Keep
    public static class InitMonitorCallback implements CustomInitLoader.InitCallback {
        private String acceptId;
        private AdType adType;
        private long allTimes;
        private final CustomInitLoader.InitCallback callback;
        private LinkedHashMap eventTimes;
        private String pid;
        private String platform;
        private String reqId;

        public InitMonitorCallback(String str, SdkAdInfo sdkAdInfo, CustomInitLoader.InitCallback initCallback, a aVar) {
            this.allTimes = -1L;
            this.platform = str;
            this.acceptId = sdkAdInfo != null ? sdkAdInfo.getAccept_id() : null;
            if (sdkAdInfo != null && sdkAdInfo.getAppendInfo() != null) {
                this.eventTimes = sdkAdInfo.getAppendInfo().getEventTimes(com.kc.dw.core.service.logrecord.b.a(sdkAdInfo));
                this.allTimes = sdkAdInfo.getAppendInfo().getCurAllTimes();
                this.reqId = sdkAdInfo.getAppendInfo().getCurReqId();
            }
            this.callback = initCallback;
            if (aVar != null) {
                this.pid = aVar.getPosId();
                this.adType = aVar.getAdType();
            }
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void fail() {
            com.kc.dw.core.service.logrecord.a.a(this.eventTimes, 10, "adn_init_fail", this.acceptId, this.pid, this.adType, this.allTimes, this.reqId);
            CustomInitLoader.InitCallback initCallback = this.callback;
            if (initCallback != null) {
                initCallback.fail();
            }
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void succ() {
            CustomInitLoader.InitCallback initCallback = this.callback;
            if (initCallback != null) {
                initCallback.succ();
            }
        }
    }

    @Override // com.kc.dw.core.loader.b
    public void destroy() {
        com.kc.dw.core.service.logrecord.a.a(10, "call_destroy", this);
    }

    @Override // com.kc.dw.core.loader.b
    public Loader getAdLoader() {
        return this.adLoader;
    }

    public SsdAdSlot getChangeAdSlot() {
        return this.qzxAdSlot;
    }

    public IAdapterChangeListener getChangeListener() {
        return this.changeListener;
    }

    public com.kc.dw.core.loader.concurrent.b getConCurrentListener() {
        return this.conCurrentListener;
    }

    @Override // com.kc.dw.core.loader.b
    public Context getContext() {
        return this.context;
    }

    public HashMap<String, Object> getExtraMap() {
        return null;
    }

    public int getGroupIndex() {
        return this.groupIndex;
    }

    public boolean getIsChangeAdapter() {
        return this.isChangeAdapter;
    }

    public IAdEventListener getLoaderListener() {
        return this.loadListener;
    }

    public Map<String, Object> getLocalParams() {
        return this.localParams;
    }

    public String getPlatform() {
        try {
            SdkAdInfo sdkAdInfo = this.sdkAdInfo;
            if (sdkAdInfo == null || TextUtils.isEmpty(sdkAdInfo.getInitCls())) {
                return "";
            }
            CustomInitLoader initLoader = CustomFactory.getInitLoader(this.sdkAdInfo.getInitCls());
            return initLoader != null ? initLoader.getPlatform() : this.sdkAdInfo.getSdk();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.kc.dw.core.loader.b
    public SdkAdInfo getSdkAdInfo() {
        return this.sdkAdInfo;
    }

    public int getTag() {
        return this.index;
    }

    @Override // com.kc.dw.core.loader.b
    public void init(Loader loader, SdkAdInfo sdkAdInfo) {
        this.adLoader = loader;
        this.sdkAdInfo = sdkAdInfo;
        this.context = loader.getContext();
        this.loadListener = loader.getLoaderListener();
    }

    public void initADN(CustomInitLoader.InitCallback initCallback) {
        if ("SSD".equals(this.sdkAdInfo.getSdk()) && initCallback != null) {
            initCallback.succ();
            return;
        }
        SdkAdInfo sdkAdInfo = this.sdkAdInfo;
        if (sdkAdInfo == null || TextUtils.isEmpty(sdkAdInfo.getInitCls())) {
            if (initCallback != null) {
                initCallback.fail();
                return;
            }
            return;
        }
        SdkAdInfo sdkAdInfo2 = this.sdkAdInfo;
        if (sdkAdInfo2 == null || TextUtils.isEmpty(sdkAdInfo2.getInitCls())) {
            return;
        }
        try {
            String initCls = TextUtils.isEmpty(null) ? this.sdkAdInfo.getInitCls() : null;
            if (TextUtils.isEmpty(initCls)) {
                if (initCallback != null) {
                    initCallback.fail();
                    return;
                }
                return;
            }
            CustomInitLoader initLoader = CustomFactory.getInitLoader(initCls);
            if (initLoader == null) {
                Constructor<?> constructor = Class.forName(this.sdkAdInfo.getInitCls()).getConstructor(new Class[0]);
                constructor.setAccessible(true);
                initLoader = (CustomInitLoader) constructor.newInstance(new Object[0]);
                CustomFactory.putInitLoader(initCls, initLoader);
            }
            initLoader.setInitCallback(new InitMonitorCallback(initLoader.getPlatform(), this.sdkAdInfo, initCallback, getAdLoader()));
            if (initLoader.getInitStatus() && initCallback != null) {
                initCallback.succ();
            } else {
                com.kc.dw.core.service.logrecord.a.a(10, "adn_init_start", this);
                initLoader.init(this.sdkAdInfo.getApp_id(), this.sdkAdInfo.getApp_key(), this.localParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (initCallback != null) {
                initCallback.fail();
            }
        }
    }

    public boolean isAutoRender() {
        if (getAdLoader() == null || getAdLoader().getAdSlot() == null) {
            return true;
        }
        return getAdLoader().getAdSlot().isAutoRender();
    }

    public boolean isMSPlatform() {
        return "SSD".equals(getPlatform());
    }

    @Override // com.kc.dw.core.loader.b
    public abstract /* synthetic */ void loadAd();

    public b next() {
        return this.next;
    }

    public void sendGdtWinResult(boolean z, int i) {
    }

    public void setAdapterChangeListener(IAdapterChangeListener iAdapterChangeListener) {
        this.changeListener = iAdapterChangeListener;
    }

    public void setChangeAdSlot(SsdAdSlot ssdAdSlot) {
        this.qzxAdSlot = ssdAdSlot;
    }

    @Override // com.kc.dw.core.loader.b
    public void setConCurrentLoadListener(com.kc.dw.core.loader.concurrent.b bVar) {
        this.conCurrentListener = bVar;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override // com.kc.dw.core.loader.b
    public void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    public void setIsChangeAdapter(boolean z) {
        this.isChangeAdapter = z;
    }

    @Override // com.kc.dw.core.loader.b
    public void setLocalParams(Map<String, Object> map) {
        this.localParams = map;
    }

    public void setNext(b bVar) {
        this.next = bVar;
    }

    public void setSdkAdInfo(SdkAdInfo sdkAdInfo) {
        this.sdkAdInfo = sdkAdInfo;
    }

    public void setTag(int i) {
        this.index = i;
    }
}
