package com.zj.adlib;

import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.kuaishou.weapon.p0.b;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class wsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f45683a = {1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20535a = 0;
    public int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<tsa> f20536a = null;

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#".concat(str);
            }
            return Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static StyleElement c(Map<Integer, StyleItem> map, int i, int i2, tsa tsaVar) {
        StyleItem styleItem = map.get(Integer.valueOf(i));
        if (styleItem == null) {
            styleItem = new StyleItem(tsaVar.b);
            styleItem.mainKey = tsaVar.f44998a;
            styleItem.subKey = tsaVar.f19894a;
            map.put(Integer.valueOf(i), styleItem);
        }
        StyleElement styleElement = styleItem.get(i2);
        if (styleElement != null) {
            return styleElement;
        }
        StyleElement styleElement2 = new StyleElement();
        styleElement2.styleElementType = i2;
        styleItem.put(i2, styleElement2);
        return styleElement2;
    }

    public static usa d(byte[] bArr) {
        usa usaVar = null;
        try {
            usa usaVar2 = new usa();
            try {
                byte[] bytes = t.d.getBytes("utf-8");
                int length = bArr.length;
                int length2 = bytes.length;
                for (int i = 0; i < length; i++) {
                    bArr[i] = (byte) (bytes[i % length2] ^ bArr[i]);
                }
                usaVar2.b(Convert.getString(bArr, 0, 4));
                usaVar2.c(Convert.getString(bArr, 4, 32));
                usaVar2.d(Convert.getString(bArr, 36, 10));
                usaVar2.e(g(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
                return usaVar2;
            } catch (Throwable th) {
                th = th;
                usaVar = usaVar2;
                th.printStackTrace();
                return usaVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(b.f40051a);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void n(Map<Integer, StyleItem> map, JSONObject jSONObject, int i, int i2, tsa tsaVar) throws JSONException {
        int iB;
        StyleElement styleElementC = c(map, i, i2, tsaVar);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("stylers");
        if (jSONObjectOptJSONObject == null || (iB = b(jSONObjectOptJSONObject.optString("color"))) == 0) {
            return;
        }
        styleElementC.value = iB;
        styleElementC.textureId = jSONObjectOptJSONObject.optInt("textureName", 0);
        styleElementC.lineWidth = jSONObjectOptJSONObject.optInt("lineWidth", 0);
        if (i >= 30 && i <= 38) {
            c(map, i, 4, tsaVar).opacity = 0.1f;
            return;
        }
        String str = tsaVar.f19893a;
        if (str != null && str.equals("water") && i2 == 3) {
            c(map, i, 2, tsaVar).value = iB;
        }
    }

    public static void o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i, tsa tsaVar) {
        try {
            int iOptInt = jSONObject.optInt(str, 0);
            if (iOptInt == 0) {
                return;
            }
            c(map, i, com.amap.api.col.p0003l.cx.a(str), tsaVar).textureId = iOptInt;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void p(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i, tsa tsaVar) {
        int iB;
        float fOptDouble;
        try {
            String strOptString = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(strOptString)) {
                fOptDouble = (float) jSONObject.optDouble(str2, 1.0d);
                iB = 0;
            } else {
                iB = b("#".concat(String.valueOf(strOptString)));
                fOptDouble = 1.0f;
            }
            if (iB == 0 && fOptDouble == 1.0d) {
                return;
            }
            int iA = com.amap.api.col.p0003l.cx.a(str);
            StyleElement styleElementC = c(map, i, iA, tsaVar);
            styleElementC.value = iB;
            styleElementC.opacity = fOptDouble;
            String str3 = tsaVar.f19895b;
            if (str3 != null && str3.equals("China")) {
                c(map, i, iA, tsaVar).opacity = 0.0f;
                return;
            }
            String str4 = tsaVar.f19893a;
            if (str4 != null && str4.equals("water") && iA == 3) {
                StyleElement styleElementC2 = c(map, i, 2, tsaVar);
                styleElementC2.value = iB;
                styleElementC2.opacity = fOptDouble;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void r(JSONArray jSONArray, String str, String str2, String str3, List<tsa> list) {
        int[] iArr;
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("mainkey");
                int[] iArr2 = new int[0];
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("subkey");
                if (jSONArrayOptJSONArray != null) {
                    int length2 = jSONArrayOptJSONArray.length();
                    int[] iArr3 = new int[length2];
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr3[i2] = jSONArrayOptJSONArray.optInt(i2);
                    }
                    iArr = iArr3;
                } else {
                    iArr = iArr2;
                }
                list.add(new tsa(iOptInt, iArr, str, str2, str3));
            }
        }
    }

    public final int a() {
        return this.f20535a;
    }

    public final yua e(String str, boolean z) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return t(str, z);
    }

    public final yua f(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return u(bArr, z);
    }

    public final List<tsa> h(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList();
        for (tsa tsaVar : this.f20536a) {
            if (tsaVar != null) {
                String str4 = tsaVar.f19893a;
                if (str4 == null || !str4.equals(str2)) {
                    String str5 = tsaVar.f19893a;
                    if (str5 != null && str5.equals(str) && (str3 = tsaVar.f19895b) != null && str3.contains(str2)) {
                        arrayList.add(tsaVar);
                    }
                } else {
                    arrayList.add(tsaVar);
                }
            }
        }
        return arrayList;
    }

    public final void i(int i) {
        this.b = i;
    }

    public final void j(yua yuaVar) {
        if (this.b != -1) {
            Map<Integer, StyleItem> mapA = yuaVar.a();
            for (tsa tsaVar : h("roads", "trafficRoadBackgroundColor")) {
                c(mapA, tsaVar.c, com.amap.api.col.p0003l.cx.a("fillColor"), tsaVar).value = this.b;
                c(mapA, tsaVar.c, com.amap.api.col.p0003l.cx.a("strokeColor"), tsaVar).value = this.b;
            }
        }
    }

    public final void k(yua yuaVar, byte[] bArr, boolean z) {
        usa usaVarD = d(bArr);
        if (usaVarD == null || usaVarD.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(usaVarD.a());
            JSONArray jSONArrayNames = jSONObject.names();
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String string = jSONArrayNames.getString(i);
                if (string == null || !string.trim().equals("sdkTextures")) {
                    if (string == null || !string.trim().equals("background")) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(string);
                        if (jSONObjectOptJSONObject != null) {
                            m(string, yuaVar.a(), jSONObjectOptJSONObject, z);
                        }
                    } else {
                        this.f20535a = b("#".concat(String.valueOf(jSONObject.optString("background"))));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void l(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (this.f20536a == null) {
            this.f20536a = v();
        }
        List<tsa> listH = h(str, str2);
        for (tsa tsaVar : listH) {
            if (tsaVar == null || tsaVar.b == -1000) {
                return;
            }
            int i = tsaVar.c;
            if (jSONObject.optBoolean("visible", true)) {
                if (!jSONObject.optBoolean("showIcon", true)) {
                    c(map, i, com.amap.api.col.p0003l.cx.a("textFillColor"), tsaVar).textureId = -1;
                }
                if (!jSONObject.optBoolean("showLabel", true)) {
                    c(map, i, com.amap.api.col.p0003l.cx.a("textFillColor"), tsaVar).opacity = 0.0f;
                    StyleElement styleElementC = c(map, i, com.amap.api.col.p0003l.cx.a("textStrokeColor"), tsaVar);
                    styleElementC.opacity = 0.0f;
                    styleElementC.visible = 0;
                    styleElementC.textureId = -1;
                }
                p(map, jSONObject, "color", "opacity", i, tsaVar);
                p(map, jSONObject, "fillColor", "fillOpacity", i, tsaVar);
                p(map, jSONObject, "strokeColor", "strokeOpacity", i, tsaVar);
                p(map, jSONObject, "textFillColor", "textFillOpacity", i, tsaVar);
                p(map, jSONObject, "textStrokeColor", "textStrokeOpacity", i, tsaVar);
                p(map, jSONObject, "backgroundColor", "backgroundOpacity", i, tsaVar);
                if (z) {
                    o(map, jSONObject, "textureName", i, tsaVar);
                }
            } else {
                StyleElement styleElementC2 = c(map, i, com.amap.api.col.p0003l.cx.a("visible"), tsaVar);
                styleElementC2.textureId = -1;
                styleElementC2.visible = 0;
            }
        }
        listH.clear();
    }

    public final void m(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("subType");
        if (jSONObjectOptJSONObject == null) {
            l(str, str, map, jSONObject, z);
            return;
        }
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String strOptString = jSONArrayNames.optString(i);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strOptString);
            if (jSONObjectOptJSONObject2.has("detailedType")) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("detailedType");
                if (jSONObjectOptJSONObject3 != null) {
                    JSONArray jSONArrayNames2 = jSONObjectOptJSONObject3.names();
                    for (int i2 = 0; i2 < jSONArrayNames2.length(); i2++) {
                        String strOptString2 = jSONArrayNames2.optString(i2);
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(strOptString2);
                        if (jSONObjectOptJSONObject4 != null) {
                            l(str, strOptString2, map, jSONObjectOptJSONObject4, z);
                        }
                    }
                }
            } else {
                l(str, strOptString, map, jSONObjectOptJSONObject2, z);
            }
        }
    }

    public final void q(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i) throws JSONException {
        for (String str2 : strArr) {
            if (this.f20536a == null) {
                this.f20536a = v();
            }
            for (tsa tsaVar : h(str, str2)) {
                n(map, jSONObject, tsaVar.c, i, tsaVar);
            }
        }
    }

    public final boolean s(Map<Integer, StyleItem> map, byte[] bArr) {
        String[] strArrA;
        int iA;
        int iB;
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("featureType");
                if (!TextUtils.isEmpty(strOptString)) {
                    if ("background".equals(strOptString)) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("stylers");
                        if (jSONObjectOptJSONObject2 != null && (iB = b(jSONObjectOptJSONObject2.optString("color"))) != 0) {
                            this.f20535a = iB;
                        }
                    } else {
                        String strB = vsa.b(strOptString);
                        if (strB != null && (strArrA = vsa.a(strOptString)) != null && strArrA.length != 0) {
                            String strOptString2 = jSONObjectOptJSONObject.optString("elementType");
                            if (!TextUtils.isEmpty(strOptString2) && (iA = com.amap.api.col.p0003l.cx.a(strOptString2)) != -1) {
                                q(map, jSONObjectOptJSONObject, strB, strArrA, iA);
                            }
                        }
                    }
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final yua t(String str, boolean z) {
        try {
            return u(FileUtil.readFileContents(str), z);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final yua u(byte[] bArr, boolean z) {
        yua yuaVar = new yua();
        try {
            if (!s(yuaVar.a(), bArr)) {
                k(yuaVar, bArr, z);
            }
            j(yuaVar);
            yuaVar.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return yuaVar;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0169  */
    public final List<tsa> v() {
        String str;
        String str2;
        JSONObject jSONObject;
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject2;
        JSONArray jSONArray2;
        int i2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject3;
        String str3 = "name";
        String str4 = "subType";
        this.f20536a = new ArrayList();
        try {
            JSONArray jSONArray3 = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
            if (jSONArray3.length() == 0) {
                return this.f20536a;
            }
            int i3 = 0;
            JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(0);
            if (jSONObjectOptJSONObject2 == null) {
                return this.f20536a;
            }
            JSONArray jSONArrayNames = jSONObjectOptJSONObject2.names();
            int length = jSONArrayNames.length();
            int i4 = 0;
            while (i4 < length) {
                String strOptString = jSONArrayNames.optString(i4);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(strOptString);
                if (jSONObjectOptJSONObject3 != null) {
                    String strOptString2 = jSONObjectOptJSONObject3.optString(str3);
                    if (jSONObjectOptJSONObject3.has("styleMap")) {
                        r(jSONObjectOptJSONObject3.optJSONArray("styleMap"), strOptString, null, strOptString2, this.f20536a);
                    } else if (jSONObjectOptJSONObject3.has(str4)) {
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(str4);
                        if (jSONObjectOptJSONObject4 != null) {
                            JSONArray jSONArrayNames2 = jSONObjectOptJSONObject4.names();
                            int length2 = jSONArrayNames2.length();
                            int i5 = i3;
                            while (i5 < length2) {
                                String strOptString3 = jSONArrayNames2.optString(i5);
                                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject(strOptString3);
                                if (jSONObjectOptJSONObject5 != null) {
                                    jSONObject2 = jSONObjectOptJSONObject2;
                                    String strOptString4 = jSONObjectOptJSONObject5.optString(str3);
                                    jSONArray2 = jSONArrayNames;
                                    if (jSONObjectOptJSONObject5.has("styleMap")) {
                                        i2 = length;
                                        r(jSONObjectOptJSONObject5.optJSONArray("styleMap"), strOptString, strOptString3, strOptString2 + c49.f40900a + strOptString4, this.f20536a);
                                    } else {
                                        i2 = length;
                                        if (jSONObjectOptJSONObject5.has(str4) && (jSONObjectOptJSONObject = jSONObjectOptJSONObject5.optJSONObject(str4)) != null) {
                                            JSONArray jSONArrayNames3 = jSONObjectOptJSONObject.names();
                                            str4 = str4;
                                            int length3 = jSONArrayNames3.length();
                                            int i6 = 0;
                                            while (i6 < length3) {
                                                int i7 = length3;
                                                String strOptString5 = jSONArrayNames3.optString(i6);
                                                JSONArray jSONArray4 = jSONArrayNames3;
                                                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject(strOptString5);
                                                if (jSONObjectOptJSONObject6 != null) {
                                                    jSONObject3 = jSONObjectOptJSONObject;
                                                    String strOptString6 = jSONObjectOptJSONObject6.optString(str3);
                                                    if (jSONObjectOptJSONObject6.has("styleMap")) {
                                                        r(jSONObjectOptJSONObject6.optJSONArray("styleMap"), strOptString, strOptString3 + c49.f40900a + strOptString5, strOptString2 + c49.f40900a + strOptString4 + c49.f40900a + strOptString6, this.f20536a);
                                                    }
                                                } else {
                                                    jSONObject3 = jSONObjectOptJSONObject;
                                                }
                                                i6++;
                                                length3 = i7;
                                                jSONArrayNames3 = jSONArray4;
                                                jSONObjectOptJSONObject = jSONObject3;
                                                str3 = str3;
                                            }
                                            str3 = str3;
                                        }
                                        i5++;
                                        jSONObjectOptJSONObject2 = jSONObject2;
                                        length = i2;
                                        jSONArrayNames = jSONArray2;
                                        str4 = str4;
                                        jSONObjectOptJSONObject4 = jSONObjectOptJSONObject4;
                                        str3 = str3;
                                    }
                                } else {
                                    jSONObject2 = jSONObjectOptJSONObject2;
                                    jSONArray2 = jSONArrayNames;
                                    i2 = length;
                                }
                                i5++;
                                jSONObjectOptJSONObject2 = jSONObject2;
                                length = i2;
                                jSONArrayNames = jSONArray2;
                                str4 = str4;
                                jSONObjectOptJSONObject4 = jSONObjectOptJSONObject4;
                                str3 = str3;
                            }
                        } else {
                            str = str3;
                            str2 = str4;
                            jSONObject = jSONObjectOptJSONObject2;
                            jSONArray = jSONArrayNames;
                            i = length;
                        }
                    }
                    str = str3;
                    str2 = str4;
                    jSONObject = jSONObjectOptJSONObject2;
                    jSONArray = jSONArrayNames;
                    i = length;
                    this.f20536a.add(new tsa(20021, f45683a, "roads", "trafficRoadBackgroundColor", null));
                } else {
                    str = str3;
                    str2 = str4;
                    jSONObject = jSONObjectOptJSONObject2;
                    jSONArray = jSONArrayNames;
                    i = length;
                }
                i4++;
                jSONObjectOptJSONObject2 = jSONObject;
                length = i;
                jSONArrayNames = jSONArray;
                str4 = str2;
                str3 = str;
                i3 = 0;
            }
            return this.f20536a;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
