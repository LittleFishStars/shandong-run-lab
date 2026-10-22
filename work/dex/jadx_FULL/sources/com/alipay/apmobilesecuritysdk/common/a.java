package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static boolean a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.e(context));
        return a(arrayList) || a(new ArrayList<String>() { // from class: com.alipay.apmobilesecuritysdk.common.RushTimeUtil$1
            {
                add("2018-06-17&2018-06-18");
                add("2018-09-08&2018-09-09");
                add("2018-11-10&2018-11-11");
                add("2018-12-11&2018-12-12");
                add("2019-02-04&2019-02-05");
                add("2019-06-17&2019-06-18");
                add("2019-09-08&2019-09-09");
                add("2019-11-10&2019-11-11");
                add("2019-12-11&2019-12-12");
                add("2020-01-24&2020-01-25");
                add("2020-06-17&2020-06-18");
                add("2020-09-08&2020-09-09");
                add("2020-11-10&2020-11-11");
                add("2020-12-11&2020-12-12");
                add("2021-02-11&2021-02-12");
                add("2021-06-17&2021-06-18");
                add("2021-09-08&2021-09-09");
                add("2021-11-10&2021-11-11");
                add("2021-12-11&2021-12-12");
                add("2022-01-31&2022-02-01");
                add("2022-06-17&2022-06-18");
                add("2022-09-08&2022-09-09");
                add("2022-11-10&2022-11-11");
                add("2022-12-11&2022-12-12");
            }
        });
    }

    public static boolean a(List<String> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split("&");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
