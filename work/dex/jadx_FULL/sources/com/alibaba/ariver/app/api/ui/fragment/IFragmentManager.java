package com.alibaba.ariver.app.api.ui.fragment;

import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.app.api.Page;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IFragmentManager {
    boolean attachFragment(RVFragment rVFragment, boolean z);

    RVFragment createFragment();

    boolean detachFragment(RVFragment rVFragment, boolean z);

    boolean exitPage(Page page, boolean z, boolean z2);

    RVFragment findFragmentForPage(Page page);

    Set<RVFragment> getFragments();

    FragmentManager getInnerManager();

    RVFragment getReadyFragment();

    void pushPage(Page page, RVFragment rVFragment, boolean z);

    void release();

    void resetFragmentToTop(RVFragment rVFragment);
}
