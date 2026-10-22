package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.model.WxClickDataModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t0 f23264a = null;
    public static String b = "t0";

    public class a implements AccessibilityService.TakeScreenshotCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23265a;

        public a(String str) {
            this.f23265a = str;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i) {
            h2.c("samon ScreenShotResult", "onFailure code is " + i);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            t0.a(bitmapWrapHardwareBuffer, this.f23265a);
            t0.b(bitmapWrapHardwareBuffer);
        }
    }

    public interface b {
        void a(String str, int i, String str2, String str3);
    }

    public static t0 b() {
        if (f23264a == null) {
            synchronized (t0.class) {
                if (f23264a == null) {
                    f23264a = new t0();
                }
            }
        }
        return f23264a;
    }

    public AdPackageModel c() {
        if (n3.a() == null) {
            h2.a(b, "parserHeardBeatData samon parserHeardBeatData is null");
            return new AdPackageModel();
        }
        String strE = n3.a().e("show_ad_activity");
        if (TextUtils.isEmpty(strE)) {
            h2.a(b, "show_ad_activity = null");
            return new AdPackageModel();
        }
        h2.a(b, "show_ad_activity = " + strE);
        AdPackageModel adPackageModel = (AdPackageModel) JSON.parseObject(strE, AdPackageModel.class);
        if (adPackageModel == null) {
            return new AdPackageModel();
        }
        h2.a(b, "adPackageModel = " + adPackageModel.toString());
        return adPackageModel;
    }

    public final Object d() throws ObjectStreamException {
        return f23264a;
    }

    public WxClickDataModel e(String str) {
        try {
            if (n3.a() == null) {
                h2.a(b, "getShowWxAppletData adPackageModel is null ");
                return null;
            }
            String strE = n3.a().e("applet_data");
            h2.a(b, "getShowWxAppletData applet_data =" + strE);
            return c(a2.b(strE).get(str));
        } catch (Exception e) {
            h2.a(b, "getShowWxAppletData Exception e =" + e.getMessage());
            return null;
        }
    }

    public void f(String str) {
        h2.a("samon-->", str.length() + "b");
    }

    public String g(String str) {
        try {
            try {
                if (n3.a() == null) {
                    return null;
                }
                Map<String, String> mapB = a2.b(n3.a().e("tag_homepage_info"));
                if (str.equals("com.taobao.tao.welcome.Welcome") || str.equals("com.taobao.tao.TBMainActivity")) {
                    str = "com.taobao.tao.welcome.Welcome";
                }
                String str2 = mapB.get(str);
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                mapB.remove(str);
                n3.a().b("tag_homepage_info", JSON.toJSONString(mapB));
                return str2;
            } catch (Exception e) {
                h2.a(b, "getShowAdActivityPackageName Exception e =" + e.getMessage());
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
        return null;
    }

    public boolean h(String str) {
        AdPackageModel adPackageModelC;
        try {
            if (n3.a() != null && (adPackageModelC = b().c()) != null) {
                for (int i = 0; i < adPackageModelC.getKeywords_names().size(); i++) {
                    if (str.toLowerCase().contains(adPackageModelC.getKeywords_names().get(i))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            h2.a(b, "isAccordType Exception e =" + e.getMessage());
        }
        return false;
    }

    public boolean i(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public String j(String str) {
        String strE;
        String str2 = str + "pic_type";
        h2.a(b + "--samon", "isShowBigPicture ");
        if (str2.equals(o.c().l)) {
            str2 = o.c().J;
        }
        h2.a(b + "--samon", "pageName= " + str2);
        if (n3.a() != null) {
            h2.a(b + "--samon", "QuickPreference.getInstance() is not null= ");
            strE = n3.a().e(str2);
        } else {
            strE = "";
        }
        h2.a(b + "--samon", "pageName= " + strE);
        ShowWindowModel showWindowModel = (TextUtils.isEmpty(strE) || strE == null) ? new ShowWindowModel() : (ShowWindowModel) JSON.parseObject(strE, ShowWindowModel.class);
        showWindowModel.setAppName(str2);
        String strA = s0.d().a();
        h2.a(b + "--samon", "date= " + strA);
        h2.a(b + "--samon", "label.getShowBigWindowData()= " + showWindowModel.getShowBigWindowData());
        return !showWindowModel.getShowBigWindowData().equals(strA) ? "1" : "0";
    }

    public void k(String str) {
        try {
            n3.a().b("business_date", str);
        } catch (Exception unused) {
        }
    }

    public String l(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> mapB = a2.b(n3.a().e("business_date"));
        if (mapB != null) {
            str2 = mapB.get(str);
            if (!TextUtils.isEmpty(str2)) {
                mapB.remove(str);
                n3.a().b("business_date", JSON.toJSONString(mapB));
            }
        }
        return str2;
    }

    public boolean a(List<String> list, int i) {
        if (list != null && list.size() != 0) {
            return list.size() >= i;
        }
        h2.a(b, "judgeData lists = null");
        return false;
    }

    public boolean d(List<String> list) {
        if (list == null || list.size() == 0) {
            h2.a(b, "getPrice lists = null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).replace("0", "").length() > 17) {
                return true;
            }
        }
        return false;
    }

    public RequestBody a(Map map, String str) {
        String jSONString = JSON.toJSONString(map);
        h2.a(b, "内容  getTitle=" + jSONString);
        h2.a(q3.e, "samon importantData =" + jSONString);
        TreeMap treeMap = new TreeMap();
        if ("heart_beat".equals(str)) {
            treeMap.put("heart_beat", "1");
            String strReplaceAll = g.a().b(jSONString, true).replaceAll("\\n", "");
            treeMap.put("sdk_version", l0.n);
            treeMap.put("content", strReplaceAll);
            String jSONString2 = JSON.toJSONString(treeMap);
            h2.a(q3.e, "samon all request data = " + jSONString2);
            return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString2);
        }
        String strReplaceAll2 = g.a().b(jSONString, false).replaceAll("\\n", "");
        if (TextUtils.isEmpty(l0.a(false))) {
            return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString);
        }
        treeMap.put("sdk_version", l0.n);
        treeMap.put("content", strReplaceAll2);
        String jSONString3 = JSON.toJSONString(treeMap);
        h2.a(q3.e, "samon all request data = " + jSONString3);
        return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString3);
    }

    public boolean b(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (list.get(i).contains("￥") || list.get(i).contains("¥"))) {
                    return true;
                }
            }
            return false;
        }
        h2.a(b, "getPrice lists = null");
        return false;
    }

    public PageSettingTypeModel d(String str) {
        try {
            if (n3.a() != null) {
                AdPackageModel adPackageModelC = b().c();
                if (adPackageModelC != null) {
                    h2.a(b, "getShowAdActivityPackageName adPackageModel is not null ");
                    n3.a().b("read_timeout", adPackageModelC.getRead_timeout());
                    n3.a().a("delay_read_time", adPackageModelC.getDelay_readpage_time());
                    if (TextUtils.isEmpty(adPackageModelC.getNew_package_setting())) {
                        h2.a(b, "getShowAdActivityPackageName getNew_package_setting is not null ");
                        return null;
                    }
                    h2.a(b, "getShowAdActivityPackageName =" + a2.b(adPackageModelC.getNew_package_setting()));
                    return b(a2.b(adPackageModelC.getNew_package_setting()).get(str));
                }
                h2.a(b, "getShowAdActivityPackageName adPackageModel is null ");
            }
        } catch (Exception e) {
            h2.a(b, "getShowAdActivityPackageName Exception e =" + e.getMessage());
        }
        return null;
    }

    public boolean b(List<String> list, int i) {
        if (list != null && list.size() != 0) {
            if (!d(list)) {
                return false;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) != null && (list.get(i2).trim().contains("￥") || list.get(i2).trim().contains("¥") || list.get(i2).trim().contains("已售"))) {
                    return list.size() >= i;
                }
            }
            return false;
        }
        h2.a(b, "judgeData lists = null");
        return false;
    }

    public boolean c(String str, int i) {
        return str.split("，").length < i;
    }

    public String c(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    stringBuffer.append(list.get(i));
                    stringBuffer.append(",");
                }
            }
            return stringBuffer.toString();
        }
        h2.a(b, " getTbTitle lists = null");
        return "";
    }

    public int b(int i) {
        if (AcseHelpManager.mIsDebug) {
            h2.a(b, "setReadTime is debug");
            return i;
        }
        h2.a(b, "setReadTime is release");
        return i;
    }

    public WxClickDataModel c(String str) {
        h2.a(b, "getCurrentWxAppletData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (WxClickDataModel) JSON.parseObject(str, WxClickDataModel.class);
    }

    public PageSettingTypeModel b(String str) {
        h2.a(b, "getCurrentPageSettingData json =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PageSettingTypeModel) JSON.parseObject(str, PageSettingTypeModel.class);
    }

    public RequestBody a(Map map) {
        String strReplaceAll = f.b().a(JSON.toJSONString(map)).replaceAll("\\n", "");
        TreeMap treeMap = new TreeMap();
        treeMap.put("data", strReplaceAll);
        String jSONString = JSON.toJSONString(treeMap);
        h2.a(q3.e, "samon all request data = " + jSONString);
        return RequestBody.create(MediaType.parse("application/json,utf-8"), jSONString);
    }

    public boolean b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("月销") || str.contains("已售") || str.matches("[1-9]\\d*\\.?\\d*") || str.contains("￥") || str.contains("¥")) {
            return true;
        }
        if (str.length() > i || a(str)) {
            return c(str, 2);
        }
        return false;
    }

    public static void b(Bitmap bitmap) {
        if (AcseHelpManager.mIsDebug) {
            a(bitmap, new File(a() + WVNativeCallbackUtil.SEPERATER + new Random().nextInt(10000) + "shotdd.png"));
        }
    }

    public int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        int length = str.length();
        return length < 2048 ? length + i : length;
    }

    public boolean a(int i) {
        if (i <= 8192) {
            return true;
        }
        n3.a().b("scroll_state", l0.r);
        return false;
    }

    public final boolean a(String str) {
        return str.matches(".*\\d+.*");
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (list.get(i).contains("https") || !list.get(i).contains("匿名") || list.get(i).length() > 17)) {
                    return true;
                }
            }
            return false;
        }
        h2.a(b, "getGoodsTitle lists = null");
        return false;
    }

    public void a(List<String> list, List<String> list2, b bVar) {
        if (list2.size() == 0 || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            String[] strArrSplit = list2.get(i).split("\\|");
            if (strArrSplit.length < 0) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (!TextUtils.isEmpty(strArrSplit[0]) && list.get(i2).contains(strArrSplit[0])) {
                    if (strArrSplit[1].equals("0")) {
                        bVar.a(strArrSplit[1], Integer.parseInt(strArrSplit[2]), "", "");
                        return;
                    }
                    if (strArrSplit[1].equals("1")) {
                        bVar.a(strArrSplit[1], Integer.parseInt(strArrSplit[2]), list.get(i2), "");
                        return;
                    }
                    if (strArrSplit[1].equals("2")) {
                        bVar.a(strArrSplit[1], Integer.parseInt(strArrSplit[2]), "", "");
                        return;
                    }
                    if (strArrSplit[1].equals("3")) {
                        bVar.a(strArrSplit[1], Integer.parseInt(strArrSplit[2]), strArrSplit[3], strArrSplit[4]);
                        return;
                    } else if (strArrSplit[1].equals("4")) {
                        bVar.a(strArrSplit[1], Integer.parseInt(strArrSplit[2]), strArrSplit[3], strArrSplit[4]);
                        return;
                    } else if (strArrSplit[1].equals("5")) {
                        bVar.a(strArrSplit[1], 0, "", "");
                        return;
                    }
                }
            }
        }
    }

    public boolean a(List<String> list, String str, String str2) {
        boolean z = false;
        boolean z2 = false;
        for (String str3 : list) {
            if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                z = true;
            }
            if (!TextUtils.isEmpty(str3) && str2.equals(str3)) {
                z2 = true;
            }
        }
        return z && z2;
    }

    public void a(String str, WxClickDataModel wxClickDataModel) {
        try {
            if (n3.a() != null) {
                String strE = n3.a().e("applet_data");
                h2.a(b, "changeHeartAppletData applet_data =" + strE);
                if (TextUtils.isEmpty(strE)) {
                    return;
                }
                Map<String, String> mapB = a2.b(strE);
                if (wxClickDataModel.getToast_times() == 0) {
                    mapB.remove(str);
                } else {
                    mapB.put(str, JSON.toJSONString(wxClickDataModel));
                }
                n3.a().b("applet_data", JSON.toJSONString(mapB));
            }
            h2.a(b, "changeHeartAppletData adPackageModel is null ");
        } catch (Exception e) {
            h2.a(b, "changeHeartAppletData Exception e =" + e.getMessage());
        }
    }

    public static void a(AccessibilityService accessibilityService, String str) {
        if (Build.VERSION.SDK_INT < 30 || accessibilityService == null) {
            return;
        }
        accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new a(str));
    }

    public static void a(Bitmap bitmap, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            r1.c();
            r1.a(strEncodeToString, str);
        } catch (Throwable unused) {
        }
    }

    public static File a() {
        File externalFilesDir = HelpShopAppUtil.getContext().getExternalFilesDir("crash");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public static void a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
