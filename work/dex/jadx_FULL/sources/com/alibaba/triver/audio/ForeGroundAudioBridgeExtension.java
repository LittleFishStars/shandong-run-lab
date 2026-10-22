package com.alibaba.triver.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.DomainNameController;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ForeGroundAudioBridgeExtension implements BridgeExtension {
    public static final String ATTR_RECORD_PLAY_STATE = "isRecordAudioPlayState";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24654a = "src";
    private static final String b = "startTime";
    private static final String c = "loop";
    private static final String d = "autoplay";
    private static final String e = "volume";
    private static final String f = "duration";
    private static final String g = "currentTime";
    private static final String h = "buffered";
    private static final String i = "paused";
    private static final String j = "option";
    private static final String k = "onForegroundAudioCanPlay";
    private static final String l = "onForegroundAudioPlay";
    private static final String m = "onForegroundAudioPause";
    private static final String n = "onForegroundAudioStop";
    private static final String o = "onForegroundAudioEnded";
    private static final String p = "onForegroundAudioTimeUpdate";
    private static final String q = "onForegroundAudioError";
    private static final String r = "onForegroundAudioWaiting";
    private static final String s = "onForegroundAudioSeeking";
    private static final String t = "onForegroundAudioSeeked";
    private static final String u = "please insure your video source is in domain whitelist";
    private static final String v = "audioPlayerID";
    private HandlerThread A;
    private Handler B;
    private Map<String, a> w = new HashMap();
    private String x;
    private String y;
    private boolean z;

    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BridgeCallback f24666a;
        private ApiContext b;
        private String c;
        private String d;
        private String e;
        private volatile boolean g;
        private boolean h;
        private boolean i;
        private long k;
        private MediaPlayer m;
        private boolean n;
        private boolean r;
        private boolean f = false;
        private float j = 1.0f;
        private int l = 0;
        private volatile boolean o = false;
        private boolean p = false;
        private boolean q = false;
        private final Handler s = new Handler(Looper.getMainLooper());

        public a(String str, String str2) {
            this.n = true;
            this.r = true;
            this.c = str;
            this.d = str2;
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.m = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            try {
                IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
                if (iConfigProxy != null) {
                    this.n = "true".equalsIgnoreCase(iConfigProxy.getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_LOCAL_AUDIO_SUPPORT, "true"));
                    this.r = "true".equalsIgnoreCase(iConfigProxy.getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_AUDIO_IGNORE_WHEN_PLAY_AGAIN, "true"));
                }
            } catch (Throwable th) {
                RVLogger.e("PlayerInstance", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getVolume:### id=" + this.c);
            JSONObject jSONObjectF = f();
            jSONObjectF.put(ForeGroundAudioBridgeExtension.e, (Object) Float.valueOf(this.j));
            bridgeCallback.sendJSONResponse(jSONObjectF);
            this.f24666a = bridgeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getLoop:### id=" + this.c);
            JSONObject jSONObjectF = f();
            jSONObjectF.put(ForeGroundAudioBridgeExtension.c, (Object) Boolean.valueOf(this.h));
            bridgeCallback.sendJSONResponse(jSONObjectF);
            this.f24666a = bridgeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getAutoPlay:### id=" + this.c);
            JSONObject jSONObjectF = f();
            jSONObjectF.put(ForeGroundAudioBridgeExtension.d, (Object) Boolean.valueOf(this.g));
            bridgeCallback.sendJSONResponse(jSONObjectF);
            this.f24666a = bridgeCallback;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.l = i;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a(ForeGroundAudioBridgeExtension.o);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            String str2 = i == 1 ? "UNKNOWN_ERROR" : "SERVER_DIED";
            if (i2 == -1010) {
                str = "ERROR_UNSUPPORTED";
            } else if (i2 == -1007) {
                str = "ERROR_MALFORMED";
            } else if (i2 == -1004) {
                str = "IO_ERROR";
            } else if (i2 != -110) {
                str = "error code , what is : " + i + "   extra is :" + i2;
            } else {
                str = "TIMED_OUT_ERROR";
            }
            b(str2 + "\t" + str);
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a(ForeGroundAudioBridgeExtension.k);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            mediaPlayer.start();
            this.f = false;
            a(ForeGroundAudioBridgeExtension.l);
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            a(ForeGroundAudioBridgeExtension.t);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getStartTime:### id=" + this.c);
            JSONObject jSONObjectF = f();
            jSONObjectF.put(ForeGroundAudioBridgeExtension.b, (Object) Float.valueOf(((float) this.k) / 1000.0f));
            bridgeCallback.sendJSONResponse(jSONObjectF);
            this.f24666a = bridgeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getStartTime:### id=" + this.c);
            JSONObject jSONObjectF = f();
            jSONObjectF.put("isRecordAudioPlayState", (Object) Boolean.valueOf(this.i));
            bridgeCallback.sendJSONResponse(jSONObjectF);
            this.f24666a = bridgeCallback;
        }

        public long d() {
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0L;
        }

        public void e() {
            RVLogger.d("PlayerInstance", "addMonitors");
            this.m.setOnPreparedListener(null);
            this.m.setOnBufferingUpdateListener(null);
            this.m.setOnErrorListener(null);
            this.m.setOnSeekCompleteListener(null);
            this.m.setOnCompletionListener(null);
        }

        public void b(BridgeCallback bridgeCallback) {
            if (a()) {
                this.m.pause();
                this.f = true;
                d(bridgeCallback);
                a(ForeGroundAudioBridgeExtension.m);
            }
        }

        public void c(BridgeCallback bridgeCallback) {
            try {
                MediaPlayer mediaPlayer = this.m;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    this.f = false;
                    d(bridgeCallback);
                    this.f24666a = bridgeCallback;
                    a(ForeGroundAudioBridgeExtension.n);
                }
            } catch (IllegalStateException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(BridgeCallback bridgeCallback) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
            bridgeCallback.sendJSONResponse(jSONObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "getSrc:### id=" + this.c);
            String strFilePathToApUrl = this.e;
            if (!TextUtils.isEmpty(strFilePathToApUrl) && !strFilePathToApUrl.startsWith("http")) {
                strFilePathToApUrl = FileUtils.filePathToApUrl(strFilePathToApUrl, "audio");
            }
            a(bridgeCallback, ForeGroundAudioBridgeExtension.f24654a, strFilePathToApUrl);
            this.f24666a = bridgeCallback;
        }

        public void b() {
            this.f = false;
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }

        public void a(BridgeCallback bridgeCallback) {
            if (a()) {
                if (this.r) {
                    return;
                }
                this.m.pause();
                this.f = true;
                return;
            }
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.f) {
                    mediaPlayer.start();
                    a(ForeGroundAudioBridgeExtension.l);
                } else {
                    try {
                        if (!this.p) {
                            mediaPlayer.prepareAsync();
                        } else if (this.n && this.o) {
                            this.m.prepareAsync();
                        } else {
                            this.q = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            d(bridgeCallback);
            this.f24666a = bridgeCallback;
        }

        public long c() {
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                return mediaPlayer.getDuration();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
            jSONObject.put("error", (Object) str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            ApiContext apiContext = this.b;
            if (apiContext != null) {
                apiContext.sendEvent(ForeGroundAudioBridgeExtension.q, jSONObject2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "setStartTime:### id=" + this.c);
            this.k = (long) (i * 1000);
            d(bridgeCallback);
            this.f24666a = bridgeCallback;
        }

        public boolean a() {
            try {
                MediaPlayer mediaPlayer = this.m;
                return mediaPlayer != null && mediaPlayer.isPlaying();
            } catch (Exception e) {
                e.printStackTrace();
                RVLogger.w(Log.getStackTraceString(e));
                return false;
            }
        }

        public void a(int i, BridgeCallback bridgeCallback) {
            try {
                MediaPlayer mediaPlayer = this.m;
                if (mediaPlayer != null) {
                    mediaPlayer.seekTo(i * 1000);
                    d(bridgeCallback);
                }
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.FALSE);
                jSONObject.put("errorCode", (Object) (-1));
                jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }

        private void a(BridgeCallback bridgeCallback, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
            jSONObject.put(str, (Object) str2);
            bridgeCallback.sendJSONResponse(jSONObject);
        }

        private void a(String str) {
            RVLogger.d("PlayerInstance", "broadcastEvent:### id=" + this.c + ",event = " + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ForeGroundAudioBridgeExtension.v, (Object) this.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            ApiContext apiContext = this.b;
            if (apiContext != null) {
                apiContext.sendEvent(str, jSONObject2, null);
            }
        }

        public void a(ApiContext apiContext) {
            RVLogger.d("PlayerInstance", "addMonitors");
            this.m.setOnPreparedListener(this);
            this.m.setOnBufferingUpdateListener(this);
            this.m.setOnErrorListener(this);
            this.m.setOnSeekCompleteListener(this);
            this.m.setOnCompletionListener(this);
            this.b = apiContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, BridgeCallback bridgeCallback, boolean z, String str2, Page page) {
            RVLogger.d("PlayerInstance", "setSrc:### id=" + this.c);
            try {
                if (this.n) {
                    str = a(str, page);
                }
            } catch (Throwable th) {
                RVLogger.e("PlayerInstance", "setSrc Error:### id=" + this.c, th);
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(g.e)) {
                    str = FileUtils.apUrlToFilePath(str);
                } else if (z && !this.p) {
                    ApiContext apiContext = this.b;
                    if (!DomainNameController.urlBothInOfficialDomainListAndPermissionModelList(str, (apiContext == null || apiContext.getRender() == null || !(this.b.getRender().getPage() instanceof Page)) ? null : ((Page) this.b.getRender().getPage()).getApp(), str2)) {
                        b(ForeGroundAudioBridgeExtension.u);
                        return;
                    }
                }
            }
            this.e = str;
            try {
                this.m.setDataSource(str);
            } catch (IOException e) {
                RVLogger.w(Log.getStackTraceString(e));
                a(ForeGroundAudioBridgeExtension.q);
            }
            if (this.g) {
                RVLogger.d("PlayerInstance", "OnAutoPlay true,call play when setSrc = " + str);
                if (!this.p) {
                    this.m.prepareAsync();
                } else if (this.n && this.o) {
                    this.m.prepareAsync();
                }
            }
            d(bridgeCallback);
            this.f24666a = bridgeCallback;
        }

        private String a(final String str, Page page) {
            if (!TextUtils.isEmpty(str) && !str.startsWith("https://") && !str.startsWith("http://")) {
                if (page != null && page.getApp() != null && page.getApp().getAppContext() != null && page.getApp().getAppId() != null) {
                    App app = page.getApp();
                    Context context = app.getAppContext().getContext();
                    if (context == null) {
                        RVLogger.e("PlayerInstance", "app context is invalid");
                        return str;
                    }
                    String appId = app.getAppId();
                    ResourceLoadContext resourceLoadContextBuild = ResourceLoadContext.newBuilder().originUrl(str).build();
                    ResourceContext resourceContext = ResourceContextManager.getInstance().get(appId);
                    Resource rawResource = (resourceContext == null || resourceContext.getContentProvider() == null) ? null : resourceContext.getContentProvider().getRawResource(ResourceQuery.asUrl(resourceLoadContextBuild.originUrl).setCanUseFallback(resourceLoadContextBuild.canUseFallback).setNeedAutoCompleteHost());
                    if (rawResource == null || rawResource.getBytes() == null || rawResource.getBytes().length <= 0) {
                        return str;
                    }
                    final byte[] bytes = rawResource.getBytes();
                    String strMd5 = CommonUtils.md5(bytes);
                    if (TextUtils.isEmpty(strMd5)) {
                        return str;
                    }
                    this.p = true;
                    int iLastIndexOf = str.lastIndexOf(Consts.DOT);
                    String strSubstring = iLastIndexOf != -1 ? str.substring(iLastIndexOf) : FileTypes.f5253q;
                    final File file = new File(context.getCacheDir(), strMd5 + strSubstring);
                    if (file.exists() && file.length() == bytes.length) {
                        this.o = true;
                        return file.getAbsolutePath();
                    }
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                    }
                    this.o = false;
                    RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
                    if (rVExecutorService == null) {
                        return str;
                    }
                    ExecutorType executorType = ExecutorType.IO;
                    if (rVExecutorService.getExecutor(executorType) == null) {
                        return str;
                    }
                    rVExecutorService.getExecutor(executorType).execute(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.a.1
                        /* JADX WARN: Code duplicated, block: B:32:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            BufferedOutputStream bufferedOutputStream;
                            Exception e;
                            BufferedOutputStream bufferedOutputStream2 = null;
                            try {
                                try {
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                    try {
                                        bufferedOutputStream.write(bytes);
                                        bufferedOutputStream.flush();
                                    } catch (Exception e2) {
                                        e = e2;
                                        RVLogger.e("PlayerInstance", "write audio file failed", e);
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (!file.exists()) {
                                        }
                                        RVLogger.e("PlayerInstance", "cache local audio failed: " + str);
                                        a.this.b("cache local audio failed:" + str);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    if (bufferedOutputStream2 != null) {
                                        try {
                                            bufferedOutputStream2.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e3) {
                                bufferedOutputStream = null;
                                e = e3;
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedOutputStream2 != null) {
                                    bufferedOutputStream2.close();
                                }
                                throw th;
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused3) {
                            }
                            if (!file.exists() && file.length() == bytes.length) {
                                a.this.s.post(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.a.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        a.this.o = true;
                                        try {
                                            if (a.this.g) {
                                                a.this.m.prepareAsync();
                                            } else if (a.this.q) {
                                                a.this.m.prepareAsync();
                                                a.this.q = false;
                                            }
                                        } catch (Throwable th3) {
                                            RVLogger.e("PlayerInstance", "can not play audio", th3);
                                            a.this.b("can not play audio: " + th3.getMessage());
                                        }
                                    }
                                });
                                return;
                            }
                            RVLogger.e("PlayerInstance", "cache local audio failed: " + str);
                            a.this.b("cache local audio failed:" + str);
                        }
                    });
                    return file.getAbsolutePath();
                }
                RVLogger.e("PlayerInstance", "page or app is invalid");
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            this.i = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f, BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "setVolume:### id=" + this.c);
            if (f >= 0.0f && f <= 1.0f) {
                this.j = f;
                this.m.setVolume(f, f);
                d(bridgeCallback);
                this.f24666a = bridgeCallback;
                return;
            }
            RVLogger.d("PlayerInstance", "setVolume invalid param.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, BridgeCallback bridgeCallback) {
            RVLogger.d("PlayerInstance", "setLoop:### id=" + this.c);
            this.h = z;
            this.m.setLooping(z);
            d(bridgeCallback);
            this.f24666a = bridgeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BridgeCallback bridgeCallback, boolean z) {
            RVLogger.d("PlayerInstance", "setAutoPlay:### id=" + this.c);
            this.g = z;
            d(bridgeCallback);
            this.f24666a = bridgeCallback;
        }
    }

    private void a(final Runnable runnable) {
        Handler handler;
        if (runnable == null) {
            return;
        }
        try {
            if (!this.z || (handler = this.B) == null) {
                runnable.run();
            } else {
                handler.post(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            RVLogger.e("unexpected error", th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            RVLogger.e("runTask error...", th);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject destroyForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.11
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                ForeGroundAudioBridgeExtension.this.w.remove(str2);
                aVar.b();
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject getForegroundAudioOption(@BindingParam({v}) final String str, @BindingParam({"optionName"}) final String str2, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.5
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str3);
                if (aVar == null) {
                    aVar = new a(str3, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str3, aVar);
                }
                ForeGroundAudioBridgeExtension.this.a(bridgeCallback, str2, aVar);
            }
        });
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    for (Map.Entry entry : ForeGroundAudioBridgeExtension.this.w.entrySet()) {
                        if (entry.getValue() != null) {
                            ((a) entry.getValue()).b();
                        }
                    }
                    ForeGroundAudioBridgeExtension.this.w.clear();
                } finally {
                    try {
                        ForeGroundAudioBridgeExtension.this.B.removeCallbacksAndMessages(null);
                        ForeGroundAudioBridgeExtension.this.A.quitSafely();
                    } catch (Throwable th) {
                        RVLogger.e("unexpected error", th);
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        boolean zA = a();
        this.z = zA;
        if (zA) {
            HandlerThread handlerThread = new HandlerThread("foreGround-Audio");
            this.A = handlerThread;
            handlerThread.start();
            this.B = new Handler(this.A.getLooper());
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject pauseForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.8
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                aVar.a(apiContext);
                aVar.b(bridgeCallback);
            }
        });
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject playForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.7
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                if (!((apiContext.getRender() == null || !(apiContext.getRender().getPage() instanceof Page)) ? false : ForeGroundAudioBridgeExtension.a(((Page) apiContext.getRender().getPage()).getApp()))) {
                    for (Map.Entry entry : ForeGroundAudioBridgeExtension.this.w.entrySet()) {
                        if (!((a) entry.getValue()).equals(aVar)) {
                            ((a) entry.getValue()).b(bridgeCallback);
                        }
                    }
                }
                aVar.a(apiContext);
                aVar.a(bridgeCallback);
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject seekForegroundAudio(@BindingParam({v}) final String str, @BindingParam({"position"}) final int i2, @BindingRequest JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.10
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                aVar.a(apiContext);
                aVar.a(i2, bridgeCallback);
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject setForegroundAudioOption(@BindingParam({v}) final String str, @BindingParam({j}) String str2, @BindingRequest final JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback, @BindingNode(Page.class) final Page page, @BindingParam({"__appxDomain"}) final String str3) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.6
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str;
                if (TextUtils.isEmpty(str4)) {
                    str4 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str4);
                if (aVar == null) {
                    aVar = new a(str4, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str4, aVar);
                }
                a aVar2 = aVar;
                aVar2.a(apiContext);
                ForeGroundAudioBridgeExtension.this.a(bridgeCallback, jSONObject, aVar2, page, str3);
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject startMonitorForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                aVar.a(apiContext);
                aVar.d(bridgeCallback);
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject stopForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext final ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.9
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                aVar.a(apiContext);
                aVar.c(bridgeCallback);
            }
        });
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public JSONObject stopMonitorForegroundAudio(@BindingParam({v}) final String str, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        a(new Runnable() { // from class: com.alibaba.triver.audio.ForeGroundAudioBridgeExtension.4
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "DEFAULT_PLAYER";
                }
                a aVar = (a) ForeGroundAudioBridgeExtension.this.w.get(str2);
                if (aVar == null) {
                    aVar = new a(str2, ForeGroundAudioBridgeExtension.this.x);
                    ForeGroundAudioBridgeExtension.this.w.put(str2, aVar);
                }
                aVar.e();
                aVar.d(bridgeCallback);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BridgeCallback bridgeCallback, JSONObject jSONObject, a aVar, Page page, String str) {
        RVLogger.d("ForeGroundAudioBridge", "onSetOption:### " + jSONObject);
        if (jSONObject == null) {
            RVLogger.d("ForeGroundAudioBridge", "InvalidParam : " + jSONObject);
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(j);
        if (jSONObject2 == null) {
            RVLogger.d("ForeGroundAudioBridge", "InvalidParam : " + jSONObject);
            return;
        }
        if (jSONObject2.containsKey(f24654a)) {
            aVar.a(jSONObject2.getString(f24654a), bridgeCallback, TRiverUtils.needAuthentication(page), str, page);
            return;
        }
        if (jSONObject2.containsKey(d)) {
            aVar.a(bridgeCallback, jSONObject2.getBooleanValue(d));
            return;
        }
        if (jSONObject2.containsKey(c)) {
            aVar.a(jSONObject2.getBooleanValue(c), bridgeCallback);
            return;
        }
        if (jSONObject2.containsKey(b)) {
            aVar.b(jSONObject2.getIntValue(b), bridgeCallback);
            return;
        }
        if (jSONObject2.containsKey(e)) {
            aVar.a(jSONObject2.getFloatValue(e), bridgeCallback);
            return;
        }
        if (jSONObject2.containsKey("isRecordAudioPlayState")) {
            aVar.a(jSONObject2.getBoolean("isRecordAudioPlayState").booleanValue());
            return;
        }
        RVLogger.d("ForeGroundAudioBridge", "InvalidParam : " + jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BridgeCallback bridgeCallback, String str, a aVar) {
        RVLogger.d("ForeGroundAudioBridge", "onGetOption:### " + str);
        if (!TextUtils.isEmpty(str)) {
            if (f24654a.equalsIgnoreCase(str)) {
                aVar.e(bridgeCallback);
                return;
            }
            if (d.equalsIgnoreCase(str)) {
                aVar.j(bridgeCallback);
                return;
            }
            if (c.equalsIgnoreCase(str)) {
                aVar.i(bridgeCallback);
                return;
            }
            if ("isRecordAudioPlayState".equalsIgnoreCase(str)) {
                aVar.f(bridgeCallback);
                return;
            }
            if (b.equalsIgnoreCase(str)) {
                aVar.g(bridgeCallback);
                return;
            }
            if (e.equalsIgnoreCase(str)) {
                aVar.h(bridgeCallback);
                return;
            }
            if ("duration".equalsIgnoreCase(str)) {
                JSONObject jSONObjectF = aVar.f();
                jSONObjectF.put("duration", (Object) Float.valueOf(aVar.m.getDuration() / 1000.0f));
                bridgeCallback.sendJSONResponse(jSONObjectF);
                return;
            }
            if (g.equalsIgnoreCase(str)) {
                JSONObject jSONObjectF2 = aVar.f();
                jSONObjectF2.put(g, (Object) Float.valueOf(aVar.m.getCurrentPosition() / 1000.0f));
                bridgeCallback.sendJSONResponse(jSONObjectF2);
                return;
            }
            if (h.equalsIgnoreCase(str)) {
                JSONObject jSONObjectF3 = aVar.f();
                jSONObjectF3.put(h, (Object) Integer.valueOf(aVar.l));
                bridgeCallback.sendJSONResponse(jSONObjectF3);
                return;
            }
            if (i.equalsIgnoreCase(str)) {
                boolean z = !aVar.a();
                JSONObject jSONObjectF4 = aVar.f();
                jSONObjectF4.put(i, (Object) Boolean.valueOf(z));
                bridgeCallback.sendJSONResponse(jSONObjectF4);
                return;
            }
            if ("obeyMuteSwitch".equalsIgnoreCase(str)) {
                JSONObject jSONObjectF5 = aVar.f();
                jSONObjectF5.put("obeyMuteSwitch", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObjectF5);
                return;
            } else {
                RVLogger.d("ForeGroundAudioBridge", "InvalidParam : " + str);
                return;
            }
        }
        RVLogger.d("ForeGroundAudioBridge", "InvalidParam : " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(App app) {
        AppConfigModel appConfigModel;
        JSONObject appLaunchParams;
        if (app == null || (appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class)) == null || (appLaunchParams = appConfigModel.getAppLaunchParams()) == null) {
            return false;
        }
        Object obj = appLaunchParams.get("enableMultiAudio");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private boolean a() {
        try {
            IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
            if (iConfigProxy != null) {
                return "true".equalsIgnoreCase(iConfigProxy.getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_AUDIO_ENABLE_ASYNC_THREAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
            }
            return false;
        } catch (Throwable th) {
            RVLogger.e("enableRunOnAsyncThread", th);
            return false;
        }
    }
}
