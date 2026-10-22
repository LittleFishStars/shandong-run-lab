package cn.hzjizhun.admin.util;

import android.text.TextUtils;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.http.net.thread.EasyThreadPools;
import com.zj.adlib.ugb;
import com.zj.adlib.vwa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileInfoUtils {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f22749a;
        public final /* synthetic */ String f;

        public a(Map map, String str) {
            this.f22749a = map;
            this.f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map map = this.f22749a;
                if (map != null && !map.isEmpty()) {
                    List list = (List) this.f22749a.get("1");
                    ArrayList arrayList = new ArrayList();
                    if (list != null && !list.isEmpty()) {
                        FileInfoUtils.readShellPath(list, arrayList);
                    }
                    if (arrayList.isEmpty()) {
                        FileInfoUtils.readSdCardPath((List) this.f22749a.get("2"), arrayList);
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    ApiManager.reportFileTime(this.f, arrayList);
                }
            } catch (Throwable th) {
                ALog.innerE("", "readShellText error: " + th.getMessage());
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readFile(File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        closeQuietly(bufferedReader);
                        return string;
                    }
                    sb.append(line);
                }
            } catch (Throwable unused) {
                closeQuietly(bufferedReader);
                return "";
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readSdCardPath(List<ugb> list, List<vwa> list2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ugb ugbVar : list) {
            try {
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(new File(ugbVar.a()).lastModified()));
                vwa vwaVar = new vwa(ugbVar.b());
                vwaVar.c(str);
                list2.add(vwaVar);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readShellPath(List<ugb> list, List<vwa> list2) {
        if (list != null && !list.isEmpty()) {
            for (ugb ugbVar : list) {
                String strA = ugbVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    String str = ShellUtils.execCommand("stat -c \"%y\" " + strA, false).successMsg;
                    if (!TextUtils.isEmpty(str)) {
                        vwa vwaVar = new vwa(ugbVar.b());
                        String[] strArrSplit = str.split(" ");
                        if (strArrSplit.length >= 2) {
                            vwaVar.c(strArrSplit[0] + " " + strArrSplit[1].split("\\.")[0]);
                            list2.add(vwaVar);
                        }
                    }
                }
            }
        }
        return "";
    }

    public static void readShellText(String str, Map<String, List<ugb>> map) {
        EasyThreadPools.executor(new a(map, str));
    }

    public static void writeFile(File file, String str) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file), 1024);
            try {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                closeQuietly(bufferedWriter);
            } catch (Throwable unused) {
                closeQuietly(bufferedWriter);
            }
        } catch (Throwable unused2) {
            bufferedWriter = null;
        }
    }
}
