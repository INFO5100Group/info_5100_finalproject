package Business.Wood;

import java.util.HashMap;

/**
 * key      木的种类
 * value    木的数量 （lb）
 */
public class WoodStorage extends HashMap<String, Double> {

    /**
     *
     */
    private static final long serialVersionUID = 10L;
    
    /**
     * add wood to storage. 
     * @param woodType 木头的种类
     * @param amount 木头的量，减少木头用负数
     * @return 是否成添加和减少木头， 不允许木头的数量为负数
     */
    public boolean addWood(String woodType, Double amount){
        if(this.containsKey(woodType)){
            if(this.get(woodType) + amount <= 0){
                return false;
            }else{
                this.put(woodType, this.get(woodType) + amount);
                return true;
            }
        }else{
            if(amount <= 0){
                return false;
            }else{
                this.put(woodType, amount);
                return true;
            }
        }
    }

    /**
     * convert lb to kg
     * @param lb
     * @return
     */
    public static Double LbtoKg(Double lb){
        return (double) Math.round(lb * 0.454 * 100) / 100;
    }
}