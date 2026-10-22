package com.zj.adlib;

import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final /* synthetic */ class ku5 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyChannelFragment f42911a;

    public /* synthetic */ ku5(MyChannelFragment myChannelFragment) {
        this.f42911a = myChannelFragment;
    }

    public final void onEvent(Object obj) {
        MyChannelFragment.contactObserver$lambda$8(this.f42911a, (List) obj);
    }
}
