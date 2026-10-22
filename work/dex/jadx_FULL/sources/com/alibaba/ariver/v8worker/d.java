package com.alibaba.ariver.v8worker;

import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.engine.common.worker.WorkerUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.jsi.standard.js.s;
import com.alibaba.jsi.standard.js.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends com.alibaba.jsi.standard.js.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24495a = "https://alipay.kylinBridge";
    private static final String b = "ImportScriptsCallback";
    private V8Worker c;
    private App d;

    public d(App app, V8Worker v8Worker) {
        this.c = v8Worker;
        this.d = app;
    }

    @Override // com.alibaba.jsi.standard.js.h
    public w a(com.alibaba.jsi.standard.js.a aVar) {
        RVLogger.d(b, "onCallFunction func: " + aVar.d());
        this.c.q();
        if (this.c.k()) {
            return null;
        }
        for (int i = 0; i < aVar.a(); i++) {
            try {
                s sVar = (s) aVar.a(i);
                String strA_ = sVar.a_(aVar.b());
                if (strA_ != null) {
                    String strTrim = strA_.trim();
                    if (!this.c.a() || !WorkerUtils.startsWithIgnoreCase(strTrim, "https://appx/af-appx.worker.min.js")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("importScripts ");
                        sb.append(strTrim.length() > 200 ? strTrim.substring(0, 200) + ".." : strTrim);
                        sb.append(" ? ");
                        sb.append("https://appx/af-appx.worker.min.js".equals(strTrim));
                        RVLogger.d(b, sb.toString());
                        if (WorkerUtils.startsWithIgnoreCase(strTrim, "https://alipay.kylinBridge")) {
                            this.c.i().a(strTrim);
                        } else {
                            a(strTrim, this.c.m());
                        }
                        sVar.a();
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(b, "work load url form mainPageResourceResponse error! ", th);
            }
        }
        return null;
    }

    public void a(String str, com.alibaba.jsi.standard.b bVar) {
        String strA = a(str);
        if (!TextUtils.isEmpty(strA)) {
            RVLogger.d(b, " >>> js loaded " + str + ", " + strA.length() + " bytes");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.c.a(strA, str, bVar);
            if (!this.c.c && o.b(str, "https://appx/af-appx.worker.min.js")) {
                V8Worker v8Worker = this.c;
                v8Worker.c = true;
                v8Worker.e = SystemClock.elapsedRealtime() - jElapsedRealtime;
            }
            RVLogger.d(b, " >>> js executed " + str);
            return;
        }
        RVLogger.d(b, " >>> load js failed :" + str);
    }

    public String a(String str) {
        String strA = null;
        if (this.d == null) {
            return null;
        }
        if (str.startsWith(WVNativeCallbackUtil.SEPERATER) && this.c.getWorkerId() != null) {
            str = this.c.getWorkerId().replace("/index.worker.js", str);
        }
        Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.d).create()).load(ResourceLoadContext.newBuilder().canUseFallback(true).originUrl(str).build());
        if (resourceLoad != null) {
            RVLogger.d(b, "shouldInterceptRequest got resource: " + resourceLoad);
            WebResourceResponse webResourceResponse = new WebResourceResponse(resourceLoad.getMimeType(), resourceLoad.getEncoding(), resourceLoad.getStream());
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", UrlUtils.getCORSUrl(this.c.getWorkerId()));
            webResourceResponse.setResponseHeaders(map);
            strA = a(webResourceResponse);
        }
        if (strA == null) {
            RVLogger.e(b, "loadResource h5ContentProvider.getContent return null");
        }
        if (TextUtils.isEmpty(strA)) {
            RVLogger.e(b, "*** Failed to load: " + str);
        }
        return strA;
    }

    public static String a(WebResourceResponse webResourceResponse) {
        try {
            InputStream data = webResourceResponse.getData();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = data.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    data.close();
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (IOException e) {
            RVLogger.e(b, "webResourceResponseToStr close stream error", e);
            return null;
        }
    }

    public void a() {
        this.d = null;
    }

    public void a(App app) {
        this.d = app;
    }
}
