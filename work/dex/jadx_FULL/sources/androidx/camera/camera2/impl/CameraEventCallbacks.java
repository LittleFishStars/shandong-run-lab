package androidx.camera.camera2.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {

    public static final class ComboCameraEventCallback {
        private final List<CameraEventCallback> mCallbacks = new ArrayList();

        public ComboCameraEventCallback(List<CameraEventCallback> list) {
            Iterator<CameraEventCallback> it = list.iterator();
            while (it.hasNext()) {
                this.mCallbacks.add(it.next());
            }
        }

        @NonNull
        public List<CameraEventCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public void onDeInitSession() {
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onDeInitSession();
            }
        }

        @NonNull
        public List<CaptureConfig> onDisableSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnDisableSession = it.next().onDisableSession();
                if (captureConfigOnDisableSession != null) {
                    arrayList.add(captureConfigOnDisableSession);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> onEnableSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnEnableSession = it.next().onEnableSession();
                if (captureConfigOnEnableSession != null) {
                    arrayList.add(captureConfigOnEnableSession);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> onInitSession() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnInitSession = it.next().onInitSession();
                if (captureConfigOnInitSession != null) {
                    arrayList.add(captureConfigOnInitSession);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<CaptureConfig> onRepeating() {
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig captureConfigOnRepeating = it.next().onRepeating();
                if (captureConfigOnRepeating != null) {
                    arrayList.add(captureConfigOnRepeating);
                }
            }
            return arrayList;
        }
    }

    public CameraEventCallbacks(@NonNull CameraEventCallback... cameraEventCallbackArr) {
        addAll(Arrays.asList(cameraEventCallbackArr));
    }

    @NonNull
    public static CameraEventCallbacks createEmptyCallback() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    @NonNull
    public ComboCameraEventCallback createComboCallback() {
        return new ComboCameraEventCallback(getAllItems());
    }

    @Override // androidx.camera.core.impl.MultiValueSet
    @NonNull
    /* JADX INFO: renamed from: clone */
    public MultiValueSet<CameraEventCallback> mo14clone() {
        CameraEventCallbacks cameraEventCallbacksCreateEmptyCallback = createEmptyCallback();
        cameraEventCallbacksCreateEmptyCallback.addAll(getAllItems());
        return cameraEventCallbacksCreateEmptyCallback;
    }
}
