// First solution
class ParkingSystem {
    private int slotForBig;
    private int slotForMedium;
    private int slotForSmall;

    public ParkingSystem(int big, int medium, int small) {
        slotForBig = big;
        slotForMedium = medium;
        slotForSmall = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && slotForBig > 0) {
            slotForBig--;
            return true;
        }

        if (carType == 2 && slotForMedium > 0) {
            slotForMedium--;
            return true;
        }

        if (carType == 3 && slotForSmall > 0) {
            slotForSmall--;
            return true;
        }
        
        return false;
    }
}

// Second solution
class ParkingSystem {
    private int[] slot;

    public ParkingSystem(int big, int medium, int small) {
        slot = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (slot[carType - 1] > 0) {
            slot[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */