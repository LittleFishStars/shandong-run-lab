package com.huachenjie.college.bean;

import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/college/bean/RecommendEmptyItemBean;", "Lcom/huachenjie/college/bean/RecommendItemBean;", "()V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecommendEmptyItemBean extends RecommendItemBean {
    public RecommendEmptyItemBean() {
        super(null, null, null, 0, 15, null);
    }

    @Override // com.huachenjie.college.bean.RecommendItemBean, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }
}
