package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";

    @NonNull
    final CameraInternal mCameraInternal;

    @Nullable
    private In mInput;

    @Nullable
    private Out mOutput;

    @NonNull
    final SurfaceProcessorInternal mSurfaceProcessor;

    @AutoValue
    public static abstract class In {
        @NonNull
        public static In of(@NonNull SurfaceEdge surfaceEdge, @NonNull List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }

        @NonNull
        public abstract List<OutConfig> getOutConfigs();

        @NonNull
        public abstract SurfaceEdge getSurfaceEdge();
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createAndSendSurfaceOutput, reason: merged with bridge method [inline-methods] */
    public void lambda$sendSurfaceOutputs$0(@NonNull SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        Futures.addCallback(entry.getValue().createSurfaceOutputFuture(surfaceEdge.getStreamSpec().getResolution(), entry.getKey().getFormat(), entry.getKey().getCropRect(), entry.getKey().getRotationDegrees(), entry.getKey().getMirroring(), surfaceEdge.hasCameraTransform() ? this.mCameraInternal : null), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            Iterator<SurfaceEdge> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).getMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    private void sendSurfaceOutputs(@NonNull final SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        for (final Map.Entry<OutConfig, SurfaceEdge> entry : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, entry);
            entry.getValue().addOnInvalidatedListener(new Runnable(this, surfaceEdge, entry) { // from class: com.zj.adlib.fx8

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SurfaceEdge f41778a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ SurfaceProcessorNode f16639a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Map.Entry f16640a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    private void sendSurfaceRequest(@NonNull SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        SurfaceRequest surfaceRequestCreateSurfaceRequest = surfaceEdge.createSurfaceRequest(this.mCameraInternal);
        setUpRotationUpdates(surfaceRequestCreateSurfaceRequest, map);
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceRequestCreateSurfaceRequest);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    @NonNull
    private SurfaceEdge transformSingleOutput(@NonNull SurfaceEdge surfaceEdge, @NonNull OutConfig outConfig) {
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean mirroring = outConfig.getMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, mirroring));
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        return new SurfaceEdge(outConfig.getTargets(), outConfig.getFormat(), surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build(), matrix, false, TransformUtils.sizeToRect(outConfig.getSize()), surfaceEdge.getRotationDegrees() - rotationDegrees, -1, surfaceEdge.getMirroring() != mirroring);
    }

    @NonNull
    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable(this) { // from class: com.zj.adlib.gx8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SurfaceProcessorNode f42008a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void setUpRotationUpdates(@NonNull SurfaceRequest surfaceRequest, @NonNull final Map<OutConfig, SurfaceEdge> map) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new SurfaceRequest.TransformationInfoListener(map) { // from class: com.zj.adlib.ex8

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f41546a;

            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
            }
        });
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    @MainThread
    public Out transform(@NonNull In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig outConfig : in.getOutConfigs()) {
            this.mOutput.put(outConfig, transformSingleOutput(surfaceEdge, outConfig));
        }
        sendSurfaceRequest(surfaceEdge, this.mOutput);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        return this.mOutput;
    }

    @AutoValue
    public static abstract class OutConfig {
        @NonNull
        public static OutConfig of(@NonNull SurfaceEdge surfaceEdge) {
            return of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.getMirroring());
        }

        @NonNull
        public abstract Rect getCropRect();

        public abstract int getFormat();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        @NonNull
        public abstract Size getSize();

        public abstract int getTargets();

        @NonNull
        public abstract UUID getUuid();

        @NonNull
        public static OutConfig of(int i, int i2, @NonNull Rect rect, @NonNull Size size, int i3, boolean z) {
            return new AutoValue_SurfaceProcessorNode_OutConfig(UUID.randomUUID(), i, i2, rect, size, i3, z);
        }
    }
}
