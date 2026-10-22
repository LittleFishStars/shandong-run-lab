package com.zj.adlib;

import com.huachenjie.channel.page.home.FlashMessageFragment;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final /* synthetic */ class wi3 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlashMessageFragment f45603a;

    public /* synthetic */ wi3(FlashMessageFragment flashMessageFragment) {
        this.f45603a = flashMessageFragment;
    }

    public final void onEvent(Object obj) {
        FlashMessageFragment.contactDeletedObserver$lambda$1(this.f45603a, (RecentContact) obj);
    }
}
