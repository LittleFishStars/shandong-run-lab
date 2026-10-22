package com.kwad.sdk.core.b.a;

import com.kwad.sdk.monitor.MediaMessageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class it implements com.kwad.sdk.core.d<MediaMessageInfo.MediaPermissionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((MediaMessageInfo.MediaPermissionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((MediaMessageInfo.MediaPermissionInfo) bVar, jSONObject);
    }

    private static void a(MediaMessageInfo.MediaPermissionInfo mediaPermissionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mediaPermissionInfo.canReadLocation = jSONObject.optInt("canReadLocation");
        mediaPermissionInfo.getLocation = jSONObject.optInt("getLocation");
        mediaPermissionInfo.getKsLocation = jSONObject.optInt("getKsLocation");
        mediaPermissionInfo.canUsePhoneState = jSONObject.optInt("canUsePhoneState");
        mediaPermissionInfo.getImei = jSONObject.optInt("getImei");
        mediaPermissionInfo.getImeis = jSONObject.optInt("getImeis");
        mediaPermissionInfo.getAndroidId = jSONObject.optInt("getAndroidId");
        mediaPermissionInfo.canUseOaid = jSONObject.optInt("canUseOaid");
        mediaPermissionInfo.getOaid = jSONObject.optInt("getOaid");
        mediaPermissionInfo.canUseMacAddress = jSONObject.optInt("canUseMacAddress");
        mediaPermissionInfo.getMacAddress = jSONObject.optInt("getMacAddress");
        mediaPermissionInfo.canUseNetworkState = jSONObject.optInt("canUseNetworkState");
        mediaPermissionInfo.canUseStoragePermission = jSONObject.optInt("canUseStoragePermission");
        mediaPermissionInfo.canReadInstalledPackages = jSONObject.optInt("canReadInstalledPackages");
        mediaPermissionInfo.getInstalledPackages = jSONObject.optInt("getInstalledPackages");
        mediaPermissionInfo.canReadMacAddress = jSONObject.optInt("canReadMacAddress");
        mediaPermissionInfo.canReadNearbyWifiList = jSONObject.optInt("canReadNearbyWifiList");
        mediaPermissionInfo.canReadICCID = jSONObject.optInt("canReadICCID");
    }

    private static JSONObject b(MediaMessageInfo.MediaPermissionInfo mediaPermissionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = mediaPermissionInfo.canReadLocation;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadLocation", i);
        }
        int i2 = mediaPermissionInfo.getLocation;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getLocation", i2);
        }
        int i3 = mediaPermissionInfo.getKsLocation;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getKsLocation", i3);
        }
        int i4 = mediaPermissionInfo.canUsePhoneState;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUsePhoneState", i4);
        }
        int i5 = mediaPermissionInfo.getImei;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getImei", i5);
        }
        int i6 = mediaPermissionInfo.getImeis;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getImeis", i6);
        }
        int i7 = mediaPermissionInfo.getAndroidId;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getAndroidId", i7);
        }
        int i8 = mediaPermissionInfo.canUseOaid;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseOaid", i8);
        }
        int i9 = mediaPermissionInfo.getOaid;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getOaid", i9);
        }
        int i10 = mediaPermissionInfo.canUseMacAddress;
        if (i10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseMacAddress", i10);
        }
        int i11 = mediaPermissionInfo.getMacAddress;
        if (i11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getMacAddress", i11);
        }
        int i12 = mediaPermissionInfo.canUseNetworkState;
        if (i12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseNetworkState", i12);
        }
        int i13 = mediaPermissionInfo.canUseStoragePermission;
        if (i13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseStoragePermission", i13);
        }
        int i14 = mediaPermissionInfo.canReadInstalledPackages;
        if (i14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadInstalledPackages", i14);
        }
        int i15 = mediaPermissionInfo.getInstalledPackages;
        if (i15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getInstalledPackages", i15);
        }
        int i16 = mediaPermissionInfo.canReadMacAddress;
        if (i16 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadMacAddress", i16);
        }
        int i17 = mediaPermissionInfo.canReadNearbyWifiList;
        if (i17 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadNearbyWifiList", i17);
        }
        int i18 = mediaPermissionInfo.canReadICCID;
        if (i18 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadICCID", i18);
        }
        return jSONObject;
    }
}
