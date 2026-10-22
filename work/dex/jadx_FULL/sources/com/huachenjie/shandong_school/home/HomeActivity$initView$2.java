package com.huachenjie.shandong_school.home;

import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.shandong_school.R;
import com.zj.adlib.ew;
import com.zj.adlib.hp4;
import com.zj.adlib.r8a;
import com.zj.adlib.r90;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/shandong_school/home/HomeActivity$initView$2", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "", "app_otherRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeActivity$initView$2 implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeActivity f36046a;

    public HomeActivity$initView$2(HomeActivity homeActivity) {
        this.f36046a = homeActivity;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(@NotNull View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(@NotNull View drawerView) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        AdPlatformSwitch adPlatformSwitchE = r90.e("msb");
        boolean z = false;
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            z = true;
        }
        if (!z || (viewGroup = (ViewGroup) drawerView.findViewById(R.id.fl_container_ad_person)) == null) {
            return;
        }
        HomeActivity homeActivity = this.f36046a;
        if (r90.c()) {
            ew.l().e(r8a.n, homeActivity, viewGroup, null);
        } else {
            ew.f().f(homeActivity, homeActivity.getLifecycle(), viewGroup, hp4.j);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(@NotNull View drawerView, float slideOffset) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int newState) {
    }
}
