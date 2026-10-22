package com.huachenjie.sport.page.mine.sport_test.result;

import android.annotation.SuppressLint;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendanceType;
import com.huachenjie.sport.bean.ScoringItem;
import com.huachenjie.sport.databinding.ItemSportTestResultScoreBinding;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0015¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/ScoringItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemSportTestResultScoreBinding;", "()V", "convert", "", "holder", "item", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SportTestResultScoreAdapter extends BaseQuickAdapter<ScoringItem, BaseDataBindingHolder<ItemSportTestResultScoreBinding>> {
    public SportTestResultScoreAdapter() {
        super(R.layout.item_sport_test_result_score, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemSportTestResultScoreBinding> holder, @NotNull ScoringItem item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemSportTestResultScoreBinding itemSportTestResultScoreBinding = (ItemSportTestResultScoreBinding) holder.getDataBinding();
        if (itemSportTestResultScoreBinding != null) {
            itemSportTestResultScoreBinding.k(item);
            Integer projectType = item.getProjectType();
            String strC = "暂无";
            if (projectType != null && projectType.intValue() == 1) {
                itemSportTestResultScoreBinding.b.setText("身高");
                TextView textView = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.1f", item.getTestResult());
                }
                textView.setText(strC);
                itemSportTestResultScoreBinding.e.setText("厘米");
            } else if (projectType != null && projectType.intValue() == 2) {
                itemSportTestResultScoreBinding.b.setText("体重");
                TextView textView2 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.1f", item.getTestResult());
                }
                textView2.setText(strC);
                itemSportTestResultScoreBinding.e.setText("公斤");
            } else if (projectType != null && projectType.intValue() == 3) {
                itemSportTestResultScoreBinding.b.setText("体重指数（BMI）");
                TextView textView3 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.1f", item.getTestResult());
                }
                textView3.setText(strC);
                itemSportTestResultScoreBinding.e.setText("");
            } else if (projectType != null && projectType.intValue() == 4) {
                itemSportTestResultScoreBinding.b.setText("肺活量");
                TextView textView4 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = "" + ((int) item.getTestResult().doubleValue());
                }
                textView4.setText(strC);
                itemSportTestResultScoreBinding.e.setText("毫升");
            } else if (projectType != null && projectType.intValue() == 5) {
                itemSportTestResultScoreBinding.b.setText("50米跑");
                TextView textView5 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.1f", item.getTestResult());
                }
                textView5.setText(strC);
                itemSportTestResultScoreBinding.e.setText("秒");
            } else if (projectType != null && projectType.intValue() == 6) {
                itemSportTestResultScoreBinding.b.setText("立定跳远");
                TextView textView6 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.2f", item.getTestResult());
                }
                textView6.setText(strC);
                itemSportTestResultScoreBinding.e.setText("米");
            } else if (projectType != null && projectType.intValue() == 7) {
                itemSportTestResultScoreBinding.b.setText("坐位体前屈");
                TextView textView7 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = ys8.c("%.1f", item.getTestResult());
                }
                textView7.setText(strC);
                itemSportTestResultScoreBinding.e.setText("厘米");
            } else if (projectType != null && projectType.intValue() == 8) {
                itemSportTestResultScoreBinding.b.setText("800米跑");
                if (item.getTestResult() == null || !item.getTestFlag()) {
                    itemSportTestResultScoreBinding.c.setText("");
                    itemSportTestResultScoreBinding.d.setVisibility(8);
                    itemSportTestResultScoreBinding.e.setVisibility(8);
                    itemSportTestResultScoreBinding.f.setVisibility(8);
                } else {
                    double d = 60;
                    itemSportTestResultScoreBinding.c.setText(String.valueOf((int) (item.getTestResult().doubleValue() / d)));
                    itemSportTestResultScoreBinding.d.setText(String.valueOf((int) (item.getTestResult().doubleValue() % d)));
                    itemSportTestResultScoreBinding.e.setText("分");
                    itemSportTestResultScoreBinding.f.setText("秒");
                }
            } else if (projectType != null && projectType.intValue() == 9) {
                itemSportTestResultScoreBinding.b.setText("1000米跑");
                if (item.getTestResult() == null || !item.getTestFlag()) {
                    itemSportTestResultScoreBinding.c.setText("");
                    itemSportTestResultScoreBinding.d.setVisibility(8);
                    itemSportTestResultScoreBinding.e.setVisibility(8);
                    itemSportTestResultScoreBinding.f.setVisibility(8);
                } else {
                    itemSportTestResultScoreBinding.c.setText("" + ((int) (item.getTestResult().doubleValue() / 60.0d)));
                    itemSportTestResultScoreBinding.d.setText("" + ((int) (item.getTestResult().doubleValue() % 60.0d)));
                    itemSportTestResultScoreBinding.e.setText("分");
                    itemSportTestResultScoreBinding.f.setText("秒");
                }
            } else if (projectType != null && projectType.intValue() == 10) {
                itemSportTestResultScoreBinding.b.setText("引体向上");
                TextView textView8 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = "" + ((int) item.getTestResult().doubleValue());
                }
                textView8.setText(strC);
                itemSportTestResultScoreBinding.e.setText("个");
            } else if (projectType != null && projectType.intValue() == 11) {
                itemSportTestResultScoreBinding.b.setText("一分钟仰卧起坐");
                TextView textView9 = itemSportTestResultScoreBinding.c;
                if (item.getTestResult() != null && item.getTestFlag()) {
                    strC = "" + ((int) item.getTestResult().doubleValue());
                }
                textView9.setText(strC);
                itemSportTestResultScoreBinding.e.setText("次");
            }
            Integer score = item.getScore();
            if (score != null) {
                int iIntValue = score.intValue();
                itemSportTestResultScoreBinding.g.setText("" + iIntValue + (char) 20998);
            }
            if (item.getTestFlag()) {
                Integer signalLevel = item.getSignalLevel();
                if (signalLevel != null && signalLevel.intValue() == 1) {
                    TextView textView10 = itemSportTestResultScoreBinding.f36534a;
                    Integer projectType2 = item.getProjectType();
                    textView10.setText((projectType2 != null && projectType2.intValue() == 3) ? "肥胖" : "不及格");
                    itemSportTestResultScoreBinding.f36534a.setTextColor(zn1.a(R.color.color_999999));
                } else if (signalLevel != null && signalLevel.intValue() == 2) {
                    TextView textView11 = itemSportTestResultScoreBinding.f36534a;
                    Integer projectType3 = item.getProjectType();
                    textView11.setText((projectType3 != null && projectType3.intValue() == 3) ? "超重" : "及格");
                    itemSportTestResultScoreBinding.f36534a.setTextColor(zn1.a(R.color.color_999999));
                } else if (signalLevel != null && signalLevel.intValue() == 3) {
                    TextView textView12 = itemSportTestResultScoreBinding.f36534a;
                    Integer projectType4 = item.getProjectType();
                    textView12.setText((projectType4 != null && projectType4.intValue() == 3) ? "低体重" : "良好");
                    itemSportTestResultScoreBinding.f36534a.setTextColor(zn1.a(R.color.color_main_v2));
                } else if (signalLevel != null && signalLevel.intValue() == 4) {
                    TextView textView13 = itemSportTestResultScoreBinding.f36534a;
                    Integer projectType5 = item.getProjectType();
                    textView13.setText((projectType5 != null && projectType5.intValue() == 3) ? AttendanceType.CLOCKED_IN : "优秀");
                    itemSportTestResultScoreBinding.f36534a.setTextColor(zn1.a(R.color.color_main_v2));
                } else {
                    itemSportTestResultScoreBinding.g.setVisibility(8);
                    itemSportTestResultScoreBinding.f36534a.setVisibility(8);
                }
            } else {
                itemSportTestResultScoreBinding.g.setVisibility(8);
                itemSportTestResultScoreBinding.f36534a.setVisibility(8);
            }
            itemSportTestResultScoreBinding.executePendingBindings();
        }
    }
}
