package com.kodilla;

import com.kodilla.spring.calculator.Calculator;
import com.kodilla.spring.forum.ForumUser;
import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaSpringApplicationTests {

	@Test
	void testCircleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Circle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a circle.", name);
	}

	@Test
	void testTriangleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Triangle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a triangle.", name);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testGetUsername() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		ForumUser forumUser = context.getBean(ForumUser.class);

		//When
		String name = forumUser.getUserName();

		//Then
		assertEquals("John Smith", name);
	}

	@Test
	void testCalculations(){
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Calculator calculator = context.getBean(Calculator.class);

		//When
		double a = 6.0;
		double b = 1.5;

		//Then
		assertEquals(7.5,calculator.add(a,b));
		assertEquals(4.5,calculator.sub(a,b));
		assertEquals(9.0,calculator.mul(a,b));
		assertEquals(4.0,calculator.div(a,b));
	}

}