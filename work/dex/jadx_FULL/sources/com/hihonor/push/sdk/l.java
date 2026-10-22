package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class l {
    public static final l e = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f32657a;
    public volatile boolean b = false;
    public volatile boolean c = false;
    public s d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f32658a;
        public final /* synthetic */ HonorPushCallback b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.f32658a = runnable;
            this.b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.b) {
                this.f32658a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public boolean a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == b.b(context);
    }

    public Context a() {
        return this.f32657a.get();
    }

    public final void a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        b1.a(new a(runnable, honorPushCallback));
    }
}
