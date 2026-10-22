package com.kc.cw.ad.internal.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f38967a = new AtomicInteger(0);
    private final String b;
    private volatile g c;
    private final List<b> d;
    private final b e;
    private final c f;

    @Keep
    public static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f38968a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f38968a = str;
            this.b = list;
        }

        @Override // com.kc.cw.ad.internal.d.b
        public void a(File file, String str, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f38968a, message.arg1);
            }
        }
    }

    public i(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) n.a(str);
        this.f = (c) n.a(cVar);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private void b() throws p {
        synchronized (this) {
            this.c = this.c == null ? d() : this.c;
        }
    }

    private void c() {
        synchronized (this) {
            if (this.f38967a.decrementAndGet() <= 0) {
                this.c.a();
                this.c = null;
            }
        }
    }

    private g d() throws p {
        String str = this.b;
        c cVar = this.f;
        g gVar = new g(new j(str, cVar.d, cVar.e), new com.kc.cw.ad.internal.d.a.b(this.f.a(this.b), this.f.c));
        gVar.a(this.e);
        return gVar;
    }

    public int a() {
        return this.f38967a.get();
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public void a(e eVar, Socket socket) throws IOException, p {
        b();
        try {
            this.f38967a.incrementAndGet();
            this.c.a(eVar, socket);
        } finally {
            c();
        }
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }
}
