package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.acse.ottn.model.PlunInstallModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.byazt.tk.AdBaseConstants;
import com.ltmb.ltadsdk.core.download.SYDownloadManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w1 f23277a = null;
    public static String b = "InstallUtils";

    public static w1 a() {
        if (f23277a == null) {
            synchronized (w1.class) {
                if (f23277a == null) {
                    f23277a = new w1();
                }
            }
        }
        return f23277a;
    }

    public final Object b() throws ObjectStreamException {
        return f23277a;
    }

    public void b(Activity activity) {
        try {
            InputStream inputStreamOpen = activity.getResources().getAssets().open("detn.mp3");
            if (inputStreamOpen == null) {
                Log.v("readAssets", "no file");
                return;
            }
            File absoluteFile = activity.getExternalFilesDir(SYDownloadManager.DOWNLOAD_TYPE_APK).getAbsoluteFile();
            if (!absoluteFile.exists()) {
                absoluteFile.mkdir();
            }
            File file = new File(activity.getExternalFilesDir(SYDownloadManager.DOWNLOAD_TYPE_APK).getAbsoluteFile().getPath() + "/text.apk");
            file.createNewFile();
            a(inputStreamOpen, file);
            a(file, activity);
        } catch (IOException e) {
            Log.v("readAssets", "e = " + e.getMessage());
            e.printStackTrace();
        }
    }

    public final void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        try {
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        fileOutputStream = null;
                    }
                    bArr = new byte[1024];
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    public boolean a(Activity activity) {
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = activity.getResources().getAssets().open("detn.mp3");
        } catch (IOException e) {
            e.printStackTrace();
            inputStreamOpen = null;
        }
        if (inputStreamOpen != null) {
            return true;
        }
        Log.v("readAssets", "no file");
        return false;
    }

    @RequiresApi(api = 17)
    public void a(File file, Activity activity) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            try {
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(1);
                intent.addFlags(2);
                intent.setDataAndType(FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file), AdBaseConstants.MIME_APK);
                if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    activity.startActivityForResult(intent, 10010);
                }
            } catch (Exception e) {
                Log.v("readAssets", "e=" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public PlunInstallModel a(String str) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
            if (HelpShopAppUtil.getContext() == null) {
                Log.v(b, "context is null");
                return plunInstallModel;
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
                int i = packageInfo.versionCode;
                Log.v(b, "context is not null");
                plunInstallModel.setVersion(i + "");
            }
            return plunInstallModel;
        } catch (Exception e) {
            plunInstallModel.setVersion("0");
            Log.v(b, "e=" + e.getMessage());
            e.printStackTrace();
        }
    }

    public PlunInstallModel a(Context context) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
            if (context == null) {
                Log.v(b, "context is null");
                return plunInstallModel;
            }
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
                int i = packageInfo.versionCode;
                Log.v(b, "context is not null");
                plunInstallModel.setVersion(i + "");
            }
            return plunInstallModel;
        } catch (Exception e) {
            plunInstallModel.setVersion("0");
            Log.v(b, "e=" + e.getMessage());
            e.printStackTrace();
        }
    }
}
