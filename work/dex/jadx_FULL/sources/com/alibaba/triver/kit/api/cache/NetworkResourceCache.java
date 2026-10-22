package com.alibaba.triver.kit.api.cache;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.triver.kit.api.network.HttpDownloader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkResourceCache implements IResourceCache {
    private static final String BASE_KEY = "tr_resource_cache_default";
    private SharedPreferences cache;
    private static Map<String, NetworkResourceCache> resourceCacheMap = new ConcurrentHashMap();
    private static NetworkResourceCache defaultCache = new NetworkResourceCache();

    public interface OnDownloadResultCallback {
        void onDownloadFailed(String str, String str2);

        void onDownloadSuccess(String str, String str2, String str3);
    }

    public interface OnObjectGetCallback {
        void onObjectGetCallback(@NonNull String str, @Nullable Object obj);
    }

    public interface OnObjectSetCallback {
        void onObjectSetCallback(@NonNull String str, boolean z);
    }

    public interface OnStreamGetCallback {
        void onStreamGetCallback(@NonNull String str, InputStream inputStream);
    }

    private NetworkResourceCache() {
        this(BASE_KEY);
    }

    public static synchronized NetworkResourceCache getInstance() {
        return defaultCache;
    }

    public String downloadResourceToCache(String str, String str2) {
        String strDownload;
        if (this.cache == null || (strDownload = HttpDownloader.download(str)) == null) {
            return null;
        }
        saveCache(str2, strDownload);
        return strDownload;
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public String getCache(String str) {
        SharedPreferences sharedPreferences = this.cache;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, null);
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public byte[] getCacheByteArray(String str) {
        String cache = getCache(str);
        if (cache == null) {
            return null;
        }
        return cache.getBytes();
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public InputStream getCacheStream(String str) {
        byte[] cacheByteArray = getCacheByteArray(str);
        if (cacheByteArray == null) {
            return null;
        }
        return new ByteArrayInputStream(cacheByteArray);
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public void removeCache(String str) {
        SharedPreferences sharedPreferences = this.cache;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    @Override // com.alibaba.triver.kit.api.cache.IResourceCache
    public void saveCache(String str, String str2) {
        SharedPreferences sharedPreferences = this.cache;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    private NetworkResourceCache(String str) {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext != null) {
            this.cache = applicationContext.getSharedPreferences(str, 0);
        }
    }

    public static synchronized NetworkResourceCache getInstance(String str) {
        if (resourceCacheMap.containsKey(str)) {
            return resourceCacheMap.get(str);
        }
        NetworkResourceCache networkResourceCache = new NetworkResourceCache(str);
        resourceCacheMap.put(str, networkResourceCache);
        return networkResourceCache;
    }

    public void downloadResourceToCache(final String str, final String str2, final OnDownloadResultCallback onDownloadResultCallback) {
        if (this.cache != null) {
            AsyncTask.execute(new Runnable() { // from class: com.alibaba.triver.kit.api.cache.NetworkResourceCache.1
                @Override // java.lang.Runnable
                public void run() {
                    String strDownloadResourceToCache = NetworkResourceCache.this.downloadResourceToCache(str, str2);
                    if (strDownloadResourceToCache == null) {
                        OnDownloadResultCallback onDownloadResultCallback2 = onDownloadResultCallback;
                        if (onDownloadResultCallback2 != null) {
                            onDownloadResultCallback2.onDownloadFailed(str, str2);
                            return;
                        }
                        return;
                    }
                    OnDownloadResultCallback onDownloadResultCallback3 = onDownloadResultCallback;
                    if (onDownloadResultCallback3 != null) {
                        onDownloadResultCallback3.onDownloadSuccess(str, str2, strDownloadResourceToCache);
                    }
                }
            });
        } else if (onDownloadResultCallback != null) {
            onDownloadResultCallback.onDownloadFailed(str, str2);
        }
    }
}
