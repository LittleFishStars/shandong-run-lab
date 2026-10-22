
void FUN_0034b820(undefined8 *param_1,void *param_2,ulong param_3,undefined4 param_4)

{
  long lVar1;
  undefined8 uVar2;
  size_t sVar3;
  ulong *puVar4;
  long *plVar5;
  undefined8 *puVar6;
  long lVar7;
  void *__dest;
  char *__s;
  ulong uVar8;
  code *pcVar9;
  ulong local_b0;
  ulong local_a8;
  void *local_a0;
  byte local_98 [16];
  undefined8 local_88;
  ulong local_80;
  ulong uStack_78;
  ulong local_70;
  undefined4 local_68;
  undefined1 local_64;
  undefined1 local_63;
  undefined1 local_62;
  undefined1 local_61;
  undefined1 local_60;
  long local_58;
  
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  if ((DAT_005d26c8 & 1) == 0) {
    *param_1 = 0;
    param_1[1] = 0;
    param_1[2] = 0;
    goto LAB_0034ba18;
  }
  uVar2 = FUN_0036aed4();
  local_68 = 0x6a;
  lVar7 = 0;
  local_64 = 6;
  local_63 = 0x18;
  local_62 = 9;
  local_61 = 0x32;
  __s = (char *)((ulong)&local_68 | 4);
  do {
    __s[lVar7] = __s[lVar7] ^ (char)lVar7 + 0x6aU;
    lVar7 = lVar7 + 1;
  } while (lVar7 != 4);
  local_60 = 0;
  FUN_00473cdc(local_98,param_4);
                    /* try { // try from 0034b904 to 0044b90f has its CatchHandler @ 0034c598 */
  sVar3 = strlen(__s);
  puVar4 = (ulong *)FUN_00127e44(local_98,0,__s,sVar3);
  local_70 = puVar4[2];
  uStack_78 = puVar4[1];
  local_80 = *puVar4;
  *puVar4 = 0;
  puVar4[1] = 0;
  puVar4[2] = 0;
  FUN_0036b93c(uVar2,&local_80);
  if ((local_80 & 1) != 0) {
    FUN_00478110(local_70);
  }
  if ((local_98[0] & 1) != 0) {
    FUN_00478110(local_88);
  }
  plVar5 = (long *)FUN_00178090();
  (**(code **)(*plVar5 + 0x10))(plVar5,param_4,0xffffffff);
  puVar6 = (undefined8 *)FUN_00178090();
  pcVar9 = *(code **)*puVar6;
  local_b0 = 0;
  local_a8 = 0;
  local_a0 = (void *)0x0;
  if (0xffffffffffffffef < param_3) {
                    /* WARNING: Subroutine does not return */
    FUN_0011ebc8(&local_b0);
  }
  if (param_3 < 0x17) {
    __dest = (void *)((ulong)&local_b0 | 1);
    local_b0 = (param_3 & 0x7f) << 1;
    if (param_3 != 0) goto LAB_0034b9e4;
  }
  else {
    uVar8 = param_3 + 0x10 & 0xfffffffffffffff0;
    __dest = (void *)FUN_004780a8(uVar8);
    local_b0 = uVar8 | 1;
    local_a8 = param_3;
    local_a0 = __dest;
LAB_0034b9e4:
    memcpy(__dest,param_2,param_3);
  }
  *(undefined1 *)((long)__dest + param_3) = 0;
  (*pcVar9)(param_1,puVar6,&local_b0);
  if ((local_b0 & 1) != 0) {
    FUN_00478110(local_a0);
  }
LAB_0034ba18:
  if (*(long *)(lVar1 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}

