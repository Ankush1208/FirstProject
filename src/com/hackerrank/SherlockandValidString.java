package com.hackerrank;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;


public class SherlockandValidString {
	
	static String isValid(String s) {
		
		int[] count=new int[128];
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)]++;
		System.out.println(Arrays.toString(count));

        Map<Long, Long> counts = s.chars()
       .mapToObj(t -> (char) t)
       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
       .entrySet().stream()
       .map(Map.Entry::getValue)
       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

   switch (counts.size()) {
       
       case 1:
           return "YES";

       case 2:
          java.util.Iterator<Long> it = counts.keySet().iterator();
           boolean diff = Math.abs(it.next() - it.next()) == 1;

           if( (diff && (counts.values().stream()
               .anyMatch(i -> i == 1))))
               {
                   return "YES";
               }
               return "NO";

        default:
           return "NO";
   }


   }


	public static void main(String[] args) {
  String res=isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd\n" + 
  		"");
  
  System.out.println(res);
		
	}

}
