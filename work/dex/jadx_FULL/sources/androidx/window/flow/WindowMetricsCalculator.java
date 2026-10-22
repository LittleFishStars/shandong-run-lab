package androidx.window.flow;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import com.byazt.hv.TTDownloadField;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "computeMaximumWindowMetrics", "Companion", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface WindowMetricsCalculator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "()V", "decorator", "Lkotlin/Function1;", "Landroidx/window/layout/WindowMetricsCalculator;", "getOrCreate", "overrideDecorator", "", "overridingDecorator", "Landroidx/window/layout/WindowMetricsCalculatorDecorator;", "reset", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static Function1<? super WindowMetricsCalculator, ? extends WindowMetricsCalculator> decorator = new Function1<WindowMetricsCalculator, WindowMetricsCalculator>() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$decorator$1
            @NotNull
            public final WindowMetricsCalculator invoke(@NotNull WindowMetricsCalculator windowMetricsCalculator) {
                Intrinsics.checkNotNullParameter(windowMetricsCalculator, o.f);
                return windowMetricsCalculator;
            }
        };

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final WindowMetricsCalculator getOrCreate() {
            return (WindowMetricsCalculator) decorator.invoke(WindowMetricsCalculatorCompat.INSTANCE);
        }

        @JvmStatic
        @ExperimentalWindowApi
        @RestrictTo({RestrictTo.Scope.TESTS})
        public final void overrideDecorator(@NotNull WindowMetricsCalculatorDecorator overridingDecorator) {
            Intrinsics.checkNotNullParameter(overridingDecorator, "overridingDecorator");
            decorator = new WindowMetricsCalculator$Companion$overrideDecorator$1(overridingDecorator);
        }

        @JvmStatic
        @ExperimentalWindowApi
        @RestrictTo({RestrictTo.Scope.TESTS})
        public final void reset() {
            decorator = new Function1<WindowMetricsCalculator, WindowMetricsCalculator>() { // from class: androidx.window.layout.WindowMetricsCalculator$Companion$reset$1
                @NotNull
                public final WindowMetricsCalculator invoke(@NotNull WindowMetricsCalculator windowMetricsCalculator) {
                    Intrinsics.checkNotNullParameter(windowMetricsCalculator, o.f);
                    return windowMetricsCalculator;
                }
            };
        }
    }

    @JvmStatic
    @NotNull
    static WindowMetricsCalculator getOrCreate() {
        return INSTANCE.getOrCreate();
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    static void overrideDecorator(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        INSTANCE.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    static void reset() {
        INSTANCE.reset();
    }

    @NotNull
    WindowMetrics computeCurrentWindowMetrics(@NotNull Activity activity);

    @NotNull
    WindowMetrics computeMaximumWindowMetrics(@NotNull Activity activity);
}
