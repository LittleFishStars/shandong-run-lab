package com.huachenjie.channel.page.notify.friend_apply;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityFriendApplyListBinding;
import com.huachenjie.channel.page.notify.friend_apply.FriendApplyListActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/channel/page/notify/friend_apply/FriendApplyListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityFriendApplyListBinding;", "Lcom/huachenjie/channel/page/notify/friend_apply/FriendApplyListVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "", "darkMode", "i0", "d0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class FriendApplyListActivity extends BaseMVVMActivity<ChannelActivityFriendApplyListBinding, FriendApplyListVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.tn3
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            FriendApplyListActivity.h0(this.f44962a);
        }
    };

    public static final void e0(FriendApplyListActivity friendApplyListActivity, View view) {
        Intrinsics.checkNotNullParameter(friendApplyListActivity, "this$0");
        friendApplyListActivity.finish();
    }

    public static final void f0(FriendApplyListActivity friendApplyListActivity) {
        Intrinsics.checkNotNullParameter(friendApplyListActivity, "this$0");
        FriendApplyListVM mViewModel = friendApplyListActivity.getMViewModel();
        if (mViewModel != null) {
            mViewModel.s();
        }
    }

    public static final void g0(FriendApplyListActivity friendApplyListActivity, FriendApplyListAdapter friendApplyListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(friendApplyListActivity, "this$0");
        Intrinsics.checkNotNullParameter(friendApplyListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.tvApplyAgree) {
            FriendApplyListVM mViewModel = friendApplyListActivity.getMViewModel();
            if (mViewModel != null) {
                mViewModel.l(i);
                return;
            }
            return;
        }
        if (id != R.id.tvApplyReject) {
            if (id == R.id.ivUserAvatar) {
                ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", friendApplyListAdapter.getData().get(i).getFromUserCode()).navigation();
            }
        } else {
            FriendApplyListVM mViewModel2 = friendApplyListActivity.getMViewModel();
            if (mViewModel2 != null) {
                mViewModel2.v(i);
            }
        }
    }

    public static final void h0(FriendApplyListActivity friendApplyListActivity) {
        Intrinsics.checkNotNullParameter(friendApplyListActivity, "this$0");
        friendApplyListActivity.getMViewModel().u();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        i0(true);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    public final void d0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("新的朋友").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.qn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendApplyListActivity.e0(this.f44249a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_friend_apply_list;
    }

    public final void i0(boolean darkMode) {
        View decorView = getWindow().getDecorView();
        int i = R.color.white;
        decorView.setBackgroundColor(zn1.a(i));
        e.p3(this).G2(R.color.transparent).T2(darkMode).q1(false).u1(i).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().u();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<FriendApplyListAdapter> mutableLiveDataM;
        final FriendApplyListAdapter value;
        super.initView();
        d0();
        FriendApplyListVM mViewModel = getMViewModel();
        if (mViewModel == null || (mutableLiveDataM = mViewModel.m()) == null || (value = mutableLiveDataM.getValue()) == null) {
            return;
        }
        value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.rn3
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                FriendApplyListActivity.f0(this.f44488a);
            }
        });
        value.addChildClickViewIds(R.id.tvApplyAgree, R.id.tvApplyReject, R.id.ivUserAvatar);
        y57.b(value, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.sn3
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FriendApplyListActivity.g0(this.f44723a, value, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }
}
