package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PermissionSettingPoint extends Extension {

    public static class Inner {
        public static void setupMethodInvokeOptimizer() {
            ExtensionOpt.setupMethodInvokeOptimizer(PermissionSettingPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.permission.api.extension.PermissionSettingPoint.Inner.1
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
                public Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws ExtensionOpt.MismatchMethodException {
                    str.hashCode();
                    if (str.equals("getSetting")) {
                        return ((PermissionSettingPoint) extension).getSetting((String) objArr[0]);
                    }
                    throw new ExtensionOpt.MismatchMethodException(str + "@" + extension.getClass().getName());
                }
            });
        }
    }

    JSONObject getSetting(String str);
}
