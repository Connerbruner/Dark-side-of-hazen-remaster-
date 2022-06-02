class Main extends Tools{
    //items in loot tables
    //non healing
    ItemClass staplers = new ItemClass("staplers",5,10,1,5,50,100);
    ItemClass clean = new ItemClass("Cleaner",3,5,1,1,100,200);
    ItemClass ruler = new ItemClass("ruler",5,10,1,4,3,5);
    ItemClass binder = new ItemClass("binder",5,20,5,10,10,20);
    ItemClass scissors = new ItemClass("scissors",7,20,2,3,3,10);
    ItemClass waterBottle = new ItemClass("Water Bottle (attack)",1,20,2,7,2,12);
    ItemClass chromeBook = new ItemClass("chromeBook",7,20,2,3,1,2);
    ItemClass metalPiece = new ItemClass("metalPiece",1,25,1,25,1,50);
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
    public static void main(String[] args) {
        Tools tool = new Tools();

    }
}