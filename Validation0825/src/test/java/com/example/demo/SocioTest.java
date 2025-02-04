package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SocioTest {

	@Test
	void test() {
		Socio socio=new Socio(11, "caso", 1);
		Socio socio2=new Socio(0, "caso", 1);
		Socio socio3=new Socio(0, "casososos", -11);
		
	}

}
