package com.ipd.dsp.internal.w0;

import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d implements com.ipd.dsp.internal.w0.a {
    public static final String b = "LruDiskUsage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f38594a = Executors.newSingleThreadExecutor();

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f38595a;

        public a(File file) {
            this.f38595a = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            d.this.b(this.f38595a);
            return null;
        }
    }

    public abstract boolean a(File file, long j, int i);

    public final void b(File file) throws IOException {
        if (file == null) {
            throw new IOException("file is null");
        }
        c.e(file);
        b(c.a(file.getParentFile()));
    }

    @Override // com.ipd.dsp.internal.w0.a
    public void a(File file) {
        this.f38594a.submit(new a(file));
    }

    public final long a(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    public final void b(List<File> list) {
        long jA = this instanceof g ? a(list) : 0L;
        int size = this instanceof f ? list.size() : 0;
        for (File file : list) {
            if (!a(file, jA, size)) {
                long length = file.length();
                if (file.delete()) {
                    if (size > 0) {
                        size--;
                    }
                    if (jA > 0) {
                        jA -= length;
                    }
                    if (Dsp.isDebugLogEnable()) {
                        k.d(b, "Cache file " + file + " us deleted because it exceeds cache limit");
                    }
                } else if (Dsp.isDebugLogEnable()) {
                    k.b(b, "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }
}
