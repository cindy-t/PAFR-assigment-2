package domain;

public class Wagon extends Vehicle{

    public Wagon(int id, String name, String type, int seats) {
        super(id, name, type, seats);
    }
    @Override
    public boolean equals(Object obj) {
        boolean result;
        if((obj == null) || (getClass() != obj.getClass())){
            return false;
        }
        else{
            Wagon otherWagon = (Wagon)obj;
            result = getType().equals(otherWagon.getType()) &&
                    getSeats() == otherWagon.getSeats();
        }
        return result;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a wagon");
    }

    public String toString(){
        return "(" + getId()+ ") Wagon of type: " + getType() + " has " + getSeats() + " seats";
    }


}
