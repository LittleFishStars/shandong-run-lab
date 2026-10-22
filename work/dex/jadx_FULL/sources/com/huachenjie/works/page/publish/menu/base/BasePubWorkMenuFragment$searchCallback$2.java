package com.huachenjie.works.page.publish.menu.base;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "VM", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BasePubWorkMenuFragment$searchCallback$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ BasePubWorkMenuFragment<VM> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePubWorkMenuFragment$searchCallback$2(BasePubWorkMenuFragment<VM> basePubWorkMenuFragment) {
        super(0);
        this.this$0 = basePubWorkMenuFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(BasePubWorkMenuFragment basePubWorkMenuFragment) {
        Intrinsics.checkNotNullParameter(basePubWorkMenuFragment, "this$0");
        String value = BasePubWorkMenuFragment.access$getMViewModel(basePubWorkMenuFragment).H().getValue();
        if (value == null) {
            value = "";
        }
        basePubWorkMenuFragment.searchContentChanged(value);
    }

    @NotNull
    public final Runnable invoke() {
        final BasePubWorkMenuFragment<VM> basePubWorkMenuFragment = this.this$0;
        return new Runnable() { // from class: com.huachenjie.works.page.publish.menu.base.a
            @Override // java.lang.Runnable
            public final void run() {
                BasePubWorkMenuFragment$searchCallback$2.invoke$lambda$0(basePubWorkMenuFragment);
            }
        };
    }
}
