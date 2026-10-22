package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class PopupMenuCompat {

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static View.OnTouchListener getDragToOpenListener(PopupMenu popupMenu) {
            return popupMenu.getDragToOpenListener();
        }
    }

    private PopupMenuCompat() {
    }

    @Nullable
    public static View.OnTouchListener getDragToOpenListener(@NonNull Object obj) {
        return Api19Impl.getDragToOpenListener((PopupMenu) obj);
    }
}
