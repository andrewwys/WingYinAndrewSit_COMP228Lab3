package exercise2;

public class PartTimeGameTester extends GameTester {

    public PartTimeGameTester(String name) {
        super(name, false);
    }

    @Override
    protected int getSalary(int hours) {
        // A part-time tester receives $20 per hour
        return hours * 20;
    }
}
