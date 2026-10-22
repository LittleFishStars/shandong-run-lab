package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alipay.sdk.m.y.k;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class AppLinkNavigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AppLinkResolver f21512a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f224a = "user_agent";
    public static final String b = "version";
    public static final String c = "referer_app_link";
    public static final String d = "app_name";
    public static final String e = "package";
    public static final String f = "1.0";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bolts.a f226a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Bundle f227b;

    public enum NavigationResult {
        FAILED(k.j, false),
        WEB(c.k, true),
        APP(NativeCallContext.DOMAIN_APP, true);

        private String code;
        private boolean succeeded;

        NavigationResult(String str, boolean z) {
        }

        public static NavigationResult valueOf(String str) {
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static NavigationResult[] valuesCustom() {
        }

        public String getCode() {
            return this.code;
        }

        public boolean isSucceeded() {
            return this.succeeded;
        }
    }

    public static class a implements Continuation<bolts.a, NavigationResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21513a;

        public a(Context context) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigationResult a(b<bolts.a> bVar) throws Exception {
        }
    }

    public AppLinkNavigation(bolts.a aVar, Bundle bundle, Bundle bundle2) {
    }

    public static AppLinkResolver d() {
        return f21512a;
    }

    public static AppLinkResolver h(Context context) {
    }

    public static NavigationResult j(Context context, bolts.a aVar) {
    }

    public static b<NavigationResult> k(Context context, Uri uri) {
    }

    public static b<NavigationResult> l(Context context, Uri uri, AppLinkResolver appLinkResolver) {
    }

    public static b<NavigationResult> m(Context context, String str) {
    }

    public static b<NavigationResult> n(Context context, String str, AppLinkResolver appLinkResolver) {
    }

    public static b<NavigationResult> o(Context context, URL url) {
    }

    public static b<NavigationResult> p(Context context, URL url, AppLinkResolver appLinkResolver) {
    }

    public static void r(AppLinkResolver appLinkResolver) {
        f21512a = appLinkResolver;
    }

    public final Bundle a(Context context) {
    }

    public bolts.a b() {
        return this.f226a;
    }

    public Bundle c() {
        return this.f227b;
    }

    public Bundle e() {
        return this.f225a;
    }

    public final JSONObject f(Bundle bundle) throws JSONException {
    }

    public final Object g(Object obj) throws JSONException {
    }

    public NavigationResult i(Context context) {
    }

    public final void q(Context context, Intent intent, NavigationResult navigationResult, JSONException jSONException) {
    }
}
