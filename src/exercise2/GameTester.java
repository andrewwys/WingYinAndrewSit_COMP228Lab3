package exercise2;

public abstract class GameTester {

    protected String name;
    protected boolean fullTimeStatus;

    protected GameTester(String name, boolean status) {
        this.name = name;
        this.fullTimeStatus = status;
    }

    protected abstract int getSalary(int hours);

    protected String getName() {return name;}
    protected boolean getStatus() {return fullTimeStatus;}

}
