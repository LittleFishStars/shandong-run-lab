package com.huachenjie.channel.page.notify.base;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityNotifyNextBinding;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextModel;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.rk0;
import com.zj.adlib.zn1;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b!\u0010\"J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0017J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013H&J\b\u0010\u0015\u001a\u00020\fH\u0017J\b\u0010\u0016\u001a\u00020\fH\u0002R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextActivity;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityNotifyNextBinding;", "", "", "", "V", "getLayoutResID", "Ljava/lang/Class;", "getViewModelClass", "", "initView", "Lcom/huachenjie/common/bean/BindingTitleBean;", "titleBean", "k0", "", "f0", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "d0", "initData", "g0", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "b", "Lkotlin/Lazy;", "e0", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseNotifyNextActivity<VM extends BaseNotifyNextModel> extends BaseMVVMActivity<ChannelActivityNotifyNextBinding, VM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>(this) { // from class: com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity$stateView$2
        final /* synthetic */ BaseNotifyNextActivity<VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m300invoke() {
            SwipeRefreshLayout swipeRefreshLayout = this.this$0.getMBinding().f7611a;
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "mBinding.refreshLayout");
            StateLayout stateLayoutB = StateUtilsKt.b(swipeRefreshLayout);
            stateLayoutB.setEmptyLabel(this.this$0.getString(R.string.channel_notify_empty));
            return stateLayoutB;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.nq0
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            BaseNotifyNextActivity.j0(this.f43587a);
        }
    };

    public static final void h0(BaseNotifyNextActivity baseNotifyNextActivity, View view) {
        Intrinsics.checkNotNullParameter(baseNotifyNextActivity, "this$0");
        baseNotifyNextActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i0(BaseNotifyNextActivity baseNotifyNextActivity) {
        Intrinsics.checkNotNullParameter(baseNotifyNextActivity, "this$0");
        BaseStateRequestModel.x((BaseStateRequestModel) baseNotifyNextActivity.getMViewModel(), false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j0(BaseNotifyNextActivity baseNotifyNextActivity) {
        Intrinsics.checkNotNullParameter(baseNotifyNextActivity, "this$0");
        ((BaseNotifyNextModel) baseNotifyNextActivity.getMViewModel()).y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(rk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(rk0.R), this.onRefreshListener)});
    }

    @NotNull
    public abstract BaseQuickAdapter<?, ?> d0();

    public final StateLayout e0() {
        return (StateLayout) this.stateView.getValue();
    }

    @NotNull
    public abstract String f0();

    public final void g0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean showDivider = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(f0()).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.mq0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseNotifyNextActivity.h0(this.f43362a, view);
            }
        }).setShowDivider(true);
        Intrinsics.checkNotNullExpressionValue(showDivider, "this");
        k0(showDivider);
        mutableLiveDataI.setValue(showDivider);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_notify_next;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Class<VM> getViewModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity>");
        return (Class) type;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @CallSuper
    public void initData() {
        super.initData();
        getMViewModel().v().setValue(Boolean.TRUE);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @CallSuper
    public void initView() {
        g0();
        RecyclerView.ItemAnimator itemAnimator = getMBinding().f33100a.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        MutableLiveData<BaseQuickAdapter<?, ?>> mutableLiveDataB = getMViewModel().B();
        BaseQuickAdapter<?, ?> baseQuickAdapterD0 = d0();
        baseQuickAdapterD0.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.lq0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                BaseNotifyNextActivity.i0(this.f43127a);
            }
        });
        BaseStateRequestModel.p(getMViewModel(), this, e0(), baseQuickAdapterD0, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, baseQuickAdapterD0, false, 4, null);
        mutableLiveDataB.setValue(baseQuickAdapterD0);
    }

    public void k0(@NotNull BindingTitleBean titleBean) {
        Intrinsics.checkNotNullParameter(titleBean, "titleBean");
    }
}
