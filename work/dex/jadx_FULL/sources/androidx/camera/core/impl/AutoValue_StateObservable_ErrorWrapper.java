package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_StateObservable_ErrorWrapper extends StateObservable.ErrorWrapper {
    private final Throwable error;

    public AutoValue_StateObservable_ErrorWrapper(Throwable th) {
        if (th == null) {
            throw new NullPointerException("Null error");
        }
        this.error = th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StateObservable.ErrorWrapper) {
            return this.error.equals(((StateObservable.ErrorWrapper) obj).getError());
        }
        return false;
    }

    @Override // androidx.camera.core.impl.StateObservable.ErrorWrapper
    @NonNull
    public Throwable getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.error + "}";
    }
}
