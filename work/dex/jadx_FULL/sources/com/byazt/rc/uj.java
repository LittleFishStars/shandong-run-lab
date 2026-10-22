package com.byazt.rc;

import com.byazt.yj.sp;
import com.byazt.yj.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 15})
public class uj<T> implements sp {
    public Map<String, String> c;
    public x n;
    public int tt;
    public String uj;
    public T ve;

    public uj(int i, T t, String str) {
        this.tt = i;
        this.ve = t;
        this.uj = str;
    }

    @Override // com.byazt.yj.sp
    public x c() {
        return this.n;
    }

    @Override // com.byazt.yj.sp
    public Map<String, String> n() {
        return this.c;
    }

    @Override // com.byazt.yj.sp
    public int tt() {
        return this.tt;
    }

    @Override // com.byazt.yj.sp
    public String uj() {
        return this.uj;
    }

    @Override // com.byazt.yj.sp
    public T ve() {
        return this.ve;
    }

    public void c(x xVar) {
        this.n = xVar;
    }

    public uj(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.c = map;
    }
}
