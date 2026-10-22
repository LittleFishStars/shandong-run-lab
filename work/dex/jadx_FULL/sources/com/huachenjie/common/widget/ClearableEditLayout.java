package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ClearableEditLayout extends LinearLayout implements View.OnClickListener {
    private static final int ID_IMAGEVIEW_CLEAR = 18;
    private Integer mClearGravity;
    private Drawable mClearImage;
    private EditText mEditText;
    private final View.OnFocusChangeListener mOnFocusChangeListener;
    private final TextWatcher mTextChangeListener;

    public ClearableEditLayout(Context context) {
        super(context);
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.huachenjie.common.widget.ClearableEditLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (TextUtils.isEmpty(ClearableEditLayout.this.mEditText.getText().toString())) {
                    ClearableEditLayout.this.setClearButtonVisibility(false);
                } else {
                    ClearableEditLayout.this.setClearButtonVisibility(hasFocus);
                }
            }
        };
        this.mTextChangeListener = new TextWatcher() { // from class: com.huachenjie.common.widget.ClearableEditLayout.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || !ClearableEditLayout.this.mEditText.hasFocus()) {
                    return;
                }
                ClearableEditLayout.this.setClearButtonVisibility(s.length() > 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        initRes(context, null);
    }

    private void addDelImageButton(int index) {
        ImageView imageView = new ImageView(getContext());
        imageView.setId(18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mClearGravity.intValue();
        imageView.setLayoutParams(layoutParams);
        Drawable drawable = this.mClearImage;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageResource(R.drawable.ic_edit_clear);
        }
        imageView.setOnClickListener(this);
        imageView.setVisibility(8);
        addView(imageView, index + 1);
    }

    private void initRes(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ClearableEditLayout);
        this.mClearImage = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClearableEditLayout_clearSrc);
        this.mClearGravity = Integer.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.ClearableEditLayout_clearGravity, 16));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initializeEditText(int index) {
        EditText editText = (EditText) getChildAt(index);
        this.mEditText = editText;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
        layoutParams.weight = 1.0f;
        this.mEditText.setLayoutParams(layoutParams);
        this.mEditText.setOnFocusChangeListener(this.mOnFocusChangeListener);
        this.mEditText.addTextChangedListener(this.mTextChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClearButtonVisibility(boolean showOrHide) {
        findViewById(18).setVisibility(showOrHide ? 0 : 4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        EditText editText;
        if (v.getId() != 18 || (editText = this.mEditText) == null) {
            return;
        }
        editText.setText("");
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof EditText) {
                initializeEditText(i);
                addDelImageButton(i);
                return;
            }
        }
        throw new InflateException("The first child view must be a EditText!");
    }

    public ClearableEditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.huachenjie.common.widget.ClearableEditLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (TextUtils.isEmpty(ClearableEditLayout.this.mEditText.getText().toString())) {
                    ClearableEditLayout.this.setClearButtonVisibility(false);
                } else {
                    ClearableEditLayout.this.setClearButtonVisibility(hasFocus);
                }
            }
        };
        this.mTextChangeListener = new TextWatcher() { // from class: com.huachenjie.common.widget.ClearableEditLayout.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || !ClearableEditLayout.this.mEditText.hasFocus()) {
                    return;
                }
                ClearableEditLayout.this.setClearButtonVisibility(s.length() > 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        initRes(context, attrs);
    }

    public ClearableEditLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.huachenjie.common.widget.ClearableEditLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (TextUtils.isEmpty(ClearableEditLayout.this.mEditText.getText().toString())) {
                    ClearableEditLayout.this.setClearButtonVisibility(false);
                } else {
                    ClearableEditLayout.this.setClearButtonVisibility(hasFocus);
                }
            }
        };
        this.mTextChangeListener = new TextWatcher() { // from class: com.huachenjie.common.widget.ClearableEditLayout.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || !ClearableEditLayout.this.mEditText.hasFocus()) {
                    return;
                }
                ClearableEditLayout.this.setClearButtonVisibility(s.length() > 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        initRes(context, attrs);
    }
}
