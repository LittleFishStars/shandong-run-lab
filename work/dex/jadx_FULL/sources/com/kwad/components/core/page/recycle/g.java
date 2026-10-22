package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class g extends RecyclerView {
    private boolean afu;

    public g(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        if (this.afu) {
            super.removeDetachedView(view, z);
        } else {
            super.removeDetachedView(view, z);
        }
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.afu = z;
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
