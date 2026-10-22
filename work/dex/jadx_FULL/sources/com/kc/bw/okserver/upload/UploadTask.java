package com.kc.bw.okserver.upload;

import com.kc.bw.dexg;
import com.kc.bw.helper.LogHelper;
import com.kc.bw.okhttp.db.UploadManager;
import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.ProgressRequestBody;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.kc.bw.okserver.OkUpload;
import com.kc.bw.okserver.task.PriorityRunnable;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class UploadTask<T> implements Runnable {
    public ThreadPoolExecutor executor;
    public Map<Object, UploadListener<T>> listeners;
    public PriorityRunnable priorityRunnable;
    public Progress progress;

    public UploadTask(Progress progress) {
        HttpUtils.checkNotNull(progress, dexg.dexa("qsphsftt!>>!ovmm"));
        this.progress = progress;
        this.executor = OkUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UploadTask(String str, Request<T, ? extends Request> request) {
        HttpUtils.checkNotNull(str, dexg.dexa("ubh!>>!ovmm"));
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
            LogHelper.w(dexg.dexa("pomz!uif!ubtl!xjui!tubuvt!XBJUJOH)2*!ps!MPBEJOH)3*!dbo!qbvtf-!dvssfou!tubuvt!jt!") + this.progress.status);
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
            request.uploadInterceptor(new ProgressRequestBody.UploadInterceptor(this, request.getRawCall()) { // from class: com.kc.bw.okserver.upload.UploadTask.1
                public final UploadTask this$0;
                public final Call val$rawCall;

                {
                    this.this$0 = this;
                    this.val$rawCall = call;
                }

                @Override // com.kc.bw.okhttp.request.base.ProgressRequestBody.UploadInterceptor
                public void uploadProgress(Progress progress2) {
                    if (this.val$rawCall.isCanceled()) {
                        return;
                    }
                    Progress progress3 = this.this$0.progress;
                    if (progress3.status != 2) {
                        this.val$rawCall.cancel();
                        return;
                    }
                    progress3.from(progress2);
                    UploadTask uploadTask = this.this$0;
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
            throw new IllegalStateException(dexg.dexa("zpv!nvtu!dbmm!VqmpbeUbtl$tbwf)*!cfgpsf!VqmpbeUbtl$tubsu)*�"));
        }
        Progress progress = this.progress;
        int i = progress.status;
        if (i == 1 || i == 2) {
            LogHelper.w(dexg.dexa("uif!ubtl!xjui!ubh!") + this.progress.tag + dexg.dexa("!jt!bmsfbez!jo!uif!vqmpbe!rvfvf-!dvssfou!ubtl!tubuvt!jt!") + this.progress.status);
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
        HttpUtils.checkNotNull(uploadListener, dexg.dexa("mjtufofs!>>!ovmm"));
        this.listeners.remove(uploadListener.tag);
    }

    public void unRegister(String str) {
        HttpUtils.checkNotNull(str, dexg.dexa("ubh!>>!ovmm"));
        this.listeners.remove(str);
    }
}
