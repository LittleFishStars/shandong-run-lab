package com.kwad.sdk.wrapper;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class g extends Application implements b {
    private final Application aDR;
    private final h btY;

    public g(Application application, h hVar) {
        this.aDR = application;
        this.btY = hVar;
        try {
            ab.b(this, "mBase", hVar);
        } catch (Throwable unused) {
            attachBaseContext(hVar);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.aDR.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this.btY.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.btY.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.btY.getClassLoader();
    }

    @Override // com.kwad.sdk.wrapper.b
    @NonNull
    public final Context getDelegatedContext() {
        return this.aDR;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.btY.getResources();
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aDR.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void sendBroadcast(Intent intent) {
        this.aDR.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aDR.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr) {
        this.aDR.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        this.aDR.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    @RequiresApi(api = 26)
    public final ComponentName startForegroundService(Intent intent) {
        return this.aDR.startForegroundService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final ComponentName startService(Intent intent) {
        return this.aDR.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean stopService(Intent intent) {
        return this.aDR.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unbindService(ServiceConnection serviceConnection) {
        this.aDR.unbindService(serviceConnection);
    }

    @Override // android.app.Application
    public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.aDR.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivities(Intent[] intentArr, @Nullable Bundle bundle) {
        this.aDR.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, @Nullable Bundle bundle) {
        this.aDR.startActivity(intent, bundle);
    }
}
