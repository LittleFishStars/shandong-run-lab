package com.byazt.byh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.ut.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.internal.l0.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 791, 54})
public class ve extends com.byazt.byh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<c> f28338a;
    public final File c;
    public final Runnable da;
    public final tt i;
    public final ReentrantReadWriteLock.WriteLock n;
    public final Handler sl;
    public volatile long sp;
    public final LinkedHashMap<String, File> tt = new LinkedHashMap<>(0, 0.75f, true);
    public final ReentrantReadWriteLock.ReadLock uj;
    public final ReentrantReadWriteLock ve;
    public volatile float x;

    public interface c {
        void c(String str);

        void c(Set<String> set);
    }

    @com.byazt.zqa.c(c = {0, 1, 791, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static final class tt {
        public final Map<String, Integer> c;

        private tt() {
            this.c = new HashMap();
        }

        public synchronized void c(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.c.get(str);
                if (num == null) {
                    this.c.put(str, 1);
                    return;
                }
                this.c.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        public synchronized void tt(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.c.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.c.remove(str);
                    return;
                }
                this.c.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        public synchronized boolean ve(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.c.containsKey(str);
        }
    }

    public ve(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.ve = reentrantReadWriteLock;
        this.uj = reentrantReadWriteLock.readLock();
        this.n = reentrantReadWriteLock.writeLock();
        this.f28338a = Collections.newSetFromMap(new ConcurrentHashMap());
        this.sp = g.g;
        this.x = 0.5f;
        this.i = new tt();
        this.da = new Runnable() { // from class: com.byazt.byh.ve.1
            @Override // java.lang.Runnable
            public void run() {
                ((qp) uj.getService("thread_service")).executeNormalTask(new Runnable() { // from class: com.byazt.byh.ve.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ve veVar = ve.this;
                        veVar.tt(veVar.sp);
                    }
                });
            }
        };
        this.sl = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.c = file;
            ((qp) uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.byh.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.tt();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  ".concat(String.valueOf(str)));
    }

    private void ve() {
        this.sl.removeCallbacks(this.da);
        this.sl.postDelayed(this.da, 10000L);
    }

    @Override // com.byazt.byh.c
    public File uj(String str) {
        if (!this.uj.tryLock()) {
            return null;
        }
        File file = this.tt.get(str);
        this.uj.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        this.n.lock();
        try {
            File[] fileArrListFiles = this.c.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.byazt.byh.ve.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.tt.put(c(file2), file2);
                }
            }
            this.n.unlock();
            ve();
        } catch (Throwable th) {
            this.n.unlock();
            throw th;
        }
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.f28338a.add(cVar);
        }
    }

    @Override // com.byazt.byh.c
    public File ve(String str) {
        this.uj.lock();
        File file = this.tt.get(str);
        this.uj.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.c, str);
        this.n.lock();
        this.tt.put(str, file2);
        this.n.unlock();
        Iterator<c> it = this.f28338a.iterator();
        while (it.hasNext()) {
            it.next().c(str);
        }
        ve();
        return file2;
    }

    public void c(long j) {
        this.sp = j;
        ve();
    }

    public void c() {
        com.byazt.utw.ve.c().tt();
        Context context = com.byazt.utw.uj.getContext();
        if (context != null) {
            com.byazt.emg.ve.c(context).c(0);
        }
        this.sl.removeCallbacks(this.da);
        ((qp) uj.getService("thread_service")).executeNormalTask(new Runnable() { // from class: com.byazt.byh.ve.4
            @Override // java.lang.Runnable
            public void run() {
                ve.this.tt(0L);
            }
        });
    }

    @Override // com.byazt.byh.c
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.c(str);
    }

    private String c(File file) {
        return file.getName();
    }

    @Override // com.byazt.byh.c
    public void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.tt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3 A[LOOP:3: B:41:0x00dd->B:43:0x00e3, LOOP_END] */
    public void tt(long j) {
        HashSet hashSet;
        Iterator<c> it;
        final HashSet hashSet2 = new HashSet();
        this.n.lock();
        HashSet hashSet3 = null;
        try {
            Iterator<Map.Entry<String, File>> it2 = this.tt.entrySet().iterator();
            long length = 0;
            while (it2.hasNext()) {
                length += it2.next().getValue().length();
            }
            try {
                if (length <= j) {
                    this.n.unlock();
                    return;
                }
                long j2 = (long) (j * this.x);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.tt.entrySet()) {
                        File value = entry.getValue();
                        if (value != null && value.exists()) {
                            if (!this.i.ve(c(value))) {
                                long length2 = value.length();
                                File file = new File(value.getAbsolutePath() + "-tmp");
                                if (value.renameTo(file)) {
                                    hashSet2.add(file);
                                    length -= length2;
                                    hashSet.add(entry.getKey());
                                }
                            }
                        } else {
                            hashSet.add(entry.getKey());
                        }
                        if (length <= j2) {
                            break;
                        }
                    }
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        this.tt.remove((String) it3.next());
                    }
                    this.n.unlock();
                } catch (Throwable th) {
                    th = th;
                    hashSet3 = hashSet;
                    m.c(th);
                    this.n.unlock();
                    hashSet = hashSet3;
                }
                it = this.f28338a.iterator();
                while (it.hasNext()) {
                    it.next().c(hashSet);
                }
                ((qp) uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.byh.ve.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it4 = hashSet2.iterator();
                        while (it4.hasNext()) {
                            try {
                                ((File) it4.next()).delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
                m.c(th);
                this.n.unlock();
                hashSet = hashSet3;
                it = this.f28338a.iterator();
                while (it.hasNext()) {
                    it.next().c(hashSet);
                }
                ((qp) uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.byh.ve.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it4 = hashSet2.iterator();
                        while (it4.hasNext()) {
                            try {
                                ((File) it4.next()).delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable th2) {
                this.n.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
