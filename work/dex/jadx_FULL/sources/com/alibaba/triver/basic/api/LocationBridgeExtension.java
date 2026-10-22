package com.alibaba.triver.basic.api;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.zj.adlib.bv9;
import com.zj.adlib.ze1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LocationBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24675a = "LocationBridge";
    private static final int b = 19;
    private static LocationManager c = null;
    private static int d = 11;
    private static int e = 13;
    protected static String[] sRequirePermissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static boolean f = false;

    public static class LocalPermissionReceiver extends BroadcastReceiver {
        private static final String d = "LocalPermissionReceiver";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f24678a;
        final BridgeCallback b;
        final JSONObject c;

        public LocalPermissionReceiver(Context context, JSONObject jSONObject, BridgeCallback bridgeCallback) {
            this.f24678a = context;
            this.b = bridgeCallback;
            this.c = jSONObject;
        }

        private void a() {
            RVLogger.d(d, "no permission");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) Integer.valueOf(LocationBridgeExtension.d));
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) "没有定位权限");
            this.b.sendJSONResponse(jSONObject);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int intExtra = intent.getIntExtra(RequestPermission.REQUEST_CODE, 0);
                int[] intArrayExtra = intent.getIntArrayExtra(RequestPermission.GRANT_RESULTS);
                if (intExtra != 19 || intArrayExtra.length <= 0) {
                    return;
                }
                for (int i : intArrayExtra) {
                    if (i != 0) {
                        a();
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                        return;
                    } else {
                        boolean unused = LocationBridgeExtension.f = true;
                        LocationBridgeExtension.b(this.f24678a, this.c, this.b);
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                    }
                }
            } catch (Exception e) {
                RVLogger.e(d, "onReceive e:", e);
            }
        }
    }

    private void a(Context context, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        try {
            int i = Build.VERSION.SDK_INT;
            if (context.getApplicationInfo().targetSdkVersion < 23) {
                f = true;
                b(context, jSONObject, bridgeCallback);
                return;
            }
            if (f) {
                return;
            }
            if (i >= 28) {
                if (c == null) {
                    c = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                }
                if (!((Boolean) c.getClass().getDeclaredMethod("isLocationEnabled", new Class[0]).invoke(c, new Object[0])).booleanValue()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", (Object) Integer.valueOf(d));
                    jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "定位服务未打开");
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String str : sRequirePermissions) {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() <= 0) {
                f = true;
                b(context, jSONObject, bridgeCallback);
            } else {
                LocalBroadcastManager.getInstance(context).registerReceiver(new LocalPermissionReceiver(context, jSONObject, bridgeCallback), new IntentFilter(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT));
                context.getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, (String[]) arrayList.toArray(new String[arrayList.size()]), 19);
            }
        } catch (Exception e2) {
            RVLogger.e(f24675a, "checkPermission e:", e2);
        }
    }

    private static void b(Context context) {
        Intent intent = new Intent();
        intent.setAction("location_broadcast_end");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @ActionFilter
    public void getCurrentLocation(@BindingParam(intDefault = 30, value = {"cacheTimeout"}) int i, @BindingParam(intDefault = 0, value = {TRiverConstants.CDN_REQUEST_TYPE}) int i2, @BindingParam(intDefault = 10, value = {com.alipay.sdk.m.o.b.r0}) int i3, @BindingParam({"bizType"}) String str, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cacheTimeout", (Object) Integer.valueOf(i));
            jSONObject.put(TRiverConstants.CDN_REQUEST_TYPE, (Object) Integer.valueOf(i2));
            jSONObject.put(com.alipay.sdk.m.o.b.r0, (Object) Integer.valueOf(i3));
            jSONObject.put("bizType", (Object) str);
            Activity activity = (page.getPageContext() == null || page.getPageContext().getActivity() == null) ? ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get() : page.getPageContext().getActivity();
            if (activity == null) {
                activity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            }
            if (f) {
                b(activity, jSONObject, bridgeCallback);
            } else {
                a(activity, jSONObject, bridgeCallback);
            }
        } catch (Exception e2) {
            RVLogger.e(f24675a, "getCurrentLocation exception:", e2);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        a.a().c();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        a(context);
        final AMapLocationClient aMapLocationClientA = a.a().a(context);
        aMapLocationClientA.setLocationOption(a(jSONObject));
        aMapLocationClientA.setLocationListener(new AMapLocationListener() { // from class: com.alibaba.triver.basic.api.LocationBridgeExtension.2
            @Override // com.amap.api.location.AMapLocationListener
            public void onLocationChanged(AMapLocation aMapLocation) {
                try {
                    LocationBridgeExtension.a(aMapLocation, context, jSONObject, bridgeCallback);
                } finally {
                    aMapLocationClientA.stopLocation();
                }
            }
        });
        aMapLocationClientA.startLocation();
    }

    private static void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("location_broadcast_start");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private static AMapLocationClientOption a(JSONObject jSONObject) {
        int iIntValue = jSONObject.getInteger("cacheTimeout").intValue();
        int iIntValue2 = jSONObject.getInteger(com.alipay.sdk.m.o.b.r0).intValue();
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (iIntValue > 0) {
            try {
                aMapLocationClientOption.setLocationCacheEnable(true);
            } catch (NoSuchMethodError unused) {
            }
        }
        try {
            aMapLocationClientOption.setHttpTimeOut(iIntValue2 < 10000 ? 10000L : iIntValue2);
        } catch (NoSuchMethodError unused2) {
        }
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(false);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(true);
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        return aMapLocationClientOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AMapLocation aMapLocation, Context context, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        int iIntValue;
        try {
            iIntValue = jSONObject.getInteger(TRiverConstants.CDN_REQUEST_TYPE).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        final JSONObject jSONObject2 = new JSONObject();
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            double dDoubleValue = Double.valueOf(aMapLocation.getLongitude()).doubleValue();
            double dDoubleValue2 = Double.valueOf(aMapLocation.getLatitude()).doubleValue();
            if (dDoubleValue > -1.0E-6d && dDoubleValue < 1.0E-6d && dDoubleValue2 > -1.0E-6d && dDoubleValue2 < 1.0E-6d) {
                b(context);
                jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "getLocation: longitude and latitude is zero.");
                jSONObject2.put("error", (Object) Integer.valueOf(e));
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            }
            b(context);
            jSONObject2.put("longitude", (Object) Double.valueOf(aMapLocation.getLongitude()));
            jSONObject2.put("latitude", (Object) Double.valueOf(aMapLocation.getLatitude()));
            jSONObject2.put("accuracy", (Object) Float.toString(aMapLocation.getAccuracy()));
            if (iIntValue > 0) {
                if (iIntValue >= 1) {
                    jSONObject2.put(ze1.s, (Object) aMapLocation.getCountry());
                    jSONObject2.put("province", (Object) aMapLocation.getProvince());
                    jSONObject2.put("city", (Object) aMapLocation.getCity());
                    jSONObject2.put("district", (Object) aMapLocation.getDistrict());
                    jSONObject2.put("districtAdcode", (Object) aMapLocation.getAdCode());
                    jSONObject2.put("countryCode", (Object) aMapLocation.getCountry());
                    try {
                        jSONObject2.put("cityAdcode", (Object) String.valueOf(Integer.valueOf(aMapLocation.getAdCode()).intValue() - (Integer.valueOf(aMapLocation.getAdCode()).intValue() % 100)));
                    } catch (Exception e2) {
                        RVLogger.e(f24675a, "cityAdCode exception:", e2);
                    }
                }
                if (iIntValue >= 2) {
                    jSONObject2.put("streetNumber", (Object) (bv9.b + aMapLocation.getStreet() + "," + aMapLocation.getStreetNum() + "}"));
                }
                if (iIntValue >= 3) {
                    PoiSearch.Query query = new PoiSearch.Query("", "", aMapLocation.getCityCode());
                    query.setPageSize(20);
                    PoiSearch poiSearch = new PoiSearch(context, query);
                    poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(dDoubleValue2, dDoubleValue), 10000));
                    poiSearch.setQuery(query);
                    poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: com.alibaba.triver.basic.api.LocationBridgeExtension.1
                        public void onPoiItemSearched(PoiItem poiItem, int i) {
                        }

                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        public void onPoiSearched(PoiResult poiResult, int i) {
                            if (i == 1000 && poiResult != null) {
                                ArrayList<PoiItem> pois = poiResult.getPois();
                                JSONArray jSONArray = new JSONArray();
                                if (pois != null && pois.size() != 0) {
                                    for (PoiItem poiItem : pois) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put(poiItem.getTitle(), (Object) poiItem.getSnippet());
                                        jSONArray.add(jSONObject3);
                                    }
                                }
                                jSONObject2.put("pois", (Object) jSONArray);
                            }
                            bridgeCallback.sendJSONResponse(jSONObject2);
                        }
                    });
                    poiSearch.searchPOIAsyn();
                }
            }
            if (iIntValue < 3) {
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            }
            return;
        }
        b(context);
        if (aMapLocation == null) {
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "location == null");
        } else {
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, (Object) ("fail to location, errCode=[" + aMapLocation.getErrorCode() + "]"));
        }
        jSONObject2.put("error", (Object) Integer.valueOf(e));
        bridgeCallback.sendJSONResponse(jSONObject2);
    }
}
