package com.huachenjie.run.page.rankinglist;

import android.text.TextUtils;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.page.rankinglist.RankingDrawerPlanAdapter;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/RankingDrawerPlanAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/RunPlanBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "f", "Ljava/lang/String;", y6b.f, "()Ljava/lang/String;", y6b.g, "(Ljava/lang/String;)V", "checkedCode", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RankingDrawerPlanAdapter extends BaseQuickAdapter<RunPlanBean, BaseViewHolder> {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String checkedCode;

    public RankingDrawerPlanAdapter() {
        super(R.layout.run_item_ranking_drawer_plan, null, 2, null);
        this.checkedCode = "";
    }

    public static final void f(RankingDrawerPlanAdapter rankingDrawerPlanAdapter, RunPlanBean runPlanBean, View view) {
        Intrinsics.checkNotNullParameter(rankingDrawerPlanAdapter, "this$0");
        Intrinsics.checkNotNullParameter(runPlanBean, "$item");
        String runPlanCode = runPlanBean.getRunPlanCode();
        Intrinsics.checkNotNull(runPlanCode);
        rankingDrawerPlanAdapter.checkedCode = runPlanCode;
        rankingDrawerPlanAdapter.notifyDataSetChanged();
    }

    @NotNull
    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getCheckedCode() {
        return this.checkedCode;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkedCode = str;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull final RunPlanBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        CheckTextView checkTextView = (CheckTextView) holder.getView(R.id.tv);
        checkTextView.setText(item.getRunPlanName());
        checkTextView.setChecked(TextUtils.equals(item.getRunPlanCode(), this.checkedCode));
        checkTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.oa7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingDrawerPlanAdapter.f(this.f18599a, item, view);
            }
        });
    }
}
