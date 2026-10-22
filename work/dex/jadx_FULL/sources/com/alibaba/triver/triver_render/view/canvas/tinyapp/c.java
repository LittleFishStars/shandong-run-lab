package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.canvas.misc.CanvasUtil;
import com.alibaba.mobile.canvas.plugin.CanvasTracePlugin;
import com.alibaba.mobile.tinycanvas.util.TinyLogUtils;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements CanvasTracePlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25231a = "exception";
    public static final String b = "appId";

    private void b(Map<String, Object> map) {
        String mapStringValue = CanvasUtil.getMapStringValue(map, "appId");
        String mapStringValue2 = CanvasUtil.getMapStringValue(map, com.heytap.mcssdk.constant.b.k);
        Map map2 = (Map) map.get("extParam");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", (Object) mapStringValue);
        StringBuilder sb = new StringBuilder();
        if (map2 != null) {
            for (Map.Entry entry : map2.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(c49.f40900a);
                sb.append(entry.getValue().toString());
                sb.append("\n");
                if (sb.length() > 100) {
                    break;
                }
            }
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, e.f25235a, f25231a, mapStringValue2, sb.toString(), jSONObject.toJSONString());
    }

    public void a(Map<String, Object> map) {
        TinyLogUtils.i(String.format("[CanvasTracePlugin]:%s", map));
        String mapStringValue = CanvasUtil.getMapStringValue(map, IpcMessageConstants.EXTRA_EVENT);
        if (TextUtils.isEmpty(mapStringValue)) {
            b(map);
        } else {
            a(map, mapStringValue);
        }
    }

    private void a(Map<String, Object> map, String str) {
        String str2;
        String mapStringValue = CanvasUtil.getMapStringValue(map, "message");
        Map<String, String> mapA = a(CanvasUtil.getMapStringValue(map, MediationConstant.KEY_EXTRA_INFO));
        if (mapA.containsKey("appId")) {
            str2 = mapA.get("appId");
            mapA.remove("appId");
        } else {
            str2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", (Object) str2);
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, e.f25235a, f25231a, str.equals("GL_INFO") ? "100722" : "102015", mapStringValue, jSONObject.toJSONString());
    }

    private Map<String, String> a(String str) {
        JSONObject object;
        HashMap map = new HashMap();
        try {
            return (TextUtils.isEmpty(str) || (object = JSON.parseObject(str)) == null) ? map : object;
        } catch (Exception e) {
            TinyLogUtils.w("Canvas:Tiny", e);
            return map;
        }
    }
}
