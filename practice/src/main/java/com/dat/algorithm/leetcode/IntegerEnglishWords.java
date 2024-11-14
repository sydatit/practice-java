package com.dat.algorithm.leetcode;

public class IntegerEnglishWords {
    public static void main(String[] args) {
        IntegerEnglishWords integerEnglishWords = new IntegerEnglishWords();
        System.out.println(integerEnglishWords.numberToWords(123));
        System.out.println(integerEnglishWords.numberToWords(12345));
        System.out.println(integerEnglishWords.numberToWords(1234567));
        System.out.println(integerEnglishWords.numberToWords(1234567891));
    }

    private final String ZERO_WORD = "Zero";
    private final String ONE_WORD = "One";
    private final String TWO_WORD = "Two";
    private final String THREE_WORD = "Three";
    private final String FOUR_WORD = "Four";
    private final String FIVE_WORD = "Five";
    private final String SIX_WORD = "Six";
    private final String SEVEN_WORD = "Seven";
    private final String EIGHT_WORD = "Eight";
    private final String NINE_WORD = "Nine";
    private final String TEN_WORD = "Ten";
    private final String ELEVEN_WORD = "Eleven";
    private final String TWELVE_WORD = "Twelve";
    private final String THIRTEEN_WORD = "Thirteen";
    private final String FOURTEEN_WORD = "Fourteen";
    private final String FIFTEEN_WORD = "Fifteen";
    private final String SIXTEEN_WORD = "Sixteen";
    private final String SEVENTEEN_WORD = "Seventeen";
    private final String EIGHTEEN_WORD = "Eighteen";
    private final String NINETEEN_WORD = "Nineteen";
    private final String TWENTY_WORD = "Twenty";
    private final String THIRTY_WORD = "Thirty";
    private final String FORTY_WORD = "Forty";
    private final String FIFTY_WORD = "Fifty";
    private final String SIXTY_WORD = "Sixty";
    private final String SEVENTY_WORD = "Seventy";
    private final String EIGHTY_WORD = "Eighty";
    private final String NINETY_WORD = "Ninety";
    private final String HUNDRED_WORD = "Hundred";
    private final String THOUSAND_WORD = "Thousand";
    private final String MILLION_WORD = "Million";
    private final String BILLION_WORD = "Billion";

    public String numberToWords(int num) {
        if (num == 0) {
            return ZERO_WORD;
        }
        String number = String.valueOf(num);
        int length = number.length();
        String res = "";
        if (length <= 3) {
            res = convert(number);
        } else if (length <= 6) {
            res = convert(number.substring(0, length - 3)) + " " + THOUSAND_WORD + " " + convert(number.substring(length - 3));
        } else if (length <= 9) {
            res = convert(number.substring(0, length - 6)) + " " + MILLION_WORD + " " + convert(number.substring(length - 6, length - 3)) +
                    " " + THOUSAND_WORD + " " + convert(number.substring(length - 3));
        } else {
            res = convert(number.substring(0, length - 9)) + " " + BILLION_WORD + " " + convert(number.substring(length - 9, length - 6)) + " "
                    + MILLION_WORD + " " + convert(number.substring(length - 6, length - 3)) + " " + THOUSAND_WORD + " "
                    + convert(number.substring(length - 3));
        }
        return res.trim();
    }

    private String convert(String number) {
        int length = number.length();
        if (Integer.parseInt(number) == 0) {
            return "";
        }
        String res;
        if (length == 1) {
            switch (number) {
                case "1":
                    res = ONE_WORD;
                    break;
                case "2":
                    res = TWO_WORD;
                    break;
                case "3":
                    res = THREE_WORD;
                    break;
                case "4":
                    res = FOUR_WORD;
                    break;
                case "5":
                    res = FIVE_WORD;
                    break;
                case "6":
                    res = SIX_WORD;
                    break;
                case "7":
                    res = SEVEN_WORD;
                    break;
                case "8":
                    res = EIGHT_WORD;
                    break;
                case "9":
                    res = NINE_WORD;
                    break;
                default:
                    res = "";
                    break;
            }
        } else if (length == 2) {
            if (number.charAt(0) == '1') {
                switch (number) {
                    case "10":
                        res = TEN_WORD;
                        break;
                    case "11":
                        res = ELEVEN_WORD;
                        break;
                    case "12":
                        res = TWELVE_WORD;
                        break;
                    case "13":
                        res = THIRTEEN_WORD;
                        break;
                    case "14":
                        res = FOURTEEN_WORD;
                        break;
                    case "15":
                        res = FIFTEEN_WORD;
                        break;
                    case "16":
                        res = SIXTEEN_WORD;
                        break;
                    case "17":
                        res = SEVENTEEN_WORD;
                        break;
                    case "18":
                        res = EIGHTEEN_WORD;
                        break;
                    case "19":
                        res = NINETEEN_WORD;
                        break;
                    default:
                        res = "";
                        break;
                }
            } else {
                switch (number.charAt(0)) {
                    case '2':
                        res = TWENTY_WORD;
                        break;
                    case '3':
                        res = THIRTY_WORD;
                        break;
                    case '4':
                        res = FORTY_WORD;
                        break;
                    case '5':
                        res = FIFTY_WORD;
                        break;
                    case '6':
                        res = SIXTY_WORD;
                        break;
                    case '7':
                        res = SEVENTY_WORD;
                        break;
                    case '8':
                        res = EIGHTY_WORD;
                        break;
                    case '9':
                        res = NINETY_WORD;
                        break;
                    default:
                        res = "";
                        break;
                }
                if (number.charAt(1) != '0') {
                    res += " " + convert(String.valueOf(number.charAt(1)));
                }
            }
        } else if (length == 3) {
            if (number.charAt(0) != '0') {
                res = convert(number.charAt(0) + " ") + HUNDRED_WORD;
            } else {
                res = "";
            }
            if (number.charAt(1) != '0') {
                res += " " + convert(number.substring(1));
            } else if (number.charAt(2) != '0') {
                res += " " + convert(String.valueOf(number.charAt(2)));
            }
        } else {
            res = "";
        }

        return res;
    }
}
