package com.huachenjie.social_contact.page.suit;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.SuitBean;
import com.huachenjie.social_contact.databinding.FragmentUserWearSuitListBinding;
import com.huachenjie.social_contact.page.suit.UserWearSuitListFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0014J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitListFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitListVM;", "", "initAdapter", "Lcom/huachenjie/social_contact/bean/SuitBean;", "item", "unlockSuit", "unlockFreeSuit", "suit", "changeSuit", "cancelSuitPart", "", "crystal", "starDrill", "skinVoucher", "", "canBuy", "changeAssetsValue", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "onDestroyView", "partType", "I", "", "partList", "Ljava/util/List;", "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearSuitListFragment extends BaseVMFragment<UserWearSuitListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String PART_LIST = "part_list";

    @NotNull
    private static final String PART_TYPE = "part_type";

    @NotNull
    private List<SuitBean> partList = new ArrayList();
    private int partType;

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.suit.UserWearSuitListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitListFragment$a;", "", "", "partType", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/SuitBean;", "Lkotlin/collections/ArrayList;", "partList", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitListFragment;", "a", "", "PART_LIST", "Ljava/lang/String;", "PART_TYPE", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserWearSuitListFragment a(int partType, @NotNull ArrayList<SuitBean> partList) {
            Intrinsics.checkNotNullParameter(partList, "partList");
            Bundle bundle = new Bundle();
            bundle.putInt(UserWearSuitListFragment.PART_TYPE, partType);
            bundle.putParcelableArrayList(UserWearSuitListFragment.PART_LIST, partList);
            UserWearSuitListFragment userWearSuitListFragment = new UserWearSuitListFragment();
            userWearSuitListFragment.setArguments(bundle);
            return userWearSuitListFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36313a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36313a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36313a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36313a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitListFragment$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuitBean f36314a;

        public c(SuitBean suitBean) {
            this.f36314a = suitBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            ((UserWearSuitListVM) ((BaseVMFragment) UserWearSuitListFragment.this).mState).n(this.f36314a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitListFragment$d", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuitBean f36315a;

        public d(SuitBean suitBean) {
            this.f36315a = suitBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            if (UserWearSuitListFragment.this.canBuy(this.f36315a.getCrystalValue(), this.f36315a.getStarDrill(), this.f36315a.getSkinVoucher())) {
                ((UserWearSuitListVM) ((BaseVMFragment) UserWearSuitListFragment.this).mState).n(this.f36315a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canBuy(int crystal, int starDrill, int skinVoucher) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return false;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        return ((UserWearActivity) activity).m0(crystal, starDrill, skinVoucher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelSuitPart() {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).n0(this.partType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeAssetsValue(int crystal, int starDrill, int skinVoucher) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).o0(crystal, starDrill, skinVoucher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSuit(SuitBean suit) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).r0(2, suit.getMetaverseSuitCode(), Integer.valueOf(this.partType));
    }

    private final void initAdapter() {
        UserWearSuitAdapter value = ((UserWearSuitListVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tvWear);
        }
        UserWearSuitAdapter value2 = ((UserWearSuitListVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value2 != null) {
            value2.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.vi9
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearSuitListFragment.initAdapter$lambda$1(this.f45362a, baseQuickAdapter, view, i);
                }
            });
        }
        UserWearSuitAdapter value3 = ((UserWearSuitListVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value3 != null) {
            value3.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.wi9
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearSuitListFragment.initAdapter$lambda$2(this.f45605a, baseQuickAdapter, view, i);
                }
            });
        }
        UserWearSuitAdapter value4 = ((UserWearSuitListVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value4 != null) {
            value4.setList(this.partList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1(UserWearSuitListFragment userWearSuitListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearSuitListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.SuitBean");
        SuitBean suitBean = (SuitBean) item;
        if (suitBean.getHaveFlag()) {
            return;
        }
        userWearSuitListFragment.changeSuit(suitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2(UserWearSuitListFragment userWearSuitListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearSuitListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.SuitBean");
        SuitBean suitBean = (SuitBean) item;
        if (suitBean.getCheckedFlag()) {
            ((UserWearSuitListVM) ((BaseVMFragment) userWearSuitListFragment).mState).h(suitBean);
            return;
        }
        if (suitBean.getHaveFlag()) {
            ((UserWearSuitListVM) ((BaseVMFragment) userWearSuitListFragment).mState).i(suitBean);
            return;
        }
        int freeFlag = suitBean.getFreeFlag();
        if (freeFlag == 1) {
            userWearSuitListFragment.unlockFreeSuit(suitBean);
        } else if (freeFlag != 3) {
            userWearSuitListFragment.unlockSuit(suitBean);
        }
    }

    private final void unlockFreeSuit(SuitBean item) {
        String str;
        int i = this.partType;
        if (i == 1) {
            str = "确定免费解锁该发型吗？";
        } else if (i == 2) {
            str = "确定免费解锁该表情吗？";
        } else if (i != 3) {
            str = i != 4 ? "确定免费解锁该套装吗？" : "确定免费解锁该鞋吗？";
        } else {
            str = "确定免费解锁该服装吗？";
        }
        DialogUtil.z(getActivity(), "提示", str, OptionsPickerHelper.e, "确定", new c(item));
    }

    private final void unlockSuit(SuitBean item) {
        String str;
        int i = this.partType;
        if (i == 1) {
            str = "确定解锁该发型吗？";
        } else if (i == 2) {
            str = "确定解锁该表情吗？";
        } else if (i != 3) {
            str = i != 4 ? "确定解锁该套装吗？" : "确定解锁该鞋吗？";
        } else {
            str = "确定解锁该服装吗？";
        }
        DialogUtil.z(getActivity(), "提示", str, OptionsPickerHelper.e, "确定", new d(item));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_user_wear_suit_list), Integer.valueOf(nk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.partType = arguments.getInt(PART_TYPE);
            ArrayList parcelableArrayList = arguments.getParcelableArrayList(PART_LIST);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList();
            }
            this.partList = parcelableArrayList;
        }
        initAdapter();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((UserWearSuitListVM) ((BaseVMFragment) this).mState).l().observe(this, new b(new Function1<SuitBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearSuitListFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SuitBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SuitBean suitBean) {
                if (suitBean != null) {
                    UserWearSuitListFragment userWearSuitListFragment = UserWearSuitListFragment.this;
                    fv5.b("解锁成功");
                    userWearSuitListFragment.changeAssetsValue(suitBean.getCrystalValue(), suitBean.getStarDrill(), suitBean.getSkinVoucher());
                }
            }
        }));
        ((UserWearSuitListVM) ((BaseVMFragment) this).mState).m().observe(this, new b(new Function1<SuitBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearSuitListFragment.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SuitBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SuitBean suitBean) {
                if (suitBean != null) {
                    UserWearSuitListFragment.this.changeSuit(suitBean);
                }
            }
        }));
        ((UserWearSuitListVM) ((BaseVMFragment) this).mState).k().observe(this, new b(new Function1<SuitBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearSuitListFragment.initViewModel.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SuitBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SuitBean suitBean) {
                int i = UserWearSuitListFragment.this.partType;
                if (i == 1) {
                    fv5.b("发型已卸下");
                } else if (i == 2) {
                    fv5.b("表情已卸下");
                } else if (i == 3) {
                    fv5.b("服装已卸下");
                } else if (i != 4) {
                    fv5.b("模型已卸下");
                } else {
                    fv5.b("鞋已卸下");
                }
                UserWearSuitListFragment.this.cancelSuitPart();
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FragmentUserWearSuitListBinding fragmentUserWearSuitListBinding = (FragmentUserWearSuitListBinding) getBinding();
        if (fragmentUserWearSuitListBinding != null) {
            fragmentUserWearSuitListBinding.f36169a.setAdapter(null);
        }
        super.onDestroyView();
    }
}
