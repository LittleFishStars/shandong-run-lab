package com.huachenjie.sport.page.mine.sport_test.result;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AddPointItem;
import com.huachenjie.sport.databinding.ItemSportTestResultAddScoreBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultAddScoreAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/AddPointItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemSportTestResultAddScoreBinding;", "()V", "convert", "", "holder", "item", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SportTestResultAddScoreAdapter extends BaseQuickAdapter<AddPointItem, BaseDataBindingHolder<ItemSportTestResultAddScoreBinding>> {
    public SportTestResultAddScoreAdapter() {
        super(R.layout.item_sport_test_result_add_score, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemSportTestResultAddScoreBinding> holder, @NotNull AddPointItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemSportTestResultAddScoreBinding itemSportTestResultAddScoreBinding = (ItemSportTestResultAddScoreBinding) holder.getDataBinding();
        if (itemSportTestResultAddScoreBinding != null) {
            itemSportTestResultAddScoreBinding.k(item);
            Integer projectType = item.getProjectType();
            if (projectType != null && projectType.intValue() == 1) {
                itemSportTestResultAddScoreBinding.f36532a.setText("身高");
            } else if (projectType != null && projectType.intValue() == 2) {
                itemSportTestResultAddScoreBinding.f36532a.setText("体重");
            } else if (projectType != null && projectType.intValue() == 3) {
                itemSportTestResultAddScoreBinding.f36532a.setText("体重指数（BMI）");
            } else if (projectType != null && projectType.intValue() == 4) {
                itemSportTestResultAddScoreBinding.f36532a.setText("肺活量");
            } else if (projectType != null && projectType.intValue() == 5) {
                itemSportTestResultAddScoreBinding.f36532a.setText("50米");
            } else if (projectType != null && projectType.intValue() == 6) {
                itemSportTestResultAddScoreBinding.f36532a.setText("立定跳远");
            } else if (projectType != null && projectType.intValue() == 7) {
                itemSportTestResultAddScoreBinding.f36532a.setText("坐位体前屈");
            } else if (projectType != null && projectType.intValue() == 8) {
                itemSportTestResultAddScoreBinding.f36532a.setText("800米跑");
            } else if (projectType != null && projectType.intValue() == 9) {
                itemSportTestResultAddScoreBinding.f36532a.setText("1000米跑");
            } else if (projectType != null && projectType.intValue() == 10) {
                itemSportTestResultAddScoreBinding.f36532a.setText("引体向上");
            } else if (projectType != null && projectType.intValue() == 11) {
                itemSportTestResultAddScoreBinding.f36532a.setText("一分钟仰卧起坐");
            }
            itemSportTestResultAddScoreBinding.executePendingBindings();
        }
    }
}
