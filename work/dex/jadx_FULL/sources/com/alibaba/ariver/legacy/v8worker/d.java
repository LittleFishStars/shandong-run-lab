package com.alibaba.ariver.legacy.v8worker;

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
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements JavaVoidCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24300a = "https://alipay.kylinBridge";
    private static final String b = "ImportScriptsCallback";
    private n c;
    private App d;

    public d(App app, n nVar) {
        this.c = nVar;
        this.d = app;
    }

    public void a(String str) {
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            RVLogger.d(b, " >>> load js failed :" + str);
            return;
        }
        RVLogger.d(b, " >>> js loaded " + str + ", " + strB.length() + " bytes");
        this.c.executeScript(strB, str, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(" >>> js executed ");
        sb.append(str);
        RVLogger.d(b, sb.toString());
    }

    public String b(String str) {
        String strA;
        if (str.startsWith(WVNativeCallbackUtil.SEPERATER) && this.c.getWorkerId() != null) {
            str = this.c.getWorkerId().replace("/index.worker.js", str);
        }
        Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.d).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build());
        if (resourceLoad != null) {
            RVLogger.d(b, "shouldInterceptRequest got resource: " + resourceLoad);
            WebResourceResponse webResourceResponse = new WebResourceResponse(resourceLoad.getMimeType(), resourceLoad.getEncoding(), resourceLoad.getStream());
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", UrlUtils.getCORSUrl(this.c.getWorkerId()));
            webResourceResponse.setResponseHeaders(map);
            strA = a(webResourceResponse);
        } else {
            strA = null;
        }
        if (strA == null) {
            RVLogger.e(b, "loadResource h5ContentProvider.getContent return null");
        }
        if (TextUtils.isEmpty(strA)) {
            RVLogger.e(b, "*** Failed to load: " + str);
        }
        return strA;
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
    public void invoke(V8Object v8Object, V8Array v8Array) {
        for (int i = 0; i < v8Array.length(); i++) {
            try {
                String str = (String) v8Array.get(i);
                if (str != null) {
                    String strTrim = str.trim();
                    if (!this.c.isAppxLoaded() || !WorkerUtils.startsWithIgnoreCase(strTrim, "https://appx/af-appx.worker.min.js")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("importScripts ");
                        sb.append(strTrim.length() > 200 ? strTrim.substring(0, 200) + ".." : strTrim);
                        sb.append(" ? ");
                        sb.append("https://appx/af-appx.worker.min.js".equals(strTrim));
                        RVLogger.d(b, sb.toString());
                        if (WorkerUtils.startsWithIgnoreCase(strTrim, "https://alipay.kylinBridge")) {
                            this.c.getJsApiHandler().a(strTrim);
                        } else {
                            a(strTrim);
                        }
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(b, "work load url form mainPageResourceResponse error! ", th);
                return;
            }
        }
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
}
