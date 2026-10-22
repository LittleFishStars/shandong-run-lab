package com.aliyun.svideosdk.editor.pplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {
    private static final Handler.Callback q = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<com.aliyun.svideosdk.editor.pplayer.a> f25766a;
    private long c;
    private long e;
    private HandlerThread f;
    private Handler g;
    private long j;
    private long k;
    private InterfaceC0231b l;
    private boolean m;
    private c n;
    private c o;
    private e p;
    private int b = 3;
    private long d = 1200;
    private long h = 0;
    private boolean i = false;

    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            b bVar = (b) message.obj;
            int i = message.what;
            if (i == 1) {
                bVar.b();
                return false;
            }
            if (i != 2) {
                return false;
            }
            bVar.a();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.editor.pplayer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0231b {
        long a();
    }

    public b(Surface surface, String str) {
        e eVar = new e();
        this.p = eVar;
        eVar.a(str);
        this.p.a(surface);
        this.m = true;
        this.n = new d();
        this.f25766a = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread("Play");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper(), q);
    }

    private long a(long j) {
        long j2 = this.c / 1000;
        if (j2 <= 0) {
            return -1L;
        }
        this.h = j % j2;
        if (this.f25766a.size() == 1) {
            return this.f25766a.get(0).a(this.h);
        }
        if (this.f25766a.size() == 2) {
            return this.h < this.f25766a.get(0).c() ? this.f25766a.get(0).a(this.h) : this.f25766a.get(1).a(this.h - this.f25766a.get(0).c());
        }
        if (this.f25766a.size() != 3) {
            return -1L;
        }
        if (this.h < this.f25766a.get(0).c()) {
            return this.f25766a.get(0).a(this.h);
        }
        return (this.h < this.f25766a.get(0).c() || this.h >= this.f25766a.get(0).c() + this.f25766a.get(1).c()) ? this.f25766a.get(2).a((this.h - this.f25766a.get(0).c()) - this.f25766a.get(1).c()) : this.f25766a.get(1).a(this.h - this.f25766a.get(0).c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        long jA;
        Log.i("AnimationPlayer", "condition: " + this.b);
        if (!this.f25766a.isEmpty() && this.c != 0) {
            if (this.i) {
                this.j = this.l.a() - this.k;
                Log.e("AnimationPlayer", "current time: " + this.l.a());
                Log.e("AnimationPlayer", "mAnimationPlayTime: " + this.k);
                if (this.j < 0) {
                    Log.e("AnimationPlayer", "time < 0");
                }
            } else {
                c cVar = this.o;
                if (cVar != null) {
                    this.e = cVar.b();
                    jA = this.o.a();
                } else {
                    this.e = this.n.b();
                    jA = this.n.a();
                }
                this.j = jA;
                Log.d("AnimationPlayer", "doPlay time : " + this.j);
            }
            long jA2 = a(this.j);
            if (jA2 != -1) {
                Log.d("AnimationPlayer", "draw time " + jA2);
                this.p.a(jA2);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = this;
            Handler handler = this.g;
            if (handler != null && this.b == 1) {
                handler.sendMessageAtTime(messageObtain, this.e + 33);
            }
            return;
        }
        Log.e("AnimationPlayer", "mAnimation is empty or mPersonDuration=0");
    }

    private long c() {
        long jB = 0;
        for (int i = 0; i < this.f25766a.size(); i++) {
            jB += this.f25766a.get(i).b();
        }
        return jB;
    }

    public void a(long j, int i) {
        this.p.a(j, i);
    }

    public void a(long j, long j2) {
        int i;
        this.c = j2 - j;
        this.k = j;
        Log.e("AnimationPlayer", "mPersonDuration: " + this.c);
        Log.e("AnimationPlayer", "mDefaultDuration: " + this.d);
        if (this.c < c()) {
            this.c = c();
        }
        long jA = this.c;
        int i2 = 0;
        if (jA < this.d) {
            for (int i3 = 0; i3 < this.f25766a.size(); i3++) {
                this.f25766a.get(i3).b(this.f25766a.get(i3).b());
            }
            jA = this.c;
            if (jA <= c()) {
                return;
            }
            i = 0;
            while (i2 < this.f25766a.size()) {
                if (this.f25766a.get(i2).a() != 0) {
                    jA -= this.f25766a.get(i2).c();
                } else {
                    i = i2;
                }
                i2++;
            }
        } else {
            i = 0;
            while (i2 < this.f25766a.size()) {
                if (this.f25766a.get(i2).a() != 0) {
                    this.f25766a.get(i2).b(this.f25766a.get(i2).a());
                    jA -= this.f25766a.get(i2).a();
                } else {
                    i = i2;
                }
                i2++;
            }
        }
        this.f25766a.get(i).b(jA);
    }

    public void a(com.aliyun.svideosdk.editor.pplayer.a aVar) {
        this.f25766a.add(aVar);
    }

    public void a(c cVar) {
        this.o = cVar;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(long j) {
        this.d = j;
    }

    public long d() {
        return this.h;
    }

    public void e() {
        if (this.b == 1 && this.m) {
            this.b = 2;
            a();
        }
    }

    public void f() {
        if (this.b == 1 || !this.m) {
            return;
        }
        this.b = 1;
        this.n.reset();
        c cVar = this.o;
        if (cVar != null) {
            cVar.reset();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = this;
        Handler handler = this.g;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public void g() {
        if (this.b == 3 || !this.m) {
            return;
        }
        this.b = 3;
        this.g = null;
        Log.w("AnimationPlayer", "mPlayHandler = null;");
        this.f.quit();
        try {
            this.f.join();
        } catch (InterruptedException unused) {
        }
        this.p.a();
    }
}
