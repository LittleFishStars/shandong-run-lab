package com.huachenjie.run.page.rankinglist;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.bean.RunPlanListBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.aw8;
import com.zj.adlib.n76;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u0006\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivityVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "titleBackground", "Lcom/zj/adlib/aw8;", "a", "Lcom/zj/adlib/aw8;", "j", "()Lcom/zj/adlib/aw8;", "sunshineModel", "", "Lcom/huachenjie/run/bean/RunPlanBean;", "runPlanList", "", "Z", "isLoadPlanList", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRankingActivityVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isLoadPlanList;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> titleBackground = new MutableLiveData<>(Integer.valueOf(zn1.a(R.color.transparent)));

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final aw8 sunshineModel = new aw8();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<RunPlanBean>> runPlanList = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/run/page/rankinglist/SunshineRankingActivityVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/run/bean/RunPlanListBean;", "data", "", "onCCSuccess", "onFinish", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<RunPlanListBean> {
        public a() {
            super(SunshineRankingActivityVM.this, true);
        }

        public void onFinish() {
            super.onFinish();
            SunshineRankingActivityVM.this.isLoadPlanList = false;
        }

        public void onCCSuccess(@Nullable RunPlanListBean data) {
            SunshineRankingActivityVM.this.i().setValue(data != null ? data.getList() : null);
        }
    }

    @NotNull
    public final MutableLiveData<List<RunPlanBean>> i() {
        return this.runPlanList;
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final aw8 getSunshineModel() {
        return this.sunshineModel;
    }

    @NotNull
    public final MutableLiveData<Integer> k() {
        return this.titleBackground;
    }

    public final void l() {
        if (this.isLoadPlanList) {
            return;
        }
        this.isLoadPlanList = true;
        n76.e(this, this.sunshineModel.g("")).p5(new a());
    }
}
