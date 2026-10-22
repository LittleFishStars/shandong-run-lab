package com.alibaba.ariver.kernel.api.extension;

import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.extension.registry.BridgeDSLRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ExtensionManager {
    void enterNode(Node node);

    void exitNode(Node node);

    ActionMeta findActionMeta(Node node, String str);

    ActionMeta findActionMeta(@NonNull InstanceType instanceType, Node node, String str);

    AccessController getAccessController();

    BridgeDSLRegistry getBridgeDSLRegistry();

    List<BridgeDSL> getBridgeDSLs();

    BridgeExtension getBridgeExtensionByActionMeta(Node node, ActionMeta actionMeta);

    Extension getExtensionByName(Node node, String str);

    List<Extension> getExtensionByPoint(Node node, Class<? extends Extension> cls);

    List<Extension> getExtensionByPoint(Class<? extends Extension> cls);

    ExtensionRegistry getExtensionRegistry();

    RemoteController getRemoteController();

    <T extends Extension> void registerExtensionByPoint(Node node, Class<T> cls, T t);

    void setAccessControlManagement(AccessControlManagement accessControlManagement);

    void setExtensionFilter(Class<? extends Extension> cls, ExtensionFilter extensionFilter);

    <T extends Extension> void setExtensionSorter(Class<T> cls, Comparator<? super T> comparator);

    void setRemoteControlManagement(RemoteControlManagement remoteControlManagement);
}
