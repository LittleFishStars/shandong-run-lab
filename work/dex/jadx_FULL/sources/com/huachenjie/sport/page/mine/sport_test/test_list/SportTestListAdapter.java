package com.huachenjie.sport.page.mine.sport_test.test_list;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestItemBean;
import com.huachenjie.sport.databinding.ItemSportTestBinding;
import com.zj.adlib.v79;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/SportTestItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemSportTestBinding;", "holder", "item", "", "convert", "", "K", "I", "type", "<init>", "(I)V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestListAdapter extends BaseQuickAdapter<SportTestItemBean, BaseDataBindingHolder<ItemSportTestBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int type;

    public SportTestListAdapter(int i) {
        super(R.layout.item_sport_test, null, 2, null);
        this.type = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemSportTestBinding> holder, @NotNull SportTestItemBean item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemSportTestBinding itemSportTestBinding = (ItemSportTestBinding) holder.getDataBinding();
        if (itemSportTestBinding != null) {
            itemSportTestBinding.m(item);
            itemSportTestBinding.l(Boolean.valueOf(this.type == 2));
            StringBuilder sb = new StringBuilder();
            Integer fitnessType = item.getFitnessType();
            if (fitnessType != null && fitnessType.intValue() == 3) {
                sb.append("补测");
            } else {
                sb.append("体测");
            }
            Integer fitnessTestStatus = item.getFitnessTestStatus();
            if (fitnessTestStatus != null && fitnessTestStatus.intValue() == 1) {
                sb.append("待开始");
            } else if (fitnessTestStatus != null && fitnessTestStatus.intValue() == 2) {
                sb.append("进行中");
            } else {
                sb.append("已结束");
            }
            itemSportTestBinding.b.setText(sb);
            TextView textView = itemSportTestBinding.b;
            Integer reserveTimeStatus = item.getReserveTimeStatus();
            textView.setBackgroundColor(zn1.a((reserveTimeStatus != null && reserveTimeStatus.intValue() == 2) ? R.color.color_FF762F : R.color.color_8997A4));
            Boolean userReserveStatus = item.getUserReserveStatus();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(userReserveStatus, bool)) {
                str = "已预约";
            } else {
                Integer reserveTimeStatus2 = item.getReserveTimeStatus();
                str = (reserveTimeStatus2 != null && reserveTimeStatus2.intValue() == 3) ? "预约已结束" : "立即预约体测";
            }
            itemSportTestBinding.f36526a.setText(str);
            boolean zAreEqual = Intrinsics.areEqual(item.getUserReserveStatus(), bool);
            String string = "";
            if (zAreEqual) {
                String reservePeriod = item.getReservePeriod();
                if (reservePeriod != null) {
                    string = reservePeriod;
                }
            } else {
                Integer reserveTimeStatus3 = item.getReserveTimeStatus();
                if (reserveTimeStatus3 != null && reserveTimeStatus3.intValue() == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    Long reserveStartTime = item.getReserveStartTime();
                    sb2.append(v79.Q0(reserveStartTime != null ? reserveStartTime.longValue() : 0L, "yyyy/MM/dd HH:mm"));
                    sb2.append("开始预约");
                    string = sb2.toString();
                } else {
                    Integer reserveTimeStatus4 = item.getReserveTimeStatus();
                    if (reserveTimeStatus4 != null && reserveTimeStatus4.intValue() == 2) {
                        StringBuilder sb3 = new StringBuilder();
                        Long reserveEndTime = item.getReserveEndTime();
                        sb3.append(v79.Q0(reserveEndTime != null ? reserveEndTime.longValue() : 0L, "yyyy/MM/dd HH:mm"));
                        sb3.append("结束预约");
                        string = sb3.toString();
                    }
                }
            }
            itemSportTestBinding.c.setText(string);
            itemSportTestBinding.executePendingBindings();
        }
    }
}
