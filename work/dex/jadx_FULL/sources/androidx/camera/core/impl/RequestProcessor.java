package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface RequestProcessor {

    public interface Callback {
        default void onCaptureBufferLost(@NonNull Request request, long j, int i) {
        }

        default void onCaptureCompleted(@NonNull Request request, @NonNull CameraCaptureResult cameraCaptureResult) {
        }

        default void onCaptureFailed(@NonNull Request request, @NonNull CameraCaptureFailure cameraCaptureFailure) {
        }

        default void onCaptureProgressed(@NonNull Request request, @NonNull CameraCaptureResult cameraCaptureResult) {
        }

        default void onCaptureSequenceAborted(int i) {
        }

        default void onCaptureSequenceCompleted(int i, long j) {
        }

        default void onCaptureStarted(@NonNull Request request, long j, long j2) {
        }
    }

    public interface Request {
        @NonNull
        Config getParameters();

        @NonNull
        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(@NonNull Request request, @NonNull Callback callback);

    void stopRepeating();

    int submit(@NonNull Request request, @NonNull Callback callback);

    int submit(@NonNull List<Request> list, @NonNull Callback callback);
}
