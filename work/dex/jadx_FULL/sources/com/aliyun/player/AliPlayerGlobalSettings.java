package com.aliyun.player;

import com.aliyun.utils.f;
import com.cicada.player.utils.NativeUsed;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliPlayerGlobalSettings {
    private static OnGetUrlHashCallback sOnGetUrlHashCallback;
    private static OnNetworkCallback sOnNetworkCallback;

    public interface OnGetUrlHashCallback {
        String getUrlHashCallback(String str);
    }

    public interface OnNetworkCallback {
        boolean onNetworkDataProcess(String str, ByteBuffer byteBuffer, long j, ByteBuffer byteBuffer2);
    }

    public enum StreamType {
        STREAM_VOICE_CALL,
        STREAM_SYSTEM,
        STREAM_RING,
        STREAM_MUSIC,
        STREAM_ALARM,
        STREAM_NOTIFICATION
    }

    static {
        f.b();
        sOnGetUrlHashCallback = null;
        sOnNetworkCallback = null;
    }

    public static void clearCaches() {
        nClearCaches();
    }

    public static void disableCrashUpload(boolean z) {
        nDisableCrashUpload(z);
    }

    public static void enableBufferToLocalCache(boolean z) {
        nEnableBufferToLocalCache(z);
    }

    public static void enableEnhancedHttpDns(boolean z) {
        nEnableEnhancedHttpDns(z);
    }

    public static void enableHttpDns(boolean z) {
        nEnableHttpDns(z);
    }

    public static void enableLocalCache(boolean z, int i, String str) {
        nEnableLocalCache(z, i, str);
    }

    public static void enableNetworkBalance(boolean z) {
        nEnableNetworkBalance(z);
    }

    public static void forceAudioRendingFormat(boolean z, String str, int i, int i2) {
        nForceAudioRendingFormat(z, str, i, i2);
    }

    public static void loadClass() {
    }

    private static native void nClearCaches();

    private static native void nDisableCrashUpload(boolean z);

    private static native void nEnableBufferToLocalCache(boolean z);

    private static native void nEnableEnhancedHttpDns(boolean z);

    private static native void nEnableHttpDns(boolean z);

    private static native void nEnableLocalCache(boolean z, int i, String str);

    private static native void nEnableNetworkBalance(boolean z);

    private static native void nForceAudioRendingFormat(boolean z, String str, int i, int i2);

    @NativeUsed
    private static synchronized String nOnGetUrlHashCallback(String str) {
        OnGetUrlHashCallback onGetUrlHashCallback = sOnGetUrlHashCallback;
        if (onGetUrlHashCallback == null) {
            return null;
        }
        return onGetUrlHashCallback.getUrlHashCallback(str);
    }

    @NativeUsed
    private static synchronized boolean nOnNetworkDataProcessCallback(String str, ByteBuffer byteBuffer, long j, ByteBuffer byteBuffer2) {
        OnNetworkCallback onNetworkCallback = sOnNetworkCallback;
        if (onNetworkCallback == null) {
            return false;
        }
        return onNetworkCallback.onNetworkDataProcess(str, byteBuffer, j, byteBuffer2);
    }

    private static native void nSetAudioStreamType(int i);

    private static native void nSetCacheFileClearConfig(long j, long j2, long j3);

    private static native void nSetCacheUrlHashCallback(boolean z);

    private static native void nSetDNSResolve(String str, String str2);

    private static native void nSetIPResolveType(int i);

    private static native void nSetNetworkCallback(boolean z);

    private static native void nSetUseHttp2(boolean z);

    public static void setAudioStreamType(StreamType streamType) {
        nSetAudioStreamType(streamType.ordinal());
    }

    public static void setCacheFileClearConfig(long j, long j2, long j3) {
        nSetCacheFileClearConfig(j, j2, j3);
    }

    public static synchronized void setCacheUrlHashCallback(OnGetUrlHashCallback onGetUrlHashCallback) {
        sOnGetUrlHashCallback = onGetUrlHashCallback;
        nSetCacheUrlHashCallback(onGetUrlHashCallback != null);
    }

    public static void setDNSResolve(String str, String str2) {
        nSetDNSResolve(str, str2);
    }

    public static void setIPResolveType(IPlayer.IPResolveType iPResolveType) {
        nSetIPResolveType(iPResolveType.ordinal());
    }

    public static synchronized void setNetworkCallback(OnNetworkCallback onNetworkCallback) {
        sOnNetworkCallback = onNetworkCallback;
        nSetNetworkCallback(onNetworkCallback != null);
    }

    public static void setUseHttp2(boolean z) {
        nSetUseHttp2(z);
    }
}
