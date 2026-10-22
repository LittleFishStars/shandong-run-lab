package cj.mobile.wm.okserver.task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PriorityRunnable extends PriorityObject<Runnable> implements Runnable {
    public PriorityRunnable(int i, Runnable runnable) {
        super(i, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((Runnable) this.obj).run();
    }
}
