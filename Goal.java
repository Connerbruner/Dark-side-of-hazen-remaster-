class Goal extends Tools {

    String goal;
    Hallway ending;
    Item reward;
    boolean complete=false;
    public Goal(String name,Hallway hallway,Item item)
    {
        goal=name;
        hallway=hallway;
        item=reward;
    }
    public Goal(String name,Hallway hallway)
    {
        goal=name;
        ending=hallway;
    }
    public  String toString()
    {
        return "Current Goal: "+name+" go to "+ending.hallwayName+" reward: "+reward.toString();
    }
    public void check(Hallway hallway)
    {
        if(hallway.hallwayName.eqauls(ending.hallwayName))
        {
            complete=true;
        }
    }
}