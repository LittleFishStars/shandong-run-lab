package com.kc.openset.video;

import androidx.fragment.app.Fragment;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface VideoContentResult {
    void destroy();

    Fragment getFragment();

    boolean onBackPress();

    void onHiddenChanged(boolean z);

    void onPause();

    void onResume();

    void setUserVisibleHint(boolean z);
}
