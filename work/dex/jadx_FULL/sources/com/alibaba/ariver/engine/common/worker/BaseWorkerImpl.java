package com.alibaba.ariver.engine.common.worker;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseWorkerImpl implements Worker {
    public static final String APPX_WORKER_JS_URL = "https://appx/af-appx.worker.min.js";
    protected String mAppId;
    protected boolean mDestroyed;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    protected boolean mPreStarted;
    protected List<RenderReadyListener> mRenderReadyListeners;
    protected Bundle mStartupParams;
    protected String mWorkerId;
    protected List<Worker.WorkerReadyListener> mWorkerReadyListeners;
    protected volatile boolean mWorkerReady = false;
    protected volatile boolean mRenderReady = false;
    protected boolean mAlipayJSBridgeReady = false;
    protected String mAppxVersionInWorker = null;
    private final Object mLock = new Object();
    private int COUNT = 0;

    public interface RenderReadyListener {
        void onRenderReady();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        synchronized (this.mLock) {
            if (this.mDestroyed) {
                return;
            }
            this.mDestroyed = true;
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            List<Worker.WorkerReadyListener> list = this.mWorkerReadyListeners;
            if (list != null) {
                list.clear();
            }
            List<RenderReadyListener> list2 = this.mRenderReadyListeners;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppxVersionInWorker() {
        return this.mAppxVersionInWorker;
    }

    public abstract String getLogTag();

    public Bundle getStartupParams() {
        return this.mStartupParams;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        if (this.mHandler == null) {
            synchronized (this) {
                if (this.mHandler == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ariver-post-message-");
                    int i = this.COUNT;
                    this.COUNT = i + 1;
                    sb.append(i);
                    HandlerThread handlerThread = new HandlerThread(sb.toString(), 5);
                    this.mHandlerThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mHandlerThread.getLooper());
                }
            }
        }
        return this.mHandler;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public String getWorkerId() {
        return this.mWorkerId;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mDestroyed;
        }
        return z;
    }

    public boolean isPrestarted() {
        return this.mPreStarted;
    }

    public boolean isRenderReady() {
        return this.mRenderReady;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public boolean isWorkerReady() {
        return this.mWorkerReady;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
    }

    public void onAlipayJSBridgeReady() {
        RVLogger.d(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        tryToInjectStartupParamsAndPushWorker();
    }

    public void registerRenderReadyListener(RenderReadyListener renderReadyListener) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mRenderReady) {
                z = true;
            } else {
                if (this.mRenderReadyListeners == null) {
                    this.mRenderReadyListeners = new ArrayList();
                }
                if (renderReadyListener != null && !this.mRenderReadyListeners.contains(renderReadyListener)) {
                    this.mRenderReadyListeners.add(renderReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            renderReadyListener.onRenderReady();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void registerWorkerReadyListener(Worker.WorkerReadyListener workerReadyListener) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mWorkerReady) {
                z = true;
            } else {
                if (this.mWorkerReadyListeners == null) {
                    this.mWorkerReadyListeners = new ArrayList();
                }
                if (workerReadyListener != null && !this.mWorkerReadyListeners.contains(workerReadyListener)) {
                    this.mWorkerReadyListeners.add(workerReadyListener);
                }
                z = false;
            }
        }
        if (z) {
            workerReadyListener.onWorkerReady();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(getAppId(), "", jSONObject == null ? "" : jSONObject.toJSONString(), sendToWorkerCallback);
    }

    public void sendMessageToWorker(String str, String str2, String str3) {
        sendMessageToWorker(str, str2, str3, null);
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public abstract void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback);

    public void sendPushCallBack(String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        sendPushCallBack(null, str, str2, sendToWorkerCallback);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAppxVersionInWorker(String str) {
        this.mAppxVersionInWorker = str;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        List<RenderReadyListener> list;
        RVLogger.e(getLogTag(), "setRenderReady");
        synchronized (this.mLock) {
            this.mRenderReady = true;
            list = this.mRenderReadyListeners;
            this.mRenderReadyListeners = null;
        }
        if (list != null) {
            Iterator<RenderReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRenderReady();
            }
            list.clear();
        }
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setStartupParams(Bundle bundle) {
        this.mStartupParams = (Bundle) bundle.clone();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void setWorkerId(String str) {
        this.mWorkerId = str;
    }

    public void setWorkerReady() {
        List<Worker.WorkerReadyListener> list;
        RVLogger.e(getLogTag(), "setWorkerReady");
        synchronized (this.mLock) {
            this.mWorkerReady = true;
            list = this.mWorkerReadyListeners;
            this.mWorkerReadyListeners = null;
        }
        if (list != null) {
            Iterator<Worker.WorkerReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onWorkerReady();
            }
            list.clear();
        }
    }

    public void sendPushCallBack(@Nullable JSONObject jSONObject, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        if (sendToWorkerCallback != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TextUtils.isEmpty(str)) {
                str = this.mWorkerId;
            }
            jSONObject.put("appId", (Object) str);
            jSONObject.put("result", "0");
            if (TextUtils.isEmpty(str2)) {
                str2 = "" + System.currentTimeMillis();
            }
            jSONObject.put("messageId", (Object) str2);
            RVLogger.d(getLogTag(), "sendPushCallBack..." + jSONObject.toJSONString());
            sendToWorkerCallback.onCallBack(jSONObject);
        }
    }
}
