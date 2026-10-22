package com.zj.adlib;

import com.google.common.net.c;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpec;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ8\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/fk8;", "", "", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpec;", "specList", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "skuList", "", "selSpecIndexArray", "Lkotlin/Pair;", "", "a", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSkuUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SkuUtil.kt\ncom/huachenjie/mall/utils/SkuUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1864#2,3:41\n1#3:44\n*S KotlinDebug\n*F\n+ 1 SkuUtil.kt\ncom/huachenjie/mall/utils/SkuUtil\n*L\n23#1:41,3\n*E\n"})
public final class fk8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fk8 f41700a = new fk8();

    @NotNull
    public final Pair<GoodsDetailSku, String> a(@NotNull List<GoodsDetailSpec> specList, @NotNull List<GoodsDetailSku> skuList, @NotNull int[] selSpecIndexArray) {
        Object next;
        Intrinsics.checkNotNullParameter(specList, "specList");
        Intrinsics.checkNotNullParameter(skuList, "skuList");
        Intrinsics.checkNotNullParameter(selSpecIndexArray, "selSpecIndexArray");
        int i = 0;
        String str = "";
        String str2 = str;
        for (Object obj : specList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GoodsDetailSpec goodsDetailSpec = (GoodsDetailSpec) obj;
            if (i > 0) {
                str = str + dv9.e;
                str2 = str2 + (char) 65292;
            }
            GoodsDetailSpecValue goodsDetailSpecValue = (GoodsDetailSpecValue) CollectionsKt.getOrNull(goodsDetailSpec.getSpecValueList(), selSpecIndexArray[i]);
            if (goodsDetailSpecValue != null) {
                str2 = str2 + goodsDetailSpecValue.getSpecValue();
                str = str + goodsDetailSpec.getSpecNo() + c.b + goodsDetailSpecValue.getSpecNo();
            }
            i = i2;
        }
        Iterator<T> it = skuList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((GoodsDetailSku) next).getSpecsValue(), str));
        GoodsDetailSku goodsDetailSku = (GoodsDetailSku) next;
        return new Pair<>(goodsDetailSku, goodsDetailSku != null ? str2 : "");
    }
}
