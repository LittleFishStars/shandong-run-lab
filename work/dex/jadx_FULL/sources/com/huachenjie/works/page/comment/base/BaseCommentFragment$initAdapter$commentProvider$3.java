package com.huachenjie.works.page.comment.base;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BaseCommentFragment$initAdapter$commentProvider$3 extends FunctionReferenceImpl implements Function1<BaseNode, Unit> {
    public BaseCommentFragment$initAdapter$commentProvider$3(Object obj) {
        super(1, obj, BaseCommentFragment.ClickProxy.class, "clickCommentOpt", "clickCommentOpt(Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseNode, bo.g);
        ((BaseCommentFragment.ClickProxy) ((CallableReference) this).receiver).c(baseNode);
    }
}
