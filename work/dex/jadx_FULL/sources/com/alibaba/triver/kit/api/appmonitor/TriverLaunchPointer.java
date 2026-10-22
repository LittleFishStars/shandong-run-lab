package com.alibaba.triver.kit.api.appmonitor;

import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverLaunchPointer {
    private static final String TAG = "TriverLaunchPointer";
    public String appId;
    public String developerVersion;
    public String errorCode;
    public String errorMsg;
    public HashMap extra;
    public Double isFirstPage;
    public String memInfo;
    public String newStage;
    public String page;
    public String stage;
    public Bundle startParams;
    public Double status;
    public String templateId;
    public String templateVersion;
    public String version;

    public static final class Builder {
        App app;
        String appId;
        String developerVersion;
        String errorCode;
        String errorMsg;
        public HashMap<String, Object> extra = new HashMap<>();
        Double isFirstPage;
        String memInfo;
        String newStage;
        Page page;
        String pagePath;
        String stage;
        Bundle startParams;
        Double status;
        String templateId;
        String templateVersion;
        String version;

        public TriverLaunchPointer create() {
            Page page;
            App app = this.app;
            if (app == null && (page = this.page) != null) {
                app = page.getApp();
            }
            if (app != null) {
                if (app.getAppId() != null) {
                    setAppId(app.getAppId());
                }
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                if (appModel != null) {
                    setVersion(appModel.getAppVersion());
                    if (appModel.getAppInfoModel() != null) {
                        setDeveloperVersion(appModel.getAppInfoModel().getDeveloperVersion());
                        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
                        if (templateConfig != null) {
                            setTemplateId(templateConfig.getTemplateId());
                            setTemplateVersion(templateConfig.getTemplateVersion());
                        }
                    }
                }
                if (app.getSceneParams() != null && app.getSceneParams().containsKey(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP)) {
                    putExtra("monitorTime", Long.valueOf(SystemClock.elapsedRealtime() - app.getSceneParams().getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP)));
                }
                if (app.getSceneParams() != null && app.getSceneParams().containsKey("currentStage")) {
                    putExtra("currentStage", app.getSceneParams().getString("currentStage"));
                }
            }
            Page page2 = this.page;
            if (page2 != null) {
                try {
                    setPagePath(UrlUtils.getHash(page2.getPageURI()));
                } catch (Exception e) {
                    RVLogger.e(TriverLaunchPointer.TAG, e);
                }
            }
            return new TriverLaunchPointer(this);
        }

        public Builder putExtra(String str, Object obj) {
            this.extra.put(str, obj);
            return this;
        }

        public Builder setApp(App app) {
            this.app = app;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setDeveloperVersion(String str) {
            this.developerVersion = str;
            return this;
        }

        public Builder setErrorCode(String str) {
            this.errorCode = str;
            return this;
        }

        public Builder setErrorMsg(String str) {
            this.errorMsg = str;
            return this;
        }

        public Builder setIsFirstPage(Double d) {
            this.isFirstPage = d;
            return this;
        }

        public Builder setMemInfo(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                putExtra(TriverAppMonitorConstants.KEY_AB_WORKER_TEST, map.get(TriverAppMonitorConstants.KEY_AB_WORKER_TEST)).putExtra(TriverAppMonitorConstants.KEY_START_MEM, map.get(TriverAppMonitorConstants.KEY_START_MEM)).putExtra(TriverAppMonitorConstants.KEY_HIGH_MEM, map.get(TriverAppMonitorConstants.KEY_HIGH_MEM));
            }
            return this;
        }

        public Builder setNewStage(String str) {
            this.newStage = str;
            return this;
        }

        public Builder setPage(Page page) {
            this.page = page;
            return this;
        }

        public Builder setPagePath(String str) {
            this.pagePath = str;
            return this;
        }

        public Builder setStage(String str) {
            this.stage = str;
            return this;
        }

        public Builder setStartParams(Bundle bundle) {
            if (bundle != null) {
                this.startParams = (Bundle) bundle.clone();
            }
            return this;
        }

        public Builder setStatus(Double d) {
            this.status = d;
            return this;
        }

        public Builder setTemplateId(String str) {
            this.templateId = str;
            return this;
        }

        public Builder setTemplateVersion(String str) {
            this.templateVersion = str;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }
    }

    public static Builder build() {
        return new Builder();
    }

    public String toString() {
        return "TriverLaunchPointer{appId='" + this.appId + "', version='" + this.version + "', developerVersion='" + this.developerVersion + "', templateId='" + this.templateId + "', templateVersion='" + this.templateVersion + "', stage='" + this.stage + "', page='" + this.page + "', newStage='" + this.newStage + "', status=" + this.status + ", errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "', isFirstPage=" + this.isFirstPage + ", extra=" + this.extra + ", startParams=" + this.startParams + '}';
    }

    private TriverLaunchPointer(Builder builder) {
        this.appId = builder.appId;
        this.version = builder.version;
        this.developerVersion = builder.developerVersion;
        this.templateId = builder.templateId;
        this.templateVersion = builder.templateVersion;
        this.stage = builder.stage;
        this.page = builder.pagePath;
        this.status = builder.status;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.isFirstPage = builder.isFirstPage;
        this.extra = builder.extra;
        this.newStage = builder.newStage;
        this.startParams = builder.startParams;
        this.memInfo = builder.memInfo;
    }
}
