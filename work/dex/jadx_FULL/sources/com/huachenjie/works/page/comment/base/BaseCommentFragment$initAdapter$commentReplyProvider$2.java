package com.huachenjie.works.page.comment.base;

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
public /* synthetic */ class BaseCommentFragment$initAdapter$commentReplyProvider$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public BaseCommentFragment$initAdapter$commentReplyProvider$2(Object obj) {
        super(1, obj, BaseCommentFragment.ClickProxy.class, "clickAvatar", "clickAvatar(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, bo.g);
        ((BaseCommentFragment.ClickProxy) ((CallableReference) this).receiver).a(str);
    }
}
