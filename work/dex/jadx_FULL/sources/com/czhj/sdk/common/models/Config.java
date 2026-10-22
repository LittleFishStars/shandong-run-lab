package com.czhj.sdk.common.models;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.volley.toolbox.Volley;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Config {
    private static Config gInstance;
    private boolean disable_boot_mark;
    private boolean disable_oaid_api;
    private int disable_up_oaid;
    private String log;
    private boolean logenc;
    private int max_send_log_records = 100;
    private int send_log_interval = 3;
    private int networkTimeout = 5000;
    private boolean mIsGDPRRegion = false;

    private Config() {
    }

    public static Config sharedInstance() {
        if (gInstance == null) {
            synchronized (Config.class) {
                if (gInstance == null) {
                    gInstance = new Config();
                }
            }
        }
        return gInstance;
    }

    public int getDisable_up_OAid() {
        return this.disable_up_oaid;
    }

    public String getLogUrl() {
        if (!TextUtils.isEmpty(this.log)) {
            return this.log;
        }
        return "https://" + Constants.LOG_URL;
    }

    public int getMax_send_log_records() {
        if (this.max_send_log_records < 10) {
            this.max_send_log_records = 100;
        }
        return this.max_send_log_records;
    }

    public int getNetworkTimeout() {
        return this.networkTimeout;
    }

    public boolean getOaidApiDisable() {
        return this.disable_oaid_api;
    }

    public int getSend_log_interval() {
        return this.send_log_interval;
    }

    public boolean isDisableBootMark() {
        return this.disable_boot_mark;
    }

    public boolean isEnc() {
        return this.logenc;
    }

    public boolean isGDPRRegion() {
        return this.mIsGDPRRegion;
    }

    public void setEnable_okhttp3(boolean z) {
        Volley.setEnableOkhttp3(z);
    }

    public void setNetworkTimeout(int i) {
        if (i <= 0 || i > 30) {
            return;
        }
        this.networkTimeout = i * 1000;
    }

    public void update(boolean z, boolean z2, boolean z3, int i, String str, int i2, int i3, boolean z4) {
        this.mIsGDPRRegion = z;
        this.disable_boot_mark = z2;
        this.disable_oaid_api = z3;
        this.disable_up_oaid = i;
        this.max_send_log_records = i3;
        this.send_log_interval = i2;
        this.log = str;
        this.logenc = z4;
    }
}
