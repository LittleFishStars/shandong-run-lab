package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_VideoEncoderDataSpace extends VideoEncoderDataSpace {
    private final int range;
    private final int standard;
    private final int transfer;

    public AutoValue_VideoEncoderDataSpace(int i, int i2, int i3) {
        this.standard = i;
        this.transfer = i2;
        this.range = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoEncoderDataSpace)) {
            return false;
        }
        VideoEncoderDataSpace videoEncoderDataSpace = (VideoEncoderDataSpace) obj;
        return this.standard == videoEncoderDataSpace.getStandard() && this.transfer == videoEncoderDataSpace.getTransfer() && this.range == videoEncoderDataSpace.getRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getRange() {
        return this.range;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getStandard() {
        return this.standard;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getTransfer() {
        return this.transfer;
    }

    public int hashCode() {
        return ((((this.standard ^ 1000003) * 1000003) ^ this.transfer) * 1000003) ^ this.range;
    }

    public String toString() {
        return "VideoEncoderDataSpace{standard=" + this.standard + ", transfer=" + this.transfer + ", range=" + this.range + "}";
    }
}
