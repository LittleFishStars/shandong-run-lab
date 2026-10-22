package com.kc.bw.okserver;

import android.os.Environment;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.db.DownloadManager;
import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.IOUtils;
import com.kc.bw.okserver.download.DownloadTask;
import com.kc.bw.okserver.download.DownloadThreadPool;
import com.kc.bw.okserver.task.XExecutor;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OkDownload {
    public String folder;
    public ConcurrentHashMap<String, DownloadTask> taskMap;
    public DownloadThreadPool threadPool;

    @Keep
    public static class OkDownloadHolder {
        public static final OkDownload instance = new OkDownload();
    }

    public OkDownload() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append(dexg.dexa("epxompbe"));
        sb.append(str);
        String string = sb.toString();
        this.folder = string;
        IOUtils.createFolder(string);
        this.threadPool = new DownloadThreadPool();
        this.taskMap = new ConcurrentHashMap<>();
        List<Progress> downloading = DownloadManager.getInstance().getDownloading();
        for (Progress progress : downloading) {
            int i = progress.status;
            if (i == 1 || i == 2 || i == 3) {
                progress.status = 0;
            }
        }
        DownloadManager.getInstance().replace((List) downloading);
    }

    public static OkDownload getInstance() {
        return OkDownloadHolder.instance;
    }

    public static DownloadTask request(String str, Request<File, ? extends Request> request) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        DownloadTask downloadTask = taskMap.get(str);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = new DownloadTask(str, request);
        taskMap.put(str, downloadTask2);
        return downloadTask2;
    }

    public static DownloadTask restore(Progress progress) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        DownloadTask downloadTask = taskMap.get(progress.tag);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = new DownloadTask(progress);
        taskMap.put(progress.tag, downloadTask2);
        return downloadTask2;
    }

    public static List<DownloadTask> restore(List<Progress> list) {
        Map<String, DownloadTask> taskMap = getInstance().getTaskMap();
        ArrayList arrayList = new ArrayList();
        for (Progress progress : list) {
            DownloadTask downloadTask = taskMap.get(progress.tag);
            if (downloadTask == null) {
                downloadTask = new DownloadTask(progress);
                taskMap.put(progress.tag, downloadTask);
            }
            arrayList.add(downloadTask);
        }
        return arrayList;
    }

    public void addOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().addOnAllTaskEndListener(onAllTaskEndListener);
    }

    public String getFolder() {
        return this.folder;
    }

    public DownloadTask getTask(String str) {
        return this.taskMap.get(str);
    }

    public Map<String, DownloadTask> getTaskMap() {
        return this.taskMap;
    }

    public DownloadThreadPool getThreadPool() {
        return this.threadPool;
    }

    public boolean hasTask(String str) {
        return this.taskMap.containsKey(str);
    }

    public void init() {
    }

    public void pauseAll() {
        Iterator<Map.Entry<String, DownloadTask>> it = this.taskMap.entrySet().iterator();
        while (it.hasNext()) {
            DownloadTask value = it.next().getValue();
            if (value != null && value.progress.status != 2) {
                value.pause();
            }
        }
        Iterator<Map.Entry<String, DownloadTask>> it2 = this.taskMap.entrySet().iterator();
        while (it2.hasNext()) {
            DownloadTask value2 = it2.next().getValue();
            if (value2 != null && value2.progress.status == 2) {
                value2.pause();
            }
        }
    }

    public void removeAll() {
        removeAll(false);
    }

    public void removeAll(boolean z) {
        HashMap map = new HashMap(this.taskMap);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            DownloadTask downloadTask = (DownloadTask) ((Map.Entry) it.next()).getValue();
            if (downloadTask != null && downloadTask.progress.status != 2) {
                downloadTask.remove(z);
            }
        }
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            DownloadTask downloadTask2 = (DownloadTask) ((Map.Entry) it2.next()).getValue();
            if (downloadTask2 != null && downloadTask2.progress.status == 2) {
                downloadTask2.remove(z);
            }
        }
    }

    public void removeOnAllTaskEndListener(XExecutor.OnAllTaskEndListener onAllTaskEndListener) {
        this.threadPool.getExecutor().removeOnAllTaskEndListener(onAllTaskEndListener);
    }

    public DownloadTask removeTask(String str) {
        return this.taskMap.remove(str);
    }

    public OkDownload setFolder(String str) {
        this.folder = str;
        return this;
    }

    public void startAll() {
        Iterator<Map.Entry<String, DownloadTask>> it = this.taskMap.entrySet().iterator();
        while (it.hasNext()) {
            DownloadTask value = it.next().getValue();
            if (value != null) {
                value.start();
            }
        }
    }
}
