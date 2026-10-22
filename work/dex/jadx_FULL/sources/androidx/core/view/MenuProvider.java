package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface MenuProvider {
    void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater);

    default void onMenuClosed(@NonNull Menu menu) {
    }

    boolean onMenuItemSelected(@NonNull MenuItem menuItem);

    default void onPrepareMenu(@NonNull Menu menu) {
    }
}
