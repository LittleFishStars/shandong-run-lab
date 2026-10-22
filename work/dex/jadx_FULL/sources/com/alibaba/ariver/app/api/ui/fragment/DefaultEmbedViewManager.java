package com.alibaba.ariver.app.api.ui.fragment;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformance;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultEmbedViewManager implements IEmbedViewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23828a = "AriverApp:DefaultEmbedViewManager";
    private static final int b = 20;
    private Page f;
    private final Map<String, IEmbedView> c = new ConcurrentHashMap();
    private final List<IEmbedView> d = new ArrayList();
    private final List<String> e = new ArrayList();
    final Map<String, Queue<Render>> mRenderQueueMap = new ConcurrentHashMap();
    final Map<String, Queue<Message>> mMessageQueueMap = new ConcurrentHashMap();

    public static class Message {
        String actionType;
        BridgeCallback bridgeCallback;
        JSONObject data;

        private Message(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
            this.actionType = str;
            this.data = jSONObject;
            this.bridgeCallback = bridgeCallback;
        }
    }

    public static class Render {
        BridgeCallback callback;
        JSONObject data;

        private Render(JSONObject jSONObject, BridgeCallback bridgeCallback) {
            this.data = jSONObject;
            this.callback = bridgeCallback;
        }
    }

    public DefaultEmbedViewManager(Page page) {
        this.f = page;
    }

    private void a(final IEmbedView iEmbedView, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    iEmbedView.onReceivedRender(jSONObject, bridgeCallback);
                } catch (Throwable th) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "EmbedView onReceivedRender exception: " + th));
                }
            }
        });
    }

    public void clearBaseView() {
        if (this.c.isEmpty() || this.e.isEmpty()) {
            return;
        }
        for (String str : this.e) {
            if (!TextUtils.isEmpty(str)) {
                IEmbedView iEmbedView = this.c.get(str);
                this.c.remove(str);
                this.d.remove(iEmbedView);
            }
        }
        this.e.clear();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public synchronized IEmbedView createView(String str, String str2) {
        IEmbedView iEmbedViewCreateEmbedView;
        RVLogger.d(f23828a, "createView for viewId: " + str + " type: " + str2);
        iEmbedViewCreateEmbedView = this.c.get(str);
        if (iEmbedViewCreateEmbedView == null) {
            iEmbedViewCreateEmbedView = ((EmbedViewProvider) RVProxy.get(EmbedViewProvider.class)).createEmbedView(str2, this.f);
            if (iEmbedViewCreateEmbedView instanceof IEmbedPerformance) {
                a(str2, (IEmbedPerformance) iEmbedViewCreateEmbedView);
            }
            if (TextUtils.equals(str2, "newembedbase")) {
                clearBaseView();
                this.e.add(str);
            }
            HashMap map = new HashMap();
            map.put(RVConstants.EXTRA_APP_INSTANCE_ID, this.f.getApp().getNodeId() + "");
            map.put(RVConstants.EXTRA_PAGE_INSTANCE_ID, this.f.getNodeId() + "");
            map.put(RVConstants.EXTRA_EMBED_VIEW_ID, str);
            iEmbedViewCreateEmbedView.onCreate(map);
            synchronized (this.c) {
                this.c.put(str, iEmbedViewCreateEmbedView);
                this.d.add(iEmbedViewCreateEmbedView);
                Queue<Render> queueRemove = this.mRenderQueueMap.remove(str);
                if (queueRemove != null) {
                    for (Render render : queueRemove) {
                        a(iEmbedViewCreateEmbedView, render.data, render.callback);
                    }
                    queueRemove.clear();
                }
                Queue<Message> queueRemove2 = this.mMessageQueueMap.remove(str);
                if (queueRemove2 != null) {
                    for (Message message : queueRemove2) {
                        a(iEmbedViewCreateEmbedView, message.actionType, message.data, message.bridgeCallback);
                    }
                    queueRemove2.clear();
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("elementid", (Object) str);
            EngineUtils.sendToRender(this.f.getRender(), RVEvents.NBCOMPONENT_CANRENDER, jSONObject, null);
        }
        return iEmbedViewCreateEmbedView;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void destroyView(String str) {
        IEmbedView iEmbedViewRemove = this.c.remove(str);
        if (iEmbedViewRemove != null) {
            iEmbedViewRemove.onDestroy();
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void dispatchRender(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        synchronized (this.c) {
            IEmbedView iEmbedViewFindViewById = findViewById(str);
            if (iEmbedViewFindViewById != null) {
                a(iEmbedViewFindViewById, jSONObject, bridgeCallback);
                return;
            }
            Queue<Render> arrayBlockingQueue = this.mRenderQueueMap.get(str);
            if (arrayBlockingQueue == null) {
                arrayBlockingQueue = new ArrayBlockingQueue<>(20);
                this.mRenderQueueMap.put(str, arrayBlockingQueue);
            }
            arrayBlockingQueue.add(new Render(jSONObject, bridgeCallback));
            RVLogger.d(f23828a, "findViewById " + str + " null, just add to render queueMap!");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void dispatchSendMessage(String str, String str2, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        synchronized (this.c) {
            IEmbedView iEmbedViewFindViewById = findViewById(str);
            if (iEmbedViewFindViewById != null) {
                a(iEmbedViewFindViewById, str2, jSONObject, bridgeCallback);
                return;
            }
            Queue<Message> arrayBlockingQueue = this.mMessageQueueMap.get(str);
            if (arrayBlockingQueue == null) {
                arrayBlockingQueue = new ArrayBlockingQueue<>(20);
                this.mMessageQueueMap.put(str, arrayBlockingQueue);
            }
            arrayBlockingQueue.add(new Message(str2, jSONObject, bridgeCallback));
            RVLogger.d(f23828a, "findViewById " + str + " null, just add to message queueMap!");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public List<IEmbedView> findAllEmbedView() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public IEmbedView findViewById(String str) {
        return this.c.get(str);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        Iterator<IEmbedView> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionResult(i, strArr, iArr);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void releaseViews() {
        for (IEmbedView iEmbedView : this.c.values()) {
            try {
                iEmbedView.onDestroy();
            } catch (Throwable th) {
                if (RVKernelUtils.isDebug()) {
                    throw th;
                }
                RVLogger.e(f23828a, "release view " + iEmbedView.getType() + " error!", th);
            }
        }
        this.d.clear();
        this.c.clear();
        this.mRenderQueueMap.clear();
        this.mMessageQueueMap.clear();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedViewManager
    public void triggerPreSnapshot() {
        try {
            Map<String, IEmbedView> map = this.c;
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator<IEmbedView> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().triggerPreSnapshot();
            }
        } catch (Throwable th) {
            RVLogger.e(f23828a, "triggerPreSnapshot catch throwable ", th);
        }
    }

    private void a(final IEmbedView iEmbedView, final String str, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    iEmbedView.onReceivedMessage(str, jSONObject, bridgeCallback);
                } catch (Throwable th) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "EmbedView onReceivedMessage exception: " + th));
                }
            }
        });
    }

    private void a(final String str, IEmbedPerformance iEmbedPerformance) {
        final WeakReference weakReference = new WeakReference(this.f);
        final int iHashCode = iEmbedPerformance.hashCode();
        iEmbedPerformance.setPerformanceReporter(new IEmbedPerformanceReporter() { // from class: com.alibaba.ariver.app.api.ui.fragment.DefaultEmbedViewManager.3
            @Override // com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter
            public void onRenderFinished(long j) {
                try {
                    RVLogger.d(DefaultEmbedViewManager.f23828a, "on render finished type=" + str + ", obj=" + iHashCode + ",elapsedRealtime" + j);
                    Page page = (Page) weakReference.get();
                    if (page == null || page.isExited() || page.isDestroyed()) {
                        return;
                    }
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, "embed_view_" + str + LoginConstants.UNDER_LINE + iHashCode, j);
                } catch (Throwable th) {
                    RVLogger.e(DefaultEmbedViewManager.f23828a, " embed view render finished callback error!", th);
                }
            }
        });
    }
}
