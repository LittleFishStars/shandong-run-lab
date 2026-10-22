package com.huachenjie.mall.page.express;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.huachenjie.mall.bean.ExpressLogisticsDetailBean;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.kuaishou.weapon.p0.t;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u000e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00158\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00158\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00158\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a¨\u0006)"}, d2 = {"Lcom/huachenjie/mall/page/express/ExpressLogisticsVm;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", ExpressLogisticsActivity.t, "", j.b, "", "Lcom/huachenjie/mall/bean/ExpressLogisticsBean;", GoodsSpecificationPreviewActivity.z, "originBean", "Lcom/huachenjie/mall/bean/ExpressLogisticsDetailBean;", "detailBean", "", CollegeTownItemFragment.ITEM_TYPE, "p", "Ljava/text/SimpleDateFormat;", "c", "Lkotlin/Lazy;", "k", "()Ljava/text/SimpleDateFormat;", "dateFormat", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", ExpressLogisticsActivity.x, "Lcom/huachenjie/common/bean/BindingTitleBean;", "b", "m", "titleBean", "Lcom/huachenjie/mall/bean/ExpressLogisticsOutBean;", t.d, "expressBean", "Lcom/huachenjie/mall/page/express/ExpressLogisticsAdapter;", "d", "j", "adapter", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ExpressLogisticsVm extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy dateFormat = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.huachenjie.mall.page.express.ExpressLogisticsVm$dateFormat$2
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("MM.dd HH:mm");
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isLightStatus = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExpressLogisticsOutBean> expressBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExpressLogisticsAdapter> adapter = new MutableLiveData<>();

    public static /* synthetic */ void q(ExpressLogisticsVm expressLogisticsVm, List list, ExpressLogisticsBean expressLogisticsBean, ExpressLogisticsDetailBean expressLogisticsDetailBean, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        expressLogisticsVm.p(list, expressLogisticsBean, expressLogisticsDetailBean, i);
    }

    @NotNull
    public final MutableLiveData<ExpressLogisticsAdapter> j() {
        return this.adapter;
    }

    public final SimpleDateFormat k() {
        return (SimpleDateFormat) this.dateFormat.getValue();
    }

    @NotNull
    public final MutableLiveData<ExpressLogisticsOutBean> l() {
        return this.expressBean;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> m() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.isLightStatus;
    }

    public final void o(@NotNull String logisticNo) {
        Intrinsics.checkNotNullParameter(logisticNo, ExpressLogisticsActivity.t);
        BaseViewModelExtKt.b(this, true, false, null, null, new ExpressLogisticsVm$queryExpressInfo$1(logisticNo, this, null), 14, null);
    }

    public final void p(List<ExpressLogisticsBean> list, ExpressLogisticsBean originBean, ExpressLogisticsDetailBean detailBean, int itemType) {
        String logisticNodeDesc = originBean.getLogisticNodeDesc();
        int logisticNode = originBean.getLogisticNode();
        String str = k().format(Long.valueOf(detailBean.getTime() * ((long) 1000)));
        Intrinsics.checkNotNullExpressionValue(str, "dateFormat.format(detailBean.time * 1000)");
        ExpressLogisticsBean expressLogisticsBean = new ExpressLogisticsBean(logisticNodeDesc, logisticNode, null, str, detailBean.getDesc(), itemType, 4, null);
        expressLogisticsBean.setPosition(list.size());
        expressLogisticsBean.setLightStatus(Intrinsics.areEqual(this.isLightStatus.getValue(), Boolean.TRUE));
        list.add(expressLogisticsBean);
    }
}
