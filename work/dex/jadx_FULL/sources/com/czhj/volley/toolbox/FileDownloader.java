package com.czhj.volley.toolbox;

import android.os.Looper;
import com.czhj.volley.RequestQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RequestQueue f29481a;
    private final int b;
    private final LinkedList<DownloadController> c;

    public class DownloadController {
        public static final int STATUS_DISCARD = 4;
        public static final int STATUS_DOWNLOADING = 1;
        public static final int STATUS_PAUSE = 2;
        public static final int STATUS_SUCCESS = 3;
        public static final int STATUS_WAITING = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FileDownloadRequest.FileDownloadListener f29482a;
        int b;
        private FileDownloadRequest d;
        private DownloadItem e;

        public DownloadController(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
            this.f29482a = fileDownloadListener;
            this.e = downloadItem;
        }

        public boolean a() {
            if (this.b != 0) {
                return false;
            }
            FileDownloadRequest fileDownloadRequestBuildRequest = FileDownloader.this.buildRequest(this.e, new FileDownloadRequest.FileDownloadListener() { // from class: com.czhj.volley.toolbox.FileDownloader.DownloadController.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f29483a;

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void downloadProgress(DownloadItem downloadItem, long j, long j2) {
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f29482a;
                    if (fileDownloadListener != null) {
                        fileDownloadListener.downloadProgress(downloadItem, j, j2);
                    }
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onCancel(DownloadItem downloadItem) {
                    this.f29483a = true;
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f29482a;
                    if (fileDownloadListener != null) {
                        fileDownloadListener.onCancel(downloadItem);
                    }
                    DownloadController downloadController = DownloadController.this;
                    FileDownloader.this.a(downloadController);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onErrorResponse(DownloadItem downloadItem) {
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = DownloadController.this.f29482a;
                    if (fileDownloadListener != null && !this.f29483a) {
                        fileDownloadListener.onErrorResponse(downloadItem);
                    }
                    DownloadController downloadController = DownloadController.this;
                    FileDownloader.this.a(downloadController);
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onSuccess(DownloadItem downloadItem) {
                    DownloadController downloadController = DownloadController.this;
                    downloadController.b = 3;
                    FileDownloadRequest.FileDownloadListener fileDownloadListener = downloadController.f29482a;
                    if (fileDownloadListener != null && !this.f29483a) {
                        fileDownloadListener.onSuccess(downloadItem);
                    }
                    DownloadController downloadController2 = DownloadController.this;
                    FileDownloader.this.a(downloadController2);
                }
            });
            this.d = fileDownloadRequestBuildRequest;
            this.b = 1;
            RequestQueue requestQueue = FileDownloader.this.f29481a;
            if (requestQueue == null) {
                return false;
            }
            requestQueue.add(fileDownloadRequestBuildRequest);
            return true;
        }

        public boolean discard() {
            int i = this.b;
            if (i == 0) {
                this.b = 4;
                FileDownloader.this.a(this);
                FileDownloadRequest.FileDownloadListener fileDownloadListener = this.f29482a;
                if (fileDownloadListener != null) {
                    fileDownloadListener.onCancel(this.e);
                }
                return true;
            }
            if (i == 4 || i == 3) {
                return false;
            }
            if (i == 1) {
                this.d.cancel();
            }
            this.b = 4;
            FileDownloader.this.a(this);
            return true;
        }

        public DownloadItem getDownloadItem() {
            return this.e;
        }

        public FileDownloadRequest.FileDownloadListener getDownloadListener() {
            return this.f29482a;
        }

        public int getStatus() {
            return this.b;
        }

        public String getStorePath() {
            return this.e.filePath;
        }

        public String getUrl() {
            return this.e.url;
        }

        public boolean isDownloading() {
            return this.b == 1;
        }

        public boolean pause() {
            if (this.b != 1) {
                return false;
            }
            this.b = 2;
            this.d.cancel();
            FileDownloader.this.a();
            return true;
        }

        public boolean resume() {
            if (this.b != 2) {
                return false;
            }
            this.b = 0;
            FileDownloader.this.a();
            return true;
        }

        public void setDownloadListener(FileDownloadRequest.FileDownloadListener fileDownloadListener) {
            this.f29482a = fileDownloadListener;
        }
    }

    public FileDownloader(RequestQueue requestQueue) {
        this(requestQueue, 0);
    }

    public FileDownloader(RequestQueue requestQueue, int i) {
        this.c = new LinkedList<>();
        this.b = i;
        this.f29481a = requestQueue;
    }

    private void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("FileDownloader must be invoked from the main thread.");
        }
    }

    public void a() {
        synchronized (this.c) {
            Iterator<DownloadController> it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().isDownloading()) {
                    i++;
                }
            }
            if (i >= this.b) {
                return;
            }
            Iterator<DownloadController> it2 = this.c.iterator();
            while (it2.hasNext()) {
                if (it2.next().a() && (i = i + 1) == this.b) {
                    return;
                }
            }
        }
    }

    public void a(DownloadController downloadController) {
        synchronized (this.c) {
            this.c.remove(downloadController);
        }
        a();
    }

    public DownloadController add(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
        DownloadController downloadController = get(downloadItem.filePath, downloadItem.url);
        if (downloadController == null) {
            downloadController = new DownloadController(downloadItem, fileDownloadListener);
            synchronized (this.c) {
                this.c.add(downloadController);
            }
            a();
        }
        return downloadController;
    }

    public FileDownloadRequest buildRequest(DownloadItem downloadItem, FileDownloadRequest.FileDownloadListener fileDownloadListener) {
        return new FileDownloadRequest(downloadItem, fileDownloadListener);
    }

    public void clearAll() {
        synchronized (this.c) {
            while (this.c.size() > 0) {
                this.c.get(0).discard();
            }
        }
    }

    public DownloadController get(String str, String str2) {
        synchronized (this.c) {
            for (DownloadController downloadController : this.c) {
                if (downloadController.getStorePath().equals(str) && downloadController.getUrl().equals(str2)) {
                    return downloadController;
                }
            }
            return null;
        }
    }

    public List<DownloadController> getAll() {
        LinkedList<DownloadController> linkedList;
        synchronized (this.c) {
            linkedList = this.c;
        }
        return linkedList;
    }
}
