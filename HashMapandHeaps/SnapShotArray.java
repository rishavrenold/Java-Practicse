package HashMapandHeaps;

import java.util.HashMap;

public class SnapShotArray {

    HashMap<Integer,Integer> snapshotarr[];
    int snap_id=0;
    public SnapShotArray(int length) {
        snapshotarr=new HashMap[length];
        for(int i=0;i<length;i++)
        {
            snapshotarr[i]=new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        snapshotarr[index].put(snap_id,val);
    }
    
    public int snap() {
        snap_id++;
        return snap_id;
    }
    
    public int get(int index, int snap_id) {
        
        int val=0;
        if(snap_id==-1)
        {
            return 0;
        }
        while(index>=0 && snap_id>=0)
        {
            if(snapshotarr[index].containsKey(snap_id))
            {
                val=snapshotarr[index].get(snap_id);
                break;
            }else{
                snap_id--;
            }
        }
        return val;
    }
    public static void main(String[] args) {
        SnapShotArray ob= new SnapShotArray(5);
        ob.set(0,5);
        ob.set(2,3);
        ob.set(1,7);
        ob.snap();
         ob.set(1,44);
        ob.set(3,9);
        ob.snap();
        System.out.println(ob.get(3,1));
        System.out.println(ob.get(0,-1));

    }
}
