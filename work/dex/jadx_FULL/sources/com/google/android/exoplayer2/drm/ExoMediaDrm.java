package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.zj.adlib.at6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ExoMediaDrm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30600a = 2;
    public static final int b = 3;
    public static final int c = 1;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;

    public static final class KeyRequest {
        public static final int b = Integer.MIN_VALUE;
        public static final int c = 0;
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        public static final int g = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30601a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2670a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2671a;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RequestType {
        }

        public KeyRequest(byte[] bArr, String str) {
            this(bArr, str, Integer.MIN_VALUE);
        }

        public byte[] a() {
            return this.f2671a;
        }

        public String b() {
            return this.f2670a;
        }

        public int c() {
            return this.f30601a;
        }

        public KeyRequest(byte[] bArr, String str, int i) {
            this.f2671a = bArr;
            this.f2670a = str;
            this.f30601a = i;
        }
    }

    public interface OnEventListener {
        void a(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2);
    }

    public interface OnExpirationUpdateListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, long j);
    }

    public interface OnKeyStatusChangeListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, List<b> list, boolean z);
    }

    public interface Provider {
        ExoMediaDrm a(UUID uuid);
    }

    public static final class a implements Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExoMediaDrm f30602a;

        public a(ExoMediaDrm exoMediaDrm) {
            this.f30602a = exoMediaDrm;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
        public ExoMediaDrm a(UUID uuid) {
            this.f30602a.acquire();
            return this.f30602a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30603a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2672a;

        public b(int i, byte[] bArr) {
            this.f30603a = i;
            this.f2672a = bArr;
        }

        public byte[] a() {
            return this.f2672a;
        }

        public int b() {
            return this.f30603a;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30604a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2673a;

        public c(byte[] bArr, String str) {
            this.f2673a = bArr;
            this.f30604a = str;
        }

        public byte[] a() {
            return this.f2673a;
        }

        public String b() {
            return this.f30604a;
        }
    }

    CryptoConfig a(byte[] bArr) throws MediaCryptoException;

    void acquire();

    c b();

    KeyRequest c(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    void closeSession(byte[] bArr);

    default void d(byte[] bArr, at6 at6Var) {
    }

    int getCryptoType();

    @Nullable
    PersistableBundle getMetrics();

    byte[] getPropertyByteArray(String str);

    String getPropertyString(String str);

    byte[] openSession() throws MediaDrmException;

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    boolean requiresSecureDecoder(byte[] bArr, String str);

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(@Nullable OnEventListener onEventListener);

    void setOnExpirationUpdateListener(@Nullable OnExpirationUpdateListener onExpirationUpdateListener);

    void setOnKeyStatusChangeListener(@Nullable OnKeyStatusChangeListener onKeyStatusChangeListener);

    void setPropertyByteArray(String str, byte[] bArr);

    void setPropertyString(String str, String str2);
}
