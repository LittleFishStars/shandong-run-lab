package com.huachenjie.login.page.info.sex;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.huachenjie.login.R;
import com.zj.adlib.f79;
import com.zj.adlib.fr6;
import com.zj.adlib.s72;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/zj/adlib/f79;", BridgeDSL.INVOKE, "()Lcom/zj/adlib/f79;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class ChooseSexActivity$timePickerView$2 extends Lambda implements Function0<f79> {
    final /* synthetic */ ChooseSexActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseSexActivity$timePickerView$2(ChooseSexActivity chooseSexActivity) {
        super(0);
        this.this$0 = chooseSexActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(ChooseSexActivity chooseSexActivity, Date date, View view) {
        Intrinsics.checkNotNullParameter(chooseSexActivity, "this$0");
        Intrinsics.checkNotNullParameter(date, "date");
        ChooseSexActivity.Z(chooseSexActivity).j().setValue(Long.valueOf(date.getTime()));
        ChooseSexActivity.Z(chooseSexActivity).i().setValue(s72.c(date.getTime(), chooseSexActivity.getResources().getString(R.string.login_choose_sex_birthday_time)));
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final f79 m448invoke() {
        fr6 fr6Var = fr6.f41739a;
        final ChooseSexActivity chooseSexActivity = this.this$0;
        return fr6Var.e(chooseSexActivity, new OnTimeSelectListener() { // from class: com.huachenjie.login.page.info.sex.a
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void a(Date date, View view) {
                ChooseSexActivity$timePickerView$2.invoke$lambda$1(chooseSexActivity, date, view);
            }
        });
    }
}
