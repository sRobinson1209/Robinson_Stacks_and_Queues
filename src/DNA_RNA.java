import java.util.Scanner;
import java.util.Stack;

public class DNA_RNA {
    public static String toRNA(String dna) {
        Stack<Character> stack = new Stack<>();

        //push each character onto stack
        for (int i = 0; i < dna.length(); i++) {
            char nucleotide = dna.charAt(i);
            if (nucleotide == 'T') {
                stack.push('U');
            }else{
                stack.push(nucleotide);
            }
        }
            //if there is a T replace with U
            StringBuilder rna = new StringBuilder();
            while (!stack.isEmpty()) {
                rna.append(stack.pop());
            }
            //reverse because a stack is LIFO so once everything is changed its in the reverse order
            return rna.reverse().toString();
        }
        public static void main (String[]args ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter DNA Sequence: ");
            String dna = scanner.nextLine();

            String rna = toRNA(dna);
            System.out.println("RNA equivalent: " + "\n" +rna);
        }
    }


