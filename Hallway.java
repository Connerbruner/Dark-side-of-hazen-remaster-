class Hallway extends Tools{
    
    String hallwayName;
    ItemClass[] hallwayItems;

    public Hallway(String name,ItemClass[] items)
    {
        hallwayName=name;
        hallwayItems=items;
    }

    public Item loot()
    {
        return hallwayItems[random(0,hallwayItems.length)].createRandomItem();
    }
}