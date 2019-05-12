package cards

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Test {

	@Test
	void testhighCard() {
		int[] a = {1,6,4,3,2,1};
		assertArrayEquals(a,Poker.rank("8C","6D","5S","4H","3D"));
	}
	@Test
	void testOnePair(){
		int[] b = {2,7,5,4,3,0};
		assertArrayEquals(b,Poker.rank("9C","9D","5S","6H","7D"));
	}
	@Test
	void testTwoPair(){
		int[] c = {3,8,4,1,0,0};
		assertArrayEquals(c,Poker.rank("TC","6D","TS","6H","3D"));		
	}
	@Test
	void testThreeOfAKind(){
		int[] d = {4,11,0,0,0,0};
		assertArrayEquals(d,Poker.rank("KC","KD","KS","3H","4D"));
	}
	@Test
	void testStraight(){
		int[] e = {5,12,0,0,0,0};
		assertArrayEquals(e,Poker.rank("AD","KS","JS","QS","TS"));		
	}
	@Test
	void testFlush(){
		int[] f = {6,5,4,3,1,0};
		assertArrayEquals(f,Poker.rank("7D","6D","5D","3D","2D"));		
	}
	@Test
	void testFullHouse(){
		int[] g = {7,1,0,0,0,0};
		assertArrayEquals(g,Poker.rank("3C","3D","3S","7D","7S"));		
	}
	@Test
	void testFourOfAKind(){
		int[] h = {8,1,0,0,0,0};
		assertArrayEquals(h,Poker.rank("3C","3D","3S","3H","4D"));		
	}
	@Test
	void testStraightFlush(){
		int[] i = {9,10,0,0,0,0};
		assertArrayEquals(i,Poker.rank("JD","TD","8D","9D","QD"));		
	}

}
