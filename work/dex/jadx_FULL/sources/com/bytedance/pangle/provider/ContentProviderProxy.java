package com.bytedance.pangle.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.byazt.uq.da;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.FileNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class ContentProviderProxy extends ContentProvider {
    public ContentProviderManager mPluginProviderManager;

    private PluginContentProvider obtainPluginProvider(Uri uri, String str) throws JSONException {
        return obtainPluginProvider(uri, str, null);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        waitInit();
        try {
            String string = bundle.getString("provider_params", "");
            Uri uri = Uri.parse(bundle.getString(ContentProviderManager.PROVIDER_PROXY_URI, ""));
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority(), string);
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.call(str, str2, bundle);
            }
            return null;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#call(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        waitInit();
        if (uri == null) {
            return -1;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.delete(pluginContentProviderObtainPluginProvider.pluginUri, str, strArr);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.getType(pluginContentProviderObtainPluginProvider.pluginUri);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#getType className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.insert(pluginContentProviderObtainPluginProvider.pluginUri, contentValues);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mPluginProviderManager = ContentProviderManager.getInstance();
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openAssetFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openAssetFile(pluginContentProviderObtainPluginProvider.pluginUri, str);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openAssetFile(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openFile(pluginContentProviderObtainPluginProvider.pluginUri, str);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openFile(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @NonNull
    public <T> ParcelFileDescriptor openPipeHelper(@NonNull Uri uri, @NonNull String str, @Nullable Bundle bundle, @Nullable T t, @NonNull ContentProvider.PipeDataWriter<T> pipeDataWriter) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openPipeHelper(pluginContentProviderObtainPluginProvider.pluginUri, str, bundle, t, pipeDataWriter);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openPipeHelper(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NonNull Uri uri, @NonNull String str, @Nullable Bundle bundle) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openTypedAssetFile(pluginContentProviderObtainPluginProvider.pluginUri, str, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openTypedAssetFile(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.query(pluginContentProviderObtainPluginProvider.pluginUri, strArr, str, strArr2, str2);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        waitInit();
        if (uri == null) {
            return 0;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.update(pluginContentProviderObtainPluginProvider.pluginUri, contentValues, str, strArr);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    public void waitInit() {
        Zeus.waitInit(-1);
    }

    private PluginContentProvider obtainPluginProvider(Uri uri, String str, String str2) throws JSONException {
        String queryParameter = uri.getQueryParameter("provider_params");
        Uri uri2 = null;
        if (queryParameter == null) {
            return null;
        }
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = da.tt(queryParameter);
        }
        JSONObject jSONObject = new JSONObject(queryParameter);
        String strOptString = jSONObject.optString(ContentProviderManager.PLUGIN_PROCESS_NAME);
        String strOptString2 = jSONObject.optString("plugin_pkg_name");
        String strOptString3 = jSONObject.optString("uri");
        Zeus.loadPlugin(strOptString2);
        if (!TextUtils.isEmpty(strOptString3)) {
            uri2 = Uri.parse(strOptString3);
            str2 = uri2.getAuthority();
        }
        if (str2 == null) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] plugin Authority is null !!! plugin provider can not find !!");
        }
        PluginContentProvider pluginProvider = this.mPluginProviderManager.getPluginProvider(new ContentProviderManager.tt(strOptString2, strOptString, str2));
        pluginProvider.pluginUri = uri2;
        return pluginProvider;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable Bundle bundle) {
        waitInit();
        if (uri == null) {
            return -1;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.delete(pluginContentProviderObtainPluginProvider.pluginUri, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.insert(pluginContentProviderObtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openAssetFile(@NonNull Uri uri, @NonNull String str, @Nullable CancellationSignal cancellationSignal) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openAssetFile(pluginContentProviderObtainPluginProvider.pluginUri, str, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openAssetFile(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str, @Nullable CancellationSignal cancellationSignal) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openFile(pluginContentProviderObtainPluginProvider.pluginUri, str, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openFile(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NonNull Uri uri, @NonNull String str, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) throws FileNotFoundException {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.openTypedAssetFile(pluginContentProviderObtainPluginProvider.pluginUri, str, bundle, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#openTypedAssetFile(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, @Nullable CancellationSignal cancellationSignal) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.query(pluginContentProviderObtainPluginProvider.pluginUri, strArr, str, strArr2, str2, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(6 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable Bundle bundle) {
        waitInit();
        if (uri == null) {
            return 0;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.update(pluginContentProviderObtainPluginProvider.pluginUri, contentValues, bundle);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        try {
            String string = bundle.getString("provider_params", "");
            Uri uri = Uri.parse(bundle.getString(ContentProviderManager.PROVIDER_PROXY_URI, ""));
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority(), string);
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.call(string, str2, str3, bundle);
            }
            return null;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#call(4 params-Added in API level 29) className=" + getClass().getSimpleName() + ",exception:", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    @RequiresApi(api = 26)
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) {
        waitInit();
        if (uri == null) {
            return null;
        }
        try {
            PluginContentProvider pluginContentProviderObtainPluginProvider = obtainPluginProvider(uri, uri.getAuthority());
            if (pluginContentProviderObtainPluginProvider != null) {
                return pluginContentProviderObtainPluginProvider.query(pluginContentProviderObtainPluginProvider.pluginUri, strArr, bundle, cancellationSignal);
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        }
        return null;
    }
}
