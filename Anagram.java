//Leetcode Valid Anagram
class Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> countMap=new HashMap<Character,Integer>();
        //Fill up this countMap with character occurences from String s
        for(char c:s.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c,countMap.get(c)+1);
            }
            else
                countMap.put(c,1);
        }
        //Check every character in string t
        for(char u:t.toCharArray()){
            if(!countMap.containsKey(u))
                return false;
            else{
               Integer curr= countMap.get(u);
               curr--;
               if(curr==0)
                   countMap.remove(u);
                else
                    countMap.put(u,curr);
            }
        }
        if(countMap.size()==0)
            return true;
        else return false;
        
    }
}
