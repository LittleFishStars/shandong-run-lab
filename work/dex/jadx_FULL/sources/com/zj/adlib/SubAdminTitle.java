package com.zj.adlib;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.xt8, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/zj/adlib/xt8;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "", "a", "count", "b", "", "toString", "hashCode", "", "other", "", "equals", "K", "I", "d", "()I", "e", "(I)V", "getItemType", CollegeTownItemFragment.ITEM_TYPE, "<init>", "channel_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SubAdminTitle implements MultiItemEntity {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata and from toString */
    public int count;

    public SubAdminTitle(int i) {
        this.count = i;
    }

    public static /* synthetic */ SubAdminTitle c(SubAdminTitle subAdminTitle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subAdminTitle.count;
        }
        return subAdminTitle.b(i);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final SubAdminTitle b(int count) {
        return new SubAdminTitle(count);
    }

    public final int d() {
        return this.count;
    }

    public final void e(int i) {
        this.count = i;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SubAdminTitle) && this.count == ((SubAdminTitle) other).count;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    public int hashCode() {
        return Integer.hashCode(this.count);
    }

    @NotNull
    public String toString() {
        return "SubAdminTitle(count=" + this.count + ')';
    }
}
