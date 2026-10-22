package com.huachenjie.base.widget.semester;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.gyf.immersionbar.e;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.semester.SemesterDrawer;
import com.huachenjie.common.bean.SemesterBean;
import com.lxj.xpopup.core.DrawerPopupView;
import com.zj.adlib.ai9;
import com.zj.adlib.cr2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001:B=\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R#\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010 \u001a\n \u0018*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR#\u0010$\u001a\n \u0018*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u0018*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006;"}, d2 = {"Lcom/huachenjie/base/widget/semester/SemesterDrawer;", "Lcom/lxj/xpopup/core/DrawerPopupView;", "", "getImplLayoutId", "", "onCreate", "f", "", "Ljava/lang/String;", "getSemesterCode", "()Ljava/lang/String;", "semesterCode", "", "Lcom/huachenjie/common/bean/SemesterBean;", "a", "Ljava/util/List;", "semesterData", "", "b", "Z", "filterUnStart", "c", "showRemember", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/TextView;", "getTvConfirm", "()Landroid/widget/TextView;", "tvConfirm", "Landroidx/recyclerview/widget/RecyclerView;", "getRvSemester", "()Landroidx/recyclerview/widget/RecyclerView;", "rvSemester", "Landroid/widget/CheckBox;", "d", "getCbChoose", "()Landroid/widget/CheckBox;", "cbChoose", "Lcom/huachenjie/base/widget/semester/SemesterDrawerAdapter;", "e", "getAdapter", "()Lcom/huachenjie/base/widget/semester/SemesterDrawerAdapter;", "adapter", "Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;", "Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;", "getListener", "()Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;", "setListener", "(Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;ZZ)V", "OnConfirmListener", "base_release"}, k = 1, mv = {1, 8, 0})
public final class SemesterDrawer extends DrawerPopupView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public OnConfirmListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<SemesterBean> semesterData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy ivClose;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvConfirm;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public final boolean filterUnStart;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy rvSemester;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public final boolean showRemember;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy cbChoose;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy adapter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public final String semesterCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;", "", "Lcom/huachenjie/common/bean/SemesterBean;", "semester", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public interface OnConfirmListener {
        void a(@Nullable SemesterBean semester);
    }

    public /* synthetic */ SemesterDrawer(Context context, String str, List list, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str, list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    public static final void g(SemesterDrawer semesterDrawer, View view) {
        Intrinsics.checkNotNullParameter(semesterDrawer, "this$0");
        semesterDrawer.dismiss();
    }

    private final SemesterDrawerAdapter getAdapter() {
        return (SemesterDrawerAdapter) this.adapter.getValue();
    }

    private final CheckBox getCbChoose() {
        return (CheckBox) this.cbChoose.getValue();
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

    public static final void h(SemesterDrawer semesterDrawer, View view) {
        Intrinsics.checkNotNullParameter(semesterDrawer, "this$0");
        if (semesterDrawer.getCbChoose().isChecked()) {
            ai9.r(semesterDrawer.getAdapter().getMSemesterBean());
        } else {
            ai9.r(null);
        }
        OnConfirmListener onConfirmListener = semesterDrawer.listener;
        if (onConfirmListener != null) {
            onConfirmListener.a(semesterDrawer.getAdapter().getMSemesterBean());
        }
        semesterDrawer.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        getRvSemester().setLayoutManager(new LinearLayoutManager(getContext()));
        getRvSemester().setAdapter(getAdapter());
        String str = this.semesterCode;
        if (str != null) {
            getAdapter().j(str);
            for (SemesterBean semesterBean : this.semesterData) {
                if (TextUtils.equals(str, semesterBean.getSemesterCode())) {
                    getAdapter().i(semesterBean);
                }
            }
        }
        if (!this.filterUnStart) {
            getAdapter().setList(this.semesterData);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SemesterBean semesterBean2 : this.semesterData) {
            if (semesterBean2.getStatus() != 0) {
                arrayList.add(semesterBean2);
            }
        }
        getAdapter().setList(arrayList);
    }

    public int getImplLayoutId() {
        return R.layout.layout_drawer_semester;
    }

    @Nullable
    public final OnConfirmListener getListener() {
        return this.listener;
    }

    @Nullable
    public final String getSemesterCode() {
        return this.semesterCode;
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
        getIvClose().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.b58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SemesterDrawer.g(this.f40680a, view);
            }
        });
        getCbChoose().setVisibility(this.showRemember ? 0 : 8);
        getCbChoose().setChecked(ai9.d() != null);
        getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.c58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SemesterDrawer.h(this.f40905a, view);
            }
        });
    }

    public final void setListener(@Nullable OnConfirmListener onConfirmListener) {
        this.listener = onConfirmListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemesterDrawer(@NotNull Context context, @Nullable String str, @NotNull List<SemesterBean> list, boolean z, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "semesterData");
        this.semesterCode = str;
        this.semesterData = list;
        this.filterUnStart = z;
        this.showRemember = z2;
        this.ivClose = LazyKt.lazy(new Function0<ImageView>() { // from class: com.huachenjie.base.widget.semester.SemesterDrawer$ivClose$2
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
            public final ImageView m237invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_close);
            }
        });
        this.tvConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.base.widget.semester.SemesterDrawer$tvConfirm$2
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
            public final TextView m239invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_confirm);
            }
        });
        this.rvSemester = LazyKt.lazy(new Function0<RecyclerView>() { // from class: com.huachenjie.base.widget.semester.SemesterDrawer$rvSemester$2
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
            public final RecyclerView m238invoke() {
                return (RecyclerView) this.this$0.findViewById(R.id.rv_semester);
            }
        });
        this.cbChoose = LazyKt.lazy(new Function0<CheckBox>() { // from class: com.huachenjie.base.widget.semester.SemesterDrawer$cbChoose$2
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
            public final CheckBox m236invoke() {
                return (CheckBox) this.this$0.findViewById(R.id.cb_choose);
            }
        });
        this.adapter = LazyKt.lazy(new Function0<SemesterDrawerAdapter>() { // from class: com.huachenjie.base.widget.semester.SemesterDrawer$adapter$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SemesterDrawerAdapter m235invoke() {
                return new SemesterDrawerAdapter();
            }
        });
    }
}
