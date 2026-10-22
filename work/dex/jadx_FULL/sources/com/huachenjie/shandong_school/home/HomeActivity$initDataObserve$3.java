package com.huachenjie.shandong_school.home;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.bean.ActivityPopBean;
import com.igexin.push.g.o;
import com.zj.adlib.su9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", o.f, "Lcom/huachenjie/base/bean/ActivityPopBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HomeActivity$initDataObserve$3 extends Lambda implements Function1<ActivityPopBean, Unit> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeActivity$initDataObserve$3(HomeActivity homeActivity) {
        super(1);
        this.this$0 = homeActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ActivityPopBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ActivityPopBean activityPopBean) {
        if (activityPopBean.getActivityPopupFlag()) {
            su9.k(this.this$0, activityPopBean.getActivityPopupInfo().getActivityUrl());
            this.this$0.getMViewModel().u(activityPopBean.getActivityPopupInfo().getActivityNo());
        }
    }
}
