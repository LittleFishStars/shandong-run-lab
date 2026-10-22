package com.byazt.lu;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.byazt.ds.i;
import com.byazt.ds.x;
import com.byazt.yv.da;
import com.byazt.yv.sl;
import com.byazt.yv.t;
import com.byazt.yv.u;
import com.byazt.za.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 15})
public class uj implements Handler.Callback, Comparator<com.byazt.tv.c> {
    public static uj tt;
    public static long u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.tv.tt f28782a;
    public Application c;
    public sl da;
    public sp i;
    public Handler sl;
    public i sp;
    public a t;
    public x uj;
    public c ve;
    public Handler x;
    public final ArrayList<com.byazt.tv.c> n = new ArrayList<>(32);
    public CopyOnWriteArrayList<Message> yp = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<com.byazt.tv.sp> z = new CopyOnWriteArrayList<>();

    private uj() {
    }

    public static void c() {
        if (tt != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - u) > 10000) {
                u = jCurrentTimeMillis;
                tt.c((String[]) null, true);
            }
        }
    }

    public static uj n() {
        if (tt == null) {
            synchronized (uj.class) {
                if (tt == null) {
                    tt = new uj();
                }
            }
        }
        return tt;
    }

    private void sl() {
        if (!this.uj.rl()) {
            c cVar = this.ve;
            if (cVar != null) {
                cVar.n();
                this.ve = null;
                return;
            }
            return;
        }
        if (this.ve == null) {
            c cVar2 = new c(this);
            this.ve = cVar2;
            Message messageObtainMessage = this.x.obtainMessage(6, cVar2);
            this.yp.add(messageObtainMessage);
            messageObtainMessage.sendToTarget();
        }
    }

    private void t() {
        if (da.tt) {
            da.c("packAndSend once, " + this.i.c() + ", hadUI:" + this.i.tt(), null);
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.x();
        }
        if (this.x != null) {
            this.t.c(u.c());
            Message messageObtainMessage = this.sl.obtainMessage(6, this.t);
            this.yp.add(messageObtainMessage);
            this.x.sendMessage(messageObtainMessage);
        }
    }

    public sp a() {
        return this.i;
    }

    public void da() {
        if (this.x == null || this.z.isEmpty()) {
            return;
        }
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            try {
                com.byazt.tv.sp spVar = this.z.get(i);
                Message messageC = com.byazt.tv.sp.c(this.x, spVar);
                long jC = com.byazt.tv.sp.c(spVar);
                if (messageC.what == 6) {
                    this.yp.add(messageC);
                    this.x.sendMessageDelayed(messageC, jC);
                }
            } catch (Exception unused) {
            }
        }
        this.z.clear();
    }

    public Context getContext() {
        return this.c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 1) {
                da.c = this.uj.qy();
                if (!this.sp.a()) {
                    this.sl.removeMessages(1);
                    this.sl.sendEmptyMessageDelayed(1, 1000L);
                } else if (this.uj.nu()) {
                    Looper looperTt = u.tt(this.uj);
                    if (looperTt == null) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        looperTt = handlerThread.getLooper();
                    }
                    Handler handler = new Handler(looperTt, this);
                    this.x = handler;
                    handler.sendEmptyMessage(2);
                    if (this.n.size() > 0) {
                        this.sl.removeMessages(4);
                        this.sl.sendEmptyMessageDelayed(4, 1000L);
                    }
                    da.uj("net|worker start", null);
                }
                com.byazt.ds.tt.c();
            } else if (i == 2) {
                ArrayList<tt> arrayList = new ArrayList(4);
                arrayList.add(new n(this));
                arrayList.add(new ve(this));
                a aVar = new a(this);
                this.t = aVar;
                arrayList.add(aVar);
                for (tt ttVar : arrayList) {
                    if (ttVar instanceof a) {
                        this.t.c(u.c());
                    }
                    long jSp = ttVar.sp();
                    if (jSp < 864000000) {
                        int i2 = (int) jSp;
                        Message messageObtainMessage = this.sl.obtainMessage(6, i2, i2, ttVar);
                        this.yp.add(messageObtainMessage);
                        this.x.sendMessageDelayed(messageObtainMessage, jSp);
                    }
                }
                this.t.c(true);
                sl();
            } else if (i == 4) {
                c((String[]) null, false);
            } else if (i == 5) {
                c((String[]) message.obj, false);
            } else if (i == 6) {
                tt ttVar2 = (tt) message.obj;
                try {
                    this.yp.remove(message);
                } catch (Exception unused) {
                }
                if (!ttVar2.a()) {
                    long jSp2 = ttVar2.sp();
                    if (jSp2 < 864000000 && !c(this.yp, ttVar2)) {
                        int i3 = (int) jSp2;
                        Message messageObtainMessage2 = this.sl.obtainMessage(6, i3, i3, ttVar2);
                        this.yp.add(messageObtainMessage2);
                        this.x.sendMessageDelayed(messageObtainMessage2, jSp2);
                    }
                    sl();
                }
                this.t.c(true);
            } else if (i == 7) {
                synchronized (this.n) {
                    this.n.add(sp.n());
                }
                c((String[]) null, false);
            } else if (i != 89) {
                da.tt((Throwable) null);
            } else {
                i iVar = this.sp;
                if (iVar != null) {
                    iVar.n();
                }
            }
        } catch (Throwable th) {
            da.c("engine:" + th.getMessage());
        }
        return true;
    }

    public void i() {
        if (this.x.hasMessages(6)) {
            int size = this.yp.size();
            for (int i = 0; i < size; i++) {
                this.z.add(com.byazt.tv.sp.c(this.yp.get(i)));
            }
            this.yp.clear();
            this.x.removeMessages(6);
        }
    }

    public sl sp() {
        if (this.da == null) {
            sl slVarDa = this.uj.bm().da();
            this.da = slVarDa;
            if (slVarDa == null) {
                this.da = t.c(0);
            }
        }
        return this.da;
    }

    public com.byazt.tv.tt tt() {
        return this.f28782a;
    }

    public i uj() {
        return this.sp;
    }

    public x ve() {
        return this.uj;
    }

    public void x() {
        Handler handler = this.sl;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.sl.sendEmptyMessage(89);
    }

    public void c(Application application, x xVar, i iVar, com.byazt.za.c cVar) {
        this.c = application;
        this.f28782a = new com.byazt.tv.tt(this);
        this.uj = xVar;
        this.sp = iVar;
        this.i = new sp(this.sp, this.uj);
        this.c.registerActivityLifecycleCallbacks(cVar);
        Looper looperC = u.c(xVar);
        if (looperC == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperC = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperC, this);
        this.sl = handler;
        handler.sendEmptyMessage(1);
        com.byazt.yv.sp.c(xVar.i() != 0);
    }

    private boolean c(List<Message> list, tt ttVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).obj == ttVar) {
                return true;
            }
        }
        return false;
    }

    private void c(String[] strArr, boolean z) {
        ArrayList<com.byazt.tv.c> arrayList;
        synchronized (this.n) {
            arrayList = (ArrayList) this.n.clone();
            this.n.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(com.byazt.tv.c.c(str));
            }
        }
        boolean zC = this.uj.c(arrayList);
        if (arrayList.size() > 0) {
            if (this.uj.nu()) {
                if (!zC && arrayList.size() <= 100) {
                    synchronized (this.n) {
                        this.n.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<com.byazt.tv.c> arrayList2 = new ArrayList<>(arrayList.size());
                boolean zC2 = false;
                boolean zC3 = false;
                for (com.byazt.tv.c cVar : arrayList) {
                    zC2 |= this.i.c(cVar, arrayList2);
                    if (cVar instanceof com.byazt.tv.i) {
                        zC3 = sp.c(cVar);
                        i = 1;
                    }
                }
                this.f28782a.c(arrayList2);
                if (i != 0) {
                    if (zC3) {
                        this.sl.removeMessages(7);
                    } else if (!u.tt() && u.c()) {
                        this.sl.sendEmptyMessageDelayed(7, this.uj.gu());
                    }
                }
                if (zC2 || z) {
                    t();
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.c, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).n().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                da.tt((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.c.sendBroadcast(intent);
            } catch (Exception e) {
                da.tt(e);
            }
        }
    }

    public static void c(com.byazt.tv.c cVar) {
        int size;
        Handler handler;
        uj ujVar = tt;
        if (ujVar == null) {
            da.tt("Init comes First!", null);
            com.byazt.ds.tt.c(cVar);
            return;
        }
        if (cVar.tt == 0) {
            da.tt((Throwable) null);
        }
        synchronized (ujVar.n) {
            size = ujVar.n.size();
            ujVar.n.add(cVar);
        }
        if (size % 10 != 0 || (handler = ujVar.sl) == null) {
            return;
        }
        handler.removeMessages(4);
        ujVar.sl.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void c(String[] strArr) {
        uj ujVar = tt;
        if (ujVar == null) {
            da.tt(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = ujVar.sl;
        if (handler != null) {
            handler.removeMessages(4);
            ujVar.sl.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compare(com.byazt.tv.c cVar, com.byazt.tv.c cVar2) {
        long j = cVar.tt - cVar2.tt;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }
}
