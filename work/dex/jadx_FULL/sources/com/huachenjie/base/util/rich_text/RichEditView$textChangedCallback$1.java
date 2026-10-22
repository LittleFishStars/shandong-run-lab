package com.huachenjie.base.util.rich_text;

import android.text.Editable;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", o.f, "Landroid/text/Editable;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RichEditView$textChangedCallback$1 extends Lambda implements Function1<Editable, Unit> {
    public static final RichEditView$textChangedCallback$1 INSTANCE = new RichEditView$textChangedCallback$1();

    public RichEditView$textChangedCallback$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Editable editable) {
    }
}
