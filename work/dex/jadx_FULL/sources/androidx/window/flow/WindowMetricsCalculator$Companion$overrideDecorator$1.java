package androidx.window.flow;

import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public /* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends FunctionReferenceImpl implements Function1<WindowMetricsCalculator, WindowMetricsCalculator> {
    public WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @NotNull
    public final WindowMetricsCalculator invoke(@NotNull WindowMetricsCalculator windowMetricsCalculator) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, bo.g);
        return ((WindowMetricsCalculatorDecorator) ((CallableReference) this).receiver).decorate(windowMetricsCalculator);
    }
}
