package com.huachenjie.channel.page.manage_channel.admin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.huachenjie.channel.databinding.ChannelFragmentManageAdminBinding;
import com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentManageAdminBinding;", "Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminVM;", "", "initAdapter", "addSubAdmin", "", "memberUserCode", "", "position", "cancelSubAdmin", "clickAvatar", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "initView", "lazyLoadData", "initDataObservable", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "isSubAdmin$delegate", "isSubAdmin", "()Z", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageAdminFragment extends BaseMVVMFragment<ChannelFragmentManageAdminBinding, ManageAdminVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    @NotNull
    private static final String KEY_IS_SUB_ADMIN = "is_sub_admin";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channel_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: isSubAdmin$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isSubAdmin = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment.isSubAdmin.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m270invoke() {
            Bundle arguments = ManageAdminFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("is_sub_admin") : false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminFragment$a;", "", "", "channelNo", "", "isSubAdmin", "Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_IS_SUB_ADMIN", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ManageAdminFragment a(@NotNull String channelNo, boolean isSubAdmin) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ManageAdminFragment manageAdminFragment = new ManageAdminFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            bundle.putBoolean("is_sub_admin", isSubAdmin);
            manageAdminFragment.setArguments(bundle);
            return manageAdminFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33419a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33419a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33419a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33419a.invoke(obj);
        }
    }

    public static final /* synthetic */ ManageAdminVM access$getMViewModel(ManageAdminFragment manageAdminFragment) {
        return manageAdminFragment.getMViewModel();
    }

    private final void addSubAdmin() {
        AddSubAdminDialog.Companion companion = AddSubAdminDialog.INSTANCE;
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        AddSubAdminDialog addSubAdminDialogA = companion.a(channelNo, 3 - getMViewModel().m(), new Function1<ChannelAdminBean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment.addSubAdmin.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChannelAdminBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ChannelAdminBean channelAdminBean) {
                Intrinsics.checkNotNullParameter(channelAdminBean, o.f);
                ManageAdminFragment.access$getMViewModel(ManageAdminFragment.this).j(channelAdminBean);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        addSubAdminDialogA.show(childFragmentManager, AddSubAdminDialog.class.getSimpleName());
    }

    private final void cancelSubAdmin(final String memberUserCode, final int position) {
        ft1.p(requireContext(), getString(R.string.channel_manage_cancel_sub_admin_confirm), new View.OnClickListener() { // from class: com.zj.adlib.e75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageAdminFragment.cancelSubAdmin$lambda$3(this.f41362a, memberUserCode, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelSubAdmin$lambda$3(ManageAdminFragment manageAdminFragment, String str, int i, View view) {
        Intrinsics.checkNotNullParameter(manageAdminFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$memberUserCode");
        ManageAdminVM mViewModel = manageAdminFragment.getMViewModel();
        String channelNo = manageAdminFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.k(channelNo, str, i);
    }

    private final void clickAvatar(String memberUserCode) {
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", memberUserCode).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<ManageAdminAdapter> mutableLiveDataL = getMViewModel().l();
        final ManageAdminAdapter manageAdminAdapter = new ManageAdminAdapter();
        manageAdminAdapter.addChildClickViewIds(R.id.iv_avatar, R.id.tv_cancel);
        y57.b(manageAdminAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.f75
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ManageAdminFragment.initAdapter$lambda$2$lambda$0(manageAdminAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        y57.d(manageAdminAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.g75
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ManageAdminFragment.initAdapter$lambda$2$lambda$1(manageAdminAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataL.setValue(manageAdminAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$2$lambda$0(ManageAdminAdapter manageAdminAdapter, ManageAdminFragment manageAdminFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(manageAdminAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(manageAdminFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        T item = manageAdminAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.channel.bean.ChannelAdminBean");
        ChannelAdminBean channelAdminBean = (ChannelAdminBean) item;
        int id = view.getId();
        if (id == R.id.iv_avatar) {
            manageAdminFragment.clickAvatar(channelAdminBean.getMemberUserCode());
        } else if (id == R.id.tv_cancel) {
            manageAdminFragment.cancelSubAdmin(channelAdminBean.getMemberUserCode(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(ManageAdminAdapter manageAdminAdapter, ManageAdminFragment manageAdminFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(manageAdminAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(manageAdminFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (manageAdminAdapter.getItemViewType(i) == 3) {
            manageAdminFragment.addSubAdmin();
        }
    }

    private final boolean isSubAdmin() {
        return ((Boolean) this.isSubAdmin.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_manage_admin;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ManageAdminVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.admin.ManageAdminFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ri1 ri1Var = ri1.f19330a;
                    Context contextRequireContext = ManageAdminFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    String channelNo = ManageAdminFragment.this.getChannelNo();
                    Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                    ri1Var.b(contextRequireContext, channelNo, 3);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        ManageAdminVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.o(channelNo, isSubAdmin());
    }
}
