package com.alibaba.ariver.resource.parser;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ParseContext {
    public String appId;

    @Nullable
    public List<Pattern> ignorePatterns;
    public String mainFileName;

    @Nullable
    public String onlineHost;
    public String packagePath;
    public String templateAppId;
    public boolean needVerify = true;
    public boolean needCache = false;
    public boolean fromCache = false;

    public void adaptAppModel(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            return;
        }
        this.appId = appModel.getAppId();
        this.onlineHost = appModel.getAppInfoModel().getVhost();
        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
        if (templateConfig == null || !templateConfig.isTemplateValid()) {
            return;
        }
        this.mainFileName = templateConfig.getTemplateId() + ".tar";
        this.templateAppId = templateConfig.getTemplateId();
        RVLogger.d(RVConstants.RESOURCE_TAG, "change mainFile name to template file: " + this.mainFileName);
    }

    public String toString() {
        return "ParseContext{packagePath='" + this.packagePath + "', mainFileName='" + this.mainFileName + "', appId='" + this.appId + "', onlineHost='" + this.onlineHost + "', templateAppId='" + this.templateAppId + "', ignorePatterns=" + this.ignorePatterns + '}';
    }
}
