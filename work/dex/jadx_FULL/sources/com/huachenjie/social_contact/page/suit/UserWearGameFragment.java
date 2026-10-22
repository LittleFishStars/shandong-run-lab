package com.huachenjie.social_contact.page.suit;

import android.content.Context;
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
import com.huachenjie.social_contact.bean.AttributeBean;
import com.huachenjie.social_contact.bean.GameBean;
import com.huachenjie.social_contact.page.suit.UserWearGameFragment;
import com.zj.adlib.fv5;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0014R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGameFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/social_contact/page/suit/UserWearGameVM;", "", "initAdapter", "Lcom/huachenjie/social_contact/bean/GameBean;", "item", "unlockSuit", "unlockFreeSuit", "suit", "changeSuit", "", "crystal", "starDrill", "skinVoucher", "", "canBuy", "changeAssetsValue", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow;", "mPopupWindow$delegate", "Lkotlin/Lazy;", "getMPopupWindow", "()Lcom/huachenjie/social_contact/page/suit/UserWearGamePopupWindow;", "mPopupWindow", "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearGameFragment extends BaseVMFragment<UserWearGameVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: mPopupWindow$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPopupWindow = LazyKt.lazy(new Function0<UserWearGamePopupWindow>() { // from class: com.huachenjie.social_contact.page.suit.UserWearGameFragment$mPopupWindow$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserWearGamePopupWindow m763invoke() {
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            return new UserWearGamePopupWindow(contextRequireContext);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.suit.UserWearGameFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGameFragment$a;", "", "Lcom/huachenjie/social_contact/page/suit/UserWearGameFragment;", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserWearGameFragment a() {
            return new UserWearGameFragment();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36300a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36300a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36300a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36300a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearGameFragment$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameBean f36301a;

        public c(GameBean gameBean) {
            this.f36301a = gameBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            ((UserWearGameVM) ((BaseVMFragment) UserWearGameFragment.this).mState).l(this.f36301a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearGameFragment$d", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameBean f36302a;

        public d(GameBean gameBean) {
            this.f36302a = gameBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            if (UserWearGameFragment.this.canBuy(this.f36302a.crystalValue(), this.f36302a.starDrill(), this.f36302a.skinVoucher())) {
                ((UserWearGameVM) ((BaseVMFragment) UserWearGameFragment.this).mState).l(this.f36302a);
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
    public final void changeAssetsValue(int crystal, int starDrill, int skinVoucher) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).o0(crystal, starDrill, skinVoucher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSuit(GameBean suit) {
        if (getActivity() == null || !(getActivity() instanceof UserWearActivity)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.social_contact.page.suit.UserWearActivity");
        ((UserWearActivity) activity).r0(3, suit.getMetaverseModelCode(), null);
    }

    private final UserWearGamePopupWindow getMPopupWindow() {
        return (UserWearGamePopupWindow) this.mPopupWindow.getValue();
    }

    private final void initAdapter() {
        UserWearGameAdapter value = ((UserWearGameVM) ((BaseVMFragment) this).mState).h().getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tvWear);
        }
        UserWearGameAdapter value2 = ((UserWearGameVM) ((BaseVMFragment) this).mState).h().getValue();
        if (value2 != null) {
            value2.addChildClickViewIds(R.id.ivAttributeInfo);
        }
        UserWearGameAdapter value3 = ((UserWearGameVM) ((BaseVMFragment) this).mState).h().getValue();
        if (value3 != null) {
            value3.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ri9
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearGameFragment.initAdapter$lambda$0(this.f44465a, baseQuickAdapter, view, i);
                }
            });
        }
        UserWearGameAdapter value4 = ((UserWearGameVM) ((BaseVMFragment) this).mState).h().getValue();
        if (value4 != null) {
            value4.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.si9
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserWearGameFragment.initAdapter$lambda$1(this.f44698a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$0(UserWearGameFragment userWearGameFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearGameFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.GameBean");
        GameBean gameBean = (GameBean) item;
        int id = view.getId();
        if (id == R.id.tvWear) {
            if (gameBean.getUnlockFlag()) {
                return;
            }
            userWearGameFragment.changeSuit(gameBean);
        } else if (id == R.id.ivAttributeInfo) {
            UserWearGamePopupWindow mPopupWindow = userWearGameFragment.getMPopupWindow();
            List<AttributeBean> attributeList = gameBean.getAttributeList();
            Intrinsics.checkNotNull(attributeList);
            mPopupWindow.b(view, attributeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1(UserWearGameFragment userWearGameFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(userWearGameFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.GameBean");
        GameBean gameBean = (GameBean) item;
        if (gameBean.getWearFlag()) {
            return;
        }
        if (gameBean.getUnlockFlag()) {
            ((UserWearGameVM) ((BaseVMFragment) userWearGameFragment).mState).m(gameBean);
            return;
        }
        int freeFlag = gameBean.getFreeFlag();
        if (freeFlag == 1) {
            userWearGameFragment.unlockFreeSuit(gameBean);
        } else if (freeFlag != 3) {
            userWearGameFragment.unlockSuit(gameBean);
        }
    }

    private final void unlockFreeSuit(GameBean item) {
        DialogUtil.z(getActivity(), "提示", "确定免费解锁该GAME ICON吗？", OptionsPickerHelper.e, "确定", new c(item));
    }

    private final void unlockSuit(GameBean item) {
        DialogUtil.z(getActivity(), "提示", "确定解锁该GAME ICON吗？", OptionsPickerHelper.e, "确定", new d(item));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_user_wear_game), Integer.valueOf(nk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        initAdapter();
        ((UserWearGameVM) ((BaseVMFragment) this).mState).k();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((UserWearGameVM) ((BaseVMFragment) this).mState).j().observe(this, new b(new Function1<GameBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearGameFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GameBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GameBean gameBean) {
                if (gameBean != null) {
                    UserWearGameFragment.this.changeSuit(gameBean);
                }
            }
        }));
        ((UserWearGameVM) ((BaseVMFragment) this).mState).i().observe(this, new b(new Function1<GameBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearGameFragment.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GameBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GameBean gameBean) {
                if (gameBean != null) {
                    UserWearGameFragment userWearGameFragment = UserWearGameFragment.this;
                    fv5.b("解锁成功");
                    userWearGameFragment.changeAssetsValue(gameBean.crystalValue(), gameBean.starDrill(), gameBean.skinVoucher());
                }
            }
        }));
    }
}
