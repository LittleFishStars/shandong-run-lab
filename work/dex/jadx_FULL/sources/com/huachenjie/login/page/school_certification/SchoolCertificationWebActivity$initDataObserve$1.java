package com.huachenjie.login.page.school_certification;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.bean.SchoolAuthBean;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", o.f, "Lcom/huachenjie/login/bean/SchoolAuthBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SchoolCertificationWebActivity$initDataObserve$1 extends Lambda implements Function1<SchoolAuthBean, Unit> {
    final /* synthetic */ SchoolCertificationWebActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SchoolCertificationWebActivity$initDataObserve$1(SchoolCertificationWebActivity schoolCertificationWebActivity) {
        super(1);
        this.this$0 = schoolCertificationWebActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(SchoolCertificationWebActivity schoolCertificationWebActivity, String str, SchoolAuthBean schoolAuthBean, View view) {
        Intrinsics.checkNotNullParameter(schoolCertificationWebActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$schoolCode");
        Intrinsics.checkNotNullParameter(schoolAuthBean, "$result");
        schoolCertificationWebActivity.i0(str, schoolAuthBean.getUserInfo().getNumber(), schoolAuthBean.getBindKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(SchoolCertificationWebActivity schoolCertificationWebActivity, String str, SchoolAuthBean schoolAuthBean, View view) {
        Intrinsics.checkNotNullParameter(schoolCertificationWebActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$schoolCode");
        Intrinsics.checkNotNullParameter(schoolAuthBean, "$result");
        SchoolCertificationWebActivity.b0(schoolCertificationWebActivity).j(str, schoolAuthBean.getUserInfo().getNumber(), schoolAuthBean.getUserInfo().getPhone(), schoolAuthBean.getBindKey());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SchoolAuthBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final SchoolAuthBean schoolAuthBean) {
        if (schoolAuthBean == null) {
            return;
        }
        final String schoolCode = schoolAuthBean.getSchoolCode();
        int type = schoolAuthBean.getType();
        if (type == 0) {
            LoginResultData loginResult = schoolAuthBean.getLoginResult();
            if (loginResult != null) {
                this.this$0.d0(loginResult);
                return;
            }
            return;
        }
        if (type != 1) {
            if (type != 2) {
                return;
            }
            this.this$0.i0(schoolCode, schoolAuthBean.getUserInfo().getNumber(), schoolAuthBean.getBindKey());
            return;
        }
        String strReplace = new Regex("(\\d{3})\\d{4}(\\d{4})").replace(schoolAuthBean.getUserInfo().getPhone(), "$1****$2");
        SchoolCertificationWebActivity schoolCertificationWebActivity = this.this$0;
        String str = "是否使用手机号" + strReplace + "与闪动校园绑定";
        final SchoolCertificationWebActivity schoolCertificationWebActivity2 = this.this$0;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.huachenjie.login.page.school_certification.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SchoolCertificationWebActivity$initDataObserve$1.invoke$lambda$1(schoolCertificationWebActivity2, schoolCode, schoolAuthBean, view);
            }
        };
        final SchoolCertificationWebActivity schoolCertificationWebActivity3 = this.this$0;
        ft1.r(schoolCertificationWebActivity, "", str, "更换手机号", "确认绑定", onClickListener, new View.OnClickListener() { // from class: com.huachenjie.login.page.school_certification.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SchoolCertificationWebActivity$initDataObserve$1.invoke$lambda$2(schoolCertificationWebActivity3, schoolCode, schoolAuthBean, view);
            }
        });
    }
}
