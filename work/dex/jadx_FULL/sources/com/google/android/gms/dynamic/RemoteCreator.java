package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class RemoteCreator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f31318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5713a;

    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(@NonNull String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    public RemoteCreator(@NonNull String str) {
        this.f5713a = str;
    }

    @NonNull
    @KeepForSdk
    public abstract T getRemoteCreator(@NonNull IBinder iBinder);

    @NonNull
    @KeepForSdk
    public final T getRemoteCreatorInstance(@NonNull Context context) throws RemoteCreatorException {
        if (this.f31318a == null) {
            yw6.l(context);
            Context contextI = com.google.android.gms.common.b.i(context);
            if (contextI == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.f31318a = getRemoteCreator((IBinder) contextI.getClassLoader().loadClass(this.f5713a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return (T) this.f31318a;
    }
}
