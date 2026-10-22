package com.huachenjie.college.page.sport;

import android.content.Intent;
import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.college.bean.HuaweiHealthEntryStatusBean;
import com.huachenjie.college.page.hw_health.HWHealthActivity;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.su9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "data", "Lcom/huachenjie/college/bean/HuaweiHealthEntryStatusBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CollegeActivity$initDataObserve$2 extends Lambda implements Function1<HuaweiHealthEntryStatusBean, Unit> {
    final /* synthetic */ CollegeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollegeActivity$initDataObserve$2(CollegeActivity collegeActivity) {
        super(1);
        this.this$0 = collegeActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CollegeActivity collegeActivity, HuaweiHealthEntryStatusBean huaweiHealthEntryStatusBean, View view) {
        Intrinsics.checkNotNullParameter(collegeActivity, "this$0");
        su9.w(collegeActivity, huaweiHealthEntryStatusBean.getAuthUrl(), true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HuaweiHealthEntryStatusBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final HuaweiHealthEntryStatusBean huaweiHealthEntryStatusBean) {
        if (!huaweiHealthEntryStatusBean.getSchoolOpened()) {
            fv5.b("学校暂未开通此功能");
        } else if (huaweiHealthEntryStatusBean.getAuthStatus()) {
            this.this$0.startActivity(new Intent(this.this$0, (Class<?>) HWHealthActivity.class));
        } else {
            final CollegeActivity collegeActivity = this.this$0;
            ft1.q(collegeActivity, "授权提示", "为了提供手表运动数据与阳光跑进行锻炼抵扣，需要获取您的华为运动健康数据授权，请在授权页面勾选全部数据类型。", OptionsPickerHelper.e, "去授权", new View.OnClickListener() { // from class: com.huachenjie.college.page.sport.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollegeActivity$initDataObserve$2.invoke$lambda$0(collegeActivity, huaweiHealthEntryStatusBean, view);
                }
            });
        }
    }
}
