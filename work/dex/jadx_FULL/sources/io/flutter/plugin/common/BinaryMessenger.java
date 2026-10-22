package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface BinaryMessenger {

    public interface BinaryMessageHandler {
        @UiThread
        void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull BinaryReply binaryReply);
    }

    public interface BinaryReply {
        void reply(@Nullable ByteBuffer byteBuffer);
    }

    public interface TaskQueue {
    }

    public static class TaskQueueOptions {
        private boolean isSerial = true;

        public boolean getIsSerial() {
            return this.isSerial;
        }

        public TaskQueueOptions setIsSerial(boolean z) {
            this.isSerial = z;
            return this;
        }
    }

    default void disableBufferingIncomingMessages() {
        throw new UnsupportedOperationException("disableBufferingIncomingMessages not implemented.");
    }

    default void enableBufferingIncomingMessages() {
        throw new UnsupportedOperationException("enableBufferingIncomingMessages not implemented.");
    }

    @UiThread
    default TaskQueue makeBackgroundTaskQueue() {
        return makeBackgroundTaskQueue(new TaskQueueOptions());
    }

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer);

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryReply binaryReply);

    @UiThread
    void setMessageHandler(@NonNull String str, @Nullable BinaryMessageHandler binaryMessageHandler);

    @UiThread
    default void setMessageHandler(@NonNull String str, @Nullable BinaryMessageHandler binaryMessageHandler, @Nullable TaskQueue taskQueue) {
        if (taskQueue != null) {
            throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
        }
        setMessageHandler(str, binaryMessageHandler);
    }

    @UiThread
    default TaskQueue makeBackgroundTaskQueue(TaskQueueOptions taskQueueOptions) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }
}
