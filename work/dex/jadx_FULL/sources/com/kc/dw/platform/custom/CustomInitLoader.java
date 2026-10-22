package com.kc.dw.platform.custom;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class CustomInitLoader {
    private InitCallback initCallback;
    private volatile boolean isInitSucc;

    @Keep
    public interface InitCallback {
        void fail();

        void succ();
    }

    public void callInitFail() {
        synchronized (this) {
            this.isInitSucc = false;
            InitCallback initCallback = this.initCallback;
            if (initCallback != null) {
                initCallback.fail();
                this.initCallback = null;
            }
        }
    }

    public void callInitSucc() {
        synchronized (this) {
            this.isInitSucc = true;
            InitCallback initCallback = this.initCallback;
            if (initCallback != null) {
                initCallback.succ();
                this.initCallback = null;
            }
        }
    }

    public boolean getInitStatus() {
        return this.isInitSucc;
    }

    public abstract String getPlatform();

    public abstract String getVersionName();

    public void init(String str, String str2, Map<String, Object> map) {
        try {
            initADN(str, str2, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void initADN(String str, String str2, Map<String, Object> map);

    public void setInitCallback(InitCallback initCallback) {
        synchronized (this) {
            this.initCallback = initCallback;
        }
    }
}
