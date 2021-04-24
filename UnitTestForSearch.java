import java.util.Random;

public class UnitTestForSearch
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private int inputSize;
    private int[] randomInput;
    private int randomTarget;

    UnitTestForSearch(int array_size)
    {
        this.inputSize=array_size;
        this.randomInput=this.RandomArrayGenerator();
        this.randomTarget=this.RandomTargetExisting(this.randomInput);

        System.out.println();
        this.printList(this.randomInput);
        System.out.println("Target Element chosen to be searched is: "+this.randomTarget);
    }

    public void printList(int[] input)
    {
        System.out.println("Input list used for Demonstrating Search Methods: ");
        for (int i=0; i<input.length-1;i++)
        {
            System.out.print(input[i]+",");
        }
        System.out.print(input[input.length-1]);
        System.out.println();
    }

    private int[] RandomArrayGenerator()
    {
        int[] input= new int[this.inputSize];

        Random random= new Random();

        for (int i=0; i<this.inputSize;i++)
        {
            input[i]=random.nextInt();
        }

        return input;
    }

    private int RandomTargetExisting(int [] input)
    {
        Random random= new Random();
        int random_index=random.nextInt(input.length-1);
        int target=input[random_index];

        return target;
    }

    private int RandomTargetNonExisting()
    {
        // YET TO BE IMPLEMENTED
        return 1;
    }

    public boolean BruteForceTester()
    {
        Search search= new Search();
        boolean found=search.BruteForceSearch(this.randomInput,this.randomTarget);
        if (found)
        {
            System.out.println(ANSI_GREEN+"GOOD JOB!! BRUTE FORCE SUCCESSFULLY PASSED THE SEARCH TEST");
        }

        else
        {
            System.out.println(ANSI_RED+"ATTN!! BRUTE FORCE FAILED THE SEARCH TEST");
        }
        System.out.println(ANSI_RESET);
        return found;

    }

    public boolean BinarySearchTester()
    {
        Search search= new Search();
        boolean found=search.BinarySearch(this.randomInput,this.randomTarget,false);
        if (found)
        {
            System.out.println(ANSI_GREEN+"GOOD JOB!! BINARY SEARCH SUCCESSFULLY PASSED THE SEARCH TEST");
        }

        else
        {
            System.out.println(ANSI_RED+"ATTN!! BINARY SEARCH FAILED THE SEARCH TEST");
        }
        System.out.println(ANSI_RESET);

        return found;

    }

    public boolean TernarySearchTester()
    {
        Search search= new Search();
        boolean found=search.TernarySearch(this.randomInput,this.randomTarget,false);
        if (found)
        {
            System.out.println(ANSI_GREEN+"GOOD JOB!! TERNARY SEARCH SUCCESSFULLY PASSED THE SEARCH TEST");
        }

        else
        {
            System.out.println(ANSI_RED+"ATTN!! TERNARY SEARCH FAILED THE SEARCH TEST");
        }
        System.out.println(ANSI_RESET);

        return found;

    }

    public void BulkTest(int numOfTests)
    {
        System.out.println(ANSI_BLUE+"RUNNING BULK TEST OF SIZE "+numOfTests);
        System.out.println(ANSI_RESET);

        int i=0;
        boolean stopped=false;
        Search search = new Search();
        while (i<numOfTests)
        {
            int [] input=this.RandomArrayGenerator();
            int target= this.RandomTargetExisting(input);
            boolean testResult1=search.BruteForceSearch(input,target);
            boolean testResult2=search.BinarySearch(input,target,false);
            boolean testResult3=search.TernarySearch(input,target,false);

            if (!testResult1 || !testResult2 || !testResult3)
            {
                System.out.println(ANSI_RED+" RED FLAG!!! BULK TEST HAS FAILED ");
                stopped=true;
                break;
            }
            i++;
        }
        if (!stopped)
        {
            System.out.println(ANSI_GREEN+" ---------- GREAT JOB!!!! BULK TESTS OF SIZE "+numOfTests+ " HAVE PASSED ----------");
        }

        System.out.println(ANSI_RESET);
    }


}
