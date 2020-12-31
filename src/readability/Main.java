package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        double wordcounter = 0;
        String znaki = ".*[!.?]";
        double znakicounter = 1;
        double SUMMA = 0;
        String  big = "[A-Z]{2,}";
        int bigg = 0;
        int bigcounter = 0;
        int syllables = 0;
        int counter = 0;
        int polysyllables = 0;
        int six = 6;
        int seven = 7;
        int eight = 8;
        int nine = 9;
        int ten = 10;
        int eleven = 11;
        int twelve = 12;
        int thirteen = 13;
        int fourteen = 14;
        int fiveteen = 15;
        int sixteen = 16;
        int seventeen = 17;
        int eighteen = 18;
        int twentyFour = 24;
        int nineteen = 19;
        int twentyFive = 25;
        double res = 0;
        String num = "[\\d].*";
        System.out.println("The text is:");
        while (scanner.hasNext()) {
            String word = scanner.next();
            System.out.print(word + " ");
            if (word.matches(big)) {
                bigg += word.length();
                bigcounter++;
            }
            word = word.toLowerCase();
            SUMMA += word.length(); // Пробелы и т.д.
            wordcounter++;
            if (word.matches(znaki) && scanner.hasNext()) {
                znakicounter++;
            }
            for (int i = 0; i < word.length()-1; i++) {
                if (word.charAt(i) == 'a'|| word.charAt(i) == 'e' ||
                        word.charAt(i) == 'i'|| word.charAt(i) == 'o' ||
                        word.charAt(i) == 'u' || word.charAt(i) == 'y') {
                    if ((word.charAt(i+1) != 'a'&& word.charAt(i+1) != 'e' &&
                            word.charAt(i+1) != 'i' && word.charAt(i+1) != 'o' &&
                            word.charAt(i+1) != 'u' && word.charAt(i+1) != 'y' && word.charAt(i+1) != '.' && word.charAt(i+1) != ','
                            && word.charAt(i+1) != '!' && word.charAt(i+1) != '?')) {
                        syllables++;
                        counter++;
                    }
                }
            }
            if ((word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == '!' || word.charAt(word.length()-1) == '?') &&
                    (word.charAt(word.length()-2) == 'a' || word.charAt(word.length()-2) == 'e' ||
                            word.charAt(word.length()-2) == 'i' || word.charAt(word.length()-2) == 'o' ||
                            word.charAt(word.length()-2) == 'u' || word.charAt(word.length()-2) == 'y') && (word.charAt(word.length()-3) == 'a' || word.charAt(word.length()-3) == 'e' ||
                    word.charAt(word.length()-3) == 'i' || word.charAt(word.length()-3) == 'o' ||
                    word.charAt(word.length()-3) == 'u' || word.charAt(word.length()-3) == 'y')){
                syllables++;
                counter++;
            }
            if (word.length() > 2) {
                if (word.charAt(word.length() - 1) == 'a' ||
                        word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' ||
                        word.charAt(word.length() - 1) == 'u' || word.charAt(word.length() - 1) == 'y') {
                    if (word.charAt(word.length() - 2) != 'a' && word.charAt(word.length() - 2) != 'e' &&
                            word.charAt(word.length() - 2) != 'i' && word.charAt(word.length() - 2) != 'o' &&
                            word.charAt(word.length() - 2) != 'u' && word.charAt(word.length() - 2) != 'y') {
                        syllables++;
                        counter++;
                    }
                }
            }
            if (counter > 2) {
                polysyllables++;
            }
            if (counter == 0) {
                syllables++;
            }
            counter = 0;
            if (word.matches(num)) {
                syllables--;
            }
        }

        System.out.println();
        System.out.println("Words: " + (int)wordcounter);
        System.out.println("Sentences: " + (int)znakicounter);
        System.out.println("Characters: " + (int)SUMMA);
        System.out.println("Syllables: " + (syllables + bigg - bigcounter));
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String answer = new Scanner(System.in).next();
        double score = (4.71 * (SUMMA/wordcounter) + 0.5 * (wordcounter/znakicounter) - 21.43);
        double score1 = (0.39 * (wordcounter/znakicounter) + 11.8 * ((syllables + bigg - bigcounter)/wordcounter) - 15.59);
        double score2 = (1.043 * Math.sqrt(polysyllables * (30/znakicounter)) + 3.1291);
        double score3 = (0.0588 * (SUMMA/wordcounter * 100) - 0.296 * (znakicounter/wordcounter * 100) - 15.8);
        switch (answer){
            case "ARI":

                if (score > 1 && score <= 2) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, six);
                }else if (score > 2 && score <= 3) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, seven);
                }else if (score > 3 && score <= 4) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, nine);
                }else if (score > 4 && score <= 5) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, ten);
                }else if (score > 5 && score <= 6) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, eleven);
                }else if (score > 6 && score <= 7) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, twelve);
                }else if (score > 7 && score <= 8) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, thirteen);
                }else if (score > 8 && score <= 9) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, fourteen);
                }else if (score > 9 && score <= 10) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, fiveteen);
                }else if (score > 10 && score <= 11) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, sixteen);
                }else if (score > 11 && score <= 12) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, seventeen);
                }else if (score > 12 && score <= 13) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, eighteen);
                }else if (score > 13 && score <= 14) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, twentyFour);
                }
                break;
            case "FK":
                if (score1 > 1 && score1 <= 2) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, six);
                }else if (score1 > 2 && score1 <= 3) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, seven);
                }else if (score1 > 3 && score1 <= 4) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, nine);
                }else if (score1 > 4 && score1 <= 5) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, ten);
                }else if (score1 > 5 && score1 <= 6) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, eleven);
                }else if (score1 > 6 && score1 <= 7) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, twelve);
                }else if (score1 > 7 && score1 <= 8) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, thirteen);
                }else if (score1 > 8 && score1 <= 9) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, fourteen);
                }else if (score1 > 9 && score1 <= 10) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, fiveteen);
                }else if (score1 > 10 && score1 <= 11) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, sixteen);
                }else if (score1 > 11 && score1 <= 12) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, seventeen);
                }else if (score1 > 12 && score1 <= 13) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, eighteen);
                }else if (score1 > 13 && score1 <= 14) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, twentyFour);
                }
                break;
            case "SMOG":

                if (score2 > 1 && score2 <= 2) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, six);
                }else if (score2 > 2 && score2 <= 3) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, seven);
                }else if (score2 > 3 && score2 <= 4) {
                    System.out.printf("FSimple Measure of Gobbledygook: %.2f (about %d year olds).",score2, nine);
                }else if (score2 > 4 && score2 <= 5) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, ten);
                }else if (score2 > 5 && score2 <= 6) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, eleven);
                }else if (score2 > 6 && score2 <= 7) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, twelve);
                }else if (score2 > 7 && score2 <= 8) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, thirteen);
                }else if (score2 > 8 && score2 <= 9) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, fourteen);
                }else if (score2 > 9 && score2 <= 10) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, fiveteen);
                }else if (score2 > 10 && score2 <= 11) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, sixteen);
                }else if (score2 > 11 && score2 <= 12) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, seventeen);
                }else if (score2 > 12 && score2 <= 13) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, eighteen);
                }else if (score2 > 13 && score2 <= 14) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, twentyFour);
                }
                break;
            case "CL" :
                if (score3> 1 && score3 <= 2) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, seven);
                }else if (score3 > 2 && score3 <= 3) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, eight);
                }else if (score3 > 3 && score3 <= 4) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, ten);
                }else if (score3 > 4 && score3 <= 5) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, eleven);
                }else if (score3 > 5 && score3 <= 6) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, twelve);
                }else if (score3 > 6 && score3 <= 7) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, thirteen);
                }else if (score3 > 7 && score3 <= 8) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, fourteen);
                }else if (score3 > 8 && score3 <= 9) {
                    System.out.printf("Coleman–Liau index:  %.2f (about %d year olds).",score3, fiveteen);
                }else if (score3 > 9 && score3 <= 10) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, sixteen);
                }else if (score3 > 10 && score3 <= 11) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, seventeen);
                }else if (score3 > 11 && score3 <= 12) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, eighteen);
                }else if (score3 > 12 && score3 <= 13) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, nineteen);
                }else  {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, twentyFive);
                }
                break;
            default:
                if (score> 1 && score <= 2) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, seven);
                    res += seven;
                }else if (score > 2 && score <= 3) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, eight);
                    res += eight;
                }else if (score > 3 && score <= 4) {
                    System.out.printf("SAutomated Readability Index: %.2f (about %d year olds).",score, ten);
                    res += ten;
                }else if (score > 4 && score <= 5) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, eleven);
                    res += eleven;
                }else if (score > 5 && score <= 6) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, twelve);
                    res += twelve;
                }else if (score > 6 && score <= 7) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, thirteen);
                    res += thirteen;
                }else if (score > 7 && score <= 8) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, fourteen);
                    res += fourteen;
                }else if (score > 8 && score <= 9) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, fiveteen);
                    res += fiveteen;
                }else if (score > 9 && score <= 10) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, sixteen);
                    res += sixteen;
                }else if (score > 10 && score <= 11) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, seventeen);
                    res += seventeen;
                }else if (score > 11 && score <= 12) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, eighteen);
                    res += eighteen;
                }else if (score > 12 && score <= 13) {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, nineteen);
                    res += twentyFour;
                }else {
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).",score, twentyFive);
                    res += twentyFive;
                }
                System.out.println();
                if (score1> 1 && score1 <= 2) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, seven);
                    res += seven;
                }else if (score1 > 2 && score1 <= 3) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, eight);
                    res += eight;
                }else if (score1 > 3 && score1 <= 4) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, ten);
                    res += ten;
                }else if (score1 > 4 && score1 <= 5) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, eleven);
                    res += eleven;
                }else if (score1 > 5 && score1 <= 6) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, twelve);
                    res += twelve;
                }else if (score1 > 6 && score1 <= 7) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, thirteen);
                    res += thirteen;
                }else if (score1 > 7 && score1 <= 8) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, fourteen);
                    res += fourteen;
                }else if (score1 > 8 && score1 <= 9) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, fiveteen);
                    res += fiveteen;
                }else if (score1 > 9 && score1 <= 10) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, sixteen);
                    res += sixteen;
                }else if (score1 > 10 && score1 <= 11) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, seventeen);
                    res += seventeen;
                }else if (score1 > 11 && score1 <= 12) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, eighteen);
                    res += eighteen;
                }else if (score1 > 12 && score1 <= 13) {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, nineteen);
                    res += twentyFour;
                }else {
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).",score1, twentyFive);
                    res += twentyFive;
                }
                System.out.println();
                if (score2> 1 && score2 <= 2) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, seven);
                    res += seven;
                }else if (score2 > 2 && score2 <= 3) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, eight);
                    res += eight;
                }else if (score2 > 3 && score2 <= 4) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, ten);
                    res += ten;
                }else if (score2 > 4 && score2 <= 5) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, eleven);
                    res += eleven;
                }else if (score2 > 5 && score2 <= 6) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, twelve);
                    res += twelve;
                }else if (score2 > 6 && score2 <= 7) {
                    System.out.printf("Simple Measure of Gobbledygook:  %.2f (about %d year olds).",score2, thirteen);
                    res += thirteen;
                }else if (score2 > 7 && score2 <= 8) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, fourteen);
                    res += fourteen;
                }else if (score2 > 8 && score2 <= 9) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, fiveteen);
                    res += fiveteen;
                }else if (score2 > 9 && score2 <= 10) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, sixteen);
                    res += sixteen;
                }else if (score2 > 10 && score2 <= 11) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, seventeen);
                    res += seventeen;
                }else if (score2 > 11 && score2 <= 12) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, eighteen);
                    res += eighteen;
                }else if (score2 > 12 && score2 <= 13) {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, nineteen);
                    res += twentyFour;
                }else {
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).",score2, twentyFive);
                    res += twentyFive;
                }
                System.out.println();
                if (score3> 1 && score3 <= 2) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, seven);
                    res += seven;
                }else if (score3 > 2 && score3 <= 3) {
                    System.out.printf("SColeman–Liau index: %.2f (about %d year olds).",score3, eight);
                    res += eight;
                }else if (score3 > 3 && score3 <= 4) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, ten);
                    res += ten;
                }else if (score3 > 4 && score3 <= 5) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, eleven);
                    res += eleven;
                }else if (score3 > 5 && score3 <= 6) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, twelve);
                    res += twelve;
                }else if (score3 > 6 && score3 <= 7) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, thirteen);
                    res += thirteen;
                }else if (score3 > 7 && score3 <= 8) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, fourteen);
                    res += fourteen;
                }else if (score3 > 8 && score3 <= 9) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, fiveteen);
                    res += fiveteen;
                }else if (score3 > 9 && score3 <= 10) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, sixteen);
                    res += sixteen;
                }else if (score3 > 10 && score3 <= 11) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, seventeen);
                    res += seventeen;
                }else if (score3 > 11 && score3 <= 12) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, eighteen);
                    res += eighteen;
                }else if (score3 > 12 && score3 <= 13) {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, nineteen);
                    res += twentyFour;
                }else {
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).",score3, twentyFive);
                    res += twentyFive;
                }
                System.out.println();
                System.out.println();
                System.out.printf("This text should be understood in average by %.2f year olds.", res/4);
                break;

        }

    }
}