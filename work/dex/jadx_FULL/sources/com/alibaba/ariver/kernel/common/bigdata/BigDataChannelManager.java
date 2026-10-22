package com.alibaba.ariver.kernel.common.bigdata;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BigDataChannelManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24231a = "AriverKernel:BigDataChannelManager";
    private Map<String, BigDataChannelModel> b;
    private Map<String, IBigDataChannelCallback> c;

    public static class InstanceHolder {
        static BigDataChannelManager sInstance = new BigDataChannelManager();

        private InstanceHolder() {
        }
    }

    public static BigDataChannelManager getInstance() {
        return InstanceHolder.sInstance;
    }

    public String createChannel(String str, String str2, int i, int i2) {
        return createChannel(str, str2, i, i2, null);
    }

    public String createChannelWithBuffer(String str, String str2, int i, int i2, int i3) {
        return createChannelWithBuffer(str, str2, i, i2, 0, null);
    }

    public String createDirectPassChannel(String str, String str2, int i, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        return createChannel(str, str2, i, 1, iBigDataConsumerReadyCallback);
    }

    public boolean isConsumerReady(String str) {
        BigDataChannelModel bigDataChannelModel;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24231a, "channel id is null");
            return false;
        }
        Map<String, BigDataChannelModel> map = this.b;
        if (map == null || (bigDataChannelModel = map.get(str)) == null) {
            return false;
        }
        return bigDataChannelModel.isConsumerReady();
    }

    public JSONObject pickNext(String str) {
        Map<String, BigDataChannelModel> map = this.b;
        if (map == null || map.isEmpty()) {
            RVLogger.e(f24231a, "pickNext, no data");
            return null;
        }
        BigDataChannelModel bigDataChannelModel = this.b.get(str);
        if (bigDataChannelModel != null) {
            return bigDataChannelModel.getBufferedData();
        }
        RVLogger.e(f24231a, "pickNext, no channel");
        return null;
    }

    public void pushData(String str, JSONObject jSONObject) {
        if (this.b == null) {
            this.b = new ConcurrentHashMap(8);
        }
        BigDataChannelModel bigDataChannelModel = this.b.get(str);
        if (bigDataChannelModel == null) {
            RVLogger.e(f24231a, "please invoke createChannel first !!!");
            return;
        }
        if (!jSONObject.containsKey("channelId")) {
            jSONObject.put("channelId", (Object) str);
        }
        if (!jSONObject.containsKey("workerId")) {
            jSONObject.put("workerId", (Object) bigDataChannelModel.getWorkerId());
        }
        if (!jSONObject.containsKey("viewId")) {
            jSONObject.put("viewId", (Object) bigDataChannelModel.getViewId());
        }
        IBigDataChannelCallback iBigDataChannelCallback = this.c.get(bigDataChannelModel.getWorkerId());
        if (1 == bigDataChannelModel.getPolicy()) {
            if (iBigDataChannelCallback != null) {
                iBigDataChannelCallback.onReceiveData(jSONObject);
            }
        } else if (2 == bigDataChannelModel.getPolicy()) {
            bigDataChannelModel.enqueueBuffer(jSONObject);
        }
    }

    public void readyForNextData(String str, String str2) {
        BigDataChannelModel bigDataChannelModel;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24231a, "channel id is null");
            return;
        }
        Map<String, BigDataChannelModel> map = this.b;
        if (map == null || (bigDataChannelModel = map.get(str)) == null) {
            return;
        }
        bigDataChannelModel.setConsumerReady(true);
        IBigDataConsumerReadyCallback callback = bigDataChannelModel.getCallback();
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channelId", (Object) str);
            jSONObject.put("viewId", (Object) str2);
            callback.onConsumerReady(jSONObject);
        }
    }

    public void registerReceiveDataCallback(String str, IBigDataChannelCallback iBigDataChannelCallback) {
        this.c.put(str, iBigDataChannelCallback);
    }

    public void releaseAllChannel() {
        Map<String, BigDataChannelModel> map = this.b;
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            BigDataChannelModel bigDataChannelModel = this.b.get(str);
            if (bigDataChannelModel != null) {
                bigDataChannelModel.releaseBuffer();
            }
            IBigDataChannelCallback iBigDataChannelCallback = this.c.get(bigDataChannelModel.getWorkerId());
            if (iBigDataChannelCallback != null) {
                iBigDataChannelCallback.onChannelReleased(str);
            }
        }
        this.c.clear();
        this.b.clear();
    }

    public void releaseChannelByChannelId(String str) {
        IBigDataChannelCallback iBigDataChannelCallback;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, BigDataChannelModel> map = this.b;
        String workerId = "";
        if (map != null) {
            BigDataChannelModel bigDataChannelModel = map.get(str);
            workerId = bigDataChannelModel != null ? bigDataChannelModel.getWorkerId() : "";
            this.b.remove(str);
        }
        if (TextUtils.isEmpty(workerId) || (iBigDataChannelCallback = this.c.get(workerId)) == null) {
            return;
        }
        iBigDataChannelCallback.onChannelReleased(str);
    }

    public void releaseChannelByWorkerId(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || this.c.get(str) == null) {
            return;
        }
        this.c.remove(str);
    }

    private BigDataChannelManager() {
        this.c = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap(8);
    }

    public String createChannel(String str, String str2, int i, int i2, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        return createChannelWithBuffer(str, str2, i, i2, 0, iBigDataConsumerReadyCallback);
    }

    public String createChannelWithBuffer(String str, String str2, int i, int i2, int i3, IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        String string = UUID.randomUUID().toString();
        BigDataChannelModel bigDataChannelModel = new BigDataChannelModel();
        bigDataChannelModel.setChannelId(string);
        bigDataChannelModel.setWorkerId(str);
        bigDataChannelModel.setViewId(str2);
        bigDataChannelModel.setBizType(i);
        bigDataChannelModel.setBufferSize(i3);
        bigDataChannelModel.setPolicy(i2);
        bigDataChannelModel.setConsumerReady(true);
        bigDataChannelModel.setCallback(iBigDataConsumerReadyCallback);
        this.b.put(string, bigDataChannelModel);
        if (this.c.get(str) != null) {
            this.c.get(str).onChannelCreated(string, str, str2);
        }
        return string;
    }
}
