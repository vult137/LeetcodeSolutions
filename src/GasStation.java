// 134. Gas Station
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1;
        for (int i = 0; i < gas.length; i++) {
            if (checkPosition(gas, cost, i)) return i;
        }
        return -1;
    }

    public boolean checkPosition(int[] gas, int[] cost, int index) {
        int len = gas.length;
        int remain = gas[index] - cost[index];
        int i = index + 1;
        while (remain >= 0 && i != index) {
            if (i == len){
                i = 0;
                if (i == index) break;
            }
            remain += gas[i] - cost[i];
            i++;
        }
        return i == index;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }
}
