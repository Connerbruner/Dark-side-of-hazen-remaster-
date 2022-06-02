class Main extends Tools{
    //items in loot tables
    //non healing
    ItemClass staplers = new ItemClass("staplers",5,10,1,5,50,100);
    ItemClass clean = new ItemClass("Cleaner",3,5,1,1,100,200);
    ItemClass ruler = new ItemClass("ruler",5,10,1,4,3,5);
    ItemClass binder = new ItemClass("binder",5,20,5,10,10,20);
    ItemClass scissors = new ItemClass("scissors",7,20,2,3,3,10);
    ItemClass waterBottle = new ItemClass("Water Bottle",1,20,2,7,2,12);
    ItemClass chromeBook = new ItemClass("chromeBook",7,20,2,3,1,2);
    ItemClass metalPiece = new ItemClass("metalPiece",1,25,1,25,1,50);
    //healing
    ItemClass soda = new ItemClass("Soda",5,10);
    ItemClass chip = new ItemClass("Chip bag",7,12);
    
    
    //Hallways
    Hallway hallway200 = new Hallway("200s",);
    Hallway hallway100 = new Hallway("100s",);
    Hallway hallway700 = new Hallway("700s",);
    Hallway hallwayD200 = new Hallway("200s",);
    Hallway hallwayD100 = new Hallway("100s",);
    Hallway hallway500 = new Hallway("500",);
    Hallway swim = new Hallway("swim hallway",);
    Hallway commons = new Hallway("Commons",);
    Hallway courtYard = new Hallway("courtYard",);
    Hallway Robotics = new Hallway("Robotics Room",);
    
    
    Hallway[] all = {};
    
    public static void main(String[] args) {
        Tools tool = new Tools();
        tool.sPrintln("???: braden");
        tool.sPrintln("???: braden");
        tool.sPrintln("???: braden");
        tool.sPrintln("???: braden");
        tool.sPrintln("???: braden");
        tool.sPrintln("???: braden");
    }
}