class Hallway extends Tools{
    Hallway[] neighbors;
    String hallwayName;
    ItemClass[] hallwayItems;
    public void setNeighbors(Hallway[] hallway)
    {
        neighbors=hallway;
    }
    public Hallway(String name,ItemClass[] items)
    {
        hallwayName=name;
        hallwayItems=items;
    }

    public Item loot()
    {
        return hallwayItems[random(0,hallwayItems.length-1)].createRandomItem();
    }
    public Hallway move()
    {
        sPrint("Current hallway: "+hallwayName);
        for(int i=0; i<neighbors.length; i++)
        {
            sPrint(i+": "+neighbors[i].hallwayName);
        }
        sPrint("Where would you like to go 0-"+(neighbors.length-1));
        return neighbors[scanner.nextInt()];
    }
}