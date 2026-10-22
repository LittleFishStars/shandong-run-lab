package com.huachenjie.sport.page.mine.attendance.rule;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.widget.AttendancePeriodView;
import com.huachenjie.common.bean.SignPeriod;
import com.huachenjie.common.bean.SignSegment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ItemAttendanceRuleBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/SignPeriod;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemAttendanceRuleBinding;", "()V", "convert", "", "holder", "item", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AttendanceRuleAdapter extends BaseQuickAdapter<SignPeriod, BaseDataBindingHolder<ItemAttendanceRuleBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public AttendanceRuleAdapter() {
        List list = null;
        super(R.layout.item_attendance_rule, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemAttendanceRuleBinding> holder, @NotNull SignPeriod item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        AttendancePeriodView attendancePeriodView = (AttendancePeriodView) holder.getView(R.id.period_view);
        ArrayList arrayList = new ArrayList();
        for (SignSegment signSegment : item.getTimeSegmentList()) {
            if (signSegment.getFinishFlag()) {
                arrayList.add(new AttendancePeriodView.PeriodBean("签到时段：" + signSegment.getStartTime() + '~' + signSegment.getEndTime(), "签退时段：" + signSegment.getFinishStartTime() + '~' + signSegment.getFinishEndTime()));
            } else {
                arrayList.add(new AttendancePeriodView.PeriodBean("签到时段：" + signSegment.getStartTime() + '~' + signSegment.getEndTime(), ""));
            }
        }
        attendancePeriodView.setPeriodData(arrayList);
        ItemAttendanceRuleBinding itemAttendanceRuleBinding = (ItemAttendanceRuleBinding) holder.getDataBinding();
        if (itemAttendanceRuleBinding != null) {
            itemAttendanceRuleBinding.o(item);
            itemAttendanceRuleBinding.executePendingBindings();
        }
    }
}
