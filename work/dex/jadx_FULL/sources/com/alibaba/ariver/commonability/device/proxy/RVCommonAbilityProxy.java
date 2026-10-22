package com.alibaba.ariver.commonability.device.proxy;

import com.alibaba.ariver.commonability.device.jsapi.contact.b;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVCommonAbilityProxy extends Proxiable {
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String MIDDLE = "middle";
    public static final String UNKNOWN = "unknown";

    public @interface a {
    }

    b getAddPhoneContactDialog();

    String getAppAlias();

    com.alibaba.ariver.commonability.device.jsapi.clipboard.a getClipboardTextHandler();

    @a
    String getDevicePerformance();

    float getFontSizeSetting();

    String getLocalLanguage();

    boolean hasRootStatusPermission(String str);
}
