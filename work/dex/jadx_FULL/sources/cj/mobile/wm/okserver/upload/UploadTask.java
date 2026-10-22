package cj.mobile.wm.okserver.upload;

import cj.mobile.wm.dexc;
import cj.mobile.wm.helper.LogHelper;
import cj.mobile.wm.okhttp.db.UploadManager;
import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.ProgressRequestBody;
import cj.mobile.wm.okhttp.request.base.Request;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import cj.mobile.wm.okserver.OkUpload;
import cj.mobile.wm.okserver.task.PriorityRunnable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadTask<T> implements Runnable {
    public ThreadPoolExecutor executor;
    public Map<Object, UploadListener<T>> listeners;
    public PriorityRunnable priorityRunnable;
    public Progress progress;

    public UploadTask(Progress progress) {
        HttpUtils.checkNotNull(progress, dexc.dexa("qsphsftt!>>!ovmm"));
        this.progress = progress;
        this.executor = OkUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UploadTask(String str, Request<T, ? extends Request> request) {
        HttpUtils.checkNotNull(str, dexc.dexa("ubh!>>!ovmm"));
        Progress progress = new Progress();
        this.progress = progress;
        progress.tag = str;
        progress.url = request.getBaseUrl();
        Progress progress2 = this.progress;
        progress2.status = 0;
        progress2.totalSize = -1L;
        progress2.request = request;
        this.executor = OkUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(Progress progress) {
        updateDatabase(progress);
        Iterator<UploadListener<T>> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void postOnError(Progress progress, Throwable th) {
        progress.speed = 0L;
        progress.status = 4;
        progress.exception = th;
        updateDatabase(progress);
        for (UploadListener<T> uploadListener : this.listeners.values()) {
            uploadListener.onProgress(progress);
            uploadListener.onError(progress);
        }
    }

    private void postOnFinish(Progress progress, T t) {
        progress.speed = 0L;
        progress.fraction = 1.0f;
        progress.status = 5;
        updateDatabase(progress);
        for (UploadListener<T> uploadListener : this.listeners.values()) {
            uploadListener.onProgress(progress);
            uploadListener.onFinish(t, progress);
        }
    }

    private void postOnRemove(Progress progress) {
        updateDatabase(progress);
        Iterator<UploadListener<T>> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onRemove(progress);
        }
        this.listeners.clear();
    }

    private void postOnStart(Progress progress) {
        progress.speed = 0L;
        progress.status = 0;
        updateDatabase(progress);
        Iterator<UploadListener<T>> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onStart(progress);
        }
    }

    private void postPause(Progress progress) {
        progress.speed = 0L;
        progress.status = 3;
        updateDatabase(progress);
        Iterator<UploadListener<T>> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void postWaiting(Progress progress) {
        progress.speed = 0L;
        progress.status = 1;
        updateDatabase(progress);
        Iterator<UploadListener<T>> it = this.listeners.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(progress);
        }
    }

    private void updateDatabase(Progress progress) {
        UploadManager.getInstance().update(Progress.buildUpdateContentValues(progress), progress.tag);
    }

    public UploadTask<T> extra1(Serializable serializable) {
        this.progress.extra1 = serializable;
        return this;
    }

    public UploadTask<T> extra2(Serializable serializable) {
        this.progress.extra2 = serializable;
        return this;
    }

    public UploadTask<T> extra3(Serializable serializable) {
        this.progress.extra3 = serializable;
        return this;
    }

    public void pause() {
        this.executor.remove(this.priorityRunnable);
        Progress progress = this.progress;
        int i = progress.status;
        if (i == 1) {
            postPause(progress);
            return;
        }
        if (i == 2) {
            progress.speed = 0L;
            progress.status = 3;
        } else {
            LogHelper.w(dexc.dexa("pomz!uif!ubtl!xjui!tubuvt!XBJUJOH)2*!ps!MPBEJOH)3*!dbo!qbvtf-!dvssfou!tubuvt!jt!") + this.progress.status);
        }
    }

    public UploadTask<T> priority(int i) {
        this.progress.priority = i;
        return this;
    }

    public UploadTask<T> register(UploadListener<T> uploadListener) {
        if (uploadListener != null) {
            this.listeners.put(uploadListener.tag, uploadListener);
        }
        return this;
    }

    public UploadTask<T> remove() {
        pause();
        UploadManager.getInstance().delete(this.progress.tag);
        UploadTask<T> uploadTask = (UploadTask<T>) OkUpload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return uploadTask;
    }

    public void restart() {
        pause();
        Progress progress = this.progress;
        progress.status = 0;
        progress.currentSize = 0L;
        progress.fraction = 0.0f;
        progress.speed = 0L;
        UploadManager.getInstance().replace(this.progress);
        start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        Progress progress = this.progress;
        progress.status = 2;
        postLoading(progress);
        try {
            Request<?, ? extends Request> request = this.progress.request;
            final Call rawCall = request.getRawCall();
            request.uploadInterceptor(new ProgressRequestBody.UploadInterceptor() { // from class: cj.mobile.wm.okserver.upload.UploadTask.1
                @Override // cj.mobile.wm.okhttp.request.base.ProgressRequestBody.UploadInterceptor
                public void uploadProgress(Progress progress2) {
                    if (rawCall.isCanceled()) {
                        return;
                    }
                    Progress progress3 = UploadTask.this.progress;
                    if (progress3.status != 2) {
                        rawCall.cancel();
                        return;
                    }
                    progress3.from(progress2);
                    UploadTask uploadTask = UploadTask.this;
                    uploadTask.postLoading(uploadTask.progress);
                }
            });
            Response<?> responseExecute = request.adapt().execute();
            if (responseExecute.isSuccessful()) {
                postOnFinish(this.progress, responseExecute.body());
            } else {
                postOnError(this.progress, responseExecute.getException());
            }
        } catch (Exception e) {
            e.printStackTrace();
            postOnError(this.progress, e);
        }
    }

    public UploadTask<T> save() {
        UploadManager.getInstance().replace(this.progress);
        return this;
    }

    public UploadTask<T> start() {
        if (OkUpload.getInstance().getTask(this.progress.tag) == null || UploadManager.getInstance().get(this.progress.tag) == null) {
            throw new IllegalStateException(dexc.dexa("zpv!nvtu!dbmm!VqmpbeUbtl$tbwf)*!cfgpsf!VqmpbeUbtl$tubsu)*�"));
        }
        Progress progress = this.progress;
        int i = progress.status;
        if (i == 1 || i == 2) {
            LogHelper.w(dexc.dexa("uif!ubtl!xjui!ubh!") + this.progress.tag + dexc.dexa("!jt!bmsfbez!jo!uif!vqmpbe!rvfvf-!dvssfou!ubtl!tubuvt!jt!") + this.progress.status);
        } else {
            postOnStart(progress);
            postWaiting(this.progress);
            PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
            this.priorityRunnable = priorityRunnable;
            this.executor.execute(priorityRunnable);
        }
        return this;
    }

    public void unRegister(UploadListener<T> uploadListener) {
        HttpUtils.checkNotNull(uploadListener, dexc.dexa("mjtufofs!>>!ovmm"));
        this.listeners.remove(uploadListener.tag);
    }

    public void unRegister(String str) {
        HttpUtils.checkNotNull(str, dexc.dexa("ubh!>>!ovmm"));
        this.listeners.remove(str);
    }
}
