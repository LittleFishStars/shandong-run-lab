package com.huachenjie.sport.page.mine.sport_test.result;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.gyf.immersionbar.e;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.TestResultYearBean;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreDrawer;
import com.lxj.xpopup.core.DrawerPopupView;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B%\u0012\u0006\u0010*\u001a\u00020)\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0019\u001a\n \u0010*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001e\u001a\n \u0010*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010 R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006."}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer;", "Lcom/lxj/xpopup/core/DrawerPopupView;", "", "getImplLayoutId", "", "onCreate", y6b.f, "", "Lcom/huachenjie/sport/bean/TestResultYearBean;", "a", "Ljava/util/List;", "schoolYearData", "M", "I", "position", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/TextView;", "b", "getTvConfirm", "()Landroid/widget/TextView;", "tvConfirm", "Landroidx/recyclerview/widget/RecyclerView;", "c", "getRvSemester", "()Landroidx/recyclerview/widget/RecyclerView;", "rvSemester", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestDrawerAdapter;", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestDrawerAdapter;", "adapter", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;", "getListener", "()Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;", "setListener", "(Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "OnConfirmListener", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestResultScoreDrawer extends DrawerPopupView {

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final int position;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public SportTestDrawerAdapter adapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnConfirmListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<TestResultYearBean> schoolYearData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy ivClose;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvConfirm;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy rvSemester;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;", "", "Lcom/huachenjie/sport/bean/TestResultYearBean;", "item", "", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public interface OnConfirmListener {
        void a(@NotNull TestResultYearBean item);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportTestResultScoreDrawer(@NotNull Context context, @NotNull List<TestResultYearBean> list, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "schoolYearData");
        this.schoolYearData = list;
        this.position = i;
        this.ivClose = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreDrawer$ivClose$2
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
            public final ImageView m793invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_close);
            }
        });
        this.tvConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreDrawer$tvConfirm$2
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
            public final TextView m795invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_confirm);
            }
        });
        this.rvSemester = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreDrawer$rvSemester$2
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
            public final RecyclerView m794invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_semester);
            }
        });
    }

    private final ImageView getIvClose() {
        return (ImageView) this.ivClose.getValue();
    }

    private final RecyclerView getRvSemester() {
        return (RecyclerView) this.rvSemester.getValue();
    }

    private final TextView getTvConfirm() {
        return (TextView) this.tvConfirm.getValue();
    }

    public static final void h(SportTestResultScoreDrawer sportTestResultScoreDrawer, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(sportTestResultScoreDrawer, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SportTestDrawerAdapter sportTestDrawerAdapter = sportTestResultScoreDrawer.adapter;
        if (sportTestDrawerAdapter != null) {
            sportTestDrawerAdapter.g(i);
        }
    }

    public static final void i(SportTestResultScoreDrawer sportTestResultScoreDrawer, View view) {
        Intrinsics.checkNotNullParameter(sportTestResultScoreDrawer, "this$0");
        sportTestResultScoreDrawer.dismiss();
    }

    public static final void j(SportTestResultScoreDrawer sportTestResultScoreDrawer, View view) {
        Intrinsics.checkNotNullParameter(sportTestResultScoreDrawer, "this$0");
        OnConfirmListener onConfirmListener = sportTestResultScoreDrawer.listener;
        if (onConfirmListener != null) {
            SportTestDrawerAdapter sportTestDrawerAdapter = sportTestResultScoreDrawer.adapter;
            Intrinsics.checkNotNull(sportTestDrawerAdapter);
            onConfirmListener.a(sportTestDrawerAdapter.f());
        }
        sportTestResultScoreDrawer.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setJustifyContent(0);
        getRvSemester().setLayoutManager(flexboxLayoutManager);
        SportTestDrawerAdapter sportTestDrawerAdapter = new SportTestDrawerAdapter(this.position);
        this.adapter = sportTestDrawerAdapter;
        sportTestDrawerAdapter.setList(this.schoolYearData);
        SportTestDrawerAdapter sportTestDrawerAdapter2 = this.adapter;
        if (sportTestDrawerAdapter2 != null) {
            sportTestDrawerAdapter2.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.tn8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    SportTestResultScoreDrawer.h(this.f44965a, baseQuickAdapter, view, i);
                }
            });
        }
        getRvSemester().setAdapter(this.adapter);
    }

    public int getImplLayoutId() {
        return R.layout.layout_spore_test_result_drawer;
    }

    @Nullable
    public final OnConfirmListener getListener() {
        return this.listener;
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
        g();
        getIvClose().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.rn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestResultScoreDrawer.i(this.f44490a, view);
            }
        });
        getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.sn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestResultScoreDrawer.j(this.f44724a, view);
            }
        });
    }

    public final void setListener(@Nullable OnConfirmListener onConfirmListener) {
        this.listener = onConfirmListener;
    }
}
