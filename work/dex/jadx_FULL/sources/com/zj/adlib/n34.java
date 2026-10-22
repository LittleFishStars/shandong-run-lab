package com.zj.adlib;

import androidx.coroutines.BindingAdapter;
import com.huachenjie.sport.widget.HuodongSignButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/widget/HuodongSignButton;", "view", "", "signButtonStatus", "", "signRemainingTime", "", "a", "(Lcom/huachenjie/sport/widget/HuodongSignButton;Ljava/lang/Integer;Ljava/lang/Long;)V", "sport_release"}, k = 2, mv = {1, 8, 0})
public final class n34 {
    @BindingAdapter(requireAll = false, value = {"signButtonStatus", "signRemainingTime"})
    public static final void a(@NotNull HuodongSignButton huodongSignButton, @Nullable Integer num, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(huodongSignButton, "view");
        if (num == null) {
            return;
        }
        huodongSignButton.setStatus(o34.f43655a.b(num.intValue()), l);
    }
}
