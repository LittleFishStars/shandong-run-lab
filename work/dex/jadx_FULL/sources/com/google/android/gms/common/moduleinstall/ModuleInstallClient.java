package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import com.zj.adlib.br5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ModuleInstallClient extends HasApiKey<Api.ApiOptions.a> {
    @NonNull
    Task<ModuleInstallResponse> a(@NonNull br5 br5Var);

    @NonNull
    Task<Boolean> b(@NonNull InstallStatusListener installStatusListener);

    @NonNull
    Task<ModuleAvailabilityResponse> c(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    Task<ModuleInstallIntentResponse> e(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    Task<Void> f(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    Task<Void> h(@NonNull OptionalModuleApi... optionalModuleApiArr);
}
