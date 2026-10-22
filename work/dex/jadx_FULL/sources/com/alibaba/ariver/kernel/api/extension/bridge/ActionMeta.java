package com.alibaba.ariver.kernel.api.extension.bridge;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionMeta {
    public Method actionMethod;
    public String actionName;
    public Class<? extends BridgeExtension> bridgeExtensionClazz;

    @Nullable
    public String[] nativePermissions;
    public Annotation[][] paramAnnotationArray;
    public Class[] paramTypes;
    public UsePermission usePermission;
    public boolean paramRequired = false;
    public boolean autoCallback = false;

    public String toString() {
        return "ActionMeta{actionName='" + this.actionName + "', bridgeExtensionClazz=" + this.bridgeExtensionClazz + ", paramRequired=" + this.paramRequired + ", autoCallback=" + this.autoCallback + '}';
    }
}
