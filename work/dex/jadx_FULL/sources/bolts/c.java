package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zj.adlib.fe1;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c implements AppLinkResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21529a = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    public static final String b = "Prefer-Html-Meta-Tags";
    public static final String c = "al";
    public static final String d = "value";
    public static final String e = "app_name";
    public static final String f = "class";
    public static final String g = "package";
    public static final String h = "url";
    public static final String i = "should_fallback";
    public static final String j = "url";
    public static final String k = "web";
    public static final String l = "android";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f258a;

    public class a implements Continuation<JSONArray, bolts.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f21530a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ c f259a;

        public a(c cVar, Uri uri) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bolts.a a(bolts.b<JSONArray> bVar) throws Exception {
        }
    }

    public class b implements Continuation<Void, bolts.b<JSONArray>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f21531a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ c f260a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ fe1 f261a;
        public final /* synthetic */ fe1 b;

        public class a extends WebViewClient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f21532a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f262a;

            public a(b bVar) {
            }

            public final void a(WebView webView) {
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
            }
        }

        /* JADX INFO: renamed from: bolts.c$b$b, reason: collision with other inner class name */
        public class C0034b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bolts.b.k f21533a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ b f263a;

            public C0034b(b bVar, bolts.b.k kVar) {
            }

            @JavascriptInterface
            public void setValue(String str) {
            }
        }

        public b(c cVar, fe1 fe1Var, Uri uri, fe1 fe1Var2) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bolts.b<JSONArray> a(bolts.b<Void> bVar) throws Exception {
        }
    }

    /* JADX INFO: renamed from: bolts.c$c, reason: collision with other inner class name */
    public class CallableC0035c implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f21534a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ c f264a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ fe1 f265a;
        public final /* synthetic */ fe1 b;

        public CallableC0035c(c cVar, Uri uri, fe1 fe1Var, fe1 fe1Var2) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
        }
    }

    public c(Context context) {
    }

    public static List<Map<String, Object>> f(Map<String, Object> map, String str) {
    }

    public static bolts.a g(Map<String, Object> map, Uri uri) {
    }

    public static Map<String, Object> h(JSONArray jSONArray) throws JSONException {
    }

    public static String i(URLConnection uRLConnection) throws IOException {
    }

    public static Uri j(String str) {
    }

    @Override // bolts.AppLinkResolver
    public bolts.b<bolts.a> a(Uri uri) {
    }
}
