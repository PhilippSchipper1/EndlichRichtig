package de.fs.endlichrichtig;

class Workout {
    private String title;


    public Workout(String title, String wod) {
        this.title = title;
        this.wod = wod;
    }

    public Workout(){

    }

    private String wod;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWod() {
        return wod;
    }

    public void setWod(String wod) {
        this.wod = wod;
    }

}
