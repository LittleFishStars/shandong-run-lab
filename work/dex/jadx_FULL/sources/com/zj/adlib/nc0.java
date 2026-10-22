package com.zj.adlib;

import android.content.Context;
import com.huachenjie.base.widget.AttachListNoLinePopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.AttachListPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/r5a$b;", "", "", "data", "", "iconIds", "Lcom/lxj/xpopup/interfaces/OnSelectListener;", "selectListener", "Lcom/lxj/xpopup/impl/AttachListPopupView;", "a", "(Lcom/zj/adlib/r5a$b;[Ljava/lang/String;[ILcom/lxj/xpopup/interfaces/OnSelectListener;)Lcom/lxj/xpopup/impl/AttachListPopupView;", "base_release"}, k = 2, mv = {1, 8, 0})
public final class nc0 {
    @NotNull
    public static final AttachListPopupView a(@NotNull r5a.b bVar, @Nullable String[] strArr, @Nullable int[] iArr, @Nullable OnSelectListener onSelectListener) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        AttachListPopupView attachListPopupViewC = bVar.c(strArr, iArr, onSelectListener);
        Context context = attachListPopupViewC.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "first.context");
        AttachListPopupView onSelectListener2 = new AttachListNoLinePopupView(context).setStringData(strArr, iArr).setContentGravity(17).setOnSelectListener(onSelectListener);
        ((BasePopupView) onSelectListener2).popupInfo = ((BasePopupView) attachListPopupViewC).popupInfo;
        Intrinsics.checkNotNullExpressionValue(onSelectListener2, "AttachListNoLinePopupVie…first.popupInfo\n        }");
        return onSelectListener2;
    }
}
