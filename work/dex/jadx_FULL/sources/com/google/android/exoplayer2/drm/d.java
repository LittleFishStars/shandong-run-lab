package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.at6;
import com.zj.adlib.gj9;
import com.zj.adlib.gm3;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.wl1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(18)
public final class d implements ExoMediaDrm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExoMediaDrm.Provider f30607a = new ExoMediaDrm.Provider() { // from class: com.zj.adlib.om3
        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
        public final ExoMediaDrm a(UUID uuid) {
            return d.u(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2678a = "FrameworkMediaDrm";
    public static final String b = "cenc";
    public static final String c = "https://x";
    public static final String d = "<LA_URL>https://x</LA_URL>";
    public static final int h = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaDrm f2679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final UUID f2680a;
    public int g;

    @RequiresApi(31)
    public static class a {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        @DoNotInline
        public static void b(MediaDrm mediaDrm, byte[] bArr, at6 at6Var) {
            LogSessionId logSessionIdA = at6Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            ((MediaDrm.PlaybackComponent) sb0.g(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    public d(UUID uuid) throws UnsupportedSchemeException {
        sb0.g(uuid);
        sb0.b(!C.f1999b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2680a = uuid;
        MediaDrm mediaDrm = new MediaDrm(m(uuid));
        this.f2679a = mediaDrm;
        this.g = 1;
        if (C.f2005d.equals(uuid) && v()) {
            o(mediaDrm);
        }
    }

    public static byte[] i(byte[] bArr) {
        om6 om6Var = new om6(bArr);
        int iR = om6Var.r();
        short sU = om6Var.u();
        short sU2 = om6Var.u();
        if (sU != 1 || sU2 != 1) {
            Log.h(f2678a, "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sU3 = om6Var.u();
        Charset charset = com.google.common.base.b.e;
        String strE = om6Var.E(sU3, charset);
        if (strE.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strE.indexOf("</DATA>");
        if (iIndexOf == -1) {
            Log.n(f2678a, "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strE.substring(0, iIndexOf) + d + strE.substring(iIndexOf);
        int i = iR + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putShort(sU);
        byteBufferAllocate.putShort(sU2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static byte[] j(UUID uuid, byte[] bArr) {
        return C.f2002c.equals(uuid) ? wl1.a(bArr) : bArr;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e A[RETURN] */
    public static byte[] k(UUID uuid, byte[] bArr) {
        byte[] bArrE;
        UUID uuid2 = C.f2008e;
        if (uuid2.equals(uuid)) {
            byte[] bArrE2 = com.google.android.exoplayer2.extractor.mp4.c.e(bArr, uuid);
            if (bArrE2 != null) {
                bArr = bArrE2;
            }
            bArr = com.google.android.exoplayer2.extractor.mp4.c.a(uuid2, i(bArr));
        }
        if (gj9.f41922a < 23 && C.f2005d.equals(uuid)) {
            bArrE = com.google.android.exoplayer2.extractor.mp4.c.e(bArr, uuid);
            if (bArrE != null) {
                return bArrE;
            }
        } else if (uuid2.equals(uuid) && "Amazon".equals(gj9.b)) {
            String str = gj9.c;
            if ("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) {
                bArrE = com.google.android.exoplayer2.extractor.mp4.c.e(bArr, uuid);
                if (bArrE != null) {
                    return bArrE;
                }
            }
        }
        return bArr;
    }

    public static String l(UUID uuid, String str) {
        return (gj9.f41922a < 26 && C.f2002c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    public static UUID m(UUID uuid) {
        return (gj9.f41922a >= 27 || !C.f2002c.equals(uuid)) ? uuid : C.f1999b;
    }

    public static void o(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData p(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z;
        if (!C.f2005d.equals(uuid)) {
            return list.get(0);
        }
        if (gj9.f41922a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i = 0;
            int length = 0;
            while (true) {
                if (i >= list.size()) {
                    z = true;
                    break;
                }
                DrmInitData.SchemeData schemeData2 = list.get(i);
                byte[] bArr = (byte[]) sb0.g(schemeData2.data);
                if (!gj9.c(schemeData2.mimeType, schemeData.mimeType) || !gj9.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !com.google.android.exoplayer2.extractor.mp4.c.c(bArr)) {
                    z = false;
                    break;
                }
                length += bArr.length;
                i++;
            }
            if (z) {
                byte[] bArr2 = new byte[length];
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    byte[] bArr3 = (byte[]) sb0.g(list.get(i3).data);
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i2, length2);
                    i2 += length2;
                }
                return schemeData.copyWithData(bArr2);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            DrmInitData.SchemeData schemeData3 = list.get(i4);
            int iG = com.google.android.exoplayer2.extractor.mp4.c.g((byte[]) sb0.g(schemeData3.data));
            int i5 = gj9.f41922a;
            if (i5 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i5 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    public static boolean q(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(m(uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        onEventListener.a(this, bArr, i, i2, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, MediaDrm mediaDrm, byte[] bArr, long j) {
        onExpirationUpdateListener.a(this, bArr, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it.next();
            arrayList.add(new ExoMediaDrm.b(keyStatus.getStatusCode(), keyStatus.getKeyId()));
        }
        onKeyStatusChangeListener.a(this, bArr, arrayList, z);
    }

    public static /* synthetic */ ExoMediaDrm u(UUID uuid) {
        try {
            return w(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.d(f2678a, "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + Consts.DOT);
            return new b();
        }
    }

    public static boolean v() {
        return "ASUS_Z00AD".equals(gj9.c);
    }

    public static d w(UUID uuid) throws UnsupportedDrmException {
        try {
            return new d(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void acquire() {
        sb0.i(this.g > 0);
        this.g++;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.c b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f2679a.getProvisionRequest();
        return new ExoMediaDrm.c(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @SuppressLint({"WrongConstant"})
    public ExoMediaDrm.KeyRequest c(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataP;
        byte[] bArrK;
        String strL;
        if (list != null) {
            schemeDataP = p(this.f2680a, list);
            bArrK = k(this.f2680a, (byte[]) sb0.g(schemeDataP.data));
            strL = l(this.f2680a, schemeDataP.mimeType);
        } else {
            schemeDataP = null;
            bArrK = null;
            strL = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f2679a.getKeyRequest(bArr, bArrK, strL, i, map);
        byte[] bArrJ = j(this.f2680a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if (c.equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeDataP != null && !TextUtils.isEmpty(schemeDataP.licenseServerUrl)) {
            defaultUrl = schemeDataP.licenseServerUrl;
        }
        return new ExoMediaDrm.KeyRequest(bArrJ, defaultUrl, gj9.f41922a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.f2679a.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void d(byte[] bArr, at6 at6Var) {
        if (gj9.f41922a >= 31) {
            try {
                a.b(this.f2679a, bArr, at6Var);
            } catch (UnsupportedOperationException unused) {
                Log.n(f2678a, "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public int getCryptoType() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public PersistableBundle getMetrics() {
        if (gj9.f41922a < 28) {
            return null;
        }
        return this.f2679a.getMetrics();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        return this.f2679a.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        return this.f2679a.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public gm3 a(byte[] bArr) throws MediaCryptoException {
        return new gm3(m(this.f2680a), bArr, gj9.f41922a < 21 && C.f2005d.equals(this.f2680a) && "L3".equals(getPropertyString("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        return this.f2679a.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (C.f2002c.equals(this.f2680a)) {
            bArr2 = wl1.b(bArr2);
        }
        return this.f2679a.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.f2679a.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f2679a.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void release() {
        int i = this.g - 1;
        this.g = i;
        if (i == 0) {
            this.f2679a.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        if (gj9.f41922a >= 31) {
            return a.a(this.f2679a, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f2680a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f2679a.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@Nullable final ExoMediaDrm.OnEventListener onEventListener) {
        this.f2679a.setOnEventListener(onEventListener == null ? null : new MediaDrm.OnEventListener() { // from class: com.zj.adlib.mm3
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                this.f18256a.r(onEventListener, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnExpirationUpdateListener(@Nullable final ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        if (gj9.f41922a < 23) {
            throw new UnsupportedOperationException();
        }
        this.f2679a.setOnExpirationUpdateListener(onExpirationUpdateListener == null ? null : new MediaDrm.OnExpirationUpdateListener() { // from class: com.zj.adlib.km3
            @Override // android.media.MediaDrm.OnExpirationUpdateListener
            public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
                this.f17748a.s(onExpirationUpdateListener, mediaDrm, bArr, j);
            }
        }, (Handler) null);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnKeyStatusChangeListener(@Nullable final ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        if (gj9.f41922a < 23) {
            throw new UnsupportedOperationException();
        }
        this.f2679a.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new MediaDrm.OnKeyStatusChangeListener() { // from class: com.zj.adlib.pm3
            @Override // android.media.MediaDrm.OnKeyStatusChangeListener
            public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
                this.f18889a.t(onKeyStatusChangeListener, mediaDrm, bArr, list, z);
            }
        }, (Handler) null);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
        this.f2679a.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
        this.f2679a.setPropertyString(str, str2);
    }
}
