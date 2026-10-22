package com.alibaba.triver.kit.api.cache;

import android.content.Context;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileResourceCache implements IResourceCache {
    private static FileResourceCache fileResourceCache = new FileResourceCache();

    private FileResourceCache() {
    }

    private String getCacheFilePath(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return FileUtils.getLocalFilePath(context, TRiverUtils.getStringMD5(str)).getAbsolutePath();
    }

    private Context getContext() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return null;
        }
        return rVEnvironmentService.getApplicationContext();
    }

    public static FileResourceCache getInstance() {
        return fileResourceCache;
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public String getCache(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return FileUtils.loadFileOrAsset(getCacheFilePath(str), context);
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public byte[] getCacheByteArray(String str) {
        InputStream cacheStream = getCacheStream(str);
        if (cacheStream == null) {
            return null;
        }
        return IOUtils.readToByte(cacheStream);
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public InputStream getCacheStream(String str) {
        String cacheFilePath;
        if (getContext() == null || (cacheFilePath = getCacheFilePath(str)) == null) {
            return null;
        }
        File file = new File(cacheFilePath);
        if (!file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public void removeCache(String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        FileUtils.delete(FileUtils.getLocalFilePath(context, TRiverUtils.getStringMD5(str)).getAbsolutePath());
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public void saveCache(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        FileUtils.writeString2LocalFile(context, TRiverUtils.getStringMD5(str), str2);
    }
}
