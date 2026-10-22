package com.huachenjie.works.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.widget.MaxHeightRecyclerView;
import com.huachenjie.works.R;
import com.zj.adlib.fx7;
import com.zj.adlib.y57;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/PopupWindow;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FindAlumniPicker$popupWindow$2 extends Lambda implements Function0<PopupWindow> {
    final /* synthetic */ Context $context;
    final /* synthetic */ FindAlumniPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindAlumniPicker$popupWindow$2(Context context, FindAlumniPicker findAlumniPicker) {
        super(0);
        this.$context = context;
        this.this$0 = findAlumniPicker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(PopupWindow popupWindow, View view) {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(FindAlumniPicker findAlumniPicker, View view) {
        Intrinsics.checkNotNullParameter(findAlumniPicker, "this$0");
        findAlumniPicker.i();
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final PopupWindow m989invoke() {
        View viewInflate = View.inflate(this.$context, R.layout.works_dialog_find_alumni_picker, null);
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) viewInflate.findViewById(R.id.recycler_view);
        maxHeightRecyclerView.setAdapter(this.this$0.getAdapter());
        maxHeightRecyclerView.setMaxHeightPx((fx7.h() * 3) / 5);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(this.this$0);
        View viewFindViewById = viewInflate.findViewById(R.id.v_bottom);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "popupView.findViewById<TextView>(R.id.v_bottom)");
        y57.f(viewFindViewById, 0L, new View.OnClickListener() { // from class: com.huachenjie.works.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindAlumniPicker$popupWindow$2.invoke$lambda$1(popupWindow, view);
            }
        }, 1, null);
        View viewFindViewById2 = viewInflate.findViewById(R.id.tv_confirm);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "popupView.findViewById<TextView>(R.id.tv_confirm)");
        final FindAlumniPicker findAlumniPicker = this.this$0;
        y57.f(viewFindViewById2, 0L, new View.OnClickListener() { // from class: com.huachenjie.works.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindAlumniPicker$popupWindow$2.invoke$lambda$2(findAlumniPicker, view);
            }
        }, 1, null);
        return popupWindow;
    }
}
