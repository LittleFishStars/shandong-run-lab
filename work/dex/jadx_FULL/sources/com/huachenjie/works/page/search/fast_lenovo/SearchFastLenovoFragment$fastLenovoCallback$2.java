package com.huachenjie.works.page.search.fast_lenovo;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SearchFastLenovoFragment$fastLenovoCallback$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ SearchFastLenovoFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFastLenovoFragment$fastLenovoCallback$2(SearchFastLenovoFragment searchFastLenovoFragment) {
        super(0);
        this.this$0 = searchFastLenovoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(SearchFastLenovoFragment searchFastLenovoFragment) {
        Intrinsics.checkNotNullParameter(searchFastLenovoFragment, "this$0");
        searchFastLenovoFragment.getMViewModel().k();
    }

    @NotNull
    public final Runnable invoke() {
        final SearchFastLenovoFragment searchFastLenovoFragment = this.this$0;
        return new Runnable() { // from class: com.huachenjie.works.page.search.fast_lenovo.a
            @Override // java.lang.Runnable
            public final void run() {
                SearchFastLenovoFragment$fastLenovoCallback$2.invoke$lambda$0(searchFastLenovoFragment);
            }
        };
    }
}
