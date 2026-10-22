package com.huachenjie.home.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/huachenjie/home/bean/GoodStuffBannerBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/home/bean/BannerItemBean;", "(Ljava/util/List;)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getList", "()Ljava/util/List;", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoodStuffBannerBean implements MultiItemEntity {

    @NotNull
    private final List<BannerItemBean> list;

    /* JADX WARN: Illegal instructions before constructor call */
    public GoodStuffBannerBean() {
        List list = null;
        this(list, 1, list);
    }

    public GoodStuffBannerBean(@NotNull List<BannerItemBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    @NotNull
    public final List<BannerItemBean> getList() {
        return this.list;
    }

    public /* synthetic */ GoodStuffBannerBean(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
