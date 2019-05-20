package cards;
import java.util.Scanner;
public class Poker {
	public static int[] rank(String str1,String str2,String str3,String str4,String str5) {
		char[] card1 = str1.toCharArray();
		char[] card2 = str2.toCharArray();
		char[] card3 = str3.toCharArray();
		char[] card4 = str4.toCharArray();
		char[] card5 = str5.toCharArray();
		char[] number = {card1[0],card2[0],card3[0],card4[0],card5[0]};
		char[] suit = {card1[1],card2[1],card3[1],card4[1],card5[1]};
		int[] numcount = new int[13];
		int[] suitcount = new int[4];
		int[] result = new int[6];
		for(int i = 0;i < 5;i++) {
			switch(suit[i]) {
			case 'D':
				suitcount[0]++;
				break;
			case 'S':
				suitcount[1]++;
				break;
			case 'H':
				suitcount[2]++;
				break;
			case 'C':
				suitcount[3]++;
				break;
			}
			if(Character.isDigit(number[i])) {
				numcount[number[i]-50]++;
				continue;
			}
			switch(number[i]) {
			case 'T':
				numcount[8]++;
				break;
			case 'J':
				numcount[9]++;
				break;
			case 'Q':
				numcount[10]++;
				break;
			case 'K':
				numcount[11]++;
				break;
			case 'A':
				numcount[12]++;
				break;
			}			
		}
		switch(numcount[Max(numcount)]) {
			case 4:
				result[0] = 8;
				result[1] = Max(numcount);
				return result;
			case 3:
				result[1] = Max(numcount);
				for(int i = 0;i < 13;i++)
					if(numcount[i] == 2) {
						result[0] = 7;
						return result;
					}
				result[0] = 4;
				return result;
			case 2:
				for(int i = 12;i > Max(numcount);i--)
					if(numcount[i] == 2) {
						result[0] = 3;
						result[1] = i;
						result[2] = Max(numcount);
						for(int j = 12;j >= 0;j--)
							if(numcount[j] == 1) {
								result[3] = j;
								return result;
							}
					}
					result[0] = 2;
					result[1] = Max(numcount);
					int temp = 2;
					for(int j = 12;j >= 0;j--)
						if(numcount[j] == 1) {
							result[temp] = j;
							temp++;
						}
					return result;
			case 1:
				for(int i = Max(numcount);i < Max(numcount)+5;i++)
					if(numcount[i] == 0) {
						int tem = 1;
						for(i = 12;i >= Max(numcount);i--)
							if(numcount[i] == 1) {
								result[tem] = i;
								tem++;
							}
						if(suitcount[Max(suitcount)] == 5) {
							result[0] = 6;
							return result;
						}
						result[0] = 1;
						return result;
					}
				result[1] = Max(numcount)+4;
				if(suitcount[Max(suitcount)] == 5) {
					result[0] = 9;
					return result;
				}
				result[0] = 5;
				return result;
				
					
		}
		return result;
		
	}
	public static int Max(int[] array) {
		if(array.length < 1)return 0;
		if(array.length == 1)return array[0];
		int temp = array[0];
		int location = 0;
		for(int i = 1;i < array.length;i++)if(array[i] > temp) {
			temp = array[i];
			location = i;
		}
		return location;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Black:");
			String blk1 = scan.next();
			String blk2 = scan.next();
			String blk3 = scan.next();
			String blk4 = scan.next();
			String blk5 = scan.next();
			int[] blk = rank(blk1,blk2,blk3,blk4,blk5);
		System.out.print("White:");
			String wht1 = scan.next();
			String wht2 = scan.next();
			String wht3 = scan.next();
			String wht4 = scan.next();
			String wht5 = scan.next();
			int[] wht = rank(wht1,wht2,wht3,wht4,wht5);
		scan.close();
		for(int i = 0;i < 6;i++) {
			if(blk[i] > wht[i]) {
				System.out.print("Black wins - ");
				break;
			}
			if(wht[i] > blk[i]) {
				System.out.print("White wins - ");
				break;
			}
			if(i == 5) {
				System.out.print("Tie");
				System.exit(0);
			}
	}
		switch(blk[0] >= wht[0] ? blk[0]:wht[0]) {
		case 1:
			System.out.print("high card:");
			int more = blk[1] >= wht[1] ? blk[1]:wht[1];
			if(more < 9)System.out.print(more+2);
			switch(more) {
			case 9:
				System.out.print("Jack");
				break;
			case 10:
				System.out.print("Queen");
				break;
			case 11:
				System.out.print("King");
				break;
			case 12:
				System.out.print("Ace");
				break;				
			}
			break;
		case 2:
			System.out.print("one pair");
			break;
		case 3:
			System.out.print("two pair");
			break;
		case 4:
			System.out.print("three of a kind");
			break;
		case 5:
			System.out.print("straight");
			break;
		case 6:
			System.out.print("flush");
			break;
		case 7:
			System.out.print("full house");
			break;
		case 8:
			System.out.print("four of a kind");
			break;
		case 9:
			System.out.print("straight flush");
			break;
		}
	}
}
