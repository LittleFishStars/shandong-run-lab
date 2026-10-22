package com.zj.adlib;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.core.content.FileProvider;
import com.alibaba.ariver.remotedebug.b.c;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.byazt.tk.AdBaseConstants;
import com.hjq.permissions.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class wc4 {
    public wc4() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Intent A(@Nullable String str, LinkedList<String> linkedList) {
        ArrayList arrayList = new ArrayList();
        if (linkedList != null) {
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                File fileO = i.O(it.next());
                if (fileO != null) {
                    arrayList.add(fileO);
                }
            }
        }
        return B(str, arrayList);
    }

    public static Intent B(@Nullable String str, List<File> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                Uri uriB = i.B(it.next());
                if (uriB != null) {
                    arrayList.add(uriB);
                }
            }
        }
        return z(str, arrayList);
    }

    public static Intent C(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        return l(Intent.createChooser(intent, ""), true);
    }

    public static Intent D() {
        Intent intent = new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        return intent.addFlags(268435456);
    }

    public static Intent E(String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        return intent.addFlags(268435456);
    }

    public static boolean F(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    @RequiresPermission(Permission.CALL_PHONE)
    public static Intent a(@NonNull String str) {
        return l(new Intent("android.intent.action.CALL", Uri.parse(WVUCWebViewClient.SCHEME_TEL + Uri.encode(str))), true);
    }

    public static Intent b(Uri uri) {
        return c(uri, false);
    }

    public static Intent c(Uri uri, boolean z) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(c.g, uri);
        intent.addFlags(1);
        return l(intent, z);
    }

    public static Intent d(String str, String str2) {
        return f(str, str2, null, false);
    }

    public static Intent e(String str, String str2, Bundle bundle) {
        return f(str, str2, bundle, false);
    }

    public static Intent f(String str, String str2, Bundle bundle, boolean z) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return l(intent, z);
    }

    public static Intent g(String str, String str2, boolean z) {
        return f(str, str2, null, z);
    }

    public static Intent h(@NonNull String str) {
        return l(new Intent("android.intent.action.DIAL", Uri.parse(WVUCWebViewClient.SCHEME_TEL + Uri.encode(str))), true);
    }

    public static Intent i(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
        intent.setFlags(1);
        return intent.addFlags(268435456);
    }

    public static Intent j(File file) {
        if (!i.t0(file)) {
            return null;
        }
        return i(FileProvider.getUriForFile(Utils.a(), Utils.a().getPackageName() + ".utilcode.provider", file));
    }

    public static Intent k(String str) {
        return j(i.O(str));
    }

    public static Intent l(Intent intent, boolean z) {
        return z ? intent.addFlags(268435456) : intent;
    }

    public static Intent m(String str) {
        return n(str, false);
    }

    public static Intent n(String str, boolean z) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return l(intent, z);
    }

    public static Intent o(String str) {
        String strY = i.Y(str);
        if (i.C0(strY)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, strY);
        return intent.addFlags(268435456);
    }

    public static Intent p(@NonNull String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(str)));
        intent.putExtra("sms_body", str2);
        return l(intent, true);
    }

    public static Intent q(Uri uri) {
        return w("", uri);
    }

    public static Intent r(File file) {
        return x("", file);
    }

    public static Intent s(String str) {
        return y("", str);
    }

    public static Intent t(ArrayList<Uri> arrayList) {
        return z("", arrayList);
    }

    public static Intent u(LinkedList<String> linkedList) {
        return A("", linkedList);
    }

    public static Intent v(List<File> list) {
        return B("", list);
    }

    public static Intent w(@Nullable String str, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        return l(Intent.createChooser(intent, ""), true);
    }

    public static Intent x(@Nullable String str, File file) {
        return w(str, i.B(file));
    }

    public static Intent y(@Nullable String str, String str2) {
        return x(str, i.O(str2));
    }

    public static Intent z(@Nullable String str, ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType("image/*");
        return l(Intent.createChooser(intent, ""), true);
    }
}
