package com.alibaba.triver.app;

import android.app.Activity;
import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.view.EmbedAppContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class f extends EmbedAppContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f24623a;
    private App b;
    private int c;

    public f(App app, FragmentActivity fragmentActivity, @IdRes int i) {
        super(app, fragmentActivity);
        this.f24623a = fragmentActivity;
        this.b = app;
        this.c = i;
    }

    @Override // com.alibaba.ariver.app.view.EmbedAppContext
    public IFragmentManager createFragmentManager() {
        return new com.alibaba.triver.fragment.a(getApp(), this.c, getActivity());
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public ViewSpecProvider getViewSpecProvider() {
        return new com.alibaba.triver.content.f(this.f24623a, new e(this.b));
    }
}
