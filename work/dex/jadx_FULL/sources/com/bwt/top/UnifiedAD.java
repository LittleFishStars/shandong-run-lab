package com.bwt.top;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bwt.top.ad.BaseAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class UnifiedAD extends BaseAd<UnifiedADListener> {
    public UnifiedAD(Activity activity) {
        super(activity);
    }

    public UnifiedAD(Activity activity, String str, UnifiedADListener unifiedADListener) {
        this(activity);
        if (str != null) {
            setAdId(str);
        }
        if (unifiedADListener != null) {
            setAdListener(unifiedADListener);
        }
    }

    public UnifiedAD(Fragment fragment) {
        this(fragment.getActivity());
    }
}
