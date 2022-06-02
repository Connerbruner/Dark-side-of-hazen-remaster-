class Item extends Tools {
    int damage, speed, dur;
    String itemName;
    boolean isHeal;
    public Item(String name,int power, int move, int dura)
    {
        itemName = name;
        damage = power; 
        speed = move;
        dur = dura;
        isHeal = false;
    }
    public Item(String name,int power)
    {
        itemName = name;
        damage = power;
        dur=0;
        isHeal = true;
        
    }
    public String toString()
    {
        return itemName+" Power: "+damage+" Speed: "+speed+" durability: "+dur;
    }
    public int useItem()
    {
        if(isHeal && dur>0)
        {
                sPrintln("You heal "+damage+" damage");
                dur--;
                sPrintln(itemName+" just lost one durability\ndurability left: "+dur);
                return damage;

        }
        else if (dur>0)
        {
            int hit=damage*(random(2,4)/3);
            sPrintln("You deal "+hit+" damage");
            dur--;
            sPrintln(itemName+" just lost one durability\ndurability left: "+dur);
            return hit;
        }
        else
        {
           sPrintln("Cant use this Item no durability");
            return 0;
        }
    }

}