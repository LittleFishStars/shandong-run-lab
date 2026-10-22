
undefined8 FUN_0036aed4(void)

{
  int iVar1;
  undefined8 uVar2;
  
  if (((DAT_005d2738 & 1) == 0) && (iVar1 = FUN_00475d10(&DAT_005d2738), iVar1 != 0)) {
    uVar2 = FUN_004780a8(0x248);
    FUN_0036ad00(uVar2);
    DAT_005d2730 = uVar2;
    FUN_00475dcc(&DAT_005d2738);
  }
  return DAT_005d2730;
}

