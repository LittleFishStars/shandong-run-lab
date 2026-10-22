package com.alibaba.ariver.remotedebug.jsapi;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.view.RemoteDebugInfoPanelView;
import com.alibaba.ariver.remotedebug.view.a;
import com.alibaba.ariver.remotedebug.view.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteDebugViewBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24390a = "AriverAPI:RemoteDebugViewBridgeExtension";
    private static final String b = "connected";
    private static final String c = "connecting";
    private static final String d = "disconnected";
    private static final String e = "tinyRemoteDebugPanelButtonClick";
    private static final String f = "tinyRemoteDebugMaskButtonClick";
    private b g;
    private RemoteDebugInfoPanelView h;
    private WeakReference<Page> i;
    private WeakReference<Page> j;

    @Nullable
    private b a(Page page) {
        Activity activity;
        if (this.g == null) {
            RVLogger.d(f24390a, "create panelView.");
            if (page.getPageContext() != null && (activity = page.getPageContext().getActivity()) != null) {
                b bVar = new b(activity);
                this.g = bVar;
                bVar.setActionEventListener(new a() { // from class: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension.1
                    @Override // com.alibaba.ariver.remotedebug.view.a
                    public void a() {
                        if (RemoteDebugViewBridgeExtension.this.i == null || RemoteDebugViewBridgeExtension.this.i.get() == null) {
                            RVLogger.d(RemoteDebugViewBridgeExtension.f24390a, "mMaskPageRef or page is null");
                        } else {
                            EngineUtils.sendToRender(((Page) RemoteDebugViewBridgeExtension.this.i.get()).getRender(), RemoteDebugViewBridgeExtension.f, null, null);
                        }
                    }
                });
            }
            RVLogger.d(f24390a, "create panelView error!");
        }
        return this.g;
    }

    @Nullable
    private RemoteDebugInfoPanelView b(Page page) {
        Activity activity;
        if (this.h == null) {
            RVLogger.d(f24390a, "create panelView.");
            if (page.getPageContext() != null && (activity = page.getPageContext().getActivity()) != null) {
                RemoteDebugInfoPanelView remoteDebugInfoPanelView = new RemoteDebugInfoPanelView(activity);
                this.h = remoteDebugInfoPanelView;
                remoteDebugInfoPanelView.setActionEventListener(new a() { // from class: com.alibaba.ariver.remotedebug.jsapi.RemoteDebugViewBridgeExtension.2
                    @Override // com.alibaba.ariver.remotedebug.view.a
                    public void a() {
                        if (RemoteDebugViewBridgeExtension.this.j == null || RemoteDebugViewBridgeExtension.this.j.get() == null) {
                            RVLogger.d(RemoteDebugViewBridgeExtension.f24390a, "mPanelPageRef or page is null");
                        } else {
                            EngineUtils.sendToRender(((Page) RemoteDebugViewBridgeExtension.this.j.get()).getRender(), RemoteDebugViewBridgeExtension.e, null, null);
                        }
                    }
                });
            }
            RVLogger.d(f24390a, "create panelView error!");
        }
        return this.h;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showRemoteDebugMask(@BindingNode(Page.class) Page page, @BindingParam({"text"}) String str, @BindingParam({"buttonTitle"}) String str2, @BindingParam({"hide"}) boolean z) {
        b bVarA = a(page);
        if (bVarA == null) {
            RVLogger.d(f24390a, "maskView is null.");
            return BridgeResponse.newError(2, "maskView is null");
        }
        if (z) {
            bVarA.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(str)) {
                RVLogger.d(f24390a, "text is empty");
                return BridgeResponse.newError(2, "text is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                RVLogger.d(f24390a, "buttonTitle is empty");
                return BridgeResponse.newError(2, "buttonTitle is empty");
            }
            bVarA.setStateText(str);
            bVarA.setExitText(str2);
            bVarA.setVisibility(0);
        }
        this.i = new WeakReference<>(page);
        return BridgeResponse.SUCCESS;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0077  */
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showRemoteDebugPanel(@BindingNode(Page.class) Page page, @BindingParam({"status"}) String str, @BindingParam({"text"}) String str2, @BindingParam({"buttonTitle"}) String str3) {
        byte b2 = 2;
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(f24390a, "status is empty");
            return BridgeResponse.newError(2, "status is empty");
        }
        if (TextUtils.isEmpty(str2)) {
            RVLogger.d(f24390a, "text is empty");
            return BridgeResponse.newError(2, "text is empty");
        }
        if (TextUtils.isEmpty(str3)) {
            RVLogger.d(f24390a, "buttonTitle is empty");
            return BridgeResponse.newError(2, "buttonTitle is empty");
        }
        RemoteDebugInfoPanelView remoteDebugInfoPanelViewB = b(page);
        if (remoteDebugInfoPanelViewB == null) {
            RVLogger.d(f24390a, "panelView is null.");
            return BridgeResponse.newError(2, "panelView is null.");
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1381388741) {
            if (iHashCode != -775651656) {
                if (iHashCode != -579210487 || !str.equals(b)) {
                    b2 = -1;
                }
            } else if (str.equals(c)) {
                b2 = 0;
            } else {
                b2 = -1;
            }
        } else if (str.equals("disconnected")) {
            b2 = 1;
        } else {
            b2 = -1;
        }
        if (b2 == 0) {
            remoteDebugInfoPanelViewB.a();
        } else if (b2 != 1) {
            remoteDebugInfoPanelViewB.b();
        } else {
            remoteDebugInfoPanelViewB.c();
        }
        remoteDebugInfoPanelViewB.setStateText(str2);
        remoteDebugInfoPanelViewB.setExitText(str3);
        this.j = new WeakReference<>(page);
        return BridgeResponse.SUCCESS;
    }
}
