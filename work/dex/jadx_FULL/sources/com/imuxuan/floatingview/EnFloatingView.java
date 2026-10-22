package com.imuxuan.floatingview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class EnFloatingView extends FloatingMagnetView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f38167a;

    public EnFloatingView(@NonNull Context context) {
        this(context, R.layout.en_floating_view);
    }

    public void setIconImage(@DrawableRes int i) {
        this.f38167a.setImageResource(i);
    }

    public EnFloatingView(@NonNull Context context, @LayoutRes int i) {
        super(context, null);
        View.inflate(context, i, this);
        this.f38167a = (ImageView) findViewById(R.id.icon);
    }
}
