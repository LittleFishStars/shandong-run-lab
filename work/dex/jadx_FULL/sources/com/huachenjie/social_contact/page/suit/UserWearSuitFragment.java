package com.huachenjie.social_contact.page.suit;

import android.os.Bundle;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.SuitDataBean;
import com.huachenjie.social_contact.databinding.FragmentUserWearSuitBinding;
import com.igexin.push.g.o;
import com.zj.adlib.bw9;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initView", "initViewModel", "onDestroyView", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitPageAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/huachenjie/social_contact/page/suit/UserWearSuitPageAdapter;", "mAdapter", "Lcom/google/android/material/tabs/TabLayoutMediator;", "tabLayoutMediator$delegate", "getTabLayoutMediator", "()Lcom/google/android/material/tabs/TabLayoutMediator;", "tabLayoutMediator", "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearSuitFragment extends BaseVMDialogFragment<UserWearSuitVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CODE = "metaverse_model_code";

    /* JADX INFO: renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0<UserWearSuitPageAdapter>() { // from class: com.huachenjie.social_contact.page.suit.UserWearSuitFragment$mAdapter$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserWearSuitPageAdapter m764invoke() {
            return new UserWearSuitPageAdapter(this.this$0);
        }
    });

    /* JADX INFO: renamed from: tabLayoutMediator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabLayoutMediator = LazyKt.lazy(new UserWearSuitFragment$tabLayoutMediator$2(this));

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.suit.UserWearSuitFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitFragment$a;", "", "", "metaverseModelCode", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitFragment;", "a", "KEY_CODE", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserWearSuitFragment a(@NotNull String metaverseModelCode) {
            Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
            Bundle bundle = new Bundle();
            bundle.putString(UserWearSuitFragment.KEY_CODE, metaverseModelCode);
            UserWearSuitFragment userWearSuitFragment = new UserWearSuitFragment();
            userWearSuitFragment.setArguments(bundle);
            return userWearSuitFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36312a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36312a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36312a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36312a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserWearSuitPageAdapter getMAdapter() {
        return (UserWearSuitPageAdapter) this.mAdapter.getValue();
    }

    private final TabLayoutMediator getTabLayoutMediator() {
        return (TabLayoutMediator) this.tabLayoutMediator.getValue();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_user_wear_suit), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        String string;
        initView();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(KEY_CODE)) == null) {
            return;
        }
        ((UserWearSuitVM) ((BaseVMDialogFragment) this).mState).i(string);
    }

    public final void initView() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.FragmentUserWearSuitBinding");
        FragmentUserWearSuitBinding fragmentUserWearSuitBinding = (FragmentUserWearSuitBinding) binding;
        fragmentUserWearSuitBinding.f36167a.setOffscreenPageLimit(1);
        bw9 bw9Var = bw9.f40853a;
        ViewPager2 viewPager2 = fragmentUserWearSuitBinding.f36167a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        bw9Var.g(viewPager2);
        fragmentUserWearSuitBinding.f36167a.setAdapter(getMAdapter());
        getTabLayoutMediator().attach();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        MutableLiveData<List<SuitDataBean>> mutableLiveDataH;
        UserWearSuitVM userWearSuitVM = (UserWearSuitVM) ((BaseVMDialogFragment) this).mState;
        if (userWearSuitVM == null || (mutableLiveDataH = userWearSuitVM.h()) == null) {
            return;
        }
        mutableLiveDataH.observe(this, new b(new Function1<List<? extends SuitDataBean>, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearSuitFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<SuitDataBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<SuitDataBean> list) {
                UserWearSuitPageAdapter mAdapter = UserWearSuitFragment.this.getMAdapter();
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                mAdapter.e(list);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FragmentUserWearSuitBinding fragmentUserWearSuitBinding = (FragmentUserWearSuitBinding) getBinding();
        if (fragmentUserWearSuitBinding != null) {
            getTabLayoutMediator().detach();
            fragmentUserWearSuitBinding.f36167a.setAdapter(null);
        }
        super.onDestroyView();
    }
}
