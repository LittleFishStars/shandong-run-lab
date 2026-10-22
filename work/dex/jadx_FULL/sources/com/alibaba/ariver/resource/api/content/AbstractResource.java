package com.alibaba.ariver.resource.api.content;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
abstract class AbstractResource implements Resource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private String f24423a;
    private String b;
    private Map<String, String> c;
    private String d;
    private Map<String, String> e;
    protected ResourceSourceType mSourceType;

    public AbstractResource(@NonNull String str) {
        this.b = str;
        this.f24423a = UrlUtils.purifyUrl(str);
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            this.d = FileUtils.getMimeTypeFromContentType(str2);
            return;
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
    }

    public void addRequestHeader(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, str2);
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public String getEncoding() {
        return "UTF-8";
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public Map<String, String> getHeaders() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public String getMimeType() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = FileUtils.getMimeType(this.f24423a);
        }
        return this.d;
    }

    public String getOriginUrl() {
        return this.b;
    }

    public Map<String, String> getRequestHeadersMap() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public ResourceSourceType getSourceType() {
        return this.mSourceType;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    @NonNull
    public String getUrl() {
        return this.f24423a;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public boolean isLocal() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setSourceType(ResourceSourceType resourceSourceType) {
        this.mSourceType = resourceSourceType;
    }
}
