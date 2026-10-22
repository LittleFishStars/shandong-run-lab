package com.huachenjie.base.bean;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006)"}, d2 = {"Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "Ljava/io/Serializable;", "()V", "value", "", "baseImageDownload", "getBaseImageDownload", "()I", "setBaseImageDownload", "(I)V", "baseImageParse", "getBaseImageParse", "setBaseImageParse", "bestImageCapture", "getBestImageCapture", "setBestImageCapture", "cameraStart", "getCameraStart", "setCameraStart", "livenessCheck", "getLivenessCheck", "setLivenessCheck", "modelInit", "getModelInit", "setModelInit", "similarityCheck", "getSimilarityCheck", "setSimilarityCheck", "statusChangeListener", "Lcom/huachenjie/base/bean/RunFaceDetectStatus$OnStatusChangeListener;", "getStatusChangeListener", "()Lcom/huachenjie/base/bean/RunFaceDetectStatus$OnStatusChangeListener;", "setStatusChangeListener", "(Lcom/huachenjie/base/bean/RunFaceDetectStatus$OnStatusChangeListener;)V", "uploadImage", "getUploadImage", "setUploadImage", "statusString", "", "Companion", "OnStatusChangeListener", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunFaceDetectStatus implements Serializable {
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_SUCCESS = 1;
    private int baseImageDownload;
    private int baseImageParse;
    private int bestImageCapture;
    private int cameraStart;
    private int livenessCheck;
    private int modelInit;
    private int similarityCheck;

    @Nullable
    private transient OnStatusChangeListener statusChangeListener;
    private int uploadImage;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/base/bean/RunFaceDetectStatus$OnStatusChangeListener;", "", "onStatusChange", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnStatusChangeListener {
        void onStatusChange();
    }

    public final int getBaseImageDownload() {
        return this.baseImageDownload;
    }

    public final int getBaseImageParse() {
        return this.baseImageParse;
    }

    public final int getBestImageCapture() {
        return this.bestImageCapture;
    }

    public final int getCameraStart() {
        return this.cameraStart;
    }

    public final int getLivenessCheck() {
        return this.livenessCheck;
    }

    public final int getModelInit() {
        return this.modelInit;
    }

    public final int getSimilarityCheck() {
        return this.similarityCheck;
    }

    @Nullable
    public final OnStatusChangeListener getStatusChangeListener() {
        return this.statusChangeListener;
    }

    public final int getUploadImage() {
        return this.uploadImage;
    }

    public final void setBaseImageDownload(int i) {
        if (this.baseImageDownload != i) {
            this.baseImageDownload = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setBaseImageParse(int i) {
        if (this.baseImageParse != i) {
            this.baseImageParse = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setBestImageCapture(int i) {
        if (this.bestImageCapture != i) {
            this.bestImageCapture = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setCameraStart(int i) {
        if (this.cameraStart != i) {
            this.cameraStart = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setLivenessCheck(int i) {
        if (this.livenessCheck != i) {
            this.livenessCheck = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setModelInit(int i) {
        if (this.modelInit != i) {
            this.modelInit = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setSimilarityCheck(int i) {
        if (this.similarityCheck != i) {
            this.similarityCheck = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    public final void setStatusChangeListener(@Nullable OnStatusChangeListener onStatusChangeListener) {
        this.statusChangeListener = onStatusChangeListener;
    }

    public final void setUploadImage(int i) {
        if (this.uploadImage != i) {
            this.uploadImage = i;
            OnStatusChangeListener onStatusChangeListener = this.statusChangeListener;
            if (onStatusChangeListener != null) {
                onStatusChangeListener.onStatusChange();
            }
        }
    }

    @NotNull
    public final String statusString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.modelInit);
        sb.append(this.baseImageDownload);
        sb.append(this.baseImageParse);
        sb.append(this.cameraStart);
        sb.append(this.bestImageCapture);
        sb.append(this.livenessCheck);
        sb.append(this.similarityCheck);
        sb.append(this.uploadImage);
        return sb.toString();
    }
}
