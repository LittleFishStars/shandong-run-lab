package com.zj.adlib;

import com.huachenjie.channel.page.channel_home.ChannelHomeActivity;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final /* synthetic */ class fi1 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelHomeActivity f41683a;

    public /* synthetic */ fi1(ChannelHomeActivity channelHomeActivity) {
        this.f41683a = channelHomeActivity;
    }

    public final void onEvent(Object obj) {
        ChannelHomeActivity.n0(this.f41683a, (List) obj);
    }
}
