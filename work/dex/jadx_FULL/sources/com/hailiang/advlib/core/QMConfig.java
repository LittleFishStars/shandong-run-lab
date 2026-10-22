package com.hailiang.advlib.core;

import android.content.Context;
import android.text.TextUtils;
import com.hailiang.advlib.common.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class QMConfig {
    private boolean agreePrivacyStrategy = false;
    private Context context;
    private QMCustomControl customControl;
    private boolean debug;
    private Map map;
    private ISdkInitListener sdkInitListener;
    private String versionName;

    @Keep
    public static class Builder {
        private boolean agreePrivacyStrategy = false;
        private QMCustomControl customControl;
        private boolean debug;
        private Map map;
        private ISdkInitListener sdkInitListener;
        private String versionName;

        public Builder agreePrivacyStrategy(boolean z) {
            this.agreePrivacyStrategy = z;
            return this;
        }

        public Builder androidId(String str) {
            return this;
        }

        public QMConfig build(Context context) {
            QMConfig qMConfig = new QMConfig();
            if (TextUtils.isEmpty(this.versionName)) {
                this.versionName = f.b(context);
            }
            if (this.customControl != null && this.map == null) {
                this.map = new HashMap();
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            qMConfig.setContext(context);
            qMConfig.setVersionName(this.versionName);
            qMConfig.setDebug(this.debug);
            qMConfig.setAgreePrivacyStrategy(this.agreePrivacyStrategy);
            qMConfig.setMap(this.map);
            qMConfig.setCustomControl(this.customControl);
            qMConfig.setSdkInitListener(this.sdkInitListener);
            return qMConfig;
        }

        public Builder customControl(QMCustomControl qMCustomControl) {
            this.customControl = qMCustomControl;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder extraMap(Map map) {
            this.map = map;
            return this;
        }

        public Builder sdkInitListener(ISdkInitListener iSdkInitListener) {
            this.sdkInitListener = iSdkInitListener;
            return this;
        }

        public Builder versionName(String str) {
            this.versionName = str;
            return this;
        }
    }

    public String getAndroidId() {
        return "";
    }

    public Context getContext() {
        return this.context;
    }

    public QMCustomControl getCustomControl() {
        return this.customControl;
    }

    public Map getMap() {
        return this.map;
    }

    public ISdkInitListener getSdkInitListener() {
        return this.sdkInitListener;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isAgreePrivacyStrategy() {
        return this.agreePrivacyStrategy;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setAgreePrivacyStrategy(boolean z) {
        this.agreePrivacyStrategy = z;
    }

    public void setAndroidId(String str) {
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setCustomControl(QMCustomControl qMCustomControl) {
        this.customControl = qMCustomControl;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSdkInitListener(ISdkInitListener iSdkInitListener) {
        this.sdkInitListener = iSdkInitListener;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
