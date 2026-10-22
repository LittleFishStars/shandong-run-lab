package com.huachenjie.mall.page.goods_detail;

import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailPicture;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpec;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.zj.adlib.cy6;
import com.zj.adlib.fk8;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b^\u0010_J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\fR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR%\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\f0\f0\u00188\u0006¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR%\u0010(\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\f0\f0\u00188\u0006¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00188\u0006¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001dR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006¢\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001dR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00109R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010DR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006¢\u0006\f\n\u0004\bF\u0010\u001b\u001a\u0004\bG\u0010\u001dR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0006¢\u0006\f\n\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010\u001dR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0006¢\u0006\f\n\u0004\bL\u0010\u001b\u001a\u0004\bM\u0010\u001dR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020O0\u00188\u0006¢\u0006\f\n\u0004\bP\u0010\u001b\u001a\u0004\bQ\u0010\u001dR$\u0010X\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010]\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\bD\u0010\\¨\u0006`"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "F", "O", o.f, "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;", "shopInfo", "N", "P", "", "goodsNo", "", "needLoading", "G", "", "selSpecIndexArray", "Q", "goodNo", "p", "M", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "E", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "b", "u", "goodsDetail", "kotlin.jvm.PlatformType", "c", "v", "goodsPrice", "d", "w", "outPrice", "Lcom/huachenjie/mall/page/goods_detail/GoodsDetailAdapter;", "e", "q", "adapter", "f", "C", "specStr", y6b.f, "A", CreatePosterDialog.SHARE_NO, "[I", j.o, "()[I", "K", "([I)V", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "selSku", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;", "B", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;", "L", "(Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;)V", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "countDownJob", "", "J", "remainTime", y6b.g, "y", "remainTimeStr", "i", "r", "canExchange", "j", "x", "promotion", "", "k", "D", "squareType", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "I", "(Ljava/lang/String;)V", "cooperationNo", "Z", "t", "()Z", "(Z)V", "fromReward", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGoodsDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodsDetailVM.kt\ncom/huachenjie/mall/page/goods_detail/GoodsDetailVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,255:1\n1559#2:256\n1590#2,4:257\n*S KotlinDebug\n*F\n+ 1 GoodsDetailVM.kt\ncom/huachenjie/mall/page/goods_detail/GoodsDetailVM\n*L\n166#1:256\n166#1:257,4\n*E\n"})
public final class GoodsDetailVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long remainTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GoodsDetailShop shopInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GoodsDetailSku selSku;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Job countDownJob;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean fromReward;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public int[] selSpecIndexArray;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String cooperationNo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GoodsDetailBean> goodsDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> goodsPrice = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> outPrice = new MutableLiveData<>("");

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GoodsDetailAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> specStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> shareNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> remainTimeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canExchange = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> promotion = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> squareType = new MutableLiveData<>(0);

    public static /* synthetic */ void H(GoodsDetailVM goodsDetailVM, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        goodsDetailVM.G(str, z);
    }

    @NotNull
    public final MutableLiveData<String> A() {
        return this.shareNo;
    }

    @Nullable
    /* JADX INFO: renamed from: B, reason: from getter */
    public final GoodsDetailShop getShopInfo() {
        return this.shopInfo;
    }

    @NotNull
    public final MutableLiveData<String> C() {
        return this.specStr;
    }

    @NotNull
    public final MutableLiveData<Integer> D() {
        return this.squareType;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> E() {
        return this.titleBean;
    }

    public final void F(GoodsDetailBean bean) {
        int size = bean.getSpecList().size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = 0;
        }
        this.selSpecIndexArray = iArr;
        fk8 fk8Var = fk8.f41700a;
        List<GoodsDetailSpec> specList = bean.getSpecList();
        List<GoodsDetailSku> skuList = bean.getSkuList();
        int[] iArr2 = this.selSpecIndexArray;
        Intrinsics.checkNotNull(iArr2);
        Pair<GoodsDetailSku, String> pairA = fk8Var.a(specList, skuList, iArr2);
        this.selSku = (GoodsDetailSku) pairA.getFirst();
        this.specStr.setValue((String) pairA.getSecond());
    }

    public final void G(@NotNull String goodsNo, boolean needLoading) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        BaseViewModelExtKt.b(this, needLoading, false, null, null, new GoodsDetailVM$loadData$1(this, goodsNo, null), 14, null);
    }

    public final void I(@Nullable String str) {
        this.cooperationNo = str;
    }

    public final void J(boolean z) {
        this.fromReward = z;
    }

    public final void K(@Nullable int[] iArr) {
        this.selSpecIndexArray = iArr;
    }

    public final void L(@Nullable GoodsDetailShop goodsDetailShop) {
        this.shopInfo = goodsDetailShop;
    }

    public final void M(@NotNull GoodsDetailBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        Job job = this.countDownJob;
        if (job != null && job.isActive()) {
            Job job2 = this.countDownJob;
            if (job2 != null) {
                Job.a.b(job2, (CancellationException) null, 1, (Object) null);
            }
            this.countDownJob = null;
        }
        this.canExchange.setValue(Boolean.valueOf(bean.getRemainTime() == -1 || bean.getRemainTime() > 0));
        if (bean.getGoodsStatus() == 1 && bean.getType() == 3 && bean.getRemainTime() >= 0) {
            this.remainTime = bean.getRemainTime();
            this.countDownJob = v41.e(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$startCountDown$1(this, null), 3, (Object) null);
        }
    }

    public final void N(GoodsDetailBean it, GoodsDetailShop shopInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(it.getOneGoodsComment());
        arrayList.add(shopInfo);
        if (!it.getDetailImageList().isEmpty()) {
            if (it.getDetailImageList().size() == 1) {
                it.getDetailImageList().get(0).setPositionType(3);
            } else {
                List<GoodsDetailPicture> detailImageList = it.getDetailImageList();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(detailImageList, 10));
                int i = 0;
                for (Object obj : detailImageList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    GoodsDetailPicture goodsDetailPicture = (GoodsDetailPicture) obj;
                    if (i == 0) {
                        goodsDetailPicture.setPositionType(1);
                    } else if (i == it.getDetailImageList().size() - 1) {
                        goodsDetailPicture.setPositionType(2);
                    } else {
                        goodsDetailPicture.setPositionType(0);
                    }
                    arrayList2.add(goodsDetailPicture);
                    i = i2;
                }
            }
            arrayList.add("商品详情");
            arrayList.addAll(it.getDetailImageList());
        }
        GoodsDetailAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(arrayList);
        }
    }

    public final void O() {
        GoodsDetailBean value = this.goodsDetail.getValue();
        if (value == null) {
            this.goodsPrice.setValue("");
            this.outPrice.setValue("");
            return;
        }
        if (!value.getMultipleSku() || this.selSku == null) {
            this.goodsPrice.setValue(cy6.e(value.getType(), value.getMultipleSku(), value.getMinSkuPrice(), value.getMaxSkuPrice(), value.getMinPointsInMinPriceSku(), value.getMaxPointsInMinPriceSku()));
            this.outPrice.setValue((char) 165 + value.getOutPrice());
            return;
        }
        MutableLiveData<String> mutableLiveData = this.goodsPrice;
        int type = value.getType();
        GoodsDetailSku goodsDetailSku = this.selSku;
        Intrinsics.checkNotNull(goodsDetailSku);
        String salePrice = goodsDetailSku.getSalePrice();
        GoodsDetailSku goodsDetailSku2 = this.selSku;
        Intrinsics.checkNotNull(goodsDetailSku2);
        mutableLiveData.setValue(cy6.h(type, salePrice, goodsDetailSku2.getPointsPrice()));
        MutableLiveData<String> mutableLiveData2 = this.outPrice;
        StringBuilder sb = new StringBuilder();
        sb.append((char) 165);
        GoodsDetailSku goodsDetailSku3 = this.selSku;
        Intrinsics.checkNotNull(goodsDetailSku3);
        sb.append(goodsDetailSku3.getOutPrice());
        mutableLiveData2.setValue(sb.toString());
    }

    public final void P() {
        String str;
        long j = this.remainTime;
        if (j <= 0) {
            this.remainTimeStr.setValue("剩余00:00:00");
            return;
        }
        long j2 = 86400;
        long j3 = j / j2;
        long j4 = 3600;
        long j5 = (j % j2) / j4;
        long j6 = 60;
        long j7 = (j % j4) / j6;
        long j8 = j % j6;
        MutableLiveData<String> mutableLiveData = this.remainTimeStr;
        if (j3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.getDefault(), "剩余%d天 %02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j7), Long.valueOf(j8)}, 4));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format(Locale.getDefault(), "剩余%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j7), Long.valueOf(j8)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        }
        mutableLiveData.setValue(str);
    }

    public final void Q(@NotNull int[] selSpecIndexArray) {
        Intrinsics.checkNotNullParameter(selSpecIndexArray, "selSpecIndexArray");
        this.selSpecIndexArray = selSpecIndexArray;
        GoodsDetailBean value = this.goodsDetail.getValue();
        if (value != null) {
            Pair<GoodsDetailSku, String> pairA = fk8.f41700a.a(value.getSpecList(), value.getSkuList(), selSpecIndexArray);
            this.selSku = (GoodsDetailSku) pairA.getFirst();
            this.specStr.setValue((String) pairA.getSecond());
        }
        O();
    }

    @NotNull
    public final String o() {
        GoodsDetailBean value = this.goodsDetail.getValue();
        boolean z = false;
        if (value != null && value.getOutOfStock()) {
            z = true;
        }
        if (z) {
            String strE = ys8.e(R.string.mall_goods_detail_out_of_stock);
            Intrinsics.checkNotNullExpressionValue(strE, "{\n            StringUtil…l_out_of_stock)\n        }");
            return strE;
        }
        if (this.fromReward) {
            String strE2 = ys8.e(R.string.mall_goods_detail_receive_now);
            Intrinsics.checkNotNullExpressionValue(strE2, "{\n            StringUtil…il_receive_now)\n        }");
            return strE2;
        }
        String strE3 = ys8.e(R.string.mall_goods_detail_buy_now);
        Intrinsics.checkNotNullExpressionValue(strE3, "{\n            StringUtil…detail_buy_now)\n        }");
        return strE3;
    }

    public final void p(@NotNull String goodNo) {
        Intrinsics.checkNotNullParameter(goodNo, "goodNo");
        BaseViewModelExtKt.b(this, true, true, null, null, new GoodsDetailVM$encodeGoodsNo$1(goodNo, this, null), 12, null);
    }

    @NotNull
    public final MutableLiveData<GoodsDetailAdapter> q() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.canExchange;
    }

    @Nullable
    /* JADX INFO: renamed from: s, reason: from getter */
    public final String getCooperationNo() {
        return this.cooperationNo;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final boolean getFromReward() {
        return this.fromReward;
    }

    @NotNull
    public final MutableLiveData<GoodsDetailBean> u() {
        return this.goodsDetail;
    }

    @NotNull
    public final MutableLiveData<String> v() {
        return this.goodsPrice;
    }

    @NotNull
    public final MutableLiveData<String> w() {
        return this.outPrice;
    }

    @NotNull
    public final MutableLiveData<Boolean> x() {
        return this.promotion;
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.remainTimeStr;
    }

    @Nullable
    /* JADX INFO: renamed from: z, reason: from getter */
    public final int[] getSelSpecIndexArray() {
        return this.selSpecIndexArray;
    }
}
