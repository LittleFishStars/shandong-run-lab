package com.huachenjie.mall.external.bean;

import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006#"}, d2 = {"Lcom/huachenjie/mall/external/bean/SelectGoodsBean;", "", "goodsNo", "", "goodsName", "imageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "minSkuPrice", "checked", "", "isSingleSelect", "(Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;Ljava/lang/String;ZZ)V", "getChecked", "()Z", "setChecked", "(Z)V", "getGoodsName", "()Ljava/lang/String;", "getGoodsNo", "getImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", "setSingleSelect", "getMinSkuPrice", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SelectGoodsBean {
    private boolean checked;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @Nullable
    private final ImageBean imageInfo;
    private boolean isSingleSelect;

    @NotNull
    private final String minSkuPrice;

    public SelectGoodsBean() {
        this(null, null, null, null, false, false, 63, null);
    }

    public SelectGoodsBean(@NotNull String str, @NotNull String str2, @Nullable ImageBean imageBean, @NotNull String str3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "minSkuPrice");
        this.goodsNo = str;
        this.goodsName = str2;
        this.imageInfo = imageBean;
        this.minSkuPrice = str3;
        this.checked = z;
        this.isSingleSelect = z2;
    }

    public static /* synthetic */ SelectGoodsBean copy$default(SelectGoodsBean selectGoodsBean, String str, String str2, ImageBean imageBean, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectGoodsBean.goodsNo;
        }
        if ((i & 2) != 0) {
            str2 = selectGoodsBean.goodsName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            imageBean = selectGoodsBean.imageInfo;
        }
        ImageBean imageBean2 = imageBean;
        if ((i & 8) != 0) {
            str3 = selectGoodsBean.minSkuPrice;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            z = selectGoodsBean.checked;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = selectGoodsBean.isSingleSelect;
        }
        return selectGoodsBean.copy(str, str4, imageBean2, str5, z3, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSingleSelect() {
        return this.isSingleSelect;
    }

    @NotNull
    public final SelectGoodsBean copy(@NotNull String goodsNo, @NotNull String goodsName, @Nullable ImageBean imageInfo, @NotNull String minSkuPrice, boolean checked, boolean isSingleSelect) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        return new SelectGoodsBean(goodsNo, goodsName, imageInfo, minSkuPrice, checked, isSingleSelect);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectGoodsBean)) {
            return false;
        }
        SelectGoodsBean selectGoodsBean = (SelectGoodsBean) other;
        return Intrinsics.areEqual(this.goodsNo, selectGoodsBean.goodsNo) && Intrinsics.areEqual(this.goodsName, selectGoodsBean.goodsName) && Intrinsics.areEqual(this.imageInfo, selectGoodsBean.imageInfo) && Intrinsics.areEqual(this.minSkuPrice, selectGoodsBean.minSkuPrice) && this.checked == selectGoodsBean.checked && this.isSingleSelect == selectGoodsBean.isSingleSelect;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @Nullable
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.goodsNo.hashCode() * 31) + this.goodsName.hashCode()) * 31;
        ImageBean imageBean = this.imageInfo;
        int iHashCode2 = (((iHashCode + (imageBean == null ? 0 : imageBean.hashCode())) * 31) + this.minSkuPrice.hashCode()) * 31;
        boolean z = this.checked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.isSingleSelect;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isSingleSelect() {
        return this.isSingleSelect;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final void setSingleSelect(boolean z) {
        this.isSingleSelect = z;
    }

    @NotNull
    public String toString() {
        return "SelectGoodsBean(goodsNo=" + this.goodsNo + ", goodsName=" + this.goodsName + ", imageInfo=" + this.imageInfo + ", minSkuPrice=" + this.minSkuPrice + ", checked=" + this.checked + ", isSingleSelect=" + this.isSingleSelect + ')';
    }

    public /* synthetic */ SelectGoodsBean(String str, String str2, ImageBean imageBean, String str3, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : imageBean, (i & 8) == 0 ? str3 : "", (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }
}
