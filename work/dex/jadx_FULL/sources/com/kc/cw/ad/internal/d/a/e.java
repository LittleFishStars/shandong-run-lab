package com.kc.cw.ad.internal.d.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
abstract class e implements com.kc.cw.ad.internal.d.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f38956a = Executors.newSingleThreadExecutor();

    @Keep
    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f38957a;
        private final File b;

        public a(e eVar, File file) {
            this.f38957a = eVar;
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            this.f38957a.b(this.b);
            return null;
        }
    }

    private void a(List<File> list) {
        long jB = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, jB, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jB -= length;
                    com.kc.cw.ad.internal.c.f.c(com.kc.cw.ad.internal.c.f.p, "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.p, "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.kc.cw.ad.internal.d.a.a
    public void a(File file) throws IOException {
        this.f38956a.submit(new a(this, file));
    }

    public abstract boolean a(File file, long j, int i);
}
