package com.alibaba.ariver.apt;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension;
import com.alibaba.ariver.resource.template.TemplateBridgeExtension;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class f {
    public static void a() {
    }

    public static void b() {
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(SubPackageBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.f.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"loadSubPackage".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((SubPackageBridgeExtension) extension).loadSubPackage((App) objArr[0], (String) objArr[1], (JSONArray) objArr[2], (BridgeCallback) objArr[3]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TemplateBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.f.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getExtConfig".equals(str) && objArr.length == 1) {
                    return ((TemplateBridgeExtension) extension).getExtConfig((App) objArr[0]);
                }
                return null;
            }
        });
    }

    public static void c() {
    }
}
