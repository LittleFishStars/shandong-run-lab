package com.alibaba.ariver.engine.common.extension;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.R;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativePermissionExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24065a = "AriverEngine:NativePermissionExtensionInvoker";
    private BridgeResponseHelper b;
    private ActionMeta c;
    private App d;

    public static class FailedSet {
        final Set<String> actions = new HashSet();

        public void add(String str) {
            this.actions.add(str);
        }

        public boolean contains(String str) {
            if (str == null) {
                return false;
            }
            return this.actions.contains(str);
        }
    }

    public NativePermissionExtensionInvoker(Node node, BridgeResponseHelper bridgeResponseHelper, ExtensionInvoker extensionInvoker, ActionMeta actionMeta) {
        super(extensionInvoker);
        this.d = (App) node.bubbleFindNode(App.class);
        this.b = bridgeResponseHelper;
        this.c = actionMeta;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) {
        Node node = this.targetNode;
        if (!(node instanceof Page)) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        Page page = (Page) node;
        if (page.getRender() == null || page.getRender().getActivity() == null) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        Activity activity = page.getRender().getActivity();
        final ArrayList arrayList = new ArrayList();
        String[] strArr = this.c.nativePermissions;
        if (strArr == null || strArr.length <= 0) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        final FailedSet failedSet = (FailedSet) this.d.getData(FailedSet.class, true);
        if (failedSet.contains(this.c.actionName)) {
            RVLogger.d(f24065a, "API " + this.c.actionName + " already requested but failed!");
            this.b.sendError(5, RVKernelUtils.getResources().getString(R.string.api_error_no_storage_permission));
            return ExtensionInvoker.InvokeResult.decide(null);
        }
        if (arrayList.isEmpty()) {
            RVLogger.d(f24065a, "API " + this.c.actionName + " havePermission: " + arrayList);
            return ExtensionInvoker.InvokeResult.proceed();
        }
        RVLogger.d(f24065a, "API " + this.c.actionName + " need request permission: " + arrayList + ", reqCode: " + ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).getRequestCode());
        PermissionUtil.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), new IPermissionRequestCallback() { // from class: com.alibaba.ariver.engine.common.extension.NativePermissionExtensionInvoker.1
            @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
            public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                if (strArr2 == null || iArr == null || strArr2.length != iArr.length || arrayList.size() != strArr2.length) {
                    return;
                }
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr2.length) {
                        z = true;
                        break;
                    } else if (iArr[i2] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    RVLogger.d(NativePermissionExtensionInvoker.f24065a, "API " + NativePermissionExtensionInvoker.this.c.actionName + " permission check success!");
                    NativePermissionExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
                    return;
                }
                RVLogger.d(NativePermissionExtensionInvoker.f24065a, "API " + NativePermissionExtensionInvoker.this.c.actionName + " permission check fail!");
                failedSet.add(NativePermissionExtensionInvoker.this.c.actionName);
                NativePermissionExtensionInvoker.this.b.sendError(5, RVKernelUtils.getResources().getString(R.string.api_error_no_storage_permission));
            }
        });
        return ExtensionInvoker.InvokeResult.pending();
    }
}
