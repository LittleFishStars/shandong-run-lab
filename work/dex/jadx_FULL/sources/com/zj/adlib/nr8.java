package com.zj.adlib;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.step.StepCountListener;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\"\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010'\u001a\u0004\b%\u0010(\"\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010'R\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u00100\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u0010\u001eR\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u0014018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00109¨\u0006="}, d2 = {"Lcom/zj/adlib/nr8;", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/SensorEvent;", "event", "", "onSensorChanged", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "Lcom/huachenjie/common/step/StepCountListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "f", "Lcom/zj/adlib/nr;", "newData", "b", "oldData", "", "c", "", "value", y6b.f, "ave", "d", "Lcom/zj/adlib/sq4;", "a", "Z", "isDirectionUp", "K", "I", "continueUpCount", "Lcom/zj/adlib/nr;", "peakData", "valleyData", "lastPeakData", "lastVallyData", "e", "lastData", "F", "()F", y6b.g, "(F)V", "thresholdValue", "initialThresholdValue", "minPeakInterval", "minPeakValleyInterval", "L", "calcThresholdWindowSize", "Ljava/util/Queue;", "Ljava/util/Queue;", "calcThresholdWindow", "Lcom/huachenjie/common/step/StepCountListener;", "mStepListeners", "", "J", "startTime", "Lcom/zj/adlib/sq4;", "kalmanFilter", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class nr8 implements SensorEventListener {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int continueUpCount;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long startTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StepCountListener mStepListeners;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AccData peakData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isDirectionUp;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AccData valleyData;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AccData lastPeakData;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AccData lastVallyData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public AccData lastData;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float thresholdValue = 2.0f;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float initialThresholdValue = 2.0f;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float minPeakInterval = 0.2f;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final float minPeakValleyInterval = 0.08f;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int calcThresholdWindowSize = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public Queue<Float> calcThresholdWindow = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public sq4 kalmanFilter = a();

    public final sq4 a() {
        return new sq4(new sh2(new Array2DRowRealMatrix(new double[][]{new double[]{1.0d, 1.0d}, new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d}}), (RealMatrix) null, new Array2DRowRealMatrix(new double[][]{new double[]{1.0E-4d, 0.001d}, new double[]{0.001d, 0.1d}}), new ArrayRealVector(new double[]{9.8d, AudioStats.AUDIO_AMPLITUDE_NONE}), new Array2DRowRealMatrix(new double[][]{new double[]{1000.0d, AudioStats.AUDIO_AMPLITUDE_NONE}, new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, 1000.0d}})), new xg2(new Array2DRowRealMatrix(new double[][]{new double[]{1.0d, AudioStats.AUDIO_AMPLITUDE_NONE}}), new Array2DRowRealMatrix(new double[]{5.0d})));
    }

    public final void b(AccData newData) {
        AccData accData = this.lastData;
        if (accData == null) {
            this.lastData = newData;
            return;
        }
        if (c(newData, accData)) {
            AccData accData2 = this.lastPeakData;
            float fK = accData2 != null ? accData2.k() : 0.0f;
            AccData accData3 = this.peakData;
            Intrinsics.checkNotNull(accData3);
            float fK2 = accData3.k();
            AccData accData4 = this.valleyData;
            Intrinsics.checkNotNull(accData4);
            float fK3 = accData4.k();
            AccData accData5 = this.peakData;
            Intrinsics.checkNotNull(accData5);
            float fJ = accData5.j();
            AccData accData6 = this.valleyData;
            Intrinsics.checkNotNull(accData6);
            float fJ2 = fJ - accData6.j();
            float f = fK2 - fK;
            float f2 = this.minPeakInterval;
            if (f >= f2 && fK2 - fK3 >= this.minPeakValleyInterval && fJ2 >= this.thresholdValue) {
                g(fJ2);
                StepCountListener stepCountListener = this.mStepListeners;
                Intrinsics.checkNotNull(stepCountListener);
                stepCountListener.a();
            } else if (f >= f2 && fK2 - fK3 >= this.minPeakValleyInterval && fJ2 >= this.initialThresholdValue) {
                g(fJ2);
            }
        }
        this.lastData = newData;
    }

    public final boolean c(AccData newData, AccData oldData) {
        boolean z = this.isDirectionUp;
        int i = this.continueUpCount;
        boolean z2 = newData.j() >= oldData.j();
        this.isDirectionUp = z2;
        if (z2) {
            this.continueUpCount++;
        } else {
            this.continueUpCount = 0;
        }
        if (!z2 && z && (i >= 4 || oldData.j() >= 20.0f)) {
            this.lastPeakData = this.peakData;
            this.peakData = oldData;
            return true;
        }
        if (this.isDirectionUp && !z) {
            this.lastVallyData = this.valleyData;
            this.valleyData = oldData;
        }
        return false;
    }

    public final float d(float ave) {
        return 2.0f;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final float getThresholdValue() {
        return this.thresholdValue;
    }

    public final void f(@Nullable StepCountListener listener) {
        this.mStepListeners = listener;
    }

    public final void g(float value) {
        this.calcThresholdWindow.offer(Float.valueOf(value));
        if (this.calcThresholdWindow.size() > this.calcThresholdWindowSize) {
            this.calcThresholdWindow.poll();
        }
        this.thresholdValue = d((float) CollectionsKt.averageOfFloat(this.calcThresholdWindow));
    }

    public final void h(float f) {
        this.thresholdValue = f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        long j = event.timestamp / ((long) 1000000);
        if (this.startTime == 0) {
            this.startTime = j;
        }
        float[] fArr = event.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        this.kalmanFilter.i();
        this.kalmanFilter.a(new ArrayRealVector(new double[]{fSqrt}));
        b(new AccData((j - this.startTime) / 1000.0f, f, f2, f3, fSqrt, (float) this.kalmanFilter.g()[0]));
    }
}
