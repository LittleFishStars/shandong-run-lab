package androidx.window.flow;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(17)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/window/layout/DisplayCompatHelperApi17;", "", "()V", "getRealSize", "", "display", "Landroid/view/Display;", SQLiteMTAHelper.TABLE_POINT, "Landroid/graphics/Point;", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DisplayCompatHelperApi17 {

    @NotNull
    public static final DisplayCompatHelperApi17 INSTANCE = new DisplayCompatHelperApi17();

    private DisplayCompatHelperApi17() {
    }

    public final void getRealSize(@NotNull Display display, @NotNull Point point) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(point, SQLiteMTAHelper.TABLE_POINT);
        display.getRealSize(point);
    }
}
