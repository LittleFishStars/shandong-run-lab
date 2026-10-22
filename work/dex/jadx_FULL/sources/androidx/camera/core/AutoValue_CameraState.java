package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_CameraState extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    public AutoValue_CameraState(CameraState.Type type, @Nullable CameraState.StateError stateError) {
        if (type == null) {
            throw new NullPointerException("Null type");
        }
        this.type = type;
        this.error = stateError;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState)) {
            return false;
        }
        CameraState cameraState = (CameraState) obj;
        if (this.type.equals(cameraState.getType())) {
            CameraState.StateError stateError = this.error;
            if (stateError == null) {
                if (cameraState.getError() == null) {
                    return true;
                }
            } else if (stateError.equals(cameraState.getError())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraState
    @Nullable
    public CameraState.StateError getError() {
        return this.error;
    }

    @Override // androidx.camera.core.CameraState
    @NonNull
    public CameraState.Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError stateError = this.error;
        return iHashCode ^ (stateError == null ? 0 : stateError.hashCode());
    }

    public String toString() {
        return "CameraState{type=" + this.type + ", error=" + this.error + "}";
    }
}
