package com.alibaba.ariver.jsapi;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.annotation.Keep;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.u15;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DatePickerBridgeExtension implements BridgeExtension {
    private static final int HOUR_MINUTE = 0;
    private static final String TAG = "AriverAPI:DatePickerBridgeExtension";
    private static final int YEAR = 4;
    private static final int YEAR_MONTH = 3;
    private static final int YEAR_MONTH_DAY = 1;
    private static final int YEAR_MONTH_DAY_HOUR_MINUTE = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public Calendar parseDate(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(simpleDateFormat.parse(str));
                return calendar;
            } catch (ParseException e) {
                RVLogger.e(TAG, "exception detail", e);
            }
        }
        return null;
    }

    private void showDateDialog(final ApiContext apiContext, final Calendar calendar, final Calendar calendar2, final Calendar calendar3, final boolean z, final boolean z2, final BridgeCallback bridgeCallback, final JSONObject jSONObject, final int i) {
        final Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                StringBuilder sb;
                String str;
                Calendar calendar4;
                if (calendar2 != null && (calendar4 = calendar3) != null) {
                    if (calendar4.get(1) <= i2) {
                        i2 = calendar3.get(1);
                    } else if (calendar2.get(1) >= i2) {
                        i2 = calendar2.get(1);
                    }
                }
                int i5 = i3 + 1;
                if (i5 < 10) {
                    sb = new StringBuilder();
                    sb.append("0");
                } else {
                    sb = new StringBuilder();
                    sb.append("");
                }
                sb.append(i5);
                String string = sb.toString();
                if (i4 < 10) {
                    str = "0" + i4;
                } else {
                    str = "" + i4;
                }
                if (z2) {
                    jSONObject.put("date", (Object) (i2 + WVNativeCallbackUtil.SEPERATER + string + WVNativeCallbackUtil.SEPERATER + str + " "));
                    DatePickerBridgeExtension.this.showTimeDialog(apiContext, calendar, calendar2, calendar3, bridgeCallback, z, jSONObject);
                    return;
                }
                int i6 = i;
                if (i6 == 4) {
                    jSONObject.put("date", (Object) (i2 + ""));
                } else if (i6 == 3) {
                    jSONObject.put("date", (Object) (i2 + WVNativeCallbackUtil.SEPERATER + string));
                } else {
                    jSONObject.put("date", (Object) (i2 + WVNativeCallbackUtil.SEPERATER + string + WVNativeCallbackUtil.SEPERATER + str));
                }
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)) { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.2
            @Override // android.app.Dialog
            public void onStop() {
            }
        };
        datePickerDialog.setTitle(activity.getResources().getString(R.string.ariver_jsapi_choosedate));
        datePickerDialog.setCancelable(false);
        datePickerDialog.setButton(-2, activity.getResources().getString(R.string.ariver_jsapi_datecancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "User canceled"));
                dialogInterface.dismiss();
            }
        });
        if (z) {
            datePickerDialog.setButton(-3, activity.getResources().getString(R.string.ariver_jsapi_datevalid), new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    jSONObject.put("date", (Object) activity.getResources().getString(R.string.ariver_jsapi_date_longterm));
                    bridgeCallback.sendJSONResponse(jSONObject);
                    dialogInterface.dismiss();
                }
            });
        }
        try {
            DatePicker datePicker = datePickerDialog.getDatePicker();
            if (calendar2 != null) {
                datePicker.setMinDate(calendar2.getTimeInMillis());
            }
            if (calendar3 != null) {
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "set min or max date exception.", th);
        }
        try {
            DatePicker datePicker2 = datePickerDialog.getDatePicker();
            if (i == 3) {
                datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
            } else if (i == 4) {
                datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
                datePicker2.findViewById(Resources.getSystem().getIdentifier("month", "id", "android")).setVisibility(8);
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "set date mode exception", e);
        }
        try {
            datePickerDialog.show();
        } catch (Exception e2) {
            RVLogger.e(TAG, "show date dialog exception.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTimeDialog(ApiContext apiContext, Calendar calendar, final Calendar calendar2, final Calendar calendar3, final BridgeCallback bridgeCallback, boolean z, final JSONObject jSONObject) {
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        final Resources resources = activity.getResources();
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.5
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                StringBuilder sb;
                String str;
                StringBuilder sb2;
                StringBuilder sb3;
                BridgeCallback bridgeCallback2;
                BridgeCallback bridgeCallback3;
                String string = jSONObject.getString("date");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                StringBuilder sb4 = new StringBuilder(string);
                sb4.append(i + u15.f19942b + i2 + ":00");
                Calendar date = DatePickerBridgeExtension.this.parseDate(sb4.toString(), TextUtils.isEmpty(string) ? "HH:mm:ss" : "yyyy/MM/dd HH:mm:ss");
                if (date == null && (bridgeCallback3 = bridgeCallback) != null) {
                    bridgeCallback3.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                Calendar calendar4 = calendar2;
                if (calendar4 != null && calendar4.getTimeInMillis() > date.getTimeInMillis()) {
                    RVLogger.d(DatePickerBridgeExtension.TAG, "set selected date as min date");
                    date = calendar2;
                }
                Calendar calendar5 = calendar3;
                if (calendar5 != null && calendar5.getTimeInMillis() < date.getTimeInMillis()) {
                    RVLogger.d(DatePickerBridgeExtension.TAG, "set selected date as max date");
                    date = calendar3;
                }
                if (date == null && (bridgeCallback2 = bridgeCallback) != null) {
                    bridgeCallback2.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                if (!TextUtils.isEmpty(string)) {
                    int i3 = date.get(1);
                    int i4 = date.get(2);
                    int i5 = date.get(5);
                    int i6 = i4 + 1;
                    if (i6 < 10) {
                        sb2 = new StringBuilder();
                        sb2.append("0");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append("");
                    }
                    sb2.append(i6);
                    String string2 = sb2.toString();
                    if (i5 < 10) {
                        sb3 = new StringBuilder();
                        sb3.append("0");
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append("");
                    }
                    sb3.append(i5);
                    sb5.append(i3 + WVNativeCallbackUtil.SEPERATER + string2 + WVNativeCallbackUtil.SEPERATER + sb3.toString() + " ");
                }
                int i7 = date.get(11);
                int i8 = date.get(12);
                if (i7 < 10) {
                    sb = new StringBuilder();
                    sb.append("0");
                } else {
                    sb = new StringBuilder();
                    sb.append("");
                }
                sb.append(i7);
                String string3 = sb.toString();
                if (i8 < 10) {
                    str = "0" + i8;
                } else {
                    str = "" + i8;
                }
                sb5.append(string3 + u15.f19942b + str + ":00");
                jSONObject.put("date", (Object) sb5.toString());
                RVLogger.e(DatePickerBridgeExtension.TAG, sb4.toString());
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }, calendar.get(11), calendar.get(12), true) { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.6
            @Override // android.app.Dialog
            public void onStop() {
            }
        };
        timePickerDialog.setTitle(resources.getString(R.string.ariver_jsapi_choosetime));
        timePickerDialog.setCancelable(false);
        timePickerDialog.setButton(-2, resources.getString(R.string.ariver_jsapi_datecancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "Cancel"));
                dialogInterface.dismiss();
            }
        });
        if (z) {
            timePickerDialog.setButton(-3, resources.getString(R.string.ariver_jsapi_datevalid), new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.jsapi.DatePickerBridgeExtension.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jSONObject.put("date", (Object) resources.getString(R.string.ariver_jsapi_date_longterm));
                    bridgeCallback.sendJSONResponse(jSONObject);
                    dialogInterface.dismiss();
                }
            });
        }
        try {
            timePickerDialog.show();
        } catch (Exception e) {
            RVLogger.e(TAG, "show time dialog exception.", e);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void datePicker(@BindingApiContext(required = true) ApiContext apiContext, @BindingParam({"mode"}) int i, @BindingParam({"minDate"}) String str, @BindingParam({"maxDate"}) String str2, @BindingParam({"beginDate"}) String str3, @BindingParam({"isIDCard"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        String str4;
        if (i == 0) {
            str4 = "HH:mm:ss";
        } else if (i == 1) {
            str4 = "yyyy-MM-dd";
        } else if (i == 2) {
            str4 = "yyyy-MM-dd HH:mm:ss";
        } else if (i == 3) {
            str4 = "yyyy-MM";
        } else {
            str4 = i == 4 ? "yyyy" : null;
        }
        Calendar date = parseDate(str, str4);
        Calendar date2 = parseDate(str2, str4);
        if (date != null && date2 != null && date.getTimeInMillis() > date2.getTimeInMillis()) {
            RVLogger.e(TAG, "min date should less than max date!");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "min date should less than max date!"));
            return;
        }
        Calendar date3 = parseDate(str3, str4);
        if (date3 == null) {
            date3 = Calendar.getInstance();
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 0) {
            showTimeDialog(apiContext, date3, date, date2, bridgeCallback, z, jSONObject);
        } else {
            showDateDialog(apiContext, date3, date, date2, z, i == 2, bridgeCallback, jSONObject, i);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
