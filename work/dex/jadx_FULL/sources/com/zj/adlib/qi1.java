package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.channel.ChannelOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010 \u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006#"}, d2 = {"Lcom/zj/adlib/qi1;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "", "channelNo", qi1.CHANNEL_LOGO, "b", "d", "c", "", qi1.CHANNEL_STATUS_CHANGE, "e", "teamId", qi1.FROM_ORGANIZE, "a", "Ljava/lang/String;", "RECEIVER_CHANNEL_OPERATE", "CHANNEL_NO", "CHANNEL_STATUS_CHANGE", "CHANNEL_LOGO", "CHANNEL_CREATE", "f", "TEAM_ID", y6b.f, "FROM_ORGANIZE", y6b.g, "CHANNEL_OPERATE_TYPE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class qi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final qi1 f44215a = new qi1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_CHANNEL_OPERATE = "com.huachenjie.shandong_school.receiver.channel.channelOperate";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String CHANNEL_STATUS_CHANGE = "channelStatusChange";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String CHANNEL_LOGO = "channelLogo";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String CHANNEL_CREATE = "channelCreate";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public static final String TEAM_ID = "teamId";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final String FROM_ORGANIZE = "fromOrganize";

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public static final String CHANNEL_OPERATE_TYPE = "channelOperateType";

    public final void a(@NotNull Context context, @NotNull String channelNo, @NotNull String teamId, boolean fromOrganize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra("teamId", teamId);
        intent.putExtra(FROM_ORGANIZE, fromOrganize);
        intent.putExtra("channelOperateType", 4);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void b(@NotNull Context context, @NotNull String channelNo, @NotNull String channelLogo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelLogo, CHANNEL_LOGO);
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra(CHANNEL_LOGO, channelLogo);
        intent.putExtra(CHANNEL_CREATE, true);
        intent.putExtra("channelOperateType", 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra("channelOperateType", 2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void d(@NotNull Context context, @NotNull String channelNo, @NotNull String channelLogo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelLogo, CHANNEL_LOGO);
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra(CHANNEL_LOGO, channelLogo);
        intent.putExtra(CHANNEL_CREATE, false);
        intent.putExtra("channelOperateType", 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void e(@NotNull Context context, @NotNull String channelNo, @NotNull String channelLogo, boolean channelStatusChange) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelLogo, CHANNEL_LOGO);
        Intent intent = new Intent(RECEIVER_CHANNEL_OPERATE);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra(CHANNEL_LOGO, channelLogo);
        intent.putExtra(CHANNEL_STATUS_CHANGE, channelStatusChange);
        intent.putExtra("channelOperateType", 3);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull ChannelOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_CHANNEL_OPERATE));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull ChannelOperateReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
