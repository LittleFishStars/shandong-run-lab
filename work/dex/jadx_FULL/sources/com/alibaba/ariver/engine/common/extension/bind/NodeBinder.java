package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NodeBinder implements Binder<BindingNode, Node> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24069a = "AriverApp:NodeBinder";
    private Node b;

    public NodeBinder(Node node) {
        this.b = node;
    }

    private Node a(Class<? extends Scope> cls, Node node) {
        Class scopeType;
        if (node == null || !(node instanceof Scope) || (scopeType = ((Scope) node).getScopeType()) == null) {
            return null;
        }
        return scopeType.equals(cls) ? node : a(cls, node.getParentNode());
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public Node bind(Class<Node> cls, BindingNode bindingNode) {
        Node nodeA = a(bindingNode.value(), this.b);
        if (nodeA == null) {
            RVLogger.w(f24069a, "Cannot find scope for node: " + this.b + " scope: " + bindingNode.value());
        }
        return nodeA;
    }
}
