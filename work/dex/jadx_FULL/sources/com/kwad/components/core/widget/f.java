package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends FrameLayout {
    private boolean awy;
    protected boolean lM;
    protected g lt;

    @NonNull
    protected Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.lM = as.VM();
    }

    private void zY() {
        boolean zVM = as.VM();
        if (!this.awy || zVM == this.lM) {
            return;
        }
        this.lM = zVM;
        g gVar = this.lt;
        if (gVar != null) {
            gVar.k(!zVM);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        zY();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.awy = i == 0;
        zY();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.lt = gVar;
    }
}
