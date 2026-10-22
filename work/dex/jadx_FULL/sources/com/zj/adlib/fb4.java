package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/fb4;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "", "changeValue", "a", "b", "", "Ljava/lang/String;", "RECEIVER_INSPIRATION", "INSPIRATION_OPERATE_TYPE", "c", "INSPIRATION_VALUE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class fb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fb4 f41638a = new fb4();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_INSPIRATION = "com.huachenjie.shandong_school.receiver.inspiration.operate";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String INSPIRATION_OPERATE_TYPE = "inspirationOperateType";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String INSPIRATION_VALUE = "inspirationValue";

    public final void a(@NotNull Context context, int changeValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_INSPIRATION);
        intent.putExtra(INSPIRATION_OPERATE_TYPE, 1);
        intent.putExtra("inspirationValue", changeValue);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_INSPIRATION);
        intent.putExtra(INSPIRATION_OPERATE_TYPE, 2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull InspirationReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_INSPIRATION));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull InspirationReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
