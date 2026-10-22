package com.aliyun.credentials.http;

import com.alipay.sdk.m.y.l;
import com.aliyun.credentials.exception.CredentialException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompatibleUrlConnClient implements Closeable {
    protected static final String ACCEPT_ENCODING = "Accept-Encoding";
    protected static final String CONTENT_TYPE = "Content-Type";

    public static HttpResponse compatibleGetResponse(HttpRequest httpRequest) throws Throwable {
        CompatibleUrlConnClient compatibleUrlConnClient = new CompatibleUrlConnClient();
        HttpResponse httpResponseSyncInvoke = compatibleUrlConnClient.syncInvoke(httpRequest);
        compatibleUrlConnClient.close();
        return httpResponseSyncInvoke;
    }

    public HttpURLConnection buildHttpConnection(HttpRequest httpRequest) {
        checkHttpRequest(httpRequest);
        try {
            URL url = new URL(httpRequest.getSysUrl());
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
            return initHttpConnection(url, httpRequest);
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public void checkHttpRequest(HttpRequest httpRequest) {
        if (httpRequest.getSysUrl() == null) {
            throw new IllegalArgumentException("URL is null for HttpRequest.");
        }
        if (httpRequest.getSysMethod() == null) {
            throw new IllegalArgumentException("Method is not set for HttpRequest.");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public SSLSocketFactory createSSLSocketFactory() {
        try {
            X509TrustManagerImp x509TrustManagerImp = new X509TrustManagerImp();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManagerImp}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public HttpURLConnection initHttpConnection(URL url, HttpRequest httpRequest) {
        HttpURLConnection httpURLConnection;
        try {
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new TrueHostnameVerifier());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(httpRequest.getSysMethod().toString());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            setConnectionTimeout(httpURLConnection, httpRequest);
            httpURLConnection.setRequestProperty("Accept-Encoding", HlsPlaylistParser.V);
            if (httpRequest.getHttpContent() != null) {
                httpURLConnection.setRequestProperty("Content-Type", httpRequest.getSysHeaders().get("Content-Type"));
            }
            return httpURLConnection;
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public void parseHttpConn(HttpResponse httpResponse, HttpURLConnection httpURLConnection, InputStream inputStream, Exception exc) {
        try {
            if (inputStream == null) {
                httpResponse.setResponseMessage(exc.getMessage());
                return;
            }
            byte[] content = readContent(inputStream);
            httpResponse.setResponseCode(httpURLConnection.getResponseCode());
            httpResponse.setResponseMessage(httpURLConnection.getResponseMessage());
            Iterator<Map.Entry<String, List<String>>> it = httpURLConnection.getHeaderFields().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, List<String>> next = it.next();
                String key = next.getKey();
                if (key != null) {
                    List<String> value = next.getValue();
                    StringBuilder sb = new StringBuilder(value.get(0));
                    for (int i = 1; i < value.size(); i++) {
                        sb.append(",");
                        sb.append(value.get(i));
                    }
                    httpResponse.putHeaderParameter(key, sb.toString());
                }
            }
            String headerValue = httpResponse.getHeaderValue("Content-Type");
            if (content != null && headerValue != null) {
                httpResponse.setSysEncoding("UTF-8");
                String[] strArrSplit = headerValue.split(l.b);
                httpResponse.setHttpContentType(FormatType.mapAcceptToFormat(strArrSplit[0].trim()));
                if (strArrSplit.length > 1 && strArrSplit[1].contains("=")) {
                    httpResponse.setSysEncoding(strArrSplit[1].split("=")[1].trim().toUpperCase());
                }
            }
            httpResponse.setHttpContent(content, httpResponse.getSysEncoding(), httpResponse.getHttpContentType());
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public byte[] readContent(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                throw new CredentialException(e.getMessage(), e);
            }
        }
    }

    public void setConnectionTimeout(HttpURLConnection httpURLConnection, HttpRequest httpRequest) {
        httpURLConnection.setConnectTimeout(httpRequest.getSysConnectTimeout().intValue());
        httpURLConnection.setReadTimeout(httpRequest.getSysReadTimeout().intValue());
    }

    public HttpResponse syncInvoke(HttpRequest httpRequest) throws Throwable {
        HttpURLConnection httpURLConnectionBuildHttpConnection = buildHttpConnection(httpRequest);
        InputStream errorStream = null;
        try {
            try {
                httpURLConnectionBuildHttpConnection.connect();
                if (httpRequest.getHttpContent() != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionBuildHttpConnection.getOutputStream());
                    dataOutputStream.write(httpRequest.getHttpContent());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                InputStream inputStream = httpURLConnectionBuildHttpConnection.getInputStream();
                try {
                    HttpResponse httpResponse = new HttpResponse(httpURLConnectionBuildHttpConnection.getURL().toString());
                    parseHttpConn(httpResponse, httpURLConnectionBuildHttpConnection, inputStream, null);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            throw new CredentialException(e.getMessage(), e);
                        }
                    }
                    httpURLConnectionBuildHttpConnection.disconnect();
                    return httpResponse;
                } catch (IOException e2) {
                    e = e2;
                    errorStream = httpURLConnectionBuildHttpConnection.getErrorStream();
                    HttpResponse httpResponse2 = new HttpResponse(httpURLConnectionBuildHttpConnection.getURL().toString());
                    parseHttpConn(httpResponse2, httpURLConnectionBuildHttpConnection, errorStream, e);
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (IOException e3) {
                            throw new CredentialException(e3.getMessage(), e3);
                        }
                    }
                    httpURLConnectionBuildHttpConnection.disconnect();
                    return httpResponse2;
                } catch (Throwable th) {
                    errorStream = inputStream;
                    th = th;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (IOException e4) {
                            throw new CredentialException(e4.getMessage(), e4);
                        }
                    }
                    httpURLConnectionBuildHttpConnection.disconnect();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
