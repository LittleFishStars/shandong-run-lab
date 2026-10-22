package com.kc.bw.common.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.camera.video.AudioStats;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LocationUtils {
    public static final String TAG = dexg.dexa("MpdbujpoVujmt");
    public static double longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    public static double latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    public static float accuracy = 0.0f;

    private float getAccuracyWithNetwork(Context context) {
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO"))) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"))).getLastKnownLocation(dexg.dexa("ofuxpsl"));
                if (lastKnownLocation != null) {
                    latitude = lastKnownLocation.getLatitude();
                    longitude = lastKnownLocation.getLongitude();
                    accuracy = lastKnownLocation.getAccuracy();
                }
            } else {
                DebugLog.W(TAG, dexg.dexa("毛徎楲鵦�瞄ꚑ轻楲\""));
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuBddvsbdzXjuiOfuxpsl!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.毛徎賿滧ꈈ꜇楲鵦)hfuBddvsbdzXjuiOfuxpsl*-"), th);
        }
        return accuracy;
    }

    private double getLatWithNetwork(Context context) {
        Location lastKnownLocation;
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO")) && (lastKnownLocation = ((LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"))).getLastKnownLocation(dexg.dexa("ofuxpsl"))) != null) {
                latitude = lastKnownLocation.getLatitude();
                longitude = lastKnownLocation.getLongitude();
                accuracy = lastKnownLocation.getAccuracy();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuMbuXjuiOfuxpsl!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.毛徎賿滧ꈈ꜇楲鵦)hfuMbuXjuiOfuxpsl*-"), th);
        }
        return latitude;
    }

    private double getLngWithNetwork(Context context) {
        Location lastKnownLocation;
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO")) && (lastKnownLocation = ((LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"))).getLastKnownLocation(dexg.dexa("ofuxpsl"))) != null) {
                latitude = lastKnownLocation.getLatitude();
                longitude = lastKnownLocation.getLongitude();
                accuracy = lastKnownLocation.getAccuracy();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuMohXjuiOfuxpsl!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.軭滧ꈈ꜇楲鵦)hfuMohXjuiOfuxpsl*-"), th);
        }
        return latitude;
    }

    private void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 900024, dexg.dexa("鯿楈���炰ꈈ꜇楲鵦"), str + (th != null ? th.toString() : ""));
    }

    public float getAccuracy(Context context) {
        Location lastKnownLocation;
        float f = accuracy;
        if (f > 0.0f) {
            return f;
        }
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO"))) {
                LocationManager locationManager = (LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"));
                if (locationManager.isProviderEnabled(dexg.dexa("hqt")) && (lastKnownLocation = locationManager.getLastKnownLocation(dexg.dexa("hqt"))) != null) {
                    latitude = lastKnownLocation.getLatitude();
                    longitude = lastKnownLocation.getLongitude();
                    accuracy = lastKnownLocation.getAccuracy();
                }
                return getAccuracyWithNetwork(context);
            }
            DebugLog.W(TAG, dexg.dexa("毛徎楲鵦�瞄ꚑ轻楲\""));
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuBddvsbdz!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.毛徎賿滧ꈈ꜇楲鵦)hfuBddvsbdz*-"), th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.W(TAG, dexg.dexa("ꈈ꜇毛徎賿滧遘瘷�") + elapsedRealTime2 + dexg.dexa("!nt"));
        }
        return accuracy;
    }

    public double getLatitude(Context context) {
        Location lastKnownLocation;
        double d = latitude;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return d;
        }
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO"))) {
                LocationManager locationManager = (LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"));
                if (locationManager.isProviderEnabled(dexg.dexa("hqt")) && (lastKnownLocation = locationManager.getLastKnownLocation(dexg.dexa("hqt"))) != null) {
                    latitude = lastKnownLocation.getLatitude();
                    longitude = lastKnownLocation.getLongitude();
                    accuracy = lastKnownLocation.getAccuracy();
                }
                return getLngWithNetwork(context);
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuMbujuvef!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.軭滧ꈈ꜇楲鵦)hfuMbujuvef*-"), th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.W(TAG, dexg.dexa("ꈈ꜇毛徎軭滧遘瘷�") + elapsedRealTime2 + dexg.dexa("!nt"));
        }
        return latitude;
    }

    public double getLongitude(Context context) {
        Location lastKnownLocation;
        double d = longitude;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return d;
        }
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            if (PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`GJOF`MPDBUJPO")) && PermissionUtils.checkPermission(context, dexg.dexa("boespje/qfsnjttjpo/BDDFTT`DPBSTF`MPDBUJPO"))) {
                LocationManager locationManager = (LocationManager) context.getSystemService(dexg.dexa("mpdbujpo"));
                if (locationManager.isProviderEnabled(dexg.dexa("hqt")) && (lastKnownLocation = locationManager.getLastKnownLocation(dexg.dexa("hqt"))) != null) {
                    latitude = lastKnownLocation.getLatitude();
                    longitude = lastKnownLocation.getLongitude();
                    accuracy = lastKnownLocation.getAccuracy();
                }
                return getLatWithNetwork(context);
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, dexg.dexa("hfuMpohjuvef!fssps;") + th);
            reportErrorInfo(context, dexg.dexa("東葇徎辯.輐滧ꈈ꜇楲鵦)hfuMpohjuvef*-"), th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.W(TAG, dexg.dexa("ꈈ꜇毛徎輐滧遘瘷�") + elapsedRealTime2 + dexg.dexa("!nt"));
        }
        return longitude;
    }
}
