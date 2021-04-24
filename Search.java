import java.util.Arrays;

public class Search
{
    public boolean BruteForceSearch(int[] input, int target)
    {
        boolean found =false;

        for (int i=0; i<input.length;i++)
        {
            if (input[i]==target)
            {
                found=true;
                System.out.println("BRUTE FORCE: found target element <"+target+"> at position "+i);
                break;
            }
        }

        if (!found)
        {
            System.out.println("BRUTE FORCE: Target Element NOT FOUND");
        }
        return found;
    }

    public boolean BinarySearch(int[] input, int target, boolean sorted)
    {
        boolean found=false;

        if (!sorted)
        {
            input=this.BubbleSort(input);
        }



        while (true)
        {

            if (input.length==0 || target<input[0]
                    || target> input[input.length-1] )
            {
                found=false;
                break;
            }

            int midPoint = (input.length / 2);
            int midElement = input[midPoint];

            if (midElement == target)
            {
                found = true;
                break;
            }
            else if (input.length == 1)
            {
                found = false;
                break;
            }
            else if (target < midElement)
            {
                input = Arrays.copyOfRange(input, 0, midPoint);
            }
            else if (target > midElement)
            {
                input = Arrays.copyOfRange(input, midPoint, input.length);
            }
        }

        if(found)
        {
            System.out.println("BINARY SEARCH: found target element <"+target+">");
        }
        else
        {
            System.out.println("BINARY SEARCH: Target Element NOT FOUND");
        }

        return found;

    }


    public boolean TernarySearch(int[] input, int target, boolean sorted)
    {
        boolean found=false;

        if (!sorted)
        {
            input=this.BubbleSort(input);
        }



        while (true)
        {
            //edge cases handled
            if (input.length==0 || target<input[0]
                    || target> input[input.length-1] )
            {
                found=false;
                break;
            }

            int midPoint1 = (input.length / 3);
            int midPoint2= (input.length / 2);
            int midElement1 = input[midPoint1];
            int midElement2=input[midPoint2];

            if (midElement1 == target)
            {
                found = true;
                break;
            }

            else if (midElement2 == target)
            {
                found = true;
                break;
            }

            else if (input.length == 1)
            {
                found = false;
                break;
            }

            else if (target < midElement1)
            {
                input = Arrays.copyOfRange(input, 0, midPoint1);
            }
            else if (target > midElement2)
            {
                input = Arrays.copyOfRange(input, midPoint2, input.length);
            }
            else
            {
                input = Arrays.copyOfRange(input, midPoint1, midPoint2);
            }
        }

        if(found)
        {
            System.out.println("TERNARY SEARCH: found target element <"+target+">");
        }
        else
        {
            System.out.println("TERNARY SEARCH: Target Element NOT FOUND");
        }

        return found;
    }

// ---------------- PRIVATE METHODS ------------------------

    private int [] BubbleSort(int[] input)
    {
        for (int i=0; i<input.length-1;i++)
        {
            for (int j = i + 1; j < input.length; j++)
            {
                if (input[j] < input[i])
                {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }

        return input;
    }

}
