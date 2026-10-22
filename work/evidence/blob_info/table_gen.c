
void FUN_00348470(undefined8 param_1,undefined8 param_2)

{
  long lVar1;
  undefined *puVar2;
  int iVar3;
  long *plVar4;
  undefined8 uVar5;
  long lVar6;
  undefined1 auStack_98 [8];
  undefined1 auStack_90 [8];
  undefined1 auStack_88 [32];
  undefined1 auStack_68 [32];
  long local_48;
  
  lVar1 = tpidr_el0;
  local_48 = *(long *)(lVar1 + 0x28);
  FUN_0041cadc();
  iVar3 = pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_005d2574);
  if ((DAT_005d2570._1_1_ & 1) == 0) {
    plVar4 = (long *)FUN_003af0d0(iVar3);
    (**(code **)(*plVar4 + 0xd0))();
    puVar2 = PTR_DAT_00577ea0;
    (**(code **)(*(long *)PTR_DAT_00577ea0 + 0x1f0))(auStack_90,0,PTR_FUN_005778f0,0);
    (**(code **)(*(long *)puVar2 + 0x1f0))(auStack_98,0,PTR_FUN_00577cb0,0);
    DAT_005d2570._1_1_ = 1;
    FUN_002b3c30(auStack_68,param_1,0);
    uVar5 = FUN_0036aed4();
    FUN_002b3b38(auStack_88,auStack_68);
    FUN_0036b568(uVar5,auStack_88);
    FUN_002b5c90(auStack_88);
    lVar6 = FUN_0036aed4();
    *(undefined8 *)(lVar6 + 0x148) = param_2;
    FUN_002b5c90(auStack_68);
  }
  iVar3 = pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_005d2574);
  if (*(long *)(lVar1 + 0x28) == local_48) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(iVar3);
}

