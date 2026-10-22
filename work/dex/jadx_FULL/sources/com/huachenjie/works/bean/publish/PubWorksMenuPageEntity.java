package com.huachenjie.works.bean.publish;

import com.huachenjie.base.widget.OperatePopupWindow;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "T", "Lhuachenjie/sdk/http/PageEntity;", "type", "", "(I)V", "getType", "()I", "setType", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorksMenuPageEntity<T> extends PageEntity<T> {
    private int type;

    public PubWorksMenuPageEntity() {
        this(0, 1, null);
    }

    public /* synthetic */ PubWorksMenuPageEntity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public static /* synthetic */ PubWorksMenuPageEntity copy$default(PubWorksMenuPageEntity pubWorksMenuPageEntity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pubWorksMenuPageEntity.type;
        }
        return pubWorksMenuPageEntity.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final PubWorksMenuPageEntity<T> copy(int type) {
        return new PubWorksMenuPageEntity<>(type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PubWorksMenuPageEntity) && this.type == ((PubWorksMenuPageEntity) other).type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.type);
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "PubWorksMenuPageEntity(type=" + this.type + ')';
    }

    public PubWorksMenuPageEntity(int i) {
        this.type = i;
    }
}
