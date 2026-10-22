package com.zj.adlib;

import android.widget.TextView;
import com.heytap.mcssdk.constant.b;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.util.weimai_hh.SpanHonghuUtil;
import com.huachenjie.run.databinding.RunActivitySchoolRuleV3Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/dw7;", "", "Landroid/widget/TextView;", "tvTitle", "tvPlanInfo", "Lcom/huachenjie/common/bean/SchoolRule;", b.p, "", "b", "Lcom/huachenjie/run/databinding/RunActivitySchoolRuleV3Binding;", "binding", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class dw7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dw7 f41295a = new dw7();

    public final void a(@NotNull RunActivitySchoolRuleV3Binding binding, @Nullable SchoolRule rule) {
        String str;
        Intrinsics.checkNotNullParameter(binding, "binding");
        if (rule == null) {
            binding.d.setText("");
            binding.f11560a.setText("");
            binding.f.setText("");
            return;
        }
        ll7 ll7Var = ll7.f43096a;
        String strJ = ll7Var.j(Long.valueOf(rule.getSingleMinDistance()), false, false, true, 1);
        String strJ2 = ll7Var.j(Long.valueOf(rule.getSingleMaxDistance() == 0 ? 10000L : rule.getSingleMaxDistance()), false, false, true, 1);
        TextView textView = binding.d;
        if (rule.getSingleMinDistance() != 0) {
            str = "最低" + strJ + "km -- 最高" + strJ2 + "km";
        } else {
            str = "最高" + strJ2 + "km";
        }
        textView.setText(str);
        if (rule.getDayMaxDistance() > 0) {
            binding.f11560a.setText(ll7Var.e(Integer.valueOf(rule.getDayMaxDistance()), false, false) + "km");
        }
        if (rule.getWeekMaxDistance() > 0) {
            binding.f.setText(ll7Var.e(Integer.valueOf(rule.getWeekMaxDistance()), false, false) + "km");
        }
    }

    public final void b(@NotNull TextView tvTitle, @NotNull TextView tvPlanInfo, @Nullable SchoolRule rule) {
        String str;
        Intrinsics.checkNotNullParameter(tvTitle, "tvTitle");
        Intrinsics.checkNotNullParameter(tvPlanInfo, "tvPlanInfo");
        if (rule == null) {
            return;
        }
        SpanHonghuUtil.SpanBuilder spanBuilderA = SpanHonghuUtil.a();
        String strI = ll7.f43096a.i(Long.valueOf(rule.getTotalDistance()), false, false, 0);
        if (rule.getTotalDistance() <= 0 || rule.getTotalTimes() <= 0) {
            if (rule.getTotalDistance() > 0) {
                spanBuilderA.j(strI, 1).A(strI, 36).a(" km", 16);
                str = "目标总公里数";
            } else if (rule.getTotalTimes() > 0) {
                spanBuilderA.j(String.valueOf(rule.getTotalTimes()), 1).A(String.valueOf(rule.getTotalTimes()), 36).a(" 次", 16);
                str = "目标总次数";
            } else {
                tvTitle.setText("");
            }
            tvTitle.setText(str);
            spanBuilderA.v0(tvPlanInfo);
        }
        spanBuilderA.j(strI, 1).A(strI, 36).a(" km", 16).h("    ").j(String.valueOf(rule.getTotalTimes()), 1).A(String.valueOf(rule.getTotalTimes()), 36).a(" 次", 16);
        str = "目标总公里数/总次数";
        tvTitle.setText(str);
        spanBuilderA.v0(tvPlanInfo);
    }
}
