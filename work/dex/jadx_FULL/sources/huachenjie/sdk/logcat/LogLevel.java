package huachenjie.sdk.logcat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum LogLevel {
    Verbose(1),
    Debug(2),
    Info(4),
    Warn(8),
    Error(16);

    final int value;

    LogLevel(int i) {
        this.value = i;
    }
}
