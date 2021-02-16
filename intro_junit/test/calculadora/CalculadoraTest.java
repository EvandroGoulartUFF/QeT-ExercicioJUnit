package calculadora;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

	private Calculadora calc;

	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, subtracao);		
	}
	
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(4, 5);		
		Assertions.assertEquals(20, multiplicacao);		
	}

	@DisplayName("Testa a somatória de 0 a n")
	@Test
	public void testSomatoriaZeroN() {
		int somatoria = calc.somatoria(4);
		Assertions.assertEquals(10, somatoria);		
	}
	
	@DisplayName("Testa se um inteiro n é positivo")
	@Test
	public void testInteiroNPositivo() {		
		Assertions.assertTrue(calc.ehPositivo(4));		
	}
	
	@DisplayName("Testa dois inteiros a e b e retorna: 0 se a == b, 1 se a > b e -1 se a < b")
	@Test
	public void testComparaDoisInteiros() {
		int a_igual_b = calc.compara(1, 1);
		int a_maior_b = calc.compara(1, 0);
		int a_menor_b = calc.compara(0, 1);
		Assertions.assertAll(() -> Assertions.assertEquals(0, a_igual_b), 
				             () -> Assertions.assertEquals(1, a_maior_b),
				             () -> Assertions.assertEquals(-1, a_menor_b));		
	}
	
	@DisplayName("Testa divisão de dois inteiros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa Exception na divisão de dois inteiros com divisor zero")
	@Test
	public void testExceptionDivisaoPorZero() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
