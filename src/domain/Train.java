package domain;

import java.util.ArrayList;

public class Train extends Vehicle{
    private ArrayList<Wagon> wagons = new ArrayList<Wagon>();

    public Train(int id, String name, String type, int seats){
        super(id, name, type, seats);
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    @Override
    public int getSeats() {
        int numberOfSeats = super.getSeats();
        for (int i = 0; i < wagons.size(); i++){
            numberOfSeats += wagons.get(i).getSeats();
        }
        return numberOfSeats;
    }

    public void addWagon(Wagon wagon)
    {
        wagons.add(wagon);
    }

    public boolean containsWagon(Wagon wagon)
    {
        return wagons.contains(wagon);
    }

    public void removeWagon(Wagon wagon)
    {
        while (containsWagon(wagon))
        {
            wagons.remove(wagon);

        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;
        if((obj == null) || (getClass() != obj.getClass())){
            return false;
        }
        else{
            Train otherTrain = (Train)obj;
            result = getId() == otherTrain.getId() &&
                    getType().equals(otherTrain.getType());
        }
        return result;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a train");
    }

    @Override
    public String toString(){
        return "(" + getId()+ ") Train of type: " + getType() + " has " + getSeats() + " seats";
    }



}
