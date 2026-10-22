package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.R;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MyTBMiniAppVideoStd extends TBMiniAppVideoStd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24833a = 0;
    private static BridgeCallback aY = null;
    private static TriverEmbedVideoView aZ = null;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;

    public MyTBMiniAppVideoStd(Context context) {
        super(context);
    }

    public static TriverEmbedVideoView getEmbedview() {
        return aZ;
    }

    public static BridgeCallback getGlobalJSCallback() {
        return aY;
    }

    public static void r() {
        aY = null;
        aZ = null;
    }

    public void a(BridgeCallback bridgeCallback, TriverEmbedVideoView triverEmbedVideoView) {
        aY = bridgeCallback;
        aZ = triverEmbedVideoView;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void b() {
        super.b();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void c() {
        super.c();
        TriverEmbedVideoView triverEmbedVideoView = aZ;
        if (triverEmbedVideoView != null) {
            triverEmbedVideoView.a(3);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void d() {
        super.d();
        TriverEmbedVideoView triverEmbedVideoView = aZ;
        if (triverEmbedVideoView != null) {
            triverEmbedVideoView.a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", (Object) Float.valueOf(motionEvent.getX()));
            jSONObject2.put("y", (Object) Float.valueOf(motionEvent.getY()));
            jSONObject.put("ptInView", (Object) jSONObject2);
            TriverEmbedVideoView triverEmbedVideoView = aZ;
            if (triverEmbedVideoView != null) {
                triverEmbedVideoView.sendEvent("onTap", jSONObject, null);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void e() {
        super.e();
        TriverEmbedVideoView triverEmbedVideoView = aZ;
        if (triverEmbedVideoView != null) {
            triverEmbedVideoView.a(2);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void f() {
        super.f();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void g() {
        super.g();
        TriverEmbedVideoView triverEmbedVideoView = aZ;
        if (triverEmbedVideoView != null) {
            triverEmbedVideoView.a(4);
            aZ.c();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public int getLayoutId() {
        return R.layout.triver_jz_layout_standard;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void h() {
        super.h();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void i() {
        super.i();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void j() {
        super.j();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void k() {
        super.k();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void l() {
        super.l();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void m() {
        super.m();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void n() {
        super.n();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd
    public void o() {
        super.o();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.trv_fullscreen) {
                if (this.M == 2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fullScreen", (Object) Boolean.FALSE);
                    jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, (Object) "vertical");
                    TriverEmbedVideoView triverEmbedVideoView = aZ;
                    if (triverEmbedVideoView != null) {
                        triverEmbedVideoView.sendEvent("onFullScreenChange", jSONObject, null);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("fullScreen", (Object) Boolean.TRUE);
                    jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, (Object) "vertical");
                    TriverEmbedVideoView triverEmbedVideoView2 = aZ;
                    if (triverEmbedVideoView2 != null) {
                        triverEmbedVideoView2.sendEvent("onFullScreenChange", jSONObject2, null);
                    }
                }
            }
            super.onClick(view);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void p() {
        super.p();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void q() {
        super.q();
    }

    public MyTBMiniAppVideoStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void b(int i, int i2) {
        super.b(i, i2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("what", (Object) Integer.valueOf(i));
        jSONObject.put("extra", (Object) Integer.valueOf(i2));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(TriverEmbedVideoView.b, (Object) jSONObject);
        BridgeCallback bridgeCallback = aY;
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd, com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(Context context) {
        super.a(context);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(long j, long j2, long j3) {
        if (aZ == null || this.L == 5) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("currentTime", (Object) Long.valueOf(j));
        jSONObject.put("userPlayDuration", (Object) Long.valueOf(j3));
        jSONObject.put("videoDuration", (Object) Long.valueOf(j2));
        aZ.sendEvent("onTimeUpdate", jSONObject, null);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a() {
        super.a();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(int i, int i2) {
        super.a(i, i2);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(int i) {
        super.a(i);
    }
}
