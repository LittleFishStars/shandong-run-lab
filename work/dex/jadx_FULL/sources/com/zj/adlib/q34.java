package com.zj.adlib;

import androidx.coroutines.BindingAdapter;
import com.huachenjie.sport.widget.HuodongStatusWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/sport/widget/HuodongStatusWidget;", "view", "", "status", "", "a", "(Lcom/huachenjie/sport/widget/HuodongStatusWidget;Ljava/lang/Integer;)V", "sport_release"}, k = 2, mv = {1, 8, 0})
public final class q34 {
    @BindingAdapter(requireAll = false, value = {"huodongStatus"})
    public static final void a(@NotNull HuodongStatusWidget huodongStatusWidget, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(huodongStatusWidget, "view");
        if (num == null) {
            return;
        }
        huodongStatusWidget.setStatus(p34.f43883a.b(num.intValue()));
    }
}
