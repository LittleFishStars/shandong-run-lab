package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class SessionConfigurationCompat {
    public static final int SESSION_HIGH_SPEED = 1;
    public static final int SESSION_REGULAR = 0;
    private final SessionConfigurationCompatImpl mImpl;

    @RequiresApi(21)
    public static final class SessionConfigurationCompatBaseImpl implements SessionConfigurationCompatImpl {
        private final Executor mExecutor;
        private final List<OutputConfigurationCompat> mOutputConfigurations;
        private final int mSessionType;
        private final CameraCaptureSession.StateCallback mStateCallback;
        private InputConfigurationCompat mInputConfig = null;
        private CaptureRequest mSessionParameters = null;

        public SessionConfigurationCompatBaseImpl(int i, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.mSessionType = i;
            this.mOutputConfigurations = Collections.unmodifiableList(new ArrayList(list));
            this.mStateCallback = stateCallback;
            this.mExecutor = executor;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SessionConfigurationCompatBaseImpl) {
                SessionConfigurationCompatBaseImpl sessionConfigurationCompatBaseImpl = (SessionConfigurationCompatBaseImpl) obj;
                if (Objects.equals(this.mInputConfig, sessionConfigurationCompatBaseImpl.mInputConfig) && this.mSessionType == sessionConfigurationCompatBaseImpl.mSessionType && this.mOutputConfigurations.size() == sessionConfigurationCompatBaseImpl.mOutputConfigurations.size()) {
                    for (int i = 0; i < this.mOutputConfigurations.size(); i++) {
                        if (!this.mOutputConfigurations.get(i).equals(sessionConfigurationCompatBaseImpl.mOutputConfigurations.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public Executor getExecutor() {
            return this.mExecutor;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @Nullable
        public InputConfigurationCompat getInputConfiguration() {
            return this.mInputConfig;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @Nullable
        public Object getSessionConfiguration() {
            return null;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mSessionParameters;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mSessionType;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mStateCallback;
        }

        public int hashCode() {
            int iHashCode = this.mOutputConfigurations.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            InputConfigurationCompat inputConfigurationCompat = this.mInputConfig;
            int iHashCode2 = (inputConfigurationCompat == null ? 0 : inputConfigurationCompat.hashCode()) ^ i;
            return this.mSessionType ^ ((iHashCode2 << 5) - iHashCode2);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(@NonNull InputConfigurationCompat inputConfigurationCompat) {
            if (this.mSessionType == 1) {
                throw new UnsupportedOperationException("Method not supported for high speed session types");
            }
            this.mInputConfig = inputConfigurationCompat;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(@NonNull CaptureRequest captureRequest) {
            this.mSessionParameters = captureRequest;
        }
    }

    public interface SessionConfigurationCompatImpl {
        @NonNull
        Executor getExecutor();

        @Nullable
        InputConfigurationCompat getInputConfiguration();

        @NonNull
        List<OutputConfigurationCompat> getOutputConfigurations();

        @Nullable
        Object getSessionConfiguration();

        @Nullable
        CaptureRequest getSessionParameters();

        int getSessionType();

        @NonNull
        CameraCaptureSession.StateCallback getStateCallback();

        void setInputConfiguration(@NonNull InputConfigurationCompat inputConfigurationCompat);

        void setSessionParameters(@NonNull CaptureRequest captureRequest);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SessionMode {
    }

    public SessionConfigurationCompat(int i, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.mImpl = new SessionConfigurationCompatBaseImpl(i, list, executor, stateCallback);
        } else {
            this.mImpl = new SessionConfigurationCompatApi28Impl(i, list, executor, stateCallback);
        }
    }

    @NonNull
    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static List<OutputConfiguration> transformFromCompat(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<OutputConfigurationCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) it.next().unwrap());
        }
        return arrayList;
    }

    @RequiresApi(24)
    public static List<OutputConfigurationCompat> transformToCompat(@NonNull List<OutputConfiguration> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<OutputConfiguration> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(OutputConfigurationCompat.wrap(it.next()));
        }
        return arrayList;
    }

    @Nullable
    public static SessionConfigurationCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 28) {
            return new SessionConfigurationCompat(new SessionConfigurationCompatApi28Impl(obj));
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SessionConfigurationCompat) {
            return this.mImpl.equals(((SessionConfigurationCompat) obj).mImpl);
        }
        return false;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    @Nullable
    public InputConfigurationCompat getInputConfiguration() {
        return this.mImpl.getInputConfiguration();
    }

    @NonNull
    public List<OutputConfigurationCompat> getOutputConfigurations() {
        return this.mImpl.getOutputConfigurations();
    }

    @Nullable
    public CaptureRequest getSessionParameters() {
        return this.mImpl.getSessionParameters();
    }

    public int getSessionType() {
        return this.mImpl.getSessionType();
    }

    @NonNull
    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mImpl.getStateCallback();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public void setInputConfiguration(@NonNull InputConfigurationCompat inputConfigurationCompat) {
        this.mImpl.setInputConfiguration(inputConfigurationCompat);
    }

    public void setSessionParameters(@NonNull CaptureRequest captureRequest) {
        this.mImpl.setSessionParameters(captureRequest);
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getSessionConfiguration();
    }

    @RequiresApi(28)
    public static final class SessionConfigurationCompatApi28Impl implements SessionConfigurationCompatImpl {
        private final SessionConfiguration mObject;
        private final List<OutputConfigurationCompat> mOutputConfigurations;

        public SessionConfigurationCompatApi28Impl(@NonNull Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.mObject = sessionConfiguration;
            this.mOutputConfigurations = Collections.unmodifiableList(SessionConfigurationCompat.transformToCompat(sessionConfiguration.getOutputConfigurations()));
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof SessionConfigurationCompatApi28Impl) {
                return Objects.equals(this.mObject, ((SessionConfigurationCompatApi28Impl) obj).mObject);
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public Executor getExecutor() {
            return this.mObject.getExecutor();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat getInputConfiguration() {
            return InputConfigurationCompat.wrap(this.mObject.getInputConfiguration());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public List<OutputConfigurationCompat> getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @Nullable
        public Object getSessionConfiguration() {
            return this.mObject;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public CaptureRequest getSessionParameters() {
            return this.mObject.getSessionParameters();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int getSessionType() {
            return this.mObject.getSessionType();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public CameraCaptureSession.StateCallback getStateCallback() {
            return this.mObject.getStateCallback();
        }

        public int hashCode() {
            return this.mObject.hashCode();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setInputConfiguration(@NonNull InputConfigurationCompat inputConfigurationCompat) {
            this.mObject.setInputConfiguration((InputConfiguration) inputConfigurationCompat.unwrap());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void setSessionParameters(@NonNull CaptureRequest captureRequest) {
            this.mObject.setSessionParameters(captureRequest);
        }

        public SessionConfigurationCompatApi28Impl(int i, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i, SessionConfigurationCompat.transformFromCompat(list), executor, stateCallback));
        }
    }

    private SessionConfigurationCompat(@NonNull SessionConfigurationCompatImpl sessionConfigurationCompatImpl) {
        this.mImpl = sessionConfigurationCompatImpl;
    }
}
