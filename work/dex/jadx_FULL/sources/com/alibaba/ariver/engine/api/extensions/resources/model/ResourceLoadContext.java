package com.alibaba.ariver.engine.api.extensions.resources.model;

import android.net.Uri;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceLoadContext {
    public static int WEBTYPE_IS_NOT_WEBVIEW = 4;
    public static int WEBTYPE_RN_VIEW = 3;
    public static int WEBTYPE_SYSTEM_BUILD_IN = 1;
    public static int WEBTYPE_THIRD_PARTY = 2;
    public boolean canAsyncFallback;
    public boolean canDegradeGlobalPackage;
    public boolean canUseFallback;
    public boolean isMainDoc;
    public String originUrl;
    public Node sourceNode;
    public Uri uri;

    @Deprecated
    public int webType;

    public static class Builder {
        public boolean canUseFallback;
        public String originUrl;
        public Node sourceNode;
        public Uri uri;
        public boolean canAsyncFallback = false;
        public boolean canDegradeGlobalPackage = true;
        public boolean isMainDoc = false;
        public int webType = ResourceLoadContext.WEBTYPE_IS_NOT_WEBVIEW;

        public ResourceLoadContext build() {
            return new ResourceLoadContext(this);
        }

        public Builder canAsyncFallback(boolean z) {
            this.canAsyncFallback = z;
            return this;
        }

        public Builder canDegradeGlobalPackage(boolean z) {
            this.canDegradeGlobalPackage = z;
            return this;
        }

        public Builder canUseFallback(boolean z) {
            this.canUseFallback = z;
            return this;
        }

        public Builder isMainDoc(boolean z) {
            this.isMainDoc = z;
            return this;
        }

        public Builder originUrl(String str) {
            this.originUrl = str;
            return this;
        }

        public Builder sourceNode(Node node) {
            this.sourceNode = node;
            return this;
        }

        public Builder uri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder webType(int i) {
            this.webType = i;
            return this;
        }
    }

    public ResourceLoadContext() {
        this.canDegradeGlobalPackage = true;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ResourceLoadContext(Builder builder) {
        String str = builder.originUrl;
        this.originUrl = str;
        Uri uri = builder.uri;
        if (uri == null) {
            this.uri = UrlUtils.parseUrl(str);
        } else {
            this.uri = uri;
        }
        this.canUseFallback = builder.canUseFallback;
        this.canAsyncFallback = builder.canAsyncFallback;
        this.isMainDoc = builder.isMainDoc;
        this.webType = builder.webType;
        this.canDegradeGlobalPackage = builder.canDegradeGlobalPackage;
    }
}
