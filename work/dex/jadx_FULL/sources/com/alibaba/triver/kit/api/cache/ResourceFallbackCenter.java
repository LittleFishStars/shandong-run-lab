package com.alibaba.triver.kit.api.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ZipUtils;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.a.f;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.proxy.IZCacheProxy;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.uc.webview.export.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceFallbackCenter {
    private static final String CANAL_PKG_NAME = "plugin_taobao_3000000005260194";
    private static Map<String, Map<String, Resource>> officialResourceMap = new ConcurrentHashMap();
    private static JSONArray lastOrangeConfig = null;
    private static String templateVersion = null;
    private static Map<String, String> pluginVersionMap = new ConcurrentHashMap();

    public static synchronized void forceUpdateResourceFromOrange() {
        JSONArray shopPkgPreloadList = TBShopOrangeController.getShopPkgPreloadList();
        if (shopPkgPreloadList == null) {
            return;
        }
        JSONObject templatePkgInfo = getTemplatePkgInfo(shopPkgPreloadList);
        JSONArray pluginPkgArray = getPluginPkgArray(shopPkgPreloadList);
        if (templatePkgInfo != null) {
            ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).removeAZCacheRemote(templatePkgInfo.getString("name"));
        }
        if (pluginPkgArray != null) {
            for (Object obj : pluginPkgArray) {
                if (obj instanceof JSONObject) {
                    ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).removeAZCacheRemote(((JSONObject) obj).getString("name"));
                }
            }
        }
        updateResourceFromOrangeInner(shopPkgPreloadList);
    }

    public static String getAppxAssertResource(String str) {
        File file;
        Resource resource;
        InputStream stream;
        initLocalAppx();
        try {
            File localAppXParentFile = getLocalAppXParentFile();
            if (localAppXParentFile == null) {
                return null;
            }
            File[] fileArrListFiles = localAppXParentFile.listFiles();
            int length = fileArrListFiles.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    file = null;
                    break;
                }
                file = fileArrListFiles[i];
                if (file.getName().equals("66666692.tar")) {
                    break;
                }
                i++;
            }
            if (file == null || (resource = parseTarFileWithStream(new FileInputStream(file)).get(str)) == null || (stream = resource.getStream()) == null) {
                return null;
            }
            return IOUtils.read(stream);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getCanalResource(String str) {
        return getStringResourceFromResourceMapByType(TRiverConstants.CANAL_VIEW_TYPE, str);
    }

    private static File getLocalAppXParentFile() {
        Context applicationContextNullable = TRiverUtils.getApplicationContextNullable();
        if (applicationContextNullable == null) {
            return null;
        }
        return FileUtils.getLocalFilePath(applicationContextNullable, "local_APPX");
    }

    public static String getPluginId(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length >= 3) {
            return strArrSplit[2];
        }
        return null;
    }

    public static JSONArray getPluginPkgArray(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray == null) {
            return null;
        }
        for (Object obj : jSONArray) {
            if ((obj instanceof JSONObject) && isPluginPkg(((JSONObject) obj).getString("name"))) {
                jSONArray2.add(obj);
            }
        }
        return jSONArray2;
    }

    public static String getPluginResource(String str, String str2) {
        return getStringResourceFromResourceMapByType(str, str2);
    }

    public static String getPluginVersion(String str) {
        return pluginVersionMap.get(str);
    }

    private static String getStringResourceFromResourceMapByType(String str, String str2) {
        Resource resource;
        Map<String, Resource> map = officialResourceMap.get(str);
        if (map != null && (resource = map.get(str2)) != null) {
            try {
                byte[] bytes = resource.getBytes();
                if (bytes != null) {
                    return new String(bytes, Charset.forName("UTF-8"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject getTemplatePkgInfo(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        for (Object obj : jSONArray) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (isTemplatePkg(jSONObject.getString("name"))) {
                    return jSONObject;
                }
            }
        }
        return null;
    }

    public static String getTemplatePkgResource(String str) {
        return getStringResourceFromResourceMapByType("template", str);
    }

    public static String getTemplateVersion() {
        return templateVersion;
    }

    public static WebResourceResponse getWebRespByString(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(str2, str3, new ByteArrayInputStream(str.getBytes(Charset.forName(str3))));
        HashMap map = new HashMap();
        map.put("Access-Control-Allow-Origin", "*");
        map.put("Cache-Control", "no-cache");
        webResourceResponse.setResponseHeaders(map);
        return webResourceResponse;
    }

    private static void initLocalAppx() throws Throwable {
        Context applicationContextNullable = TRiverUtils.getApplicationContextNullable();
        if (applicationContextNullable == null) {
            return;
        }
        File localFilePath = FileUtils.getLocalFilePath(applicationContextNullable, "local_APPX");
        if (localFilePath.isFile()) {
            return;
        }
        if (localFilePath.exists() || localFilePath.mkdir()) {
            try {
                ZipUtils.unZip(applicationContextNullable.getResources().getAssets().open("66666692.amr"), localFilePath.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isPluginPkg(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("plugin");
    }

    public static boolean isTemplatePkg(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("template");
    }

    private static void parsePkgResource(String str, String str2) throws Throwable {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str2) || (fileArrListFiles = new File(str2).listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.getName().endsWith("tar")) {
                String absolutePath = file.getAbsolutePath();
                ParseContext parseContext = new ParseContext();
                parseContext.packagePath = absolutePath;
                HashMap map = new HashMap();
                try {
                    PackageParseUtils.fastReadTarIntoMemory(map, absolutePath, parseContext);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (map.size() > 0) {
                    officialResourceMap.put(str, map);
                }
                Log.d("ZCacheOfficialCenter", "resource map size : " + map.size());
                return;
            }
        }
    }

    private static void parsePluginVersion(String str, String str2) {
        String versionInManifestXml = parseVersionInManifestXml(str2);
        if (versionInManifestXml != null) {
            pluginVersionMap.put(str, versionInManifestXml);
        }
    }

    private static Map<String, Resource> parseTarFileWithStream(InputStream inputStream) {
        ParseContext parseContext = new ParseContext();
        HashMap map = new HashMap();
        if (inputStream == null) {
            return map;
        }
        try {
            PackageParseUtils.readTarStreamIntoMemory(map, new f(inputStream), parseContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void parseTemplateVersion(String str) {
        templateVersion = parseVersionInManifestXml(str);
    }

    private static String parseVersionInManifestXml(String str) {
        File[] fileArrListFiles;
        Node nodeItem;
        if (TextUtils.isEmpty(str) || (fileArrListFiles = new File(str).listFiles()) == null) {
            return null;
        }
        int length = fileArrListFiles.length;
        for (int i = 0; i < length; i++) {
            File file = fileArrListFiles[i];
            if ("Manifest.xml".equals(file.getName())) {
                try {
                    NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("version");
                    if (elementsByTagName != null && elementsByTagName.getLength() >= 1 && (nodeItem = elementsByTagName.item(0)) != null) {
                        return nodeItem.getTextContent();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String readAssert(String str) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return null;
        }
        return readAssert(str, rVEnvironmentService.getApplicationContext());
    }

    public static synchronized void updateCanalPackage() {
        parsePkgResource(TRiverConstants.CANAL_VIEW_TYPE, updateSepecficNamePackage(CANAL_PKG_NAME));
    }

    public static synchronized void updateResourceFromOrange() {
        JSONArray shopPkgPreloadList = TBShopOrangeController.getShopPkgPreloadList();
        if (shopPkgPreloadList == null) {
            return;
        }
        if (shopPkgPreloadList.equals(lastOrangeConfig)) {
            return;
        }
        updateResourceFromOrangeInner(shopPkgPreloadList);
    }

    private static synchronized void updateResourceFromOrangeInner(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        JSONObject templatePkgInfo = getTemplatePkgInfo(jSONArray);
        JSONArray pluginPkgArray = getPluginPkgArray(jSONArray);
        if (templatePkgInfo != null) {
            String string = templatePkgInfo.getString("name");
            if (TBShopOrangeController.enableShopPkgPreload()) {
                ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).updatePackRemote(string, null, 6);
            }
            String miniAppFilePath = ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).getMiniAppFilePath(string, null);
            parsePkgResource("template", miniAppFilePath);
            parseTemplateVersion(miniAppFilePath);
        }
        if (pluginPkgArray != null) {
            for (Object obj : pluginPkgArray) {
                if (obj instanceof JSONObject) {
                    String string2 = ((JSONObject) obj).getString("name");
                    ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).updatePackRemote(string2, null, 6);
                    String miniAppFilePath2 = ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).getMiniAppFilePath(string2, null);
                    String pluginId = getPluginId(string2);
                    if (pluginId != null) {
                        parsePkgResource(pluginId, miniAppFilePath2);
                        parsePluginVersion(pluginId, miniAppFilePath2);
                    }
                }
            }
        }
        lastOrangeConfig = jSONArray;
    }

    private static String updateSepecficNamePackage(String str) {
        ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).updatePackRemote(str, null, 6);
        return ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).getMiniAppFilePath(str, null);
    }

    public static String readAssert(String str, Context context) {
        if (context == null) {
            return null;
        }
        try {
            return IOUtils.read(context.getAssets().open(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
