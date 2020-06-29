public class Principal {

    public static void main(String[] args) {
        StatisticUtil su = new StatisticUtil();
        int[] elementos = {6, 5, 1, 3, 4, 2};
        
        System.out.println(StatisticUtil.average(elementos));
        System.out.println(StatisticUtil.mode(elementos));
        System.out.println(StatisticUtil.median(elementos));
    }

}
