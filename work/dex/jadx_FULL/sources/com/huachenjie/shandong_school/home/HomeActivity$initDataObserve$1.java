package com.huachenjie.shandong_school.home;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.bean.VersionUpgrade;
import com.igexin.push.g.o;
import com.zj.adlib.eh9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", o.f, "Lcom/huachenjie/common/bean/VersionUpgrade;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HomeActivity$initDataObserve$1 extends Lambda implements Function1<VersionUpgrade, Unit> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeActivity$initDataObserve$1(HomeActivity homeActivity) {
        super(1);
        this.this$0 = homeActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VersionUpgrade) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VersionUpgrade versionUpgrade) {
        if (eh9.c(versionUpgrade)) {
            eh9.d(this.this$0, 1001, versionUpgrade);
        } else {
            this.this$0.w0();
        }
    }
}
