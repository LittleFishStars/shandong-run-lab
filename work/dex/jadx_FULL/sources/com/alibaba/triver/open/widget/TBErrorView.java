package com.alibaba.triver.open.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.alibctriver.R;
import com.alibaba.triver.kit.api.model.ErrorInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBErrorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f25083a;
    private TextView b;

    /* JADX INFO: renamed from: com.alibaba.triver.open.widget.TBErrorView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25084a;

        static {
            int[] iArr = new int[ButtonType.values().length];
            f25084a = iArr;
            try {
                iArr[ButtonType.BUTTON_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum ButtonType {
        BUTTON_LEFT
    }

    public TBErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(LayoutInflater.from(getContext()).inflate(R.layout.triver_error, (ViewGroup) this, true));
    }

    private void a(View view) {
        this.f25083a = (Button) findViewById(R.id.wml_errorButtonPos);
        this.b = (TextView) findViewById(R.id.wml_mapping_code);
    }

    public void setError(ErrorInfo errorInfo) {
        if (errorInfo == null || errorInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(errorInfo.errorCode)) {
            this.b.setVisibility(4);
            return;
        }
        this.b.setVisibility(0);
        this.b.setText(errorInfo.errorCode + errorInfo.errorMsg);
    }

    public void a(ButtonType buttonType, CharSequence charSequence, View.OnClickListener onClickListener) {
        Button button = AnonymousClass1.f25084a[buttonType.ordinal()] != 1 ? null : this.f25083a;
        if (button != null) {
            button.setText(charSequence);
            button.setOnClickListener(onClickListener);
            button.setVisibility(onClickListener == null ? 8 : 0);
        }
    }

    public TBErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TBErrorView(Context context) {
        this(context, null, 0);
    }
}
