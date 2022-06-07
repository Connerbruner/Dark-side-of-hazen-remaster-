class Gordy extends Tools {
    Hallway hallway;
    int HP;
    boolean charge=false;
    public Gordy(Hallway start,int health,int power)
    {
        hallway=start;
        HP=health;
    }
    
    public int Attack(int block)
    {
        int r=4;
        if(!charge)
        {
            r = random(1,3);
        }
        if(r==1)
        {
            sPrintln("DARK RUSH");
            int damage = 3*random(0,5);
            sPrintln("Gordy deals "+damage+" damage");
            return damage-block;
        }
        else if(r==2)
        {
            sPrintln("DOUBLE BLADE");
            int damage = 8*random(0,2);
            sPrintln("Gordy deals "+damage+" damage");
            return damage-block;
        }
        else if(r==3){
            sPrintln("FIRE BLADE OF DARKNESS");
            sPrintln("Gordy is charging");
            charge=true;
        }
        else {
            sPrintln("FIRE BLADE OF DARKNESS");
            int damage = 2*random(5,10);
            sPrintln("Gordy deals "+damage+" damage");
            charge=false;
            return damage-block;
            }
        return 0;
    }
    public void move(Hallway cur) {
        //moves like nomral
        int i;
        for( i=0; hallway.neighbors[i].hallwayName.equals(cur.hallwayName) && i<hallway.neighbors.length; i++);
        if(hallway.neighbors[i].hallwayName.equals(cur.hallwayName))
        {
            hallway=hallway.neighbors[i];
        }
        else {
            Hallway temp=hallway.neighbors[random(0,hallway.neighbors.length-1)];
            hallway=temp;
            //moves foward but never back
            temp=hallway.neighbors[random(0,hallway.neighbors.length-1)];

            while(temp.hallwayName.equals(hallway.hallwayName))
            {
                temp=hallway.neighbors[random(0,hallway.neighbors.length-1)];
            }
            hallway=temp;

        }
        }
    

        
    }
