class Game extends Tools {
    
    //items in loot tables
    //non-healing
    ItemClass staplers = new ItemClass("staplers",5,10,50,100);
    ItemClass clean = new ItemClass("Cleaner",3,5,100,200);
    ItemClass ruler = new ItemClass("ruler",5,10,3,5);
    ItemClass binder = new ItemClass("binder",5,20,10,20);
    ItemClass scissors = new ItemClass("scissors",7,20,3,10);
    ItemClass waterBottle = new ItemClass("Water Bottle (attack)",1,20,2,12);
    ItemClass chromeBook = new ItemClass("chromeBook",10,20,1,2);
    ItemClass metalPiece = new ItemClass("metalPiece",1,20,1,50);
    //healing
    ItemClass soda = new ItemClass("Soda",5,10);
    ItemClass chip = new ItemClass("Chip bag",7,12);
    ItemClass water = new ItemClass("Water bottle (heal)",6,10);
    ItemClass lunch = new ItemClass("School lunch",1,20);

    //Item-class array
    ItemClass[] classroom = {water,waterBottle,clean,ruler,binder,scissors,chromeBook,staplers};
    ItemClass[] gym = {water,waterBottle,binder,scissors,chromeBook};
    ItemClass[] metal = {water,waterBottle,chromeBook,metalPiece};
    ItemClass[] court = {water,waterBottle};
    ItemClass[] main = {soda,lunch,chip,water,waterBottle};

    

    //Hallways
    Hallway hallway200 = new Hallway("200s",classroom);
    Hallway hallway100 = new Hallway("100s",classroom);
    Hallway hallway700 = new Hallway("700s",metal);
    Hallway hallwayD200 = new Hallway("D200s",classroom);
    Hallway hallwayD100 = new Hallway("D100s",classroom);
    Hallway hallway500 = new Hallway("500",gym);
    Hallway swim = new Hallway("swim hallway",gym);
    Hallway commons = new Hallway("Commons",main);
    Hallway courtYard = new Hallway("courtYard",court);
    Hallway robotics = new Hallway("Robotics Room",metal);
    
    Hallway[] neighborCommon = {hallwayD200,hallway100,hallway200,hallway500};
    Hallway[] neighborD200={commons,hallwayD100,hallway700,courtYard};
    Hallway[] neighborD100={hallwayD200,hallway200};
    Hallway[] neighbor200 ={hallway100,commons,hallwayD200};
    Hallway[] neighbor100={courtYard,hallway200,commons};
    Hallway[] neighbor500={swim,commons};
    Hallway[] neighbor700={courtYard,hallwayD200,robotics};
    Hallway[] neighborSwim={hallway500,hallwayD200};
    Hallway[] neighborRobot={hallway700};
    Hallway[] neighborCourt={hallway100,hallway700};
    Gordy gordy = new Gordy(hallway700,100,3);

    //you
    Hallway current = commons;
    Item[] backpack = new Item[3];
    int HP=50;
    int HPM=50;

    public void game()
    {
        commons.setNeighbors(neighborCommon);
        hallwayD200.setNeighbors(neighborD200);
        hallwayD100.setNeighbors(neighborD100);
        hallway200.setNeighbors(neighbor200);
        hallway100.setNeighbors(neighbor100);
        hallway500.setNeighbors(neighbor500);
        hallway700.setNeighbors(neighbor700);
        swim.setNeighbors(neighborSwim);
        robotics.setNeighbors(neighborRobot);
        courtYard.setNeighbors(neighborCourt);
        for(int turn=1; HP>0; turn++)
        {
            System.out.print(SCREEN_CLEAR);
            sPrint("Turn "+turn);
            sPrint("What would you like to do? (pick 2 different ones)");
            sPrint("1) loot\n2) use item\n3) move");
            int action1=scanner.nextInt();
            int action2=scanner.nextInt();
            while(action2==action1)
            {
                action2=scanner.nextInt();
            }
            
            if(action1==1 || action2==1)
            {
                find();
            }
            if(action1==2 || action2==2)
            {
                useItem();
            }
            if(action1==3 || action2==3)
            {
                current = current.move();
            }
            gordy.move();
            if(gordy.hallway.hallwayName.equals(current.hallwayName))
            {
                HP-= gordy.Attack();
            }
                
        }
    }
    public void find()
    {
        Item temp =current.loot();
        sPrint(packToString());
        System.out.println();
        sPrint(temp.toString());
        if(choice("Want to this item"))
        {
            sPrint("What slot 0-2");
            backpack[scanner.nextInt()] = temp;
            
        }
    }
    public String packToString()
    {
        return "Current items\nSlot 0: "+backpack[0]+"\nSlot 1: "+backpack[1]+"\nSlot 2: "+backpack[2];
    }
    
    public void useItem()
    {
        sPrint(packToString());
        sPrint("What slot 0-2");
        int i = scanner.nextInt();
        Item use = backpack[i];
        if(use!=null)
        {
            if(use.isHeal)
            {
               if(HP!=HPM)
               {
                   HP+=use.useItem();
                   backpack[i]=null;
               }
            }
            else if(gordy.hallway.hallwayName.equals(current.hallwayName)) {
                gordy.HP-=backpack[i].useItem();
            }
        }
        else
        {
            sPrint("No item to use");
        }

    }
    
}