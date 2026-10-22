package cj.mobile.r;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class e implements cj.mobile.r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f22664a;

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f22665a;
        public final /* synthetic */ e b;

        public a(e eVar, File file) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
        }
    }

    public abstract boolean a(File file, long j, int i);

    public final void b(File file) throws IOException {
    }

    @Override // cj.mobile.r.a
    public void a(File file) throws IOException {
    }

    public final long a(List<File> list) {
    }

    public final void b(List<File> list) {
    }
}
