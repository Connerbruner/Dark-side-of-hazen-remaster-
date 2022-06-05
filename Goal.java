class Goal extends Tools {

    String goal;
    Hallway ending;
    boolean complete=false;

    public Goal(String name,Hallway hallway)
    {
        goal=name;
        ending=hallway;
    }
    public  String toString()
    {
        return "Current Goal: "+goal+" go to "+ending.hallwayName;
    }
    public boolean check(Hallway hallway)
    {
        if(hallway.hallwayName.equals(ending.hallwayName) && !complete)
        {
            sPrintln(toString()+" COMPLETE");
            complete=true;
            return true;
        }
        return false;
    }
}