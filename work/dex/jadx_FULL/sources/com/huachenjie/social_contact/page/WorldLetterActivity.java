package com.huachenjie.social_contact.page;

import android.os.Bundle;
import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.WorldLetterActivity;
import com.huachenjie.social_contact.vm.WorldLetterVM;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.e)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/social_contact/page/WorldLetterActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/vm/WorldLetterVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "e0", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "v", "onBackClick", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class WorldLetterActivity extends BaseVmActivity<WorldLetterVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.p0a
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            WorldLetterActivity.g0(this.f43869a);
        }
    };

    public static final void g0(WorldLetterActivity worldLetterActivity) {
        Intrinsics.checkNotNullParameter(worldLetterActivity, "this$0");
        ((WorldLetterVM) ((BaseVmActivity) worldLetterActivity).f8507a).t();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_world_letter), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.R), this.onRefreshListener);
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…fresh, onRefreshListener)");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((WorldLetterVM) ((BaseVmActivity) this).f8507a).l();
        ((WorldLetterVM) ((BaseVmActivity) this).f8507a).t();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void onBackClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        finish();
    }
}
