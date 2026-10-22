package com.huachenjie.base.broadcast.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zj.adlib.qi1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;", "a", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;", "mListener", "<init>", "(Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelOperateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ChannelOperateListener mListener;

    public ChannelOperateReceiver(@NotNull ChannelOperateListener channelOperateListener) {
        Intrinsics.checkNotNullParameter(channelOperateListener, "mListener");
        this.mListener = channelOperateListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("channelNo");
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(ChannelOp…eHelper.CHANNEL_NO) ?: \"\"");
            int intExtra = intent.getIntExtra("channelOperateType", 0);
            if (intExtra == 1) {
                String stringExtra2 = intent.getStringExtra(qi1.d);
                str = stringExtra2 != null ? stringExtra2 : "";
                Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(ChannelOp…elper.CHANNEL_LOGO) ?: \"\"");
                this.mListener.b(stringExtra, str, intent.getBooleanExtra(qi1.e, false));
                return;
            }
            if (intExtra == 2) {
                this.mListener.a(stringExtra);
                return;
            }
            if (intExtra == 3) {
                String stringExtra3 = intent.getStringExtra(qi1.d);
                str = stringExtra3 != null ? stringExtra3 : "";
                Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(ChannelOp…elper.CHANNEL_LOGO) ?: \"\"");
                this.mListener.d(stringExtra, str, intent.getBooleanExtra(qi1.c, false));
                return;
            }
            if (intExtra != 4) {
                return;
            }
            String stringExtra4 = intent.getStringExtra("teamId");
            str = stringExtra4 != null ? stringExtra4 : "";
            Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(ChannelOperateHelper.TEAM_ID) ?: \"\"");
            this.mListener.c(stringExtra, str, intent.getBooleanExtra(qi1.g, false));
        }
    }
}
