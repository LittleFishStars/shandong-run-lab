package com.alibaba.ariver.engine.api.bridge.remote;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteCallbackPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24054a = "AriverEngine:RemoteCallbackPool";
    private static RemoteCallbackPool c;
    private final LongSparseArray<Map<String, SendToNativeCallback>> b = new LongSparseArray<>();
    private int d = 0;

    public static RemoteCallbackPool getInstance() {
        if (c == null) {
            synchronized (RemoteCallbackPool.class) {
                if (c == null) {
                    c = new RemoteCallbackPool();
                }
            }
        }
        return c;
    }

    @Nullable
    public synchronized SendToNativeCallback getCallback(long j, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SendToNativeCallback> map = this.b.get(j);
        if (map == null) {
            return null;
        }
        SendToNativeCallback sendToNativeCallback = map.get(str);
        if (sendToNativeCallback != null && z) {
            map.remove(str);
            this.d--;
            if (map.isEmpty()) {
                this.b.remove(j);
            }
        }
        return sendToNativeCallback;
    }

    public int getCallbackCount() {
        return this.d;
    }

    public synchronized void registerCallback(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
        Node node = nativeCallContext.getNode();
        if (node == null) {
            RVLogger.w(f24054a, "registerCallback but node == null!");
            return;
        }
        Map<String, SendToNativeCallback> map = this.b.get(node.getNodeId());
        if (map == null) {
            map = new HashMap<>();
            this.b.put(node.getNodeId(), map);
        }
        this.d++;
        map.put(nativeCallContext.getId(), sendToNativeCallback);
    }
}
