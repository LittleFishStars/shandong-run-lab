package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.col.p0003l.it;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.zj.adlib.c49;
import com.zj.adlib.ywa;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class TileProviderInner {

    @JBindingExclude
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;

    @JBindingInclude
    private List<TileOverlaySource> mTileSource;

    @JBindingExclude
    private String overlayName;

    @JBindingExclude
    private final HashMap<String, it> reqTaskHandleHashMap = new HashMap<>();

    @JBindingExclude
    private final TileProvider tileProvider;

    @JBindingExclude
    public TileProviderInner(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    @JBindingExclude
    private Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @JBindingExclude
    private String createKey(int i, int i2, int i3, long j) {
        return i + " " + i2 + " " + i3 + c49.f40900a + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(Tile tile, TileReqTaskHandle tileReqTaskHandle, String str) {
        boolean z;
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(str)) {
                if (this.reqTaskHandleHashMap.containsKey(str)) {
                    this.reqTaskHandleHashMap.remove(str);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    tileReqTaskHandle.finish(tile);
                    callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                }
            }
        }
    }

    @JBindingInclude
    public void cancelTile(TileSourceReq tileSourceReq, TileReqTaskHandle tileReqTaskHandle) {
        String strCreateKey = createKey(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(strCreateKey)) {
                it itVar = this.reqTaskHandleHashMap.get(strCreateKey);
                if (itVar != null) {
                    ywa.a();
                    ywa.d(itVar);
                }
                tileReqTaskHandle.status = 1;
                finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, strCreateKey);
                try {
                    TileProvider tileProvider = this.tileProvider;
                    if (tileProvider instanceof TileSourceProvider) {
                        ((TileSourceProvider) tileProvider).cancel(tileSourceReq);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @JBindingInclude
    public void getTile(final TileSourceReq tileSourceReq, final TileReqTaskHandle tileReqTaskHandle) {
        final String strCreateKey = createKey(tileSourceReq.x, tileSourceReq.y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        it itVar = new it() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.1
            @Override // com.amap.api.col.p0003l.it
            public void runTask() {
                try {
                    synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(strCreateKey)) {
                            if (TileProviderInner.this.tileProvider != null) {
                                Tile tile = TileProvider.NO_TILE;
                                try {
                                    if (TileProviderInner.this.tileProvider instanceof TileSourceProvider) {
                                        tile = ((TileSourceProvider) TileProviderInner.this.tileProvider).getTile(tileSourceReq);
                                    } else {
                                        TileProvider tileProvider = TileProviderInner.this.tileProvider;
                                        TileSourceReq tileSourceReq2 = tileSourceReq;
                                        tile = tileProvider.getTile(tileSourceReq2.x, tileSourceReq2.y, tileSourceReq2.zoom);
                                    }
                                } catch (Throwable unused) {
                                }
                                TileProviderInner.this.finishDownload(tile, tileReqTaskHandle, strCreateKey);
                            }
                        }
                    }
                } catch (Throwable th) {
                    TileProviderInner.this.finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, strCreateKey);
                    th.printStackTrace();
                }
            }
        };
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(strCreateKey)) {
                return;
            }
            this.reqTaskHandleHashMap.put(strCreateKey, itVar);
            ywa.a().b(itVar);
        }
    }

    @JBindingInclude
    public int getTileHeight() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @JBindingInclude
    public int getTileWidth() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @JBindingExclude
    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
