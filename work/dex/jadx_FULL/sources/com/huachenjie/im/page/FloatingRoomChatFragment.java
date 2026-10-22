package com.huachenjie.im.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.base.util.MaskUtil;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.adapter.FloatingChatRoomAdapter;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.databinding.FragmentFloatingSignalTowerBinding;
import com.huachenjie.im.page.base.BaseSignalTowerFragment;
import com.huachenjie.im.vm.BaseSignalTowerVM;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.zj.adlib.cr2;
import com.zj.adlib.dj1;
import com.zj.adlib.ee2;
import com.zj.adlib.f64;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.r90;
import com.zj.adlib.yk0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FloatingRoomChatFragment extends BaseSignalTowerFragment<BaseSignalTowerVM> {
    private ActivityResultLauncher<Intent> activityLauncher;
    private View centerLine;
    private FrameLayout container;
    private ValueAnimator hideAnimation;
    private LinearLayout mChatBox;
    private OnChatBoxScrollListener mChatBoxScrollListener;
    private ImageView mHideChatBox;
    private ImageView mShowChatBox;
    private OnViewCreateListener mViewCreateListener;
    private int maxChatBoxHeight;
    private int minChatBoxHeight;
    private ValueAnimator showAnimation;
    private RelativeLayout tabContainer;
    private View tabIndex;
    private TextView tabOvert;
    private TextView tabTeam;
    private final int[] mTabIndexOffsetX = new int[2];
    private Boolean sendCreateMessage = Boolean.FALSE;
    private int[] mPointOnScreen = null;

    public interface OnChatBoxScrollListener {
        void a(float f);
    }

    public interface OnViewCreateListener {
        void a();
    }

    public class a implements OnItemChildClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseQuickAdapter f34514a;

        public a(BaseQuickAdapter baseQuickAdapter) {
            this.f34514a = baseQuickAdapter;
        }

        @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
        public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
            int iX;
            ChatRoomMessage chatRoomMessage = ((FloatingChatRoomAdapter) this.f34514a).getData().get(i);
            if (16 == chatRoomMessage.getFromClientType() || (iX = dj1.x(chatRoomMessage)) == 1 || iX == 2) {
                return;
            }
            String fromAccount = chatRoomMessage.getFromAccount();
            if (((BaseSignalTowerVM) ((BaseVMFragment) FloatingRoomChatFragment.this).mState).j.getValue().getAccid().equals(fromAccount)) {
                return;
            }
            ((BaseSignalTowerVM) ((BaseVMFragment) FloatingRoomChatFragment.this).mState).k(fromAccount);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = FloatingRoomChatFragment.this.container.getHeight();
            FloatingRoomChatFragment floatingRoomChatFragment = FloatingRoomChatFragment.this;
            floatingRoomChatFragment.initMaxChatBoxHeight(height, floatingRoomChatFragment.container);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = FloatingRoomChatFragment.this.tabTeam.getWidth();
            int width2 = FloatingRoomChatFragment.this.tabOvert.getWidth();
            FloatingRoomChatFragment.this.centerLine.setTranslationX(width);
            FloatingRoomChatFragment.this.mTabIndexOffsetX[0] = (width - FloatingRoomChatFragment.this.tabIndex.getWidth()) / 2;
            FloatingRoomChatFragment.this.mTabIndexOffsetX[1] = width + ((width2 - FloatingRoomChatFragment.this.tabIndex.getWidth()) / 2);
            FloatingRoomChatFragment floatingRoomChatFragment = FloatingRoomChatFragment.this;
            if (floatingRoomChatFragment.showType != 2) {
                floatingRoomChatFragment.tabIndex.setTranslationX(FloatingRoomChatFragment.this.mTabIndexOffsetX[0]);
            } else if (((BaseSignalTowerVM) ((BaseVMFragment) floatingRoomChatFragment).mState).m.getValue().intValue() == 0) {
                FloatingRoomChatFragment.this.tabIndex.setTranslationX(FloatingRoomChatFragment.this.mTabIndexOffsetX[0]);
            } else {
                FloatingRoomChatFragment.this.tabIndex.setTranslationX(FloatingRoomChatFragment.this.mTabIndexOffsetX[1]);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.tabTeam) {
                ((BaseSignalTowerVM) ((BaseVMFragment) FloatingRoomChatFragment.this).mState).m.setValue(0);
            } else if (id == R.id.tabOvert) {
                ((BaseSignalTowerVM) ((BaseVMFragment) FloatingRoomChatFragment.this).mState).m.setValue(1);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatingRoomChatFragment.this.startHideAnimation();
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int width = FloatingRoomChatFragment.this.mChatBox.getWidth();
            if (FloatingRoomChatFragment.this.mChatBoxScrollListener != null) {
                FloatingRoomChatFragment.this.mChatBoxScrollListener.a(fFloatValue);
            }
            FloatingRoomChatFragment.this.mChatBox.setTranslationX((-width) * fFloatValue);
        }
    }

    public class g extends ee2 {
        public g() {
        }

        @Override // com.zj.adlib.ee2, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingRoomChatFragment.this.mShowChatBox.setTranslationY(FloatingRoomChatFragment.this.mChatBox.getHeight() - cr2.c(FloatingRoomChatFragment.this.container.getContext(), 26.0f));
            FloatingRoomChatFragment.this.mShowChatBox.setVisibility(0);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatingRoomChatFragment.this.startShowAnimation();
        }
    }

    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int width = FloatingRoomChatFragment.this.mChatBox.getWidth();
            if (FloatingRoomChatFragment.this.mChatBoxScrollListener != null) {
                FloatingRoomChatFragment.this.mChatBoxScrollListener.a(fFloatValue);
            }
            FloatingRoomChatFragment.this.mChatBox.setTranslationX((-width) * fFloatValue);
        }
    }

    public class j extends ee2 {
        public j() {
        }

        @Override // com.zj.adlib.ee2, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingRoomChatFragment.this.mShowChatBox.setVisibility(8);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initDrag(FragmentFloatingSignalTowerBinding fragmentFloatingSignalTowerBinding) {
        fragmentFloatingSignalTowerBinding.f9698a.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.jj3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f42601a.lambda$initDrag$4(view, motionEvent);
            }
        });
    }

    private void initHideAnimation(FragmentFloatingSignalTowerBinding fragmentFloatingSignalTowerBinding) {
        ImageView imageView = fragmentFloatingSignalTowerBinding.c;
        this.mHideChatBox = imageView;
        imageView.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMaxChatBoxHeight(int i2, FrameLayout frameLayout) {
        if (this.showType == 2) {
            this.maxChatBoxHeight = i2 - cr2.c(frameLayout.getContext(), 60.0f);
        } else {
            this.maxChatBoxHeight = i2 - cr2.c(frameLayout.getContext(), 24.0f);
        }
    }

    private void initShowAnimation(FragmentFloatingSignalTowerBinding fragmentFloatingSignalTowerBinding) {
        ImageView imageView = fragmentFloatingSignalTowerBinding.d;
        this.mShowChatBox = imageView;
        imageView.setVisibility(8);
        this.mShowChatBox.setOnClickListener(new h());
    }

    private void initTab(FragmentFloatingSignalTowerBinding fragmentFloatingSignalTowerBinding) {
        RelativeLayout relativeLayout = fragmentFloatingSignalTowerBinding.f9700a;
        this.tabContainer = relativeLayout;
        this.tabTeam = fragmentFloatingSignalTowerBinding.f9707b;
        this.tabOvert = fragmentFloatingSignalTowerBinding.f9701a;
        this.tabIndex = fragmentFloatingSignalTowerBinding.f9704a;
        this.centerLine = fragmentFloatingSignalTowerBinding.f34425a;
        int i2 = this.showType;
        if (i2 == 1) {
            relativeLayout.setVisibility(8);
            return;
        }
        if (i2 == 3) {
            relativeLayout.setVisibility(0);
            this.tabOvert.setVisibility(8);
            this.centerLine.setVisibility(8);
            this.tabIndex.setVisibility(8);
            return;
        }
        relativeLayout.setVisibility(0);
        this.tabContainer.postDelayed(new c(), 16L);
        d dVar = new d();
        this.tabTeam.setOnClickListener(dVar);
        this.tabOvert.setOnClickListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ActivityResult activityResult) {
        if (activityResult == null || activityResult.getResultCode() != -1 || activityResult.getData() == null) {
            return;
        }
        int intExtra = activityResult.getData().getIntExtra(BaseSignalTowerFragment.OVERT_TYPE, -1);
        if (intExtra == 0 || intExtra == 1) {
            ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).n.setValue(Integer.valueOf(intExtra));
        }
        int intExtra2 = activityResult.getData().getIntExtra(BaseSignalTowerFragment.TAB_INDEX, -1);
        if (intExtra2 == 0 || intExtra2 == 1) {
            ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(Integer.valueOf(intExtra2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$3(View view) {
        startSignalTower();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initDrag$4(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.maxChatBoxHeight <= 0) {
                initMaxChatBoxHeight(this.container.getHeight(), this.container);
            }
            if (this.mPointOnScreen == null) {
                int[] iArr = new int[2];
                this.mPointOnScreen = iArr;
                this.mChatBox.getLocationOnScreen(iArr);
            }
        } else if (action == 2) {
            int iRound = Math.round(motionEvent.getRawY() - this.mPointOnScreen[1]);
            int i2 = this.minChatBoxHeight;
            if (iRound < i2 || iRound > (i2 = this.maxChatBoxHeight)) {
                iRound = i2;
            }
            ViewGroup.LayoutParams layoutParams = this.mChatBox.getLayoutParams();
            layoutParams.height = iRound;
            this.mChatBox.setLayoutParams(layoutParams);
            smoothScrollToBottom();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeDataChange$1(Integer num) {
        if (num == null) {
            return;
        }
        onSelectedTabChange(num.intValue());
    }

    public static FloatingRoomChatFragment newInstance(String str, String str2, ArrayList<String> arrayList, String str3) {
        return newInstance(str, str2, Boolean.FALSE, 100, 100, arrayList, str3, Boolean.TRUE, 1, 0);
    }

    private void onSelectedTabChange(int i2) {
        if (this.showType != 2) {
            return;
        }
        if (i2 == 0) {
            this.tabTeam.setTypeface(Typeface.defaultFromStyle(1));
            this.tabOvert.setTypeface(Typeface.defaultFromStyle(0));
            this.tabIndex.setTranslationX(this.mTabIndexOffsetX[0]);
        } else if (i2 == 1) {
            this.tabTeam.setTypeface(Typeface.defaultFromStyle(0));
            this.tabOvert.setTypeface(Typeface.defaultFromStyle(1));
            this.tabIndex.setTranslationX(this.mTabIndexOffsetX[1]);
        }
    }

    private void smoothScrollToBottom() {
        if (((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue() == 0) {
            smoothScrollToBottom(this.mTeamRecycler);
            return;
        }
        if (((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue() == 1) {
            if (((BaseSignalTowerVM) ((BaseVMFragment) this).mState).n.getValue().intValue() == 0) {
                smoothScrollToBottom(this.mOvertRecycler);
            } else if (((BaseSignalTowerVM) ((BaseVMFragment) this).mState).n.getValue().intValue() == 1) {
                smoothScrollToBottom(this.mNationwideRecycler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHideAnimation() {
        if (this.hideAnimation == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.hideAnimation = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.hideAnimation.addUpdateListener(new f());
            this.hideAnimation.addListener(new g());
        }
        if (this.hideAnimation.isRunning()) {
            return;
        }
        this.hideAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShowAnimation() {
        if (this.showAnimation == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.showAnimation = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.showAnimation.addUpdateListener(new i());
            this.showAnimation.addListener(new j());
        }
        if (this.showAnimation.isRunning()) {
            return;
        }
        this.showAnimation.start();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_floating_signal_tower), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment, com.huachenjie.im.page.base.BaseRoomChatFragment
    public int getHistoryRoomChatNum(String str) {
        if (str.equals(this.teamId)) {
            if (this.sendCreateMessage.booleanValue()) {
                return 1;
            }
            return this.requestHistoryTeamChatNum;
        }
        if (str.equals(this.overtId) || str.equals(this.nationwideId)) {
            return this.requestHistoryOvertChatNum;
        }
        return 0;
    }

    public String getMineAccid() {
        IMTokenBean value = ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).j.getValue();
        return value == null ? "" : value.getAccid();
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment, com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        super.handleArguments(bundle);
        this.sendCreateMessage = Boolean.valueOf(bundle.getBoolean(UserConstants.CHAT_PARAMS.m));
    }

    public void hideRoomTab() {
        this.teamId = "";
        this.metaverseTeamCode = "";
        this.roomUserList = null;
        this.showType = 1;
        if (getBinding() != null && (getBinding() instanceof FragmentFloatingSignalTowerBinding)) {
            initTab((FragmentFloatingSignalTowerBinding) getBinding());
        }
        ((FloatingChatRoomAdapter) this.mTeamAdapter).l(this.showType == 1);
        ((FloatingChatRoomAdapter) this.mOvertAdapter).l(this.showType == 1);
        ((FloatingChatRoomAdapter) this.mNationwideAdapter).l(this.showType == 1);
        ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(1);
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment, com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(Bundle bundle) {
        super.init(bundle);
        this.activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.hj3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f42135a.lambda$init$0((ActivityResult) obj);
            }
        });
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment
    public void initChatRecycler(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter) {
        super.initChatRecycler(recyclerView, baseQuickAdapter);
        baseQuickAdapter.addChildClickViewIds(R.id.tvName);
        ((FloatingChatRoomAdapter) baseQuickAdapter).l(this.showType == 1);
        baseQuickAdapter.setOnItemChildClickListener(new a(baseQuickAdapter));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        if (getBinding() != null && (getBinding() instanceof FragmentFloatingSignalTowerBinding)) {
            FragmentFloatingSignalTowerBinding fragmentFloatingSignalTowerBinding = (FragmentFloatingSignalTowerBinding) getBinding();
            FrameLayout frameLayout = fragmentFloatingSignalTowerBinding.f9697a;
            this.container = frameLayout;
            this.mChatBox = fragmentFloatingSignalTowerBinding.f9699a;
            frameLayout.post(new b());
            initDrag(fragmentFloatingSignalTowerBinding);
            initTab(fragmentFloatingSignalTowerBinding);
            initShowAnimation(fragmentFloatingSignalTowerBinding);
            initHideAnimation(fragmentFloatingSignalTowerBinding);
            this.mTeamRecycler = fragmentFloatingSignalTowerBinding.f9709c;
            FloatingChatRoomAdapter floatingChatRoomAdapter = new FloatingChatRoomAdapter();
            this.mTeamAdapter = floatingChatRoomAdapter;
            initChatRecycler(this.mTeamRecycler, floatingChatRoomAdapter);
            this.mOvertRecycler = fragmentFloatingSignalTowerBinding.f9708b;
            FloatingChatRoomAdapter floatingChatRoomAdapter2 = new FloatingChatRoomAdapter();
            this.mOvertAdapter = floatingChatRoomAdapter2;
            initChatRecycler(this.mOvertRecycler, floatingChatRoomAdapter2);
            this.mNationwideRecycler = fragmentFloatingSignalTowerBinding.f9702a;
            FloatingChatRoomAdapter floatingChatRoomAdapter3 = new FloatingChatRoomAdapter();
            this.mNationwideAdapter = floatingChatRoomAdapter3;
            initChatRecycler(this.mNationwideRecycler, floatingChatRoomAdapter3);
            int i2 = this.showType;
            if (i2 == 1 || i2 == 2) {
                ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(1);
            } else {
                ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(0);
            }
            if (this.mRoomChatType != 6 && r90.w().booleanValue()) {
                MaskUtil.g(getActivity(), this.container.findViewById(R.id.ivExpand), R.layout.mask_floating_room_chat, new View.OnClickListener() { // from class: com.zj.adlib.fj3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r90.a0();
                    }
                });
            }
            fragmentFloatingSignalTowerBinding.f9705b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gj3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41919a.lambda$initDataAfterView$3(view);
                }
            });
            int i3 = this.mRoomChatType;
            if (i3 == 6) {
                fragmentFloatingSignalTowerBinding.f9707b.setText("我的宿舍");
                fragmentFloatingSignalTowerBinding.f9701a.setText("全国宿舍");
            } else if (i3 == 5) {
                fragmentFloatingSignalTowerBinding.f9701a.setText("附近");
            } else {
                fragmentFloatingSignalTowerBinding.f9701a.setText("公开");
            }
            if (this.mRoomChatType == 6) {
                ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(0);
            }
        }
        this.minChatBoxHeight = cr2.c(this.container.getContext(), 190.0f);
        if (getArguments() != null) {
            ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).n.setValue(Integer.valueOf(getArguments().getInt(BaseSignalTowerFragment.OVERT_TYPE, 0)));
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void observeDataChange() {
        ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.observe(this, new Observer() { // from class: com.zj.adlib.ij3
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f42368a.lambda$observeDataChange$1((Integer) obj);
            }
        });
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment, com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        f64.b().a();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        OnViewCreateListener onViewCreateListener = this.mViewCreateListener;
        if (onViewCreateListener != null) {
            onViewCreateListener.a();
        }
    }

    public void setMetaverseTeamCode(String str) {
        this.metaverseTeamCode = str;
    }

    public void setOnChatBoxScrollListener(OnChatBoxScrollListener onChatBoxScrollListener) {
        this.mChatBoxScrollListener = onChatBoxScrollListener;
    }

    public void setRoomUserList(ArrayList<String> arrayList) {
        this.roomUserList = arrayList;
    }

    public void setViewCreateListener(OnViewCreateListener onViewCreateListener) {
        this.mViewCreateListener = onViewCreateListener;
    }

    public void showRoomTab(String str) {
        showRoomTab(str, Boolean.FALSE);
    }

    public void startSignalTower() {
        try {
            Postcard postcardWithInt = ARouter.getInstance().build(RoutePathConstants.IM.c).withString("teamId", this.teamId).withString(UserConstants.CHAT_PARAMS.j, this.overtId).withInt(UserConstants.CHAT_PARAMS.o, this.requestHistoryTeamChatNum).withInt(UserConstants.CHAT_PARAMS.p, this.requestHistoryOvertChatNum).withStringArrayList(UserConstants.CHAT_PARAMS.k, this.roomUserList).withString(UserConstants.CHAT_PARAMS.l, this.metaverseTeamCode).withBoolean(UserConstants.CHAT_PARAMS.q, this.hideNationwide.booleanValue()).withInt(UserConstants.CHAT_PARAMS.n, this.mRoomChatType).withInt(BaseSignalTowerFragment.TAB_INDEX, ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue()).withInt(BaseSignalTowerFragment.OVERT_TYPE, ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).n.getValue().intValue());
            LogisticsCenter.completion(postcardWithInt);
            Intent intent = new Intent(getContext(), postcardWithInt.getDestination());
            intent.putExtras(postcardWithInt.getExtras());
            this.activityLauncher.launch(intent);
            getActivity().overridePendingTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out);
        } catch (Exception unused) {
        }
    }

    public static FloatingRoomChatFragment newInstance(String str, String str2, Boolean bool, ArrayList<String> arrayList, String str3) {
        return newInstance(str, str2, bool, 100, 100, arrayList, str3, Boolean.FALSE, 2, 1);
    }

    public void showRoomTab(String str, Boolean bool) {
        i4a.a("showRoomTab:" + bool);
        this.teamId = str;
        this.showType = 2;
        if (getBinding() != null && (getBinding() instanceof FragmentFloatingSignalTowerBinding)) {
            initTab((FragmentFloatingSignalTowerBinding) getBinding());
        }
        ((FloatingChatRoomAdapter) this.mTeamAdapter).l(this.showType == 1);
        ((FloatingChatRoomAdapter) this.mOvertAdapter).l(this.showType == 1);
        ((FloatingChatRoomAdapter) this.mNationwideAdapter).l(this.showType == 1);
        this.sendCreateMessage = bool;
        this.mTeamAdapter.setList(null);
        enterChatRoomAndRefreshHistory(str);
        ((BaseSignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(0);
    }

    public static FloatingRoomChatFragment newInstance(String str, String str2, Boolean bool, ArrayList<String> arrayList, String str3, Boolean bool2) {
        return newInstance(str, str2, bool, 100, 100, arrayList, str3, bool2, 3, 0);
    }

    public static FloatingRoomChatFragment newInstance(String str, int i2, Boolean bool) {
        return newInstance("", str, Boolean.FALSE, 0, i2, null, "", bool, 4, 0);
    }

    public static FloatingRoomChatFragment newInstance(String str, String str2, Boolean bool, ArrayList<String> arrayList, String str3, Boolean bool2, int i2, int i3) {
        return newInstance(str, str2, bool, 100, 100, arrayList, str3, bool2, i2, i3);
    }

    private static FloatingRoomChatFragment newInstance(String str, String str2, Boolean bool, int i2, int i3, ArrayList<String> arrayList, String str3, Boolean bool2, int i4, int i5) {
        FloatingRoomChatFragment floatingRoomChatFragment = new FloatingRoomChatFragment();
        Bundle bundleCreateArguments = BaseSignalTowerFragment.createArguments(str, str2, i2, i3, arrayList, str3, bool2, i4);
        bundleCreateArguments.putBoolean(UserConstants.CHAT_PARAMS.m, bool.booleanValue());
        bundleCreateArguments.putInt(BaseSignalTowerFragment.OVERT_TYPE, i5);
        floatingRoomChatFragment.setArguments(bundleCreateArguments);
        return floatingRoomChatFragment;
    }
}
