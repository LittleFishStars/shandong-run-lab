package com.zj.adlib;

import com.huachenjie.mall.page.shopping_message.ShoppingMessageActivity;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final /* synthetic */ class oa8 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShoppingMessageActivity f43711a;

    public /* synthetic */ oa8(ShoppingMessageActivity shoppingMessageActivity) {
        this.f43711a = shoppingMessageActivity;
    }

    public final void onEvent(Object obj) {
        ShoppingMessageActivity.o0(this.f43711a, (RecentContact) obj);
    }
}
