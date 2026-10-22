package com.huachenjie.sport.page.mine.attendance.plan;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendancePlanBean;
import com.huachenjie.sport.databinding.ItemAttendancePlanBinding;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/AttendancePlanBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemAttendancePlanBinding;", "holder", "item", "", "convert", "", "position", y6b.g, "K", "I", "f", "()I", y6b.f, "(I)V", "currentPosition", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePlanAdapter extends BaseQuickAdapter<AttendancePlanBean, BaseDataBindingHolder<ItemAttendancePlanBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int currentPosition;

    /* JADX WARN: Illegal instructions before constructor call */
    public AttendancePlanAdapter() {
        List list = null;
        super(R.layout.item_attendance_plan, list, 2, list);
        this.currentPosition = -1;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final void g(int i) {
        this.currentPosition = i;
    }

    public final void h(int position) {
        int i;
        boolean z = false;
        if (position >= 0 && position < getData().size()) {
            z = true;
        }
        if (z && position != (i = this.currentPosition)) {
            this.currentPosition = position;
            notifyItemChanged(i);
            notifyItemChanged(this.currentPosition);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemAttendancePlanBinding> holder, @NotNull AttendancePlanBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemAttendancePlanBinding itemAttendancePlanBinding = (ItemAttendancePlanBinding) holder.getDataBinding();
        if (itemAttendancePlanBinding != null) {
            itemAttendancePlanBinding.m(Integer.valueOf(getItemPosition(item)));
            itemAttendancePlanBinding.n(Integer.valueOf(this.currentPosition));
            itemAttendancePlanBinding.o(item);
            itemAttendancePlanBinding.executePendingBindings();
        }
    }
}
