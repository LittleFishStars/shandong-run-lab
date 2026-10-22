package com.byazt.dl;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 465, 13})
public abstract class tt {
    public static volatile boolean c;
    public static volatile long tt;
    public Handler uj;
    public final Queue<c> ve = new LinkedList();

    @com.byazt.zqa.c(c = {0, 1, 465, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public final long c;
        public final String tt;

        private c(long j, String str) {
            this.c = j;
            this.tt = str;
        }
    }

    private synchronized boolean tt(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iTt = tt();
        long jVe = ve();
        if (this.ve.size() <= 0 || this.ve.size() < iTt) {
            this.ve.offer(new c(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.ve.peek().c);
            if (jAbs <= jVe) {
                tt(jVe - jAbs);
                return true;
            }
            this.ve.poll();
            this.ve.offer(new c(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized String n() {
        String str;
        HashMap map = new HashMap();
        for (c cVar : this.ve) {
            if (map.containsKey(cVar.tt)) {
                map.put(cVar.tt, Integer.valueOf(((Integer) map.get(cVar.tt)).intValue() + 1));
            } else {
                map.put(cVar.tt, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    public abstract int tt();

    public boolean uj() {
        return c;
    }

    public abstract long ve();

    public synchronized boolean c(String str) {
        if (tt(str)) {
            c(true);
            c(tt);
        } else {
            c(false);
        }
        return c;
    }

    private void c(long j) {
        if (this.uj == null) {
            this.uj = new Handler(Looper.getMainLooper());
        }
        this.uj.postDelayed(new Runnable() { // from class: com.byazt.dl.tt.1
            @Override // java.lang.Runnable
            public void run() {
                tt.this.c(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(boolean z) {
        c = z;
    }

    private synchronized void tt(long j) {
        tt = j;
    }
}
