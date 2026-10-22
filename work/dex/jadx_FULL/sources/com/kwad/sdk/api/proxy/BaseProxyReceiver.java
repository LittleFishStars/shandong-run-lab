package com.kwad.sdk.api.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class BaseProxyReceiver extends BroadcastReceiver {
    private IReceiverProxy mDelegate;

    @NonNull
    public abstract IReceiverProxy getDelegate(Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegate == null) {
            this.mDelegate = getDelegate(Wrapper.wrapContextIfNeed(context));
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onReceive(context, intent);
    }
}
