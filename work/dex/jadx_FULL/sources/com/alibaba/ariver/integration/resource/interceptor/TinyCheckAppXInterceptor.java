package com.alibaba.ariver.integration.resource.interceptor;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.ContainerModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TinyCheckAppXInterceptor implements StepInterceptor {
    private static final String TAG = "Ariver:TinyCheckAppXInterceptor";
    private String mCheckingVersion;
    private PrepareCallback mPrepareCallback;
    private PrepareContext mPrepareContext;
    private PrepareController mPrepareController;
    private RVAppInfoManager mResourceAppManager;
    private boolean mAlreadyChecked = false;
    private boolean mUsingAppxNg = false;

    private String getDeclaredMinAppxVersion() {
        String appxMinFrameworkVersionFromPackage = getAppxMinFrameworkVersionFromPackage(this.mPrepareContext.getAppModel());
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_minFrameworkVersion", "");
        if (RVResourceUtils.compareVersion(config, appxMinFrameworkVersionFromPackage) <= 0) {
            return appxMinFrameworkVersionFromPackage;
        }
        RVLogger.d(TAG, "checkAppxMinFrameworkVersion...get minVersion from config: " + config);
        return config;
    }

    private void handleForceUpdateAppInfo(boolean z) {
        if (this.mAlreadyChecked) {
            onUpdateFail(z);
        } else {
            forceUpdateAppInfo(z);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        if (prepareStep.getType() == StepType.START && this.mPrepareContext.getAppModel() != null) {
            this.mPrepareController = prepareController;
            if (notNeedCheckSdkVersion(this.mPrepareContext)) {
                return false;
            }
            String declaredMinAppxVersion = getDeclaredMinAppxVersion();
            if (!TextUtils.isEmpty(declaredMinAppxVersion)) {
                this.mCheckingVersion = declaredMinAppxVersion;
                if (!checkAppxMinFrameworkVersion(this.mPrepareContext)) {
                    RVLogger.d(TAG, "framework version not compatible!!!");
                    return true;
                }
            } else if (!checkAppxMinVersion(this.mPrepareContext)) {
                RVLogger.d(TAG, "deploy version not compatible!!!");
                return true;
            }
        }
        return false;
    }

    public boolean checkAppxMinFrameworkVersion(PrepareContext prepareContext) {
        AppModel appModel;
        if ("YES".equalsIgnoreCase(BundleUtils.getString(prepareContext.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK))) {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion check appx-ng version");
            appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make(RVConstants.TINY_APPX_NG_APPID));
            this.mUsingAppxNg = true;
        } else {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion check appx version");
            appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make(RVConstants.TINY_WEB_COMMON_APPID));
        }
        String string = appModel != null ? JSONUtils.getString(appModel.getExtendInfos(), "appxVersion") : null;
        RVLogger.d(TAG, "checkAppxMinFrameworkVersion...min: " + this.mCheckingVersion + ",current: " + string);
        if (TextUtils.isEmpty(string)) {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion...get sdk version null, just ignore this check!");
            return true;
        }
        int iCompareVersion = RVResourceUtils.compareVersion(string, this.mCheckingVersion);
        if (iCompareVersion == 1 || iCompareVersion == 0) {
            return true;
        }
        handleForceUpdateAppInfo(true);
        return false;
    }

    public boolean checkAppxMinVersion(PrepareContext prepareContext) {
        String appxMinVersionFromPackage = getAppxMinVersionFromPackage(prepareContext.getAppModel());
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_minSdkVersion", "");
        if (RVResourceUtils.compareVersion(config, appxMinVersionFromPackage) > 0) {
            RVLogger.d(TAG, "checkAppxMinVersion...get minVersion from config: " + config);
            appxMinVersionFromPackage = config;
        }
        if (TextUtils.isEmpty(appxMinVersionFromPackage)) {
            return true;
        }
        AppModel appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make(RVConstants.TINY_WEB_COMMON_APPID));
        String appVersion = appModel != null ? appModel.getAppVersion() : null;
        RVLogger.d(TAG, "checkAppxMinVersion...min: " + appxMinVersionFromPackage + ",current: " + appVersion);
        if (TextUtils.isEmpty(appVersion)) {
            handleForceUpdateAppInfo(false);
            return false;
        }
        this.mCheckingVersion = appxMinVersionFromPackage;
        int iCompareVersion = RVResourceUtils.compareVersion(appVersion, appxMinVersionFromPackage);
        if (iCompareVersion == 1 || iCompareVersion == 0) {
            return true;
        }
        handleForceUpdateAppInfo(false);
        return false;
    }

    public void forceUpdateAppInfo(final boolean z) {
        RVLogger.d(TAG, "forceUpdateAppInfo..." + this.mPrepareContext);
        this.mPrepareController.postTimeOut(this.mPrepareContext.getTimeout());
        this.mPrepareCallback.showLoading(true, this.mPrepareContext.getEntryInfo());
        ResourceUtils.prepare(this.mUsingAppxNg ? RVConstants.TINY_APPX_NG_APPID : RVConstants.TINY_WEB_COMMON_APPID, z ? "*" : this.mCheckingVersion, new PackageInstallCallback() { // from class: com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor.1
            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z2, String str) {
                boolean zCheckAppxMinVersion;
                TinyCheckAppXInterceptor.this.mAlreadyChecked = true;
                if (!z2) {
                    RVLogger.d(TinyCheckAppXInterceptor.TAG, "prepareUpdate...onError, checkRealSdkVersion: " + z);
                    TinyCheckAppXInterceptor.this.onUpdateFail(z);
                    return;
                }
                RVLogger.d(TinyCheckAppXInterceptor.TAG, "prepareUpdate...onSuccess, checkRealSdkVersion: " + z);
                if (z) {
                    TinyCheckAppXInterceptor tinyCheckAppXInterceptor = TinyCheckAppXInterceptor.this;
                    zCheckAppxMinVersion = tinyCheckAppXInterceptor.checkAppxMinFrameworkVersion(tinyCheckAppXInterceptor.mPrepareContext);
                } else {
                    TinyCheckAppXInterceptor tinyCheckAppXInterceptor2 = TinyCheckAppXInterceptor.this;
                    zCheckAppxMinVersion = tinyCheckAppXInterceptor2.checkAppxMinVersion(tinyCheckAppXInterceptor2.mPrepareContext);
                }
                if (zCheckAppxMinVersion) {
                    IpcServerUtils.sendMsgToClient(TinyCheckAppXInterceptor.this.mPrepareContext.getAppId(), TinyCheckAppXInterceptor.this.mPrepareContext.getStartToken(), 13, null);
                    TinyCheckAppXInterceptor.this.onUpdateSuccess(z);
                    TinyCheckAppXInterceptor.this.mPrepareController.moveToNext();
                }
            }
        });
    }

    public String getAppxMinFrameworkVersionFromPackage(AppModel appModel) {
        ContainerModel containerInfo;
        if (appModel == null || (containerInfo = appModel.getContainerInfo()) == null) {
            return null;
        }
        return JSONUtils.getString(containerInfo.getLaunchParams(), "minAppxVersion");
    }

    public String getAppxMinVersionFromPackage(AppModel appModel) {
        ContainerModel containerInfo;
        if (appModel == null || (containerInfo = appModel.getContainerInfo()) == null) {
            return null;
        }
        String string = JSONUtils.getString(containerInfo.getLaunchParams(), "minSDKVersion");
        return !TextUtils.isEmpty(string) ? string : JSONUtils.getString(containerInfo.getLaunchParams(), "minSdkVersion");
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.mPrepareContext = prepareContext;
        this.mPrepareCallback = prepareCallback;
        this.mResourceAppManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
    }

    public boolean notNeedCheckSdkVersion(PrepareContext prepareContext) {
        JSONArray array;
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_setMinAppxBlacklist", null);
        if (TextUtils.isEmpty(config) || (array = JSONUtils.parseArray(config)) == null) {
            return false;
        }
        if (!array.contains("all") && !array.contains(prepareContext.getAppId())) {
            return false;
        }
        RVLogger.d(TAG, "isNeedCheck hit blacklist ta_setMinAppxBlacklist: " + config);
        return true;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
    }

    public void onUpdateFail(boolean z) {
        RVLogger.d(TAG, "onUpdateFail checkRealSdkVersion: " + z);
        this.mPrepareCallback.prepareFail(this.mPrepareContext.getPrepareData(), new PrepareException("7", "Appx check failed: " + this.mCheckingVersion));
    }

    public void onUpdateSuccess(boolean z) {
        RVLogger.d(TAG, "onUpdateSuccess checkRealSdkVersion: " + z);
    }
}
