package com.alibaba.ariver.resource.api.content;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OfflineResource extends AbstractResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24425a;
    private ResourcePackage b;
    private byte[] c;

    public OfflineResource(String str, byte[] bArr) {
        super(str);
        this.f24425a = null;
        this.c = bArr;
        this.mSourceType = ResourceSourceType.OFFLINE;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ void addRequestHeader(String str, String str2) {
        super.addRequestHeader(str, str2);
    }

    public ResourcePackage getBelongsPackage() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public byte[] getBytes() {
        return this.c;
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
    public String getMimeType() {
        return TextUtils.isEmpty(this.f24425a) ? super.getMimeType() : this.f24425a;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ Map getRequestHeadersMap() {
        return super.getRequestHeadersMap();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public ResourceSourceType getSourceType() {
        return this.mSourceType;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public InputStream getStream() {
        return new ByteArrayInputStream(this.c);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    @NonNull
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public boolean isLocal() {
        return true;
    }

    public void setBelongsPackage(ResourcePackage resourcePackage) {
        this.b = resourcePackage;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setBytes(byte[] bArr) {
        this.c = bArr;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void setSourceType(ResourceSourceType resourceSourceType) {
        super.setSourceType(resourceSourceType);
    }

    public String toString() {
        return "OfflineResource(" + getUrl() + ") size: " + this.c.length;
    }

    public OfflineResource(String str, byte[] bArr, String str2) {
        super(str);
        this.c = bArr;
        this.f24425a = str2;
        this.mSourceType = ResourceSourceType.OFFLINE;
    }
}
