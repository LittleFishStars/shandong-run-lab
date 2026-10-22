package com.zj.adlib;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/zj/adlib/mh3;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "", "d", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "a", "Ljava/util/List;", "child", "f", "Ljava/lang/String;", "title", "getChildNode", "()Ljava/util/List;", "childNode", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class mh3 extends BaseExpandNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<BaseNode> child;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String title;

    public mh3(@NotNull List<BaseNode> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "child");
        Intrinsics.checkNotNullParameter(str, "title");
        this.child = list;
        this.title = str;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @NotNull
    public List<BaseNode> getChildNode() {
        return this.child;
    }
}
