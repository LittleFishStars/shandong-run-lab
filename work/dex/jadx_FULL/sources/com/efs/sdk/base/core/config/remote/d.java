package com.efs.sdk.base.core.config.remote;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile SharedPreferences f29597a;

    public static void b() {
        File fileA = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileA.exists()) {
            fileA.delete();
        }
    }

    private void d() {
        if (this.f29597a == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.f29597a == null) {
                    this.f29597a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, EncodeUtil.base64EncodeToStr(("config_" + ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.f29597a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(@NonNull RemoteConfig remoteConfig) {
        c();
        if (this.f29597a == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.f29597a.edit();
        editorEdit.clear();
        editorEdit.putInt("cver", remoteConfig.mConfigVersion);
        editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : remoteConfig.mSDKConfigMap.entrySet()) {
            editorEdit.putString(entry.getKey(), entry.getValue());
        }
        editorEdit.putString(UserTrackConstant.SIGN, remoteConfig.f29589a);
        editorEdit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (h.a.f29572a.a()) {
            return;
        }
        b.a().b();
    }

    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File fileB = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!fileB.exists()) {
            return false;
        }
        FileUtil.delete(fileB);
        return true;
    }
}
