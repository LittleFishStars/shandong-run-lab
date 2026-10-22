package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class re7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f44434a = new HashMap();

    @KeepForSdk
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Provider f44435a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Class f19278a;

        @KeepForSdk
        public <RemoteT extends RemoteModel> a(@NonNull Class<RemoteT> cls, @NonNull Provider<? extends RemoteModelManagerInterface<RemoteT>> provider) {
            this.f19278a = cls;
            this.f44435a = provider;
        }

        public final Provider a() {
            return this.f44435a;
        }

        public final Class b() {
            return this.f19278a;
        }
    }

    @KeepForSdk
    public re7(@NonNull Set<a> set) {
        for (a aVar : set) {
            this.f44434a.put(aVar.b(), aVar.a());
        }
    }

    @NonNull
    public static synchronized re7 d() {
        return (re7) hq5.c().a(re7.class);
    }

    @NonNull
    public Task<Void> a(@NonNull RemoteModel remoteModel) {
        yw6.m(remoteModel, "RemoteModel cannot be null");
        return f(remoteModel.getClass()).c(remoteModel);
    }

    @NonNull
    public Task<Void> b(@NonNull RemoteModel remoteModel, @NonNull sp2 sp2Var) {
        yw6.m(remoteModel, "RemoteModel cannot be null");
        yw6.m(sp2Var, "DownloadConditions cannot be null");
        if (this.f44434a.containsKey(remoteModel.getClass())) {
            return f(remoteModel.getClass()).b(remoteModel, sp2Var);
        }
        return com.google.android.gms.tasks.a.d(new MlKitException("Feature model '" + remoteModel.getClass().getSimpleName() + "' doesn't have a corresponding modelmanager registered.", 13));
    }

    @NonNull
    public <T extends RemoteModel> Task<Set<T>> c(@NonNull Class<T> cls) {
        return ((RemoteModelManagerInterface) ((Provider) yw6.l((Provider) this.f44434a.get(cls))).get()).a();
    }

    @NonNull
    public Task<Boolean> e(@NonNull RemoteModel remoteModel) {
        yw6.m(remoteModel, "RemoteModel cannot be null");
        return f(remoteModel.getClass()).d(remoteModel);
    }

    public final RemoteModelManagerInterface f(Class cls) {
        return (RemoteModelManagerInterface) ((Provider) yw6.l((Provider) this.f44434a.get(cls))).get();
    }
}
