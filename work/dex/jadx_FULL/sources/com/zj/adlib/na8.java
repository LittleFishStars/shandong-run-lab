package com.zj.adlib;

import com.huachenjie.mall.page.shopping_message.ShoppingMessageActivity;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final /* synthetic */ class na8 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShoppingMessageActivity f43483a;

    public /* synthetic */ na8(ShoppingMessageActivity shoppingMessageActivity) {
        this.f43483a = shoppingMessageActivity;
    }

    public final void onEvent(Object obj) {
        ShoppingMessageActivity.p0(this.f43483a, (List) obj);
    }
}
