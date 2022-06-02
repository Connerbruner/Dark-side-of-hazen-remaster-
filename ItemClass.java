class ItemClass extends Tools{
    int damageLow, damageHigh,  speedLow,  speedHigh,  durLow,  durHigh;
    String itemName;
    boolean isHeal;
    public ItemClass(String name,int damageL,int damageH, int speedL, int speedH, int durL, int durH)
    {
        itemName=name;
        damageLow = damageL;
        damageHigh = damageH;
        speedLow = speedL;
        speedHigh = speedH;
        durLow = durL;
        durHigh = durH;
        isHeal=false;
    }
    public ItemClass(String name,int damageL,int damageH)
    {
        itemName=name;
        damageLow = damageL;
        damageHigh = damageH;
        isHeal=true;
    }
    public Item createRandomWeapon()
    {
    return new Item(itemName,random(damageLow,damageHigh),random(speedLow,speedHigh),random(durLow,durHigh));
    }
    public Item createRandomItem()
    {
        return new Item(itemName,random(damageLow,damageHigh));
    }
    
}