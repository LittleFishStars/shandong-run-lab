package cj.mobile.g;

import android.app.Activity;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadConfirmListener f22214a = new C0075a();

    /* JADX INFO: renamed from: cj.mobile.g.a$a, reason: collision with other inner class name */
    public class C0075a implements DownloadConfirmListener {

        /* JADX INFO: renamed from: cj.mobile.g.a$a$a, reason: collision with other inner class name */
        public class C0076a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadConfirmCallBack f22215a;

            public C0076a(C0075a c0075a, DownloadConfirmCallBack downloadConfirmCallBack) {
            }

            @Override // cj.mobile.g.b
            public void a() {
            }

            @Override // cj.mobile.g.b
            public void b() {
            }
        }

        public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        }
    }
}
