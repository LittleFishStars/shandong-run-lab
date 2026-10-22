package com.huachenjie.run.page.run_index;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RunIndexActivity$recordAdapter$2 extends Lambda implements Function0<RunIndexRecordAdapter> {
    final /* synthetic */ RunIndexActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunIndexActivity$recordAdapter$2(RunIndexActivity runIndexActivity) {
        super(0);
        this.this$0 = runIndexActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$1(RunIndexRecordAdapter runIndexRecordAdapter, RunIndexActivity runIndexActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(runIndexRecordAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SportRecord sportRecord = (SportRecord) CollectionsKt.getOrNull(runIndexRecordAdapter.getData(), i);
        if (sportRecord != null) {
            runIndexActivity.R0(sportRecord.getRunRecordCode(), sportRecord.getSemesterCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$2(RunIndexActivity runIndexActivity, RunIndexRecordAdapter runIndexRecordAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        Intrinsics.checkNotNullParameter(runIndexRecordAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        runIndexActivity.P0(runIndexRecordAdapter.getItem(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4$lambda$3(RunIndexActivity runIndexActivity) {
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        RunIndexActivity.e0(runIndexActivity).q0();
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final RunIndexRecordAdapter m680invoke() {
        final RunIndexRecordAdapter runIndexRecordAdapter = new RunIndexRecordAdapter();
        final RunIndexActivity runIndexActivity = this.this$0;
        runIndexRecordAdapter.setHeaderWithEmptyEnable(true);
        View root = runIndexActivity.z0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerBinding.root");
        BaseQuickAdapter.setHeaderView$default(runIndexRecordAdapter, root, 0, 0, 6, null);
        runIndexRecordAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.huachenjie.run.page.run_index.b
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RunIndexActivity$recordAdapter$2.invoke$lambda$4$lambda$1(runIndexRecordAdapter, runIndexActivity, baseQuickAdapter, view, i);
            }
        });
        runIndexRecordAdapter.addChildClickViewIds(R.id.tvErrorBtn);
        runIndexRecordAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.huachenjie.run.page.run_index.c
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RunIndexActivity$recordAdapter$2.invoke$lambda$4$lambda$2(runIndexActivity, runIndexRecordAdapter, baseQuickAdapter, view, i);
            }
        });
        runIndexRecordAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.huachenjie.run.page.run_index.d
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RunIndexActivity$recordAdapter$2.invoke$lambda$4$lambda$3(runIndexActivity);
            }
        });
        return runIndexRecordAdapter;
    }
}
