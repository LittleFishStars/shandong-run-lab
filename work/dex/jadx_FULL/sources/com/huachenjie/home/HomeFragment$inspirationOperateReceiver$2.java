package com.huachenjie.home;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.broadcast.inspiration.InspirationListener;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HomeFragment$inspirationOperateReceiver$2 extends Lambda implements Function0<InspirationReceiver> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$inspirationOperateReceiver$2(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(HomeFragment homeFragment, int i) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        HomeFragment.access$getMViewModel(homeFragment).W();
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final InspirationReceiver m398invoke() {
        final HomeFragment homeFragment = this.this$0;
        return new InspirationReceiver(new InspirationListener() { // from class: com.huachenjie.home.b
            @Override // com.huachenjie.base.broadcast.inspiration.InspirationListener
            public final void a(int i) {
                HomeFragment$inspirationOperateReceiver$2.invoke$lambda$0(homeFragment, i);
            }
        });
    }
}
