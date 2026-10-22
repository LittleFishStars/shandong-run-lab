package com.alibaba.triver.open.impl;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceProviderImpl implements NodeAware<App>, ResourceProviderPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25061a = "ResourceProviderImpl";
    private App b;

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(String str) {
        try {
            RVHttpRequest rVHttpRequestBuild = RVHttpRequest.newBuilder().url(str).build();
            RVHttpResponse rVHttpResponseA = com.alibaba.triver.open.prefetch.a.a(rVHttpRequestBuild);
            if (rVHttpResponseA == null) {
                rVHttpResponseA = ((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(rVHttpRequestBuild);
            }
            if (rVHttpResponseA != null) {
                return rVHttpResponseA.getResStream();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.resource.api.extension.ResourceProviderPoint
    public Resource getResource(ResourceQuery resourceQuery) {
        String str = resourceQuery.pureUrl;
        if (!TextUtils.isEmpty(str) && this.b != null) {
            final String strPurifyUrl = UrlUtils.purifyUrl(str);
            RVLogger.w(f25061a, strPurifyUrl + " start load : " + Thread.currentThread().getId());
            if (strPurifyUrl.endsWith(".png")) {
                RVLogger.printPerformanceLog("start load image url", strPurifyUrl);
                return new Resource() { // from class: com.alibaba.triver.open.impl.ResourceProviderImpl.1
                    private InputStream c;

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void addHeader(String str2, String str3) {
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public byte[] getBytes() {
                        return new byte[0];
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public String getEncoding() {
                        return "UTF-8";
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @Nullable
                    public Map<String, String> getHeaders() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @Nullable
                    public String getMimeType() {
                        return "image/png";
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public ResourceSourceType getSourceType() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public InputStream getStream() {
                        return new InputStream() { // from class: com.alibaba.triver.open.impl.ResourceProviderImpl.1.1
                            @Override // java.io.InputStream
                            public int read() throws IOException {
                                if (AnonymousClass1.this.c == null) {
                                    try {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        anonymousClass1.c = ResourceProviderImpl.this.a(strPurifyUrl);
                                    } catch (Throwable th) {
                                        RVLogger.w(Log.getStackTraceString(th));
                                    }
                                }
                                if (AnonymousClass1.this.c == null) {
                                    RVLogger.w(ResourceProviderImpl.f25061a, strPurifyUrl + " fail load " + Thread.currentThread().getId());
                                    return -1;
                                }
                                int i = AnonymousClass1.this.c.read();
                                if (i == -1 && ResourceProviderImpl.this.b.getActivePage() != null && (ResourceProviderImpl.this.b.getActivePage().getPageContext() instanceof com.alibaba.triver.open.container.a)) {
                                    RVLogger.w(ResourceProviderImpl.f25061a, strPurifyUrl + " finish load " + Thread.currentThread().getId());
                                    ((com.alibaba.triver.open.container.a) ResourceProviderImpl.this.b.getActivePage().getPageContext()).a();
                                }
                                if (i == -1) {
                                    RVLogger.printPerformanceLog("end load image url", strPurifyUrl);
                                }
                                return i;
                            }
                        };
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @NonNull
                    public String getUrl() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public boolean isLocal() {
                        return false;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void setBytes(byte[] bArr) {
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void setSourceType(ResourceSourceType resourceSourceType) {
                    }
                };
            }
            if (strPurifyUrl.endsWith(FileTypes.F)) {
                RVLogger.printPerformanceLog("start load image url", strPurifyUrl);
                return new Resource() { // from class: com.alibaba.triver.open.impl.ResourceProviderImpl.2
                    private InputStream c;

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void addHeader(String str2, String str3) {
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public byte[] getBytes() {
                        return new byte[0];
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public String getEncoding() {
                        return "UTF-8";
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @Nullable
                    public Map<String, String> getHeaders() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @Nullable
                    public String getMimeType() {
                        return "image/jpg";
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public ResourceSourceType getSourceType() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public InputStream getStream() {
                        return new InputStream() { // from class: com.alibaba.triver.open.impl.ResourceProviderImpl.2.1
                            @Override // java.io.InputStream
                            public int read() throws IOException {
                                if (AnonymousClass2.this.c == null) {
                                    try {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        anonymousClass2.c = ResourceProviderImpl.this.a(strPurifyUrl);
                                    } catch (Throwable th) {
                                        RVLogger.w(Log.getStackTraceString(th));
                                    }
                                }
                                if (AnonymousClass2.this.c == null) {
                                    RVLogger.w(ResourceProviderImpl.f25061a, strPurifyUrl + " fail load " + Thread.currentThread().getId());
                                    return -1;
                                }
                                int i = AnonymousClass2.this.c.read();
                                if (i == -1 && ResourceProviderImpl.this.b.getActivePage() != null && (ResourceProviderImpl.this.b.getActivePage().getPageContext() instanceof com.alibaba.triver.open.container.a)) {
                                    RVLogger.w(ResourceProviderImpl.f25061a, strPurifyUrl + " finish load " + Thread.currentThread().getId());
                                    ((com.alibaba.triver.open.container.a) ResourceProviderImpl.this.b.getActivePage().getPageContext()).a();
                                }
                                if (i == -1) {
                                    RVLogger.printPerformanceLog("end load image url", strPurifyUrl);
                                }
                                return i;
                            }
                        };
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    @NonNull
                    public String getUrl() {
                        return null;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public boolean isLocal() {
                        return false;
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void setBytes(byte[] bArr) {
                    }

                    @Override // com.alibaba.ariver.engine.api.resources.Resource
                    public void setSourceType(ResourceSourceType resourceSourceType) {
                    }
                };
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.b = weakReference.get();
    }
}
