package com.kc.aw.activity;

import android.os.Build;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgInteractionLandscapeActivity extends PtgInteractionPortraitActivity {
    @Override // com.kc.aw.activity.PtgInteractionPortraitActivity
    public final void _a() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(0);
        }
    }
}
