package com.alibaba.ariver.commonability.device.jsapi.wifi;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SendUDPMessageExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23999a = "SendUDPMessageExtension";
    private static final String b = "ip";
    private static final String c = "port";
    private static final String d = "data";
    private static final String e = "broadcast";
    private static final int f = 12;

    private static InetAddress a(Context context) {
        if (b(context).booleanValue()) {
            return InetAddress.getByName("192.168.43.255");
        }
        DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
        if (dhcpInfo == null) {
            return InetAddress.getByName("255.255.255.255");
        }
        int i = dhcpInfo.ipAddress;
        int i2 = dhcpInfo.netmask;
        int i3 = (~i2) | (i & i2);
        byte[] bArr = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr[i4] = (byte) ((i3 >> (i4 * 8)) & 255);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static Boolean b(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (Boolean) wifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
            return Boolean.FALSE;
        } catch (IllegalArgumentException e3) {
            e = e3;
            e.printStackTrace();
            return Boolean.FALSE;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return Boolean.FALSE;
        } catch (InvocationTargetException e5) {
            e = e5;
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getSSID(@BindingApiContext ApiContext apiContext) {
        WifiManager wifiManager = (WifiManager) apiContext.getActivity().getApplicationContext().getSystemService("wifi");
        String ssid = wifiManager.isWifiEnabled() ? wifiManager.getConnectionInfo().getSSID() : "";
        String strSubstring = TextUtils.isEmpty(ssid) ? "" : ssid;
        if (strSubstring.startsWith("\"") && strSubstring.endsWith("\"")) {
            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ssid", (Object) strSubstring);
        return new BridgeResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse sendUDPMessage(@BindingParam({"ip"}) String str, @BindingParam({c}) int i, @BindingParam({"data"}) String str2, @BindingParam({e}) String str3, @BindingApiContext ApiContext apiContext) {
        boolean z = !str3.isEmpty() && b.a(str3) > 0;
        String str4 = f23999a;
        RVLogger.e(str4, "sendUdpMessage before ip:" + str + ",port:" + i + ",data:" + str2 + ",broadcast:" + str3);
        if (str == null || i == 0 || str2 == null) {
            RVLogger.e(str4, "sendUdpMessage param is empty");
            return new BridgeResponse.Error(12, "param is empty");
        }
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            try {
                InetAddress byName = InetAddress.getByName(str);
                if (z) {
                    datagramSocket.setBroadcast(true);
                    byName = a(apiContext.getActivity().getApplication());
                }
                byte[] bArrDecode = Base64.decode(str2.getBytes(), 2);
                RVLogger.e(str4, "sendUdpMessage after ip:" + str + ",port:" + i + ",data:" + bArrDecode);
                datagramSocket.send(new DatagramPacket(bArrDecode, bArrDecode.length, byName, i));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", (Object) "");
                datagramSocket.close();
                return new BridgeResponse(jSONObject);
            } catch (Throwable th) {
                datagramSocket.close();
                RVLogger.e(f23999a, String.format("sendSocketMessage error : %s", th.toString()), th);
                return new BridgeResponse.Error(12, "exception: " + th.getMessage());
            }
        } catch (SocketException e2) {
            RVLogger.e(f23999a, String.format("sendUdpMessage error : %s", e2.toString()), e2);
            return new BridgeResponse.Error(12, "exception: " + e2.getMessage());
        }
    }
}
