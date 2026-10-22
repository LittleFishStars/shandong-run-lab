package com.huachenjie.channel.page.manage_channel.admin.add;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.channel.databinding.ChannelDialogAddSubAdminBinding;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog.a;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\u00060\u001dR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelDialogAddSubAdminBinding;", "Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminVM;", "", "initAdapter", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "onStart", "initData", "initDataObserve", "Lkotlin/Function1;", "Lcom/huachenjie/channel/bean/ChannelAdminBean;", "onSetCallback", "Lkotlin/jvm/functions/Function1;", "maxCount", "I", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog$a;", "clickProxy$delegate", "getClickProxy", "()Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog$a;", "clickProxy", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AddSubAdminDialog extends BaseMVVMBottomDialogFragment<ChannelDialogAddSubAdminBinding, AddSubAdminVM> {

    @NotNull
    private static final String CHANNEL_NO = "channel_no";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String MAX_COUNT = "max_count";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog$channelNo$2
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

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AddSubAdminDialog.a m272invoke() {
            return this.this$0.new a();
        }
    });
    private int maxCount;

    @Nullable
    private Function1<? super ChannelAdminBean, Unit> onSetCallback;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog$a;", "", "Landroid/view/View;", "view", "", "d", "e", "c", "", "memberUserCode", "b", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "f", "<init>", "(Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void g(AddSubAdminDialog addSubAdminDialog, ChannelMemberBean channelMemberBean, int i, View view) {
            Intrinsics.checkNotNullParameter(addSubAdminDialog, "this$0");
            Intrinsics.checkNotNullParameter(channelMemberBean, "$bean");
            AddSubAdminVM addSubAdminVMAccess$getMViewModel = AddSubAdminDialog.access$getMViewModel(addSubAdminDialog);
            String channelNo = addSubAdminDialog.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            addSubAdminVMAccess$getMViewModel.k(channelNo, channelMemberBean, i);
        }

        public final void b(@NotNull String memberUserCode) {
            Intrinsics.checkNotNullParameter(memberUserCode, "memberUserCode");
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", memberUserCode).navigation();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AddSubAdminDialog.access$getMViewModel(AddSubAdminDialog.this).n().setValue("");
            AddSubAdminVM addSubAdminVMAccess$getMViewModel = AddSubAdminDialog.access$getMViewModel(AddSubAdminDialog.this);
            String channelNo = AddSubAdminDialog.this.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            addSubAdminVMAccess$getMViewModel.p(channelNo);
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AddSubAdminDialog.this.dismiss();
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AddSubAdminVM addSubAdminVMAccess$getMViewModel = AddSubAdminDialog.access$getMViewModel(AddSubAdminDialog.this);
            String channelNo = AddSubAdminDialog.this.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            addSubAdminVMAccess$getMViewModel.p(channelNo);
        }

        public final void f(@NotNull final ChannelMemberBean bean, final int position) {
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            if (AddSubAdminDialog.this.maxCount <= 0) {
                fv5.b(AddSubAdminDialog.this.getString(R.string.channel_manage_channel_member_limit));
                return;
            }
            Context contextRequireContext = AddSubAdminDialog.this.requireContext();
            String string = AddSubAdminDialog.this.getString(R.string.channel_manage_add_sub_admin_confirm);
            final AddSubAdminDialog addSubAdminDialog = AddSubAdminDialog.this;
            ft1.p(contextRequireContext, string, new View.OnClickListener() { // from class: com.zj.adlib.p10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddSubAdminDialog.a.g(addSubAdminDialog, bean, position, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog$b;", "", "", "channelNo", "", "maxCount", "Lkotlin/Function1;", "Lcom/huachenjie/channel/bean/ChannelAdminBean;", "", "onSetCallback", "Lcom/huachenjie/channel/page/manage_channel/admin/add/AddSubAdminDialog;", "a", "CHANNEL_NO", "Ljava/lang/String;", "MAX_COUNT", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AddSubAdminDialog a(@NotNull String channelNo, int maxCount, @NotNull Function1<? super ChannelAdminBean, Unit> onSetCallback) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(onSetCallback, "onSetCallback");
            AddSubAdminDialog addSubAdminDialog = new AddSubAdminDialog();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            bundle.putInt(AddSubAdminDialog.MAX_COUNT, maxCount);
            addSubAdminDialog.setArguments(bundle);
            addSubAdminDialog.onSetCallback = onSetCallback;
            return addSubAdminDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33422a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33422a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33422a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33422a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ AddSubAdminVM access$getMViewModel(AddSubAdminDialog addSubAdminDialog) {
        return (AddSubAdminVM) addSubAdminDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final a getClickProxy() {
        return (a) this.clickProxy.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<AddSubAdminAdapter> mutableLiveDataL = ((AddSubAdminVM) getMViewModel()).l();
        final AddSubAdminAdapter addSubAdminAdapter = new AddSubAdminAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R….layout_empty_work, null)");
        addSubAdminAdapter.setEmptyView(viewInflate);
        addSubAdminAdapter.addChildClickViewIds(R.id.iv_avatar, R.id.tv_btn);
        y57.b(addSubAdminAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.n10
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AddSubAdminDialog.initAdapter$lambda$2$lambda$0(addSubAdminAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        addSubAdminAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.o10
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AddSubAdminDialog.initAdapter$lambda$2$lambda$1(this.f43645a);
            }
        });
        mutableLiveDataL.setValue(addSubAdminAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$0(AddSubAdminAdapter addSubAdminAdapter, AddSubAdminDialog addSubAdminDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(addSubAdminAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(addSubAdminDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        ChannelMemberBean item = addSubAdminAdapter.getItem(i);
        int id = view.getId();
        if (id == R.id.iv_avatar) {
            addSubAdminDialog.getClickProxy().b(item.getMemberUserCode());
        } else if (id == R.id.tv_btn) {
            addSubAdminDialog.getClickProxy().f(item, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$2$lambda$1(AddSubAdminDialog addSubAdminDialog) {
        Intrinsics.checkNotNullParameter(addSubAdminDialog, "this$0");
        AddSubAdminVM addSubAdminVM = (AddSubAdminVM) addSubAdminDialog.getMViewModel();
        String channelNo = addSubAdminDialog.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        addSubAdminVM.o(channelNo);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_dialog_add_sub_admin;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), getClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        Bundle arguments = getArguments();
        this.maxCount = arguments != null ? arguments.getInt(MAX_COUNT) : 0;
        AddSubAdminVM addSubAdminVM = (AddSubAdminVM) getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        addSubAdminVM.o(channelNo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        ((AddSubAdminVM) getMViewModel()).m().observe(this, new c(new Function1<ChannelMemberBean, Unit>() { // from class: com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChannelMemberBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChannelMemberBean channelMemberBean) {
                if (channelMemberBean == null) {
                    return;
                }
                Function1 function1 = AddSubAdminDialog.this.onSetCallback;
                if (function1 != null) {
                    function1.invoke(new ChannelAdminBean(channelMemberBean.getAvatar(), channelMemberBean.getNickName(), channelMemberBean.getMemberUserCode(), channelMemberBean.getSlogan(), channelMemberBean.getAvatarFrameImgUrl(), true));
                }
                AddSubAdminDialog.this.maxCount--;
                fv5.b(AddSubAdminDialog.this.getString(R.string.channel_manage_channel_member_success));
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
    }
}
