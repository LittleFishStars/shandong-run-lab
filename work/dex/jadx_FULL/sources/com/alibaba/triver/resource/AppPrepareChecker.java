package com.alibaba.triver.resource;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppInfoStrategy;
import com.alibaba.triver.extensions.CustomServerMessageImpl;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.error.TriverErrors;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.request.footprint.AddFootprintClient;
import com.alibaba.triver.utils.ResourceUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppPrepareChecker implements StepInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrepareContext f25138a;
    private AppPerformance b;
    private AppInfoStrategy c;
    private LaunchMonitorData d;
    private b e;

    public static class AppPerformance implements Parcelable {
        public static final Parcelable.Creator<AppPerformance> CREATOR = new Parcelable.Creator<AppPerformance>() { // from class: com.alibaba.triver.resource.AppPrepareChecker.AppPerformance.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AppPerformance createFromParcel(Parcel parcel) {
                return new AppPerformance(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AppPerformance[] newArray(int i) {
                return new AppPerformance[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f25143a;
        public long b;
        public long c;
        public String d;
        public String e;

        public AppPerformance() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f25143a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }

        public AppPerformance(Parcel parcel) {
            this.f25143a = parcel.readLong();
            this.b = parcel.readLong();
            this.c = parcel.readLong();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }
    }

    private void b() {
        AppInfoStrategy appInfoStrategyA = com.alibaba.triver.appinfo.core.b.a(RVConstants.TINY_WEB_COMMON_APPID, "*");
        if (appInfoStrategyA != null) {
            this.b.e = appInfoStrategyA.getName();
            RVLogger.d("AriverTriver:appInfoCenter", "appxInfoStrategy:" + appInfoStrategyA.getName());
        }
        if (appInfoStrategyA != AppInfoStrategy.NONE) {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.resource.AppPrepareChecker.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ResourceUtils.a(RVConstants.TINY_WEB_COMMON_APPID, "*", false, AppPrepareChecker.this.f25138a.getStartParams(), new PackageInstallCallback() { // from class: com.alibaba.triver.resource.AppPrepareChecker.2.1
                            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                            public void onResult(boolean z, String str) {
                                if (z) {
                                    RVLogger.d("AriverTriver:appInfoCenter", "appx async update success!");
                                } else {
                                    RVLogger.e("AriverTriver:appInfoCenter", "appx async update error!");
                                }
                            }
                        });
                    } catch (Exception e) {
                        RVLogger.e("AriverTriver:appInfoCenter", "appx async update error!", e);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0264  */
    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) {
        String templateId;
        Bundle bundle;
        String appVersion;
        String developerVersion;
        Bundle startParams;
        String appId;
        String appVersion2;
        String developerVersion2;
        String templateId2;
        LaunchMonitorData launchMonitorData;
        AppModel appModel;
        JSONObject extendInfos;
        Map<String, String> configsByGroup;
        boolean z;
        if ("68687029".equals(this.f25138a.getAppId())) {
            return false;
        }
        if (prepareStep.getType() == StepType.SETUP) {
            Bundle startParams2 = this.f25138a.getStartParams();
            String str = "";
            if (startParams2 != null) {
                if (TRiverConstants.CHINFO_BRAND_ZONE_PUBLIC.equals(startParams2.getString(RVStartParams.KEY_CHINFO))) {
                    str = "chInfo is brandzone_public. SYNC_FORCE!";
                    z = true;
                } else {
                    z = false;
                }
                if (!TROrangeController.closeAppInfoForceUpdate() && "true".equals(startParams2.getString("forceUpdate"))) {
                    str = "forceUpdate is true. SYNC_FORCE!";
                    z = true;
                }
            } else {
                z = false;
            }
            String str2 = str;
            if (z) {
                this.f25138a.updateMode = UpdateMode.SYNC_FORCE;
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(com.alibaba.triver.trace.c.J, str2, "AppInfo", this.f25138a.getAppId(), null, null);
                this.b.d = AppInfoStrategy.SYNC_LOAD.getName();
            } else {
                PrepareContext prepareContext = this.f25138a;
                UpdateMode updateMode = prepareContext.updateMode;
                UpdateMode updateMode2 = UpdateMode.SYNC_FORCE;
                if (updateMode != updateMode2) {
                    AppInfoStrategy appInfoStrategyA = com.alibaba.triver.appinfo.core.b.a(prepareContext.getAppId(), this.f25138a.getAppInfoQuery().getVersion());
                    this.c = appInfoStrategyA;
                    if (appInfoStrategyA != null) {
                        this.b.d = appInfoStrategyA.getName();
                        RVLogger.d("AriverTriver:appInfoCenter", "appInfoStrategy:" + this.c.getName());
                        if (startParams2 != null) {
                            startParams2.putString("mainRequestStrategy", this.c.getName());
                        }
                    }
                    if (this.c == AppInfoStrategy.SYNC_LOAD) {
                        this.f25138a.updateMode = updateMode2;
                    } else {
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(com.alibaba.triver.trace.c.J, "get appInfo from cache. request appId:" + this.f25138a.getAppId() + " version:" + this.f25138a.getAppInfoQuery().getVersion(), "AppInfo", this.f25138a.getAppId(), null, null);
                    }
                } else {
                    this.b.d = AppInfoStrategy.SYNC_LOAD.getName();
                }
            }
            AppInfoQuery appInfoQuery = this.f25138a.getAppInfoQuery();
            if (appInfoQuery != null && appInfoQuery.getScene() != AppInfoScene.ONLINE) {
                this.f25138a.getSceneParams().putBoolean(TRiverConstants.KEY_DELETE_FILE_WHEN_EXIT, true);
                if (appInfoQuery.getScene() != AppInfoScene.TRIAL) {
                    this.f25138a.getSceneParams().putBoolean(TRiverConstants.KEY_FORCE_CLOSE_KEEP_ALIVE_WHEN_EXIT, true);
                }
            }
        } else {
            String str3 = null;
            if (prepareStep.getType() == StepType.UPDATE) {
                String string = this.f25138a.getStartParams() != null ? this.f25138a.getStartParams().getString(TRiverConstants.KEY_ORI_URL) : null;
                long j = this.f25138a.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN);
                AppModel appModel2 = this.f25138a.getAppModel();
                if (TROrangeController.closeAppLimit() || appModel2 == null || appModel2.getExtendInfos() == null || !appModel2.getExtendInfos().getBooleanValue("needFlowLimit")) {
                    a(string, j);
                } else {
                    b bVar = new b();
                    this.e = bVar;
                    bVar.a(this.f25138a.getAppId());
                }
                this.b.b = SystemClock.elapsedRealtime();
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("AppPrepare", "End appInfo");
                this.f25138a.getSceneParams().putParcelable(TRiverConstants.KEY_APP_INFO_PERFORMANCE, this.b);
                StringBuilder sb = new StringBuilder();
                sb.append("appInfoCost:");
                AppPerformance appPerformance = this.b;
                sb.append(appPerformance.b - appPerformance.f25143a);
                RVLogger.d("AriverTriver:appInfoCenter", sb.toString());
                PrepareContext prepareContext2 = this.f25138a;
                if (prepareContext2 != null) {
                    startParams = prepareContext2.getStartParams();
                    appId = this.f25138a.getAppId();
                    if (this.f25138a.getAppModel() != null) {
                        appVersion2 = this.f25138a.getAppModel().getAppVersion();
                        if (this.f25138a.getAppModel().getAppInfoModel() != null) {
                            developerVersion2 = this.f25138a.getAppModel().getAppInfoModel().getDeveloperVersion();
                            templateId2 = this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig() != null ? this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig().getTemplateId() : null;
                        } else {
                            developerVersion2 = null;
                            templateId2 = developerVersion2;
                        }
                    } else {
                        appVersion2 = null;
                    }
                    launchMonitorData = this.d;
                    if (launchMonitorData != null) {
                        launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH);
                    }
                    ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setVersion(appVersion2).setDeveloperVersion(developerVersion2).setTemplateId(templateId2).setStage(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH).setStartParams(startParams).setStatus(Double.valueOf(1.0d)).create());
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.e, com.alibaba.triver.trace.c.J, TRiverUtils.getSessionId(startParams), appId, (JSONObject) null);
                    appModel = this.f25138a.getAppModel();
                    if (appModel != null && (extendInfos = appModel.getExtendInfos()) != null && extendInfos.getBooleanValue("footPrintEnable") && (configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON)) != null && !configsByGroup.isEmpty() && TextUtils.equals(configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_FOOTPRINT_ENABLE), "true")) {
                        AddFootprintClient.a(this.f25138a.getAppId(), this.f25138a.getStartParams());
                    }
                } else {
                    startParams = null;
                    appId = null;
                    appVersion2 = null;
                }
                developerVersion2 = appVersion2;
                templateId2 = developerVersion2;
                launchMonitorData = this.d;
                if (launchMonitorData != null) {
                    launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH);
                }
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setVersion(appVersion2).setDeveloperVersion(developerVersion2).setTemplateId(templateId2).setStage(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH).setStartParams(startParams).setStatus(Double.valueOf(1.0d)).create());
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.e, com.alibaba.triver.trace.c.J, TRiverUtils.getSessionId(startParams), appId, (JSONObject) null);
                appModel = this.f25138a.getAppModel();
                if (appModel != null) {
                    AddFootprintClient.a(this.f25138a.getAppId(), this.f25138a.getStartParams());
                }
            } else if (prepareStep.getType() == StepType.OFFLINE) {
                PrepareContext prepareContext3 = this.f25138a;
                if (prepareContext3 != null) {
                    Bundle startParams3 = prepareContext3.getStartParams();
                    String appId2 = this.f25138a.getAppId();
                    if (this.f25138a.getAppModel() != null) {
                        appVersion = this.f25138a.getAppModel().getAppVersion();
                        if (this.f25138a.getAppModel().getAppInfoModel() != null) {
                            developerVersion = this.f25138a.getAppModel().getAppInfoModel().getDeveloperVersion();
                            bundle = startParams3;
                            templateId = this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig() != null ? this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig().getTemplateId() : null;
                            str3 = appId2;
                        } else {
                            developerVersion = null;
                        }
                    } else {
                        appVersion = null;
                        developerVersion = null;
                    }
                    str3 = appId2;
                    bundle = startParams3;
                    templateId = developerVersion;
                } else {
                    templateId = null;
                    bundle = null;
                    appVersion = null;
                    developerVersion = null;
                }
                LaunchMonitorData launchMonitorData2 = this.d;
                if (launchMonitorData2 != null) {
                    launchMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_FINISH);
                }
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str3).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStartParams(bundle).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_FINISH).setStatus(Double.valueOf(1.0d)).create());
            } else if (prepareStep.getType() == StepType.START) {
                this.b.c = SystemClock.elapsedRealtime();
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("AppPrepare", "End prepare");
                boolean zCloseAppInfoUpdateOptimization = TROrangeController.closeAppInfoUpdateOptimization();
                if (this.c == AppInfoStrategy.ASYNC_LOAD) {
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(com.alibaba.triver.trace.c.J, "Async update appId:" + this.f25138a.getAppId() + " version:" + this.f25138a.getAppInfoQuery().getVersion(), "AppInfo", this.f25138a.getAppId(), null, null);
                    if (zCloseAppInfoUpdateOptimization) {
                        a();
                    }
                }
                if (zCloseAppInfoUpdateOptimization) {
                    b();
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        b bVar;
        String templateId;
        Bundle bundle;
        String appVersion;
        String developerVersion;
        StepType type = prepareStep.getType();
        StepType stepType = StepType.SETUP;
        Double dValueOf = Double.valueOf(1.0d);
        String str = null;
        if (type == stepType) {
            this.b.f25143a = SystemClock.elapsedRealtime();
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("AppPrepare", "Start prepare");
            LaunchMonitorData launchMonitorData = this.d;
            if (launchMonitorData != null) {
                launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_START);
            }
            PrepareContext prepareContext = this.f25138a;
            String appId = prepareContext != null ? prepareContext.getAppId() : "";
            PrepareContext prepareContext2 = this.f25138a;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setStage(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_START).setStartParams(prepareContext2 != null ? prepareContext2.getStartParams() : null).setStatus(dValueOf).create());
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.e, com.alibaba.triver.trace.c.I, "", appId, (JSONObject) null);
            return false;
        }
        if (prepareStep.getType() != StepType.OFFLINE) {
            if (prepareStep.getType() != StepType.START || (bVar = this.e) == null) {
                return false;
            }
            JSONObject jSONObjectA = bVar.a();
            if (!b.a(jSONObjectA) || prepareController == null) {
                a(this.f25138a.getStartParams() != null ? this.f25138a.getStartParams().getString(TRiverConstants.KEY_ORI_URL) : null, this.f25138a.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN));
                return false;
            }
            prepareController.moveToError(b.b(jSONObjectA));
            return true;
        }
        PrepareContext prepareContext3 = this.f25138a;
        if (prepareContext3 != null) {
            Bundle startParams = prepareContext3.getStartParams();
            String appId2 = this.f25138a.getAppId();
            if (this.f25138a.getAppModel() != null) {
                appVersion = this.f25138a.getAppModel().getAppVersion();
                if (this.f25138a.getAppModel().getAppInfoModel() != null) {
                    developerVersion = this.f25138a.getAppModel().getAppInfoModel().getDeveloperVersion();
                    bundle = startParams;
                    templateId = this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig() != null ? this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig().getTemplateId() : null;
                    str = appId2;
                } else {
                    developerVersion = null;
                }
            } else {
                appVersion = null;
                developerVersion = null;
            }
            str = appId2;
            bundle = startParams;
            templateId = developerVersion;
        } else {
            templateId = null;
            bundle = null;
            appVersion = null;
            developerVersion = null;
        }
        LaunchMonitorData launchMonitorData2 = this.d;
        if (launchMonitorData2 != null) {
            launchMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_START);
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(appVersion).setDeveloperVersion(developerVersion).setStartParams(bundle).setTemplateId(templateId).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_START).setStatus(dValueOf).create());
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.f25138a = prepareContext;
        this.b = new AppPerformance();
        LaunchMonitorData launchMonitorData = new LaunchMonitorData();
        this.d = launchMonitorData;
        launchMonitorData.addPoint("appStart");
        PrepareContext prepareContext2 = this.f25138a;
        if (prepareContext2 != null) {
            prepareContext2.getSceneParams().putParcelable(LaunchMonitorUtils.KEY_APP_MAIN_MONITOR_DATA, this.d);
        }
        Bundle startParams = this.f25138a.getStartParams();
        String string = startParams.getString(RVStartParams.KEY_CHINFO);
        String string2 = startParams.getString("isShop");
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.title = startParams.getString(TRiverConstants.KEY_APP_NAME);
        entryInfo.iconUrl = startParams.getString(TRiverConstants.KEY_APP_LOGO);
        String string3 = startParams.getString(TRiverConstants.KEY_FRAME_TYPE);
        String string4 = startParams.getString("loadingParams");
        JSONObject jSONObject = new JSONObject();
        entryInfo.extraInfo = jSONObject;
        jSONObject.put(RVStartParams.KEY_CHINFO, (Object) string);
        if (string3 != null) {
            entryInfo.extraInfo.put(TRiverConstants.KEY_FRAME_TYPE, (Object) string3);
        }
        entryInfo.extraInfo.put("isShop", (Object) string2);
        if (!TextUtils.isEmpty(string4)) {
            entryInfo.extraInfo.put("appLoadingConfig", (Object) JSON.parseObject(string4));
        }
        this.f25138a.setEntryInfo(entryInfo);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        PrepareStep prepareStepA;
        Bundle startParams;
        String templateId;
        String appVersion;
        String developerVersion;
        String str;
        String message;
        String message2;
        if (!(prepareController instanceof d) || (prepareStepA = ((d) prepareController).a()) == null) {
            return false;
        }
        PrepareContext prepareContext = this.f25138a;
        String code = null;
        if (prepareContext != null) {
            startParams = prepareContext.getStartParams();
            String appId = this.f25138a.getAppId();
            if (this.f25138a.getAppModel() != null) {
                appVersion = this.f25138a.getAppModel().getAppVersion();
                if (this.f25138a.getAppModel().getAppInfoModel() != null) {
                    developerVersion = this.f25138a.getAppModel().getAppInfoModel().getDeveloperVersion();
                    if (this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig() != null) {
                        str = appId;
                        templateId = this.f25138a.getAppModel().getAppInfoModel().getTemplateConfig().getTemplateId();
                    } else {
                        str = appId;
                        templateId = null;
                    }
                } else {
                    developerVersion = null;
                }
            } else {
                appVersion = null;
                developerVersion = null;
            }
            str = appId;
            templateId = developerVersion;
        } else {
            startParams = null;
            templateId = null;
            appVersion = null;
            developerVersion = null;
            str = null;
        }
        StepType type = prepareStepA.getType();
        StepType stepType = StepType.UPDATE;
        if (type == stepType) {
            if (prepareException != null) {
                code = prepareException.getCode();
                message2 = prepareException.getMessage();
            } else {
                message2 = null;
            }
            TriverErrors.ErrorWrapper errorWrapperMapError = TriverErrors.mapError(stepType.name(), code, message2);
            String str2 = errorWrapperMapError.errorCode;
            String str3 = errorWrapperMapError.errorMsg;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setStartParams(startParams).setErrorCode(str2).setErrorMsg(str3).create());
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.e, com.alibaba.triver.trace.c.K, TRiverUtils.getSessionId(startParams), str, str2, str3, (JSONObject) null);
            return false;
        }
        StepType type2 = prepareStepA.getType();
        StepType stepType2 = StepType.OFFLINE;
        if (type2 != stepType2) {
            return false;
        }
        if (prepareException != null) {
            code = prepareException.getCode();
            message = prepareException.getMessage();
        } else {
            message = null;
        }
        TriverErrors.ErrorWrapper errorWrapperMapError2 = TriverErrors.mapError(stepType2.name(), code, message);
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_FINISH).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setStartParams(startParams).setErrorCode(errorWrapperMapError2.errorCode).setErrorMsg(errorWrapperMapError2.errorMsg).create());
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
    }

    private void a(String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomServerMessageImpl.SUBTYPE, 1);
        bundle.putParcelable("appInfo", this.f25138a.getAppModel());
        bundle.putString("url", str);
        bundle.putLong(RVConstants.EXTRA_START_TOKEN, j);
        bundle.putBundle(RVConstants.EXTRA_START_PARAMS, this.f25138a.getStartParams());
        IpcServerUtils.sendMsgToClient(this.f25138a.getAppId(), j, 17, bundle);
    }

    private void a() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.resource.AppPrepareChecker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UpdateAppParam updateAppParam = new UpdateAppParam(AppPrepareChecker.this.f25138a.getAppId(), null);
                    updateAppParam.setForce(true);
                    updateAppParam.setUpdateMode(AppPrepareChecker.this.f25138a.updateMode);
                    updateAppParam.setQueryScene(AppPrepareChecker.this.f25138a.getAppInfoQuery().getScene());
                    updateAppParam.setExtras(AppPrepareChecker.this.f25138a.getStartParams());
                    HashMap map = new HashMap();
                    if (AppPrepareChecker.this.f25138a.getAppInfoQuery().isOnlineScene()) {
                        map.put(AppPrepareChecker.this.f25138a.getAppId(), "*");
                    } else {
                        map.put(AppPrepareChecker.this.f25138a.getAppId(), AppPrepareChecker.this.f25138a.getAppInfoQuery().getVersion());
                    }
                    updateAppParam.setRequestApps(map);
                    IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(AppPrepareChecker.this.f25138a.getAppId(), AppPrepareChecker.this.f25138a.getStartParams());
                    if (iAppUpdaterCreateUpdater != null) {
                        iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.triver.resource.AppPrepareChecker.1.1
                            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                            public void onError(UpdateAppException updateAppException) {
                                RVLogger.e("AriverTriver:AppInfoCenter", AppPrepareChecker.this.f25138a.getAppId() + " async update error!");
                            }

                            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                            public void onSuccess(List<AppModel> list) {
                                RVLogger.d("AriverTriver:AppInfoCenter", AppPrepareChecker.this.f25138a.getAppId() + " async update success!");
                            }
                        });
                    }
                } catch (Exception e) {
                    RVLogger.e("AriverTriver:AppInfoCenter", AppPrepareChecker.this.f25138a.getAppId() + " async update error!", e);
                }
            }
        });
    }
}
