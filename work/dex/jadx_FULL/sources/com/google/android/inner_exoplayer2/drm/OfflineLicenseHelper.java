package com.google.android.inner_exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.analytics.PlayerId;
import com.google.android.inner_exoplayer2.source.MediaSource;
import com.google.android.inner_exoplayer2.upstream.DataSource;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.common.util.concurrent.o;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RequiresApi(18)
public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();
    private final ConditionVariable drmListenerConditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener.EventDispatcher eventDispatcher;
    private final Handler handler;
    private final HandlerThread handlerThread;

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher);
    }

    private DrmSession acquireFirstSessionOnHandlerThread(final int i, @Nullable final byte[] bArr, final Format format) {
        Assertions.checkNotNull(format.drmInitData);
        final o oVarA = o.A();
        this.drmListenerConditionVariable.close();
        this.handler.post(new Runnable() { // from class: com.zj.adlib.y76
            @Override // java.lang.Runnable
            public final void run() {
                this.f20809a.lambda$acquireFirstSessionOnHandlerThread$2(i, bArr, oVarA, format);
            }
        });
        try {
            final DrmSession drmSession = (DrmSession) oVarA.get();
            this.drmListenerConditionVariable.block();
            final o oVarA2 = o.A();
            this.handler.post(new Runnable() { // from class: com.zj.adlib.z76
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20998a.lambda$acquireFirstSessionOnHandlerThread$3(drmSession, oVarA2);
                }
            });
            try {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) oVarA2.get();
                if (drmSessionException == null) {
                    return drmSession;
                }
                throw drmSessionException;
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        } catch (InterruptedException | ExecutionException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private byte[] acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(int i, @Nullable byte[] bArr, Format format) {
        final DrmSession drmSessionAcquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(i, bArr, format);
        final o oVarA = o.A();
        this.handler.post(new Runnable() { // from class: com.zj.adlib.x76
            @Override // java.lang.Runnable
            public final void run() {
                this.f20613a.lambda$acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread$1(oVarA, drmSessionAcquireFirstSessionOnHandlerThread);
            }
        });
        try {
            try {
                byte[] bArr2 = (byte[]) Assertions.checkNotNull((byte[]) oVarA.get());
                releaseManagerOnHandlerThread();
                return bArr2;
            } catch (Throwable th) {
                releaseManagerOnHandlerThread();
                throw th;
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireFirstSessionOnHandlerThread$2(int i, byte[] bArr, o oVar, Format format) {
        try {
            this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), PlayerId.UNSET);
            this.drmSessionManager.prepare();
            try {
                this.drmSessionManager.setMode(i, bArr);
                oVar.set((DrmSession) Assertions.checkNotNull(this.drmSessionManager.acquireSession(this.eventDispatcher, format)));
            } catch (Throwable th) {
                this.drmSessionManager.release();
                throw th;
            }
        } catch (Throwable th2) {
            oVar.setException(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireFirstSessionOnHandlerThread$3(DrmSession drmSession, o oVar) {
        try {
            DrmSession.DrmSessionException error = drmSession.getError();
            if (drmSession.getState() == 1) {
                drmSession.release(this.eventDispatcher);
                this.drmSessionManager.release();
            }
            oVar.set(error);
        } catch (Throwable th) {
            oVar.setException(th);
            drmSession.release(this.eventDispatcher);
            this.drmSessionManager.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread$1(o oVar, DrmSession drmSession) {
        try {
            oVar.set(drmSession.getOfflineLicenseKeySetId());
        } catch (Throwable th) {
            try {
                oVar.setException(th);
            } finally {
                drmSession.release(this.eventDispatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLicenseDurationRemainingSec$0(o oVar, DrmSession drmSession) {
        try {
            oVar.set((Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(drmSession)));
        } catch (Throwable th) {
            try {
                oVar.setException(th);
            } finally {
                drmSession.release(this.eventDispatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseManagerOnHandlerThread$4(o oVar) {
        try {
            this.drmSessionManager.release();
            oVar.set(null);
        } catch (Throwable th) {
            oVar.setException(th);
        }
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, false, factory, eventDispatcher);
    }

    private void releaseManagerOnHandlerThread() {
        final o oVarA = o.A();
        this.handler.post(new Runnable() { // from class: com.zj.adlib.w76
            @Override // java.lang.Runnable
            public final void run() {
                this.f45537a.lambda$releaseManagerOnHandlerThread$4(oVarA);
            }
        });
        try {
            oVarA.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    public synchronized byte[] downloadLicense(Format format) {
        Assertions.checkArgument(format.drmInitData != null);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, null, format);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) {
        Pair<Long, Long> pair;
        Assertions.checkNotNull(bArr);
        try {
            final DrmSession drmSessionAcquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(1, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
            final o oVarA = o.A();
            this.handler.post(new Runnable() { // from class: com.zj.adlib.a86
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15177a.lambda$getLicenseDurationRemainingSec$0(oVarA, drmSessionAcquireFirstSessionOnHandlerThread);
                }
            });
            try {
                try {
                    pair = (Pair) oVarA.get();
                    releaseManagerOnHandlerThread();
                } catch (Throwable th) {
                    releaseManagerOnHandlerThread();
                    throw th;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        } catch (DrmSession.DrmSessionException e2) {
            if (e2.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw e2;
        }
        return pair;
    }

    public void release() {
        this.handlerThread.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) {
        Assertions.checkNotNull(bArr);
        acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(3, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized byte[] renewLicense(byte[] bArr) {
        Assertions.checkNotNull(bArr);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return newWidevineInstance(str, z, factory, null, eventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, DataSource.Factory factory, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z, factory)), eventDispatcher);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = eventDispatcher;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
        this.drmListenerConditionVariable = new ConditionVariable();
        eventDispatcher.addEventListener(new Handler(handlerThread.getLooper()), new DrmSessionEventListener() { // from class: com.google.android.inner_exoplayer2.drm.OfflineLicenseHelper.1
            @Override // com.google.android.inner_exoplayer2.drm.DrmSessionEventListener
            public void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override // com.google.android.inner_exoplayer2.drm.DrmSessionEventListener
            public void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override // com.google.android.inner_exoplayer2.drm.DrmSessionEventListener
            public void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            @Override // com.google.android.inner_exoplayer2.drm.DrmSessionEventListener
            public void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }
        });
    }
}
