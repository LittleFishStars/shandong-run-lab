package XI.XI.XI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface XI extends IInterface {

    /* JADX INFO: renamed from: XI.XI.XI.XI$XI, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0004XI extends Binder implements XI {

        /* JADX INFO: renamed from: XI, reason: collision with root package name */
        public static final /* synthetic */ int f21181XI = 0;

        /* JADX INFO: renamed from: XI.XI.XI.XI$XI$XI, reason: collision with other inner class name */
        public static class C0005XI implements XI {

            /* JADX INFO: renamed from: XI, reason: collision with root package name */
            public IBinder f21182XI;

            public C0005XI(IBinder iBinder) {
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21182XI;
            }

            @Override // XI.XI.XI.XI
            public String getAAID(String str) {
            }

            @Override // XI.XI.XI.XI
            public String getOAID() {
            }

            @Override // XI.XI.XI.XI
            public String getVAID() {
            }

            @Override // XI.XI.XI.XI
            public boolean isSupported() {
            }
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID();

    boolean isSupported();
}
