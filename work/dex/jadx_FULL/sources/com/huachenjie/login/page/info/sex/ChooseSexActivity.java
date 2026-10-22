package com.huachenjie.login.page.info.sex;

import android.content.Intent;
import android.view.View;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.databinding.LoginActivityChooseSexBinding;
import com.huachenjie.login.page.info.portrait.ChoosePortraitActivity;
import com.zj.adlib.f79;
import com.zj.adlib.pg3;
import com.zj.adlib.s72;
import com.zj.adlib.zk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/login/page/info/sex/ChooseSexActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityChooseSexBinding;", "Lcom/huachenjie/login/page/info/sex/ChooseSexVM;", "", "getLayoutResID", "", "", "V", "", "initData", "Lcom/zj/adlib/f79;", "b", "Lkotlin/Lazy;", "b0", "()Lcom/zj/adlib/f79;", "timePickerView", "<init>", "()V", "a", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseSexActivity extends BaseMVVMActivity<LoginActivityChooseSexBinding, ChooseSexVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy timePickerView = LazyKt.lazy(new ChooseSexActivity$timePickerView$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/login/page/info/sex/ChooseSexActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "c", "d", "e", "<init>", "(Lcom/huachenjie/login/page/info/sex/ChooseSexActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseSexActivity.this.getOnBackPressedDispatcher().onBackPressed();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseSexActivity.this.b0().t();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseSexActivity.Z(ChooseSexActivity.this).k().setValue(2);
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseSexActivity.Z(ChooseSexActivity.this).k().setValue(1);
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            pg3 pg3Var = pg3.f18845a;
            Integer value = ChooseSexActivity.Z(ChooseSexActivity.this).k().getValue();
            pg3Var.k(value == null ? 2 : value.intValue());
            Long value2 = ChooseSexActivity.Z(ChooseSexActivity.this).j().getValue();
            Intrinsics.checkNotNull(value2);
            String strC = s72.c(value2.longValue(), ChooseSexActivity.this.getResources().getString(R.string.login_choose_sex_birthday_normal));
            Intrinsics.checkNotNullExpressionValue(strC, "formatDateTimeByFormat(\n…day_normal)\n            )");
            pg3Var.g(strC);
            ChooseSexActivity.this.startActivity(new Intent(ChooseSexActivity.this, (Class<?>) ChoosePortraitActivity.class));
        }
    }

    public static final /* synthetic */ ChooseSexVM Z(ChooseSexActivity chooseSexActivity) {
        return chooseSexActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new a())});
    }

    public final f79 b0() {
        return (f79) this.timePickerView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_choose_sex;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().i().setValue(getResources().getString(R.string.login_choose_sex_birthday_default_time));
    }
}
