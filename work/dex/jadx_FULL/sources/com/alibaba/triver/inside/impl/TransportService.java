package com.alibaba.triver.inside.impl;

import android.os.LocaleList;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import android.webkit.CookieManager;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.zj.adlib.c49;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TransportService implements RVTransportService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24988a = "AriverInt:TransportService";
    private static final int b = 10000;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f24989a;
        long b;

        private a() {
        }
    }

    private long a(String str, long j) {
        RVLogger.d("checkDownloadedSize -- path " + str + " downloaded " + j);
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        if (j <= 0 || file.length() == j) {
            return j;
        }
        RVLogger.e("checkDownloadedSize -- delete old " + file.delete());
        return 0L;
    }

    @Override // com.alibaba.ariver.kernel.common.network.RVTransportService
    public void addDownload(RVDownloadRequest rVDownloadRequest, RVDownloadCallback rVDownloadCallback) {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        byte[] buf;
        try {
            String downloadUrl = rVDownloadRequest.getDownloadUrl();
            String downloadFileName = rVDownloadRequest.getDownloadFileName();
            String strCombinePath = FileUtils.combinePath(rVDownloadRequest.getDownloadDir(), (downloadFileName == null || "".equals(downloadFileName.trim())) ? rVDownloadRequest.getDownloadUrl().substring(rVDownloadRequest.getDownloadUrl().lastIndexOf(WVNativeCallbackUtil.SEPERATER)) : WVNativeCallbackUtil.SEPERATER + downloadFileName);
            a aVar = new a();
            for (int i = 3; i >= 0; i--) {
                try {
                    try {
                        try {
                            try {
                                a(strCombinePath, aVar.f24989a);
                                File file = new File(strCombinePath);
                                if (file.exists() && aVar.b > 0 && file.length() == aVar.b) {
                                    rVDownloadCallback.onFinish(strCombinePath);
                                    IOUtils.returnBuf(null);
                                    IOUtils.closeQuietly(null);
                                    IOUtils.closeQuietly(null);
                                    return;
                                }
                                URLConnection uRLConnectionOpenConnection = new URL(downloadUrl).openConnection();
                                uRLConnectionOpenConnection.setRequestProperty("Range", "bytes=" + aVar.f24989a + c49.f40900a);
                                uRLConnectionOpenConnection.setConnectTimeout(10000);
                                uRLConnectionOpenConnection.setReadTimeout(10000);
                                inputStream = uRLConnectionOpenConnection.getInputStream();
                                try {
                                    if (aVar.b <= 0) {
                                        aVar.b = uRLConnectionOpenConnection.getContentLength();
                                    }
                                    RVLogger.d(f24988a, "path:" + strCombinePath);
                                    if (FileUtils.create(strCombinePath)) {
                                        randomAccessFile = new RandomAccessFile(file, "rwd");
                                        try {
                                            randomAccessFile.seek(aVar.f24989a);
                                            buf = IOUtils.getBuf(1024);
                                            while (true) {
                                                try {
                                                    int i2 = inputStream.read(buf);
                                                    if (i2 == -1) {
                                                        rVDownloadCallback.onFinish(strCombinePath);
                                                        IOUtils.returnBuf(buf);
                                                        IOUtils.closeQuietly(inputStream);
                                                        IOUtils.closeQuietly(randomAccessFile);
                                                        return;
                                                    }
                                                    randomAccessFile.write(buf, 0, i2);
                                                    aVar.f24989a += (long) i2;
                                                } catch (Throwable th) {
                                                    th = th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            buf = null;
                                        }
                                    } else {
                                        IOUtils.returnBuf(null);
                                        IOUtils.closeQuietly(inputStream);
                                        IOUtils.closeQuietly(null);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    randomAccessFile = null;
                                    buf = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile = null;
                                inputStream = null;
                                buf = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(randomAccessFile);
                    } catch (Throwable th6) {
                        th = th6;
                        RVLogger.e(f24988a, "download app exception." + th);
                        rVDownloadCallback.onFailed(null, 2, th.getMessage());
                        return;
                    }
                    RVLogger.w(Log.getStackTraceString(th));
                } catch (Throwable th7) {
                    IOUtils.returnBuf(buf);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(randomAccessFile);
                    throw th7;
                }
            }
            rVDownloadCallback.onFailed(strCombinePath, 1, "download fail");
        } catch (Throwable th8) {
            th = th8;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.network.RVTransportService
    public RVHttpResponse httpRequest(RVHttpRequest rVHttpRequest) {
        RVHttpResponse rVHttpResponse = new RVHttpResponse();
        rVHttpResponse.setStatusCode(-1);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(rVHttpRequest.getUrl()).openConnection();
            httpURLConnection.setConnectTimeout(rVHttpRequest.getTimeout() > 0 ? (int) rVHttpRequest.getTimeout() : 10000);
            httpURLConnection.setRequestMethod(rVHttpRequest.getMethod());
            httpURLConnection.setReadTimeout(rVHttpRequest.getTimeout() > 0 ? (int) rVHttpRequest.getTimeout() : 10000);
            if (rVHttpRequest.getHeaders() != null) {
                for (Map.Entry<String, String> entry : rVHttpRequest.getHeaders().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.addRequestProperty(com.google.common.net.b.k, a());
            httpURLConnection.addRequestProperty(com.google.common.net.b.p, CookieManager.getInstance().getCookie(rVHttpRequest.getUrl()));
            if ("POST".equals(rVHttpRequest.getMethod()) && rVHttpRequest.getRequestData() != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(rVHttpRequest.getRequestData());
            }
            rVHttpResponse.setResStream(httpURLConnection.getInputStream());
            rVHttpResponse.setStatusCode(httpURLConnection.getResponseCode());
            rVHttpResponse.setHeaders(httpURLConnection.getHeaderFields());
            return rVHttpResponse;
        } catch (Throwable th) {
            RVLogger.e(f24988a, "download app exception." + th);
            return rVHttpResponse;
        }
    }

    private String a() {
        try {
            Locale locale = LocaleList.getDefault().get(0);
            String str = locale.getLanguage() + c49.f40900a + locale.getCountry();
            if ("zh".equals(locale.getLanguage())) {
                return str + ",zh;q=0.8,en-US;q=0.5,en;q=0.3";
            }
            return str + "," + locale.getLanguage() + ";q=0.8,en-US;q=0.5,en;q=0.3";
        } catch (Exception unused) {
            return "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3";
        }
    }
}
