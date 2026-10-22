package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NodeAwareUtils {
    public static void handleSetNode(Node node, Extension extension) {
        NodeAware nodeAware;
        Class nodeType;
        boolean z;
        if (!(extension instanceof NodeAware) || (nodeType = (nodeAware = (NodeAware) extension).getNodeType()) == null) {
            return;
        }
        Node parentNode = node;
        while (true) {
            if (parentNode == null) {
                z = false;
                break;
            } else {
                if (nodeType.isAssignableFrom(parentNode.getClass())) {
                    nodeAware.setNode(new WeakReference(parentNode));
                    z = true;
                    break;
                }
                parentNode = parentNode.getParentNode();
            }
        }
        if (z) {
            return;
        }
        RVLogger.w("AriverKernel:ExtensionInvoker:Aware", "cannot find Wanted node type: " + nodeType + " with target node: " + node + " in extension " + extension);
    }
}
