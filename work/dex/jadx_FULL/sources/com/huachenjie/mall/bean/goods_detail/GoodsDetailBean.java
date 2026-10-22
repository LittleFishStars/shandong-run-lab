package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.VideoBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.cy6;
import com.zj.adlib.i46;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\t\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\t\u0012\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u001dj\b\u0012\u0004\u0012\u00020)`\u001f\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\t\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00102\u001a\u000203\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00105\u001a\u000203\u0012\b\b\u0002\u00106\u001a\u000203\u0012\b\b\u0002\u00107\u001a\u000203\u0012\b\b\u0002\u00108\u001a\u000203\u0012\b\b\u0002\u00109\u001a\u000203\u0012\b\b\u0002\u0010:\u001a\u00020\u000b¢\u0006\u0002\u0010;J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0006HÆ\u0003J\t\u0010}\u001a\u00020\u0006HÆ\u0003J\t\u0010~\u001a\u00020\u0006HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\tHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u001bHÆ\u0003J\u001a\u0010\u0086\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020!HÆ\u0003J\u0010\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020#0\tHÆ\u0003J\u0010\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020%0\tHÆ\u0003J\u0010\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020'0\tHÆ\u0003J\u001a\u0010\u008b\u0001\u001a\u0012\u0012\u0004\u0012\u00020)0\u001dj\b\u0012\u0004\u0012\u00020)`\u001fHÆ\u0003J\u0012\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\tHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\n\u0010\u0092\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0093\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0094\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0095\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0096\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0097\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0098\u0001\u001a\u000203HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0006HÆ\u0003JØ\u0003\u0010 \u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\t2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\t2\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u001dj\b\u0012\u0004\u0012\u00020)`\u001f2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\t2\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\b\b\u0002\u00106\u001a\u0002032\b\b\u0002\u00107\u001a\u0002032\b\b\u0002\u00108\u001a\u0002032\b\b\u0002\u00109\u001a\u0002032\b\b\u0002\u0010:\u001a\u00020\u000bHÆ\u0001J\n\u0010¡\u0001\u001a\u00020\u0003HÖ\u0001J\u0016\u0010¢\u0001\u001a\u00020\u000b2\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001HÖ\u0003J\u0007\u0010¥\u0001\u001a\u00020\u0006J\u0011\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u0003J\u0007\u0010©\u0001\u001a\u00020\u0006J\u0011\u0010ª\u0001\u001a\u00030§\u00012\u0007\u0010¨\u0001\u001a\u00020\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¬\u0001\u001a\u00020\u0006HÖ\u0001J\u001e\u0010\u00ad\u0001\u001a\u00030®\u00012\b\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010<\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010/\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0011\u0010:\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010@R\u0011\u0010F\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bG\u0010>R\u0011\u00105\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u00104\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u00107\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0011\u00106\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bL\u0010IR\u0011\u00109\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bM\u0010IR\u0011\u00108\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bN\u0010IR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010>R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bU\u0010>R!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bX\u0010>R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bY\u0010>R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010IR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b]\u0010QR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b^\u0010QR\u0011\u0010_\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b`\u0010>R\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\\R!\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)0\u001dj\b\u0012\u0004\u0012\u00020)`\u001f¢\u0006\b\n\u0000\u001a\u0004\bb\u0010WR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\\R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bd\u0010>R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010\\R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u0010>R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bg\u0010@R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bj\u0010@R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010>R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bn\u0010>R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bo\u0010>R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\bp\u0010QR\u0011\u0010q\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\br\u0010>R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010@R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bt\u0010>R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010QR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\t¢\u0006\b\n\u0000\u001a\u0004\bv\u0010QR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\\R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\\¨\u0006²\u0001"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "Landroid/os/Parcelable;", "type", "", "subType", "goodsNo", "", "shopNo", "labelList", "", "shopGoodsShow", "", "multipleSku", "minSkuPrice", "maxSkuPrice", "minPointsInMinPriceSku", "maxPointsInMinPriceSku", "outPrice", "saleCount", "goodsName", "salePoint", "outOfStock", "goodsStatus", "serviceList", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailService;", "deliveryPlace", "expressInfo", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailExpress;", "goodsAttributeList", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailAttribute;", "Lkotlin/collections/ArrayList;", "oneGoodsComment", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailOneGoodsComment;", "detailImageList", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailPicture;", "specList", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpec;", "skuList", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "mainImageList", "Lcom/huachenjie/base/bean/ImageBean;", "goodsVideoList", "Lcom/huachenjie/base/bean/VideoBean;", "limitBuy", "remainTime", "", "activityFlag", "activityInfo", "Lcom/huachenjie/mall/bean/goods_detail/GoodsActivity;", "goodsScore", "", "baseCommissionRate", "baseCommission", "cooperationCommissionRate", "cooperationCommission", "cooperationServiceChargeRate", "cooperationServiceCharge", "addWin", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/lang/String;Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailExpress;Ljava/util/ArrayList;Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailOneGoodsComment;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/List;IJZLcom/huachenjie/mall/bean/goods_detail/GoodsActivity;FFFFFFFZ)V", "activityBg", "getActivityBg", "()Ljava/lang/String;", "getActivityFlag", "()Z", "getActivityInfo", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsActivity;", "activityPriceLabel", "getActivityPriceLabel", "getAddWin", "attributesNameStr", "getAttributesNameStr", "getBaseCommission", "()F", "getBaseCommissionRate", "getCooperationCommission", "getCooperationCommissionRate", "getCooperationServiceCharge", "getCooperationServiceChargeRate", "getDeliveryPlace", "getDetailImageList", "()Ljava/util/List;", "getExpressInfo", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailExpress;", "expressStr", "getExpressStr", "getGoodsAttributeList", "()Ljava/util/ArrayList;", "getGoodsName", "getGoodsNo", "getGoodsScore", "getGoodsStatus", "()I", "getGoodsVideoList", "getLabelList", "labelStr", "getLabelStr", "getLimitBuy", "getMainImageList", "getMaxPointsInMinPriceSku", "getMaxSkuPrice", "getMinPointsInMinPriceSku", "getMinSkuPrice", "getMultipleSku", "getOneGoodsComment", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailOneGoodsComment;", "getOutOfStock", "getOutPrice", "getRemainTime", "()J", "getSaleCount", "getSalePoint", "getServiceList", "serviceStr", "getServiceStr", "getShopGoodsShow", "getShopNo", "getSkuList", "getSpecList", "getSubType", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatBaseCommissionRate", "formatCommission", "", "squareType", "formatCommissionRate", "formatDetailCommission", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoodsDetailBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodsDetailBean.kt\ncom/huachenjie/mall/bean/goods_detail/GoodsDetailBean\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,418:1\n1855#2,2:419\n1864#2,3:421\n1#3:424\n*S KotlinDebug\n*F\n+ 1 GoodsDetailBean.kt\ncom/huachenjie/mall/bean/goods_detail/GoodsDetailBean\n*L\n160#1:419,2\n178#1:421,3\n*E\n"})
public final /* data */ class GoodsDetailBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailBean> CREATOR = new Creator();
    private final boolean activityFlag;

    @Nullable
    private final GoodsActivity activityInfo;
    private final boolean addWin;
    private final float baseCommission;
    private final float baseCommissionRate;
    private final float cooperationCommission;
    private final float cooperationCommissionRate;
    private final float cooperationServiceCharge;
    private final float cooperationServiceChargeRate;

    @NotNull
    private final String deliveryPlace;

    @NotNull
    private final List<GoodsDetailPicture> detailImageList;

    @NotNull
    private final GoodsDetailExpress expressInfo;

    @NotNull
    private final ArrayList<GoodsDetailAttribute> goodsAttributeList;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;
    private final float goodsScore;
    private final int goodsStatus;

    @Nullable
    private final List<VideoBean> goodsVideoList;

    @NotNull
    private final List<String> labelList;
    private final int limitBuy;

    @NotNull
    private final ArrayList<ImageBean> mainImageList;
    private final int maxPointsInMinPriceSku;

    @NotNull
    private final String maxSkuPrice;
    private final int minPointsInMinPriceSku;

    @NotNull
    private final String minSkuPrice;
    private final boolean multipleSku;

    @NotNull
    private final GoodsDetailOneGoodsComment oneGoodsComment;
    private final boolean outOfStock;

    @NotNull
    private final String outPrice;
    private final long remainTime;

    @NotNull
    private final String saleCount;

    @NotNull
    private final String salePoint;

    @NotNull
    private final List<GoodsDetailService> serviceList;
    private final boolean shopGoodsShow;

    @NotNull
    private final String shopNo;

    @NotNull
    private final List<GoodsDetailSku> skuList;

    @NotNull
    private final List<GoodsDetailSpec> specList;
    private final int subType;
    private final int type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailBean createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            boolean z3 = parcel.readInt() != 0;
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i6);
            int i7 = 0;
            while (i7 != i6) {
                arrayList2.add(GoodsDetailService.CREATOR.createFromParcel(parcel));
                i7++;
                i6 = i6;
            }
            String string9 = parcel.readString();
            GoodsDetailExpress goodsDetailExpressCreateFromParcel = GoodsDetailExpress.CREATOR.createFromParcel(parcel);
            int i8 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i8);
            int i9 = 0;
            while (i9 != i8) {
                arrayList3.add(GoodsDetailAttribute.CREATOR.createFromParcel(parcel));
                i9++;
                i8 = i8;
            }
            GoodsDetailOneGoodsComment goodsDetailOneGoodsCommentCreateFromParcel = GoodsDetailOneGoodsComment.CREATOR.createFromParcel(parcel);
            int i10 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(i10);
            int i11 = 0;
            while (i11 != i10) {
                arrayList4.add(GoodsDetailPicture.CREATOR.createFromParcel(parcel));
                i11++;
                i10 = i10;
            }
            int i12 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i12);
            int i13 = 0;
            while (i13 != i12) {
                arrayList5.add(GoodsDetailSpec.CREATOR.createFromParcel(parcel));
                i13++;
                i12 = i12;
            }
            int i14 = parcel.readInt();
            ArrayList arrayList6 = new ArrayList(i14);
            int i15 = 0;
            while (i15 != i14) {
                arrayList6.add(GoodsDetailSku.CREATOR.createFromParcel(parcel));
                i15++;
                i14 = i14;
            }
            int i16 = parcel.readInt();
            ArrayList arrayList7 = new ArrayList(i16);
            int i17 = 0;
            while (i17 != i16) {
                arrayList7.add(parcel.readParcelable(GoodsDetailBean.class.getClassLoader()));
                i17++;
                i16 = i16;
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i18 = parcel.readInt();
                ArrayList arrayList8 = new ArrayList(i18);
                int i19 = 0;
                while (i19 != i18) {
                    arrayList8.add(parcel.readParcelable(GoodsDetailBean.class.getClassLoader()));
                    i19++;
                    i18 = i18;
                }
                arrayList = arrayList8;
            }
            return new GoodsDetailBean(i, i2, string, string2, arrayListCreateStringArrayList, z, z2, string3, string4, i3, i4, string5, string6, string7, string8, z3, i5, arrayList2, string9, goodsDetailExpressCreateFromParcel, arrayList3, goodsDetailOneGoodsCommentCreateFromParcel, arrayList4, arrayList5, arrayList6, arrayList7, arrayList, parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : GoodsActivity.CREATOR.createFromParcel(parcel), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailBean[] newArray(int i) {
            return new GoodsDetailBean[i];
        }
    }

    public GoodsDetailBean() {
        this(0, 0, null, null, null, false, false, null, null, 0, 0, null, null, null, null, false, 0, null, null, null, null, null, null, null, null, null, null, 0, 0L, false, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, -1, 127, null);
    }

    public GoodsDetailBean(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull List<String> list, boolean z, boolean z2, @NotNull String str3, @NotNull String str4, int i3, int i4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, boolean z3, int i5, @NotNull List<GoodsDetailService> list2, @NotNull String str9, @NotNull GoodsDetailExpress goodsDetailExpress, @NotNull ArrayList<GoodsDetailAttribute> arrayList, @NotNull GoodsDetailOneGoodsComment goodsDetailOneGoodsComment, @NotNull List<GoodsDetailPicture> list3, @NotNull List<GoodsDetailSpec> list4, @NotNull List<GoodsDetailSku> list5, @NotNull ArrayList<ImageBean> arrayList2, @Nullable List<VideoBean> list6, int i6, long j, boolean z4, @Nullable GoodsActivity goodsActivity, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "shopNo");
        Intrinsics.checkNotNullParameter(list, "labelList");
        Intrinsics.checkNotNullParameter(str3, "minSkuPrice");
        Intrinsics.checkNotNullParameter(str4, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(str5, "outPrice");
        Intrinsics.checkNotNullParameter(str6, "saleCount");
        Intrinsics.checkNotNullParameter(str7, "goodsName");
        Intrinsics.checkNotNullParameter(str8, "salePoint");
        Intrinsics.checkNotNullParameter(list2, "serviceList");
        Intrinsics.checkNotNullParameter(str9, "deliveryPlace");
        Intrinsics.checkNotNullParameter(goodsDetailExpress, "expressInfo");
        Intrinsics.checkNotNullParameter(arrayList, "goodsAttributeList");
        Intrinsics.checkNotNullParameter(goodsDetailOneGoodsComment, "oneGoodsComment");
        Intrinsics.checkNotNullParameter(list3, "detailImageList");
        Intrinsics.checkNotNullParameter(list4, "specList");
        Intrinsics.checkNotNullParameter(list5, "skuList");
        Intrinsics.checkNotNullParameter(arrayList2, "mainImageList");
        this.type = i;
        this.subType = i2;
        this.goodsNo = str;
        this.shopNo = str2;
        this.labelList = list;
        this.shopGoodsShow = z;
        this.multipleSku = z2;
        this.minSkuPrice = str3;
        this.maxSkuPrice = str4;
        this.minPointsInMinPriceSku = i3;
        this.maxPointsInMinPriceSku = i4;
        this.outPrice = str5;
        this.saleCount = str6;
        this.goodsName = str7;
        this.salePoint = str8;
        this.outOfStock = z3;
        this.goodsStatus = i5;
        this.serviceList = list2;
        this.deliveryPlace = str9;
        this.expressInfo = goodsDetailExpress;
        this.goodsAttributeList = arrayList;
        this.oneGoodsComment = goodsDetailOneGoodsComment;
        this.detailImageList = list3;
        this.specList = list4;
        this.skuList = list5;
        this.mainImageList = arrayList2;
        this.goodsVideoList = list6;
        this.limitBuy = i6;
        this.remainTime = j;
        this.activityFlag = z4;
        this.activityInfo = goodsActivity;
        this.goodsScore = f;
        this.baseCommissionRate = f2;
        this.baseCommission = f3;
        this.cooperationCommissionRate = f4;
        this.cooperationCommission = f5;
        this.cooperationServiceChargeRate = f6;
        this.cooperationServiceCharge = f7;
        this.addWin = z5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getMinPointsInMinPriceSku() {
        return this.minPointsInMinPriceSku;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMaxPointsInMinPriceSku() {
        return this.maxPointsInMinPriceSku;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getOutPrice() {
        return this.outPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSaleCount() {
        return this.saleCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSalePoint() {
        return this.salePoint;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getOutOfStock() {
        return this.outOfStock;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getGoodsStatus() {
        return this.goodsStatus;
    }

    @NotNull
    public final List<GoodsDetailService> component18() {
        return this.serviceList;
    }

    @NotNull
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getDeliveryPlace() {
        return this.deliveryPlace;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final GoodsDetailExpress getExpressInfo() {
        return this.expressInfo;
    }

    @NotNull
    public final ArrayList<GoodsDetailAttribute> component21() {
        return this.goodsAttributeList;
    }

    @NotNull
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final GoodsDetailOneGoodsComment getOneGoodsComment() {
        return this.oneGoodsComment;
    }

    @NotNull
    public final List<GoodsDetailPicture> component23() {
        return this.detailImageList;
    }

    @NotNull
    public final List<GoodsDetailSpec> component24() {
        return this.specList;
    }

    @NotNull
    public final List<GoodsDetailSku> component25() {
        return this.skuList;
    }

    @NotNull
    public final ArrayList<ImageBean> component26() {
        return this.mainImageList;
    }

    @Nullable
    public final List<VideoBean> component27() {
        return this.goodsVideoList;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getLimitBuy() {
        return this.limitBuy;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final long getRemainTime() {
        return this.remainTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getActivityFlag() {
        return this.activityFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final GoodsActivity getActivityInfo() {
        return this.activityInfo;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final float getGoodsScore() {
        return this.goodsScore;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final float getBaseCommissionRate() {
        return this.baseCommissionRate;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final float getBaseCommission() {
        return this.baseCommission;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final float getCooperationCommissionRate() {
        return this.cooperationCommissionRate;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final float getCooperationCommission() {
        return this.cooperationCommission;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final float getCooperationServiceChargeRate() {
        return this.cooperationServiceChargeRate;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final float getCooperationServiceCharge() {
        return this.cooperationServiceCharge;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final boolean getAddWin() {
        return this.addWin;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    public final List<String> component5() {
        return this.labelList;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShopGoodsShow() {
        return this.shopGoodsShow;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getMultipleSku() {
        return this.multipleSku;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    @NotNull
    public final GoodsDetailBean copy(int type, int subType, @NotNull String goodsNo, @NotNull String shopNo, @NotNull List<String> labelList, boolean shopGoodsShow, boolean multipleSku, @NotNull String minSkuPrice, @NotNull String maxSkuPrice, int minPointsInMinPriceSku, int maxPointsInMinPriceSku, @NotNull String outPrice, @NotNull String saleCount, @NotNull String goodsName, @NotNull String salePoint, boolean outOfStock, int goodsStatus, @NotNull List<GoodsDetailService> serviceList, @NotNull String deliveryPlace, @NotNull GoodsDetailExpress expressInfo, @NotNull ArrayList<GoodsDetailAttribute> goodsAttributeList, @NotNull GoodsDetailOneGoodsComment oneGoodsComment, @NotNull List<GoodsDetailPicture> detailImageList, @NotNull List<GoodsDetailSpec> specList, @NotNull List<GoodsDetailSku> skuList, @NotNull ArrayList<ImageBean> mainImageList, @Nullable List<VideoBean> goodsVideoList, int limitBuy, long remainTime, boolean activityFlag, @Nullable GoodsActivity activityInfo, float goodsScore, float baseCommissionRate, float baseCommission, float cooperationCommissionRate, float cooperationCommission, float cooperationServiceChargeRate, float cooperationServiceCharge, boolean addWin) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        Intrinsics.checkNotNullParameter(maxSkuPrice, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(outPrice, "outPrice");
        Intrinsics.checkNotNullParameter(saleCount, "saleCount");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(salePoint, "salePoint");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        Intrinsics.checkNotNullParameter(deliveryPlace, "deliveryPlace");
        Intrinsics.checkNotNullParameter(expressInfo, "expressInfo");
        Intrinsics.checkNotNullParameter(goodsAttributeList, "goodsAttributeList");
        Intrinsics.checkNotNullParameter(oneGoodsComment, "oneGoodsComment");
        Intrinsics.checkNotNullParameter(detailImageList, "detailImageList");
        Intrinsics.checkNotNullParameter(specList, "specList");
        Intrinsics.checkNotNullParameter(skuList, "skuList");
        Intrinsics.checkNotNullParameter(mainImageList, "mainImageList");
        return new GoodsDetailBean(type, subType, goodsNo, shopNo, labelList, shopGoodsShow, multipleSku, minSkuPrice, maxSkuPrice, minPointsInMinPriceSku, maxPointsInMinPriceSku, outPrice, saleCount, goodsName, salePoint, outOfStock, goodsStatus, serviceList, deliveryPlace, expressInfo, goodsAttributeList, oneGoodsComment, detailImageList, specList, skuList, mainImageList, goodsVideoList, limitBuy, remainTime, activityFlag, activityInfo, goodsScore, baseCommissionRate, baseCommission, cooperationCommissionRate, cooperationCommission, cooperationServiceChargeRate, cooperationServiceCharge, addWin);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailBean)) {
            return false;
        }
        GoodsDetailBean goodsDetailBean = (GoodsDetailBean) other;
        return this.type == goodsDetailBean.type && this.subType == goodsDetailBean.subType && Intrinsics.areEqual(this.goodsNo, goodsDetailBean.goodsNo) && Intrinsics.areEqual(this.shopNo, goodsDetailBean.shopNo) && Intrinsics.areEqual(this.labelList, goodsDetailBean.labelList) && this.shopGoodsShow == goodsDetailBean.shopGoodsShow && this.multipleSku == goodsDetailBean.multipleSku && Intrinsics.areEqual(this.minSkuPrice, goodsDetailBean.minSkuPrice) && Intrinsics.areEqual(this.maxSkuPrice, goodsDetailBean.maxSkuPrice) && this.minPointsInMinPriceSku == goodsDetailBean.minPointsInMinPriceSku && this.maxPointsInMinPriceSku == goodsDetailBean.maxPointsInMinPriceSku && Intrinsics.areEqual(this.outPrice, goodsDetailBean.outPrice) && Intrinsics.areEqual(this.saleCount, goodsDetailBean.saleCount) && Intrinsics.areEqual(this.goodsName, goodsDetailBean.goodsName) && Intrinsics.areEqual(this.salePoint, goodsDetailBean.salePoint) && this.outOfStock == goodsDetailBean.outOfStock && this.goodsStatus == goodsDetailBean.goodsStatus && Intrinsics.areEqual(this.serviceList, goodsDetailBean.serviceList) && Intrinsics.areEqual(this.deliveryPlace, goodsDetailBean.deliveryPlace) && Intrinsics.areEqual(this.expressInfo, goodsDetailBean.expressInfo) && Intrinsics.areEqual(this.goodsAttributeList, goodsDetailBean.goodsAttributeList) && Intrinsics.areEqual(this.oneGoodsComment, goodsDetailBean.oneGoodsComment) && Intrinsics.areEqual(this.detailImageList, goodsDetailBean.detailImageList) && Intrinsics.areEqual(this.specList, goodsDetailBean.specList) && Intrinsics.areEqual(this.skuList, goodsDetailBean.skuList) && Intrinsics.areEqual(this.mainImageList, goodsDetailBean.mainImageList) && Intrinsics.areEqual(this.goodsVideoList, goodsDetailBean.goodsVideoList) && this.limitBuy == goodsDetailBean.limitBuy && this.remainTime == goodsDetailBean.remainTime && this.activityFlag == goodsDetailBean.activityFlag && Intrinsics.areEqual(this.activityInfo, goodsDetailBean.activityInfo) && Float.compare(this.goodsScore, goodsDetailBean.goodsScore) == 0 && Float.compare(this.baseCommissionRate, goodsDetailBean.baseCommissionRate) == 0 && Float.compare(this.baseCommission, goodsDetailBean.baseCommission) == 0 && Float.compare(this.cooperationCommissionRate, goodsDetailBean.cooperationCommissionRate) == 0 && Float.compare(this.cooperationCommission, goodsDetailBean.cooperationCommission) == 0 && Float.compare(this.cooperationServiceChargeRate, goodsDetailBean.cooperationServiceChargeRate) == 0 && Float.compare(this.cooperationServiceCharge, goodsDetailBean.cooperationServiceCharge) == 0 && this.addWin == goodsDetailBean.addWin;
    }

    @NotNull
    public final String formatBaseCommissionRate() {
        if (this.baseCommissionRate == 0.0f) {
            return "0%";
        }
        return i46.a(this.baseCommissionRate) + '%';
    }

    @NotNull
    public final CharSequence formatCommission(int squareType) {
        return cy6.c(squareType == 1 ? this.baseCommission : this.cooperationCommission, 0.0f, 0.0f, null, false, 30, null);
    }

    @NotNull
    public final String formatCommissionRate() {
        if (this.cooperationCommissionRate == 0.0f) {
            return "0%";
        }
        return i46.a(this.cooperationCommissionRate) + '%';
    }

    @NotNull
    public final CharSequence formatDetailCommission(int squareType) {
        return cy6.c(squareType == 1 ? this.baseCommission : this.cooperationCommission, 0.0f, 0.0f, "#FF650AEC", false, 6, null);
    }

    @NotNull
    public final String getActivityBg() {
        GoodsActivity goodsActivity;
        List<GoodsActivityMaterial> materialList;
        Object next;
        String picUrl;
        GoodsActivity goodsActivity2 = this.activityInfo;
        if ((goodsActivity2 != null && goodsActivity2.getActivityTypeValue() == 3) || (goodsActivity = this.activityInfo) == null || (materialList = goodsActivity.getMaterialList()) == null) {
            return "";
        }
        Iterator<T> it = materialList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((GoodsActivityMaterial) next).getMaterialType() == 2));
        GoodsActivityMaterial goodsActivityMaterial = (GoodsActivityMaterial) next;
        return (goodsActivityMaterial == null || (picUrl = goodsActivityMaterial.getPicUrl()) == null) ? "" : picUrl;
    }

    public final boolean getActivityFlag() {
        return this.activityFlag;
    }

    @Nullable
    public final GoodsActivity getActivityInfo() {
        return this.activityInfo;
    }

    @NotNull
    public final String getActivityPriceLabel() {
        GoodsActivity goodsActivity;
        List<GoodsActivityMaterial> materialList;
        Object next;
        String name;
        GoodsActivity goodsActivity2 = this.activityInfo;
        if ((goodsActivity2 != null && goodsActivity2.getActivityTypeValue() == 3) || (goodsActivity = this.activityInfo) == null || (materialList = goodsActivity.getMaterialList()) == null) {
            return "";
        }
        Iterator<T> it = materialList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((GoodsActivityMaterial) next).getMaterialType() == 3));
        GoodsActivityMaterial goodsActivityMaterial = (GoodsActivityMaterial) next;
        return (goodsActivityMaterial == null || (name = goodsActivityMaterial.getName()) == null) ? "" : name;
    }

    public final boolean getAddWin() {
        return this.addWin;
    }

    @NotNull
    public final String getAttributesNameStr() {
        int i = 0;
        String str = "";
        for (Object obj : this.goodsAttributeList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GoodsDetailAttribute goodsDetailAttribute = (GoodsDetailAttribute) obj;
            str = str + (i > 0 ? q.a.i : "") + goodsDetailAttribute.getAttributesName();
            i = i2;
        }
        return str;
    }

    public final float getBaseCommission() {
        return this.baseCommission;
    }

    public final float getBaseCommissionRate() {
        return this.baseCommissionRate;
    }

    public final float getCooperationCommission() {
        return this.cooperationCommission;
    }

    public final float getCooperationCommissionRate() {
        return this.cooperationCommissionRate;
    }

    public final float getCooperationServiceCharge() {
        return this.cooperationServiceCharge;
    }

    public final float getCooperationServiceChargeRate() {
        return this.cooperationServiceChargeRate;
    }

    @NotNull
    public final String getDeliveryPlace() {
        return this.deliveryPlace;
    }

    @NotNull
    public final List<GoodsDetailPicture> getDetailImageList() {
        return this.detailImageList;
    }

    @NotNull
    public final GoodsDetailExpress getExpressInfo() {
        return this.expressInfo;
    }

    @NotNull
    public final String getExpressStr() {
        if (this.expressInfo.getExpressType() == 0) {
            return "包邮";
        }
        return (char) 165 + this.expressInfo.getExpressFee();
    }

    @NotNull
    public final ArrayList<GoodsDetailAttribute> getGoodsAttributeList() {
        return this.goodsAttributeList;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    public final float getGoodsScore() {
        return this.goodsScore;
    }

    public final int getGoodsStatus() {
        return this.goodsStatus;
    }

    @Nullable
    public final List<VideoBean> getGoodsVideoList() {
        return this.goodsVideoList;
    }

    @NotNull
    public final List<String> getLabelList() {
        return this.labelList;
    }

    @NotNull
    public final String getLabelStr() {
        String str = (String) CollectionsKt.getOrNull(this.labelList, 0);
        return str == null ? "" : str;
    }

    public final int getLimitBuy() {
        return this.limitBuy;
    }

    @NotNull
    public final ArrayList<ImageBean> getMainImageList() {
        return this.mainImageList;
    }

    public final int getMaxPointsInMinPriceSku() {
        return this.maxPointsInMinPriceSku;
    }

    @NotNull
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    public final int getMinPointsInMinPriceSku() {
        return this.minPointsInMinPriceSku;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    public final boolean getMultipleSku() {
        return this.multipleSku;
    }

    @NotNull
    public final GoodsDetailOneGoodsComment getOneGoodsComment() {
        return this.oneGoodsComment;
    }

    public final boolean getOutOfStock() {
        return this.outOfStock;
    }

    @NotNull
    public final String getOutPrice() {
        return this.outPrice;
    }

    public final long getRemainTime() {
        return this.remainTime;
    }

    @NotNull
    public final String getSaleCount() {
        return this.saleCount;
    }

    @NotNull
    public final String getSalePoint() {
        return this.salePoint;
    }

    @NotNull
    public final List<GoodsDetailService> getServiceList() {
        return this.serviceList;
    }

    @NotNull
    public final String getServiceStr() {
        String str = "";
        for (GoodsDetailService goodsDetailService : this.serviceList) {
            if (goodsDetailService.getSupport() || goodsDetailService.getType() == 1) {
                str = str + (str.length() > 0 ? "·" : "") + (!goodsDetailService.getSupport() ? "不支持" : "") + goodsDetailService.getServiceName();
            }
        }
        return str;
    }

    public final boolean getShopGoodsShow() {
        return this.shopGoodsShow;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    public final List<GoodsDetailSku> getSkuList() {
        return this.skuList;
    }

    @NotNull
    public final List<GoodsDetailSpec> getSpecList() {
        return this.specList;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v59, types: [int] */
    /* JADX WARN: Type inference failed for: r0v77, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v57, types: [int] */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.subType)) * 31) + this.goodsNo.hashCode()) * 31) + this.shopNo.hashCode()) * 31) + this.labelList.hashCode()) * 31;
        boolean z = this.shopGoodsShow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.multipleSku;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((((((((((((((((i + r2) * 31) + this.minSkuPrice.hashCode()) * 31) + this.maxSkuPrice.hashCode()) * 31) + Integer.hashCode(this.minPointsInMinPriceSku)) * 31) + Integer.hashCode(this.maxPointsInMinPriceSku)) * 31) + this.outPrice.hashCode()) * 31) + this.saleCount.hashCode()) * 31) + this.goodsName.hashCode()) * 31) + this.salePoint.hashCode()) * 31;
        boolean z3 = this.outOfStock;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode3 = (((((((((((((((((((((iHashCode2 + r3) * 31) + Integer.hashCode(this.goodsStatus)) * 31) + this.serviceList.hashCode()) * 31) + this.deliveryPlace.hashCode()) * 31) + this.expressInfo.hashCode()) * 31) + this.goodsAttributeList.hashCode()) * 31) + this.oneGoodsComment.hashCode()) * 31) + this.detailImageList.hashCode()) * 31) + this.specList.hashCode()) * 31) + this.skuList.hashCode()) * 31) + this.mainImageList.hashCode()) * 31;
        List<VideoBean> list = this.goodsVideoList;
        int iHashCode4 = (((((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.limitBuy)) * 31) + Long.hashCode(this.remainTime)) * 31;
        boolean z4 = this.activityFlag;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i2 = (iHashCode4 + r4) * 31;
        GoodsActivity goodsActivity = this.activityInfo;
        int iHashCode5 = (((((((((((((((i2 + (goodsActivity != null ? goodsActivity.hashCode() : 0)) * 31) + Float.hashCode(this.goodsScore)) * 31) + Float.hashCode(this.baseCommissionRate)) * 31) + Float.hashCode(this.baseCommission)) * 31) + Float.hashCode(this.cooperationCommissionRate)) * 31) + Float.hashCode(this.cooperationCommission)) * 31) + Float.hashCode(this.cooperationServiceChargeRate)) * 31) + Float.hashCode(this.cooperationServiceCharge)) * 31;
        boolean z5 = this.addWin;
        return iHashCode5 + (z5 ? 1 : z5);
    }

    @NotNull
    public String toString() {
        return "GoodsDetailBean(type=" + this.type + ", subType=" + this.subType + ", goodsNo=" + this.goodsNo + ", shopNo=" + this.shopNo + ", labelList=" + this.labelList + ", shopGoodsShow=" + this.shopGoodsShow + ", multipleSku=" + this.multipleSku + ", minSkuPrice=" + this.minSkuPrice + ", maxSkuPrice=" + this.maxSkuPrice + ", minPointsInMinPriceSku=" + this.minPointsInMinPriceSku + ", maxPointsInMinPriceSku=" + this.maxPointsInMinPriceSku + ", outPrice=" + this.outPrice + ", saleCount=" + this.saleCount + ", goodsName=" + this.goodsName + ", salePoint=" + this.salePoint + ", outOfStock=" + this.outOfStock + ", goodsStatus=" + this.goodsStatus + ", serviceList=" + this.serviceList + ", deliveryPlace=" + this.deliveryPlace + ", expressInfo=" + this.expressInfo + ", goodsAttributeList=" + this.goodsAttributeList + ", oneGoodsComment=" + this.oneGoodsComment + ", detailImageList=" + this.detailImageList + ", specList=" + this.specList + ", skuList=" + this.skuList + ", mainImageList=" + this.mainImageList + ", goodsVideoList=" + this.goodsVideoList + ", limitBuy=" + this.limitBuy + ", remainTime=" + this.remainTime + ", activityFlag=" + this.activityFlag + ", activityInfo=" + this.activityInfo + ", goodsScore=" + this.goodsScore + ", baseCommissionRate=" + this.baseCommissionRate + ", baseCommission=" + this.baseCommission + ", cooperationCommissionRate=" + this.cooperationCommissionRate + ", cooperationCommission=" + this.cooperationCommission + ", cooperationServiceChargeRate=" + this.cooperationServiceChargeRate + ", cooperationServiceCharge=" + this.cooperationServiceCharge + ", addWin=" + this.addWin + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.type);
        parcel.writeInt(this.subType);
        parcel.writeString(this.goodsNo);
        parcel.writeString(this.shopNo);
        parcel.writeStringList(this.labelList);
        parcel.writeInt(this.shopGoodsShow ? 1 : 0);
        parcel.writeInt(this.multipleSku ? 1 : 0);
        parcel.writeString(this.minSkuPrice);
        parcel.writeString(this.maxSkuPrice);
        parcel.writeInt(this.minPointsInMinPriceSku);
        parcel.writeInt(this.maxPointsInMinPriceSku);
        parcel.writeString(this.outPrice);
        parcel.writeString(this.saleCount);
        parcel.writeString(this.goodsName);
        parcel.writeString(this.salePoint);
        parcel.writeInt(this.outOfStock ? 1 : 0);
        parcel.writeInt(this.goodsStatus);
        List<GoodsDetailService> list = this.serviceList;
        parcel.writeInt(list.size());
        Iterator<GoodsDetailService> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.deliveryPlace);
        this.expressInfo.writeToParcel(parcel, flags);
        ArrayList<GoodsDetailAttribute> arrayList = this.goodsAttributeList;
        parcel.writeInt(arrayList.size());
        Iterator<GoodsDetailAttribute> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        this.oneGoodsComment.writeToParcel(parcel, flags);
        List<GoodsDetailPicture> list2 = this.detailImageList;
        parcel.writeInt(list2.size());
        Iterator<GoodsDetailPicture> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        List<GoodsDetailSpec> list3 = this.specList;
        parcel.writeInt(list3.size());
        Iterator<GoodsDetailSpec> it4 = list3.iterator();
        while (it4.hasNext()) {
            it4.next().writeToParcel(parcel, flags);
        }
        List<GoodsDetailSku> list4 = this.skuList;
        parcel.writeInt(list4.size());
        Iterator<GoodsDetailSku> it5 = list4.iterator();
        while (it5.hasNext()) {
            it5.next().writeToParcel(parcel, flags);
        }
        ArrayList<ImageBean> arrayList2 = this.mainImageList;
        parcel.writeInt(arrayList2.size());
        Iterator<ImageBean> it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            parcel.writeParcelable(it6.next(), flags);
        }
        List<VideoBean> list5 = this.goodsVideoList;
        if (list5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list5.size());
            Iterator<VideoBean> it7 = list5.iterator();
            while (it7.hasNext()) {
                parcel.writeParcelable(it7.next(), flags);
            }
        }
        parcel.writeInt(this.limitBuy);
        parcel.writeLong(this.remainTime);
        parcel.writeInt(this.activityFlag ? 1 : 0);
        GoodsActivity goodsActivity = this.activityInfo;
        if (goodsActivity == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            goodsActivity.writeToParcel(parcel, flags);
        }
        parcel.writeFloat(this.goodsScore);
        parcel.writeFloat(this.baseCommissionRate);
        parcel.writeFloat(this.baseCommission);
        parcel.writeFloat(this.cooperationCommissionRate);
        parcel.writeFloat(this.cooperationCommission);
        parcel.writeFloat(this.cooperationServiceChargeRate);
        parcel.writeFloat(this.cooperationServiceCharge);
        parcel.writeInt(this.addWin ? 1 : 0);
    }

    public /* synthetic */ GoodsDetailBean(int i, int i2, String str, String str2, List list, boolean z, boolean z2, String str3, String str4, int i3, int i4, String str5, String str6, String str7, String str8, boolean z3, int i5, List list2, String str9, GoodsDetailExpress goodsDetailExpress, ArrayList arrayList, GoodsDetailOneGoodsComment goodsDetailOneGoodsComment, List list3, List list4, List list5, ArrayList arrayList2, List list6, int i6, long j, boolean z4, GoodsActivity goodsActivity, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z5, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z6;
        GoodsDetailExpress goodsDetailExpress2;
        int i9 = (i7 & 1) != 0 ? 0 : i;
        int i10 = (i7 & 2) != 0 ? 0 : i2;
        String str10 = (i7 & 4) != 0 ? "" : str;
        String str11 = (i7 & 8) != 0 ? "" : str2;
        List listEmptyList = (i7 & 16) != 0 ? CollectionsKt.emptyList() : list;
        boolean z7 = (i7 & 32) != 0 ? false : z;
        boolean z8 = (i7 & 64) != 0 ? false : z2;
        String str12 = (i7 & 128) != 0 ? "" : str3;
        String str13 = (i7 & 256) != 0 ? "" : str4;
        int i11 = (i7 & 512) != 0 ? 0 : i3;
        int i12 = (i7 & 1024) != 0 ? 0 : i4;
        String str14 = (i7 & 2048) != 0 ? "" : str5;
        String str15 = (i7 & 4096) != 0 ? "" : str6;
        String str16 = (i7 & 8192) != 0 ? "" : str7;
        String str17 = (i7 & 16384) != 0 ? "" : str8;
        boolean z9 = (i7 & 32768) != 0 ? false : z3;
        int i13 = (i7 & 65536) != 0 ? 0 : i5;
        List listEmptyList2 = (i7 & 131072) != 0 ? CollectionsKt.emptyList() : list2;
        String str18 = (i7 & 262144) != 0 ? "" : str9;
        String str19 = str17;
        if ((i7 & 524288) != 0) {
            z6 = false;
            goodsDetailExpress2 = new GoodsDetailExpress(0, null, 3, null);
        } else {
            z6 = false;
            goodsDetailExpress2 = goodsDetailExpress;
        }
        this(i9, i10, str10, str11, listEmptyList, z7, z8, str12, str13, i11, i12, str14, str15, str16, str19, z9, i13, listEmptyList2, str18, goodsDetailExpress2, (1048576 & i7) != 0 ? new ArrayList() : arrayList, (i7 & 2097152) != 0 ? new GoodsDetailOneGoodsComment(null, null, null, 0, false, 31, null) : goodsDetailOneGoodsComment, (i7 & 4194304) != 0 ? CollectionsKt.emptyList() : list3, (i7 & 8388608) != 0 ? CollectionsKt.emptyList() : list4, (i7 & 16777216) != 0 ? CollectionsKt.emptyList() : list5, (i7 & 33554432) != 0 ? new ArrayList() : arrayList2, (i7 & TTAdConstant.KEY_CLICK_AREA) != 0 ? null : list6, (i7 & 134217728) != 0 ? -1 : i6, (i7 & 268435456) != 0 ? -1L : j, (i7 & 536870912) != 0 ? z6 : z4, (i7 & 1073741824) == 0 ? goodsActivity : null, (i7 & Integer.MIN_VALUE) != 0 ? 0.0f : f, (i8 & 1) != 0 ? 0.0f : f2, (i8 & 2) != 0 ? 0.0f : f3, (i8 & 4) != 0 ? 0.0f : f4, (i8 & 8) != 0 ? 0.0f : f5, (i8 & 16) != 0 ? 0.0f : f6, (i8 & 32) == 0 ? f7 : 0.0f, (i8 & 64) == 0 ? z5 : z6);
    }
}
