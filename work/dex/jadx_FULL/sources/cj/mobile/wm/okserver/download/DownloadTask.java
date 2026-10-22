package cj.mobile.wm.okserver.download;

import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.db.DownloadManager;
import cj.mobile.wm.okhttp.exception.HttpException;
import cj.mobile.wm.okhttp.exception.StorageException;
import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.request.base.Request;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import cj.mobile.wm.okhttp.utils.IOUtils;
import cj.mobile.wm.okserver.OkDownload;
import cj.mobile.wm.okserver.task.PriorityRunnable;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DownloadTask implements Runnable {
    public static final int BUFFER_SIZE = 8192;
    public static final String TAG = "DownloadTask";
    public ThreadPoolExecutor executor;
    public ConcurrentHashMap<Object, DownloadListener> listeners;
    public PriorityRunnable priorityRunnable;
    public Progress progress;

    public DownloadTask(Progress progress) {
        HttpUtils.checkNotNull(progress, dexc.dexa("qsphsftt!>>!ovmm"));
        this.progress = progress;
        this.executor = OkDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new ConcurrentHashMap<>();
    }

    public DownloadTask(String str, Request<File, ? extends Request> request) {
        HttpUtils.checkNotNull(str, dexc.dexa("ubh!>>!ovmm"));
        Progress progress = new Progress();
        this.progress = progress;
        progress.tag = str;
        progress.folder = OkDownload.getInstance().getFolder();
        this.progress.url = request.getBaseUrl();
        Progress progress2 = this.progress;
        progress2.status = 0;
        progress2.totalSize = -1L;
        progress2.request = request;
        this.executor = OkDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new ConcurrentHashMap<>();
    }

    private void download(InputStream inputStream, RandomAccessFile randomAccessFile, Progress progress) throws Throwable {
        if (inputStream == null || randomAccessFile == null) {
            return;
        }
        progress.status = 2;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        while (true) {
            try {
                int i = bufferedInputStream.read(bArr, 0, 8192);
                if (i == -1 || progress.status != 2) {
                    break;
                }
                randomAccessFile.write(bArr, 0, i);
                try {
                    Progress.changeProgress(progress, i, progress.totalSize, new Progress.Action() { // from class: cj.mobile.wm.okserver.download.DownloadTask.1
                        @Override // cj.mobile.wm.okhttp.model.Progress.Action
                        public void call(Progress progress2) {
                            DownloadTask.this.postLoading(progress2);
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            IOUtils.closeQuietly(randomAccessFile);
            IOUtils.closeQuietly(bufferedInputStream);
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        IOUtils.closeQuietly(randomAccessFile);
        IOUtils.closeQuietly(bufferedInputStream);
        IOUtils.closeQuietly(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(Progress progress) {
        updateDatabase(progress);
        Iterator<DownloadListener> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void postOnError(Progress progress, Throwable th) {
        progress.speed = 0L;
        progress.status = 4;
        progress.exception = th;
        updateDatabase(progress);
        for (DownloadListener downloadListener : this.listeners.values()) {
            downloadListener.onProgress(progress);
            downloadListener.onError(progress);
        }
    }

    private void postOnFinish(Progress progress, File file) {
        progress.speed = 0L;
        progress.fraction = 1.0f;
        progress.status = 5;
        updateDatabase(progress);
        for (DownloadListener downloadListener : this.listeners.values()) {
            downloadListener.onProgress(progress);
            downloadListener.onFinish(file, progress);
        }
    }

    private void postOnRemove(Progress progress) {
        updateDatabase(progress);
        Iterator<DownloadListener> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onRemove(progress);
        }
        this.listeners.clear();
    }

    private void postOnStart(Progress progress) {
        progress.speed = 0L;
        progress.status = 0;
        updateDatabase(progress);
        Iterator<DownloadListener> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onStart(progress);
        }
    }

    private void postPause(Progress progress) {
        progress.speed = 0L;
        progress.status = 3;
        updateDatabase(progress);
        Iterator<DownloadListener> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void postWaiting(Progress progress) {
        progress.speed = 0L;
        progress.status = 1;
        updateDatabase(progress);
        Iterator<DownloadListener> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void updateDatabase(Progress progress) {
        DownloadManager.getInstance().update(Progress.buildUpdateContentValues(progress), progress.tag);
    }

    public DownloadTask extra1(Serializable serializable) {
        this.progress.extra1 = serializable;
        return this;
    }

    public DownloadTask extra2(Serializable serializable) {
        this.progress.extra2 = serializable;
        return this;
    }

    public DownloadTask extra3(Serializable serializable) {
        this.progress.extra3 = serializable;
        return this;
    }

    public DownloadTask fileName(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.fileName = str;
        }
        return this;
    }

    public DownloadTask folder(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.folder = str;
        }
        return this;
    }

    public void pause() {
        this.executor.remove(this.priorityRunnable);
        Progress progress = this.progress;
        int i = progress.status;
        if (i == 1) {
            postPause(progress);
        } else if (i == 2) {
            progress.speed = 0L;
            progress.status = 3;
        }
    }

    public DownloadTask priority(int i) {
        this.progress.priority = i;
        return this;
    }

    public DownloadTask register(DownloadListener downloadListener) {
        if (downloadListener != null) {
            this.listeners.put(downloadListener.tag, downloadListener);
        }
        return this;
    }

    public DownloadTask remove(boolean z) {
        pause();
        if (z) {
            IOUtils.delFileOrFolder(this.progress.filePath);
        }
        DownloadManager.getInstance().delete(this.progress.tag);
        DownloadTask downloadTaskRemoveTask = OkDownload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return downloadTaskRemoveTask;
    }

    public void remove() {
        remove(false);
    }

    public void restart() {
        pause();
        IOUtils.delFileOrFolder(this.progress.filePath);
        Progress progress = this.progress;
        progress.status = 0;
        progress.currentSize = 0L;
        progress.fraction = 0.0f;
        progress.speed = 0L;
        DownloadManager.getInstance().replace(this.progress);
        start();
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        File file;
        Progress progress = this.progress;
        long j = progress.currentSize;
        if (j < 0) {
            postOnError(progress, new Exception(dexc.dexa("gjmf!ibt!fyqjsfe\"")));
            return;
        }
        if (j > 0 && !TextUtils.isEmpty(progress.filePath) && !new File(this.progress.filePath).exists()) {
            postOnError(this.progress, new Exception(dexc.dexa("gjmf!epft!opu!fyjtu\"")));
            return;
        }
        try {
            Request<?, ? extends Request> request = this.progress.request;
            request.headers(dexc.dexa("Sbohf"), dexc.dexa("czuft>") + j + dexc.dexa(Consts.DOT));
            Response responseExecute = request.execute();
            int iCode = responseExecute.code();
            if (iCode == 404 || iCode >= 500) {
                Log.d(dexc.dexa("PlEpxompbe"), iCode + "");
                postOnError(this.progress, HttpException.NET_ERROR());
                return;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody == null) {
                postOnError(this.progress, new HttpException(dexc.dexa("sftqpotf!cpez!jt!ovmm")));
                return;
            }
            Progress progress2 = this.progress;
            if (progress2.totalSize == -1) {
                progress2.totalSize = responseBodyBody.contentLength();
            }
            String netFileName = this.progress.fileName;
            if (TextUtils.isEmpty(netFileName)) {
                netFileName = HttpUtils.getNetFileName(responseExecute, this.progress.url);
                this.progress.fileName = netFileName;
            }
            if (!IOUtils.createFolder(this.progress.folder)) {
                postOnError(this.progress, StorageException.NOT_AVAILABLE());
                return;
            }
            if (TextUtils.isEmpty(this.progress.filePath)) {
                file = new File(this.progress.folder, netFileName);
                this.progress.filePath = file.getAbsolutePath();
            } else {
                file = new File(this.progress.filePath);
            }
            if (j > 0 && !file.exists()) {
                postOnError(this.progress, new Exception(dexc.dexa("gjmf!epft!opu!fyjtu\"")));
                return;
            }
            Progress progress3 = this.progress;
            if (j > progress3.totalSize) {
                postOnError(progress3, new Exception(dexc.dexa("gjmf!ibt!fyqjsfe\"")));
                return;
            }
            if (j == 0 && file.exists()) {
                IOUtils.delFileOrFolder(file);
            }
            if (j == this.progress.totalSize && j > 0) {
                if (file.exists() && j == file.length()) {
                    postOnFinish(this.progress, file);
                    return;
                } else {
                    postOnError(this.progress, new Exception(dexc.dexa("gjmf!ibt!fyqjsfe\"")));
                    return;
                }
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, dexc.dexa("sx"));
                randomAccessFile.seek(j);
                this.progress.currentSize = j;
                try {
                    DownloadManager.getInstance().replace(this.progress);
                    download(responseBodyBody.byteStream(), randomAccessFile, this.progress);
                    Progress progress4 = this.progress;
                    int i = progress4.status;
                    if (i == 3) {
                        postPause(progress4);
                        return;
                    }
                    if (i != 2) {
                        postOnError(progress4, new Exception(dexc.dexa("volopxo!fydfqujpo\"")));
                        return;
                    }
                    long length = file.length();
                    Progress progress5 = this.progress;
                    if (length == progress5.totalSize) {
                        postOnFinish(progress5, file);
                    } else {
                        postOnError(progress5, new Exception(dexc.dexa("gjmf!ibt!fyqjsfe\"")));
                    }
                } catch (IOException e) {
                    postOnError(this.progress, e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                postOnError(this.progress, e2);
            }
        } catch (IOException e3) {
            postOnError(this.progress, e3);
        }
    }

    public DownloadTask save() {
        if (!TextUtils.isEmpty(this.progress.folder) && !TextUtils.isEmpty(this.progress.fileName)) {
            Progress progress = this.progress;
            progress.filePath = new File(progress.folder, progress.fileName).getAbsolutePath();
        }
        DownloadManager.getInstance().replace(this.progress);
        return this;
    }

    public void start() {
        StorageException storageException;
        if (OkDownload.getInstance().getTask(this.progress.tag) == null || DownloadManager.getInstance().get(this.progress.tag) == null) {
            throw new IllegalStateException(dexc.dexa("zpv!nvtu!dbmm!EpxompbeUbtl$tbwf)*!cfgpsf!EpxompbeUbtl$tubsu)*�"));
        }
        Progress progress = this.progress;
        int i = progress.status;
        if (i == 0 || i == 3 || i == 4) {
            postOnStart(progress);
            postWaiting(this.progress);
            PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
            this.priorityRunnable = priorityRunnable;
            this.executor.execute(priorityRunnable);
            return;
        }
        if (i == 5) {
            String str = progress.filePath;
            if (str == null) {
                storageException = new StorageException(dexc.dexa("uif!gjmf!pg!uif!ubtl!xjui!ubh;") + this.progress.tag + dexc.dexa("!nbz!cf!jowbmje!ps!ebnbhfe-!qmfbtf!dbmm!uif!nfuipe!sftubsu)*!up!epxompbe!bhbjo�"));
            } else {
                File file = new File(str);
                if (file.exists()) {
                    long length = file.length();
                    Progress progress2 = this.progress;
                    if (length == progress2.totalSize) {
                        postOnFinish(progress2, new File(progress2.filePath));
                        return;
                    }
                }
                progress = this.progress;
                storageException = new StorageException(dexc.dexa("uif!gjmf!") + this.progress.filePath + dexc.dexa("!nbz!cf!jowbmje!ps!ebnbhfe-!qmfbtf!dbmm!uif!nfuipe!sftubsu)*!up!epxompbe!bhbjo�"));
            }
            postOnError(progress, storageException);
        }
    }

    public void unRegister(DownloadListener downloadListener) {
        HttpUtils.checkNotNull(downloadListener, dexc.dexa("mjtufofs!>>!ovmm"));
        this.listeners.remove(downloadListener.tag);
    }

    public void unRegister(String str) {
        HttpUtils.checkNotNull(str, dexc.dexa("ubh!>>!ovmm"));
        this.listeners.remove(str);
    }
}
