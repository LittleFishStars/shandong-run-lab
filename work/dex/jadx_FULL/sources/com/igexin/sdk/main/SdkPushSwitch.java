package com.igexin.sdk.main;

import android.content.Context;
import com.igexin.c.a.c.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SdkPushSwitch {
    private String mSdkSwitchPath;

    public SdkPushSwitch(Context context) {
        if (context == null) {
            return;
        }
        this.mSdkSwitchPath = context.getFilesDir().getPath() + "/push.pid";
    }

    public void delete() {
        switchOff();
    }

    public boolean isSwitchOn() {
        if (this.mSdkSwitchPath != null) {
            return new File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    public void switchOff() {
        if (!isSwitchOn() || this.mSdkSwitchPath == null || new File(this.mSdkSwitchPath).delete()) {
            return;
        }
        a.a("SdkPushSwitch | switchOff, delete file = " + this.mSdkSwitchPath + " failed !!!!!!!!!!!!", new Object[0]);
    }

    public void switchOn() {
        if (isSwitchOn() || this.mSdkSwitchPath == null) {
            return;
        }
        try {
            new File(this.mSdkSwitchPath).createNewFile();
        } catch (IOException e) {
            a.a(e);
            a.a("SdkPushSwitch | switchOn, create file = " + this.mSdkSwitchPath + " exception, " + e.toString(), new Object[0]);
        }
    }
}
