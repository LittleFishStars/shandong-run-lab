package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.annotation.UsePermission;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeGuard;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecurityExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24214a = "AriverKernel:ExtensionInvoker:Security";
    private AccessController b;
    private ActionMeta c;

    public SecurityExtensionInvoker(ActionMeta actionMeta, AccessController accessController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.c = actionMeta;
        this.b = accessController;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        for (Extension extension : immutableList) {
            if (extension instanceof Guard) {
                arrayList.add((Guard) extension);
            }
            UsePermission usePermission = this.c.usePermission;
            if (usePermission != null && usePermission.value().length() > 0) {
                arrayList.add(new BridgeGuard(new BridgePermission(usePermission.value(), usePermission.desc())));
            } else if (extension instanceof BridgeExtension) {
                String str = this.c.actionName;
                arrayList.add(new BridgeGuard(new BridgePermission(str, str)));
            }
        }
        AccessController.ApplyCallback applyCallback = new AccessController.ApplyCallback() { // from class: com.alibaba.ariver.kernel.api.invoke.SecurityExtensionInvoker.1
            @Override // com.alibaba.ariver.kernel.api.security.AccessController.ApplyCallback
            public void onFailure(List<? extends Permission> list) {
                List listMutable = immutableList.mutable();
                for (Permission permission : list) {
                    for (Guard guard : arrayList) {
                        if (guard.permit().authority().equalsIgnoreCase(permission.authority())) {
                            listMutable.remove(guard);
                        }
                    }
                }
                RVLogger.debug(SecurityExtensionInvoker.f24214a, "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                SecurityExtensionInvoker.this.proceedSafe(new ImmutableList<>(listMutable), obj, method, objArr);
            }

            @Override // com.alibaba.ariver.kernel.api.security.AccessController.ApplyCallback
            public void onSuccess() {
                RVLogger.debug(SecurityExtensionInvoker.f24214a, "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                SecurityExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
            }
        };
        AccessController accessController = this.b;
        return (accessController == null || !accessController.check(this.targetNode, arrayList, applyCallback)) ? ExtensionInvoker.InvokeResult.proceed() : ExtensionInvoker.InvokeResult.pending();
    }
}
