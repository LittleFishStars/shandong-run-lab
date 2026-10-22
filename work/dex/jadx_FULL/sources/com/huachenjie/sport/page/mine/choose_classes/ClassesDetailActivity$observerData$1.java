package com.huachenjie.sport.page.mine.choose_classes;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.dialog.AlertDialog;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", o.f, "", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE, "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ClassesDetailActivity$observerData$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ClassesDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassesDetailActivity$observerData$1(ClassesDetailActivity classesDetailActivity) {
        super(1);
        this.this$0 = classesDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2$lambda$1(ClassesDetailActivity classesDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(classesDetailActivity, "this$0");
        ((ClassesDetailVM) ((BaseVmActivity) classesDetailActivity).f8507a).F();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        if (num != null) {
            final ClassesDetailActivity classesDetailActivity = this.this$0;
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                alertDataBean.setContent("本学期选课次数已用完，请联系你的体育老师进行调课。");
                alertDataBean.setConfirm("我知道了");
                AlertDialog.INSTANCE.a(alertDataBean).show(classesDetailActivity.getSupportFragmentManager(), "AlertDialog");
                return;
            }
            if (iIntValue > 0) {
                AlertDialog.AlertDataBean alertDataBean2 = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                alertDataBean2.setContent("确认要重新选课吗？你还有" + iIntValue + "次选课机会，请谨慎选择要参加的课程！");
                alertDataBean2.setCancel(OptionsPickerHelper.e);
                alertDataBean2.setConfirm("确定重选");
                AlertDialog.INSTANCE.b(alertDataBean2, new View.OnClickListener() { // from class: com.huachenjie.sport.page.mine.choose_classes.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClassesDetailActivity$observerData$1.invoke$lambda$3$lambda$2$lambda$1(classesDetailActivity, view);
                    }
                }).show(classesDetailActivity.getSupportFragmentManager(), "AlertDialog");
            }
        }
    }
}
