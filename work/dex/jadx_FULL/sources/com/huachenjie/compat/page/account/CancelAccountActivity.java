package com.huachenjie.compat.page.account;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.CancelAccountActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.i62;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.m)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/compat/page/account/CancelAccountVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "h0", "<init>", "()V", "a", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountActivity extends BaseVmActivity<CancelAccountVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountActivity$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/compat/page/account/CancelAccountActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.compat.page.account.CancelAccountActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/compat/page/account/CancelAccountActivity$a$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", "onTick", "onFinish", "compat_release"}, k = 1, mv = {1, 8, 0})
        public static final class CountDownTimerC0798a extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f34085a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CountDownTimerC0798a(View view) {
                super(60000L, 1000L);
                this.f34085a = view;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((TextView) this.f34085a).setEnabled(true);
                ((TextView) this.f34085a).setText("重新获取");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView = (TextView) this.f34085a;
                StringBuilder sb = new StringBuilder();
                sb.append(millisUntilFinished / ((long) 1000));
                sb.append('s');
                textView.setText(sb.toString());
            }
        }

        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((CancelAccountVM) ((BaseVmActivity) CancelAccountActivity.this).f8507a).o();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((CancelAccountVM) ((BaseVmActivity) CancelAccountActivity.this).f8507a).k();
            v.setEnabled(false);
            ((TextView) v).setText("60s");
            new CountDownTimerC0798a(v).start();
        }
    }

    public static final void i0(CancelAccountActivity cancelAccountActivity, View view) {
        Intrinsics.checkNotNullParameter(cancelAccountActivity, "this$0");
        cancelAccountActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_cancel_account), Integer.valueOf(wk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void h0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((CancelAccountVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(zn1.a(R.color.white)).setTitleName("注销账号");
        int i = R.color.color_2C3E50;
        ((CancelAccountVM) ((BaseVmActivity) this).f8507a).j().setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.md1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountActivity.i0(this.f43273a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        h0();
        ((CancelAccountVM) ((BaseVmActivity) this).f8507a).h().setValue(ai9.e().getPhone());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
