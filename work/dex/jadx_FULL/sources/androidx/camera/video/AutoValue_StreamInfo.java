package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_StreamInfo extends StreamInfo {
    private final int id;
    private final SurfaceRequest.TransformationInfo inProgressTransformationInfo;
    private final StreamInfo.StreamState streamState;

    public AutoValue_StreamInfo(int i, StreamInfo.StreamState streamState, @Nullable SurfaceRequest.TransformationInfo transformationInfo) {
        this.id = i;
        if (streamState == null) {
            throw new NullPointerException("Null streamState");
        }
        this.streamState = streamState;
        this.inProgressTransformationInfo = transformationInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        if (this.id == streamInfo.getId() && this.streamState.equals(streamInfo.getStreamState())) {
            SurfaceRequest.TransformationInfo transformationInfo = this.inProgressTransformationInfo;
            if (transformationInfo == null) {
                if (streamInfo.getInProgressTransformationInfo() == null) {
                    return true;
                }
            } else if (transformationInfo.equals(streamInfo.getInProgressTransformationInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.StreamInfo
    public int getId() {
        return this.id;
    }

    @Override // androidx.camera.video.StreamInfo
    @Nullable
    public SurfaceRequest.TransformationInfo getInProgressTransformationInfo() {
        return this.inProgressTransformationInfo;
    }

    @Override // androidx.camera.video.StreamInfo
    @NonNull
    public StreamInfo.StreamState getStreamState() {
        return this.streamState;
    }

    public int hashCode() {
        int iHashCode = (((this.id ^ 1000003) * 1000003) ^ this.streamState.hashCode()) * 1000003;
        SurfaceRequest.TransformationInfo transformationInfo = this.inProgressTransformationInfo;
        return iHashCode ^ (transformationInfo == null ? 0 : transformationInfo.hashCode());
    }

    public String toString() {
        return "StreamInfo{id=" + this.id + ", streamState=" + this.streamState + ", inProgressTransformationInfo=" + this.inProgressTransformationInfo + "}";
    }
}
