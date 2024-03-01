import java.util.LinkedList;
import java.util.Queue;
public class RNA_to_Protein {
        public static String translateRNAToAminoAcids(String rnaSequence) {
            // Codon table represented as arrays
            String[] codons = {"UUU", "UUC", "UUA", "UUG", "CUU", "CUC", "CUA", "CUG", "AUU", "AUC", "AUA", "AUG",
                    "GUU", "GUC", "GUA", "GUG", "UCU", "UCC", "UCA", "UCG", "CCU", "CCC", "CCA", "CCG", "ACU", "ACC",
                    "ACA", "ACG", "GCU", "GCC", "GCA", "GCG", "UAU", "UAC", "UAA", "UAG", "CAU", "CAC", "CAA", "CAG",
                    "AAU", "AAC", "AAA", "AAG", "GAU", "GAC", "GAA", "GAG", "UGU", "UGC", "UGA", "UGG", "CGU", "CGC",
                    "CGA", "CGG", "AGU", "AGC", "AGA", "AGG", "GGU", "GGC", "GGA", "GGG"};
            char[] aminoAcids = {'F', 'F', 'L', 'L', 'L', 'L', 'L', 'L', 'I', 'I', 'I', 'M', 'V', 'V', 'V', 'V', 'S', 'S',
                    'S', 'S', 'P', 'P', 'P', 'P', 'T', 'T', 'T', 'T', 'A', 'A', 'A', 'A', 'Y', 'Y', '.', '.', 'H', 'H',
                    'Q', 'Q', 'N', 'N', 'K', 'K', 'D', 'D', 'E', 'E', 'C', 'C', '.', 'W', 'R', 'R', 'R', 'R', 'S', 'S',
                    'R', 'R', 'G', 'G', 'G', 'G'};

            StringBuilder result = new StringBuilder();
            Queue<Character> aminoAcidsQueue = new LinkedList<>();
            //move i three places in each iteration
            //i + 2 calculates the index that is two positions ahead of i
            // O(n)
            for (int i = 0; i+2 < rnaSequence.length(); i += 3) {
                String codon = rnaSequence.substring(i, i + 3);
                char aminoAcid = ' '; // insert a space if codon not found
                //O(n)
                for (int j = 0; j < codons.length; j++) {
                    if (codons[j].equals(codon)) {
                        aminoAcid = aminoAcids[j];
                        break;
                    }
                }
                aminoAcidsQueue.add(aminoAcid);
            }
            //result string O(n)
            while (!aminoAcidsQueue.isEmpty()) {
                result.append(aminoAcidsQueue.poll());
            }
            return result.toString();
        }
        public static void main(String[] args) {
            // Sample Input
            String rnaSequence1 = "AGCUGGGAAACGUAGGCCUA";
            String rnaSequence2 = "UAAAGAGAAGCCAGC";

            // Sample Output
            System.out.println(translateRNAToAminoAcids(rnaSequence1)); // Output: SWET.A.
            System.out.println(translateRNAToAminoAcids(rnaSequence2)); // Output: .GREAT
        }
    }
