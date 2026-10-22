package com.fl.saas.base.adapter.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.base.adapter.AdViewAdapter;
import com.fl.saas.base.adapter.base.BaseAdAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bean.MaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.zj.adlib.hx5;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseAdAdapter<S extends AdViewListener> implements AdapterAPI, ReportEventListener {

    @Nullable
    private WeakReference<Activity> activityRef;

    @Nullable
    private AdViewAdapter mAdAdapter;
    private AdMaterial.AdMaterialData mAdMaterialData;
    protected AdSource mAdSource;
    private WeakReference<Context> mContextRef;
    private long reqTime;
    private final String TAG = CommConstant.getObjTag(this);
    private boolean hasDestroy = false;
    private boolean isCache = false;
    public boolean isSelect = false;
    private boolean isFailedCallBack = false;
    private boolean hasRequest = false;
    private boolean isReportExposure = false;

    public BaseAdAdapter() {
        createAdapter();
    }

    private void createAdapter() {
        if (this.mAdAdapter == null) {
            this.mAdAdapter = new AdViewAdapter();
        }
        AdSource adSource = this.mAdSource;
        if (adSource != null) {
            this.mAdAdapter.biddingRestAdSource(adSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getActivityValid$0(Activity activity) {
        return !activity.isFinishing();
    }

    private void loadSuccessEvent() {
        LogcatUtil.d(this.TAG, "onLoadedEvent");
        this.mAdSource.responseTime = DeviceUtil.getBootTime() - this.reqTime;
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.onSuccess(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void priceLow() {
        if (this instanceof BiddingResult) {
            ((BiddingResult) this).biddingResult(false, this.mAdSource.bidfloor, 0, 0);
        }
        disposeError(new YdError(11000, "Bid below reserve price"));
    }

    private void reportMaterial() {
        AdMaterial.AdMaterialData materialData;
        if (!DeviceUtil.isContainMaterial(getAdSource().adv_id) || (materialData = getMaterialData()) == null) {
            return;
        }
        AdHttpUtils.getInstance().doPost(CommConstant.API.REPORT_MATERIAL, AdHttpUtils.reqObjToStr(new MaterialBean(getAdSource(), materialData)), new HttpCallbackStringListener() { // from class: com.fl.saas.base.adapter.base.BaseAdAdapter.1
            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onError(Exception exc) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onJump(String str) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackStringListener
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    BaseAdAdapter.this.mAdSource.creative_id = jSONObject.optString("creative_id");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void bindC2SBidECPM(Supplier<Integer> supplier) {
        int iIntValue;
        if (!getAdSource().isC2SBidAd || supplier == null) {
            return;
        }
        try {
            iIntValue = supplier.get().intValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogcatUtil.e(this.TAG, "bindC2SBidECPM is exception, " + getAdSource());
            iIntValue = 0;
        }
        setECPM(iIntValue);
    }

    public boolean canUseEcpm() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.canUseEcpm();
        }
        return true;
    }

    public boolean changeReRequestCount() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.changeReRequestCount();
        }
        return false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void clearCache() {
        this.isCache = false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        if (isCache()) {
            return;
        }
        this.hasDestroy = true;
        this.mContextRef = null;
        this.activityRef = null;
    }

    public void disposeError(ErrorInfo errorInfo) {
        LogcatUtil.d(this.TAG, "disposeError:" + errorInfo);
        if (this.isSelect && !this.isFailedCallBack) {
            this.isFailedCallBack = true;
            onAdFailed(YdError.create(errorInfo.code, errorInfo.errorType, errorInfo.msg));
        }
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.onFailed(this, errorInfo);
        }
    }

    public void disposeError(YdError ydError) {
        LogcatUtil.d(this.TAG, "disposeError: " + ydError);
        if (this.isSelect) {
            if (this.isFailedCallBack) {
                return;
            }
            this.isFailedCallBack = true;
            onAdFailed(ydError);
            return;
        }
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.adv_id = this.mAdSource.adv_id + "";
        errorInfo.tagid = this.mAdSource.tagid;
        errorInfo.code = ydError.getCode();
        errorInfo.errorType = ydError.getErrorType();
        errorInfo.msg = ydError.getMsg();
        disposeError(errorInfo);
    }

    @Nullable
    public Activity getActivityOrNull() {
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Optional<Activity> getActivityValid() {
        return Optional.ofNullable(this.activityRef).map(new hx5()).filter(new Predicate() { // from class: com.zj.adlib.cn0
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return BaseAdAdapter.lambda$getActivityValid$0((Activity) obj);
            }
        });
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    @NonNull
    public AdSource getAdSource() {
        return this.mAdSource;
    }

    public String getAppId() {
        return getAdSource().app_id;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        Context topActivity = weakReference != null ? weakReference.get() : null;
        if (topActivity == null) {
            topActivity = DeviceUtil.getTopActivity();
        }
        return topActivity == null ? DeviceUtil.getContext() : topActivity;
    }

    public String getExt() {
        return this.mAdSource.getExt();
    }

    public abstract String getKey();

    /* JADX WARN: Multi-variable type inference failed */
    public AdMaterial.AdMaterialData getMaterialData() {
        AdMaterial.AdMaterialData adMaterialData = this.mAdMaterialData;
        if (adMaterialData != null) {
            return adMaterialData;
        }
        if (this instanceof AdMaterial) {
            this.mAdMaterialData = ((AdMaterial) this).getAdMaterialData();
        }
        return this.mAdMaterialData;
    }

    public String getPosId() {
        return getAdSource().tagid;
    }

    public WinAdInfo getWinInfo() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.getWinInfo();
        }
        return null;
    }

    public abstract void handle(Activity activity);

    @Override // com.fl.saas.base.base.AdapterAPI
    public boolean isCache() {
        return this.isCache;
    }

    public boolean isCheckActivity() {
        return true;
    }

    public boolean isFullScreenInterstitial() {
        return getAdSource().isFullScreenInterstitial();
    }

    public boolean isHasDestroy() {
        return this.hasDestroy;
    }

    public boolean isReRequest() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            return adViewAdapter.isReRequest();
        }
        return false;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void load() {
        try {
            Activity activityOrNull = getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            WeakReference<Context> weakReference = this.mContextRef;
            if (weakReference == null || weakReference.get() == null || (isCheckActivity() && activityOrNull == null)) {
                onAdFailed(YdError.create(20404, "adapter is not ready, context exception"));
                return;
            }
            long bootTime = DeviceUtil.getBootTime();
            this.reqTime = bootTime;
            AdSource adSource = this.mAdSource;
            if (adSource != null) {
                adSource.reqTime = bootTime;
            }
            onRequest();
            handle(activityOrNull);
        } catch (Exception e) {
            e.printStackTrace();
            onAdFailed(YdError.create(20404, "adapter is not ready, context exception"));
        }
    }

    public abstract void onAdFailed(YdError ydError);

    public void onClickedEvent() {
        LogcatUtil.d(this.TAG, "onClickedEvent");
        QuickAppHelper.getInstance().setAdSource(this.mAdSource);
        ReportHelper.getInstance().reportClick(this.mAdSource);
        AdSource adSource = this.mAdSource;
        if (adSource != null) {
            adSource.hasClickCallBack = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r0.price >= r0.bidfloor) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLoadedEvent() {
        AdSource adSource = this.mAdSource;
        if (adSource == null) {
            return;
        }
        if (adSource.isC2SBidAd || adSource.isSDKBidAd) {
            if (adSource.price > 0) {
                if (adSource.isFilterBidFloor()) {
                    AdSource adSource2 = this.mAdSource;
                }
            }
            priceLow();
            return;
        }
        loadSuccessEvent();
    }

    public void onRequest() {
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter == null || this.hasRequest) {
            return;
        }
        this.hasRequest = true;
        adViewAdapter.sendRequestMsg();
    }

    public void onShowEvent() {
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        LogcatUtil.d(this.TAG, "onShowEvent");
        ReportHelper.getInstance().reportDisplay(this.mAdSource);
        ReportHelper.getInstance().addShowAd(this.mAdSource);
        reportMaterial();
        ConfigHelper.getInstance().addShowCount();
    }

    @Override // com.fl.saas.base.base.AdapterAPI, com.fl.saas.base.adapter.base.ReportEventListener
    public void reportRequestShow() {
        ReportHelper.getInstance().reportRequestShow(this.mAdSource);
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setAdAdapter(@NonNull AdViewManager adViewManager) {
        createAdapter();
        AdViewAdapter adViewAdapter = this.mAdAdapter;
        if (adViewAdapter != null) {
            adViewAdapter.setAdViewManager(adViewManager);
        }
        return this;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setAdSource(@NonNull AdSource adSource) {
        if (this.isCache) {
            return this;
        }
        this.mAdSource = adSource;
        createAdapter();
        return this;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void setCache() {
        this.isCache = true;
        this.activityRef = null;
        this.mAdAdapter = null;
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public BaseAdAdapter<S> setContext(@NonNull Context context) {
        WeakReference<Context> weakReference;
        if (context instanceof Activity) {
            this.activityRef = new WeakReference<>((Activity) context);
            weakReference = new WeakReference<>(context.getApplicationContext());
        } else {
            weakReference = new WeakReference<>(context);
        }
        this.mContextRef = weakReference;
        return this;
    }

    public void setECPM(int i) {
        AdMaterial.AdMaterialData materialData;
        ReportHelper.Ucf ucf = ReportHelper.getInstance().getUcf(this.mAdSource.adv_id + "");
        if (ucf != null && ucf.getListUbx() != null && !ucf.getListUbx().isEmpty() && (materialData = getMaterialData()) != null && !TextUtils.isEmpty(materialData.getData())) {
            Iterator<String> it = ucf.getListUbx().iterator();
            while (it.hasNext()) {
                if (materialData.getData().contains(it.next())) {
                    int uvr = ((100 - ucf.getUvr()) * i) / 100;
                    this.mAdSource.price = Math.max(i, 0);
                    this.mAdSource.uqfPrice = Math.max(uvr, 0);
                    this.mAdSource.uqf = 1;
                    return;
                }
            }
        }
        this.mAdSource.price = Math.max(i, 0);
    }

    @Override // com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        if (this.isSelect) {
            LogcatUtil.d(this.TAG, "multiple show");
            return;
        }
        Activity activityOrNull = getActivityOrNull();
        if (activityOrNull == null) {
            activityOrNull = DeviceUtil.getTopActivity();
        }
        if (activityOrNull != null) {
            setContext((Context) activityOrNull);
        }
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference == null || weakReference.get() == null) {
            onAdFailed(YdError.create(20404, "context is null, context exception"));
        } else {
            this.isSelect = true;
            this.isCache = false;
        }
    }
}
