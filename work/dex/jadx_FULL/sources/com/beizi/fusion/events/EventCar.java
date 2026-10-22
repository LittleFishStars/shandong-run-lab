package com.beizi.fusion.events;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.beizi.fusion.i2;
import com.beizi.fusion.j4;
import com.beizi.fusion.jh;
import com.beizi.fusion.m9;
import com.beizi.fusion.mm;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.oo;
import com.beizi.fusion.qg;
import com.beizi.fusion.t8;
import com.beizi.fusion.v3;
import com.fl.saas.common.crash.CrashHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EventCar {
    private static EventCar e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27256a;
    private List b;
    private long c = 128;
    private long d = 172800000;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EventBean f27257a;

        public a(EventBean eventBean) {
            this.f27257a = eventBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            EventCar.this.a(this.f27257a);
        }
    }

    private EventCar(Context context) {
        this.f27256a = context;
        RequestInfo requestInfoInit = RequestInfo.getInstance(context).init();
        if (requestInfoInit.isInit()) {
            return;
        }
        requestInfoInit.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventBean eventBean) {
        try {
            ResponseInfo responseInfo = ResponseInfo.getInstance(this.f27256a);
            String strA = a(eventBean.getEventCode());
            if (responseInfo.getMessenger() != null) {
                this.b = responseInfo.getMessenger().getEvents();
                this.c = Long.valueOf(responseInfo.getMessenger().getFileMaxSize()).longValue();
                this.d = responseInfo.getMessenger().getExpireTime();
                List list = this.b;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i = 0; i < this.b.size(); i++) {
                    Messenger.EventsBean eventsBean = (Messenger.EventsBean) this.b.get(i);
                    List<String> codes = eventsBean.getCodes();
                    if (codes != null && codes.size() > 0) {
                        for (int i2 = 0; i2 < codes.size(); i2++) {
                            if (!TextUtils.isEmpty(eventBean.getEventCode()) && !TextUtils.isEmpty(codes.get(i2)) && (eventBean.getEventCode().equals(codes.get(i2)) || strA.equals(codes.get(i2)))) {
                                if (eventsBean.getIsOnline().equals("1")) {
                                    eventBean.setUrl(eventsBean.getUploadUrl());
                                    a(eventsBean, eventBean);
                                } else {
                                    a(eventsBean, eventBean, true);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static EventCar getInstance(Context context) {
        if (e == null) {
            synchronized (EventCar.class) {
                if (e == null) {
                    e = new EventCar(context);
                }
            }
        }
        return e;
    }

    public void doUpLoadLogs() throws Throwable {
        int i;
        int i2;
        try {
            jh.a("BeiZis", "===================doUpLoadLogs===================:" + Thread.currentThread().getName());
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileB = j4.b(this.f27256a);
            jh.a("BeiZis", "doUpLoadLogs storagePath == " + fileB);
            if (fileB != null) {
                String str = fileB.getPath() + "/BeiZi/offline/";
                File[] fileArrListFiles = new File(str).listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                    return;
                }
                int length = fileArrListFiles.length;
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    File file = fileArrListFiles[i4];
                    if (file.isDirectory()) {
                        String strA = "";
                        File file2 = new File(str, file.getName() + "/10000.txt");
                        if (file2.exists()) {
                            strA = a(file2);
                        } else {
                            mm.a(file);
                        }
                        if (TextUtils.isEmpty(strA)) {
                            i = i4;
                        } else {
                            File[] fileArrListFiles2 = file.listFiles();
                            int length2 = fileArrListFiles2.length;
                            int i5 = i3;
                            while (i5 < length2) {
                                File file3 = fileArrListFiles2[i5];
                                if (file3.getName().equals("10000.txt")) {
                                    i2 = i4;
                                } else {
                                    i2 = i4;
                                    if (jCurrentTimeMillis - Long.valueOf(file3.getName().substring(i3, file3.getName().indexOf(Consts.DOT))).longValue() < this.d) {
                                        String strA2 = m9.a(strA, file3);
                                        if (!TextUtils.isEmpty(strA2)) {
                                            try {
                                                if (new JSONObject(strA2).optInt("code") == 200) {
                                                    file3.delete();
                                                }
                                            } catch (JSONException unused) {
                                            }
                                        }
                                    } else {
                                        file3.delete();
                                    }
                                }
                                i5++;
                                i4 = i2;
                                i3 = 0;
                            }
                            i = i4;
                            if (file.listFiles().length <= 1) {
                                mm.a(file);
                            }
                        }
                    } else {
                        i = i4;
                    }
                    i4 = i + 1;
                    i3 = 0;
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void goRoad(EventBean eventBean) {
        v3.b().f().execute(new a(eventBean));
    }

    public void goRoadWithoutThread(EventBean eventBean) {
        a(eventBean);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, str.indexOf(Consts.DOT) + 1) + "*";
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean) {
        String strA;
        if (eventBean != null) {
            try {
                if (TextUtils.isEmpty(eventBean.getUrl())) {
                    return;
                }
                String url = eventBean.getUrl();
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    url = eventBean.getTaskReqUrl();
                }
                int iIndexOf = url.indexOf("?");
                String strSubstring = url.substring(0, iIndexOf);
                String strSubstring2 = url.substring(iIndexOf + 1);
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    strA = oo.a(this.f27256a, strSubstring2, eventBean, eventBean.getAppLinks());
                } else {
                    strA = oo.a(this.f27256a, strSubstring2, eventBean);
                }
                String strB = i2.b(qg.b(), t8.a(strA));
                if (strB != null) {
                    String strA2 = m9.a(strSubstring, strB.getBytes());
                    if (!TextUtils.isEmpty(strA2)) {
                        if (new JSONObject(strA2).optInt("code") != 200) {
                            a(eventsBean, eventBean, true);
                            return;
                        }
                        return;
                    }
                    a(eventsBean, eventBean, true);
                }
            } catch (JSONException | Exception unused) {
            }
        }
    }

    private static String a(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            fileInputStream.close();
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean, boolean z) throws IOException {
        String uploadUrl;
        Log.d("BeiZis", "===================doOffline===================:" + eventBean.getEventCode());
        try {
            File fileB = j4.b(this.f27256a);
            jh.a("BeiZis", "doOffline storagePath == " + fileB);
            if (fileB != null) {
                if (z) {
                    uploadUrl = eventsBean.getOfflineUrl();
                } else {
                    uploadUrl = eventsBean.getUploadUrl();
                }
                String strSubstring = uploadUrl.substring(0, uploadUrl.indexOf("?"));
                String strB = i2.b(qg.b(), oo.a(this.f27256a, uploadUrl.substring(uploadUrl.indexOf("?") + 1), eventBean));
                String str = fileB.getPath() + "/BeiZi/offline/" + oo.a(eventsBean.toString()) + WVNativeCallbackUtil.SEPERATER;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "10000.txt");
                synchronized (EventCar.class) {
                    if (!file2.exists()) {
                        file2.createNewFile();
                        FileWriter fileWriter = new FileWriter(file2, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(strSubstring);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                        fileWriter.close();
                    }
                }
                long jLongValue = 0;
                for (File file3 : file.listFiles()) {
                    String strSubstring2 = file3.getName().substring(0, file3.getName().indexOf(Consts.DOT));
                    if (Long.valueOf(strSubstring2).longValue() > jLongValue) {
                        jLongValue = Long.valueOf(strSubstring2).longValue();
                    }
                }
                if (jLongValue != 0 && jLongValue != 10000) {
                    File file4 = new File(str + jLongValue + CrashHandler.FILE_NAME_SUFFIX);
                    if (file4.exists() && file4.length() < this.c * 1000) {
                        FileWriter fileWriter2 = new FileWriter(file4, true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                        bufferedWriter2.write(strB);
                        bufferedWriter2.newLine();
                        bufferedWriter2.close();
                        fileWriter2.close();
                        file4.renameTo(new File(file, System.currentTimeMillis() + CrashHandler.FILE_NAME_SUFFIX));
                        return;
                    }
                }
                File file5 = new File(file, System.currentTimeMillis() + CrashHandler.FILE_NAME_SUFFIX);
                file5.createNewFile();
                FileWriter fileWriter3 = new FileWriter(file5, true);
                BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                bufferedWriter3.write(strB);
                bufferedWriter3.newLine();
                bufferedWriter3.close();
                fileWriter3.close();
            }
        } catch (Throwable unused) {
        }
    }
}
