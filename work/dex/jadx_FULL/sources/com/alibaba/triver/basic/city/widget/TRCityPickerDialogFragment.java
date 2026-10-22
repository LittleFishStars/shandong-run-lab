package com.alibaba.triver.basic.city.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.city.adapter.TRCTAdapter;
import com.alibaba.triver.basic.city.adapter.decoration.TRCTDividerItemDecoration;
import com.alibaba.triver.basic.city.adapter.decoration.TRCTSectionItemDecoration;
import com.alibaba.triver.basic.city.b.b;
import com.alibaba.triver.basic.city.b.c;
import com.alibaba.triver.basic.city.b.d;
import com.alibaba.triver.basic.city.view.TRCTSideIndexBar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCityPickerDialogFragment extends DialogFragment implements TextWatcher, View.OnClickListener, com.alibaba.triver.basic.city.adapter.a, TRCTSideIndexBar.a {
    private TRCTAdapter mAdapter;
    private List<b> mAllCities;
    private TextView mCancelBtn;
    private ImageView mClearAllBtn;
    private View mContentView;
    private View mEmptyView;
    private int mHeight;
    private List<c> mHotCities;
    private TRCTSideIndexBar mIndexBar;
    private LinearLayoutManager mLayoutManager;
    private int mLocateState;
    private d mLocatedCity;
    private TextView mOverlayTextView;
    private RecyclerView mRecyclerView;
    private List<b> mResults;
    private EditText mSearchBox;
    private com.alibaba.triver.basic.city.adapter.b mTRCTOnPickListener;
    private int mWidth;
    private boolean mShowHotCities = true;
    private boolean mShowLocationCity = true;
    private boolean mEnableAnim = false;
    private int mAnimStyle = R.style.TRDefaultCityPickerAnimation;

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mEnableAnim = arguments.getBoolean("cp_enable_anim");
        }
        List<b> listA = com.alibaba.triver.basic.city.a.a.a();
        this.mAllCities = listA;
        d dVar = this.mLocatedCity;
        int i = 0;
        if (dVar == null && this.mShowLocationCity) {
            listA.add(0, dVar);
            i = 1;
        }
        if (this.mHotCities == null && this.mShowHotCities) {
            this.mAllCities.add(i, new c("热门城市", "未知", "0"));
        }
        List<c> list = this.mHotCities;
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.mHotCities = arrayList;
            arrayList.add(new c("北京", "北京", "110000"));
            this.mHotCities.add(new c("上海", "上海", "310000"));
            this.mHotCities.add(new c("广州", "广东", "440100"));
            this.mHotCities.add(new c("深圳", "广东", "440300"));
            this.mHotCities.add(new c("天津", "天津", "120000"));
            this.mHotCities.add(new c("杭州", "浙江", "330100"));
            this.mHotCities.add(new c("南京", "江苏", "320100"));
            this.mHotCities.add(new c("成都", "四川", "510100"));
            this.mHotCities.add(new c("武汉", "湖北", "420100"));
        }
        if (this.mLocatedCity == null) {
            this.mLocatedCity = new d(getString(R.string.tr_cp_locating), "未知", "0");
            this.mLocateState = 123;
        } else {
            this.mLocateState = 132;
        }
        this.mResults = this.mAllCities;
    }

    private void initViews() {
        this.mRecyclerView = (RecyclerView) this.mContentView.findViewById(R.id.cp_city_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        this.mLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.addItemDecoration(new TRCTSectionItemDecoration(getActivity(), this.mAllCities), 0);
        this.mRecyclerView.addItemDecoration(new TRCTDividerItemDecoration(getActivity()), 1);
        TRCTAdapter tRCTAdapter = new TRCTAdapter(getActivity(), this.mAllCities, this.mHotCities, this.mLocateState);
        this.mAdapter = tRCTAdapter;
        tRCTAdapter.a(true);
        this.mAdapter.a(this);
        this.mAdapter.a(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.triver.basic.city.widget.TRCityPickerDialogFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    TRCityPickerDialogFragment.this.mAdapter.a();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mEmptyView = this.mContentView.findViewById(R.id.cp_empty_view);
        this.mOverlayTextView = (TextView) this.mContentView.findViewById(R.id.cp_overlay);
        TRCTSideIndexBar tRCTSideIndexBar = (TRCTSideIndexBar) this.mContentView.findViewById(R.id.cp_side_index_bar);
        this.mIndexBar = tRCTSideIndexBar;
        tRCTSideIndexBar.setNavigationBarHeight(com.alibaba.triver.basic.city.c.a.b(getActivity()));
        this.mIndexBar.a(this.mOverlayTextView).a(this);
        EditText editText = (EditText) this.mContentView.findViewById(R.id.cp_search_box);
        this.mSearchBox = editText;
        editText.addTextChangedListener(this);
        this.mCancelBtn = (TextView) this.mContentView.findViewById(R.id.cp_cancel);
        this.mClearAllBtn = (ImageView) this.mContentView.findViewById(R.id.cp_clear_all);
        this.mCancelBtn.setOnClickListener(this);
        this.mClearAllBtn.setOnClickListener(this);
    }

    private void measure() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        this.mHeight = displayMetrics.heightPixels;
        this.mWidth = displayMetrics.widthPixels;
    }

    public static TRCityPickerDialogFragment newInstance(boolean z) {
        TRCityPickerDialogFragment tRCityPickerDialogFragment = new TRCityPickerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("cp_enable_anim", z);
        tRCityPickerDialogFragment.setArguments(bundle);
        return tRCityPickerDialogFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string = editable.toString();
        if (TextUtils.isEmpty(string)) {
            this.mClearAllBtn.setVisibility(8);
            this.mEmptyView.setVisibility(8);
            this.mResults = this.mAllCities;
            ((TRCTSectionItemDecoration) this.mRecyclerView.getItemDecorationAt(0)).a(this.mResults);
            this.mAdapter.a(this.mResults);
        } else {
            this.mClearAllBtn.setVisibility(0);
            this.mResults = com.alibaba.triver.basic.city.a.a.a(string);
            ((TRCTSectionItemDecoration) this.mRecyclerView.getItemDecorationAt(0)).a(this.mResults);
            List<b> list = this.mResults;
            if (list == null || list.isEmpty()) {
                this.mEmptyView.setVisibility(0);
            } else {
                this.mEmptyView.setVisibility(8);
                this.mAdapter.a(this.mResults);
            }
        }
        this.mRecyclerView.scrollToPosition(0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.alibaba.triver.basic.city.adapter.a
    public void dismiss(int i, b bVar) {
        dismiss();
        com.alibaba.triver.basic.city.adapter.b bVar2 = this.mTRCTOnPickListener;
        if (bVar2 != null) {
            bVar2.a(i, bVar);
        }
    }

    @Override // com.alibaba.triver.basic.city.adapter.a
    public void locate() {
        com.alibaba.triver.basic.city.adapter.b bVar = this.mTRCTOnPickListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void locationChanged(d dVar, int i) {
        this.mAdapter.a(dVar, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.cp_cancel) {
            if (id == R.id.cp_clear_all) {
                this.mSearchBox.setText("");
            }
        } else {
            dismiss();
            com.alibaba.triver.basic.city.adapter.b bVar = this.mTRCTOnPickListener;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.TRCityPickerStyle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.tr_cp_dialog_city_picker, viewGroup, false);
        this.mContentView = viewInflate;
        return viewInflate;
    }

    @Override // com.alibaba.triver.basic.city.view.TRCTSideIndexBar.a
    public void onIndexChanged(String str, int i) {
        this.mAdapter.a(str);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.alibaba.triver.basic.city.widget.TRCityPickerDialogFragment.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || TRCityPickerDialogFragment.this.mTRCTOnPickListener == null) {
                    return false;
                }
                TRCityPickerDialogFragment.this.mTRCTOnPickListener.a();
                return false;
            }
        });
        measure();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(2);
            window.setGravity(80);
            window.setLayout(this.mWidth, this.mHeight - com.alibaba.triver.basic.city.c.a.a((Context) getActivity()));
            if (this.mEnableAnim) {
                window.setWindowAnimations(this.mAnimStyle);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        initViews();
    }

    @SuppressLint({"ResourceType"})
    public void setAnimationStyle(@StyleRes int i) {
        if (i <= 0) {
            i = this.mAnimStyle;
        }
        this.mAnimStyle = i;
    }

    public void setHotCities(List<c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mHotCities = list;
    }

    public void setLocatedCity(d dVar) {
        this.mLocatedCity = dVar;
    }

    public void setOnPickListener(com.alibaba.triver.basic.city.adapter.b bVar) {
        this.mTRCTOnPickListener = bVar;
    }

    public void setShowHotCities(boolean z) {
        this.mShowHotCities = z;
    }

    public void setShowLocationCity(boolean z) {
        this.mShowLocationCity = z;
    }
}
