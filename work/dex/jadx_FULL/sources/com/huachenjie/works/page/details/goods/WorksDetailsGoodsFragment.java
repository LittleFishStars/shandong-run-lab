package com.huachenjie.works.page.details.goods;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.huachenjie.works.bean.RecommendGoodsBean;
import com.huachenjie.works.databinding.WorksFragmentWorksDetailGoodsBinding;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment;
import com.zj.adlib.fx7;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/huachenjie/works/page/details/goods/WorksDetailsGoodsFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentWorksDetailGoodsBinding;", "Lcom/huachenjie/works/page/details/goods/WorksDetailsGoodsVM;", "", "initAdapter", "", "", "", "getVariables", "getWidth", "getHeight", "getLayoutResID", "initView", "Landroid/view/View;", "v", "onDismissDialog", "Lcom/huachenjie/works/bean/GoodsRecommendData;", "workGoodsData$delegate", "Lkotlin/Lazy;", "getWorkGoodsData", "()Lcom/huachenjie/works/bean/GoodsRecommendData;", WorksDetailsGoodsFragment.WORK_GOODS_DATA, "", "worksNo$delegate", "getWorksNo", "()Ljava/lang/String;", yj7.g.WORKS_NO, "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksDetailsGoodsFragment extends BaseMVVMBottomDialogFragment<WorksFragmentWorksDetailGoodsBinding, WorksDetailsGoodsVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String WORK_GOODS_DATA = "workGoodsData";

    @NotNull
    public static final String WORK_NO = "workNo";

    /* JADX INFO: renamed from: workGoodsData$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy workGoodsData = LazyKt.lazy(new Function0<GoodsRecommendData>() { // from class: com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment$workGoodsData$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final GoodsRecommendData m920invoke() {
            Bundle arguments = this.this$0.getArguments();
            GoodsRecommendData goodsRecommendData = arguments != null ? (GoodsRecommendData) arguments.getParcelable(WorksDetailsGoodsFragment.WORK_GOODS_DATA) : null;
            return goodsRecommendData == null ? new GoodsRecommendData(null, 1, null) : goodsRecommendData;
        }
    });

    /* JADX INFO: renamed from: worksNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment$worksNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("workNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/details/goods/WorksDetailsGoodsFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", yj7.g.WORKS_NO, "Lcom/huachenjie/works/bean/GoodsRecommendData;", WorksDetailsGoodsFragment.WORK_GOODS_DATA, "", "a", "WORK_GOODS_DATA", "Ljava/lang/String;", "WORK_NO", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String worksNo, @Nullable GoodsRecommendData workGoodsData) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
            WorksDetailsGoodsFragment worksDetailsGoodsFragment = new WorksDetailsGoodsFragment();
            Bundle bundle = new Bundle();
            if (workGoodsData == null) {
                workGoodsData = new GoodsRecommendData(null, 1, null);
            }
            bundle.putParcelable(WorksDetailsGoodsFragment.WORK_GOODS_DATA, workGoodsData);
            bundle.putString("workNo", worksNo);
            worksDetailsGoodsFragment.setArguments(bundle);
            worksDetailsGoodsFragment.show(fragmentManager, "WorksDetailsGoodsFragment");
        }
    }

    private final GoodsRecommendData getWorkGoodsData() {
        return (GoodsRecommendData) this.workGoodsData.getValue();
    }

    private final String getWorksNo() {
        return (String) this.worksNo.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        List<RecommendGoodsBean> arrayList;
        MutableLiveData<WorksDetailsGoodsAdapter> mutableLiveDataI = ((WorksDetailsGoodsVM) getMViewModel()).i();
        WorksDetailsGoodsAdapter worksDetailsGoodsAdapter = new WorksDetailsGoodsAdapter();
        GoodsRecommendData workGoodsData = getWorkGoodsData();
        if (workGoodsData == null || (arrayList = workGoodsData.getList()) == null) {
            arrayList = new ArrayList<>();
        }
        worksDetailsGoodsAdapter.setList(arrayList);
        y57.d(worksDetailsGoodsAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.h0a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WorksDetailsGoodsFragment.initAdapter$lambda$1$lambda$0(this.f42024a, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(worksDetailsGoodsAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$1$lambda$0(WorksDetailsGoodsFragment worksDetailsGoodsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<WorksDetailsGoodsAdapter> mutableLiveDataI;
        WorksDetailsGoodsAdapter value;
        Intrinsics.checkNotNullParameter(worksDetailsGoodsFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        WorksDetailsGoodsVM worksDetailsGoodsVM = (WorksDetailsGoodsVM) worksDetailsGoodsFragment.getMViewModel();
        if (worksDetailsGoodsVM == null || (mutableLiveDataI = worksDetailsGoodsVM.i()) == null || (value = mutableLiveDataI.getValue()) == null) {
            return;
        }
        ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", value.getData().get(i).getGoodsNo()).withString("source", "30").withString("traceNo", worksDetailsGoodsFragment.getWorksNo()).navigation();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return MathKt.roundToInt(fx7.h() * 0.66f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_works_detail_goods;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.s), this)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    public final void onDismissDialog(@Nullable View v) {
        dismiss();
    }
}
