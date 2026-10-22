package com.huachenjie.sport.page.campus_letter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.triver.basic.api.RequestPermission;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.huachenjie.sport.page.campus_letter.CampusLetterActivity;
import com.igexin.push.g.o;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.j)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010#¨\u0006'"}, d2 = {"Lcom/huachenjie/sport/page/campus_letter/CampusLetterActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/campus_letter/CampusLetterVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "o0", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "l0", "K", "I", "", "a", "Z", "m0", "()Z", "t0", "(Z)V", "redDotFlag", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "operatePopupWindow", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "operateCallback", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCampusLetterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CampusLetterActivity.kt\ncom/huachenjie/sport/page/campus_letter/CampusLetterActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
public final class CampusLetterActivity extends BaseVmActivity<CampusLetterVM> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int requestCode = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.hd1
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            CampusLetterActivity.r0(this.f42101a);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final OperatePopupWindow.OnClickCallback operateCallback = new OperatePopupWindow.OnClickCallback() { // from class: com.zj.adlib.id1
        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public final void a(View view, int i, Object obj) {
            CampusLetterActivity.s0(this.f42330a, view, i, obj);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OperatePopupWindow operatePopupWindow;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean redDotFlag;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36555a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36555a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36555a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36555a.invoke(obj);
        }
    }

    public static final boolean n0(CampusLetterActivity campusLetterActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(campusLetterActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        OperatePopupWindow operatePopupWindowL0 = campusLetterActivity.l0();
        Intrinsics.checkNotNull(operatePopupWindowL0);
        operatePopupWindowL0.i(Integer.valueOf(i));
        OperatePopupWindow operatePopupWindowL1 = campusLetterActivity.l0();
        Intrinsics.checkNotNull(operatePopupWindowL1);
        operatePopupWindowL1.j(view, "delete", OperatePopupWindow.h);
        return true;
    }

    public static final void p0(CampusLetterActivity campusLetterActivity, View view) {
        Intrinsics.checkNotNullParameter(campusLetterActivity, "this$0");
        ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).u(null, -1);
    }

    public static final void q0(CampusLetterActivity campusLetterActivity, View view) {
        Intrinsics.checkNotNullParameter(campusLetterActivity, "this$0");
        campusLetterActivity.finish();
    }

    public static final void r0(CampusLetterActivity campusLetterActivity) {
        Intrinsics.checkNotNullParameter(campusLetterActivity, "this$0");
        ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).v();
    }

    public static final void s0(CampusLetterActivity campusLetterActivity, View view, int i, Object obj) {
        CampusLetterAdapter value;
        List<CampusLetterBean> data;
        CampusLetterAdapter value2;
        List<CampusLetterBean> data2;
        Intrinsics.checkNotNullParameter(campusLetterActivity, "this$0");
        if (view == null) {
            return;
        }
        if (i == 1001) {
            if (obj == null || !(obj instanceof Integer) || (value = ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).m().getValue()) == null || (data = value.getData()) == null) {
                return;
            }
            Number number = (Number) obj;
            CampusLetterBean campusLetterBean = data.get(number.intValue());
            if (campusLetterBean != null) {
                ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).l(campusLetterBean.getSchoolLetterRelationCode(), number.intValue());
                return;
            }
            return;
        }
        if (i != 1003 || obj == null || !(obj instanceof Integer) || (value2 = ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).m().getValue()) == null || (data2 = value2.getData()) == null) {
            return;
        }
        Number number2 = (Number) obj;
        CampusLetterBean campusLetterBean2 = data2.get(number2.intValue());
        if (campusLetterBean2 != null) {
            ((CampusLetterVM) ((BaseVmActivity) campusLetterActivity).f8507a).u(campusLetterBean2.getSchoolLetterRelationCode(), number2.intValue());
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_campus_letter), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.R), this.onRefreshListener);
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…fresh, onRefreshListener)");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        this.redDotFlag = intent != null ? intent.getBooleanExtra("redDotFlag", false) : false;
        o0();
        CampusLetterAdapter value = ((CampusLetterVM) ((BaseVmActivity) this).f8507a).m().getValue();
        if (value != null) {
            value.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.zj.adlib.gd1
                @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    return CampusLetterActivity.n0(this.f41875a, baseQuickAdapter, view, i);
                }
            });
        }
        ((CampusLetterVM) ((BaseVmActivity) this).f8507a).v();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((CampusLetterVM) ((BaseVmActivity) this).f8507a).n().observe(this, new a(new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.campus_letter.CampusLetterActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
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
            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                LetterDetailActivity.Companion aVar = LetterDetailActivity.INSTANCE;
                CampusLetterActivity campusLetterActivity = CampusLetterActivity.this;
                int i = campusLetterActivity.requestCode;
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                aVar.b(campusLetterActivity, i, str, 0);
            }
        }));
    }

    public final OperatePopupWindow l0() {
        if (this.operatePopupWindow == null) {
            Context context = getContext();
            Integer value = ((CampusLetterVM) ((BaseVmActivity) this).f8507a).b.getValue();
            Intrinsics.checkNotNull(value);
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(context, value.intValue());
            this.operatePopupWindow = operatePopupWindow;
            Intrinsics.checkNotNull(operatePopupWindow);
            operatePopupWindow.h(this.operateCallback);
        }
        return this.operatePopupWindow;
    }

    /* JADX INFO: renamed from: m0, reason: from getter */
    public final boolean getRedDotFlag() {
        return this.redDotFlag;
    }

    public final void o0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataO = ((CampusLetterVM) ((BaseVmActivity) this).f8507a).o();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("校园信件");
        bindingTitleBean.setShowDivider(false);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.color_2C3E50));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(Color.parseColor("#000000")));
        bindingTitleBean.setShowRightText(true);
        bindingTitleBean.setRightButtonText("清除未读");
        bindingTitleBean.setRightButtonTextColor(Color.parseColor("#FF2C3E50"));
        bindingTitleBean.setShowRightIconNew(false);
        bindingTitleBean.setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.ed1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampusLetterActivity.p0(this.f41408a, view);
            }
        });
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.fd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampusLetterActivity.q0(this.f41646a, view);
            }
        });
        mutableLiveDataO.setValue(bindingTitleBean);
        TextView textView = (TextView) findViewById(R.id.tv_right_text);
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
        findViewById(R.id.v_right_red_dot);
        e.p3(this).l3().T2(true).a1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String stringExtra;
        CampusLetterAdapter value;
        Object next;
        int iIndexOf;
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode != requestCode || resultCode != -1 || data == null || (stringExtra = data.getStringExtra("code")) == null || (value = ((CampusLetterVM) ((BaseVmActivity) this).f8507a).m().getValue()) == null) {
            return;
        }
        Iterator<T> it = value.getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((CampusLetterBean) next).getSchoolLetterRelationCode(), stringExtra));
        CampusLetterBean campusLetterBean = (CampusLetterBean) next;
        if (campusLetterBean == null || (iIndexOf = value.getData().indexOf(campusLetterBean)) <= -1) {
            return;
        }
        value.removeAt(iIndexOf);
    }

    public final void t0(boolean z) {
        this.redDotFlag = z;
    }
}
