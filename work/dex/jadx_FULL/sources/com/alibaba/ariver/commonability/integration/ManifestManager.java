package com.alibaba.ariver.commonability.integration;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.file.jsapi.FSManageExtension;
import com.alibaba.ariver.commonability.map.app.IEmbedMapViewProvider;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ManifestManager implements RVManifest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24037a = "com-alibaba-ariver-commonability";

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.bluetooth.jsapi.BluetoothExtension", Arrays.asList("closeBluetoothAdapter", "connectBLEDevice", "disconnectBLEDevice", "getBLEDeviceCharacteristics", "getBLEDeviceServices", "getBluetoothAdapterState", "getBluetoothDevices", "getConnectedBluetoothDevices", "notifyBLECharacteristicValueChange", "openBluetoothAdapter", "readBLECharacteristicValue", "startBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery", "writeBLECharacteristicValue", "disableBluetooth", "enableBluetooth", "getBLEDeviceRSSI", "setBLEMTU", "createBluetoothSocket", "writeBluetoothSocketValue", "closeBluetoothSocket", "connectBluetoothSocket", "makeBluetoothPair", "cancelBluetoothPair", "getBluetoothPairs"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.system.GetBatteryInfoBridgeExtension", Arrays.asList("getBatteryInfo"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.phone.MakePhoneCallBridgeExtension", Arrays.asList("makePhoneCall"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.phone.TelephonyInfoBridgeExtension", Arrays.asList("getCarrierName"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.clipboard.ClipboardBridgeExtension", Arrays.asList("getClipboard", "setClipboard"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.wifi.SendUDPMessageExtension", Arrays.asList("getSSID", "sendUDPMessage"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.contact.AddPhoneContactBridgeExtension", Arrays.asList("addPhoneContact"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.system.SystemRootStatusBridgeExtension", Arrays.asList("isSystemRoot"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.screen.ScreenBrightnessBridgeExtension", Arrays.asList("getScreenBrightness", "setScreenBrightness", "setScreenAutolock"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.bluetooth.jsapi.IBeaconBridgeExtension", Arrays.asList("getBeacons", "startBeaconDiscovery", "stopBeaconDiscovery"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.sensor.DeviceOrientationBridgeExtension", Arrays.asList("startDeviceMotionListening", "stopDeviceMotionListening"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension", Arrays.asList("getFileInfo", "getSavedFileInfo", "getSavedFileList", "removeSavedFile", "saveFile"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension", Arrays.asList(JSApiCachePoint.GET_SYSTEM_INFO), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension", Arrays.asList("connectWifi", "getConnectedWifi", "getWifiList", "startWifi", "stopWifi"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.vibrate.VibrateBridgeExtension", Arrays.asList("vibrate", "vibrateLong", "vibrateShort"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.wifi.WifiInfoExtension", Arrays.asList("getWifiInfo"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension", Arrays.asList("watchShake"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.phone.ChoosePhoneContactBridgeExtension", Arrays.asList("contact"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.file.jsapi.FSManageExtension", Arrays.asList(FSManageExtension.ACTION_FS_MANAGE), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.mdns.jsapi.MultiCastDNSBridgeExtension", Arrays.asList("startLocalServiceDiscovery", "stopLocalServiceDiscovery"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.map.jsapi.GetMapInfoBridgeExtension", Arrays.asList("getMapInfo"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.map.jsapi.AuthMapLocationBridgeExtension", Arrays.asList("authMapLocation"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.map.jsapi.CalculateRouteExtension", Arrays.asList("calculateRoute"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.nfc.jsapi.NFCBridgeExtension", Arrays.asList("getNFCAdapter", "enableNFC", "startNFCDiscovery", "stopNFCDiscovery", "connectNFC", "closeNFC", "setNFCTimeout", "transceiveNFC", "getNFCMaxTransceiveLength", "getIsoDepHistoricalBytes", "getNFCTag", "writeNdefMessage", "getNfcASak", "getNfcAAtqa"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(f24037a, "com.alibaba.ariver.commonability.device.jsapi.navigator.NavigatorBridgeExtension", Arrays.asList("navigateToSetting"), App.class));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        boolean z;
        EmbedViewMetaInfo mapViewMetaInfo;
        HashMap map = new HashMap();
        IEmbedMapViewProvider iEmbedMapViewProvider = (IEmbedMapViewProvider) RVProxy.get(IEmbedMapViewProvider.class);
        if (iEmbedMapViewProvider == null || (mapViewMetaInfo = iEmbedMapViewProvider.getMapViewMetaInfo()) == null) {
            z = false;
        } else {
            map.put("map", mapViewMetaInfo);
            z = true;
        }
        if (!z) {
            map.put("map", new EmbedViewMetaInfo(f24037a, "com.alibaba.ariver.commonability.map.app.RVEmbedMapView"));
        }
        return map;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo(f24037a, "com.alibaba.ariver.commonability.device.jsapi.phone.contact.ContactActivityResultPoint", Arrays.asList("com.alibaba.ariver.app.api.point.activity.ActivityResultPoint")));
        arrayList.add(new ExtensionMetaInfo(f24037a, "com.alibaba.ariver.commonability.map.RVMapAppPointExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.app.AppCreatePoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint", "com.alibaba.ariver.app.api.point.app.AppStartPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(f24037a, "com.alibaba.ariver.commonability.core.ipc.RemoteExtension", (List<String>) Arrays.asList("com.alibaba.ariver.commonability.core.ipc.RemotePoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(f24037a, "com.alibaba.ariver.commonability.nfc.jsapi.NFCBridgeExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.activity.ActivityOnNewIntentPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(f24037a, "com.alibaba.ariver.commonability.map.RVMapAppDebugButtonExtension", (List<String>) Arrays.asList("com.alibaba.ariver.console.ShowToggleButtonPoint"), (Class<? extends Scope>) App.class));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        return null;
    }
}
