package com.huachenjie.run.page.run_index;

import android.view.View;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunLayoutIndexHeaderBinding;
import com.huachenjie.run.page.run_index.RunIndexActivity.a;
import com.huachenjie.run.page.run_index.adapter.DeductionType;
import com.zj.adlib.DeductionTip;
import com.zj.adlib.lk0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/huachenjie/run/databinding/RunLayoutIndexHeaderBinding;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RunIndexActivity$headerBinding$2 extends Lambda implements Function0<RunLayoutIndexHeaderBinding> {
    final /* synthetic */ RunIndexActivity this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35923a;

        static {
            int[] iArr = new int[DeductionType.values().length];
            try {
                iArr[DeductionType.AI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeductionType.VENUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeductionType.WEARABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeductionType.OUTSIDE_ATTEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f35923a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunIndexActivity$headerBinding$2(RunIndexActivity runIndexActivity) {
        super(0);
        this.this$0 = runIndexActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(RunIndexActivity runIndexActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        DeductionTip itemOrNull = runIndexActivity.y0().getItemOrNull(i);
        if (itemOrNull == null) {
            return;
        }
        int i2 = a.f35923a[itemOrNull.getType().ordinal()];
        if (i2 == 1) {
            runIndexActivity.Y0();
            return;
        }
        if (i2 == 2) {
            runIndexActivity.b1();
        } else if (i2 == 3) {
            runIndexActivity.c1();
        } else {
            if (i2 != 4) {
                return;
            }
            runIndexActivity.Z0();
        }
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final RunLayoutIndexHeaderBinding m679invoke() {
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.run_layout_index_header, null, false);
        final RunIndexActivity runIndexActivity = this.this$0;
        RunLayoutIndexHeaderBinding runLayoutIndexHeaderBinding = (RunLayoutIndexHeaderBinding) viewDataBindingInflate;
        RecyclerView recyclerView = runLayoutIndexHeaderBinding.f12062a;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(runIndexActivity.y0());
        recyclerView.setItemAnimator(null);
        runIndexActivity.y0().setOnItemClickListener(new OnItemClickListener() { // from class: com.huachenjie.run.page.run_index.a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RunIndexActivity$headerBinding$2.invoke$lambda$2$lambda$1(runIndexActivity, baseQuickAdapter, view, i);
            }
        });
        runLayoutIndexHeaderBinding.setVariable(lk0.p0, RunIndexActivity.e0(runIndexActivity));
        runLayoutIndexHeaderBinding.setVariable(lk0.k, runIndexActivity.new a());
        runLayoutIndexHeaderBinding.setLifecycleOwner(runIndexActivity);
        return runLayoutIndexHeaderBinding;
    }
}
