package com.alibaba.triver.kit.api.preload.core;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.preload.annotation.AppxJob;
import com.alibaba.triver.kit.api.preload.annotation.PreloadThreadType;
import com.alibaba.triver.kit.api.preload.annotation.RunningAfterAppxJob;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PreloadScheduler {
    public static final String TAG = "PreloadScheduler";
    public static String UA;
    private static PreloadScheduler mInstance;
    private Map<PointType, List<Class<? extends IPreloadJob>>> mJobList = new HashMap();
    private Map<Class, PreloadResultWrapper> mLocalCache = new HashMap();
    private CountDownLatch mAppxJobLock = new CountDownLatch(1);
    private Map<Long, List<String>> mSucceedPreloadList = new HashMap();

    public enum PointType {
        PROCESS_CREATE,
        PRELOAD_RESOURCE,
        CREATE_ACTIVITY,
        CREATE_APP,
        CLOSE_APP,
        AFTER_OPEN_PAGE,
        DATA_PREFETCH,
        AFTER_PARSE_PACKAGE,
        PROCESS_DIED,
        AFTER_PAGE_LOADED
    }

    public class PreloadResultWrapper {
        public String name;
        public Object obj;

        public PreloadResultWrapper(String str, Object obj) {
            this.name = str;
            this.obj = obj;
        }
    }

    public static PreloadScheduler getInstance() {
        if (mInstance == null) {
            mInstance = new PreloadScheduler();
        }
        return mInstance;
    }

    public void doPreload(IPreloadJob iPreloadJob, Map<String, Object> map, PointType pointType) {
        try {
            Object objPreLoad = iPreloadJob.preLoad(map, pointType);
            if (objPreLoad != null) {
                this.mLocalCache.put(objPreLoad.getClass(), new PreloadResultWrapper(iPreloadJob.getJobName(), objPreLoad));
                RVLogger.d(TAG, iPreloadJob.getJobName() + " preload finish with result.");
            } else {
                RVLogger.d(TAG, iPreloadJob.getJobName() + " preload finish with no result.");
            }
        } catch (Exception e) {
            RVLogger.e(TAG, iPreloadJob.getJobName() + " preload error", e);
        }
    }

    public <T> T getAndRemoveReadyResult(long j, Class<T> cls) {
        T t;
        PreloadResultWrapper preloadResultWrapperRemove = this.mLocalCache.remove(cls);
        if (preloadResultWrapperRemove == null || (t = (T) preloadResultWrapperRemove.obj) == null) {
            return null;
        }
        try {
            Map<Long, List<String>> map = this.mSucceedPreloadList;
            if (map != null) {
                List<String> list = map.get(Long.valueOf(j));
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(preloadResultWrapperRemove.name);
                    this.mSucceedPreloadList.put(Long.valueOf(j), arrayList);
                } else {
                    list.add(preloadResultWrapperRemove.name);
                }
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, preloadResultWrapperRemove.name + " class cast error", th);
        }
        return t;
    }

    public <T> T getReadyResult(long j, Class<T> cls) {
        T t;
        PreloadResultWrapper preloadResultWrapper = this.mLocalCache.get(cls);
        if (preloadResultWrapper == null || (t = (T) preloadResultWrapper.obj) == null) {
            return null;
        }
        try {
            Map<Long, List<String>> map = this.mSucceedPreloadList;
            if (map != null) {
                List<String> list = map.get(Long.valueOf(j));
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(preloadResultWrapper.name);
                    this.mSucceedPreloadList.put(Long.valueOf(j), arrayList);
                } else {
                    list.add(preloadResultWrapper.name);
                }
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, preloadResultWrapper.name + " class cast error", th);
        }
        return t;
    }

    public List<String> getSucceedPreloadName(long j) {
        Map<Long, List<String>> map = this.mSucceedPreloadList;
        if (map != null) {
            return map.get(Long.valueOf(j));
        }
        return null;
    }

    public void preLoad(final PointType pointType, final Map<String, Object> map) {
        if (CommonUtils.closePreloadScheduler()) {
            RVLogger.d(TAG, "PreloadScheduler close");
            return;
        }
        if (CommonUtils.closePreloadSchedulerPoints(pointType)) {
            RVLogger.d(TAG, "PreloadScheduler " + pointType + " point preload close");
            return;
        }
        List<Class<? extends IPreloadJob>> list = this.mJobList.get(pointType);
        if (list == null) {
            RVLogger.e(TAG, pointType + " list is null");
            return;
        }
        for (Class<? extends IPreloadJob> cls : list) {
            if (cls != null) {
                final String simpleName = cls.getSimpleName();
                RVLogger.d(TAG, simpleName + " preload start");
                try {
                    final IPreloadJob iPreloadJobNewInstance = cls.newInstance();
                    if (iPreloadJobNewInstance == null) {
                        RVLogger.d(TAG, "PreloadScheduler this is a null job");
                    } else if (CommonUtils.closePreloadSchedulerJob(iPreloadJobNewInstance.getJobName())) {
                        RVLogger.d(TAG, "PreloadScheduler " + iPreloadJobNewInstance.getJobName() + " job close");
                    } else {
                        final Method method = cls.getMethod("preLoad", Map.class, PointType.class);
                        PreloadThreadType preloadThreadType = (PreloadThreadType) method.getAnnotation(PreloadThreadType.class);
                        ExecutorType executorTypeValue = preloadThreadType != null ? preloadThreadType.value() : null;
                        if (executorTypeValue == null) {
                            executorTypeValue = ExecutorType.IDLE;
                        }
                        ExecutorType executorType = ExecutorType.UI;
                        if (executorTypeValue != executorType) {
                            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(executorTypeValue).execute(new Runnable() { // from class: com.alibaba.triver.kit.api.preload.core.PreloadScheduler.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AppxJob appxJob = (AppxJob) method.getAnnotation(AppxJob.class);
                                    if (appxJob != null && appxJob.value()) {
                                        synchronized (this) {
                                            if (PreloadScheduler.this.mAppxJobLock.getCount() == 0) {
                                                PreloadScheduler.this.mAppxJobLock = new CountDownLatch(1);
                                            }
                                            RVLogger.d(PreloadScheduler.TAG, simpleName + " is appx job begin.");
                                            PreloadScheduler.this.doPreload(iPreloadJobNewInstance, map, pointType);
                                            RVLogger.d(PreloadScheduler.TAG, simpleName + " is appx job end.");
                                            PreloadScheduler.this.mAppxJobLock.countDown();
                                        }
                                        return;
                                    }
                                    RunningAfterAppxJob runningAfterAppxJob = (RunningAfterAppxJob) method.getAnnotation(RunningAfterAppxJob.class);
                                    if (runningAfterAppxJob != null && runningAfterAppxJob.value()) {
                                        synchronized (this) {
                                            try {
                                                RVLogger.d(PreloadScheduler.TAG, "Sync job " + simpleName + " waiting for appx preload.");
                                                PreloadScheduler.this.mAppxJobLock.await(10L, TimeUnit.SECONDS);
                                                RVLogger.d(PreloadScheduler.TAG, "Sync job " + simpleName + " begin.");
                                            } catch (Exception e) {
                                                RVLogger.e(PreloadScheduler.TAG, "preLoad wait appx error", e);
                                            }
                                        }
                                    }
                                    PreloadScheduler.this.doPreload(iPreloadJobNewInstance, map, pointType);
                                }
                            });
                        } else if (preloadThreadType.value() == executorType) {
                            RunningAfterAppxJob runningAfterAppxJob = (RunningAfterAppxJob) method.getAnnotation(RunningAfterAppxJob.class);
                            if (runningAfterAppxJob == null || !runningAfterAppxJob.value()) {
                                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(executorType).execute(new Runnable() { // from class: com.alibaba.triver.kit.api.preload.core.PreloadScheduler.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PreloadScheduler.this.doPreload(iPreloadJobNewInstance, map, pointType);
                                    }
                                });
                            } else {
                                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.kit.api.preload.core.PreloadScheduler.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        synchronized (this) {
                                            try {
                                                RVLogger.d(PreloadScheduler.TAG, "Sync UI job " + simpleName + " waiting for appx preload.");
                                                PreloadScheduler.this.mAppxJobLock.await(10L, TimeUnit.SECONDS);
                                                RVLogger.d(PreloadScheduler.TAG, "Sync UI job " + simpleName + " begin.");
                                            } catch (Exception e) {
                                                RVLogger.e(PreloadScheduler.TAG, "preLoad wait appx error", e);
                                            }
                                        }
                                        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.kit.api.preload.core.PreloadScheduler.2.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                                PreloadScheduler.this.doPreload(iPreloadJobNewInstance, map, pointType);
                                            }
                                        });
                                    }
                                });
                            }
                        }
                        RVLogger.e(TAG, simpleName + " preload job commit.");
                    }
                } catch (Throwable th) {
                    RVLogger.e(TAG, simpleName + " invoke error", th);
                }
            }
        }
    }

    public <T> void putReadyResult(Class<T> cls, IPreloadJob iPreloadJob, T t) {
        this.mLocalCache.put(cls, new PreloadResultWrapper(iPreloadJob.getJobName(), t));
    }

    public void registerPreLoadJob(PointType pointType, Class<? extends IPreloadJob> cls) {
        List<Class<? extends IPreloadJob>> list = this.mJobList.get(pointType);
        if (list != null) {
            if (list.contains(cls)) {
                return;
            }
            list.add(cls);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cls);
            this.mJobList.put(pointType, arrayList);
        }
    }
}
