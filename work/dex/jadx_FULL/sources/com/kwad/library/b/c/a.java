package com.kwad.library.b.c;

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
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class a extends Application implements d {
    private final String TAG = "PluginApplicationWrapper";
    private final Application aDR;
    private b aDS;
    private String aDT;

    public a(Application application, String str) {
        this.aDR = application;
        this.aDT = str;
        b bVar = new b(application, this.aDT);
        this.aDS = bVar;
        try {
            ab.b(this, "mBase", bVar);
        } catch (Throwable unused) {
            attachBaseContext(this.aDS);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.aDR.bindService(intent, serviceConnection, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        try {
            Context contextM = c.m(this.aDR, this.aDT);
            Objects.toString(contextM);
            return contextM;
        } catch (Throwable th) {
            com.kwad.library.solder.lib.a.e("PluginApplicationWrapper", "PluginApplicationWrapper getApplicationContext error:  ", th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.aDS.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.aDS.getClassLoader();
    }

    @Override // com.kwad.library.b.c.d
    @NonNull
    public final Context getDelegatedContext() {
        return this.aDR;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.aDS.getResources();
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
