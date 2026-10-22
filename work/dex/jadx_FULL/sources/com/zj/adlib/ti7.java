package com.zj.adlib;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0000H\u0007¨\u0006\b"}, d2 = {"Landroid/widget/TextView;", "", "content", "", "canJump", "", "d", "b", "base_release"}, k = 2, mv = {1, 8, 0})
public final class ti7 {
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void b(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.si7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ti7.c(view, motionEvent);
            }
        });
    }

    public static final boolean c(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            float x = motionEvent.getX();
            int y = (int) motionEvent.getY();
            float totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            float scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            Intrinsics.checkNotNullExpressionValue(layout, "v.layout");
            int lineForVertical = layout.getLineForVertical(scrollY);
            if (scrollX <= layout.getLineWidth(lineForVertical)) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableNewSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                Intrinsics.checkNotNullExpressionValue(clickableSpanArr, "link");
                if (!(clickableSpanArr.length == 0)) {
                    if (action != 1) {
                        return true;
                    }
                    clickableSpanArr[0].onClick(view);
                    return true;
                }
            }
        }
        return false;
    }

    public static final void d(@NotNull TextView textView, @NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "content");
        textView.setText(charSequence);
        if (z) {
            b(textView);
            textView.setHighlightColor(0);
        }
    }

    public static /* synthetic */ void e(TextView textView, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        d(textView, charSequence, z);
    }
}
