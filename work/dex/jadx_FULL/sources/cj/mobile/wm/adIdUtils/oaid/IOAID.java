package cj.mobile.wm.adIdUtils.oaid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class IOAID {
    public static volatile boolean checkDone = false;
    public static volatile boolean isSupported = false;

    public abstract void doGet(IGetter iGetter);

    public abstract boolean supported();
}
