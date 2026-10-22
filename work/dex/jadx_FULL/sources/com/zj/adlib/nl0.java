package com.zj.adlib;

import android.net.Uri;
import com.huachenjie.base.R;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/nl0;", "", "", "url", "", "a", "b", "Ljava/lang/String;", "WEIXIN_PRE", "APP_ID_KEY", "c", "PATH_KEY", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBannerJumpUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BannerJumpUtil.kt\ncom/huachenjie/base/util/BannerJumpUtil\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,72:1\n29#2:73\n*S KotlinDebug\n*F\n+ 1 BannerJumpUtil.kt\ncom/huachenjie/base/util/BannerJumpUtil\n*L\n35#1:73\n*E\n"})
public final class nl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final nl0 f43546a = new nl0();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String WEIXIN_PRE = "weixin";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String APP_ID_KEY = "appid";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String PATH_KEY = "path";

    public final boolean a(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.startsWith$default(url, WEIXIN_PRE, false, 2, (Object) null);
    }

    public final boolean b(@NotNull String url) {
        MatchResult matchResultFind$default;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        MatchResult matchResultFind$default2;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        Intrinsics.checkNotNullParameter(url, "url");
        String value = null;
        if (!StringsKt.startsWith$default(url, WEIXIN_PRE, false, 2, (Object) null)) {
            return false;
        }
        try {
            Regex regex = new Regex("\\*([^\\*]+)\\*");
            Uri uri = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
            String queryParameter = uri.getQueryParameter("appid");
            String value2 = (queryParameter == null || (matchResultFind$default2 = Regex.find$default(regex, queryParameter, 0, 2, (Object) null)) == null || (groups2 = matchResultFind$default2.getGroups()) == null || (matchGroup2 = groups2.get(1)) == null) ? null : matchGroup2.getValue();
            if (value2 != null) {
                queryParameter = value2;
            }
            String queryParameter2 = uri.getQueryParameter("path");
            if (queryParameter2 != null && (matchResultFind$default = Regex.find$default(regex, queryParameter2, 0, 2, (Object) null)) != null && (groups = matchResultFind$default.getGroups()) != null && (matchGroup = groups.get(1)) != null) {
                value = matchGroup.getValue();
            }
            if (value != null) {
                queryParameter2 = value;
            }
            IWXAPI iwxapiM = it9.a.m();
            if (!iwxapiM.isWXAppInstalled()) {
                fv5.a(R.string.base_mini_program_no_wechat);
                return true;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = queryParameter;
            req.path = queryParameter2;
            req.miniprogramType = 0;
            if (!iwxapiM.sendReq(req)) {
                fv5.a(R.string.base_mini_program_jump_error);
            }
            return true;
        } catch (Exception unused) {
            fv5.a(R.string.base_mini_program_params_error);
            return true;
        }
    }
}
