package com.ltmb.ltadsdk.api.internal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class AdPluginProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SYAdManager f40338a;
    public static IAdxAdLoaderManager b;
    public static IAdConfigApiRequest c;
    public static IRemoteOpen d;

    public static SYAdManager getAdManager() {
        return f40338a;
    }

    public static IAdConfigApiRequest.Request getConfigRequest() {
        IAdConfigApiRequest iAdConfigApiRequest = c;
        if (iAdConfigApiRequest != null) {
            return iAdConfigApiRequest.create();
        }
        return null;
    }

    public static IAdxAdLoaderManager getLoaderManager() {
        return b;
    }

    public static IRemoteOpen getRemoteOpen() {
        return d;
    }

    public static void setAdManager(SYAdManager sYAdManager) {
        f40338a = sYAdManager;
    }

    public static void setConfigRequest(IAdConfigApiRequest iAdConfigApiRequest) {
        c = iAdConfigApiRequest;
    }

    public static void setLoaderManager(IAdxAdLoaderManager iAdxAdLoaderManager) {
        b = iAdxAdLoaderManager;
    }

    public static void setRemoteOpen(IRemoteOpen iRemoteOpen) {
        d = iRemoteOpen;
    }
}
