package com.huachenjie.channel.utils.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/utils/channel/ChannelRefreshReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "a", "Ljava/lang/String;", "channelNo", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelRefreshReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String channelNo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Function1<Integer, Unit> onReceive;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelRefreshReceiver(@NotNull String str, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "channelNo");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        this.channelNo = str;
        this.onReceive = function1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra("channelNo")) == null) {
            return;
        }
        int intExtra = intent.getIntExtra("type", 0);
        if (Intrinsics.areEqual(stringExtra, this.channelNo)) {
            this.onReceive.invoke(Integer.valueOf(intExtra));
        }
    }
}
