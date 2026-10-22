package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class PermissionModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<PermissionModel> CREATOR = new Parcelable.Creator<PermissionModel>() { // from class: com.alibaba.ariver.resource.api.models.PermissionModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionModel createFromParcel(Parcel parcel) {
            return new PermissionModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionModel[] newArray(int i) {
            return new PermissionModel[i];
        }
    };
    private static final String KEY_ENABLE_PROXY = "enableProxy";
    private static final String KEY_ENABLE_PROXY_LEGACY = "Enable_Proxy";
    private static final String KEY_EVENT_LIST = "eventList";
    private static final String KEY_EVENT_LIST_LEGACY = "EVENT_List";
    private static final String KEY_FORCE_USE_SSL = "forceUseSsl";
    private static final String KEY_FORCE_USE_SSL_LEGACY = "ForceUseSSL";
    private static final String KEY_HTTP_RES_MIME_LIST = "httpLinkSubResMimeList";
    private static final String KEY_HTTP_RES_MIME_LIST_LEGACY = "HttpLink_SubResMimeList";
    private static final String KEY_IGNORECHECK_MTOP_API = "ignorePermissionCheckMtopApi";
    private static final String KEY_IGNORE_PERMISSION_CHECK = "ignorePermissionCheck";
    private static final String KEY_JSAPI_LIST = "jsapiNameList";
    private static final String KEY_JSAPI_LIST_LEGACY = "JSAPI_List";
    private static final String KEY_JSAPI_SP_CONFIG = "jsapiSpConfig";
    private static final String KEY_JSAPI_SP_CONFIG_LEGACY = "JSAPI_SP_Config";
    private static final String KEY_NATIVE_API_SCOPE_CONFIG = "nativeApiScopeConfig";
    private static final String KEY_NATIVE_API_USER_AUTH = "nativeApiUserAuth";
    private static final String KEY_SUB_RES_MIME_LIST = "validSubResMimeList";
    private static final String KEY_SUB_RES_MIME_LIST_LEGACY = "Valid_SubResMimeList";
    private static final String KEY_VALID_DOMAIN = "validDomain";
    private static final String KEY_WEBVIEW_CONFIG = "webViewConfig";
    private static final String KEY_WEBVIEW_CONFIG_LEGACY = "Webview_Config";
    private static final long serialVersionUID = 7945824571470124314L;

    @JSONField(name = "enableProxy")
    private String enableProxy;

    @JSONField(name = KEY_EVENT_LIST)
    private Set<String> eventList;

    @JSONField(name = KEY_FORCE_USE_SSL)
    private String forceUseSsl;

    @JSONField(name = KEY_HTTP_RES_MIME_LIST)
    private Set<String> httpLinkSubResMimeList;

    @JSONField(name = KEY_IGNORE_PERMISSION_CHECK)
    private Set<String> ignorePermissionCheck;

    @JSONField(name = KEY_IGNORECHECK_MTOP_API)
    private Set<String> ignorePermissionCheckMtopApi;

    @JSONField(name = KEY_JSAPI_LIST)
    private Set<String> jsapiList;

    @JSONField(name = KEY_NATIVE_API_SCOPE_CONFIG)
    private JSONObject nativeApiScopeConfig;

    @JSONField(name = KEY_NATIVE_API_USER_AUTH)
    private JSONObject nativeApiUserAuth;

    @JSONField(deserialize = false, serialize = false)
    private Map<String, PermissionModel> pluginPermissions;

    @JSONField(name = KEY_JSAPI_SP_CONFIG)
    private JSONObject specialConfigs;

    @JSONField(name = "validDomain")
    private Set<String> validDomains;

    @JSONField(name = KEY_SUB_RES_MIME_LIST)
    private Set<String> validSubResMimeList;

    @JSONField(name = KEY_WEBVIEW_CONFIG)
    private JSONObject webviewConfigs;

    public PermissionModel() {
    }

    public static PermissionModel generateFromJSON(byte[] bArr) {
        return generateFromJSON(JSONUtils.parseObject(bArr));
    }

    private void readToArray(Set<String> set, Parcel parcel) {
        if (parcel.readByte() == 1) {
            for (Object obj : parcel.readArray(PermissionModel.class.getClassLoader())) {
                set.add((String) obj);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEnableProxy() {
        return this.enableProxy;
    }

    public Set<String> getEventList() {
        return this.eventList;
    }

    public String getForceUseSsl() {
        return this.forceUseSsl;
    }

    public Set<String> getHttpLinkSubResMimeList() {
        return this.httpLinkSubResMimeList;
    }

    public Set<String> getIgnorePermissionCheck() {
        return this.ignorePermissionCheck;
    }

    public Set<String> getIgnorePermissionCheckMtopApi() {
        return this.ignorePermissionCheckMtopApi;
    }

    public Set<String> getJsapiList() {
        return this.jsapiList;
    }

    public JSONObject getNativeApiScopeConfig() {
        return this.nativeApiScopeConfig;
    }

    public JSONObject getNativeApiUserAuth() {
        return this.nativeApiUserAuth;
    }

    @JSONField(deserialize = false, serialize = false)
    public Map<String, PermissionModel> getPluginPermissions() {
        return this.pluginPermissions;
    }

    public JSONObject getSpecialConfigs() {
        return this.specialConfigs;
    }

    public Set<String> getValidDomains() {
        return this.validDomains;
    }

    public Set<String> getValidSubResMimeList() {
        return this.validSubResMimeList;
    }

    public JSONObject getWebviewConfigs() {
        return this.webviewConfigs;
    }

    public void setEnableProxy(String str) {
        this.enableProxy = str;
    }

    public void setEventList(Set<String> set) {
        this.eventList = set;
    }

    public void setForceUseSsl(String str) {
        this.forceUseSsl = str;
    }

    public void setHttpLinkSubResMimeList(Set<String> set) {
        this.httpLinkSubResMimeList = set;
    }

    public void setIgnorePermissionCheck(Set<String> set) {
        this.ignorePermissionCheck = set;
    }

    public void setIgnorePermissionCheckMtopApi(Set<String> set) {
        this.ignorePermissionCheckMtopApi = set;
    }

    public void setJsapiList(Set<String> set) {
        this.jsapiList = set;
    }

    public void setNativeApiScopeConfig(JSONObject jSONObject) {
        this.nativeApiScopeConfig = jSONObject;
    }

    public void setNativeApiUserAuth(JSONObject jSONObject) {
        this.nativeApiUserAuth = jSONObject;
    }

    @JSONField(deserialize = false, serialize = false)
    public void setPluginPermissions(Map<String, PermissionModel> map) {
        this.pluginPermissions = map;
    }

    public void setSpecialConfigs(JSONObject jSONObject) {
        this.specialConfigs = jSONObject;
    }

    public void setValidDomains(Set<String> set) {
        this.validDomains = set;
    }

    public void setValidSubResMimeList(Set<String> set) {
        this.validSubResMimeList = set;
    }

    public void setWebviewConfigs(JSONObject jSONObject) {
        this.webviewConfigs = jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PermissionModel{validDomains=");
        sb.append(this.validDomains);
        sb.append(", ignorePermissionCheckMtopApi=");
        sb.append(this.ignorePermissionCheckMtopApi);
        sb.append(", specialConfigs=");
        sb.append(this.specialConfigs);
        sb.append(", webviewConfigs=");
        sb.append(this.webviewConfigs);
        sb.append(", jsapiList=$list(");
        Set<String> set = this.jsapiList;
        sb.append(set == null ? 0 : set.size());
        sb.append(")");
        sb.append(", ignorePermissionCheck=");
        sb.append(this.ignorePermissionCheck);
        sb.append(", nativeApiUserAuth=");
        sb.append(this.nativeApiUserAuth);
        sb.append(", nativeApiScopeConfig=");
        sb.append(this.nativeApiScopeConfig);
        sb.append(", validSubResMimeList=");
        sb.append(this.validSubResMimeList);
        sb.append(", httpLinkSubResMimeList=");
        sb.append(this.httpLinkSubResMimeList);
        sb.append(", enableProxy='");
        sb.append(this.enableProxy);
        sb.append('\'');
        sb.append(", eventList=");
        sb.append(this.eventList);
        sb.append(", forceUseSsl=");
        sb.append(this.forceUseSsl);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.validDomains != null ? 1 : 0));
        Set<String> set = this.validDomains;
        if (set != null) {
            parcel.writeArray(set.toArray());
        }
        parcel.writeSerializable(this.specialConfigs);
        parcel.writeSerializable(this.webviewConfigs);
        parcel.writeByte((byte) (this.jsapiList != null ? 1 : 0));
        Set<String> set2 = this.jsapiList;
        if (set2 != null) {
            parcel.writeArray(set2.toArray());
        }
        parcel.writeByte((byte) (this.ignorePermissionCheck != null ? 1 : 0));
        Set<String> set3 = this.ignorePermissionCheck;
        if (set3 != null) {
            parcel.writeArray(set3.toArray());
        }
        parcel.writeByte((byte) (this.ignorePermissionCheckMtopApi != null ? 1 : 0));
        Set<String> set4 = this.ignorePermissionCheckMtopApi;
        if (set4 != null) {
            parcel.writeArray(set4.toArray());
        }
        parcel.writeSerializable(this.nativeApiUserAuth);
        parcel.writeSerializable(this.nativeApiScopeConfig);
        parcel.writeByte((byte) (this.validSubResMimeList != null ? 1 : 0));
        Set<String> set5 = this.validSubResMimeList;
        if (set5 != null) {
            parcel.writeArray(set5.toArray());
        }
        parcel.writeString(this.enableProxy);
        parcel.writeByte((byte) (this.httpLinkSubResMimeList != null ? 1 : 0));
        Set<String> set6 = this.httpLinkSubResMimeList;
        if (set6 != null) {
            parcel.writeArray(set6.toArray());
        }
        parcel.writeByte((byte) (this.eventList != null ? 1 : 0));
        Set<String> set7 = this.eventList;
        if (set7 != null) {
            parcel.writeArray(set7.toArray());
        }
        parcel.writeString(this.forceUseSsl);
        Map<String, PermissionModel> map = this.pluginPermissions;
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size > 0) {
            String[] strArr = new String[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            int i2 = 0;
            for (Map.Entry<String, PermissionModel> entry : this.pluginPermissions.entrySet()) {
                strArr[i2] = entry.getKey();
                parcelableArr[i2] = entry.getValue();
                i2++;
            }
            parcel.writeStringArray(strArr);
            parcel.writeParcelableArray(parcelableArr, 0);
        }
    }

    public PermissionModel(Parcel parcel) {
        HashSet hashSet = new HashSet();
        this.validDomains = hashSet;
        readToArray(hashSet, parcel);
        this.specialConfigs = (JSONObject) parcel.readSerializable();
        this.webviewConfigs = (JSONObject) parcel.readSerializable();
        HashSet hashSet2 = new HashSet();
        this.jsapiList = hashSet2;
        readToArray(hashSet2, parcel);
        HashSet hashSet3 = new HashSet();
        this.ignorePermissionCheck = hashSet3;
        readToArray(hashSet3, parcel);
        HashSet hashSet4 = new HashSet();
        this.ignorePermissionCheckMtopApi = hashSet4;
        readToArray(hashSet4, parcel);
        this.nativeApiUserAuth = (JSONObject) parcel.readSerializable();
        this.nativeApiScopeConfig = (JSONObject) parcel.readSerializable();
        HashSet hashSet5 = new HashSet();
        this.validSubResMimeList = hashSet5;
        readToArray(hashSet5, parcel);
        this.enableProxy = parcel.readString();
        HashSet hashSet6 = new HashSet();
        this.httpLinkSubResMimeList = hashSet6;
        readToArray(hashSet6, parcel);
        HashSet hashSet7 = new HashSet();
        this.eventList = hashSet7;
        readToArray(hashSet7, parcel);
        this.forceUseSsl = parcel.readString();
        this.pluginPermissions = new HashMap();
        int i = parcel.readInt();
        if (i > 0) {
            String[] strArr = new String[i];
            parcel.readStringArray(strArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(PermissionModel.class.getClassLoader());
            for (int i2 = 0; i2 < i; i2++) {
                Parcelable parcelable = parcelableArray[i2];
                if (parcelable instanceof PermissionModel) {
                    this.pluginPermissions.put(strArr[i2], (PermissionModel) parcelable);
                }
            }
        }
    }

    public static PermissionModel generateFromJSON(String str) {
        return generateFromJSON(JSONUtils.parseObject(str));
    }

    public static PermissionModel generateFromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PermissionModel permissionModel = new PermissionModel();
        JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "validDomain", null);
        if (jSONArray != null) {
            HashSet hashSet = new HashSet();
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(jSONArray.getString(i));
            }
            permissionModel.setValidDomains(hashSet);
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, KEY_JSAPI_SP_CONFIG, null);
        if (jSONObject2 == null) {
            jSONObject2 = JSONUtils.getJSONObject(jSONObject, "JSAPI_SP_Config", null);
        }
        if (jSONObject2 != null) {
            permissionModel.setSpecialConfigs(jSONObject2);
        }
        JSONObject jSONObject3 = JSONUtils.getJSONObject(jSONObject, KEY_WEBVIEW_CONFIG, null);
        if (jSONObject3 == null) {
            jSONObject3 = JSONUtils.getJSONObject(jSONObject, "Webview_Config", null);
        }
        if (jSONObject3 != null) {
            permissionModel.setWebviewConfigs(jSONObject3);
        }
        JSONArray jSONArray2 = JSONUtils.getJSONArray(jSONObject, KEY_JSAPI_LIST, null);
        if (jSONArray2 == null) {
            jSONArray2 = JSONUtils.getJSONArray(jSONObject, "JSAPI_List", null);
        }
        if (jSONArray2 != null) {
            HashSet hashSet2 = new HashSet();
            int size2 = jSONArray2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                hashSet2.add(jSONArray2.getString(i2));
            }
            permissionModel.setJsapiList(hashSet2);
        }
        JSONArray jSONArray3 = JSONUtils.getJSONArray(jSONObject, KEY_IGNORE_PERMISSION_CHECK, null);
        if (jSONArray3 != null) {
            HashSet hashSet3 = new HashSet();
            int size3 = jSONArray3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                hashSet3.add(jSONArray3.getString(i3));
            }
            permissionModel.setIgnorePermissionCheck(hashSet3);
        }
        JSONObject jSONObject4 = JSONUtils.getJSONObject(jSONObject, KEY_NATIVE_API_USER_AUTH, null);
        if (jSONObject4 != null) {
            permissionModel.setNativeApiUserAuth(jSONObject4);
        }
        JSONObject jSONObject5 = JSONUtils.getJSONObject(jSONObject, KEY_NATIVE_API_SCOPE_CONFIG, null);
        if (jSONObject5 != null) {
            permissionModel.setNativeApiScopeConfig(jSONObject5);
        }
        JSONArray jSONArray4 = JSONUtils.getJSONArray(jSONObject, KEY_EVENT_LIST, null);
        if (jSONArray4 == null) {
            jSONArray4 = JSONUtils.getJSONArray(jSONObject, "EVENT_List", null);
        }
        if (jSONArray4 != null) {
            HashSet hashSet4 = new HashSet();
            int size4 = jSONArray4.size();
            for (int i4 = 0; i4 < size4; i4++) {
                hashSet4.add(jSONArray4.getString(i4));
            }
            permissionModel.setEventList(hashSet4);
        }
        String string = JSONUtils.getString(jSONObject, "enableProxy", null);
        if (string == null) {
            string = JSONUtils.getString(jSONObject, "Enable_Proxy", null);
        }
        if (string != null) {
            permissionModel.setEnableProxy(string);
        }
        JSONArray jSONArray5 = JSONUtils.getJSONArray(jSONObject, KEY_SUB_RES_MIME_LIST, null);
        if (jSONArray5 == null) {
            jSONArray5 = JSONUtils.getJSONArray(jSONObject, "Valid_SubResMimeList", null);
        }
        if (jSONArray5 != null) {
            HashSet hashSet5 = new HashSet();
            int size5 = jSONArray5.size();
            for (int i5 = 0; i5 < size5; i5++) {
                hashSet5.add(jSONArray5.getString(i5));
            }
            permissionModel.setValidSubResMimeList(hashSet5);
        }
        JSONArray jSONArray6 = JSONUtils.getJSONArray(jSONObject, KEY_HTTP_RES_MIME_LIST, null);
        if (jSONArray6 == null) {
            jSONArray6 = JSONUtils.getJSONArray(jSONObject, "HttpLink_SubResMimeList", null);
        }
        if (jSONArray6 != null) {
            HashSet hashSet6 = new HashSet();
            int size6 = jSONArray6.size();
            for (int i6 = 0; i6 < size6; i6++) {
                hashSet6.add(jSONArray6.getString(i6));
            }
            permissionModel.setHttpLinkSubResMimeList(hashSet6);
        }
        String string2 = JSONUtils.getString(jSONObject, KEY_FORCE_USE_SSL, null);
        if (string2 == null) {
            string2 = JSONUtils.getString(jSONObject, "ForceUseSSL", null);
        }
        if (string2 != null) {
            permissionModel.setForceUseSsl(string2);
        }
        return permissionModel;
    }
}
