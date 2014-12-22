import java.util.Scanner;

public class Grade
{
    private static double finalGradeNeeded( double cGrade, double tGrade )
    {
        return 4 * ( tGrade - .75 * cGrade );
    }

    public static void main( String[] args )
    {
        char grade;        
        double cGrade = 0, pct, fGrade;
        Scanner input = new Scanner(System.in);
        
        while ( cGrade >= 0 )
        {
            try 
            {
                // get the student's overall current grade
                System.out.println("(Enter negative grade to exit.");
                System.out.print("Overall grade: " );
                cGrade = input.nextDouble();
                
                // convert to decimal, if necessary.
                if ( cGrade > 1.0 )
                    cGrade /= 100;
                
                // compute!
                System.out.println
                    ("For the course, if the final were held today:\n\n");           
                System.out.println("TO GET  YOU NEED");
                System.out.println("----------------");
                for ( grade = 'A', pct = .895; grade <= 'C'; 
                    grade++, pct -= .10 )
                {
                    fGrade = finalGradeNeeded( cGrade, pct ) * 100;
        
                    if ( fGrade > 100 )
                        System.out.printf("   %c       ---%n", grade);
                    else if ( fGrade < 0.0 )
                        System.out.printf("   %c       +++%n", grade);
                    else
                        System.out.printf("   %c       %.0f%n", grade, fGrade );
                        
                }
                System.out.println("----------------\n\n");
                System.out.println("--- = impossible");
                System.out.println("+++ = automatic");
                
            }
            catch( Exception e )
            {
                System.err.println("Invalid input!\n" );
            }
        }
    }
}