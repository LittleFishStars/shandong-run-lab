package com.alibaba.triver.embed.video.fullscreenvideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.common.DomainNameController;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverEmbedVideoView extends BaseEmbedView {
    public static final String b = "onError";
    public static final int c = 0;
    public static final int d = 12;
    public static final int e = 13;
    public static final int f = 14;
    public static final int g = 15;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final String n = "video";
    private static final int p = 33;
    private static final String q = "AriverVideoComp";
    private static final String s = "please insure your video source is in domain whitelist";
    private static final String t = "SEEK_POSITION_KEY";
    private static final String u = "contain";
    private static final String v = "fill";
    private static final String w = "cover";
    private String A;
    private String B;
    private int Q;
    private WeakReference<Context> R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MyTBMiniAppVideoStd f24850a;
    private View r;
    private Activity y;
    private String x = "https://www.starbucks.com.cn/images/pages/apps-mobile-screens-cn.mp4";
    private boolean z = true;
    private boolean C = true;
    private boolean D = false;
    private int E = 0;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private int K = 0;
    private int L = 0;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private int P = 0;
    BridgeCallback o = null;

    public static class PerReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f24862a;

        public PerReceiver(a aVar) {
            this.f24862a = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                if (intent.getIntExtra(RequestPermission.REQUEST_CODE, 0) == 33) {
                    int[] intArrayExtra = intent.getIntArrayExtra(RequestPermission.GRANT_RESULTS);
                    String[] stringArrayExtra = intent.getStringArrayExtra(RequestPermission.PERMISSIONS);
                    int i = 0;
                    while (true) {
                        if (intArrayExtra == null || i >= intArrayExtra.length) {
                            z = true;
                            break;
                        } else {
                            if (intArrayExtra[i] != 0) {
                                this.f24862a.a(stringArrayExtra[i]);
                                break;
                            }
                            i++;
                        }
                    }
                    if (z) {
                        this.f24862a.a();
                    }
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            } catch (Throwable th) {
                RVLogger.e("Bridge", Log.getStackTraceString(th));
            }
        }
    }

    public interface a {
        void a();

        void a(String str);
    }

    public interface b {
        void a(Bitmap bitmap);
    }

    private void e() {
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd == null || myTBMiniAppVideoStd.L != 3) {
            return;
        }
        myTBMiniAppVideoStd.e();
        c.g();
    }

    private void f() {
        this.f24850a.A();
        this.f24850a.D();
        a(0);
    }

    private void g() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            HttpURLConnection f24858a = null;

            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                try {
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(TriverEmbedVideoView.this.B).openConnection();
                        this.f24858a = httpURLConnection2;
                        httpURLConnection2.setConnectTimeout(5000);
                        this.f24858a.connect();
                        if ((this.f24858a.getResponseCode() + "").startsWith("2")) {
                            final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.f24858a.getInputStream());
                            TriverEmbedVideoView.this.y.runOnUiThread(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView;
                                    MyTBMiniAppVideoStd myTBMiniAppVideoStd = TriverEmbedVideoView.this.f24850a;
                                    if (myTBMiniAppVideoStd == null || (imageView = myTBMiniAppVideoStd.ay) == null) {
                                        return;
                                    }
                                    imageView.setImageBitmap(bitmapDecodeStream);
                                }
                            });
                        }
                        httpURLConnection = this.f24858a;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (Exception e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                        httpURLConnection = this.f24858a;
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th) {
                    HttpURLConnection httpURLConnection3 = this.f24858a;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        RVLogger.d(q, "getType: ");
        return "video";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i2, int i3, String str, String str2, Map<String, String> map) {
        RVLogger.d(q, "getView: ");
        RVLogger.d(q, "getView Params :" + map);
        this.y = (Activity) this.R.get();
        if (this.r == null) {
            MyTBMiniAppVideoStd myTBMiniAppVideoStd = new MyTBMiniAppVideoStd(this.R.get());
            this.f24850a = myTBMiniAppVideoStd;
            this.r = myTBMiniAppVideoStd;
        }
        if (map != null) {
            a(map);
        }
        a(this.y, new a() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.1
            @Override // com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.a
            public void a() {
                TriverEmbedVideoView triverEmbedVideoView = TriverEmbedVideoView.this;
                triverEmbedVideoView.f24850a.a(triverEmbedVideoView.x, "饺子快长大", 0, true);
            }

            @Override // com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.a
            public void a(String str3) {
                TriverToastUtils.showLongToast(TriverEmbedVideoView.this.y, InternationalUtil.getString(TriverEmbedVideoView.this.y, R.string.triver_video_permissions_denied_msg));
                TriverEmbedVideoView.this.r.setVisibility(4);
            }
        }, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", com.kuaishou.weapon.p0.g.f40125a);
        return this.r;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        RVLogger.d(q, "onAttachedToWebView[TODO]");
        if (this.o != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) "true");
            this.o.sendJSONResponse(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("elementid", (Object) this.mViewId);
        EngineUtils.sendToRender(this.mOuterPage.getRender(), RVEvents.NBCOMPONENT_CANRENDER, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.8
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
            public void onCallBack(JSONObject jSONObject3) {
                RVLogger.d("TriverVideoView", jSONObject3.toString());
            }
        });
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        RVLogger.d(q, "onCreate Params :" + map);
        super.onCreate(map);
        PageContext pageContext = this.mOuterPage.getPageContext();
        if (pageContext != null) {
            this.R = new WeakReference<>(pageContext.getActivity());
        }
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        RVLogger.d(q, "onDestroy");
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd != null) {
            myTBMiniAppVideoStd.D();
        }
        MyTBMiniAppVideoStd.r();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        RVLogger.d(q, "onDetachedToWebView[TODO]");
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd != null) {
            myTBMiniAppVideoStd.D();
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i2) {
        try {
            if (i2 == 0) {
                RVLogger.e(q, "onEmbedViewVisibilityChanged 0");
            } else if (i2 != 1) {
            } else {
                RVLogger.e(q, "onEmbedViewVisibilityChanged 1");
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(q, "onReceivedMessage action = " + str + " json=" + jSONObject);
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd != null) {
            myTBMiniAppVideoStd.a(bridgeCallback, this);
        }
        try {
            if ("play".equals(str)) {
                b(bridgeCallback);
            } else if ("pause".equals(str)) {
                e();
            } else if ("stop".equals(str)) {
                f();
            } else if (com.alibaba.ariver.jsapi.multimedia.video.a.j.equals(str)) {
                c(bridgeCallback);
            }
        } catch (Exception e2) {
            RVLogger.e(q, "onReceivedMessage Error = " + e2.getMessage());
            RVLogger.w(Log.getStackTraceString(e2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fail", "true");
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
        if (jSONObject != null) {
            try {
                int i2 = 0;
                if (com.alibaba.ariver.jsapi.multimedia.video.a.i.equals(str)) {
                    if (this.Q == 1) {
                        return;
                    }
                    this.Q = 1;
                    if (this.f24850a != null) {
                        int iA = a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, jSONObject);
                        this.f24850a.p();
                        int i3 = 90 == iA ? 8 : 4;
                        if (-90 != iA) {
                            i2 = i3;
                        }
                        g.a(this.f24850a.getContext(), i2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("fullScreen", (Object) Boolean.TRUE);
                        jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, (Object) (iA == 0 ? "vertical" : "horizontal"));
                        sendEvent("onFullScreenChange", jSONObject3, null);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("onFullScreenChange", (Object) jSONObject3);
                        jSONObject4.put("success", "true");
                        bridgeCallback.sendJSONResponse(jSONObject4);
                        return;
                    }
                    return;
                }
                if ("showStatusBar".equals(str)) {
                    this.D = true;
                    this.f24850a.aX = "1";
                    return;
                }
                if ("hideStatusBar".equals(str)) {
                    this.D = false;
                    this.f24850a.aX = "0";
                    return;
                }
                if ("changeControllerStatus".equals(str)) {
                    String string = jSONObject.getString("status");
                    this.D = TextUtils.equals(string, "1");
                    this.f24850a.aX = string;
                    return;
                }
                if (com.alibaba.ariver.jsapi.multimedia.video.a.f.equals(str)) {
                    boolean zBooleanValue = jSONObject.getBoolean("ison").booleanValue();
                    this.C = zBooleanValue;
                    this.f24850a.setMuted(zBooleanValue);
                    return;
                }
                if (!"setup".equals(str)) {
                    if (!com.alibaba.ariver.jsapi.multimedia.video.a.d.equals(str)) {
                        if (com.alibaba.ariver.jsapi.multimedia.video.a.h.equals(str)) {
                            c.a(jSONObject.getFloatValue("rate"));
                            return;
                        }
                        return;
                    } else {
                        if (jSONObject.containsKey("time")) {
                            int i4 = Integer.parseInt(jSONObject.getString("time"));
                            if (this.f24850a != null) {
                                c.a(i4 * 1000);
                                this.f24850a.R();
                                this.f24850a.b(i4);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                this.x = jSONObject.getString(VideoPlayerActivity.t);
                if (jSONObject.containsKey("isLoop")) {
                    this.z = jSONObject.getBoolean("isLoop").booleanValue();
                }
                if (jSONObject.containsKey("object-fit")) {
                    this.A = jSONObject.getString("object-fit");
                }
                if (jSONObject.containsKey("poster")) {
                    String string2 = jSONObject.getString("poster");
                    this.B = string2;
                    if (!TextUtils.isEmpty(string2) && this.B.startsWith("//")) {
                        this.B = "http:" + this.B;
                    }
                }
                this.f24850a.setMuted(this.C);
                if (this.D) {
                    this.f24850a.aX = "1";
                } else {
                    this.f24850a.aX = "0";
                }
                if (u.equals(this.A)) {
                    TBMiniAppVideo.setVideoImageDisplayType(0);
                } else if (v.equals(this.A)) {
                    TBMiniAppVideo.setVideoImageDisplayType(1);
                } else if ("cover".equals(this.A)) {
                    TBMiniAppVideo.setVideoImageDisplayType(2);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    g();
                } else {
                    if (TextUtils.isEmpty(this.x)) {
                        return;
                    }
                    a(this.x, new b() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.2
                        @Override // com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.b
                        public void a(final Bitmap bitmap) {
                            TriverEmbedVideoView.this.y.runOnUiThread(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView;
                                    MyTBMiniAppVideoStd myTBMiniAppVideoStd2 = TriverEmbedVideoView.this.f24850a;
                                    if (myTBMiniAppVideoStd2 == null || (imageView = myTBMiniAppVideoStd2.ay) == null) {
                                        return;
                                    }
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                        }
                    });
                }
            } catch (Exception e3) {
                RVLogger.e(q, "onReceivedMessage Error = " + e3.getMessage());
                RVLogger.w(Log.getStackTraceString(e3));
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("fail", "true");
                bridgeCallback.sendJSONResponse(jSONObject5);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(q, "onReceivedParams :" + jSONObject);
        if (this.o == null) {
            this.o = bridgeCallback;
        }
        if (!TextUtils.isEmpty(this.B)) {
            g();
        } else if (!TextUtils.isEmpty(this.x)) {
            a(this.x, new b() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.5
                @Override // com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.b
                public void a(final Bitmap bitmap) {
                    TriverEmbedVideoView.this.y.runOnUiThread(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView;
                            MyTBMiniAppVideoStd myTBMiniAppVideoStd = TriverEmbedVideoView.this.f24850a;
                            if (myTBMiniAppVideoStd == null || (imageView = myTBMiniAppVideoStd.ay) == null) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
        a(jSONObject);
        c.a().l();
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd != null) {
            myTBMiniAppVideoStd.a(bridgeCallback, this);
        }
        RVLogger.d(q, "onReceivedRender autoPlay = " + this.J);
        if (this.J) {
            a(bridgeCallback);
            return;
        }
        RVLogger.e(q, "onReceivedRender: should not exec here .Not autoplay!!");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("success", "true");
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        int i3 = 0;
        while (true) {
            if (iArr == null || i3 >= iArr.length) {
                z = true;
                break;
            } else {
                if (iArr[i3] != 0) {
                    z = false;
                    break;
                }
                i3++;
            }
        }
        if (z) {
            this.f24850a.a(this.x, "饺子快长大", 0, true);
            return;
        }
        Activity activity = this.y;
        TriverToastUtils.showLongToast(activity, InternationalUtil.getString(activity, R.string.triver_video_permissions_denied_msg));
        this.r.setVisibility(4);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        RVLogger.d(q, "onWebViewPause[TODO]");
        try {
            if (this.f24850a == null || !c.i()) {
                return;
            }
            c.g();
            this.f24850a.e();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        RVLogger.d(q, "onWebViewResume[TODO]");
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void sendEvent(String str, JSONObject jSONObject, final IEmbedCallback iEmbedCallback) {
        if (this.mOuterPage == null) {
            throw new IllegalStateException("You should call super.onCreate first!!!");
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!str.equals("onToWebViewMessage")) {
            str = "nbcomponent." + getType() + Consts.DOT + str;
        }
        if (jSONObject != null) {
            jSONObject.put("element", (Object) this.mViewId);
            jSONObject2.put("data", (Object) jSONObject);
        }
        Render render = this.mOuterPage.getRender();
        EngineUtils.sendToRender(render, render.getEngine().getEngineRouter().getWorkerById(EngineUtils.getWorkerId(render)), str, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.4
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
            public void onCallBack(JSONObject jSONObject3) {
                IEmbedCallback iEmbedCallback2 = iEmbedCallback;
                if (iEmbedCallback2 != null) {
                    iEmbedCallback2.onResponse(jSONObject3);
                }
            }
        });
    }

    private void a(Map map) {
        this.z = TextUtils.equals(a(map, "loop"), "true");
        this.x = b(a(map, "url"));
        this.A = a(map, "objectFit");
        String strA = a(map, "videoPoster");
        this.B = strA;
        if (strA.startsWith("//")) {
            this.B = "http:" + this.B;
        }
        this.C = TextUtils.equals(a(map, "muted"), "1");
        this.D = TextUtils.equals(a(map, "controls"), "true");
        this.Q = Integer.valueOf(a(map, "fullScreenStatus", "-1")).intValue();
    }

    private boolean b(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getBoolean(str).booleanValue();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return false;
        }
    }

    private void c(BridgeCallback bridgeCallback) {
        if (this.Q == 0) {
            return;
        }
        this.Q = 0;
        if (this.f24850a != null) {
            TBMiniAppVideo.u();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fullScreen", (Object) Boolean.FALSE);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "vertical");
            JSONObject jSONObject2 = new JSONObject();
            sendEvent("onFullScreenChange", jSONObject, null);
            jSONObject2.put("onFullScreenChange", (Object) jSONObject);
            jSONObject2.put("success", "true");
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    public int d() {
        return this.E;
    }

    private String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String string = JSON.parseObject(str).getString("url");
            try {
                if (string.startsWith(com.alibaba.ariver.commonability.file.g.e) || !TRiverUtils.needAuthentication(getOuterPage()) || DomainNameController.embedViewPermissionCheck(string, this.mOuterApp)) {
                    return string;
                }
                RVLogger.e(q, "url is illegal");
                a(s);
                return "";
            } catch (Exception e2) {
                str2 = string;
                e = e2;
                RVLogger.w(Log.getStackTraceString(e));
                RVLogger.e(q, "url is not a json format , use raw url data");
                return TRiverUtils.needAuthentication(getOuterPage()) ? str : str;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
        }
        RVLogger.w(Log.getStackTraceString(e));
        RVLogger.e(q, "url is not a json format , use raw url data");
        if (TRiverUtils.needAuthentication(getOuterPage()) || str2.startsWith(com.alibaba.ariver.commonability.file.g.e) || DomainNameController.embedViewPermissionCheck(str, this.mOuterApp)) {
            return str;
        }
        RVLogger.e(q, "url is illegal");
        a(s);
        return "";
    }

    private int a(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getInteger(str).intValue();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return 0;
        }
    }

    private void a(JSONObject jSONObject) {
        String str;
        try {
            String strB = b(jSONObject.getString("src"));
            this.x = strB;
            if (TextUtils.isEmpty(strB)) {
                str = "show-fullscreen-btn";
            } else {
                str = "show-fullscreen-btn";
                if (this.x.startsWith(com.alibaba.ariver.commonability.file.g.e)) {
                    this.x = FileUtils.apUrlToFilePath(this.x);
                }
            }
            if (jSONObject.containsKey("loop")) {
                this.z = b("loop", jSONObject);
            }
            if (jSONObject.containsKey("object-fit")) {
                this.A = jSONObject.getString("object-fit");
            }
            if (jSONObject.containsKey("poster")) {
                String string = jSONObject.getString("poster");
                this.B = string;
                if (!TextUtils.isEmpty(string) && this.B.startsWith("//")) {
                    this.B = "http:" + this.B;
                }
            }
            if (jSONObject.containsKey("initial-time")) {
                this.E = a("initial-time", jSONObject);
            }
            if (jSONObject.containsKey("enable-progress-gesture")) {
                this.F = b("enable-progress-gesture", jSONObject);
            }
            int i2 = 0;
            if (jSONObject.containsKey("controls")) {
                boolean zB = b("controls", jSONObject);
                this.D = zB;
                this.f24850a.setControlsVisibility(zB ? 0 : 4);
            }
            if (jSONObject.containsKey("showMuteBtn")) {
                boolean zB2 = b("showMuteBtn", jSONObject);
                this.G = zB2;
                this.f24850a.setMuteButtonVisibility(zB2 ? 0 : 4);
            }
            if (jSONObject.containsKey("show-center-play-btn")) {
                boolean zB3 = b("show-center-play-btn", jSONObject);
                this.H = zB3;
                this.f24850a.setCenterPlayButtonVisibility(zB3 ? 0 : 4);
            }
            if (jSONObject.containsKey("page-gesture")) {
                this.I = b("page-gesture", jSONObject);
            }
            if (jSONObject.containsKey("autoplay")) {
                this.J = b("autoplay", jSONObject);
            }
            if (jSONObject.containsKey("duration")) {
                this.K = a("duration", jSONObject);
            }
            if (jSONObject.containsKey("mobilenet-hint-type")) {
                this.L = a("mobilenet-hint-type", jSONObject);
            }
            String str2 = str;
            if (jSONObject.containsKey(str2)) {
                boolean zB4 = b(str2, jSONObject);
                this.O = zB4;
                this.f24850a.setFullScreenButtonVisibility(zB4 ? 0 : 4);
            }
            if (jSONObject.containsKey("show-play-btn")) {
                boolean zB5 = b("show-play-btn", jSONObject);
                this.M = zB5;
                this.f24850a.setBottomPlayVisibility(zB5 ? 0 : 4);
            }
            if (jSONObject.containsKey("showThinProgressBar")) {
                boolean zB6 = b("showThinProgressBar", jSONObject);
                this.N = zB6;
                this.f24850a.setThinProgressBarVisibility(zB6 ? 0 : 4);
            }
            if (jSONObject.containsKey("muted")) {
                this.C = b("muted", jSONObject);
            }
            if (jSONObject.containsKey(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                int iA = a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, jSONObject);
                this.P = iA;
                int i3 = 90 == iA ? 8 : 4;
                if (-90 != iA) {
                    i2 = i3;
                }
                TBMiniAppVideo.B = i2;
                return;
            }
            TBMiniAppVideo.B = 4;
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    public void c() {
        this.Q = 0;
    }

    private void b(BridgeCallback bridgeCallback) {
        if (this.f24850a.L == 5) {
            c.h();
            this.f24850a.d();
            this.f24850a.ae();
        } else {
            a(bridgeCallback);
        }
        if (bridgeCallback == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "true");
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    public int b() {
        return this.P;
    }

    private String a(Map map, String str) {
        return map.containsKey(str) ? String.valueOf(map.get(str)) : "";
    }

    private String a(Map map, String str, String str2) {
        return map.containsKey(str) ? String.valueOf(map.get(str)) : str2;
    }

    private void a(BridgeCallback bridgeCallback) {
        MyTBMiniAppVideoStd myTBMiniAppVideoStd;
        if (this.r == null || (myTBMiniAppVideoStd = this.f24850a) == null || myTBMiniAppVideoStd == null) {
            return;
        }
        myTBMiniAppVideoStd.setMuted(this.C);
        if (this.D) {
            this.f24850a.aX = "1";
        } else {
            this.f24850a.aX = "0";
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.f24850a.a(this.x, "饺子快长大", 0, this.z);
        }
        MyTBMiniAppVideoStd myTBMiniAppVideoStd2 = this.f24850a;
        int i2 = myTBMiniAppVideoStd2.L;
        if (i2 == 0) {
            if (!myTBMiniAppVideoStd2.ab.a().toString().startsWith("file") && !this.f24850a.ab.a().toString().startsWith(WVNativeCallbackUtil.SEPERATER) && !g.a(this.f24850a.getContext()) && !TBMiniAppVideo.E && this.L != 0) {
                this.f24850a.S();
                return;
            } else {
                this.f24850a.a();
                this.f24850a.d();
                this.f24850a.a(0);
            }
        } else if (i2 == 5) {
            myTBMiniAppVideoStd2.a(4);
            this.f24850a.a();
            this.f24850a.d();
        } else if (i2 == 6) {
            myTBMiniAppVideoStd2.a();
            this.f24850a.d();
        }
        if (u.equals(this.A)) {
            TBMiniAppVideo.setVideoImageDisplayType(0);
        } else if (v.equals(this.A)) {
            TBMiniAppVideo.setVideoImageDisplayType(1);
        } else if ("cover".equals(this.A)) {
            TBMiniAppVideo.setVideoImageDisplayType(2);
        }
        this.f24850a.ae();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "true");
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    public void a() {
        MyTBMiniAppVideoStd myTBMiniAppVideoStd = this.f24850a;
        if (myTBMiniAppVideoStd != null) {
            myTBMiniAppVideoStd.ay.setVisibility(4);
        }
        a(5);
    }

    public void a(int i2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", (Object) Integer.valueOf(i2));
        sendEvent("onChangeState", jSONObject, new IEmbedCallback() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.3
            @Override // com.alibaba.ariver.engine.api.embedview.IEmbedCallback
            public void onResponse(JSONObject jSONObject2) {
                jSONObject2.toString();
            }
        });
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str);
        sendEvent(b, jSONObject, null);
    }

    private void a(Activity activity, a aVar, String... strArr) {
        try {
            if (PermissionChecker.checkSelfPermission(this.y, "android.permission.READ_EXTERNAL_STORAGE") == 0 && PermissionChecker.checkSelfPermission(this.y, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                aVar.a();
            } else {
                ActivityCompat.requestPermissions(activity, strArr, 33);
                LocalBroadcastManager.getInstance(activity).registerReceiver(new PerReceiver(aVar), new IntentFilter(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT));
            }
        } catch (Throwable th) {
            RVLogger.e("Bridge", Log.getStackTraceString(th));
        }
    }

    public void a(final String str, final b bVar) {
        new Thread(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView.7
            @Override // java.lang.Runnable
            public void run() throws IOException {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
                            mediaMetadataRetriever.setDataSource(str);
                        } else {
                            mediaMetadataRetriever.setDataSource(str, new HashMap());
                        }
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(frameAtTime);
                        }
                    } catch (Exception e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                    }
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException unused) {
                    }
                }
            }
        }).start();
    }
}
