package com.shoumo.geek.arrays;

public class PetrolPumpCircularVisit {

	public int findFirstPum(PetrolPump[] petrolPumData) {
		int start = 0, end = 1;

		int currentPetrol = petrolPumData[0].petrolAmount
				- petrolPumData[0].nextTravelDistance;

		while (end != start || currentPetrol < 0) {

			while (start != end && currentPetrol < 0) {
				currentPetrol -= petrolPumData[start].petrolAmount
						- petrolPumData[start].nextTravelDistance;

				start = (start + 1) % petrolPumData.length;

				if (start == 0)
					return -1;
			}

			currentPetrol += petrolPumData[end].petrolAmount
					- petrolPumData[end].nextTravelDistance;
			end = (end + 1) % petrolPumData.length;
		}
		return start;
	}

	public static class PetrolPump {
		int petrolAmount;
		int nextTravelDistance;

		public PetrolPump(int petrolAmount, int nextTravelDistance) {
			this.petrolAmount = petrolAmount;
			this.nextTravelDistance = nextTravelDistance;
		}
	}

	public static void main(String[] args) {
		PetrolPumpCircularVisit ppcv = new PetrolPumpCircularVisit();
		PetrolPump[] petrolPumpData = new PetrolPump[] { new PetrolPump(6, 4),
				new PetrolPump(3, 6), new PetrolPump(7, 3) };

		int retData = ppcv.findFirstPum(petrolPumpData);
		if (retData < 0) {
			System.out.println("No petrol pump found");
		} else {
			System.out.println("Petrol pump found at " + retData);
		}
	}
}
