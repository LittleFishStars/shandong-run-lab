package com.byazt.zz;

import android.content.Context;
import com.byazt.c.eo;
import com.byazt.c.p;
import com.byazt.hs.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 1597})
public class DownloaderBuilder {
    public sp chunkAdjustCalculator;
    public x chunkCntCalculator;
    public ExecutorService chunkDownloadExecutor;
    public final Context context;
    public ExecutorService cpuThreadExecutor;
    public ExecutorService dbThreadExecutor;
    public da downloadCache;
    public com.byazt.hs.a downloadDns;
    public boolean downloadInMultiProcess;
    public t downloadLaunchHandler;
    public com.byazt.zl.tt downloadMonitorListener;
    public p downloadSetting;
    public com.byazt.hs.x headHttpService;
    public IDownloadHttpService httpService;
    public sl idGenerator;
    public ExecutorService ioThreadExecutor;
    public int maxDownloadPoolSize;
    public ExecutorService mixApkDownloadExecutor;
    public ExecutorService mixDefaultDownloadExecutor;
    public ExecutorService mixFrequentDownloadExecutor;
    public nu monitorConfig;
    public eo notificationClickCallback;
    public ExecutorService okHttpDispatcherExecutor;
    public rl ttNetHandler;
    public int writeBufferSize;
    public List<com.byazt.c.u> downloadCompleteHandlers = new ArrayList();
    public boolean needAutoRefreshUnSuccessTask = true;
    public int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.byazt.c.u uVar) {
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

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(sp spVar) {
        this.chunkAdjustCalculator = spVar;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(x xVar) {
        this.chunkCntCalculator = xVar;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadCache(da daVar) {
        this.downloadCache = daVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.byazt.hs.a aVar) {
        this.downloadDns = aVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(t tVar) {
        this.downloadLaunchHandler = tVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.byazt.zl.tt ttVar) {
        this.downloadMonitorListener = ttVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(p pVar) {
        this.downloadSetting = pVar;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public sp getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public x getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public da getDownloadCache() {
        return this.downloadCache;
    }

    public List<com.byazt.c.u> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public com.byazt.hs.a getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public t getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public com.byazt.zl.tt getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public p getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.byazt.hs.x getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public sl getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public nu getMonitorConfig() {
        return this.monitorConfig;
    }

    public eo getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public rl getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(com.byazt.hs.x xVar) {
        this.headHttpService = xVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(sl slVar) {
        this.idGenerator = slVar;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder monitorConfig(nu nuVar) {
        this.monitorConfig = nuVar;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(eo eoVar) {
        this.notificationClickCallback = eoVar;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(rl rlVar) {
        this.ttNetHandler = rlVar;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
