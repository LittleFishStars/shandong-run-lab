package com.alibaba.triver.fragment;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.activity.DefaultFragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends DefaultFragmentManager {
    public a(App app, int i, FragmentActivity fragmentActivity) {
        super(app, i, fragmentActivity);
    }

    @Override // com.alibaba.ariver.app.activity.DefaultFragmentManager, com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment createFragment() {
        return new TRFragment();
    }
}
