package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.topic.TopicOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/e99;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/topic/TopicOperateReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "a", "b", "", "Ljava/lang/String;", "RECEIVER_TOPIC_OPERATE", "TOPIC_OPERATE_TYPE", "", "I", "TOPIC_JOIN", "TOPIC_LEAVE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class e99 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int TOPIC_JOIN = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final e99 f16248a = new e99();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_TOPIC_OPERATE = "com.huachenjie.shandong_school.receiver.topic.topicOperateHelper";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int TOPIC_LEAVE = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TOPIC_OPERATE_TYPE = "channelOperateType";

    public final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_TOPIC_OPERATE);
        intent.putExtra("channelOperateType", 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(RECEIVER_TOPIC_OPERATE);
        intent.putExtra("channelOperateType", 2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull TopicOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_TOPIC_OPERATE));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull TopicOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
