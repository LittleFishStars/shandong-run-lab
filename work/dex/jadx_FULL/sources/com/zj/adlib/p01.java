package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.broadcast_floor.BroadcastFloorOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/zj/adlib/p01;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/broadcast_floor/BroadcastFloorOperateReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "a", "", "Ljava/lang/String;", "RECEIVER_CHANNEL_OPERATE", "b", "BROADCAST_FLOOR_OPERATE_TYPE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class p01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p01 f43867a = new p01();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_CHANNEL_OPERATE = "com.huachenjie.shandong_school.receiver.floor.broadcastFloor";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String BROADCAST_FLOOR_OPERATE_TYPE = "broadcastFloorOperateType";

    public final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra(BROADCAST_FLOOR_OPERATE_TYPE, 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull BroadcastFloorOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_CHANNEL_OPERATE));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull BroadcastFloorOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
