package com.zj.adlib;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class nsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TileOverlay f43602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IAMapDelegate f18504a;
    public TileOverlay b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18505a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18506b = false;

    public nsa(IAMapDelegate iAMapDelegate) {
        this.f18504a = iAMapDelegate;
    }

    public static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }

    public final void b() {
        if (this.f43602a == null) {
            TileOverlayOptions tileOverlayOptionsTileProvider = new TileOverlayOptions().tileProvider(new pva(this.f18504a.getMapConfig()));
            tileOverlayOptionsTileProvider.memCacheSize(CachedContentIndex.f31137a);
            tileOverlayOptionsTileProvider.diskCacheSize(20480);
            tileOverlayOptionsTileProvider.visible(this.f18505a);
            try {
                this.f43602a = this.f18504a.addTileOverlay(tileOverlayOptionsTileProvider);
                this.b = this.f18504a.addTileOverlay(tileOverlayOptionsTileProvider);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void c() {
        boolean zE = e();
        if (zE) {
            b();
        }
        if (this.f18505a != zE) {
            this.f18505a = zE;
            TileOverlay tileOverlay = this.f43602a;
            if (tileOverlay != null) {
                tileOverlay.setVisible(zE);
            }
        }
    }

    public final void d() {
        boolean zF = f();
        if (zF) {
            b();
        }
        if (this.f18506b != zF) {
            this.f18506b = zF;
            TileOverlay tileOverlay = this.b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(zF);
            }
        }
    }

    public final boolean e() {
        IAMapDelegate iAMapDelegate = this.f18504a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals(AMap.ENGLISH);
    }
}
