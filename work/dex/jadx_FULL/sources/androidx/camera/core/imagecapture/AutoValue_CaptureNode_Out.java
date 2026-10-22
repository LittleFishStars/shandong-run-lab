package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_CaptureNode_Out extends CaptureNode.Out {
    private final Edge<ImageProxy> imageEdge;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingRequest> requestEdge;

    public AutoValue_CaptureNode_Out(Edge<ImageProxy> edge, Edge<ProcessingRequest> edge2, int i, int i2) {
        if (edge == null) {
            throw new NullPointerException("Null imageEdge");
        }
        this.imageEdge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.requestEdge = edge2;
        this.inputFormat = i;
        this.outputFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.Out)) {
            return false;
        }
        CaptureNode.Out out = (CaptureNode.Out) obj;
        return this.imageEdge.equals(out.getImageEdge()) && this.requestEdge.equals(out.getRequestEdge()) && this.inputFormat == out.getInputFormat() && this.outputFormat == out.getOutputFormat();
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    public Edge<ImageProxy> getImageEdge() {
        return this.imageEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    public int hashCode() {
        return ((((((this.imageEdge.hashCode() ^ 1000003) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "Out{imageEdge=" + this.imageEdge + ", requestEdge=" + this.requestEdge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }
}
