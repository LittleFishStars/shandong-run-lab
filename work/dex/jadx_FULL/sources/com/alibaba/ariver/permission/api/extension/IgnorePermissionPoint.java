package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface IgnorePermissionPoint extends Extension {
    boolean ignoreAppPermission(String str);
}
