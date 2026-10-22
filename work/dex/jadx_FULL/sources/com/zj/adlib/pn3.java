package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.broadcast.friend_alias.FriendAliasReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/pn3;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "", pn3.FRIEND_ACCOUNT, "fiendAlias", "a", "Ljava/lang/String;", "RECEIVER_FRIEND_ALIAS", "b", "FRIEND_ACCOUNT", "c", "FRIEND_ALIAS", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class pn3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final pn3 f44021a = new pn3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_FRIEND_ALIAS = "com.huachenjie.shandong_school.receiver.alias.friendAliasHelper";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String FRIEND_ACCOUNT = "friendAccount";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String FRIEND_ALIAS = "friendAlias";

    public final void a(@NotNull Context context, @NotNull String friendAccount, @NotNull String fiendAlias) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendAccount, FRIEND_ACCOUNT);
        Intrinsics.checkNotNullParameter(fiendAlias, "fiendAlias");
        Intent intent = new Intent(RECEIVER_FRIEND_ALIAS);
        intent.putExtra(FRIEND_ACCOUNT, friendAccount);
        intent.putExtra(FRIEND_ALIAS, fiendAlias);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void registerReceiver(@NotNull Context context, @NotNull FriendAliasReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_FRIEND_ALIAS));
    }

    public final void unregisterReceiver(@NotNull Context context, @NotNull FriendAliasReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
