package com.huachenjie.base.dialog.inspiration;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.R;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.zj.adlib.fe9;
import com.zj.adlib.i62;
import com.zj.adlib.kq5;
import com.zj.adlib.sk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/base/dialog/inspiration/InspirationDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/base/dialog/inspiration/InspirationVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "onStart", "", "title$delegate", "Lkotlin/Lazy;", "getTitle", "()Ljava/lang/String;", "title", "", "inspirationValue$delegate", "getInspirationValue", "()I", "inspirationValue", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationDialog extends BaseVMDialogFragment<InspirationVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String INSPIRATION_VALUE = "inspirationValue";

    @NotNull
    public static final String TITLE = "title";

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy title = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.dialog.inspiration.InspirationDialog$title$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("title")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: inspirationValue$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inspirationValue = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.base.dialog.inspiration.InspirationDialog$inspirationValue$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m212invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("inspirationValue") : 0);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/dialog/inspiration/InspirationDialog$a;", "", "Landroid/view/View;", "view", "", "c", "a", "b", "<init>", "(Lcom/huachenjie/base/dialog/inspiration/InspirationDialog;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
            kq5.b(InspirationDialog.this.requireContext(), MobClickConstants.h, null);
            InspirationDialog.this.dismissAllowingStateLoss();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            InspirationDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.inspiration.InspirationDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/base/dialog/inspiration/InspirationDialog$b;", "", "", "title", "", "inspirationValue", "Lcom/huachenjie/base/dialog/inspiration/InspirationDialog;", "a", "INSPIRATION_VALUE", "Ljava/lang/String;", "TITLE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InspirationDialog a(@NotNull String title, int inspirationValue) {
            Intrinsics.checkNotNullParameter(title, "title");
            InspirationDialog inspirationDialog = new InspirationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putInt("inspirationValue", inspirationValue);
            inspirationDialog.setArguments(bundle);
            return inspirationDialog;
        }
    }

    private final int getInspirationValue() {
        return ((Number) this.inspirationValue.getValue()).intValue();
    }

    private final String getTitle() {
        return (String) this.title.getValue();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_inspiration), Integer.valueOf(sk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(sk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        ((InspirationVM) ((BaseVMDialogFragment) this).mState).i().setValue(getTitle());
        ((InspirationVM) ((BaseVMDialogFragment) this).mState).h().setValue(Integer.valueOf(getInspirationValue()));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator startDelay;
        super.onStart();
        View view = getView();
        if (view == null || (viewPropertyAnimatorAnimate = view.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(1.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(300L)) == null || (startDelay = duration.setStartDelay(300L)) == null) {
            return;
        }
        startDelay.start();
    }
}
