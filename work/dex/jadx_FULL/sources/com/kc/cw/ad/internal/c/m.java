package com.kc.cw.ad.internal.c;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.model.SsLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m {
    public static void a(Context context) {
        l lVarA = l.a();
        try {
            SsLocation ssLocation = lVarA.b;
            SsLocation ssLocation2 = null;
            if (lVarA.f38951a && (SSAd.getCustomController() == null || SSAd.getCustomController().isCanUseLocation())) {
                if (ssLocation != null) {
                    ssLocation2 = ssLocation;
                } else if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                    Iterator<String> it = locationManager.getProviders(true).iterator();
                    while (it.hasNext()) {
                        Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
                        if (lastKnownLocation != null) {
                            if (ssLocation2 == null) {
                                ssLocation2 = new SsLocation(lastKnownLocation.getLongitude(), lastKnownLocation.getLatitude(), 0, lastKnownLocation.getTime());
                            } else if (lastKnownLocation.getTime() > ssLocation2.getTime()) {
                                ssLocation2 = new SsLocation(lastKnownLocation.getLongitude(), lastKnownLocation.getLatitude(), 0, lastKnownLocation.getTime());
                            }
                        }
                    }
                } else {
                    String strB = o.b(context, RequestParameters.SUBRESOURCE_LOCATION);
                    if (!TextUtils.isEmpty(strB) && !strB.equals("{}")) {
                        ssLocation2 = (SsLocation) k.a(strB, SsLocation.class);
                    }
                }
            }
            if (SSAd.getCustomController() != null && SSAd.getCustomController().getLocation() != null) {
                SsLocation location = SSAd.getCustomController().getLocation();
                if (ssLocation2 == null || location.getTime() > ssLocation2.getTime()) {
                    ssLocation2 = location;
                }
            }
            if (ssLocation2 == null || ssLocation2 == ssLocation) {
                return;
            }
            if (lVarA.b() <= -1) {
                lVarA.b = ssLocation2;
            } else {
                String str = "%." + lVarA.b() + "f";
                Locale locale = Locale.US;
                lVarA.b = new SsLocation(Double.parseDouble(String.format(locale, str, Double.valueOf(ssLocation2.getLongitude()))), Double.parseDouble(String.format(locale, str, Double.valueOf(ssLocation2.getLatitude()))), 0, ssLocation2.getTime());
            }
            String strA = k.a(lVarA.b);
            if (TextUtils.isEmpty(strA) || strA.equals("{}")) {
                return;
            }
            o.a(context, RequestParameters.SUBRESOURCE_LOCATION, strA);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
