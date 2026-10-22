package com.huachenjie.run.page.appeal;

import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityAppealBinding;
import com.huachenjie.run.page.appeal.AppealActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.h)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J(\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/run/page/appeal/AppealActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityAppealBinding;", "Lcom/huachenjie/run/page/appeal/AppealVM;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "e0", "Landroid/text/SpannableString;", "spannable", "", "fullText", "target", "color", "c0", "t", "Ljava/lang/String;", "runRecordCode", "x", "semesterCode", "<init>", "()V", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class AppealActivity extends BaseMVVMActivity<RunActivityAppealBinding, AppealVM> {

    @NotNull
    public static final String y = "runRecordCode";

    @NotNull
    public static final String z = "semesterCode";

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Autowired(name = "runRecordCode")
    @JvmField
    @Nullable
    public String runRecordCode;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "semesterCode")
    @JvmField
    @Nullable
    public String semesterCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/appeal/AppealActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/page/appeal/AppealActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            String string;
            Editable text = AppealActivity.a0(AppealActivity.this).f35448a.getText();
            String string2 = (text == null || (string = text.toString()) == null) ? null : StringsKt.trim(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            int length = string2.length();
            boolean z = false;
            if (2 <= length && length < 181) {
                z = true;
            }
            if (!z) {
                fv5.a(R.string.run_appeal_content_invalid_warn);
                return;
            }
            AppealVM appealVMB0 = AppealActivity.b0(AppealActivity.this);
            AppealActivity appealActivity = AppealActivity.this;
            String str = appealActivity.runRecordCode;
            if (str == null) {
                str = "";
            }
            String str2 = appealActivity.semesterCode;
            appealVMB0.j(str, string2, str2 != null ? str2 : "");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/run/page/appeal/AppealActivity$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            AppealVM appealVMB0 = AppealActivity.b0(AppealActivity.this);
            String string = s != null ? s.toString() : null;
            if (string == null) {
                string = "";
            }
            appealVMB0.n(string);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35798a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35798a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35798a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35798a.invoke(obj);
        }
    }

    public static final /* synthetic */ RunActivityAppealBinding a0(AppealActivity appealActivity) {
        return appealActivity.getMBinding();
    }

    public static final /* synthetic */ AppealVM b0(AppealActivity appealActivity) {
        return appealActivity.getMViewModel();
    }

    public static final void d0(AppealActivity appealActivity, View view) {
        Intrinsics.checkNotNullParameter(appealActivity, "this$0");
        appealActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().getAppealSucceedEvent().observe(this, new d(new Function1() { // from class: com.huachenjie.run.page.appeal.AppealActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Void r2) {
                this.this$0.setResult(-1);
                this.this$0.finish();
            }
        }));
    }

    public final void c0(SpannableString spannable, String fullText, String target, int color) {
        int iIndexOf$default = StringsKt.indexOf$default(fullText, target, 0, false, 6, (Object) null);
        if (iIndexOf$default < 0) {
            return;
        }
        int length = target.length() + iIndexOf$default;
        spannable.setSpan(new ForegroundColorSpan(color), iIndexOf$default, length, 33);
        spannable.setSpan(new StyleSpan(1), iIndexOf$default, length, 33);
    }

    public final void e0() {
        SpannableString spannableString = new SpannableString("申诉内容请控制在2～180字，以便我们更准确地了解您的情况。成绩申诉将在3个工作日内 完成处理，请您耐心等待。");
        int color = Color.parseColor("#FF9118");
        c0(spannableString, "申诉内容请控制在2～180字，以便我们更准确地了解您的情况。成绩申诉将在3个工作日内 完成处理，请您耐心等待。", "2～180", color);
        c0(spannableString, "申诉内容请控制在2～180字，以便我们更准确地了解您的情况。成绩申诉将在3个工作日内 完成处理，请您耐心等待。", "3个工作日内", color);
        getMBinding().b.setText(spannableString);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_appeal;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("我要申诉");
        int i = R.color.color_191F20;
        mutableLiveDataI.setValue(titleName.setTitleTextColor(zn1.a(i)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackground(zn1.a(R.color.white)).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ja0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppealActivity.d0(this.f42537a, view);
            }
        }));
        e0();
        getMBinding().f35448a.addTextChangedListener(new c());
    }
}
