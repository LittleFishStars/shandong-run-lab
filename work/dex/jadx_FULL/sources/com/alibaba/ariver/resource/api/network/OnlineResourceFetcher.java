package com.alibaba.ariver.resource.api.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.NetworkStream;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.OnlineResource;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OnlineResourceFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24430a = "AriverRes:OnlineResourceFetcher";
    private static final List<String> b;
    private final Map<String, Resource> c = new HashMap();
    private boolean d = false;
    private FallbackListener e;

    public interface FallbackListener {
        void onFailed(String str);

        void onSuccess(String str, Resource resource);
    }

    public class ResourceListener implements NetworkStream.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24431a;

        public ResourceListener(String str) {
            this.f24431a = str;
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputClose(NetworkStream networkStream) {
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputException() {
            RVLogger.w(OnlineResourceFetcher.f24430a, "online resource [" + this.f24431a + "] miss!");
            OnlineResourceFetcher.this.c.remove(this.f24431a);
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputOpen(NetworkStream networkStream) {
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onResourceError(NetworkStream networkStream, int i) {
            RVLogger.w(OnlineResourceFetcher.f24430a, "online resource [" + this.f24431a + "] miss!");
            OnlineResourceFetcher.this.c.remove(this.f24431a);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add(RVConstants.FILE_API_PERMISSION);
        arrayList.add(RVConstants.FILE_APP_CONFIG);
        arrayList.add(RVConstants.FILE_TABBAR);
        arrayList.add("index.js");
        arrayList.add("index.worker.js");
        arrayList.add("index.html");
    }

    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.c.containsKey(str);
    }

    @VisibleForTesting
    public Resource createOnlineResource(String str, boolean z, @Nullable String str2) {
        OnlineResource onlineResource = new OnlineResource(str, new ResourceListener(str));
        if (!TextUtils.isEmpty(str2)) {
            onlineResource.addRequestHeader("x-mass-tappid", str2);
        }
        onlineResource.setPackageRequest(z);
        return onlineResource;
    }

    @WorkerThread
    public Resource getOnlineResource(String str, boolean z, String str2) {
        Resource resource = this.c.get(str);
        if (resource != null) {
            RVLogger.d(f24430a, "getOnlineResource hit cache: " + str);
            return resource;
        }
        synchronized (this.c) {
            Resource offlineResource = this.c.get(str);
            if (offlineResource == null) {
                RVLogger.d(f24430a, "getOnlineResource miss cache: " + str);
                if (!UrlUtils.isValidUrl(str) && !"YES".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_disableUrlCheck", null))) {
                    return null;
                }
                offlineResource = createOnlineResource(str, z, str2);
                this.c.put(str, offlineResource);
            }
            synchronized (this.c.get(str)) {
                byte[] bytes = offlineResource.getBytes();
                if (bytes == null || bytes.length == 0) {
                    FallbackListener fallbackListener = this.e;
                    if (fallbackListener != null) {
                        fallbackListener.onFailed(str);
                    }
                    this.c.remove(str);
                } else {
                    offlineResource = new OfflineResource(str, bytes);
                    FallbackListener fallbackListener2 = this.e;
                    if (fallbackListener2 != null) {
                        fallbackListener2.onSuccess(str, offlineResource);
                    }
                    RVLogger.w(f24430a, "getOnlineResource [" + str + "] got length: " + bytes.length);
                }
            }
            offlineResource.setSourceType(ResourceSourceType.FALLBACK);
            return offlineResource;
        }
    }

    public boolean hasKeyResourceFallback() {
        return this.d;
    }

    public void prefetchUrl(final String str) {
        if (TextUtils.isEmpty(str) || this.c.containsKey(str)) {
            return;
        }
        RVLogger.d(f24430a, "prefetchUrl: " + str);
        ExecutorUtils.runNotOnMain(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                OnlineResourceFetcher.this.getOnlineResource(str, false, null);
            }
        });
    }

    public void setFallbackListener(FallbackListener fallbackListener) {
        this.e = fallbackListener;
    }

    public void startFallback(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null || TextUtils.isEmpty(appModel.getAppInfoModel().getFallbackBaseUrl())) {
            return;
        }
        String fallbackBaseUrl = appModel.getAppInfoModel().getFallbackBaseUrl();
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            prefetchUrl(FileUtils.combinePath(fallbackBaseUrl, it.next()));
        }
        this.d = true;
        RVLogger.d(f24430a);
    }
}
