package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.canvas.data.CanvasDumpInfo;
import com.alibaba.mobile.canvas.data.CanvasFpsInfo;
import com.alibaba.mobile.canvas.data.CanvasMemoryInfo;
import com.alibaba.mobile.canvas.data.CanvasStartupInfo;
import com.alibaba.mobile.canvas.misc.CanvasDataTrace;
import com.alibaba.mobile.tinycanvas.misc.TinyAppEnv;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends CanvasDataTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25235a = "GCanvasTriver";
    public static final String b = "Init";
    public static final String c = "Performance";
    private TinyAppEnv d;

    public e(TinyAppEnv tinyAppEnv) {
        this.d = tinyAppEnv;
    }

    public void a(CanvasDumpInfo canvasDumpInfo) {
        JSONObject jSONObject = new JSONObject();
        TinyAppEnv tinyAppEnv = this.d;
        if (tinyAppEnv != null) {
            jSONObject.put("app_id", (Object) tinyAppEnv.getAppId());
            jSONObject.put("page_url", (Object) this.d.getPagePath());
        } else {
            jSONObject.put("app_id", (Object) "null");
            jSONObject.put("page_url", (Object) "null");
        }
        jSONObject.put("canvas_id", (Object) canvasDumpInfo.canvasDesc.getCanvasId());
        jSONObject.put("context", (Object) canvasDumpInfo.contextType);
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackCounter(f25235a, b, 1, jSONObject.toJSONString());
    }

    public void a(CanvasMemoryInfo canvasMemoryInfo, CanvasDumpInfo canvasDumpInfo) {
    }

    public void a(CanvasStartupInfo canvasStartupInfo, CanvasDumpInfo canvasDumpInfo) {
    }

    public void a(CanvasFpsInfo canvasFpsInfo, CanvasDumpInfo canvasDumpInfo) {
        JSONObject jSONObject = new JSONObject();
        TinyAppEnv tinyAppEnv = this.d;
        if (tinyAppEnv != null) {
            jSONObject.put("app_id", (Object) tinyAppEnv.getAppId());
            jSONObject.put("page_url", (Object) this.d.getPagePath());
        } else {
            jSONObject.put("app_id", (Object) "null");
            jSONObject.put("page_url", (Object) "null");
        }
        jSONObject.put("context", (Object) canvasDumpInfo.contextType);
        jSONObject.put("canvas_id", (Object) canvasDumpInfo.canvasDesc.getCanvasId());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AliyunLogKey.KEY_FPS, (Object) decimalFormat.format(canvasFpsInfo.avgFps));
        jSONObject2.put("drawcall", (Object) 0);
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat(f25235a, c, jSONObject, jSONObject2);
    }
}
