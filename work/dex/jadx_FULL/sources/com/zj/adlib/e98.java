package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class e98 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public static final Component<?> f41378a = Component.builder(e98.class).add(Dependency.required(hq5.class)).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.jqd
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new e98((Context) componentContainer.get(Context.class));
        }
    }).build();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f16246a = "com.google.mlkit.internal";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Context f16247a;

    public e98(@NonNull Context context) {
        this.f16247a = context;
    }

    @NonNull
    @KeepForSdk
    public static e98 g(@NonNull hq5 hq5Var) {
        return (e98) hq5Var.a(e98.class);
    }

    @KeepForSdk
    public synchronized void a(@NonNull RemoteModel remoteModel) {
        zza().edit().remove(String.format("downloading_model_id_%s", remoteModel.f())).remove(String.format("downloading_model_hash_%s", remoteModel.f())).remove(String.format("downloading_model_type_%s", d(remoteModel))).remove(String.format("downloading_begin_time_%s", remoteModel.f())).remove(String.format("model_first_use_time_%s", remoteModel.f())).apply();
    }

    @KeepForSdk
    public synchronized void b(@NonNull RemoteModel remoteModel) {
        zza().edit().remove(String.format("bad_hash_%s", remoteModel.f())).remove(AlibcCommonConstant.APP_VERSION).apply();
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void c(@NonNull RemoteModel remoteModel) {
        zza().edit().remove(String.format("current_model_hash_%s", remoteModel.f())).commit();
    }

    @Nullable
    @KeepForSdk
    public synchronized String d(@NonNull RemoteModel remoteModel) {
        return zza().getString(String.format("downloading_model_hash_%s", remoteModel.f()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized Long e(@NonNull RemoteModel remoteModel) {
        long j = zza().getLong(String.format("downloading_model_id_%s", remoteModel.f()), -1L);
        if (j < 0) {
            return null;
        }
        return Long.valueOf(j);
    }

    @Nullable
    @KeepForSdk
    public synchronized String f(@NonNull RemoteModel remoteModel) {
        return zza().getString(String.format("bad_hash_%s", remoteModel.f()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized String h(@NonNull RemoteModel remoteModel) {
        return zza().getString(String.format("current_model_hash_%s", remoteModel.f()), null);
    }

    @NonNull
    @KeepForSdk
    public synchronized String i() {
        String string = zza().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        zza().edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }

    @KeepForSdk
    public synchronized long j(@NonNull RemoteModel remoteModel) {
        return zza().getLong(String.format("downloading_begin_time_%s", remoteModel.f()), 0L);
    }

    @KeepForSdk
    public synchronized long k(@NonNull RemoteModel remoteModel) {
        return zza().getLong(String.format("model_first_use_time_%s", remoteModel.f()), 0L);
    }

    @Nullable
    @KeepForSdk
    public synchronized String l() {
        return zza().getString(AlibcCommonConstant.APP_VERSION, null);
    }

    @KeepForSdk
    public synchronized void m(long j, @NonNull tq5 tq5Var) {
        String strB = tq5Var.b();
        zza().edit().putString(String.format("downloading_model_hash_%s", strB), tq5Var.a()).putLong(String.format("downloading_model_id_%s", strB), j).putLong(String.format("downloading_begin_time_%s", strB), SystemClock.elapsedRealtime()).apply();
    }

    @KeepForSdk
    public synchronized void n(@NonNull RemoteModel remoteModel, @NonNull String str, @NonNull String str2) {
        zza().edit().putString(String.format("bad_hash_%s", remoteModel.f()), str).putString(AlibcCommonConstant.APP_VERSION, str2).apply();
    }

    @KeepForSdk
    public synchronized void o(@NonNull RemoteModel remoteModel, @NonNull String str) {
        zza().edit().putString(String.format("current_model_hash_%s", remoteModel.f()), str).apply();
    }

    @KeepForSdk
    public synchronized void p(@NonNull RemoteModel remoteModel, long j) {
        zza().edit().putLong(String.format("model_first_use_time_%s", remoteModel.f()), j).apply();
    }

    @Nullable
    public final synchronized String q(@NonNull String str, long j) {
        return zza().getString(String.format("cached_local_model_hash_%1s_%2s", yw6.l(str), Long.valueOf(j)), null);
    }

    public final synchronized void r(@NonNull String str, long j, @NonNull String str2) {
        zza().edit().putString(String.format("cached_local_model_hash_%1s_%2s", yw6.l(str), Long.valueOf(j)), str2).apply();
    }

    @NonNull
    public final SharedPreferences zza() {
        return this.f16247a.getSharedPreferences(f16246a, 0);
    }
}
