class Goal extends Tools {

    String goal;
    Hallway ending;
    Item reward;
    boolean complete=false;
    public Goal(String name,Hallway hallway,Item item)
    {
        goal=name;
        ending=hallway;
        reward=item;
    }
    public Goal(String name,Hallway hallway)
    {
        goal=name;
        ending=hallway;
    }
    public  String toString()
    {
        return "Current Goal: "+goal+" go to "+ending.hallwayName+" reward: "+reward.toString();
    }
    public void check(Hallway hallway)
    {
        if(hallway.hallwayName.equals(ending.hallwayName))
        {
            complete=true;
        }
    }
}