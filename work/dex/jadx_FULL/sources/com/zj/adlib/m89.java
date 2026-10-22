package com.zj.adlib;

import com.aliyun.credentials.utils.AuthConstant;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/m89;", "", "", "e", "", "a", "()Ljava/lang/Boolean;", AuthConstant.INI_ENABLE, "b", "(Ljava/lang/Boolean;)Lcom/zj/adlib/m89;", "", "toString", "", "hashCode", "other", "equals", "Ljava/lang/Boolean;", "d", "<init>", "(Ljava/lang/Boolean;)V", "wakelock_plus_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class m89 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final Boolean enable;

    /* JADX INFO: renamed from: com.zj.adlib.m89$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/zj/adlib/m89$a;", "", "", GoodsSpecificationPreviewActivity.z, "Lcom/zj/adlib/m89;", "a", "<init>", "()V", "wakelock_plus_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final m89 a(@NotNull List<? extends Object> list) {
        }
    }

    public m89() {
    }

    public m89(@Nullable Boolean bool) {
    }

    public static /* synthetic */ m89 c(m89 m89Var, Boolean bool, int i, Object obj) {
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final m89 b(@Nullable Boolean enable) {
    }

    @Nullable
    public final Boolean d() {
        return this.enable;
    }

    @NotNull
    public final List<Object> e() {
    }

    public boolean equals(@Nullable Object other) {
    }

    public int hashCode() {
    }

    @NotNull
    public String toString() {
    }

    public /* synthetic */ m89(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
    }
}
