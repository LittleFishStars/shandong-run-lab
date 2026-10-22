package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.captcha.CaptchaResultReceiver;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/zj/adlib/ee1;", "", "Landroid/content/Context;", "context", "", "captcha", "", "a", "Lcom/huachenjie/base/broadcast/captcha/CaptchaResultReceiver;", "receiver", "registerReceiver", "unregisterReceiver", "Ljava/lang/String;", "RECEIVER_CAPTCHA_RESULT", "b", "BROADCAST_CAPTCHA_RESULT", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ee1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ee1 f41414a = new ee1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_CAPTCHA_RESULT = "com.huachenjie.shandong_school.receiver.captcha.result";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String BROADCAST_CAPTCHA_RESULT = "broadcastCaptchaResult";

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull String captcha) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(captcha, "captcha");
        Intent intent = new Intent(RECEIVER_CAPTCHA_RESULT);
        intent.putExtra(BROADCAST_CAPTCHA_RESULT, captcha);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull CaptchaResultReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_CAPTCHA_RESULT));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull CaptchaResultReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
