package com.huachenjie.mall.page.apply_refund;

import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.PickedMedia;
import com.zj.adlib.gg3;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0005R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R%\u0010$\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u000b8\u0006¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010¨\u0006/"}, d2 = {"Lcom/huachenjie/mall/page/apply_refund/ApplyRefundVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "Lcom/zj/adlib/wq6;", "items", "", "t", "Lcom/huachenjie/mall/page/apply_refund/ApplyRefundFileAdapter;", "adapter", "j", "s", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", WriteReviewActivity.x, "", "kotlin.jvm.PlatformType", "c", "q", "refundType", "", "d", "n", "refundPrice", "Lcom/huachenjie/mall/bean/OrderReasonBean;", "e", j.b, "refundReason", "f", "p", "refundText", y6b.f, "m", "picAdapter", "", y6b.g, "r", "showPicList", "i", "k", "applyRefundResult", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nApplyRefundVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplyRefundVM.kt\ncom/huachenjie/mall/page/apply_refund/ApplyRefundVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,130:1\n1549#2:131\n1620#2,3:132\n*S KotlinDebug\n*F\n+ 1 ApplyRefundVM.kt\ncom/huachenjie/mall/page/apply_refund/ApplyRefundVM\n*L\n85#1:131\n85#1:132,3\n*E\n"})
public final class ApplyRefundVM extends BaseTitleViewModel {
    public static final int K = 6;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 60;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderGoodsBean> goodsBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> refundType = new MutableLiveData<>(-1);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> refundPrice = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderReasonBean> refundReason = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> refundText = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ApplyRefundFileAdapter> picAdapter = new MutableLiveData<>(new ApplyRefundFileAdapter());

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showPicList = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> applyRefundResult = new MutableLiveData<>();

    public final void j(@NotNull ApplyRefundFileAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        String strF = ys8.f(R.string.mall_activity_apply_refund_size_remain, String.valueOf(6 - adapter.getData().size()));
        Intrinsics.checkNotNullExpressionValue(strF, "getString(\n             ….size}\"\n                )");
        adapter.addData(new ApplyRefundFileBean(2, null, null, strF, 6, null));
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.applyRefundResult;
    }

    @NotNull
    public final MutableLiveData<OrderGoodsBean> l() {
        return this.goodsBean;
    }

    @NotNull
    public final MutableLiveData<ApplyRefundFileAdapter> m() {
        return this.picAdapter;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.refundPrice;
    }

    @NotNull
    public final MutableLiveData<OrderReasonBean> o() {
        return this.refundReason;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.refundText;
    }

    @NotNull
    public final MutableLiveData<Integer> q() {
        return this.refundType;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.showPicList;
    }

    public final void s() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ApplyRefundVM$submitRefund$1(this, null), 14, null);
    }

    public final void t(@NotNull List<PickedMedia> items) throws IOException {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.isEmpty()) {
            return;
        }
        g();
        final Function1<List<? extends ApplyRefundFileBean>, Unit> function1 = new Function1<List<? extends ApplyRefundFileBean>, Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundVM$uploadFiles$adapterCallback$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ApplyRefundFileBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<ApplyRefundFileBean> list) {
                Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
                ApplyRefundFileAdapter value = this.this$0.m().getValue();
                Intrinsics.checkNotNull(value);
                ApplyRefundFileAdapter applyRefundFileAdapter = value;
                if (!applyRefundFileAdapter.getData().isEmpty()) {
                    applyRefundFileAdapter.removeAt(applyRefundFileAdapter.getData().size() - 1);
                }
                applyRefundFileAdapter.addData((Collection) list);
                if (applyRefundFileAdapter.getData().size() < 6) {
                    this.this$0.j(applyRefundFileAdapter);
                }
                this.this$0.r().setValue(Boolean.TRUE);
                this.this$0.c();
            }
        };
        if (((PickedMedia) CollectionsKt.first(items)).f()) {
            v41.e(ViewModelKt.getViewModelScope(this), jo2.c(), (CoroutineStart) null, new ApplyRefundVM$uploadFiles$1(items, function1, null), 2, (Object) null);
            return;
        }
        gg3 gg3Var = gg3.f41898a;
        List<PickedMedia> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PickedMedia) it.next()).e());
        }
        gg3Var.d(arrayList, new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundVM$uploadFiles$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<String> list2) {
                if (list2 == null) {
                    this.c();
                    return;
                }
                Function1<List<ApplyRefundFileBean>, Unit> function2 = function1;
                List<String> list3 = list2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new ApplyRefundFileBean(0, (String) it2.next(), null, null, 13, null));
                }
                function2.invoke(arrayList2);
            }
        });
    }
}
