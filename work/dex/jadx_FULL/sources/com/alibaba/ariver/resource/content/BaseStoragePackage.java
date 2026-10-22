package com.alibaba.ariver.resource.content;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseStoragePackage implements ResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24441a = "header.json";
    private String c;
    private final Map<String, Map<String, String>> b = new ConcurrentHashMap();
    private boolean d = false;
    private Map<String, Resource> e = new ConcurrentHashMap();
    protected CountDownLatch mSetupLock = new CountDownLatch(1);
    protected CountDownLatch mParseLock = new CountDownLatch(1);

    private void a(byte[] bArr) {
        this.b.clear();
        String str = new String(bArr);
        RVLogger.d(getLogTag(), "addHeader from header.json: " + str);
        JSONObject object = JSONUtils.parseObject(str);
        if (object == null || object.size() <= 0) {
            return;
        }
        for (String str2 : new HashSet(object.keySet())) {
            JSONObject jSONObject = JSONUtils.getJSONObject(object, str2, null);
            if (jSONObject != null) {
                HashMap map = new HashMap();
                for (String str3 : jSONObject.keySet()) {
                    String string = JSONUtils.getString(jSONObject, str3);
                    if (!TextUtils.isEmpty(string)) {
                        map.put(str3, string);
                    }
                }
                this.b.put(str2, map);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void add(Resource resource) {
        this.e.put(resource.getUrl(), resource);
        Uri url = UrlUtils.parseUrl(resource.getUrl());
        if (f24441a.equals(resource.getUrl()) || f24441a.equals(url.getLastPathSegment())) {
            a(resource.getBytes());
        }
    }

    public void afterParsePackage(ParseContext parseContext) {
    }

    public void beforeParsePackage(ParseContext parseContext) {
    }

    public boolean contains(String str) {
        return this.e.containsKey(str);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public int count() {
        return this.e.size();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        String str = resourceQuery.pureUrl;
        if (this.mSetupLock.getCount() > 0) {
            if (needWaitSetupWhenGet()) {
                RVLogger.d(getLogTag(), "get resource wait for mSetupLock!");
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    this.mSetupLock.await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                RVLogger.d(getLogTag(), "wait for mSetupLock cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            if (this.mParseLock.getCount() > 0) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                RVLogger.d(getLogTag(), "get resource wait for parseLock!");
                try {
                    this.mParseLock.await(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    RVLogger.w(getLogTag(), "wait parse exception ", e2);
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                RVLogger.d(getLogTag(), "wait for parseLock cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                if (jCurrentTimeMillis3 >= 3000) {
                    this.c = "wait_appParse_timeout";
                    this.mParseLock.countDown();
                }
            }
        }
        Resource resource = this.e.get(str);
        if (resource != null) {
            RVLogger.d(getLogTag(), "load response " + str);
        } else if (TextUtils.isEmpty(this.c)) {
            this.c = "notMatch";
        }
        return resource;
    }

    public abstract String getLogTag();

    public CountDownLatch getParseLock() {
        return this.mParseLock;
    }

    public Map<String, Map<String, String>> getResourceHeaderMap() {
        return this.b;
    }

    public CountDownLatch getSetupLock() {
        return this.mSetupLock;
    }

    public boolean isDetached() {
        return this.d;
    }

    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean isPrepareDone() {
        return this.mSetupLock.getCount() == 0;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public Set<String> keySet() {
        return this.e.keySet();
    }

    public boolean needWaitSetupWhenGet() {
        return false;
    }

    @CallSuper
    public void onParseDone() {
        this.mParseLock.countDown();
    }

    public void onParsePackageSuccess(ParseContext parseContext) {
    }

    @CallSuper
    public void onPrepareDone() {
        this.mSetupLock.countDown();
    }

    public void onVerifyError(ParseFailedException parseFailedException) {
        ParseContext parseContext = parseFailedException.getParseContext();
        if (parseContext != null) {
            RVLogger.w(getLogTag(), "onVerifyError, delete packagePath: " + parseContext.packagePath);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("APP_LOAD_CACHE_FAIL", "离线包加载至内存失败: appId=" + parseContext.appId, "Worker", parseContext.appId, null, null);
            FileUtils.delete(parseContext.packagePath);
        }
    }

    public void parseContent(final String str, String str2) {
        RVLogger.d(getLogTag(), "parseContent installPath:" + str2);
        if (TextUtils.isEmpty(str2)) {
            RVLogger.e(getLogTag(), "parseContent installPath is null, appId:" + str);
        }
        try {
            final ParseContext parseContext = new ParseContext();
            parseContext.appId = str;
            parseContext.packagePath = str2;
            beforeParsePackage(parseContext);
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.content.BaseStoragePackage.1
                @Override // java.lang.Runnable
                public void run() {
                    Map<String, String> map;
                    try {
                        try {
                            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Package_parse_ + str);
                            Iterator<Resource> it = PackageParseUtils.parsePackage(parseContext).values().iterator();
                            while (it.hasNext()) {
                                BaseStoragePackage.this.add(it.next());
                            }
                            BaseStoragePackage.this.onParsePackageSuccess(parseContext);
                        } catch (ParseFailedException e) {
                            e.setParseContext(parseContext);
                            BaseStoragePackage.this.onVerifyError(e);
                        }
                        BaseStoragePackage.this.onPrepareDone();
                        BaseStoragePackage.this.onParseDone();
                        for (String str3 : BaseStoragePackage.this.getResourceHeaderMap().keySet()) {
                            Resource resource = BaseStoragePackage.this.get(ResourceQuery.asUrl(str3));
                            if (resource != null && (map = BaseStoragePackage.this.getResourceHeaderMap().get(str3)) != null) {
                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                    resource.addHeader(entry.getKey(), entry.getValue());
                                }
                            }
                        }
                        BaseStoragePackage.this.afterParsePackage(parseContext);
                        RVTraceUtils.traceEndSection(RVTraceKey.RV_Package_parse_ + str);
                    } catch (Throwable th) {
                        BaseStoragePackage.this.onPrepareDone();
                        BaseStoragePackage.this.onParseDone();
                        throw th;
                    }
                }
            });
        } catch (Exception e) {
            RVLogger.e(getLogTag(), "parseContent exception!", e);
            onParseDone();
            onPrepareDone();
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void remove(String str) {
        this.e.remove(str);
    }

    @VisibleForTesting
    public void setStorage(Map<String, Resource> map) {
        this.e = map;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void teardown() {
        RVLogger.d(getLogTag(), "release storage");
        this.d = true;
        this.e.clear();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void waitForParse() {
        try {
            this.mParseLock.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RVLogger.e(getLogTag(), "waitForSetup error", e);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void waitForSetup() {
        RVLogger.w(getLogTag(), "waitForSetup (" + this.mSetupLock.getCount() + ") with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        try {
            this.mSetupLock.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RVLogger.e(getLogTag(), "waitForSetup error", e);
        }
    }
}
