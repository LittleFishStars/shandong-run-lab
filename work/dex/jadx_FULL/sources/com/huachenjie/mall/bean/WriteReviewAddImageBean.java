package com.huachenjie.mall.bean;

import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/bean/WriteReviewAddImageBean;", "Lcom/huachenjie/mall/bean/WriteReviewImageBean;", "optionalNum", "", "(I)V", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getOptionalNum", "setOptionalNum", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WriteReviewAddImageBean extends WriteReviewImageBean {
    private int optionalNum;

    public WriteReviewAddImageBean() {
        this(0, 1, null);
    }

    public /* synthetic */ WriteReviewAddImageBean(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // com.huachenjie.mall.bean.WriteReviewImageBean, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    public final int getOptionalNum() {
        return this.optionalNum;
    }

    public final void setOptionalNum(int i) {
        this.optionalNum = i;
    }

    public WriteReviewAddImageBean(int i) {
        super(null, null, 3, null);
        this.optionalNum = i;
    }
}
