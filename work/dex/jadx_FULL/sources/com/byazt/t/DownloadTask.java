package com.byazt.t;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadInterceptor;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.gr;
import com.byazt.c.gu;
import com.byazt.c.rh;
import com.byazt.c.u;
import com.byazt.c.yp;
import com.byazt.c.yv;
import com.byazt.ev.EnqueueType;
import com.byazt.ev.a;
import com.byazt.m.BaseException;
import com.byazt.zz.m;
import com.byazt.zz.my;
import com.byazt.zz.sp;
import com.byazt.zz.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 66, 1577})
public class DownloadTask {
    public boolean autoSetHashCodeForSameTask;
    public sp chunkAdjustCalculator;
    public x chunkStrategy;
    public yp depend;
    public rh diskSpaceHandler;
    public final List<u> downloadCompleteHandlers;
    public DownloadInfo downloadInfo;
    public DownloadInfo.c downloadInfoBuilder;
    public IDownloadFileUriProvider fileUriProvider;
    public gu forbiddenHandler;
    public int hashCodeForSameTask;
    public IDownloadInterceptor interceptor;
    public final SparseArray<IDownloadListener> mainThreadListeners;
    public gr monitorDepend;
    public boolean needDelayForCacheSync;
    public eo notificationClickCallback;
    public yv notificationEventListener;
    public final SparseArray<IDownloadListener> notificationListeners;
    public my retryDelayTimeCalculator;
    public final SparseArray<a> singleListenerHashCodeMap;
    public final Map<a, IDownloadListener> singleListenerMap;
    public final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.c();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            sparseArray2.put(iKeyAt, sparseArray.get(iKeyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int iKeyAt = sparseArray2.keyAt(i);
            IDownloadListener iDownloadListener = sparseArray2.get(iKeyAt);
            if (iDownloadListener != null) {
                sparseArray.put(iKeyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new x() { // from class: com.byazt.t.DownloadTask.2
                @Override // com.byazt.zz.x
                public int c(long j) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(u uVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (uVar != null) {
                if (!this.downloadCompleteHandlers.contains(uVar)) {
                    this.downloadCompleteHandlers.add(uVar);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, a aVar, boolean z) {
        Map<a, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(aVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, aVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(aVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        com.byazt.x.c.tt("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(a.MAIN);
        addListenerToDownloadingSameTask(a.SUB);
        com.byazt.zl.c.c(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.m(z);
        return this;
    }

    public void asyncDownload(final m mVar) {
        com.byazt.u.uj.c(new Runnable() { // from class: com.byazt.t.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask.this.download();
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(a.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(a.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.ve(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.tt(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(sp spVar) {
        this.chunkAdjustCalculator = spVar;
        return this;
    }

    public DownloadTask chunkStategy(x xVar) {
        this.chunkStrategy = xVar;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<a, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.gt(z);
        return this;
    }

    public DownloadTask depend(yp ypVar) {
        this.depend = ypVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(rh rhVar) {
        this.diskSpaceHandler = rhVar;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.rl(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.c();
        DownloadInfo downloadInfoTt = com.byazt.zz.ve.zm().tt(this.downloadInfo.getId());
        if (downloadInfoTt == null) {
            this.downloadInfo.generateTaskId();
            com.byazt.zl.c.c(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfoTt);
        }
        setChunkCalculator();
        com.byazt.zz.uj.c().c(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.c(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.c(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.a(i);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.c(j);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.my(z);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.sp(str);
        return this;
    }

    public DownloadTask extraHeaders(List<ve> list) {
        this.downloadInfoBuilder.c(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.tt(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(gu guVar) {
        this.forbiddenHandler = guVar;
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.tt(z);
        return this;
    }

    public sp getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public x getChunkStrategy() {
        return this.chunkStrategy;
    }

    public yp getDepend() {
        return this.depend;
    }

    public rh getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public u getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    @NonNull
    public List<u> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(a aVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(aVar);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i));
        }
    }

    public int getDownloadListenerSize(a aVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(aVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(a aVar) {
        if (aVar == a.MAIN) {
            return this.mainThreadListeners;
        }
        if (aVar == a.SUB) {
            return this.subThreadListeners;
        }
        if (aVar == a.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public gu getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public gr getMonitorDepend() {
        return this.monitorDepend;
    }

    public eo getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public yv getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public my getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(a aVar) {
        return this.singleListenerMap.get(aVar);
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.u(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.yp(z);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.rh(z);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            Map<a, IDownloadListener> map = this.singleListenerMap;
            a aVar = a.MAIN;
            map.put(aVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, aVar);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.c(i);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.uj(i);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.da(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.x(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.n(i);
        return this;
    }

    public DownloadTask monitorDepend(gr grVar) {
        this.monitorDepend = grVar;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.t(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.z(z);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.x(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.uj(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.t(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.ve(z);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.da(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.i(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.sl(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.nu(z);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask notificationClickCallback(eo eoVar) {
        this.notificationClickCallback = eoVar;
        return this;
    }

    public DownloadTask notificationEventListener(yv yvVar) {
        this.notificationEventListener = yvVar;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            Map<a, IDownloadListener> map = this.singleListenerMap;
            a aVar = a.NOTIFICATION;
            map.put(aVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, aVar);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.c(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.c(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.i(str);
        return this;
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, a aVar, boolean z) {
        int iIndexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(aVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(aVar)) {
                this.singleListenerMap.remove(aVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            try {
                if (z) {
                    if (this.singleListenerMap.containsKey(aVar)) {
                        iDownloadListener = this.singleListenerMap.get(aVar);
                        this.singleListenerMap.remove(aVar);
                    }
                    if (iDownloadListener != null && (iIndexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && iIndexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(iIndexOfValue);
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        a aVar2 = this.singleListenerHashCodeMap.get(i);
                        if (aVar2 != null && this.singleListenerMap.containsKey(aVar2)) {
                            this.singleListenerMap.remove(aVar2);
                            this.singleListenerHashCodeMap.remove(i);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.tt(i);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.sl(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(my myVar) {
        this.retryDelayTimeCalculator = myVar;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.n(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.qy(z);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<u> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<u> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, a aVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (aVar == a.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (aVar == a.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (aVar == a.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        com.byazt.nr.m.c(th);
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public void setNotificationEventListener(yv yvVar) {
        this.notificationEventListener = yvVar;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.n(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.sp(z);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            Map<a, IDownloadListener> map = this.singleListenerMap;
            a aVar = a.SUB;
            map.put(aVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, aVar);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.uj(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.a(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.tt(j);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.tt(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.ve(j);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.ve(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(a aVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(aVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.byazt.zz.uj.c().tt(getDownloadId(), iDownloadListener, aVar, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
