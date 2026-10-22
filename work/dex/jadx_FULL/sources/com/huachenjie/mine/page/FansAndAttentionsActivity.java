package com.huachenjie.mine.page;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.dialog.NotifyFansMenuDialog;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mine.R;
import com.huachenjie.mine.adapter.FansAndAttentionsAdapter;
import com.huachenjie.mine.databinding.MineActivityFansOrAttentionsBinding;
import com.huachenjie.mine.page.FansAndAttentionsActivity;
import com.huachenjie.mine.page.FansAndAttentionsModel;
import com.igexin.push.g.o;
import com.zj.adlib.ik0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b \u0010!J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/huachenjie/mine/page/FansAndAttentionsActivity;", "Lcom/huachenjie/mine/page/FansAndAttentionsModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mine/databinding/MineActivityFansOrAttentionsBinding;", "", "", "", "V", "getLayoutResID", "Ljava/lang/Class;", "getViewModelClass", "", "initView", "", "h0", "Lcom/huachenjie/mine/adapter/FansAndAttentionsAdapter;", "f0", "appUserCode", "o0", "initData", "i0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "b", "Lkotlin/Lazy;", "g0", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public abstract class FansAndAttentionsActivity<VM extends FansAndAttentionsModel> extends BaseMVVMActivity<MineActivityFansOrAttentionsBinding, VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.wd3
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            FansAndAttentionsActivity.n0(this.f45574a);
        }
    };

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>(this) { // from class: com.huachenjie.mine.page.FansAndAttentionsActivity$stateView$2
        final /* synthetic */ FansAndAttentionsActivity<VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m589invoke() {
            SwipeRefreshLayout swipeRefreshLayout = this.this$0.getMBinding().f11184a;
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "mBinding.refreshLayout");
            return StateUtilsKt.b(swipeRefreshLayout);
        }
    });

    public static final void j0(FansAndAttentionsActivity fansAndAttentionsActivity, View view) {
        Intrinsics.checkNotNullParameter(fansAndAttentionsActivity, "this$0");
        fansAndAttentionsActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k0(FansAndAttentionsActivity fansAndAttentionsActivity) {
        Intrinsics.checkNotNullParameter(fansAndAttentionsActivity, "this$0");
        BaseStateRequestModel.x((BaseStateRequestModel) fansAndAttentionsActivity.getMViewModel(), false, 1, null);
    }

    public static final void l0(FansAndAttentionsAdapter fansAndAttentionsAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(fansAndAttentionsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", fansAndAttentionsAdapter.getData().get(i).getAppUserCode()).navigation();
    }

    public static final void m0(FansAndAttentionsAdapter fansAndAttentionsAdapter, final FansAndAttentionsActivity fansAndAttentionsActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(fansAndAttentionsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(fansAndAttentionsActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        FansBean fansBean = fansAndAttentionsAdapter.getData().get(i);
        if (view.getId() == R.id.iv_menu) {
            NotifyFansMenuDialog notifyFansMenuDialogA = NotifyFansMenuDialog.INSTANCE.a(fansBean);
            notifyFansMenuDialogA.setOnUnfollowFriendCallback(new Function1<String, Unit>(fansAndAttentionsActivity) { // from class: com.huachenjie.mine.page.FansAndAttentionsActivity$initView$1$3$1$1
                final /* synthetic */ FansAndAttentionsActivity<VM> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = fansAndAttentionsActivity;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    this.this$0.o0(str);
                }
            });
            FragmentManager supportFragmentManager = fansAndAttentionsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            notifyFansMenuDialogA.show(supportFragmentManager, NotifyFansMenuDialog.class.getSimpleName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n0(FansAndAttentionsActivity fansAndAttentionsActivity) {
        Intrinsics.checkNotNullParameter(fansAndAttentionsActivity, "this$0");
        ((FansAndAttentionsModel) fansAndAttentionsActivity.getMViewModel()).y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.R), this.onRefreshListener)});
    }

    @NotNull
    public abstract FansAndAttentionsAdapter f0();

    public final StateLayout g0() {
        return (StateLayout) this.stateView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_activity_fans_or_attentions;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Class<VM> getViewModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huachenjie.mine.page.FansAndAttentionsActivity>");
        return (Class) type;
    }

    @NotNull
    public abstract String h0();

    public final void i0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(h0()).setTitleTextColor(zn1.a(com.huachenjie.channel.R.color.color_2C3E50)).setBackIconResId(com.huachenjie.channel.R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FansAndAttentionsActivity.j0(this.f45797a, view);
            }
        }).setShowDivider(true));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().v().setValue(Boolean.TRUE);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        i0();
        RecyclerView.ItemAnimator itemAnimator = getMBinding().f35290a.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        MutableLiveData<FansAndAttentionsAdapter> mutableLiveDataB = getMViewModel().B();
        final FansAndAttentionsAdapter fansAndAttentionsAdapterF0 = f0();
        BaseStateRequestModel.p(getMViewModel(), this, g0(), fansAndAttentionsAdapterF0, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, fansAndAttentionsAdapterF0, false, 4, null);
        fansAndAttentionsAdapterF0.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.yd3
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                FansAndAttentionsActivity.k0(this.f46003a);
            }
        });
        y57.d(fansAndAttentionsAdapterF0, 0L, new OnItemClickListener() { // from class: com.zj.adlib.zd3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FansAndAttentionsActivity.l0(fansAndAttentionsAdapterF0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        fansAndAttentionsAdapterF0.addChildClickViewIds(R.id.iv_menu);
        y57.b(fansAndAttentionsAdapterF0, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.ae3
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FansAndAttentionsActivity.m0(fansAndAttentionsAdapterF0, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(fansAndAttentionsAdapterF0);
    }

    public void o0(@NotNull String appUserCode) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
    }
}
