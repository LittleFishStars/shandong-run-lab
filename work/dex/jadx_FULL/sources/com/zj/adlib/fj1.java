package com.zj.adlib;

import com.huachenjie.im.page.ChatRoomFragment;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final /* synthetic */ class fj1 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatRoomFragment f41687a;

    public /* synthetic */ fj1(ChatRoomFragment chatRoomFragment) {
        this.f41687a = chatRoomFragment;
    }

    public final void onEvent(Object obj) {
        this.f41687a.lambda$new$9b1c5750$1((List) obj);
    }
}
