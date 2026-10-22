package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f32670a;
    public a0 b = new a0();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f32671a;
        public final /* synthetic */ HonorPushCallback b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.f32671a = callable;
            this.b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object objCall = this.f32671a.call();
                s sVar = s.this;
                HonorPushCallback honorPushCallback = this.b;
                sVar.getClass();
                b1.a(new t(sVar, honorPushCallback, objCall));
            } catch (ApiException e) {
                s.a(s.this, this.b, e.getErrorCode(), e.getMessage());
            } catch (Exception unused) {
                s sVar2 = s.this;
                HonorPushCallback honorPushCallback2 = this.b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                s.a(sVar2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public s(Context context) {
        this.f32670a = context;
    }

    public static void a(s sVar, HonorPushCallback honorPushCallback, int i, String str) {
        sVar.getClass();
        b1.a(new u(sVar, honorPushCallback, i, str));
    }

    public final <T> void a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        b1 b1Var = b1.d;
        if (b1Var.b == null) {
            synchronized (b1Var.c) {
                if (b1Var.b == null) {
                    b1Var.b = b1Var.b();
                }
            }
        }
        b1Var.b.execute(aVar);
    }
}
