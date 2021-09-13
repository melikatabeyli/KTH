/*
Author: Melik Atabeyli
Koden är som en filter för balanserad parantes. Om parantesen i filen är av samma antal och i rätt ordning så säger den
balanserad. Detta görs med att inserta filen i en Stringbuilder objekt och sen iterera genom objekten medans den analyserar
varje parantes i stringen. Om den inte är balanserad så säger den inte balanserad.
 */
import java.io.*;

import java.util.Stack;

//Filtrerar givna filen och säger om den är balanserad eller inte
public class highgrade {

    //metoden kallar på starten av filtreringsproceduren
    public static void main(String Args[]) {

        highgrade yolo = new highgrade() ;
        yolo.BalanseradParentes(); }

    //Tar input från filen och pushar varje {, [, och ( till Stacken. Sen så jämför
    //den ifall de är ordentligt balanserade.
    private void BalanseradParentes() {

        try {
            FileReader fr = new FileReader("testing.txt") ;
            BufferedReader br = new BufferedReader(fr) ;

            StringBuilder sb = new StringBuilder() ;

            String text ;

            while((text = br.readLine()) != null)
            {
                sb.append(text) ;
                sb.append(System.getProperty("line.separator")) ;
            }

            boolean balanserad = balansTestare(sb.toString()) ;

            System.out.println("Filens utskrift:\n") ;

            System.out.println(sb.toString()) ;

            if(balanserad)
                System.out.println("Filen är balanserad");
            else
                System.out.println("Filen är inte balanserad");

            br.close();
        }
        catch(IOException t){
            System.out.println("Filen hittades inte");
        }
    }
    //Itererar genom stringen för att se om parantesen är balanserade. Det finns 4 olika cases som
    //loopen checkar igenom och returnar rätt värde beroende på det.
    private boolean balansTestare(String string) {

        Stack<Character> stack = new Stack<>();
        char a, b;

        for (int i = 0; i < string.length(); i++) {

            a = string.charAt(i);
            b = ' ';

            if(!stack.isEmpty())
                b = stack.peek();

            if (a == '{' || a == '[' || a == '(')

                stack.push(a) ;

            else if (a == '}' && b == '{' || a == ']' && b == '[' || a == ')' && b == '(')

                stack.pop() ;

            else if ((a == '}' || a == ']'  || a == ')') && b == ' ')
                return false ;

            else if (a == '}' && (b == '[' ||b== '(' ) || a == ']'&& (b == '{' || b== '(') || a == ')' && (b == '{' || b== '[' ))
                return false ; }

        return stack.isEmpty() ;

    }}