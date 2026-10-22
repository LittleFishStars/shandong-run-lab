package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.dva;
import com.zj.adlib.usa;
import com.zj.adlib.wsa;
import com.zj.adlib.xd9;
import com.zj.adlib.xwa;
import com.zj.adlib.zwa;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k implements cs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cs f936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomMapStyleOptions f938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f940a;
    public cs b;
    public boolean f;
    public boolean g;
    public boolean l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f941a = "__MACOSX";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f943a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f945b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f944a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f946b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public byte[] f947c = null;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public byte[] f948d = null;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public byte[] f949e = null;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public byte[] f950f = null;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public byte[] f951g = null;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public byte[] f952h = null;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public byte[] f953i = null;
    public boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<String, byte[]> f942a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MyTrafficStyle f939a = new MyTrafficStyle();

    public interface a {
        void a();
    }

    public k(IAMapDelegate iAMapDelegate, Context context, boolean z) {
        this.f25982a = -1;
        this.f = false;
        this.g = false;
        this.l = false;
        this.f940a = iAMapDelegate;
        this.f935a = context;
        this.f = false;
        this.g = false;
        this.l = z;
        this.f25982a = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    public static String j(String str) {
        int iIndexOf;
        return (str == null || (iIndexOf = str.indexOf("99999_")) == -1) ? str : str.substring(0, iIndexOf).replace("99999_", "");
    }

    public static boolean l(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            if (bArr.length < 8) {
                return false;
            }
            if (((bArr[4] & 255) | ((bArr[7] << com.google.common.base.a.B) & (-16777216)) | ((bArr[6] << com.google.common.base.a.r) & xd9.p) | ((bArr[5] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) != 2001) {
                return false;
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapCustomStyleManager", "checkData");
            zwa.D(th);
        }
        return true;
    }

    public static byte[] n(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        GLFileUtil.closeQuietly(byteArrayOutputStream);
                        GLFileUtil.closeQuietly(byteArrayInputStream);
                        GLFileUtil.closeQuietly(gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    zwa.D(th);
                    th.printStackTrace();
                    return null;
                } finally {
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    public final void a() {
        IAMapDelegate iAMapDelegate;
        if (this.f938a == null || this.g) {
            return;
        }
        try {
            MapConfig mapConfig = this.f940a.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.f940a) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.f940a.getUiSettings().isLogoEnable()) {
                        if (!this.f938a.isEnable()) {
                            this.f940a.getUiSettings().setLogoEnable(true);
                        } else if (this.i) {
                            this.f940a.getUiSettings().setLogoEnable(false);
                        }
                    } else if (!this.i) {
                        this.f940a.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.f943a) {
                    if (!this.f938a.isEnable()) {
                        this.f940a.getGLMapEngine().setNativeMapModeAndStyle(this.f25982a, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime());
                        this.i = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0) {
                                r();
                            }
                            s();
                            if (this.j) {
                                q();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.f943a = false;
                        return;
                    }
                    this.f940a.getGLMapEngine().setNativeMapModeAndStyle(this.f25982a, 0, 0);
                    mapConfig.setCustomStyleEnable(true);
                    this.f943a = false;
                }
                if (this.c) {
                    String styleTexturePath = this.f938a.getStyleTexturePath();
                    if (this.f938a.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.f938a.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.f938a.getStyleTextureData() != null) {
                        this.k = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.h = true;
                            this.f940a.getGLMapEngine().setCustomStyleTexture(this.f25982a, this.f938a.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            s();
                        }
                    } else {
                        s();
                        this.k = false;
                    }
                    this.c = false;
                }
                if (this.f945b) {
                    String styleDataPath = this.f938a.getStyleDataPath();
                    if (this.f938a.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.f938a.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.f938a.getStyleData() != null || this.f951g != null) {
                        if (this.f949e == null) {
                            this.f949e = n(FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                        }
                        byte[] styleData = this.f951g;
                        if (styleData == null) {
                            styleData = this.f938a.getStyleData();
                        }
                        if (l(styleData)) {
                            this.f940a.getGLMapEngine().setCustomStyleData(this.f25982a, styleData, this.f949e);
                            this.i = true;
                            IAMapDelegate iAMapDelegate2 = this.f940a;
                            if (iAMapDelegate2 != null) {
                                iAMapDelegate2.resetRenderTime();
                            }
                        } else {
                            dva.a();
                        }
                    } else if (this.i) {
                        this.f943a = true;
                        this.f938a.setEnable(false);
                    }
                    this.f945b = false;
                }
                if (this.d) {
                    String styleExtraPath = this.f938a.getStyleExtraPath();
                    if (this.f938a.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.f938a.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.f938a.getStyleExtraData() != null || this.f952h != null) {
                        byte[] styleExtraData = this.f952h;
                        if (styleExtraData == null) {
                            styleExtraData = this.f938a.getStyleExtraData();
                        }
                        if (styleExtraData != null) {
                            h(styleExtraData);
                            this.j = true;
                        }
                    }
                    this.d = false;
                }
                if (this.e) {
                    e(mapConfig);
                    this.e = false;
                }
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapCustomStyleManager", "updateStyle");
            zwa.D(th);
        }
    }

    @Override // com.amap.api.col.3l.cs.a
    public final void b(byte[] bArr, int i) {
        MapConfig mapConfig;
        a aVar;
        if (this.f938a != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f940a;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i == 1) {
                        this.f951g = bArr;
                        this.f945b = true;
                    } else if (i == 0) {
                        this.f952h = bArr;
                        this.d = true;
                    } else if (i == 2) {
                        String str = this.f938a.getStyleId() + "_sdk_780.data";
                        String str2 = this.f938a.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> mapUncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (mapUncompressToByteWithKeys != null) {
                            byte[] bArr2 = mapUncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.f951g = bArr2;
                                this.f945b = true;
                            }
                            if (mapUncompressToByteWithKeys.get(str2) != null && (aVar = this.f937a) != null) {
                                aVar.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(a aVar) {
        this.f937a = aVar;
    }

    public final void d(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f938a == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.f) {
                this.f = true;
                if (this.f938a.isEnable()) {
                    this.f943a = true;
                }
            }
            if (this.f938a.isEnable() != customMapStyleOptions.isEnable()) {
                this.f938a.setEnable(customMapStyleOptions.isEnable());
                this.f943a = true;
                xwa.m(this.f935a, customMapStyleOptions.isEnable());
            }
            if (this.f938a.isEnable()) {
                if (!TextUtils.equals(this.f938a.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.f938a.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.f938a.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f940a) != null && iAMapDelegate.getMapConfig() != null && this.f940a.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.f936a == null) {
                            if (this.l) {
                                this.f936a = new cs(this.f935a, this, 2, "abroad_sdk_json_sdk_780_zip");
                            } else {
                                this.f936a = new cs(this.f935a, this, 1, "sdk_780");
                            }
                        }
                        this.f936a.b(styleId);
                        this.f936a.b();
                        if (this.b == null) {
                            this.b = new cs(this.f935a, this, 0, null);
                        }
                        this.b.b(styleId);
                        this.b.b();
                    }
                }
                if (!TextUtils.equals(this.f938a.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.f938a.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.f945b = true;
                }
                if (this.f938a.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.f938a.setStyleData(customMapStyleOptions.getStyleData());
                    this.f945b = true;
                }
                if (!TextUtils.equals(this.f938a.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.f938a.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.c = true;
                }
                if (this.f938a.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.f938a.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.c = true;
                }
                if (!TextUtils.equals(this.f938a.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.f938a.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.d = true;
                }
                if (this.f938a.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.f938a.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.d = true;
                }
                if (!TextUtils.equals(this.f938a.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.f938a.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.e = true;
                }
                if (this.f938a.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.f938a.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.e = true;
                }
                xwa.j(this.f935a, true);
            } else {
                t();
                xwa.j(this.f935a, false);
            }
        }
    }

    public final void e(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.f942a.clear();
            return;
        }
        String styleResDataPath = this.f938a.getStyleResDataPath();
        if (this.f938a.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f938a.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f938a.getStyleResData() == null && this.f953i == null) {
            return;
        }
        byte[] styleResData = this.f953i;
        if (styleResData == null) {
            styleResData = this.f938a.getStyleResData();
        }
        if (styleResData != null) {
            mapConfig.setUseProFunction(true);
            this.f942a.clear();
            Map<String, byte[]> mapUncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(styleResData, null);
            if (mapUncompressToByteWithKeys != null) {
                for (String str : mapUncompressToByteWithKeys.keySet()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = mapUncompressToByteWithKeys.get(str)) != null) {
                        if (FileUtil.isGzip(bArr)) {
                            this.f942a.put(str, bArr);
                        } else {
                            this.f942a.put(str, FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    public final void f(String str, boolean z) {
        boolean z2;
        int iB = !TextUtils.isEmpty(str) ? wsa.b(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f940a;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.f947c == null) {
            this.f947c = FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
        }
        byte[] bArr = this.f947c;
        if (bArr != null) {
            if (z) {
                if (iB == Integer.MIN_VALUE) {
                    z2 = true;
                }
                this.f940a.getGLMapEngine().setBackgroundTexture(this.f25982a, zwa.T((byte[]) bArr.clone(), 0, iB, z2));
            }
            iB = 0;
            z2 = false;
            this.f940a.getGLMapEngine().setBackgroundTexture(this.f25982a, zwa.T((byte[]) bArr.clone(), 0, iB, z2));
        }
    }

    public final void g(JSONObject jSONObject) {
        this.f940a.getGLMapEngine().setCustomThirdLayerStyle(this.f25982a, jSONObject.toString());
    }

    public final void h(byte[] bArr) {
        usa usaVarD;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (bArr == null || (usaVarD = wsa.d(bArr)) == null || usaVarD.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(usaVarD.a());
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String strOptString = null;
            boolean zOptBoolean = true;
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("bg")) != null) {
                zOptBoolean = jSONObjectOptJSONObject2.optBoolean("visible", true);
                strOptString = jSONObjectOptJSONObject2.optString("lineColor", null);
            }
            f(strOptString, zOptBoolean);
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("layer");
            if (jSONObjectOptJSONObject4 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("traffic")) != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("multiFillColors");
                if (jSONObjectOptJSONObject.optBoolean("visible") && jSONObjectOptJSONObject5 != null) {
                    int iB = wsa.b(jSONObjectOptJSONObject5.optString("smooth"));
                    int iB2 = wsa.b(jSONObjectOptJSONObject5.optString("slow"));
                    int iB3 = wsa.b(jSONObjectOptJSONObject5.optString("congested"));
                    int iB4 = wsa.b(jSONObjectOptJSONObject5.optString("seriousCongested"));
                    this.f939a.setSmoothColor(iB);
                    this.f939a.setSlowColor(iB2);
                    this.f939a.setCongestedColor(iB3);
                    this.f939a.setSeriousCongestedColor(iB4);
                    if (this.f950f == null) {
                        this.f950f = FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
                    }
                    this.f940a.setTrafficStyleWithTexture(this.f950f, this.f939a);
                }
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (jSONObjectOptJSONObject6 != null) {
                g(jSONObjectOptJSONObject6);
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapCustomStyleManager", "setExtraStyle");
            zwa.D(th);
        }
    }

    public final byte[] i(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f940a.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME, j(str));
        }
        for (String str2 : this.f942a.keySet()) {
            if (str.contains(str2)) {
                return this.f942a.get(str2);
            }
        }
        return null;
    }

    public final void k() {
        if (this.f938a == null) {
            return;
        }
        synchronized (this) {
            IAMapDelegate iAMapDelegate = this.f940a;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f940a.getMapConfig().isProFunctionAuthEnable()) {
                this.f938a.setStyleId(null);
                this.f951g = null;
                this.f952h = null;
                this.f953i = null;
            }
            this.c = true;
            this.f945b = true;
            if (this.j) {
                this.d = true;
            }
            this.f943a = true;
            this.e = true;
        }
    }

    public final void m() {
        if (this.f938a == null) {
            this.f938a = new CustomMapStyleOptions();
        }
    }

    public final boolean o() {
        return this.f938a != null;
    }

    public final void p() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.f938a;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                t();
                this.f943a = true;
            }
        }
    }

    public final void q() {
        IAMapDelegate iAMapDelegate = this.f940a;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f950f != null) {
            this.f940a.getGLMapEngine().setTrafficStyleWithTexture(this.f25982a, this.f950f, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f940a;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f947c != null) {
            this.f940a.getGLMapEngine().setBackgroundTexture(this.f25982a, this.f947c);
        }
        this.j = false;
    }

    public final void r() {
        if (this.l) {
            if (this.f946b == null) {
                this.f946b = n(FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f946b == null) {
            this.f946b = n(FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f940a.getGLMapEngine().setCustomStyleData(this.f25982a, this.f946b, this.f944a);
        this.i = false;
        this.f942a.clear();
    }

    public final void s() {
        if (this.h) {
            if (this.f948d == null) {
                this.f948d = FileUtil.readFileContentsFromAssets(this.f935a, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.h = false;
            this.f940a.getGLMapEngine().setCustomStyleTexture(this.f25982a, this.f948d);
        }
    }

    public final void t() {
        CustomMapStyleOptions customMapStyleOptions = this.f938a;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f938a.setStyleDataPath(null);
            this.f938a.setStyleData(null);
            this.f938a.setStyleTexturePath(null);
            this.f938a.setStyleTextureData(null);
            this.f938a.setStyleExtraData(null);
            this.f938a.setStyleExtraPath(null);
        }
    }

    @Override // com.amap.api.col.3l.cs.a
    public final void a(byte[] bArr, int i) {
        b(bArr, i);
    }
}
