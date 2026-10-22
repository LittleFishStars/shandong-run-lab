package com.huachenjie.base.util.rich_text;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", o.f, "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RichEditView$specialSymbolCallback$1 extends Lambda implements Function1<String, Unit> {
    public static final RichEditView$specialSymbolCallback$1 INSTANCE = new RichEditView$specialSymbolCallback$1();

    public RichEditView$specialSymbolCallback$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, o.f);
    }
}
