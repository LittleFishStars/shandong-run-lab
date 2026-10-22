package com.alibaba.ariver.kernel.ipc;

import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShadowNodePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24290a = "AriverKernel:ShadowNodePool";
    private static ShadowNodePool b;
    private final LongSparseArray<Set<Long>> c = new LongSparseArray<>();
    private final Map<Long, Node> d = new ConcurrentHashMap();

    public static ShadowNodePool getInstance() {
        if (b == null) {
            synchronized (ShadowNodePool.class) {
                if (b == null) {
                    b = new ShadowNodePool();
                }
            }
        }
        return b;
    }

    public void bindStartToken(long j, long j2) {
        Set<Long> hashSet = this.c.get(j);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.c.put(j, hashSet);
        }
        hashSet.add(Long.valueOf(j2));
    }

    public Node createOrGetNode(Node node, long j) {
        Node node2 = this.d.get(Long.valueOf(j));
        if (node2 != null) {
            return node2;
        }
        if (node == null) {
            return null;
        }
        RVLogger.d(f24290a, "generateNodeId " + j + " for localNode: " + node);
        boolean configBoolean = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_enableShadowNodeOpt", true);
        Node node3 = node;
        while (node3.getParentNode() != null) {
            Node parentNode = node3.getParentNode();
            if (configBoolean) {
                Node node4 = this.d.get(Long.valueOf(parentNode.getNodeId()));
                if (node4 == null) {
                    parentNode.onInitialized();
                    RVLogger.d(f24290a, "generateNodeId " + parentNode.getNodeId() + " for parentNode: " + parentNode);
                    this.d.put(Long.valueOf(parentNode.getNodeId()), parentNode);
                } else {
                    RVLogger.d(f24290a, "replace parentNode " + parentNode.getNodeId() + " and instance " + parentNode + " to existed: " + node4);
                    node3.setParentNode(node4);
                }
            } else {
                parentNode.onInitialized();
            }
            node3 = parentNode;
        }
        node.onInitialized();
        this.d.put(Long.valueOf(j), node);
        return node;
    }

    public void onNodeExit(long j) {
        Node nodeRemove = this.d.remove(Long.valueOf(j));
        RVLogger.d(f24290a, "onNodeExit " + j + " node: " + nodeRemove);
        if (nodeRemove != null) {
            nodeRemove.onFinalized();
        }
    }

    public void unBindStartToken(long j) {
        RVLogger.d(f24290a, "unBindStartToken " + j);
        Set<Long> set = this.c.get(j);
        if (set != null) {
            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                onNodeExit(it.next().longValue());
            }
        }
        this.c.remove(j);
    }
}
