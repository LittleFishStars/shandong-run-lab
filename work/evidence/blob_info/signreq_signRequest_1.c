
undefined8 FUN_0034926c(long *param_1,undefined8 param_2,long param_3,undefined4 param_4)

{
  ulong uVar1;
  long lVar2;
  int iVar3;
  undefined8 uVar4;
  byte local_60 [16];
  ulong local_50;
  long local_48;
  
  lVar2 = tpidr_el0;
  local_48 = *(long *)(lVar2 + 0x28);
  if (param_3 == 0) {
    uVar4 = (**(code **)(*param_1 + 0x538))(param_1,&DAT_004abd98);
    if (*(long *)(lVar2 + 0x28) != local_48) goto LAB_0034938c;
  }
  else {
    uVar4 = (**(code **)(*param_1 + 0x548))(param_1,param_3,0);
    iVar3 = (**(code **)(*param_1 + 0x540))(param_1,param_3);
    FUN_0034b820(local_60,uVar4,(long)iVar3,param_4);
    (**(code **)(*param_1 + 0x550))(param_1,param_3,uVar4);
    uVar1 = (ulong)local_60 | 1;
    if ((local_60[0] & 1) != 0) {
      uVar1 = local_50;
    }
    uVar4 = (**(code **)(*param_1 + 0x538))(param_1,uVar1);
    if ((local_60[0] & 1) != 0) {
      FUN_00478110(local_50);
    }
    if (*(long *)(lVar2 + 0x28) != local_48) {
LAB_0034938c:
                    /* WARNING: Subroutine does not return */
      __stack_chk_fail();
    }
  }
  return uVar4;
}

