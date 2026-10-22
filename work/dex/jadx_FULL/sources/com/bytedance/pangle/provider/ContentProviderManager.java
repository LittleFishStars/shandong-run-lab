package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.byazt.th.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    public static ContentProviderManager sInstance;
    public final Map<tt, c> mContentProviderMap = new HashMap();
    public final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    public final Map<String, ve> mSystemProviderInfoMap = new HashMap();

    @com.byazt.zqa.c(c = {0, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 1148, 1973})
    public static final class c {
        public final tt c;
        public final ProviderInfo tt;
        public final PluginContentProvider ve;

        public c(tt ttVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.tt = providerInfo;
            this.c = ttVar;
            this.ve = pluginContentProvider;
        }
    }

    @com.byazt.zqa.c(c = {0, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 1148, 1157})
    public static class tt {
        public final String c;
        public final String tt;
        public final String ve;

        public tt(String str, String str2, String str3) {
            this.c = str2;
            this.tt = str3;
            this.ve = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof tt) {
                tt ttVar = (tt) obj;
                if (TextUtils.equals(this.ve, ttVar.ve) && TextUtils.equals(this.tt, ttVar.tt) && TextUtils.equals(this.c, ttVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.c, this.tt, this.ve);
        }
    }

    @com.byazt.zqa.c(c = {0, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 1148, 1149})
    public static final class ve extends tt {
        public final ProviderInfo uj;

        public ve(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.uj = providerInfo;
        }
    }

    private ContentProviderManager() {
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    private void installProvider(String str, ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider pluginContentProviderInstantiateProvider = instantiateProvider(plugin, providerInfo);
                if (pluginContentProviderInstantiateProvider == null) {
                    return;
                }
                pluginContentProviderInstantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                tt ttVar = new tt(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(ttVar, new c(ttVar, providerInfo, pluginContentProviderInstantiateProvider));
            } catch (Exception e) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private PluginContentProvider instantiateProvider(Plugin plugin, ProviderInfo providerInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object objNewInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (!(objNewInstance instanceof FileProvider)) {
            return (PluginContentProvider) objNewInstance;
        }
        Bundle bundle = providerInfo.metaData;
        if (bundle == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(objNewInstance)));
        }
        com.byazt.uk.FileProvider.c(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
        return null;
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, str, strArr, str2);
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(tt ttVar) {
        c cVar = this.mContentProviderMap.get(ttVar);
        if (cVar == null) {
            return null;
        }
        return cVar.ve;
    }

    public Map<String, ve> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return a.a(contentResolver, uri, str);
    }

    public void initSystemContentProviderInfo() {
        String str;
        GlobalParam.getInstance().getReporter().c("zeus_stage_content_provider", "start");
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null && str.contains(".pangle.provider.proxy.")) {
                    try {
                        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String strC = uj.c(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(strC, new ve(Zeus.getAppApplication().getPackageName(), strC, providerInfo));
                            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return a.a(contentResolver, uri, contentValues, str);
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        String strC = uj.c(uj.c(Zeus.getAppApplication()));
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(strC, providerInfo, plugin);
        }
    }

    public boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> setKeySet = this.mAuthorityProcessNameMap.keySet();
        return setKeySet != null && setKeySet.contains(authority);
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return a.a(contentResolver, uri, bundle, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return a.b(contentResolver, uri, contentValues, bundle, str);
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }
}
