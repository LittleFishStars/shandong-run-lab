package com.huachenjie.base.broadcast.friend_alias;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zj.adlib.pn3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasListener;", "a", "Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasListener;", "mListener", "<init>", "(Lcom/huachenjie/base/broadcast/friend_alias/FriendAliasListener;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class FriendAliasReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final FriendAliasListener mListener;

    public FriendAliasReceiver(@NotNull FriendAliasListener friendAliasListener) {
        Intrinsics.checkNotNullParameter(friendAliasListener, "mListener");
        this.mListener = friendAliasListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(pn3.b);
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(FriendAli…per.FRIEND_ACCOUNT) ?: \"\"");
            String stringExtra2 = intent.getStringExtra(pn3.c);
            String str = stringExtra2 != null ? stringExtra2 : "";
            Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(FriendAli…elper.FRIEND_ALIAS) ?: \"\"");
            this.mListener.a(stringExtra, str);
        }
    }
}
