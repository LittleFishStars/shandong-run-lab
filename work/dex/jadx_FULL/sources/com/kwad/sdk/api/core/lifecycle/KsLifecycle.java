package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.GenericLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class KsLifecycle {
    private Lifecycle mBase;

    @Keep
    public enum KsLifeEvent {
        ON_CREATE(Lifecycle.Event.ON_CREATE),
        ON_START(Lifecycle.Event.ON_START),
        ON_RESUME(Lifecycle.Event.ON_RESUME),
        ON_PAUSE(Lifecycle.Event.ON_PAUSE),
        ON_STOP(Lifecycle.Event.ON_STOP),
        ON_DESTROY(Lifecycle.Event.ON_DESTROY),
        ON_ANY(Lifecycle.Event.ON_ANY);

        Lifecycle.Event mRealValue;

        KsLifeEvent(Lifecycle.Event event) {
            this.mRealValue = event;
        }

        public static KsLifeEvent createfrom(Lifecycle.Event event) {
            for (KsLifeEvent ksLifeEvent : values()) {
                if (ksLifeEvent.getReal() == event) {
                    return ksLifeEvent;
                }
            }
            return null;
        }

        @Keep
        public final Lifecycle.Event getReal() {
            return this.mRealValue;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DESTROYED' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class KsLifeState {
        private static final /* synthetic */ KsLifeState[] $VALUES;
        public static final KsLifeState CREATED;
        public static final KsLifeState DESTROYED;
        public static final KsLifeState INITIALIZED;
        public static final KsLifeState RESUMED;
        public static final KsLifeState STARTED;
        Lifecycle.State mReal;

        static {
            Lifecycle.State state = Lifecycle.State.DESTROYED;
            KsLifeState ksLifeState = new KsLifeState("DESTROYED", 0, state);
            DESTROYED = ksLifeState;
            KsLifeState ksLifeState2 = new KsLifeState("INITIALIZED", 1, state);
            INITIALIZED = ksLifeState2;
            KsLifeState ksLifeState3 = new KsLifeState("CREATED", 2, state);
            CREATED = ksLifeState3;
            KsLifeState ksLifeState4 = new KsLifeState("STARTED", 3, state);
            STARTED = ksLifeState4;
            KsLifeState ksLifeState5 = new KsLifeState("RESUMED", 4, state);
            RESUMED = ksLifeState5;
            $VALUES = new KsLifeState[]{ksLifeState, ksLifeState2, ksLifeState3, ksLifeState4, ksLifeState5};
        }

        private KsLifeState(String str, int i, Lifecycle.State state) {
            super(str, i);
            this.mReal = state;
        }

        public static KsLifeState createFrom(Lifecycle.State state) {
            for (KsLifeState ksLifeState : values()) {
                if (ksLifeState.mReal == state) {
                    return ksLifeState;
                }
            }
            return null;
        }

        public static KsLifeState valueOf(String str) {
            return (KsLifeState) Enum.valueOf(KsLifeState.class, str);
        }

        public static KsLifeState[] values() {
            return (KsLifeState[]) $VALUES.clone();
        }

        public final boolean isAtLeast(@NonNull KsLifeState ksLifeState) {
            return compareTo(ksLifeState) >= 0;
        }
    }

    public KsLifecycle(Lifecycle lifecycle) {
        this.mBase = lifecycle;
    }

    @MainThread
    public void addObserver(@NonNull final KsLifecycleObserver ksLifecycleObserver) {
        if (ksLifecycleObserver instanceof KsGenericLifecycleObserver) {
            GenericLifecycleObserver genericLifecycleObserver = new GenericLifecycleObserver() { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                @Override // androidx.p002lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ((KsGenericLifecycleObserver) ksLifecycleObserver).onStateChanged(KsLifeEvent.createfrom(event));
                }
            };
            ksLifecycleObserver.setBase(genericLifecycleObserver);
            this.mBase.addObserver(genericLifecycleObserver);
        }
    }

    @MainThread
    public KsLifeState getCurrentState() {
        return KsLifeState.createFrom(this.mBase.getState());
    }

    @MainThread
    public void removeObserver(@NonNull KsLifecycleObserver ksLifecycleObserver) {
        this.mBase.removeObserver(ksLifecycleObserver.getBase());
    }
}
