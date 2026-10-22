package com.ipd.dsp.internal.v0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f38571a = new AtomicInteger(0);
    public final String b;
    public volatile o c;
    public final List<b> d;
    public final b e;

    public static final class a extends Handler implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38572a;
        public final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f38572a = str;
            this.b = list;
        }

        @Override // com.ipd.dsp.internal.v0.b
        public void a(File file, String str, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f38572a, message.arg1);
            }
        }
    }

    public p(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) i.a(str);
        this.e = new a(str, copyOnWriteArrayList);
    }

    public void a(d dVar, Socket socket) throws k, IOException {
        e();
        try {
            this.f38571a.incrementAndGet();
            this.c.a(dVar, socket);
        } finally {
            a();
        }
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }

    public final o c() throws k {
        o oVar = new o(new e(this.b), new com.ipd.dsp.internal.w0.b(new File(c.a(), com.ipd.dsp.internal.w0.e.a(this.b))));
        oVar.a(this.e);
        return oVar;
    }

    public void d() {
        this.d.clear();
        if (this.c != null) {
            this.c.a((b) null);
            this.c.g();
            this.c = null;
        }
        this.f38571a.set(0);
    }

    public final synchronized void e() throws k {
        this.c = this.c == null ? c() : this.c;
    }

    public int b() {
        return this.f38571a.get();
    }

    public final synchronized void a() {
        if (this.f38571a.decrementAndGet() <= 0) {
            this.c.g();
            this.c = null;
        }
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }
}
