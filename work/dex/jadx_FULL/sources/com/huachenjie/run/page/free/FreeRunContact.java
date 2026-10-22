package com.huachenjie.run.page.free;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface FreeRunContact {

    public interface FreeRunView extends BaseView {
        void A(boolean isAuto, boolean isDataError, boolean isValid, int inspirationValue);

        void B(List<IntervalPace> paceList);

        void D(List<IntervalStep> stepList);

        void G();

        void a(List<HCJLatLng> pathList);

        void t();

        void u();

        void v(boolean showSuccessDialog, int inspirationValue);

        void w(String message);

        void x(boolean isAuto, boolean isDataError, boolean isValid, int code, String message);
    }

    public static abstract class Presenter extends BasePresenter<FreeRunView> {
        public abstract void f(boolean isAuto, boolean isDataError, Map<String, Object> params, boolean isValid);

        public abstract void g(List<IntervalPace> paceList, long paceInterval, String runRecordCode);

        public abstract void h(List<HCJLatLng> pathList, String runRecordCode);

        public abstract void i(List<IntervalStep> stepList, long stepInterval, String runRecordCode);
    }
}
