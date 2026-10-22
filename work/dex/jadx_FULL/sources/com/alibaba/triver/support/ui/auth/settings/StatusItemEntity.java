package com.alibaba.triver.support.ui.auth.settings;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StatusItemEntity implements Serializable {
    public String appId;
    public String desc;
    public String displayName;
    public boolean hasAccess;
    public boolean isLocalApi;
    public String scopeName;

    public boolean equals(Object obj) {
        return (obj instanceof StatusItemEntity) && TextUtils.equals(((StatusItemEntity) obj).displayName, this.displayName);
    }
}
