package com.huachenjie.common.dialog.auth;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.StudentSchoolAuthBean;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/dialog/auth/a;", "Lcom/huachenjie/common/dialog/auth/AuthDialogContact$Presenter;", "", "schoolCode", "", "f", "Lcom/zj/adlib/gq1;", "a", "Lcom/zj/adlib/gq1;", ze1.k, "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class a extends AuthDialogContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final gq1 model = new gq1();

    /* JADX INFO: renamed from: com.huachenjie.common.dialog.auth.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/common/dialog/auth/a$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/StudentSchoolAuthBean;", "data", "", "onCCSuccess", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class C0795a extends BizSubscriber<StudentSchoolAuthBean> {
        public C0795a() {
            super(true);
        }

        public void onCCSuccess(@Nullable StudentSchoolAuthBean data) {
            if (data != null) {
                ((AuthDialogContact.AuthDialogView) ((BasePresenter) a.this).f33638a).F(data.getLoginUrl());
            } else {
                ((AuthDialogContact.AuthDialogView) ((BasePresenter) a.this).f33638a).r();
            }
        }
    }

    @Override // com.huachenjie.common.dialog.auth.AuthDialogContact.Presenter
    public void f(@NotNull String schoolCode) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        n76.d(this.model.d(schoolCode)).c(this).p5(new C0795a());
    }
}
