// import java.util.Comparable;

class Person implements Comparable<Person> {
    int rank;
    String name;
    boolean hotdog;
    double percentageOfHotdog;

   public Person (int r,String n,double pofH){
       
       this.rank = r;
       this.name = n;
       this.hotdog=pofH>0;
       this.percentageOfHotdog = pofH;
       
   }

   public String getName() {
     return this.name;
   }

    // public static void

    //compareTo --> Comparable
    //returns -1 if less than D
    //return 1 if more than D
    //returns 0 is equal to D
    @Override
    public int compareTo(Person D) {
        //use this.rank
        if(this.rank<D.rank){return -1;}
        else if(this.rank > D.rank){return 1;}
        else{return 0;}
    }

    @Override
    public String toString() {
        String tostr = "";

        //Both of these work, but use whichever makes sense for you....
        // tostr.valueOf(1);

        tostr += "Person Name: "+this.name+"\n";
        tostr += "Person Rank: " + String.valueOf(this.rank) + "\n";
        if (this.hotdog) {
          tostr = tostr + "Percentage of Hotdog blood: " + String.valueOf(this.percentageOfHotdog) + "%\n";
        }

        return tostr;
    }

        // if (this.rank < D.rank) {
        //     return -1;
        // } else if (this.rank > D.rank) {
        //     return 1;
        // } else {
        //     return 0;
        // }

        // if (this.rank < D.rank)
        // if (this.rank > D.rank)
        // return 0;

    
    
}