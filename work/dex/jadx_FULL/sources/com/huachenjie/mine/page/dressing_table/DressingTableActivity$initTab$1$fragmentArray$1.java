package com.huachenjie.mine.page.dressing_table;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DressingTableActivity$initTab$1$fragmentArray$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DressingTableActivity$initTab$1$fragmentArray$1(Object obj) {
        super(1, obj, DressingTableActivity.class, "changMineAvatarFrame", "changMineAvatarFrame(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ((DressingTableActivity) ((CallableReference) this).receiver).c0(str);
    }
}
