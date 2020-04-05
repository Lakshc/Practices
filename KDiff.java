//Leetcode 532
class KDiff {
    public static int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        int pairs=0;
        HashMap<Integer,Integer> comp=new HashMap<Integer,Integer>();
        for(int i:nums){
           
            if(comp.get(i)!=null){
                if(k==0&&comp.get(i)==1){
                pairs++;
                }
              comp.put(i,comp.get(i)+1);
                
            }
            else{
                if(comp.get(i-k)!=null){
                    pairs++;
                }
                if(comp.get(i+k)!=null){
                    pairs++;
                }
                comp.put(i,1);
                
            }
            
            
        }
        return pairs;
        
    }
        public static void main(String args[]){
        int[] test={6,3,5,7,2,3,3,8,2,4};
        System.out.println("Answer is:"+findPairs(test, 2));
    }
}
