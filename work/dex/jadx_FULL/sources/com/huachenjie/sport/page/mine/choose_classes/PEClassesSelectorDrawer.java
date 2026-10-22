package com.huachenjie.sport.page.mine.choose_classes;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.gyf.immersionbar.e;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001?B9\u0012\u0006\u0010<\u001a\u00020;\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u0006H\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R#\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010 \u001a\n \u0017*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR#\u0010$\u001a\n \u0017*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\"\u0010#R#\u0010&\u001a\n \u0017*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b%\u0010#R#\u0010)\u001a\n \u0017*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010#R\u001b\u0010-\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b+\u0010,R\u001b\u00100\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010,R\u001b\u00103\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010,R$\u0010:\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006@"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer;", "Lcom/lxj/xpopup/core/DrawerPopupView;", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "getLayoutManager", "", "getImplLayoutId", "", "onCreate", "semesterIndex", "subjectIndex", "timeIndex", "setIndex", "f", "", "", "a", "Ljava/util/List;", "semesterData", "c", "subjectData", "d", "timeData", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/TextView;", "b", "getTvConfirm", "()Landroid/widget/TextView;", "tvConfirm", "Landroidx/recyclerview/widget/RecyclerView;", "getRvSemester", "()Landroidx/recyclerview/widget/RecyclerView;", "rvSemester", "getRvSubject", "rvSubject", "e", "getRvTime", "rvTime", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorAdapter;", "getSemesterAdapter", "()Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorAdapter;", "semesterAdapter", y6b.f, "getSubjectAdapter", "subjectAdapter", y6b.g, "getTimeAdapter", "timeAdapter", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;", "getListener", "()Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;", "setListener", "(Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "OnConfirmListener", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class PEClassesSelectorDrawer extends DrawerPopupView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public OnConfirmListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<String> semesterData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy ivClose;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvConfirm;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<String> subjectData;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy rvSemester;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final List<String> timeData;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy rvSubject;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy rvTime;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy semesterAdapter;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy subjectAdapter;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy timeAdapter;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;", "", "", "semesterIndex", "subjectIndex", "time", "", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public interface OnConfirmListener {
        void a(int semesterIndex, int subjectIndex, int time);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PEClassesSelectorDrawer(@NotNull Context context, @NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "semesterData");
        Intrinsics.checkNotNullParameter(list2, "subjectData");
        Intrinsics.checkNotNullParameter(list3, "timeData");
        this.semesterData = list;
        this.subjectData = list2;
        this.timeData = list3;
        this.ivClose = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$ivClose$2
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
            public final ImageView m773invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_close);
            }
        });
        this.tvConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$tvConfirm$2
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
            public final TextView m780invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_confirm);
            }
        });
        this.rvSemester = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$rvSemester$2
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
            public final RecyclerView m774invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_semester);
            }
        });
        this.rvSubject = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$rvSubject$2
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
            public final RecyclerView m775invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_subject);
            }
        });
        this.rvTime = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$rvTime$2
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
            public final RecyclerView m776invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_time);
            }
        });
        this.semesterAdapter = LazyKt.lazy(new Function0<PEClassesSelectorAdapter>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$semesterAdapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PEClassesSelectorAdapter m777invoke() {
                return new PEClassesSelectorAdapter();
            }
        });
        this.subjectAdapter = LazyKt.lazy(new Function0<PEClassesSelectorAdapter>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$subjectAdapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PEClassesSelectorAdapter m778invoke() {
                return new PEClassesSelectorAdapter();
            }
        });
        this.timeAdapter = LazyKt.lazy(new Function0<PEClassesSelectorAdapter>() { // from class: com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer$timeAdapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PEClassesSelectorAdapter m779invoke() {
                return new PEClassesSelectorAdapter();
            }
        });
    }

    public static final void g(PEClassesSelectorDrawer pEClassesSelectorDrawer, View view) {
        Intrinsics.checkNotNullParameter(pEClassesSelectorDrawer, "this$0");
        pEClassesSelectorDrawer.dismiss();
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

    private final RecyclerView getRvSemester() {
        return (RecyclerView) this.rvSemester.getValue();
    }

    private final RecyclerView getRvSubject() {
        return (RecyclerView) this.rvSubject.getValue();
    }

    private final RecyclerView getRvTime() {
        return (RecyclerView) this.rvTime.getValue();
    }

    private final PEClassesSelectorAdapter getSemesterAdapter() {
        return (PEClassesSelectorAdapter) this.semesterAdapter.getValue();
    }

    private final PEClassesSelectorAdapter getSubjectAdapter() {
        return (PEClassesSelectorAdapter) this.subjectAdapter.getValue();
    }

    private final PEClassesSelectorAdapter getTimeAdapter() {
        return (PEClassesSelectorAdapter) this.timeAdapter.getValue();
    }

    private final TextView getTvConfirm() {
        return (TextView) this.tvConfirm.getValue();
    }

    public static final void h(PEClassesSelectorDrawer pEClassesSelectorDrawer, View view) {
        Intrinsics.checkNotNullParameter(pEClassesSelectorDrawer, "this$0");
        OnConfirmListener onConfirmListener = pEClassesSelectorDrawer.listener;
        if (onConfirmListener != null) {
            onConfirmListener.a(pEClassesSelectorDrawer.getSemesterAdapter().getCheckedIndex(), pEClassesSelectorDrawer.getSubjectAdapter().getCheckedIndex(), pEClassesSelectorDrawer.getTimeAdapter().getCheckedIndex());
        }
        pEClassesSelectorDrawer.dismiss();
    }

    public final void f() {
        getRvSemester().setLayoutManager(getLayoutManager());
        getRvSemester().setAdapter(getSemesterAdapter());
        getSemesterAdapter().setList(this.semesterData);
        getRvSubject().setLayoutManager(getLayoutManager());
        getRvSubject().setAdapter(getSubjectAdapter());
        getSubjectAdapter().setList(this.subjectData);
        getRvTime().setLayoutManager(getLayoutManager());
        getRvTime().setAdapter(getTimeAdapter());
        getTimeAdapter().setList(this.timeData);
    }

    public int getImplLayoutId() {
        return R.layout.layout_pe_classes_selector_drawer;
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
        f();
        getIvClose().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PEClassesSelectorDrawer.g(this.f45352a, view);
            }
        });
        getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PEClassesSelectorDrawer.h(this.f45598a, view);
            }
        });
    }

    public final void setIndex(int semesterIndex, int subjectIndex, int timeIndex) {
        getSemesterAdapter().h(semesterIndex);
        getSubjectAdapter().h(subjectIndex);
        getTimeAdapter().h(timeIndex);
    }

    public final void setListener(@Nullable OnConfirmListener onConfirmListener) {
        this.listener = onConfirmListener;
    }
}
