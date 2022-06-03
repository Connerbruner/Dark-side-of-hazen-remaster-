class Gordy extends Tools {
    Hallway hallway;
    int HP;
    int level;
    boolean charge=false;
    public Gordy(Hallway start,int health,int power)
    {
        hallway=start;
        HP=health;
        level=power;
    }
    
    public int Attack()
    {
        int r=4;
        if(charge)
        {
            r = random(1,3);    
        }
        
        
        if(r==1)
        {
            sPrintln("DARK RUSH");
            int damage = 3*random(0,5);
            sPrintln("Gordy deals "+damage+" damage")
            return damage;
        }
        else if(r==2)
        {
            sPrintln("DOUBLE BLADE");
            int damage = 8*random(0,2);
            sPrintln("Gordy deals "+damage+" damage")
            return damage;
        }
        else if(r==3){
            sPrintln("FIRE BLADE OF DARKNESS");
            sPrintln("Gordy is charging");
            charge=true;
        }
        else {
            sPrintln("FIRE BLADE OF DARKNESS");
            int damage = 2*random(5,10);
            sPrintln("Gordy deals "+damage+" damage")
            return damage;
            }
    }
}