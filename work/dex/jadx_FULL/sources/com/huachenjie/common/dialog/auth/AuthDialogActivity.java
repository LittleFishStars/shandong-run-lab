package com.huachenjie.common.dialog.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.databinding.ActivityAuthDialogBinding;
import com.huachenjie.common.dialog.auth.AuthDialogActivity;
import com.zj.adlib.ai9;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = RoutePathConstants.Common.b)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0002R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/common/dialog/auth/AuthDialogActivity;", "Lcom/huachenjie/common/base/BaseActivity;", "Lcom/huachenjie/common/dialog/auth/a;", "Lcom/huachenjie/common/dialog/auth/AuthDialogContact$AuthDialogView;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "initPresenter", "initField", "initView", "", "getContentViewRes", "Landroid/content/Intent;", "intent", "handleIntent", "", "s", "r", "", "schoolAuthUrl", "F", "init", "Lcom/huachenjie/common/databinding/ActivityAuthDialogBinding;", "a", "Lkotlin/Lazy;", "m0", "()Lcom/huachenjie/common/databinding/ActivityAuthDialogBinding;", "inflate", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class AuthDialogActivity extends BaseActivity<a> implements AuthDialogContact.AuthDialogView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy inflate = LazyKt.lazy(new Function0<ActivityAuthDialogBinding>() { // from class: com.huachenjie.common.dialog.auth.AuthDialogActivity$inflate$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ActivityAuthDialogBinding m346invoke() {
            return ActivityAuthDialogBinding.d(this.this$0.getLayoutInflater(), null, false);
        }
    });

    public static final void n0(AuthDialogActivity authDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(authDialogActivity, "this$0");
        authDialogActivity.finish();
    }

    public static final void o0(AuthDialogActivity authDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(authDialogActivity, "this$0");
        ((a) ((BaseActivity) authDialogActivity).f8487a).f(ai9.e().getSchoolCode());
    }

    @Override // com.huachenjie.common.dialog.auth.AuthDialogContact.AuthDialogView
    public void F(@NotNull String schoolAuthUrl) {
        Intrinsics.checkNotNullParameter(schoolAuthUrl, "schoolAuthUrl");
        ARouter.getInstance().build(RoutePathConstants.Login.b).withString("url", schoolAuthUrl).withString("type", "STUDENT_AUTH").navigation();
        finish();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return 0;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(@Nullable Intent intent) {
    }

    public final void init() {
        m0().c.setText("请认证学生卡身份");
        m0().f8574a.setText(OptionsPickerHelper.e);
        m0().b.setText("去认证");
        m0().f8574a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ug0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthDialogActivity.n0(this.f45142a, view);
            }
        });
        m0().b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vg0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthDialogActivity.o0(this.f45343a, view);
            }
        });
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
    }

    public final ActivityAuthDialogBinding m0() {
        return (ActivityAuthDialogBinding) this.inflate.getValue();
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(m0().getRoot());
        init();
    }

    @Override // com.huachenjie.common.dialog.auth.AuthDialogContact.AuthDialogView
    public void r() {
        ARouter.getInstance().build(RoutePathConstants.Compat.c).navigation();
        finish();
    }

    @Override // com.huachenjie.common.base.BaseActivity, com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return false;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    @NotNull
    public a initPresenter() {
        return new a();
    }
}
