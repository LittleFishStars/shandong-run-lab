package com.autonavi.base.ae.gmap;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.TileOverlaySource;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.zj.adlib.via;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TerrainOverlayProvider {
    private static final int TERRAIN_OVERLAY_SOURCE_BASE_ID = 1;
    private static final int TERRAIN_OVERLAY_SOURCE_HIGH_ID = 0;
    private TileProviderInner tileProviderInner;

    public TerrainOverlayProvider(IGlOverlayLayer iGlOverlayLayer) {
        TileOverlaySource tileOverlaySource = new TileOverlaySource(0, TileOverlaySource.TILESOURCE_TYPE_IMAGE_DEM, "http://restsdk.amap.com/rest/lbs/dem/data?z=%d&x=%d&y=%d&type=2");
        tileOverlaySource.setMinZoom(3);
        tileOverlaySource.setMaxZoom(10);
        tileOverlaySource.setCacheEnabled(true);
        int i = TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE;
        TileOverlaySource tileOverlaySource2 = new TileOverlaySource(1, i, "http://mst01.is.autonavi.com/appmaptile?z=%d&x=%d&y=%d&lang=zh_cn&size=1&scale=1&style=6");
        tileOverlaySource2.setCacheEnabled(i != TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tileOverlaySource);
        arrayList.add(tileOverlaySource2);
        TileProviderInner tileProviderInner = new TileProviderInner(new via(tileOverlaySource, tileOverlaySource2));
        this.tileProviderInner = tileProviderInner;
        tileProviderInner.init(iGlOverlayLayer, "TerrainTileOverlay");
        this.tileProviderInner.setTileSource(arrayList);
    }

    public BitmapDescriptor getDefaultTerrain() {
        return BitmapDescriptorFactory.fromAsset("terrainDefault.png");
    }

    public List<BitmapDescriptor> getSkyBoxImages() {
        String[] strArr = {"map_custom/skybox/right.png", "map_custom/skybox/left.png", "map_custom/skybox/front.png", "map_custom/skybox/back.png", "map_custom/skybox/top.png", "map_custom/skybox/bottom.png"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(BitmapDescriptorFactory.fromAsset(strArr[i]));
        }
        return arrayList;
    }

    public TileProviderInner getTileProvider() {
        return this.tileProviderInner;
    }
}
