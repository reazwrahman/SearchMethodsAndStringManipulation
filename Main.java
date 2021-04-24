public class Main
{

    public static void main(String[] args)
    {
        // TASK 2 DONE FIRST SINCE IT DOESN'T NEED USER INPUT
        UnitTestForSearch test= new UnitTestForSearch(100);
        test.BruteForceTester();
        test.BinarySearchTester();
        test.TernarySearchTester();

        /*Run the bulk test for a specified number of times to reveal any inner bugs*/
        test.BulkTest(10);

        // TASK 1
        WorkingWithStringDriver driver1= new WorkingWithStringDriver();
        driver1.Drive();


        // MANUAL USER INPUT FOR DEBUGGING PURPOSES
        /*int [] input= new int[]{5,1,4,5,2,1,9,11}
        int target=2;

        System.out.println("Element chosen for searching is: "+target);

        Search search=new Search();
        //search.BruteForceSearch(input,target);
        search.BinarySearch(input,target,false);
        //search.TernarySearch(input,target,false);*/




    }
}