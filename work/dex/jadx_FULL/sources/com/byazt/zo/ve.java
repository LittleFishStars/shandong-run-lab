package com.byazt.zo;

import android.view.View;
import com.byazt.ete.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 54})
public class ve {
    public volatile int n;
    public View uj;
    public da ve;
    public final com.byazt.hkv.uj x;
    public List<c> c = new ArrayList();
    public Map<String, Object> tt = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f29248a = 0;
    public long sp = -1;

    public ve(com.byazt.hkv.uj ujVar) {
        this.x = ujVar;
    }

    private void ve() {
        this.n = 0;
        this.f29248a = 0;
    }

    public long c() {
        return this.sp;
    }

    public void tt() {
        this.sp = System.currentTimeMillis();
        ((com.byazt.vis.c) this.x.c(com.byazt.vis.c.class)).c(false);
        ve();
        c(0);
    }

    public void c(View view) {
        this.uj = view;
    }

    public void c(c cVar) {
        this.c.add(cVar);
    }

    public void c(da daVar) {
        this.ve = daVar;
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().c(this.ve);
        }
    }

    private void c(int i) {
        int size = this.c.size();
        while (i < size) {
            int i2 = i + 1;
            this.n = i2;
            c cVar = this.c.get(i);
            cVar.c(this.uj);
            this.f29248a = cVar.c(this.tt, this);
            if (this.f29248a != 0) {
                if (this.f29248a == 2) {
                    ((com.byazt.vis.c) this.x.c(com.byazt.vis.c.class)).c(this.tt, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public <T extends c> T c(Class<T> cls) {
        return (T) this.x.c(cls);
    }
}
