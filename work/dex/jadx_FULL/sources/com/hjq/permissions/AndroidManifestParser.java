package com.hjq.permissions;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class AndroidManifestParser {
    private static final String ANDROID_MANIFEST_FILE_NAME = "AndroidManifest.xml";
    private static final String ANDROID_NAMESPACE_URI = "http://schemas.android.com/apk/res/android";
    private static final String ATTR_MAX_SDK_VERSION = "maxSdkVersion";
    private static final String ATTR_MIN_SDK_VERSION = "minSdkVersion";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE = "package";
    private static final String ATTR_PERMISSION = "permission";
    private static final String ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE = "requestLegacyExternalStorage";
    private static final String ATTR_SUPPORTS_PICTURE_IN_PICTURE = "supportsPictureInPicture";
    private static final String ATTR_USES_PERMISSION_FLAGS = "usesPermissionFlags";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_ACTIVITY_ALIAS = "activity-alias";
    private static final String TAG_APPLICATION = "application";
    private static final String TAG_MANIFEST = "manifest";
    private static final String TAG_SERVICE = "service";
    private static final String TAG_USES_PERMISSION = "uses-permission";
    private static final String TAG_USES_PERMISSION_SDK_23 = "uses-permission-sdk-23";
    private static final String TAG_USES_PERMISSION_SDK_M = "uses-permission-sdk-m";
    private static final String TAG_USES_SDK = "uses-sdk";

    private AndroidManifestParser() {
    }

    @NonNull
    private static AndroidManifestInfo.ActivityInfo parseActivityFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ActivityInfo activityInfo = new AndroidManifestInfo.ActivityInfo();
        activityInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        activityInfo.supportsPictureInPicture = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_SUPPORTS_PICTURE_IN_PICTURE, false);
        return activityInfo;
    }

    @NonNull
    public static AndroidManifestInfo parseAndroidManifest(@NonNull Context context, int i) throws XmlPullParserException, IOException {
        AndroidManifestInfo androidManifestInfo = new AndroidManifestInfo();
        XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser(i, ANDROID_MANIFEST_FILE_NAME);
        do {
            try {
                if (xmlResourceParserOpenXmlResourceParser.getEventType() == 2) {
                    String name = xmlResourceParserOpenXmlResourceParser.getName();
                    if (TextUtils.equals(TAG_MANIFEST, name)) {
                        androidManifestInfo.packageName = xmlResourceParserOpenXmlResourceParser.getAttributeValue(null, "package");
                    }
                    if (TextUtils.equals(TAG_USES_SDK, name)) {
                        androidManifestInfo.usesSdkInfo = parseUsesSdkFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (TextUtils.equals(TAG_USES_PERMISSION, name) || TextUtils.equals(TAG_USES_PERMISSION_SDK_23, name) || TextUtils.equals(TAG_USES_PERMISSION_SDK_M, name)) {
                        androidManifestInfo.permissionInfoList.add(parsePermissionFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (TextUtils.equals("application", name)) {
                        androidManifestInfo.applicationInfo = parseApplicationFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (TextUtils.equals("activity", name) || TextUtils.equals(TAG_ACTIVITY_ALIAS, name)) {
                        androidManifestInfo.activityInfoList.add(parseActivityFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (TextUtils.equals("service", name)) {
                        androidManifestInfo.serviceInfoList.add(parseServerFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlResourceParserOpenXmlResourceParser != null) {
                        try {
                            xmlResourceParserOpenXmlResourceParser.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } while (xmlResourceParserOpenXmlResourceParser.next() != 1);
        xmlResourceParserOpenXmlResourceParser.close();
        return androidManifestInfo;
    }

    @NonNull
    private static AndroidManifestInfo.ApplicationInfo parseApplicationFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ApplicationInfo applicationInfo = new AndroidManifestInfo.ApplicationInfo();
        applicationInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        applicationInfo.requestLegacyExternalStorage = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE, false);
        return applicationInfo;
    }

    @NonNull
    private static AndroidManifestInfo.PermissionInfo parsePermissionFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.PermissionInfo permissionInfo = new AndroidManifestInfo.PermissionInfo();
        permissionInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        permissionInfo.maxSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MAX_SDK_VERSION, Integer.MAX_VALUE);
        permissionInfo.usesPermissionFlags = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_USES_PERMISSION_FLAGS, 0);
        return permissionInfo;
    }

    @NonNull
    private static AndroidManifestInfo.ServiceInfo parseServerFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ServiceInfo serviceInfo = new AndroidManifestInfo.ServiceInfo();
        serviceInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "name");
        serviceInfo.permission = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, "permission");
        return serviceInfo;
    }

    @NonNull
    private static AndroidManifestInfo.UsesSdkInfo parseUsesSdkFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.UsesSdkInfo usesSdkInfo = new AndroidManifestInfo.UsesSdkInfo();
        usesSdkInfo.minSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MIN_SDK_VERSION, 0);
        return usesSdkInfo;
    }
}
