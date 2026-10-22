package com.google.android.exoplayer2.drm;

import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaDrmCallback {
    byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, ExoMediaDrm.c cVar) throws MediaDrmCallbackException;
}
