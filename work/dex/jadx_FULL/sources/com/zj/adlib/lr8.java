package com.zj.adlib;

import com.huachenjie.common.step.keep.StepDetectListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R$\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\r\u0010\u001d\"\u0004\b\u0017\u0010\u001e¨\u0006\""}, d2 = {"Lcom/zj/adlib/lr8;", "", "", "timestamp", "", "xAxis", "yAxis", "zAxis", "", "a", "", "I", "lastIndex", "b", "waveIndex", "J", "lastTimestamp", "F", "lastTotalWaveValue", "", "[F", "xAxisArray", "yAxisArray", "c", "zAxisArray", "d", "waveArray", "Lcom/huachenjie/common/step/keep/StepDetectListener;", "Lcom/huachenjie/common/step/keep/StepDetectListener;", "()Lcom/huachenjie/common/step/keep/StepDetectListener;", "(Lcom/huachenjie/common/step/keep/StepDetectListener;)V", "sensorDataListener", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class lr8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float lastTotalWaveValue;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int lastIndex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long lastTimestamp;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StepDetectListener sensorDataListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int waveIndex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final float[] xAxisArray = new float[50];

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final float[] yAxisArray = new float[50];

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final float[] zAxisArray = new float[50];

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final float[] waveArray = new float[10];

    public final void a(long timestamp, float xAxis, float yAxis, float zAxis) {
        float[] fArr = {xAxis, yAxis, zAxis};
        int i = this.lastIndex + 1;
        this.lastIndex = i;
        int i2 = i % 50;
        this.xAxisArray[i2] = xAxis;
        this.yAxisArray[i2] = fArr[1];
        this.zAxisArray[i2] = fArr[2];
        float fMin = Math.min(i, 50);
        f58 f58Var = f58.f41602a;
        float[] fArr2 = {f58Var.c(this.xAxisArray) / fMin, f58Var.c(this.yAxisArray) / fMin, f58Var.c(this.zAxisArray) / fMin};
        float fA = f58Var.a(fArr2);
        fArr2[0] = fArr2[0] / fA;
        fArr2[1] = fArr2[1] / fA;
        fArr2[2] = fArr2[2] / fA;
        float fB = f58Var.b(fArr2, fArr) - fA;
        int i3 = this.waveIndex + 1;
        this.waveIndex = i3;
        float[] fArr3 = this.waveArray;
        fArr3[i3 % 10] = fB;
        float fC = f58Var.c(fArr3);
        if (fC > 10.0f && this.lastTotalWaveValue <= 10.0f && timestamp - this.lastTimestamp > 250000000) {
            StepDetectListener stepDetectListener = this.sensorDataListener;
            if (stepDetectListener != null) {
                stepDetectListener.a(timestamp);
            }
            this.lastTimestamp = timestamp;
        }
        this.lastTotalWaveValue = fC;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: from getter */
    public final StepDetectListener getSensorDataListener() {
        return this.sensorDataListener;
    }

    public final void c(@Nullable StepDetectListener stepDetectListener) {
        this.sensorDataListener = stepDetectListener;
    }
}
