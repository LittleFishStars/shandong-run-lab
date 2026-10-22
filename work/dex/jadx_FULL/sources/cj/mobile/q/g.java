package cj.mobile.q;

import android.os.Handler;
import android.os.Message;
import cj.mobile.utils.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f22654a;
    public final String b;
    public volatile e c;
    public final List<b> d;
    public final b e;
    public final c f;

    public static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22655a;
        public final List<b> b;

        public a(String str, List<b> list) {
        }

        @Override // cj.mobile.q.b
        public void a(File file, String str, int i) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public g(String str, c cVar) {
    }

    public void a(d dVar, Socket socket) throws ProxyCacheException, IOException {
    }

    public final e b() throws ProxyCacheException {
    }

    public final synchronized void c() throws ProxyCacheException {
    }

    public final synchronized void a() {
    }
}
