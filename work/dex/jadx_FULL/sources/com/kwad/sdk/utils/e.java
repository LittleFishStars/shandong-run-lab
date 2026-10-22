package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class e {
    public static int q(Activity activity) {
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android"));
        Log.v("dbw", "Navi height:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static boolean r(@NonNull Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).getContext().getPackageName();
                if (viewGroup.getChildAt(i).getId() != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
