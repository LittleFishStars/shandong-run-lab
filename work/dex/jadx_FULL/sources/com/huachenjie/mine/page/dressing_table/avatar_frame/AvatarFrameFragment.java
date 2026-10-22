package com.huachenjie.mine.page.dressing_table.avatar_frame;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.bean.UnlockMode;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.mine.R;
import com.huachenjie.mine.bean.AvatarFrameBean;
import com.huachenjie.mine.databinding.MineFragmentAvatarFrameBinding;
import com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.ik0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentAvatarFrameBinding;", "Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameVM;", "", "initAdapter", "Lcom/huachenjie/mine/bean/AvatarFrameBean;", "item", "unlockFreeTheme", "unlockTheme", "", "", "getVariables", "getLayoutResID", "initView", "initDataObservable", "", "isVisibleToUser", "setUserVisibleHint", "Lkotlin/Function1;", "", "onAvatarFrameChanged", "Lkotlin/jvm/functions/Function1;", "hasInitData", "Z", "<init>", "()V", "Companion", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class AvatarFrameFragment extends BaseMVVMFragment<MineFragmentAvatarFrameBinding, AvatarFrameVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasInitData;

    @Nullable
    private Function1<? super String, Unit> onAvatarFrameChanged;

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameFragment$a;", "", "Lkotlin/Function1;", "", "", "onAvatarFrameChanged", "Lcom/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameFragment;", "a", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarFrameFragment a(@NotNull Function1<? super String, Unit> onAvatarFrameChanged) {
            Intrinsics.checkNotNullParameter(onAvatarFrameChanged, "onAvatarFrameChanged");
            AvatarFrameFragment avatarFrameFragment = new AvatarFrameFragment();
            avatarFrameFragment.onAvatarFrameChanged = onAvatarFrameChanged;
            return avatarFrameFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35371a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35371a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35371a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35371a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameFragment$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarFrameBean f35372a;

        public c(AvatarFrameBean avatarFrameBean) {
            this.f35372a = avatarFrameBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            AvatarFrameFragment.access$getMViewModel(AvatarFrameFragment.this).p(this.f35372a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/mine/page/dressing_table/avatar_frame/AvatarFrameFragment$d", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogUtil.PositiveNegativeClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarFrameBean f35373a;

        public d(AvatarFrameBean avatarFrameBean) {
            this.f35373a = avatarFrameBean;
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            AvatarFrameFragment.access$getMViewModel(AvatarFrameFragment.this).p(this.f35373a);
        }
    }

    public static final /* synthetic */ AvatarFrameVM access$getMViewModel(AvatarFrameFragment avatarFrameFragment) {
        return avatarFrameFragment.getMViewModel();
    }

    private final void initAdapter() {
        MutableLiveData<AvatarFrameAdapter> mutableLiveDataK = getMViewModel().k();
        final AvatarFrameAdapter avatarFrameAdapter = new AvatarFrameAdapter();
        avatarFrameAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.qi0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AvatarFrameFragment.initAdapter$lambda$1$lambda$0(avatarFrameAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataK.setValue(avatarFrameAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(AvatarFrameAdapter avatarFrameAdapter, AvatarFrameFragment avatarFrameFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(avatarFrameAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(avatarFrameFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        AvatarFrameBean item = avatarFrameAdapter.getItem(i);
        if (item.getWearFlag()) {
            avatarFrameFragment.getMViewModel().i(item);
            return;
        }
        if (item.getUnlockFlag()) {
            avatarFrameFragment.getMViewModel().j(item);
        } else {
            if (item.getFreeFlag() == 2) {
                return;
            }
            if (item.getFreeFlag() == 1) {
                avatarFrameFragment.unlockFreeTheme(item);
            } else {
                avatarFrameFragment.unlockTheme(item);
            }
        }
    }

    private final void unlockFreeTheme(AvatarFrameBean item) {
        DialogUtil.z(getActivity(), "提示", "是否免费领取该头像框？", "我再想想", "确定", new c(item));
    }

    private final void unlockTheme(AvatarFrameBean item) {
        int value;
        UnlockMode unlockingModeDOS = item.getUnlockingModeDOS();
        String str = "世界水晶";
        if (unlockingModeDOS != null) {
            int type = unlockingModeDOS.getType();
            if (type != 1) {
                if (type == 2) {
                    str = "星空钻";
                } else if (type == 3) {
                    str = "皮肤券";
                }
            }
            value = unlockingModeDOS.getValue();
        } else {
            value = 0;
        }
        DialogUtil.z(getActivity(), "提示", "您确定花费" + value + str + "解锁该头像框吗？", "我再想想", "确定", new d(item));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_avatar_frame;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, AvatarFrameVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().l().observe(this, new b(new Function1<AvatarFrameBean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AvatarFrameBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AvatarFrameBean avatarFrameBean) {
                if (avatarFrameBean == null) {
                    return;
                }
                fv5.b("头像框已卸下");
                Function1 function1 = AvatarFrameFragment.this.onAvatarFrameChanged;
                if (function1 != null) {
                    function1.invoke("");
                }
            }
        }));
        getMViewModel().n().observe(this, new b(new Function1<AvatarFrameBean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AvatarFrameBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AvatarFrameBean avatarFrameBean) {
                Function1 function1;
                if (avatarFrameBean == null || (function1 = AvatarFrameFragment.this.onAvatarFrameChanged) == null) {
                    return;
                }
                function1.invoke(avatarFrameBean.getAvatarFrameImgUrl());
            }
        }));
        getMViewModel().m().observe(this, new b(new Function1<AvatarFrameBean, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment.initDataObservable.3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AvatarFrameBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AvatarFrameBean avatarFrameBean) {
                if (avatarFrameBean == null) {
                    return;
                }
                fv5.b("解锁成功");
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser || this.hasInitData) {
            return;
        }
        this.hasInitData = true;
        getMViewModel().o();
    }
}
