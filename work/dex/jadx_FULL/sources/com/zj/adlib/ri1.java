package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.channel.utils.channel.ChannelRefreshReceiver;
import com.king.zxing.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012¨\u0006 "}, d2 = {"Lcom/zj/adlib/ri1;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "receiver", "", "a", "c", "", "channelNo", "", "type", "b", "Ljava/lang/String;", "INTENT_FILTER", "CHANNEL_NO", e.f.c, "I", "TYPE_STATUS", "TYPE_INFO", "TYPE_ADMIN", "d", "TYPE_CHAT", "e", "TYPE_TOPIC", "f", "TYPE_TOPIC_CHAT", y6b.f, "TYPE_ORGANIZE_TEAM", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ri1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int TYPE_STATUS = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final ri1 f19330a = new ri1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String INTENT_FILTER = "com.huachenjie.shandong_school.receiver.channel.channel_refresh";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int TYPE_INFO = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final int TYPE_ADMIN = 3;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TYPE = "type";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final int TYPE_CHAT = 4;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final int TYPE_TOPIC = 5;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final int TYPE_TOPIC_CHAT = 6;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final int TYPE_ORGANIZE_TEAM = 7;

    public final void a(@NotNull Context context, @NotNull ChannelRefreshReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(INTENT_FILTER));
    }

    public final void b(@NotNull Context context, @NotNull String channelNo, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intent intent = new Intent(INTENT_FILTER);
        intent.putExtra("channelNo", channelNo);
        intent.putExtra("type", type);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull ChannelRefreshReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
