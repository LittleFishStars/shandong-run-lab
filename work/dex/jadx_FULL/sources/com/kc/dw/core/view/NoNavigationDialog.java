package com.kc.dw.core.view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class NoNavigationDialog extends AlertDialog {
    private Window window;

    public NoNavigationDialog(Context context) {
        super(context);
        this.window = getWindow();
    }

    public NoNavigationDialog(Context context, int i) {
        super(context, i);
    }

    private void clearFocusNotAle(Window window) {
        window.clearFlags(8);
    }

    private void focusNotAle(Window window) {
        window.setFlags(8, 8);
    }

    public void hideNavigationBar(Window window) {
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this, window) { // from class: com.kc.dw.core.view.NoNavigationDialog.1
            public final NoNavigationDialog this$0;
            public final Window val$window;

            {
                this.this$0 = this;
                this.val$window = window;
            }

            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                this.val$window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        focusNotAle(this.window);
        super.show();
        hideNavigationBar(this.window);
        clearFocusNotAle(this.window);
    }
}
