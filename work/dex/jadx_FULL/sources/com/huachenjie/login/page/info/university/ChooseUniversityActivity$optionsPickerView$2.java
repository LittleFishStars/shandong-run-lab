package com.huachenjie.login.page.info.university;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.huachenjie.login.bean.GradeBean;
import com.zj.adlib.fr6;
import com.zj.adlib.rd6;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/zj/adlib/rd6;", "", BridgeDSL.INVOKE, "()Lcom/zj/adlib/rd6;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class ChooseUniversityActivity$optionsPickerView$2 extends Lambda implements Function0<rd6<String>> {
    final /* synthetic */ ChooseUniversityActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseUniversityActivity$optionsPickerView$2(ChooseUniversityActivity chooseUniversityActivity) {
        super(0);
        this.this$0 = chooseUniversityActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(ChooseUniversityActivity chooseUniversityActivity, int i, int i2, int i3, View view) {
        GradeBean gradeBean;
        Intrinsics.checkNotNullParameter(chooseUniversityActivity, "this$0");
        List<GradeBean> value = ChooseUniversityActivity.a0(chooseUniversityActivity).m().getValue();
        if (value == null || (gradeBean = value.get(i)) == null) {
            return;
        }
        ChooseUniversityActivity.a0(chooseUniversityActivity).k().setValue(gradeBean);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final rd6<String> m449invoke() {
        fr6 fr6Var = fr6.f41739a;
        final ChooseUniversityActivity chooseUniversityActivity = this.this$0;
        return fr6Var.c(chooseUniversityActivity, new OnOptionsSelectListener() { // from class: com.huachenjie.login.page.info.university.a
            @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
            public final void a(int i, int i2, int i3, View view) {
                ChooseUniversityActivity$optionsPickerView$2.invoke$lambda$1(chooseUniversityActivity, i, i2, i3, view);
            }
        });
    }
}
