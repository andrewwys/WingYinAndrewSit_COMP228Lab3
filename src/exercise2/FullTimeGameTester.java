package exercise2;

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    protected int getSalary(int hours){
        // Assume a Full Time tester receives base salary $3000 plus $5 per hour
        return 3000 + 5*hours;
    }

}
