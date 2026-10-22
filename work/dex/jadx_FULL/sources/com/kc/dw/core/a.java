package com.kc.dw.core;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a implements c {
    public String appId;

    public String getAppId() {
        return this.appId;
    }

    public List<String> getNeededPermissions() {
        return null;
    }

    public void init(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(this.appId) || context == null) {
            return;
        }
        this.appId = str;
        onInit(context, str, str2);
    }

    public void onInit(Context context, String str, String str2) {
    }
}
