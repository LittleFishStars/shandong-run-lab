package com.alibaba.ariver.commonability.device.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.taobao.windvane.util.WVConstants;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.alibaba.ariver.commonability.R;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.constants.UserConstants;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddPhoneContactBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23957a = "AddPhoneContactBridgeExtension";
    private static final int b = 262144;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, BridgeCallback bridgeCallback, JSONObject jSONObject) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        try {
            activity.startActivity(a(activity, intent, jSONObject));
            bridgeCallback.sendBridgeResponse(new BridgeResponse.NamedValue("success", Boolean.TRUE));
        } catch (Exception e) {
            RVLogger.e(f23957a, e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, BridgeCallback bridgeCallback, JSONObject jSONObject) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        try {
            activity.startActivity(a(activity, intent, jSONObject));
            bridgeCallback.sendBridgeResponse(new BridgeResponse.NamedValue("success", Boolean.TRUE));
        } catch (Exception e) {
            RVLogger.e(f23957a, e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    public static String getDisplayPostal(ContentValues contentValues) {
        String[] strArr = {contentValues.getAsString("data4"), contentValues.getAsString("data7"), contentValues.getAsString("data8"), contentValues.getAsString("data9"), contentValues.getAsString("data10")};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String str = strArr[i];
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                if (i != 4) {
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void addPhoneContact(@BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback, @BindingRequest final JSONObject jSONObject) {
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        if (rVCommonAbilityProxy == null) {
            return;
        }
        final Activity activity = apiContext.getActivity();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(activity.getString(R.string.h5_add_contact_create), activity.getString(R.string.h5_add_contact_update)));
        b addPhoneContactDialog = rVCommonAbilityProxy.getAddPhoneContactDialog();
        addPhoneContactDialog.a(activity, arrayList);
        addPhoneContactDialog.a(new AdapterView.OnItemClickListener() { // from class: com.alibaba.ariver.commonability.device.jsapi.contact.AddPhoneContactBridgeExtension.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    AddPhoneContactBridgeExtension.a(activity, bridgeCallback, jSONObject);
                } else {
                    if (i != 1) {
                        return;
                    }
                    AddPhoneContactBridgeExtension.b(activity, bridgeCallback, jSONObject);
                }
            }
        });
        addPhoneContactDialog.a(new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.commonability.device.jsapi.contact.AddPhoneContactBridgeExtension.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "fail cancel"));
            }
        });
        addPhoneContactDialog.a();
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

    private static Intent a(Activity activity, Intent intent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return intent;
        }
        ContentValues contentValues = new ContentValues(8);
        contentValues.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/name");
        contentValues.put("data3", jSONObject.getString("lastName"));
        contentValues.put("data5", jSONObject.getString("middleName"));
        contentValues.put("data2", jSONObject.getString("firstName"));
        contentValues.put("data1", a(contentValues));
        ContentValues contentValues2 = new ContentValues(8);
        contentValues2.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/im");
        contentValues2.put("data2", (Integer) 3);
        contentValues2.put("data1", jSONObject.getString("alipayAccount"));
        contentValues2.put("data5", (Integer) (-1));
        contentValues2.put("data6", activity.getString(activity.getApplicationInfo().labelRes));
        ContentValues contentValues3 = new ContentValues(8);
        contentValues3.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/im");
        contentValues3.put("data2", (Integer) 3);
        contentValues3.put("data1", jSONObject.getString("weChatNumber"));
        contentValues3.put("data5", (Integer) (-1));
        contentValues3.put("data6", activity.getString(R.string.h5_add_contact_wechat));
        ContentValues contentValues4 = new ContentValues(4);
        contentValues4.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/photo");
        contentValues4.put("data15", a(jSONObject.getString("photoFilePath")));
        ContentValues contentValues5 = new ContentValues(4);
        contentValues5.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/nickname");
        contentValues5.put("data2", (Integer) 1);
        contentValues5.put("data1", jSONObject.getString(UserConstants.USER_PARAMS.b));
        ContentValues contentValues6 = new ContentValues(4);
        contentValues6.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/phone_v2");
        contentValues6.put("data2", (Integer) 3);
        contentValues6.put("data1", jSONObject.getString("workPhoneNumber"));
        ContentValues contentValues7 = new ContentValues(4);
        contentValues7.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/phone_v2");
        contentValues7.put("data2", (Integer) 4);
        contentValues7.put("data1", jSONObject.getString("workFaxNumber"));
        ContentValues contentValues8 = new ContentValues(4);
        contentValues8.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/phone_v2");
        contentValues8.put("data2", (Integer) 1);
        contentValues8.put("data1", jSONObject.getString("homePhoneNumber"));
        ContentValues contentValues9 = new ContentValues(4);
        contentValues9.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/phone_v2");
        contentValues9.put("data2", (Integer) 5);
        contentValues9.put("data1", jSONObject.getString("homeFaxNumber"));
        ContentValues contentValues10 = new ContentValues(4);
        contentValues10.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/phone_v2");
        contentValues10.put("data2", (Integer) 7);
        contentValues10.put("data1", jSONObject.getString("hostNumber"));
        ContentValues contentValues11 = new ContentValues(4);
        contentValues11.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/website");
        contentValues11.put("data2", (Integer) 7);
        contentValues11.put("data1", jSONObject.getString("url"));
        ContentValues contentValues12 = new ContentValues(8);
        contentValues12.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues12.put("data2", (Integer) 3);
        contentValues12.put("data10", jSONObject.getString("addressCountry"));
        contentValues12.put("data8", jSONObject.getString("addressState"));
        contentValues12.put("data7", jSONObject.getString("addressCity"));
        contentValues12.put("data4", jSONObject.getString("addressStreet"));
        contentValues12.put("data9", jSONObject.getString("addressPostalCode"));
        contentValues12.put("data1", getDisplayPostal(contentValues12));
        ContentValues contentValues13 = new ContentValues(8);
        contentValues13.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues13.put("data2", (Integer) 2);
        contentValues13.put("data10", jSONObject.getString("workAddressCountry"));
        contentValues13.put("data8", jSONObject.getString("workAddressState"));
        contentValues13.put("data7", jSONObject.getString("workAddressCity"));
        contentValues13.put("data4", jSONObject.getString("workAddressStreet"));
        contentValues13.put("data9", jSONObject.getString("workAddressPostalCode"));
        contentValues13.put("data1", getDisplayPostal(contentValues13));
        ContentValues contentValues14 = new ContentValues(8);
        contentValues14.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues14.put("data2", (Integer) 1);
        contentValues14.put("data10", jSONObject.getString("homeAddressCountry"));
        contentValues14.put("data8", jSONObject.getString("homeAddressState"));
        contentValues14.put("data7", jSONObject.getString("homeAddressCity"));
        contentValues14.put("data4", jSONObject.getString("homeAddressStreet"));
        contentValues14.put("data9", jSONObject.getString("homeAddressPostalCode"));
        contentValues14.put("data1", getDisplayPostal(contentValues14));
        ContentValues contentValues15 = new ContentValues(4);
        contentValues15.put(WVConstants.MIMETYPE, "vnd.android.cursor.item/note");
        contentValues15.put("data1", jSONObject.getString("remark"));
        intent.putParcelableArrayListExtra("data", new ArrayList<>(Arrays.asList(contentValues, contentValues2, contentValues3, contentValues4, contentValues5, contentValues6, contentValues7, contentValues8, contentValues9, contentValues10, contentValues11, contentValues12, contentValues13, contentValues14, contentValues15)));
        intent.putExtra("name", contentValues.getAsString("data1"));
        intent.putExtra(AliyunLogCommon.TERMINAL_TYPE, jSONObject.getString("mobilePhoneNumber"));
        intent.putExtra("company", jSONObject.getString("organization"));
        intent.putExtra("job_title", jSONObject.getString("title"));
        intent.putExtra("email", jSONObject.getString("email"));
        return intent;
    }

    private static String a(ContentValues contentValues) {
        String asString = contentValues.getAsString("data2");
        String asString2 = contentValues.getAsString("data5");
        String asString3 = contentValues.getAsString("data3");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(asString)) {
            sb.append(asString);
        }
        if (!TextUtils.isEmpty(asString2)) {
            sb.append(' ');
            sb.append(asString2);
        }
        if (!TextUtils.isEmpty(asString3)) {
            sb.append(' ');
            sb.append(asString3);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    private static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        ?? IsEmpty = TextUtils.isEmpty(str);
        ?? r1 = 0;
        try {
            if (IsEmpty != 0) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray.length <= 262144) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return byteArray;
                    }
                    RVLogger.e(f23957a, "Photo file too large for an IPC transaction, ignoring. file size = " + byteArray.length + ", max allowed = 262144");
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                } catch (IOException e) {
                    e = e;
                    RVLogger.e(f23957a, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = IsEmpty;
        }
    }
}
