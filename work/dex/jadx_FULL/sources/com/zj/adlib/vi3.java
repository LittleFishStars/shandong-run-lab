package com.zj.adlib;

import com.huachenjie.channel.page.home.FlashMessageFragment;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final /* synthetic */ class vi3 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlashMessageFragment f45360a;

    public /* synthetic */ vi3(FlashMessageFragment flashMessageFragment) {
        this.f45360a = flashMessageFragment;
    }

    public final void onEvent(Object obj) {
        FlashMessageFragment.contactObserver$lambda$0(this.f45360a, (List) obj);
    }
}
