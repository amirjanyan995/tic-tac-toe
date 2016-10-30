import java.util.Random;

public class GameAlgorithm {
	private static Random r = new Random();

	public static int hardzakum(String mas[], String stat, String backStat) {
		//tox
		for (int i = 0; i < mas.length; i += 3) {
			if ((mas[i].equals(backStat)) && (mas[i + 1].equals(backStat)) && (!mas[i + 2].equals(stat)))
				return i + 2;
			else if ((mas[i].equals(backStat)) && (!mas[i + 1].equals(stat)) && (mas[i + 2].equals(backStat)))
				return i + 1;
			else if ((!mas[i].equals(stat)) && (mas[i + 1].equals(backStat)) && (mas[i + 2].equals(backStat)))
				return i;
		}
		//syun
		for (int i = 0; i < mas.length / 3; i++) {
			if ((mas[i].equals(backStat)) && (mas[i + 3].equals(backStat)) && (!mas[i + 6].equals(stat)))
				return i + 6;
			else if ((mas[i].equals(backStat)) && (!mas[i + 3].equals(stat)) && (mas[i + 6].equals(backStat)))
				return i + 3;
			else if ((!mas[i].equals(stat)) && (mas[i + 3].equals(backStat)) && (mas[i + 6].equals(backStat)))
				return i;
		}
		//dzax ankyunagic
		if ((mas[0].equals(backStat)) && (mas[4].equals(backStat)) && (!mas[8].equals(stat)))
			return 8;
		else if ((mas[0].equals(backStat)) && (!mas[4].equals(stat)) && (mas[8].equals(backStat)))
			return 4;
		else if ((!mas[0].equals(stat)) && (mas[4].equals(backStat)) && (mas[8].equals(backStat)))
			return 0;
		//Aj ankyunagic
		if ((mas[2].equals(backStat)) && (mas[4].equals(backStat)) && (!mas[6].equals(stat)))
			return 6;
		else if ((mas[2].equals(backStat)) && (!mas[4].equals(stat)) && (mas[6].equals(backStat)))
			return 4;
		else if ((!mas[2].equals(stat)) && (mas[4].equals(backStat)) && (mas[6].equals(backStat)))
			return 2;

		return -1;
	}

	public static int pashapan(String mas[], String stat, String backStat) {
		// tox
		for (int i = 0; i < mas.length; i += 3) {
			if ((mas[i].equals(stat)) && (mas[i + 1].equals(stat)) && (!mas[i + 2].equals(backStat)))
				return i + 2;
			else if ((mas[i].equals(stat)) && (!mas[i + 1].equals(backStat)) && (mas[i + 2].equals(stat)))
				return i + 1;
			else if ((!mas[i].equals(backStat)) && (mas[i + 1].equals(stat)) && (mas[i + 2].equals(stat)))
				return i;
		}
		// syun
		for (int i = 0; i < mas.length / 3; i++) {
			if ((mas[i].equals(stat)) && (mas[i + 3].equals(stat)) && (!mas[i + 6].equals(backStat)))
				return i + 6;
			else if ((mas[i].equals(stat)) && (!mas[i + 3].equals(backStat)) && (mas[i + 6].equals(stat)))
				return i + 3;
			else if ((!mas[i].equals(backStat)) && (mas[i + 3].equals(stat)) && (mas[i + 6].equals(stat)))
				return i;
		}
		// dzax ankyunagic
		if ((mas[0].equals(stat)) && (mas[4].equals(stat)) && (!mas[8].equals(backStat)))
			return 8;
		else if ((mas[0].equals(stat)) && (!mas[4].equals(backStat)) && (mas[8].equals(stat)))
			return 4;
		else if ((!mas[0].equals(backStat)) && (mas[4].equals(stat)) && (mas[8].equals(stat)))
			return 0;
		// aj ankyunagic
		if ((mas[2].equals(stat)) && (mas[4].equals(stat)) && (!mas[6].equals(backStat)))
			return 6;
		else if ((mas[2].equals(stat)) && (!mas[4].equals(backStat)) && (mas[6].equals(stat)))
			return 4;
		else if ((!mas[2].equals(backStat)) && (mas[4].equals(stat)) && (mas[6].equals(stat)))
			return 2;

		// kentron
		if (!mas[4].equals(stat) && !mas[4].equals(backStat))
			return 4;
		/*
		 * if (r.nextInt(10) <= 5) { if (!mas[4].equals(stat) &&
		 * !mas[4].equals(backStat)) { mas[4] = backStat; return 4; } }
		 */
		// patahakan texadrum
		int index = r.nextInt(9);
		while (true) {
			if (!mas[index].equals(stat) && !mas[index].equals(backStat))
				return index;
			else
				index = r.nextInt(9);
		}
	}
}
