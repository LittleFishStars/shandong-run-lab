package com.kc.bw.adIdUtils.cnadid;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.adIdUtils.ByteStreams;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CNAdidHelper {
    public String TAG;

    @Keep
    public static class Inner {
        public static final CNAdidHelper instance = new CNAdidHelper();
    }

    public CNAdidHelper() {
        this.TAG = dexg.dexa("DOBejeIfmqfs");
    }

    private String getCNAdID1(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), dexg.dexa("[IW{Z3Ml"));
        } catch (Throwable unused) {
            return "";
        }
    }

    private String getCNAdID2(Context context) {
        try {
            String string = context.getSharedPreferences(context.getPackageName() + dexg.dexa("`eob"), 0).getString(dexg.dexa("[IW{Z3Ml"), dexg.dexa("OB"));
            try {
                if (string.equals(dexg.dexa("OB"))) {
                    return null;
                }
                return string;
            } catch (Throwable unused) {
                return string;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private String getCNAdID3() {
        String str = "";
        try {
            File file = new File(dexg.dexa("0tedbse0Boespje0[IW{Z3Ml"));
            if (!file.isDirectory() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                String line = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
                str = line != null ? line : "";
                fileInputStream.close();
                return str;
            }
            return null;
        } catch (Throwable unused) {
            return str;
        }
    }

    private String getCNAdID4() {
        FileInputStream fileInputStream;
        String filePath = getFilePath();
        File file = new File(filePath);
        Log.d(dexg.dexa("DOBEJEEFy.."), dexg.dexa("hfuDOBeJE5..") + filePath);
        if (!file.exists()) {
            String strWriteToFile = writeToFile();
            Log.d(dexg.dexa("DOBEJEEFy.."), dexg.dexa("hfuDOBeJE5..ebub..fyjtutgbmtfebub..") + strWriteToFile);
            return strWriteToFile;
        }
        Log.d(dexg.dexa("DOBEJEEFy.."), dexg.dexa("hfuDOBeJE5..fyjtut"));
        try {
            fileInputStream = new FileInputStream(filePath);
            try {
                String str = new String(ByteStreams.toByteArray(fileInputStream));
                Log.d(dexg.dexa("DOBEJEEFy.."), dexg.dexa("hfuDOBeJE5..ebub..") + str);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable unused2) {
                try {
                    String strWriteToFile2 = writeToFile();
                    if (fileInputStream == null) {
                        return strWriteToFile2;
                    }
                    try {
                        return strWriteToFile2;
                    } catch (IOException unused3) {
                        return strWriteToFile2;
                    }
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                }
            }
        } catch (Throwable unused5) {
            fileInputStream = null;
        }
    }

    private String getFilePath() {
        StringBuilder sb;
        String strDexa;
        try {
            if (Environment.getExternalStorageState().equals(dexg.dexa("npvoufe"))) {
                sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory());
                sb.append(File.separator);
                strDexa = dexg.dexa("[IW{Z3Ml2/uyu");
            } else {
                sb = new StringBuilder();
                sb.append(Environment.getDownloadCacheDirectory());
                sb.append(File.separator);
                strDexa = dexg.dexa("[IW{Z3Ml2/uyu");
            }
            sb.append(strDexa);
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static CNAdidHelper getInstance() {
        return Inner.instance;
    }

    public static String getRandomString(int i) {
        StringBuffer stringBuffer;
        try {
            String strDexa = dexg.dexa("{ydwconmlkihgetbrxfsuzvjpqRXFSUZVJPQBTEGHIKLM[YDWCON23456789:1");
            Random random = new Random();
            stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    stringBuffer.append(strDexa.charAt(random.nextInt(62)));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            stringBuffer = null;
        }
        return stringBuffer.toString();
    }

    private String writeToFile() {
        Object th;
        FileOutputStream fileOutputStream;
        String randomString = getRandomString(32);
        try {
            File file = new File(getFilePath());
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(randomString.getBytes());
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.d(this.TAG, dexg.dexa("鰼搗楲鵦-") + th);
                    return randomString;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        return randomString;
    }

    public String readCNAdid(Context context) {
        try {
            String cNAdID1 = getCNAdID1(context);
            if (!TextUtils.isEmpty(cNAdID1)) {
                return cNAdID1;
            }
            String cNAdID2 = getCNAdID2(context);
            if (!TextUtils.isEmpty(cNAdID2)) {
                return cNAdID2;
            }
            String cNAdID3 = getCNAdID3();
            if (!TextUtils.isEmpty(cNAdID3)) {
                return cNAdID3;
            }
            String cNAdID4 = getCNAdID4();
            return !TextUtils.isEmpty(cNAdID4) ? cNAdID4 : "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
