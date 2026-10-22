package com.zj.adlib;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/b38;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "", "d", "e", "f", "Ljava/lang/String;", "title", y6b.f, "url", "", "getChildNode", "()Ljava/util/List;", "childNode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class b38 extends BaseNode {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String title;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final String url;

    public b38(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.title = str;
        this.url = str2;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }
}
