package com.fl.saas.s2s.videocache;

import android.content.Context;
import com.fl.saas.s2s.videocache.headers.HeaderInjector;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class VideoProxyHelper {
    private static final long DEFAULT_CACHE_LENGTH = 67108864;
    private static volatile VideoProxyHelper videoProxyHelper;
    private HttpProxyCacheServer proxy;
    private long maxCacheLength = DEFAULT_CACHE_LENGTH;
    private Map<String, String> globalHeaders = new HashMap();

    public class GlobalHeadersInjector implements HeaderInjector {
        public GlobalHeadersInjector() {
        }

        @Override // com.fl.saas.s2s.videocache.headers.HeaderInjector
        public Map<String, String> addHeaders(String str) {
            return VideoProxyHelper.this.globalHeaders;
        }
    }

    public static VideoProxyHelper getInstance() {
        if (videoProxyHelper == null) {
            synchronized (VideoProxyHelper.class) {
                if (videoProxyHelper == null) {
                    videoProxyHelper = new VideoProxyHelper();
                }
            }
        }
        return videoProxyHelper;
    }

    private HttpProxyCacheServer newProxy(Context context) {
        return new HttpProxyCacheServer.Builder(context).cacheDirectory(CacheUtils.getVideoCacheDir(context)).headerInjector(new GlobalHeadersInjector()).maxCacheSize(this.maxCacheLength).build();
    }

    public long getFolderSize(File file) {
        long folderSize = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return -1L;
            }
            for (File file2 : fileArrListFiles) {
                folderSize += file2.isDirectory() ? getFolderSize(file2) : file2.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folderSize;
    }

    public Map<String, String> getGlobalHeaders() {
        return this.globalHeaders;
    }

    public HttpProxyCacheServer getProxy(Context context) {
        if (this.proxy == null && context != null) {
            this.proxy = newProxy(context);
        }
        return this.proxy;
    }

    public String getProxyUrl(Context context, VideoPreLoadModel videoPreLoadModel) {
        String proxyUrl = getInstance().getProxy(context.getApplicationContext()).getProxyUrl(videoPreLoadModel.getOriginalUrl(), false);
        PreCatcher.getInstance().startCache(videoPreLoadModel.getOriginalUrl(), videoPreLoadModel.getPreLoadBytes());
        return proxyUrl;
    }

    public void setBuildConfig(Map<String, Object> map) {
        if (map == null || map.get("maxCacheLength") == null) {
            return;
        }
        this.maxCacheLength = Long.parseLong(String.valueOf(map.get("maxCacheLength")));
    }
}
