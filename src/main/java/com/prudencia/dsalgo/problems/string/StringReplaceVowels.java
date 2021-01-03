package com.prudencia.dsalgo.problems.string;

public class StringReplaceVowels {

        public String removeVowels(String s) {
            StringBuffer result = new StringBuffer();
            for(int i=0; i< s.length();i++){
                if(!isVowel(s,i)){
                    result.append(s.charAt(i));
                }
            }

            return result.toString();
        }

        public boolean isVowel(String s,int index){

            if(s.charAt(index) =='a' || s.charAt(index) =='e' || s.charAt(index) =='i' || s.charAt(index) =='o' || s.charAt(index) =='u' ){
                return true;
            }
            return false;

        }

    public static void main(String[] args) {
        StringReplaceVowels  stringReplaceVowels = new StringReplaceVowels();
        System.out.println(stringReplaceVowels.removeVowels("leetcodeisacommunityforcoders"));
    }
}
