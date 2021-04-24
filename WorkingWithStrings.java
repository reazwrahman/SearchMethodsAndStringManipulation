import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class WorkingWithStrings
{

    private String fName;
    private String lName;
    private String userFullName;
    private int lengthOfName;
    private int vowelCount=0;
    private int nonVowelCount=0;

    private Character[] vowelsLower=new Character[] {'a','e','i','o','u'};
    private Character[] vowelsUpper=new Character[] {'A','E','I','O','U'};

    public void UserNameDisplay()
    {
        Scanner scan= new Scanner (System.in);

        System.out.println("Enter First Name: ");
        fName=scan.nextLine();

        System.out.println("Enter Last Name: ");
        lName=scan.nextLine();
        userFullName=fName+" "+lName;
        lengthOfName= fName.length()+lName.length();

        System.out.println("Hello"+" "+userFullName);
        System.out.println("The total length (number of characters) of user name is: "+lengthOfName);

    }

    public void DisplayUpperCase()
    {
        System.out.println("User name displayed in all upper case: "+userFullName.toUpperCase());
    }

    public void DisplayLowerCase()
    {
        System.out.println("User name displayed in all lower case: "+userFullName.toLowerCase());
    }

    public int CountVowels()
    {
        int count=0;
        for (int i=0; i<userFullName.length();i++)
        {
            for (int j = 0; j < vowelsUpper.length; j++)
            {
                if ( (userFullName.toCharArray()[i] == vowelsLower[j]) ||
                        (userFullName.toCharArray()[i] == vowelsUpper[j]))
                {
                    /* DEBUG LOG: System.out.println("vowels number "+count+" is "+userFullName.toCharArray()[i]); */
                    count += 1;
                }
            }
        }

        vowelCount=count;
        return count;
    }

    public void DisplayVowelCount()
    {
        CountVowels();
        System.out.println("The number of vowels in user name is: "+vowelCount);
    }

    public int CountNonVowels()
    {
        if (vowelCount==0)
        {
            CountVowels();
        }

        nonVowelCount=lengthOfName-vowelCount;
        return nonVowelCount;
    }

    public void DisplayNonVowelCount()
    {
        CountNonVowels();
        System.out.println("The number of consonants (non-vowels) in user name is: "+nonVowelCount);
    }


    public void StaticTextStore()
    {
        String text="I am a very good student who works hard";
        System.out.println("The character in position 10 of the string <"+text+"> is: "+text.toCharArray()[10]);

        int goodStart=0;
        int goodEnd=0;
        boolean found=false;

        int i=0;
        while (i<text.length())
        {
            if (text.toCharArray()[i]=='g' && text.toCharArray()[i+1]=='o'
                    && text.toCharArray()[i+2]=='o' && text.toCharArray()[i+3]=='d')
            {
                goodStart=i;
                goodEnd=i+3;
                found=true;
                break;
            }
            i++;
        }

        if (found)
        {
            System.out.println("The word good starts at position: "+goodStart+" and ends at position: "+goodEnd);
        }
        else
        {
            System.out.println("The word <good> not found");
        }
    }

    public void CheckUserInput()
    {
        Scanner scan= new Scanner (System.in);
        String checkAgainst="Excellent";
        String userInput;
        boolean correct=false;

        while (true)
        {
            System.out.println("Enter the word 'Excellent' below: ");
            userInput = scan.nextLine();

            if (userInput.equals(checkAgainst))
            {
                correct = true;
                System.out.println("Good Job!");
                break;
            }
            else
            {
                System.out.println("Wrong input. Please, try again");
            }
        }

    }

    public void DisplayCurrentDateTime()
    {
        Date date = new Date();
        String[] dateComponents = date.toString().split(" ", 0);
        String weekDay = dateComponents[0];
        String month = dateComponents[1];
        String monthDay = dateComponents[2];
        String[] timeComponents = dateComponents[3].split(":", 0);
        String hour = timeComponents[0];
        String minute = timeComponents[1];
        String timeZone = dateComponents[4];
        String year = dateComponents[5];
        String amOrpm = "am";
        if (Integer.parseInt(hour) > 12)
        {
            hour = Integer.toString(Integer.parseInt(hour) - 12);
            amOrpm = "pm";
        }
        System.out.println("Current Date and Time: ");
        System.out.println(month + " " + monthDay + "," + " " + year);
        System.out.println(hour + ":" + minute + " " + amOrpm);
    }

}
