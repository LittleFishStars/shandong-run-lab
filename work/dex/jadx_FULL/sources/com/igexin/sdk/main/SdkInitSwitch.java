package com.igexin.sdk.main;

import android.content.Context;
import com.igexin.c.a.c.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SdkInitSwitch {
    private String mSdkSwitchPath;

    public SdkInitSwitch(Context context) {
        if (context == null) {
            return;
        }
        this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
    }

    public void delete() {
        File file = new File(this.mSdkSwitchPath);
        if (file.exists()) {
            file.delete();
        }
    }

    public boolean isSwitchOn() {
        if (this.mSdkSwitchPath != null) {
            return new File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    public void switchOn() {
        if (isSwitchOn() || this.mSdkSwitchPath == null) {
            return;
        }
        try {
            new File(this.mSdkSwitchPath).createNewFile();
        } catch (IOException e) {
            a.a(e);
        }
    }
}
