package cj.mobile.wm;

import cj.mobile.wm.w3;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class q3<T extends w3> {
    public final Queue<T> dexa = e9.dexa(20);

    public abstract T dexa();

    public void dexa(T t) {
        if (this.dexa.size() < 20) {
            this.dexa.offer(t);
        }
    }

    public T dexb() {
        T tPoll = this.dexa.poll();
        return tPoll == null ? (T) dexa() : tPoll;
    }
}
