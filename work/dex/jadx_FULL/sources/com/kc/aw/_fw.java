package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _fw implements _ce {
    public static final _b _a = new _b(TimeUnit.SECONDS, new LinkedBlockingQueue(30), new _a(), new ThreadPoolExecutor.DiscardOldestPolicy());

    @Keep
    public final class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb_a = _jf._a("WorkerThread-");
            sb_a.append(this._a.getAndIncrement());
            return new Thread(runnable, sb_a.toString());
        }
    }

    @Keep
    public final class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, LinkedBlockingQueue linkedBlockingQueue, _a _aVar, ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy) {
            super(4, 8, 60L, timeUnit, linkedBlockingQueue, _aVar, discardOldestPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public final class _c implements Callable<Void> {
        public final File _a;
        public final _fw _b;

        public _c(_fw _fwVar, File file) {
            this._b = _fwVar;
            this._a = file;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws IOException {
            _fw _fwVar = this._b;
            File file = this._a;
            _fwVar.getClass();
            long length = 0;
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!file.setLastModified(jCurrentTimeMillis)) {
                    long length2 = file.length();
                    if (length2 != 0) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                        long j = length2 - 1;
                        randomAccessFile.seek(j);
                        byte b = randomAccessFile.readByte();
                        randomAccessFile.seek(j);
                        randomAccessFile.write(b);
                        randomAccessFile.close();
                    } else if (!file.delete() || !file.createNewFile()) {
                        throw new IOException("Error recreate zero-size file " + file);
                    }
                    if (file.lastModified() < jCurrentTimeMillis) {
                        String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath());
                    }
                }
            }
            File parentFile = file.getParentFile();
            List<File> linkedList = new LinkedList();
            File[] fileArrListFiles = parentFile.listFiles();
            if (fileArrListFiles != null) {
                linkedList = Arrays.asList(fileArrListFiles);
                Collections.sort(linkedList, new _dt._a());
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                length += ((File) it.next()).length();
            }
            linkedList.size();
            for (File file2 : linkedList) {
                if (!(length <= ((_no) _fwVar)._b)) {
                    long length3 = file2.length();
                    if (file2.delete()) {
                        length -= length3;
                    }
                    file2.toString();
                }
            }
            return null;
        }
    }
}
