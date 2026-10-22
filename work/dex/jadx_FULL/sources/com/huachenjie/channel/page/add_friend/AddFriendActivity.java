package com.huachenjie.channel.page.add_friend;

import android.util.ArrayMap;
import android.view.View;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.AddFriendAdapter;
import com.huachenjie.channel.bean.MayKnowFriendBean;
import com.huachenjie.channel.databinding.ChannelActivityAddFriendBinding;
import com.huachenjie.channel.page.add_friend.AddFriendActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.external.dialog.AddFriendDialog;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.zj.adlib.tk0;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/add_friend/AddFriendActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityAddFriendBinding;", "Lcom/huachenjie/channel/page/add_friend/AddFriendVM;", "", "S", "initView", "initData", "", "getLayoutResID", "", "", "V", "g0", "d0", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AddFriendActivity extends BaseMVVMActivity<ChannelActivityAddFriendBinding, AddFriendVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/add_friend/AddFriendActivity$a;", "", "Landroid/view/View;", "view", "", "c", "b", "a", "<init>", "(Lcom/huachenjie/channel/page/add_friend/AddFriendActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            AddFriendActivity.c0(AddFriendActivity.this).y();
        }

        public final void b(@Nullable View view) {
            ARouter.getInstance().build(RoutePathConstants.Base.c).navigation();
        }

        public final void c(@Nullable View view) {
            ARouter.getInstance().build(RoutePathConstants.SocialContact.c).navigation();
        }
    }

    public static final /* synthetic */ AddFriendVM c0(AddFriendActivity addFriendActivity) {
        return addFriendActivity.getMViewModel();
    }

    public static final void e0(AddFriendActivity addFriendActivity) {
        Intrinsics.checkNotNullParameter(addFriendActivity, "this$0");
        BaseStateRequestModel.x(addFriendActivity.getMViewModel(), false, 1, null);
    }

    public static final void f0(final AddFriendAdapter addFriendAdapter, AddFriendActivity addFriendActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Map extensionMap;
        Object obj;
        String string;
        Intrinsics.checkNotNullParameter(addFriendAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(addFriendActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        final MayKnowFriendBean mayKnowFriendBean = addFriendAdapter.getData().get(i);
        String str = "";
        if (!(view != null && view.getId() == R.id.bt_add)) {
            if (view != null && view.getId() == R.id.iv_avatar) {
                Postcard postcardBuild = ARouter.getInstance().build(zj7.h.OTHER_HOME);
                NimUserInfo userInfo = mayKnowFriendBean.getUserInfo();
                if (userInfo != null && (extensionMap = userInfo.getExtensionMap()) != null && (obj = extensionMap.get("appUserCode")) != null && (string = obj.toString()) != null) {
                    str = string;
                }
                postcardBuild.withString("appUserCode", str).navigation();
                return;
            }
            return;
        }
        NimUserInfo userInfo2 = mayKnowFriendBean.getUserInfo();
        String avatar = userInfo2 != null ? userInfo2.getAvatar() : null;
        String str2 = avatar == null ? "" : avatar;
        String str3 = mayKnowFriendBean.formatterAvatarFrameUrl();
        NimUserInfo userInfo3 = mayKnowFriendBean.getUserInfo();
        String name = userInfo3 != null ? userInfo3.getName() : null;
        String str4 = name == null ? "" : name;
        NimUserInfo userInfo4 = mayKnowFriendBean.getUserInfo();
        String account = userInfo4 != null ? userInfo4.getAccount() : null;
        AddFriendDialog addFriendDialog = new AddFriendDialog(addFriendActivity, new UserInfoBean(null, str4, str2, null, null, str3, account == null ? "" : account, null, 0, false, 0, null, null, false, false, 32665, null));
        addFriendDialog.setApplyFriendSucCallback(new Function0<Unit>() { // from class: com.huachenjie.channel.page.add_friend.AddFriendActivity$initAdapter$1$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m244invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m244invoke() {
                mayKnowFriendBean.setApplied(true);
                addFriendAdapter.notifyItemChanged(i);
            }
        });
        addFriendDialog.show();
    }

    public static final void h0(AddFriendActivity addFriendActivity, View view) {
        Intrinsics.checkNotNullParameter(addFriendActivity, "this$0");
        addFriendActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(Integer.valueOf(tk0.p0), getMViewModel());
        arrayMap.put(Integer.valueOf(tk0.k), new a());
        return arrayMap;
    }

    public final void d0() {
        getMBinding().f7361a.setItemAnimator(null);
        final AddFriendAdapter value = getMViewModel().B().getValue();
        if (value != null) {
            AddFriendVM mViewModel = getMViewModel();
            StateLayout stateLayout = getMBinding().f7364a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
            mViewModel.o(this, stateLayout, value, true);
            BaseStateRequestModel.n(getMViewModel(), this, value, false, 4, null);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.g10
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    AddFriendActivity.e0(this.f41796a);
                }
            });
            value.addChildClickViewIds(R.id.bt_add, R.id.iv_avatar);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.h10
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    AddFriendActivity.f0(value, this, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public final void g0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.i10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFriendActivity.h0(this.f42251a, view);
            }
        }).setTitleName("添加好友").setTitleTextColor(zn1.a(R.color.color_2C3E50)));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_add_friend;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        d0();
    }
}
