package com.huachenjie.common.map;

import android.content.res.Resources;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.event.SignalChangeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class NoBgGPSSignalComponent<T> extends BaseComponent<T> {
    public static final String f = "GPSSignalCompoonent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f33828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SignalChangeListener f8797a;
    public View b;
    public View c;

    public interface SignalChangeListener {
        void a();

        void b();
    }

    public NoBgGPSSignalComponent(T context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    public void d(SignalChangeListener listener) {
        this.f8797a = listener;
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f33828a = a(R.id.view_signal_1_nobg);
        this.b = a(R.id.view_signal_2_nobg);
        this.c = a(R.id.view_signal_3_nobg);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onCreate() {
        super.onCreate();
        EventBus.f().v(this);
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        super.onDestroy();
        EventBus.f().A(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SignalChangeEvent event) {
        if (event != null) {
            int validLocCount = event.getValidLocCount();
            if (validLocCount <= 0) {
                View view = this.f33828a;
                Resources resources = b().getResources();
                int i = R.color.color_cacaca;
                view.setBackgroundColor(ResourcesCompat.getColor(resources, i, null));
                this.b.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i, null));
                this.c.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i, null));
                SignalChangeListener signalChangeListener = this.f8797a;
                if (signalChangeListener != null) {
                    signalChangeListener.a();
                    return;
                }
                return;
            }
            if (validLocCount == 1) {
                this.f33828a.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), R.color.color_ff4040, null));
                View view2 = this.b;
                Resources resources2 = b().getResources();
                int i2 = R.color.color_cacaca;
                view2.setBackgroundColor(ResourcesCompat.getColor(resources2, i2, null));
                this.c.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i2, null));
                SignalChangeListener signalChangeListener2 = this.f8797a;
                if (signalChangeListener2 != null) {
                    signalChangeListener2.a();
                    return;
                }
                return;
            }
            if (validLocCount == 2) {
                View view3 = this.f33828a;
                Resources resources3 = b().getResources();
                int i3 = R.color.color_main_v2;
                view3.setBackgroundColor(ResourcesCompat.getColor(resources3, i3, null));
                this.b.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i3, null));
                this.c.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), R.color.color_cacaca, null));
                SignalChangeListener signalChangeListener3 = this.f8797a;
                if (signalChangeListener3 != null) {
                    signalChangeListener3.b();
                    return;
                }
                return;
            }
            View view4 = this.f33828a;
            Resources resources4 = b().getResources();
            int i4 = R.color.color_main_v2;
            view4.setBackgroundColor(ResourcesCompat.getColor(resources4, i4, null));
            this.b.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i4, null));
            this.c.setBackgroundColor(ResourcesCompat.getColor(b().getResources(), i4, null));
            SignalChangeListener signalChangeListener4 = this.f8797a;
            if (signalChangeListener4 != null) {
                signalChangeListener4.b();
            }
        }
    }
}
