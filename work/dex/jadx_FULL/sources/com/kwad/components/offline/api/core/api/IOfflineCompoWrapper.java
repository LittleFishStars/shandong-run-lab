package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class IOfflineCompoWrapper {
    protected String mOfflinePackageName;

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Application wrapApp(Application application);

    public abstract Context wrapContextIfNeed(@Nullable Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);
}
