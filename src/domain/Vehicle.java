package domain;

public abstract class Vehicle {
    private int id;
    private String name;
    private String type;
    private int seats;

    public Vehicle(int id, String name, String type, int seats){
        this.id = id;
        this.name = name;
        this.type = type;
        this.seats = seats;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getSeats(){
        return seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public abstract void draw();

    @Override
    public String toString(){
        return "Vehicle: " + getId() + " of type: " + getType() + " has: " + getSeats() + " seats";
    }
}
