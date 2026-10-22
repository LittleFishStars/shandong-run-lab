package com.huachenjie.base.widget;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u001c\u0010\b\u001a\n \r*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/base/widget/QQStyleDrawerListener;", "Landroidx/drawerlayout/widget/DrawerLayout$SimpleDrawerListener;", "Landroid/view/View;", "drawerView", "", "slideOffset", "", "onDrawerSlide", "contentView", "a", "Landroidx/drawerlayout/widget/DrawerLayout;", "Landroidx/drawerlayout/widget/DrawerLayout;", "drawerLayout", "kotlin.jvm.PlatformType", "Landroid/view/View;", "<init>", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class QQStyleDrawerListener extends DrawerLayout.SimpleDrawerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View contentView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final DrawerLayout drawerLayout;

    public QQStyleDrawerListener(@NotNull DrawerLayout drawerLayout) {
        Intrinsics.checkNotNullParameter(drawerLayout, "drawerLayout");
        this.drawerLayout = drawerLayout;
        this.contentView = drawerLayout.getChildAt(0);
    }

    public final void a(View contentView, View drawerView, float slideOffset) {
        float f = 1 - (0.1f * slideOffset);
        float width = drawerView.getWidth() * slideOffset * 0.3f;
        contentView.setScaleX(f);
        contentView.setScaleY(f);
        contentView.setTranslationX(width);
        if (slideOffset > 0.0f) {
            contentView.setElevation(slideOffset * 8.0f);
        } else {
            contentView.setElevation(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(@NotNull View drawerView, float slideOffset) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        super.onDrawerSlide(drawerView, slideOffset);
        View view = this.contentView;
        Intrinsics.checkNotNullExpressionValue(view, "contentView");
        a(view, drawerView, slideOffset);
    }
}
