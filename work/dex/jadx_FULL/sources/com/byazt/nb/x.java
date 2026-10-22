package com.byazt.nb;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 71})
public class x<T> {
    public T c;
    public T tt;

    private static boolean tt(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public void c(T t, T t2) {
        this.c = t;
        this.tt = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return tt(pair.first, this.c) && tt(pair.second, this.tt);
    }

    public int hashCode() {
        T t = this.c;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.tt;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.c + " " + this.tt + "}";
    }
}
