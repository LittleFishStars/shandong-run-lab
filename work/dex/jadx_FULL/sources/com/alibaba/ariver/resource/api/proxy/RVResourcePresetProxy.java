package com.alibaba.ariver.resource.api.proxy;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public interface RVResourcePresetProxy extends Proxiable {

    @Keep
    public interface InputStreamGetter {
        InputStream onGetInputStream();
    }

    @Keep
    public static class PresetPackage {
        private String appId;
        private boolean forceUse;
        private InputStreamGetter inputStreamGetter;
        private String version;

        public PresetPackage(String str, String str2, InputStreamGetter inputStreamGetter) {
            this.appId = str;
            this.version = str2;
            this.inputStreamGetter = inputStreamGetter;
        }

        public String getAppId() {
            return this.appId;
        }

        public InputStream getInputStream() {
            return this.inputStreamGetter.onGetInputStream();
        }

        public String getVersion() {
            return this.version;
        }

        public boolean isForceUse() {
            return this.forceUse;
        }

        public void setForceUse(boolean z) {
            this.forceUse = z;
        }
    }

    @Nullable
    Map<String, AppModel> getPresetAppInfos();

    @Nullable
    Map<String, PresetPackage> getPresetPackage();
}
