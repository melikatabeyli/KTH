// Author: Melik Atabeyli
/*This is both an iterative and recursive function which can read the characters
until a newline is read, after this it will printout the characters in reverse to
stdout as we did in the previous exercise
 */
import java.util.Scanner;

public class Q2 {
    public static void recursive(String z, int x) {
        if (x < z.length()) {
            x++;
            /*recalling the function with incremented x */
            recursive(z, x);
            x--;
            System.out.print(z.charAt(x)); } }
    public static void iterative(String z) {
        for (int x = z.length(); x > 0; x--)
            System.out.print(z.charAt(x - 1)); }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.print("recursive: ");
        recursive(s, 0);
        System.out.println();
        System.out.print("iterative: ");
        iterative(s); }}
