package com.huachenjie.run.page.rankinglist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.gyf.immersionbar.e;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankingRangeBean;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.rankinglist.RankingDrawer;
import com.lxj.xpopup.core.DrawerPopupView;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001WB[\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001b¢\u0006\u0004\bU\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0002R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001dR#\u0010)\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R#\u0010-\u001a\n %*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b+\u0010,R#\u0010/\u001a\n %*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010&\u001a\u0004\b.\u0010,R#\u00103\u001a\n %*\u0004\u0018\u000100008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010&\u001a\u0004\b1\u00102R#\u00106\u001a\n %*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010,R#\u00108\u001a\n %*\u0004\u0018\u000100008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b7\u00102R#\u0010;\u001a\n %*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010,R#\u0010>\u001a\n %*\u0004\u0018\u000100008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010&\u001a\u0004\b=\u00102R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010&\u001a\u0004\bA\u0010BR\u001b\u0010F\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010&\u001a\u0004\bE\u0010BR\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010&\u001a\u0004\bI\u0010JR$\u0010R\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006X"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/RankingDrawer;", "Lcom/lxj/xpopup/core/DrawerPopupView;", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "getLayoutManager", "", "getImplLayoutId", "", "onCreate", "f", "a", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "code", "b", "getTimeCode", "setTimeCode", "timeCode", "", "Ljava/lang/String;", "getPlanCode", "()Ljava/lang/String;", "setPlanCode", "(Ljava/lang/String;)V", DetailActivity.x, "", "Lcom/huachenjie/run/bean/RankingRangeBean;", "Ljava/util/List;", "filterData", "c", "timeData", "Lcom/huachenjie/run/bean/RunPlanBean;", "d", "planData", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/TextView;", "getTvConfirm", "()Landroid/widget/TextView;", "tvConfirm", "getTvRange", "tvRange", "Landroidx/recyclerview/widget/RecyclerView;", "getRvRange", "()Landroidx/recyclerview/widget/RecyclerView;", "rvRange", "e", "getTvTime", "tvTime", "getRvTime", "rvTime", y6b.f, "getTvPlan", "tvPlan", y6b.g, "getRvPlan", "rvPlan", "Lcom/huachenjie/run/page/rankinglist/RankingDrawerAdapter;", "i", "getAdapter", "()Lcom/huachenjie/run/page/rankinglist/RankingDrawerAdapter;", "adapter", "j", "getTimeAdapter", "timeAdapter", "Lcom/huachenjie/run/page/rankinglist/RankingDrawerPlanAdapter;", "k", "getPlanAdapter", "()Lcom/huachenjie/run/page/rankinglist/RankingDrawerPlanAdapter;", "planAdapter", "Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;", "Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;", "getListener", "()Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;", "setListener", "(Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "OnConfirmListener", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RankingDrawer extends DrawerPopupView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public OnConfirmListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer code;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<RankingRangeBean> filterData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy ivClose;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Integer timeCode;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy tvConfirm;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<RankingRangeBean> timeData;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy tvRange;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final List<RunPlanBean> planData;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy rvRange;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvTime;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String planCode;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy rvTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvPlan;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy rvPlan;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final Lazy adapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final Lazy timeAdapter;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final Lazy planAdapter;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/RankingDrawer$OnConfirmListener;", "", "", "code", "timeCode", "", DetailActivity.x, "", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public interface OnConfirmListener {
        void a(int code, int timeCode, @NotNull String planCode);
    }

    public /* synthetic */ RankingDrawer(Context context, Integer num, Integer num2, String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? "" : str, list, list2, list3);
    }

    public static final void g(RankingDrawer rankingDrawer, View view) {
        Intrinsics.checkNotNullParameter(rankingDrawer, "this$0");
        rankingDrawer.dismiss();
    }

    private final RankingDrawerAdapter getAdapter() {
        return (RankingDrawerAdapter) this.adapter.getValue();
    }

    private final ImageView getIvClose() {
        return (ImageView) this.ivClose.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FlexboxLayoutManager getLayoutManager() {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setJustifyContent(0);
        return flexboxLayoutManager;
    }

    private final RankingDrawerPlanAdapter getPlanAdapter() {
        return (RankingDrawerPlanAdapter) this.planAdapter.getValue();
    }

    private final RecyclerView getRvPlan() {
        return (RecyclerView) this.rvPlan.getValue();
    }

    private final RecyclerView getRvRange() {
        return (RecyclerView) this.rvRange.getValue();
    }

    private final RecyclerView getRvTime() {
        return (RecyclerView) this.rvTime.getValue();
    }

    private final RankingDrawerAdapter getTimeAdapter() {
        return (RankingDrawerAdapter) this.timeAdapter.getValue();
    }

    private final TextView getTvConfirm() {
        return (TextView) this.tvConfirm.getValue();
    }

    private final TextView getTvPlan() {
        return (TextView) this.tvPlan.getValue();
    }

    private final TextView getTvRange() {
        return (TextView) this.tvRange.getValue();
    }

    private final TextView getTvTime() {
        return (TextView) this.tvTime.getValue();
    }

    public static final void h(RankingDrawer rankingDrawer, View view) {
        Intrinsics.checkNotNullParameter(rankingDrawer, "this$0");
        OnConfirmListener onConfirmListener = rankingDrawer.listener;
        if (onConfirmListener != null) {
            onConfirmListener.a(rankingDrawer.getAdapter().getCheckedCode(), rankingDrawer.getTimeAdapter().getCheckedCode(), rankingDrawer.getPlanAdapter().getCheckedCode());
        }
        rankingDrawer.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        List<RankingRangeBean> list = this.filterData;
        if (list == null || list.isEmpty()) {
            getTvRange().setVisibility(8);
            getRvRange().setVisibility(8);
        } else {
            getTvRange().setVisibility(0);
            getRvRange().setVisibility(0);
            getRvRange().setLayoutManager(getLayoutManager());
            getRvRange().setAdapter(getAdapter());
            Integer num = this.code;
            if (num != null) {
                getAdapter().h(num.intValue());
            }
            getAdapter().setList(this.filterData);
        }
        List<RankingRangeBean> list2 = this.timeData;
        if (list2 == null || list2.isEmpty()) {
            getTvTime().setVisibility(8);
            getRvTime().setVisibility(8);
        } else {
            getTvTime().setVisibility(0);
            getRvTime().setVisibility(0);
            getRvTime().setLayoutManager(getLayoutManager());
            getRvTime().setAdapter(getTimeAdapter());
            Integer num2 = this.timeCode;
            if (num2 != null) {
                getTimeAdapter().h(num2.intValue());
            }
            getTimeAdapter().setList(this.timeData);
        }
        List<RunPlanBean> list3 = this.planData;
        if (list3 == null || list3.isEmpty()) {
            getTvPlan().setVisibility(8);
            getRvPlan().setVisibility(8);
            return;
        }
        getTvPlan().setVisibility(0);
        getRvPlan().setVisibility(0);
        getRvPlan().setLayoutManager(new LinearLayoutManager(getContext()));
        getRvPlan().setAdapter(getPlanAdapter());
        String str = this.planCode;
        if (str != null) {
            getPlanAdapter().h(str);
        }
        getPlanAdapter().setList(this.planData);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    public int getImplLayoutId() {
        return R.layout.run_layout_ranking_drawer;
    }

    @Nullable
    public final OnConfirmListener getListener() {
        return this.listener;
    }

    @NotNull
    public final String getPlanCode() {
        return this.planCode;
    }

    @Nullable
    public final Integer getTimeCode() {
        return this.timeCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*com.lxj.xpopup.core.BasePopupView*/.onCreate();
        Context context = getContext();
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        int iB = cr2.b(context, e.H0((Activity) context2)) + 14;
        ViewGroup.LayoutParams layoutParams = getIvClose().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).setMargins(0, SizeUtils.b(iB), 0, 0);
        f();
        getIvClose().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.la7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingDrawer.g(this.f43027a, view);
            }
        });
        getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ma7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingDrawer.h(this.f43257a, view);
            }
        });
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    public final void setListener(@Nullable OnConfirmListener onConfirmListener) {
        this.listener = onConfirmListener;
    }

    public final void setPlanCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planCode = str;
    }

    public final void setTimeCode(@Nullable Integer num) {
        this.timeCode = num;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankingDrawer(@NotNull Context context, @Nullable Integer num, @Nullable Integer num2, @NotNull String str, @NotNull List<RankingRangeBean> list, @NotNull List<RankingRangeBean> list2, @NotNull List<RunPlanBean> list3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DetailActivity.x);
        Intrinsics.checkNotNullParameter(list, "filterData");
        Intrinsics.checkNotNullParameter(list2, "timeData");
        Intrinsics.checkNotNullParameter(list3, "planData");
        this.code = num;
        this.timeCode = num2;
        this.planCode = str;
        this.filterData = list;
        this.timeData = list2;
        this.planData = list3;
        this.ivClose = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$ivClose$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ImageView m661invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_close);
            }
        });
        this.tvConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$tvConfirm$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m667invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_confirm);
            }
        });
        this.tvRange = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$tvRange$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m669invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_range);
            }
        });
        this.rvRange = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$rvRange$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m664invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_range);
            }
        });
        this.tvTime = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$tvTime$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m670invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_time);
            }
        });
        this.rvTime = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$rvTime$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m665invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_time);
            }
        });
        this.tvPlan = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$tvPlan$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m668invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_plan);
            }
        });
        this.rvPlan = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$rvPlan$2
            {
                super(0);
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
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecyclerView m663invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_plan);
            }
        });
        this.adapter = LazyKt.lazy(new Function0<RankingDrawerAdapter>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$adapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RankingDrawerAdapter m660invoke() {
                return new RankingDrawerAdapter();
            }
        });
        this.timeAdapter = LazyKt.lazy(new Function0<RankingDrawerAdapter>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$timeAdapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RankingDrawerAdapter m666invoke() {
                return new RankingDrawerAdapter();
            }
        });
        this.planAdapter = LazyKt.lazy(new Function0<RankingDrawerPlanAdapter>() { // from class: com.huachenjie.run.page.rankinglist.RankingDrawer$planAdapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RankingDrawerPlanAdapter m662invoke() {
                return new RankingDrawerPlanAdapter();
            }
        });
    }
}
