package com.alibaba.ariver.engine.api.resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Resource {
    void addHeader(String str, String str2);

    byte[] getBytes();

    String getEncoding();

    @Nullable
    Map<String, String> getHeaders();

    @Nullable
    String getMimeType();

    ResourceSourceType getSourceType();

    InputStream getStream();

    @NonNull
    String getUrl();

    boolean isLocal();

    void setBytes(byte[] bArr);

    void setSourceType(ResourceSourceType resourceSourceType);
}
