package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;

class TestToy {

	@Test
	void testAnimalSize() {

		 //a is the actual value object and M is the actual value
		 Animal a = new Animal("3627382729","Cow","Game Pixel",19.52,3,7,"Plastic",'M');

		 assertEquals('M',a.getSize());
	}

	@Test
	void testAnimalMaterial() {

		 //a is the actual value object and plastic is the actual value
		 Animal a = new Animal("3627382729","Cow","Game Pixel",19.52,3,7,"Plastic",'M');

		 assertEquals("Plastic",a.getMaterial());
	}

	@Test
	void testBoardGameDesigner() {

		//expected value for designer is Roy Watson
		BoardGame a = new BoardGame("672836456","Mikado","Game Pixel",6.43,6,9,"1-4","Roy Watson");


		assertEquals("Roy Watson",a.getDesigner());
	}

	@Test
	void testFigureSize() {

		//expected value is S
		Figure a = new Figure ("4723782189","Ninja Turtles","Gamezoid",46.32,6,14,'S');

		assertEquals('S',a.getClassification());
	}

	@Test
	void testPuzzleType() {

		//expected value is H
		Puzzle a = new Puzzle("3627456238","Toy Soldier","Gamen",14.06,2,5,'H');

		assertEquals('H',a.getPuzzleType());
	}
}
