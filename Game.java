class Game extends Tools {

    //items in loot tables
    //non-healing
    ItemClass staplers = new ItemClass("staplers", 5, 10, 50, 100);
    ItemClass clean = new ItemClass("Cleaner", 3, 5, 100, 200);
    ItemClass ruler = new ItemClass("ruler", 5, 10, 3, 5);
    ItemClass binder = new ItemClass("binder", 5, 20, 10, 20);
    ItemClass scissors = new ItemClass("scissors", 7, 20, 3, 10);
    ItemClass waterBottle = new ItemClass("Water Bottle (attack)", 1, 20, 2, 12);
    ItemClass chromeBook = new ItemClass("chromeBook", 10, 20, 1, 2);
    ItemClass metalPiece = new ItemClass("metalPiece", 1, 20, 1, 50);
    //healing
    ItemClass soda = new ItemClass("Soda", 5, 10);
    ItemClass chip = new ItemClass("Chip bag", 7, 12);
    ItemClass water = new ItemClass("Water bottle (heal)", 6, 10);
    ItemClass lunch = new ItemClass("School lunch", 1, 20);

    //Item-class array
    ItemClass[] classroom = {water, waterBottle, clean, ruler, binder, scissors, chromeBook, staplers};
    ItemClass[] gym = {water, waterBottle, chromeBook};
    ItemClass[] metal = {water, waterBottle, chromeBook, metalPiece};
    ItemClass[] court = {water, waterBottle};
    ItemClass[] main = {soda, lunch, chip, water, waterBottle};
    ItemClass[] outSide = {soda, chip, lunch, water, waterBottle, chromeBook};


    //Hallways
    Hallway hallway200 = new Hallway("200s", classroom);
    Hallway hallway100 = new Hallway("100s", classroom);
    Hallway hallway700 = new Hallway("700s", metal);
    Hallway hallwayD200 = new Hallway("D200s", classroom);
    Hallway hallwayD100 = new Hallway("D100s", classroom);
    Hallway hallway500 = new Hallway("500", gym);
    Hallway swim = new Hallway("swim hallway", gym, false);
    Hallway commons = new Hallway("Commons", main);
    Hallway courtYard = new Hallway("courtYard", court);
    Hallway robotics = new Hallway("Robotics Room", metal, false);

    Hallway footBall = new Hallway("Football field", outSide, false);
    Hallway track = new Hallway("Track field", outSide, false);
    Hallway parkingLotBus = new Hallway("Parking lot (Bus)", outSide, false);
    Hallway parkingLotSenior = new Hallway("Parking lot (Senior)", outSide, false);
    Hallway parkingLotBack = new Hallway("Parking lot (Back)", outSide, false);

    //hallway[]
    Hallway[] neighborCommon = {hallwayD200, hallway100, hallway200, hallway500, parkingLotSenior};
    Hallway[] neighborD200 = {commons, hallwayD100, hallway700, courtYard};
    Hallway[] neighborD100 = {hallwayD200, hallway200};
    Hallway[] neighbor200 = {hallway100, commons, hallwayD200, parkingLotBack};
    Hallway[] neighbor100 = {courtYard, hallway200, commons, parkingLotSenior};
    Hallway[] neighbor500 = {swim, commons, parkingLotBus};
    Hallway[] neighbor700 = {courtYard, hallwayD200, robotics, parkingLotBack};
    Hallway[] neighborSwim = {hallway500, hallwayD200, parkingLotBus};
    Hallway[] neighborRobot = {hallway700};
    Hallway[] neighborCourt = {hallway100, hallway700, parkingLotSenior};

    Hallway[] neighborFootBall = {parkingLotBack};
    Hallway[] neighborBack = {footBall, track, parkingLotSenior};
    Hallway[] neighborSenior = {parkingLotBack, parkingLotBus, hallway100, commons};
    Hallway[] neighborBus = {hallway500, track, parkingLotSenior};
    Hallway[] neighborTrack = {parkingLotBack, parkingLotBus};

    Gordy gordy = new Gordy(hallway700, 100, 3);

    Goal[] allGoals = {
            new Goal("Get the robotics key in 200s", hallway200),
            new Goal("Go to the robotics room and ", robotics),
            new Goal("Go to the swimming hall and exit the building", swim),
    };

    //you
    Hallway current = commons;
    Item[] backpack = new Item[3];
    int HP = 50;
    int HPM = 50;

    public void game() {
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
        footBall.setNeighbors(neighborFootBall);
        parkingLotBack.setNeighbors(neighborBack);
        parkingLotSenior.setNeighbors(neighborSenior);
        parkingLotBus.setNeighbors(neighborBus);
        track.setNeighbors(neighborTrack);
        for (int turn = 1; HP > 0 && gordy.HP > 0; turn++) {
            System.out.print(SCREEN_CLEAR);
            sPrint("Turn " + turn);
            sPrint("What would you like to do? (pick 2 different ones)");
            sPrint("1) loot\n2) use item\n3) move");
            int action1 = scanner.nextInt();
            int action2 = scanner.nextInt();
            scanner.nextLine();
            while (action2 == action1) {
                action2 = scanner.nextInt();
            }

            if (action1 == 1 || action2 == 1) {
                find();
            }
            if (action1 == 2 || action2 == 2) {
                useItem();
            }
            if (action1 == 3 || action2 == 3) {
                Hallway temp = current.move();
                if (temp != null) {
                    current = temp;
                }
            }
            gordy.move();
            if (gordy.hallway.hallwayName.equals(current.hallwayName)) {
                HP -= gordy.Attack();
            }
            int i;
            for(i=0; allGoals[i]==null; i++);
            allGoals[i].check(current);
            if(i>0)
            {
                robotics.hallUnlocked=true;
            }
            if(i>1)
            {
                swim.hallUnlocked=true;
            }
            if(i>2)
            {
                track.hallUnlocked=true;
                footBall.hallUnlocked=true;
                parkingLotBus.hallUnlocked=true;
                parkingLotSenior.hallUnlocked=true;
                parkingLotBack.hallUnlocked=true;
            }

        }
    }

    public void find() {
        Item temp = current.loot();
        sPrint(packToString());
        System.out.println();
        sPrint(temp.toString());
        if (choice("Want to this item")) {
            sPrint("What slot 0-2");
            backpack[scanner.nextInt()] = temp;

        }
    }

    public String packToString() {
        return "Current items\nSlot 0: " + backpack[0] + "\nSlot 1: " + backpack[1] + "\nStorage: " + backpack[2] + "\n";
    }

    public void useItem() {
        sPrint(packToString());
        sPrint("What slot 0-1");
        int i = 3;
        while (i == 3) {
            i = scanner.nextInt();
        }
        Item use = backpack[i];
        scanner.nextLine();
        if (use != null) {
            if (use.isHeal) {
                if (HP != HPM) {
                    HP += use.useItem();
                    if (HP > HPM) {
                        HP = HPM;
                    }
                    backpack[i] = null;
                }
            } else if (gordy.hallway.hallwayName.equals(current.hallwayName)) {
                gordy.HP -= backpack[i].useItem();
            }
        } else {
            sPrint("No item to use");
        }
        if (backpack[0] == null && backpack[2] != null) {
            if (choice("Pull out " + backpack[2].itemName + " of storage")) {
                backpack[0] = backpack[2];
                backpack[2] = null;
            }
        }
        if (backpack[1] == null && backpack[2] != null) {
            if (choice("Pull out " + backpack[2].itemName + " of storage")) {
                backpack[1] = backpack[2];
                backpack[2] = null;
            }
        }

    }

}