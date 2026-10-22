package android.taobao.windvane.extra.a;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class g extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f21222a;

    public g(String str, Handler.Callback callback) {
        super(str);
        start();
        this.f21222a = new Handler(getLooper(), callback);
    }

    public Handler a() {
        return this.f21222a;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        Handler handler = this.f21222a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }
}
