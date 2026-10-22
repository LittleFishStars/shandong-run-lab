package com.huachenjie.base.broadcast.channel;

import com.zj.adlib.qi1;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;", "", "", "channelNo", "logo", "", "isCrested", "", "b", "a", qi1.c, "d", "teamId", qi1.g, "c", "base_release"}, k = 1, mv = {1, 8, 0})
public interface ChannelOperateListener {
    void a(@NotNull String channelNo);

    void b(@NotNull String channelNo, @NotNull String logo, boolean isCrested);

    void c(@NotNull String channelNo, @NotNull String teamId, boolean fromOrganize);

    void d(@NotNull String channelNo, @NotNull String logo, boolean channelStatusChange);
}
