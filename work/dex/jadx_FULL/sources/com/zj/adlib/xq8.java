package com.zj.adlib;

import androidx.coroutines.BindingAdapter;
import com.huachenjie.common.page.statelayout.ConvertInterface;
import com.huachenjie.common.page.statelayout.StateLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/huachenjie/common/page/statelayout/StateLayout;", "view", "", "state", "Lcom/huachenjie/common/page/statelayout/ConvertInterface;", "inter", "", "a", "(Lcom/huachenjie/common/page/statelayout/StateLayout;Ljava/lang/Integer;Lcom/huachenjie/common/page/statelayout/ConvertInterface;)V", "common_release"}, k = 2, mv = {1, 8, 0})
public final class xq8 {
    @BindingAdapter(requireAll = false, value = {"layoutState", "layoutStateInterface"})
    public static final void a(@NotNull StateLayout stateLayout, @Nullable Integer num, @Nullable ConvertInterface convertInterface) {
        Intrinsics.checkNotNullParameter(stateLayout, "view");
        stateLayout.setConvertInterface(convertInterface);
        if (num == null) {
            return;
        }
        stateLayout.setState(num.intValue());
    }
}
