class Hallway extends Tools{
    
    String hallwayName;
    ItemClass[] hallwayItems;
    Hallway[] hallwayNeighbor;
    
    public Hallway(String name,ItemClass[] items,Hallway[] neighbor)
    {
        hallwayName=name;
        hallwayItems=items;
        hallwayNeighbor=neighbor;
    }
    
    public Hallway moveToNeighbor()
    {
        for(int i=0; i<hallwayNeighbor.length; i++)
        {
            sPrint(i+") "+hallwayNeighbor[i].hallwayName);
        }
        sPrint("Which hallway would you like move to?");
        return hallwayNeighbor[scanner.nextInt()];
    }
    
    public Hallway gordyMove()
    {
    return hallwayNeighbor[random(0,hallwayNeighbor.length)];
    }
    
    public Item loot()
    {
        return hallwayItems[random(0,hallwayItems.length)].createRandomItem();
    }
}