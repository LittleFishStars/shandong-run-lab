package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.AbstractC1423n;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.bean.MaterialBean;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdMaterial;
import com.fl.saas.adx.base.widget.ErrorInfo;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.zj.adlib.hx5;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.fl.saas.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1423n implements AdapterAPI, D0 {

    @Nullable
    private WeakReference<Activity> activityRef;
    private AdMaterial.AdMaterialData mAdMaterialData;
    protected C1415j mAdxInfo;
    private Context mContext;
    protected String mLinkId;
    protected String mPlaceId;
    private long reqTime;
    private final String TAG = CommConstant.getObjTag(this);
    private boolean isCache = false;
    private boolean isFailedCallBack = false;
    private boolean isHot = false;
    private boolean isReportExposure = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Activity activity) {
        return !activity.isFinishing();
    }

    public void bindC2SBidECPM(b1 b1Var) {
        int iIntValue;
        if (getAdSource() == null || !getAdSource().s || b1Var == null) {
            return;
        }
        try {
            iIntValue = ((Integer) b1Var.a()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogcatUtil.e(this.TAG, "bindC2SBidECPM is exception, " + getAdSource());
            iIntValue = 0;
        }
        setECPM(iIntValue);
    }

    public boolean canUseEcpm() {
        C1415j c1415j = this.mAdxInfo;
        return c1415j == null || c1415j.r0 == 1;
    }

    public boolean changeReRequestCount() {
        return false;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void clearCache() {
        this.isCache = false;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        this.mContext = null;
    }

    public void disposeError(FLError fLError) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.code = fLError.getCode();
        errorInfo.errorType = fLError.getErrorType();
        errorInfo.msg = fLError.getMsg();
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

    public C1428p0 getActivityValid() {
        return C1428p0.b(this.activityRef).a((Function) new hx5()).a(new InterfaceC1444x0() { // from class: com.zj.adlib.rjb
            @Override // com.fl.saas.InterfaceC1444x0
            public final boolean a(Object obj) {
                return AbstractC1423n.a((Activity) obj);
            }
        });
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public C1415j getAdSource() {
        return this.mAdxInfo;
    }

    public String getAppId() {
        return DeviceUtil.appId;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public String getLinkId() {
        return this.mLinkId;
    }

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

    public String getPlaceId() {
        return this.mPlaceId;
    }

    public String getPosId() {
        return this.mPlaceId;
    }

    public abstract void handle(Context context);

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public boolean isCache() {
        return this.isCache;
    }

    public boolean isFullScreenInterstitial() {
        if (getAdSource() != null) {
            return getAdSource().n();
        }
        return false;
    }

    public boolean isHot() {
        return this.isHot;
    }

    public boolean isReRequest() {
        return false;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void load() {
        try {
            this.reqTime = DeviceUtil.getBootTime();
            Context activityOrNull = getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            Context context = this.mContext;
            if (context == null && activityOrNull == null) {
                onAdFailed(FLError.create(20404, "adapter is not ready, context exception"));
                return;
            }
            if (activityOrNull == null) {
                activityOrNull = context;
            }
            handle(activityOrNull);
        } catch (Exception e) {
            e.printStackTrace();
            onAdFailed(FLError.create(20404, "adapter is not ready, context exception"));
        }
    }

    public abstract void onAdFailed(FLError fLError);

    public void onClickedEvent() {
        LogcatUtil.d(this.TAG, "onClickedEvent");
        QuickAppHelper.getInstance().setAdSource(this.mAdxInfo);
    }

    public void onLoadedEvent() {
        if (this.mAdxInfo == null) {
            disposeError(new FLError(20401, "没有填充"));
        } else {
            a();
        }
    }

    public void onShowEvent() {
        if (this.isReportExposure) {
            return;
        }
        this.isReportExposure = true;
        LogcatUtil.d(this.TAG, "onShowEvent");
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI, com.fl.saas.D0
    public void reportRequestShow() {
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public AbstractC1423n setAdSource(@NonNull C1415j c1415j) {
        if (this.isCache) {
            return this;
        }
        this.mAdxInfo = c1415j;
        if (c1415j != null) {
            c1415j.l = this.reqTime;
            c1415j.A = DeviceUtil.getBootTime() - this.mAdxInfo.l;
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void setCache() {
        this.isCache = true;
        this.activityRef = null;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public AbstractC1423n setContext(@NonNull Context context) {
        if (context instanceof Activity) {
            this.activityRef = new WeakReference<>((Activity) context);
            context = context.getApplicationContext();
        }
        this.mContext = context;
        return this;
    }

    public void setECPM(int i) {
        this.mAdxInfo.d = Math.max(i, 0);
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void setHot(boolean z) {
        this.isHot = z;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void setLinkId(String str) {
        this.mLinkId = str;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void setMaterial(MaterialBean materialBean) {
        C1415j c1415j;
        if (materialBean == null || (c1415j = this.mAdxInfo) == null || c1415j.x2 != 1) {
            return;
        }
        materialBean.setId(c1415j.z);
        materialBean.setPlaceId(this.mAdxInfo.i);
        materialBean.setTitle(this.mAdxInfo.o0);
        materialBean.setDes(this.mAdxInfo.s1);
        materialBean.setImgUrl(this.mAdxInfo.p1);
        materialBean.setDeepLinkUrl(this.mAdxInfo.y0);
        materialBean.setLandPageUrl(this.mAdxInfo.x0);
        materialBean.setDownloadUrl(this.mAdxInfo.z0);
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public AdapterAPI setPlaceId(String str) {
        this.mPlaceId = str;
        return this;
    }

    @Override // com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        this.isCache = false;
    }

    private void a() {
        LogcatUtil.d(this.TAG, "onLoadedEvent");
        this.mAdxInfo.o = DeviceUtil.getBootTime() - this.reqTime;
        showAd();
    }

    public void disposeError(ErrorInfo errorInfo) {
        LogcatUtil.d(this.TAG, "disposeError:" + errorInfo);
        if (this.isFailedCallBack) {
            return;
        }
        this.isFailedCallBack = true;
        onAdFailed(FLError.create(errorInfo.code, errorInfo.errorType, errorInfo.msg));
    }
}
