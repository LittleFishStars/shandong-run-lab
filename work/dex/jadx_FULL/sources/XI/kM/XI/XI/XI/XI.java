package XI.kM.XI.XI.XI;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class XI implements ServiceConnection {
    public static final ThreadPoolExecutor kM = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public final LinkedBlockingQueue<IBinder> K0;

    /* JADX INFO: renamed from: XI, reason: collision with root package name */
    public boolean f21184XI;

    /* JADX INFO: renamed from: XI.kM.XI.XI.XI.XI$XI, reason: collision with other inner class name */
    public class RunnableC0006XI implements Runnable {
        public final /* synthetic */ XI K0;

        /* JADX INFO: renamed from: XI, reason: collision with root package name */
        public final /* synthetic */ IBinder f21185XI;

        public RunnableC0006XI(XI xi, IBinder iBinder) {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }
}
