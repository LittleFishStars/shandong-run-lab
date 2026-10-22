package com.byazt.wh;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.byazt.h.i;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.SqlDownloadCacheService;
import com.byazt.zz.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1172, 34})
public class a implements ServiceConnection, gt {
    public static boolean tt;
    public static long uj;
    public static int ve;

    @Nullable
    public ve c;
    public Future<?> i;
    public com.byazt.zz.ve.c.InterfaceC0604c sp;
    public Handler n = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tt f29159a = null;
    public Runnable x = new Runnable() { // from class: com.byazt.wh.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.tt || a.this.sp == null) {
                return;
            }
            a.this.sp.c();
        }
    };
    public CountDownLatch da = new CountDownLatch(1);

    /* JADX INFO: renamed from: com.byazt.wh.a$3, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1172, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS})
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.c(com.byazt.zz.ve.ic(), a.this);
        }
    }

    public a() {
        SqlDownloadCacheService.c(com.byazt.zz.ve.ic(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sp() {
        return false;
    }

    @Override // com.byazt.zz.da
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ArrayList<i> yp(int i) {
        return null;
    }

    @Override // com.byazt.zz.da
    public boolean c(int i, Map<Long, i> map) {
        return false;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo da(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.da(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo i(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.i(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        tt = true;
        this.n.removeCallbacks(this.x);
        try {
            this.c = ve.c.c(iBinder);
        } catch (Throwable th) {
            m.c(th);
        }
        this.i = com.byazt.zz.ve.t().submit(new Runnable() { // from class: com.byazt.wh.a.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (a.this.f29159a != null && a.this.c != null) {
                                a.this.c.c(a.this.f29159a);
                            }
                            a.this.da.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.byazt.wh.a.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = a.tt = false;
                                    if (a.this.sp() || a.this.sp == null) {
                                        return;
                                    }
                                    a.this.n.postDelayed(a.this.x, 2000L);
                                }
                            };
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        try {
                            com.byazt.x.c.tt("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                            if (a.this.sp != null) {
                                a.this.sp.c();
                            }
                            a.this.da.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.byazt.wh.a.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = a.tt = false;
                                    if (a.this.sp() || a.this.sp == null) {
                                        return;
                                    }
                                    a.this.n.postDelayed(a.this.x, 2000L);
                                }
                            };
                        } catch (Throwable th3) {
                            a.this.da.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.wh.a.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused2 = a.tt = false;
                                        if (a.this.sp() || a.this.sp == null) {
                                            return;
                                        }
                                        a.this.n.postDelayed(a.this.x, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused2) {
                            }
                            throw th3;
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.c = null;
        tt = false;
    }

    @Override // com.byazt.zz.da
    public Map<Long, i> t(int i) {
        return null;
    }

    @Override // com.byazt.zz.da
    public void u(int i) {
    }

    @Override // com.byazt.zz.da
    public boolean n(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.n(i);
            }
            return false;
        } catch (RemoteException e) {
            m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo sp(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.sp(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo tt(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.tt(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> uj(String str) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.uj(str);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> ve(String str) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.ve(str);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo x(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.x(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public boolean a(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.a(i);
            }
            return false;
        } catch (RemoteException e) {
            m.c(e);
            return false;
        }
    }

    public void c(com.byazt.zz.ve.c.InterfaceC0604c interfaceC0604c) {
        this.sp = interfaceC0604c;
    }

    @Override // com.byazt.zz.gt
    public void c(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.byazt.t.tt>> sparseArray2, final uj ujVar) {
        com.byazt.zz.ve.t().submit(new Runnable() { // from class: com.byazt.wh.a.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                uj ujVar2;
                Future future;
                a.this.c(new tt.c() { // from class: com.byazt.wh.a.4.1
                    @Override // com.byazt.wh.tt
                    public void c(Map map, Map map2) {
                        com.byazt.w.a.c(sparseArray, map);
                        com.byazt.w.a.c(sparseArray2, map2);
                        ujVar.c();
                        a.this.c((tt) null);
                    }
                });
                try {
                    z = !a.this.da.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    m.c(th);
                    z = false;
                }
                if (z && (future = a.this.i) != null) {
                    future.cancel(true);
                }
                a.this.c();
                if (!z || (ujVar2 = ujVar) == null) {
                    return;
                }
                ujVar2.c();
            }
        });
    }

    public void c(tt ttVar) {
        synchronized (this) {
            ve veVar = this.c;
            if (veVar != null) {
                try {
                    veVar.c(ttVar);
                } catch (RemoteException e) {
                    m.c(e);
                }
            } else {
                this.f29159a = ttVar;
            }
        }
    }

    @Override // com.byazt.zz.da
    public boolean n() {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.n();
            }
            return false;
        } catch (RemoteException e) {
            m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> tt(String str) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.tt(str);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public void uj(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.uj(i);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public List<com.byazt.t.tt> ve(int i) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.ve(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> tt() {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.tt();
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo uj(int i, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.uj(i, j);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public void ve() {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.ve();
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    public void c() {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c();
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void tt(com.byazt.t.tt ttVar) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.tt(ttVar);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public boolean uj() {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.uj();
            }
            return false;
        } catch (RemoteException e) {
            m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo ve(int i, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.ve(i, j);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public List<DownloadInfo> c(String str) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.c(str);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo tt(int i, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.tt(i, j);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public void c(com.byazt.t.tt ttVar) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c(ttVar);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void tt(DownloadInfo downloadInfo) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.tt(downloadInfo);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c(i, i2, j);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void tt(int i, List<com.byazt.t.tt> list) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.tt(i, list);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, int i3, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, int i3, int i4) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, int i2) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.c(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public boolean c(DownloadInfo downloadInfo) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.c(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            m.c(e);
            return false;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j, String str, String str2) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.c(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                return veVar.c(i, j);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.zz.da
    public void c(int i, List<com.byazt.t.tt> list) {
        try {
            ve veVar = this.c;
            if (veVar != null) {
                veVar.c(i, list);
            }
        } catch (RemoteException e) {
            m.c(e);
        }
    }
}
