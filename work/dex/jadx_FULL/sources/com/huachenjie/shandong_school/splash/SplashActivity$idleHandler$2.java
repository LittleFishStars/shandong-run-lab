package com.huachenjie.shandong_school.splash;

import android.os.Handler;
import android.os.MessageQueue;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/MessageQueue$IdleHandler;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SplashActivity$idleHandler$2 extends Lambda implements Function0<MessageQueue.IdleHandler> {
    final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$idleHandler$2(SplashActivity splashActivity) {
        super(0);
        this.this$0 = splashActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2(final SplashActivity splashActivity) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        Handler handler = splashActivity.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = splashActivity.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() { // from class: com.huachenjie.shandong_school.splash.c
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity$idleHandler$2.invoke$lambda$2$lambda$0(splashActivity);
                }
            }, 500L);
        }
        Handler handler3 = splashActivity.mHandler;
        if (handler3 == null) {
            return false;
        }
        handler3.postDelayed(new Runnable() { // from class: com.huachenjie.shandong_school.splash.d
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity$idleHandler$2.invoke$lambda$2$lambda$1(splashActivity);
            }
        }, com.igexin.push.config.c.j);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$0(SplashActivity splashActivity) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        splashActivity.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(SplashActivity splashActivity) {
        Intrinsics.checkNotNullParameter(splashActivity, "this$0");
        splashActivity.n0();
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final MessageQueue.IdleHandler m751invoke() {
        final SplashActivity splashActivity = this.this$0;
        return new MessageQueue.IdleHandler() { // from class: com.huachenjie.shandong_school.splash.b
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return SplashActivity$idleHandler$2.invoke$lambda$2(splashActivity);
            }
        };
    }
}
