package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j {
    static int azO = 10;
    static int azP = 5;
    private final Executor azK;
    private final LinkedBlockingQueue<t> azL;
    private final Object azM;
    private final ArrayList<t> azN;
    private final Handler handler;

    public static final class a {
        private static final j azS = new j(0);
    }

    public static class b implements Handler.Callback {
        private b() {
        }

        private static void a(ArrayList<t> arrayList) {
            for (t tVar : arrayList) {
                if (tVar != null) {
                    tVar.Bt();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((t) message.obj).Bt();
            } else if (i == 2) {
                a((ArrayList) message.obj);
                j.Bp().push();
            }
            return true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    public static j Bp() {
        return a.azS;
    }

    private static boolean Bq() {
        return azO > 0;
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.azM) {
            this.azL.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.azM) {
            if (this.azN.isEmpty()) {
                if (this.azL.isEmpty()) {
                    return;
                }
                int i = 0;
                if (Bq()) {
                    int i2 = azO;
                    int iMin = Math.min(this.azL.size(), azP);
                    while (i < iMin) {
                        this.azN.add(this.azL.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.azL.drainTo(this.azN);
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.azN), i);
            }
        }
    }

    private j() {
        this.azK = com.kwad.framework.filedownloader.f.b.w(5, "BlockCompleted");
        this.azM = new Object();
        this.azN = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.azL = new LinkedBlockingQueue<>();
    }

    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z) {
        if (tVar.Bu()) {
            tVar.Bt();
            return;
        }
        if (tVar.Bv()) {
            this.azK.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.Bt();
                }
            });
            return;
        }
        if (!Bq() && !this.azL.isEmpty()) {
            synchronized (this.azM) {
                if (!this.azL.isEmpty()) {
                    Iterator<t> it = this.azL.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                }
                this.azL.clear();
            }
        }
        if (!Bq()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }
}
