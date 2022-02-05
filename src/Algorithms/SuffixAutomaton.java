package Algorithms;


import java.util.HashMap;

//struct state {
//        int len, link;
//        map<char, int> next;
//        };
class State{
    int length , link ;
    HashMap<Character,Integer> next;
}

public class SuffixAutomaton {
    //const int MAXLEN = 100000;
    //state st[MAXLEN * 2];
    //int sz, last;

    int MAXLEN = 1_00_000;
    State stateArray [] = new State[MAXLEN*2];
    int size , last ;

//void sa_init() {
//st[0].len = 0;
//st[0].link = -1;
//sz++;
//last = 0;
//}
    public void initialise(){
        stateArray[0].length = 0;
        stateArray[0].link = -1;
        size++;
        last = 0;
    }
    //void sa_extend(char c)
    public void addCharecter(Character character){
        //int cur = sz++;
        //st[cur].len = st[last].len + 1;
        //int p = last;
        //while (p != -1 && !st[p].next.count(c)) {
        //st[p].next[c] = rcu;
        //p = st[p].link;
        //}
        int current = size++;
        stateArray[current].length = stateArray[last].length+1;
        int position  = last;
        while (position!=-1 && !stateArray[position].next.containsKey(character)){
            stateArray[position].next.put(character,current);
            position = stateArray[position].link;
        }
        //if (p == -1) {
        //st[cur].link = 0;
        //}
        if(position==-1){
            stateArray[current].link=0;
        }
        //else {
        //int q = st[p].next[c];
        //if (st[p].len + 1 == st[q].len) {
        //st[cur].link = q;
        //}
        else {
            int clone = size++;

        }
        //else {
        //int clone = sz++;
        //st[clone].len = st[p].len + 1;
        //st[clone].next = st[q].next;
        //st[clone].link = st[q].link;
        //while (p != -1 && st[p].next[c] == q) {
        //st[p].next[c] = clone;
        //p = st[p].link;
        //}
        //st[q].link = st[cur].link = clone;
        //}
        //}
        //last = cur;

    }




}
