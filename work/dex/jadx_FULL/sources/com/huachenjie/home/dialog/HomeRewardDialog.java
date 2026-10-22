package com.huachenjie.home.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.home.databinding.HomeDialogHomeRewardBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.fe9;
import com.zj.adlib.kq5;
import com.zj.adlib.xk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/home/dialog/HomeRewardDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/home/databinding/HomeDialogHomeRewardBinding;", "Lcom/huachenjie/home/dialog/HomeRewardVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initView", "initData", "<init>", "()V", "Companion", "ClickProxy", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeRewardDialog extends BaseMVVMDialogFragment<HomeDialogHomeRewardBinding, HomeRewardVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String REWARD_BEAN = "reward_bean";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/home/dialog/HomeRewardDialog$ClickProxy;", "", "Landroid/view/View;", "view", "", "c", "a", "b", "<init>", "(Lcom/huachenjie/home/dialog/HomeRewardDialog;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeRewardDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void c(@NotNull final View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeRewardVM homeRewardVMAccess$getMViewModel = HomeRewardDialog.access$getMViewModel(HomeRewardDialog.this);
            final HomeRewardDialog homeRewardDialog = HomeRewardDialog.this;
            homeRewardVMAccess$getMViewModel.i(new Function0<Unit>() { // from class: com.huachenjie.home.dialog.HomeRewardDialog$ClickProxy$clickTakeInspiration$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m402invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m402invoke() {
                    kq5.c(view.getContext(), "guide_user_reward_inspiration");
                    ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
                    homeRewardDialog.dismiss();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.HomeRewardDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/dialog/HomeRewardDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/home/bean/reward/HomeRewardBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "", "REWARD_BEAN", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull HomeRewardBean bean) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            HomeRewardDialog homeRewardDialog = new HomeRewardDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reward_bean", bean);
            homeRewardDialog.setArguments(bundle);
            homeRewardDialog.show(fragmentManager, "HomeRewardDialog");
        }
    }

    public static final /* synthetic */ HomeRewardVM access$getMViewModel(HomeRewardDialog homeRewardDialog) {
        return homeRewardDialog.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_home_reward;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @Nullable
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        MutableLiveData<HomeRewardBean> mutableLiveDataJ = getMViewModel().j();
        Bundle arguments = getArguments();
        mutableLiveDataJ.setValue(arguments != null ? (HomeRewardBean) arguments.getParcelable("reward_bean") : null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
    }
}
