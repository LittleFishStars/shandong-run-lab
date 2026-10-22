package com.huachenjie.social_contact.page.suit;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.IPBean;
import com.huachenjie.social_contact.page.suit.UserWearIPFragment;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearIPFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/social_contact/page/suit/UserWearIPVM;", "", "initAdapter", "Lcom/huachenjie/social_contact/bean/IPBean;", "suit", "changeSuit", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearIPFragment extends BaseVMFragment<UserWearIPVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.suit.UserWearIPFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearIPFragment$a;", "", "Lcom/huachenjie/social_contact/page/suit/UserWearIPFragment;", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserWearIPFragment a() {
            return new UserWearIPFragment();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36308a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36308a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36308a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36308a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSuit(IPBean suit) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).r0(1, suit.getMetaverseModelCode(), null);
    }

    private final void initAdapter() {
        UserWearIPAdapter value = ((UserWearIPVM) ((BaseVMFragment) this).mState).i().getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tvWear);
        }
        UserWearIPAdapter value2 = ((UserWearIPVM) ((BaseVMFragment) this).mState).i().getValue();
        if (value2 != null) {
            value2.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ti9
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearIPFragment.initAdapter$lambda$0(this.f44932a, baseQuickAdapter, view, i);
                }
            });
        }
        UserWearIPAdapter value3 = ((UserWearIPVM) ((BaseVMFragment) this).mState).i().getValue();
        if (value3 != null) {
            value3.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ui9
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearIPFragment.initAdapter$lambda$1(this.f45155a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$0(UserWearIPFragment userWearIPFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearIPFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.IPBean");
        IPBean iPBean = (IPBean) item;
        if (iPBean.getHaveFlag()) {
            return;
        }
        userWearIPFragment.changeSuit(iPBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1(UserWearIPFragment userWearIPFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearIPFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.IPBean");
        IPBean iPBean = (IPBean) item;
        if (!iPBean.getCheckedFlag() && iPBean.getHaveFlag()) {
            ((UserWearIPVM) ((BaseVMFragment) userWearIPFragment).mState).h(iPBean);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_user_wear_ip), Integer.valueOf(nk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initAdapter();
        ((UserWearIPVM) ((BaseVMFragment) this).mState).j();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((UserWearIPVM) ((BaseVMFragment) this).mState).k().observe(this, new b(new Function1<IPBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearIPFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IPBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IPBean iPBean) {
                if (iPBean != null) {
                    UserWearIPFragment.this.changeSuit(iPBean);
                }
            }
        }));
    }
}
