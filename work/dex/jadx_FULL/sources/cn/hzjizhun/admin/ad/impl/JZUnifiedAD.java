package cn.hzjizhun.admin.ad.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.listener.JZUnifiedADListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JZUnifiedAD extends BaseAd<JZUnifiedADListener> {
    public JZUnifiedAD(Activity activity) {
        super(activity);
    }

    public JZUnifiedAD(Activity activity, boolean z) {
        super(activity, z);
    }

    public JZUnifiedAD(Fragment fragment) {
        this(fragment.getActivity());
    }

    public JZUnifiedAD(Activity activity, String str, JZUnifiedADListener jZUnifiedADListener) {
        this(activity);
        if (str != null) {
            setJZAdId(str);
        }
        if (jZUnifiedADListener != null) {
            setJZAdListener(jZUnifiedADListener);
        }
    }
}
