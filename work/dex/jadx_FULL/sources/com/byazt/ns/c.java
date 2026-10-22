package com.byazt.ns;

import android.text.TextUtils;
import com.byazt.byh.ve;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.utw.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.internal.l0.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 20})
public final class c {
    public static final boolean c = com.byazt.lt.tt.tt();
    public HashMap<String, Boolean> tt;
    public C0483c ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public static final c c = new c();
    }

    public static c c() {
        return tt.c;
    }

    private static ve ve() {
        ve veVar = null;
        File file = new File(sp.tt(com.byazt.oy.tt.getContext(), false, null), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ve veVar2 = new ve(file);
            try {
                veVar2.c(g.g);
                return veVar2;
            } catch (IOException e) {
                e = e;
                veVar = veVar2;
                m.c(e);
                return veVar;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public boolean tt() {
        if (this.ve != null) {
            return true;
        }
        ve veVarVe = ve();
        if (veVarVe == null) {
            return false;
        }
        uj.c(true);
        uj.c(1);
        try {
            C0483c c0483c = new C0483c();
            this.ve = c0483c;
            c0483c.setName("csj_v_c_preloader");
            this.ve.start();
            uj.c(veVarVe, com.byazt.oy.tt.getContext());
            com.byazt.utw.ve.c();
            com.byazt.utw.ve.c().c(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private c() {
        this.tt = new HashMap<>();
        tt();
    }

    public boolean c(a aVar) {
        if (!tt()) {
            return false;
        }
        this.ve.c(aVar);
        return true;
    }

    /* JADX INFO: renamed from: com.byazt.ns.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 44})
    public class C0483c extends com.byazt.jtc.ve {
        public Queue<C0484c> n;
        public Queue<C0484c> tt;
        public final Queue<C0484c> uj;
        public boolean ve;

        /* JADX INFO: renamed from: com.byazt.ns.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO})
        public class C0484c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f28850a;
            public int c;
            public String n;
            public String tt;
            public int uj;
            public String[] ve;

            public C0484c() {
            }
        }

        public C0483c() {
            super("VideoCachePreloader$PreLoadThread");
            this.uj = new ArrayBlockingQueue(10);
            this.tt = new LinkedBlockingQueue();
            this.ve = true;
            this.n = new LinkedBlockingQueue();
        }

        private C0484c c(int i, a aVar) {
            this.uj.size();
            C0484c c0484cPoll = this.uj.poll();
            if (c0484cPoll == null) {
                c0484cPoll = new C0484c();
            }
            c0484cPoll.c = i;
            c0484cPoll.f28850a = aVar;
            return c0484cPoll;
        }

        private synchronized void tt(C0484c c0484c) {
            this.n.add(c0484c);
            notify();
        }

        private void ve(C0484c c0484c) {
            if (c0484c == null) {
                return;
            }
            this.tt.offer(c0484c);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.ve) {
                synchronized (this) {
                    if (!this.n.isEmpty()) {
                        c();
                    }
                    while (!this.tt.isEmpty()) {
                        C0484c c0484cPoll = this.tt.poll();
                        if (c0484cPoll != null) {
                            int i = c0484cPoll.c;
                            if (i == 0) {
                                String[] strArr = c0484cPoll.ve;
                                if (strArr != null && strArr.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : c0484cPoll.ve) {
                                        if (com.byazt.nxx.c.c(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    com.byazt.utw.ve.c().c(false, !TextUtils.isEmpty(c0484cPoll.n), c0484cPoll.uj, c0484cPoll.tt, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                            } else if (i == 1) {
                                com.byazt.utw.ve.c().c(c0484cPoll.tt);
                            } else if (i == 2) {
                                com.byazt.utw.ve.c().tt();
                            } else if (i == 3) {
                                com.byazt.utw.ve.c().tt();
                                if (uj.tt() != null) {
                                    uj.tt().c();
                                }
                                if (uj.c() != null) {
                                    uj.c().c();
                                }
                            } else if (i == 4) {
                                com.byazt.utw.ve.c().tt();
                                this.ve = false;
                            }
                            c(c0484cPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        m.c(e);
                    }
                }
            }
        }

        private void c(C0484c c0484c) {
            c0484c.ve = null;
            c0484c.tt = null;
            c0484c.c = -1;
            c0484c.f28850a = null;
            this.uj.offer(c0484c);
        }

        private void c() {
            while (true) {
                C0484c c0484cPoll = this.n.poll();
                if (c0484cPoll == null) {
                    return;
                }
                c0484cPoll.tt = c0484cPoll.f28850a.getUrl();
                c0484cPoll.ve = new String[]{c0484cPoll.f28850a.getUrl()};
                int pitayaCacheSize = c0484cPoll.f28850a.getPitayaCacheSize();
                if (pitayaCacheSize <= 0) {
                    pitayaCacheSize = c0484cPoll.f28850a.getPreloadSize();
                }
                c0484cPoll.uj = pitayaCacheSize;
                c0484cPoll.n = c0484cPoll.f28850a.getFileNameKey();
                if (!TextUtils.isEmpty(c0484cPoll.f28850a.getFileNameKey())) {
                    c0484cPoll.tt = c0484cPoll.f28850a.getFileNameKey();
                }
                c0484cPoll.f28850a = null;
                ve(c0484cPoll);
            }
        }

        public void c(a aVar) {
            tt(c(0, aVar));
        }
    }
}
