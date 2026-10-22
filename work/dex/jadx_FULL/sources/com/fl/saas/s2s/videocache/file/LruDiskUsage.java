package com.fl.saas.s2s.videocache.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class LruDiskUsage implements DiskUsage {
    private final ExecutorService workerThread = Executors.newSingleThreadExecutor();

    public class TouchCallable implements Callable<Void> {
        private final File file;

        public TouchCallable(File file) {
            this.file = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws IOException {
            LruDiskUsage.this.touchInBackground(this.file);
            return null;
        }
    }

    private long countTotalSize(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void touchInBackground(File file) throws IOException {
        Files.setLastModifiedNow(file);
        trim(Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(List<File> list) {
        long jCountTotalSize = countTotalSize(list);
        int size = list.size();
        for (File file : list) {
            if (!accept(file, jCountTotalSize, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jCountTotalSize -= length;
                }
            }
        }
    }

    public abstract boolean accept(File file, long j, int i);

    @Override // com.fl.saas.s2s.videocache.file.DiskUsage
    public void touch(File file) {
        this.workerThread.submit(new TouchCallable(file));
    }
}
