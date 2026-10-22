package com.huachenjie.channel.page.friend_list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.FriendListAdapter;
import com.huachenjie.channel.bean.FriendListBean;
import com.huachenjie.channel.databinding.ChannelActivityFriendListBinding;
import com.huachenjie.channel.page.add_friend.AddFriendActivity;
import com.huachenjie.channel.page.friend_list.FriendListActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.im.bean.FriendUserInfo;
import com.igexin.push.g.o;
import com.zj.adlib.dj1;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/friend_list/FriendListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityFriendListBinding;", "Lcom/huachenjie/channel/page/friend_list/FriendListViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "onResume", "W", "initTitleBar", "e0", "g0", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class FriendListActivity extends BaseMVVMActivity<ChannelActivityFriendListBinding, FriendListViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.channel.page.friend_list.FriendListActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/friend_list/FriendListActivity$a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FriendListActivity.class));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33405a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33405a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33405a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33405a.invoke(obj);
        }
    }

    public static final void f0(FriendListActivity friendListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String accId;
        Intrinsics.checkNotNullParameter(friendListActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        FriendListAdapter value = friendListActivity.getMViewModel().j().getValue();
        Intrinsics.checkNotNull(value);
        FriendListBean friendListBean = (FriendListBean) value.getData().get(i);
        if (friendListBean.getPostType() == 2) {
            FriendUserInfo userInfo = friendListBean.getUserInfo();
            if (userInfo == null || (accId = userInfo.getAccId()) == null) {
                accId = "";
            }
            dj1.c0(accId);
        }
    }

    public static final void h0(FriendListActivity friendListActivity, View view) {
        Intrinsics.checkNotNullParameter(friendListActivity, "this$0");
        friendListActivity.finish();
    }

    public static final void i0(FriendListActivity friendListActivity, View view) {
        Intrinsics.checkNotNullParameter(friendListActivity, "this$0");
        friendListActivity.startActivity(new Intent(friendListActivity, (Class<?>) AddFriendActivity.class));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMBinding().f7555a.getEtSearch().setEnabled(false);
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.friend_list.FriendListActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                EditText etSearch = this.this$0.getMBinding().f7555a.getEtSearch();
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                etSearch.setEnabled(bool.booleanValue());
            }
        }));
    }

    public final void e0() {
        FriendListAdapter value = getMViewModel().j().getValue();
        Intrinsics.checkNotNull(value);
        y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.zn3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FriendListActivity.f0(this.f46302a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public final void g0() {
        getMBinding().f7554a.setFilterContentViewIds(new int[]{R.id.slide_view});
        getMBinding().f7555a.openIntervalCallback(100L, new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.friend_list.FriendListActivity$initEvents$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                FriendListViewModel mViewModel = this.this$0.getMViewModel();
                StateLayout stateLayout = this.this$0.getMBinding().f7554a;
                Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
                mViewModel.s(str, stateLayout);
            }
        });
        getMBinding().f7552a.setSelectIndexCallback(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.friend_list.FriendListActivity$initEvents$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                FriendListActivity friendListActivity = this.this$0;
                int i = 0;
                for (Object obj : friendListActivity.getMViewModel().m()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FriendListBean friendListBean = (FriendListBean) obj;
                    if (friendListBean.getPostType() == 1 && Intrinsics.areEqual(friendListBean.getGroupName(), str)) {
                        friendListActivity.getMBinding().f7551a.stopScroll();
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) friendListActivity.getMBinding().f7551a.getLayoutManager();
                        if (linearLayoutManager != null) {
                            linearLayoutManager.scrollToPositionWithOffset(i, 0);
                            return;
                        }
                        return;
                    }
                    i = i2;
                }
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_friend_list;
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataP = getMViewModel().p();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataP.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.channel_friend_list_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendListActivity.h0(this.f45855a, view);
            }
        }).setShowRightIcon(true).setRightIconResId(R.drawable.channel_ic_address_book_add).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.yn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendListActivity.i0(this.f46072a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
        e0();
        g0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        FriendListViewModel mViewModel = getMViewModel();
        String string = getMBinding().f7555a.getEtSearch().getText().toString();
        StateLayout stateLayout = getMBinding().f7554a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        mViewModel.q(string, stateLayout);
    }
}
