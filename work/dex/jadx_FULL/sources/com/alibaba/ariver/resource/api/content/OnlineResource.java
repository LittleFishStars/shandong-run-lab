package com.alibaba.ariver.resource.api.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OnlineResource extends AbstractResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private NetworkStream.Listener f24426a;
    private byte[] b;
    private boolean c;
    private NetworkStream d;

    public OnlineResource(@NonNull String str, @Nullable NetworkStream.Listener listener) {
        super(str);
        this.b = null;
        this.c = false;
        this.d = null;
        this.f24426a = listener;
        this.mSourceType = ResourceSourceType.ONLINE;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ void addRequestHeader(String str, String str2) {
        super.addRequestHeader(str, str2);
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public synchronized byte[] getBytes() {
        InputStream stream;
        byte[] bArr = this.b;
        if (bArr != null) {
            return bArr;
        }
        try {
            stream = getStream();
            try {
                byte[] toByte = IOUtils.readToByte(stream);
                this.b = toByte;
                IOUtils.closeQuietly(stream);
                return toByte;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(stream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            stream = null;
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getEncoding() {
        return super.getEncoding();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getMimeType() {
        return super.getMimeType();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ Map getRequestHeadersMap() {
        return super.getRequestHeadersMap();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ ResourceSourceType getSourceType() {
        return super.getSourceType();
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public synchronized InputStream getStream() {
        NetworkStream networkStream;
        if (this.b != null) {
            byte[] bArr = this.b;
            return new ByteArrayInputStream(bArr, 0, bArr.length);
        }
        NetworkStream networkStream2 = this.d;
        if (networkStream2 != null) {
            return networkStream2;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new NetworkStream(getOriginUrl(), this.c, this.f24426a, getRequestHeadersMap());
            }
            networkStream = this.d;
        }
        return networkStream;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    @NonNull
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ boolean isLocal() {
        return super.isLocal();
    }

    public boolean isPackageRequest() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setBytes(byte[] bArr) {
        this.b = bArr;
    }

    public void setPackageRequest(boolean z) {
        this.c = z;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void setSourceType(ResourceSourceType resourceSourceType) {
        super.setSourceType(resourceSourceType);
    }

    public String toString() {
        return "OnlineResource(" + getOriginUrl() + ")";
    }
}
