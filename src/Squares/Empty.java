package Squares;

public class Empty extends Square{

    public String getType() {
        return "Empty";
    }

    public boolean moveTest(int iInit, int jInit, int iFin, int jFin) {
        return false;
    }
}
