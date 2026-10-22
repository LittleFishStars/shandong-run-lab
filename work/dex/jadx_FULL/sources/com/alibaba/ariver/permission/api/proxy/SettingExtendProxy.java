package com.alibaba.ariver.permission.api.proxy;

import android.content.Context;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface SettingExtendProxy extends Proxiable {
    String getExtendAction();

    String getExtendDescription();

    String getExtendDescriptionInSetting();

    String getExtendScope();

    boolean onUserAuthClick(Context context);
}
