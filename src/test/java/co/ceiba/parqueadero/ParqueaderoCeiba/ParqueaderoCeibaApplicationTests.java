package co.ceiba.parqueadero.ParqueaderoCeiba;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.parqueadero.modelo.Unitarias;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParqueaderoCeibaApplicationTests {
	
	
	@Test
	public void calculartest()  {
		Unitarias uni = new Unitarias(3.00, 1.00);
		double esperado= uni.Carcular();		
		assertEquals(4,esperado,0f);		
	}

}
