class ItemClass extends Tools {
    int damageLow, damageHigh, durLow, durHigh;
    String itemName;
    boolean isHeal;

    public ItemClass(String name, int damageL, int damageH, int durL, int durH) {
        itemName = name;
        damageLow = damageL;
        damageHigh = damageH;
        durLow = durL;
        durHigh = durH;
        isHeal = false;
    }

    public ItemClass(String name, int damageL, int damageH) {
        itemName = name;
        damageLow = damageL;
        damageHigh = damageH;
        isHeal = true;
    }

    public Item createRandomItem() {
        if(isHeal)
        {
            return new Item(itemName, random(damageLow, damageHigh));
        }
        return new Item(itemName, random(damageLow, damageHigh), random(durLow, durHigh));
    }


}