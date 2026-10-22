package com.zj.adlib;

import com.amap.api.col.p0003l.df;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pva implements TileProvider {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MapConfig f18943a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44069a = 256;
    public final int b = 256;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18944a = false;

    public class a extends df {
        public int K;
        public int L;
        public int M;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Random f18945a = new Random();
        public String f;
        public String k;

        public a(int i, int i2, int i3, String str) {
            this.k = "";
            this.K = i;
            this.L = i2;
            this.M = i3;
            this.f = str;
            this.k = c();
        }

        public final String c() {
            if (swa.b(this.K, this.L, this.M) || this.M < 6) {
                return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f18945a.nextInt(100000) % 4) + 1));
            }
            if (MapsInitializer.isLoadWorldGridMap()) {
                return "http://restsdk.amap.com/v4/gridmap?";
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(j4b.j(gia.f41914a));
            stringBuffer.append("&channel=amapapi");
            if (swa.b(this.K, this.L, this.M) || this.M < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.M);
                stringBuffer.append("&x=");
                stringBuffer.append(this.K);
                stringBuffer.append("&y=");
                stringBuffer.append(this.L);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.K);
                stringBuffer.append("&y=");
                stringBuffer.append(this.L);
                stringBuffer.append("&z=");
                stringBuffer.append(this.M);
                stringBuffer.append("&ds=0");
                stringBuffer.append("&dpitype=webrd");
                stringBuffer.append("&lang=");
                stringBuffer.append(this.f);
                stringBuffer.append("&scale=2");
            }
            return this.k + df.a(stringBuffer.toString());
        }
    }

    public pva(MapConfig mapConfig) {
        this.f18943a = mapConfig;
    }

    public final byte[] a(int i, int i2, int i3, String str) throws IOException {
        try {
            return new a(i, i2, i3, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            if (!this.f18944a) {
                if (this.f18943a.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return TileProvider.NO_TILE;
                    }
                    if (i3 < 6 || swa.b(i, i2, i3)) {
                        return TileProvider.NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i3 >= 6 && !swa.b(i, i2, i3)) {
                    return TileProvider.NO_TILE;
                }
            }
            MapConfig mapConfig = this.f18943a;
            byte[] bArrA = a(i, i2, i3, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            return bArrA == null ? TileProvider.NO_TILE : Tile.obtain(this.f44069a, this.b, bArrA);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f44069a;
    }
}
