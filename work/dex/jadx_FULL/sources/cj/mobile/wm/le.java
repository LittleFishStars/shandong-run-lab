package cj.mobile.wm;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class le {

    public static class dexa extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Button.class.getName());
        }
    }

    public static float dexa(Context context, float f) {
        if (context == null) {
            return 0.0f;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void dexa(int i, View view) {
        if (view == null || view.getVisibility() == i) {
            return;
        }
        view.setVisibility(i);
    }

    public static void dexa(View.OnClickListener onClickListener, View... viewArr) {
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnClickListener(onClickListener);
                    if (!(view instanceof Button)) {
                        view.setAccessibilityDelegate(new dexa());
                    }
                }
            }
        }
    }

    public static void dexa(boolean z, View... viewArr) {
        if (viewArr != null) {
            int i = z ? 0 : 8;
            for (View view : viewArr) {
                dexa(i, view);
            }
        }
    }
}
